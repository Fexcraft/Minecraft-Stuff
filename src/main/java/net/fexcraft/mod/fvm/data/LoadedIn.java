package net.fexcraft.mod.fvm.data;

public enum LoadedIn {
	
	NULL("null"), ENTITY("entity"), TILE("tile"), MEMORY("memory");
	
	private String string;
	
	LoadedIn(String string){
		this.string = string;
	}
	
	@Override
	public String toString(){
		return string;
	}

	public boolean isLoadedInMemory(){
		return this == MEMORY;
	}
	
	public LoadedIn fromString(String string){
		for(LoadedIn li : values()){
			if(li.string.equals(string)){
				return li;
			}
		}
		return NULL;
	}
	
}