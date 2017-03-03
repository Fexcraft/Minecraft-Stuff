package net.fexcraft.mod.fvm.gui;

import net.fexcraft.mod.fvm.blocks.VehicleCrafterEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;

public class CreatorContainer extends Container {

	private VehicleCrafterEntity tile;

	public CreatorContainer(TileEntity tileentity, InventoryPlayer inventory){
		this.tile = (VehicleCrafterEntity)tileentity;

        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 9; ++j){
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 6 + j * 18, 125 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k){
            this.addSlotToContainer(new Slot(inventory, k, 6 + k * 18, 185));
        }
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn){
		return true;
	}
	
	@Override
	public void onContainerClosed(EntityPlayer playerIn){
        super.onContainerClosed(playerIn);
    }

}
