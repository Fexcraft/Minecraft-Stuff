package net.fexcraft.mod.fsu.server.modules.nrr.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fsu.server.network.WebIO.IWebListener;
import net.fexcraft.mod.lib.FCL;

public class MapWL implements IWebListener {
	
	@Override
	public void process(JsonObject msg){
		//
	}

	@Override
	public String getId(){
		return "nrrmap_province_view";
	}

	@Override
	public JsonObject getObj(){
		return null;
	}

	@Override
	public void reset(){
		//
	}

	@Override
	public InputStream getStream(){
		try{
			return new FileInputStream(new File(FCL.getInstance().getConfigDirectory().getParentFile(), "/fsu-nrr/map_0_0.png"));
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
			return null;
		}
	}
	
}