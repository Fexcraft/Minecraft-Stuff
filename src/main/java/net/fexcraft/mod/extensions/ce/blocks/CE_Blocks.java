package net.fexcraft.mod.extensions.ce.blocks;

import java.util.List;

import net.fexcraft.mod.frsm.util.text.CCS;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class CE_Blocks{
	
	public static Block Clock_2;
	public static Block Calendar_1;
	public static Block Clock_1C;
	public static Block Clock_2C;
	public static Block Calendar_1C;
	public static Block Clock_3W;
	public static Block Clock_3B;
	
	public static void init(){
		Clock_2 = new Clock2("Clock2", "SYSTEM TIME");
		Calendar_1 = new Calendar1("Calendar1", "SYSTEM TIME");
		Clock_1C = new Clock1C("Clock1C", "CUSTOM TIME");
		Clock_2C = new Clock2C("Clock2C", "CUSTOM TIME");
		Calendar_1C = new Calendar1C("Calendar1C","CUSTOM TIME");
		Clock_3W = new Clock3_W("Clock3_W", "SYSTEM TIME");
		Clock_3B = new Clock3_B("Clock3_B", "SYSTEM TIME");
	}
	
	
	public static class Clock2 extends CEBBC{
		private static String info;
		public Clock2(String name, String info) {super(name); this.info = info;}
		@Override public TileEntity createNewTileEntity(World worldIn, int meta) {return new TE();}
		public static class TE extends TileEntity{}
		public static class C2I extends ItemBlock{
			public C2I(Block block){super(block);}
			@Override public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4){par3.add(CCS.GRAY + info);}
		}
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
	public static class Clock1C extends CEBB{
		private static String info;
		public Clock1C(String name, String info) {super(name); this.info = info;}
		@Override public TileEntity createNewTileEntity(World worldIn, int meta) {return new TEC();}
		public static class TEC extends TileEntity{
			@Override
			public SPacketUpdateTileEntity getUpdatePacket(){
				NBTTagCompound syncData = new NBTTagCompound();
				int h = this.getTileData().getInteger("frsm_ce_hour");
				int m = this.getTileData().getInteger("frsm_ce_minute");
				int s = this.getTileData().getInteger("frsm_ce_second");
				syncData.setInteger("frsm_ce_hour", h);
				syncData.setInteger("frsm_ce_minute", m);
				syncData.setInteger("frsm_ce_second", s);
				//PrintLog.printIn("CE Packet", "Sent!");
				return new SPacketUpdateTileEntity(this.getPos(), 2, syncData);
			}
			@Override
			public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
				int h = pkt.getNbtCompound().getInteger("frsm_ce_hour");
				int m = pkt.getNbtCompound().getInteger("frsm_ce_minute");
				int s = pkt.getNbtCompound().getInteger("frsm_ce_second");
				this.getWorld().getTileEntity(this.getPos()).getTileData().setInteger("frsm_ce_hour", h);
				this.getWorld().getTileEntity(this.getPos()).getTileData().setInteger("frsm_ce_minute", m);
				this.getWorld().getTileEntity(this.getPos()).getTileData().setInteger("frsm_ce_second", s);
				//PrintLog.printIn("CE Packet", "Received!");
			}
		}
		@Override
		public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
	    	return C1C.onBlockActivated(w, pos, state, p, side, hitX, hitY, hitZ);
		}
		public void onBlockPlacedBy(World w, BlockPos pos, IBlockState state, EntityLivingBase p, ItemStack stack){
			C1C.onBlockPlacedBy(w, pos, state, p, stack);
		}
		public static class C1CI extends ItemBlock{
			public C1CI(Block block){super(block);}
			@Override public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4){par3.add(CCS.GRAY + info);}
		}
	}
	public static class Clock2C extends CEBBC{
		private static String info;
		public Clock2C(String name, String info) {super(name); this.info = info;}
		@Override public TileEntity createNewTileEntity(World worldIn, int meta) {return new TEC();}
		public static class TEC extends TileEntity{
			@Override
			public SPacketUpdateTileEntity getUpdatePacket(){
				NBTTagCompound syncData = new NBTTagCompound();
				int h = this.getTileData().getInteger("frsm_ce_hour");
				int m = this.getTileData().getInteger("frsm_ce_minute");
				int s = this.getTileData().getInteger("frsm_ce_second");
				syncData.setInteger("frsm_ce_hour", h);
				syncData.setInteger("frsm_ce_minute", m);
				syncData.setInteger("frsm_ce_second", s);
				//PrintLog.printIn("CE Packet", "Sent!");
				return new SPacketUpdateTileEntity(this.getPos(), 2, syncData);
			}
			@Override
			public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
				int h = pkt.getNbtCompound().getInteger("frsm_ce_hour");
				int m = pkt.getNbtCompound().getInteger("frsm_ce_minute");
				int s = pkt.getNbtCompound().getInteger("frsm_ce_second");
				this.getWorld().getTileEntity(this.getPos()).getTileData().setInteger("frsm_ce_hour", h);
				this.getWorld().getTileEntity(this.getPos()).getTileData().setInteger("frsm_ce_minute", m);
				this.getWorld().getTileEntity(this.getPos()).getTileData().setInteger("frsm_ce_second", s);
				//PrintLog.printIn("CE Packet", "Received!");
			}
		}
		@Override
		public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
	    	return C1C.onBlockActivated(w, pos, state, p, side, hitX, hitY, hitZ);
		}
		public void onBlockPlacedBy(World w, BlockPos pos, IBlockState state, EntityLivingBase p, ItemStack stack){
			C1C.onBlockPlacedBy(w, pos, state, p, stack);
		}
		public static class C2CI extends ItemBlock{
			public C2CI(Block block){super(block);}
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
				//PrintLog.printIn("CE Packet", "Sent!");
				return new SPacketUpdateTileEntity(this.getPos(), 2, syncData);
			}
			@Override
			public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
				int d = pkt.getNbtCompound().getInteger("frsm_ce_day");
				int m = pkt.getNbtCompound().getInteger("frsm_ce_month");
				this.getWorld().getTileEntity(this.getPos()).getTileData().setInteger("frsm_ce_day", d);
				this.getWorld().getTileEntity(this.getPos()).getTileData().setInteger("frsm_ce_month", m);
				//PrintLog.printIn("CE Packet", "Received!");
			}
		}
		@Override
		public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
	    	return CL1C.onBlockActivated(w, pos, state, p, side, hitX, hitY, hitZ);
		}
		public void onBlockPlacedBy(World w, BlockPos pos, IBlockState state, EntityLivingBase p, ItemStack stack){
			CL1C.onBlockPlacedBy(w, pos, state, p, stack);
		}
		public static class CL1CI extends ItemBlock{
			public CL1CI(Block block){super(block);}
			@Override public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4){par3.add(CCS.GRAY + info);}
		}
	}
	public static class Clock3_W extends CEBB{
		private static String info;
		public Clock3_W(String name, String info) {super(name); this.info = info;}
		@Override public TileEntity createNewTileEntity(World worldIn, int meta) {return new TE();}
		public static class TE extends TileEntity{}
		public static class C3I extends ItemBlock{
			public C3I(Block block){super(block);}
			@Override public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4){par3.add(CCS.GRAY + info);}
		}
	}
	public static class Clock3_B extends CEBB{
		private static String info;
		public Clock3_B(String name, String info) {super(name); this.info = info;}
		@Override public TileEntity createNewTileEntity(World worldIn, int meta) {return new TE();}
		public static class TE extends TileEntity{}
		public static class C3I extends ItemBlock{
			public C3I(Block block){super(block);}
			@Override public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4){par3.add(CCS.GRAY + info);}
		}
	}
	//
}