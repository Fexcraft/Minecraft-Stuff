package net.fexcraft.mod.fvm.data;

import java.util.ArrayList;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.model.PartModel;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Pos;
import net.fexcraft.mod.lib.util.render.ModelType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Part implements IForgeRegistryEntry<Part>{
	
	public final Addon addon;
	private ResourceLocation registryname;
	public final int /*maxHealth,*/ maxStackSize;
	
	//Visual
	public String modelname;
	public ModelType modeltype = ModelType.NONE;
	@SideOnly(Side.CLIENT) public PartModel model;
	/*(Side.CLIENT) private float scale = 1;*/
	public ArrayList<ResourceLocation> textures;
	public TreeMap<ResourceLocation, JsonObject> modelsettings;
	
	//Construction
	public TreeMap<ResourceLocation, Pos> compatible;

	
	public Part(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj, "PART");
		this.addon = DataUtil.getAddon(registryname, obj, "PART");
		//this.maxHealth = JsonUtil.getIfExists(obj, "MaxHealth", 100).intValue();//500
		this.maxStackSize = JsonUtil.getIfExists(obj, "MaxStackSize", 64).intValue();
		//
		this.modelname = JsonUtil.getIfExists(obj, "ModelFile", "null");
		this.textures = DataUtil.getTextures(obj, this.registryname, "PART");
		if(obj.has("ModelSettings")){
			JsonArray array = obj.get("ModelSettings").getAsJsonArray();
			for(JsonElement elm : array){
				JsonObject jsn = elm.getAsJsonObject();
				modelsettings.put(new ResourceLocation(jsn.get("Vehicle").getAsString()), jsn);
			}
		}
	}

	public void loadModel(){
		this.modeltype = FvmResources.findOutModelType(this.modelname);
		try{
			this.model = (PartModel)DataUtil.loadModel(this.modeltype, this.modelname, PartModel.class);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static class PartData {
		
		public Part part;
		public int texture;
		public String texture_url;
		
		public PartData(Part part){
			this.part = part;
			this.texture = 0;
		}

		public void write(NBTTagCompound compound){
			compound.setString("PartType", part.registryname.toString());
			compound.setInteger("Texture", texture);
			compound.setString("TextureUrl", texture_url == null ? "" : texture_url);
		}

		private void read(NBTTagCompound compound){
			this.texture = compound.getInteger("Texture");
			this.texture_url = compound.getString("TextureUrl");
		}

		public static PartData fromNBT(NBTTagCompound compound) {
			if(compound.hasKey("PartType")){
				PartData pdata = new PartData(FvmResources.PARTS.getValue(new ResourceLocation(compound.getString("PartType"))));
				pdata.read(compound);
				return pdata;
			}
			return null;
		}
	}

	public void translate(ResourceLocation resourceLocation){
		if(this.compatible.containsKey(resourceLocation)){
			this.compatible.get(resourceLocation).translate();
		}
	}

	public void translateR(ResourceLocation resourceLocation){
		if(this.compatible.containsKey(resourceLocation)){
			this.compatible.get(resourceLocation).translateR();
		}
	}

	@Override
	public Part setRegistryName(ResourceLocation name){
		registryname = name;
		return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return registryname;
	}

	@Override
	public Class<Part> getRegistryType(){
		return Part.class;
	}	
	
}