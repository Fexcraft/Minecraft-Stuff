package net.fexcraft.mod.fvm.gui;

import java.io.IOException;
import com.flansmod.fvm.LandVehicle;

import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
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
	
	public VehicleInventory(EntityPlayer player, com.flansmod.fvm.LandVehicle entity){
		super(new InventoryContainer(player, entity));
		this.player = player;
		this.entity = entity;
		super.xSize = 242;
		super.ySize = 195;
	}
	
	@Override
	public void initGui(){
		super.initGui();
		this.buttonList.clear();
	}
	
	public static class InventoryContainer extends Container {
		
		private LandVehicle lv;

		public InventoryContainer(EntityPlayer player, com.flansmod.fvm.LandVehicle entity){
			lv = entity;
			Print.debug(Static.side().isClient() ? "Client GUI" : "Server GUI");
			
	        for(int i = 0; i < 5; i++){
	        	for(int j = 0; j < 12; j++){
	        		if(j + (i * 12) >= lv.data.getContainer().getSizeInventory()){
	        			break;
	        		}
	        		this.addSlotToContainer(new VehicleInventorySlot(lv.data.itemDiscriminator, lv.data.container, j + (i * 12), 6 + j * 18, 20 + i * 18));
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
				break;
		}
	}
	
}