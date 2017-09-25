package net.fexcraft.mod.nvr.common.enums;

public enum NationType {
	
	MONARCHY (true , false),//current ruler selects next ruler, sets goverment positions, no voting
	DEMOCRACY(false, true ),//all important things need to get a vote from majority of the goverment, where the current ruler suggest stuff, goverment selected via vote
	AUTOCRACY(true , true ),//hybrid of the 2 above
	ANARCHY  (false, false);//any one rules over one self.
	
	public final boolean singleruler;
	public final boolean voting;
	
	NationType(boolean sr, boolean v){
		this.singleruler = sr;
		this.voting = v;
	}
	
	public static NationType fromString(String string){
		NationType type = valueOf(string);
		return type == null ? ANARCHY : type;
	}
	
}