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
	private boolean shaped;
	private String[] lines;
	private String[] singredients;
	private String[] cingredients;
	private String[] ringredients;
	
	public static void parse(ItemStack stack, JsonObject obj) throws Exception {
		RecipeObject rcp = new RecipeObject();
		rcp.stack = stack;
		if(obj.get("Type").getAsString().equals("Shaped")){
			rcp.shaped = true;
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
				temp_list.add(rcp);
			}
			else{
				Print.debug("Recipe don't has a grid!\n" + obj.toString());
			}
		}
		else if(obj.get("Type").getAsString().equals("Shapeless")){
			rcp.shaped = false;
			JsonArray array = obj.get("Ingredients").getAsJsonArray();
			rcp.singredients = new String[array.size()];
			for(int i = 0; i < array.size(); i++){
				rcp.singredients[i] = array.get(i).getAsString();
			}
			temp_list.add(rcp);
		}
		else if(obj.get("Type").getAsString().equals("Blueprint")){
			//TODO
		}
		else{
			Print.debug("Invalid Recipe Type!\n" + obj.toString());
		}
	}
	
	public static void registerRecipes(){
		for(RecipeObject obj : temp_list){
			if(obj.shaped){
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
			}
			else{
				Object[] array = new Object[obj.singredients.length];
				for(int i = 0; i < array.length; i++){
					array[i] = Item.getByNameOrId(obj.singredients[i]);
				}
				GameRegistry.addShapelessRecipe(obj.stack, array);
			}
		}
		temp_list.clear();
		temp_list = null;
	}
	
}