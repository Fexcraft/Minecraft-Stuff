//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de
// This file is for Fex's Vehicle Mod

// Model: DisplayBlock
// Model Creator: FEX___96
// Created on: 15.02.2017 - 21:22:12
// Last changed on: 15.02.2017 - 21:22:12

package net.fexcraft.mod.fvm.models.block;

import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.util.ResourceLocation;

public class ModelDisplayBlock extends ModelBase {
	
	int textureX = 32;
	int textureY = 32;

	public ModelDisplayBlock(){
		base = new ModelRendererTurbo[36];
		base[0] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 0
		base[1] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 2
		base[2] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 3
		base[3] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 4
		base[4] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 5
		base[5] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 6
		base[6] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 7
		base[7] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 8
		base[8] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 9
		base[9] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 10
		base[10] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 11
		base[11] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 12
		base[12] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 13
		base[13] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 14
		base[14] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 15
		base[15] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 16
		base[16] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 17
		base[17] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 18
		base[18] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 19
		base[19] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 20
		base[20] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 21
		base[21] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 22
		base[22] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 23
		base[23] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 24
		base[24] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 25
		base[25] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 26
		base[26] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 27
		base[27] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 28
		base[28] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 29
		base[29] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 30
		base[30] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 31
		base[31] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 32
		base[32] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 33
		base[33] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 34
		base[34] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 35
		base[35] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 36

		base[0].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 0
		base[0].setRotationPoint(0F, 0F, 0F);

		base[1].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 2
		base[1].setRotationPoint(0F, 0F, 0F);
		base[1].rotateAngleY = -0.17453293F;

		base[2].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 3
		base[2].setRotationPoint(0F, 0F, 0F);
		base[2].rotateAngleY = -0.34906585F;

		base[3].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 4
		base[3].setRotationPoint(0F, 0F, 0F);
		base[3].rotateAngleY = -0.52359878F;

		base[4].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 5
		base[4].setRotationPoint(0F, 0F, 0F);
		base[4].rotateAngleY = -0.6981317F;

		base[5].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 6
		base[5].setRotationPoint(0F, 0F, 0F);
		base[5].rotateAngleY = -0.87266463F;

		base[6].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 7
		base[6].setRotationPoint(0F, 0F, 0F);
		base[6].rotateAngleY = -1.04719755F;

		base[7].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 8
		base[7].setRotationPoint(0F, 0F, 0F);
		base[7].rotateAngleY = -1.22173048F;

		base[8].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 9
		base[8].setRotationPoint(0F, 0F, 0F);
		base[8].rotateAngleY = -1.3962634F;

		base[9].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 10
		base[9].setRotationPoint(0F, 0F, 0F);
		base[9].rotateAngleY = -1.57079633F;

		base[10].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 11
		base[10].setRotationPoint(0F, 0F, 0F);
		base[10].rotateAngleY = -1.74532925F;

		base[11].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 12
		base[11].setRotationPoint(0F, 0F, 0F);
		base[11].rotateAngleY = -1.91986218F;

		base[12].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 13
		base[12].setRotationPoint(0F, 0F, 0F);
		base[12].rotateAngleY = -2.0943951F;

		base[13].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 14
		base[13].setRotationPoint(0F, 0F, 0F);
		base[13].rotateAngleY = -2.26892803F;

		base[14].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 15
		base[14].setRotationPoint(0F, 0F, 0F);
		base[14].rotateAngleY = -2.44346095F;

		base[15].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 16
		base[15].setRotationPoint(0F, 0F, 0F);
		base[15].rotateAngleY = -2.61799388F;

		base[16].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 17
		base[16].setRotationPoint(0F, 0F, 0F);
		base[16].rotateAngleY = -2.7925268F;

		base[17].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 18
		base[17].setRotationPoint(0F, 0F, 0F);
		base[17].rotateAngleY = -2.96705973F;

		base[18].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 19
		base[18].setRotationPoint(0F, 0F, 0F);
		base[18].rotateAngleY = -3.14159265F;

		base[19].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 20
		base[19].setRotationPoint(0F, 0F, 0F);
		base[19].rotateAngleY = -3.31612558F;

		base[20].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 21
		base[20].setRotationPoint(0F, 0F, 0F);
		base[20].rotateAngleY = -3.4906585F;

		base[21].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 22
		base[21].setRotationPoint(0F, 0F, 0F);
		base[21].rotateAngleY = -3.66519143F;

		base[22].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 23
		base[22].setRotationPoint(0F, 0F, 0F);
		base[22].rotateAngleY = -3.83972435F;

		base[23].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 24
		base[23].setRotationPoint(0F, 0F, 0F);
		base[23].rotateAngleY = -4.01425728F;

		base[24].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 25
		base[24].setRotationPoint(0F, 0F, 0F);
		base[24].rotateAngleY = -4.1887902F;

		base[25].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 26
		base[25].setRotationPoint(0F, 0F, 0F);
		base[25].rotateAngleY = -4.36332313F;

		base[26].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 27
		base[26].setRotationPoint(0F, 0F, 0F);
		base[26].rotateAngleY = -4.53785606F;

		base[27].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 28
		base[27].setRotationPoint(0F, 0F, 0F);
		base[27].rotateAngleY = -4.71238898F;

		base[28].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 29
		base[28].setRotationPoint(0F, 0F, 0F);
		base[28].rotateAngleY = -4.88692191F;

		base[29].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 30
		base[29].setRotationPoint(0F, 0F, 0F);
		base[29].rotateAngleY = -5.06145483F;

		base[30].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 31
		base[30].setRotationPoint(0F, 0F, 0F);
		base[30].rotateAngleY = -5.23598776F;

		base[31].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 32
		base[31].setRotationPoint(0F, 0F, 0F);
		base[31].rotateAngleY = -5.41052068F;

		base[32].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 33
		base[32].setRotationPoint(0F, 0F, 0F);
		base[32].rotateAngleY = -5.58505361F;

		base[33].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 34
		base[33].setRotationPoint(0F, 0F, 0F);
		base[33].rotateAngleY = -5.75958653F;

		base[34].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 35
		base[34].setRotationPoint(0F, 0F, 0F);
		base[34].rotateAngleY = -5.93411946F;

		base[35].addShapeBox(0F, -1F, 6F, 1, 1, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0.1F, 0.4F, 0F, -0.1F, 0F, 0F, 0F); // Box 36
		base[35].setRotationPoint(0F, 0F, 0F);
		base[35].rotateAngleY = -6.10865238F;

		r0 = new ModelRendererTurbo[2];
		r0[0] = new ModelRendererTurbo(this, 9, 0, textureX, textureY); // Box 37
		r0[1] = new ModelRendererTurbo(this, 9, 0, textureX, textureY); // Box 38

		r0[0].addShapeBox(0F, -1.5F, 5.5F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F); // Box 37
		r0[0].setRotationPoint(0F, 0F, 0F);
		r0[0].rotateAngleY = -3.14159265F;

		r0[1].addShapeBox(-1F, -1.5F, 5.5F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F); // Box 38
		r0[1].setRotationPoint(0F, 0F, 0F);
		r0[1].rotateAngleY = -3.14159265F;
		
		translateAll(0F, 24F, 0F);
		
	}
	
	private static final ResourceLocation texture = new ResourceLocation(FvmResources.MODID, "textures/blocks/displayblock.png");

	public ResourceLocation getTexture(){
		return texture;
	}
	
}