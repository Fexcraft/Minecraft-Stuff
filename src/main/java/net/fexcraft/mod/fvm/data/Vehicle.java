package net.fexcraft.mod.fvm.data;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.util.common.Print;
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
		if(obj.has("RegistryName")){
			this.registryname = obj.get("RegistryName").getAsString();
		}
		else{
			Print.log("VEHICLE DOES NOT HAVE A REGISTRY NAME, THAT IS AN ISSUE;");
			Print.log(obj);
			Static.halt();
		}
		if(obj.has("Addon")){
			addon = FvmResources.addons.get(obj.get("Addon").getAsString());
			if(addon == null){
				Print.log("ADDON PACK NOT FOUND FOR VEHICLE (" + registryname + "), OR INCORRECT NAME, THAT IS AN ISSUE;");
				Static.halt();
			}
		}
		else{
			Print.log("VEHICLE (" + registryname + ") DOES NOT HAVE A SET ADDON PACK, THAT IS AN ISSUE;");
			Static.halt();
		}
		this.fullname = JsonUtil.getIfExists(obj, "FullName", this.registryname);
		if(obj.has("Description")){
			JsonArray desc = obj.get("Description").getAsJsonArray();
			this.description = new String[desc.size()];
			for(int i = 0; i < desc.size(); i++){
				this.description[i] = desc.get(i).getAsString();
			}
		}
		if(obj.has("PrimaryColor")){
			this.def_primary = RGB.fromJSON(obj.get("PrimaryColor").getAsJsonObject(), false);
		}
		else{
			this.def_primary = new RGB();
		}
		if(obj.has("SecondaryColor")){
			this.def_secondary = RGB.fromJSON(obj.get("SecondaryColor").getAsJsonObject(), false);
		}
		else{
			this.def_secondary = new RGB();
		}
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