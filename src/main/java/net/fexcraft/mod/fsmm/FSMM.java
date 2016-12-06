package net.fexcraft.mod.fsmm;
 
import java.io.File;
import java.util.UUID;

import net.fexcraft.mod.fsmm.account.AccountManager;
import net.fexcraft.mod.fsmm.account.AccountManager.DefaultBank;
import net.fexcraft.mod.fsmm.blocks.FSMMBlocks;
import net.fexcraft.mod.fsmm.commands.FSMMCommand;
import net.fexcraft.mod.fsmm.gui.GuiATM;
import net.fexcraft.mod.fsmm.gui.GuiHandler;
import net.fexcraft.mod.fsmm.gui.Processor;
import net.fexcraft.mod.fsmm.items.FSMMItems;
import net.fexcraft.mod.fsmm.util.Data;
import net.fexcraft.mod.fsmm.util.FI;
import net.fexcraft.mod.fsmm.util.FSMMEventHandler;
import net.fexcraft.mod.fsmm.util.UpdateHandler;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.PacketHandler.PacketHandlerType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
 
@Mod(modid = FI.MODID, name = FI.MODNAME, version = FI.VERSION, updateJSON = "http://fexcraft.net/minecraft/fcl/request?mode=getForgeUpdateJson&modid=fsmm", dependencies = "required-after:fcl")
public class FSMM {
	
    @Mod.Instance(FI.MODID)
    private static FSMM instance;
    
	public static File config_path;
	public static boolean fsu_override;
	public static float starting_balance;
	public static UUID default_bank;
	public static boolean debug;
	
	private static AccountManager account_manager;
    
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) throws Exception{
		FSMMBlocks.init();
		FSMMItems.init();
		
		config_path = event.getSuggestedConfigurationFile().getParentFile();
		account_manager = new AccountManager();
		account_manager.initialize(event.getSuggestedConfigurationFile().getParentFile());
		
		Configuration config = new Configuration(new File(event.getSuggestedConfigurationFile().getParentFile(), "/fsmm/config.cfg"));
		config.load();
		starting_balance = config.getFloat("starting_balance", "General", 100, 0, 1000000, "Starting balance for a new player.");
		default_bank = UUID.fromString(config.getString("default_bank", "General", "00000000-0000-0000-0000-000000000000", "Default Bank the player will have an account in."));
		debug = config.getBoolean("debug", "General", false, "Prints some maybe useful data into console, suggested for bug-hunting.");
		config.save();
		
		account_manager.registerBank(new DefaultBank());
		
	}
	
	public static CreativeTabs tabFSMM = new CreativeTabs("tabFSMM") {
	    @Override
	    public ItemStack getTabIconItem() {
	    	return new ItemStack(FSMMItems.foney1000);
	    }
	};
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event){
		event.registerServerCommand(new FSMMCommand());
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event){
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		MinecraftForge.EVENT_BUS.register(new FSMMEventHandler());
		MinecraftForge.EVENT_BUS.register(new AccountManager.TickHandler());
		Data.getDataFromServer();
		UpdateHandler.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	fsu_override = Loader.isModLoaded("fsu");
    	if(event.getSide().isClient()){
        	PacketHandler.registerListener(PacketHandlerType.JSON, Side.CLIENT, new GuiATM.Receiver());
    	}
    	PacketHandler.registerListener(PacketHandlerType.JSON, Side.SERVER, new Processor());
    }
    
    public static FSMM getInstance(){
    	return instance;
    }

	public AccountManager getAccountManager() {
		return account_manager;
	}
}