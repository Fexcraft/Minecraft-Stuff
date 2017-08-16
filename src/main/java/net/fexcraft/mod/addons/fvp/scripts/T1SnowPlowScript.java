package net.fexcraft.mod.addons.fvp.scripts;

import org.lwjgl.input.Keyboard;

import com.flansmod.common.RotatedAxes;
import com.flansmod.common.vector.Vector3f;
import com.flansmod.fvtm.LandVehicle;

import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleData;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleScript;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;

public class T1SnowPlowScript implements LandVehicleScript {
	
	private int cooldown;
	public boolean on = false;

	@Override
	public ResourceLocation getId(){
		return new ResourceLocation("fvp:t1snowplowscript");
	}

	@Override
	public boolean isOn(Side side){
		return true;//is on both sides active
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		compound.setBoolean(this.getId().toString() + "_On", on);
		return compound;
	}

	@Override
	public LandVehicleScript readFromNBT(NBTTagCompound compound, boolean isRemote) {
		if(compound.hasKey(this.getId().toString() + "_On")){
			on = compound.getBoolean(this.getId().toString() + "_On");
		}
		return this;
	}

	@Override
	public void onDataPacket(Entity entity, LandVehicleData data, NBTTagCompound compound, Side side) {
		if(side.isServer()){
			this.sendPacketToAllAround(entity, compound);
		}
		if(compound.hasKey("On")){
			on = compound.getBoolean("On");
		}
	}

	@Override
	public void onCreated(Entity entity, LandVehicleData data){
		return;
	}

	@Override
	public boolean onInteract(Entity entity, LandVehicleData data, EntityPlayer player){
		return false;
	}

	@Override
	public void onUpdate(Entity entity, LandVehicleData data){
		com.flansmod.fvtm.LandVehicle vehicle = (LandVehicle) entity;
		if(vehicle.world.isRemote){
			if(LandVehicleScript.playerIsInVehicle(vehicle)){
				if(cooldown > 0){
					cooldown--;
				}
				if(cooldown > 0){
					return;
				}
				if(Keyboard.isKeyDown(Keyboard.KEY_F) && !FMLClientHandler.instance().isGUIOpen(GuiContainer.class)){
					cooldown = 4;
					on = !on;
					Print.debugChat("Snow Plow " + (on ? "enabled" : "disabled") + ".");
					NBTTagCompound nbt = new NBTTagCompound();
					nbt.setBoolean("On", on);
					this.sendPacketToServer(vehicle, nbt);
				}
			}
		}
		else{
			if(on){
				Vector3f[] pos = new Vector3f[6];
				pos[0] = calculate(vehicle,  2);
				pos[1] = calculate(vehicle,  1);
				pos[2] = calculate(vehicle,  0);
				pos[3] = calculate(vehicle, -1);
				pos[4] = calculate(vehicle, -2);
				pos[5] = calculate(vehicle,  3);
				IBlockState[] states = new IBlockState[6];
				int j = 0;
				for(int i = 0; i < 6; i++){
					BlockPos poss = new BlockPos(pos[i].toVec3());
					states[i] = vehicle.world.getBlockState(poss);
					if(i < 5){
						if(states[i].getMaterial() == Material.SNOW){
							vehicle.world.setBlockState(new BlockPos(poss), Blocks.AIR.getDefaultState(), 2);
							j++;
						}
						else if(states[i].getMaterial().isReplaceable() || states[i].getMaterial() == Material.CACTUS || states[i].getMaterial() == Material.CIRCUITS){
							vehicle.world.setBlockState(new BlockPos(poss), Blocks.AIR.getDefaultState(), 2);
						}
					}
					if(i == 5 && j > 0 && states[i].getMaterial().isReplaceable()){
						vehicle.world.setBlockState(poss, Blocks.SNOW_LAYER.getDefaultState().withProperty(BlockSnow.LAYERS, j), 2);
					}
				}
			}
			else{
				//
			}
		}
	}
	
	private static final Vector3f calculate(com.flansmod.fvtm.LandVehicle vehicle, int i){
		Pos pos = new Pos(70, 4, i * 16);
		Vector3f loc = new Vector3f(pos.to16FloatX(), pos.to16FloatY(), pos.to16FloatZ());
		RotatedAxes yaw = new RotatedAxes(vehicle.seats[0].looking.getYaw(), 0F, 0F);
		Vector3f rotatedOffset = yaw.findLocalVectorGlobally(vehicle.seats[0].seatInfo.rotatedOffset);
		Vector3f.add(loc, new Vector3f(rotatedOffset.x, 0F, rotatedOffset.z), loc);
		Vector3f rel = vehicle.axes.findLocalVectorGlobally(loc);
		return new Vector3f(vehicle.posX + rel.x, vehicle.posY + rel.y, vehicle.posZ + rel.z);
	}

	@Override
	public void onRemove(Entity entity, LandVehicleData data){
		//
	}
	
}