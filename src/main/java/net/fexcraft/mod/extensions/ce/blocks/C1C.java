package net.fexcraft.mod.extensions.ce.blocks;

import net.fexcraft.mod.extensions.ce.blocks.CE_Blocks.Clock1C.TEC;
import net.fexcraft.mod.extensions.ce.items.CE_Items;
import net.fexcraft.mod.frsm.util.PrintChat;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.network.Network;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class C1C{
	public static boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(!w.isRemote && Network.isDonator(p)){
			if(w.getTileEntity(pos) != null){
	    		int i = 0;
	    		if(p.getHeldItemMainhand() != null && p.getHeldItemMainhand().getItem() == CE_Items.universal_tool){
	    			ItemStack is = p.getHeldItemMainhand().copy();
	    			i = is.getTagCompound().getInteger("frsm_ce_mode");
	    		}
	        	switch(i){
	        		case 0:
	        			PrintChat.print(p, "Wrong Item or no mode selected.");
	        			break;
	        		case 1:
	        			int h = w.getTileEntity(pos).getTileData().getInteger("frsm_ce_hour");
	        			if(h  < 24){h++;}
	        			if(h == 24){h=0;}
	        			w.getTileEntity(pos).getTileData().setInteger("frsm_ce_hour", h);
	        			//PrintChat.printIn(p, "H: " + h);
	        			break;
	        		case 2:
	        			int m = w.getTileEntity(pos).getTileData().getInteger("frsm_ce_minute");
	        			if(m  < 60){m++;}
	        			if(m == 60){m=0;}
	        			w.getTileEntity(pos).getTileData().setInteger("frsm_ce_minute", m);
	        			//PrintChat.printIn(p, "M: " + m);
	        			break;
	        		case 3:
	        			int s = w.getTileEntity(pos).getTileData().getInteger("frsm_ce_second");
	        			if(s  < 60){s++;}
	        			if(s == 60){s=0;}
	        			w.getTileEntity(pos).getTileData().setInteger("frsm_ce_second", s);
	        			//PrintChat.printIn(p, "S: " + s);
	        			break;
	        		case 4:
	        		case 5:
	        			PrintChat.print(p, "Error, this mode isn't applicable for CE Clocks.");
	        			break;
	        		default: PrintChat.print(p, CCS.RED + "Error.");
	        	}
	    		//w.markBlockForUpdate(pos);
		    	int h = w.getTileEntity(pos).getTileData().getInteger("frsm_ce_hour");
				int m = w.getTileEntity(pos).getTileData().getInteger("frsm_ce_minute");
				int s = w.getTileEntity(pos).getTileData().getInteger("frsm_ce_second");
				String H = CCS.AQUA + h;
				String M = CCS.AQUA + m;
				String S = CCS.AQUA + s;
				PrintChat.print((EntityPlayer)p, CCS.DPURPLE + "H: " + H + CCS.DPURPLE + ", M: " + M + CCS.DPURPLE + ", S: " + S);
	    	}
		}
		return true;
	}
	
	public static void onBlockPlacedBy(World w, BlockPos pos, IBlockState state, EntityLivingBase p, ItemStack stack){
		if(!w.isRemote){
			if(w.getTileEntity(pos) != null){
				int h = w.getTileEntity(pos).getTileData().getInteger("frsm_ce_hour");
				int m = w.getTileEntity(pos).getTileData().getInteger("frsm_ce_minute");
				int s = w.getTileEntity(pos).getTileData().getInteger("frsm_ce_second");
				PrintChat.print((EntityPlayer)p, "H:" + h + ", M:" + m + ", S:" + s);
				((TEC)w.getTileEntity(pos)).getUpdatePacket();
			}
		}
	}
}