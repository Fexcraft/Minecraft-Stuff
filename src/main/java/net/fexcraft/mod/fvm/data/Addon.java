package net.fexcraft.mod.fvm.data;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.common.ZipUtil;
import net.fexcraft.mod.lib.util.json.JsonUtil;

public class Addon {
	
	public File file;
	public String id, name, url, license;
	public ArrayList<String> dependencies;
	public ArrayList<UUID> authors;
	public ArrayList<String> altauthors;
	
	public Addon(File file){
		this.file = file;
		JsonObject obj = null;
		if(file.isDirectory()){
			obj = JsonUtil.get(new File(file, FvmResources.DEFPACKCFGFILENAME));
		}
		else{
			obj = ZipUtil.getJsonObject(file, FvmResources.DEFPACKCFGFILENAME);
		}
		try{
			this.id = obj.get("id").getAsString();
		}
		catch(Exception e){
			e.printStackTrace();
			Static.halt();
		}
		this.name = JsonUtil.getIfExists(obj, "name", "Name Missing.");
		if(obj.has("dependencies")){
			this.dependencies = JsonUtil.jsonArrayToStringArray(obj.get("dependencies").getAsJsonArray());
		}
		if(obj.has("authors")){
			JsonArray array = obj.get("authors").getAsJsonArray();
			for(JsonElement elm : array){
				try{
					String str = elm.getAsString();
					if(str.split(":")[0].equals("fnet")){
						altauthors.add(str);
					}
					else{
						authors.add(UUID.fromString(elm.getAsString().replace("-", "")));
					}
				}
				catch(Exception e){
					Print.log("ADN: (" + id + ") " + e.getMessage());
				}
			}
		}
		this.url = JsonUtil.getIfExists(obj, "url", "no url provided by pack author");
		this.license = JsonUtil.getIfExists(obj, "license", "no license url provided by pack author");
	}

	public static boolean isAddonContainer(File file){
		if(file.isDirectory()){
			File fl = new File(file, FvmResources.DEFPACKCFGFILENAME);
			try{
				return fl.exists();
			}
			catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}
		if(file.getName().endsWith(".zip") || file.getName().endsWith(".jar")){
			return ZipUtil.contains(file, FvmResources.DEFPACKCFGFILENAME);
		}
		return false;
	}

	public static void registerAsDummyMod(){
		//TODO		
	}
	
}