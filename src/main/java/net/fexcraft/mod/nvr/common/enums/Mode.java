package net.fexcraft.mod.nvr.common.enums;

public enum Mode {
	
	CLAIM         (0, "Claim", "cl"),
	TYPE          (1, "Ck. Type", "t"),
	DISTRICTS     (2, "District", "d"),
	MUNICIPALITIES(3, "Municip.", "m"),
	PROVINCES     (4, "Provinces", "p"),
	NATIONS       (5, "Nation", "n"),
	COMPANIES     (7, "Companies", "c"),
	LINKED        (8, "Linked Ck.", "l"),
	GEOGRAPHIC    (9, "Geographic", "g");
	
	private int id;
	private String name, fileprefix;
	
	Mode(int id, String string, String fileprefix){
		this.id = id;
		this.name = string;
		this.fileprefix = fileprefix;
	}

	public static Mode fromString(String mode){
		for(Mode en : values()){
			if(en.name().toLowerCase().equals(mode.toLowerCase())){
				return en;
			}
		}
		return TYPE;
	}

	public static Mode fromInt(int i){
		for(Mode en : values()){
			if(en.id == i){
				return en;
			}
		}
		return TYPE;
	}

	public String getFilePrefix(){
		return fileprefix;
	}

	public String getName() {
		return name;
	}
	
}