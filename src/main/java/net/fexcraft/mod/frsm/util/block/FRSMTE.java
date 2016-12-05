package net.fexcraft.mod.frsm.util.block;

import net.minecraft.tileentity.TileEntity;

public class FRSMTE extends TileEntity {
	
	/*private HashSet<INT> types = new HashSet<INT>();
	
	static class INT{
		public String id;
		public int value;
		public INT(String id, int value){
			this.id = id;
			this.value = value;
		}
	}
	
	public FRSMTE(){
		if(FI.TEMT){
			types.add(new INT("scale_x", 0));
			types.add(new INT("scale_y", 0));
			types.add(new INT("scale_z", 0));
			types.add(new INT("translate_x", 0));
			types.add(new INT("translate_y", 0));
			types.add(new INT("translate_z", 0));
			types.add(new INT("rotation_x", 0));
			types.add(new INT("rotation_y", 0));
			types.add(new INT("rotation_z", 0));
		}
	}
	
	public int getTemtValue(String string){
		int result = 0;
		for(INT i : types){
			if(i.id.equals(string)){
				result = i.value;
				break;
			}
		}
		return result;
	}
	
	@Override
	public void processServerPacket(IPacket pkt) {
		//
	}
	
	@Override
	public void processClientPacket(IPacket pkt) {
		PacketTileEntityUpdate packet = (PacketTileEntityUpdate)pkt;
		if(packet.nbt.hasKey("temt_packet") && !types.isEmpty()){
			PrintLog.print("DEBUG", "PACKET RECEIVED");
			String mode = packet.nbt.getString("temt_mode");
			String type = packet.nbt.getString("temt_type");
			int amount = packet.nbt.getInteger("temt_amount");
			switch(mode){
				case "add":
					for(INT i : types){
						if(i.id.equals(type)){
							i.value += amount;
							break;
						}
					}
				case "remove":
					for(INT i : types){
						if(i.id.equals(type)){
							i.value -= amount;
							break;
						}
					}
				case "set":
					for(INT i : types){
						if(i.id.equals(type)){
							i.value = amount;
							break;
						}
					}
				default:
					for(INT i : types){
						if(i.id.equals(type)){
							i.value = 0;
							break;
						}
					}
			}
		}
	}
	
	@Override
	public NBTTagCompound getUpdateTag(){
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), nbt);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
		this.readFromNBT(pkt.getNbtCompound());
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		if(!types.isEmpty()){
			for(INT i : types){
				i.value = nbt.getInteger("frsm_" + i.id);
			}
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		if(!types.isEmpty()){
			for(INT i : types){
				nbt.setInteger("frsm_" + i.id, i.value);
			}
		}
		return nbt;
	}

	public HashSet<INT> getTemtTypes(){
		return types;
	}*/
	
}