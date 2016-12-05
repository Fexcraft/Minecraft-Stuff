package net.fexcraft.mod.frsm.util.json;

import java.io.File;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class JsonArrayUtil{
	
	private static JsonUtil ju;
	
	public static JsonArray getArray(File file, String string){
		JsonObject obj = ju.get(file);
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
	
	public static void update(File file, String string, JsonArray value){
		JsonObject obj = ju.get(file);
		obj.add(string, value);
		ju.write(file, obj);
	}
	
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
	
	public static JsonArray remove(JsonArray array, String string){
		JsonArray list = new JsonArray();
		for(JsonElement elm : array){
			if(!elm.getAsString().equals(string)){
				list.add(elm);
			}
		}
		return list;
	}
	
	public static JsonArray remove(JsonArray array, int integer){
		JsonArray list = new JsonArray();
		for(JsonElement elm : array){
			if(!(elm.getAsInt() == integer)){
				list.add(elm);
			}
		}
		return list;
	}
	
	public static JsonArray remove(JsonArray array, JsonObject obj){
		JsonArray list = new JsonArray();
		for(JsonElement elm : array){
			if(!(elm.getAsJsonObject().equals(obj))){
				list.add(elm);
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
	
	
}