package net.fexcraft.mod.fvtm.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.DriveType;
import net.fexcraft.mod.fvtm.api.LandVehicle;
import net.fexcraft.mod.fvtm.model.vehicle.EmptyVehicleModel;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.RecipeObject;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Pos;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericLandVehicle implements LandVehicle {
	
	private ResourceLocation registryname;
	private Addon addon;
	private String name;
	private String[] description;
	private float yoffset, wheeloffset;
	private List<ResourceLocation> textures;
	private TreeMap<String, ResourceLocation> preinstalled = new TreeMap<String, ResourceLocation>();
	private List<String> required;
	@SideOnly(Side.CLIENT) private VehicleModel model;
	private List<Pos> wheelpos;
	private RGB primary, secondary;
	private int constructionlength;
	private DriveType drivetype;
	//FM
	private float cameradis, maxposthrottle, maxnegthrottle, turnleftmod, turnrightmod, wheelspringstrength, wheelstepheight;
	
	public GenericLandVehicle(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj, "LANDVEHICLE");
		this.addon = DataUtil.getAddon(registryname, obj, "LANDVEHICLE");
		this.name = JsonUtil.getIfExists(obj, "FullName", registryname);
		this.description = DataUtil.getDescription(obj);
		this.textures = DataUtil.getTextures(obj, registryname, "LANDVEHICLE");
		this.yoffset = JsonUtil.getIfExists(obj, "ConstructionYOffSet", 0).floatValue();
		this.constructionlength = JsonUtil.getIfExists(obj, "ConstructionLength", 4).intValue();
		this.wheeloffset = JsonUtil.getIfExists(obj, "ConstructionWheelOffset", 0).floatValue();
		//this.preinstalled = JsonUtil.jsonArrayToResourceLocationArray(JsonUtil.getIfExists(obj, "PreInstalledParts", new JsonArray()).getAsJsonArray());
		if(obj.has("PreInstalled")){
			JsonArray array = JsonUtil.getIfExists(obj, "PreInstalled", new JsonArray()).getAsJsonArray();
			array.forEach((element) -> {
				JsonObject jsn = element.getAsJsonObject();
				preinstalled.put(jsn.get("as").getAsString(), new ResourceLocation(jsn.get("part").getAsString()));
			});
		}
		this.required = JsonUtil.jsonArrayToStringArray(JsonUtil.getIfExists(obj, "RequiredParts", new JsonArray()).getAsJsonArray());
		if(Static.side().isClient()){
			this.model = Resources.getModel(JsonUtil.getIfExists(obj, "ModelFile", "null"), VehicleModel.class, EmptyVehicleModel.INSTANCE);//TODO
		}
		this.wheelpos = new ArrayList<Pos>();
		if(obj.has("WheelPos")){
			JsonArray array = obj.get("WheelPos").getAsJsonArray();
			for(JsonElement elm : array){
				if(wheelpos.size() < 4){
					wheelpos.add(Pos.fromJSON(elm.getAsJsonObject()));
				}
			}
		}
		else{
			this.wheelpos.add(new Pos(0, 0, 0));
			this.wheelpos.add(new Pos(0, 0, 0));
			this.wheelpos.add(new Pos(0, 0, 0));
			this.wheelpos.add(new Pos(0, 0, 0));
		}
		this.primary = DataUtil.getRGB(obj, "PrimaryColor");
		this.secondary = DataUtil.getRGB(obj, "SecondaryColor");
		this.drivetype = DriveType.fromString(JsonUtil.getIfExists(obj, "DriveType", "fwd"));
		//FM
		this.cameradis = JsonUtil.getIfExists(obj, "FM-CameraDistance", 5f).floatValue();
		this.maxposthrottle = JsonUtil.getIfExists(obj, "FM-MaxPositiveThrottle", 1f).floatValue();
		this.maxnegthrottle = JsonUtil.getIfExists(obj, "FM-MaxNegativeThrottle", 0.2f).floatValue();
		this.turnleftmod = JsonUtil.getIfExists(obj, "FM-TurnLeftModifier", 1f).floatValue();
		this.turnrightmod = JsonUtil.getIfExists(obj, "FM-TurnRightModifier", 1f).floatValue();
		this.wheelspringstrength = JsonUtil.getIfExists(obj, "FM-WheelSpringStrength", 0.25f).floatValue();
		this.wheelstepheight = JsonUtil.getIfExists(obj, "FM-WheelStepHeight", 1f).floatValue();
		if(obj.has("Recipes")){
			obj.get("Recipes").getAsJsonArray().forEach((elm) -> {
				try{
					RecipeObject.parse(this.getItemStack(this.getDataClass().getConstructor(this.getClass()).newInstance(this)), elm.getAsJsonObject(), "FVTM:Vehicles");
				}
				catch(Exception e){
					e.printStackTrace();
				}
			});
		}
	}

	@Override
	public LandVehicle setRegistryName(ResourceLocation name){
		this.registryname = name;
		return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return this.registryname;
	}

	@Override
	public Addon getAddon(){
		return addon;
	}

	@Override
	public String getName(){
		return name;
	}

	@Override
	public String[] getDescription(){
		return description;
	}

	@Override
	public ItemStack getItemStack(LandVehicleData data){
		ItemStack stack = new ItemStack(GenericLandVehicleItem.INSTANCE);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString(LandVehicleItem.NBTKEY, this.getRegistryName().toString());
		if(data != null){
			data.writeToNBT(nbt);
		}
		stack.setTagCompound(nbt);
		return stack;
	}

	@Override
	public Map<String, ResourceLocation> getPreinstalledParts(){
		return preinstalled;
	}

	@Override
	public float getYAxisConstructorOffset(){
		return this.yoffset;
	}

	@Override
	public float getWheelConstructorOffset(){
		return this.wheeloffset;
	}

	@Override
	public List<ResourceLocation> getTextures(){
		return this.textures;
	}

	@Override @SideOnly(Side.CLIENT)
	public VehicleModel getModel(){
		return model;
	}

	@Override
	public List<Pos> getDefaultWheelPos(){
		return wheelpos;
	}

	@Override
	public RGB getDefPrimaryColor(){
		return primary;
	}

	@Override
	public RGB getDefSecondaryolor(){
		return secondary;
	}

	@Override
	public List<String> getRequiredParts(){
		return this.required;
	}

	@Override
	public int getConstructionLength(){
		return constructionlength;
	}

	@Override
	public Class<? extends LandVehicleData> getDataClass(){
		return GenericLandVehicleData.class;
	}

	@Override
	public boolean canSpawnAs(String modid){
		return modid.equals("flansmod") || modid.equals("fvtm");
	}

	@Override
	public DriveType getDriveType(){
		return drivetype;
	}

	@Override
	public float getFMCameraDistance(){
		return this.cameradis;
	}

	@Override
	public float getFMWheelStepHeight(){
		return this.wheelstepheight;
	}

	@Override
	public float getFMMaxNegativeThrottle(){
		return this.maxnegthrottle;
	}

	@Override
	public float getFMMaxPositiveThrottle(){
		return this.maxposthrottle;
	}

	@Override
	public float getFMTurnLeftModifier(){
		return this.turnleftmod;
	}

	@Override
	public float getFMTurnRightModifier(){
		return this.turnrightmod;
	}

	@Override
	public float getFMWheelSpringStrength(){
		return this.wheelspringstrength;
	}
	
}