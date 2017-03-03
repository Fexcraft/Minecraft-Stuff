package net.fexcraft.mod.fvm.gui;

import java.io.IOException;
import org.lwjgl.input.Mouse;

import net.fexcraft.mod.fvm.blocks.VehicleCrafterEntity;
import net.fexcraft.mod.fvm.data.PartType;
import net.fexcraft.mod.fvm.items.PartItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class CreatorGui extends GuiContainer {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation("fvm:textures/guis/blueprint_table.png");
	public static final ResourceLocation ASSETS = new ResourceLocation("fvm:textures/guis/construction_table_assets.png");
	private final InventoryPlayer playerInventory;
	private final VehicleCrafterEntity tile;
	public static int scroll = 0;

	public CreatorGui(TileEntity tileentity, InventoryPlayer inventory){
		super(new CreatorContainer(tileentity, inventory));
		this.playerInventory = inventory;
		this.tile = (VehicleCrafterEntity)tileentity;
		
		super.xSize = 256;
		super.ySize = 207;
		
	}
	
	@Override
	public void initGui(){
		super.initGui();
		this.buttonList.clear();
		//
	}
	
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
		String s = "Blueprint Table";
		/*if(tile.type != null){
			s = tile.type.fullname;
		}*///TODO
		this.fontRendererObj.drawString(s, 7, 7, 4210752);
		this.fontRendererObj.drawString(scroll + "s", 239, 63, 4210752);
		//
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
		/*if(lsu != Time.getSecond()){
			lsu = Time.getSecond();
			this.updateScroll();
		}*///TODO
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		int i = this.guiLeft, j = this.guiTop;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
		//
		
	}
	
	public void handleMouseInput() throws IOException{
		super.handleMouseInput();
		int i = Mouse.getEventDWheel();
		if(i != 0){
			if(i > 0){
				scroll--;
				if(scroll < 0){
					scroll = 0;
				}
			}
			if(i < 0){
				scroll++;
			}
			//TODOupdateScroll();
		}
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		//
	}
	
	private String removeItem(String id) {
		for(int i = 0; i < this.playerInventory.mainInventory.size(); i++){
			ItemStack stack = this.playerInventory.mainInventory.get(i);
			if(stack.getItem() instanceof PartItem){
				PartType type = PartItem.getType(stack);
				if(type.category.contains(id)){
					this.playerInventory.removeStackFromSlot(i);
					return type.registryname;
				}
			}
		}
		return "null";
	}
	
	private boolean canInstall(String id){
		if(id == null || id.equals("null")){
			return false;
		}
		for(ItemStack stack : this.playerInventory.mainInventory){
			if(stack.getItem() instanceof PartItem){
				PartType type = PartItem.getType(stack);
				if(type.category.contains(id)){
					return true;
				}
			}
		}
		return false;
	}

	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		super.drawScreen(mouseX, mouseY, partialTicks);		
		//
	}
	
	public static class Arrow extends GuiButton {
		
		private boolean up;
		
		public Arrow(boolean b, int i, int j){
			super(b ? 0 : 1, i + 238, j + (b ? 20 : 123), 12, 15, "");
			up = b;
		}
		
		public void drawButton(Minecraft mc, int mouseX, int mouseY){
			super.drawButton(mc, mouseX, mouseY);
			mc.getTextureManager().bindTexture(ASSETS);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			
			if(this.hovered){
				this.drawTexturedModalRect(this.xPosition, this.yPosition, 225, up ? 0 : 30, this.width, this.height);
			}
			else{
				this.drawTexturedModalRect(this.xPosition, this.yPosition , 225, up ? 15 : 45, this.width, this.height);
			}
		}
		
	}

}