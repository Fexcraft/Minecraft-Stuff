package net.fexcraft.mod.lib.crafting.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class CraftingGui extends GuiContainer {
	
    private static final ResourceLocation TEXTURE = new ResourceLocation("fcl:textures/gui/crafting_table.png");

    public CraftingGui(InventoryPlayer playerInv, World worldIn, BlockPos blockPosition){
        super(new WorkbenchContainer(playerInv, worldIn, blockPosition));
        this.xSize = 176;
		this.ySize = 188;
    }
    
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);
        //this.drawTexturedModalRect(((this.width - this.xSize) / 2), ((this.height - this.ySize) / 2), 176, 188, this.xSize, this.ySize);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, this.xSize, this.ySize);
    }
    
}