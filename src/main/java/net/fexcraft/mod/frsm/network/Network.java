package net.fexcraft.mod.frsm.network;

import java.io.IOException;
import java.net.URL;

import net.fexcraft.mod.frsm.network.data.Data;
import net.fexcraft.mod.frsm.network.data.Links;
import net.fexcraft.mod.frsm.network.util.UpdateHandler;
import net.minecraftforge.common.MinecraftForge;

public class Network{
	
	public static boolean isConnected(){
		try{
			URL url = new URL("http://www.fexcraft.net/files/TXT/connection.test");
			url.openConnection().connect();
			return true;
		}
		catch(IOException e){
			//e.printStackTrace();
			return false;
		}
	}
	
	
	public static void init(){
		Data.getDataFromServer();
		Links.getDownloadLinks();
		
		MinecraftForge.EVENT_BUS.register(new UpdateHandler.EventHandler());
		UpdateHandler.load();
	}
}