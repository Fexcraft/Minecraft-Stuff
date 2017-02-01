/**
 * THIS FILE IS PART OF 'SCC' Simple Chunk Control
 *  © Fexcraft.net
 *  
 *  @author Ferdinand (FEX___96)
 */
package net.fexcraft.mod.sm.scc.util;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Data {
	
	public static File path, chunk, player, config;
	public static Set<Chunk> chunks = new HashSet<Chunk>();
	public static Set<Player> players = new HashSet<Player>();
	
	public static void initalize(File file){
		path = new File(file, "/scc");
		if(!path.exists()){
			path.mkdirs();
		}
		chunk = new File(path, "/chunks/");
		if(!chunk.exists()){
			chunk.mkdirs();
		}
		player = new File(path, "/players/");
		if(!player.exists()){
			player.mkdirs();
		}
		config = new File(path, "scc.cfg");
	}

	public static Chunk getChunk(int x, int z) {
		for(Chunk chunk : chunks){
			if(chunk.x == x && chunk.z == z){
				return chunk;
			}
		}
		return null;
	}

	public static Chunk getChunk(World world, BlockPos pos) {
		net.minecraft.world.chunk.Chunk ck = world.getChunkFromBlockCoords(pos);
		return getChunk(ck.xPosition, ck.zPosition);
	}

	public static Player getPlayer(UUID id) {
		for(Player player : players){
			if(player.uuid.toString().equals(id.toString())){
				return player;
			}
		}
		return null;
	}
	
	
}