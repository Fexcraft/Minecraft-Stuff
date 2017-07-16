package net.fexcraft.mod.fvtm.blocks;

import java.util.ArrayList;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleItem;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
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

@fBlock(modid = FVTM.MODID, name = "landvehicle_constructor_controller", tileentity = ConstructorControllerEntity.class)
public class ConstructorController extends BlockContainer {
	
	public static ConstructorController INSTANCE;
	
	public ConstructorController(){
		super(Material.ANVIL, MapColor.OBSIDIAN);
		if(INSTANCE != null){
			Print.log("LANDVEHICLE CONSTRUCTOR CONTROLLER WAS INITIALIZED TWICE, THIS IS NOT ALLOWED.");
			Static.halt();
		}
    	this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setCreativeTab(Tabs.BLOCKS);
		INSTANCE = this;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new ConstructorControllerEntity();
	}
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    @Override
	public boolean isFullBlock(IBlockState state){
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
	
	//<-- VANILLA END -->//
	
	@Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(w.isRemote || hand == EnumHand.OFF_HAND){
			ConstructorControllerEntity te = (ConstructorControllerEntity)w.getTileEntity(pos);
			te.hitX = hitX;
			te.hitY = hitY;
			te.hitZ = hitZ;
			//Print.debugChat("HITX: " + hitX + " | HITY: " + hitY + " | HITZ: " + hitZ);
			//te.setState("0101010101");
			//te.lift += Static.rad10;
			return false;
		}
		ConstructorControllerEntity te = (ConstructorControllerEntity)w.getTileEntity(pos);
		if(te == null){
			return false;
		}
		if(!p.getHeldItemMainhand().isEmpty()){
			ItemStack stack = p.getHeldItemMainhand();
			if(stack.getItem() instanceof LandVehicleItem){
				/*if(!te.isLinked()){
					Print.chat(p, "No Center block connected!");
					Print.chat(p, "Rightclick to scan.");
					return true;
				}*/
				te.setData((LandVehicleItem)stack.getItem(), stack);
				Print.chat(p, "Vehicle: " + te.getData().getVehicle().getName());
				p.getHeldItemMainhand().shrink(64);
				te.sendUpdate();
				return true;
			}
		}
		else{
			if(w.getTileEntity(pos) != null){
				if(!te.isLinked()){
					/*ArrayList<ConstructorCenterEntity> list = this.findCenter(w, p, pos);
					for(ConstructorCenterEntity en : list){
						if(en.link == null && en.remote == null){
							en.link(pos);
							te.linked = true;
							Print.chat(p, "Connected! " + en.getPos().toString());
							break;
						}
					}
					if(!te.linked){
						Print.chat(p, "No center block found.");
					}*///TODO
				}
				else{
					if(te.getData() != null){
						//p.openGui(FVM.INSTANCE, 1, w, pos.getX(), pos.getY(), pos.getZ());
						return findAndPressButton(te, w, pos, state, p, side, hitX, hitY, hitZ);
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
	
	private boolean findAndPressButton(ConstructorControllerEntity te, World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumFacing side, float hitX, float hitY, float hitZ) {
		boolean found = false;
		if(side == EnumFacing.UP){
			Print.debugChat(hitX + " ||| " + hitZ);
			int x = calculateCoord(hitX);
			int z = calculateCoord(hitZ);
			Print.debugChat(x + " ||| " + z);
			Button button = findButton(state.getValue(FACING), x, z);
			if(button != null){
				if(button.id < 10){
					te.onButtonPress(button.id);
				}
				else{
					
				}
			}
		}
		return found;
	}
	
	private Button findButton(EnumFacing value, int x, int z){
		Print.debugChat(value.toString());
		for(Button button : buttons){
			if(button.collides(value, x, z)){
				return button;
			}
		}
		return null;
	}
	
	private static final ArrayList<Button> buttons = new ArrayList<Button>();
	static{
		buttons.add(new Button(0){
			@Override
			public boolean collides(EnumFacing value, int x, int z){
				switch(value){
					case WEST:
						if((x == 2 || x == 3) && (z == 14 || z == 15)){
							return true;
						}
						break;
					case EAST:
						if((x == 14 || x == 15) && (z == 2 || z == 3)){
							return true;
						}
						break;
					case NORTH:
						if((x == 2 || x == 3) && (z == 2 || z == 3)){
							return true;
						}
						break;
					case SOUTH:
						if((x == 14 || x == 15) && (z == 14 || z == 15)){
							return true;
						}
						break;
					default:
						break;
				}
				return false;
			}
		});
		buttons.add(new Button(1){
			@Override
			public boolean collides(EnumFacing value, int x, int z){
				switch(value){
					case WEST:
						if((x == 4 || x == 5) && (z == 14 || z == 15)){
							return true;
						}
						break;
					case EAST:
						break;
					case NORTH:
						break;
					case SOUTH:
						break;
					default:
						break;
				}
				return false;
			}
		});

		buttons.add(new Button(2){
			@Override
			public boolean collides(EnumFacing value, int x, int z){
				switch(value){
					case WEST:
						if(x == 4 && z == 2){
							return true;
						}
						break;
					case EAST:
						break;
					case NORTH:
						break;
					case SOUTH:
						break;
					default:
						break;
				}
				return false;
			}
		});
		//
		buttons.add(new Button(9){
			@Override
			public boolean collides(EnumFacing value, int x, int z){
				switch(value){
					case WEST:
						if(x == 11 && z == 2){
							return true;
						}
						break;
					case EAST:
						break;
					case NORTH:
						break;
					case SOUTH:
						break;
					default:
						break;
				}
				return false;
			}
		});
	}

	public static abstract class Button {
		private int id;
		public Button(int id){
			this.id = id;
		}
		public abstract boolean collides(EnumFacing value, int x, int z);
	}

	private int calculateCoord(float coords){
		int i = 0;
		while((coords - 0.0625) > 0){
			coords -= 0.0625;
			i++;
		}
		if(coords > 0){
			i++;
		}
		return i;
	}

	/*public static ArrayList<ConstructorCenterEntity> findCenter(World w, EntityPlayer p, BlockPos pos){
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
	}*/
	
}