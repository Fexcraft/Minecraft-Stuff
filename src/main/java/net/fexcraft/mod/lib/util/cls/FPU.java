package net.fexcraft.mod.lib.util.cls;

import net.minecraft.nbt.NBTTagCompound;

/** FRSM Universal Power Unit*/
public class FPU{
	
	/*private BlockPos origin_pos;
	private String origin;
	private int level;
	
	public FEP(BlockPos pos, String org, int lvl){
		origin_pos = pos;
		origin = org;
		level = lvl;
	}
	
	public BlockPos getPos(){
		return origin_pos;
	}
	
	public String getName(){
		return origin;
	}
	
	public int getLevel(){
		return level;
	}*/
	
	private int power;
	
	public FPU(int power){
		this.power = power;
	}
	
	public void set(int p){
		this.power = p;
	}
	
	public int get(){
		return this.power;
	}
	
	public void subtract(int i){
		power -= i;
	}
	
	public void add(int i){
		power += i;
	}
	
	public NBTTagCompound writeToNBT(NBTTagCompound nbt){
		nbt.setInteger("frsm_fpu_power", this.power);
		return nbt;
	}
	
	public void readFromNBT(NBTTagCompound nbt){
		this.power = nbt.getInteger("frsm_fpu_power");
		return;
	}
}