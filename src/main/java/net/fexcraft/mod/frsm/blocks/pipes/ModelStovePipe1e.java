//This File was created with the Minecraft-SMP Modelling Toolbox 2.2.1.1
// Copyright (C) 2015 Minecraft-SMP.de

package net.fexcraft.mod.frsm.blocks.pipes;

import net.fexcraft.mod.lib.tmt.ModelConverter;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelStovePipe1e extends ModelConverter {
	
	int textureX = 64;
	int textureY = 64;

	public ModelStovePipe1e(){
		
		bodyModel = new ModelRendererTurbo[24];
		bodyModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Box 55
		bodyModel[2] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 56
		bodyModel[3] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 57
		bodyModel[4] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 58
		bodyModel[5] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 59
		bodyModel[6] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 60
		bodyModel[7] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 61
		bodyModel[8] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		bodyModel[9] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Box 55
		bodyModel[10] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 56
		bodyModel[11] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 57
		bodyModel[12] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 58
		bodyModel[13] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 59
		bodyModel[14] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 60
		bodyModel[15] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 61
		bodyModel[16] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 0
		bodyModel[17] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 1
		bodyModel[18] = new ModelRendererTurbo(this, 43, 5, textureX, textureY); // Box 2
		bodyModel[19] = new ModelRendererTurbo(this, 43, 5, textureX, textureY); // Box 3
		bodyModel[20] = new ModelRendererTurbo(this, 19, 21, textureX, textureY); // Box 4
		bodyModel[21] = new ModelRendererTurbo(this, 19, 21, textureX, textureY); // Box 5
		bodyModel[22] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 6
		bodyModel[23] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 7

		bodyModel[0].addShapeBox(0F, 0F, 0F, 1, 8, 1, 0F, -1F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 0
		bodyModel[0].setRotationPoint(-2.5F, 16F, -2.5F);

		bodyModel[1].addShapeBox(0F, 0F, 0F, 3, 8, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 55
		bodyModel[1].setRotationPoint(-1.5F, 16F, -2.5F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 3, 8, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 56
		bodyModel[2].setRotationPoint(-1.5F, 16F, 1.5F);

		bodyModel[3].addShapeBox(0F, 0F, 0F, 1, 8, 3, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 57
		bodyModel[3].setRotationPoint(-2.5F, 16F, -1.5F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 1, 6, 3, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 58
		bodyModel[4].setRotationPoint(1.5F, 18F, -1.5F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 59
		bodyModel[5].setRotationPoint(1.5F, 18F, -2.5F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 60
		bodyModel[6].setRotationPoint(1.5F, 18F, 1.5F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 1, 8, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 61
		bodyModel[7].setRotationPoint(-2.5F, 16F, 1.5F);

		bodyModel[8].addShapeBox(0F, 0F, 0F, 1, 8, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 0
		bodyModel[8].setRotationPoint(8F, 13.5F, -2.5F);
		bodyModel[8].rotateAngleZ = -1.57079633F;

		bodyModel[9].addShapeBox(0F, 0F, 0F, 3, 7, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 55
		bodyModel[9].setRotationPoint(8F, 14.5F, -2.5F);
		bodyModel[9].rotateAngleZ = -1.57079633F;

		bodyModel[10].addShapeBox(0F, 0F, 0F, 3, 7, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 56
		bodyModel[10].setRotationPoint(8F, 14.5F, 1.5F);
		bodyModel[10].rotateAngleZ = -1.57079633F;

		bodyModel[11].addShapeBox(0F, 0F, 0F, 1, 8, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 57
		bodyModel[11].setRotationPoint(8F, 13.5F, -1.5F);
		bodyModel[11].rotateAngleZ = -1.57079633F;

		bodyModel[12].addShapeBox(0F, 0F, 0F, 1, 6, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 58
		bodyModel[12].setRotationPoint(8F, 17.5F, -1.5F);
		bodyModel[12].rotateAngleZ = -1.57079633F;

		bodyModel[13].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 59
		bodyModel[13].setRotationPoint(8F, 17.5F, -2.5F);
		bodyModel[13].rotateAngleZ = -1.57079633F;

		bodyModel[14].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 60
		bodyModel[14].setRotationPoint(8F, 17.5F, 1.5F);
		bodyModel[14].rotateAngleZ = -1.57079633F;

		bodyModel[15].addShapeBox(0F, 0F, 0F, 1, 8, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -1F, -0.5F, 0F); // Box 61
		bodyModel[15].setRotationPoint(8F, 13.5F, 1.5F);
		bodyModel[15].rotateAngleZ = -1.57079633F;

		bodyModel[16].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 0
		bodyModel[16].setRotationPoint(1.5F, 17.5F, -1.5F);

		bodyModel[17].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 1
		bodyModel[17].setRotationPoint(-0.5F, 13.5F, -1.5F);

		bodyModel[18].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, -1F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 2
		bodyModel[18].setRotationPoint(-0.5F, 13.5F, -2.5F);

		bodyModel[19].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F); // Box 3
		bodyModel[19].setRotationPoint(-0.5F, 13.5F, 1.5F);

		bodyModel[20].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4
		bodyModel[20].setRotationPoint(1.5F, 17.5F, -2.5F);

		bodyModel[21].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 5
		bodyModel[21].setRotationPoint(1.5F, 17.5F, 1.5F);

		bodyModel[22].addShapeBox(0F, 0F, 0F, 3, 2, 1, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 6
		bodyModel[22].setRotationPoint(-1.5F, 14.5F, 1.5F);

		bodyModel[23].addShapeBox(0F, 0F, 0F, 3, 2, 1, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 7
		bodyModel[23].setRotationPoint(-1.5F, 14.5F, -2.5F);
		
		translateAll(0F, 0F, 0F);
		
		flipAll();
		
	}
}