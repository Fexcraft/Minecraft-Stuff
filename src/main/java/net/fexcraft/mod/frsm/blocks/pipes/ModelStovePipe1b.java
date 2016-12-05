//This File was created with the Minecraft-SMP Modelling Toolbox 2.2.1.1
// Copyright (C) 2015 Minecraft-SMP.de

package net.fexcraft.mod.frsm.blocks.pipes;

import net.fexcraft.mod.lib.tmt.ModelConverter;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelStovePipe1b extends ModelConverter{
	
	int textureX = 64;
	int textureY = 64;

	public ModelStovePipe1b(){
		
		bodyModel = new ModelRendererTurbo[8];
		bodyModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Box 55
		bodyModel[2] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 56
		bodyModel[3] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 57
		bodyModel[4] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 58
		bodyModel[5] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 59
		bodyModel[6] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 60
		bodyModel[7] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 61

		bodyModel[0].addShapeBox(0F, 0F, 0F, 1, 16, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 0
		bodyModel[0].setRotationPoint(8F, 13.5F, -2.5F);
		bodyModel[0].rotateAngleZ = -1.57079633F;

		bodyModel[1].addBox(0F, 0F, 0F, 3, 16, 1, 0F); // Box 55
		bodyModel[1].setRotationPoint(8F, 14.5F, -2.5F);
		bodyModel[1].rotateAngleZ = -1.57079633F;

		bodyModel[2].addBox(0F, 0F, 0F, 3, 16, 1, 0F); // Box 56
		bodyModel[2].setRotationPoint(8F, 14.5F, 1.5F);
		bodyModel[2].rotateAngleZ = -1.57079633F;

		bodyModel[3].addBox(0F, 0F, 0F, 1, 16, 3, 0F); // Box 57
		bodyModel[3].setRotationPoint(8F, 13.5F, -1.5F);
		bodyModel[3].rotateAngleZ = -1.57079633F;

		bodyModel[4].addBox(0F, 0F, 0F, 1, 16, 3, 0F); // Box 58
		bodyModel[4].setRotationPoint(8F, 17.5F, -1.5F);
		bodyModel[4].rotateAngleZ = -1.57079633F;

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 16, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 59
		bodyModel[5].setRotationPoint(8F, 17.5F, -2.5F);
		bodyModel[5].rotateAngleZ = -1.57079633F;

		bodyModel[6].addShapeBox(0F, 0F, 0F, 1, 16, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 60
		bodyModel[6].setRotationPoint(8F, 17.5F, 1.5F);
		bodyModel[6].rotateAngleZ = -1.57079633F;

		bodyModel[7].addShapeBox(0F, 0F, 0F, 1, 16, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 61
		bodyModel[7].setRotationPoint(8F, 13.5F, 1.5F);
		bodyModel[7].rotateAngleZ = -1.57079633F;

		translateAll(0F, -32F, 0F);

		flipAll();
		
	}
}