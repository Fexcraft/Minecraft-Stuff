package net.fexcraft.mod.frsm.blocks.RCT;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.PrintChat;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RCT extends BlockContainer implements IBlock{

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool isPowered = PropertyBool.create("powered");
	
    public RCT() {
    	super(Material.GLASS);
    	this.setHarvestLevel("axe", 1);
    	this.setHardness(1.0F);
    	this.setResistance(10.0F);
    	this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(isPowered, Boolean.valueOf(false)));
    	this.setHarvestLevel("pickaxe", 1);
    	this.setHardness(5.0F);
    	this.setResistance(32.0F);
    	this.setCreativeTab(CD.RC.getCreativeTab());
    	BlockUtil.register(FI.MODID, this);
    	BlockUtil.registerFIB(this);
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
	public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
    }
	
	@Override
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if (w.isBlockPowered(pos) && !p.isSneaking()) {
			//p.openGui(FRSM.instance, GuiHandler.RCT, w, pos.getX(), pos.getY(), pos.getZ());
			PrintChat.print(p, "Currently disabled.");
			return true;
		}
		else{
			return false;
		}
	}
	
	//TODO CHECK IF REDSTONE SIGNAL
	
	@Override
	public String getName(){
		return "RCT";
	}
	
	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(isPowered, Boolean.valueOf(false));
    }
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(isPowered, false), 2);
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(FACING, getFacing(meta)).withProperty(isPowered, Boolean.valueOf((meta & 8) > 0));
    }
    
    public static EnumFacing getFacing(int meta){
        return EnumFacing.getFront(meta & 7);
    }
	
    @Override
    public int getMetaFromState(IBlockState state){
        byte b0 = 0;
        int i = b0 | ((EnumFacing)state.getValue(FACING)).getIndex();
        if (((Boolean)state.getValue(isPowered)).booleanValue()){
            i |= 8;
        }
        return i;
    }
	
    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {FACING, isPowered});
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new RCTEntity();
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
}