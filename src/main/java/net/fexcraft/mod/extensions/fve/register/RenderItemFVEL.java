package net.fexcraft.mod.extensions.fve.register;

import net.fexcraft.mod.extensions.fve.blocks.FVEBB;
import net.fexcraft.mod.extensions.fve.blocks.FVELBlocks;
import net.fexcraft.mod.extensions.fve.util.FI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;

public final class RenderItemFVEL{
	public static void init(Side side){
	     if(side == Side.CLIENT){
	    	 RenderItem renderItem = Minecraft.getMinecraft().getRenderItem(); 
	     
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C5L), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C5L).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C5LBlue), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C5LBlue).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C5LRed), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C5LRed).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C5LGreen), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C5LGreen).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C5LBlack), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C5LBlack).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C5LWhite), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C5LWhite).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C5LPink), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C5LPink).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C5LPurple), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C5LPurple).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C5LOrange), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C5LOrange).getName(), "inventory"));
	      	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C5LCyan), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C5LCyan).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C5LYellow), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C5LYellow).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C5LBrown), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C5LBrown).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C5LGray), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C5LGray).getName(), "inventory"));
	     	 //
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C6L), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C6L).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C6LBlue), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C6LBlue).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C6LRed), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C6LRed).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C6LBlack), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C6LBlack).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C6LWhite), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C6LWhite).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C6LGray), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C6LGray).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C6LSilver), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C6LSilver).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C6LYellow), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C6LYellow).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C6LBeige), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C6LBeige).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C6LPink), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C6LPink).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C6LBrown), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C6LBrown).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C6LOrange), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C6LOrange).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C6LPurple), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C6LPurple).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.C6LC), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.C6LC).getName(), "inventory"));
	     	 //
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.T1L), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.T1L).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.T1LBlue), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.T1LBlue).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.T1LRed), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.T1LRed).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.T1LBlack), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.T1LBlack).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.T1LWhite), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.T1LWhite).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.T1LGray), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.T1LGray).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.T1LSilver), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.T1LSilver).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.T1LYellow), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.T1LYellow).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.T1LBeige), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.T1LBeige).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.T1LPink), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.T1LPink).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.T1LBrown), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.T1LBrown).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.T1LOrange), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.T1LOrange).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.T1LPurple), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.T1LPurple).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.T1LCyan), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.T1LCyan).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVELBlocks.T1LC), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVELBlocks.T1LC).getName(), "inventory"));
	     	 //
	     }
	}
}