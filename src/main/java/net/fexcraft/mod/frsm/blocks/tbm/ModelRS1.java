//This File was created with the Minecraft-SMP Modelling Toolbox 2.2.2.2
// Copyright (C) 2016 Minecraft-SMP.de

// Model: RS1
// Model Creator: FEX___96
// Created on: 10.04.2016 - 15:25:04
// Last changed on: 10.04.2016 - 15:25:04

package net.fexcraft.mod.frsm.blocks.tbm;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelRS1 extends ModelBase {
	
	int textureX = 32;
	int textureY = 32;

	public ModelRS1(){
		base = new ModelRendererTurbo[3];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		base[1] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 1
		base[2] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 2

		base[0].addBox(0F, 0F, 0F, 14, 6, 1, 0F); // Box 0
		base[0].setRotationPoint(2F, -11.1F, 8.5F);

		base[1].addBox(0F, 0F, 0F, 2, 11, 2, 0F); // Box 1
		base[1].setRotationPoint(7F, -11F, 7F);

		base[2].addShapeBox(0F, 0F, 0F, 4, 6, 1, 0F, 0F, -2.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2.5F, 0F, 0F, -2.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2.5F, 0F); // Box 2
		base[2].setRotationPoint(-2F, -11.1F, 8.5F);
	}
}