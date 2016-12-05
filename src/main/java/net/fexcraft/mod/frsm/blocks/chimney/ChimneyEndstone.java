package net.fexcraft.mod.frsm.blocks.chimney;

import java.util.Random;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ChimneyEndstone extends ChimneyBase {
    
	public ChimneyEndstone() {
		super(Material.ROCK);
		this.setCreativeTab(CD.BLOCKS.getCreativeTab());
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerFIB(this);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new ChimneyEndstoneEntity();
	}
	
	@Override
	public String getName(){
		return "chimney4";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState state, World w, BlockPos pos, Random random){
		double d0 = (double)((float)pos.getX() + 0.4F + random.nextFloat() * 0.2F);
		double d1 = (double)((float)pos.getY() + 0.7F + random.nextFloat() * 0.3F);
		double d2 = (double)((float)pos.getZ() + 0.4F + random.nextFloat() * 0.2F);
		w.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		w.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, 0.0D, 0.1D, 0.0D);
		w.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		w.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, 0.0D, 0.1D, 0.0D);
		w.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		w.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, 0.0D, 0.1D, 0.0D);
		w.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		w.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, 0.0D, 0.1D, 0.0D);
		w.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		w.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, 0.0D, 0.1D, 0.0D);
		w.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		w.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, 0.0D, 0.1D, 0.0D);
		w.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		w.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, 0.0D, 0.1D, 0.0D);
	}

}