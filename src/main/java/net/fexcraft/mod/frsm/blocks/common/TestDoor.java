package net.fexcraft.mod.frsm.blocks.common;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;

public class TestDoor extends BlockDoor implements IBlock{

	public TestDoor() {
		super(Material.AIR);
		this.setCreativeTab(CD.DEV.getCreativeTab());
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerFIB(this);
	}

	@Override
	public String getName() {
		return "testdoor";
	}

	@Override
	public int getVariantAmount() {
		return default_variant;
	}
	
}