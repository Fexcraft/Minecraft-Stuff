package net.fexcraft.mod.fvtm.api;

import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface Attribute extends IForgeRegistryEntry<Attribute> {
	
	public void load(JsonObject obj);
	
	public default Attribute setRegistryName(ResourceLocation name){
		return this;
	}
	
	public default Class<Attribute> getRegistryType(){
		return Attribute.class;
	}
	
}