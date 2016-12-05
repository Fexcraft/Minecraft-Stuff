package net.fexcraft.mod.extensions.ie.tileentities;

import net.fexcraft.mod.extensions.ie.util.EFIO;
import net.minecraft.util.EnumFacing;

public class CableType4CopperEntity extends CableType4Entity {

	@Override
	public int fpu_max(EnumFacing ef){
		return 248;
	}
	
	@Override
	public String getContainerName(){
		return "Cable Type 4 Copper";
	}

	@Override
	public String getContainerId(){
		return "cabletype4_copper";
	}
	
	@Override
	public int fpu_transfer_speed(EnumFacing ef){
		for(EFIO e : getIO().get()){
			if(e.facing.equals(ef)){
				switch(e.cthickness){
					case 2:
						return 52;
					case 4:
						return 104;
				}
			}
		}
		return 0;
	}

	@Override
	public int fpu_min_transfer_speed(EnumFacing ef){
		for(EFIO e : getIO().get()){
			if(e.facing.equals(ef)){
				switch(e.cthickness){
					case 2:
						return 5;
					case 4:
						return 10;
				}
			}
		}
		return 0;
	}
	
}