package net.fexcraft.mod.lib.api.item;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface �Item {
	
	public String modid();
	
	public String name();
	
	public int variants() default 1;
	
	public String[] custom_variants() default {};
	
}