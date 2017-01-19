package net.fexcraft.mod.fwm.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.fexcraft.mod.fwm.data.ChunkQueueElement;
import net.fexcraft.mod.fwm.data.Config;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;

public class Ticker {
	
	private static Ticker instance = new Ticker();
	private static int tick = 0;
	
	private static Set loaded_chunks = new HashSet();
	private static List<ChunkQueueElement> chunk_queue = new ArrayList<ChunkQueueElement>();
	
	@SubscribeEvent
	public void onTick(ServerTickEvent event){
		switch(event.phase){
			case START:
				int tr = -1;
				for(int i = 0; i < chunk_queue.size(); i++){
					if(chunk_queue.get(i).checkTimer(Config.chunk_actualization_interval)){
						chunk_queue.get(i).generateJson();
						chunk_queue.get(i).generateImage();
						chunk_queue.get(i).resetTimer();
						tr = i;
						break;
					}
				}
				if(tr >= 0){
					chunk_queue.remove(tr);
				}
				break;
			case END:
				tick++;
				break;
		}
	}

	public static void saveQueue(){
		//
	}

	public static Ticker getInstance(){
		return instance;
	}
	
}