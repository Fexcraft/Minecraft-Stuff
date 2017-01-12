package net.fexcraft.mod.extensions.ce.models;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.extensions.ce.util.ClockModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelClock3 extends ClockModelBase {
	int textureX = 64;
	int textureY = 64;

	public ModelClock3(){
		models.add(this);
		hour = new ModelRendererTurbo[1];
		hour[0] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Hour
		second = new ModelRendererTurbo[1];
		second[0] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Second
		minute = new ModelRendererTurbo[1];
		minute[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Minute
		base = new ModelRendererTurbo[36];
		base[0] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Base04
		base[1] = new ModelRendererTurbo(this, 25, 9, textureX, textureY); // Base05
		base[2] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Base06
		base[3] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Base07
		base[4] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Base08
		base[5] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Base09
		base[6] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Base10
		base[7] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Base11
		base[8] = new ModelRendererTurbo(this, 9, 33, textureX, textureY); // Base12
		base[9] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Base13
		base[10] = new ModelRendererTurbo(this, 25, 33, textureX, textureY); // Base14
		base[11] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Base15
		base[12] = new ModelRendererTurbo(this, 41, 33, textureX, textureY); // Base16
		base[13] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Base17
		base[14] = new ModelRendererTurbo(this, 57, 33, textureX, textureY); // Base18
		base[15] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Base19
		base[16] = new ModelRendererTurbo(this, 9, 41, textureX, textureY); // Base20
		base[17] = new ModelRendererTurbo(this, 17, 41, textureX, textureY); // Base21
		base[18] = new ModelRendererTurbo(this, 25, 41, textureX, textureY); // Base22
		base[19] = new ModelRendererTurbo(this, 33, 41, textureX, textureY); // Base23
		base[20] = new ModelRendererTurbo(this, 41, 41, textureX, textureY); // Base24
		base[21] = new ModelRendererTurbo(this, 49, 41, textureX, textureY); // Base25
		base[22] = new ModelRendererTurbo(this, 57, 41, textureX, textureY); // Base26
		base[23] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Base27
		base[24] = new ModelRendererTurbo(this, 9, 49, textureX, textureY); // Base28
		base[25] = new ModelRendererTurbo(this, 17, 49, textureX, textureY); // Base29
		base[26] = new ModelRendererTurbo(this, 25, 49, textureX, textureY); // Base30
		base[27] = new ModelRendererTurbo(this, 33, 49, textureX, textureY); // Base31
		base[28] = new ModelRendererTurbo(this, 41, 49, textureX, textureY); // Base32
		base[29] = new ModelRendererTurbo(this, 49, 49, textureX, textureY); // Base33
		base[30] = new ModelRendererTurbo(this, 57, 49, textureX, textureY); // Base34
		base[31] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Base35
		base[32] = new ModelRendererTurbo(this, 9, 57, textureX, textureY); // Base36
		base[33] = new ModelRendererTurbo(this, 17, 57, textureX, textureY); // Base37
		base[34] = new ModelRendererTurbo(this, 25, 57, textureX, textureY); // Base38
		base[35] = new ModelRendererTurbo(this, 33, 57, textureX, textureY); // Base39

		base[0].addBox(0F, 0F, 0F, 16, 2, 3, 0F); // Base04
		base[0].setRotationPoint(0F, -2F, 0F);

		base[1].addBox(0F, 0F, 0F, 16, 2, 3, 0F); // Base05
		base[1].setRotationPoint(0F, -16F, 0F);

		base[2].addBox(0F, 0F, 0F, 2, 12, 3, 0F); // Base06
		base[2].setRotationPoint(0F, -14F, 0F);

		base[3].addBox(0F, 0F, 0F, 2, 12, 3, 0F); // Base07
		base[3].setRotationPoint(14F, -14F, 0F);

		base[4].addBox(0F, 0F, 0F, 12, 12, 1, 0F); // Base08
		base[4].setRotationPoint(2F, -14F, 0F);

		base[5].addShapeBox(0.5F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Base09
		base[5].setRotationPoint(7F, -9F, 1F);

		base[6].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -0.5F, 0F, -0.5F, -0.5F); // Base10
		base[6].setRotationPoint(7F, -9F, 1F);

		base[7].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, -0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.5F, -0.5F, 0F, -0.5F); // Base11
		base[7].setRotationPoint(8F, -9F, 1F);

		base[8].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, -0.5F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, -0.5F, -0.5F, 0F, -0.5F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, -0.5F, -0.5F, 0F); // Base12
		base[8].setRotationPoint(8F, -9F, 2F);

		base[9].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, -0.5F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, -0.5F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, -0.5F, 0F, 0F, -0.5F, -0.5F); // Base13
		base[9].setRotationPoint(7F, -9F, 2F);

		base[10].addShapeBox(0.5F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Base14
		base[10].setRotationPoint(7F, -9F, 2F);

		base[11].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Base15
		base[11].setRotationPoint(7F, -13.9F, 0.1F);

		base[12].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Base16
		base[12].setRotationPoint(7F, -4.1F, 0.1F);

		base[13].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Base17
		base[13].setRotationPoint(2.1F, -9F, 0.1F);

		base[14].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Base18
		base[14].setRotationPoint(11.9F, -9F, 0.1F);

		base[15].addShapeBox(-0.5F, 3.9F, 0F, 1, 2, 1, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Base19
		base[15].setRotationPoint(8F, -8F, 0.1F);
		base[15].rotateAngleZ = 0.52359878F;

		base[16].addShapeBox(-0.5F, 3.9F, 0F, 1, 2, 1, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Base20
		base[16].setRotationPoint(8F, -8F, 0.1F);
		base[16].rotateAngleZ = 1.04719755F;

		base[17].addShapeBox(-0.5F, 3.9F, 0F, 1, 2, 1, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Base21
		base[17].setRotationPoint(8F, -8F, 0.1F);
		base[17].rotateAngleZ = 2.0943951F;

		base[18].addShapeBox(-0.5F, 3.9F, 0F, 1, 2, 1, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Base22
		base[18].setRotationPoint(8F, -8F, 0.1F);
		base[18].rotateAngleZ = 2.61799388F;

		base[19].addShapeBox(-0.5F, 3.9F, 0F, 1, 2, 1, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Base23
		base[19].setRotationPoint(8F, -8F, 0.1F);
		base[19].rotateAngleZ = 3.66519143F;

		base[20].addShapeBox(-0.5F, 3.9F, 0F, 1, 2, 1, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Base24
		base[20].setRotationPoint(8F, -8F, 0.1F);
		base[20].rotateAngleZ = 4.1887902F;

		base[21].addShapeBox(-0.5F, 3.9F, 0F, 1, 2, 1, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Base25
		base[21].setRotationPoint(8F, -8F, 0.1F);
		base[21].rotateAngleZ = 5.23598776F;

		base[22].addShapeBox(-0.5F, 3.9F, 0F, 1, 2, 1, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Base26
		base[22].setRotationPoint(8F, -8F, 0.1F);
		base[22].rotateAngleZ = 5.75958653F;

		base[23].addShapeBox(-1.2F, 0F, 0F, 1, 2, 1, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.8F, -0.4F, 0F, -0.8F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, -0.8F, -0.4F, -0.4F, -0.8F); // Base27
		base[23].setRotationPoint(8F, -13.7F, 1F);

		base[24].addShapeBox(-0.9F, 0F, 0F, 1, 2, 1, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.8F, -0.4F, 0F, -0.8F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, -0.8F, -0.4F, -0.4F, -0.8F); // Base28
		base[24].setRotationPoint(8F, -13.7F, 1F);

		base[25].addShapeBox(0.2F, 0F, 0F, 1, 2, 1, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.8F, -0.4F, 0F, -0.8F, 0.4F, -0.4F, 0F, -1.2F, -0.4F, 0F, -1.2F, -0.4F, -0.8F, 0.4F, -0.4F, -0.8F); // Base29
		base[25].setRotationPoint(8F, -13.7F, 1F);

		base[26].addShapeBox(0.2F, 0F, 0F, 1, 2, 1, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.8F, -0.4F, 0F, -0.8F, -1.2F, -0.4F, 0F, 0.4F, -0.4F, 0F, 0.4F, -0.4F, -0.8F, -1.2F, -0.4F, -0.8F); // Base30
		base[26].setRotationPoint(7.2F, -13.7F, 1F);

		base[27].addShapeBox(-1.2F, 0F, 0F, 1, 2, 1, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.8F, -0.4F, 0F, -0.8F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, -0.8F, -0.4F, -0.4F, -0.8F); // Base31
		base[27].setRotationPoint(8.1F, -3.9F, 1F);

		base[28].addShapeBox(0.2F, 0F, 0F, 1, 2, 1, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.8F, -0.4F, 0F, -0.8F, 0F, -0.4F, 0F, -0.8F, -0.4F, 0F, -0.8F, -0.4F, -0.8F, 0F, -0.4F, -0.8F); // Base32
		base[28].setRotationPoint(8F, -3.9F, 1F);

		base[29].addShapeBox(0.2F, 0F, 0F, 1, 2, 1, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.8F, -0.4F, 0F, -0.8F, -0.8F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, -0.8F, -0.4F, -0.8F); // Base33
		base[29].setRotationPoint(7.1F, -3.9F, 1F);

		base[30].addShapeBox(-1.2F, 0F, 0F, 1, 2, 1, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.8F, -0.4F, 0F, -0.8F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, -0.8F, -0.4F, -0.4F, -0.8F); // Base34
		base[30].setRotationPoint(4.2F, -8.8F, 1F);

		base[31].addShapeBox(-1.2F, 0F, 0F, 1, 2, 1, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.8F, -0.4F, 0F, -0.8F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, -0.8F, -0.4F, -0.4F, -0.8F); // Base35
		base[31].setRotationPoint(3.8F, -8.8F, 1F);

		base[32].addShapeBox(-1.2F, 0F, 0F, 1, 2, 1, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.8F, -0.4F, 0F, -0.8F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, -0.8F, -0.4F, -0.4F, -0.8F); // Base36
		base[32].setRotationPoint(3.4F, -8.8F, 1F);

		base[33].addShapeBox(0.2F, 0F, 0F, 1, 2, 1, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.8F, -0.4F, 0F, -0.8F, 0.4F, -0.4F, 0F, -1.2F, -0.4F, 0F, -1.2F, -0.4F, -0.8F, 0.4F, -0.4F, -0.8F); // Base37
		base[33].setRotationPoint(12.3F, -8.8F, 1F);

		base[34].addShapeBox(0.2F, 0F, 0F, 1, 2, 1, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.8F, -0.4F, 0F, -0.8F, -1.2F, -0.4F, 0F, 0.4F, -0.4F, 0F, 0.4F, -0.4F, -0.8F, -1.2F, -0.4F, -0.8F); // Base38
		base[34].setRotationPoint(11.5F, -8.8F, 1F);

		base[35].addShapeBox(-1.2F, 0F, 0F, 1, 2, 1, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.8F, -0.4F, 0F, -0.8F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, -0.8F, -0.4F, -0.4F, -0.8F); // Base39
		base[35].setRotationPoint(14.1F, -8.8F, 1F);

		minute[0].addShapeBox(-0.5F, 0F, 0.25F, 1, 6, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.8F, -0.3F, 0F, -0.8F, -0.45F, -0.5F, 0F, -0.45F, -0.5F, 0F, -0.45F, -0.5F, -0.8F, -0.45F, -0.5F, -0.8F); // Minute
		minute[0].setRotationPoint(8F, -24F, 0F);

		hour[0].addShapeBox(-0.5F, 0F, 0F, 1, 5, 1, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.8F, -0.2F, 0F, -0.8F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, -0.8F, -0.4F, -0.5F, -0.8F); // Hour
		hour[0].setRotationPoint(8F, -24F, 0F);

		second[0].addShapeBox(-0.5F, 0F, 0.5F, 1, 6, 1, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.8F, -0.4F, 0F, -0.8F, -0.45F, 0F, 0F, -0.45F, 0F, 0F, -0.45F, 0F, -0.8F, -0.45F, 0F, -0.8F); // Second
		second[0].setRotationPoint(8F, -24F, 0F);


		translateAll(-8F, 24F, -8F);

		//flipAll();
	}
	
	@Override
	public void renderBase(){
		GL11.glRotatef( 90, 0, 1, 0);
		super.renderBase();
		GL11.glRotatef(-90, 0, 1, 0);
	}
	
	@Override
	public void renderSecond(){
		GL11.glRotatef( 90, 0, 1, 0);
		GL11.glTranslatef(0f, 0f, 0.125f);
		super.renderSecond();
		GL11.glTranslatef(0f, 0f, -.125f);
		GL11.glRotatef(-90, 0, 1, 0);
	}
	
	@Override
	public void renderMinute(){
		GL11.glRotatef( 90, 0, 1, 0);
		GL11.glTranslatef(0f, 0f, 0.125f);
		super.renderMinute();
		GL11.glTranslatef(0f, 0f, -.125f);
		GL11.glRotatef(-90, 0, 1, 0);
	}
	
	@Override
	public void renderHour(){
		GL11.glRotatef( 90, 0, 1, 0);
		GL11.glTranslatef(0f, 0f, 0.125f);
		super.renderHour();
		GL11.glTranslatef(0f, 0f, -.125f);
		GL11.glRotatef(-90, 0, 1, 0);
	}

	@Override
	public String getName(){
		return "clock3";
	}
}