package net.fexcraft.mod.fvm.data;

import java.util.ArrayList;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.items.VehicleItem;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.render.ModelType;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.actors.threadpool.Arrays;

/**
 * Main class for unchangeable vehicle data.
 * @author Ferdinand (FEX___96)
 */
public class Vehicle {
	
	public String registryname;
	public String fullname;
	public Addon addon;
	public String[] description;
	public RGB def_primary, def_secondary;
	public Item item;
	public boolean allowsLocking;
	public VehicleEntityType etype;
	
	//Visual
	public String modelname;
	public ModelType modeltype = ModelType.NONE;
	@SideOnly(Side.CLIENT) //public VehicleModel model;//TODO
	private int scale;//TODO
	
	//Constructor
	public int construction_length;
	public float construction_wheel_offset;
	public float construction_height_offset;
	public String[] requires;
	
	//Parts
	
	
	//Textures
	
	
	//Inventory
	
	
	//FM
	public boolean usesFMM;//TODO
	
	
	//FVM
	public boolean usesFVM;//TODO
	
	
	//MTS
	public boolean usesMTS;//TODO
	
	
	public Vehicle(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj, "VEHICLE");
		this.addon = DataUtil.getAddon(registryname, obj, "VEHICLE");
		this.fullname = JsonUtil.getIfExists(obj, "FullName", this.registryname);
		this.description = DataUtil.getDescription(obj);
		this.def_primary = DataUtil.getRGB(obj, "PrimaryColor");
		this.def_secondary = DataUtil.getRGB(obj, "SecondaryColor");
		this.modelname = JsonUtil.getIfExists(obj, "ModelFile", "null");
		this.item = VehicleItem.register(this);
		this.allowsLocking = JsonUtil.getIfExists(obj, "AllowLocking", true);
		//
		if(obj.has("ConstructionSettings")){
			JsonObject cs = obj.get("ConstructionSettings").getAsJsonObject();
			this.construction_length = JsonUtil.getIfExists(cs, "Length", 3).intValue();
			this.construction_height_offset = JsonUtil.getIfExists(cs, "HeightOffset", 12.5).floatValue();
			this.construction_wheel_offset = JsonUtil.getIfExists(cs, "WheelOffset", 20).floatValue();
			if(cs.has("Requires")){
				JsonArray array = cs.get("Requires").getAsJsonArray();
				requires = new String[array.size()];
				for(int i = 0; i < requires.length; i++){
					requires[i] = array.get(i).getAsString();
				}
			}
		}
		//
		etype = VehicleEntityType.find(obj);
	}
	
	public void loadModel(){
		//TODO
	}
	
	/**
	 * Main class for custom vehicle data.
	 * @author Ferdinand (FEX___96)
	 */
	public static class VehicleData {
		
		public Vehicle vehicle;
		public UUID creator;
		public RGB primary, secondary;
		
		public VehicleData(Vehicle vehicle){
			this.vehicle = vehicle;
			this.creator = UUID.fromString(Static.NULL_UUID_STRING);
			this.primary = new RGB(vehicle.def_primary);
			this.secondary = new RGB(vehicle.def_secondary);
		}
		
		public NBTTagCompound write(NBTTagCompound compound){
			if(compound == null){
				compound = new NBTTagCompound();
			}
			return compound;
		}
		
		public void read(NBTTagCompound compound){
			
		}
		
		public static VehicleData fromNBT(NBTTagCompound compound){
			if(compound.hasKey("VehicleType")){
				VehicleData vdata = new VehicleData( FvmResources.vehicles.get(compound.getString("VehicleType")));
				vdata.read(compound);
			}
			return null;
		}
		
	}
	
	public static enum VehicleEntityType {
		
		FLANS(new String[]{"flans", "fm", "fm-", "fmm"}),
		FVM(new String[]{"fvm"}),
		MTS(new String[]{"mts"}),
		NULL(new String[]{"null", "none", "nah"});
		
		private ArrayList<String> arr;
		
		VehicleEntityType(String[] arr){
			this.arr = (ArrayList<String>)Arrays.asList(arr);
		}

		public static VehicleEntityType find(JsonObject obj){
			if(!obj.has("EntityType")){
				return NULL;
			}
			String str = obj.get("EntityType").getAsString();
			for(VehicleEntityType type : values()){
				if(type.arr.contains(str)){
					return type;
				}
			}
			return NULL;
		}
		
	}
	
}