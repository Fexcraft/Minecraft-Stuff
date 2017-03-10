package net.fexcraft.mod.fvm.gui;

import java.io.IOException;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketJsonObject;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class VehicleMain extends GuiContainer {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation("fvm:textures/guis/vehicle_main.png");
	private Button[] left = new Button[5];
	private Button[] right = new Button[5];
	private EntityPlayer player;
	
	public VehicleMain(EntityPlayer player){
		super(new MainContainer());
		this.player = player;
		super.xSize = 176;
		super.ySize = 118;
	}
	
	@Override
	public void initGui(){
		super.initGui();
		this.buttonList.clear();
		int j = 0;
		for(int i = 0; i < left.length; i++){
			this.buttonList.add(left[i] = new Button(j++, this.guiLeft + 24, this.guiTop + (6 + (i * 22))));
		}
		for(int i = 0; i < right.length; i++){
			this.buttonList.add(right[i] = new Button(j++, this.guiLeft + 90, this.guiTop + (6 + (i * 22))));
		}
	}
	
	public static class MainContainer extends Container {

		@Override
		public boolean canInteractWith(EntityPlayer playerIn){
			return true;
		}
		
	}
	
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
		this.fontRendererObj.drawString("Inventory", 30, 11, 4210752);
		//
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		int i = this.guiLeft, j = this.guiTop;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch(button.id){
			case 0:
				//player.openGui(FVM.INSTANCE, 3556, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
				JsonObject obj = JsonUtil.getJsonForPacket("fvm_gui");
				obj.addProperty("target", "inventory");
				obj.addProperty("uuid", player.getGameProfile().getId().toString());
				PacketHandler.getInstance().sendToServer(new PacketJsonObject(obj));
				Print.debug("INVENTORY OPEN");
				break;
		}
	}
	
	public static class Button extends GuiButton {
		
		public Button(int id, int x, int y){
			super(id, x, y, 62, 18, "");
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
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 136, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 154, this.width, this.height);
				}
			}
			else{
				this.drawTexturedModalRect(this.xPosition, this.yPosition , 0, 118, this.width, this.height);
			}
			
			
			int j = 14737632;
			if(!this.enabled){
				j = 10526880;
			}
			else if(this.hovered){
				j = 16777120;
			}
			this.drawCenteredString(mc.fontRendererObj, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, j);
		}
	}
	
}