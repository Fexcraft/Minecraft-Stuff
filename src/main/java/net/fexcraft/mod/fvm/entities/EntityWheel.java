package net.fexcraft.mod.fvm.entities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityWheel extends Entity {
	
	public final Entity parent;
	public final int id;
	
	
	public EntityWheel(World worldIn){
		super(worldIn);
		parent = null;
		id = 0;
	}
	
	public EntityWheel(World worldIn, Entity parent, int wid){
		super(worldIn);
		this.parent = parent;
		this.id = wid;
	}

	@Override
	protected void entityInit(){
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		// TODO Auto-generated method stub
	}
	
}