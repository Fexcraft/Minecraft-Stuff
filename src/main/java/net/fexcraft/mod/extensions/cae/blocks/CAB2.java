package net.fexcraft.mod.extensions.cae.blocks;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.extensions.cae.CustomAsphaltExtension.FI;
import net.fexcraft.mod.extensions.cae.items.PlanningItem;
import net.fexcraft.mod.frsm.util.PrintChat;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.fexcraft.mod.lib.util.cls.Static;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CAB2 extends Block implements IBlock{

	public static final PropertyInteger height = PropertyInteger.create("height", 0, 15);
	
	
	public CAB2() {
		super(Material.ROCK);
		setCreativeTab(CD.STREETS.getCreativeTab());
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerFIB(this);
		BlockUtil.registerFIBRender(this);
	}

	@Override
	public String getName(){
		return "custom_asphalt_nolayer";
	}

	@Override
	public int getVariantAmount(){
		return 16;
	}
	
	@Override
    public int damageDropped(IBlockState state){
        return state.getValue(height);
    }
	
	@Override
	public boolean isFullCube(IBlockState state){
		if(state.getValue(height) == 15){
			return true;
		}
		else return false;
    }
	
	@Override
	public boolean isFullyOpaque(IBlockState state) {
		if(state.getValue(height) == 15){
			return true;
		}
		else return false;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
    }
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
		if(state.getValue(height) == 15){
			return true;
		}
		else return false;
    }
	
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, (state.getValue(height) + 1) * Static.sixteenth, 1.0F);
	}
	
	@Override
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(height, Integer.valueOf(meta));
    }
    
    @Override
    public int getMetaFromState(IBlockState state){
        return ((Integer)state.getValue(height)).intValue();
    }
    
    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {height});
    }
    
    @SideOnly(Side.CLIENT) @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list){
        for (int i = 0; i < this.getVariantAmount(); ++i){
            list.add(new ItemStack(itemIn, 1, i));
        }
    }
	
    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
    	if(placer instanceof EntityPlayer == false){
    		return this.getDefaultState().withProperty(height, 15);
    	}
    	
    	EntityPlayer player = (EntityPlayer)placer;
    	if(player.getHeldItemMainhand() != null){
    		if(player.getHeldItemMainhand() != null){
    			return this.getDefaultState().withProperty(height, 15);
    		}
    		return this.getDefaultState().withProperty(height, player.getHeldItemMainhand().getItemDamage());
    	}
    	else return this.getDefaultState().withProperty(height, 0);
    }
    
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
    	if(placer instanceof EntityPlayer == false){
    		return;
    	}
    	EntityPlayer player = (EntityPlayer)placer;
    	if(player.getHeldItemMainhand() != null){
        	int i = player.getHeldItemMainhand().getItemDamage();
        	world.setBlockState(pos, state.withProperty(height, i));
        }
    }
    
    @Override
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		if(w.isRemote){
			return false;
		}
		else{
			if(p.getHeldItemMainhand().getItem() instanceof PlanningItem){
				if(p.getHeldItemMainhand().getTagCompound() != null){
					w.setBlockState(pos, CAEBlocks.custom_asphalt.getDefaultState().withProperty(CustomAsphaltBlock.height, state.getValue(height).intValue()));
					//PrintChat.print(p, "CAB NoLayer -> Custom Asphalt Block");
				}
				else{
					PrintChat.print(p, "Item NBT is NULL.");
				}
			}
			return true;
		}
	}
}