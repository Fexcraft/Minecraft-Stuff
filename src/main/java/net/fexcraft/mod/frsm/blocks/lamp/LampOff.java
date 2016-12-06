package net.fexcraft.mod.frsm.blocks.lamp;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FM;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.block.IPaintableBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.fexcraft.mod.lib.util.cls.EnumColor;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LampOff extends Block implements IPaintableBlock{
	
	public static final PropertyEnum COLOR = PropertyEnum.create("color", EnumDyeColor.class);
	
	public LampOff() {
		super(FM.normal);
		this.setHarvestLevel("axe", 1);
		this.setHardness(1.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.DEV.getCreativeTab());
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerCustomFIB(new Lamp.IB(this));
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return new AxisAlignedBB(0.4F, 1.0F, 0.4F, 0.6F, 0.9F, 0.6F);
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
	public String getName(){
		return "lampOff";
	}
	
    @Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(!w.isRemote && p.getHeldItemMainhand() == null){
    		w.setBlockState(pos, FRSM_Blocks.lamp.getDefaultState().withProperty(COLOR, state.getValue(COLOR)));
    	}
		return true;
	}
    
    @Override
    public int damageDropped(IBlockState state){
        return ((EnumDyeColor)state.getValue(COLOR)).getMetadata();
    }
    
    @SideOnly(Side.CLIENT) @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list){
        for (int i = 0; i < this.getVariantAmount(); ++i){
            list.add(new ItemStack(itemIn, 1, i));
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(meta));
    }
    
    @Override
    public int getMetaFromState(IBlockState state){
        return ((EnumDyeColor)state.getValue(COLOR)).getMetadata();
    }
    
    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {COLOR});
    }
    
    @Override
	public int getVariantAmount(){
		return 16;
	}

	@Override
	public void onPaintItemUse(EnumColor color, ItemStack stack, EntityPlayer player, BlockPos pos, World world) {
		world.setBlockState(pos, this.getDefaultState().withProperty(COLOR, color.toDyeColor()));
	}
}