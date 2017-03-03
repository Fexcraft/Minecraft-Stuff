package net.fexcraft.mod.fvm.data;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.items.MaterialItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Material extends DataObject {
	
	public String addonpack;
	public String registryname;
	public String fullname;
	public ArrayList<String> description = new ArrayList<String>();
	public MaterialItem item;
	public int maxStackSize;
	
	public Material(LoadedIn state, JsonObject obj){
		super(state);
		if(state.isLoadedInMemory() || obj == null){
			load(obj);
		}
	}
	
	@Override
	public void load(JsonObject obj){
		if(obj == null){
			addonpack = "none";
			registryname = "null";
			fullname = "Null Type";
			return;
		}
		addonpack = ju.getIfExists(obj, "AddOn", "nullpack");
		registryname = ju.getIfExists(obj, "RegistryName", "null");
		fullname = ju.getIfExists(obj, "FullName", registryname);
		if(obj.has("Description")){
			description = ju.jsonArrayToStringArray(obj.get("Description").getAsJsonArray());
		}
		maxStackSize = ju.getIfExists(obj, "MaxStackSize", 64).intValue();
		
		if(this.state().isLoadedInMemory()){
			MaterialItem.addMaterial(this);
			if(obj.has("Recipes")){
				JsonArray arr = obj.get("Recipes").getAsJsonArray();
				for(JsonElement elm : arr){
					try{
						RecipeObject.parse(newStack(), elm.getAsJsonObject());
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public JsonObject save(JsonObject obj){
		obj.addProperty("MaterialName", registryname);
		return obj;
	}

	@Override
	public void read(NBTTagCompound compound){
		//
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		return null;
	}

	@Override
	public DataObject newInstance(LoadedIn state){
		return this;
	}
	
	@Override
	public int compareTo(Object o){
		if(registryname == null){
			return -1;
		}
		return registryname.compareTo(((Material)o).registryname);
	}

	public void setItem(MaterialItem item){
		this.item = item;
	}

	public ItemStack newStack(){
		return new ItemStack(item, 1, 0);
	}
	
}