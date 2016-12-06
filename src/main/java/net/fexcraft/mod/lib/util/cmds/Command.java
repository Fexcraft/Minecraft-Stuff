package net.fexcraft.mod.lib.util.cmds;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.network.Network;
import net.fexcraft.mod.lib.util.cls.Print;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextFormatting;

public class Command extends CommandBase{

	@Override
	public String getName(){
		return "fcl";
	}

	@Override
	public String getUsage(ICommandSender sender){
		return "/fcl";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(args.length < 6){
			Print.chat(sender, "Missing arguments.");
			Print.chat(sender, TextFormatting.DARK_AQUA + "/fcl update <modid> version <new_version> <username> <password>");
		}
		else{
			String modid = args[1];
			String version = args[3];
			String usr = args[4];
			String pwt = args[5];
			String uuid = ((EntityPlayer)sender.getCommandSenderEntity()).getGameProfile().getId().toString();
			
			JsonObject obj = new JsonObject();
			obj.addProperty("version", version);
			obj.addProperty("username", usr);
			obj.addProperty("pwt", pwt);
			obj.addProperty("uuid", uuid);
			
			JsonObject reply = Network.request("http://fexcraft.net/minecraft/fcl/request.fn", "mode=update_version&modid=" + modid + "&obj=" + obj);
			if(reply != null){
				Print.chat(sender, reply.get("reply").getAsString());
				if(reply.has("version")){
					Print.chat(sender, reply.get("version").getAsString());
				}
				if(reply.has("uuid")){
					Print.chat(sender, reply.get("uuid").getAsString());
				}
			}
		}
	}
	
}