package net.fexcraft.mod.famm.blocks;

import java.util.ArrayList;
import net.minecraft.block.Block;

public final class FAMMBlocks{
	
	/*public static Block a;
	public static Block b;
	public static Block c;
	public static Block d;
	public static Block e;
	public static Block f;
	public static Block g;
	public static Block h;
	public static Block i;
	public static Block j;
	public static Block k;
	public static Block l;
	public static Block m;
	public static Block n;
	public static Block o;
	public static Block p;
	public static Block q;
	public static Block r;
	public static Block s;
	public static Block t;
	public static Block u;
	public static Block v;
	public static Block w;
	public static Block x;
	public static Block y;
	public static Block z;
	public static Block n0;
	public static Block n1;
	public static Block n2;
	public static Block n3;
	public static Block n4;
	public static Block n5;
	public static Block n6;
	public static Block n7;
	public static Block n8;
	public static Block n9;
	public static Block plus;
	public static Block minus;
	public static Block empty;
	public static Block questionmark;
	public static Block exclamationmark;
	public static Block point;
	public static Block pointdown;
	public static Block comma;
	public static Block colon;
	public static Block space;
	public static Block stop;
	public static Block arrowright;
	public static Block arrowleft;
	public static Block arrowtop;
	public static Block arrowbot;
	public static Block ri;
	public static Block rii;
	public static Block riii;
	public static Block riv;
	public static Block rv;
	public static Block rvi;
	public static Block rvii;
	public static Block rviii;
	public static Block rix;
	public static Block rx;
	public static Block rr;
	public static Block cr;
	public static Block eh;
	public static Block es;
	public static Block ea;
	public static Block ec;
	public static Block d1;
	public static Block d2;*/
	
	public static String[] blocknames =
		new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
					"n0", "n1", "n2", "n3", "n4", "n5", "n6", "n7", "n8", "n9", "plus", "minus", "empty", "questionmark", "exclamationmark", "point",
					"pointdown", "comma", "colon", "space", "stop", "arrowright", "arrowleft", "arrowtop", "arrowbot", "ri", "rii", "riii", "riv", "rv",
					"rvi", "rvii", "rviii", "rix", "rx", "rr", "cr", "eh", "es", "ea", "ec", "d1", "d2"};
	
	public static ArrayList<Block> blocks = new ArrayList<Block>();
	
	public static Block get(String id){
		Block result = null;
		for(Block block : blocks){
			if(block.getRegistryName().getResourcePath().equals(id)){
				result = block;
				break;
			}
		}
		return result;
	}
  
	public static void initializeDefault(){
		for(int i = 0; i < blocknames.length; i++){
			Block block = new FAMMBLK(blocknames[i]);
			blocks.add(block);
		}
    }
	
	public static void initializeHalfBlocks(){
		for(int i = 0; i < blocknames.length; i++){
			Block block = new FAMMBLKH(blocknames[i] + "_hb");
			blocks.add(block);
		}
    }
	
}