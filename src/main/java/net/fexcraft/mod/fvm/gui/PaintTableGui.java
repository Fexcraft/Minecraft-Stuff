package net.fexcraft.mod.fvm.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import net.fexcraft.mod.fvm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvm.blocks.PaintTableEntity;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class PaintTableGui extends GuiContainer{
	
	public static final ResourceLocation TEXTURE = new ResourceLocation("fvm:textures/guis/paint_table.png");
	//
	private PaintTableEntity tile;
	private ConstructorControllerEntity con;
	//
	public Reset[] reset = new Reset[5];
	public Done done;
	//
	private GuiTextField[][] rgb = new GuiTextField[2][3];
	private GuiTextField url;

	public PaintTableGui(TileEntity tileentity){
		super(new PaintTableContainer(tileentity));
		this.tile = (PaintTableEntity)tileentity;
		switch(tile.getFacing()){
			case NORTH:
				con = (ConstructorControllerEntity)tile.getWorld().getTileEntity(tile.getPos().north());
				break;
			case SOUTH:
				con = (ConstructorControllerEntity)tile.getWorld().getTileEntity(tile.getPos().south());
				break;
			case WEST:
				con = (ConstructorControllerEntity)tile.getWorld().getTileEntity(tile.getPos().west());
				break;
			case EAST:
				con = (ConstructorControllerEntity)tile.getWorld().getTileEntity(tile.getPos().east());
				break;
			default:
				break;
		}
		if(con == null){
			mc.displayGuiScreen((GuiScreen)null);
			tile.setFacing(EnumFacing.UP);
		}
		
		
		super.xSize = 256;
		super.ySize = 176;
		
	}
	
	@Override
	public void initGui(){
		super.initGui();
        Keyboard.enableRepeatEvents(true);
        //
        int id = -1;
        //
		this.buttonList.clear();
		this.buttonList.add(reset[0] = new Reset(id++, this.guiLeft + 112, this.guiTop + 24));//0
		this.buttonList.add(reset[1] = new Reset(id++, this.guiLeft + 112, this.guiTop + 38));//1
		this.buttonList.add(reset[2] = new Reset(id++, this.guiLeft + 112, this.guiTop + 52));//2
		this.buttonList.add(reset[3] = new Reset(id++, this.guiLeft + 112, this.guiTop + 66));//3
		this.buttonList.add(reset[4] = new Reset(id++, this.guiLeft + 112, this.guiTop + 80));//4
		reset[2].enabled = false;
		reset[3].enabled = false;
		reset[4].enabled = false;
		this.buttonList.add(done = new Done(id++, this.guiLeft + 5, this.guiTop + 164));//5
		//
		for(int i = 0; i < rgb.length; i++){
			for(int j = 0; j < rgb[i].length; j++){
				this.rgb[i][j] = new GuiTextField(id++, this.fontRendererObj, guiLeft + (133 + (j * 40)), guiTop + (26 + (i * 14)), 35, 8);
		        this.rgb[i][j].setTextColor(-1);
		        this.rgb[i][j].setDisabledTextColour(-1);
		        this.rgb[i][j].setEnableBackgroundDrawing(false);
		        this.rgb[i][j].setMaxStringLength(8);
		        
			}
			//6,7,8,9,10,11,12,13,14
			switch(i){
	        	case 0:
	        		rgb[i][0].setText(con.type.primaryColor.red + "");
	        		rgb[i][1].setText(con.type.primaryColor.green + "");
	        		rgb[i][2].setText(con.type.primaryColor.blue + "");
	        		break;
	        	case 1:
	        		rgb[i][0].setText(con.type.secondaryColor.red + "");
	        		rgb[i][1].setText(con.type.secondaryColor.green + "");
	        		rgb[i][2].setText(con.type.secondaryColor.blue + "");
	        		break;
	        	default:
	        		break;
			}
		}
        //
		this.url = new GuiTextField(id++, this.fontRendererObj, guiLeft + 7, guiTop + 152, 203, 8);//15
		this.url.setText("  < feature not available yet >  ");
		this.url.setTextColor(-1);
        this.url.setDisabledTextColour(-1);
        this.url.setEnableBackgroundDrawing(false);
        this.url.setMaxStringLength(256);
        //
	}
	
	@Override
	public void onGuiClosed(){
        super.onGuiClosed();
        Keyboard.enableRepeatEvents(false);
    }
	
	@Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        boolean yes = true;
        for(int i = 0; i < rgb.length; i++){
			for(int j = 0; j < rgb[i].length; j++){
				if(rgb[i][j].textboxKeyTyped(typedChar, keyCode)){
					yes = false;
				}
			}
		}
        if(yes){
        	super.keyTyped(typedChar, keyCode);
        }
    }
	
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException{
        super.mouseClicked(mouseX, mouseY, mouseButton);
        for(int i = 0; i < rgb.length; i++){
			for(int j = 0; j < rgb[i].length; j++){
				rgb[i][j].mouseClicked(mouseX, mouseY, mouseButton);
			}
		}
    }
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
        super.drawScreen(mouseX, mouseY, partialTicks);
        GlStateManager.disableLighting();
        GlStateManager.disableBlend();
        for(int i = 0; i < rgb.length; i++){
			for(int j = 0; j < rgb[i].length; j++){
				rgb[i][j].drawTextBox();
			}
		}
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		int i = this.guiLeft, j = this.guiTop;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
		if(con.type == null){
			mc.displayGuiScreen((GuiScreen)null);
		}
		//
		String s = "FVM Paint Table";
		if(con.type != null){
			s = s + " - " + con.type.fullname;
		}
		this.fontRendererObj.drawString(s, i + 7, j + 7, 4210752);
		this.fontRendererObj.drawString("Primary Color", i + 7, j + 26, MapColor.GRAY.colorValue);
		this.fontRendererObj.drawString("Secondary Color", i + 7, j + 40, MapColor.GRAY.colorValue);
		this.fontRendererObj.drawString("Texture URL", i + 7, j + 138, MapColor.GRAY.colorValue);
		
		String texture = "null/error";
		try{
			texture = fontRendererObj.trimStringToWidth(con.type.getTexture().toString(), 203);
		}
		catch(Exception e){
			texture = "null/error <0>";
		}
		this.fontRendererObj.drawString(texture, i + 7, j + 110, MapColor.CYAN.colorValue);
		
	}
	
	public void handleMouseInput() throws IOException{
		super.handleMouseInput();
		//
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button instanceof Done){
			String s = rgb[0][0].getText() + "//" + rgb[0][1].getText() + "//" + rgb[0][2].getText();
			s += "//" + rgb[1][0].getText() + "//" + rgb[1][1].getText() + "//" + rgb[1][2].getText();
			con.notifyServer("painttable:" + s);
			mc.displayGuiScreen((GuiScreen)null);
			Print.chat(mc.player, "Applying color...");
		}
		switch(button.id){
			case 0:
				rgb[0][0].setText(con.type.primaryColor.red + "");
				rgb[0][1].setText(con.type.primaryColor.green + "");
				rgb[0][2].setText(con.type.primaryColor.blue + "");
				break;
			case 1:
				rgb[0][0].setText(con.type.secondaryColor.red + "");
				rgb[0][1].setText(con.type.secondaryColor.green + "");
				rgb[0][2].setText(con.type.secondaryColor.blue + "");
				break;
			default:
				break;
		}
	}
	
	public static class Reset extends GuiButton {
		
		public Reset(int id, int x, int y){
			super(id, x, y, 11, 12, "");
		}
		
		public void drawButton(Minecraft mc, int mouseX, int mouseY){
			super.drawButton(mc, mouseX, mouseY);
			mc.getTextureManager().bindTexture(TEXTURE);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			
			if(this.enabled){
				if(this.hovered){
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 22, 241, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 22, 229, this.width, this.height);
				}
			}
			else{
				this.drawTexturedModalRect(this.xPosition, this.yPosition, 22, 217, this.width, this.height);
			}
		}
		
	}
	
	public static class Done extends GuiButton {
		
		public Done(int id, int x, int y){
			super(id, x, y, 8, 8, "");
		}
		
		public void drawButton(Minecraft mc, int mouseX, int mouseY){
			super.drawButton(mc, mouseX, mouseY);
			mc.getTextureManager().bindTexture(TEXTURE);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			
			if(this.enabled){
				if(this.hovered){
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 8, 177, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 193, this.width, this.height);
				}
			}
			else{
				if(this.hovered){
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 201, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 185, this.width, this.height);
				}
			}
		}
		
	}

}