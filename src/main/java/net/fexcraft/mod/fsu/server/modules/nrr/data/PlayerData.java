package net.fexcraft.mod.fsu.server.modules.nrr.data;

import java.util.UUID;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fsmm.FSMM;
import net.fexcraft.mod.fsmm.account.AccountManager.Account;
import net.fexcraft.mod.fsu.server.modules.nrr.NRR;
import net.fexcraft.mod.lib.perms.player.AttachedData;
import net.fexcraft.mod.lib.perms.player.PlayerPerms;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.math.BlockPos;

public class PlayerData implements AttachedData<PlayerData> {
	
	public UUID uuid;
	public PlayerPerms perms;
	public Account account;
	//
	private String nick;
	//
	public Province province;
	public BlockPos last_pos;
	public int last_province;
	
	//
	
	public PlayerData(PlayerPerms pp){
		perms = pp;
	}

	@Override
	public String getId(){
		return NRR.PLAYERDATA;
	}

	@Override
	public JsonObject save(UUID uuid){
		FSMM.getInstance().getAccountManager().saveAccount(account);
		JsonObject obj = new JsonObject();
		if(nick != null){
			obj.addProperty("Nick", nick);
		}
		obj.addProperty("Province", province.id);
		obj.addProperty("LastSave", Time.getDate());
		
		
		
		return obj;
	}

	@Override
	public void load(UUID uuid, JsonObject elm){
		this.uuid = uuid;
		if(elm == null){
			province = NRR.provinces.get(-1);
			

			Print.debug("NULL");
		}
		else{
			JsonObject obj = elm.getAsJsonObject();
			if(obj.has("Nick")){
				nick = obj.get("Nick").getAsString();
			}
			province = NRR.provinces.get(JsonUtil.getIfExists(obj, "Province", -1).intValue());
			Print.debug("PRN: " + province == null);
			if(province == null){
				province = NRR.provinces.get(-1);
			}
			Print.debug("PRN: " + province.id);
			
			

			Print.debug("NOT NULL");
		}
		account = FSMM.getInstance().getAccountManager().getAccountOf(uuid);
	}

	public String getNick(ICommandSender sender){
		if(nick == null){
			return "&2" + sender.getName();
		}
		else return nick;
	}
	
}