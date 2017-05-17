package net.fexcraft.mod.fvm.data;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.items.MaterialItem;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.item.Item;

public class Material {
	
	public Addon addonpack;
	public String registryname, fullname;
	public String[] description;
	public Item item;
	public int maxStackSize;
	
	public Material(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj, "MATERIAL");
		this.addonpack = DataUtil.getAddon(registryname, obj, "MATERIAL");
		this.fullname = JsonUtil.getIfExists(obj, "FullName", registryname);
		this.description = DataUtil.getDescription(obj);
		this.item = MaterialItem.register(this);
		this.maxStackSize = JsonUtil.getIfExists(obj, "MaxStackSize", 64).intValue();
	}
	
}