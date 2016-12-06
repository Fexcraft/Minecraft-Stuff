package net.fexcraft.mod.extensions.fve.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import net.fexcraft.mod.frsm.FRSM;
import net.fexcraft.mod.frsm.util.PrintLog;
import net.fexcraft.mod.frsm.util.java.FR;
import net.fexcraft.mod.frsm.util.json.JsonUtil;

public class Data{
	
	private static File file_c;
	public static JsonObject obj_c;
	
	public static void getDataFromServer(){
		file_c = new File(FRSM.tempdata, "Temp_FVE_Data_" + FR.nextInt(9999) + ".fd");
		file_c.deleteOnExit();
		try {
			URL url = new URL("http://www.fexcraft.net/files/TXT/" + FI.MCV + "/fve.fd");
			FileUtils.copyURLToFile(url, file_c);
			obj_c = JsonUtil.read(file_c, true).getAsJsonObject();
			
		}
		catch(IOException | JsonSyntaxException ex) {
			ex.printStackTrace();
			PrintLog.print("UpdateChecker", "Failed to get data from Server, creating dummy temp-file to prevent crashes.");
			obj_c = new JsonObject();
			obj_c.addProperty("latest_version", FI.VERSION);
			obj_c.addProperty("latest_mc_version", FI.MCV);
		}
	}
	
}