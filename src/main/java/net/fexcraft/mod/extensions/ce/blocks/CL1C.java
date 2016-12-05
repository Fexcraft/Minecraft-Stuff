package net.fexcraft.mod.extensions.ce.blocks;

import net.fexcraft.mod.extensions.ce.blocks.CE_Blocks.Calendar1C.TECL;
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

public class CL1C{
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
	        		case 2:
	        		case 3:
	        			PrintChat.print(p, "Error, this mode isn't applicable for CE Calendars.");
	        			break;
	        		case 4:
	        			int m1 = w.getTileEntity(pos).getTileData().getInteger("frsm_ce_month");
	        			int d = w.getTileEntity(pos).getTileData().getInteger("frsm_ce_day");d++;
	        			if(m1 == 1){
	        				if(d > 28){
	        					d = 1;
	        				}
	        			}
	        			if(m1 == 0 || m1 == 2 || m1 == 4 || m1 == 6 || m1 == 7 || m1 == 9 || m1 == 11){
	        				if(d > 31){
	        					d = 1;
	        				}
	        			}
	        			if(m1 == 3 || m1 == 5 || m1 == 8 || m1 == 10){
	        				if(d > 30){
	        					d = 1;
	        				}
	        			}
	        			w.getTileEntity(pos).getTileData().setInteger("frsm_ce_day", d);
	        			//PrintChat.printIn(p, "D: " + d);
	        			break;
	        		case 5:
	        			int m = w.getTileEntity(pos).getTileData().getInteger("frsm_ce_month");
	        			if(m >  11){m = m - 12;}
	        			if(m <  12){m++;}
	        			if(m == 12){m=0;}
	        			w.getTileEntity(pos).getTileData().setInteger("frsm_ce_month", m);
	        			//PrintChat.printIn(p, "M: " + (m + 1));
	        			break;
	        		default: PrintChat.print(p, CCS.RED + "Error.");
	        	}
	    		//w.markBlockForUpdate(pos);
		    	int D3 = w.getTileEntity(pos).getTileData().getInteger("frsm_ce_day");
				int M3 = w.getTileEntity(pos).getTileData().getInteger("frsm_ce_month");
				String D = CCS.AQUA + D3;
				String M = CCS.AQUA + (M3 + 1);
				PrintChat.print((EntityPlayer)p, CCS.DPURPLE + "M: " + M + CCS.DPURPLE + ", D: " + D);
	    	}
		}
    	//w.markBlockForUpdate(pos);
    	//int d = w.getTileEntity(pos).getTileData().getInteger("frsm_ce_day");
		//int m = w.getTileEntity(pos).getTileData().getInteger("frsm_ce_month");
    	//PrintLog.printIn("RENDER: ", "M:" + m + " (" + (m + 1) + "), D: " + d);
		return true;
	}
	
	public static void onBlockPlacedBy(World w, BlockPos pos, IBlockState state, EntityLivingBase p, ItemStack stack){
		if(!w.isRemote){
			if(w.getTileEntity(pos) != null){
				int d = w.getTileEntity(pos).getTileData().getInteger("frsm_ce_day");
				int m = w.getTileEntity(pos).getTileData().getInteger("frsm_ce_month");
				PrintChat.print((EntityPlayer)p, "M:" + (m + 1) + ", D:" + d);
				((TECL)w.getTileEntity(pos)).getUpdatePacket();
			}
		}
	}
}