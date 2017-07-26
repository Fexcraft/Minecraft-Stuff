package net.fexcraft.mod.fvtm.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.lib.tmt.Model;
import net.fexcraft.mod.lib.util.math.Pos;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface LandVehicle extends IForgeRegistryEntry<LandVehicle> {
	
	public Addon getAddon();
	
	public String getName();
	
	public String[] getDescription();
	
	@Override
	public default Class<LandVehicle> getRegistryType(){
		return LandVehicle.class;
	}
	
	public ItemStack getItemStack(@Nullable LandVehicleData data);
	
	public List<ResourceLocation> getPreinstalledParts();
	
	public List<ResourceLocation> getRequiredParts();
	
	public float getYAxisConstructorOffset();
	
	public float getWheelConstructorOffset();
	
	public List<ResourceLocation> getTextures();
	
	public List<Pos> getDefaultWheelPos();
	
	public RGB getDefPrimaryColor();
	
	public RGB getDefSecondaryolor();
	
	@SideOnly(Side.CLIENT)
	public Model getModel();
	
	//<-- VEHICLE DATA -->//
	public static interface LandVehicleData {
		
		public LandVehicle getVehicle();
		
		public int getSelectedTexture();
		
		public String getTextureURL();
		
		public void setTextureURL(String string);
		
		public int getFuelTankContent();
		
		public int getFuelTankSize();
		
		public Set<ResourceLocation> getInstalledParts();
		
		public Map<ResourceLocation, PartData> getParts();
		
		public List<Pos> getWheelPos();
		
		public RGB getPrimaryColor();
		
		public RGB getSecondaryColor();
		
		public NBTTagCompound writeToNBT(NBTTagCompound compound);
		
		public LandVehicleData readFromNBT(NBTTagCompound compound);
		
		public boolean readyToSpawn();
		
	}
	
	//<-- VEHICLE ITEM -->//
	public static interface LandVehicleItem {
		
		public static final String NBTKEY = "FVTM:LandVehicle";
		
		public LandVehicleData getLandVehicle(ItemStack stack);
		
	}
}