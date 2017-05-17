package net.fexcraft.mod.fvm.data;

import java.util.UUID;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.render.ModelType;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Main class for unchangeable vehicle data.
 * @author Ferdinand (FEX___96)
 */
public class Vehicle {
	
	/** Registry Name which is used for internal FVM stuff. */
	public String registryname;
	/** Fancy Name to be displayed in GUIs, etc. */
	public String fullname;
	public Addon addon;
	/** Description, simply put. */
	public String[] description;
	/** Default Vehicle colours. */
	public RGB def_primary, def_secondary;
	/** Model Adress */
	public String modelname;
	public ModelType modeltype = ModelType.NONE;
	/** Base model of the Vehicle. */
	@SideOnly(Side.CLIENT) //public VehicleModel model;
	/** The Custom Item of this Vehicle. */
	public Item item;
	/** Locking */
	public boolean allowsLocking;
	
	public Vehicle(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj, "VEHICLE");
		this.addon = DataUtil.getAddon(registryname, obj, "VEHICLE");
		this.fullname = JsonUtil.getIfExists(obj, "FullName", this.registryname);
		this.description = DataUtil.getDescription(obj);
		this.def_primary = DataUtil.getRGB(obj, "PrimaryColor");
		this.def_secondary = DataUtil.getRGB(obj, "SecondaryColor");
		this.modelname = JsonUtil.getIfExists(obj, "ModelFile", "null");
		//this.item = VehicleItem.register(this); //TODO
		this.allowsLocking = JsonUtil.getIfExists(obj, "AllowLocking", true);
	}
	
	public void loadModel(){
		//TODO
	}
	
	/**
	 * Main class for custom vehicle data.
	 * @author Ferdinand (FEX___96)
	 */
	public static class VData {
		
		public Vehicle vehicle;
		public UUID creator;
		public RGB primary, secondary;
		
		public VData(Vehicle vehicle){
			this.vehicle = vehicle;
			this.creator = UUID.fromString(Static.NULL_UUID_STRING);
			this.primary = new RGB(vehicle.def_primary);
			this.secondary = new RGB(vehicle.def_secondary);
		}
		
		public NBTTagCompound write(NBTTagCompound compound){
			return compound;
		}
		
		public void read(NBTTagCompound compound){
			
		}
		
		public VData fromNBT(NBTTagCompound compound){
			Vehicle veh = FvmResources.vehicles.get(compound.getString("VehicleType"));
			if(veh == null){ return null; }
			VData vdata = new VData(veh);
			vdata.read(compound);
			return vdata;
		}
		
	}
	
}