package net.fexcraft.mod.extensions.ie.util;

import java.util.Calendar;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Ticker {
	
	public static int sec;
	public static int tick;
	public static int tick360;
	private static Calendar cal;
	
	@SubscribeEvent
	public void onUpdate(TickEvent.WorldTickEvent event){
		switch(event.phase){
			case START:
				tick++;
				if(tick > 20){
					tick = 0;
				}
				tick360++;
				if(tick360 > 360){
					tick360 = 0;
				}
				break;
			case END:
				sec = cal.getInstance().get(Calendar.SECOND);
				break;
			default:
				
				break;
		}
	}
	
}