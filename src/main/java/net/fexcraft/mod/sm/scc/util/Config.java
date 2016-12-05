/**
 * THIS FILE IS PART OF 'SCC' Simple Chunk Control
 *  © Fexcraft.net
 *  
 *  @author Ferdinand (FEX___96)
 */
package net.fexcraft.mod.sm.scc.util;

import java.util.ArrayList;

import net.minecraftforge.common.config.Configuration;

public class Config {
	
	public static ArrayList<String> fbl;
	public static int maxChunkPerPlayer;
	public static boolean protectUnclaimed;
	public static boolean allowed;
	public static final String version = "1.1";
	
	public static void initialize(){
		Configuration cfg = new Configuration(Data.config);
		cfg.load();
		maxChunkPerPlayer = cfg.getInt("max_chunks_per_player", "Chunk", 8, 1, 4096, "Maximal amount of Chunks a Player can claim.");
		protectUnclaimed = cfg.getBoolean("protect_unclaimed", "chunk", false, "Should Block placing/breaking be disabled in unclaimed chunks?");
		allowed = cfg.getBoolean("claiming", "Chunk", true, "Are Players allowed to claim land?");
		cfg.save();
	}
}