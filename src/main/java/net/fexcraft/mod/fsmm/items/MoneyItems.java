package net.fexcraft.mod.fsmm.items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class MoneyItems {
	
	private static HashMap<Float, IMoneyItem> map = new HashMap<Float, IMoneyItem>();
	
	public static IMoneyItem getItem(float value){
		IMoneyItem item = null;
		for(Entry<Float, IMoneyItem> set : map.entrySet()){
			if(set.getKey().equals(value)){
				item = set.getValue();
				break;
			}
		}
		return item;
	}
	
	public static void addItemToMap(IMoneyItem item){
		map.put(item.getWorth(), item);
	}
	
	public static HashMap<Float, IMoneyItem> getMap(){
		return map;
	}
	
	public static ArrayList<Float> getList(){
		ArrayList<Float> list = new ArrayList<Float>(map.keySet());
		Collections.sort(list);
		return list;
	}
}