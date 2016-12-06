package net.fexcraft.mod.lib.util.json;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FilenameUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import net.fexcraft.mod.lib.util.cls.Print;

/**
 * @author Ferdinand (FEX___96)
 * @comment Main class for Json processing.
 */
public class JsonUtil{
	
	private static final JsonParser parser = new JsonParser();
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	/**
	 * @return Current JsonParser instance;
	 */
	public static JsonParser getParser(){
		return parser;
	}
	
	/**
	 * @return Current gson instance used by JsonUtil;
	 */
	public static Gson getGson(){
		return gson;
	}
	
	/**
	 * Gets an JsonObject from given String
	 * @param string
	 * @return empty JsonObject if String == null
	 */
	public static JsonObject getObjectFromString(String string){
		JsonElement elm = getFromString(string);
		if(elm == null){
			return new JsonObject();
		}
		return elm.getAsJsonObject();
	}
	
	/**
	 * Gets an JsonElement from given String,<br>
	 * @param string
	 * @return null if String == null
	 */
	public static JsonElement getFromString(String string, boolean b){
		if(string == null){
			return null;
		}
		try{
			return parser.parse(string);
		}
		catch(Exception e){
			if(b){
				e.printStackTrace();
			}
			return null;
		}
	}
	
	public static JsonElement getFromString(String string){
		return getFromString(string, true);
	}
	
	public static void addToArrayIfNotContains(JsonArray array, String string){
		boolean contains = false;
		for(JsonElement elm : array){
			if(elm.getAsString().equals(string)){
				contains = true;
				break;
			}
		}
		if(!contains){
			array.add(new JsonPrimitive(string));
		}
	}
	
	public static JsonObject getJsonForPacket(String target){
		JsonObject obj = new JsonObject();
		obj.addProperty("target_listener", target);
		return obj;
	}
	
	
	public static Reader getReader(String file_extension){
		return new Reader(file_extension);
	}
	
	/**
	 * @param file the file to be parsed into json
	 * @param b notify in logs about error in parsing, or file missing
	 * @return JsonElement from given file, or null
	 */
	public static JsonElement read(File file, boolean b){
		try{
			FileReader fr = new FileReader(file);
			JsonElement obj = parser.parse(fr);
			fr.close();
			return obj;
		}
		catch (Exception e) {
			if(b){
				e.printStackTrace();
			}
			Print.log("File '" + file + "' seems to be missing, or has invalid format.");
			return null;
		}
	}
	
	/**
	 * @param file file the file to be parsed into json
	 * @return JsonObject from file, or new JsonObject if there are errors in previous methods
	 */
	public static JsonObject get(File file){
		JsonElement e = read(file, false);
		if(e == null || e.isJsonObject() == false){
			return new JsonObject();
		}
		else return e.getAsJsonObject();
	}
	
	/**
	 * @author Ferdinand (FEX___96)
	 * @comment Reader.class which will only read files with specific extension.
	 */
	public static class Reader{
		
		private String file_extension;
		
		public Reader(String file_extension){
			this.file_extension = file_extension;
		}
		
		/**
		 * @param file the file to be parsed into json
		 * @param b notify in logs about error in parsing, or file missing
		 * @return JsonElement from given file, or null
		 */
		public JsonElement read(File file, boolean b){
			String ex = FilenameUtils.getExtension(file.getPath());
			if(ex != file_extension){
				return null;
			}
			FileReader fr;
			try{
				fr = new FileReader(file);
				JsonElement obj = parser.parse(fr);
				fr.close();
				return obj;
			} catch (IOException e) {
				if(b){
					e.printStackTrace();
					Print.log("[FCL] File '" + file + "' seems to be missing.");
				}
				return null;
			}
		}
		
		/**
		 * @param file file the file to be parsed into json
		 * @return JsonObject from file, or new JsonObject if there are errors in previous methods
		 */
		public JsonObject getObject(File file){
			JsonElement e = read(file, false);
			if(e == null || e.isJsonObject() == false){
				return new JsonObject();
			}
			else return e.getAsJsonObject();
		}
	}
	
	/**
	 * Writes a JsonObject into the speficied file (Gson Pretty Printing Configuration)
	 * @param file target file
	 * @param obj JsonElement to be written into the file
	 */
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
	
	/**
	 * @param file File to be updated
	 * @param string Target value/object
	 * @param value
	 */
	public static void update(File file, String string, String value){
		JsonObject obj = get(file);
		obj.addProperty(string, value);
		write(file, obj);
	}
	
	/**
	 * @param file File to be updated
	 * @param string Target value/object
	 * @param value
	 */
	public static void update(File file, String string, boolean value){
		JsonObject obj = get(file);
		obj.addProperty(string, value);
		write(file, obj);
	}
	
	/**
	 * @param file File to be updated
	 * @param string Target value/object
	 * @param value
	 */
	public static void update(File file, String string, Number value){
		JsonObject obj = get(file);
		obj.addProperty(string, value);
		write(file, obj);
	}
	
	/**
	 * @param file File to be updated
	 * @param string Target value/object
	 * @param value
	 */
	public static void update(File file, String string, JsonElement element){
		JsonObject obj = get(file);
		obj.add(string, element);
		write(file, obj);
	}
	
	/**
	 * Gets a value from a JsonObject if it exists, else returns specified default value and adds it to the JsonObject
	 * @param obj
	 * @param target
	 * @param default_value
	 */
	public static String getIfExists(JsonObject obj, String target, String default_value){
		if(!obj.has(target)){
			obj.addProperty(target, default_value);
			return default_value;
		}
		return obj.get(target).getAsString();
	}
	
