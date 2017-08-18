package net.fexcraft.mod.addons.gep.attributes;

import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Fuel;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.blocks.ConstructorController.Button;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EngineAttribute implements Attribute {
	
	private float enginespeed;
	private float fuelcompsumption;
	private Fuel fueltype;

	@Override
	public ResourceLocation getRegistryName(){
		return new ResourceLocation("engine");
	}

	@Override
	public void load(JsonObject obj){
		this.enginespeed = JsonUtil.getIfExists(obj, "Engine-Speed", 0.5f).floatValue();
		this.fuelcompsumption = JsonUtil.getIfExists(obj, "Fuel-Compsumption", 0.5f).floatValue();
		this.fueltype = Resources.FUELS.getValue(new ResourceLocation(JsonUtil.getIfExists(obj, "Fuel-Type", "gasoline")));
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
	public void onButtonPress(Button button, EntityPlayer player, String[] args){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag){
		tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
		tooltip.add(Formatter.format("&9Speed: &7" + enginespeed));
		tooltip.add(Formatter.format("&9Compsumption: &7" + fuelcompsumption));
		tooltip.add(Formatter.format("&9Fuel: &7" + fueltype.getRegistryName().toString()));
	}

	public float getFuelCompsumption(){
		return fuelcompsumption;
	}
	
	public Fuel getFuelType(){
		return fueltype;
	}
	
	public float getEngineSpeed(){
		return enginespeed;
	}

	@Override
	public boolean hasDataClass(){
		return true;
	}

	@Override
	public Class<? extends AttributeData> getDataClass(){
		return EngineAttributeData.class;
	}
	
	public static class EngineAttributeData implements AttributeData {
		
		private boolean isOn;
		
		public EngineAttributeData(PartData data, Attribute attr){
			this.isOn = false;
		}

		@Override
		public NBTTagCompound writeToNBT(PartData data, NBTTagCompound compound){
			compound.setBoolean("EngineOn", isOn);
			return compound;
		}

		@Override
		public AttributeData readFromNBT(PartData data, NBTTagCompound compound){
			this.isOn = compound.hasKey("EngineOn") ? compound.getBoolean("EngineOn") : this.isOn;
			return this;
		}
		
		public boolean isOn(){
			return this.isOn;
		}

		public boolean toggle(){
			return this.isOn = !this.isOn;
		}

		public boolean setOn(boolean bool){
			return this.isOn = bool;
		}
		
	}
	
}