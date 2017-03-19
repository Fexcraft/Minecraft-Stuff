package net.fexcraft.mod.fvm.data;

import com.flansmod.fvm.LandVehicle;

import net.fexcraft.mod.fvm.network.FvmPacketHandler;
import net.fexcraft.mod.fvm.network.packets.ScriptNBTPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class Script {
	
	private LoadedIn loadedin;
	
	public Script(LoadedIn state){
		loadedin = state;
	}
	
	public abstract String getId();
	
	public abstract void onCreated(com.flansmod.fvm.LandVehicle vehicleentity);
	
	public abstract void onRemoved(com.flansmod.fvm.LandVehicle vehicleentity);
	
	public abstract void onUpdate(com.flansmod.fvm.LandVehicle vehicleentity);

	public abstract boolean onInteract(com.flansmod.fvm.LandVehicle landVehicle, EntityPlayer entityplayer);
	
	public abstract NBTTagCompound write(NBTTagCompound nbt);
	
	public abstract void read(NBTTagCompound nbt);
	
	public abstract void onPacket(com.flansmod.fvm.LandVehicle landVehicle, NBTTagCompound packet, Side side);
	
	protected void sendPacketToClient(com.flansmod.fvm.LandVehicle vehicleentity, EntityPlayerMP player, NBTTagCompound nbt){
		nbt.setString("ScriptId", this.getId());
		FvmPacketHandler.getInstance().sendTo(new ScriptNBTPacket(vehicleentity, nbt), player);
	}
	
	protected void sendPacketToAll(com.flansmod.fvm.LandVehicle vehicleentity, NBTTagCompound nbt){
		nbt.setString("ScriptId", this.getId());
		FvmPacketHandler.getInstance().sendToAll(new ScriptNBTPacket(vehicleentity, nbt));
	}
	
	protected void sendPacketToAllAround(LandVehicle vehicleentity, NBTTagCompound nbt) {
		nbt.setString("ScriptId", this.getId());
		FvmPacketHandler.getInstance().sendToAllAround(new ScriptNBTPacket(vehicleentity, nbt), new TargetPoint(vehicleentity.dimension, vehicleentity.posX, vehicleentity.posY, vehicleentity.posZ, 256));
	}
	
	protected void sendPacketToServer(com.flansmod.fvm.LandVehicle vehicleentity, NBTTagCompound nbt){
		nbt.setString("ScriptId", this.getId());
		FvmPacketHandler.getInstance().sendToServer(new ScriptNBTPacket(vehicleentity, nbt));
	}
	
	@SideOnly(Side.CLIENT)
	protected int getClientSeatId(){
		EntityPlayer player = Minecraft.getMinecraft().player;
		if(player.getRidingEntity() != null && player.getRidingEntity() instanceof com.flansmod.fvm.EntitySeat){
			return ((com.flansmod.fvm.EntitySeat)player.getRidingEntity()).getSeatId();
		}
		else return -1;
	}
	
	@SideOnly(Side.CLIENT)
	protected boolean playerIsInVehicle(com.flansmod.fvm.LandVehicle vehicle){
		EntityPlayer player = Minecraft.getMinecraft().player;
		for(com.flansmod.fvm.EntitySeat seat : vehicle.seats){
			if(player.getRidingEntity() == null){
				return false;
			}
			if(player.getRidingEntity().equals(seat)){
				return true;
			}
		}
		return false;
	}
	
}