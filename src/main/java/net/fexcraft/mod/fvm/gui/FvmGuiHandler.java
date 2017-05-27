package net.fexcraft.mod.fvm.gui;

import net.fexcraft.mod.fvm.FVM;
import net.fexcraft.mod.lib.api.network.IPacketListener;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class FvmGuiHandler implements IGuiHandler {

	public static final int ADDON_MANAGER = 55;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		Print.debug("REQUEST " + ID + " | " + x + ", " + y + ", " + z + ";");
		switch(ID){
			case 55:
				return new GenericPlaceholderContainer();
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		Print.debug("REQUEST " + ID + " | " + x + ", " + y + ", " + z + ";");
		switch(ID){
			case 55:
				Print.debug("CREATING GUI!;");
				return new AddonManagerGui(x, y, z);
			default:
				return null;
		}
	}
	
	public static class Receiver implements IPacketListener<PacketNBTTagCompound> {

		@Override
		public String getId(){
			return "fvm";
		}

		@Override
		public void process(PacketNBTTagCompound packet, Object[] objs){
			if(!packet.nbt.hasKey("task")){
				return;
			}
			switch(packet.nbt.getString("task")){
				case "open_addon_manager":
					int[] arr = packet.nbt.getIntArray("args");
					((EntityPlayer)objs[0]).openGui(FVM.MODID, 0, ((EntityPlayer)objs[0]).world, arr[0], arr[1], arr[2]);
					break;
			}
		}
		
	}
	
}