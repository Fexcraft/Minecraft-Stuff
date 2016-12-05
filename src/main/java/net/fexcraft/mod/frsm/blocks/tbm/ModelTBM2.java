//This File was created with the Minecraft-SMP Modelling Toolbox 2.2.2.2
// Copyright (C) 2016 Minecraft-SMP.de

// Model: TBM2
// Model Creator: FEX___96
// Created on: 13.04.2016 - 18:28:04
// Last changed on: 13.04.2016 - 18:28:04

package net.fexcraft.mod.frsm.blocks.tbm;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelTBM2 extends ModelBase {
	
	int textureX = 64;
	int textureY = 64;

	public ModelTBM2(){
		
		base = new ModelRendererTurbo[20];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		base[1] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 1
		base[2] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 2
		base[3] = new ModelRendererTurbo(this, 41, 9, textureX, textureY); // Box 3
		base[4] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 4
		base[5] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 5
		base[6] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 6
		base[7] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 7
		base[8] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 8
		base[9] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 9
		base[10] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 10
		base[11] = new ModelRendererTurbo(this, 17, 25, textureX, textureY); // Box 11
		base[12] = new ModelRendererTurbo(this, 33, 25, textureX, textureY); // Box 12
		base[13] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 13
		base[14] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 14
		base[15] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 15
		base[16] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Box 16
		base[17] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 17
		base[18] = new ModelRendererTurbo(this, 17, 41, textureX, textureY); // Box 18
		base[19] = new ModelRendererTurbo(this, 33, 41, textureX, textureY); // Box 19

		base[0].addBox(0F, 0F, 0F, 2, 2, 6, 0F); // Box 0
		base[0].setRotationPoint(2F, -2F, 5F);

		base[1].addBox(0F, 0F, 0F, 2, 2, 6, 0F); // Box 1
		base[1].setRotationPoint(12F, -2F, 5F);

		base[2].addBox(0F, 0F, 0F, 6, 2, 2, 0F); // Box 2
		base[2].setRotationPoint(5F, -2F, 2F);

		base[3].addBox(0F, 0F, 0F, 6, 2, 2, 0F); // Box 3
		base[3].setRotationPoint(5F, -2F, 12F);

		base[4].addShapeBox(0F, 0F, 0F, 2, 2, 3, 0F, -3F, 0F, 0F, 1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4
		base[4].setRotationPoint(2F, -2F, 2F);

		base[5].addShapeBox(0F, 0F, 0F, 2, 2, 3, 0F, 1F, 0F, -2F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -2F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 5
		base[5].setRotationPoint(12F, -2F, 2F);

		base[6].addShapeBox(0F, 0F, 0F, 2, 2, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 1F, 0F, -2F); // Box 6
		base[6].setRotationPoint(12F, -2F, 11F);

		base[7].addShapeBox(0F, 0F, 0F, 2, 2, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -2F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -2F, -3F, 0F, 0F); // Box 7
		base[7].setRotationPoint(2F, -2F, 11F);

		base[8].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, 0F, -0.6F, -0.2F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.6F, -0.2F, 0F, -0.6F, -0.2F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.6F, -0.2F); // Box 8
		base[8].setRotationPoint(-1F, -2F, 7F);

		base[9].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, 0F, -0.2F, 0F, 0F, -0.6F, -0.2F, 0F, -0.6F, -0.2F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.6F, -0.2F, 0F, -0.6F, -0.2F, 0F, -0.2F, 0F); // Box 9
		base[9].setRotationPoint(14F, -2F, 7F);

		base[10].addShapeBox(0F, 0F, 0F, 2, 2, 3, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.2F, -0.6F, 0F, -0.2F, -0.6F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.2F, -0.6F, 0F, -0.2F, -0.6F, 0F); // Box 10
		base[10].setRotationPoint(7F, -2F, 14F);

		base[11].addShapeBox(0F, 0F, 0F, 2, 2, 3, 0F, -0.2F, -0.6F, 0F, -0.2F, -0.6F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.2F, -0.6F, 0F, -0.2F, -0.6F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F); // Box 11
		base[11].setRotationPoint(7F, -2F, -1F);

		base[12].addShapeBox(0F, 0F, 0F, 2, 2, 3, 0F, -0.2F, -0.6F, 0F, -0.2F, -0.6F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.2F, -0.6F, 0F, -0.2F, -0.6F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F); // Box 12
		base[12].setRotationPoint(13.6F, -2F, 1F);
		base[12].rotateAngleY = -0.78539816F;

		base[13].addShapeBox(0F, 0F, 0F, 2, 2, 3, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.2F, -0.6F, 0F, -0.2F, -0.6F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.2F, -0.6F, 0F, -0.2F, -0.6F, 0F); // Box 13
		base[13].setRotationPoint(11.6F, -2F, 13F);
		base[13].rotateAngleY = 0.78539816F;

		base[14].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, 0F, -0.6F, -0.2F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.6F, -0.2F, 0F, -0.6F, -0.2F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.6F, -0.2F); // Box 14
		base[14].setRotationPoint(1F, -2F, 13.6F);
		base[14].rotateAngleY = 0.78539816F;

		base[15].addShapeBox(0F, 0F, 0F, 2, 2, 3, 0F, -0.2F, -0.6F, 0F, -0.2F, -0.6F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.2F, -0.6F, 0F, -0.2F, -0.6F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F); // Box 15
		base[15].setRotationPoint(1F, -2F, 2.6F);
		base[15].rotateAngleY = 0.78539816F;

		base[16].addBox(0F, 0F, 0F, 8, 1, 2, 0F); // Box 16
		base[16].setRotationPoint(4F, -1.5F, 7F);

		base[17].addBox(0F, 0F, 0F, 2, 1, 3, 0F); // Box 17
		base[17].setRotationPoint(7F, -1.5F, 4F);

		base[18].addBox(0F, 0F, 0F, 2, 1, 3, 0F); // Box 18
		base[18].setRotationPoint(7F, -1.5F, 9F);

		base[19].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 19
		base[19].setRotationPoint(6.5F, -2F, 8F);
		base[19].rotateAngleY = 0.78539816F;

		translateAll(0F, 0F, 0F);

	}
}