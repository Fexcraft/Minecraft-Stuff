//This File was created with the Minecraft-SMP Modelling Toolbox 2.2.1.1
// Copyright (C) 2016 Minecraft-SMP.de

package net.fexcraft.mod.frsm.blocks.roadsigns;

import net.fexcraft.mod.lib.tmt.ModelConverter;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelRoadSign2 extends ModelConverter {
	
	int textureX = 64;
	int textureY = 64;

	public ModelRoadSign2(){
		
		bodyModel = new ModelRendererTurbo[14];
		bodyModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 1
		bodyModel[2] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 2
		bodyModel[3] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 3
		bodyModel[4] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 4
		bodyModel[5] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 5
		bodyModel[6] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 6
		bodyModel[7] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 7
		bodyModel[8] = new ModelRendererTurbo(this, 41, 41, textureX, textureY); // Box 8
		bodyModel[9] = new ModelRendererTurbo(this, 41, 49, textureX, textureY); // Box 9
		bodyModel[10] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Box 10
		bodyModel[11] = new ModelRendererTurbo(this, 33, 57, textureX, textureY); // Box 11
		bodyModel[12] = new ModelRendererTurbo(this, 49, 57, textureX, textureY); // Box 12
		bodyModel[13] = new ModelRendererTurbo(this, 49, 41, textureX, textureY); // Box 13

		bodyModel[0].addBox(0F, 0F, 0F, 1, 36, 3, 0F); // Box 0
		bodyModel[0].setRotationPoint(-0.5F, -26F, -1.5F);

		bodyModel[1].addBox(0F, 0F, 0F, 1, 36, 1, 0F); // Box 1
		bodyModel[1].setRotationPoint(-1.5F, -26F, -0.5F);

		bodyModel[2].addBox(0F, 0F, 0F, 1, 36, 1, 0F); // Box 2
		bodyModel[2].setRotationPoint(0.5F, -26F, -0.5F);

		bodyModel[3].addShapeBox(0F, 0F, 0F, 1, 36, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 3
		bodyModel[3].setRotationPoint(-1.5F, -26F, -1.5F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 1, 36, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4
		bodyModel[4].setRotationPoint(0.5F, -26F, -1.5F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 36, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 5
		bodyModel[5].setRotationPoint(0.5F, -26F, 0.5F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 1, 36, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 6
		bodyModel[6].setRotationPoint(-1.5F, -26F, 0.5F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 16, 16, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F); // Box 7
		bodyModel[7].setRotationPoint(-11.3F, -25F, -2F);
		bodyModel[7].rotateAngleZ = -0.78539816F;

		bodyModel[8].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F); // Box 8
		bodyModel[8].setRotationPoint(1.25F, -25F, -1F);

		bodyModel[9].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
		bodyModel[9].setRotationPoint(-1.25F, -25F, -1F);

		bodyModel[10].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 10
		bodyModel[10].setRotationPoint(-0.5F, -25F, 1F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F); // Box 11
		bodyModel[11].setRotationPoint(1.25F, -20F, -1F);

		bodyModel[12].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 12
		bodyModel[12].setRotationPoint(-1.25F, -20F, -1F);

		bodyModel[13].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 13
		bodyModel[13].setRotationPoint(-0.5F, -20F, 1F);
		
		translateAll(0F, 14F, 0F);
		
		flipAll();
		
	}
}