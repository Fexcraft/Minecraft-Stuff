package net.fexcraft.mod.ftm.models;

import net.fexcraft.mod.lib.tmt.ModelConverter;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelCart extends ModelConverter {
	int textureX = 128;
	int textureY = 64;

	public ModelCart(){
		bodyModel = new ModelRendererTurbo[20];
		bodyModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 1
		bodyModel[2] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 2
		bodyModel[3] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 3
		bodyModel[4] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 4
		bodyModel[5] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 6
		bodyModel[6] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 7
		bodyModel[7] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 8
		bodyModel[8] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 9
		bodyModel[9] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 10
		bodyModel[10] = new ModelRendererTurbo(this, 105, 1, textureX, textureY); // Box 11
		bodyModel[11] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 12
		bodyModel[12] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 13
		bodyModel[13] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 14
		bodyModel[14] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 15
		bodyModel[15] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 16
		bodyModel[16] = new ModelRendererTurbo(this, 73, 25, textureX, textureY); // Box 17
		bodyModel[17] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 18
		bodyModel[18] = new ModelRendererTurbo(this, 73, 33, textureX, textureY); // Box 19
		bodyModel[19] = new ModelRendererTurbo(this, 41, 41, textureX, textureY); // Box 20

		bodyModel[0].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 0
		bodyModel[0].setRotationPoint(8F, -8F, -7F);

		bodyModel[1].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 1
		bodyModel[1].setRotationPoint(10F, -8F, -7F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 2
		bodyModel[2].setRotationPoint(7F, -8F, -7F);

		bodyModel[3].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 3
		bodyModel[3].setRotationPoint(8F, -8F, 5F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 4
		bodyModel[4].setRotationPoint(7F, -8F, 5F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 6
		bodyModel[5].setRotationPoint(10F, -8F, 5F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 7
		bodyModel[6].setRotationPoint(-8F, -8F, 5F);

		bodyModel[7].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 8
		bodyModel[7].setRotationPoint(-10F, -8F, 5F);

		bodyModel[8].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 9
		bodyModel[8].setRotationPoint(-11F, -8F, 5F);

		bodyModel[9].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 10
		bodyModel[9].setRotationPoint(-11F, -8F, -7F);

		bodyModel[10].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 11
		bodyModel[10].setRotationPoint(-10F, -8F, -7F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 12
		bodyModel[11].setRotationPoint(-8F, -8F, -7F);

		bodyModel[12].addBox(0F, 0F, 0F, 1, 1, 10, 0F); // Box 13
		bodyModel[12].setRotationPoint(8.5F, -6.5F, -5F);

		bodyModel[13].addBox(0F, 0F, 0F, 1, 1, 10, 0F); // Box 14
		bodyModel[13].setRotationPoint(-9.5F, -6.5F, -5F);

		bodyModel[14].addShapeBox(0F, 0F, 0F, 26, 3, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3.5F, 0F, -1F, -3.5F, 0F, -1F, -3.5F, 0F, -1F, -3.5F, 0F, -1F); // Box 15
		bodyModel[14].setRotationPoint(-13F, -9F, -5F);

		bodyModel[15].addBox(0F, 0F, 0F, 26, 1, 14, 0F); // Box 16
		bodyModel[15].setRotationPoint(-13F, -10F, -7F);

		bodyModel[16].addBox(0F, 0F, 0F, 24, 6, 1, 0F); // Box 17
		bodyModel[16].setRotationPoint(-12F, -16F, -7F);

		bodyModel[17].addBox(0F, 0F, 0F, 24, 6, 1, 0F); // Box 18
		bodyModel[17].setRotationPoint(-12F, -16F, 6F);

		bodyModel[18].addBox(0F, 0F, 0F, 1, 6, 14, 0F); // Box 19
		bodyModel[18].setRotationPoint(-13F, -16F, -7F);

		bodyModel[19].addBox(0F, 0F, 0F, 1, 6, 14, 0F); // Box 20
		bodyModel[19].setRotationPoint(12F, -16F, -7F);

		translateAll(0F, 7F, 0F);


		//flipAll();
	}
}