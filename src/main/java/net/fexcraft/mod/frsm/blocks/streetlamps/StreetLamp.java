package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

@fBlock(modid = FI.MODID, name = "streetlamp_lamp", tileentity = StreetLampEntity.class)
public class StreetLamp extends FBC_4R implements StreetLampPostEntity.Connectable {

	public StreetLamp(){
		super(Material.IRON);
		this.setCreativeTab(CD.STREETS);
		this.setLightLevel(2F);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new StreetLampEntity();
	}
	
}