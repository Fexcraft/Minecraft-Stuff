package net.fexcraft.mod.extensions.bge.tileentities;

import net.minecraft.tileentity.TileEntity;

public class BLK1TE extends TileEntity{
		
		/*private EnumColor color;
		
		public TE(){
			color = EnumColor.WHITE;
		}
		
		public EnumColor getColor(){
			return color;
		}
		
		@Override
		public NBTTagCompound getUpdateTag(){
			NBTTagCompound nbt = new NBTTagCompound();
			nbt = this.writeToNBT(nbt);
			return nbt;
		}

		@Override
		public SPacketUpdateTileEntity getUpdatePacket(){
			NBTTagCompound nbt = new NBTTagCompound();
			nbt = this.writeToNBT(nbt);
			return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), nbt);
		}
		
		@Override
		public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
			this.readFromNBT(pkt.getNbtCompound());
		}
		
		@Override
		public NBTTagCompound writeToNBT(NBTTagCompound compound){
			super.writeToNBT(compound);
			if(color != null){
				compound.setString("frsm_bge_color", color.toString());
			}
			return compound;
		}
		
		@Override
		public void readFromNBT(NBTTagCompound compound){
			super.readFromNBT(compound);
			color = EnumColor.fromString(compound.getString("frsm_bge_color"));
		}*/
}