package net.fexcraft.mod.fvm.gui;

import net.fexcraft.mod.fvm.FVM;
import net.fexcraft.mod.fvm.data.Addon;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.api.network.IPacketListener;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
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
	
	public static class SReceiver implements IPacketListener<PacketNBTTagCompound> {

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
					((EntityPlayer)objs[0]).openGui(FVM.MODID, ADDON_MANAGER, ((EntityPlayer)objs[0]).world, arr[0], arr[1], arr[2]);
					break;
				case "toggle_debug":
					if(Static.side().isServer()){
						Static.toggleDebug();
						Print.chat((EntityPlayer)objs[0], "Server Side (FCL) Debug Toggled.");
					}
					break;
				case "toggle_addon_state":
					try{
						Addon addon = FvmResources.addons.get(packet.nbt.getString("id"));
						if(addon != null && !addon.missing_dependencies){
							addon.enabled = !addon.enabled;
						}
						FvmResources.updateAddonConfig();
					}
					catch(Exception e){
						break;
					}
					//break;
				case "get_addon_list":
					NBTTagCompound nbt = new NBTTagCompound();
					nbt.setString("target_listener", "fvm");
					nbt.setString("cargo", "addon_list");
					nbt.setInteger("Size", FvmResources.addons.size());
					int entryid = 0;
					for(Addon addon : FvmResources.addons.values()){
						nbt.setTag("entry_" + entryid++, addon.toNBT());
					}
					PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(nbt), (net.minecraft.entity.player.EntityPlayerMP)objs[0]);
					break;
				
			}
		}
		
		public NBTTagCompound getPacketCompound(String task){
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setString("target_listener", "fvm");
			nbt.setString("cargo", task);
			return nbt;
		}
		
	}
	
	public static class CReceiver implements IPacketListener<PacketNBTTagCompound> {

		@Override
		public String getId(){
			return "fvm";
		}

		@Override
		public void process(PacketNBTTagCompound packet, Object[] objs){
			if(!packet.nbt.hasKey("cargo")){
				return;
			}
			switch(packet.nbt.getString("cargo")){
				case "addon_list":
					AddonManagerGui.addons.clear();
					int size = packet.nbt.getInteger("Size");
					for(int i = 0; i < size; i++){
						NBTTagCompound nbt = packet.nbt.getCompoundTag("entry_" + i);
						AddonManagerGui.addons.add(new Addon(nbt));
					}
					break;
			}
		}
		
	}
	
}