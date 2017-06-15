package net.fexcraft.mod.fsu.server.modules.nvr.events;

import net.fexcraft.mod.fsu.server.modules.nvr.NVR;
import net.fexcraft.mod.fsu.server.modules.nvr.NVR.DK;
import net.fexcraft.mod.fsu.server.modules.nvr.data.Chunk;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChunkEvents {
	
	@SubscribeEvent
	public void onLoad(ChunkEvent.Load event){
		int x = event.getChunk().xPosition;
		int z = event.getChunk().zPosition;
		NVR.chunks.put(new DK(x, z), new Chunk(x, z));
		
		//Mapping.
		//MappingUtil.ProvinceMap.processChunk(event.getWorld(), x, z);*/
	}
	
	@SubscribeEvent
	public void onUnLoad(ChunkEvent.Unload event){
		Chunk chunk = NVR.chunks.get(new DK(event.getChunk().xPosition, event.getChunk().zPosition));
		
		//Mapping.
		//MappingUtil.ProvinceMap.processChunk(event.getWorld(), chunk.x, chunk.z);
		
		if(chunk != null){
			chunk.save();
			NVR.chunks.remove(new DK(chunk.x, chunk.z));
		}
	}
	
}