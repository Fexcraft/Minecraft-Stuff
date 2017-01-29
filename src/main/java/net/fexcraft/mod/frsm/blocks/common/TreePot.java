package net.fexcraft.mod.frsm.blocks.common;

import java.util.List;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.util.registry.ItemBlock16;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@fBlock(modid = FI.MODID, name = "tree_pot", variants = 16)
public class TreePot extends Block {

	/**
	 * Types:
	 * 0 none 
	 * 1 DIRT
	 * 2 grass
	 * 3 dry soil
	 * 4 wet soil
	 * 5 podzol
	 * 6 gravel
	 * 7 mossy cobble
	 * 8 sand
	 * 9 red sand
	 * 10 netherstone
	 * 11 soulsand
	 * 12 glowstone
	 * 13 myzel
	 * 14 redstone_ore
	 * 15 redstone_block
	 */
	public static final PropertyInteger type = PropertyInteger.create("type", 0, 15);
    
    public TreePot(){
        super(Material.WOOD);
        this.setHarvestLevel("axe", 1);
        this.setHardness(1.0F);
        this.setResistance(10.0F);
    	this.setCreativeTab(CD.TREEPOTS);
    }
    
    public static class IB extends ItemBlock16 {
    	public IB(Block block){
    		super(block);
    		setMaxStackSize(1);
    	}
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
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.6875F, 1.0F);
	}
    
    @Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(!w.isRemote){
    		if(!p.getHeldItemMainhand().isEmpty()){
    			Item item = p.getHeldItemMainhand().getItem();
    			if(item instanceof ItemBlock){
    				if(item == Item.getItemFromBlock(Blocks.DIRT) && p.getHeldItemMainhand().getMetadata() == 0){
    	    			w.setBlockState(pos, state.withProperty(type, 1));
    	    			return true;
    	    		}
    	    		if(item == Item.getItemFromBlock(Blocks.GRASS_PATH)){
    	    			w.setBlockState(pos, state.withProperty(type, 2));
    	    			return true;
    	    		}
    	    		if(item == Item.getItemFromBlock(Blocks.DIRT) && p.getHeldItemMainhand().getMetadata() == 2){
    	    			w.setBlockState(pos, state.withProperty(type, 5));
    	    			return true;
    	    		}
    	    		if(item == Item.getItemFromBlock(Blocks.GRAVEL)){
    	    			w.setBlockState(pos, state.withProperty(type, 6));
    	    			return true;
    	    		}
    	    		if(item == Item.getItemFromBlock(Blocks.MOSSY_COBBLESTONE)){
    	    			w.setBlockState(pos, state.withProperty(type, 7));
    	    			return true;
    	    		}
    	    		if(item == Item.getItemFromBlock(Blocks.SAND) && p.getHeldItemMainhand().getMetadata() == 0){
    	    			w.setBlockState(pos, state.withProperty(type, 8));
    	    			return true;
    	    		}
    	    		if(item == Item.getItemFromBlock(Blocks.SAND) && p.getHeldItemMainhand().getMetadata() == 1){
    	    			w.setBlockState(pos, state.withProperty(type, 9));
    	    			return true;
    	    		}
    	    		if(item == Item.getItemFromBlock(Blocks.NETHERRACK)){
    	    			w.setBlockState(pos, state.withProperty(type, 10));
    	    			return true;
    	    		}
    	    		if(item == Item.getItemFromBlock(Blocks.SOUL_SAND)){
    	    			w.setBlockState(pos, state.withProperty(type, 11));
    	    			return true;
    	    		}
    	    		if(item == Item.getItemFromBlock(Blocks.GLOWSTONE)){
    	    			w.setBlockState(pos, state.withProperty(type, 12));
    	    			return true;
    	    		}
    	    		if(item == Item.getItemFromBlock(Blocks.MYCELIUM)){
    	    			w.setBlockState(pos, state.withProperty(type, 13));
    	    			return true;
    	    		}
    	    		if(item == Item.getItemFromBlock(Blocks.REDSTONE_ORE)){
    	    			w.setBlockState(pos, state.withProperty(type, 14));
    	    			return true;
    	    		}
    	    		if(item == Item.getItemFromBlock(Blocks.REDSTONE_BLOCK)){
    	    			w.setBlockState(pos, state.withProperty(type, 15));
    	    			return true;
    	    		}
    			}
    			if(item instanceof ItemTool){
    				if(item instanceof ItemHoe){
    					switch(state.getValue(type).intValue()){
    						case 1: case 2:
    							w.setBlockState(pos, state.withProperty(type, 3));
    							return true;
    						case 5:
    							w.setBlockState(pos, state.withProperty(type, 4));
    							return true;
    					}
    				}
    				else{
    					w.setBlockState(pos, state.withProperty(type, 0));
    	    			p.getHeldItemMainhand().damageItem(2, p);
    	    			w.spawnEntity(new EntityItem(w, pos.getX(), pos.getY(), pos.getZ(), getDrop(state.getValue(type).intValue())));
    	    			return true;
    				}
    			}
    		}
    	}
    	return false;
    }
    
    public ItemStack getDrop(int i){
    	switch(i){
    		case 0:
    			return null;
    		case 1:
    		case 2:
    		case 3:
    		case 4:
    		case 5:
    			return new ItemStack(Blocks.DIRT);
    		case 6:
    			return new ItemStack(Blocks.GRAVEL);
    		case 7:
    			return new ItemStack(Blocks.MOSSY_COBBLESTONE);
    		case 8:
    			return new ItemStack(Blocks.SAND, 1, 0);
    		case 9:
    			return new ItemStack(Blocks.SAND, 1, 1);
    		case 10:
    			return new ItemStack(Blocks.NETHERRACK);
    		case 11:
    			return new ItemStack(Blocks.SOUL_SAND);
    		case 12:
    			return new ItemStack(Blocks.GLOWSTONE);
    		case 13:
    			return new ItemStack(Blocks.MYCELIUM);
    		case 14:
    			return new ItemStack(Blocks.REDSTONE_ORE);
    		case 15:
    			return new ItemStack(Blocks.REDSTONE_BLOCK);
    	}
    	return null;
    }
    
    @SideOnly(Side.CLIENT) @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list){
        for (int i = 0; i < 16; ++i){
            list.add(new ItemStack(itemIn, 1, i));
        }
    }
    
    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune){
    	List<ItemStack> ret = super.getDrops(world, pos, state, fortune);
        int typei = ((Integer)state.getValue(type)).intValue();
        switch(typei){
        	case 0:
        		break;
        	case 1: case 2: case 3: case 4: case 5:
        		ret.add(new ItemStack(Blocks.DIRT));
        		break;
        	case 6:
        		ret.add(new ItemStack(Blocks.GRAVEL));
        		break;
        	case 7:
            	ret.add(new ItemStack(Blocks.COBBLESTONE));
            	ret.add(new ItemStack(Items.WHEAT_SEEDS, 2));
            	break;
        	case 8:
            	ret.add(new ItemStack(Blocks.SAND, 1, 0));
            	break;
        	case 9:
            	ret.add(new ItemStack(Blocks.SAND, 1, 1));
            	break;
        	case 10:
            	ret.add(new ItemStack(Blocks.NETHERRACK));
            	break;
        	case 11:
            	ret.add(new ItemStack(Blocks.SOUL_SAND));
            	break;
        	case 12:
            	ret.add(new ItemStack(Blocks.GLOWSTONE));
            	break;
        	case 13:
            	ret.add(new ItemStack(Blocks.MYCELIUM));
            	break;
        	case 14:
            	ret.add(new ItemStack(Items.REDSTONE, 2));
            	break;
        	case 15:
            	ret.add(new ItemStack(Items.REDSTONE, 9));
            	break;
        	default:
        		break;
        }
        return ret;
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(type, Integer.valueOf(meta));
    }
    
    @Override
    public int getMetaFromState(IBlockState state){
        return ((Integer)state.getValue(type)).intValue();
    }
    
    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {type});
    }
    
}