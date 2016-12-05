package net.fexcraft.mod.extensions.ie.util;

import net.fexcraft.mod.lib.api.tileentity.ICableTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class Util {
	
	public static String s(EnumFacing ef, ICableTileEntity cable){
		if(cable.fpu_get(null) >= cable.fpu_max(null)){
			return " (F)";
		}
		if(cable.fpu_get(null) <= cable.fpu_min(null)){
			return " (E)";
		}
		return "";
	}
	
	public static BlockPos getPosFromFacing(EnumFacing facing, BlockPos pos){
		switch(facing){
			case NORTH: return new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
			case SOUTH: return new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);
			case WEST:  return new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
			case EAST:  return new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
			default: return pos;
		}
	}
}