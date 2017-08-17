package net.fexcraft.mod.addons.gep.attributes;

import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.blocks.ConstructorController.Button;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class FuelTankExtensionAttribute implements Attribute {
	
	private static final ResourceLocation regname = new ResourceLocation("fuel_tank");
	private int tanksize;

	@Override
	public ResourceLocation getRegistryName(){
		return regname;
	}

	@Override
	public void load(JsonObject obj){
		this.tanksize = JsonUtil.getIfExists(obj, "Fuel-TankSize", 10).intValue();
	}

	@Override
	public String getName(){
		return "Fuel Tank Extension";
	}

	@Override
	public NBTTagCompound getScreen(NBTTagCompound compound, PartData part, int selection, int scroll){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onButtonPress(Button button, EntityPlayer player, String[] args){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag){
		tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
		tooltip.add(Formatter.format("&9Tank Size: &7" + tanksize));
	}

	public int getFuelTankSize(){
		return tanksize;
	}

	@Override
	public boolean hasDataClass(){
		return false;
	}

	@Override
	public Class<? extends AttributeData> getDataClass(){
		return null;
	}
	
}