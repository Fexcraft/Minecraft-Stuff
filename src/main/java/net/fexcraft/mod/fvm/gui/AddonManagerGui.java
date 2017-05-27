package net.fexcraft.mod.fvm.gui;

import java.io.File;

import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class AddonManagerGui extends GuiContainer {
	
	private Modes mode;
	//MAIN
	private Button[][] menubuttons;
	//ALL
	
	//ONE
	
	//COMMON
	

	public AddonManagerGui(int mode, int y, int z){
		super(new GenericPlaceholderContainer());
		this.mode = Modes.fromInt(mode);
		switch(this.mode){
			case MAIN:
				this.xSize = 256;
				this.ySize = 123;
				break;
			case VIEW_ALL:
				
				break;
			case VIEW_ONE:
				
				break;
		}
	}
	
	public static enum Modes {
		MAIN(0,     "fvm:textures/guis/addon_manager_main.png"),
		VIEW_ALL(1, "fvm:textures/guis/addon_manager_view_all.png"),
		VIEW_ONE(2, "fvm:textures/guis/addon_manager_view_one.png");
		
		private ResourceLocation texture;
		private int id;
		
		Modes(int id, String rs){
			this.id = id;
			this.texture = new ResourceLocation(rs);
		}

		public static Modes fromInt(int id){
			for(Modes mode : values()){
				if(mode.id == id){
					return mode;
				}
			}
			return null;
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
		this.mc.getTextureManager().bindTexture(mode.texture);
		int i = this.guiLeft, j = this.guiTop;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
		
		this.fontRendererObj.drawString(trs("main_description_0"), i + 7, j + 26, MapColor.GRAY.colorValue);
		this.fontRendererObj.drawString(trs("main_description_1"), i + 7, j + 38, MapColor.GRAY.colorValue);
		this.fontRendererObj.drawString(trs("main_description_2"), i + 7, j + 50, MapColor.GRAY.colorValue);
	}
	
	@Override
	protected void actionPerformed(GuiButton button){
		switch(mode){
			case MAIN:
				if(button.id == 0){
					NBTTagCompound nbt = new NBTTagCompound();
					nbt.setString("target_listener", "fvm");
					nbt.setIntArray("args", new int[]{1,0,0});
					nbt.setString("task", "open_addon_manager");
					PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(nbt));
				}
				else if(button.id == 1){
					OpenGlHelper.openFile(new File(this.mc.getResourcePackRepository().getDirResourcepacks().getParentFile(), "addons/"));
				}
				break;
			case VIEW_ALL:
				break;
			case VIEW_ONE:
				break;
			default:
				break;
		}
	}
	
	public String trs(String string){
		return I18n.format("gui.fvm.addon_manager." + string, new Object[0]);
	}
	
	@Override
	public void initGui(){
		super.initGui();
		this.buttonList.clear();
		switch(mode){
			case MAIN:
				menubuttons = new Button[3][3];
				menubuttons[0][0] = new Button(0,   5 + this.guiLeft, 62 + this.guiTop, trs("main_button_0_0"));
				menubuttons[0][0].enabled = true;
				menubuttons[0][1] = new Button(1,  88 + this.guiLeft, 62 + this.guiTop, trs("main_button_0_1"));
				menubuttons[0][1].enabled = true;
				menubuttons[0][2] = new Button(2, 171 + this.guiLeft, 62 + this.guiTop, trs("main_button_0_2"));
				menubuttons[0][2].enabled = false;
				menubuttons[1][0] = new Button(3,   5 + this.guiLeft, 78 + this.guiTop, trs("main_button_1_0"));
				menubuttons[1][0].enabled = false;
				menubuttons[1][1] = new Button(4,  88 + this.guiLeft, 78 + this.guiTop, trs("main_button_1_1"));
				menubuttons[1][1].enabled = false;
				menubuttons[1][2] = new Button(5, 171 + this.guiLeft, 78 + this.guiTop, trs("main_button_1_2"));
				menubuttons[1][2].enabled = false;
				menubuttons[2][0] = new Button(6,   5 + this.guiLeft, 94 + this.guiTop, trs("main_button_2_0"));
				menubuttons[2][0].enabled = false;
				menubuttons[2][1] = new Button(7,  88 + this.guiLeft, 94 + this.guiTop, trs("main_button_2_1"));
				menubuttons[2][1].enabled = false;
				menubuttons[2][2] = new Button(8, 171 + this.guiLeft, 94 + this.guiTop, trs("main_button_2_2"));
				menubuttons[2][2].enabled = false;
				for(int i = 0; i < 3; i++){
					for(int j = 0; j < 3; j++){
						this.buttonList.add(menubuttons[i][j]);
					}
				}
				break;
			case VIEW_ALL:
				break;
			case VIEW_ONE:
				break;
			default:
				break;
		}
	}
	
	public class Button extends GuiButton {
		
		public Button(int id, int x, int y, String text){
			super(id, x, y, 80, 14, text);
		}
		
		public void drawButton(Minecraft mc, int mouseX, int mouseY){
			super.drawButton(mc, mouseX, mouseY);
			mc.getTextureManager().bindTexture(mode.texture);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			
			int color;
			if(this.enabled){
				color = MapColor.GRAY.colorValue;
				if(this.hovered){
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 176, 228, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 176, 214, this.width, this.height);
				}
				//this.drawCenteredString(mc.fontRendererObj, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, MapColor.GRAY.colorValue);
			}
			else{
				color = MapColor.SNOW.colorValue;
				if(this.hovered){
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 176, 200, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 176, 242, this.width, this.height);
				}
				//this.drawCenteredString(mc.fontRendererObj, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, MapColor.SILVER.colorValue);
			}
			mc.fontRendererObj.drawString(this.displayString, ((this.xPosition + this.width / 2) - mc.fontRendererObj.getStringWidth(this.displayString) / 2), this.yPosition + (this.height - 8) / 2, color);
		}
		
	}
	
}