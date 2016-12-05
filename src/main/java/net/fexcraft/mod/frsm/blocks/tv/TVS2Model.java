//This File was created with the Minecraft-SMP Modelling Toolbox 2.2.2.2
// Copyright (C) 2016 Minecraft-SMP.de

// Model: TVS2
// Model Creator: FEX___96
// Created on: 09.04.2016 - 22:29:00
// Last changed on: 09.04.2016 - 22:29:00

package net.fexcraft.mod.frsm.blocks.tv;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class TVS2Model extends ModelBase {
	
	int textureX = 64;
	int textureY = 64;

	public TVS2Model(){
		base = new ModelRendererTurbo[10];
		base[0] = new ModelRendererTurbo(this, 1, 54, textureX, textureY); // Box 0
		base[1] = new ModelRendererTurbo(this, 37, 36, textureX, textureY); // Box 1
		base[2] = new ModelRendererTurbo(this, 1, 11, textureX, textureY); // Box 2
		base[3] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 3
		base[4] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 4
		base[5] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 5
		base[6] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 6
		base[7] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 7
		base[8] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 8
		base[9] = new ModelRendererTurbo(this, 33, 25, textureX, textureY); // Box 9

		base[0].addShapeBox(0F, 0F, 0F, 12, 1, 6, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 0
		base[0].setRotationPoint(2F, -1F, 6F);

		base[1].addBox(0F, 0F, 0F, 8, 3, 2, 0F); // Box 1
		base[1].setRotationPoint(4F, -3F, 4F);

		base[2].addShapeBox(0F, 0F, 0F, 14, 6, 6, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 2
		base[2].setRotationPoint(1F, -7F, 5.5F);

		base[3].addShapeBox(0F, 0F, 0F, 10, 6, 3, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 3
		base[3].setRotationPoint(3F, -8F, 2.5F);

		base[4].addBox(0F, 0F, 0F, 14, 1, 2, 0F); // Box 4
		base[4].setRotationPoint(1F, -2F, 11.5F);

		base[5].addBox(0F, 0F, 0F, 14, 1, 2, 0F); // Box 5
		base[5].setRotationPoint(1F, -11F, 11.5F);

		base[6].addBox(0F, 0F, 0F, 1, 8, 2, 0F); // Box 6
		base[6].setRotationPoint(1F, -10F, 11.5F);

		base[7].addBox(0F, 0F, 0F, 1, 8, 2, 0F); // Box 7
		base[7].setRotationPoint(14F, -10F, 11.5F);

		base[8].addShapeBox(0F, 0F, 0F, 14, 4, 6, 0F, -2F, -3F, 0F, -2F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 8
		base[8].setRotationPoint(1F, -11F, 5.5F);

		base[9].addBox(0F, 0F, 0F, 12, 8, 2, 0F); // Box 9
		base[9].setRotationPoint(2F, -10F, 11F);
	}
}