/**
 * THIS FILE IS PART OF 'SCC' Simple Chunk Control
 *  © Fexcraft.net
 *  
 *  @author Ferdinand (FEX___96)
 */
package net.fexcraft.mod.sm.scc.events;

import net.fexcraft.mod.sm.scc.util.Chunk;
import net.fexcraft.mod.sm.scc.util.Data;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChunkEvents {
	
	@SubscribeEvent
	public void onLoad(ChunkEvent.Load event){
		Chunk chunk = new Chunk(event.getChunk().x, event.getChunk().z);
		Data.chunks.add(chunk);
	}
	
	@SubscribeEvent
	public void onUnLoad(ChunkEvent.Unload event){
		Chunk chunk = Data.getChunk(event.getChunk().x, event.getChunk().z);
		if(chunk != null){
			chunk.save();
			Data.chunks.remove(chunk);
		}
	}
	
}