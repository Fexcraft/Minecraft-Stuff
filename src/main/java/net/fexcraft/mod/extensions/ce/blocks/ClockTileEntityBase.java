package net.fexcraft.mod.extensions.ce.blocks;

import net.fexcraft.mod.extensions.ce.util.ClockTimeType;
import net.fexcraft.mod.frsm.blocks.clock.ModelClock1;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.cls.ApiUtil;
import net.fexcraft.mod.lib.util.cls.Static;
import net.minecraft.client.model.ModelBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class ClockTileEntityBase extends TileEntity implements IPacketReceiver {
	
	private ModelBase model;
	private ClockTimeType timetype;
	private ResourceLocation texture;
	public int h, m, s;
	public int rs;
	
	public ClockTileEntityBase(){
		timetype = ClockTimeType.NULL;
		h = m = s = 0;
		model = new ModelClock1();
	}
	
	public ClockTileEntityBase(ClockTimeType type, ModelBase base, ResourceLocation rs, int render){
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
	
	public void updateClient(){
		if(!Static.side().isClient()){
			ApiUtil.sendTileEntityUpdatePacket(world, pos, this.writeToNBT(new NBTTagCompound()), 64);
		}
	}

	@Override
	public void processServerPacket(IPacket pkt) {
		//
	}

	@Override
	public void processClientPacket(IPacket pkt) {
		this.readFromNBT(((PacketTileEntityUpdate)pkt).nbt);
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
				tag.setIntArray("frsm_ce_offset", new int[]{h, m, s});
			default:
				break;
		}
		return tag;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag){
		super.readFromNBT(tag);
		timetype.fromString(tag.getString("frsm_ce_timetype"));
		if(tag.hasKey("frsm_ce_offset")){
			int[] offsets = tag.getIntArray("frsm_ce_offset");
			h = offsets[0];
			m = offsets[1];
			s = offsets[2];
		}
	}
	
}