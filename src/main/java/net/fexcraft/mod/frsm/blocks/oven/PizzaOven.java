package net.fexcraft.mod.frsm.blocks.oven;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.block.IPaintableBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.fexcraft.mod.lib.util.cls.EnumColor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PizzaOven extends FBC_4R implements IPaintableBlock {

	public PizzaOven() {
		super(Material.IRON);
		this.setCreativeTab(CD.TECHNIC.getCreativeTab());
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerFIB(this);
		BlockUtil.registerFIBRender(this);
	}

	@Override
	public String getName(){
		return "electric_pizza_oven";
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new PizzaOvenEntity();
	}

	@Override
	public void onPaintItemUse(EnumColor color, ItemStack stack, EntityPlayer player, BlockPos pos, World world) {
		if(!world.isRemote){
			((PizzaOvenEntity)world.getTileEntity(pos)).onPaintItemUse(color, stack, player, pos, world);
		}
	}
	
}