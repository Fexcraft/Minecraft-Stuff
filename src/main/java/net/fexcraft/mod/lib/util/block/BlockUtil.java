package net.fexcraft.mod.lib.util.block;

import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.cls.Print;
import net.fexcraft.mod.lib.util.item.FIB;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockUtil{

	public static void register(String modid, Block block) {
		if(block instanceof IBlock == false){
			Print.log("[FCL:BlockRegistry] Block '" + block.toString() + "' not implementing IBlock, skipping!");
			return;
		}
		block.setRegistryName(modid, ((IBlock)block).getName());
		block.setUnlocalizedName(block.getRegistryName().toString());
		GameRegistry.register(block);
	}

	public static void registerFIB(Block block) {
		if(block instanceof IBlock == false){
			Print.log("[FCL:BlockRegistry] Block '" + block.toString() + "' not implementing IBlock, skipping!");
			return;
		}
		FIB item = new FIB(block, ((IBlock)block).getName(), ((IBlock)block).getVariantAmount());
		GameRegistry.register(item);
	}
	
	public static void registerFIBRender(Block block){
		if(block instanceof IBlock == false){
			Print.log("[FCL:BlockRegistry] Block '" + block.toString() + "' not implementing IBlock, skipping!");
			return;
		}
		FIB fib = (FIB)Item.getItemFromBlock(block);
		ItemUtil.registerRender(fib);
	}
	
	public static void registerCustomFIB(FIB item){
		GameRegistry.register(item);
	}
	
	public static Material getMaterial(String material){
		switch(material){
			case "air": return Material.AIR;
			case "grass": return Material.GRASS;
			case "ground": return Material.GROUND;
			case "wood": return Material.WOOD;
			case "rock": return Material.ROCK;
			case "iron": return Material.IRON;
			case "anvil": return Material.ANVIL;
			case "water": return Material.WATER;
			case "lava": return Material.LAVA;
			case "leaves": return Material.LEAVES;
			case "plants": return Material.PLANTS;
			case "vine": return Material.VINE;
			case "sponge": return Material.SPONGE;
			case "cloth": return Material.CLOTH;
			case "fire": return Material.FIRE;
			case "sand": return Material.SAND;
			case "circuits": return Material.CIRCUITS;
			case "carpet": return Material.CARPET;
			case "glass": return Material.GLASS;
			case "redstone_light": return Material.REDSTONE_LIGHT;
			case "tnt": return Material.TNT;
			case "coral": return Material.CORAL;
			case "ice": return Material.ICE;
			case "packed_ice": return Material.PACKED_ICE;
			case "snow": return Material.SNOW;
			case "crafted_snow": return Material.CRAFTED_SNOW;
			case "cactus": return Material.CACTUS;
			case "clay": return Material.CLAY;
			case "gourd": return Material.GOURD;
			case "dragon_egg": return Material.DRAGON_EGG;
			case "portal": return Material.PORTAL;
			case "cake": return Material.CAKE;
			case "web": return Material.WEB;
			default: return Material.AIR;
		}
	}
	
}