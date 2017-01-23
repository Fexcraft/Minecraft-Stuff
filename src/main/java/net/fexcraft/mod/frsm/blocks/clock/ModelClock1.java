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
		
		bodyModel = new ModelRendererTurbo[26];
		bodyModel[0] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // Box 12
		bodyModel[1] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 13
		bodyModel[2] = new ModelRendererTurbo(this, 89, 9, textureX, textureY); // Box 14
		bodyModel[3] = new ModelRendererTurbo(this, 105, 9, textureX, textureY); // Box 15
		bodyModel[4] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 16
		bodyModel[5] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 17
		bodyModel[6] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 18
		bodyModel[7] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 19
		bodyModel[8] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 20
		bodyModel[9] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 21
		bodyModel[10] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 22
		bodyModel[11] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 23
		bodyModel[12] = new ModelRendererTurbo(this, 121, 9, textureX, textureY); // Box 24
		bodyModel[13] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 25
		bodyModel[14] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 26
		bodyModel[15] = new ModelRendererTurbo(this, 73, 25, textureX, textureY); // Box 27
		bodyModel[16] = new ModelRendererTurbo(this, 81, 25, textureX, textureY); // Box 28
		bodyModel[17] = new ModelRendererTurbo(this, 89, 25, textureX, textureY); // Box 29
		bodyModel[18] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 30
		bodyModel[19] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 31
		bodyModel[20] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 32
		bodyModel[21] = new ModelRendererTurbo(this, 9, 33, textureX, textureY); // Box 33
		bodyModel[22] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 34
		bodyModel[23] = new ModelRendererTurbo(this, 25, 33, textureX, textureY); // Box 35
		bodyModel[24] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 37
		bodyModel[25] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 40

		bodyModel[0].addBox(0F, 0F, 0F, 1, 4, 6, 0F); // Box 12
		bodyModel[0].setRotationPoint(-8F, -15F, -3F);

		bodyModel[1].addBox(0F, 0F, 0F, 1, 4, 6, 0F); // Box 13
		bodyModel[1].setRotationPoint(-8F, -5F, -3F);

		bodyModel[2].addBox(0F, 0F, 0F, 1, 6, 4, 0F); // Box 14
		bodyModel[2].setRotationPoint(-8F, -11F, -7F);

		bodyModel[3].addBox(0F, 0F, 0F, 1, 6, 4, 0F); // Box 15
		bodyModel[3].setRotationPoint(-8F, -11F, 3F);

		bodyModel[4].addBox(0F, 0F, 0F, 1, 6, 6, 0F); // Box 16
		bodyModel[4].setRotationPoint(-8F, -11F, -3F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 17
		bodyModel[5].setRotationPoint(-8F, -15F, -7F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 18
		bodyModel[6].setRotationPoint(-8F, -15F, 3F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F); // Box 19
		bodyModel[7].setRotationPoint(-8F, -5F, 3F);

		bodyModel[8].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 20
		bodyModel[8].setRotationPoint(-8F, -5F, -7F);

		bodyModel[9].addBox(0F, 0F, 0F, 1, 3, 1, 0F); // Box 21
		bodyModel[9].setRotationPoint(-7.75F, -9.5F, -0.5F);

		bodyModel[10].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 22
		bodyModel[10].setRotationPoint(-7.75F, -9.5F, -1.5F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 23
		bodyModel[11].setRotationPoint(-7.75F, -9.5F, 0.5F);

		bodyModel[12].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 24
		bodyModel[12].setRotationPoint(-7.9F, -3.2F, -1F);

		bodyModel[13].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 25
		bodyModel[13].setRotationPoint(-7.9F, -14.8F, -1F);

		bodyModel[14].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 26
		bodyModel[14].setRotationPoint(-7.9F, -9F, 4.8F);

		bodyModel[15].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 27
		bodyModel[15].setRotationPoint(-7.9F, -9F, -6.8F);

		bodyModel[16].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 28
		bodyModel[16].setRotationPoint(-7.9F, -11.75F, 4F);

		bodyModel[17].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 29
		bodyModel[17].setRotationPoint(-7.9F, -14F, 1.75F);

		bodyModel[18].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 30
		bodyModel[18].setRotationPoint(-7.9F, -6.25F, 4F);

		bodyModel[19].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 31
		bodyModel[19].setRotationPoint(-7.9F, -4F, 1.75F);

		bodyModel[20].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 32
		bodyModel[20].setRotationPoint(-7.9F, -4F, -3.75F);

		bodyModel[21].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 33
		bodyModel[21].setRotationPoint(-7.9F, -14F, -3.75F);

		bodyModel[22].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 34
		bodyModel[22].setRotationPoint(-7.9F, -11.75F, -6F);

		bodyModel[23].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 35
		bodyModel[23].setRotationPoint(-7.9F, -6.25F, -6F);

		bodyModel[24].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 37
		bodyModel[24].setRotationPoint(-6.5F, -8.5F, -0.5F);

		bodyModel[25].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 40
		bodyModel[25].setRotationPoint(-7.5F, -8.5F, -0.5F);


		bodyDoorOpenModel = new ModelRendererTurbo[12];
		bodyDoorOpenModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		bodyDoorOpenModel[1] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 1
		bodyDoorOpenModel[2] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 2
		bodyDoorOpenModel[3] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 3
		bodyDoorOpenModel[4] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 4
		bodyDoorOpenModel[5] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 5
		bodyDoorOpenModel[6] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 6
		bodyDoorOpenModel[7] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 7
		bodyDoorOpenModel[8] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 8
		bodyDoorOpenModel[9] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 9
		bodyDoorOpenModel[10] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 10
		bodyDoorOpenModel[11] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 11

		bodyDoorOpenModel[0].addBox(0F, 0F, 0F, 3, 1, 6, 0F); // Box 0
		bodyDoorOpenModel[0].setRotationPoint(-8F, -1F, -3F);

		bodyDoorOpenModel[1].addBox(0F, 0F, 0F, 3, 1, 6, 0F); // Box 1
		bodyDoorOpenModel[1].setRotationPoint(-8F, -16F, -3F);

		bodyDoorOpenModel[2].addBox(0F, 0F, 0F, 3, 6, 1, 0F); // Box 2
		bodyDoorOpenModel[2].setRotationPoint(-8F, -11F, 7F);

		bodyDoorOpenModel[3].addBox(0F, 0F, 0F, 3, 6, 1, 0F); // Box 3
		bodyDoorOpenModel[3].setRotationPoint(-8F, -11F, -8F);

		bodyDoorOpenModel[4].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, 2F, 0F, 0F, 2F, 0F); // Box 4
		bodyDoorOpenModel[4].setRotationPoint(-8F, -3F, -6F);

		bodyDoorOpenModel[5].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F, 0F, -1F, 1.5F, 0F, -1F, 1.5F); // Box 5
		bodyDoorOpenModel[5].setRotationPoint(-8F, -5F, -8F);

		bodyDoorOpenModel[6].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F); // Box 6
		bodyDoorOpenModel[6].setRotationPoint(-8F, -3F, 3F);

		bodyDoorOpenModel[7].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 7
		bodyDoorOpenModel[7].setRotationPoint(-8F, -14F, 3F);

		bodyDoorOpenModel[8].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -2F, 0F, 0F, -2F, 0F); // Box 8
		bodyDoorOpenModel[8].setRotationPoint(-8F, -14F, -6F);

		bodyDoorOpenModel[9].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F, 0F, -1F, 1.5F, 0F, -1F, 1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
		bodyDoorOpenModel[9].setRotationPoint(-8F, -14F, -8F);

		bodyDoorOpenModel[10].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, -1F, 1.5F, 0F, -1F, 1.5F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
		bodyDoorOpenModel[10].setRotationPoint(-8F, -14F, 7F);

		bodyDoorOpenModel[11].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 1.5F, 0F, -1F, 1.5F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F); // Box 11
		bodyDoorOpenModel[11].setRotationPoint(-8F, -5F, 7F);


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