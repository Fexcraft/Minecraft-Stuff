package net.fexcraft.mod.ftm.entities;

import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class TrainEntityBase extends Entity implements ITrainEntity {
	
	public ITrainEntity front_couple, rear_couple;
	
	public TrainEntityBase(World world) {
		super(world);
	}
	
	public boolean isFrontCoupled(){
		return getCoupledEntityFront() != null;
	}
	
	public boolean isRearCoupled(){
		return getCoupledEntityRear() != null;
	}

	@Override
	public ITrainEntity getCoupledEntityFront(){
		return front_couple;
	}

	@Override
	public ITrainEntity getCoupledEntityRear(){
		return rear_couple;
	}
	
	public Vec3d getRearOffsetBasedOnFacing(EnumFacing facing, float f){
		switch(facing){
			case EAST:
				return new Vec3d(posX - f, posY, posZ);
			case NORTH:
				return new Vec3d(posX, posY, posZ + f);
			case SOUTH:
				return new Vec3d(posX, posY, posZ - f);
			case WEST:
				return new Vec3d(posX + f, posY, posZ);
			default:
				break;
		}
		return new Vec3d(posX, posY, posZ);
	}
	
	public Vec3d getFrontOffsetBasedOnFacing(EnumFacing facing, float f){
		switch(facing){
			case EAST:
				return new Vec3d(posX + f, posY, posZ);
			case NORTH:
				return new Vec3d(posX, posY, posZ - f);
			case SOUTH:
				return new Vec3d(posX, posY, posZ + f);
			case WEST:
				return new Vec3d(posX - f, posY, posZ);
			default:
				break;
		}
		return new Vec3d(posX, posY, posZ);
	}
	
}
