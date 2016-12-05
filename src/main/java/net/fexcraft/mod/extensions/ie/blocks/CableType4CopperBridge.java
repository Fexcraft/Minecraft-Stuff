package net.fexcraft.mod.extensions.ie.blocks;

import javax.annotation.Nullable;

import net.fexcraft.mod.extensions.ie.tileentities.CableType4CopperBridgeEntity;
import net.fexcraft.mod.extensions.ie.util.EFIO;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.api.tileentity.ICableTileEntity;
import net.fexcraft.mod.lib.util.cls.Print;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CableType4CopperBridge extends CableType4{

	public CableType4CopperBridge() {
		super();
	}

	@Override
	public String getName(){
		return "cabletype4_copper_bridge";
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new CableType4CopperBridgeEntity();
	}
	
	@Override
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		if(!w.isRemote && hand == EnumHand.MAIN_HAND){
			if(p.getHeldItemMainhand() == null){
				Print.chat(p, CCS.GRAY + ((ICableTileEntity)w.getTileEntity(pos)).fpu_get(side));
				CableType4CopperBridgeEntity te = (CableType4CopperBridgeEntity)w.getTileEntity(pos);
				for(EFIO e : te.getIO().get()){
					Print.chat(p, "----------");
					Print.chat(p, "F:   " + e.facing.getName() +" ||  I/O: " + e.io.getId());
				}
				((ICableTileEntity)w.getTileEntity(pos)).detectAndSendChanges(side);
			}
			if(p.getHeldItemMainhand() != null && p.getHeldItemMainhand().getItem() == Items.GOLD_INGOT){
				int i = ((CableType4CopperBridgeEntity)w.getTileEntity(pos)).getIO().get(p.getHorizontalFacing().getOpposite()).cthickness;
				Print.spam(1, i + "");
				switch(i){
					case 2:
						i = 4;
						break;
					case 4:
					case 0:
						i = 2;
						break;
				}
				((ICableTileEntity)w.getTileEntity(pos)).fpu_setInput(p.getHorizontalFacing().getOpposite(), i);
				Print.spam(1, i + "\n------");
				((ICableTileEntity)w.getTileEntity(pos)).detectAndSendChanges(side);
			}
			if(p.getHeldItemMainhand() != null && p.getHeldItemMainhand().getItem() == Items.IRON_INGOT){
				int i = ((CableType4CopperBridgeEntity)w.getTileEntity(pos)).getIO().get(p.getHorizontalFacing().getOpposite()).cthickness;
				switch(i){
					case 2:
						i = 4;
						break;
					case 4:
					case 0:
						i = 2;
						break;
				}
				((ICableTileEntity)w.getTileEntity(pos)).fpu_setOutput(p.getHorizontalFacing().getOpposite(), i);
				((ICableTileEntity)w.getTileEntity(pos)).detectAndSendChanges(side);
			}
			if(p.getHeldItemMainhand() != null && p.getHeldItemMainhand().getItem() == Items.DIAMOND){
				((CableType4CopperBridgeEntity)w.getTileEntity(pos)).resetFacing(p.getHorizontalFacing().getOpposite());
				((ICableTileEntity)w.getTileEntity(pos)).detectAndSendChanges(side);
			}
			return true;
		}
		else return false;
	}
}