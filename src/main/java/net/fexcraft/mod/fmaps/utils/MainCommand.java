package net.fexcraft.mod.fmaps.utils;

import java.util.ArrayList;
import java.util.List;

import net.fexcraft.mod.fmaps.FMaps;
import net.fexcraft.mod.fmaps.nano.WebServer;
import net.fexcraft.mod.fmaps.nano.WebServer.Key;
import net.fexcraft.mod.lib.api.common.fCommand;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

@fCommand
public class MainCommand extends CommandBase {

	private static final ArrayList aliases;
	static{
        aliases = new ArrayList(); 
        aliases.add("fmaps");
        aliases.add("maps");
	}
  
    public MainCommand(){}
    
    @Override 
    public String getName(){ 
        return "fmap"; 
    } 

    @Override         
    public String getUsage(ICommandSender var1){ 
        return "command.fmaps.help"; 
    }
    
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender){
    	if(sender.getCommandSenderEntity() instanceof EntityPlayer){
    		if(PermManager.isEnabled()){
    			boolean bool = PermManager.getPlayerPerms((EntityPlayer)sender).hasPermission("fmaps.command.use");
    			if(Static.side().isClient()){
    				bool = true;
    			}
    			if(!bool){
    				Print.chat(sender, "&8{fcl} &7No permission to use this command.");
    			}
    			return bool;
    		}
    		else return true;
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
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
    	EntityPlayer player = (EntityPlayer)sender;
        if(args.length < 1){
        	Print.chat(sender, "&0[&e<<<&0] &7========= &0[&e>>>&0]");
        	Print.chat(sender, "&3/maps key &7- generates a new key for you");
        	Print.chat(sender, "&3/maps status &7- shows your current key status");
        	return;
        }
        switch(args[0]){
	        case "key":{
	        	if(WebServer.keys.get(sender.getCommandSenderEntity().getUniqueID()) != null){
	        		Key key = WebServer.keys.get(player.getGameProfile().getId());
	        		if(key.expired){
		        		Print.chat(sender, "&3Found existing key, but it expired.");
		        		Print.chat(sender, "&3Generated a new key!");
		        		key = new Key(player.getGameProfile().getId());
		        		Print.chat(sender, "&e>>>> &7" + key.code + "&e>>>>");
	        		}
	        		else{
		        		Print.chat(sender, "&3Found existing key!");
		        		Print.chat(sender, "&e>>>> &7" + key.code + "&e>>>>");
	        		}
	        	}
	        	else{
	        		Key key = new Key(player.getGameProfile().getId());
	        		Print.chat(sender, "&3Generated new key!");
	        		Print.chat(sender, "&e>>>> &7" + key.code + "&e>>>>");
	        	}
	        	return;
	        }
	        case "status":{
	        	Key key = WebServer.keys.get(player.getGameProfile().getId());
	        	if(key == null){
	        		Print.chat(sender, "&3No keycode found.");
	        	}
	        	else if(key.expired){
	        		Print.chat(sender, "&3Key expired. &7(" + key.lastuse + ");");
	        	}
	        	else{
	        		Print.chat(sender, "&e>>>> &7" + key.code + "&e>>>>");
	        		Print.chat(sender, "&3Key active. &7(" + key.lastuse + ");");
	        		Print.chat(sender, "&3Valid till: &7(" + (key.lastuse + FMaps.SESSIONEXPIRY) + ");");
	        	}
	        	return;
	        }
        	default:{
        		Print.chat(sender, "Invalid argument.");
        		return;
        	}
        }
    }
    
}

