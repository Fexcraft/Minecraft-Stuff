package net.fexcraft.mod.fvm.data;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.data.Part.PartData;
import net.fexcraft.mod.fvm.items.VehicleItem;
import net.fexcraft.mod.fvm.model.VehicleModel;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.render.ModelType;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
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
	@SideOnly(Side.CLIENT)
	public VehicleModel model;
	/*@SideOnly(Side.CLIENT)
	private float scale;*/
	public ArrayList<ResourceLocation> textures;
	
	//Constructor
	public int construction_length;
	public float construction_wheel_offset;
	public float construction_height_offset;
	public String[] requires;
	
	//Parts
	
	
	//Inventory
	
	
	//FM
	
	
	//FVM
	
	
	//MTS
	
	
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
		this.textures = DataUtil.getTextures(obj, this.registryname, "VEHICLE");
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
		/*switch(etype){
			case FLANS:
				JsonObject ms = JsonUtil.getIfExists(obj, "MinusSettings", new JsonObject()).getAsJsonObject();
				break;
			case FVM:
				break;
			case MTS:
				break;
			case NULL:
				break;
			default:
				break;
		}*/
	}
	
	public void loadModel(){
		this.modeltype = FvmResources.findOutModelType(this.modelname);
		try{
			this.model = (VehicleModel)DataUtil.loadModel(this.modeltype, this.modelname, VehicleModel.class);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Main class for custom vehicle data.
	 * @author Ferdinand (FEX___96)
	 */
	public static class VehicleData {
		
		public Vehicle vehicle;
		public UUID creator;
		public RGB primary, secondary;
		public boolean doors;
		public int texture;
		public String texture_url;
		public TreeMap<String, PartData> parts;
		public boolean readyToSpawn;
		
		public VehicleData(Vehicle vehicle){
			this.vehicle = vehicle;
			this.creator = UUID.fromString(Static.NULL_UUID_STRING);
			this.primary = new RGB(vehicle.def_primary);
			this.secondary = new RGB(vehicle.def_secondary);
			this.doors = false;
			this.texture = 0;
			this.texture_url = null;
			this.parts = new TreeMap<String, PartData>();
			this.readyToSpawn = false;
		}
		
		public NBTTagCompound write(NBTTagCompound compound){
			if(compound == null){
				compound = new NBTTagCompound();
			}
			compound.setString("VehicleType", vehicle.registryname);
			compound.setString("Creator", this.creator == null ? Static.NULL_UUID_STRING : this.creator.toString());
			this.primary.writeToNBT(compound, "Primary");
			this.secondary.writeToNBT(compound, "Secondary");
			compound.setBoolean("Doors", doors);
			compound.setInteger("Texture", texture);
			compound.setString("TextureUrl", texture_url == null ? "" : texture_url);
			NBTTagList list = new NBTTagList();
			for(Entry<String, PartData> entry : parts.entrySet()){
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setString("As", entry.getKey());
				entry.getValue().write(nbt);
				list.appendTag(nbt);
			}
			compound.setTag("Parts", list);
			compound.setBoolean("ReadyToSpawn", readyToSpawn);
			return compound;
		}
		
		public void read(NBTTagCompound compound){
			this.creator = UUID.fromString(compound.getString("Creator"));
			this.primary.readFromNBT(compound, "Primary");
			this.secondary.readFromNBT(compound, "Secondary");
			this.doors = compound.getBoolean("Doors");
			this.texture = compound.getInteger("Texture");
			this.texture_url = compound.getString("TextureUrl");
			NBTTagList list = compound.getTagList("Parts", 0);
			for(int i = 0; i < list.tagCount(); i++){
				NBTTagCompound nbt = list.getCompoundTagAt(i);
				PartData part = PartData.fromNBT(nbt);
				if(part != null){
					parts.put(nbt.getString("As"), part);
				}
			}
			this.readyToSpawn = compound.getBoolean("ReadyToSpawn");
		}
		
		public static VehicleData fromNBT(NBTTagCompound compound){
			if(compound.hasKey("VehicleType")){
				VehicleData vdata = new VehicleData( FvmResources.vehicles.get(compound.getString("VehicleType")));
				vdata.read(compound);
				return vdata;
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
			this.arr = new ArrayList<String>(Arrays.asList(arr));
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