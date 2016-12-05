package net.fexcraft.mod.ftm.entities;

import net.fexcraft.mod.lib.api.entity.IEntity;
import net.minecraft.util.math.Vec3d;

public interface ITrainEntity extends IEntity {

	public abstract boolean hasEngine();
	
	public abstract float getEnginePower();
	
	public abstract ITrainEntity getCoupledEntityFront();
	
	public abstract ITrainEntity getCoupledEntityRear();
	
	public abstract float getFrontCouplingOffset();
	
	public abstract float getRearCouplingOffset();
	
	public abstract float getWeight();
	
	public abstract void setWeight(float w);
	
	public void updatePositionCall(Vec3d pos);
	
}