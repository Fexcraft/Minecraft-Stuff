package net.fexcraft.mod.frsm.commads;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.frsm.util.Data;
import net.fexcraft.mod.frsm.util.FI;
import static net.fexcraft.mod.frsm.util.CCS.*;

import net.fexcraft.mod.lib.api.common.fCommand;
import net.fexcraft.mod.lib.network.Browser;
import net.fexcraft.mod.lib.network.Network;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;

@fCommand
public class MainCommand extends CommandBase {

	private final ArrayList aliases;
	private static final String restart = RED + "Changes apply after game restart.";
	private static final String experimental = RED + "This is an Experimental Feature, use on own responsability.";
	private static final String error = RED + "Error, Invalid argument.";
	private ICommandSender sender;
  
    public MainCommand(){ 
        aliases = new ArrayList(); 
        aliases.add("fex");
        aliases.add("frsmod");
    }
    
    @Override 
    public String getName(){ 
        return "frsm"; 
    } 

    @Override         
    public String getUsage(ICommandSender var1){ 
        return "/frsm help"; 
    }
    
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender){
    	if(sender.getCommandSenderEntity() instanceof EntityPlayer){
    		return true;
    	}
    	else{
    		return true;
    	}
    }
    
    @Override 
    public List getAliases() { 
        return this.aliases;
    } 

    @Override 
    public void execute(MinecraftServer server, ICommandSender sender, String[] args)  throws CommandException{
    	this.sender = sender;
        if(args.length < 1){
        	print(DAQUA + "/frsm <args>");
        	return;
        }
        switch(args[0]){
        	case "help":
        	case "?":
        	case "list":
        		print(FI.PREFIX + " Welcome back " + sender.getName() + "!");
        		print(DAQUA + "List of available arguments:");
        		print(WHITE + "download, version, changelog, config, help, reload, resyc, grn");
        		print(DAQUA + "Do '/frsm <arg> help to find out more.'");
        		break;
        	case "config":
        		print(FI.PREFIX + " Currently disabled.");
        		break;
        	case "version":
        		print(FI.PREFIX + DAQUA + " Version: " + DPURPLE + FI.VERSION);
        		break;
        	case "download":
        	case "dl":
        		processDownload(args, server);
        		break;
        	case "grn":
        		if(args.length < 2){
        			ItemStack stack = ((EntityPlayer)sender.getCommandSenderEntity()).getHeldItemMainhand();
            		print(FI.PREFIX + DGRAY + " RGN: " + LPURPLE + stack.getItem().getRegistryName() + DAQUA + " [M:" + stack.getItemDamage() + "|A:" + stack.getCount() + "]");
        		}
        		else if(args[1].equals("help")){
        			print(FI.PREFIX + " GRN - Get Registry Name;");
        			print("Displays the registry name of the currently held item.");
        			print("Use '/frsm grn raytrace' to get the registry name of the block you are currently looking at.");
        		}
        		else if(args[1].equals("raytrace")){
        			RayTraceResult rtr = ((EntityPlayer)sender.getCommandSenderEntity()).rayTrace(4, 1);
        			if(rtr.typeOfHit != RayTraceResult.Type.BLOCK){
        				print("No block in reach.");
        			}
        			else{
        				IBlockState state = ((EntityPlayer)sender.getCommandSenderEntity()).getEntityWorld().getBlockState(rtr.getBlockPos());
        				print(FI.PREFIX + DGRAY + " RGN: " + LPURPLE + state.getBlock().getRegistryName().toString() + DAQUA + " [M:" + state.getBlock().getMetaFromState(state) + "]");
        			}
        		}
        		else{
        			print("Invalid argument, try '/frsm grn help';");
        		}
        		break;
        	case "changelog":
        		if(args.length < 2){
            		Print.chat(sender, Data.getData().get("changelog").getAsString());
            	}
            	else if(args[1].equals("help")){
            		Print.chat(sender, "Used to check the current changelog data.");
            	}
            	else{
            		print(error);
            	}
        		break;
        	case "reload":
        	case "resync":
        		if(args.length < 2){
            		if(Network.isConnected()){
                		Data.getDataFromServer();
                		print("Resync Complete.");
            		}
            		else{
            			print("Couldn't connect to Data Server.");
            		}
            	}
            	else if(args[1].equals("help")){
            		Print.chat(sender, "Used to re-sync with the server data.");
            	}
            	else{
            		sender.sendMessage(new TextComponentString(error));
            	}
        		break;
        	default:
        		print(error);
        		break;
        }
    }

    private void processDownload(String[] args, MinecraftServer server) {
    	if(args.length < 2){
    		Print.chat(sender, FI.PREFIX + DGRAY + "================");
    		Print.chat(sender, DAQUA + "List of avaible download sources: ");
    		for(JsonElement elm : Data.getData().get("download_links").getAsJsonArray()){
    			JsonObject obj = elm.getAsJsonObject();
    			String prefix = getRandomPrefix();
    			Print.chat(sender, prefix + DGREEN + obj.get("name").getAsString());
    			Print.chat(sender, prefix + obj.get("link").getAsString());
    			Print.chat(sender, prefix + "Source ID: " + GREEN + obj.get("id").getAsString());
    		}
    		Print.chat(sender, DAQUA+ "You can also use '/frsm download <source_id>'");
    		Print.chat(sender, DAQUA + "to open the link in your default browser.");
    	}
    	else if(args[1].equals("help")){
    		Print.chat(sender, "Command used to get the downloading links for this mod, or to directly open an new browser tab with the seleted link.");
    		Print.chat(sender, DAQUA + "Try '/frsm download'.");
    	}
    	else if(args.length == 2){
    		if(args[1] == null){
    			Print.chat(sender, error);
    			return;
    		}
    		String arg = args[1];
    		boolean found = false;
    		for(JsonElement elm : Data.getData().get("download_links").getAsJsonArray()){
    			if(elm.getAsJsonObject().get("id").getAsString().equals(arg)){
    				Print.chat(sender, "opening...");
    				Browser.browse(sender, elm.getAsJsonObject().get("link").getAsString());
    				found = true;
    			}
    		}
    		if(found == false){
    			Print.chat(sender, RED + "Error, wrong download source id.");
    		}
    	}
    	else{
    		Print.chat(sender, error);
    		Print.chat(sender, DAQUA + "Try '/frsm download <source_id>'.");
    	}
	}
    
    public String getRandomPrefix(){
    	int i1 = Static.random.nextInt(15);
    	int i2 = Static.random.nextInt(15);
    	String string = fromInt(i1) + "[" + fromInt(i2) + "#" + fromInt(i1) + "] " + GRAY;
    	return string;
    }
    
    private void print(String string){
    	Print.chat(sender, string);
    }
}

