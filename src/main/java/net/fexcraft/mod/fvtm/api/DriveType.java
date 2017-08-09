package net.fexcraft.mod.fvtm.api;

public enum DriveType {
	
	TRACKS, FWD, RWD, AWD;

	public boolean hasTracks(){
		return this == TRACKS;
	}
	
	public boolean isFWD(){
		return this == FWD;
	}
	
	public boolean isRWD(){
		return this == RWD;
	}
	
	public boolean is4WD(){
		return this == AWD;
	}

}
