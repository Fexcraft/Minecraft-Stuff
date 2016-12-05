package net.fexcraft.mod.frsm.entities;

import net.fexcraft.mod.lib.api.entity.IEntity;
import net.fexcraft.mod.lib.util.cls.Print;
import net.fexcraft.mod.lib.util.entity.EntUtil;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntitySittable extends Entity implements IEntity {

	public EntitySittable(World worldIn){
		super(worldIn);
	}

	@Override
	protected void entityInit(){
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
		//
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
		//
	}
	
	@Override
	public void onUpdate(){
		if(EntUtil.getPassengerOf(this) == null){
			this.setDead();
			Print.spam(1, "dead.");
		}
	}
	
}