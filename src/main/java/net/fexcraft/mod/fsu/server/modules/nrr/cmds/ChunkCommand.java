package net.fexcraft.mod.fsu.server.modules.nrr.cmds;

import net.fexcraft.mod.fsu.server.modules.nrr.NRR;
import net.fexcraft.mod.fsu.server.modules.nrr.data.Chunk;
import net.fexcraft.mod.fsu.server.modules.nrr.data.PlayerData;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class ChunkCommand extends CommandBase {

	@Override
	public String getName(){
		return "ck";
	}

	@Override
	public String getUsage(ICommandSender sender){
		return "fsu.nrr.cmd.chunk";
	}
	
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender){
    	if(sender instanceof EntityPlayer){
    		return true;
    	}
    	else return false;
    }

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException{
		if(sender instanceof EntityPlayer == false){
			return;
		}
		if(sender.getCommandSenderEntity().dimension != 0){
			Print.chat(sender, "NRR Protection only works in the Overworld!");
			return;
		}
		PlayerData data = NRR.getPlayerData((EntityPlayer)sender);
		Chunk chunk = NRR.getChunk(sender);
		if(args.length < 1){
			Print.chat(sender, "&7Missing arguments. &7Try '&f/ck help&7'&0;");
			return;
		}
		switch(args[0]){
			case "help":
				Print.chat(sender, "&6[&cFSU&6]&0=&7==&0=&7==&0=&7==&0=&7==&0=&7==&0=&7==&0=&7==");
				Print.chat(sender, "&6Welcome back " + data.getNick(sender));
				Print.chat(sender, "&3Available arguments:");
				Print.chat(sender, "&9- /ck help");
				Print.chat(sender, "&9- /ck info <null/x> <null/z>");
				Print.chat(sender, "&9- /ck claim <null/args>");
				Print.chat(sender, "&9- /ck set <args>");
				Print.chat(sender, "&6[&4#&6]&7==&0=&7==&0=&7==&0=&7==&0=&7==&0=&7==&0=&7==&0=&7==");
				break;
			case "claim":
				if(args.length < 2){
					if(canClaim(sender, data, chunk, sender.getEntityWorld())){
						chunk.province = data.province;
						chunk.ptype = Chunk.ProtectionType.NONE;
						JsonUtil.write(NRR.getChunkFile(chunk.x, chunk.z), chunk.save());
						Print.chat(sender, "&7Chunk &c" + chunk.x + "x&7, &c" + chunk.z + "z&7 claimed!");
					}
				}
				else{
					switch(args[1]){
						case "spawn":
							if(data.perms.hasPermission(NRR.ADMINPERM)){
								if(chunk.province.id == 0){
									Print.chat(sender, "Chunk already claimed!");
								}
								else{
									chunk.province = NRR.provinces.get(0);
									chunk.ptype = Chunk.ProtectionType.SERVER;
									JsonUtil.write(NRR.getChunkFile(chunk.x, chunk.z), chunk.save());
									Print.chat(sender, "&7Chunk &c" + chunk.x + "x&7, &c" + chunk.z + "z&7 claimed!");
								}
							}
							else{
								Print.chat(sender, "No permission!");
							}
							break;
						case "spawno":
							
							
							break;
					}
				}
				break;
			case "set":
				Print.chat(sender, "Soon.");
				break;
			case "obj":
				Print.chat(sender, chunk.save().toString());
				break;
			case "save":
				if(data.perms.hasPermission(NRR.ADMINPERM)){
					NRR.sendToAll("Manuall Saving requested.");
					NRR.save();
					NRR.sendToAll("Done saving.");
				}
				break;
			default:
				Print.chat(sender, "&7/ck &4help&7");
				break;
		}
	}

	private boolean canClaim(ICommandSender sender, PlayerData data, Chunk chunk, World world){
		if(!data.province.isLeader(data.uuid)){
			Print.chat(sender, "You aren't province leader.");
			return false;
		}
		if(chunk.province.id == data.province.id){
			Print.chat(sender, "&7Chunk already part of the Province!");
			return false;
		}
		if(chunk.province.id > 0){
			Print.chat(sender, "&7Chunk already claimed!");
			return false;
		}
		Chunk ck0 = NRR.getChunk(chunk.x + 1, chunk.z);
		Chunk ck1 = NRR.getChunk(chunk.x - 1, chunk.z);
		Chunk ck2 = NRR.getChunk(chunk.x, chunk.z + 1);
		Chunk ck3 = NRR.getChunk(chunk.x, chunk.z - 1);
		if(ck0.province.id == data.province.id || ck1.province.id == data.province.id || ck2.province.id == data.province.id || ck3.province.id == data.province.id){
			if(chunk.mainbiome.equals(data.province.mainbiome) || chunk.mainbiome.contains("Beach")){
				if(ck0.province.id != data.province.id && !data.province.neighbors.contains(ck0.province.id)){
					data.province.neighbors.add(ck0.province.id);
				}
				if(ck1.province.id != data.province.id && !data.province.neighbors.contains(ck1.province.id)){
					data.province.neighbors.add(ck1.province.id);
				}
				if(ck2.province.id != data.province.id && !data.province.neighbors.contains(ck2.province.id)){
					data.province.neighbors.add(ck2.province.id);
				}
				if(ck3.province.id != data.province.id && !data.province.neighbors.contains(ck3.province.id)){
					data.province.neighbors.add(ck3.province.id);
				}
				return true;
			}
			else{
				Print.chat(sender, "&7Chunk main biome doesn't match the main biome of your Province!");
				return false;
			}
		}
		else{
			Print.chat(sender, "&7Chunk not connected to other Province chunks!");
			return false;
		}
	}
	
}