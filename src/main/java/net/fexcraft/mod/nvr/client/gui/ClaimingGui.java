package net.fexcraft.mod.nvr.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;

public class ClaimingGui extends GuiContainer {
	
	private static Mode mode;

	public ClaimingGui(String mode){
		super(new PlaceholderGuiContainer());
		this.mode = Mode.fromString(mode);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		//
	}
	
	private static enum Mode {
		CLAIM,
		TYPE,
		DISTRICTS,
		MUNICIPALITIES,
		PROVINCES,
		NATIONS,
		COMPANIES,
		LINKED;

		public static Mode fromString(String mode){
			for(Mode en : values()){
				if(en.name().toLowerCase().equals(mode.toLowerCase())){
					return en;
				}
			}
			return TYPE;
		}
		
	}
	
}