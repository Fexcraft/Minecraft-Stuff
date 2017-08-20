package net.fexcraft.mod.nvr.server.data;

import net.fexcraft.mod.lib.util.lang.ArrayList;

public class DoubleKey implements Comparable {
	
	private final int x, z;
	
	public DoubleKey(int i, int j){
		this.x = i; this.z = j;
	}
	
	@Override
	public boolean equals(Object obj){
		return obj instanceof DoubleKey ? (((DoubleKey)obj).x == x && ((DoubleKey)obj).z == z) : false;
	}
	
	@Override
	public int compareTo(Object o){
		if(o instanceof DoubleKey){
			int i = Integer.compare(((DoubleKey)o).x, x);
			return i == 0 ? Integer.compare(((DoubleKey)o).z, z) : i;
		}
		else return -1;
	}
	
	public final int x(){
		return x;
	}
	
	public final int z(){
		return z;
	}
	
	@Override
	public final String toString(){
		return x + " | " + z;
	}

	public static ArrayList<DoubleKey> getFromStringJsonArray(ArrayList<String> array){
		ArrayList<DoubleKey> list = new ArrayList<DoubleKey>();
		array.forEach((string) -> {
			try{
				String[] str = string.split(" | ");
				list.add(new DoubleKey(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
			}
			catch(Exception e){
				e.printStackTrace();
			}
		});
		return list;
	}
	
}