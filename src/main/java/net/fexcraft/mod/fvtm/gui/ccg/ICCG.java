package net.fexcraft.mod.fvtm.gui.ccg;

public interface ICCG {
	
	public String getId();
	
	public void onButtonPress(int button);
	
	public void onInput(String in);
	
	public void updateTileEntity();
	
}