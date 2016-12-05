package net.fexcraft.mod.extensions.cae.gui;

import java.io.IOException;

import com.google.gson.JsonObject;

import net.fexcraft.mod.extensions.cae.gui.ButtonArrow.EnumArrowType;
import net.fexcraft.mod.extensions.cae.util.CAEUtil;
import net.fexcraft.mod.extensions.cae.util.Type;
import net.fexcraft.mod.frsm.FRSM;
import net.fexcraft.mod.frsm.util.SSC;
import net.fexcraft.mod.frsm.util.java.BoolUtil;
import net.fexcraft.mod.lib.network.Browser;
import net.fexcraft.mod.lib.network.packet.PacketJsonObject;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GuiCAE extends GuiScreen{
	
	private static Minecraft mc = Minecraft.getMinecraft();
	private static ResourceLocation bg = new ResourceLocation("frsm_asphalt:textures/gui/cae_main.png");
	private EntityPlayer player;
	private World world;
	private BlockPos pos;
	public static int sx = 256;
	public static int sy = 200;
	
	private ButtonArrow exit;//0
	private ButtonArrow right;//1
	private ButtonArrow left;//2
	private ButtonArrow help;//3
	
	private ButtonTypeSelect x2;//4
	private ButtonTypeSelect x4;//5
	private ButtonTypeSelect x8;//6
	private ButtonTypeSelect x16;//7
	private ButtonTypeSelect x32;//8
	private ButtonTypeSelect x64;//9
	
	private ButtonTool l0;//10
	private ButtonTool r0;//11
	private ButtonTool l1;//12
	private ButtonTool r1;//13
	private ButtonTool l2;//14
	private ButtonTool r2;//15
	private ButtonTool l3;//16
	private ButtonTool r3;//17
	
	private ButtonArrow u;//18
	private ButtonArrow d;//19
	private ButtonArrow r;//20
	private ButtonArrow l;//21
	private ButtonArrow s;//22
	private ButtonArrow b;//23
	private ButtonArrow reset;//24
	private ButtonSubmit submit;//25
	private ButtonSP[][] sp;//selectable;//25++;
	
	private static Type type;
	public static JsonObject obj;
	
	public GuiCAE(){
		this.player = Minecraft.getMinecraft().thePlayer;
		this.world = player.worldObj;
		this.pos = player.getPosition();
		if(type == null){
			type = Type.x16;
		}
	}
	
	@Override
    public void drawScreen(int mx, int my, float renderPartialTicks){
		this.drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(bg);
        this.drawTexturedModalRect((this.width - sx) / 2, (this.height - sy) / 2, 0, 0, sx, sy);
        
        this.right.enabled = false;
        this.left.enabled = false;
        
        if(type != Type.x16 && type != Type.x8){
        	this.submit.enabled = false;
        }
        
        this.exit.drawButton(mc, mx, my);
        this.right.drawButton(mc, mx, my);
		this.left.drawButton(mc, mx, my);
        this.help.drawButton(mc, mx, my);
        this.x2.drawButton(mc, mx, my);
        this.x4.drawButton(mc, mx, my);
        this.x8.drawButton(mc, mx, my);
        this.x16.drawButton(mc, mx, my);
        this.x32.drawButton(mc, mx, my);
        this.x64.drawButton(mc, mx, my);
        this.l0.drawButton(mc, mx, my);
        this.r0.drawButton(mc, mx, my);
        this.l1.drawButton(mc, mx, my);
        this.r1.drawButton(mc, mx, my);
        this.l2.drawButton(mc, mx, my);
        this.r2.drawButton(mc, mx, my);
        this.l3.drawButton(mc, mx, my);
        this.r3.drawButton(mc, mx, my);
        this.u.drawButton(mc, mx, my);
        this.d.drawButton(mc, mx, my);
        this.r.drawButton(mc, mx, my);
        this.l.drawButton(mc, mx, my);
        this.s.drawButton(mc, mx, my);
        this.b.drawButton(mc, mx, my);
        this.reset.drawButton(mc, mx, my);
        this.submit.drawButton(mc, mx, my);
        
        for(int i = 0; i < type.N(); i++){
    		for(int j = 0; j < type.N(); j++){
    			this.sp[i][j].drawButton(mc, mx, my);
    		}
    	}
    }

	@Override
    public boolean doesGuiPauseGame(){
        return false;
    }
	
	@Override
    public void initGui(){
    	super.initGui();
    	this.buttonList.clear();
    	this.buttonList.add(this.exit     = new ButtonArrow(0,  ((this.width - sx) / 2) + 242, ((this.height - sy) / 2) +   4, EnumArrowType.EXIT ));
    	this.buttonList.add(this.right    = new ButtonArrow(1,  ((this.width - sx) / 2) + 231, ((this.height - sy) / 2) +   4, EnumArrowType.RIGHT));
    	this.buttonList.add(this.left     = new ButtonArrow(2,  ((this.width - sx) / 2) + 220, ((this.height - sy) / 2) +   4, EnumArrowType.LEFT ));
    	this.buttonList.add(this.help     = new ButtonArrow(3,  ((this.width - sx) / 2) + 209, ((this.height - sy) / 2) +   4, EnumArrowType.HELP ));
    	this.buttonList.add(this.x2  = new ButtonTypeSelect(4,  ((this.width - sx) / 2) + 181, ((this.height - sy) / 2) +  33, Type.x2 ));
    	this.buttonList.add(this.x4  = new ButtonTypeSelect(5,  ((this.width - sx) / 2) + 217, ((this.height - sy) / 2) +  33, Type.x4 ));
    	this.buttonList.add(this.x8  = new ButtonTypeSelect(6,  ((this.width - sx) / 2) + 181, ((this.height - sy) / 2) +  44, Type.x8 ));
    	this.buttonList.add(this.x16 = new ButtonTypeSelect(7,  ((this.width - sx) / 2) + 217, ((this.height - sy) / 2) +  44, Type.x16));
    	this.buttonList.add(this.x32 = new ButtonTypeSelect(8,  ((this.width - sx) / 2) + 181, ((this.height - sy) / 2) +  55, Type.x32));
    	this.buttonList.add(this.x64 = new ButtonTypeSelect(9,  ((this.width - sx) / 2) + 217, ((this.height - sy) / 2) +  55, Type.x64));
    	this.buttonList.add(this.l0        = new ButtonTool(10, ((this.width - sx) / 2) + 181, ((this.height - sy) / 2) +  70, 200, 200));
    	this.buttonList.add(this.r0        = new ButtonTool(11, ((this.width - sx) / 2) + 206, ((this.height - sy) / 2) +  70, 200, 200));
    	this.buttonList.add(this.l1        = new ButtonTool(12, ((this.width - sx) / 2) + 181, ((this.height - sy) / 2) +  95, 200, 200));
    	this.buttonList.add(this.r1        = new ButtonTool(13, ((this.width - sx) / 2) + 206, ((this.height - sy) / 2) +  95, 200, 200));
    	this.buttonList.add(this.l2        = new ButtonTool(14, ((this.width - sx) / 2) + 181, ((this.height - sy) / 2) + 120, 200, 200));
    	this.buttonList.add(this.r2        = new ButtonTool(15, ((this.width - sx) / 2) + 206, ((this.height - sy) / 2) + 120, 200, 200));
    	this.buttonList.add(this.l3        = new ButtonTool(16, ((this.width - sx) / 2) + 181, ((this.height - sy) / 2) + 145, 200, 200));
    	this.buttonList.add(this.r3        = new ButtonTool(17, ((this.width - sx) / 2) + 206, ((this.height - sy) / 2) + 145, 200, 200));
    	this.buttonList.add(this.u        = new ButtonArrow(18, ((this.width - sx) / 2) + 236, ((this.height - sy) / 2) +  72, EnumArrowType.UP       ));
    	this.buttonList.add(this.d        = new ButtonArrow(19, ((this.width - sx) / 2) + 236, ((this.height - sy) / 2) +  82, EnumArrowType.DOWN     ));
    	this.buttonList.add(this.r        = new ButtonArrow(20, ((this.width - sx) / 2) + 236, ((this.height - sy) / 2) +  97, EnumArrowType.RIGHT    ));
    	this.buttonList.add(this.l        = new ButtonArrow(21, ((this.width - sx) / 2) + 236, ((this.height - sy) / 2) + 107, EnumArrowType.LEFT     ));
    	this.buttonList.add(this.s        = new ButtonArrow(22, ((this.width - sx) / 2) + 236, ((this.height - sy) / 2) + 122, EnumArrowType.SLASH    ));
    	this.buttonList.add(this.b        = new ButtonArrow(23, ((this.width - sx) / 2) + 236, ((this.height - sy) / 2) + 132, EnumArrowType.BACKSLASH));
    	this.buttonList.add(this.reset    = new ButtonArrow(24, ((this.width - sx) / 2) + 236, ((this.height - sy) / 2) + 157, EnumArrowType.EXIT     ));
    	this.buttonList.add(this.submit  = new ButtonSubmit(25, ((this.width - sx) / 2) + 179, ((this.height - sy) / 2) + 171, "SAVE"));
    	int k = 26;
    	this.sp = new ButtonSP[type.N()][type.N()];
    	for(int i = 0; i < type.N(); i++){
    		for(int j = 0; j < type.N(); j++){
        		this.buttonList.add(this.sp[i][j] = new ButtonSP(k, ((((this.width - sx) / 2) + 20) + (i * ButtonSP.getSize())), ((((this.height - sy) / 2) + 43) + (j * ButtonSP.getSize()))));
        		k++;
        	}
    	}
    }
	
	@Override
    protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id > 25){
			((ButtonSP)button).sp = BoolUtil.reverse(((ButtonSP)button).sp);
			return;
		}
		switch(button.id){
			case 0://Exit
				close();
				return;
			case 3://Help
				Browser.browse(player, "http://fexcraft.net/");
		    	close();
		    	return;
			case 4:
				sendResetPacket(Type.x2);
				return;
			case 5:
				sendResetPacket(Type.x4);
				return;
			case 6:
				sendResetPacket(Type.x8);
				return;
			case 7:
				sendResetPacket(Type.x16);
				return;
			case 8:
				sendResetPacket(Type.x32);
				return;
			case 9:
				sendResetPacket(Type.x64);
				return;
			case 24:
				sendResetPacket(type);
				return;
			case 25:
				sendUpdatePacket();
				return;
		    default:
		    	return;
		}
    }
	
	public void sendUpdatePacket(){
		player.openGui(FRSM.getInstance(), -1, world, pos.getX(), pos.getY(), pos.getZ());
		JsonObject obj = JsonUtil.getJsonForPacket("cae");
		obj.addProperty("type", type.toString());
		obj.addProperty("task", "update_item");
		obj.addProperty("player", player.getName());
		char[] array = getArrayFromButtons();
		array = rotateClockWise(array);
		array = rotateClockWise(array);
		array = rotateClockWise(array);
		obj.addProperty("array", new String(array));
		SSC.getPacketHandler().sendToServer(new PacketJsonObject(obj));
	}
	
	public char[] getArrayFromButtons(){
		char[] array = type.getEmptyArray();
		for(int i = 0; i < type.N(); i++){
			for(int j = 0; j < type.N(); j++){
				boolean sb = sp[i][j].sp;
				array[(sp[i][j].id - 26)] = (sb ? '1' : '0');
			}
		}
		return array;
	}
	
	public char[] rotateClockWise(char[] arr){
		int[][] iar = CAEUtil.intXZfromCharArray(type, arr);
		int[][] nar = new int[type.N()][type.N()];
		for(int i = 0; i < iar[0].length; i++){
	        for(int j = iar.length - 1; j >= 0; j--){
	            nar[i][j] = iar[j][i];
	        }
	    }
		int k = 0;
		for(int x = 0; x < type.N(); x++){
			for(int z = 0; z < type.N(); z++){
				String s = nar[x][z] + "";
				arr[k] = s.toCharArray()[0];
				k++;
			}
		}
		return arr;
	}
	
	public void sendResetPacket(Type type){
		player.openGui(FRSM.getInstance(), -1, world, pos.getX(), pos.getY(), pos.getZ());
		JsonObject obj = JsonUtil.getJsonForPacket("cae");
		obj.addProperty("type", type.toString());
		obj.addProperty("task", "reset_gui");
		obj.addProperty("player", player.getName());
		SSC.getPacketHandler().sendToServer(new PacketJsonObject(obj));
	}

	public static void close(){
		mc.displayGuiScreen(null);
	    if (mc.currentScreen == null){
	    	mc.setIngameFocus();
	    }
	}

	public static void setType(Type tp){
		type = tp;
	}
	
	
	public static Type getType(){
		return type;
	}
	
}