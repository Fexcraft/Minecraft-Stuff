package net.fexcraft.mod.nvr.common.enums;

public enum MunicipalityType {
	
	HAMLET    (  0,  3, "Hamlet"),
	VILLAGE   (  8,  4, "Village"),
	SMALL_TOWN( 16,  8, "Small Town"),
	TOWN      ( 24, 12, "Town"),
	LARGE_TOWN( 32, 16, "Large Town"),
	CITY      ( 40, 20, "City"),
	LARGE_CITY( 60, 28, "Large City"),
	METROPOLIS(120, 36, "Metropolis"),
	TOO_LARGE (160, 50, "TOO LARGE OF A CITY"),
	INVALID   (  0,  0, "Invalid"),
	ABANDONED (  0,  0, "(Abandoned)");
	
	private int req;//required citizen to expand district amount
	private int dis;//district limit
	private String title;
	
	MunicipalityType(int i, int j, String name){
		req = i; dis = j;
		this.title = name;
	}
	
	public static MunicipalityType fromString(String string){
		MunicipalityType type = valueOf(string);
		return type == null ? INVALID : type;
	}
	
	public final String getTitle(){
		return title;
	}
	
}