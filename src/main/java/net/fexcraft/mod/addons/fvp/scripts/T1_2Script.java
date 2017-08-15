package net.fexcraft.mod.addons.fvp.scripts;

import org.lwjgl.input.Keyboard;

import net.fexcraft.mod.fvtm.api.LandVehicle;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleData;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleScript;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;

public class T1_2Script implements LandVehicle.LandVehicleScript {
	
	private int cooldown = 0;
	public boolean out = false;

	@Override
	public ResourceLocation getId(){
		return new ResourceLocation("fvp:t1-2type");
	}

	@Override
	public boolean isOn(Side side){
		return true;//works on both sides.
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setBoolean("Out", out);
		return compound;
	}

	@Override
	public LandVehicleScript readFromNBT(NBTTagCompound compound, boolean isRemote){
		if(compound.hasKey("Out")){
			out = compound.getBoolean("Out");
		}
		return this;
	}

	@Override
	public void onDataPacket(Entity entity, LandVehicleData data, NBTTagCompound compound, Side side){
		if(side.isServer()){
			this.sendPacketToAllAround(entity, compound);
		}
		out = compound.getBoolean("Out");
	}

	@Override
	public void onCreated(Entity entity, LandVehicleData data){
		//
	}

	@Override
	public void onRemove(Entity entity, LandVehicleData data){
		//
	}

	@Override
	public boolean onInteract(Entity entity, LandVehicleData data, EntityPlayer player){
		return false;
	}

	@Override
	public void onUpdate(Entity entity, LandVehicleData data) {
		if(entity.world.isRemote && LandVehicleScript.playerIsInVehicle((com.flansmod.fvtm.LandVehicle)entity)){
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
				this.sendPacketToServer(entity, nbt);
			}
		}
	}
	
}