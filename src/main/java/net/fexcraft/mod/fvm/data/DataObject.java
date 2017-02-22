package net.fexcraft.mod.fvm.data;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.nbt.NBTTagCompound;

/**
 * @author Ferdinand (FEX___96)
 *
 */
public abstract class DataObject implements Comparable {
	
	protected static final JsonUtil ju = JsonUtil.getInstance();
	protected LoadedIn state;
	
	public DataObject(){
		this.state = LoadedIn.MEMORY;
	}
	
	public DataObject(LoadedIn state){
		this.state = state;
	}
	
	public void setState(LoadedIn state){
		this.state = state;
	}
	
	public final LoadedIn state(){
		return state;
	}
	
	public final LoadedIn getState(){
		return state();
	}
	
	public abstract void load(JsonObject obj);
	
	public abstract JsonObject save(JsonObject obj);
	
	public abstract void read(NBTTagCompound compound);
	
	public abstract NBTTagCompound write(NBTTagCompound compound);
	
	public abstract DataObject newInstance(LoadedIn state);
	
}