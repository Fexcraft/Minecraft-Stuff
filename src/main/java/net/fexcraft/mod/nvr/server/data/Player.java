package net.fexcraft.mod.nvr.server.data;

import java.util.UUID;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fsmm.account.AccountManager.Account;
import net.fexcraft.mod.lib.perms.player.AttachedData;
import net.fexcraft.mod.lib.perms.player.PlayerPerms;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.nvr.server.NVR;
import net.minecraft.command.ICommandSender;

public class Player implements AttachedData {
	
	public UUID uuid;
	public PlayerPerms perms;
	public Account account;
	private String nick;
	
	public Player(PlayerPerms pp){
		perms = pp;
	}

	@Override
	public String getId(){
		return NVR.DATASTR;
	}

	@Override
	public AttachedData load(UUID uuid, JsonObject obj){
		this.uuid = uuid;
		this.nick = obj.has("Nick") ? obj.get("Nick").getAsString() : null;
		this.account = Account.getAccountManager().getAccountOf(uuid);
		return this;
	}

	@Override
	public JsonObject save(UUID uuid){
		Account.getAccountManager().saveAccount(account);
		JsonObject obj = new JsonObject();
		if(nick != null){ obj.addProperty("Nick", nick); }
		obj.addProperty("LastSave", Time.getDate());
		return obj;
	}

	public String getNick(ICommandSender sender){
		return nick == null ? "&2" + sender.getName() : nick;
	}
	
}