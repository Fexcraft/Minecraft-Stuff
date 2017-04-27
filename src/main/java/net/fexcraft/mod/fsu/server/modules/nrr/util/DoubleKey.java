package net.fexcraft.mod.fsu.server.modules.nrr.util;

public class DoubleKey implements Comparable<DoubleKey>{
	
	public int x, z;
	
	public DoubleKey(int t, int e){
		x = t;
		z = e;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof DoubleKey){
			DoubleKey d = (DoubleKey)o;
			return x == d.x && z == d.z;
		}
		else return this.toString().equals(o.toString());
	}
	
	@Override
	public String toString(){
		return "[" + x + "]|[" + z + "]";
	}

	@Override
	public int compareTo(DoubleKey o){
		int y = Integer.compare(x, o.x);
		return y == 0 ? Integer.compare(z,  o.z) : y;
	}
	
}