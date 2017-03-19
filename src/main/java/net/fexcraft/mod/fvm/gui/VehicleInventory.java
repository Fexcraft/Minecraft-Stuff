package net.fexcraft.mod.fvm.gui;

import java.io.IOException;
import com.flansmod.fvm.LandVehicle;

import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;

public class VehicleInventory extends GuiContainer {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation("fvm:textures/guis/vehicle_inventory.png");
	private EntityPlayer player;
	private com.flansmod.fvm.LandVehicle entity;
	private short scroll = 0;
	private Arrow up, down;
	
	public VehicleInventory(EntityPlayer player, com.flansmod.fvm.LandVehicle entity){
		super(new InventoryContainer(player, entity));
		this.player = player;
		this.entity = entity;
		super.xSize = 242;
		super.ySize = 195;
		//
	}
	
	@Override
	public void initGui(){
		super.initGui();
		this.buttonList.clear();
		this.buttonList.add(up   = new Arrow(true, this.guiLeft, this.guiTop));
		this.buttonList.add(down = new Arrow(false, this.guiLeft, this.guiTop));
	}
	
	public static class InventoryContainer extends Container {
		
		private LandVehicle lv;

		public InventoryContainer(EntityPlayer player, com.flansmod.fvm.LandVehicle entity){
			lv = entity;
			Print.debug(Static.sideString() + " GUI");
			
	        for(int i = 0; i < 5; i++){
	        	for(int j = 0; j < 12; j++){
	        		if(j + (i * 12) >= lv.data.getContainer().getSizeInventory()){
	        			break;
	        		}
	        		this.addSlotToContainer(new VehicleInventorySlot(lv.data.itemDiscriminator, lv.data.container, j + (i * 12), 6 + j * 18, 20 + i * 18));
	        	}
	        }
	        if(lv.data.getContainer().getSizeInventory() < 60){
	        	int k = 60 - lv.data.container.getSizeInventory();
	        	NullContainer nell = new NullContainer(k);
	        	int l = 0;
	        	for(int i = 0; i < 5; i++){
		        	for(int j = 0; j < 12; j++){
		        		if(j + (i * 12) < lv.data.container.getSizeInventory()){
		        			continue;
		        		}
		        		else{
			        		this.addSlotToContainer(new VehicleInventorySlot(nell.LIST, nell, l, 6 + j * 18, 20 + i * 18));
			        		l++;
		        		}
		        	}
	        	}
	        }
			
	        for(int i = 0; i < 3; ++i){
	            for(int j = 0; j < 9; ++j){
	                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 6 + j * 18, 117 + i * 18));
	            }
	        }

	        for(int k = 0; k < 9; ++k){
	            this.addSlotToContainer(new Slot(player.inventory, k, 6 + k * 18, 173));
	        }
	        Print.debug(this.inventorySlots.size() + " GUI");
		}

		@Override
		public boolean canInteractWith(EntityPlayer playerIn){
			return playerIn != null;
		}
		
	}
	
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
		this.fontRendererObj.drawString("Inventory", 7, 7, 4210752);
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
				if(scroll > 0){
					scroll--;
				}
				else{
					scroll = 0;
				}
				break;
			case 1:
				scroll++;
				break;
		}
	}
	
	public static class Arrow extends GuiButton {
		
		private boolean up;
		
		public Arrow(boolean b, int i, int j){
			super(b ? 0 : 1, i + 224, j + (b ? 20 : 93), 12, 15, "");
			up = b;
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
					this.drawTexturedModalRect(this.xPosition, this.yPosition, up ? 12 : 0, 211, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition , up ? 12 : 0, 226, this.width, this.height);
				}
			}
			else{
				this.drawTexturedModalRect(this.xPosition, this.yPosition , up ? 12 : 0, 241, this.width, this.height);
			}
		}
		
	}
	
}