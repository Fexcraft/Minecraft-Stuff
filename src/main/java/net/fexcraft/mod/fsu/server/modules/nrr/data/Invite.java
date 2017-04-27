package net.fexcraft.mod.fsu.server.modules.nrr.data;

import java.io.File;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fsu.server.modules.nrr.NRR;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Time;

public class Invite {
	
	public Type type;
	public String target;
	public String sender;
	public boolean accepted;
	public boolean cancelled;
	public JsonObject ddd;
	public long created;
	
	//Def constructor from JSON;
	public Invite(JsonObject obj){
		try{
			type = Type.fromString(obj.get("type").getAsString());
			target = obj.get("target").getAsString();
			sender = obj.get("sender").getAsString();
			accepted = obj.get("accepted").getAsBoolean();
			cancelled = obj.get("cancelled").getAsBoolean();
			ddd = obj.get("additional_data").getAsJsonObject();
			created = obj.get("created").getAsLong();
		}
		catch(Exception e){
			cancelled = true;
			ddd = new JsonObject();
			ddd.addProperty("error", e.getMessage());
			created = 0;
		}
	}
	
	//Province -> Player
	public Invite(String sen, String tar, String sen_name, String tar_name, int pr){
		type = Type.PROVINCE_TO_PLAYER;
		target = tar_name;
		sender = sen_name;
		ddd = new JsonObject();
		ddd.addProperty("sender_name", sen);
		ddd.addProperty("target_name", tar);
		ddd.addProperty("province", pr);
		accepted = false;
		cancelled = false;
		created = Time.getDate();
	}
	
	public void accept(){
		switch(type){
			case PROVINCE_TO_PLAYER:
				PlayerData data = NRR.getPlayerData(ddd.get("target_name").getAsString());
				if(data != null){
					data.province = NRR.provinces.get(ddd.get("province").getAsInt());
					NRR.sendToProvince(data.province.id, "&a" + ddd.get("target_name").getAsString() + "&7 joined the province!");
					break;
				}
				else return;
			default:
				return;
		}
		NRR.invites.remove(this);
		this.accepted = true;
		this.cancelled = true;
		this.save();
	}
	
	public void cancel(){
		switch(type){
			case PROVINCE_TO_PLAYER:
				NRR.sendToProvince(ddd.get("province").getAsInt(), "&a" + ddd.get("target_name").getAsString() + "&7's invite to join &c" + NRR.provinces.get(ddd.get("province").getAsInt()).name + "&7 was cancelled.");
				break;
			default:
				break;
		}
		NRR.invites.remove(this);
		this.accepted = false;
		this.cancelled = true;
		this.save();
	}
	
	public void save(){
		JsonUtil.write(new File(NRR.getInvitesFolder(), "[" + type.toString() + "]_" + sender + "_" + target + "_A-" + accepted + "_C-" + cancelled + "_" + created), toJson());
	}

	@Override
	public String toString(){
		return toJson().toString();
	}
	
	public JsonObject toJson(){
		JsonObject obj = new JsonObject();
		obj.addProperty("type", type.toString());
		obj.addProperty("sender", sender);
		obj.addProperty("target", target);
		obj.addProperty("accepted", accepted);
		obj.addProperty("cancelled", cancelled);
		obj.add("additional_data", ddd);
		return obj;
	}
	
	public static enum Type {
		
		PROVINCE_TO_PLAYER("province_to_player"),
		REGION_TO_PROVINCE("region_to_province"),
		NATION_TO_REGION("nation_to_region"),
		UNION_TO_NATION("union_to_nation"),
		COMPANY_TO_PLAYER("company_to_player");
		
		private String name;
		
		Type(String s){
			name = s;
		}
		
		public static Type fromString(String s){
			for(Type type : values()){
				if(type.name.equals(s)){
					return type;
				}
			}
			return null;
		}
		
		@Override
		public String toString(){
			return name;
		}
	}
	
}