package net.fexcraft.mod.extensions.bge.blocks;

import java.util.List;

import net.fexcraft.mod.extensions.bge.BGE;
import net.fexcraft.mod.extensions.bge.tileentities.BLK1TE;
import net.fexcraft.mod.lib.api.block.IPaintableBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.fexcraft.mod.lib.util.common.EnumColor;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Blk1 extends BlockContainer implements IPaintableBlock {
	
	public static final PropertyEnum COLOR = PropertyEnum.create("color", EnumDyeColor.class);
	
	public Blk1(){
		super(Material.GLASS);
		this.setCreativeTab(BGE.tabBGE);
		//this.setDefaultState(this.getDefaultState().withProperty(COLOR, EnumDyeColor.GREEN));
		BlockUtil.register("frsm_bge", this);
		BlockUtil.registerFIB(this);
		BlockUtil.registerFIBRender(this);
	}

	@Override
	public boolean isFullyOpaque(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state){
        return false;
    }
	
	public boolean isOpaqueCube(IBlockState state){
        return false;
    }
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(!world.isRemote && !player.isSneaking()){
    		EnumFacing facing = player.getHorizontalFacing();
    		BlockPos p = null;
    		switch(facing){
	    		case NORTH: p = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1); break;
				case SOUTH: p = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1); break;
				case WEST:  p = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()); break;
				case EAST:  p = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()); break;
				default:    p = pos; break;
    		}
    		if(world.mayPlace(BGE.blk1, p, false, side, null)){
    			world.setBlockState(pos, Blocks.AIR.getDefaultState());
    			world.setBlockState(p, BGE.blk1.getDefaultState().withProperty(COLOR, (EnumDyeColor)state.getValue(COLOR)));
    			return true;
    		}
        }
		return false;
    }
	
	@Override
	public String getName() {
		return "block1";
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new BLK1TE();
	}

	@Override
	public void onPaintItemUse(EnumColor color, ItemStack stack, EntityPlayer player, BlockPos pos, World world) {
		world.setBlockState(pos, this.getDefaultState().withProperty(COLOR, color.toDyeColor()));
	}
	
	@Override
    public int damageDropped(IBlockState state){
        return ((EnumDyeColor)state.getValue(COLOR)).getMetadata();
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list){
        for (int i = 0; i < 16; ++i){
            list.add(new ItemStack(itemIn, 1, i));
        }
    }

    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(meta));
    }
    
    public int getMetaFromState(IBlockState state){
        return ((EnumDyeColor)state.getValue(COLOR)).getMetadata();
    }

    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {COLOR});
    }

	@Override
	public int getVariantAmount(){
		return 16;
	}
	
	private static final AxisAlignedBB AABB = new AxisAlignedBB(0.25F, 0.0F, 0.25F, 0.75F, 1.125F, 0.75F);
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return AABB;
	}
    
}