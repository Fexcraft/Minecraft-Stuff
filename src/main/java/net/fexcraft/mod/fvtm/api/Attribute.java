package net.fexcraft.mod.fvtm.api;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.blocks.ConstructorController.Button;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface Attribute extends IForgeRegistryEntry<Attribute> {
	
	public void load(JsonObject obj);
	
	public String getName();
	
	public NBTTagCompound getScreen(NBTTagCompound compound, PartData part, int selection, int scroll);
	
	public void onButtonPress(Button button, EntityPlayer player);
	
	public default Attribute setRegistryName(ResourceLocation name){
		return this;
	}
	
	public default Class<Attribute> getRegistryType(){
		return Attribute.class;
	}
	
}