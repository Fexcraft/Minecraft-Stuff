package net.fexcraft.mod.nvr.server.network;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import com.google.gson.JsonObject;

import net.fexcraft.mod.nvr.common.enums.Mode;
import net.fexcraft.mod.nvr.server.network.nano_httpd.NanoHTTPD;
import net.fexcraft.mod.nvr.server.network.nano_httpd.NanoHTTPD.Response.Status;
import net.fexcraft.mod.nvr.server.util.ImageCache;

public class WebServer extends NanoHTTPD {
	
	public static WebServer instance;
	
	public WebServer(){
		super(8910);
		instance = this;
		try{
			start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
		}
		catch (IOException e){
			e.printStackTrace();
		}
		System.out.println("[NVR-WEB] Running on port " + this.getListeningPort() + "!");
	}
	
	public static void end(int arg){
		instance.mainThread.stop();
		//System.exit(arg);
	}
	
	@Override
	public Response serve(IHTTPSession session){
		try{
			session.parseBody(new HashMap<String, String>());
		} catch (IOException | ResponseException e) {
			e.printStackTrace();
		}
		if(session.getParameters().isEmpty()){
			return newFixedLengthResponse(Status.OK, NanoHTTPD.MIME_PLAINTEXT, "{\"error\":\"no parameters specified\"}");
		}
		else{
			try{
				String x = session.getParameters().get("x").get(0);
				String z = session.getParameters().get("z").get(0);
				String t = session.getParameters().get("t").get(0);
				return getImage(x, z, t);
			}
			catch(Exception e){
				JsonObject obj = new JsonObject();
				obj.addProperty("error", e.getMessage());
				return newFixedLengthResponse(Status.OK, NanoHTTPD.MIME_PLAINTEXT, obj.toString());
			}
		}
		//return newFixedLengthResponse(Status.BAD_REQUEST, NanoHTTPD.MIME_PLAINTEXT, "null");
	}

	private Response getImage(String x, String z, String t) throws IOException {
		if(ImageCache.exists(Integer.parseInt(x), Integer.parseInt(z), Mode.fromInt(Integer.parseInt(t)))){
			InputStream stream = ImageCache.get(0, Integer.parseInt(x), Integer.parseInt(z), Mode.fromInt(Integer.parseInt(t)));
			return this.newChunkedResponse(Status.OK, "image/png", stream);
		}
		else{
			return this.newChunkedResponse(Status.OK, "image/png", ImageCache.getEmptyChunkImage());
		}
	}
	
}