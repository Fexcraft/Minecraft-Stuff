package net.fexcraft.mod.fvm.blocks;

import net.fexcraft.mod.fvm.FVM;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@fBlock(modid = FvmResources.MODID, name = "paint_table", tileentity = PaintTableEntity.class)
public class PaintTable extends BlockContainer {

	public PaintTable(){
		super(Material.IRON, MapColor.SNOW);
    	this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    	this.setCreativeTab(FvmResources.BLOCKS);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new PaintTableEntity();
	}
	
	@Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(w.isRemote || hand == EnumHand.OFF_HAND){
			return false;
		}
		PaintTableEntity te = (PaintTableEntity)w.getTileEntity(pos);
		if(te == null){
			return false;
		}
		if(te.getFacing() == null || te.getFacing() == EnumFacing.UP){
			if(scan(te, w, pos, p)){
				Print.chat(p, "Controller found.");
			}
			else{
				Print.chat(p, "No Controller found.");
			}
			return true;
		}
		if(w.getTileEntity(te.getPos().add(te.getFacing().getDirectionVec())) == null){
			Print.chat(p, "No Controller found.");
			return true;
		}
		if(((ConstructorControllerEntity)w.getTileEntity(te.getPos().add(te.getFacing().getDirectionVec()))).isTypeNull()){
			Print.chat(p, "No Type in Controller.");
			return true;
		}
		p.openGui(FVM.INSTANCE, 12, w, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}

	private boolean scan(PaintTableEntity te, World w, BlockPos pos, EntityPlayer p){
		Print.chat(p, "Scanning...");
		if(w.getTileEntity(pos.north()) != null && w.getTileEntity(pos.north()) instanceof ConstructorControllerEntity){
			te.setFacing(EnumFacing.NORTH);
			return true;
		}
		if(w.getTileEntity(pos.west()) != null && w.getTileEntity(pos.west()) instanceof ConstructorControllerEntity){
			te.setFacing(EnumFacing.WEST);
			return true;
		}
		if(w.getTileEntity(pos.east()) != null && w.getTileEntity(pos.east()) instanceof ConstructorControllerEntity){
			te.setFacing(EnumFacing.EAST);
			return true;
		}
		if(w.getTileEntity(pos.south()) != null && w.getTileEntity(pos.south()) instanceof ConstructorControllerEntity){
			te.setFacing(EnumFacing.SOUTH);
			return true;
		}
		return false;
	}
	
	//================================== > VANILLA
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    @Override
	public boolean isFullyOpaque(IBlockState state){
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
        return FULL_BLOCK_AABB;
    }
	
	@Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState blockState, World worldIn, BlockPos pos){
        return FULL_BLOCK_AABB;
    }
	
	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

	@Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }
    
	@Override
    public IBlockState getStateFromMeta(int meta){
        EnumFacing enumfacing = EnumFacing.getFront(meta);
        if(enumfacing.getAxis() == EnumFacing.Axis.Y){
            enumfacing = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty(FACING, enumfacing);
    }
	
	@Override
    public int getMetaFromState(IBlockState state){
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }
	
	@Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
	
}