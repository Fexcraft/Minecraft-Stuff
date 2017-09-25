package net.fexcraft.mod.nvr.server.cmds;

import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.util.common.Log;
import net.fexcraft.mod.nvr.server.NVR;
import net.fexcraft.mod.nvr.server.data.Chunk;
import net.fexcraft.mod.nvr.server.data.District;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class ClaimCmd extends CommandBase {
	
	private static final Log print = InfoCmd.print;

	@Override
	public String getName(){
		return "cl";
	}

	@Override
	public String getUsage(ICommandSender sender){
		return sender.getCommandSenderEntity() instanceof EntityPlayer ? "/cl <args>" : "/cl <args>";
	}
	
	@Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender){
    	return !(sender == null || server == null);
    }

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(args.length < 1){
			print.chat(sender, InfoCmd.space);
			print.chat(sender, "Claim Command");
			print.chat(sender, "/cl <district>");
			print.chat(sender, "/cl w (opens GUI)");
			return;
		}
		boolean isp = sender.getCommandSenderEntity() instanceof EntityPlayer;
		EntityPlayer player = isp ? (EntityPlayer)sender.getCommandSenderEntity() : null;
		if(args[0].equals("w")){
			print.chat(sender, "//TODO");
		}
		else{
			District dis = NVR.getDistrict(args, 0);
			if(dis == null){
				print.chat(sender, "District not found.");
				return;
			}
			Chunk ck = isp ? NVR.getChunk(player) : (args.length < 3 ? null : NVR.getChunk(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
			if(ck == null){
				print.chat(sender, "Chunk not found or is not loaded.");
			}
			if(isp){
				print.chat(sender, ck.tryClaim(PermManager.getPlayerPerms(player), NVR.getPlayerData(player), dis, args.length >= 2 && args[1].equals("-a")));
			}
			else{
				print.chat(sender, ck.tryClaim(null, null, dis, true));
			}
		}
	}
	
}