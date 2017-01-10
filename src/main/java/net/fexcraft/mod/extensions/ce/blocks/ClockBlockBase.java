package net.fexcraft.mod.extensions.ce.blocks;

import java.util.List;

import net.fexcraft.mod.extensions.ce.CE;
import net.fexcraft.mod.extensions.ce.util.ClockTimeType;
import net.fexcraft.mod.frsm.util.PrintChat;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.network.Network;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.fexcraft.mod.lib.util.cls.Static;
import net.fexcraft.mod.lib.util.item.FIB;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ClockBlockBase extends FBC_4R implements IBlock {
	
	private ModelBase model;
	private ResourceLocation texture;
	private String name, tooltip;
	private ClockTimeType type;
	private boolean defaabb;
	private int rendersides = 1;
	
	public ClockBlockBase(String name, ClockTimeType type, String texture, ModelBase base, boolean def, int rs, String s){
		super(Material.IRON);
		this.setCreativeTab(CE.tabCE);
		this.name = name;
		this.tooltip = s;
		this.model = base;
		this.type = type;
		this.texture = new ResourceLocation(texture);
		this.defaabb = def;
		this.rendersides = rs;
		
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(1.0F);
		this.setResistance(32.0F);
		
		BlockUtil.register(CE.MODID, this);
		BlockUtil.registerFIB(this);
		BlockUtil.registerFIBRender(this);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new ClockTileEntityBase(type, model, texture, rendersides);
	}

	@Override
	public String getName(){
		return name;
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return Static.NO;
	}
	
	@Override
    public boolean isFullCube(IBlockState state){
        return Static.NO;
    }
	
    protected static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.1875D, 1.0D, 1.0D);
    protected static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.8125D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.1875D);
    protected static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.8125D, 1.0D, 1.0D, 1.0D);
    
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
    	if(!defaabb){
    		return FULL_BLOCK_AABB;
    	}
        switch ((EnumFacing)state.getValue(FACING)){
            case NORTH:
                return NORTH_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case WEST:
                return WEST_AABB;
            case EAST:
            default:
                return EAST_AABB;
        }
    }
    
    @Override
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(!w.isRemote && Network.isDonator(p)){
    		//
    	}
    	return false;
	}
	public void onBlockPlacedBy(World w, BlockPos pos, IBlockState state, EntityLivingBase p, ItemStack stack){
		if(!w.isRemote){
			if(w.getTileEntity(pos) != null){
				ClockTileEntityBase clock = (ClockTileEntityBase)w.getTileEntity(pos);
				if(clock.getType() == ClockTimeType.REAL_CUSTOM || clock.getType().equals(ClockTimeType.REAL_CUSTOM_REVERSE)){
					PrintChat.print((EntityPlayer)p, "H:0, M:0, S:0");
				}
				clock.updateClient();
			}
		}
	}
	public static class ClockItemBlock extends FIB {
		public ClockItemBlock(Block block){
			super(block, ((IBlock)block).getName(), ((IBlock)block).getVariantAmount());
		}
		@Override
		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean shift){
			list.add(CCS.GRAY + ((ClockBlockBase)block).tooltip);
		}
	}
	
}