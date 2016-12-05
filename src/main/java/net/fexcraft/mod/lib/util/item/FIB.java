package net.fexcraft.mod.lib.util.item;

import net.fexcraft.mod.lib.api.item.IItem;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class FIB extends ItemBlock implements IItem{

	private String name;
	private int va;
	
	public FIB(Block block, String name, int va){
		super(block);
		this.name = name;
		this.va = va;
		this.setRegistryName(block.getRegistryName().toString());
		this.setUnlocalizedName(this.getRegistryName().toString());
	}

	@Override
	public String getName(){
		return name;
	}

	@Override
	public int getVariantAmount(){
		return va;
	}
	
}