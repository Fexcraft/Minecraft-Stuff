package net.fexcraft.mod.lib.util.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.util.json.JsonUtil;

public class ZipUtil {
	
	public static JsonObject getJsonObject(File file, String target){
		try{
			JsonObject obj = null;
			ZipFile zip = new ZipFile(file);
			ZipInputStream stream = new ZipInputStream(new FileInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			while(true){
				ZipEntry entry = stream.getNextEntry();
				if(entry == null){
					break;
				}
				if(entry.getName().equals(target)){
					obj = JsonUtil.getObjectFromInputStream(zip.getInputStream(entry));
					break;
				}
			}
			reader.close();
			zip.close();
			stream.close();
			return obj;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean contains(File file, String target){
		try{
			ZipInputStream stream = new ZipInputStream(new FileInputStream(file));
			while(true){
				ZipEntry entry = stream.getNextEntry();
				if(entry == null){
					break;
				}
				if(entry.getName().equals(FvmResources.DEFPACKCFGFILENAME)){
					stream.close();
					return true;
				}
			}
			stream.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
}