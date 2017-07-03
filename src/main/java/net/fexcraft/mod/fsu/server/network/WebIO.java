package net.fexcraft.mod.fsu.server.network;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fexcraft.mod.fsu.server.FSU;
import net.fexcraft.mod.fsu.server.modules.nvr.NVR;
import net.fexcraft.mod.fsu.server.network.nano_httpd.NanoHTTPD;
import net.fexcraft.mod.fsu.server.network.nano_httpd.NanoHTTPD.Response.Status;
import net.fexcraft.mod.lib.util.json.JsonUtil;

public class WebIO extends NanoHTTPD {
	
	public static TreeMap<String, IWebListener> listeners = new TreeMap<String, IWebListener>();
	public static WebIO instance;
	
	public WebIO(){
		super(FSU.PORT);
		instance = this;
		try{
			start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
		}
		catch (IOException e){
			e.printStackTrace();
		}
		System.out.println("[FSU-WEBSYNC] Running on port " + FSU.PORT + "!");
	}
	
	public static void end(int arg){
		instance.myThread.stop();
		//System.exit(arg);
	}
	
	public static void launch(){
		new WebIO();
	}
	
	public static void addListener(String id, IWebListener listener){
		listeners.put(id, listener);
		System.out.println("[FSU-WEBSYNC] Registered listener with ID '" + listener.getId() + "'!");
	}
	
	@Override
	public Response serve(IHTTPSession session){
		try {
			session.parseBody(new HashMap<String, String>());
		} catch (IOException | ResponseException e) {
			e.printStackTrace();
		}
		try{
			JsonObject result = new JsonObject();
			String rq = session.getParameters().get("rq").get(0);
			switch(rq){
				case "sql":{
						for(String string : session.getParameters().get(rq)){
							if(string.toUpperCase().contains("DELETE") || string.toUpperCase().contains("INSERT") || string.toUpperCase().contains("UPDATE")){
								result.addProperty("error", "invalid request");
							}
							else{
								result.add("results", new JsonArray());
								ResultSet set = NVR.SQL.query(string);
								while(set.next()){
									JsonObject obj = new JsonObject();
									int j = set.getMetaData().getColumnCount();
									//Print.log(j);
									for(int i = 0; i < j; i++){
										String name = set.getMetaData().getColumnName(i + 1);
										String str = set.getString(name);
										if(str.startsWith("{") || str.startsWith("[")){
											obj.add(name, JsonUtil.getFromString(str));
										}
										else{
											obj.addProperty(name, str);
										}
										//Print.log(obj.toString());
									}
									result.get("results").getAsJsonArray().add(obj);
								}
							}
						}
					}
					break;
			}
			return newFixedLengthResponse(Status.OK, NanoHTTPD.MIME_PLAINTEXT, result.toString());
		}
		catch(Exception e){
			JsonObject obj = new JsonObject();
			obj.addProperty("error", e.getMessage());
			return newFixedLengthResponse(Status.OK, NanoHTTPD.MIME_PLAINTEXT, obj.toString());
		}
		//return newFixedLengthResponse(Status.BAD_REQUEST, NanoHTTPD.MIME_PLAINTEXT, "null");
	}
	
	public static interface IWebListener{
		public void process(JsonObject msg);
		public String getId();
		public JsonObject getObj();
		public void reset();
		public InputStream getStream();
	}
	
}