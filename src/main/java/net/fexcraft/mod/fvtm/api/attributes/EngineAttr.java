package net.fexcraft.mod.fvtm.api.attributes;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.blocks.ConstructorController.Button;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class EngineAttr implements Attribute {
	
	private float enginespeed;
	private float fuelcompsumption;

	@Override
	public ResourceLocation getRegistryName(){
		return new ResourceLocation("fvtm:engine");
	}

	@Override
	public void load(JsonObject obj){
		this.enginespeed = JsonUtil.getIfExists(obj, "Engine-Speed", 0.5f).floatValue();
		this.fuelcompsumption = JsonUtil.getIfExists(obj, "Fuel-Compsumption", 0.5f).floatValue();
	}

	@Override
	public String getName(){
		return "Engine";
	}

	@Override
	public NBTTagCompound getScreen(NBTTagCompound compound, PartData part, int selection, int scroll){
		// TODO Auto-generated method stub
		return compound;
	}

	@Override
	public void onButtonPress(Button button, EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}
	
}