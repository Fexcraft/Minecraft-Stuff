package net.fexcraft.mod.lib.util.item;

import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.cls.Print;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class ItemUtil{
	
	public static void register(String modid, Item item){
		if(item instanceof IItem == false){
			Print.log("[FCL:ItemRegistry] Item '" + item.toString() + "' not implementing IItem, skipping!");
			return;
		}
		item.setRegistryName(modid, ((IItem)item).getName());
		item.setUnlocalizedName(item.getRegistryName().toString());
		GameRegistry.register(item);
	}
	
	public static void registerRender(Item item, int meta){
		if(meta > 1){
			for(int i = 0; i < meta; i++){
				ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName() + "_" + i, "inventory"));
			}
		}
		else{
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}
	
	public static void registerRender(IItem item){
		if(FMLCommonHandler.instance().getSide() == Side.CLIENT){
			registerRender((Item)item, item.getVariantAmount());
		}
	}
}