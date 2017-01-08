package net.fexcraft.mod.lib.util.math;

public class Pos{
	
	public float x, y, z;
	
	public Pos(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Pos(float[] pos){
		try{
			x = pos[0];
			y = pos[1];
			z = pos[2];
		}
		catch(Exception e){
			x = y = z = 0;
		}
	}
	
	public Pos copy(){
		return new Pos(x, y, z);
	}
	
	public Pos clone(){
		return copy();
	}
	
	@Override
	public String toString(){
		return "[" + x + "," + y + "," + z + "]";
	}
	
	public float to16FloatX(){
		return 0.0625f * x;
	}
	
	public float to16FloatY(){
		return 0.0625f * y;
	}
	
	public float to16FloatZ(){
		return 0.0625f * z;
	}
	
}