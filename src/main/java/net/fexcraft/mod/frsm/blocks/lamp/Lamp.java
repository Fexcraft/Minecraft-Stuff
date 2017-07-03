package net.fexcraft.mod.frsm.blocks.lamp;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FM;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.api.common.PaintableObject;
import net.fexcraft.mod.lib.util.common.EnumColor;
import net.fexcraft.mod.lib.util.registry.ItemBlock16;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
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

@fBlock(modid = FI.MODID, name = "lamp", variants = 16)
public class Lamp extends Block  implements PaintableObject {
	
	public static final PropertyEnum COLOR = PropertyEnum.create("color", EnumDyeColor.class);
    
    public Lamp() {
    	super(FM.normal);
    	this.setLightLevel(1.0F);
    	this.setHarvestLevel("pickaxe", 1);
    	this.setHardness(2.0F);
    	this.setResistance(32.0F);
    	this.setCreativeTab(CD.BLOCKS);
	}
    
    public static class IB extends ItemBlock16 {

		public IB(Block block) {
			super(block);
		}
		
		@Override
	    public String getUnlocalizedName(ItemStack itemStack) {
	        String name = this.getRegistryName().toString();
	        switch(itemStack.getItemDamage()) {
	            case 0:
	            	return name + ".white";
	            case 1:
	            	return name + ".orange";
	            case 2:
	            	return name + ".magenta";
	            case 3:
	            	return name + ".lightblue";
	            case 4:
	            	return name + ".yellow";
	            case 5:
	            	return name + ".lightgreen";
	            case 6:
	            	return name + ".pink";
	            case 7:
	            	return name + ".grey";
	            case 8:
	            	return name + ".lightgrey";
	            case 9:
	            	return name + ".cyan";
	            case 10:
	            	return name + ".purple";
	            case 11:
	            	return name + ".blue";
	            case 12:
	            	return name + ".brown";
	            case 13:
	            	return name + ".green";
	            case 14:
	            	return name + ".red";
	            case 15:
	            	return name + ".black";
	            default:
	            	return name + ".error";
	        }
	    }
		
		@Override
	    public int getMetadata(int meta) {
	    	return meta;
	    }
    }
    
    @Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return new AxisAlignedBB(0.4F, 1.0F, 0.4F, 0.6F, 0.9F, 0.6F);
	}
    
	@Override
	public boolean isFullBlock(IBlockState state) {
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
    	if(!w.isRemote && p.getHeldItemMainhand().isEmpty()){
    		w.setBlockState(pos, RegistryUtil.getBlock("frsm:lamp_off").getDefaultState().withProperty(COLOR, state.getValue(COLOR)));
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