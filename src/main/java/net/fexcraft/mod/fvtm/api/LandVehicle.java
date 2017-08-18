package net.fexcraft.mod.fvtm.api;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.compatibility.FMSeat;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketEntityUpdate;
import net.fexcraft.mod.lib.util.math.Pos;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
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
	
	//<-- VEHICLE DATA -->//
	public static interface LandVehicleData {
		
		public LandVehicle getVehicle();
		
		public int getSelectedTexture();
		
		public void setSelectedTexture(int i);
		
		public ResourceLocation getCustomTexture();
		
		public void setCustomTexture(String string, boolean external);
		
		public boolean isTextureExternal();
		
		public ResourceLocation getTexture();
		
		public double getFuelTankContent();

		public boolean consumeFuel(double d);
		
		public int getFuelTankSize();
		
		public Set<String> getInstalledParts();
		
		public Map<String, PartData> getParts();

		public PartData getPart(String string);
		
		public List<Pos> getWheelPos();
		
		public RGB getPrimaryColor();
		
		public RGB getSecondaryColor();
		
		public NBTTagCompound writeToNBT(NBTTagCompound compound);
		
		public LandVehicleData readFromNBT(NBTTagCompound compound, boolean isRemote);
		
		public boolean readyToSpawn();

		public boolean doorsOpen();

		public void toggleDoors(@Nullable Boolean doors);

		public void installPart(String as, PartData data);
		
		public boolean isLocked();
		
		public boolean setLocked(@Nullable Boolean lock);

		public String getLockCode();
		
		public Collection<LandVehicleScript> getScripts();
		
		public <T extends LandVehicleScript> T getScript(Class<T> clazz);

		public int getSpawnedKeysAmount();

		public void setSpawnedKeysAmount(@Nullable Integer i);

		public List<FMSeat> getFMSeats();

		public default boolean allowsLocking(){
			return true;
		}

		public boolean isRemote();
		
	}
	
	//<-- VEHICLE ITEM -->//
	public static interface LandVehicleItem {
		
		public static final String NBTKEY = "FVTM:LandVehicle";
		
		public LandVehicleData getLandVehicle(ItemStack stack);
		
	}
	
	public static interface LandVehicleScript {
		
		public ResourceLocation getId();
		
		public boolean isOn(Side side);
		
		public NBTTagCompound writeToNBT(NBTTagCompound compound);
		
		public LandVehicleScript readFromNBT(NBTTagCompound compound, boolean isRemote);
		
		public void onDataPacket(Entity entity, LandVehicleData data, NBTTagCompound compound, Side side);

		public void onCreated(Entity entity, LandVehicleData data);

		public boolean onInteract(Entity entity, LandVehicleData data, EntityPlayer player);

		public void onUpdate(Entity entity, LandVehicleData data);

		public void onRemove(Entity entity, LandVehicleData data);
		
		@SideOnly(Side.CLIENT)
		public static int getClientSeatId(){
			EntityPlayer player = net.minecraft.client.Minecraft.getMinecraft().player;
			if(player.getRidingEntity() != null && player.getRidingEntity() instanceof com.flansmod.fvtm.EntitySeat){
				return ((com.flansmod.fvtm.EntitySeat)player.getRidingEntity()).getSeatId();
			}
			else return -1;
		}
		
		@SideOnly(Side.CLIENT)
		public static boolean playerIsInVehicle(com.flansmod.fvtm.LandVehicle vehicle){
			EntityPlayer player = net.minecraft.client.Minecraft.getMinecraft().player;
			for(com.flansmod.fvtm.EntitySeat seat : vehicle.seats){
				if(player.getRidingEntity() == null){
					return false;
				}
				if(player.getRidingEntity().equals(seat)){
					return true;
				}
			}
			return false;
		}
		
		public default void sendPacketToClient(Entity ent, EntityPlayerMP player, NBTTagCompound nbt){
			nbt.setString("ScriptId", getId().toString());
			PacketHandler.getInstance().sendTo(new PacketEntityUpdate(ent, nbt), player);
		}
		
		public default void sendPacketToAll(Entity ent, NBTTagCompound nbt){
			nbt.setString("ScriptId", getId().toString());
			PacketHandler.getInstance().sendToAll(new PacketEntityUpdate(ent, nbt));
		}
		
		public default void sendPacketToAllAround(Entity ent, NBTTagCompound nbt){
			nbt.setString("ScriptId", getId().toString());
			PacketHandler.getInstance().sendToAllAround(new PacketEntityUpdate(ent, nbt), new TargetPoint(ent.dimension, ent.posX, ent.posY, ent.posZ, 256));
		}
		
		public default void sendPacketToServer(Entity ent, NBTTagCompound nbt){
			nbt.setString("ScriptId", getId().toString());
			PacketHandler.getInstance().sendToServer(new PacketEntityUpdate(ent, nbt));
		}
		
	}
	
}