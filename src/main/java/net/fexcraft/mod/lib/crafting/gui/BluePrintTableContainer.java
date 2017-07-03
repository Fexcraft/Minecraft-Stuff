package net.fexcraft.mod.lib.crafting.gui;

import java.util.ArrayList;

import net.fexcraft.mod.lib.api.network.IPacketListener;
import net.fexcraft.mod.lib.crafting.BluePrintRecipe;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.fexcraft.mod.lib.network.packet.PacketJsonObject;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

public class BluePrintTableContainer extends Container {
	
	private EntityPlayer player;

	public BluePrintTableContainer(EntityPlayer player){
		this.player = player;
		//
		for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 9; ++j){
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 6 + j * 18, 125 + i * 18));
            }
        }
		//
		for(int k = 0; k < 9; ++k){
            this.addSlotToContainer(new Slot(player.inventory, k, 6 + k * 18, 185));
        }
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn){
		return playerIn != null;
	}
	
	public static class Receiver implements IPacketListener<PacketJsonObject> {

		@Override
		public String getId(){
			return "fcl-bpt";
		}

		@Override
		public void process(PacketJsonObject packet, Object[] objs){
			EntityPlayerMP player = (EntityPlayerMP)objs[0];
			String category = packet.obj.get("Category").getAsString();
			int id = packet.obj.get("RecipeId").getAsInt();
			int times = packet.obj.get("Times").getAsInt();
			for(int t = 0; t < times; t++){
				if(checkIfCraftable(player, category, id)){
					BluePrintRecipe recipe = RecipeRegistry.getRecipes(category).get(id);
					//
					for(ItemStack stack : recipe.components){
						for(int i = 0; i < player.inventory.mainInventory.size(); i++){
							ItemStack pstack = player.inventory.mainInventory.get(i);
							if(stack.getItem() == pstack.getItem() && stack.getMetadata() == pstack.getMetadata()){
								pstack.shrink(stack.getCount());
							}
						}
					}
					//
					BlockPos pos = BlockPos.fromLong(packet.obj.get("BlockPos").getAsLong());
					EntityItem item = new EntityItem(player.world);
					item.setItem(recipe.output.copy());
					item.setPosition(pos.getX() + 0.5, pos.getY() + 0.75, pos.getZ() + 0.5);
					player.world.spawnEntity(item);
					Print.chat(player, "&7Crafted &c" + recipe.output.getCount() + "&7pcs of &a" + recipe.output.getDisplayName() + "&7.");
				}
				else{
					Print.chat(player, "Error, Missing Recipe Components in Inventory to continue;");
				}
			}
		}
		
		private boolean checkIfCraftable(EntityPlayer player, String category, int id){
			BluePrintRecipe recipe = null;
			try{
				recipe = RecipeRegistry.getRecipes(category).get(id);
			}
			catch(Exception e){
				Print.chat(player, e.getMessage());
			}
			if(recipe != null){
				ArrayList<Integer> searched = new ArrayList<Integer>();
				for(ItemStack stack : recipe.components){
					boolean found = false;
					for(int i = 0; i < player.inventory.mainInventory.size(); i++){
						if(!searched.contains(i)){
							if(areItemStacksEqual(stack, player.inventory.mainInventory.get(i))){
								found = true;
								searched.add(i);
							}
						}
					}
					if(!found){
						return false;
					}
				}
				return true;
			}
			else return false;
		}

		private boolean areItemStacksEqual(ItemStack stack, ItemStack itemStack){
			return stack.getItem() != itemStack.getItem() ? false : stack.getCount() > itemStack.getCount() ? false : stack.getItemDamage() != itemStack.getItemDamage() ? false : true;
		}
		
	}

}
