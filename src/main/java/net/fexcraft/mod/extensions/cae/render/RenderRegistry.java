package net.fexcraft.mod.extensions.cae.render;

import net.fexcraft.mod.extensions.cae.tileentities.CABTE;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class RenderRegistry{
	
	public static void register(){
		ClientRegistry.bindTileEntitySpecialRenderer(CABTE.class, new CustomAsphaltBlockRenderer());
	}
}