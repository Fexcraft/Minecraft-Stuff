package net.fexcraft.mod.lib.perms.player;

import java.util.UUID;

import javax.annotation.Nullable;

import com.google.gson.JsonElement;

public interface AttachedData<T> {
	
	public String getId();
	
	public JsonElement save(UUID uuid);
	
	public void load(UUID uuid, @Nullable JsonElement jsonElement);
	
}