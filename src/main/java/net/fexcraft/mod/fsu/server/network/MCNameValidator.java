package net.fexcraft.mod.fsu.server.network;

import java.io.InputStream;
import java.util.UUID;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fsu.server.network.WebIO.IWebListener;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class MCNameValidator implements IWebListener {
	
	private JsonObject obj = new JsonObject();
	
	@Override
	public void process(JsonObject msg){
		String name = msg.get("name").getAsString();
		name = name.replace(" ", "");
		UUID uuid = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerProfileCache().getGameProfileForUsername(name).getId();
		obj.addProperty("uuid", uuid.toString());
	}

	@Override
	public String getId(){
		return "mc_name_validator";
	}

	@Override
	public JsonObject getObj(){
		return obj;
	}

	@Override
	public void reset(){
		obj = new JsonObject();
	}

	@Override
	public InputStream getStream(){
		return null;
	}
	
}