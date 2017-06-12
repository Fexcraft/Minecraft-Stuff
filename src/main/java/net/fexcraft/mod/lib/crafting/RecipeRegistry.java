package net.fexcraft.mod.lib.crafting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;

import net.fexcraft.mod.lib.crafting.gui.BluePrintTableContainer;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.PacketHandler.PacketHandlerType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;

public class RecipeRegistry {
	
	private static final TreeMap<String, ArrayList<BluePrintRecipe>> recipes = new TreeMap<String, ArrayList<BluePrintRecipe>>();
	
	public static final void addBluePrintRecipe(String category, ItemStack stack, ItemStack... recipeComponents){
		if(!recipes.containsKey(category)){
			recipes.put(category, new ArrayList<BluePrintRecipe>());
		}
		recipes.get(category).add(new BluePrintRecipe(category, stack, recipeComponents));
	}
	
	public static void addShapelessRecipe(String rs, String string, ItemStack output, Ingredient... ingredients){
		if(rs == null){
			return;
		}
		addShapelessRecipe(new ResourceLocation(rs), string, output, ingredients);
	}
	
	public static void addShapelessRecipe(ResourceLocation rs, String string, ItemStack output, Ingredient... ingredients){
		if(ingredients.length < 1 || rs == null){
			return;
		}
		NonNullList<Ingredient> list = NonNullList.<Ingredient>create();
		list.addAll(Arrays.asList(ingredients));
		CraftingManager.func_193372_a(rs, new ShapelessRecipes(string == null ? "" : string, output, list));
	}

	public static void addShapedRecipe(String rs, String string, ItemStack output, byte width, byte height, Ingredient... ingredients){
		if(rs == null){
			return;
		}
		addShapedRecipe(new ResourceLocation(rs), string, output, width, height, ingredients);
	}
	
	public static void addShapedRecipe(ResourceLocation rs, String string, ItemStack output, byte width, byte height, Ingredient... ingredients){
		if(ingredients.length < 1 || rs == null){
			return;
		}
		NonNullList<Ingredient> list = NonNullList.<Ingredient>create();
		list.addAll(Arrays.asList(ingredients));
		CraftingManager.func_193372_a(rs, new ShapedRecipes(string, width, height, list, output));
	}
	
	public static class GuiHandler implements IGuiHandler {
		@Override
		public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
			switch(ID){
				case 1:
					return new net.fexcraft.mod.lib.crafting.gui.BluePrintTableContainer(player);
				default: return null;
			}
		}
		@Override
		public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
			switch(ID){
				case 1:
					return new net.fexcraft.mod.lib.crafting.gui.BluePrintTable(player, world, new BlockPos(x, y, z));
				default: return null;
			}
		}
	}

	public static WorkBench getWorkBench(){
		return workbench;
	}
	
	public static BluePrintTable getBluePrintTable(){
		return blueprinttable;
	}
	
	private static WorkBench workbench;
	private static BluePrintTable blueprinttable;

	public static void initialize(){
		workbench = new WorkBench();
		blueprinttable = new BluePrintTable();
		PacketHandler.registerListener(PacketHandlerType.JSON, Side.SERVER, new BluePrintTableContainer.Receiver());
	}
	
	public static TreeMap<String, ArrayList<BluePrintRecipe>> getRecipes(){
		return recipes;
	}
	
	public static ArrayList<BluePrintRecipe> getRecipes(String category){
		return category == null ? null : recipes.get(category);
	}
	
	public static Set<String> getCategories(){
		return recipes.keySet();
	}
	
}