package net.fexcraft.mod.fsu.server.modules.nrr.cmds;

import java.util.ArrayList;
import java.util.UUID;

import net.fexcraft.mod.fsu.server.modules.nrr.NRR;
import net.fexcraft.mod.fsu.server.modules.nrr.data.Chunk;
import net.fexcraft.mod.fsu.server.modules.nrr.data.Invite;
import net.fexcraft.mod.fsu.server.modules.nrr.data.PlayerData;
import net.fexcraft.mod.fsu.server.modules.nrr.data.Province;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class ProvinceCommand extends CommandBase {

	@Override
	public String getName(){
		return "pr";
	}

	@Override
	public String getUsage(ICommandSender sender){
		return "fsu.nrr.cmd.province";
	}
	
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender){
    	if(sender instanceof EntityPlayer){
    		return true;
    	}
    	else return false;
    }

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
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
			Print.chat(sender, "&7Missing arguments. &7Try '&f/pr help&7'&0;");
			return;
		}
		switch(args[0]){
			case "help":
				Print.chat(sender, "&6[&cFSU&6]&0=&7==&0=&7==&0=&7==&0=&7==&0=&7==&0=&7==&0=&7==");
				Print.chat(sender, "&6Welcome back " + data.getNick(sender));
				Print.chat(sender, "&3Available arguments:");
				Print.chat(sender, "&9- /pr help");
				Print.chat(sender, "&9- /pr info <null/of> <id>");
				Print.chat(sender, "&9- /pr claim");
				Print.chat(sender, "&9- /pr invite <args>");
				Print.chat(sender, "&9- /pr create <args>");
				Print.chat(sender, "&9- /pr abandon <args>");
				Print.chat(sender, "&9- /pr set <args>");
				Print.chat(sender, "&9- /pr leave <reason>");
				Print.chat(sender, "&6[&4#&6]&7==&0=&7==&0=&7==&0=&7==&0=&7==&0=&7==&0=&7==&0=&7==");
				break;
			case "info":
				Province province = args.length > 1  && args[1].equals("of") ? NRR.provinces.get(Integer.parseInt(args[2])) : chunk.province;
				Print.chat(sender, "&6[&cFSU&6]&0=&7==&0=&7==&0=&7==&0=&7==&0=&7==&0=&7==&0=&7==");
				Print.chat(sender, "&7Province stats of &" + province.region.nation.color + province.name);
				Print.chat(sender, "&3Region: &" + province.region.nation.color + province.region.name);
				Print.chat(sender, "&3MainBiome: &e" + province.mainbiome);
				Print.chat(sender, "&3Neighboring provinces:");
				if(province.neighbors.size() > 0){
					for(int i : province.neighbors){
						Province pr = NRR.provinces.get(i);
						Print.chat(sender, "&8-> " + (pr == null ? "&9[&3<&8removed province&3>&9]" : "&" + pr.region.nation.color + pr.name));
					}
				}
				else{
					Print.chat(sender, "&8-> &9[&cnone&9]&0;");
				}
				Print.chat(sender, "&3Leadership:");
				if(province.leadership.size() > 0){
					for(UUID uuid : province.leadership){
						Print.chat(sender, "&8-> &9" + NRR.getPlayerNameByUUID(uuid));
					}
				}
				else{
					Print.chat(sender, "&8-> &9[&cnone&9]&0;");
				}
				Print.chat(sender, "&3Abandoned: " + (province.isAbandoned() ? "&ctrue" : "&afalse"));
				Print.chat(sender, "&6[&4#&6]&7==&0=&7==&0=&7==&0=&7==&0=&7==&0=&7==&0=&7==&0=&7==");
				break;
			case "create":
				if(args.length < 3){
					Print.chat(sender, "&7Usage: &c/pr create <founder2> <name ...>");
					Print.chat(sender, "&3The other founder must be online!");
					break;
				}
				if(data.province.id > 0){
					Print.chat(sender, "&7You need to leave your current province!");
					break;
				}
				PlayerData founder2 = NRR.getPlayerData(args[1]);
				if(founder2 == null){
					Print.chat(sender, "&cPlayer &7not found or is offline;");
					break;
				}
				if(founder2.province.id > 0){
					Print.chat(sender, "&7Selected &cplayer &7is already in a province!");
					break;
				}
				if(chunk.mainbiome.equals("Ocean") || chunk.mainbiome.equals("Deep Ocean")){
					Print.chat(sender, "&7Invalid biome to create a province.");
					break;
				}
				
				String prname = args[2];
				if(args.length > 3){
					for(int i = 3; i < args.length; i++){
						prname += " " + args[i];
					}
				}
				Province pr = new Province(getNewProvinceId());
				pr.leadership.add(((EntityPlayer)sender).getGameProfile().getId());
				pr.leadership.add(Static.getServer().getPlayerList().getPlayerByUsername(args[1]).getGameProfile().getId());
				pr.mainbiome = chunk.mainbiome;
				pr.name = prname;
				chunk.province = pr;
				chunk.ptype = Chunk.ProtectionType.PROVINCE;
				JsonUtil.write(pr.getFile(), pr.save());
				NRR.provinces.put(pr.id, pr);
				
				data.province = pr;
				Print.chat(sender, "You are now the leader of " + data.province.name);
				founder2.province = pr;
				Print.chat(Static.getServer().getPlayerList().getPlayerByUsername(args[1]), "You are now the leader of " + data.province.name);
				NRR.sendToAll("&7Province &c" + prname + "&7 was created!");
				break;
			case "obj":
				Print.chat(sender, data.province.save().toString());
				break;
			case "leave":
				if(data.province.isLeader(data.uuid) && data.province.leadership.size() < 2){
					Print.chat(sender, "&cYou cannot leave since you are the last leader, use &f/pr abandon &c instead.");
					break;
				}
				if(data.province.isLeader(data.uuid)){
					data.province.leadership.remove(data.uuid);
				}
				NRR.sendToProvince(data.province.id, data.getNick(sender) + "&c left the Province!");
				data.province = NRR.provinces.get(-1);
				break;
			case "set":
				if(!data.province.isLeader(data.uuid)){
					Print.chat(sender, "&7[&0#&7]&c No Permission!");
					break;
				}
				if(args.length < 3){
					Print.chat(sender, "&7Missing arguments!");
				}
				else{
					if(args[1].equals("color")){
						String color = args[2];
						if(color.startsWith("#") && color.length() == 7){
							if(color.equals("FFFFFF") || color.equals("000000")){
								Print.chat(sender, "Those colours aren't allowed perhaps.");
							}
							else{
								data.province.hex = color;
								NRR.sendToProvince(data.province.id, "&7Province Color changed to &3`&c" + data.province.hex + "&3`&7!");
							}	
						}
						else{
							Print.chat(sender, "Invalid Color string!");
						}
					}
				}
				break;
			case "invite":
				if(args.length < 3){
					Print.chat(sender, "&7Missing argument!");
					Print.chat(sender, "&7Available: &csend <name>&7, &ccancel <name>&7, &caccept <pr id>&7;");
					break;
				}
				else{
					if(args[1].equals("send")){
						if(!data.province.isLeader(data.uuid)){
							Print.chat(sender, "&7[&0#&7]&c No Permission!");
							break;
						}
						try{
							UUID uuid = Static.getServer().getPlayerProfileCache().getGameProfileForUsername(args[2]).getId();
							Invite inv = new Invite(sender.getName(), args[2], data.uuid.toString(), uuid.toString(), data.province.id);
							if(!inv.cancelled){
								NRR.invites.add(inv);
								Print.chat(sender, "&7Invite sent!");
							}
							else{
								Print.chat(sender, "&7ERROR: &c" + inv.ddd.get("error").getAsString());
							}
						}
						catch(Exception e){
							Print.chat(sender, "ERROR: " + e.getMessage());
						}
					}
					else if(args[1].equals("cancel")){
						if(!data.province.isLeader(data.uuid)){
							Print.chat(sender, "&7[&0#&7]&c No Permission!");
							break;
						}
						try{
							UUID uuid = Static.getServer().getPlayerProfileCache().getGameProfileForUsername(args[2]).getId();
							ArrayList<Invite> arr = NRR.getInvites(uuid.toString());
							boolean found = false;
							for(Invite inv : arr){
								if(inv.ddd.has("province") && inv.ddd.get("province").getAsInt() == data.province.id){
									inv.cancel();
									if(inv.cancelled){
										Print.chat(sender, "7cInvite cancelled.");
									}
									else{
										Print.chat(sender, "&cFailed to cancel invite.");
									}
									found = true;
								}
							}
							if(!found){
								Print.chat(sender, "No invites found.");
							}
						}
						catch(Exception e){
							Print.chat(sender, "ERROR: " + e.getMessage());
						}
					}
					else if(args[1].equals("accept")){
						try{
							ArrayList<Invite> arr = NRR.getInvites(data.uuid.toString());
							Invite invite = null;
							for(Invite inv : arr){
								if(inv.ddd.has("province") && inv.ddd.get("province").getAsInt() == Integer.parseInt(args[2])){
									invite = inv;
									break;
								}
							}
							if(invite != null){
								invite.accept();
							}
							else{
								Print.chat(sender, "No invite not found.");
							}
						}
						catch(Exception e){
							Print.chat(sender, "ERROR: " + e.getMessage());
						}
					}
					else{
						Print.chat(sender, "&7Invalid argument.");
					}
				}
				break;
			default:
				Print.chat(sender, "&7/pr &4help&7");
				break;
		}
	}
	
	public static final int getNewProvinceId(){
		int i = NRR.provinces.size();
		while(NRR.provinces.containsKey(i)){
			i++;
		}
		return i;
	}
	
}