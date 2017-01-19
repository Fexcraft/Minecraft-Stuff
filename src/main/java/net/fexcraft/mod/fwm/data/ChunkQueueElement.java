package net.fexcraft.mod.fwm.data;

import net.fexcraft.mod.lib.util.math.Time;

public class ChunkQueueElement {
	
	private int x, z;
	private long last_process;
	
	public boolean checkTimer(int i){
		return (Time.getDate() - last_process) >= i;
	}

	public void generateJson(){
		
	}

	public void generateImage(){
		
	}

	public void resetTimer() {
		last_process = Time.getDate();
	}
	
}