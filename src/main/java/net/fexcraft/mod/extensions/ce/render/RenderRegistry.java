package net.fexcraft.mod.extensions.ce.render;

import net.fexcraft.mod.extensions.ce.blocks.CE_Blocks;
import net.fexcraft.mod.extensions.ce.blocks.ClockTileEntityBase;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class RenderRegistry{
	
	public static void register(){;
		ClientRegistry.bindTileEntitySpecialRenderer(CE_Blocks.Calendar1.TE.class, new Calendar1Render());
		ClientRegistry.bindTileEntitySpecialRenderer(CE_Blocks.Calendar1C.TECL.class, new Calendar1CRender());
		
		ClientRegistry.bindTileEntitySpecialRenderer(ClockTileEntityBase.class, new ClockRenderBase());
	}
}