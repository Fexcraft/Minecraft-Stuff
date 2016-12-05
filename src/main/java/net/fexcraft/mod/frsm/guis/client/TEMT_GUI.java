package net.fexcraft.mod.frsm.guis.client;

import java.io.IOException;

import net.fexcraft.mod.frsm.items.tools.TEMT;
import net.fexcraft.mod.frsm.util.PrintChat;
import net.fexcraft.mod.frsm.util.block.TemtUtil;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TEMT_GUI extends GuiScreen{
    
    private BlockPos pos;
    private EntityPlayer player;
    private World world;
    private int x, y;
    private NBTTagCompound nbt;
    
    private GuiButton mode, type, amount;
    
    public TEMT_GUI(EntityPlayer player, World world, BlockPos pos) {
        this.pos = pos;
        this.player = player;
        this.world = world;
        this.x = 120;
        this.y = 100;
        ((TEMT)player.getHeldItemMainhand().getItem()).requestNBT(player);
    }
    private ResourceLocation bg = new ResourceLocation("frsm:textures/gui/GuiTEMT.png");
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float renderPartialTicks){
    	this.drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(bg);
        int x = (this.width - this.x) / 2;
        int y = (this.height - this.y) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.x,  this.y);
        
        for (int i = 0; i < this.buttonList.size(); ++i){
            ((GuiButton)this.buttonList.get(i)).drawButton(this.mc, mouseX, mouseY);
        }
    }
    
    @Override
    public void initGui(){
    	super.initGui();
        this.nbt = ((TEMT)player.getHeldItemMainhand().getItem()).getRequest();
        this.buttonList.add(this.mode   = new GuiButton(0,
        		((this.width - this.x) / 2) + 5, ((this.height - this.y) / 2) + 16, 110, 25,
        		"Mode: " + nbt.getString("frsm_mode")));
        this.buttonList.add(this.type   = new GuiButton(1,
        		((this.width - this.x) / 2) + 5, ((this.height - this.y) / 2) + 43, 110, 25,
        		"Type: " + nbt.getString("frsm_type")));
        this.buttonList.add(this.amount = new GuiButton(2,
        		((this.width - this.x) / 2) + 5, ((this.height - this.y) / 2) + 70, 110, 25,
        		"Amount: " + nbt.getInteger("frsm_amount")));
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    	switch(button.id){
    		case 0:
    			switchMode();
    			break;
    		case 1:
    			switchType();
    			break;
    		case 2:
    			changeAmount();
    			break;		
    	}
    	if(player.getHeldItemMainhand().getItem() instanceof TEMT == false){
    		this.mc.displayGuiScreen(null);
            if (this.mc.currentScreen == null){
            	this.mc.setIngameFocus();
            }
    	}
    }

	private void switchMode() {
		String mode = nbt.getString("frsm_mode");
		switch(mode){
			case "set":
				mode = "remove";
				break;
			case "remove":
				mode = "add";
				break;
			case "add":
				mode = "set";
				break;
			case "null":
			default:
				mode = "add";
				break;
		}
		nbt.setString("frsm_mode", mode);
		TemtUtil.sendUpdatePacket(player, "mode", mode);
		PrintChat.print(player, "Mode: " + mode);
		this.buttonList.get(0).displayString = "Mode: " + mode.toUpperCase();
	}

	private void switchType() {
		String type = nbt.getString("frsm_type");
		switch(type){
			case "scale_x":
				type = "scale_y";
				break;
			case "scale_y":
				type = "scale_z";
				break;
			case "scale_z":
				type = "rotation_x";
				break;
			case "rotation_x":
				type = "rotation_y";
				break;
			case "rotation_y":
				type = "rotation_z";
				break;
			case "rotation_z":
				type = "translate_x";
				break;
			case "translate_x":
				type = "translate_y";
				break;
			case "translate_y":
				type = "translate_z";
				break;
			case "translate_z":
				type = "scale_x";
				break;
			case "null":
			default:
				type = "scale_x";
				break;
		}
		nbt.setString("frsm_type", type);
		TemtUtil.sendUpdatePacket(player, "type", type);
		PrintChat.print(player, "Type: " + type);
		this.buttonList.get(1).displayString = "Type: " + type.toUpperCase();
	}

	private void changeAmount() {
		int amount = nbt.getInteger("frsm_amount");
		int result = 0;
		if(amount < 16){
			result = amount + 1;
		}
		if(amount >= 16 && amount < 20){
			result = 20;
		}
		if(amount >= 20){
			result = amount + 10;
		}
		if(amount >= 90){
			result = 0;
		}
		nbt.setInteger("frsm_amount", result);
		TemtUtil.sendUpdatePacket(player, "amount", result + "");
		PrintChat.print(player, "Amount: " + result);
		this.buttonList.get(2).displayString = "Amount: " + result;
	}
}