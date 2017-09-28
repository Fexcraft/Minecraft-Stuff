package net.fexcraft.mod.nvr.client.gui;

import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.GenericGuiButton;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.fexcraft.mod.nvr.common.PlaceholderGuiContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class ChunkViewGui extends GuiContainer {
	
	private static Mode mode;
	private static boolean asa, asc, rec;
	private static final ResourceLocation texture = new ResourceLocation("nvr:textures/guis/chunk_view.png");
	private static final ArrayList<GenericGuiButton> buttons = new ArrayList<GenericGuiButton>();
	private static String state = "Pending... (waiting for data)";

	public ChunkViewGui(int x, boolean a, boolean b){
		super(new PlaceholderGuiContainer());
		this.mode = Mode.fromInt(x);
		this.asa = a;
		this.asc = b;
		this.xSize = 256;
		this.ySize = 203;
	}
	
	@Override
	public void initGui(){
		super.initGui();
		this.buttonList.clear();
		this.buttons.clear();
		for(int i = 0; i < 11; i++){
			GenericGuiButton button = new GenericGuiButton(i, this.guiLeft + 243, this.guiTop + 11 + (i * 16), 8, 8, "");
			button.setTexture(texture);
			button.setTexturePos(0, 232, 240);
			button.setTexturePos(1, 240, 240);
			button.setTexturePos(2, 248, 248);
			button.setTexturePos(3, 248, 240);
			buttons.add(button);
		}
		buttons.forEach((button) -> this.buttonList.add(button) );
	}
	
	@Override
	public void onGuiClosed(){
        super.onGuiClosed();
        //TODO this.array.clear();
        state = "Pending... (waiting for data)";
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		this.mc.getTextureManager().bindTexture(texture);
		int i = this.guiLeft, j = this.guiTop;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
		//
		for(int l = 0; l < Mode.values().length; l++){
			mc.fontRenderer.drawString(Mode.values()[l].name, i + 186, j + 11 + (l * 16), MapColor.GRAY.colorValue);
		}
		mc.fontRenderer.drawString( "Refresh", i + 186, j + 155, MapColor.GRAY.colorValue);
		mc.fontRenderer.drawString("Zoom Out", i + 186, j + 171, MapColor.GRAY.colorValue);
		mc.fontRenderer.drawString(Formatter.format("&f" + state), i + 7, j + 188, MapColor.GRAY.colorValue);
	}
	
	private static enum Mode {
		
		CLAIM         (0, "Claim"),
		TYPE          (1, "Ck. Type"),
		DISTRICTS     (2, "District"),
		MUNICIPALITIES(3, "Municip."),
		PROVINCES     (4, "Provinces"),
		NATIONS       (5, "Nation"),
		COMPANIES     (7, "Companies"),
		LINKED        (8, "Linked Ck.");
		
		private int id;
		private String name;

		Mode(int id, String string){
			this.id = id;
			this.name = string;
		}

		public static Mode fromString(String mode){
			for(Mode en : values()){
				if(en.name().toLowerCase().equals(mode.toLowerCase())){
					return en;
				}
			}
			return TYPE;
		}

		public static Mode fromInt(int i){
			for(Mode en : values()){
				if(en.id == i){
					return en;
				}
			}
			return TYPE;
		}
		
	}
	
}