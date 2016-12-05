package net.fexcraft.mod.frsm.blocks.tv;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.ETE;
import net.fexcraft.mod.frsm.util.block.FRSMTE;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
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
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class TVL extends BlockContainer implements IBlock {
	
	public static final PropertyInteger CHANNEL = PropertyInteger.create("channel", 0, 15);
	private String cname;
    
	public TVL(String name) {
		super(Material.GRASS);
		this.cname = name;
		this.setDefaultState(this.blockState.getBaseState().withProperty(CHANNEL, 0));
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(3.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.DEV.getCreativeTab());
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
	public String getName(){
		return cname;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new ETE();
	}
	
	@Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
    	String s = ((TEB)world.getTileEntity(pos)).facing;
    	world.getTileEntity(pos).getTileData().setString("direction", s);
    }
    
	@Override
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(CHANNEL, Integer.valueOf(meta));
    }
    
	@Override
    public int getMetaFromState(IBlockState state){
        return ((Integer)state.getValue(CHANNEL)).intValue();
    }
	
	@Override
	protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {CHANNEL});
    }
    
    @Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(!w.isRemote){
	    	if(p.getHorizontalFacing().getOpposite().toString() != w.getTileEntity(pos).getTileData().getString("direction")){
	    		if((Integer) state.getValue(CHANNEL) == 0){
	    			p.addChatMessage(new TextComponentString(FI.FRSMs + " TV Enabled"));
	    			w.setBlockState(pos, state.withProperty(CHANNEL, 1));
	    			return true;
	    		}
	    		else if((Integer) state.getValue(CHANNEL) != 0){
	    			int i = (Integer) state.getValue(CHANNEL);
	    			if(i >= 1 && i <= 14){
	    				p.addChatMessage(new TextComponentString(FI.FRSMs + " Channel " + (i + 1)));
	    				w.setBlockState(pos, state.withProperty(CHANNEL, i + 1));
	    				return true;
	    			}
	    			else if(i == 15){
	    				p.addChatMessage(new TextComponentString(FI.FRSMs + " TV Disabled"));
	    				w.setBlockState(pos, state.withProperty(CHANNEL, 0));
	    				return true;
	    			}
	    			else return false;
	    		}
	    		if(p.isSneaking()){
	    			p.addChatMessage(new TextComponentString(FI.FRSMs + "TV Disabled"));
	    			w.setBlockState(pos, state.withProperty(CHANNEL, 0));
	    			return true;
	    		}
	    		else return false;
	    	}
	    	else return false;
    	}
    	else return false;
    }
    
    public static class TEB extends FRSMTE {
    	public String facing;
    	
    	public TEB(String facing){
    		this.facing = facing;
    	}
    }
    
    public static class TVL0 extends TVL{
    	public TVL0() {super("TVL");}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new TE("north");}
    	public static class TE extends TEB{public TE(String facing) {super(facing);}}
    }
    public static class TVL00 extends TVL{
    	public TVL00() {super("TVL0");}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new TE("south");}
    	public static class TE extends TEB{public TE(String facing) {super(facing);}}
    }
    public static class TVL000 extends TVL{
    	public TVL000() {super("TVL00");}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new TE("west");}
    	public static class TE extends TEB{public TE(String facing) {super(facing);}}
    }
    public static class TVL0000 extends TVL{
    	public TVL0000() {super("TVL000");}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new TE("east");}
    	public static class TE extends TEB{public TE(String facing) {super(facing);}}
    }
	@Override
	public int getVariantAmount(){
		return default_variant;
	}
}