package net.fexcraft.mod.extensions.ce.util;

import net.fexcraft.mod.extensions.ce.blocks.CEBB;
import net.fexcraft.mod.extensions.ce.blocks.CEBBC;
import net.fexcraft.mod.extensions.ce.blocks.CE_Blocks;
import net.fexcraft.mod.extensions.ce.items.CE_Items;
import net.fexcraft.mod.extensions.ce.items.Tool;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;

public final class RenderItemCE{
	public static void init(Side side){
	     if(side == Side.CLIENT){
	    	 RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
       	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(CE_Blocks.Clock_2),       0, new ModelResourceLocation("frsm_ce:" + ((CEBBC) CE_Blocks.Clock_2).getName(), "inventory"));
       	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(CE_Blocks.Calendar_1),    0, new ModelResourceLocation("frsm_ce:" + ((CEBB)  CE_Blocks.Calendar_1).getName(), "inventory"));
       	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(CE_Blocks.Clock_1C),      0, new ModelResourceLocation("frsm_ce:" + ((CEBB)  CE_Blocks.Clock_1C).getName(), "inventory"));
       	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(CE_Blocks.Clock_2C),      0, new ModelResourceLocation("frsm_ce:" + ((CEBBC) CE_Blocks.Clock_2C).getName(), "inventory"));
       	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(CE_Blocks.Calendar_1C),   0, new ModelResourceLocation("frsm_ce:" + ((CEBB)  CE_Blocks.Calendar_1C).getName(), "inventory"));
       	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(CE_Blocks.Clock_3W),      0, new ModelResourceLocation("frsm_ce:" + ((CEBB) CE_Blocks.Clock_3W).getName(), "inventory"));
       	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(CE_Blocks.Clock_3B),      0, new ModelResourceLocation("frsm_ce:" + ((CEBB) CE_Blocks.Clock_3B).getName(), "inventory"));
    	     
       	     renderItem.getItemModelMesher().register(CE_Items.universal_tool,    0, new ModelResourceLocation("frsm_ce:" + ((Tool) CE_Items.universal_tool).getName(), "inventory"));
    	     
	     }
	}
}