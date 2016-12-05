package net.fexcraft.mod.fsmm.blocks;

import net.minecraft.block.Block;

public final class FSMMBlocks {

	public static Block atm;
	public static Block safe;
	
	public static void init() {
		
		atm = new ATM();
		//safe = new Safe();
	}
}