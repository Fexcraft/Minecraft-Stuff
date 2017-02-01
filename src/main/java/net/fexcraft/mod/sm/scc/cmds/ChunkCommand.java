/**
 * THIS FILE IS PART OF 'SCC' Simple Chunk Control
 *  © Fexcraft.net
 *  
 *  @author Ferdinand (FEX___96)
 */
package net.fexcraft.mod.sm.scc.cmds;

import java.util.Date;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.mojang.authlib.GameProfile;

import net.fexcraft.mod.sm.scc.util.Chunk;
import net.fexcraft.mod.sm.scc.util.Config;
import net.fexcraft.mod.sm.scc.util.Data;
import net.fexcraft.mod.sm.scc.util.Player;
import net.fexcraft.mod.sm.scc.util.Util;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class ChunkCommand extends CommandBase {

	@Override
	public String getName(){
		return "chunk";
	}

	@Override
	public String getUsage(ICommandSender sender){
		return "/chunk <args>";
	}
	
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender){
    	if(sender instanceof EntityPlayer){
    		return true;
    	}
    	else return false;
    }

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(args.length < 1){
			send(sender, "/chunk <args>");
			return;
		}
		Chunk chunk = Data.getChunk(sender.getEntityWorld(), sender.getPosition());
		Player player = Data.getPlayer(((EntityPlayer)sender.getCommandSenderEntity()).getGameProfile().getId());
		switch(args[0]){
			case "claim":
				processClaim(server, chunk, sender, player, args);
				break;
			case "whitelist":
				processWhitelist(server, chunk, sender, player, args);
				break;
			case "unclaim":
				processUnClaim(chunk, sender, player, args);
				break;
			case "info":
			case "help":
			case "stats":
			case "amount":
				printInformation(server, chunk, sender, player, args);
				break;
			case "obj":
				send(sender, Util.getObjectAsString(chunk.getObject()));
				break;
		}
	}
	
	private void printInformation(MinecraftServer server, Chunk chunk, ICommandSender sender, Player player, String[] args){
		GameProfile owner = server.getPlayerProfileCache().getProfileByUUID(chunk.owner);
		send(sender, TextFormatting.GRAY + "[SCC]=======================>>");
		send(sender, "Your Chunks: " + player.chunks + "/" + Config.maxChunkPerPlayer);
		send(sender, "Claiming is " + (Config.allowed ? TextFormatting.GREEN + "allowed;" : TextFormatting.RED + "forbidden;"));
		send(sender, "Chunk: " + chunk.x + "x, " + chunk.z + "z;");
		send(sender, "Owner: " + (owner == null ? "noone" : owner.getName()) + ";");
		send(sender, "Claimed since: " + Util.getTime(chunk.claimed));
		String whitelist = new String();
		for(JsonElement elm : chunk.whitelist){
			whitelist += server.getPlayerProfileCache().getProfileByUUID(UUID.fromString(elm.getAsString())).getName() + ", ";
		}
		send(sender, "Whitelisted: " + whitelist);
	}

	private void processUnClaim(Chunk chunk, ICommandSender sender, Player player, String[] args){
		if(!Config.allowed){
			send(sender, "Claiming/Unclaiming was disabled.");
			return;
		}
		if(!chunk.owner.toString().equals(player.uuid.toString())){
			send(sender, "This is not your chunk.");
			return;
		}
		chunk.claimed = 0;
		chunk.hasOwner = false;
		chunk.owner = UUID.fromString("00000000-0000-0000-0000-000000000000");
		chunk.whitelist = new JsonArray();
		chunk.save();
		player.chunks -= 1;
		if(player.chunks < 0){
			player.chunks = 0;
		}
		player.save();
		send(sender, "Chunk unclaimed!");
		return;
	}

	private void processWhitelist(MinecraftServer server, Chunk chunk, ICommandSender sender, Player player, String[] args) {
		if(args.length < 3){
			send(sender, "/chunk whitelist <add/remove> <playername>");
		}
		else if(args[1].equals("add")){
			GameProfile gp = server.getPlayerProfileCache().getGameProfileForUsername(args[2]);
			if(gp != null){
				chunk.whitelist.add(new JsonPrimitive(gp.getId().toString()));
				chunk.save();
				send(sender, "Added Player to Chunk-Whitelist.");
			}
			else{
				send(sender, "Player not found.");
			}
		}
		else if(args[1].equals("remove")){
			GameProfile gp = server.getPlayerProfileCache().getGameProfileForUsername(args[2]);
			if(gp != null){
				String id = gp.getId().toString();
				JsonArray array = new JsonArray();
				for(JsonElement elm : chunk.whitelist){
					if(!elm.getAsString().equals(id)){
						array.add(elm);
					}
				}
				chunk.whitelist = array;
				chunk.save();
				send(sender, "Removed Player from Chunk-Whitelist.");
			}
			else{
				send(sender, "Player not found.");
			}
		}
		else{
			send(sender, "/chunk whitelist <add/remove> <playername>");
		}
	}

	private void processClaim(MinecraftServer server, Chunk chunk, ICommandSender sender, Player player, String[] args){
		if(!Config.allowed){
			send(sender, "Claiming/Unclaiming was disabled.");
			return;
		}
		if(chunk.hasOwner){
			send(sender, "Chunk already claimed by " + server.getPlayerProfileCache().getProfileByUUID(chunk.owner).getName());
			return;
		}
		else{
			if(player.chunks >= Config.maxChunkPerPlayer){
				send(sender, "Max chunk amount reached.");
				return;
			}
			chunk.claimed = new Date().getTime();
			chunk.hasOwner = true;
			chunk.owner = player.uuid;
			chunk.whitelist = new JsonArray();
			chunk.save();
			player.chunks += 1;
			player.save();
			send(sender, "Chunk claimed!");
			return;
		}
	}

	public void send(ICommandSender sender, String message){
		sender.sendMessage(new TextComponentString(message));
	}
}