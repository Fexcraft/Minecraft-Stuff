package net.fexcraft.mod.fsu.server.network;

import java.io.InputStream;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fsu.server.network.WebIO.IWebListener;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class PlayerList implements IWebListener {
	
	private JsonObject obj = new JsonObject();
	
	@Override
	public void process(JsonObject msg){
		obj.add("list", new JsonArray());
		for(EntityPlayerMP entity : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers()){
			JsonObject objj = new JsonObject();
			objj.addProperty("name", entity.getName());
			objj.addProperty("uuid", entity.getGameProfile().getId().toString());
			obj.get("list").getAsJsonArray().add(objj);
		}
	}

	@Override
	public String getId(){
		return "get_online_players";
	}

	@Override
	public JsonObject getObj(){
		return obj;
	}

	@Override
	public void reset(){
		obj = null;
		obj = new JsonObject();
	}

	@Override
	public InputStream getStream(){
		return null;
	}
	
}