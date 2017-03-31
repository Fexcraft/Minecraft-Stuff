package net.fexcraft.mod.lib.perms.player;

import java.util.UUID;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

public interface AttachedData<T> {
	
	public String getId();
	
	public JsonObject save(UUID uuid);
	
	public void load(UUID uuid, @Nullable JsonObject jsonElement);
	
}