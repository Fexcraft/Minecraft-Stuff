package net.fexcraft.mod.lib.util.math;

import java.util.Calendar;
import java.util.Date;

public class Time {
	
	public static final Calendar cal = Calendar.getInstance();
	
	public static final Calendar getCalendar(){
		return cal;
	}
	
	public static int getMonth(){
		return cal.get(0x2);
	}
	
	public static int getDay(){
		return cal.get(0x5);
	}
	
	public static int getDay365(){
		return cal.get(0x6);
	}
	
	public static int getDay7(){
		return cal.get(0x7);
	}
	
	public static int getHour12(){
		return cal.get(0xa);
	}
	
	public static int getHour24(){
		return cal.get(0xb);
	}
	
	public static int getMinute(){
		return cal.get(0xc);
	}
	
	public static int getSecond(){
		return cal.get(0xd);
	}
	
	public static int getMilisecond(){
		return cal.get(0xe);
	}
	
	public static long getDate(){
		return new Date().getTime();
	}
}