package net.fexcraft.mod.frsm.commads;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.frsm.util.Data;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.fsmm.util.CCS;
import net.fexcraft.mod.lib.network.Browser;
import net.fexcraft.mod.lib.network.Network;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class MainCommand extends CommandBase{

	private final ArrayList aliases;
	private String restart      = CCS.RED + "Changes apply after game restart.";
	private String experimental = CCS.RED + "This is an Experimental Feature, use on own responsability.";
	private String error        = CCS.RED + "Error, Invalid argument.";
  
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
        if (args.length < 1){
        	sender.sendMessage(new TextComponentString((CCS.DAQUA + "/frsm <args>")));
        }
        else if(args[0].equals("help") || args[0].equals("?") || args[0].equals("list")){
        	Print.chat(sender, FI.PREFIX + " Welcome back " + sender.getName() + "!");
        	Print.chat(sender, CCS.DAQUA + "List of avaible arguments:");
        	Print.chat(sender, "download, version, changelog, config");
        	Print.chat(sender, "help, reload, resync, grn");
        	Print.chat(sender, CCS.AQUA + "Do '/frsm <arg> help' to find out more.");
        }
        else if(args[0].equals("config")){
        	Print.chat(sender, "Currently disabled.");
        }
        else if(args[0].equals("version")){
        	Print.chat(sender, CCS.DAQUA + "Version: "+ FI.VERSION);
        }
        else if(args[0].equals("download")){
        	if(args.length < 2){
        		Print.chat(sender, FI.PREFIX + CCS.DGRAY + "================");
        		Print.chat(sender, CCS.DAQUA + "List of avaible download sources: ");
        		for(JsonElement elm : Data.getData().get("download_links").getAsJsonArray()){
        			JsonObject obj = elm.getAsJsonObject();
        			String prefix = getRandomPrefix();
        			Print.chat(sender, prefix + CCS.DGREEN + obj.get("name").getAsString());
        			Print.chat(sender, prefix + obj.get("link").getAsString());
        			Print.chat(sender, prefix + "Source ID: " + CCS.GREEN + obj.get("id").getAsString());
        		}
        		Print.chat(sender, CCS.DAQUA+ "You can also use '/frsm download <source_id>'");
        		Print.chat(sender, CCS.DAQUA + "to open the link in your default browser.");
        	}
        	else if(args[1].equals("help")){
        		Print.chat(sender, "Command used to get the downloading links for this mod, or to directly open an new browser tab with the seleted link.");
        		Print.chat(sender, CCS.DAQUA + "Try '/frsm download'.");
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
        			Print.chat(sender, CCS.RED + "Error, wrong download source id.");
        		}
        	}
        	else{
        		Print.chat(sender, error);
        		Print.chat(sender, CCS.DAQUA + "Try '/frsm download <source_id>'.");
        	}
        }
        else if(args[0].equals("grn")){
        	if(args.length < 2){
        		String rgn = ((EntityPlayer)sender.getCommandSenderEntity()).getHeldItemMainhand().getItem().getRegistryName().toString();
        		Print.chat(sender, FI.PREFIX + "RGN: " + rgn);
        	}
        	else if(args[1].equals("")){
        		
        	}
        	else{
        		return;
        	}
        }
        else if(args[0].equals("changelog")){
        	if(args.length < 2){
        		Print.chat(sender, Data.getData().get("changelog").getAsString());
        	}
        	else if(args[1].equals("help")){
        		Print.chat(sender, "Command used to check the current changelog.");
        	}
        	else{
        		sender.sendMessage(new TextComponentString(error));
        	}
        }
        else if(args[0].equals("reload") || args[0].equals("resync")){
        	if(args.length < 2){
        		if(Network.isConnected()){
            		Data.getDataFromServer();
            		Print.chat(sender, "Resync Complete.");
        		}
        		else{
        			Print.chat(sender, "Couldn't connect to server.");
        		}
        	}
        	else if(args[1].equals("help")){
        		Print.chat(sender, "Command used to re-sync with the server data.");
        	}
        	else{
        		sender.sendMessage(new TextComponentString(error));
        	}
        }
        else{
        	sender.sendMessage(new TextComponentString(error));
        }
    }

    @Override 
    public boolean isUsernameIndex(String[] var1, int var2) { 
    	return false;
    }
    
    public String getRandomPrefix(){
    	int i1 = Static.random.nextInt(15);
    	int i2 = Static.random.nextInt(15);
    	String string = CCS.intToCCS(i1) + "[" + CCS.intToCCS(i2) + "#" + CCS.intToCCS(i1) + "] " + CCS.GRAY;
    	return string;
    }
}

