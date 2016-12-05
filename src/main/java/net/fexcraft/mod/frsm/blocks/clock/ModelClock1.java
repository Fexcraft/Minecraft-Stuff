//This File was created with the Minecraft-SMP Modelling Toolbox 2.2.2.2
// Copyright (C) 2016 Minecraft-SMP.de

// Model: Clock1
// Model Creator: FEX___96
// Created on: 06.04.2016 - 22:40:27
// Last changed on: 06.04.2016 - 22:40:27

package net.fexcraft.mod.frsm.blocks.clock;

import net.fexcraft.mod.lib.tmt.ModelConverter;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelClock1 extends ModelConverter{
	
	int textureX = 128;
	int textureY = 64;

	public ModelClock1(){
		
		bodyModel = new ModelRendererTurbo[38];
		bodyModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 1
		bodyModel[2] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 2
		bodyModel[3] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 3
		bodyModel[4] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 4
		bodyModel[5] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 5
		bodyModel[6] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 6
		bodyModel[7] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 7
		bodyModel[8] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 8
		bodyModel[9] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 9
		bodyModel[10] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 10
		bodyModel[11] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 11
		bodyModel[12] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // Box 12
		bodyModel[13] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 13
		bodyModel[14] = new ModelRendererTurbo(this, 89, 9, textureX, textureY); // Box 14
		bodyModel[15] = new ModelRendererTurbo(this, 105, 9, textureX, textureY); // Box 15
		bodyModel[16] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 16
		bodyModel[17] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 17
		bodyModel[18] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 18
		bodyModel[19] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 19
		bodyModel[20] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 20
		bodyModel[21] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 21
		bodyModel[22] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 22
		bodyModel[23] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 23
		bodyModel[24] = new ModelRendererTurbo(this, 121, 9, textureX, textureY); // Box 24
		bodyModel[25] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 25
		bodyModel[26] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 26
		bodyModel[27] = new ModelRendererTurbo(this, 73, 25, textureX, textureY); // Box 27
		bodyModel[28] = new ModelRendererTurbo(this, 81, 25, textureX, textureY); // Box 28
		bodyModel[29] = new ModelRendererTurbo(this, 89, 25, textureX, textureY); // Box 29
		bodyModel[30] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 30
		bodyModel[31] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 31
		bodyModel[32] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 32
		bodyModel[33] = new ModelRendererTurbo(this, 9, 33, textureX, textureY); // Box 33
		bodyModel[34] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 34
		bodyModel[35] = new ModelRendererTurbo(this, 25, 33, textureX, textureY); // Box 35
		bodyModel[36] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 37
		bodyModel[37] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 40

		bodyModel[0].addBox(0F, 0F, 0F, 3, 1, 6, 0F); // Box 0
		bodyModel[0].setRotationPoint(-8F, -1F, -3F);

		bodyModel[1].addBox(0F, 0F, 0F, 3, 1, 6, 0F); // Box 1
		bodyModel[1].setRotationPoint(-8F, -16F, -3F);

		bodyModel[2].addBox(0F, 0F, 0F, 3, 6, 1, 0F); // Box 2
		bodyModel[2].setRotationPoint(-8F, -11F, 7F);

		bodyModel[3].addBox(0F, 0F, 0F, 3, 6, 1, 0F); // Box 3
		bodyModel[3].setRotationPoint(-8F, -11F, -8F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, 2F, 0F, 0F, 2F, 0F); // Box 4
		bodyModel[4].setRotationPoint(-8F, -3F, -6F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F, 0F, -1F, 1.5F, 0F, -1F, 1.5F); // Box 5
		bodyModel[5].setRotationPoint(-8F, -5F, -8F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F); // Box 6
		bodyModel[6].setRotationPoint(-8F, -3F, 3F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 7
		bodyModel[7].setRotationPoint(-8F, -14F, 3F);

		bodyModel[8].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -2F, 0F, 0F, -2F, 0F); // Box 8
		bodyModel[8].setRotationPoint(-8F, -14F, -6F);

		bodyModel[9].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F, 0F, -1F, 1.5F, 0F, -1F, 1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
		bodyModel[9].setRotationPoint(-8F, -14F, -8F);

		bodyModel[10].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, -1F, 1.5F, 0F, -1F, 1.5F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
		bodyModel[10].setRotationPoint(-8F, -14F, 7F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 1.5F, 0F, -1F, 1.5F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F); // Box 11
		bodyModel[11].setRotationPoint(-8F, -5F, 7F);

		bodyModel[12].addBox(0F, 0F, 0F, 1, 4, 6, 0F); // Box 12
		bodyModel[12].setRotationPoint(-8F, -15F, -3F);

		bodyModel[13].addBox(0F, 0F, 0F, 1, 4, 6, 0F); // Box 13
		bodyModel[13].setRotationPoint(-8F, -5F, -3F);

		bodyModel[14].addBox(0F, 0F, 0F, 1, 6, 4, 0F); // Box 14
		bodyModel[14].setRotationPoint(-8F, -11F, -7F);

		bodyModel[15].addBox(0F, 0F, 0F, 1, 6, 4, 0F); // Box 15
		bodyModel[15].setRotationPoint(-8F, -11F, 3F);

		bodyModel[16].addBox(0F, 0F, 0F, 1, 6, 6, 0F); // Box 16
		bodyModel[16].setRotationPoint(-8F, -11F, -3F);

		bodyModel[17].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 17
		bodyModel[17].setRotationPoint(-8F, -15F, -7F);

		bodyModel[18].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 18
		bodyModel[18].setRotationPoint(-8F, -15F, 3F);

		bodyModel[19].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F); // Box 19
		bodyModel[19].setRotationPoint(-8F, -5F, 3F);

		bodyModel[20].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 20
		bodyModel[20].setRotationPoint(-8F, -5F, -7F);

		bodyModel[21].addBox(0F, 0F, 0F, 1, 3, 1, 0F); // Box 21
		bodyModel[21].setRotationPoint(-7.75F, -9.5F, -0.5F);

		bodyModel[22].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 22
		bodyModel[22].setRotationPoint(-7.75F, -9.5F, -1.5F);

		bodyModel[23].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 23
		bodyModel[23].setRotationPoint(-7.75F, -9.5F, 0.5F);

		bodyModel[24].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 24
		bodyModel[24].setRotationPoint(-7.9F, -3.2F, -1F);

		bodyModel[25].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 25
		bodyModel[25].setRotationPoint(-7.9F, -14.8F, -1F);

		bodyModel[26].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 26
		bodyModel[26].setRotationPoint(-7.9F, -9F, 4.8F);

		bodyModel[27].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 27
		bodyModel[27].setRotationPoint(-7.9F, -9F, -6.8F);

		bodyModel[28].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 28
		bodyModel[28].setRotationPoint(-7.9F, -11.75F, 4F);

		bodyModel[29].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 29
		bodyModel[29].setRotationPoint(-7.9F, -14F, 1.75F);

		bodyModel[30].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 30
		bodyModel[30].setRotationPoint(-7.9F, -6.25F, 4F);

		bodyModel[31].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 31
		bodyModel[31].setRotationPoint(-7.9F, -4F, 1.75F);

		bodyModel[32].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 32
		bodyModel[32].setRotationPoint(-7.9F, -4F, -3.75F);

		bodyModel[33].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 33
		bodyModel[33].setRotationPoint(-7.9F, -14F, -3.75F);

		bodyModel[34].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 34
		bodyModel[34].setRotationPoint(-7.9F, -11.75F, -6F);

		bodyModel[35].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 35
		bodyModel[35].setRotationPoint(-7.9F, -6.25F, -6F);

		bodyModel[36].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 37
		bodyModel[36].setRotationPoint(-6.5F, -8.5F, -0.5F);

		bodyModel[37].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 40
		bodyModel[37].setRotationPoint(-7.5F, -8.5F, -0.5F);


		turretModel = new ModelRendererTurbo[1];
		turretModel[0] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Box 39

		turretModel[0].addShapeBox(0F, 0F, -0.5F, 1, 7, 1, 0F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, 0F, -0.5F, -0.45F); // Box 39
		turretModel[0].setRotationPoint(-6F, -24F, 0F);


		trailerModel = new ModelRendererTurbo[1];
		trailerModel[0] = new ModelRendererTurbo(this, 41, 33, textureX, textureY); // Box 38

		trailerModel[0].addShapeBox(0F, 0F, -0.5F, 1, 5, 1, 0F, 0F, 0F, -0.2F, -0.8F, 0F, -0.2F, -0.8F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.5F, -0.4F, -0.8F, -0.5F, -0.4F, -0.8F, -0.5F, -0.4F, 0F, -0.5F, -0.4F); // Box 38
		trailerModel[0].setRotationPoint(-6.5F, -24F, 0F);


		steeringWheelModel = new ModelRendererTurbo[1];
		steeringWheelModel[0] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Box 36

		steeringWheelModel[0].addShapeBox(0F, 0F, -0.5F, 1, 6, 1, 0F, 0F, 0F, -0.3F, -0.8F, 0F, -0.3F, -0.8F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, 0F, -0.5F, -0.45F); // Box 36
		steeringWheelModel[0].setRotationPoint(-6.25F, -24F, 0F);
		
		translateAll(0F, 24F, 0F);
		
	}
}