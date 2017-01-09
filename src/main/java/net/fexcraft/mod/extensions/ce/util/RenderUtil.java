package net.fexcraft.mod.extensions.ce.util;

import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.util.ResourceLocation;

public class RenderUtil{
	
	public static ResourceLocation[] calendar1 = new ResourceLocation[]{
		new ResourceLocation("frsm_ce:textures/blocks/calendar1_0.png"),
		new ResourceLocation("frsm_ce:textures/blocks/calendar1_1.png"),
		new ResourceLocation("frsm_ce:textures/blocks/calendar1_2.png"),
		new ResourceLocation("frsm_ce:textures/blocks/calendar1_3.png"),
		new ResourceLocation("frsm_ce:textures/blocks/calendar1_4.png"),
		new ResourceLocation("frsm_ce:textures/blocks/calendar1_5.png"),
		new ResourceLocation("frsm_ce:textures/blocks/calendar1_6.png"),
		new ResourceLocation("frsm_ce:textures/blocks/calendar1_7.png"),
		new ResourceLocation("frsm_ce:textures/blocks/calendar1_8.png"),
		new ResourceLocation("frsm_ce:textures/blocks/calendar1_9.png"),
		new ResourceLocation("frsm_ce:textures/blocks/calendar1_10.png"),
		new ResourceLocation("frsm_ce:textures/blocks/calendar1_11.png"),
		new ResourceLocation("frsm_ce:textures/blocks/calendar1_12.png"),
	};

	public static ResourceLocation getCalendar1Texture(){
		return calendar1[Time.getMonth() + 1];
	}

	public static ResourceLocation getCalendar1Texture(int i){
		return calendar1[i];
	}
	
}