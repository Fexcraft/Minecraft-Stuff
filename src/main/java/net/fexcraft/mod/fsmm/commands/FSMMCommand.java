package net.fexcraft.mod.fsmm.commands;

import java.util.ArrayList;
import java.util.List;

import net.fexcraft.mod.fsmm.FSMM;
import net.fexcraft.mod.fsmm.account.AccountManager.Account;
import net.fexcraft.mod.fsmm.account.ItemManager;
import net.fexcraft.mod.fsmm.util.CCS;
import net.fexcraft.mod.fsmm.util.FI;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class FSMMCommand extends CommandBase{
	
	private final ArrayList aliases;
  
    public FSMMCommand(){ 
        aliases = new ArrayList(); 
        aliases.add("money"); 
        aliases.add("balance");
        aliases.add("currency");
    }
    
    @Override 
    public String getName() 
    { 
        return "fsmm"; 

    } 

    @Override         
    public String getUsage(ICommandSender var1) { 
        return "/fsmm <args>"; 

    }
    
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender){
    	if(sender instanceof EntityPlayer){
    		return true;
    	}
    	else return false;
    }

    @Override 
    public List getAliases() { 
        return this.aliases;

    } 

    @Override 
    public void execute(MinecraftServer server, ICommandSender sender, String[] args){ 
        if (sender.getCommandSenderEntity() instanceof EntityPlayer){
        	EntityPlayer player = (EntityPlayer)sender;
        	
	        if (args.length < 1){
	        	float value = ItemManager.countMoneyInInventoryOf(player);
				player.sendMessage(new TextComponentString(CCS.DAQUA + "In Inventory: " + CCS.GREEN + value));
				Account account = FSMM.getInstance().getAccountManager().getAccountOf(player.getUUID(player.getGameProfile())); 
				player.sendMessage(new TextComponentString(CCS.DAQUA + "In Bank: " + account.getBalance()));
	        }
	        else if(args[0].equals("info")){
				sender.sendMessage(new TextComponentString((CCS.DAQUA + "Main command for FSMM related stuff")));
			}
	        else if(args[0].equals("version")){
	        	sender.sendMessage(new TextComponentString((CCS.DAQUA + "FSMM Version: " + FI.VERSION + ".")));   
	        }
	        /*else if(args[0].equals("set")){
	        	ItemManager.setInInventory(player, Double.parseDouble(args[1]));
	        }
	        else if(args[0].equals("add")){
	        	ItemManager.addToInventory(player, Double.parseDouble(args[1]));
	        }
	        else if(args[0].equals("remove")){
	        	ItemManager.removeFromInventory(player, Double.parseDouble(args[1]));
	        }*///TODO Was only made/used for testing.
	        else{sender.sendMessage(new TextComponentString("error"));
	        }
        }
    }

    @Override 
    public boolean isUsernameIndex(String[] var1, int var2) { 
    	return false;
    }
    
}

