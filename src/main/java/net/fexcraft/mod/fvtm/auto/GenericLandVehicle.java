package net.fexcraft.mod.fvtm.auto;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.LandVehicle;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.tmt.Model;
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
	private List<ResourceLocation> preinstalled, required, textures;
	private Model model;
	private List<Pos> wheelpos;
	private RGB primary, secondary;
	private int constructionlength;
	
	public GenericLandVehicle(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj, "LANDVEHICLE");
		this.addon = DataUtil.getAddon(registryname, obj, "LANDVEHICLE");
		this.name = JsonUtil.getIfExists(obj, "FullName", registryname);
		this.description = DataUtil.getDescription(obj);
		this.textures = DataUtil.getTextures(obj, registryname, "LANDVEHICLE");
		this.yoffset = JsonUtil.getIfExists(obj, "ConstructionYOffSet", 0).floatValue();
		this.constructionlength = JsonUtil.getIfExists(obj, "ConstructionLength", 4).intValue();
		this.wheeloffset = JsonUtil.getIfExists(obj, "ConstructionWheelOffset", 0).floatValue();
		this.preinstalled = JsonUtil.jsonArrayToResourceLocationArray(JsonUtil.getIfExists(obj, "PreInstalledParts", new JsonArray()).getAsJsonArray());
		this.required = JsonUtil.jsonArrayToResourceLocationArray(JsonUtil.getIfExists(obj, "RequiredParts", new JsonArray()).getAsJsonArray());
		this.model = Resources.getModel(JsonUtil.getIfExists(obj, "ModelFile", "null"), null);//TODO
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
	public List<ResourceLocation> getPreinstalledParts(){
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
	public Model getModel(){
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
	public List<ResourceLocation> getRequiredParts(){
		return this.required;
	}

	@Override
	public int getConstructionLength(){
		return constructionlength;
	}
	
}