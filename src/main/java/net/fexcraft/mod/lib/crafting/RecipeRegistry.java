package net.fexcraft.mod.lib.crafting;

import net.fexcraft.mod.lib.crafting.gui.CraftingGui;
import net.fexcraft.mod.lib.crafting.gui.WorkbenchContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
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
	
}