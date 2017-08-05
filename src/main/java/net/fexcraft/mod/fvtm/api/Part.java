package net.fexcraft.mod.fvtm.api;

import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface Part extends IForgeRegistryEntry<Part> {
	
	public Addon getAddon();
	
	public String getName();
	
	public String[] getDescription();
	
	@Override
	public default Class<Part> getRegistryType(){
		return Part.class;
	}
	
	public ItemStack getItemStack(@Nullable PartData data);
	
	public List<ResourceLocation> getCompatibleVehicles();
	
	public Pos getOffsetFor(ResourceLocation vehicle);
	
	public List<ResourceLocation> getTextures();
	
	public List<String> getCategories();
	
	public String getCategory();
	
	public List<String> getAttributes();
	
	public boolean isRemovable();
	
	public boolean isAvailable();
	
	public boolean isAdjustable();
	
	public JsonObject getAttributeData();
	
	public <T extends Attribute> T getAttribute(Class<T> clazz);
	
	public Collection<Class> getAttributeClasses();
	
	public boolean canInstall(String as, LandVehicleData data, EntityPlayer player);
	
	@SideOnly(Side.CLIENT)
	public PartModel getModel();
	
	public Class<? extends PartData> getDataClass();
	
	//<-- PART DATA -->//
	public static interface PartData {
		
		public Part getPart();
		
		public int getSelectedTexture();
		
		public void setSelectedTexture(int i);
		
		public ResourceLocation getCustomTexture();
		
		public void setCustomTexture(String string, boolean external);
		
		public boolean isTextureExternal();
		
		public ResourceLocation getTexture();
		
		public Pos getCurrentOffset();
		
		public NBTTagCompound writeToNBT(NBTTagCompound compound);
		
		public PartData readFromNBT(NBTTagCompound compound);
		
	}
	
	//<-- PART ITEM -->//
	public static interface PartItem {
		
		public static final String NBTKEY = "FVTM:Part";
		
		public PartData getPart(ItemStack stack);
		
	}
	
}