package net.fexcraft.mod.nvr.server.events;

import net.fexcraft.mod.nvr.server.NVR;
import net.fexcraft.mod.nvr.server.data.Chunk;
import net.fexcraft.mod.nvr.server.data.DoubleKey;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChunkEvents {
	
	@SubscribeEvent
	public void onLoad(ChunkEvent.Load event){
		int x = event.getChunk().x, z = event.getChunk().z;
		NVR.CHUNKS.put(new DoubleKey(x, z), new Chunk(x, z, null));
	}
	
	@SubscribeEvent
	public void onUnLoad(ChunkEvent.Unload event){
		Chunk chunk = NVR.CHUNKS.get(new DoubleKey(event.getChunk().x, event.getChunk().z));
		if(chunk != null){
			chunk.save();
			NVR.CHUNKS.remove(new DoubleKey(chunk.x, chunk.z));
		}
	}
	
}