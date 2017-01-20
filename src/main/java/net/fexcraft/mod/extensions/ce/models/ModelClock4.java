//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de

// Model: Clock4
// Model Creator: FEX___96 (Ferdinand)
// Created on: 19.01.2017 - 20:11:07
// Last changed on: 19.01.2017 - 20:11:07

package net.fexcraft.mod.extensions.ce.models;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.extensions.ce.util.ClockModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelClock4 extends ClockModelBase {
	
	private static final int textureX = 128, textureY = 128;

	public ModelClock4(){
		models.add(this);
		base = new ModelRendererTurbo[49];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		base[1] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 1
		base[2] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 6
		base[3] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 7
		base[4] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 8
		base[5] = new ModelRendererTurbo(this, 25, 17, textureX, textureY); // Box 9
		base[6] = new ModelRendererTurbo(this, 65, 17, textureX, textureY); // Box 10
		base[7] = new ModelRendererTurbo(this, 89, 17, textureX, textureY); // Box 11
		base[8] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 12
		base[9] = new ModelRendererTurbo(this, 41, 41, textureX, textureY); // Box 13
		base[10] = new ModelRendererTurbo(this, 81, 41, textureX, textureY); // Box 14
		base[11] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 15
		base[12] = new ModelRendererTurbo(this, 41, 57, textureX, textureY); // Box 16
		base[13] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 17
		base[14] = new ModelRendererTurbo(this, 57, 81, textureX, textureY); // Box 18
		base[15] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 19
		base[16] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 20
		base[17] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 21
		base[18] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 22
		base[19] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 29
		base[20] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 30
		base[21] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 31
		base[22] = new ModelRendererTurbo(this, 105, 1, textureX, textureY); // Box 32
		base[23] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 33
		base[24] = new ModelRendererTurbo(this, 57, 17, textureX, textureY); // Box 34
		base[25] = new ModelRendererTurbo(this, 81, 17, textureX, textureY); // Box 35
		base[26] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 36
		base[27] = new ModelRendererTurbo(this, 25, 17, textureX, textureY); // Box 37
		base[28] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Box 38
		base[29] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Box 39
		base[30] = new ModelRendererTurbo(this, 105, 17, textureX, textureY); // Box 40
		base[31] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 41
		base[32] = new ModelRendererTurbo(this, 121, 33, textureX, textureY); // Box 42
		base[33] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 43
		base[34] = new ModelRendererTurbo(this, 73, 41, textureX, textureY); // Box 44
		base[35] = new ModelRendererTurbo(this, 113, 41, textureX, textureY); // Box 45
		base[36] = new ModelRendererTurbo(this, 41, 41, textureX, textureY); // Box 46
		base[37] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 47
		base[38] = new ModelRendererTurbo(this, 9, 49, textureX, textureY); // Box 48
		base[39] = new ModelRendererTurbo(this, 121, 49, textureX, textureY); // Box 49
		base[40] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 50
		base[41] = new ModelRendererTurbo(this, 105, 57, textureX, textureY); // Box 51
		base[42] = new ModelRendererTurbo(this, 113, 57, textureX, textureY); // Box 52
		base[43] = new ModelRendererTurbo(this, 121, 57, textureX, textureY); // Box 53
		base[44] = new ModelRendererTurbo(this, 105, 65, textureX, textureY); // Box 54
		base[45] = new ModelRendererTurbo(this, 113, 65, textureX, textureY); // Box 55
		base[46] = new ModelRendererTurbo(this, 121, 65, textureX, textureY); // Box 56
		base[47] = new ModelRendererTurbo(this, 105, 73, textureX, textureY); // Box 57
		base[48] = new ModelRendererTurbo(this, 113, 73, textureX, textureY); // Box 58

		base[0].addBox(0F, 0F, 0F, 8, 3, 6, 0F); // Box 0
		base[0].setRotationPoint(-4F, -1F, 2F);

		base[1].addBox(0F, 0F, 0F, 8, 3, 6, 0F); // Box 1
		base[1].setRotationPoint(-4F, -34F, 2F);

		base[2].addBox(0F, 0F, 0F, 3, 8, 6, 0F); // Box 6
		base[2].setRotationPoint(15F, -20F, 2F);

		base[3].addBox(0F, 0F, 0F, 3, 8, 6, 0F); // Box 7
		base[3].setRotationPoint(-18F, -20F, 2F);

		base[4].addShapeBox(0F, 0F, 0F, 3, 10, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, -1F, 0F, 4F, -3F, 0F, 4F, -3F, 0F, -5F, -1F, 0F); // Box 8
		base[4].setRotationPoint(-18F, -12F, 2F);

		base[5].addShapeBox(0F, 0F, 0F, 10, 3, 6, 0F, -3F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 4F, 0F, -1F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -5F, 0F); // Box 9
		base[5].setRotationPoint(-14F, -1F, 2F);

		base[6].addShapeBox(0F, 0F, 0F, 3, 10, 6, 0F, -5F, -1F, 0F, 4F, -3F, 0F, 4F, -3F, 0F, -5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
		base[6].setRotationPoint(-18F, -30F, 2F);

		base[7].addShapeBox(0F, 0F, 0F, 3, 10, 6, 0F, 4F, -3F, 0F, -5F, -1F, 0F, -5F, -1F, 0F, 4F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 11
		base[7].setRotationPoint(15F, -30F, 2F);

		base[8].addShapeBox(0F, 0F, 0F, 3, 10, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, -3F, 0F, -5F, -1F, 0F, -5F, -1F, 0F, 4F, -3F, 0F); // Box 12
		base[8].setRotationPoint(15F, -12F, 2F);

		base[9].addShapeBox(0F, 0F, 0F, 10, 3, 6, 0F, -1F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -5F, 0F, -3F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 4F, 0F); // Box 13
		base[9].setRotationPoint(-14F, -34F, 2F);

		base[10].addShapeBox(0F, 0F, 0F, 10, 3, 6, 0F, 0F, 0F, 0F, -1F, -5F, 0F, -1F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 4F, 0F, -3F, 4F, 0F, 0F, 0F, 0F); // Box 14
		base[10].setRotationPoint(4F, -34F, 2F);

		base[11].addShapeBox(0F, 0F, 0F, 10, 3, 6, 0F, 0F, 0F, 0F, -3F, 4F, 0F, -3F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -5F, 0F, -1F, -5F, 0F, 0F, 0F, 0F); // Box 15
		base[11].setRotationPoint(4F, -1F, 2F);

		base[12].addBox(0F, 0F, 0F, 30, 18, 1, 0F); // Box 16
		base[12].setRotationPoint(-15F, -25F, 6.5F);

		base[13].addBox(0F, 0F, 0F, 26, 4, 1, 0F); // Box 17
		base[13].setRotationPoint(-13F, -29F, 6.5F);

		base[14].addBox(0F, 0F, 0F, 26, 4, 1, 0F); // Box 18
		base[14].setRotationPoint(-13F, -7F, 6.5F);

		base[15].addBox(0F, 0F, 0F, 16, 2, 1, 0F); // Box 19
		base[15].setRotationPoint(-8F, -31F, 6.5F);

		base[16].addBox(0F, 0F, 0F, 16, 2, 1, 0F); // Box 20
		base[16].setRotationPoint(-8F, -3F, 6.5F);

		base[17].addBox(-1.5F, -1.5F, 0F, 3, 3, 3, 0F); // Box 21
		base[17].setRotationPoint(0F, -16F, 4F);

		base[18].addShapeBox(-1.5F, -1.5F, 0F, 3, 3, 2, 0F, 0F, -1.5F, -0.5F, -1.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, -0.5F, 0F, -1.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 22
		base[18].setRotationPoint(0F, -16F, 2F);

		base[19].addBox(0F, 0F, 0F, 1, 3, 1, 0F); // Box 29
		base[19].setRotationPoint(-1.5F, -6F, 6F);

		base[20].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 30
		base[20].setRotationPoint(-1.5F, -3F, 6F);

		base[21].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 31
		base[21].setRotationPoint(-1.5F, -7F, 6F);

		base[22].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 32
		base[22].setRotationPoint(0.5F, -4F, 6F);

		base[23].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 33
		base[23].setRotationPoint(-0.5F, -5F, 6F);

		base[24].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 34
		base[24].setRotationPoint(11F, -18.5F, 6F);

		base[25].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 35
		base[25].setRotationPoint(11F, -14.5F, 6F);

		base[26].addBox(0F, 0F, 0F, 1, 3, 1, 0F); // Box 36
		base[26].setRotationPoint(13F, -17.5F, 6F);

		base[27].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 37
		base[27].setRotationPoint(12F, -16.5F, 6F);

		base[28].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 38
		base[28].setRotationPoint(-14F, -18.5F, 6F);

		base[29].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 39
		base[29].setRotationPoint(-14F, -14.5F, 6F);

		base[30].addBox(0F, 0F, 0F, 1, 3, 1, 0F); // Box 40
		base[30].setRotationPoint(-12F, -17.5F, 6F);

		base[31].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 41
		base[31].setRotationPoint(-14F, -17.5F, 6F);

		base[32].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 42
		base[32].setRotationPoint(-14F, -16.5F, 6F);

		base[33].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 43
		base[33].setRotationPoint(0.5F, -30F, 6F);

		base[34].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 44
		base[34].setRotationPoint(0.5F, -26F, 6F);

		base[35].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 45
		base[35].setRotationPoint(0.5F, -28F, 6F);

		base[36].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 46
		base[36].setRotationPoint(0.5F, -27F, 6F);

		base[37].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 47
		base[37].setRotationPoint(2.5F, -29F, 6F);

		base[38].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 48
		base[38].setRotationPoint(-3.5F, -26F, 6F);

		base[39].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 49
		base[39].setRotationPoint(-3.5F, -30F, 6F);

		base[40].addBox(0F, 0F, 0F, 1, 3, 1, 0F); // Box 50
		base[40].setRotationPoint(-2.5F, -29F, 6F);

		base[41].addBox(-0.5F, 9F, 0F, 1, 5, 1, 0F); // Box 51
		base[41].setRotationPoint(0F, -16F, 6F);
		base[41].rotateAngleZ = -0.52359878F;

		base[42].addBox(-0.5F, 9F, 0F, 1, 5, 1, 0F); // Box 52
		base[42].setRotationPoint(0F, -16F, 6F);
		base[42].rotateAngleZ = -1.04719755F;

		base[43].addBox(-0.5F, 9F, 0F, 1, 5, 1, 0F); // Box 53
		base[43].setRotationPoint(0F, -16F, 6F);
		base[43].rotateAngleZ = -2.0943951F;

		base[44].addBox(-0.5F, 9F, 0F, 1, 5, 1, 0F); // Box 54
		base[44].setRotationPoint(0F, -16F, 6F);
		base[44].rotateAngleZ = -2.61799388F;

		base[45].addBox(-0.5F, 9F, 0F, 1, 5, 1, 0F); // Box 55
		base[45].setRotationPoint(0F, -16F, 6F);
		base[45].rotateAngleZ = 0.52359878F;

		base[46].addBox(-0.5F, 9F, 0F, 1, 5, 1, 0F); // Box 56
		base[46].setRotationPoint(0F, -16F, 6F);
		base[46].rotateAngleZ = 1.04719755F;

		base[47].addBox(-0.5F, 9F, 0F, 1, 5, 1, 0F); // Box 57
		base[47].setRotationPoint(0F, -16F, 6F);
		base[47].rotateAngleZ = 2.0943951F;

		base[48].addBox(-0.5F, 9F, 0F, 1, 5, 1, 0F); // Box 58
		base[48].setRotationPoint(0F, -16F, 6F);
		base[48].rotateAngleZ = 2.61799388F;


		hour = new ModelRendererTurbo[1];
		hour[0] = new ModelRendererTurbo(this, 113, 9, textureX, textureY); // Box 23

		hour[0].addShapeBox(-1F, 0F, 0F, 2, 10, 1, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, -0.2F, -0.8F, 0F, -0.2F); // Box 23
		hour[0].setRotationPoint(0F, -24F, 5F);


		minute = new ModelRendererTurbo[1];
		minute[0] = new ModelRendererTurbo(this, 121, 9, textureX, textureY); // Box 24

		minute[0].addShapeBox(-1F, 0F, 0F, 2, 12, 1, 0F, -0.6F, 0F, 0F, -0.6F, 0F, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, -0.2F, -0.8F, 0F, -0.2F); // Box 24
		minute[0].setRotationPoint(0F, -24F, 4F);


		second = new ModelRendererTurbo[1];
		second[0] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 25

		second[0].addShapeBox(-1F, 0F, 0F, 2, 14, 1, 0F, -0.7F, 0F, 0F, -0.7F, 0F, 0F, -0.3F, 0F, -0.2F, -0.3F, 0F, -0.2F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, -0.2F, -0.9F, 0F, -0.2F); // Box 25
		second[0].setRotationPoint(0F, -24F, 3F);


		translateAll(0F, 24F, 0F);
		
	}

	@Override
	public String getName(){
		return "clock4";
	}
	
	@Override
	public void renderBase(){
		GL11.glRotatef(-90, 0f, 1f, 0f);
		super.renderBase();
		GL11.glRotatef( 90, 0f, 1f, 0f);
		GL11.glTranslatef(0F, -.5F, 0F);
	}
	
	@Override
	public void renderHour(){
		GL11.glRotatef(-90, 0f, 1f, 0f);
		super.renderHour();
		GL11.glRotatef( 90, 0f, 1f, 0f);
	}
	
	@Override
	public void renderMinute(){
		GL11.glRotatef(-90, 0f, 1f, 0f);
		super.renderMinute();
		GL11.glRotatef( 90, 0f, 1f, 0f);
	}
	
	@Override
	public void renderSecond(){
		GL11.glRotatef(-90, 0f, 1f, 0f);
		super.renderSecond();
		GL11.glRotatef( 90, 0f, 1f, 0f);
	}
	
	
}