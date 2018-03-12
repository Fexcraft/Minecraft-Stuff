package net.fexcraft.mod.fsu.server.modules.nrr.events;

import net.fexcraft.mod.fsu.server.modules.nrr.NRR;
import net.fexcraft.mod.fsu.server.modules.nrr.data.Chunk;
import net.fexcraft.mod.fsu.server.modules.nrr.util.DoubleKey;
import net.fexcraft.mod.fsu.server.modules.nrr.util.MappingUtil;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChunkEvents {
	
	@SubscribeEvent
	public void onLoad(ChunkEvent.Load event){
		int x = event.getChunk().x;
		int z = event.getChunk().z;
		NRR.chunks.put(new DoubleKey(x, z), new Chunk(x, z, event.getWorld()));
		
		//Mapping.
		MappingUtil.ProvinceMap.processChunk(event.getWorld(), x, z);
	}
	
	@SubscribeEvent
	public void onUnLoad(ChunkEvent.Unload event){
		Chunk chunk = NRR.getChunk(event.getChunk().x, event.getChunk().z);
		
		//Mapping.
		MappingUtil.ProvinceMap.processChunk(event.getWorld(), chunk.x, chunk.z);
		
		if(chunk != null){
			JsonUtil.write(chunk.getFile(), chunk.save(), true);
			NRR.chunks.remove(new DoubleKey(chunk.x, chunk.z));
		}
	}
	
}