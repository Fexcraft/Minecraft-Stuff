package net.fexcraft.mod.fvm.data;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;

public class Addon {
	
	public File file;
	public String id, name, url, license;
	public ArrayList<String> dependencies;
	public ArrayList<UUID> authors;
	
	public Addon(File file){
		JsonObject obj = new JsonObject();//TODO
		this.file = file;
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
					authors.add(UUID.fromString(elm.getAsString()));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		this.url = JsonUtil.getIfExists(obj, "url", "no url provided by pack author");
		this.license = JsonUtil.getIfExists(obj, "license", "no license url provided by pack author");
	}

	public static boolean isAddonContainer(File file){
		if(file.isDirectory()){
			File fl = new File(file, "addonpack.fvm");
			try{
				return fl.exists();
			}
			catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}
		if(file.getName().endsWith(".zip") || file.getName().endsWith(".jar")){
			try{
				ZipInputStream stream = new ZipInputStream(new FileInputStream(file));
				while(true){
					ZipEntry entry = stream.getNextEntry();
					if(entry == null){
						stream.close();
						break;
					}
					if(entry.getName().equals("addonpack.fvm")){
						stream.close();
						return true;
					}
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return false;
		}
		return false;
	}
	
}