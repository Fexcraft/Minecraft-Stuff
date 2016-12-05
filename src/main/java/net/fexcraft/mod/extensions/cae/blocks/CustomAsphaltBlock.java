package net.fexcraft.mod.extensions.cae.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.fexcraft.mod.extensions.cae.CustomAsphaltExtension.FI;
import net.fexcraft.mod.extensions.cae.items.PlanningItem;
import net.fexcraft.mod.extensions.cae.tileentities.CABTE;
import net.fexcraft.mod.frsm.util.PrintChat;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.fexcraft.mod.lib.util.cls.ApiUtil;
import net.fexcraft.mod.lib.util.cls.Static;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CustomAsphaltBlock extends BlockContainer implements IBlock{

	public static final PropertyInteger height = PropertyInteger.create("height", 0, 15);
	
	
	public CustomAsphaltBlock() {
		super(Material.ROCK);
		BlockUtil.register(FI.MODID, this);
		//BlockUtil.registerCustomFIB(new IB(this));;
		BlockUtil.registerFIB(this);
		BlockUtil.registerFIBRender(this);
	}
	
	/*public static class IB extends FIB{

		public IB(Block block) {
			super(block, ((IBlock)block).getName(), ((IBlock)block).getVariantAmount());
		}
		
		/*@Override
		public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
	        IBlockState iblockstate = worldIn.getBlockState(pos);
	        Block block = iblockstate.getBlock();

	        if (!block.isReplaceable(worldIn, pos)){
	            pos = pos.offset(facing);
	        }

	        if (stack.stackSize != 0 && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.canBlockBePlaced(this.block, pos, false, facing, (Entity)null, stack)){
	            int i = this.getMetadata(stack.getMetadata());
	            IBlockState iblockstate1 = this.block.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, i, playerIn);

	            if (placeBlockAt(stack, playerIn, worldIn, pos, facing, hitX, hitY, hitZ, iblockstate1)){
	                SoundType soundtype = worldIn.getBlockState(pos).getBlock().getSoundType(worldIn.getBlockState(pos), worldIn, pos, playerIn);
	                worldIn.playSound(playerIn, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
	                --stack.stackSize;
	            }

	            return EnumActionResult.SUCCESS;
	        }
	        else{
	            return EnumActionResult.FAIL;
	        }
		}*/
		
		/*@Override
		public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, IBlockState newState){
	        if (!world.setBlockState(pos, newState, 3)) return false;
	        
	        IBlockState state = world.getBlockState(pos);
	        if (state.getBlock() == this.block){
	            setTileEntityNBT(world, player, pos, stack);
	            this.block.onBlockPlacedBy(world, pos, state, player, stack);
	        }

	        return true;
	    }
		
		public static boolean setTileEntityNBT(World worldIn, @Nullable EntityPlayer player, BlockPos pos, ItemStack stackIn){
	        MinecraftServer minecraftserver = worldIn.getMinecraftServer();
	        if (minecraftserver == null){
	            return false;
	        }
	        else{
	            if (stackIn.hasTagCompound() && stackIn.getTagCompound().hasKey("BlockEntityTag", 10)){
	                net.minecraft.tileentity.TileEntity tileentity = worldIn.getTileEntity(pos);
	                if (tileentity != null){
	                    if (!worldIn.isRemote && tileentity.onlyOpsCanSetNbt() && (player == null || !player.func_189808_dh())){
	                        return false;
	                    }
	                    NBTTagCompound nbttagcompound = tileentity.writeToNBT(new NBTTagCompound());
	                    NBTTagCompound nbttagcompound1 = nbttagcompound.copy();
	                    NBTTagCompound nbttagcompound2 = (NBTTagCompound)stackIn.getTagCompound().getTag("BlockEntityTag");
	                    nbttagcompound.merge(nbttagcompound2);
	                    nbttagcompound.setInteger("x", pos.getX());
	                    nbttagcompound.setInteger("y", pos.getY());
	                    nbttagcompound.setInteger("z", pos.getZ());
	                    
	                    if (!nbttagcompound.equals(nbttagcompound1)){
	                        tileentity.readFromNBT(nbttagcompound);
	                        tileentity.markDirty();
	                        return true;
	                    }
	                }
	            }
	            if(stackIn.hasTagCompound() && stackIn.getTagCompound().hasKey("frsm_cae_data")){
	            	net.minecraft.tileentity.TileEntity te = worldIn.getTileEntity(pos);
	            	if(te != null){
	            		te.readFromNBT(stackIn.getTagCompound());
	            	}
	            }
	            return false;
	        }
	    }*/
		
		/*@Override
		public void onUpdate(ItemStack itemstack, World world, Entity entity, int itemSlot, boolean isSelected) {
			if(itemstack.getTagCompound() == null){
				itemstack.setTagCompound(new NBTTagCompound());
				itemstack.getTagCompound().setString("frsm_cae_type", Type.x16.toString());
				itemstack.getTagCompound().setString("frsm_cae_array", Static.Null_256);
			}
		}
		
		@SideOnly(Side.CLIENT) @Override
		public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
			if(stack.getTagCompound() == null || !stack.getTagCompound().hasKey("frsm_cae_type")){
				tooltip.add("No data.");
			}
			else{
				Type type = Type.fromString(stack.getTagCompound().getString("frsm_cae_type"));
				int[][] arr = CAEUtil.intXZfromCharArray(type, stack.getTagCompound().getString("frsm_cae_array").toCharArray());
				tooltip.add("Type: " + type.toString());
				if(type.N() < 17){
					for(int x = 0; x < type.N(); x++){
						String s = "";
						for(int z = 0; z < type.N(); z++){
							int i = arr[x][z];
							s += (i == 1 ? CCS.WHITE + "█" : CCS.DGRAY + "█");
						}
						tooltip.add(s);
					}
				}
				else{
					tooltip.add("Can't display sizes larger then x16.");
				}
			}
		}*/
	//}

	@Override
	public String getName(){
		return "custom_asphalt";
	}

	@Override
	public int getVariantAmount(){
		return 16;
	}
	
	@Override
	public boolean isFullCube(IBlockState state){
		if(state.getValue(height) == 15){
			return true;
		}
		else return false;
    }
	
	@Override
	public boolean isFullyOpaque(IBlockState state) {
		if(state.getValue(height) == 15){
			return true;
		}
		else return false;
	}
	
	@Override
    public int damageDropped(IBlockState state){
        return state.getValue(height);
    }
	
	@Override
    public int quantityDropped(Random random){
        return 1;
    }
	
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return Item.getItemFromBlock(CAEBlocks.custom_asphalt_nolayer);
    }
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
    }
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
		if(state.getValue(height) == 15){
			return true;
		}
		else return false;
    }
	
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, (state.getValue(height) + 1) * Static.sixteenth, 1.0F);
	}
	
	@Override
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(height, Integer.valueOf(meta));
    }
    
    @Override
    public int getMetaFromState(IBlockState state){
        return ((Integer)state.getValue(height)).intValue();
    }
    
    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {height});
    }
    
    @SideOnly(Side.CLIENT) @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list){
        for (int i = 0; i < this.getVariantAmount(); ++i){
            list.add(new ItemStack(itemIn, 1, i));
        }
    }
	
    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
    	if(placer instanceof EntityPlayer == false){
    		return this.getDefaultState().withProperty(height, 15);
    	}
    	
    	EntityPlayer player = (EntityPlayer)placer;
    	if(player.getHeldItemMainhand() != null){
    		if(player.getHeldItemMainhand() != null){
    			return this.getDefaultState().withProperty(height, 15);
    		}
    		return this.getDefaultState().withProperty(height, player.getHeldItemMainhand().getItemDamage());
    	}
    	else return this.getDefaultState().withProperty(height, 0);
    }
    
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
    	if(placer instanceof EntityPlayer == false){
    		return;
    	}
    	EntityPlayer player = (EntityPlayer)placer;
    	if(player.getHeldItemMainhand() != null){
        	int i = player.getHeldItemMainhand().getItemDamage();
        	world.setBlockState(pos, state.withProperty(height, i));
        }
    }
    
    @Override
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		if(w.isRemote){
			return false;
		}
		if(!w.isRemote){
			if(p.getHeldItemMainhand() != null && p.getHeldItemMainhand().getItem() instanceof PlanningItem){
				if(p.getHeldItemMainhand().getTagCompound() != null){
					String type  = p.getHeldItemMainhand().getTagCompound().getString("frsm_cae_type");
					String array = p.getHeldItemMainhand().getTagCompound().getString("frsm_cae_array");
					w.getTileEntity(pos).getTileData().setString("frsm_cae_array", array);
					w.getTileEntity(pos).getTileData().setString("frsm_cae_type",  type);
					((CABTE)w.getTileEntity(pos)).setArray(array);
					((CABTE)w.getTileEntity(pos)).setType(type);
					NBTTagCompound nbt = new NBTTagCompound();
					nbt.setString("array", array);
					nbt.setString("type",  type);
					ApiUtil.sendTileEntityUpdatePacket(w, pos, nbt);
				}
				else{
					PrintChat.print(p, "Item NBT is NULL.");
				}
			}
			/*if(p.getHeldItemMainhand() == null){
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setString("array", w.getTileEntity(pos).getTileData().getString("frsm_cae_array"));
				nbt.setString("type",  w.getTileEntity(pos).getTileData().getString("frsm_cae_type"));
				ApiUtil.sendTileEntityUpdatePacket(w, pos, nbt);
			}*/
			return true;
		}
		return false;
	}
    
    @Override
	public net.minecraft.tileentity.TileEntity createNewTileEntity(World worldIn, int meta) {
		return new CABTE();
	}
    
}