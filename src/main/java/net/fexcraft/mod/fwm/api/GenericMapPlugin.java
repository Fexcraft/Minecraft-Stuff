package net.fexcraft.mod.fwm.api;

import java.io.File;

import net.fexcraft.mod.fwm.util.Files;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public abstract class GenericMapPlugin {
	
	private final String name;
	private final String id;
	private final String version;
	private final File directory;
	
	public GenericMapPlugin(){
		MapPlugin data = this.getClass().getAnnotation(MapPlugin.class);
		name = data.name();
		id = data.id();
		version = data.version();
		directory = Files.getFile("plugins/" + id + "/");
	}
	
	public final String getName(){
		return name;
	}
	
	public final String getId(){
		return id;
	}
	
	public final String getVersion(){
		return version;
	}
	
	public final File getDataDirectory(){
		return directory;
	}
	
	public abstract void initialise(FMLInitializationEvent event);
	
	public abstract void disable();
	
	
}