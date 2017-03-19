package net.fexcraft.mod.fvm.scripts;

import org.lwjgl.input.Keyboard;

import com.flansmod.fvm.LandVehicle;

import net.fexcraft.mod.fvm.data.LoadedIn;
import net.fexcraft.mod.fvm.data.Script;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;

public class T1_2Script extends Script {
	
	private int cooldown = 0;
	public boolean out = false;

	public T1_2Script(LoadedIn state){
		super(state);
	}

	@Override
	public String getId(){
		return "t1-2type";
	}

	@Override
	public void onCreated(LandVehicle vehicleentity){
		//
	}

	@Override
	public void onRemoved(LandVehicle vehicleentity){
		//
	}

	@Override
	public void onUpdate(LandVehicle vehicleentity){
		if(vehicleentity.world.isRemote && playerIsInVehicle(vehicleentity)){
			if(cooldown > 0){
				cooldown--;
			}
			if(cooldown > 0){
				return;
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_L) && !FMLClientHandler.instance().isGUIOpen(GuiContainer.class)){
				cooldown = 4;
				out = !out;
				Print.debugChat(out ? "Out" : "In");
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setBoolean("Out", out);
				this.sendPacketToServer(vehicleentity, nbt);
			}
		}
		
	}

	@Override
	public boolean onInteract(LandVehicle landVehicle, EntityPlayer entityplayer){
		return false;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound nbt){
		nbt.setBoolean("Out", out);
		return nbt;
	}

	@Override
	public void read(NBTTagCompound nbt){
		if(nbt.hasKey("Out")){
			out = nbt.getBoolean("Out");
		}
	}

	@Override
	public void onPacket(com.flansmod.fvm.LandVehicle landVehicle, NBTTagCompound packet, Side side){
		if(side.isServer()){
			this.sendPacketToAllAround(landVehicle, packet);
		}
		out = packet.getBoolean("Out");
	}
	
}