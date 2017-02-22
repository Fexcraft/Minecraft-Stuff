package net.fexcraft.mod.fvm.blocks;

import net.fexcraft.mod.fvm.data.LoadedIn;
import net.fexcraft.mod.fvm.items.VehicleItem;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@fBlock(modid = FvmResources.MODID, name = "display_block", tileentity = DisplayBlockEntity.class)
public class DisplayBlock extends BlockContainer {

	public DisplayBlock(){
		super(Material.IRON, MapColor.SNOW);
		this.setCreativeTab(FvmResources.BLOCKS);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new DisplayBlockEntity();
	}
	
	@Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(w.isRemote || hand == EnumHand.OFF_HAND){
			return false;
		}
		DisplayBlockEntity te = (DisplayBlockEntity)w.getTileEntity(pos);
		if(te == null || te instanceof DisplayBlockEntity == false){
			return false;
		}
		if(!p.getHeldItemMainhand().isEmpty()){
			if(p.getHeldItemMainhand().getItem() instanceof VehicleItem){
				te.setType(FvmResources.getNewInstanceOf(LoadedIn.TILE, p.getHeldItemMainhand()));
				Print.chat(p, "Vehicle: " + ((VehicleItem)p.getHeldItemMainhand().getItem()).getType(p.getHeldItemMainhand()).registryname);
				p.getHeldItemMainhand().shrink(64);
				return true;
			}
		}
		else{
			te.rotate(p);
		}
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
	
}