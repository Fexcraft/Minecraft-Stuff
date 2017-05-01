package net.fexcraft.mod.fvm.data;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TextObject {
	
	private float xscale;
	private float yscale;
	private float yaw_rot, pitch_rot, roll_rot;
	private Pos offset;
	private boolean onDoor, isLicensePlate;
	private int color;
	private String text;
	
	public TextObject(JsonObject obj, boolean b){
		this.isLicensePlate = b;
		xscale = JsonUtil.getIfExists(obj, "xscale", -0.0125f).floatValue();
		yscale = JsonUtil.getIfExists(obj, "yscale", -0.0125f).floatValue();
		yaw_rot = JsonUtil.getIfExists(obj, "yaw_rot", 0).floatValue();
		pitch_rot = JsonUtil.getIfExists(obj, "pitch_rot", 0).floatValue();
		roll_rot = JsonUtil.getIfExists(obj, "poll_rot", 0).floatValue();
		offset = Pos.fromJSON(obj);
		onDoor = JsonUtil.getIfExists(obj, "onDoor", false);
		try{
			String s = JsonUtil.getIfExists(obj, "", "#000000");
			color = Integer.parseInt(s.replace("#", ""));
		}
		catch(Exception e){
			color = 0x000000;
		}
		text = JsonUtil.getIfExists(obj, "text", "<null>");
	}
	
	public TextObject(String str, boolean isLP, float xs, float ys, float yaw, float pitch, float roll, Pos offsetpos, boolean door, int colour){
		this.isLicensePlate = isLP;
		this.text = str;
		xscale = xs; yscale = ys;
		yaw_rot = yaw; pitch_rot = pitch; roll_rot = roll;
		offset = offsetpos; onDoor = door;
		color = colour;
	}
	
	public boolean isLicensePlate(){
		return this.isLicensePlate;
	}
	
	@SideOnly(Side.CLIENT)
	public static void render(VehicleType type, double yaw, double pitch){
		String str = type.license_code == null ? type.fullname : type.license_code;
		for(TextObject plate : type.license_plates){
			if(plate.onDoor && !type.doors){
				continue;
			}
			plate.render(plate.isLicensePlate ? str : plate.text, yaw, pitch);
		}
		for(TextObject plate : type.text_areas){
			if(plate.onDoor && !type.doors){
				continue;
			}
			plate.render(plate.isLicensePlate ? str : plate.text, yaw, pitch);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public static void render(VehicleType type, int facing){
		double d = 60;
		switch(facing){
			case 2: d = 0; break;
			case 3: d = -180d; break;
			case 4: d = -90; break;
			case 5: d = -270d; break;
		}
		render(type, d, 0);
	}

	@SideOnly(Side.CLIENT)
	public void render(String str, double yaw, double pitch){
		net.minecraft.client.gui.FontRenderer fro = net.minecraft.client.Minecraft.getMinecraft().fontRendererObj;
		GlStateManager.pushMatrix();
       	offset.translate();
        GlStateManager.glNormal3f(0.0F, 1.0F, 0.0F);
        GL11.glRotated(90 + yaw_rot, 0.0F, 1.0F, 0.0F);
        GL11.glRotated(-180 - pitch_rot, 1.0F, 0.0F, 0.0F);
        GL11.glRotated(roll_rot, 0.0F, 0.0F, 1.0F);
        GlStateManager.scale(xscale, yscale, 0.0125F);
        GlStateManager.enableBlend();
        GlStateManager.disableLighting();
        fro.drawString(str, -fro.getStringWidth(str) / 2, 0, color);
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        offset.translateR();
        GlStateManager.popMatrix();
	}
	
}