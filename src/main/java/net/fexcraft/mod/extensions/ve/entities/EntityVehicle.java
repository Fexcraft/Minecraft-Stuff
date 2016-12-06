package net.fexcraft.mod.extensions.ve.entities;

import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityVehicle extends Entity implements IPacketReceiver{

	public EntityVehicle(World worldIn) {
		super(worldIn);
	}

	@Override
	public void processServerPacket(IPacket pkt) {
		//
	}

	@Override
	public void processClientPacket(IPacket pkt) {
		//
	}

	@Override
	protected void entityInit() {
		
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		
	}
	
}