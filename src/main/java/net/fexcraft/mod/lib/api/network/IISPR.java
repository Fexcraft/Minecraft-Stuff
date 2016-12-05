package net.fexcraft.mod.lib.api.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public interface IISPR{
	
	public void processServerPacket(IPacket pkt, ItemStack stack);
	
	public void processClientPacket(IPacket pkt, ItemStack stack);

	public void requestNBT(EntityPlayer player);

	public NBTTagCompound getRequest();
	
}