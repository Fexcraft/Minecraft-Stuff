package net.fexcraft.mod.extensions.ie.blocks;

import net.fexcraft.mod.extensions.ie.IE;
import net.fexcraft.mod.extensions.ie.gui.GuiHandler;
import net.fexcraft.mod.extensions.ie.tileentities.ElectricalFurnaceEntity;
import net.fexcraft.mod.extensions.ie.util.Static;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.lib.api.block.IMashineBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.fexcraft.mod.lib.util.cls.EnumMashineType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ElectricalFurnace extends FBC_4R implements IMashineBlock {

	public ElectricalFurnace() {
		super(Material.ANVIL);
		BlockUtil.register(Static.MODID, this);
		BlockUtil.registerFIB(this);
		BlockUtil.registerFIBRender(this);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new ElectricalFurnaceEntity();
	}

	@Override
	public boolean isMashine(){
		return true;
	}

	@Override
	public String getName(){
		return "electric_furnace";
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}

	@Override
	public EnumMashineType getMashineType(){
		return EnumMashineType.PRODUCTION;
	}
	
	@Override
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		if(!w.isRemote){
			if(!p.isSneaking()){
				p.openGui(IE.getInstance(), GuiHandler.ELECTRICFURNACE, w, pos.getX(), pos.getY(), pos.getZ());
				return true;
			}
		}
		return false;
	}
	
}