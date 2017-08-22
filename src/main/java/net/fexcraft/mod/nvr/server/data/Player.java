package net.fexcraft.mod.nvr.server.data;

import java.util.UUID;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fsmm.account.AccountManager.Account;
import net.fexcraft.mod.lib.perms.player.AttachedData;
import net.fexcraft.mod.lib.perms.player.PlayerPerms;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.nvr.server.NVR;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.math.Vec3d;

public class Player implements AttachedData {
	
	public UUID uuid;
	public PlayerPerms perms;
	public Account account;
	private String nick;
	//tracking
	public District lastseen;
	public Vec3d lastseenpos;
	public Municipality municipality;
	
	public Player(PlayerPerms pp){
		perms = pp;
	}

	@Override
	public String getId(){
		return NVR.DATASTR;
	}

	@Override
	public AttachedData load(UUID uuid, JsonObject obj){
		obj = obj == null ? new JsonObject() : obj;
		this.uuid = uuid;
		this.nick = obj.has("Nick") ? obj.get("Nick").getAsString() : null;
		this.account = Account.getAccountManager().getAccountOf(uuid);
		//
		int mun = JsonUtil.getIfExists(obj, "Municipality", -1).intValue();
		municipality = NVR.getMunicipality(mun);
		if(!municipality.citizens.contains(uuid) && mun != -1){
			municipality = NVR.getMunicipality(-1);
			Print.debug(uuid + " not found in citizen list of (" + municipality.id + ") " + municipality.name + ";");
		}
		return this;
	}

	@Override
	public JsonObject save(UUID uuid){
		Account.getAccountManager().saveAccount(account);
		JsonObject obj = new JsonObject();
		if(nick != null){ obj.addProperty("Nick", nick); }
		obj.addProperty("LastSave", Time.getDate());
		obj.addProperty("Municipality", this.municipality.id);
		return obj;
	}

	public String getNick(ICommandSender sender){
		return nick == null ? "&2" + sender.getName() : nick;
	}
	
}