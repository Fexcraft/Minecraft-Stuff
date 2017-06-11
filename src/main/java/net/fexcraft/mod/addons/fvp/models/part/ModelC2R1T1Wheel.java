//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de

// Model: C2-R1 Wheel
// Model Creator: FEX___96
// Created on: 31.03.2017 - 14:38:29
// Last changed on: 31.03.2017 - 14:38:29

package net.fexcraft.mod.addons.fvp.models.part;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvm.data.Vehicle.VehicleData;
import net.fexcraft.mod.fvm.model.AdjustableWheelModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.entity.Entity;

public class ModelC2R1T1Wheel extends AdjustableWheelModel {
	
	int textureX = 128;
	int textureY = 64;

	public ModelC2R1T1Wheel (){
		this.creators.add("Ferdinand (FEX___96)");
		body = new ModelRendererTurbo[10];
		body[0] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 18
		body[1] = new ModelRendererTurbo(this, 25, 17, textureX, textureY); // Box 20
		body[2] = new ModelRendererTurbo(this, 41, 17, textureX, textureY); // Box 21
		body[3] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 22
		body[4] = new ModelRendererTurbo(this, 65, 17, textureX, textureY); // Box 24
		body[5] = new ModelRendererTurbo(this, 73, 17, textureX, textureY); // Box 25
		body[6] = new ModelRendererTurbo(this, 89, 17, textureX, textureY); // Box 27
		body[7] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 28
		body[8] = new ModelRendererTurbo(this, 113, 17, textureX, textureY); // Box 30
		body[9] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 31

		body[0].addBox(-1.5F, -1.5F, -1F, 3, 3, 2, 0F); // Box 18
		body[0].setRotationPoint(0F, 0F, 0F);

		body[1].addShapeBox(-1.5F, -1.5F, 1F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, -0.75F, -0.5F, -0.75F, -0.75F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, -0.75F, -0.5F, -0.75F, -0.75F, -0.5F); // Box 20
		body[1].setRotationPoint(0F, 0F, 0F);

		body[2].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0.25F, 2F, 0F, 0.25F, 2F, 0F, -0.75F, -1F, 0F, -0.75F); // Box 21
		body[2].setRotationPoint(0F, 0F, 0F);

