package net.fexcraft.mod.fvtm.auto;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.tmt.Model;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.actors.threadpool.Arrays;

public class GenericPart implements Part {
	
	private ResourceLocation registryname;
	private Addon addon;
	private String name;
	private String[] description, categories, attributes;
	private TreeMap<ResourceLocation, Pos> compatible = new TreeMap<ResourceLocation, Pos>();
	private ArrayList<ResourceLocation> textures;
	private boolean removable, available;
	private Model model;
	private JsonObject attributedata;
	
	public GenericPart(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj, "PART");
		this.addon = DataUtil.getAddon(registryname, obj, "PART");
		this.name = JsonUtil.getIfExists(obj, "FullName", this.registryname.toString());
		this.description = DataUtil.getDescription(obj);
		if(obj.has("Compatible")){
			JsonArray array = obj.get("Compatible").getAsJsonArray();
			for(JsonElement elm : array){
				try{
					JsonObject jsn = elm.getAsJsonObject();
					compatible.put(new ResourceLocation(jsn.get("vehicle").getAsString()), Pos.fromJSON(jsn));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		this.textures = DataUtil.getTextures(obj, registryname, "PART");
		this.categories = JsonUtil.jsonArrayToStringArray(JsonUtil.getIfExists(obj, "Category", new JsonArray()).getAsJsonArray()).toArray(new String[]{});
		this.attributes = JsonUtil.jsonArrayToStringArray(JsonUtil.getIfExists(obj, "Attributes", new JsonArray()).getAsJsonArray()).toArray(new String[]{});
		this.removable = JsonUtil.getIfExists(obj, "Removable", true);
		this.available = JsonUtil.getIfExists(obj, "Avaiable", true);
		this.model = Resources.getModel(JsonUtil.getIfExists(obj, "ModelFile", "null"), null);//TODO
		this.attributedata = JsonUtil.getIfExists(obj, "AttributeData", new JsonObject()).getAsJsonObject();
	}

	@Override
	public Part setRegistryName(ResourceLocation name){
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
	public ItemStack getItemStack(PartData data){
		ItemStack stack = new ItemStack(GenericPartItem.INSTANCE);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString(PartItem.NBTKEY, this.getRegistryName().toString());
		if(data != null){
			data.writeToNBT(nbt);
		}
		stack.setTagCompound(nbt);
		return stack;
	}

	@Override
	public List<ResourceLocation> getCompatibleVehicles(){
		return new ArrayList<ResourceLocation>(compatible.keySet());
	}

	@Override
	public Pos getOffsetFor(ResourceLocation vehicle){
		return compatible.containsKey(vehicle) ? compatible.get(vehicle) : new Pos(0, 0, 0);
	}

	@Override
	public List<ResourceLocation> getTextures(){
		return textures;
	}

	@Override
	public List<String> getCategories(){
		return Arrays.asList(categories);
	}

	@Override
	public String getCategory(){
		return categories[0];
	}

	@Override
	public List<String> getAttributes(){
		return Arrays.asList(categories);
	}

	@Override
	public boolean isRemovable(){
		return removable;
	}

	@Override
	public boolean isAvailable(){
		return available;
	}

	@Override @SideOnly(Side.CLIENT)
	public Model getModel(){
		return model;
	}

	@Override
	public JsonObject getAttributeData(){
		return this.attributedata;
	}
	
}