package net.fexcraft.mod.fvm.gui;

import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.input.Mouse;

import net.fexcraft.mod.fvm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvm.data.PartType;
import net.fexcraft.mod.fvm.items.PartItem;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.util.lang.LimitedList;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class ConstructorGui extends GuiContainer {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation("fvm:textures/guis/construction_table.png");
	public static final ResourceLocation ASSETS = new ResourceLocation("fvm:textures/guis/construction_table_assets.png");
	private final InventoryPlayer playerInventory;
	private final ConstructorControllerEntity tile;
	public static int scroll = 0;
	public LimitedList<Object> list = new LimitedList<Object>(6);
	//Buttons
	public Install installnew;
	public Generic statenew;
	public Generic[] parts = new Generic[6];
	public Hybrid[] names = new Hybrid[6];
	public Remove[] remove = new Remove[6];
	public Mini finish;

	public ConstructorGui(TileEntity tileentity, InventoryPlayer inventory){
		super(new ConstructorContainer(tileentity, inventory));
		this.playerInventory = inventory;
		this.tile = (ConstructorControllerEntity)tileentity;
		
		super.xSize = 256;
		super.ySize = 256;
		
	}
	
	@Override
	public void initGui(){
		super.initGui();
		this.buttonList.clear();
		this.buttonList.add(new Arrow(true, this.guiLeft, this.guiTop));
		this.buttonList.add(new Arrow(false, this.guiLeft, this.guiTop));
		this.buttonList.add(installnew = new Install(3, this.guiLeft + 174, this.guiTop + 146));
		this.buttonList.add(statenew = new Generic(4, this.guiLeft + 30, this.guiTop + 146));
		this.buttonList.add(parts[0] = new Generic(5, this.guiLeft + 30, this.guiTop + 20));
		this.buttonList.add(parts[1] = new Generic(6, this.guiLeft + 30, this.guiTop + 40));
		this.buttonList.add(parts[2] = new Generic(7, this.guiLeft + 30, this.guiTop + 60));
		this.buttonList.add(parts[3] = new Generic(8, this.guiLeft + 30, this.guiTop + 80));
		this.buttonList.add(parts[4] = new Generic(9, this.guiLeft + 30, this.guiTop + 100));
		this.buttonList.add(parts[5] = new Generic(10, this.guiLeft + 30, this.guiTop + 120));
		this.buttonList.add(names[0] = new Hybrid(11, this.guiLeft + 102, this.guiTop + 20));
		this.buttonList.add(names[1] = new Hybrid(12, this.guiLeft + 102, this.guiTop + 40));
		this.buttonList.add(names[2] = new Hybrid(13, this.guiLeft + 102, this.guiTop + 60));
		this.buttonList.add(names[3] = new Hybrid(14, this.guiLeft + 102, this.guiTop + 80));
		this.buttonList.add(names[4] = new Hybrid(15, this.guiLeft + 102, this.guiTop + 100));
		this.buttonList.add(names[5] = new Hybrid(16, this.guiLeft + 102, this.guiTop + 120));
		this.buttonList.add(remove[0] = new Remove(17, this.guiLeft + 216, this.guiTop + 20));
		this.buttonList.add(remove[1] = new Remove(18, this.guiLeft + 216, this.guiTop + 40));
		this.buttonList.add(remove[2] = new Remove(19, this.guiLeft + 216, this.guiTop + 60));
		this.buttonList.add(remove[3] = new Remove(20, this.guiLeft + 216, this.guiTop + 80));
		this.buttonList.add(remove[4] = new Remove(21, this.guiLeft + 216, this.guiTop + 100));
		this.buttonList.add(remove[5] = new Remove(22, this.guiLeft + 216, this.guiTop + 120));
		this.buttonList.add(finish = new Mini(23, this.guiLeft + 242, this.guiTop + 243));
	}
	
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
		String s = "Vehicle Constructor";
		if(tile.type != null){
			s = tile.type.fullname;
		}
		this.fontRendererObj.drawString(s, this.guiLeft + (this.fontRendererObj.getStringWidth(s) / 2), 7, 4210752);
		this.fontRendererObj.drawString(scroll + "s", 239, 75, 4210752);
		//
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
		if(lsu != Time.getSecond()){
			lsu = Time.getSecond();
			this.updateScroll();
		}
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		int i = this.guiLeft, j = this.guiTop;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
		//
		this.mc.getTextureManager().bindTexture(ASSETS);
		if(tile == null){
			return;
		}
		if(!tile.getStackInSlot(0).isEmpty()){
			ItemStack stack = tile.getStackInSlot(0);
			if(tile.type.canInstall(stack)){
				this.drawTexturedModalRect(i + 30, j + 146, 144, 0, 72, 18);
				installnew.enabled = true;
				installnew.displayString = "Install";
				statenew.enabled = true;
				statenew.compatible = true;
				statenew.displayString = "Compatible";
				
			}
			else{
				
				this.drawTexturedModalRect(i + 30, j + 146,  72, 0, 72, 18);
				installnew.enabled = false;
				installnew.displayString = "- - - - -";
				statenew.enabled = true;
				statenew.compatible = false;
				if(!FvmResources.getPart(stack).availableInConstructor){
					statenew.displayString = "Unavailable";
				}
				else{
					statenew.displayString = "Incompatible";
				}
			}
		}
		else{
			installnew.enabled = false;
			installnew.displayString = "- - - - -";
			statenew.enabled = false;
			statenew.displayString = "- - - - -";
		}
		
		
		//
		for(int k = 0; k < 6; k++){
			Object obj = list.get(k);
			if(obj == null){
				parts[k].enabled = false;
				parts[k].displayString = "< -- >";
				names[k].enabled = false;
				names[k].displayString = "< -- >";
				remove[k].enabled = false;
				remove[k].add = false;
				break;
			}
			parts[k].enabled = true;
			if(!obj.installed){
				this.mc.getTextureManager().bindTexture(ASSETS);
				this.drawTexturedModalRect(i + 8, j + (20 + (k * 20)), 238, 72, 18, 18);
				//
				parts[k].compatible = false;
				parts[k].displayString = "Missing";
				names[k].enabled = false;
				names[k].displayString = obj.id;
				if(obj.installable){
					remove[k].enabled = true;
					remove[k].add = true;
				}
				else{
					remove[k].enabled = false;
					remove[k].add = false;
				}
			}
			else{
				parts[k].compatible = true;
				parts[k].displayString = "Installed";
				names[k].enabled = true;
				names[k].displayString = obj.type.category.get(0);
				remove[k].enabled = obj.type.removable;
				remove[k].add = false;
			}
		}
		
		finish.enabled = tile.type.isReadyToUse();
		
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
			updateScroll();
		}
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch(button.id){
			case 0:
				scroll--;
				if(scroll < 0){
					scroll = 0;
				}
				updateScroll();
				break;
			case 1:
				scroll++;
				updateScroll();
				break;
			case 3:
				if(installnew.enabled && tile.type.canInstall(tile.getStackInSlot(0))){
					tile.notifyServer("install");
				}
				break;
			case 17:
			case 18:
			case 19:
			case 20:
			case 21:
			case 22:
				int i = button.id - 17;
				Object obj = list.get(i);
				if(!obj.installed && obj.installable){
					tile.notifyServer("add:" + obj.id + "//" + removeItem(obj.id) + "//" + mc.player.getGameProfile().getId());
				}
				else if(obj.installed && obj.type.removable){
					String s = tile.type.usedAs(obj.type);
					tile.notifyServer("remove:" + (s == null ? obj.type.category : s));
				}
				break;
			case 23:
				tile.notifyServer("create_vehicle");
				mc.displayGuiScreen((GuiScreen)null);
				break;
		}
	}
	
	private String removeItem(String id) {
		for(int i = 0; i < this.playerInventory.mainInventory.size(); i++){
			ItemStack stack = this.playerInventory.mainInventory.get(i);
			if(stack.getItem() instanceof PartItem){
				PartType type = PartItem.getType(stack);
				if(type.category.contains(id)){
					//this.playerInventory.removeStackFromSlot(i);
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
		for(int k = 0; k < 6; k++){
			Object obj = list.get(k);
			if(obj == null){
				return;
			}
			if(obj.installed){
				ItemStack stack = obj.type.newStack();
				GlStateManager.pushMatrix();
				RenderHelper.enableGUIStandardItemLighting();
				GlStateManager.disableLighting();
				GlStateManager.enableRescaleNormal();
				GlStateManager.enableColorMaterial();
				GlStateManager.enableLighting();
				this.itemRender.zLevel = 100.0F;
				this.itemRender.renderItemAndEffectIntoGUI(stack, this.guiLeft + 9, this.guiTop + (21 + (k * 20)));
				this.itemRender.renderItemOverlays(this.fontRendererObj, stack, this.guiLeft + 9, this.guiTop + (21 + (k * 20)));
				this.itemRender.zLevel = 0.0F;
				GlStateManager.disableLighting();
				GlStateManager.popMatrix();
				GlStateManager.enableLighting();
				GlStateManager.enableDepth();
				RenderHelper.enableStandardItemLighting();
			}
		}
	}
	
	public static class Object {
		PartType type;
		boolean installed, installable;
		String id;
		
		public Object(PartType tp, boolean b, String i){
			type = tp;
			installed = b;
			id = i;
			installable = false;
		}
	}
	
	private static final ArrayList<Object> objs = new ArrayList<Object>();
	private static int lsu = -1;
	
	public void updateScroll(){
		if(tile.type == null){
			return;
		}
		objs.clear();
		list.clear();
		for(String s : tile.type.requires){
			objs.add(new Object(null, false, s));
		}
		for(PartType part : tile.type.parts.values()){
			objs.add(new Object(part, true, null));
		}
		
		for(int i = 0; i < list.maxSize(); i++){
			if(i + scroll >= objs.size()){
				break;
			}
			list.add(objs.get(i + scroll));
		}
		
		for(Object obj : list){
			if(!obj.installed){
				obj.installable = canInstall(obj.id);
			}
		}
		
	}
	
	public static class Arrow extends GuiButton {
		
		private boolean up;
		
		public Arrow(boolean b, int i, int j){
			super(b ? 0 : 1, i + 238, j + (b ? 20 : 123), 12, 15, "");
			up = b;
		}
		
		public void drawButton(Minecraft mc, int mouseX, int mouseY){
			super.drawButton(mc, mouseX, mouseY);
			//FontRenderer fontrenderer = mc.fontRendererObj;
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
	
	public static class Install extends GuiButton {
		
		public Install(int id, int x, int y){
			super(id, x, y, 72, 18, "");
		}
		
		public void drawButton(Minecraft mc, int mouseX, int mouseY){
			super.drawButton(mc, mouseX, mouseY);
			mc.getTextureManager().bindTexture(ASSETS);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			
			if(this.enabled){
				if(this.hovered){
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 144, 0, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 144, 18, this.width, this.height);
				}
			}
			else{
				this.drawTexturedModalRect(this.xPosition, this.yPosition , 0, 0, this.width, this.height);
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
	
	public static class Generic extends GuiButton {
		
		private boolean compatible;
		
		public Generic(int id, int x, int y){
			super(id, x, y, 72, 18, "");
		}
		
		public void drawButton(Minecraft mc, int mouseX, int mouseY){
			super.drawButton(mc, mouseX, mouseY);
			mc.getTextureManager().bindTexture(ASSETS);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			
			if(this.enabled){
				if(this.compatible){
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 144, 0, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 72, 0, this.width, this.height);
				}
			}
			else{
				this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 0, this.width, this.height);
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
	
	public static class Hybrid extends GuiButton {
		
		public Hybrid(int id, int x, int y){
			super(id, x, y, 108, 18, "");
		}
		
		public void drawButton(Minecraft mc, int mouseX, int mouseY){
			super.drawButton(mc, mouseX, mouseY);
			mc.getTextureManager().bindTexture(ASSETS);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			
			if(this.enabled){
				if(this.hovered){
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 90, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 108, 90, this.width, this.height);
				}
			}
			else{
				this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 72, this.width, this.height);
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
	
	public static class Remove extends GuiButton {
		
		boolean add;
		
		public Remove(int id, int x, int y){
			super(id, x, y, 18, 18, "");
		}
		
		public void drawButton(Minecraft mc, int mouseX, int mouseY){
			super.drawButton(mc, mouseX, mouseY);
			mc.getTextureManager().bindTexture(ASSETS);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			
			if(this.enabled){
				if(this.add){
					if(this.hovered){
						this.drawTexturedModalRect(this.xPosition, this.yPosition, 220, 108, this.width, this.height);
					}
					else{
						this.drawTexturedModalRect(this.xPosition, this.yPosition, 238, 108, this.width, this.height);
					}
				}
				else{
					if(this.hovered){
						this.drawTexturedModalRect(this.xPosition, this.yPosition, 220, 90, this.width, this.height);
					}
					else{
						this.drawTexturedModalRect(this.xPosition, this.yPosition, 238, 90, this.width, this.height);
					}
				}
			}
			else{
				this.drawTexturedModalRect(this.xPosition, this.yPosition, 220, 72, this.width, this.height);
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
	
	public static class Mini extends GuiButton {
		
		public Mini(int id, int x, int y){
			super(id, x, y, 8, 8, "");
		}
		
		public void drawButton(Minecraft mc, int mouseX, int mouseY){
			super.drawButton(mc, mouseX, mouseY);
			mc.getTextureManager().bindTexture(ASSETS);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			
			if(this.enabled){
				if(this.hovered){
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 216, 40, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 216, 16, this.width, this.height);
				}
			}
			else{
				if(this.hovered){
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 216, 64, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 216, 8, this.width, this.height);
				}
			}
		}
		
	}

}