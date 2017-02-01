package net.fexcraft.mod.sm.scc.cmds;

import java.util.Date;
import java.util.UUID;

import com.google.gson.JsonArray;

import net.fexcraft.mod.sm.scc.util.Chunk;
import net.fexcraft.mod.sm.scc.util.Data;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class AdminChunkCommand extends CommandBase {

	@Override
	public String getName(){
		return "achunk";
	}
	
    public int getRequiredPermissionLevel(){
        return 2;
    }

	@Override
	public String getUsage(ICommandSender sender){
		return "/achunk <args>";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		Chunk chunk = Data.getChunk(sender.getEntityWorld(), sender.getPosition());
		if(args.length < 1){
			
		}
		else if(args[0].equals("claim")){
			chunk.claimed = new Date().getTime();
			chunk.hasOwner = true;
			chunk.owner = UUID.fromString("00000000-0000-0000-0000-000000000000");
			chunk.whitelist = new JsonArray();
			chunk.save();
			send(sender, "[A] Chunk claimed!");
			return;
		}
		else if(args[0].equals("unclaim")){
			chunk.claimed = 0;
			chunk.hasOwner = false;
			chunk.owner = UUID.fromString("00000000-0000-0000-0000-000000000000");
			chunk.whitelist = new JsonArray();
			chunk.save();
			send(sender, "[A] Chunk unclaimed!");
			return;
		}
		else{
			
		}
	}
	
	public void send(ICommandSender sender, String message){
		sender.sendMessage(new TextComponentString(message));
	}
}