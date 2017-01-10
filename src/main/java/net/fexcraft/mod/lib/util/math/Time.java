package net.fexcraft.mod.lib.util.math;

import java.util.Calendar;
import java.util.Date;

public class Time {
	
	public static final Calendar cal = Calendar.getInstance();
	
	public static final Calendar getCalendar(){
		return cal.getInstance();
	}
	
	public static int getMonth(){
		return cal.getInstance().get(0x2);
	}
	
	public static int getDay(){
		return cal.getInstance().get(0x5);
	}
	
	public static int getDay365(){
		return cal.getInstance().get(0x6);
	}
	
	public static int getDay7(){
		return cal.getInstance().get(0x7);
	}
	
	public static int getHour12(){
		return cal.getInstance().get(0xa);
	}
	
	public static int getHour24(){
		return cal.getInstance().get(0xb);
	}
	
	public static int getMinute(){
		return cal.getInstance().get(0xc);
	}
	
	public static int getSecond(){
		return cal.getInstance().get(0xd);
	}
	
	public static int getMilisecond(){
		return cal.getInstance().get(0xe);
	}
	
	public static long getDate(){
		return new Date().getTime();
	}
	
	public static Calendar getGMTCalendar(){
		Calendar cal = Calendar.getInstance();
		cal.getInstance().add(Calendar.MILLISECOND, -cal.getTimeZone().getOffset(cal.getTimeInMillis()));
		return cal;
	}
}