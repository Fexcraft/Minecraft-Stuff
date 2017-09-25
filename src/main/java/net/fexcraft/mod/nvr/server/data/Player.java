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
	public long joined;
	//tracking
	public District lastseen;
	public Vec3d lastseenpos;
	public Municipality municipality;
	public long lastsave;
	public boolean on;
	
	/** internal use only */
	private Player(){}
	
	public Player(PlayerPerms pp){
		perms = pp;
	}

	@Override
	public String getId(){
		return NVR.DATASTR;
	}

	@Override
	public AttachedData load(UUID uuid, JsonObject obj){
		this.on = true;
		obj = obj == null ? new JsonObject() : obj;
		this.uuid = uuid;
		this.joined = obj.has("Joined") ? obj.get("Joined").getAsLong() : Time.getDate();
		this.lastsave = JsonUtil.getIfExists(obj, "LastSave", 0).longValue();
		if(lastsave == 0){ lastsave = Time.getDate(); }
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
		obj.addProperty("Joined", joined);
		obj.addProperty("LastSave", lastsave = Time.getDate());
		return obj;
	}

	public String getNick(ICommandSender sender){
		if(sender == null){
			return nick == null ? "no nick" : nick;
		}
		return nick == null ? "&2" + sender.getName() : nick;
	}
	
	public static final Player loadOffline(UUID uuid, JsonObject obj){
		Player player = new Player();
		player.on = false;
		obj = obj == null ? new JsonObject() : obj;
		player.uuid = uuid;
		player.joined = obj.has("Joined") ? obj.get("Joined").getAsLong() : Time.getDate();
		player.lastsave = JsonUtil.getIfExists(obj, "LastSave", 0).longValue();
		if(player.lastsave == 0){ player.lastsave = Time.getDate(); }
		player.nick = obj.has("Nick") ? obj.get("Nick").getAsString() : null;
		player.account = Account.getAccountManager().getAccountOf(uuid);
		//
		int mun = JsonUtil.getIfExists(obj, "Municipality", -1).intValue();
		player.municipality = NVR.getMunicipality(mun);
		if(!player.municipality.citizens.contains(uuid) && mun != -1){
			player.municipality = NVR.getMunicipality(-1);
			NVR.LOGGER.log(uuid + " not found in citizen list of (" + player.municipality.id + ") " + player.municipality.name + ";");
		}
		return player;
	}
	
}