		body[3].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0.25F, 2F, 0F, 0.25F, 2F, 0F, -0.75F, -1F, 0F, -0.75F); // Box 22
		body[3].setRotationPoint(0F, 0F, 0F);
		body[3].rotateAngleZ = 0.52359878F;

		body[4].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0.25F, 2F, 0F, 0.25F, 2F, 0F, -0.75F, -1F, 0F, -0.75F); // Box 24
		body[4].setRotationPoint(0F, 0F, 0F);
		body[4].rotateAngleZ = 1.57079633F;

		body[5].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0.25F, 2F, 0F, 0.25F, 2F, 0F, -0.75F, -1F, 0F, -0.75F); // Box 25
		body[5].setRotationPoint(0F, 0F, 0F);
		body[5].rotateAngleZ = 2.0943951F;

		body[6].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0.25F, 2F, 0F, 0.25F, 2F, 0F, -0.75F, -1F, 0F, -0.75F); // Box 27
		body[6].setRotationPoint(0F, 0F, 0F);
		body[6].rotateAngleZ = 3.14159265F;

		body[7].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0.25F, 2F, 0F, 0.25F, 2F, 0F, -0.75F, -1F, 0F, -0.75F); // Box 28
		body[7].setRotationPoint(0F, 0F, 0F);
		body[7].rotateAngleZ = 3.66519143F;

		body[8].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0.25F, 2F, 0F, 0.25F, 2F, 0F, -0.75F, -1F, 0F, -0.75F); // Box 30
		body[8].setRotationPoint(0F, 0F, 0F);
		body[8].rotateAngleZ = 4.71238898F;

		body[9].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0.25F, 2F, 0F, 0.25F, 2F, 0F, -0.75F, -1F, 0F, -0.75F); // Box 31
		body[9].setRotationPoint(0F, 0F, 0F);
		body[9].rotateAngleZ = 5.23598776F;


		bodyColoredSecondary = new ModelRendererTurbo[4];
		bodyColoredSecondary[0] = new ModelRendererTurbo(this, 57, 17, textureX, textureY); // Box 23
		bodyColoredSecondary[1] = new ModelRendererTurbo(this, 81, 17, textureX, textureY); // Box 26
		bodyColoredSecondary[2] = new ModelRendererTurbo(this, 105, 17, textureX, textureY); // Box 29
		bodyColoredSecondary[3] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 32

		bodyColoredSecondary[0].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0.25F, 2F, 0F, 0.25F, 2F, 0F, -0.75F, -1F, 0F, -0.75F); // Box 23
		bodyColoredSecondary[0].setRotationPoint(0F, 0F, 0F);
		bodyColoredSecondary[0].rotateAngleZ = 1.04719755F;

		bodyColoredSecondary[1].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0.25F, 2F, 0F, 0.25F, 2F, 0F, -0.75F, -1F, 0F, -0.75F); // Box 26
		bodyColoredSecondary[1].setRotationPoint(0F, 0F, 0F);
		bodyColoredSecondary[1].rotateAngleZ = 2.61799388F;

		bodyColoredSecondary[2].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0.25F, 2F, 0F, 0.25F, 2F, 0F, -0.75F, -1F, 0F, -0.75F); // Box 29
		bodyColoredSecondary[2].setRotationPoint(0F, 0F, 0F);
		bodyColoredSecondary[2].rotateAngleZ = 4.1887902F;

		bodyColoredSecondary[3].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0.25F, 2F, 0F, 0.25F, 2F, 0F, -0.75F, -1F, 0F, -0.75F); // Box 32
		bodyColoredSecondary[3].setRotationPoint(0F, 0F, 0F);
		bodyColoredSecondary[3].rotateAngleZ = 5.75958653F;


		wheels = new ModelRendererTurbo[33];
		wheels[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		wheels[1] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 3
		wheels[2] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 4
		wheels[3] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 5
		wheels[4] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 6
		wheels[5] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 7
		wheels[6] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 8
		wheels[7] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 9
		wheels[8] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 10
		wheels[9] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 11
		wheels[10] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 12
		wheels[11] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 13
		wheels[12] = new ModelRendererTurbo(this, 65, 9, textureX, textureY); // Box 14
		wheels[13] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Box 15
		wheels[14] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 16
		wheels[15] = new ModelRendererTurbo(this, 113, 9, textureX, textureY); // Box 17
		wheels[16] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 19
		wheels[17] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 33
		wheels[18] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 32
		wheels[19] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 35
		wheels[20] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 36
		wheels[21] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 37
		wheels[22] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 38
		wheels[23] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 39
		wheels[24] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 40
		wheels[25] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 41
		wheels[26] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 42
		wheels[27] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 43
		wheels[28] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 44
		wheels[29] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 45
		wheels[30] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 46
		wheels[31] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 47
		wheels[32] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 48

		wheels[0].addShapeBox(0F, 6F, -1.5F, 3, 1, 3, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.55F, 0F, -0.3F, -0.55F, 0F, 0F, 0F, 0F); // Box 0
		wheels[0].setRotationPoint(0F, 0F, 0F);

		wheels[1].addShapeBox(0F, 6F, -1.5F, 3, 1, 3, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.55F, 0F, -0.3F, -0.55F, 0F, 0F, 0F, 0F); // Box 3
		wheels[1].setRotationPoint(0F, 0F, 0F);
		wheels[1].rotateAngleZ = 0.39269908F;

		wheels[2].addShapeBox(0F, 6F, -1.5F, 3, 1, 3, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.55F, 0F, -0.3F, -0.55F, 0F, 0F, 0F, 0F); // Box 4
		wheels[2].setRotationPoint(0F, 0F, 0F);
		wheels[2].rotateAngleZ = 0.78539816F;

		wheels[3].addShapeBox(0F, 6F, -1.5F, 3, 1, 3, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.55F, 0F, -0.3F, -0.55F, 0F, 0F, 0F, 0F); // Box 5
		wheels[3].setRotationPoint(0F, 0F, 0F);
		wheels[3].rotateAngleZ = 1.17809725F;

		wheels[4].addShapeBox(0F, 6F, -1.5F, 3, 1, 3, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.55F, 0F, -0.3F, -0.55F, 0F, 0F, 0F, 0F); // Box 6
		wheels[4].setRotationPoint(0F, 0F, 0F);
		wheels[4].rotateAngleZ = 1.57079633F;

		wheels[5].addShapeBox(0F, 6F, -1.5F, 3, 1, 3, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.55F, 0F, -0.3F, -0.55F, 0F, 0F, 0F, 0F); // Box 7
		wheels[5].setRotationPoint(0F, 0F, 0F);
		wheels[5].rotateAngleZ = 1.96349541F;

		wheels[6].addShapeBox(0F, 6F, -1.5F, 3, 1, 3, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.55F, 0F, -0.3F, -0.55F, 0F, 0F, 0F, 0F); // Box 8
		wheels[6].setRotationPoint(0F, 0F, 0F);
		wheels[6].rotateAngleZ = 2.35619449F;

		wheels[7].addShapeBox(0F, 6F, -1.5F, 3, 1, 3, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.55F, 0F, -0.3F, -0.55F, 0F, 0F, 0F, 0F); // Box 9
		wheels[7].setRotationPoint(0F, 0F, 0F);
		wheels[7].rotateAngleZ = 2.74889357F;

		wheels[8].addShapeBox(0F, 6F, -1.5F, 3, 1, 3, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.55F, 0F, -0.3F, -0.55F, 0F, 0F, 0F, 0F); // Box 10
		wheels[8].setRotationPoint(0F, 0F, 0F);
		wheels[8].rotateAngleZ = 3.14159265F;

		wheels[9].addShapeBox(0F, 6F, -1.5F, 3, 1, 3, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.55F, 0F, -0.3F, -0.55F, 0F, 0F, 0F, 0F); // Box 11
		wheels[9].setRotationPoint(0F, 0F, 0F);
		wheels[9].rotateAngleZ = 3.53429174F;

		wheels[10].addShapeBox(0F, 6F, -1.5F, 3, 1, 3, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.55F, 0F, -0.3F, -0.55F, 0F, 0F, 0F, 0F); // Box 12
		wheels[10].setRotationPoint(0F, 0F, 0F);
		wheels[10].rotateAngleZ = 3.92699082F;

		wheels[11].addShapeBox(0F, 6F, -1.5F, 3, 1, 3, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.55F, 0F, -0.3F, -0.55F, 0F, 0F, 0F, 0F); // Box 13
		wheels[11].setRotationPoint(0F, 0F, 0F);
		wheels[11].rotateAngleZ = 4.3196899F;

		wheels[12].addShapeBox(0F, 6F, -1.5F, 3, 1, 3, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.55F, 0F, -0.3F, -0.55F, 0F, 0F, 0F, 0F); // Box 14
		wheels[12].setRotationPoint(0F, 0F, 0F);
		wheels[12].rotateAngleZ = 4.71238898F;

		wheels[13].addShapeBox(0F, 6F, -1.5F, 3, 1, 3, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.55F, 0F, -0.3F, -0.55F, 0F, 0F, 0F, 0F); // Box 15
		wheels[13].setRotationPoint(0F, 0F, 0F);
		wheels[13].rotateAngleZ = 5.10508806F;

		wheels[14].addShapeBox(0F, 6F, -1.5F, 3, 1, 3, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.55F, 0F, -0.3F, -0.55F, 0F, 0F, 0F, 0F); // Box 16
		wheels[14].setRotationPoint(0F, 0F, 0F);
		wheels[14].rotateAngleZ = 5.49778714F;

		wheels[15].addShapeBox(0F, 6F, -1.5F, 3, 1, 3, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.55F, 0F, -0.3F, -0.55F, 0F, 0F, 0F, 0F); // Box 17
		wheels[15].setRotationPoint(0F, 0F, 0F);
		wheels[15].rotateAngleZ = 5.89048623F;

		wheels[16].addBox(-1F, -1F, -2F, 2, 2, 1, 0F); // Box 19
		wheels[16].setRotationPoint(0F, 0F, 0F);

		wheels[17].addShapeBox(0F, 5F, -1.5F, 3, 1, 3, 0F, 0F, -0.5F, -0.1F, -0.85F, -0.1F, -0.1F, -0.85F, -0.1F, -0.1F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, -0.65F, -0.4F, -0.1F, -0.65F, -0.4F, -0.1F, 0F, 0F, -0.1F); // Box 33
		wheels[17].setRotationPoint(0F, 0F, 0F);

		wheels[18].addShapeBox(0F, 5F, -1.5F, 3, 1, 3, 0F, 0F, -0.5F, -0.1F, -0.85F, -0.1F, -0.1F, -0.85F, -0.1F, -0.1F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, -0.65F, -0.4F, -0.1F, -0.65F, -0.4F, -0.1F, 0F, 0F, -0.1F); // Box 32
		wheels[18].setRotationPoint(0F, 0F, 0F);
		wheels[18].rotateAngleZ = 0.39269908F;

		wheels[19].addShapeBox(0F, 5F, -1.5F, 3, 1, 3, 0F, 0F, -0.5F, -0.1F, -0.85F, -0.1F, -0.1F, -0.85F, -0.1F, -0.1F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, -0.65F, -0.4F, -0.1F, -0.65F, -0.4F, -0.1F, 0F, 0F, -0.1F); // Box 35
		wheels[19].setRotationPoint(0F, 0F, 0F);
		wheels[19].rotateAngleZ = 0.78539816F;

		wheels[20].addShapeBox(0F, 5F, -1.5F, 3, 1, 3, 0F, 0F, -0.5F, -0.1F, -0.85F, -0.1F, -0.1F, -0.85F, -0.1F, -0.1F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, -0.65F, -0.4F, -0.1F, -0.65F, -0.4F, -0.1F, 0F, 0F, -0.1F); // Box 36
		wheels[20].setRotationPoint(0F, 0F, 0F);
		wheels[20].rotateAngleZ = 1.17809725F;

		wheels[21].addShapeBox(0F, 5F, -1.5F, 3, 1, 3, 0F, 0F, -0.5F, -0.1F, -0.85F, -0.1F, -0.1F, -0.85F, -0.1F, -0.1F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, -0.65F, -0.4F, -0.1F, -0.65F, -0.4F, -0.1F, 0F, 0F, -0.1F); // Box 37
		wheels[21].setRotationPoint(0F, 0F, 0F);
		wheels[21].rotateAngleZ = 1.57079633F;

		wheels[22].addShapeBox(0F, 5F, -1.5F, 3, 1, 3, 0F, 0F, -0.5F, -0.1F, -0.85F, -0.1F, -0.1F, -0.85F, -0.1F, -0.1F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, -0.65F, -0.4F, -0.1F, -0.65F, -0.4F, -0.1F, 0F, 0F, -0.1F); // Box 38
		wheels[22].setRotationPoint(0F, 0F, 0F);
		wheels[22].rotateAngleZ = 1.96349541F;

		wheels[23].addShapeBox(0F, 5F, -1.5F, 3, 1, 3, 0F, 0F, -0.5F, -0.1F, -0.85F, -0.1F, -0.1F, -0.85F, -0.1F, -0.1F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, -0.65F, -0.4F, -0.1F, -0.65F, -0.4F, -0.1F, 0F, 0F, -0.1F); // Box 39
		wheels[23].setRotationPoint(0F, 0F, 0F);
		wheels[23].rotateAngleZ = 2.35619449F;

		wheels[24].addShapeBox(0F, 5F, -1.5F, 3, 1, 3, 0F, 0F, -0.5F, -0.1F, -0.85F, -0.1F, -0.1F, -0.85F, -0.1F, -0.1F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, -0.65F, -0.4F, -0.1F, -0.65F, -0.4F, -0.1F, 0F, 0F, -0.1F); // Box 40
		wheels[24].setRotationPoint(0F, 0F, 0F);
		wheels[24].rotateAngleZ = 2.74889357F;

		wheels[25].addShapeBox(0F, 5F, -1.5F, 3, 1, 3, 0F, 0F, -0.5F, -0.1F, -0.85F, -0.1F, -0.1F, -0.85F, -0.1F, -0.1F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, -0.65F, -0.4F, -0.1F, -0.65F, -0.4F, -0.1F, 0F, 0F, -0.1F); // Box 41
		wheels[25].setRotationPoint(0F, 0F, 0F);
		wheels[25].rotateAngleZ = 3.14159265F;

		wheels[26].addShapeBox(0F, 5F, -1.5F, 3, 1, 3, 0F, 0F, -0.5F, -0.1F, -0.85F, -0.1F, -0.1F, -0.85F, -0.1F, -0.1F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, -0.65F, -0.4F, -0.1F, -0.65F, -0.4F, -0.1F, 0F, 0F, -0.1F); // Box 42
		wheels[26].setRotationPoint(0F, 0F, 0F);
		wheels[26].rotateAngleZ = 3.53429174F;

		wheels[27].addShapeBox(0F, 5F, -1.5F, 3, 1, 3, 0F, 0F, -0.5F, -0.1F, -0.85F, -0.1F, -0.1F, -0.85F, -0.1F, -0.1F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, -0.65F, -0.4F, -0.1F, -0.65F, -0.4F, -0.1F, 0F, 0F, -0.1F); // Box 43
		wheels[27].setRotationPoint(0F, 0F, 0F);
		wheels[27].rotateAngleZ = 3.92699082F;

		wheels[28].addShapeBox(0F, 5F, -1.5F, 3, 1, 3, 0F, 0F, -0.5F, -0.1F, -0.85F, -0.1F, -0.1F, -0.85F, -0.1F, -0.1F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, -0.65F, -0.4F, -0.1F, -0.65F, -0.4F, -0.1F, 0F, 0F, -0.1F); // Box 44
		wheels[28].setRotationPoint(0F, 0F, 0F);
		wheels[28].rotateAngleZ = 4.3196899F;

		wheels[29].addShapeBox(0F, 5F, -1.5F, 3, 1, 3, 0F, 0F, -0.5F, -0.1F, -0.85F, -0.1F, -0.1F, -0.85F, -0.1F, -0.1F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, -0.65F, -0.4F, -0.1F, -0.65F, -0.4F, -0.1F, 0F, 0F, -0.1F); // Box 45
		wheels[29].setRotationPoint(0F, 0F, 0F);
		wheels[29].rotateAngleZ = 4.71238898F;

		wheels[30].addShapeBox(0F, 5F, -1.5F, 3, 1, 3, 0F, 0F, -0.5F, -0.1F, -0.85F, -0.1F, -0.1F, -0.85F, -0.1F, -0.1F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, -0.65F, -0.4F, -0.1F, -0.65F, -0.4F, -0.1F, 0F, 0F, -0.1F); // Box 46
		wheels[30].setRotationPoint(0F, 0F, 0F);
		wheels[30].rotateAngleZ = 5.10508806F;

		wheels[31].addShapeBox(0F, 5F, -1.5F, 3, 1, 3, 0F, 0F, -0.5F, -0.1F, -0.85F, -0.1F, -0.1F, -0.85F, -0.1F, -0.1F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, -0.65F, -0.4F, -0.1F, -0.65F, -0.4F, -0.1F, 0F, 0F, -0.1F); // Box 47
		wheels[31].setRotationPoint(0F, 0F, 0F);
		wheels[31].rotateAngleZ = 5.49778714F;

		wheels[32].addShapeBox(0F, 5F, -1.5F, 3, 1, 3, 0F, 0F, -0.5F, -0.1F, -0.85F, -0.1F, -0.1F, -0.85F, -0.1F, -0.1F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, -0.65F, -0.4F, -0.1F, -0.65F, -0.4F, -0.1F, 0F, 0F, -0.1F); // Box 48
		wheels[32].setRotationPoint(0F, 0F, 0F);
		wheels[32].rotateAngleZ = 5.89048623F;

		//translateAll(0F, 0F, 0F);

		//flipAll();
	}

	@Override
	public void renderExchangeWheel(VehicleData data, String usedAS, Entity vehicle) {
		return;
	}

	@Override
	public void renderRightBack(VehicleData data, String usedAS, Entity vehicle) {
		GL11.glPushMatrix();
		GL11.glScalef(1.2f, 1.2f, 1.2f);
		render(wheels);
		render(body);
		data.secondary.glColorApply();
		render(bodyColoredSecondary);
		data.secondary.glColorReset();
		GL11.glPopMatrix();
	}

	@Override
	public void renderLeftBack(VehicleData data, String usedAS, Entity vehicle) {
		GL11.glPushMatrix();
		GL11.glRotated(180, 0, 1, 0);
		GL11.glScalef(1.2f, 1.2f, 1.2f);
		render(wheels);
		render(body);
		data.secondary.glColorApply();
		render(bodyColoredSecondary);
		data.secondary.glColorReset();
		GL11.glRotated(-180, 0, 1, 0);
		GL11.glPopMatrix();
	}

	@Override
	public void renderRightFront(VehicleData data, String usedAS, Entity vehicle) {
		GL11.glPushMatrix();
		GL11.glScalef(1.2f, 1.2f, 1.2f);
		/*for(ModelRendererTurbo model : wheels){
			model.rotateAngleX = vehicle.wheelsYaw * Static.rad180 / 180F * 3F;
			model.render();
		}
		for(ModelRendererTurbo model : body){
			model.rotateAngleX = vehicle.wheelsYaw * Static.rad180 / 180F * 3F;
			model.render();
		}
		data.secondary.glColorApply();
		for(ModelRendererTurbo model : bodyColoredSecondary){
			model.rotateAngleX = vehicle.wheelsYaw * Static.rad180 / 180F * 3F;
			model.render();
		}*///TODO
		data.secondary.glColorReset();
		GL11.glPopMatrix();
	}

	@Override
	public void renderLeftFront(VehicleData data, String usedAS, Entity vehicle) {
		GL11.glPushMatrix();
		GL11.glRotated(180, 0, 1, 0);
		GL11.glScalef(1.2f, 1.2f, 1.2f);
		/*for(ModelRendererTurbo model : wheels){
			model.rotateAngleX = vehicle.wheelsYaw * Static.rad180 / 180F * 3F;
			model.render();
		}
		for(ModelRendererTurbo model : body){
			model.rotateAngleX = vehicle.wheelsYaw * Static.rad180 / 180F * 3F;
			model.render();
		}
		data.secondary.glColorApply();
		for(ModelRendererTurbo model : bodyColoredSecondary){
			model.rotateAngleX = vehicle.wheelsYaw * Static.rad180 / 180F * 3F;
			model.render();
		}*///TODO
		data.secondary.glColorReset();
		GL11.glRotated(-180, 0, 1, 0);
		GL11.glPopMatrix();
	}

	@Override
	public void renderExchangeWheel(VehicleData data, String usedAS){
		return;
	}

	@Override
	public void renderRightBack(VehicleData data, String usedAS) {
		GL11.glPushMatrix();
		GL11.glScalef(1.2f, 1.2f, 1.2f);
		render(wheels);
		render(body);
		data.secondary.glColorApply();
		render(bodyColoredSecondary);
		data.secondary.glColorReset();
		GL11.glPopMatrix();
	}

	@Override
	public void renderLeftBack(VehicleData data, String usedAS) {
		GL11.glPushMatrix();
		GL11.glRotated(180, 0, 1, 0);
		GL11.glScalef(1.2f, 1.2f, 1.2f);
		render(wheels);
		render(body);
		data.secondary.glColorApply();
		render(bodyColoredSecondary);
		data.secondary.glColorReset();
		GL11.glRotated(-180, 0, 1, 0);
		GL11.glPopMatrix();
		return;
	}

	@Override
	public void renderRightFront(VehicleData data, String usedAS) {
		GL11.glPushMatrix();
		GL11.glScalef(1.2f, 1.2f, 1.2f);
		render(wheels);
		render(body);
		data.secondary.glColorApply();
		render(bodyColoredSecondary);
		data.secondary.glColorReset();
		GL11.glPopMatrix();
		return;
	}

	@Override
	public void renderLeftFront(VehicleData data, String usedAS) {
		GL11.glPushMatrix();
		GL11.glRotated(180, 0, 1, 0);
		GL11.glScalef(1.2f, 1.2f, 1.2f);
		render(wheels);
		render(body);
		data.secondary.glColorApply();
		render(bodyColoredSecondary);
		data.secondary.glColorReset();
		GL11.glRotated(-180, 0, 1, 0);
		GL11.glPopMatrix();
		return;
	}
	
}