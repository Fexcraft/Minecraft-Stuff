package net.fexcraft.mod.lib.util.cls;

public enum EnumCableEditorMode{
	
	FACING("facing"), OUTPUT("output"), INPUT("input"), REMOVE("remove"),
	STATUS("status"), SPEED("speed"), STATS("stats"), ROTATION("rotation"),
	OTHER("other"), NULL("null");
	
	private String name;
	
	EnumCableEditorMode(String name){
		this.name = name;
	}
	
	public EnumCableEditorMode next(){
		EnumCableEditorMode e = null;
		switch(this){
			case FACING:   e = OUTPUT; break;
			case OUTPUT:   e = INPUT; break;
			case INPUT:    e = REMOVE; break;
			case REMOVE:   e = STATUS; break;
			case STATUS:   e = SPEED; break;
			case SPEED:    e = STATS; break;
			case STATS:    e = ROTATION; break;
			case ROTATION: e = OTHER; break;
			case OTHER:    e = FACING; break;
			default: e = NULL; break;
		}
		return e;
	}
	
	public String getName(){
		return name;
	}

	public static EnumCableEditorMode fromString(String string){
		for(EnumCableEditorMode e : values()){
			if(e.name.equals(string)){
				return e;
			}
		}
		return NULL;
	}
}