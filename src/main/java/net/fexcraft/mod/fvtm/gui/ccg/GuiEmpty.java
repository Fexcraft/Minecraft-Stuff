package net.fexcraft.mod.fvtm.gui.ccg;

import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.lib.util.common.Print;

public class GuiEmpty implements ICCG {
	
	private ConstructorControllerEntity tileentity;
	
	public GuiEmpty(ConstructorControllerEntity entity){
		this.tileentity = entity;
	}

	@Override
	public String getId() {
		return "gui:empty";
	}

	@Override
	public void onButtonPress(int button){
		Print.debug("Button " + button + " pressed!");
	}

	@Override
	public void onInput(String in){
		Print.debug("User input: " + in);
	}

	@Override
	public void updateTileEntity(){
		tileentity.text[0] = "> No Vehicle!";
		tileentity.text[1] = "> &oController Disabled.";
		for(int i = 2; i < tileentity.text.length; i++){
			tileentity.text[i] = ">";
		}
	}
	
}