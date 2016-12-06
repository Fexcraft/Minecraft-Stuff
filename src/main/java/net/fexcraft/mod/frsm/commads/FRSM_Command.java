package net.fexcraft.mod.frsm.commads;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.frsm.network.data.Data;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.PrintChat;
import net.fexcraft.mod.frsm.util.java.FR;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.network.Browser;
import net.fexcraft.mod.lib.network.Network;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class FRSM_Command extends CommandBase{

	private final ArrayList aliases;
	private String restart      = CCS.RED + "Changes apply after game restart.";
	private String experimental = CCS.RED + "This is an Experimental Feature, use on own responsability.";
	private String error        = CCS.RED + "Error, Invalid argument.";
  
    public FRSM_Command(){ 
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
    	
        //World world = sender.getEntityWorld();
    
        if (args.length < 1){
        	sender.sendMessage(new TextComponentString((CCS.DAQUA + "/frsm <args>")));
        }
        else if(args[0].equals("help") || args[0].equals("?") || args[0].equals("list")){
        	PrintChat.print(sender, FI.FRSMs + " Welcome back " + sender.getName() + "!");
        	PrintChat.print(sender, CCS.DAQUA + "List of avaible arguments:");
        	PrintChat.print(sender, "download, version, changelog, config");
        	PrintChat.print(sender, "help, reload, resync, grn");
        	PrintChat.print(sender, CCS.AQUA + "Do '/frsm <arg> help' to find out more.");
        }
        else if(args[0].equals("config")){
        	PrintChat.print(sender, "Currently disabled.");
        }
        else if(args[0].equals("version")){
        	PrintChat.print(sender, CCS.DAQUA + "Version: "+ FI.VERSION);
        }
        else if(args[0].equals("download")){
        	if(args.length < 2){
        		PrintChat.print(sender, FI.FRSMs + CCS.DGRAY + "================");
        		PrintChat.print(sender, CCS.DAQUA + "List of avaible download sources: ");
        		for(JsonElement elm : Data.getData().get("download_links").getAsJsonArray()){
        			JsonObject obj = elm.getAsJsonObject();
        			String prefix = getRandomPrefix();
        			PrintChat.print(sender, prefix + CCS.DGREEN + obj.get("name").getAsString());
        			PrintChat.print(sender, prefix + obj.get("link").getAsString());
        			PrintChat.print(sender, prefix + "Source ID: " + CCS.GREEN + obj.get("id").getAsString());
        		}
        		PrintChat.print(sender, CCS.DAQUA+ "You can also use '/frsm download <source_id>'");
        		PrintChat.print(sender, CCS.DAQUA + "to open the link in your default browser.");
        	}
        	else if(args[1].equals("help")){
        		PrintChat.print(sender, "Command used to get the downloading links for this mod, or to directly open an new browser tab with the seleted link.");
        		PrintChat.print(sender, CCS.DAQUA + "Try '/frsm download'.");
        	}
        	else if(args.length == 2){
        		if(args[1] == null){
        			PrintChat.print(sender, error);
        			return;
        		}
        		String arg = args[1];
        		boolean found = false;
        		for(JsonElement elm : Data.getData().get("download_links").getAsJsonArray()){
        			if(elm.getAsJsonObject().get("id").getAsString().equals(arg)){
        				PrintChat.print(sender, "opening...");
        				Browser.browse(sender, elm.getAsJsonObject().get("link").getAsString());
        				found = true;
        			}
        		}
        		if(found == false){
        			PrintChat.print(sender, CCS.RED + "Error, wrong download source id.");
        		}
        	}
        	else{
        		PrintChat.print(sender, error);
        		PrintChat.print(sender, CCS.DAQUA + "Try '/frsm download <source_id>'.");
        	}
        }
        else if(args[0].equals("grn")){
        	if(args.length < 2){
        		String rgn = ((EntityPlayer)sender.getCommandSenderEntity()).getHeldItemMainhand().getItem().getRegistryName().toString();
        		PrintChat.print(sender, FI.FRSMs, "RGN: " + rgn);
        	}
        	else if(args[1].equals("")){
        		
        	}
        	else{
        		return;
        	}
        }
        else if(args[0].equals("changelog")){
        	if(args.length < 2){
        		PrintChat.print(sender, Data.getData().get("changelog").getAsString());
        	}
        	else if(args[1].equals("help")){
        		PrintChat.print(sender, "Command used to check the current changelog.");
        	}
        	else{
        		sender.sendMessage(new TextComponentString(error));
        	}
        }
        else if(args[0].equals("reload") || args[0].equals("resync")){
        	if(args.length < 2){
        		if(Network.isConnected()){
            		Data.getDataFromServer();
            		PrintChat.print(sender, "Resync Complete.");
        		}
        		else{
        			PrintChat.print(sender, "Couldn't connect to server.");
        		}
        	}
        	else if(args[1].equals("help")){
        		PrintChat.print(sender, "Command used to re-sync with the server data.");
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
    	int i1 = FR.nextInt(15);
    	int i2 = FR.nextInt(15);
    	String string = CCS.intToCCS(i1) + "[" + CCS.intToCCS(i2) + "#" + CCS.intToCCS(i1) + "] " + CCS.GRAY;
    	return string;
    }
}

