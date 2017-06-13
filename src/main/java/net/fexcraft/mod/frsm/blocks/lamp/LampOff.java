package net.fexcraft.mod.frsm.blocks.lamp;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FM;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.api.common.PaintableObject;
import net.fexcraft.mod.lib.util.common.EnumColor;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
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

@fBlock(modid = FI.MODID, name = "lampoff", variants = 16)
public class LampOff extends Block implements PaintableObject {
	
	public static final PropertyEnum COLOR = PropertyEnum.create("color", EnumDyeColor.class);
	
	public LampOff() {
		super(FM.normal);
		this.setHarvestLevel("axe", 1);
		this.setHardness(1.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.EXPERIMENTAL);
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
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(!w.isRemote && !p.getHeldItemMainhand().isEmpty()){
    		w.setBlockState(pos, Registry.getBlock("frsm:lamp").getDefaultState().withProperty(COLOR, state.getValue(COLOR)));
    	}
		return true;
	}
    
    @Override
    public int damageDropped(IBlockState state){
        return ((EnumDyeColor)state.getValue(COLOR)).getMetadata();
    }
    
    @SideOnly(Side.CLIENT) @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list){
        for (int i = 0; i < 16; ++i){
            list.add(new ItemStack(this, 1, i));
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
	public void onPaintItemUse(RGB rgb, EnumColor color, ItemStack stack, EntityPlayer player, BlockPos pos, World world) {
		world.setBlockState(pos, this.getDefaultState().withProperty(COLOR, color.toDyeColor()));
	}
	
}