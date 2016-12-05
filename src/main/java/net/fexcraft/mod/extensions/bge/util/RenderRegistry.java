package net.fexcraft.mod.extensions.bge.util;

import net.fexcraft.mod.extensions.bge.BGE;
import net.fexcraft.mod.extensions.bge.render.BLK1R;
import net.fexcraft.mod.extensions.bge.render.DiceRender;
import net.fexcraft.mod.extensions.bge.render.RCT;
import net.fexcraft.mod.extensions.bge.tileentities.BLK1TE;
import net.fexcraft.mod.extensions.bge.tileentities.CTTE;
import net.fexcraft.mod.extensions.bge.tileentities.DiceTileEntity;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class RenderRegistry{
	
	@Deprecated
	public static void registerItemRender(){
		for(int i = 0; i < 16; i++){
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BGE.blk1), i, new ModelResourceLocation(BGE.blk1.getRegistryName() + "_" + i, "inventory"));
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BGE.ct), i, new ModelResourceLocation(BGE.ct.getRegistryName() + "_" + i, "inventory"));
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BGE.dice), i, new ModelResourceLocation(BGE.dice.getRegistryName() + "_" + i, "inventory"));
			
		}
	}
	
	public static void register(){
		ClientRegistry.bindTileEntitySpecialRenderer(BLK1TE.class, new BLK1R());
		ClientRegistry.bindTileEntitySpecialRenderer(CTTE.class, new RCT());
		ClientRegistry.bindTileEntitySpecialRenderer(DiceTileEntity.class, new DiceRender());
	}
}