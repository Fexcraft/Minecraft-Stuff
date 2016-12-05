package net.fexcraft.mod.frsm.blocks.common;

import java.util.List;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.block.IPaintableBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.fexcraft.mod.lib.util.cls.EnumColor;
import net.fexcraft.mod.lib.util.item.FIB;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DecoBlock1 extends Block implements IPaintableBlock{

	public static final PropertyEnum COLOR = PropertyEnum.create("color", EnumDyeColor.class);
	
    public DecoBlock1(){
        super(Material.WOOD);
        this.setHarvestLevel("axe", 1);
        this.setHardness(1.0F);
        this.setResistance(10.0F);
        this.setCreativeTab(CD.BLOCKS.getCreativeTab());
    	this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, EnumDyeColor.WHITE));
    	BlockUtil.register(FI.MODID, this);
    	GameRegistry.register(new IB(this, getName(), this.getVariantAmount()));
    }
    
    public static class IB extends FIB{
    	
    	public IB(Block block, String name, int va) {
			super(block, name, va);
			this.setHasSubtypes(true);
		}

		@Override
        public String getUnlocalizedName(ItemStack itemStack){
            String name = getUnlocalizedName();
            switch(itemStack.getItemDamage()) {
                case 0: return name + ".white";
                case 1: return name + ".orange";
                case 2: return name + ".magenta";
                case 3: return name + ".lightblue";
                case 4: return name + ".yellow";
                case 5: return name + ".lightgreen";
                case 6: return name + ".pink";
                case 7: return name + ".grey";
                case 8: return name + ".lightgrey";
                case 9: return name + ".cyan";
                case 10: return name + ".purple";
                case 11: return name + ".blue";
                case 12: return name + ".brown";
                case 13: return name + ".green";
                case 14: return name + ".red";
                case 15: return name + ".black";
                default: return name + ".error";
            }
        }
		
		@Override
	    public int getMetadata(int meta) {
	    	return meta;
	    }
    }
    
    @Override
    public String getName(){
    	return "decoBlock1";
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
	public int getVariantAmount() {
		return 16;
	}

	@Override
	public void onPaintItemUse(EnumColor color, ItemStack stack, EntityPlayer player, BlockPos pos, World world) {
		world.setBlockState(pos, this.getDefaultState().withProperty(COLOR, color.toDyeColor()));
	}
}