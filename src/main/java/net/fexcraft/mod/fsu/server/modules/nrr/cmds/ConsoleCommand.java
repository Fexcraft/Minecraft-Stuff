package net.fexcraft.mod.fsu.server.modules.nrr.cmds;

import net.fexcraft.mod.fsu.server.modules.nrr.NRR;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class ConsoleCommand extends CommandBase {

	@Override
	public String getName(){
		return "cl";
	}

	@Override
	public String getUsage(ICommandSender sender){
		return "fsu.nrr.cmd.console";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException{
		switch(args[0]){
			case "save":
					NRR.sendToAll("[CONSOLE] Manuall Saving requested.");
					NRR.save();
					NRR.sendToAll("[CONSOLE] Done saving.");
				break;
			default:
				Print.chat(sender, "&7/cl &4help&7");
				break;
		}
	}
	
}