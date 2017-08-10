package net.fexcraft.mod.fvtm.api;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.compatibility.FMSeat;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.lib.util.math.Pos;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
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
	
	public Map<String, ResourceLocation> getPreinstalledParts();
	
	public List<String> getRequiredParts();
	
	public float getYAxisConstructorOffset();
	
	public float getWheelConstructorOffset();
	
	public int getConstructionLength();
	
	public List<ResourceLocation> getTextures();
	
	public List<Pos> getDefaultWheelPos();
	
	public RGB getDefPrimaryColor();
	
	public RGB getDefSecondaryolor();
	
	@SideOnly(Side.CLIENT)
	public VehicleModel getModel();
	
	public Class<? extends LandVehicleData> getDataClass();
	
	public boolean canSpawnAs(String modid);

	public float getFMCameraDistance();//5f

	public float getFMWheelStepHeight();//1f

	public float getFMWheelSpringStrength();//0.5f

	public float getFMMaxNegativeThrottle();
	
	public float getFMMaxPositiveThrottle();

	public float getFMTurnLeftModifier();

	public float getFMTurnRightModifier();

	public DriveType getDriveType();
	
	public Collection<Class<? extends LandVehicleScript>> getScripts();
	
	//<-- VEHICLE DATA -->//
	public static interface LandVehicleData {
		
		public LandVehicle getVehicle();
		
		public int getSelectedTexture();
		
		public void setSelectedTexture(int i);
		
		public ResourceLocation getCustomTexture();
		
		public void setCustomTexture(String string, boolean external);
		
		public boolean isTextureExternal();
		
		public ResourceLocation getTexture();
		
		public int getFuelTankContent();
		
		public int getFuelTankSize();
		
		public Set<String> getInstalledParts();
		
		public Map<String, PartData> getParts();

		public PartData getPart(String string);
		
		public List<Pos> getWheelPos();
		
		public RGB getPrimaryColor();
		
		public RGB getSecondaryColor();
		
		public NBTTagCompound writeToNBT(NBTTagCompound compound);
		
		public LandVehicleData readFromNBT(NBTTagCompound compound);
		
		public boolean readyToSpawn();

		public boolean doorsOpen();

		public void toggleDoors(@Nullable Boolean doors);

		public void installPart(String as, PartData data);
		
		public boolean isLocked();
		
		public boolean setLocked(@Nullable Boolean lock);

		public String getLockCode();
		
		public Collection<LandVehicleScript> getScripts();

		public int getSpawnedKeysAmount();

		public void setSpawnedKeysAmount(@Nullable Integer i);

		public List<FMSeat> getFMSeats();

		public default boolean allowsLocking(){
			return true;
		}
		
	}
	
	//<-- VEHICLE ITEM -->//
	public static interface LandVehicleItem {
		
		public static final String NBTKEY = "FVTM:LandVehicle";
		
		public LandVehicleData getLandVehicle(ItemStack stack);
		
	}
	
	public static interface LandVehicleScript {
		
		public boolean isOn(Side side);
		
		public NBTTagCompound writeToNBT(NBTTagCompound compound);
		
		public LandVehicleScript readFromNBT(NBTTagCompound compound);
		
		public void onDataPacket(Entity entity, NBTTagCompound compound);

		public void onCreated(Entity entity);

		public boolean onInteract(Entity entity, EntityPlayer player);

		public void onUpdate(Entity entity);

		public void onRemove(Entity entity);
		
	}
	
}