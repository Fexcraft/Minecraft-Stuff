package net.fexcraft.mod.nvr.server.data;

import java.io.File;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.perms.player.PlayerPerms;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.nvr.common.enums.ChunkType;
import net.fexcraft.mod.nvr.common.enums.Mode;
import net.fexcraft.mod.nvr.server.NVR;
import net.fexcraft.mod.nvr.server.util.ImageCache;
import net.fexcraft.mod.nvr.server.util.Permissions;

public class Chunk {
	
	public final int x, z;
	public ChunkType type;
	public District district;
	public UUID claimer, owner;
	public long claimed, changed;
	public ArrayList<String> whitelist = new ArrayList<String>();
	public ArrayList<DoubleKey> linked = new ArrayList<DoubleKey>();
	public double tax;
	
	public Chunk(int x, int z, UUID claim){
		this.x = x; this.z = z;
		try{
			JsonObject obj = JsonUtil.get(this.getFile(x, z));
			if(!obj.has("claimer")){
				obj.addProperty("claimer", (claimer = claim == null ? UUID.fromString(NVR.DEF_UUID) : claim).toString());
				obj.addProperty("type", (type = ChunkType.NEUTRAL).name());
				obj.addProperty("district", (district = NVR.DISTRICTS.get(-1)).id);
				//obj.addProperty("owner", "");
				obj.addProperty("claimed", claimed = Time.getDate());
				obj.addProperty("changed", changed = Time.getDate());
				obj.add("whitelist", new JsonArray());
				obj.add("linked", new JsonArray());
				obj.addProperty("tax", tax = 0);
				File file = this.getFile(x, z);
				if(!file.getParentFile().exists()){
					file.getParentFile().mkdirs();
				}
				JsonUtil.write(file, obj);
				//
				ImageCache.updateChunk(Static.getServer().getEntityWorld(), this, Mode.CLAIM);
				ImageCache.updateChunk(Static.getServer().getEntityWorld(), this, Mode.TYPE);
				ImageCache.updateChunk(Static.getServer().getEntityWorld(), this, Mode.GEOGRAPHIC);
			}
			else{
				type = ChunkType.fromString(JsonUtil.getIfExists(obj, "type", ChunkType.NEUTRAL.name()));
				district = NVR.getDistrict(JsonUtil.getIfExists(obj, "district", -1).intValue());
				claimer = UUID.fromString(JsonUtil.getIfExists(obj, "claimer", NVR.DEF_UUID));
				owner = obj.has("owner") && !obj.get("owner").getAsString().equals("") ? UUID.fromString(JsonUtil.getIfExists(obj, "owner", NVR.DEF_UUID)) : null;
				claimed = JsonUtil.getIfExists(obj, "claimed", 0).longValue();
				changed = JsonUtil.getIfExists(obj, "changed", 0).longValue();
				whitelist = JsonUtil.jsonArrayToStringArray(JsonUtil.getIfExists(obj, "whitelist", new JsonArray()).getAsJsonArray());
				linked = DoubleKey.getFromStringJsonArray(JsonUtil.jsonArrayToStringArray(JsonUtil.getIfExists(obj, "linked", new JsonArray()).getAsJsonArray()));
				tax = JsonUtil.getIfExists(obj, "tax", 0).doubleValue();
			}
		}
		catch(Exception e){
			e.printStackTrace();
			Static.halt();
		}
	}
	
	public static final File getFile(int x, int z){
		return new File(NVR.CHUNK_DIR, ImageCache.getRegion(x, z) + "/" + x + "_" + z + ".json");
	}

	public final void save(){
		try{
			JsonObject obj = new JsonObject();
			obj.addProperty("type", type.name());
			obj.addProperty("district", district.id);
			obj.addProperty("claimer", claimer.toString());
			obj.addProperty("owner", owner == null ? "" : owner.toString());
			obj.addProperty("claimed", claimed);
			obj.addProperty("changed", changed);
			obj.add("whitelist", JsonUtil.getArrayFromStringList(whitelist));
			obj.add("linked", JsonUtil.getArrayFromObjectList(linked));
			obj.addProperty("tax", tax);
			//
			obj.addProperty("last_save", Time.getDate());
			JsonUtil.write(getFile(x, z), obj);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public String tryClaim(PlayerPerms perms, Player player, District dis, boolean asa){
		boolean has = asa ? (player == null ? true : perms.hasPermission(Permissions.ADMIN)) : (player != null && (dis.manager.equals(player.uuid) || dis.municipality.management.contains(player.uuid) || dis.municipality.province.ruler.equals(player.uuid) || dis.municipality.province.nation.canClaim(player.uuid)));
		if(!has){ return "No Permission"; }
		if(dis == null){ return "Tried to claim (" + x + "|" + z + ") but supplied District is NULL;"; }
		//todo database logging
		this.district = dis;
		this.claimer = UUID.fromString(player == null ? NVR.CONSOLE_UUID : player.uuid.toString());
		this.claimed = Time.getDate();
		this.changed = Time.getDate();
		//
		ImageCache.updateChunk(Static.getServer().getEntityWorld(), this, Mode.CLAIM);
		ImageCache.updateChunk(Static.getServer().getEntityWorld(), this, Mode.TYPE);
		ImageCache.updateChunk(Static.getServer().getEntityWorld(), this, Mode.GEOGRAPHIC);
		//
		this.save();
		return "Claim successful.";
	}
	
}