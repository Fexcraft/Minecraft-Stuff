package net.fexcraft.mod.fsu.server.modules;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface fModule {
	
	public String id();
	
	public String config_description();
	
	public boolean def_enabled();
	
}