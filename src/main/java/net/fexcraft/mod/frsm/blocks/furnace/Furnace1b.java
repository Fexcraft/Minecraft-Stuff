package net.fexcraft.mod.frsm.blocks.furnace;

import java.util.Random;

import net.fexcraft.mod.frsm.FRSM;
import net.fexcraft.mod.frsm.guis.GuiHandler;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@fBlock(modid = FI.MODID, name = "furnace1b", tileentity = Furnace1bEntity.class)
public class Furnace1b extends FBC_4R {
	
	private static boolean keepInventory;
	
    public Furnace1b() {
    	super(Material.IRON);
    	this.setLightLevel(0.4F);
    	this.setHarvestLevel("pickaxe", 1);
    	this.setHardness(3.0F);
    	this.setResistance(32.0F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new Furnace1bEntity();
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState state, World w, BlockPos pos, Random random){
		//w.spawnParticle(EnumParticleTypes.FLAME, 0.5, 0.5, 0.5, 0.0D, 0.0D, 0.0D);
		double d0 = (double)((float)pos.getX() + 0.5F);// + random.nextFloat() * 0.2F);
        double d1 = (double)((float)pos.getY() + 0.7F);// + random.nextFloat() * 0.3F);
        double d2 = (double)((float)pos.getZ() + 0.5F);// + random.nextFloat() * 0.2F);
        double d3 = 0.1D;
        w.spawnParticle(EnumParticleTypes.FLAME, d0   , d1   , d2, 0.0D, 0.0D, 0.0D, new int[0]);
        w.spawnParticle(EnumParticleTypes.FLAME, d0+d3, d1   , d2, 0.0D, 0.0D, 0.0D, new int[0]);
        w.spawnParticle(EnumParticleTypes.FLAME, d0   , d1+d3, d2, 0.0D, 0.0D, 0.0D, new int[0]);
        w.spawnParticle(EnumParticleTypes.FLAME, d0+d3, d1+d3, d2, 0.0D, 0.0D, 0.0D, new int[0]);
        w.spawnParticle(EnumParticleTypes.FLAME, d0-d3, d1-d3, d2, 0.0D, 0.0D, 0.0D, new int[0]);
	}
	
	@Override
    public int quantityDropped(Random random){
        return 1;
    }
	
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return Item.getItemFromBlock(RegistryUtil.getBlock("frsm:furnace1"));
    }
	
	@Override
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(!w.isRemote){
			if(!p.isSneaking()){
				p.openGui(FRSM.getInstance(), GuiHandler.FURNACE1, w, pos.getX(), pos.getY(), pos.getZ());
				return true;
			}
			if(p.isSneaking() && !p.getHeldItemMainhand().isEmpty()){
				w.setBlockState(pos, RegistryUtil.getBlock("frsm:furnace1").getDefaultState().withProperty(FACING, state.getValue(FACING)));
				return true;
			}
		}
		return false;
	}

	public static void setState(boolean active, World worldIn, BlockPos pos){
        IBlockState iblockstate = worldIn.getBlockState(pos);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        keepInventory = true;

        if (active){
            worldIn.setBlockState(pos, RegistryUtil.getBlock("frsm:furnace1b").getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            worldIn.setBlockState(pos, RegistryUtil.getBlock("frsm:furnace1b").getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }
        else{
            worldIn.setBlockState(pos, RegistryUtil.getBlock("frsm:furnace1b").getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            worldIn.setBlockState(pos, RegistryUtil.getBlock("frsm:furnace1b").getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }

        keepInventory = false;

        if (tileentity != null){
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    }
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state){
        if (!keepInventory){
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof Furnace1bEntity){
                InventoryHelper.dropInventoryItems(worldIn, pos, (Furnace1bEntity)tileentity);
                worldIn.updateComparatorOutputLevel(pos, this);
            }
        }
        super.breakBlock(worldIn, pos, state);
    }
	
	@Override
	public boolean hasComparatorInputOverride(IBlockState state){
        return true;
    }

	@Override
    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos){
        return Container.calcRedstone(worldIn.getTileEntity(pos));
    }
    
    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state){
        return new ItemStack(RegistryUtil.getBlock("frsm:furnace1"));
    }
    
}