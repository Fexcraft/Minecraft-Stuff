package net.fexcraft.mod.fsu.server.network;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.TreeMap;

import com.google.gson.JsonObject;
import net.fexcraft.mod.fsu.server.FSU;
import net.fexcraft.mod.fsu.server.modules.nrr.util.MappingUtil;
import net.fexcraft.mod.fsu.server.network.nano_httpd.NanoHTTPD;
import net.fexcraft.mod.fsu.server.network.nano_httpd.NanoHTTPD.Response.Status;

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
		System.out.println("[FSU-WEBSYNC] Running on port 8134!");
		//addListener("mc_name_validator", new MCNameValidator());
		//addListener("get_online_players", new PlayerList());
		//addListener("nrrmap_province_view", new MapWL());
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
		String rr = session.getQueryParameterString();
		if(rr != null){
			JsonObject result = new JsonObject();
			try{
				rr = rr.replace("rq=", "");
				switch(rr){
					case "nrr_provincemap":
						return newChunkedResponse(Status.OK, "image/png", new FileInputStream(MappingUtil.ProvinceMap.file));
					default:
						result.addProperty("exists", false);
						result.addProperty("error", "invalid_adress");
						break;
				}
				/*rr = rr.replace("obj=", "");
				JsonObject elm = JsonUtil.getObjectFromString(rr);
				
				if(!elm.has("target")){
					result.addProperty("exists", false);
					result.addProperty("error", "target_missing");
				}
				else{
					IWebListener ls = listeners.get(elm.get("target").getAsString());
					if(ls != null){
						ls.process(elm);
						result = ls.getObj();
						if(result == null){
							return newChunkedResponse(Status.OK, "image/png", ls.getStream());
						}
						if(result.has("response_type") && !result.get("response_type").getAsString().equals("json")){
							switch(result.get("response_type").getAsString()){
								case "image":
									return newChunkedResponse(Status.OK, "image/png", ls.getStream());
							}
						}
						else{
							result.addProperty("exists", true);
							result.addProperty("error", "none");
						}
						ls.reset();
					}
					else{
						result.addProperty("exists", false);
						result.addProperty("error", "not_found");
					}
				}*/
			}
			catch(Exception e){
				result.addProperty("exists", false);
				result.addProperty("error", e.getMessage());
				e.printStackTrace();
			}
			return newFixedLengthResponse(Status.OK, NanoHTTPD.MIME_PLAINTEXT, result.toString());
		}
		else{
			JsonObject obj = new JsonObject();
			obj.addProperty("exists", false);
			obj.addProperty("error", "request_null");
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