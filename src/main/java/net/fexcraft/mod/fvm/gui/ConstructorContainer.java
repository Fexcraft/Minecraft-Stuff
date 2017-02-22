package net.fexcraft.mod.fvm.gui;

import net.fexcraft.mod.fvm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvm.items.PartItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class ConstructorContainer extends Container {
	
	private final ConstructorControllerEntity tile;
	
	public ConstructorContainer(TileEntity tileentity, InventoryPlayer inventory){
		this.tile = (ConstructorControllerEntity)tileentity;
        this.addSlotToContainer(new SlotCurrentPart(tile));

        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 9; ++j){
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 174 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k){
            this.addSlotToContainer(new Slot(inventory, k, 8 + k * 18, 232));
        }
	}

	@Override
	public boolean canInteractWith(EntityPlayer player){
		return true;
	}
	
	public static class SlotCurrentPart extends Slot{

		public SlotCurrentPart(ConstructorControllerEntity tile){
			super(tile, 0, 9, 147);
		}
		
		@Override
		public boolean isItemValid(ItemStack stack){
	        return stack.getItem() instanceof PartItem;
	    }
		
	}
	
}