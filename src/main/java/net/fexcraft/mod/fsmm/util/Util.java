package net.fexcraft.mod.fsmm.util;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Util {

	public static float round(float d){
		DecimalFormat form = new DecimalFormat("#.###");
		String string = form.format(d);
		string = string.replace(",", ".");
		return Float.parseFloat(string);
	}
	
	public static ArrayList<Float> reverse(ArrayList<Float> list){
		ArrayList<Float> ls = new ArrayList<Float>();
		for(int i = (list.size() - 1); i >= 0; i--){
			ls.add(list.get(i));
		}
		return ls;
	}
	
}