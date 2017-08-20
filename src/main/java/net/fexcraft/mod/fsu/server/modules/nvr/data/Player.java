package net.fexcraft.mod.fsu.server.modules.nvr.data;

import java.util.UUID;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fsmm.account.AccountManager.Account;
import net.fexcraft.mod.fsu.server.modules.nvr.NVR;
import net.fexcraft.mod.lib.perms.player.AttachedData;
import net.fexcraft.mod.lib.perms.player.PlayerPerms;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.command.ICommandSender;

public class Player implements AttachedData {
	
	public UUID uuid;
	public PlayerPerms perms;
	public Account account;
	//
	private String nick;
	//
	public Municipality municipality;
	//
	
	public Player(PlayerPerms pp){
		perms = pp;
	}

	@Override
	public String getId(){
		return NVR.PLAYERDATA;
	}

	@Override
	public JsonObject save(UUID uuid){
		Account.getAccountManager().saveAccount(account);
		JsonObject obj = new JsonObject();
		if(nick != null){
			obj.addProperty("Nick", nick);
		}
		obj.addProperty("Municipality", municipality.id);
		obj.addProperty("LastSave", Time.getDate());
		return obj;
	}

	@Override
	public Player load(UUID uuid, JsonObject elm){
		this.uuid = uuid;
		if(elm == null){
			this.municipality = NVR.municipalities.get(-1);
			Print.debug("NULL");
		}
		else{
			JsonObject obj = elm.getAsJsonObject();
			if(obj.has("Nick")){
				nick = obj.get("Nick").getAsString();
			}
			this.municipality = NVR.municipalities.get(JsonUtil.getIfExists(obj, "Municipality", -1).intValue());
			Print.debug("NOT NULL");
		}
		account = Account.getAccountManager().getAccountOf(uuid);
		return this;
	}

	public String getNick(ICommandSender sender){
		if(nick == null){
			return "&2" + sender.getName();
		}
		else return nick;
	}
	
}