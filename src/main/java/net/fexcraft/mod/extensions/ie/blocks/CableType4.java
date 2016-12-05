package net.fexcraft.mod.extensions.ie.blocks;

import javax.annotation.Nullable;

import net.fexcraft.mod.extensions.ie.tileentities.CableType4Entity;
import net.fexcraft.mod.extensions.ie.util.EFIO;
import net.fexcraft.mod.extensions.ie.util.Static;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.api.block.IMashineBlock;
import net.fexcraft.mod.lib.api.tileentity.ICableTileEntity;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.fexcraft.mod.lib.util.cls.EnumMashineType;
import net.fexcraft.mod.lib.util.cls.Print;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CableType4 extends BlockContainer implements IMashineBlock {

	public CableType4() {
		super(Material.IRON);
		BlockUtil.register(Static.MODID, this);
		BlockUtil.registerFIB(this);
		BlockUtil.registerFIBRender(this);
	}

	@Override
	public boolean isMashine(){
		return false;
	}
	
	@Override
	public boolean isFullyOpaque(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state){
        return false;
    }
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
        return false;
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
    }

	@Override
	public String getName(){
		return "cabletype4";
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}

	@Override
	public EnumMashineType getMashineType(){
		return EnumMashineType.TRANSPORT;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new CableType4Entity();
	}
	
	@Override
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		if(!w.isRemote && hand == EnumHand.MAIN_HAND){
			if(p.getHeldItemMainhand() == null){
				Print.chat(p, CCS.GRAY + ((ICableTileEntity)w.getTileEntity(pos)).fpu_get(side));
				CableType4Entity te = (CableType4Entity)w.getTileEntity(pos);
				for(EFIO e : te.getIO().get()){
					Print.chat(p, "----------");
					Print.chat(p, "F:   " + e.facing.getName() +" ||  I/O: " + e.io.getId());
				}
				((ICableTileEntity)w.getTileEntity(pos)).detectAndSendChanges(side);
			}
			if(p.getHeldItemMainhand() != null && p.getHeldItemMainhand().getItem() == Items.GOLD_INGOT){
				int i = ((CableType4Entity)w.getTileEntity(pos)).getIO().get(p.getHorizontalFacing().getOpposite()).cthickness;
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
				int i = ((CableType4Entity)w.getTileEntity(pos)).getIO().get(p.getHorizontalFacing().getOpposite()).cthickness;
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
				((CableType4Entity)w.getTileEntity(pos)).resetFacing(p.getHorizontalFacing().getOpposite());
				((ICableTileEntity)w.getTileEntity(pos)).detectAndSendChanges(side);
			}
			return true;
		}
		else return false;
	}
	
}