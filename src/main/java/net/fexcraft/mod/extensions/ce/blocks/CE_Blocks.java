package net.fexcraft.mod.extensions.ce.blocks;

import java.util.List;

import net.fexcraft.mod.extensions.ce.models.ModelClock1;
import net.fexcraft.mod.extensions.ce.models.ModelClock2;
import net.fexcraft.mod.extensions.ce.models.ModelClock3;
import net.fexcraft.mod.extensions.ce.util.ClockTimeType;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public final class CE_Blocks{
	
	public static Block Clock_2;
	public static Block Calendar_1;
	public static Block Clock_1C;
	public static Block Clock_2C;
	public static Block Calendar_1C;
	public static Block Clock_3W;
	public static Block Clock_3B;
	
	public static void register(){
		Calendar_1 = new Calendar1("Calendar1", "SYSTEM TIME");
		Calendar_1C = new Calendar1C("Calendar1C","CUSTOM TIME");
		
		Clock_1C = new ClockBlockBase("clock1c", ClockTimeType.REAL_CUSTOM, "frsm:textures/blocks/clock1.png", new ModelClock1(), true, 1, "Custom Time");
		Clock_2 = new ClockBlockBase("clock2", ClockTimeType.REAL_SYSTEM, "frsm:textures/blocks/clock1.png", new ModelClock2(), false, 2, "System Time");
		Clock_2C = new ClockBlockBase("clock2c", ClockTimeType.REAL_CUSTOM, "frsm:textures/blocks/clock1.png", new ModelClock2(), false, 2, "Custom Time");
		Clock_3W = new ClockBlockBase("clock3_w", ClockTimeType.REAL_SYSTEM, "frsm_ce:textures/blocks/clock3_w.png", new ModelClock3(), true, 1, "System Time");
		Clock_3B = new ClockBlockBase("clock3_b", ClockTimeType.REAL_SYSTEM, "frsm_ce:textures/blocks/clock3_b.png", new ModelClock3(), true, 1, "System Time");
	}
	
	
	public static class Calendar1 extends CEBB{
		private static String info;
		public Calendar1(String name, String info) {super(name); this.info = info;}
		@Override public TileEntity createNewTileEntity(World worldIn, int meta) {return new TE();}
		public static class TE extends TileEntity{}
		public static class CL1I extends ItemBlock{
			public CL1I(Block block){super(block);}
			@Override public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4){par3.add(CCS.GRAY + info);}
		}
	}
	public static class Calendar1C extends CEBB{
		private static String info;
		public Calendar1C(String name, String info) {super(name); this.info = info;}
		@Override public TileEntity createNewTileEntity(World worldIn, int meta) {return new TECL();}
		public static class TECL extends TileEntity{
			@Override
			public SPacketUpdateTileEntity getUpdatePacket(){
				NBTTagCompound syncData = new NBTTagCompound();
				int d = this.getTileData().getInteger("frsm_ce_day");
				int m = this.getTileData().getInteger("frsm_ce_month");
				syncData.setInteger("frsm_ce_day", d);
				syncData.setInteger("frsm_ce_month", m);
				return new SPacketUpdateTileEntity(this.getPos(), 2, syncData);
			}
			@Override
			public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
				int d = pkt.getNbtCompound().getInteger("frsm_ce_day");
				int m = pkt.getNbtCompound().getInteger("frsm_ce_month");
				this.getWorld().getTileEntity(this.getPos()).getTileData().setInteger("frsm_ce_day", d);
				this.getWorld().getTileEntity(this.getPos()).getTileData().setInteger("frsm_ce_month", m);
			}
		}
	}
}