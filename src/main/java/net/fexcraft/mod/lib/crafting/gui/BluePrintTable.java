package net.fexcraft.mod.lib.crafting.gui;

import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.input.Mouse;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.crafting.BluePrintRecipe;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketJsonObject;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BluePrintTable extends GuiContainer {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation("fcl:textures/gui/blueprint_table.png");
	private EntityPlayer player;
	private BlockPos pos;
	private World world;
	private int scroll, catscroll, comscroll, times = 1;
	//
	private HorizontalArrow left, right;
	private VerticalArrow up, down;
	private ComponentsScroll cup, cown, aup, aown;
	private CraftButton button;
	public RecipeItem[] items = new RecipeItem[5];
	//
	private String category = "Blueprint Table";
	private BluePrintRecipe[] selrecipes = new BluePrintRecipe[5];
	private int selectedrec = 0;
	//
	private boolean craftable = false;
	private int cooldown;
	
	public BluePrintTable(EntityPlayer player, World world, BlockPos blockPos){
		super(new BluePrintTableContainer(player));
		this.player = player;
		this.world = world;
		this.pos = blockPos;
		super.xSize = 256;
		super.ySize = 207;
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		int k = this.guiLeft, l = this.guiTop;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		//
		/*for(int j = 0; j < 5; j++){
			for(int i = 0; i < 6; i++){
				int sel = i + ((j + comscroll) * 6);
				if(selectedrec == -1 || selrecipes[selectedrec] == null || sel >= selrecipes[selectedrec].components.length){
					break;
				}
				//
				boolean found = false, full = false;
				for(ItemStack stack : player.inventory.mainInventory){
					if(!stack.isEmpty() && ItemStack.areItemsEqual(stack, selrecipes[selectedrec].components[sel])){
						
					}
				}
				
				if(found){
					if(full){
						
					}
					else{
						
					}
				}
				else{
					
				}
			}
		}*/
	}
	
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
		this.fontRendererObj.drawString("[" + catscroll + "] " + category, 24, 7, 4210752);
		this.fontRendererObj.drawString(scroll + "s", 239, 63, 4210752);
		if(cup.enabled){
			this.fontRendererObj.drawString(comscroll + "s", 118, 86, 4210752);
		}
		this.fontRendererObj.drawString(times + "a", 118, 50, 4210752);
		//
		for(int i = 4; i > -1; i--){
			if(selrecipes[i] != null){
				String s = selrecipes[i].output.getDisplayName();
				if(fontRendererObj.getStringWidth(s) > 70){
					s = fontRendererObj.trimStringToWidth(s, 70);
				}
				this.fontRendererObj.drawString(s, 161, 25 + (i * 20), 4210752);
			}
			else{
				this.fontRendererObj.drawString(" >>> ", 161, 25 + (i * 20), 4210752);
			}
		}
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		super.drawScreen(mouseX, mouseY, partialTicks);
		for(int k = 0; k < 5; k++){
			BluePrintRecipe obj = selrecipes[k];
			if(obj == null){
				break;
			}
			GlStateManager.pushMatrix();
			RenderHelper.enableGUIStandardItemLighting();
			GlStateManager.disableLighting();
			GlStateManager.enableRescaleNormal();
			GlStateManager.enableColorMaterial();
			GlStateManager.enableLighting();
			this.itemRender.zLevel = 100.0F;
			this.itemRender.renderItemAndEffectIntoGUI(obj.output, this.guiLeft + 139, this.guiTop + (20 + (k * 20)));
			this.itemRender.renderItemOverlays(this.fontRendererObj, obj.output, this.guiLeft + 139, this.guiTop + (20 + (k * 20)));
			this.itemRender.zLevel = 0.0F;
			GlStateManager.disableLighting();
			GlStateManager.popMatrix();
			GlStateManager.enableLighting();
			GlStateManager.enableDepth();
			RenderHelper.enableStandardItemLighting();
		}
		for(int j = 0; j < 5; j++){
			for(int i = 0; i < 6; i++){
				int sel = i + ((j + comscroll) * 6);
				if(selectedrec == -1 || selrecipes[selectedrec] == null || sel >= selrecipes[selectedrec].components.length){
					break;
				}
				GlStateManager.pushMatrix();
				RenderHelper.enableGUIStandardItemLighting();
				GlStateManager.disableLighting();
				GlStateManager.enableRescaleNormal();
				GlStateManager.enableColorMaterial();
				GlStateManager.enableLighting();
				this.itemRender.zLevel = 100.0F;
				this.itemRender.renderItemAndEffectIntoGUI(selrecipes[selectedrec].components[sel], this.guiLeft + (6 + (i * 18)), this.guiTop + (28 + (j * 18)));
				this.itemRender.renderItemOverlays(this.fontRendererObj, selrecipes[selectedrec].components[sel], this.guiLeft + (6 + (i * 18)), this.guiTop + (28 + (j * 18)));
				this.itemRender.zLevel = 0.0F;
				GlStateManager.disableLighting();
				GlStateManager.popMatrix();
				GlStateManager.enableLighting();
				GlStateManager.enableDepth();
				RenderHelper.enableStandardItemLighting();
			}
		}
		//
		cooldown--;
		if(cooldown == 0){
			cooldown = 20;//100//50
			craftable = checkIfCraftable();
		}
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch(button.id){
			case 0:
				if(catscroll > 0){
					updateCategoryScroll(true);
				}
				break;
			case 1:
				updateCategoryScroll(false);
				break;
			case 2:
				if(scroll > 0){
					updateScroll(true, false);
				}
				break;
			case 3:
				updateScroll(false, false);
				break;
			case 4:
				if(comscroll > 0){
					comscroll--;
				}
				break;
			case 5:
				comscroll++;
				break;
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				itemClick(button.id);
				break;
			case 11:
				tryCraft();
				break;
			case 12:
				if(times > 1){
					times--;
				}
				break;
			case 13:
				times++;
				break;
		}
	}
	
	private void tryCraft(){
		if(craftable){
			JsonObject obj = JsonUtil.getJsonForPacket("fcl-bpt");
			obj.addProperty("Category", category);
			obj.addProperty("RecipeId", scroll + selectedrec);
			obj.addProperty("BlockPos", pos.toLong());
			obj.addProperty("Times", times);
			PacketHandler.getInstance().sendToServer(new PacketJsonObject(obj));
			Minecraft.getMinecraft().displayGuiScreen((GuiScreen)null);
		}
	}

	private void itemClick(int id){
		for(RecipeItem item : items){
			item.selected = item.id == id;
		}
		selectedrec = id - 6;
		craftable = checkIfCraftable();
	}

	public void handleMouseInput() throws IOException{
		super.handleMouseInput();
		int i = Mouse.getEventDWheel();
		if(i != 0){
			if(i > 0){
				if(scroll > 0){
					updateScroll(true, false);
				}
			}
			if(i < 0){
				updateScroll(false, false);
			}
		}
	}
	
	private void updateCategoryScroll(boolean b){
		catscroll += b ? -1 : 1;
		if(catscroll > 0){
			int i = 0;
			for(String ss : RecipeRegistry.getCategories()){
				i++;
				if(i == catscroll){
					category = ss;
				}
			}
			if(catscroll > i){
				category = "Empty";
			}
		}
		else if(catscroll <= 0){
			category = "Blueprint Table";
		}
		updateScroll(false, true);
	}

	private void updateScroll(boolean b, boolean t){
		if(t){
			scroll = 0;
		}
		else{
			scroll += b ? -1 : 1;
		}
		ArrayList<BluePrintRecipe> list = RecipeRegistry.getRecipes(category);
		if(list != null){
			for(int i = 0; i < 5; i++){
				int j = i + scroll;
				if(j >= list.size()){
					selrecipes[i] = null;
				}
				else{
					selrecipes[i] = list.get(j);
				}
			}
		}
		else{
			selrecipes[0] = null;
			selrecipes[1] = null;
			selrecipes[2] = null;
			selrecipes[3] = null;
			selrecipes[4] = null;
		}
		cup .enabled = selrecipes[selectedrec] == null ? false : selrecipes[selectedrec].components.length > 30;
		cown.enabled = selrecipes[selectedrec] == null ? false : selrecipes[selectedrec].components.length > 30;
		craftable = checkIfCraftable();
	}

	private boolean checkIfCraftable(){
		if(selectedrec == -1 || selrecipes[selectedrec] == null){
			return false;
		}
		ArrayList<Integer> searched = new ArrayList<Integer>();
		for(ItemStack stack : selrecipes[selectedrec].components){
			boolean found = false;
			for(int i = 0; i < player.inventory.mainInventory.size(); i++){
				if(!searched.contains(i)){
					if(areItemStacksEqual(stack, player.inventory.mainInventory.get(i))){
						found = true;
						searched.add(i);
					}
				}
			}
			if(!found){
				return false;
			}
		}
		return true;
	}

	private boolean areItemStacksEqual(ItemStack stack, ItemStack itemStack){
		return stack.getItem() != itemStack.getItem() ? false : stack.getCount() > itemStack.getCount() ? false : stack.getItemDamage() != itemStack.getItemDamage() ? false : true;
	}

	@Override
	public void initGui(){
		super.initGui();
		this.buttonList.clear();
		this.buttonList.add(left  = new HorizontalArrow(true, this.guiLeft, this.guiTop));
		this.buttonList.add(right = new HorizontalArrow(false, this.guiLeft, this.guiTop));
		this.buttonList.add(up    = new VerticalArrow(true, this.guiLeft, this.guiTop));
		this.buttonList.add(down  = new VerticalArrow(false, this.guiLeft, this.guiTop));
		this.buttonList.add(cup   = new ComponentsScroll(4, this.guiLeft + 113, this.guiTop + 99)); cup.enabled = false;
		this.buttonList.add(cown  = new ComponentsScroll(5, this.guiLeft + 113, this.guiTop + 108)); cown.enabled = false;
		this.buttonList.add(items[0] = new RecipeItem(6,  this.guiLeft + 157, this.guiTop + 19)); items[0].selected = true;
		this.buttonList.add(items[1] = new RecipeItem(7,  this.guiLeft + 157, this.guiTop + 39));
		this.buttonList.add(items[2] = new RecipeItem(8,  this.guiLeft + 157, this.guiTop + 59));
		this.buttonList.add(items[3] = new RecipeItem(9,  this.guiLeft + 157, this.guiTop + 79));
		this.buttonList.add(items[4] = new RecipeItem(10, this.guiLeft + 157, this.guiTop + 99));
		this.buttonList.add(button = new CraftButton(this, 11, this.guiLeft + 113, this.guiTop + 27));
		this.buttonList.add(aup   = new ComponentsScroll(12, this.guiLeft + 113, this.guiTop + 63));
		this.buttonList.add(aown  = new ComponentsScroll(13, this.guiLeft + 113, this.guiTop + 72));
	}
	
	public static class HorizontalArrow extends GuiButton {
			
			private boolean left;
			
			public HorizontalArrow(boolean b, int i, int j){
				super(b ? 0 : 1, i + (b ? 5 : 236), j + 5, 15, 12, "");
				left = b;
			}
			
			@Override
			public void func_191745_a(Minecraft mc, int mouseX, int mouseY, float f){
				super.func_191745_a(mc, mouseX, mouseY, f);
				Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
				GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
				this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
				GlStateManager.enableBlend();
				GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
				GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
				
				
				if(this.enabled){
					if(this.hovered){
						this.drawTexturedModalRect(this.xPosition, this.yPosition, 122, left ? 232 : 244, this.width, this.height);
					}
					else{
						this.drawTexturedModalRect(this.xPosition, this.yPosition, 152, left ? 232 : 244, this.width, this.height);
					}
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 137, left ? 232 : 244, this.width, this.height);
				}
			}
			
		}
		
		public static class VerticalArrow extends GuiButton {
			
			private boolean up;
			
			public VerticalArrow(boolean b, int i, int j){
				super(b ? 2 : 3, i + 238, j + (b ? 20 : 101), 12, 15, "");
				up = b;
			}
			
			public void func_191745_a(Minecraft mc, int mouseX, int mouseY, float f){
				super.func_191745_a(mc, mouseX, mouseY, f);
				Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
				GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
				this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
				GlStateManager.enableBlend();
				GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
				GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
				
				
				if(this.enabled){
					if(this.hovered){
						this.drawTexturedModalRect(this.xPosition, this.yPosition, up ? 101 : 89, 211, this.width, this.height);
					}
					else{
						this.drawTexturedModalRect(this.xPosition, this.yPosition, up ? 101 : 89, 226, this.width, this.height);
					}
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, up ? 101 : 89, 241, this.width, this.height);
				}
			}
			
		}
		
		public static class ComponentsScroll extends GuiButton {
			private boolean up;
			public ComponentsScroll(int id, int i, int j){
				super(id, i, j, 18, 9, "");
				up = id % 2 == 0;
			}
			public void func_191745_a(Minecraft mc, int mouseX, int mouseY, float f){
				super.func_191745_a(mc, mouseX, mouseY, f);
				Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
				GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
				this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
				GlStateManager.enableBlend();
				GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
				GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
				if(this.enabled){
					if(this.hovered){
						this.drawTexturedModalRect(this.xPosition, this.yPosition, 113, up ? 207 : 216, this.width, this.height);
					}
					else{
						this.drawTexturedModalRect(this.xPosition, this.yPosition, 149, up ? 207 : 216, this.width, this.height);
					}
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 131, up ? 207 : 216, this.width, this.height);
				}
			}
		}
		
		public static class RecipeItem extends GuiButton {
			
			public boolean selected;
			
			public RecipeItem(int id, int i, int j){
				super(id, i, j, 78, 18, "");
			}
			
			public void func_191745_a(Minecraft mc, int mouseX, int mouseY, float f){
				super.func_191745_a(mc, mouseX, mouseY, f);
				Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
				GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
				this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
				GlStateManager.enableBlend();
				GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
				GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
				
				if(this.enabled){
					if(this.hovered){
						this.drawTexturedModalRect(this.xPosition, this.yPosition, 178, 207, this.width, this.height);
					}
					else if(this.selected){
						this.drawTexturedModalRect(this.xPosition, this.yPosition, 178, 225, this.width, this.height);
					}
					else{
						this.drawTexturedModalRect(this.xPosition, this.yPosition, 157, 19, this.width, this.height);
					}
				}
			}
			
		}
		
		public static class CraftButton extends GuiButton {
			
			private boolean selected;
			private BluePrintTable table;
			
			public CraftButton(BluePrintTable table, int id, int i, int j){
				super(id, i, j, 18, 18, "");
				this.table = table;
			}
			
			public void func_191745_a(Minecraft mc, int mouseX, int mouseY, float f){
				super.func_191745_a(mc, mouseX, mouseY, f);
				Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
				GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
				this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
				GlStateManager.enableBlend();
				GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
				GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
				
				if(this.enabled){
					if(table.craftable){
						if(this.hovered){
							this.drawTexturedModalRect(this.xPosition, this.yPosition, 41, 225, this.width, this.height);
						}
						else{
							this.drawTexturedModalRect(this.xPosition, this.yPosition, 23, 225, this.width, this.height);
						}
					}
					else{
						if(this.hovered){
							this.drawTexturedModalRect(this.xPosition, this.yPosition, 59, 225, this.width, this.height);
						}
						else{
							this.drawTexturedModalRect(this.xPosition, this.yPosition, 5, 225, this.width, this.height);
						}
					}
				}
				/*else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 41, 225, this.width, this.height);
				}*/
			}
			
		}
	
}