	/**
	 * Gets a value from a JsonObject if it exists, else returns specified default value and adds it to the JsonObject
	 * @param obj
	 * @param target
	 * @param default_value
	 */
	public static Number getIfExists(JsonObject obj, String target, Number default_value){
		if(!obj.has(target)){
			obj.addProperty(target, default_value);
			return default_value;
		}
		return obj.get(target).getAsNumber();
	}
	
	/**
	 * Gets a value from a JsonObject if it exists, else returns specified default value and adds it to the JsonObject
	 * @param obj
	 * @param target
	 * @param default_value
	 */
	public static boolean getIfExists(JsonObject obj, String target, boolean default_value){
		if(!obj.has(target)){
			obj.addProperty(target, default_value);
			return default_value;
		}
		return obj.get(target).getAsBoolean();
	}
	
	/**
	 * Gets a JsonElement from a JsonObject if it exists, else returns specified default JsonElement and adds it to the JsonObject
	 * @param obj
	 * @param target
	 * @param default_value
	 */
	public static JsonElement getIfExists(JsonObject obj, String target, JsonElement default_value){
		if(!obj.has(target)){
			obj.add(target, default_value);
			return default_value;
		}
		return obj.get(target);
	}
	
	/**
	 * Gets a value from a JsonObject if it exists, else returns null
	 * @param obj
	 * @param target
	 * @param default_value
	 */
	public static String getStringIfExists(JsonObject obj, String target){
		if(obj.has(target)){
			return obj.get(target).getAsString();
		}
		return null;
	}
	
	/**
	 * Gets a value from a JsonObject if it exists, else returns -1
	 * @param obj
	 * @param target
	 * @param default_value
	 */
	public static Number getNumberIfExists(JsonObject obj, String target){
		if(obj.has(target)){
			return obj.get(target).getAsNumber();
		}
		return -1;
	}
	
	/**
	 * Gets a value from a JsonObject if it exists, else returns false
	 * @param obj
	 * @param target
	 * @param default_value
	 */
	public static boolean getBooleanIfExists(JsonObject obj, String target){
		if(obj.has(target)){
			return obj.get(target).getAsBoolean();
		}
		return false;
	}
	
	/**
	 * Gets a JsonElement from a JsonObject if it exists, else returns null
	 * @param obj
	 * @param target
	 * @param default_value
	 */
	public static JsonElement getIfExists(JsonObject obj, String target){
		if(!obj.has(target)){
			return obj.get(target);
		}
		return null;
	}
	
	////>>>> ARRAYS >>>>////
	
	/**
	 * Gets a sub-array from an Object in a File, returns new JsonArray if there are errors in previous methods or doesn't exists.
	 * @param file
	 * @param string
	 * @return
	 */
	public static JsonArray getArray(File file, String string){
		JsonObject obj = get(file);
		if(obj.get(string) != null){
			JsonElement el = obj.get(string);
			if(el.isJsonArray() == true){
				return obj.get(string).getAsJsonArray();
			}
			else{
				return new JsonArray();
			}
		}
		else{
			return new JsonArray();
		}
	}
	
	
	public static boolean contains(JsonArray array, String string){
		boolean result = false;
		for(JsonElement e : array){
			try{
				if(e.getAsString().equals(string)){
					result = true;
				}
			}
			catch(ClassCastException ex){
				ex.printStackTrace();
				result = false;
				continue;
			}
		}
		return result;
	}
	
	/**
	 * @param file File to be updated
	 * @param string Target value/object
	 * @param value
	 */
	public static void update(File file, String string, JsonArray value){
		JsonObject obj = get(file);
		obj.add(string, value);
		write(file, obj);
	}
	
	/**
	 * Checks if JsonArray contains String.
	 * @param array
	 * @param string
	 * @return
	 */
	public static boolean contains(JsonArray array, Number number){
		boolean result = false;
		for(JsonElement e : array){
			try{
				if(e.getAsNumber() == number){
					result = true;
				}
			}
			catch(ClassCastException ex){
				ex.printStackTrace();
				result = false;
				continue;
			}
		}
		return result;
	}
	
	public static ArrayList<String> jsonArrayToStringArray(JsonArray array){
		ArrayList<String> list = new ArrayList<String>();
		for(JsonElement e : array){
			try{
				if(e.isJsonPrimitive()){
					String str = e.getAsString();
					list.add(str);
				}
			}
			catch(ClassCastException ex){
				//ex.printStackTrace();
				continue;
			}
		}
		return list;
	}
	
	public static ArrayList<Integer> jsonArrayToIntegerArray(JsonArray array){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(JsonElement e : array){
			try{
				if(e.isJsonPrimitive()){
					Integer num = e.getAsInt();
					list.add(num);
				}
			}
			catch(ClassCastException ex){
				//ex.printStackTrace();
				continue;
			}
		}
		return list;
	}
	
	public static void add(JsonArray array, String string){
		array.add(new JsonPrimitive(string));
	}
	
	public static void add(JsonArray array, Number number){
		array.add(new JsonPrimitive(number));
	}
	
	public static JsonArray getArrayFromStringList(ArrayList<String> array){
		JsonArray ja = new JsonArray();
		for(String s : array){
			add(ja, s);
		}
		return ja;
	}
	
	public static JsonArray getArrayFromIntegerList(ArrayList<Integer> array){
		JsonArray ja = new JsonArray();
		for(int i : array){
			add(ja, i);
		}
		return ja;
	}

	public static boolean isJsonFile(File file) {
		try{
			FileReader fr = new FileReader(file);
			parser.parse(fr);
			fr.close();
			return true;
		}
		catch(IOException e){
			return false;
		}
	}
	
}