package net.fexcraft.mod.fsu.server.modules.nrr.data;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fsu.server.modules.nrr.NRR;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Chunk implements DataObject {
	
	public int x, z;
	public Province province;
	public ProtectionType ptype;
	public String mainbiome;
	public Map<String, Integer> biomes = new TreeMap<String, Integer>();
	
	public Chunk(int x, int z, World w){
		this.x = x; this.z = z;
		load(JsonUtil.get(getFile()));
		this.x = x; this.z = z;
		if(biomes.isEmpty() || mainbiome == null){
			scanBiomes(w);
			JsonUtil.write(getFile(), save(), true);
		}
	}
	
	private void scanBiomes(World w){
		for(int i = 0; i < 16; i++){
			for(int j = 0; j < 16; j++){
				BlockPos pos = new BlockPos(i + (16 * x), 65, j + (z * 16));
				String name = w.getBiome(pos).getBiomeName();
				if(biomes.containsKey(name)){
					biomes.put(name, biomes.get(name) + 1);
				}
				else{
					biomes.put(name, 1);
				}
			}
		}
		int i = biomes.values().stream().max(Integer::compare).get();
		for(Entry<String, Integer> key : biomes.entrySet()){
			if(key.getValue() == i){
				mainbiome = key.getKey();
				break;
			}
		}
	}

	public Chunk(JsonObject obj){
		load(obj);
	}

	@Override
	public JsonObject save(){
		JsonObject obj = new JsonObject();
		obj.addProperty("x", x);
		obj.addProperty("z", z);
		obj.addProperty("province", province.id);
		obj.addProperty("protection", ptype.toString());
		obj.addProperty("mainbiome", mainbiome);
		JsonArray array = new JsonArray();
		for(Entry<String, Integer> entry : biomes.entrySet()){
			JsonObject elm = new JsonObject();
			elm.addProperty("amount", entry.getValue());
			elm.addProperty("name", entry.getKey());
			array.add(elm);
		}
		obj.add("biomes", array);
		return obj;
	}

	@Override
	public void load(JsonObject obj){
		x = JsonUtil.getIfExists(obj, "x", 0).intValue();
		z = JsonUtil.getIfExists(obj, "z", 0).intValue();
		province = NRR.provinces.get(JsonUtil.getIfExists(obj, "province", -1).intValue());
		if(province == null){
			province = NRR.provinces.get(-1);
		}
		ptype = ProtectionType.fromString(JsonUtil.getIfExists(obj, "protection", "null"));
		mainbiome = JsonUtil.getIfExists(obj, "mainbiome", "Plains");
		if(obj.has("biomes")){
			for(JsonElement elm : obj.get("biomes").getAsJsonArray()){
				biomes.put(elm.getAsJsonObject().get("name").getAsString(), elm.getAsJsonObject().get("amount").getAsInt());
			}
		}
	}

	@Override
	public File getFile(){
		return NRR.getChunkFile(x, z);
	}
	
	public static enum ProtectionType {
		NONE("null"),
		PUBLIC("public"),
		PROVINCE("provincial"),
		PRIVATE("private"),
		COMPANY("commercial"),
		REGIONAL("regional"),
		GOVERMENT("national"),
		MILITARY("military"),
		SERVER("server");
		
		private String id;
		
		ProtectionType(String s){
			id = s;
		}
		
		@Override
		public String toString(){
			return id;
		}
		
		public static ProtectionType fromString(String s){
			for(ProtectionType type : values()){
				if(type.id.equals(s)){
					return type;
				}
			}
			return NONE;
		}
	}
	
}