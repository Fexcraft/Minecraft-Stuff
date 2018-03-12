package net.fexcraft.mod.fvm.cmds;

import net.fexcraft.mod.fvm.FVM;
import net.fexcraft.mod.fvm.gui.FvmGuiHandler;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.client.resources.I18n;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class FvmCommand extends CommandBase {

	@Override
	public String getName(){
		return "fvm";
	}

	@Override
	public String getUsage(ICommandSender sender){
		return "commands.fvm.main_usage";
	}
	
	public String trs(String string){
		return I18n.format(string, new Object[0]);
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(args.length < 1){
			Print.chat(sender, I18n.format("commands.fvm.main_usage", new Object[0]));
			return;
		}
		switch(args[0]){
			case "help":
				Print.chat(sender, trs("commands.fvm.main_help_desc"));
				Print.chat(sender, trs("commands.fvm.main_help_addons"));
				Print.chat(sender, trs("commands.fvm.main_help_version"));
				break;
			case "addons":
				/*NBTTagCompound nbt = new NBTTagCompound();
				nbt.setString("target_listener", "fvm");
				nbt.setIntArray("args", new int[]{0,0,0});
				nbt.setString("task", "open_addon_manager");
				PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(nbt));*/
				//Print.chat(((EntityPlayer)sender), ((EntityPlayer)sender).getName());
				((EntityPlayer)sender).openGui(FVM.INSTANCE, FvmGuiHandler.ADDON_MANAGER, sender.getEntityWorld(), 0, 0, 0);
				break;
			case "version":
				Print.chat(sender, trs("commands.fvm.main_version") + " " + FVM.VERSION);
				break;
		}
	}
	
}