package net.fexcraft.mod.fvm.data;

import java.util.ArrayList;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.items.PartItem;
import net.fexcraft.mod.fvm.model.PartModel;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Pos;
import net.fexcraft.mod.lib.util.render.ModelType;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Part {
	
	public final Addon addon;
	public final String registryname;
	public final int /*maxHealth,*/ maxStackSize;
	public final Item item;
	
	//Visual
	public String modelname;
	public ModelType modeltype = ModelType.NONE;
	@SideOnly(Side.CLIENT) public PartModel model;
	/*(Side.CLIENT) private float scale = 1;*/
	public ArrayList<ResourceLocation> textures;
	public TreeMap<String, JsonObject> modelsettings;
	
	//Construction
	public TreeMap<String, Pos> compatible;

	
	public Part(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj, "PART");
		this.addon = DataUtil.getAddon(registryname, obj, "PART");
		//this.maxHealth = JsonUtil.getIfExists(obj, "MaxHealth", 100).intValue();//500
		this.maxStackSize = JsonUtil.getIfExists(obj, "MaxStackSize", 64).intValue();
		this.item = new PartItem(this);
		//
		this.modelname = JsonUtil.getIfExists(obj, "ModelFile", "null");
		this.textures = DataUtil.getTextures(obj, this.registryname, "PART");
		if(obj.has("ModelSettings")){
			JsonArray array = obj.get("ModelSettings").getAsJsonArray();
			for(JsonElement elm : array){
				JsonObject jsn = elm.getAsJsonObject();
				modelsettings.put(jsn.get("Vehicle").getAsString(), jsn);
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
			compound.setString("PartType", part.registryname);
			compound.setInteger("Texture", texture);
			compound.setString("TextureUrl", texture_url == null ? "" : texture_url);
		}

		private void read(NBTTagCompound compound){
			this.texture = compound.getInteger("Texture");
			this.texture_url = compound.getString("TextureUrl");
		}

		public static PartData fromNBT(NBTTagCompound compound) {
			if(compound.hasKey("PartType")){
				PartData pdata = new PartData( FvmResources.parts.get(compound.getString("PartType")));
				pdata.read(compound);
				return pdata;
			}
			return null;
		}
	}

	public void translate(String name){
		if(this.compatible.containsKey(name)){
			this.compatible.get(name).translate();
		}
	}

	public void translateR(String name){
		if(this.compatible.containsKey(name)){
			this.compatible.get(name).translateR();
		}
	}	
	
}