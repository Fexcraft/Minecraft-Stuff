package net.fexcraft.mod.extensions.ie.tileentities;

import net.fexcraft.mod.extensions.ie.util.EFIO;
import net.minecraft.util.EnumFacing;

public class CableType4CopperBridgeEntity extends CableType4BridgeEntity {
	
	@Override
	public String getContainerName(){
		return "Cable Type 4 Copper Bridge";
	}

	@Override
	public String getContainerId(){
		return "cabletype4_copper_bridge";
	}

	@Override
	public int fpu_max(EnumFacing ef){
		return 258;
	}

	@Override
	public int fpu_min(EnumFacing ef){
		return 0;
	}

	@Override
	public int fpu_transfer_speed(EnumFacing ef){
		for(EFIO e : getIO().get()){
			if(e.facing.equals(ef)){
				switch(e.cthickness){
					case 2:
						return 108;
					case 4:
						return 54;
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