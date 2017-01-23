package net.fexcraft.mod.lib.api.render;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.minecraft.tileentity.TileEntity;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface öTESR {
	
	Class<? extends TileEntity> tileentity();
	
}