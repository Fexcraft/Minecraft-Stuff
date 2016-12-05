package net.fexcraft.mod.lib.util.cls;

import net.minecraft.nbt.NBTTagCompound;

/** FRSM Universal Power Unit*/
public class FFU{
	
	private Number amount;
	private String id;
	private String name;
	private EnumNumberType type;
	
	public FFU(String name, String id, int am, EnumNumberType type){
		this.amount = am;
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	public void set(Number n){
		this.amount = n;
	}
	
	public Number get(){
		return this.amount;
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String s){
		this.id = s;
	}
	
	public NBTTagCompound writeToNBT(NBTTagCompound nbt){
		switch(this.type){
			case FLOAT:  nbt.setFloat  ("frsm_ffu_amount", this.amount.floatValue()); break;
			case DOUBLE: nbt.setDouble ("frsm_ffu_amount", this.amount.doubleValue());break;
			case INT:    nbt.setInteger("frsm_ffu_amount", this.amount.intValue());   break;
			case LONG:   nbt.setLong   ("frsm_ffu_amount", this.amount.longValue());  break;
			case SHORT:  nbt.setShort  ("frsm_ffu_amount", this.amount.shortValue()); break;
			case BYTE:   nbt.setByte   ("frsm_ffu_amount", this.amount.byteValue());  break;
			default:break;
		}
		nbt.setString("frsm_ffu_id", this.id);
		nbt.setString("frsm_ffu_name", this.name);
		nbt.setString("frsm_ffu_type", this.type.toString());
		return nbt;
	}
	
	public void readFromNBT(NBTTagCompound nbt){
		switch(this.type){
			case FLOAT:  this.amount = nbt.getFloat  ("frsm_ffu_amount");break;
			case DOUBLE: this.amount = nbt.getDouble ("frsm_ffu_amount");break;
			case INT:    this.amount = nbt.getInteger("frsm_ffu_amount");break;
			case LONG:   this.amount = nbt.getLong   ("frsm_ffu_amount");break;
			case SHORT:  this.amount = nbt.getShort  ("frsm_ffu_amount");break;
			case BYTE:   this.amount = nbt.getByte   ("frsm_ffu_amount");break;
			default: break;
		}
		this.id = nbt.getString("frsm_ffu_id");
		this.name = nbt.getString("frsm_ffu_name");
		this.type = this.type.fromString(nbt.getString("frsm_ffu_type"));
		return;
	}
}