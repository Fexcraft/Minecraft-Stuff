//This File was created with the Minecraft-SMP Modelling Toolbox 2.2.2.2
// Copyright (C) 2016 Minecraft-SMP.de

// Model: Fridge
// Model Creator: FEX___96
// Created on: 25.07.2016 - 12:52:26
// Last changed on: 25.07.2016 - 12:52:26

package net.fexcraft.mod.frsm.blocks.fridge;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class FridgeModel extends ModelBase {
	
	int textureX = 256;
	int textureY = 128;

	public FridgeModel(){
		base = new ModelRendererTurbo[18];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		base[1] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Box 1
		base[2] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 2
		base[3] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 3
		base[4] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 4
		base[5] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 5
		base[6] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 6
		base[7] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 7
		base[8] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 8
		base[9] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 9
		base[10] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 10
		base[11] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Box 11
		base[12] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 12
		base[13] = new ModelRendererTurbo(this, 89, 41, textureX, textureY); // Box 13
		base[14] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 16
		base[15] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 17
		base[16] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 18
		base[17] = new ModelRendererTurbo(this, 129, 1, textureX, textureY); // Box 19

		base[0].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 0
		base[0].setRotationPoint(5F, -1F, -6F);

		base[1].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 1
		base[1].setRotationPoint(-6F, -1F, -6F);

		base[2].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 2
		base[2].setRotationPoint(-6F, -1F, 5F);

		base[3].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 3
		base[3].setRotationPoint(5F, -1F, 5F);

		base[4].addBox(0F, 0F, 0F, 16, 1, 15, 0F); // Box 4
		base[4].setRotationPoint(-8F, -2F, -7F);

		base[5].addBox(0F, 0F, 0F, 16, 28, 1, 0F); // Box 5
		base[5].setRotationPoint(-8F, -30F, 7F);

		base[6].addBox(0F, 0F, 0F, 16, 1, 15, 0F); // Box 6
		base[6].setRotationPoint(-8F, -31F, -7F);

		base[7].addBox(0F, 0F, 0F, 1, 28, 14, 0F); // Box 7
		base[7].setRotationPoint(-8F, -30F, -7F);

		base[8].addBox(0F, 0F, 0F, 1, 28, 14, 0F); // Box 8
		base[8].setRotationPoint(7F, -30F, -7F);

		base[9].addBox(0F, 0F, 0F, 14, 1, 14, 0F); // Box 9
		base[9].setRotationPoint(-7F, -12F, -7F);

		base[10].addShapeBox(0F, 0F, 0F, 14, 4, 8, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
		base[10].setRotationPoint(-7F, -6F, -1F);

		base[11].addShapeBox(0F, 0F, 0F, 14, 1, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, -1F, 0F, -0.75F, -1F, 0F, -0.75F, 0F, 0F, -0.75F, 0F); // Box 11
		base[11].setRotationPoint(-7F, -18F, -3F);

		base[12].addShapeBox(0F, 0F, 0F, 14, 1, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, -1F, 0F, -0.75F, -1F, 0F, -0.75F, 0F, 0F, -0.75F, 0F); // Box 12
		base[12].setRotationPoint(-7F, -22F, -3F);

		base[13].addShapeBox(0F, 0F, 0F, 14, 1, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, -1F, 0F, -0.75F, -1F, 0F, -0.75F, 0F, 0F, -0.75F, 0F); // Box 13
		base[13].setRotationPoint(-7F, -26F, -3F);

		base[14].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 16
		base[14].setRotationPoint(7F, -11F, -7.5F);

		base[15].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 17
		base[15].setRotationPoint(7F, -3F, -7.5F);

		base[16].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 18
		base[16].setRotationPoint(7F, -14F, -7.5F);

		base[17].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 19
		base[17].setRotationPoint(7F, -29F, -7.5F);


		open = new ModelRendererTurbo[68];
		open[0] = new ModelRendererTurbo(this, 41, 49, textureX, textureY); // Box 22
		open[1] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 23
		open[2] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 24
		open[3] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box 25
		open[4] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Box 26
		open[5] = new ModelRendererTurbo(this, 225, 1, textureX, textureY); // Box 27
		open[6] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 28
		open[7] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 29
		open[8] = new ModelRendererTurbo(this, 9, 9, textureX, textureY); // Box 30
		open[9] = new ModelRendererTurbo(this, 169, 9, textureX, textureY); // Box 31
		open[10] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 32
		open[11] = new ModelRendererTurbo(this, 81, 57, textureX, textureY); // Box 33
		open[12] = new ModelRendererTurbo(this, 121, 57, textureX, textureY); // Box 34
		open[13] = new ModelRendererTurbo(this, 153, 65, textureX, textureY); // Box 35
		open[14] = new ModelRendererTurbo(this, 161, 25, textureX, textureY); // Box 36
		open[15] = new ModelRendererTurbo(this, 65, 9, textureX, textureY); // Box 37
		open[16] = new ModelRendererTurbo(this, 121, 9, textureX, textureY); // Box 38
		open[17] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 39
		open[18] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 40
		open[19] = new ModelRendererTurbo(this, 225, 49, textureX, textureY); // Box 41
		open[20] = new ModelRendererTurbo(this, 209, 65, textureX, textureY); // Box 42
		open[21] = new ModelRendererTurbo(this, 65, 73, textureX, textureY); // Box 43
		open[22] = new ModelRendererTurbo(this, 129, 41, textureX, textureY); // Box 44
		open[23] = new ModelRendererTurbo(this, 105, 57, textureX, textureY); // Box 45
		open[24] = new ModelRendererTurbo(this, 97, 73, textureX, textureY); // Box 46
		open[25] = new ModelRendererTurbo(this, 25, 9, textureX, textureY); // Box 47
		open[26] = new ModelRendererTurbo(this, 185, 9, textureX, textureY); // Box 48
		open[27] = new ModelRendererTurbo(this, 249, 17, textureX, textureY); // Box 49
		open[28] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 50
		open[29] = new ModelRendererTurbo(this, 73, 25, textureX, textureY); // Box 51
		open[30] = new ModelRendererTurbo(this, 153, 25, textureX, textureY); // Box 52
		open[31] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 53
		open[32] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Box 54
		open[33] = new ModelRendererTurbo(this, 89, 33, textureX, textureY); // Box 55
		open[34] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 56
		open[35] = new ModelRendererTurbo(this, 65, 49, textureX, textureY); // Box 57
		open[36] = new ModelRendererTurbo(this, 129, 41, textureX, textureY); // Box 58
		open[37] = new ModelRendererTurbo(this, 225, 49, textureX, textureY); // Box 59
		open[38] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 60
		open[39] = new ModelRendererTurbo(this, 25, 57, textureX, textureY); // Box 61
		open[40] = new ModelRendererTurbo(this, 41, 57, textureX, textureY); // Box 62
		open[41] = new ModelRendererTurbo(this, 153, 57, textureX, textureY); // Box 63
		open[42] = new ModelRendererTurbo(this, 169, 57, textureX, textureY); // Box 64
		open[43] = new ModelRendererTurbo(this, 233, 65, textureX, textureY); // Box 65
		open[44] = new ModelRendererTurbo(this, 89, 73, textureX, textureY); // Box 66
		open[45] = new ModelRendererTurbo(this, 113, 73, textureX, textureY); // Box 67
		open[46] = new ModelRendererTurbo(this, 129, 73, textureX, textureY); // Box 68
		open[47] = new ModelRendererTurbo(this, 185, 73, textureX, textureY); // Box 69
		open[48] = new ModelRendererTurbo(this, 233, 73, textureX, textureY); // Box 70
		open[49] = new ModelRendererTurbo(this, 41, 81, textureX, textureY); // Box 71
		open[50] = new ModelRendererTurbo(this, 65, 57, textureX, textureY); // Box 72
		open[51] = new ModelRendererTurbo(this, 129, 81, textureX, textureY); // Box 73
		open[52] = new ModelRendererTurbo(this, 145, 81, textureX, textureY); // Box 74
		open[53] = new ModelRendererTurbo(this, 169, 81, textureX, textureY); // Box 75
		open[54] = new ModelRendererTurbo(this, 193, 81, textureX, textureY); // Box 76
		open[55] = new ModelRendererTurbo(this, 249, 25, textureX, textureY); // Box 77
		open[56] = new ModelRendererTurbo(this, 105, 33, textureX, textureY); // Box 78
		open[57] = new ModelRendererTurbo(this, 177, 33, textureX, textureY); // Box 79
		open[58] = new ModelRendererTurbo(this, 249, 33, textureX, textureY); // Box 80
		open[59] = new ModelRendererTurbo(this, 41, 41, textureX, textureY); // Box 81
		open[60] = new ModelRendererTurbo(this, 249, 41, textureX, textureY); // Box 82
		open[61] = new ModelRendererTurbo(this, 193, 9, textureX, textureY); // Box 83
		open[62] = new ModelRendererTurbo(this, 225, 9, textureX, textureY); // Box 84
		open[63] = new ModelRendererTurbo(this, 177, 25, textureX, textureY); // Box 85
		open[64] = new ModelRendererTurbo(this, 81, 49, textureX, textureY); // Box 86
		open[65] = new ModelRendererTurbo(this, 249, 49, textureX, textureY); // Box 87
		open[66] = new ModelRendererTurbo(this, 81, 57, textureX, textureY); // Box 88
		open[67] = new ModelRendererTurbo(this, 121, 57, textureX, textureY); // Box 89

		open[0].addShapeBox(0F, 0F, 0F, 1, 10, 15, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F); // Box 22
		open[0].setRotationPoint(7F, -11.5F, -22F);

		open[1].addShapeBox(0F, 0F, 0F, 1, 19, 15, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F); // Box 23
		open[1].setRotationPoint(7F, -30.5F, -22F);

		open[2].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F); // Box 24
		open[2].setRotationPoint(7F, -16F, -21F);

		open[3].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F); // Box 25
		open[3].setRotationPoint(7F, -10F, -21F);

		open[4].addShapeBox(0F, 0F, 0F, 3, 5, 3, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 26
		open[4].setRotationPoint(-6F, -17F, 3F);

		open[5].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 27
		open[5].setRotationPoint(-5F, -16.75F, 3.5F);

		open[6].addShapeBox(0F, 0F, 0F, 3, 5, 3, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 28
		open[6].setRotationPoint(-2.5F, -17F, 3F);

		open[7].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 29
		open[7].setRotationPoint(-1.5F, -16.75F, 3.5F);

		open[8].addBox(0F, 0F, 0F, 4, 1, 4, 0F); // Box 30
		open[8].setRotationPoint(-6.5F, -19F, 2F);

		open[9].addBox(0F, 0F, 0F, 4, 1, 4, 0F); // Box 31
		open[9].setRotationPoint(-6.5F, -20F, 2F);

		open[10].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -1F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 2F, 0F, -1F, 2F, 0F, 0F, 0F, 0F); // Box 32
		open[10].setRotationPoint(-2.5F, -21F, 2F);

		open[11].addBox(0F, 0F, 0F, 8, 1, 8, 0F); // Box 33
		open[11].setRotationPoint(-6F, -7F, -1.5F);

		open[12].addBox(0F, 0F, 0F, 8, 1, 8, 0F); // Box 34
		open[12].setRotationPoint(-6F, -8F, -1.5F);

		open[13].addBox(0F, 0F, 0F, 8, 1, 8, 0F); // Box 35
		open[13].setRotationPoint(-6F, -9F, -1.5F);

		open[14].addBox(0F, 0F, 0F, 4, 4, 4, 0F); // Box 36
		open[14].setRotationPoint(2.5F, -10F, 0.5F);

		open[15].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 37
		open[15].setRotationPoint(-6.5F, -6F, -3.5F);

		open[16].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 38
		open[16].setRotationPoint(-3.5F, -6F, -3.5F);
		open[16].rotateAngleY = 0.27925268F;

		open[17].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 39
		open[17].setRotationPoint(-0.5F, -4F, -3.5F);

		open[18].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 40
		open[18].setRotationPoint(3.5F, -4F, -3.5F);
		open[18].rotateAngleY = -0.34906585F;

		open[19].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, 0F, 0F, 0.2F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0.2F, -0.5F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, -0.75F, 0F); // Box 41
		open[19].setRotationPoint(5F, -13F, -20.5F);

		open[20].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, 0F, 0F, 0.2F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0.2F, -0.5F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, -0.75F, 0F); // Box 42
		open[20].setRotationPoint(5F, -19F, -20.5F);

		open[21].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, 0F, 0F, 0.2F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0.2F, -0.5F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, -0.75F, 0F); // Box 43
		open[21].setRotationPoint(5F, -23F, -20.5F);

		open[22].addShapeBox(0F, 0F, 0F, 1, 2, 12, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F); // Box 44
		open[22].setRotationPoint(5F, -15F, -20.5F);

		open[23].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F); // Box 45
		open[23].setRotationPoint(5F, -20F, -20.5F);

		open[24].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F); // Box 46
		open[24].setRotationPoint(5F, -24F, -20.5F);

		open[25].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F); // Box 47
		open[25].setRotationPoint(5F, -15F, -21.5F);

		open[26].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F); // Box 48
		open[26].setRotationPoint(5F, -20F, -21.5F);

		open[27].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F); // Box 49
		open[27].setRotationPoint(5F, -24F, -21.5F);

		open[28].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.8F); // Box 50
		open[28].setRotationPoint(5F, -15F, -8.5F);

		open[29].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.8F); // Box 51
		open[29].setRotationPoint(5F, -20F, -8.5F);

		open[30].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.8F); // Box 52
		open[30].setRotationPoint(5F, -24F, -8.5F);

		open[31].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 53
		open[31].setRotationPoint(1.5F, -20F, 4.5F);
		open[31].rotateAngleY = -0.6981317F;

		open[32].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 54
		open[32].setRotationPoint(3.5F, -20F, 0.5F);
		open[32].rotateAngleY = -0.34906585F;

		open[33].addBox(0F, 0F, 0F, 2, 5, 2, 0F); // Box 55
		open[33].setRotationPoint(2F, -17F, 3.5F);

		open[34].addBox(0F, 0F, 0F, 2, 5, 2, 0F); // Box 56
		open[34].setRotationPoint(4.5F, -17F, 3.5F);

		open[35].addBox(0F, 0F, 0F, 4, 1, 4, 0F); // Box 57
		open[35].setRotationPoint(0.5F, -13F, -2F);
		open[35].rotateAngleY = -0.34906585F;

		open[36].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 58
		open[36].setRotationPoint(-6F, -24F, 4.5F);

		open[37].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 59
		open[37].setRotationPoint(-6F, -24F, 2F);
		open[37].rotateAngleY = -0.08726646F;

		open[38].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 60
		open[38].setRotationPoint(-6F, -24F, -0.5F);
		open[38].rotateAngleY = 0.06981317F;

		open[39].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 61
		open[39].setRotationPoint(-3F, -24F, 3.5F);
		open[39].rotateAngleY = 0.06981317F;

		open[40].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 62
		open[40].setRotationPoint(-3F, -24F, 1F);
		open[40].rotateAngleY = -0.08726646F;

		open[41].addBox(0F, 0F, 0F, 1, 1, 6, 0F); // Box 63
		open[41].setRotationPoint(1F, -23F, 0F);

		open[42].addBox(0F, 0F, 0F, 1, 1, 6, 0F); // Box 64
		open[42].setRotationPoint(2.5F, -23F, 0F);

		open[43].addBox(0F, 0F, 0F, 1, 1, 6, 0F); // Box 65
		open[43].setRotationPoint(4F, -23F, 0F);

		open[44].addBox(0F, 0F, 0F, 1, 1, 6, 0F); // Box 66
		open[44].setRotationPoint(5.5F, -23F, 0F);

		open[45].addBox(0F, 0F, 0F, 1, 1, 6, 0F); // Box 67
		open[45].setRotationPoint(1.75F, -24F, 0F);

		open[46].addBox(0F, 0F, 0F, 1, 1, 6, 0F); // Box 68
		open[46].setRotationPoint(3.25F, -24F, 0F);

		open[47].addBox(0F, 0F, 0F, 1, 1, 6, 0F); // Box 69
		open[47].setRotationPoint(4.75F, -24F, 0F);

		open[48].addBox(0F, 0F, 0F, 1, 1, 6, 0F); // Box 70
		open[48].setRotationPoint(2.5F, -25F, 0F);

		open[49].addBox(0F, 0F, 0F, 1, 1, 6, 0F); // Box 71
		open[49].setRotationPoint(4F, -25F, 0F);

		open[50].addBox(0F, 0F, 0F, 4, 1, 4, 0F); // Box 72
		open[50].setRotationPoint(-6F, -27F, 1F);

		open[51].addBox(0F, 0F, 0F, 4, 1, 4, 0F); // Box 73
		open[51].setRotationPoint(-6.5F, -28F, 2F);
		open[51].rotateAngleY = -0.29670597F;

		open[52].addBox(0F, 0F, 0F, 2, 1, 6, 0F); // Box 74
		open[52].setRotationPoint(0.5F, -27F, 0F);

		open[53].addBox(0F, 0F, 0F, 2, 1, 6, 0F); // Box 75
		open[53].setRotationPoint(3F, -27F, -0.5F);
		open[53].rotateAngleY = -0.08726646F;

		open[54].addBox(0F, 0F, 0F, 2, 1, 6, 0F); // Box 76
		open[54].setRotationPoint(2F, -28F, -1F);
		open[54].rotateAngleY = 0.26179939F;

		open[55].addBox(0F, 0F, 0F, 1, 5, 2, 0F); // Box 77
		open[55].setRotationPoint(5.5F, -18F, -20F);

		open[56].addBox(0F, 0F, 0F, 1, 5, 2, 0F); // Box 78
		open[56].setRotationPoint(5.5F, -18F, -17F);
		open[56].rotateAngleY = -0.03490659F;

		open[57].addBox(0F, 0F, 0F, 1, 5, 2, 0F); // Box 79
		open[57].setRotationPoint(5.5F, -18F, -14F);
		open[57].rotateAngleY = 0.17453293F;

		open[58].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 80
		open[58].setRotationPoint(5.5F, -17.5F, -12F);
		open[58].rotateAngleX = 0.33161256F;
		open[58].rotateAngleY = -0.10471976F;

		open[59].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 81
		open[59].setRotationPoint(5.5F, -21F, -20F);

		open[60].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 82
		open[60].setRotationPoint(5.5F, -21F, -13F);
		open[60].rotateAngleY = -0.08726646F;

		open[61].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 83
		open[61].setRotationPoint(5.5F, -25F, -10F);
		open[61].rotateAngleY = -0.08726646F;

		open[62].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 84
		open[62].setRotationPoint(5.5F, -25F, -12F);
		open[62].rotateAngleY = 0.26179939F;

		open[63].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 85
		open[63].setRotationPoint(5.5F, -24F, -14F);
		open[63].rotateAngleY = 0.26179939F;

		open[64].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 86
		open[64].setRotationPoint(5.5F, -24F, -16F);
		open[64].rotateAngleY = 0.2443461F;

		open[65].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 87
		open[65].setRotationPoint(5.5F, -25F, -16F);
		open[65].rotateAngleY = 0.38397244F;

		open[66].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 88
		open[66].setRotationPoint(5.5F, -24F, -20F);
		open[66].rotateAngleY = -0.19198622F;

		open[67].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 89
		open[67].setRotationPoint(5.5F, -24F, -18.5F);
		open[67].rotateAngleY = 0.15707963F;


		closed = new ModelRendererTurbo[4];
		closed[0] = new ModelRendererTurbo(this, 145, 41, textureX, textureY); // Box 14
		closed[1] = new ModelRendererTurbo(this, 185, 49, textureX, textureY); // Box 15
		closed[2] = new ModelRendererTurbo(this, 169, 1, textureX, textureY); // Box 20
		closed[3] = new ModelRendererTurbo(this, 177, 1, textureX, textureY); // Box 21

		closed[0].addShapeBox(0F, 0F, 0F, 15, 10, 1, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 14
		closed[0].setRotationPoint(-7.5F, -11.5F, -8F);

		closed[1].addShapeBox(0F, 0F, 0F, 15, 19, 1, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 15
		closed[1].setRotationPoint(-7.5F, -30.5F, -8F);

		closed[2].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 20
		closed[2].setRotationPoint(-7F, -10F, -8F);

		closed[3].addBox(0F, 0F, 0F, 1, 3, 1, 0F); // Box 21
		closed[3].setRotationPoint(-7F, -16F, -8F);
		
		translateAll(0F, 24F, 0F);
		
	}
}