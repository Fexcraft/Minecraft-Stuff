package net.fexcraft.mod.fvm.data;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.items.PartItem;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.item.Item;

public class Part {
	
	public final Addon addon;
	public final String registryname;
	public final int /*maxHealth,*/ maxStackSize;
	public final Item item;
	
	public Part(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj, "PART");
		this.addon = DataUtil.getAddon(registryname, obj, "PART");
		//this.maxHealth = JsonUtil.getIfExists(obj, "MaxHealth", 100).intValue();//500
		this.maxStackSize = JsonUtil.getIfExists(obj, "MaxStackSize", 64).intValue();
		this.item = new PartItem(this);
	}

	public void loadModel(){
		
	}	
	
}