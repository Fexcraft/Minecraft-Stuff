package net.fexcraft.mod.frsm.blocks.common;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.block.öBlock;
import net.fexcraft.mod.lib.api.common.PaintableObject;
import net.fexcraft.mod.lib.util.common.EnumColor;
import net.fexcraft.mod.lib.util.registry.ItemBlock16;
import net.fexcraft.mod.lib.util.render.RGB;
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
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@öBlock(modid = FI.MODID, name = "decoblock1", variants = 16, item = DecoBlock1.IB.class)
public class DecoBlock1 extends Block implements PaintableObject {

	public static final PropertyEnum COLOR = PropertyEnum.create("color", EnumDyeColor.class);
	
    public DecoBlock1(){
        super(Material.WOOD);
        this.setHarvestLevel("axe", 1);
        this.setHardness(1.0F);
        this.setResistance(10.0F);
        this.setCreativeTab(CD.BLOCKS);
    	this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, EnumDyeColor.WHITE));
    }
    
    public static class IB extends ItemBlock16 {
    	
    	public IB(Block block){
			super(block);
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
    public int damageDropped(IBlockState state){
        return ((EnumDyeColor)state.getValue(COLOR)).getMetadata();
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, NonNullList<ItemStack> list){
        for(int i = 0; i < 16; ++i){
            list.add(new ItemStack(item, 1, i));
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
	public void onPaintItemUse(RGB color, EnumColor dye, ItemStack stack, EntityPlayer player, BlockPos pos, World world) {
		world.setBlockState(pos, this.getDefaultState().withProperty(COLOR, dye.toDyeColor()));
	}
	
}