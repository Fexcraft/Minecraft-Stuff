package net.fexcraft.mod.fvm.scripts;

import org.lwjgl.input.Keyboard;

import com.flansmod.fvm.LandVehicle;
import net.fexcraft.mod.fvm.data.LoadedIn;
import net.fexcraft.mod.fvm.data.Script;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

public class MultiDoorScript extends Script {
	
	public boolean front, back, rf, rb, lf, lb;
	private int cooldown = 0;
	
	public MultiDoorScript(LoadedIn state){
		super(state);
	}

	@Override
	public String getId(){
		return "generic-multidoor";
	}

	@Override
	public void onCreated(LandVehicle vehicleentity){
		Print.debug("EXISTS -> " + Static.sideString());
	}

	@Override
	public void onRemoved(LandVehicle vehicleentity){
		Print.debug("Removing...");
	}

	@Override
	public void onUpdate(LandVehicle vehicleentity){
		if(cooldown > 0){
			cooldown--;
		}
		if(cooldown > 0){
			return;
		}
		if(vehicleentity.world.isRemote && playerIsInVehicle(vehicleentity)){
			if(Keyboard.isKeyDown(Keyboard.KEY_L)){
				switch(getClientSeatId()){
					case 0:
						lf = !lf;
						sendDoorPacket(vehicleentity, "LeftFront", lf);
						break;
					case 1:
						rf = !rf;
						sendDoorPacket(vehicleentity, "RightFront", rf);
						break;
					case 2:
						lb = !lb;
						sendDoorPacket(vehicleentity, "LeftBack", lb);
						break;
					case 3:
						rb = !rb;
						sendDoorPacket(vehicleentity, "RightBack", rb);
						break;
					default:
						break;
				}
				cooldown = 3;
				Print.debugChat("L > Door");
			}
			else if(Keyboard.isKeyDown(Keyboard.KEY_O)){
				if(getClientSeatId() != 0){
					return;
				}
				front = !front;
				cooldown = 3;
				sendDoorPacket(vehicleentity, "Front", front);
				Print.debugChat("O > Front");
			}
			else if(Keyboard.isKeyDown(Keyboard.KEY_P)){
				if(getClientSeatId() != 0){
					return;
				}
				back = !back;
				cooldown = 3;
				sendDoorPacket(vehicleentity, "Back", back);
				Print.debugChat("P > Back");
			}
			else return;
		}
		//
	}

	@Override
	public boolean onInteract(LandVehicle landVehicle, EntityPlayer entityplayer){
		return false;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound nbt){
		nbt.setBoolean("Front", front);
		nbt.setBoolean("Back", back);
		nbt.setBoolean("LeftFront", lf);
		nbt.setBoolean("RightFront", rf);
		nbt.setBoolean("LeftBack", lb);
		nbt.setBoolean("RightBack", rb);
		return nbt;
	}

	@Override
	public void read(NBTTagCompound nbt){
		try{
			front = nbt.getBoolean("Front");
			back = nbt.getBoolean("Back");
			lf = nbt.getBoolean("LeftFront");
			rf = nbt.getBoolean("RightFront");
			lb = nbt.getBoolean("LeftBack");
			rb = nbt.getBoolean("RightBack");
		}
		catch(Exception e){
			//
		}
	}

	@Override
	public void onPacket(com.flansmod.fvm.LandVehicle landVehicle, NBTTagCompound packet, Side side){
		if(side.isServer()){
			this.sendPacketToAllAround(landVehicle, packet);
		}
		if(packet.hasKey("Front")){
			front = packet.getBoolean("Front");
		}
		if(packet.hasKey("Back")){
			back = packet.getBoolean("Back");
		}
		if(packet.hasKey("LeftFront")){
			lf = packet.getBoolean("LeftFront");
		}
		if(packet.hasKey("RightFront")){
			rf = packet.getBoolean("RightFront");
		}
		if(packet.hasKey("LeftBack")){
			lb = packet.getBoolean("LeftBack");
		}
		if(packet.hasKey("RightBack")){
			rb = packet.getBoolean("RightBack");
		}
	}

	public void sendDoorPacket(LandVehicle veh, String s, boolean b){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setBoolean(s, b);
		this.sendPacketToServer(veh, nbt);
	}
	
}