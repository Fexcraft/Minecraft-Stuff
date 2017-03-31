package net.fexcraft.mod.fvm.blocks;

import java.util.ArrayList;

import net.fexcraft.mod.fvm.FVM;
import net.fexcraft.mod.fvm.data.LoadedIn;
import net.fexcraft.mod.fvm.items.VehicleItem;
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
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@fBlock(modid = FvmResources.MODID, name = "constructor_controller", tileentity = ConstructorControllerEntity.class)
public class ConstructorController extends BlockContainer {

	public ConstructorController(){
		super(Material.IRON, MapColor.BLACK);
    	this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setCreativeTab(FvmResources.BLOCKS);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new ConstructorControllerEntity();
	}
	
	@Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(w.isRemote || hand == EnumHand.OFF_HAND){
			return false;
		}
		ConstructorControllerEntity te = (ConstructorControllerEntity)w.getTileEntity(pos);
		if(te == null){
			return false;
		}
		if(!p.getHeldItemMainhand().isEmpty()){
			ItemStack stack = p.getHeldItemMainhand();
			if(stack.getItem() instanceof VehicleItem){
				if(!te.isLinked()){
					Print.chat(p, "No Center block connected!");
					Print.chat(p, "Rightclick to scan.");
					return true;
				}
				te.type = FvmResources.getNewInstanceOf(LoadedIn.TILE, stack);
				Print.chat(p, "Vehicle: " + te.type.fullname);
				p.getHeldItemMainhand().shrink(64);
				te.sendUpdate();
				return true;
			}
		}
		else{
			if(w.getTileEntity(pos) != null){
				if(!te.isLinked()){
					ArrayList<ConstructorCenterEntity> list = this.findCenter(w, p, pos);
					for(ConstructorCenterEntity en : list){
						if(en.link == null){
							en.link(pos);
							te.setLinked(true);
							Print.chat(p, "Connected! " + en.getPos().toString());
							break;
						}
					}
					if(!te.isLinked()){
						Print.chat(p, "No center block found.");
					}
				}
				else{
					if(te.type != null){
						p.openGui(FVM.INSTANCE, 1, w, pos.getX(), pos.getY(), pos.getZ());
					}
					else{
						Print.chat(p, "No Vehicle.");
					}
				}
			}
			return true;
		}
		return false;
    }
	
	public static ArrayList<ConstructorCenterEntity> findCenter(World w, EntityPlayer p, BlockPos pos){
		Print.chat(p, "Scanning...");
		ArrayList<ConstructorCenterEntity> list = new ArrayList<ConstructorCenterEntity>();
		int x = pos.getX() - 8;
		int y = pos.getY();
		int z = pos.getZ() - 8;
		for(int i = 0; i < 16; i++){
			for(int j = 0; j < 16; j++){
				TileEntity tile = w.getTileEntity(new BlockPos(x + i, y, z + j));
				if(tile != null && tile instanceof ConstructorCenterEntity){
					list.add((ConstructorCenterEntity)tile);
				}
				tile = w.getTileEntity(new BlockPos(x + i, y - 1, z + j));
				if(tile != null && tile instanceof ConstructorCenterEntity){
					list.add((ConstructorCenterEntity)tile);
				}
				tile = w.getTileEntity(new BlockPos(x + i, y + 1, z + j));
				if(tile != null && tile instanceof ConstructorCenterEntity){
					list.add((ConstructorCenterEntity)tile);
				}
			}
		}
		return list;
	}
	
	//================================== > VANILLA
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

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
        if (enumfacing.getAxis() == EnumFacing.Axis.Y){
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
	
}