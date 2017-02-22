package net.fexcraft.mod.fvm.entities;

import com.google.gson.JsonObject;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fvm.data.LoadedIn;
import net.fexcraft.mod.fvm.data.Seat;
import net.fexcraft.mod.fvm.data.VehicleType;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityLandVehicle extends Entity implements IEntityAdditionalSpawnData {
	
	public VehicleType data = null;
	
	public EntityLandVehicle(World worldIn){
		super(worldIn);
		this.setSize(1f, 1f);
		if(world.isRemote){
			setRenderDistanceWeight(256D);
		}
		
		data = FvmResources.getNewInstanceOf(LoadedIn.ENTITY, "T1");
		
	}

	public EntityLandVehicle(World worldIn, VehicleType type){
		super(worldIn);
		this.setSize(1f, 1f);
		if(world.isRemote){
			setRenderDistanceWeight(256D);
		}
		
		data = type;
		
	}

	@Override
	public void writeSpawnData(ByteBuf buffer){
		ByteBufUtils.writeUTF8String(buffer, data.toString());
	}

	@Override
	public void readSpawnData(ByteBuf additionalData){
		try{
			JsonObject obj = JsonUtil.getFromString(ByteBufUtils.readUTF8String(additionalData)).getAsJsonObject();
			data = new VehicleType(LoadedIn.ENTITY, obj);
			FvmResources.loadVehicleModel(data);
		}
		catch(Exception e){
			e.printStackTrace();
			Print.debug("Failed to receive additional spawn data for this vehicle!");
		}
	}

	@Override
	protected void entityInit(){
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		compound.getString("VehicleType");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		compound.setString("VehicleType", data.toString());
	}
	
	@Override
	public void onUpdate(){
		super.onUpdate();
		
		if(this.isBeingRidden()){
			this.setPosition(posX - 0.2, posY, posZ - 0.2);
		}
	}
	
	@Override
	public boolean processInitialInteract(EntityPlayer player, EnumHand hand){
		if(world.isRemote || hand == EnumHand.OFF_HAND){
			Print.debug("interact false");
			return false;
		}
		
		
		Print.debug("interact");
		player.startRiding(this, true);
		Print.chat(player, "mount");
		
		
		return super.processInitialInteract(player, hand);
	}
	
	@Override
	public boolean canBeCollidedWith(){
		return !isDead;
	}
	
	@Override
	public void updatePassenger(Entity passenger){
		if(this.isPassenger(passenger)){
			Seat s = data.seats.get(0);
            passenger.setPosition(this.posX + s.x(), this.posY + s.y(), this.posZ + s.z());
        }
		
	}
	
}