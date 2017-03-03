package net.fexcraft.mod.fvm.data;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeObject {
	
	public static ArrayList<RecipeObject> temp_list = new ArrayList<RecipeObject>();
	private ItemStack stack;
	private Type type;
	//
	private String[] lines;
	private String[] singredients;
	//
	private String[] cingredients;
	private String[] ringredients;
	//
	private String input;
	private int inputmeta = 0;
	private String container;
	private float exp = 0.0f;
	
	public static void parse(ItemStack stack, JsonObject obj) throws Exception {
		RecipeObject rcp = new RecipeObject();
		rcp.stack = stack;
		rcp.type = Type.fromString(obj.get("Type").getAsString());
		switch(rcp.type){
			case SHAPED:
				if(obj.has("Grid")){
					JsonArray grid = obj.get("Grid").getAsJsonArray();
					rcp.lines = new String[grid.size()];
					for(int i = 0; i < grid.size(); i++){
						rcp.lines[i] = grid.get(i).getAsString();
					}
					ArrayList<String> chars = new ArrayList<String>(); 
					for(String s : rcp.lines){
						String[] ca = s.split("");
						for(String c : ca){
							if(c.equals(" ")){
								continue;
							}
							if(!chars.contains(c)){
								chars.add(c);
							}
						}
					}
					rcp.cingredients = new String[chars.size()];
					rcp.ringredients = new String[chars.size()];
					for(int i = 0; i < chars.size(); i++){
						String c = chars.get(i);
						rcp.cingredients[i] = c;
						rcp.ringredients[i] = obj.get(c + "").getAsString();
					}
					if(obj.has("Output")){
						stack.setCount(obj.get("Output").getAsInt());
					}
					temp_list.add(rcp);
				}
				else{
					Print.debug("Recipe don't has a grid!\n" + obj.toString());
				}
				break;
			case SHAPELESS:
				JsonArray array = obj.get("Ingredients").getAsJsonArray();
				rcp.singredients = new String[array.size()];
				for(int i = 0; i < array.size(); i++){
					rcp.singredients[i] = array.get(i).getAsString();
				}
				if(obj.has("Output")){
					stack.setCount(obj.get("Output").getAsInt());
				}
				temp_list.add(rcp);
				break;
			case BLUEPRINT:
				break;
			case SMELTING:
				if(obj.has("Input")){
					rcp.input = obj.get("Input").getAsString();
					if(obj.has("InputMeta")){
						rcp.inputmeta = obj.get("InputMeta").getAsInt();
					}
					if(obj.has("Container")){
						rcp.container = obj.get("Container").getAsString();
					}
					if(obj.has("Output")){
						stack.setCount(obj.get("Output").getAsInt());
					}
				}
				else{
					Print.debug("Recipe don't has an input Item!\n" + obj.toString());
				}
				temp_list.add(rcp);
				break;
			case NULL:
			default:
				Print.debug("Invalid Recipe Type!\n" + obj.toString());
				break;
		}
	}
	
	public static void registerRecipes(){
		for(RecipeObject obj : temp_list){
			switch(obj.type){
				case SHAPED:
					Object[] array = new Object[obj.lines.length + obj.cingredients.length + obj.ringredients.length];
					for(int i = 0; i < obj.lines.length; i++){
						array[i] = obj.lines[i];
					}
					int k = 0, l = 0;
					for(int j = 0; j < obj.cingredients.length + obj.ringredients.length; j++){
						if(j % 2 == 0){
							array[j + obj.lines.length] = obj.cingredients[k].toCharArray()[0];
							k++;
						}
						else{
							array[j + obj.lines.length] = Item.getByNameOrId(obj.ringredients[l]);
							l++;
						}
					}
					GameRegistry.addShapedRecipe(obj.stack, array);
					break;
				case SHAPELESS:
					Object[] arrey = new Object[obj.singredients.length];
					for(int i = 0; i < arrey.length; i++){
						arrey[i] = Item.getByNameOrId(obj.singredients[i]);
					}
					GameRegistry.addShapelessRecipe(obj.stack, arrey);
					break;
				case BLUEPRINT:
					break;
				case SMELTING:
					ItemStack istack = null;
					if(obj.container == null){
						istack = new ItemStack(Item.getByNameOrId(obj.input), 1, obj.inputmeta);
					}
					else{
						istack = new ItemStack(Item.getByNameOrId(obj.input).setContainerItem(Item.getByNameOrId(obj.container)), 1, obj.inputmeta);
					}
					GameRegistry.addSmelting(istack, obj.stack, obj.exp);
					break;
				case NULL:
				default:
					break;
			}
		}
		temp_list.clear();
		temp_list = null;
	}
	
	private static enum Type {
		
		SHAPED("Shaped"), SHAPELESS("Shapeless"), BLUEPRINT("Blueprint"), SMELTING("Smelting"),
		NULL("null");
		
		public String id;
		
		Type(String s){
			id = s;
		}

		public static Type fromString(String string){
			for(Type type : values()){
				if(type.id.equals(string)){
					return type;
				}
			}
			return NULL;
		}
		
		@Override
		public String toString(){
			return id;
		}
	}
	
}