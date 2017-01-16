package net.fexcraft.mod.fwm.util;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;

public class Ticker {
	
	private static Ticker instance = new Ticker();
	private static int tick = 0;
	
	@SubscribeEvent
	public void onTick(ServerTickEvent event){
		switch(event.phase){
			case START:
				
				
				
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