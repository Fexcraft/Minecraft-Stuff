package net.fexcraft.mod.extensions.fve.register;

import net.fexcraft.mod.extensions.fve.blocks.FVEBB;
import net.fexcraft.mod.extensions.fve.blocks.FVERBlocks;
import net.fexcraft.mod.extensions.fve.util.FI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;

public final class RenderItemFVER{
	public static void init(Side side){
	     if(side == Side.CLIENT){
	    	 RenderItem renderItem = Minecraft.getMinecraft().getRenderItem(); 
	     
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C5R), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C5R).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C5RBlue), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C5RBlue).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C5RRed), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C5RRed).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C5RGreen), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C5RGreen).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C5RBlack), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C5RBlack).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C5RWhite), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C5RWhite).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C5RPink), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C5RPink).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C5RPurple), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C5RPurple).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C5ROrange), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C5ROrange).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C5RCyan), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C5RCyan).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C5RYellow), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C5RYellow).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C5RBrown), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C5RBrown).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C5RGray), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C5RGray).getName(), "inventory"));
	     	 //
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C6R), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C6R).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C6RBlue), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C6RBlue).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C6RRed), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C6RRed).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C6RBlack), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C6RBlack).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C6RWhite), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C6RWhite).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C6RGray), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C6RGray).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C6RSilver), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C6RSilver).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C6RYellow), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C6RYellow).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C6RBeige), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C6RBeige).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C6RPink), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C6RPink).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C6RBrown), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C6RBrown).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C6ROrange), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C6ROrange).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C6RPurple), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C6RPurple).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.C6RC), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.C6RC).getName(), "inventory"));
	     	 //
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.T1R), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.T1R).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.T1RBlue), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.T1RBlue).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.T1RRed), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.T1RRed).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.T1RBlack), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.T1RBlack).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.T1RWhite), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.T1RWhite).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.T1RGray), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.T1RGray).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.T1RSilver), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.T1RSilver).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.T1RYellow), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.T1RYellow).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.T1RBeige), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.T1RBeige).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.T1RPink), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.T1RPink).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.T1RBrown), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.T1RBrown).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.T1ROrange), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.T1ROrange).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.T1RPurple), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.T1RPurple).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.T1RCyan), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.T1RCyan).getName(), "inventory"));
	     	 renderItem.getItemModelMesher().register(Item.getItemFromBlock(FVERBlocks.T1RC), 0, new ModelResourceLocation(FI.MODID + ":" + ((FVEBB) FVERBlocks.T1RC).getName(), "inventory"));
	     	 //
	     }
	}
}