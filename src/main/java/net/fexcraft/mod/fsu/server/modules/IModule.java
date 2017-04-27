package net.fexcraft.mod.fsu.server.modules;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

public interface IModule<T> {
	
	public String getId();
	
	public void preInit(FMLPreInitializationEvent event);
	
	public void init(FMLInitializationEvent event);
	
	public void postInit(FMLPostInitializationEvent event);

	public void serverStart(FMLServerStartingEvent event);

	public void serverStop(FMLServerStoppingEvent event);
	
	public void setEnabled(boolean bool);
	
	public boolean isEnabled();
	
	public T getInstace();
	
}