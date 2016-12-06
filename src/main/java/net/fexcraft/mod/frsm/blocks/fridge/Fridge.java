package net.fexcraft.mod.frsm.blocks.fridge;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.SSC;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.frsm.util.java.BoolUtil;
import net.fexcraft.mod.lib.api.block.IPaintableBlock;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.fexcraft.mod.lib.util.cls.EnumColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;

public class Fridge extends FBC_4R implements IPaintableBlock{
	
	public Fridge() {
		super(Material.IRON);
		this.setHarvestLevel("pickaxe", 1);
    	this.setHardness(5.0F);
    	this.setResistance(32.0F);
		this.setCreativeTab(CD.TECHNIC.getCreativeTab());
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerFIB(this);
	}

	@Override
	public String getName() {
		return "fridge";
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(!world.isRemote){
        	NBTTagCompound nbt = new NBTTagCompound();
        	FridgeTileEntity te = (FridgeTileEntity)world.getTileEntity(pos);
            nbt.setBoolean("open", BoolUtil.reverse(te.getState()));
            te.setState(BoolUtil.reverse(te.getState()));
        	SSC.getPacketHandler().sendToAllAround(new PacketTileEntityUpdate(pos, nbt), new TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 32));
        }
		return true;
    }

	@Override
	public void onPaintItemUse(EnumColor color, ItemStack stack, EntityPlayer player, BlockPos pos, World world) {
		TileEntity te = world.getTileEntity(pos);
		if(te == null){
			return;
		}
		switch(color){
			case BLACK:
			case BLUE:
			case GRAY:
			case GREEN:
			case RED:
			case WHITE:
				((FridgeTileEntity)te).setColor(color);
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setString("color", color.toString());
				SSC.getPacketHandler().sendToAllAround(new PacketTileEntityUpdate(pos, nbt), new TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 32));
				break;
			default: return;
		}
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new FridgeTileEntity();
	}
	
}