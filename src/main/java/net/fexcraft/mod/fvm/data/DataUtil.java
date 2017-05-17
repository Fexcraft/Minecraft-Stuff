package net.fexcraft.mod.fvm.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.render.RGB;

public class DataUtil {
	
	public static String getRegistryName(JsonObject obj, String type){
		if(obj.has("RegistryName")){
			return obj.get("RegistryName").getAsString();
		}
		else{
			Print.log(type + " DOES NOT HAVE A REGISTRY NAME, THAT IS AN ISSUE;");
			Print.log(obj);
			Static.halt();
		}
		return null;
	}
	
	public static Addon getAddon(String rgn, JsonObject obj, String type){
		if(obj.has("Addon")){
			Addon addon = FvmResources.addons.get(obj.get("Addon").getAsString());
			if(addon == null){
				Print.log("ADDON PACK NOT FOUND FOR " + type + " (" + rgn + "), OR INCORRECT NAME, THAT IS AN ISSUE;");
				Static.halt();
			}
			return addon;
		}
		else{
			Print.log(type + " (" + rgn + ") DOES NOT HAVE A SET ADDON PACK, THAT IS AN ISSUE;");
			Static.halt();
		}
		return null;
	}
	
	public static String[] getDescription(JsonObject obj){
		if(obj.has("Description")){
			JsonArray desc = obj.get("Description").getAsJsonArray();
			String[] description = new String[desc.size()];
			for(int i = 0; i < desc.size(); i++){
				description[i] = desc.get(i).getAsString();
			}
			return description;
		}
		return new String[0];
	}
	
	public static RGB getRGB(JsonObject obj, String string){
		return obj.has(string) ? RGB.fromJSON(obj.get(string).getAsJsonObject(), false) : new RGB();
	}
	
}