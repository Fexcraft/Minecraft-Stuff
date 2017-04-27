package net.fexcraft.mod.fsu.server.modules.nrr.data;

import java.io.File;

import com.google.gson.JsonObject;

public interface DataObject {
	
	public JsonObject save();
	
	public void load(JsonObject obj);

	public File getFile();
	
}