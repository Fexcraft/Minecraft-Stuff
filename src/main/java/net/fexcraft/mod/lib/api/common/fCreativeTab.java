package net.fexcraft.mod.lib.api.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface fCreativeTab {
    
	public String name();
	
	public String icon() default "minecraft:snowball";
	
	public short meta() default 0;
	
}