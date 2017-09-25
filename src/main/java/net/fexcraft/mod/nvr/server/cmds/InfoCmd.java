package net.fexcraft.mod.nvr.server.cmds;

import java.util.UUID;

import net.fexcraft.mod.lib.util.common.Log;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.nvr.server.NVR;
import net.fexcraft.mod.nvr.server.data.Chunk;
import net.fexcraft.mod.nvr.server.data.District;
import net.fexcraft.mod.nvr.server.data.DoubleKey;
import net.fexcraft.mod.nvr.server.data.Municipality;
import net.fexcraft.mod.nvr.server.data.Nation;
import net.fexcraft.mod.nvr.server.data.Player;
import net.fexcraft.mod.nvr.server.data.Province;
import net.fexcraft.mod.nvr.server.util.Sender;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class InfoCmd extends CommandBase {
	
	public static final Log print = NVR.LOGGER;
	public static final String space = "&8=-=-=-=-=-|-=-=-=-=-= &0[&6#&0]";

	@Override
	public String getName(){
		return "ni";
	}

	@Override
	public String getUsage(ICommandSender sender){
		return sender.getCommandSenderEntity() instanceof EntityPlayer ? "/ni <args>" : "/ni <args>";
	}
	
	@Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender){
    	return !(sender == null || server == null);
    }

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(args.length < 1){
			print.chat(sender, space);
			print.chat(sender, "Info Command");
			print.chat(sender, "/ni n <id/name> &8(nation)");
			print.chat(sender, "/ni p <id/name> &8(province)");
			print.chat(sender, "/ni m <id/name> &8(municipality)");
			print.chat(sender, "/ni d <id/name> &8(district)");
			print.chat(sender, "/ni c <id/name> &8(chunk)");
			print.chat(sender, "/ni pl <uuid/name> &8(player)");
			print.chat(sender, "/ni w &8(opens GUI)");
			print.chat(sender, "/ni pos &8(position GUI)");
			return;
		}
		boolean isp = sender.getCommandSenderEntity() instanceof EntityPlayer;
		EntityPlayer player = isp ? (EntityPlayer)sender.getCommandSenderEntity() : null;
		switch(args[0]){
			case "n":{
				print.chat(sender, space + " [NTV]");
				if((args.length < 2 || args[1] == null) && !isp){
					print.chat(sender, "No Nation Selected.");
					return;
				}
				Nation nat = args.length < 2 || args[1] == null ? NVR.getPlayerData(player).municipality.province.nation : NVR.getNation(args, 1);
				if(nat == null){
					print.chat(sender, "Nation not found.");
					return;
				}
				if(nat.parent != null && nat.parent.id != -1){
					print.chat(sender, "&9Parent: &6" + nat.parent.name + " &8(" + nat.parent.id + ");");
				}
				print.chat(sender, "&9Type: &6" + nat.gov_title + " &8(" + nat.type.name().toLowerCase() + ");");
				print.chat(sender, "&9Name: &6" + nat.name + " &8(" + nat.id + ");");
				print.chat(sender, "&9Incharge: &6" + nat.incharge_title + " &3" + (nat.incharge == null ? "no one" : Static.getPlayerNameByUUID(nat.incharge)));
				print.chat(sender, "&9Goverment: ");
				Object[] str = new String[nat.gov.size()];
				if(str.length > 0){
					for(int i = 0; i < str.length; i++){
						str[i] = "&6> &7" + nat.gov_name + " " + Static.getPlayerNameByUUID(nat.gov.get(i));
					}
					print.chat(sender, str);
				}
				else {
					print.chat(sender, "&6> &7none");
				}
				print.chat(sender, "&9Balance: &7" + nat.account.getBalance());
				print.chat(sender, "&9Prev. Income: &7" + nat.prev_income);
				print.chat(sender, space);
				print.chat(sender, "&9Creator: &7" + Static.getPlayerNameByUUID(nat.creator));
				print.chat(sender, "&9Created: &7" + Time.getAsString(nat.created));
				print.chat(sender, "&9Changed: &7" + Time.getAsString(nat.changed));
				print.chat(sender, "&9Neighbors:");
				str = new String[nat.neighbors.size()];
				if(str.length > 0){
					for(int i = 0; i < str.length; i++){
						str[i] = "&6> &7" + NVR.getNation(nat.neighbors.get(i)).name;
					}
					print.chat(sender, str);
				}
				else {
					print.chat(sender, "&6> &7none");
				}
				break;
			}
			case "p":{
				print.chat(sender, space + " [PRV]");
				if((args.length < 2 || args[1] == null) && !isp){
					print.chat(sender, "No Province Selected.");
					return;
				}
				Province prov = args.length < 2 || args[1] == null ? NVR.getPlayerData(player).municipality.province : NVR.getProvince(args, 1);
				if(prov == null){
					print.chat(sender, "Province not found.");
					return;
				}
				print.chat(sender, "&9Nation: &6" + prov.nation.name + " &8(" + prov.nation.id + ");");
				print.chat(sender, "&9Name: &6" + prov.name + " &8(" + prov.id + ");");
				print.chat(sender, "&9Ruler: &6" + prov.ruler_title + " &3" + (prov.ruler == null ? "no one" : Static.getPlayerNameByUUID(prov.ruler)));
				print.chat(sender, "&9Rebels: &3" + prov.rebelper100() + "% &7|| &9Sep.: &3" + prov.seperper100() + "%");
				print.chat(sender, space);
				print.chat(sender, "&9Creator: &7" + Static.getPlayerNameByUUID(prov.creator));
				print.chat(sender, "&9Created: &7" + Time.getAsString(prov.created));
				print.chat(sender, "&9Changed: &7" + Time.getAsString(prov.changed));
				print.chat(sender, "&9Neighbors:");
				Object[] str = new String[prov.neighbors.size()];
				if(str.length > 0){
					for(int i = 0; i < str.length; i++){
						str[i] = "&6> &7" + NVR.getProvince(prov.neighbors.get(i)).name;
					}
					print.chat(sender, str);
				}
				else {
					print.chat(sender, "&6> &7none");
				}
				break;
			}
			case "m":{
				print.chat(sender, space + " [MNV]");
				if((args.length < 2 || args[1] == null) && !isp){
					print.chat(sender, "No Municipality Selected.");
					return;
				}
				Municipality mun = args.length < 2 || args[1] == null ? NVR.getPlayerData(player).municipality : NVR.getMunicipality(args, 1);
				if(mun == null){
					print.chat(sender, "Municipality not found.");
					return;
				}
				print.chat(sender, "&9Province: &6" + mun.province.name + " &8(" + mun.province.id + ");");
				print.chat(sender, "&9Type: &6" + mun.type.getTitle() + " &8(" + mun.type.name().toLowerCase() + ");");
				print.chat(sender, "&9Name: &6" + mun.name + " &8(" + mun.id + ");");
				print.chat(sender, "&9Management: ");
				Object[] str = new String[mun.management.size()];
				if(str.length > 0){
					for(int i = 0; i < str.length; i++){
						str[i] = "&6> &7" + Static.getPlayerNameByUUID(mun.management.get(i));
					}
					print.chat(sender, str);
				}
				else{
					print.chat(sender, "&6> &7none");
				}
				print.chat(sender, "&9Balance: &7" + mun.account.getBalance());
				print.chat(sender, "&9Prev. Income: &7" + mun.previncome);
				print.chat(sender, "&9Citizens: &3" + mun.citizens.size());
				print.chat(sender, "&9Citizen Tax: &3" + mun.citizentax);
				print.chat(sender, space);
				print.chat(sender, "&9Creator: &7" + Static.getPlayerNameByUUID(mun.creator));
				print.chat(sender, "&9Created: &7" + Time.getAsString(mun.created));
				print.chat(sender, "&9Changed: &7" + Time.getAsString(mun.changed));
				print.chat(sender, "&9Neighbors:");
				str = new String[mun.neighbors.size()];
				if(str.length > 0){
					for(int i = 0; i < str.length; i++){
						str[i] = "&6> &7" + NVR.getMunicipality(mun.neighbors.get(i)).name;
					}
					print.chat(sender, str);
				}
				else{
					print.chat(sender, "&6> &7none");
				}
				break;
			}
			case "d":{
				print.chat(sender, space + " [DISV]");
				if((args.length < 2 || args[1] == null) && !isp){
					print.chat(sender, "No District Selected.");
					return;
				}
				District dis = args.length < 2 || args[1] == null ? NVR.getPlayerData(player).lastseen : NVR.getDistrict(args, 1);
				if(dis == null){
					print.chat(sender, "District not found.");
					return;
				}
				print.chat(sender, "&9Municipality: &6" + dis.municipality.name + " &8(" + dis.municipality.id + ");");
				print.chat(sender, "&9Type: &6" + dis.type.name());
				print.chat(sender, "&9Name: &6" + dis.name + " &8(" + dis.id + ");");
				print.chat(sender, "&9Manager: &3" + (dis.manager == null ? "no one" : Static.getPlayerNameByUUID(dis.manager)));
				print.chat(sender, "&9Prev. Income: &7" + dis.previncome);
				print.chat(sender, "&9Chunk Tax: &3" + dis.tax);
				print.chat(sender, space);
				print.chat(sender, "&9Creator: &7" + Static.getPlayerNameByUUID(dis.creator));
				print.chat(sender, "&9Created: &7" + Time.getAsString(dis.created));
				print.chat(sender, "&9Changed: &7" + Time.getAsString(dis.changed));
				print.chat(sender, "&9Neighbors:");
				Object[] str = new String[dis.neighbors.size()];
				if(str.length > 0){
					for(int i = 0; i < str.length; i++){
						str[i] = "&6> &7" + NVR.getDistrict(dis.neighbors.get(i)).name;
					}
					print.chat(sender, str);
				}
				else{
					print.chat(sender, "&6> &7none");
				}
				break;
			}
			case "c":{
				print.chat(sender, space + " [CKV]");
				if((args.length < 3 || args[1] == null || args[2] == null) && !isp){
					print.chat(sender, "Missing Arguments");
					return;
				}
				Chunk ck = args.length < 3 ? NVR.getChunk(player) : NVR.getChunk(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
				if(ck == null){
					print.chat(sender, "Chunk not found or not loaded.");
					return;
				}
				print.chat(sender, "&9District: &6" + ck.district.name + " &8(" + ck.district.id + ");");
				print.chat(sender, "&9Type: &6" + ck.type.name());
				print.chat(sender, "&9Coords: &6" + ck.x + "x&7, &6" + ck.z + "z;");
				print.chat(sender, "&9Owner: &3" + (ck.owner == null ? "no one" : Static.getPlayerNameByUUID(ck.owner)));
				print.chat(sender, "&9Additional Tax: &3" + ck.tax);
				print.chat(sender, "&9Whitelist: ");
				Object[] str = new String[ck.whitelist.size()];
				if(str.length > 0){
					for(int i = 0; i < str.length; i++){
						str[i] = "&6> &7" + Static.getPlayerNameByUUID(UUID.fromString(ck.whitelist.get(i)));
					}
					print.chat(sender, str);
				}
				else{
					print.chat(sender, "&6> &7empty");
				}
				print.chat(sender, space);
				print.chat(sender, "&9Claimer: &7" + Static.getPlayerNameByUUID(ck.claimer));
				print.chat(sender, "&9Claimed: &7" + Time.getAsString(ck.claimed));
				print.chat(sender, "&9Changed: &7" + Time.getAsString(ck.changed));
				print.chat(sender, "&9Linked To: ");
				str = new String[ck.linked.size()];
				if(str.length > 0){
					for(int i = 0; i < str.length; i++){
						DoubleKey key = ck.linked.get(i);
						str[i] = "&6> &7" + key.x() + "x, " + key.z() + ";";
					}
					print.chat(sender, str);
				}
				else{
					print.chat(sender, "&6> &7no chunks");
				}
				break;
			}
			case "pl":{
				print.chat(sender, space + " [PLV]");
				if((args.length < 2 || args[1] == null) && !isp){
					print.chat(sender, "No Player Selected.");
					return;
				}
				Player data = args.length < 2 || args[1] == null ? NVR.getPlayerData(player) : NVR.getPlayerData(args[1], true);
				if(data == null){
					print.chat(sender, "Player not found.");
					return;
				}
				print.chat(sender, "&9Municipality: &6" + data.municipality.name + " &8(" + data.municipality.id + ");");
				print.chat(sender, "&9Nick: &6" + data.getNick(null));
				print.chat(sender, "&9Joined: &3" + Time.getAsString(data.joined));
				print.chat(sender, "&9Last Seen: &3" + (data.on ? "now online" : Time.getAsString(data.lastsave)));
				print.chat(sender, "&9Balance: &3" + data.account.getBalance());
				break;
			}
			case "w":{
				if(!isp){
					print.chat(sender, "Function not available for Console.");
				}
				else{
					print.chat(sender, "Function not available yet.");
				}
				break;
			}
			case "pos":{
				if(!isp){
					print.chat(sender, "Function not available for Console.");
				}
				else{
					Sender.sendLocationUpdate(player, "< Requested Position Update >", "</ni pos>", null, null);
				}
				break;
			}
		}
	}
	
}