package net.fexcraft.mod.fvm.util;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class FvmTickHandler {
	
	public static final int getClientTick(){
		return Client.tick;
	}
	
	public static class Client {
		
		private static int tick;
		
		@SubscribeEvent
		public void onTick(TickEvent.ClientTickEvent event){
			if(event.phase == event.phase.START){
				tick++;
				if(tick > 99){
					tick = 0;
				}
			}
		}
		
	}
	
	public static class Server {
		
		@SubscribeEvent
		public void onTick(TickEvent.ServerTickEvent event){
			//
		}
		
	}
	
}