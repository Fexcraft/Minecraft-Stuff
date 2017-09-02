package net.fexcraft.mod.addons.gep.scripts;

import org.lwjgl.input.Keyboard;

import net.fexcraft.mod.fvtm.api.LandVehicle;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleData;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleScript;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;

public class MultiDoorScript implements LandVehicle.LandVehicleScript {
	
	public boolean hood, trunk, front_left, front_right, back_left, back_right;
	private int cooldown;

	@Override
	public ResourceLocation getId(){
		return new ResourceLocation("generic:multidoor");
	}

	@Override
	public boolean isOn(Side side){
		return true;//on both sides
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		compound.setBoolean("MultiDoor-Hood", hood);
		compound.setBoolean("MultiDoor-Trunk", trunk);
		compound.setBoolean("MultiDoor-FrontLeft", front_left);
		compound.setBoolean("MultiDoor-FrontRight", front_right);
		compound.setBoolean("MultiDoor-BackLeft", back_left);
		compound.setBoolean("MultiDoor-BackRight", back_right);
		return compound;
	}

	@Override
	public LandVehicleScript readFromNBT(NBTTagCompound compound, boolean isRemote){
		this.hood = compound.getBoolean("MultiDoor-Hood");
		this.trunk = compound.getBoolean("MultiDoor-Trunk");
		this.front_left = compound.getBoolean("MultiDoor-FrontLeft");
		this.front_right = compound.getBoolean("MultiDoor-FrontRight");
		this.back_left = compound.getBoolean("MultiDoor-BackLeft");
		this.back_right = compound.getBoolean("MultiDoor-BackRight");
		return this;
	}

	@Override
	public void onDataPacket(Entity entity, LandVehicleData data, NBTTagCompound compound, Side side){
		if(!compound.hasKey("MultiDoor")){
			return;
		}
		if(side.isServer()){
			this.sendPacketToAllAround(entity, compound);
		}
		byte[] arr = compound.getByteArray("MultiDoor");
		this.hood        = arr[0] == 0 ? false : true;
		this.trunk       = arr[1] == 0 ? false : true;
		this.front_left  = arr[2] == 0 ? false : true;
		this.front_right = arr[3] == 0 ? false : true;
		this.back_left   = arr[4] == 0 ? false : true;
		this.back_right  = arr[5] == 0 ? false : true;
	}

	@Override
	public void onCreated(Entity entity, LandVehicleData data){
		//
	}

	@Override
	public boolean onInteract(Entity entity, LandVehicleData data, EntityPlayer player){
		return false;
	}

	@Override
	public void onUpdate(Entity entity, LandVehicleData data){
		if(cooldown > 0){
			cooldown--;
		}
		if(cooldown > 0){
			return;
		}
		if(entity.world.isRemote && LandVehicleScript.playerIsInVehicle((com.flansmod.fvtm.LandVehicle)entity)){
			if(Keyboard.isKeyDown(Keyboard.KEY_L)){
				int seat = LandVehicleScript.getClientSeatId();
				switch(seat){
					case 0:{
						front_left = !front_left;
						break;
					}
					case 1:{
						front_right = !front_right;
						break;
					}
					case 2:{
						back_left = !back_left;
						break;
					}
					case 3:{
						back_right = !back_right;
						break;
					}
					default: break;
				}
				if(seat < 4){
					sendDoorPacket(entity);
					cooldown = 30;
					Print.debugChat("L > Door");
				}
			}
			else if(Keyboard.isKeyDown(Keyboard.KEY_O)){
				if(LandVehicleScript.getClientSeatId() != 0){
					return;
				}
				hood = !hood;
				cooldown = 30;
				sendDoorPacket(entity);
				Print.debugChat("O > Hood");
			}
			else if(Keyboard.isKeyDown(Keyboard.KEY_P)){
				if(LandVehicleScript.getClientSeatId() != 0){
					return;
				}
				trunk = !trunk;
				cooldown = 30;
				sendDoorPacket(entity);
				Print.debugChat("P > Back");
			}
			else return;
		}
	}

	private void sendDoorPacket(Entity entity){
		byte[] arr = new byte[6];
		arr[0] = (byte)(hood ? 1 : 0);
		arr[1] = (byte)(trunk ? 1 : 0);
		arr[2] = (byte)(front_left ? 1 : 0);
		arr[3] = (byte)(front_right ? 1 : 0);
		arr[4] = (byte)(back_left ? 1 : 0);
		arr[5] = (byte)(back_right ? 1 : 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setByteArray("MultiDoor", arr);
		this.sendPacketToServer(entity, nbt);
	}

	@Override
	public void onRemove(Entity entity, LandVehicleData data){
		//
	}
	
}