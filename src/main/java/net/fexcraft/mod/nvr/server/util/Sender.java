package net.fexcraft.mod.nvr.server.util;

import java.util.List;

import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.nvr.server.NVR;
import net.fexcraft.mod.nvr.server.data.Player;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentString;
import scala.actors.threadpool.Arrays;

public class Sender {
	
	public static final void serverMessage(String string){
		Static.getServer().getPlayerList().sendMessage(new TextComponentString(string));
	}
	
	public static final void sendLocationUpdate(EntityPlayer player, String ms, String mg, String color, Integer time){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("target_listener", "nvr-lg");
		nbt.setString("task", "show");
		Player data = NVR.getPlayerData(player);
		writeIcon(nbt, data.lastseen.municipality.icon, 0, color);
		writeIcon(nbt, data.lastseen.municipality.province.icon, 1, color);
		writeIcon(nbt, data.lastseen.municipality.province.nation.icon, 2, color);
		nbt.setString(  "up", ms == null ? "" : ms);
		nbt.setString("down", mg == null ? "" : mg);
		if(time != null){
			nbt.setInteger("time", time);
		}
		PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(nbt), (EntityPlayerMP)player);
	}
	
	private static final List colours = Arrays.asList(new String[]{"green", "yellow", "red", "blue"});

	private static final void writeIcon(NBTTagCompound compound, String icon, int id, String color){
		if((icon == null || icon.equals("")) && color == null){
			compound.setInteger("x_" + id, 64);
			compound.setInteger("y_" + id, 224);
			return;
		}
		else if(colours.contains(icon) || color != null){
			compound.setString("color_" + id, color == null ? icon : color);
			return;
		}
		else{
			compound.setString("icon_" + id, icon);
			return;
		}
	}
	
}