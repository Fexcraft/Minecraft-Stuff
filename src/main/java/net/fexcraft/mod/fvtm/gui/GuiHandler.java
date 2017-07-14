package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.auto.GenericAddon;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.network.IPacketListener;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

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
			return "fvtm";
		}

		@Override
		public void process(PacketNBTTagCompound packet, Object[] objs){
			if(!packet.nbt.hasKey("task")){
				return;
			}
			switch(packet.nbt.getString("task")){
				case "open_addon_manager":
					int[] arr = packet.nbt.getIntArray("args");
					((EntityPlayer)objs[0]).openGui(FVTM.MODID, ADDON_MANAGER, ((EntityPlayer)objs[0]).world, arr[0], arr[1], arr[2]);
					break;
				case "toggle_debug":
					if(Static.side().isServer()){
						Static.toggleDebug();
						Print.chat((EntityPlayer)objs[0], "Server Side (FCL) Debug Toggled.");
					}
					break;
				case "toggle_addon_state":
					try{
						Addon addon = Resources.ADDONS.getValue(new ResourceLocation(packet.nbt.getString("id")));
						if(addon != null && !addon.hasMissingDependencies()){
							addon.setEnabled(!addon.isEnabled());
						}
						FVTM.getResources().updateAddonConfig();
					}
					catch(Exception e){
						break;
					}
					//break;
				case "get_addon_list":
					NBTTagCompound nbt = new NBTTagCompound();
					nbt.setString("target_listener", "fvtm");
					nbt.setString("cargo", "addon_list");
					nbt.setInteger("Size", Resources.ADDONS.getValues().size());
					int entryid = 0;
					for(Addon addon : Resources.ADDONS.getValues()){
						nbt.setTag("entry_" + entryid++, addon.toNBT());
					}
					PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(nbt), (net.minecraft.entity.player.EntityPlayerMP)objs[0]);
					break;
				case "set_addon_state":
					boolean success;
					try{
						Addon addon = Resources.ADDONS.getValue(new ResourceLocation(packet.nbt.getString("id")));
						if(addon != null && !addon.hasMissingDependencies()){
							addon.setEnabled(packet.nbt.getBoolean("state"));
						}
						FVTM.getResources().updateAddonConfig();
						success = true;
					}
					catch(Exception e){
						e.printStackTrace();
						Print.log("Failed to update Addon State;");
						success = false;
					}

					NBTTagCompound tagc = new NBTTagCompound();
					tagc.setString("target_listener", "fvtm");
					tagc.setString("cargo", "addon_state_change_confirmation");
					tagc.setBoolean("success", success);
					tagc.setBoolean("enabled", packet.nbt.getBoolean("state"));
					PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(tagc), (net.minecraft.entity.player.EntityPlayerMP)objs[0]);
					Print.debug("S: " + tagc);
					break;
				
			}
		}
		
		public NBTTagCompound getPacketCompound(String task){
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setString("target_listener", "fvtm");
			nbt.setString("cargo", task);
			return nbt;
		}
		
	}
	
	public static class CReceiver implements IPacketListener<PacketNBTTagCompound> {

		@Override
		public String getId(){
			return "fvtm";
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
						GenericAddon addon = new GenericAddon();
						AddonManagerGui.addons.add(addon.fromNBT(nbt));
					}
					break;
				case "addon_state_change_confirmation":
					if(packet.nbt.hasKey("success") && packet.nbt.getBoolean("success")){
						AddonManagerGui.addon.setEnabled(packet.nbt.getBoolean("enabled"));
					}
					Print.debug("C: " + packet.nbt);
					break;
			}
		}
		
	}
	
}