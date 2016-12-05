package net.fexcraft.mod.frsm.util.custom;

import java.util.ArrayList;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {
	
	public static ArrayList<IS> ls = new ArrayList<IS>();

	@Override
	public int getBurnTime(ItemStack fuel) {
		int value = 0;
		for(int i = 0; i < ls.size(); i++){
			if(fuel == ls.get(i).stack){
				value = ls.get(i).value;
			}
		}
		return value;
	}
	
	public static void init(){
		add(newIS(FRSM_Items.planks_oak,        0),   75);
		add(newIS(FRSM_Blocks.crate,            0), 1500);
		for(int i = 0; i < 16; i++){
			add(newIS(FRSM_Blocks.decoblock1,   i),  300);
		}
		add(newIS(FRSM_Blocks.decoblock2,       0),  300);
		add(newIS(FRSM_Blocks.framed_glowstone,  0),  900);
		add(newIS(FRSM_Blocks.wooden_light_box,   0),  400);
		for(int i = 0; i < 16; i++){
			add(newIS(FRSM_Blocks.lamp,         i),  100);
		}
		for(int i = 0; i < 16; i++){
			add(newIS(FRSM_Blocks.lamp_off,      i),  100);
		}
		add(newIS(FRSM_Blocks.palet1x1,         0), 1200);
		add(newIS(FRSM_Blocks.palet1x1_1,       0), 1200);
		add(newIS(FRSM_Blocks.palet1x1_2,       0), 1200);
		add(newIS(FRSM_Blocks.tbm,              0), 6000);
		//add(newIS(FRSM_Blocks.wb,               0), 1600);
		add(newIS(FRSM_Blocks.window,           0),  600);
	}
	
	private static ItemStack newIS(Item i, int meta){
		return new ItemStack(i, 1, meta);
	}
	
	private static ItemStack newIS(Block b, int meta){
		return new ItemStack(b, 1, meta);
	}
	
	public static void add(ItemStack is, int i){
		ls.add(new IS(is, i));
		//PrintLog.print("FRSM:FuelHandler", "Registered ItemStack '" + is + "' with value of '" + i + "'.");
	}
	
	private static class IS{
		private ItemStack stack;
		private int value;
		public IS(ItemStack is, int i){
			stack = is;
			value = i;
		}
	}
}