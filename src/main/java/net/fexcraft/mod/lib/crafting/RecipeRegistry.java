package net.fexcraft.mod.lib.crafting;

import java.util.List;

import net.fexcraft.mod.lib.crafting.gui.CraftingGui;
import net.fexcraft.mod.lib.crafting.gui.WorkbenchContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class RecipeRegistry {
	
	public static void addShapelessRecipe(ItemStack stack, Object... recipeComponents){
		ManagerCrafting.getInstance().addShapelessRecipe(stack, recipeComponents);
	}
	
	public static void addRecipe(ItemStack stack, Object... recipeComponents){
		addShapedRecipe(stack, recipeComponents);
	}
	
	public static void addShapedRecipe(ItemStack stack, Object... recipeComponents){
		ManagerCrafting.getInstance().addRecipe(stack, recipeComponents);
	}
	
	public static class GuiHandler implements IGuiHandler {
		@Override
		public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
			switch(ID){
				case 0: return new WorkbenchContainer(player.inventory, world, new BlockPos(x, y, z));
				default: return null;
			}
		}
		@Override
		public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
			switch(ID){
				case 0: return new CraftingGui(player.inventory, world, new BlockPos(x, y, z));
				default: return null;
			}
		}
	}
	
	public static void importVanillaRecipes(){
		List<IRecipe> list = ManagerCrafting.getInstance().getRecipeList();
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

	public static Object getWorkBench(){
		return workbench;
	}
	
	private static WorkBench workbench;

	public static void initialize(){
		workbench = new WorkBench();
	}
	
}