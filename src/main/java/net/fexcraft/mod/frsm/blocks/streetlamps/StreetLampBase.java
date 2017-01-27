package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.lib.api.block.öBlock;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

@öBlock(modid = FI.MODID, name = "streetlamp_base", tileentity = StreetLampBaseEntity.class)
public class StreetLampBase extends FBC_4R implements StreetLampPostEntity.Connectable {

	public StreetLampBase(){
		super(Material.IRON);
		this.setCreativeTab(CD.STREETS);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new StreetLampBaseEntity();
	}
	
}