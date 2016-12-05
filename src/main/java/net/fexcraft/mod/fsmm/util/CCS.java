package net.fexcraft.mod.fsmm.util;

import net.minecraft.util.text.TextFormatting;

/**
 * @author Ferdinand
 * @category Utils
 * @comment Color Chat Spaces
 */
public class CCS{
	
	public static String BLACK   = TextFormatting.BLACK        + "";
	public static String DBLUE   = TextFormatting.DARK_BLUE    + "";
	public static String DGREEN  = TextFormatting.DARK_GREEN   + "";
	public static String DAQUA   = TextFormatting.DARK_AQUA    + "";
	public static String DRED    = TextFormatting.DARK_RED     + "";
	public static String DPURPLE = TextFormatting.DARK_PURPLE  + "";
	public static String GOLD    = TextFormatting.GOLD         + "";
	public static String GRAY    = TextFormatting.GRAY         + "";
	public static String DGRAY   = TextFormatting.DARK_GRAY    + "";
	public static String BLUE    = TextFormatting.BLUE         + "";
	public static String GREEN   = TextFormatting.GREEN        + "";
	public static String AQUA    = TextFormatting.AQUA         + "";
	public static String RED     = TextFormatting.RED          + "";
	public static String LPURPLE = TextFormatting.LIGHT_PURPLE + "";
	public static String YELLOW  = TextFormatting.YELLOW       + "";
	public static String WHITE   = TextFormatting.WHITE        + "";
	
	public static String intToCCS(int i){
		switch(i){
			case 0: return BLACK;
			case 1: return DBLUE;
			case 2: return DGREEN;
			case 3: return DAQUA;
			case 4: return DRED;
			case 5: return DPURPLE;
			case 6: return GOLD;
			case 7: return GRAY;
			case 8: return DGRAY;
			case 9: return BLUE;
			case 10: return GREEN;
			case 11: return AQUA;
			case 12: return RED;
			case 13: return LPURPLE;
			case 14: return YELLOW;
			case 15: return WHITE;
			default: return DGREEN;
		}
	}
}