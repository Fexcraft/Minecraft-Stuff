package net.fexcraft.mod.frsm.util.json;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.fexcraft.mod.frsm.util.PrintLog;

/**
 * @author Ferdinand (FEX___96)
 * @category Utils
 * @comment Json Utility
 */
public class JsonUtil{
	
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	public static JsonArrayUtil ar;
	
	/** Write Element **/
	public static void write(File file, JsonElement obj){
		try{
			FileWriter fw = new FileWriter(file);
			fw.write(gson.toJson(obj));
			fw.flush();
			fw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/** Get Element **/
	public static JsonElement read(File file, boolean b){
		JsonParser parser = new JsonParser();
		FileReader fr;
		try{
			fr = new FileReader(file);
			JsonElement obj = parser.parse(fr);
			fr.close();
			return obj;
		} catch (IOException e) {
			if(b){
				e.printStackTrace();
			}
			PrintLog.print("FRSM", "File '" + file + "' seems to be missing.");
			return null;
		}
	}
	
	/** Get Object from Element **/
	public static JsonObject get(File file){
		JsonElement e = read(file, false);
		if(e == null || e.isJsonObject() == false){
			return new JsonObject();
		}
		else return e.getAsJsonObject();
	}
	
	/** Get String - from File **/
	public static String getS(File file, String string){
		JsonObject obj = get(file);
		String result = null;
		if(obj.get(string) != null){
			result = obj.get(string).getAsString();
		}
		return result;
	}
	
	/** Get String - from Object **/
	public static String getS(JsonObject obj, String string){
		String result = null;
		if(obj.get(string) != null){
			result = obj.get(string).getAsString();
		}
		return result;
	}
	
	/** Get String - from File - Not Null - Update File**/
	public static String getSNN(File file, String string){
		String result = getS(file, string);
		if(result == null){
			update(file, string, "null");
			result = "null";
		}
		return result;
	}
	
	/** Get String - from Object - Not Null - Update Object**/
	public static String getSNN(JsonObject obj, String string){
		String result = getS(obj, string);
		if(result == null){
			obj.addProperty(string, "null");
			result = "null";
		}
		return result;
	}
	
	/** Get Number - from File **/
	public static Number getN(File file, String string){
		JsonObject obj = get(file);
		Number result = null;
		if(obj.get(string) != null){
			result = obj.get(string).getAsNumber();
		}
		return result;
	}
	
	/** Get Number - from File - Not Null - Update File**/
	public static Number getNNN(File file, String string, Number default_value){
		Number result = getN(file, string);
		if(result == null){
			update(file, string, default_value);
			result = default_value;
		}
		return result;
	}
	
	/** Get Integer **/
	public static int getI(File file, String string, Number default_value){
		return getNNN(file, string, default_value).intValue();
	}
	
	/** Get Float **/
	public static float getF(File file, String string, Number default_value){
		return getNNN(file, string, default_value).floatValue();
	}
	
	/** Get Double **/
	public static double getD(File file, String string, Number default_value){
		return getNNN(file, string, default_value).doubleValue();
	}
	
	/** Get Short **/
	public static short getShort(File file, String string, Number default_value){
		return getNNN(file, string, default_value).shortValue();
	}
	
	/** Get Long **/
	public static long getLong(File file, String string, Number default_value){
		return getNNN(file, string, default_value).longValue();
	}
	
	/** Get Byte **/
	public static byte getByte(File file, String string, Number default_value){
		return getNNN(file, string, default_value).byteValue();
	}
	
	/** Get Boolean - from File **/
	public static boolean getB(File file, String string){
		JsonObject obj = get(file);
		boolean result = false;
		if(obj.get(string) != null){
			result = obj.get(string).getAsBoolean();
		}
		return result;
	}
	
	/** Format String - remove slashes **/
	private static String format(String string){
		return string.replaceAll("\"", "");
	}

	public static void update(File file, String string, String value){
		JsonObject obj = get(file);
		obj.addProperty(string, value);
		write(file, obj);
	}
	
	public static void update(File file, String string, boolean value){
		JsonObject obj = get(file);
		obj.addProperty(string, value);
		write(file, obj);
	}
	
	public static void update(File file, String string, Number value){
		JsonObject obj = get(file);
		obj.addProperty(string, value);
		write(file, obj);
	}
	
	public static void update(File file, String string, JsonElement element){
		JsonObject obj = get(file);
		obj.add(string, element);
		write(file, obj);
	}
	
//+//////////////////////////+// OLD NON-DELETED CODE //+//////////////////////////+//
	
	//// ARRAYS >>>>
	
	public static ArrayList<String> getSA(File folder, String id, String compare, String get){
		ArrayList<String> list = new ArrayList<String>();
		String s = null;
		for(File file : folder.listFiles()){
			if(file.isDirectory()){}
			else{
				s = getS(file, id);
				if(s.equals(compare)){
					list.add(getS(file, get));
				}
			}
		}
		return list;
	}
	
	public static ArrayList<String> getSA(File folder, String id, int compare, String get){
		ArrayList<String> list = new ArrayList<String>();
		int i = -1;
		for(File file : folder.listFiles()){
			if(file.isDirectory()){}
			else{
				i = getI(file, id, 0);
				if(i == compare){
					list.add(getS(file, get));
				}
			}
		}
		return list;
	}
	
	public static ArrayList<String> getSA(File folder, String get){
		ArrayList<String> list = new ArrayList<String>();
		for(File file : folder.listFiles()){
			if(file.isDirectory()){}
			else{
				list.add(getS(file, get));
			}
		}
		return list;
	}
	

	
	public static JsonElement getFA(ArrayList<JsonElement> array, String compare, String searched){
		JsonElement json = null;
		for(JsonElement obj : array){
			if(obj.getAsJsonObject().get(compare).getAsString().equals(searched)){
				json = obj;
			}
		}
		return json;
	}
	
	////CREATE IF NOT EXISTS >>>>
	
	public static String getIfExistsS(File file, String string){
		String result = null;
		if(!file.exists()){
			update(file, string, "null");
			return result = "null";
		}
		else{
			result = getS(file, string);
		}
		return result;
	}
	
	public static int getIfExistsI(File file, String string){
		int result = -1;
		if(!file.exists()){
			update(file, string, 0);
			return result = 0;
		}
		else{
			result = getI(file, string, 0);
		}
		return result;
	}
	
	public static float getIfExistsF(File file, String string){
		float result = -1F;
		if(!file.exists()){
			update(file, string, 0);
			return result = 0F;
		}
		else{
			result = getF(file, string, 0);
		}
		return result;
	}
	
	public static float getIfExistsFM(File file, String string){
		float result = 0F;
		if(!file.exists()){
			update(file, string, 0);
			return result = 0F;
		}
		else{
			result = getF(file, string, 0);
		}
		return result;
	}
	
	public static String getOrCreate(JsonObject obj, String target, String defval){
		if(obj.has(target)){
			return obj.get(target).getAsString();
		}
		else{
			obj.addProperty(target, defval);
			return defval;
		}
	}
	
	public static int getOrCreate(JsonObject obj, String target, int defval){
		if(obj.has(target)){
			return obj.get(target).getAsInt();
		}
		else{
			obj.addProperty(target, defval);
			return defval;
		}
	}
	
	public static JsonObject getOrCreate(JsonObject obj, String target, JsonObject defval){
		if(obj.has(target)){
			return obj.get(target).getAsJsonObject();
		}
		else{
			obj.add(target, defval);
			return defval;
		}
	}

	
	public static JsonArray getOrCreate(JsonObject obj, String target, JsonArray defval){
		if(obj.has(target)){
			return obj.get(target).getAsJsonArray();
		}
		else{
			obj.add(target, defval);
			return defval;
		}
	}
	
	public static float getOrCreate(JsonObject obj, String target, float defval){
		if(obj.has(target)){
			return obj.get(target).getAsFloat();
		}
		else{
			obj.addProperty(target, defval);
			return defval;
		}
	}
	
	public static double getOrCreate(JsonObject obj, String target, double defval){
		if(obj.has(target)){
			return obj.get(target).getAsDouble();
		}
		else{
			obj.addProperty(target, defval);
			return defval;
		}
	}
	
	public static boolean getOrCreate(JsonObject obj, String target, boolean defval){
		if(obj.has(target)){
			return obj.get(target).getAsBoolean();
		}
		else{
			obj.addProperty(target, defval);
			return defval;
		}
	}
	
}