package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class ConstructorCenterEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {
	
	private ConstructorControllerEntity.Client link = null;
	private final int offset = 24;
	private final int length = 4;
	public BlockPos constructor;

	public void link(BlockPos pos){
		//TODO
	}
	
	public int getLength(){
		if(link != null && link.vehicledata != null){
			return link.vehicledata.getVehicle().getConstructionLength();
		}
		return length;
	}
	
	public int getRenderLength(){
		if(link != null && link.vehicledata != null){
			return (link.vehicledata.getVehicle().getConstructionLength() * 2) + 1;
		}
		return (length * 2) + 1;
	}
	
	public float getRenderOffset(){
		if(link != null && link.vehicledata != null){
			return link.vehicledata.getVehicle().getWheelConstructorOffset() * 0.0625f;
		}
		return offset * 0.0625f;
	}
	
	public ConstructorControllerEntity.Client getLink(){
		return link;
	}
	
}