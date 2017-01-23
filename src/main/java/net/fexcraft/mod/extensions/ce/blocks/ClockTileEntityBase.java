package net.fexcraft.mod.extensions.ce.blocks;

import net.fexcraft.mod.extensions.ce.models.ModelClock1;
import net.fexcraft.mod.extensions.ce.util.ClockModelBase;
import net.fexcraft.mod.extensions.ce.util.ClockTimeType;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.client.model.ModelBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class ClockTileEntityBase extends TileEntity implements IPacketReceiver {
	
	private ClockModelBase model;
	private ClockTimeType timetype;
	private ResourceLocation texture;
	public int h, m, s;
	public int rs;
	
	public ClockTileEntityBase(){
		timetype = ClockTimeType.NULL;
		h = m = s = 0;
		model = new ModelClock1();
	}
	
	public ClockTileEntityBase(ClockTimeType type, ClockModelBase base, ResourceLocation rs, int render){
		timetype = type;
		texture = rs;
		h = m = s = 0;
		this.rs = render;
		model = base;
	}
	
	public ModelBase getModel(){
		return model;
	}
	
	public ResourceLocation getTexture(){
		return texture;
	}
	
	public ClockTimeType getType(){
		return timetype;
	}
	
	public void sendUpdatePacket(){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("type", timetype.toString());
		switch(timetype){
			case REAL_CUSTOM:
			case REAL_CUSTOM_REVERSE:
				nbt.setInteger("hour", h);
				nbt.setInteger("minute", m);
				nbt.setInteger("second", s);
			default:
				break;
		}
		nbt.setString("model", model.getName());
		ApiUtil.sendTileEntityUpdatePacket(world, pos, nbt, 64);
	}

	@Override
	public void processServerPacket(IPacket pkt) {
		//
	}

	@Override
	public void processClientPacket(IPacket pkt) {
		NBTTagCompound nbt = ((PacketTileEntityUpdate)pkt).nbt;
		timetype = ClockTimeType.fromString(nbt.getString("type"));
		if(nbt.hasKey("hour")){
			h = nbt.getInteger("hour");
			m = nbt.getInteger("minute");
			s = nbt.getInteger("second");
		}
		model = ClockModelBase.getModel(nbt.getString("model"));
	}
	
	@Override
	public NBTTagCompound getUpdateTag(){
		return this.writeToNBT(new NBTTagCompound());
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		return new SPacketUpdateTileEntity(this.getPos(), 2, this.writeToNBT(new NBTTagCompound()));
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
		this.readFromNBT(pkt.getNbtCompound());
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag){
		super.writeToNBT(tag);
		tag.setString("frsm_ce_timetype", timetype.toString());
		switch(timetype){
			case REAL_CUSTOM:
			case REAL_CUSTOM_REVERSE:
				tag.setInteger("frsm_ce_hour", h);
				tag.setInteger("frsm_ce_minute", m);
				tag.setInteger("frsm_ce_second", s);
			default:
				break;
		}
		tag.setString("frsm_ce_model", model.getName());
		return tag;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag){
		super.readFromNBT(tag);
		try{
			timetype = ClockTimeType.fromString(tag.getString("frsm_ce_timetype"));
			if(tag.hasKey("frsm_ce_hour")){
				h = tag.getInteger("frsm_ce_hour");
				m = tag.getInteger("frsm_ce_minute");
				s = tag.getInteger("frsm_ce_second");
			}
			model = ClockModelBase.getModel(tag.getString("frsm_ce_model"));
		}
		catch(Exception e){
			Print.debug(e.getMessage());
		}
	}

	public void reverseType(){
		switch(timetype){
			case MINECRAFT_WORLD:
				timetype = ClockTimeType.MINECRAFT_WORLD_REVERSE;
				break;
			case MINECRAFT_WORLD_REVERSE:
				timetype = ClockTimeType.MINECRAFT_WORLD;
				break;
			case REAL_CUSTOM:
				timetype = ClockTimeType.REAL_CUSTOM_REVERSE;
				break;
			case REAL_CUSTOM_REVERSE:
				timetype = ClockTimeType.REAL_CUSTOM;
				break;
			case REAL_SYSTEM:
				timetype = ClockTimeType.REAL_SYSTEM_REVERSE;
				break;
			case REAL_SYSTEM_REVERSE:
				timetype = ClockTimeType.REAL_SYSTEM;
				break;
			case NULL:
			default:
				break;
		}
	}
	
}