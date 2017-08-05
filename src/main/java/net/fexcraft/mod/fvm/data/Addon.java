package net.fexcraft.mod.fvm.data;

import java.io.File;
import java.util.UUID;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.common.ZipUtil;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Addon implements IForgeRegistryEntry<Addon> {
	
	public static final String deflink = "no url provided by pack author", deflicense = "no license url provided by pack author";
	//
	public File file;
    private ResourceLocation registryname;
	public String name, url, license, fileaddr;
	public ArrayList<ResourceLocation> dependencies;
	public ArrayList<UUID> authors = new ArrayList<UUID>();
	public ArrayList<String> altauthors = new ArrayList<String>();
	public boolean enabled = true, missing_dependencies = false;
	public String version;
	
	public Addon(File file){
		this.file = file;
		JsonObject obj = null;
		if(file.isDirectory()){
			obj = JsonUtil.get(new File(file, FvmResources.DEFPACKCFGFILENAME));
		}
		else{
			obj = ZipUtil.getJsonObject(file, FvmResources.DEFPACKCFGFILENAME);
		}
		try{
			this.registryname = new ResourceLocation(obj.get("id").getAsString());
		}
		catch(Exception e){
			e.printStackTrace();
			Static.halt();
		}
		this.name = JsonUtil.getIfExists(obj, "name", "Name Missing.");
		if(obj.has("dependencies")){
			this.dependencies = JsonUtil.jsonArrayToResourceLocationArray(obj.get("dependencies").getAsJsonArray());
		}
		if(obj.has("authors")){
			JsonArray array = obj.get("authors").getAsJsonArray();
			for(JsonElement elm : array){
				try{
					String str = elm.getAsString();
					if(str.split(":")[0].equals("fnet")){
						altauthors.add(str);
					}
					else{
						authors.add(UUID.fromString(elm.getAsString()));
					}
				}
				catch(Exception e){
					Print.log("ADN: (" + registryname.toString() + ") " + e.getMessage());
				}
			}
		}
		this.url = JsonUtil.getIfExists(obj, "url", "no url provided by pack author");
		this.license = JsonUtil.getIfExists(obj, "license", "no license url provided by pack author");
		this.version = JsonUtil.getIfExists(obj, "version", "1.0");
	}
	
	/** To load temporary addon copies for GUI's **/
	public Addon(NBTTagCompound nbt){
		this.registryname = new ResourceLocation(nbt.getString("id"));
		this.name = nbt.getString("name");
		this.dependencies = JsonUtil.jsonArrayToResourceLocationArray(JsonUtil.getFromString(nbt.getString("dependencies")).getAsJsonArray());
		this.authors = new ArrayList<UUID>();
		JsonArray authors  = JsonUtil.getFromString(nbt.getString("authors")).getAsJsonArray();
		for(JsonElement elm : authors){
			this.authors.add(UUID.fromString(elm.getAsString()));
		}
		this.altauthors = JsonUtil.jsonArrayToStringArray(JsonUtil.getFromString(nbt.getString("altauthors")).getAsJsonArray());
		this.url = nbt.getString("url");
		this.license = nbt.getString("license");
		this.enabled = nbt.getBoolean("enabled");
		this.missing_dependencies = nbt.getBoolean("missing_dependencies");
		this.fileaddr = nbt.getString("file");
		this.version = nbt.getString("version");
	}
	
	public NBTTagCompound toNBT(){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("id", registryname.toString());
		nbt.setString("name", name);
		nbt.setString("dependencies", JsonUtil.getArrayFromResourceLocationList(dependencies).toString());
		nbt.setString("authors", JsonUtil.getArrayFromUUIDList(authors).toString());
		nbt.setString("altauthors", JsonUtil.getArrayFromStringList(altauthors).toString());
		nbt.setString("url", url);
		nbt.setString("license", license);
		nbt.setBoolean("enabled", enabled);
		nbt.setBoolean("missing_depencencies", missing_dependencies);
		nbt.setString("file", fileaddr == null ? file.toString() : fileaddr);
		nbt.setString("version", version);
		return nbt;
	}

	public static boolean isAddonContainer(File file){
		if(file.isDirectory()){
			File fl = new File(file, FvmResources.DEFPACKCFGFILENAME);
			try{
				return fl.exists();
			}
			catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}
		if(file.getName().endsWith(".zip") || file.getName().endsWith(".jar")){
			return ZipUtil.contains(file, FvmResources.DEFPACKCFGFILENAME);
		}
		return false;
	}

	public static void registerAsDummyMod(){
		//TODO		
	}

	@Override
	public Addon setRegistryName(ResourceLocation name){
		registryname = name;
		return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return registryname;
	}

	@Override
	public Class<Addon> getRegistryType(){
		return Addon.class;
	}
	
	public String regname(){
		return this.registryname.toString();
	}
	
}