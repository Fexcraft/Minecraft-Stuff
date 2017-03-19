package net.fexcraft.mod.fvm.scripts;

import org.lwjgl.input.Keyboard;

import com.flansmod.common.RotatedAxes;
import com.flansmod.common.vector.Vector3f;
import com.flansmod.fvm.LandVehicle;

import net.fexcraft.mod.fvm.data.LoadedIn;
import net.fexcraft.mod.fvm.data.Script;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;

public class T1SnowPlowScript extends Script {
	
	private int cooldown;
	public boolean on = false;

	public T1SnowPlowScript(LoadedIn state){
		super(state);
	}

	@Override
	public String getId(){
		return "t1-snowplow";
	}

	@Override
	public void onCreated(LandVehicle vehicleentity){
		
	}

	@Override
	public void onRemoved(LandVehicle vehicleentity){
		
	}

	@Override
	public void onUpdate(LandVehicle vehicle){
		if(vehicle.world.isRemote){
			if(playerIsInVehicle(vehicle)){
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
	
	private static Vector3f calculate(LandVehicle vehicle, int i){
		Pos pos = new Pos(70, 4, i * 16);
		Vector3f loc = new Vector3f(pos.to16FloatX(), pos.to16FloatY(), pos.to16FloatZ());
		RotatedAxes yaw = new RotatedAxes(vehicle.seats[0].looking.getYaw(), 0F, 0F);
		Vector3f rotatedOffset = yaw.findLocalVectorGlobally(vehicle.seats[0].seatInfo.rotatedOffset);
		Vector3f.add(loc, new Vector3f(rotatedOffset.x, 0F, rotatedOffset.z), loc);
		Vector3f rel = vehicle.axes.findLocalVectorGlobally(loc);
		return new Vector3f(vehicle.posX + rel.x, vehicle.posY + rel.y, vehicle.posZ + rel.z);
	}

	@Override
	public boolean onInteract(LandVehicle landVehicle, EntityPlayer entityplayer){
		return false;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound nbt){
		nbt.setBoolean("On", on);
		return nbt;
	}

	@Override
	public void read(NBTTagCompound nbt){
		if(nbt.hasKey("On")){
			on = nbt.getBoolean("On");
		}
	}

	@Override
	public void onPacket(com.flansmod.fvm.LandVehicle landVehicle, NBTTagCompound packet, Side side){
		if(side.isServer()){
			this.sendPacketToAllAround(landVehicle, packet);
		}
		if(packet.hasKey("On")){
			on = packet.getBoolean("On");
		}
	}
	
}