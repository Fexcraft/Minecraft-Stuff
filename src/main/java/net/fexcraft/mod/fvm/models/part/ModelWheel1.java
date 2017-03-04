//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de
// This file is for Fex's Vehicle Mod

// Model: Wheel1
// Model Creator: FEX___96
// Created on: 16.02.2017 - 16:04:16
// Last changed on: 16.02.2017 - 16:04:16

package net.fexcraft.mod.fvm.models.part;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvm.data.VehicleType;
import net.fexcraft.mod.fvm.models.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelWheel1 extends PartModel {
	int textureX = 512;
	int textureY = 512;

	public ModelWheel1(){
		wheel_front_left = new ModelRendererTurbo[36];
		wheel_front_left[0] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 1
		wheel_front_left[1] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 2
		wheel_front_left[2] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 3
		wheel_front_left[3] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 4
		wheel_front_left[4] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 5
		wheel_front_left[5] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 6
		wheel_front_left[6] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 7
		wheel_front_left[7] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 8
		wheel_front_left[8] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 9
		wheel_front_left[9] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 10
		wheel_front_left[10] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 11
		wheel_front_left[11] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 12
		wheel_front_left[12] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 13
		wheel_front_left[13] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 14
		wheel_front_left[14] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 15
		wheel_front_left[15] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 16
		wheel_front_left[16] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 17
		wheel_front_left[17] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 18
		wheel_front_left[18] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 19
		wheel_front_left[19] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 20
		wheel_front_left[20] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 21
		wheel_front_left[21] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 22
		wheel_front_left[22] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 23
		wheel_front_left[23] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 24
		wheel_front_left[24] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 25
		wheel_front_left[25] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 26
		wheel_front_left[26] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 27
		wheel_front_left[27] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 28
		wheel_front_left[28] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 29
		wheel_front_left[29] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 30
		wheel_front_left[30] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 31
		wheel_front_left[31] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 32
		wheel_front_left[32] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 33
		wheel_front_left[33] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 34
		wheel_front_left[34] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 35
		wheel_front_left[35] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 36

		wheel_front_left[0].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 1
		wheel_front_left[0].setRotationPoint(0F, -10F, 0F);

		wheel_front_left[1].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 2
		wheel_front_left[1].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[1].rotateAngleZ = -0.17453293F;

		wheel_front_left[2].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 3
		wheel_front_left[2].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[2].rotateAngleZ = -0.34906585F;

		wheel_front_left[3].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 4
		wheel_front_left[3].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[3].rotateAngleZ = -0.52359878F;

		wheel_front_left[4].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 5
		wheel_front_left[4].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[4].rotateAngleZ = -0.6981317F;

		wheel_front_left[5].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 6
		wheel_front_left[5].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[5].rotateAngleZ = -0.87266463F;

		wheel_front_left[6].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 7
		wheel_front_left[6].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[6].rotateAngleZ = -1.04719755F;

		wheel_front_left[7].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 8
		wheel_front_left[7].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[7].rotateAngleZ = -1.22173048F;

		wheel_front_left[8].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 9
		wheel_front_left[8].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[8].rotateAngleZ = -1.3962634F;

		wheel_front_left[9].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 10
		wheel_front_left[9].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[9].rotateAngleZ = -1.57079633F;

		wheel_front_left[10].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 11
		wheel_front_left[10].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[10].rotateAngleZ = -1.74532925F;

		wheel_front_left[11].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 12
		wheel_front_left[11].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[11].rotateAngleZ = -1.91986218F;

		wheel_front_left[12].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 13
		wheel_front_left[12].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[12].rotateAngleZ = -2.0943951F;

		wheel_front_left[13].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 14
		wheel_front_left[13].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[13].rotateAngleZ = -2.26892803F;

		wheel_front_left[14].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 15
		wheel_front_left[14].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[14].rotateAngleZ = -2.44346095F;

		wheel_front_left[15].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 16
		wheel_front_left[15].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[15].rotateAngleZ = -2.61799388F;

		wheel_front_left[16].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 17
		wheel_front_left[16].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[16].rotateAngleZ = -2.7925268F;

		wheel_front_left[17].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 18
		wheel_front_left[17].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[17].rotateAngleZ = -2.96705973F;

		wheel_front_left[18].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 19
		wheel_front_left[18].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[18].rotateAngleZ = -3.14159265F;

		wheel_front_left[19].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 20
		wheel_front_left[19].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[19].rotateAngleZ = -3.31612558F;

		wheel_front_left[20].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 21
		wheel_front_left[20].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[20].rotateAngleZ = -3.4906585F;

		wheel_front_left[21].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 22
		wheel_front_left[21].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[21].rotateAngleZ = -3.66519143F;

		wheel_front_left[22].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 23
		wheel_front_left[22].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[22].rotateAngleZ = -3.83972435F;

		wheel_front_left[23].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 24
		wheel_front_left[23].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[23].rotateAngleZ = -4.01425728F;

		wheel_front_left[24].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 25
		wheel_front_left[24].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[24].rotateAngleZ = -4.1887902F;

		wheel_front_left[25].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 26
		wheel_front_left[25].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[25].rotateAngleZ = -4.36332313F;

		wheel_front_left[26].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 27
		wheel_front_left[26].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[26].rotateAngleZ = -4.53785606F;

		wheel_front_left[27].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 28
		wheel_front_left[27].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[27].rotateAngleZ = -4.71238898F;

		wheel_front_left[28].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 29
		wheel_front_left[28].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[28].rotateAngleZ = -4.88692191F;

		wheel_front_left[29].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 30
		wheel_front_left[29].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[29].rotateAngleZ = -5.06145483F;

		wheel_front_left[30].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 31
		wheel_front_left[30].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[30].rotateAngleZ = -5.23598776F;

		wheel_front_left[31].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 32
		wheel_front_left[31].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[31].rotateAngleZ = -5.41052068F;

		wheel_front_left[32].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 33
		wheel_front_left[32].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[32].rotateAngleZ = -5.58505361F;

		wheel_front_left[33].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 34
		wheel_front_left[33].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[33].rotateAngleZ = -5.75958653F;

		wheel_front_left[34].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 35
		wheel_front_left[34].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[34].rotateAngleZ = -5.93411946F;

		wheel_front_left[35].addShapeBox(0F, 8F, -3F, 2, 3, 6, 0F, 0F, 0F, 0F, -0.5F, 0.15F, 0F, -0.5F, 0.15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F); // Box 36
		wheel_front_left[35].setRotationPoint(0F, -10F, 0F);
		wheel_front_left[35].rotateAngleZ = -6.10865238F;

		//translateAll(0F, 0F, 0F);

		//flipAll();	
	}
	
	@Override
	public void render(VehicleType type, String us){
		GL11.glPushMatrix();
		GL11.glScalef(0.9f, 0.9f, 0.9f);
		rotate(wheel_front_left, 0, 0, 0.0174533f);
		render(wheel_front_left);
		GL11.glPopMatrix();
	}
	
}