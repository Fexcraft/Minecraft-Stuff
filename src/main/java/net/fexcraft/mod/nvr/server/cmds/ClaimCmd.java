package net.fexcraft.mod.nvr.server.cmds;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.util.common.Log;
import net.fexcraft.mod.nvr.server.NVR;
import net.fexcraft.mod.nvr.server.data.Chunk;
import net.fexcraft.mod.nvr.server.data.District;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
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
			print.chat(sender, "/cl w <args> (opens GUI)");
			return;
		}
		boolean isp = sender.getCommandSenderEntity() instanceof EntityPlayer;
		EntityPlayer player = isp ? (EntityPlayer)sender.getCommandSenderEntity() : null;
		if(args[0].equals("w")){
			if(!isp){
				print.chat(sender, "Function only avaible to ingame players.");
			}
			else{
				boolean asa = args.length >= 2 ? args[1].equals("-a") : false;
				boolean asc = args.length >= 2 ? args[1].equals("-c") : false;
				player.openGui(NVR.getInstance(), 0, player.world, 0, asa ? 1 : 0, asc ? 1 : 0);
				//
				this.sendChunkArray(player);
			}
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

	private void sendChunkArray(EntityPlayer player){
		NBTTagCompound nbt = new NBTTagCompound();
		try{
			NBTTagList list = new NBTTagList();
			int x = player.world.getChunkFromBlockCoords(player.getPosition()).x;
			int z = player.world.getChunkFromBlockCoords(player.getPosition()).z;
			int xa = x + 5, za = z + 5;
			for(int i = x - 5; i < xa; i++){
			    for(int j = z - 5; j < za; j++){
			        Chunk ck = NVR.getChunk(i, j);
			        JsonObject obj = new JsonObject();
			        obj.addProperty("x", ck.x);
			        obj.addProperty("z", ck.z);
			        obj.addProperty("claimed", ck.district.id > -1);
			        obj.addProperty("type", ck.type.name());
			        obj.addProperty("district", ck.district.id);
			        obj.addProperty("municipality", ck.district.municipality.id);
			        obj.addProperty("province", ck.district.municipality.province.id);
			        obj.addProperty("nation", ck.district.municipality.province.nation.id);
			        obj.addProperty("company", ck.owner.toString());
			        obj.addProperty("linked", ck.linked.size() > 0);
			        list.appendTag(new NBTTagString(obj.toString()));
			    }
			}
			nbt.setTag("chunklist", list);
		}
		catch(Exception e){
			
		}
		nbt.setString("target_listener", "nvr-cl");
		nbt.setString("task", "ckv");
		PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(nbt), (EntityPlayerMP)player);
	}
	
}