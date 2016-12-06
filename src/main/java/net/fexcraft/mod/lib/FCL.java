package net.fexcraft.mod.lib;

import java.util.UUID;

import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.fexcraft.mod.lib.network.BlackList;
import net.fexcraft.mod.lib.network.DonorValidator;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.SimpleUpdateHandler;
import net.fexcraft.mod.lib.util.cls.Print;
import net.fexcraft.mod.lib.util.cmds.Command;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 * 
 * @description This Library is currently part of FRSM,
 * if you got it from anywhere else then Fexcraft.net or another official download site,
 * consider deleting it instantly for security reasons!
 * 
 */
@Mod(modid = "fcl", name = "Fexcraft Common Library", version = FCL.version, acceptableRemoteVersions = "*", updateJSON = "http://fexcraft.net/minecraft/fcl/request?mode=getForgeUpdateJson&modid=fcl")
public class FCL {
	
	public static final String prefix = TextFormatting.BLACK + "[" + TextFormatting.DARK_AQUA + "FCL" + TextFormatting.BLACK + "]" + TextFormatting.GRAY + " ";
	public static final String version = "X.12";
	public static final String mcv = "1.10.2";
	public static final UUID[] authors = new UUID[]{UUID.fromString("01e4af9b-2a30-471e-addf-f6338ffce04b")};
	private static PacketHandler packet_handler;
	@Mod.Instance("fcl")
	private static FCL instance;
	private static Side side;
	
	@Mod.EventHandler
    public void init(FMLPreInitializationEvent event) throws Exception{
		RecipeRegistry.initalize();
		side = event.getSide();
	}
	@Mod.EventHandler
    public void init(FMLInitializationEvent event) throws Exception{
		MinecraftForge.EVENT_BUS.register(new SimpleUpdateHandler.EventHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new RecipeRegistry.GuiHandler());
		
    	GameRegistry.addShapelessRecipe(new ItemStack(RecipeRegistry.workbench, 4), new Object[]{
    		Items.IRON_INGOT, Blocks.CRAFTING_TABLE, Blocks.LOG
    	});
	}
	
	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event){
		event.registerServerCommand(new Command());
	}
	
	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) throws Exception{
		if(!Loader.isModLoaded("frsm")){
			SimpleUpdateHandler.register("fcl", 1, version);
			SimpleUpdateHandler.setUpdateMessage("fcl", prefix + "Update avaible! (" + SimpleUpdateHandler.getLatestVersionOf("fcl") + ")");
		}
		SimpleUpdateHandler.postInit();
		BlackList.initialize(side);
		DonorValidator.initialize(side);
		//Print.log("[FCL] Loaded.");
		packet_handler.init();
		Print.log("Loading complete.");
	}
	
	public static FCL getInstance(){
		return instance;
	}
	
	public static Side getSide(){
		return side;
	}
	
}