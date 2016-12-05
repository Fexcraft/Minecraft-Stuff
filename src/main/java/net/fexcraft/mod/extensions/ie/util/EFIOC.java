package net.fexcraft.mod.extensions.ie.util;

import net.fexcraft.mod.extensions.ie.util.EFIO.EnumIO;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

public class EFIOC {
	
	private EFIO[] arr;
	private int a;
	
	public EFIOC(int a){
		this.a = a;
		reset(a);
	}
	
	public void reset(int a){
		this.a = a;
		arr = new EFIO[a];
		if(a == 4){
			arr[0] = new EFIO(EnumFacing.SOUTH, EnumIO.NULL, 0);
			arr[1] = new EFIO(EnumFacing.WEST,  EnumIO.NULL, 0);
			arr[2] = new EFIO(EnumFacing.NORTH, EnumIO.NULL, 0);
			arr[3] = new EFIO(EnumFacing.EAST,  EnumIO.NULL, 0);
		}
		else{
			arr[0] = new EFIO(EnumFacing.DOWN,  EnumIO.NULL, 0);
			arr[1] = new EFIO(EnumFacing.UP,    EnumIO.NULL, 0);
			arr[2] = new EFIO(EnumFacing.NORTH, EnumIO.NULL, 0);
			arr[3] = new EFIO(EnumFacing.SOUTH, EnumIO.NULL, 0);
			arr[4] = new EFIO(EnumFacing.WEST,  EnumIO.NULL, 0);
			arr[5] = new EFIO(EnumFacing.EAST,  EnumIO.NULL, 0);
		}
	}
	
	public NBTTagCompound writeToNBT(NBTTagCompound nbt){
		nbt.setInteger("frsm_fpu_efioc", arr.length);
		for(int i = 0; i < arr.length; i++){
			nbt.setString("frsm_fpu_efio_" + i + "_facing", arr[i].facing.getName());
			nbt.setInteger("frsm_fpu_efio_" + i + "_type", arr[i].io.getId());
			nbt.setInteger("frsm_fpu_efio_" + i + "_ct", arr[i].cthickness);
		}
		return nbt;
	}
	
	public void readFromNBT(NBTTagCompound nbt){
		reset(nbt.getInteger("frsm_fpu_efioc"));
		for(int i = 0; i < arr.length; i++){
			EnumFacing facing = EFIO.ef_fromString(nbt.getString("frsm_fpu_efio_" + i + "_facing"));
			EnumIO io = EnumIO.get(nbt.getInteger("frsm_fpu_efio_" + i + "_type"));
			arr[i] = new EFIO(facing, io, nbt.getInteger("frsm_fpu_efio_" + i + "_ct"));
		}
		return;
	}
	
	public EFIO[] get(){
		return arr;
	}
	
	public EFIO get(EnumFacing ef){
		for(EFIO e : arr){
			if(e.facing.equals(ef)){
				return e;
			}
		}
		return null;
	}
	
	public EFIO north(){
		if(a == 4){
			return arr[2];
		}
		else{
			return arr[2];
		}
	}
	
	public EFIO south(){
		if(a == 4){
			return arr[0];
		}
		else{
			return arr[3];
		}
	}
	
	public EFIO west(){
		if(a == 4){
			return arr[1];
		}
		else{
			return arr[4];
		}
	}
	
	public EFIO east(){
		if(a == 4){
			return arr[3];
		}
		else{
			return arr[5];
		}
	}
	
	public EFIO up(){
		if(a == 4){
			return null;
		}
		else{
			return arr[1];
		}
	}
	
	public EFIO down(){
		if(a == 4){
			return null;
		}
		else{
			return arr[0];
		}
	}

	public EFIOC copy(){
		EFIOC rs = new EFIOC(a);
		rs.arr = arr.clone();
		return rs;
	}
}