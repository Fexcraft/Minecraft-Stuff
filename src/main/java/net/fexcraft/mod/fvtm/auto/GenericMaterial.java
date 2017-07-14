package net.fexcraft.mod.fvtm.auto;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class GenericMaterial implements Material {
	
	private ResourceLocation registryname;
	private Addon addon;
	private String name;
	private String[] description;
	
	public GenericMaterial(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj, "ADDON");
		this.addon = DataUtil.getAddon(registryname, obj, "ADDON");
		this.name = JsonUtil.getIfExists(obj, "FullName", this.registryname.toString());
		this.description = DataUtil.getDescription(obj);
	}

	@Override
	public Material setRegistryName(ResourceLocation name){
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
	public ItemStack getItemStack(){
		ItemStack stack = new ItemStack(GenericMaterialItem.INSTANCE);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString(MaterialItem.NBTKEY, this.getRegistryName().toString());
		stack.setTagCompound(nbt);
		return stack;
	}
	
}