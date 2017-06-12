package net.fexcraft.mod.lib.api.render;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.minecraft.tileentity.TileEntity;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface fTESR {

	@Deprecated
	Class<? extends TileEntity> tileentity() default TileEntity.class;
	
}