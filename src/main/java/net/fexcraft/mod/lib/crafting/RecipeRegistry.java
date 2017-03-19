package net.fexcraft.mod.lib.crafting;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import net.fexcraft.mod.lib.crafting.gui.BluePrintTableContainer;
import net.fexcraft.mod.lib.crafting.gui.CraftingGui;
import net.fexcraft.mod.lib.crafting.gui.WorkbenchContainer;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.PacketHandler.PacketHandlerType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
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
	
	public static void addShapelessRecipe(ItemStack stack, Object... recipeComponents){
		ManagerCrafting.addShapelessRecipe(stack, recipeComponents);
	}
	
	public static void addRecipe(ItemStack stack, Object... recipeComponents){
		addShapedRecipe(stack, recipeComponents);
	}
	
	public static void addShapedRecipe(ItemStack stack, Object... recipeComponents){
		ManagerCrafting.addRecipe(stack, recipeComponents);
	}
	
	public static class GuiHandler implements IGuiHandler {
		@Override
		public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
			switch(ID){
				case 0:
					return new WorkbenchContainer(player.inventory, world, new BlockPos(x, y, z));
				case 1:
					return new net.fexcraft.mod.lib.crafting.gui.BluePrintTableContainer(player);
				default: return null;
			}
		}
		@Override
		public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
			switch(ID){
				case 0:
					return new CraftingGui(player.inventory, world, new BlockPos(x, y, z));
				case 1:
					return new net.fexcraft.mod.lib.crafting.gui.BluePrintTable(player, world, new BlockPos(x, y, z));
				default: return null;
			}
		}
	}
	
	public static void importVanillaRecipes(){
		List<IRecipe> list = ManagerCrafting.getRecipeList();
		List<net.minecraft.item.crafting.IRecipe> rcls = CraftingManager.getInstance().getRecipeList();
		for(net.minecraft.item.crafting.IRecipe recipe : rcls){
			if(recipe instanceof net.minecraft.item.crafting.ShapedRecipes){
				net.minecraft.item.crafting.ShapedRecipes rec = (net.minecraft.item.crafting.ShapedRecipes)recipe;
				list.add(new ShapedRecipes(rec.recipeWidth, rec.recipeHeight, rec.recipeItems, rec.getRecipeOutput()));
			}
			else if(recipe instanceof net.minecraft.item.crafting.ShapelessRecipes){
				net.minecraft.item.crafting.ShapelessRecipes rec = (net.minecraft.item.crafting.ShapelessRecipes)recipe;
				list.add(new ShapelessRecipes(rec.getRecipeOutput(), rec.recipeItems));
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