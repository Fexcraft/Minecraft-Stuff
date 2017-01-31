package net.fexcraft.mod.fsmm;
 
import net.fexcraft.mod.fsmm.account.AccountManager;
import net.fexcraft.mod.fsmm.account.AccountManager.DefaultBank;
import net.fexcraft.mod.fsmm.commands.FSMMCommand;
import net.fexcraft.mod.fsmm.gui.GuiATM;
import net.fexcraft.mod.fsmm.gui.GuiHandler;
import net.fexcraft.mod.fsmm.gui.Processor;
import net.fexcraft.mod.fsmm.items.FsmmItems;
import net.fexcraft.mod.fsmm.util.FI;
import net.fexcraft.mod.fsmm.util.FsmmEventHandler;
import net.fexcraft.mod.fsmm.util.FsmmConfig;
import net.fexcraft.mod.fsmm.util.UpdateHandler;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.PacketHandler.PacketHandlerType;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
 
@Mod(modid = FI.MODID, name = FI.MODNAME, version = FI.VERSION, updateJSON = "http://fexcraft.net/minecraft/fcl/request?mode=getForgeUpdateJson&modid=fsmm", dependencies = "required-after:fcl",
guiFactory = "net.fexcraft.mod.fsmm.util.GuiFactory")
public class FSMM {
	
    @Mod.Instance(FI.MODID)
    private static FSMM instance;
	
	private static AccountManager account_manager;
    
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) throws Exception{
		FsmmItems.initialize();
		FsmmConfig.initialize(event);
		Registry.registerAllBlocks(FI.MODID);
		
		account_manager = new AccountManager();
		account_manager.initialize(event.getModConfigurationDirectory());
		account_manager.registerBank(new DefaultBank());
	}
	
	public static CreativeTabs tabFSMM = new CreativeTabs("tabFSMM") {
	    @Override
	    public ItemStack getTabIconItem() {
	    	return new ItemStack(FsmmItems.foney1000);
	    }
	};
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event){
		event.registerServerCommand(new FSMMCommand());
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event){
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		MinecraftForge.EVENT_BUS.register(new FsmmEventHandler());
		MinecraftForge.EVENT_BUS.register(new AccountManager.TickHandler());
		UpdateHandler.initialize();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	FsmmConfig.FSU_OVERRIDE = Loader.isModLoaded("fsu");
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