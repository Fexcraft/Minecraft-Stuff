package net.fexcraft.mod.extensions.ie.gui.client;

import net.fexcraft.mod.extensions.ie.gui.server.ContainerEF;
import net.fexcraft.mod.extensions.ie.tileentities.ElectricalFurnaceEntity;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiEF extends GuiContainer {
    private static final ResourceLocation FURNACE_GUI_TEXTURES = new ResourceLocation("frsm_ie:textures/gui/electrical_furnace.png");
    private final InventoryPlayer playerInventory;
    private final IInventory tileFurnace;

    public GuiEF(InventoryPlayer playerInv, IInventory furnaceInv){
        super(new ContainerEF(playerInv, furnaceInv));
        this.playerInventory = playerInv;
        this.tileFurnace = furnaceInv;
    }
    
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
    	ElectricalFurnaceEntity tile = ((ElectricalFurnaceEntity) tileFurnace);
    	String name = tile.getContainerName();
    	String fpus = tile.fpu_get(null) + "/" + tile.fpu_max(null) + "F^";
        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        this.fontRendererObj.drawString(fpus, this.xSize / 2 - this.fontRendererObj.getStringWidth(fpus) / 2, 14, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draws the background layer of this container (behind the items).
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(FURNACE_GUI_TEXTURES);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
        /*if(ElectricalFurnaceEntity.isBurning(this.tileFurnace)){
            int k = this.getBurnLeftScaled(13);
            this.drawTexturedModalRect(i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }*/

        int l = this.getCookProgressScaled(24);
        this.drawTexturedModalRect(i + 79, j + 34, 176, 0, l + 1, 16);
    }

    private int getCookProgressScaled(int pixels){
        int i = this.tileFurnace.getField(2);
        int j = this.tileFurnace.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }

    /*private int getBurnLeftScaled(int pixels){
        int i = this.tileFurnace.getField(1);

        if(i == 0){
            i = ((ElectricalFurnaceEntity)this.tileFurnace).getSmeltTime();
        }

        return this.tileFurnace.getField(0) * pixels / i;
    }*/
}