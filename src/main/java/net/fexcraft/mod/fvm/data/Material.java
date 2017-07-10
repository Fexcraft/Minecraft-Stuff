package net.fexcraft.mod.fvm.data;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Material implements IForgeRegistryEntry<Material> {
	
	public Addon addonpack;
	private ResourceLocation registryname;
	public String fullname;
	public String[] description;
	
	public Material(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj, "MATERIAL");
		this.addonpack = DataUtil.getAddon(registryname, obj, "MATERIAL");
		this.fullname = JsonUtil.getIfExists(obj, "FullName", registryname.toString());
		this.description = DataUtil.getDescription(obj);
	}

	@Override
	public Material setRegistryName(ResourceLocation name){
		registryname = name;
		return this;
	}

	@Override
	public ResourceLocation getRegistryName() {
		return registryname;
	}

	@Override
	public Class<Material> getRegistryType(){
		return Material.class;
	}
	
}