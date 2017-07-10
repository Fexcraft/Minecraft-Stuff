package net.fexcraft.mod.fvm.data;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.model.NullModel;
import net.fexcraft.mod.fvm.model.PartModel;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.tmt.Model;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.render.ModelType;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.util.ResourceLocation;

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
			Addon addon = FvmResources.ADDONS.getValue(new ResourceLocation(obj.get("Addon").getAsString()));
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

	public static ArrayList<ResourceLocation> getTextures(JsonObject obj, String rgn, String type){
		ArrayList<ResourceLocation> textures = new ArrayList<ResourceLocation>();
		if(!obj.has("Textures")){
			Print.log("NO TEXTURE FOUND FOR " + type + " (" + rgn + ")! APPLYING DEFAULT TEXTURE;");
			textures.add(FvmResources.NULL_TEXTURE);
		}
		else{
			try{
				JsonArray array = obj.get("Textures").getAsJsonArray();
				for(JsonElement elm : array){
					textures.add(new ResourceLocation(elm.getAsString()));
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return textures;
	}

	public static Model loadModel(ModelType modeltype, String modelname, Class<? extends Model> clazz) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		switch(modeltype){
			case JAVA:
			case TMT:
				Class clasz = Class.forName(modelname.replace(".class", ""));
				return (Model)clasz.newInstance();
			case JSON:
				//TODO;
				return null;
			case JTMT:
				JsonObject obj = JsonUtil.getObjectFromInputStream(net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(modelname)).getInputStream());
				return clazz.getConstructor(JsonObject.class).newInstance(obj);
			case OBJ:
				//TODO
				return null;
			case NONE:
				if(clazz == PartModel.class){
					return NullModel.get();
				}
			default:
				return null;
		}
	}
	
}