package net.fexcraft.mod.extensions.ce.render;

import net.fexcraft.mod.extensions.ce.blocks.CE_Blocks;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class RenderRegistry{
	
	public static void register(){
		ClientRegistry.bindTileEntitySpecialRenderer(CE_Blocks.Clock2.TE.class, new Clock2Render());
		ClientRegistry.bindTileEntitySpecialRenderer(CE_Blocks.Calendar1.TE.class, new Calendar1Render());
		ClientRegistry.bindTileEntitySpecialRenderer(CE_Blocks.Clock1C.TEC.class, new Clock1CRender());
		ClientRegistry.bindTileEntitySpecialRenderer(CE_Blocks.Clock2C.TEC.class, new Clock2CRender());
		ClientRegistry.bindTileEntitySpecialRenderer(CE_Blocks.Calendar1C.TECL.class, new Calendar1CRender());
		ClientRegistry.bindTileEntitySpecialRenderer(CE_Blocks.Clock3_W.TE.class, new Clock3Render("W"));
		ClientRegistry.bindTileEntitySpecialRenderer(CE_Blocks.Clock3_B.TE.class, new Clock3Render("B"));
	}
}