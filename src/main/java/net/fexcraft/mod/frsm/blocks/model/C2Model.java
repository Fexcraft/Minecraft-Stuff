//This File was created with the Minecraft-SMP Modelling Toolbox 2.2.1.1
// Copyright (C) 2015 Minecraft-SMP.de

package net.fexcraft.mod.frsm.blocks.model;

import net.fexcraft.mod.lib.tmt.ModelConverter;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class C2Model extends ModelConverter {
	
	int textureX = 512;
	int textureY = 512;

	public C2Model(){
		
		model = new ModelRendererTurbo[112];
		model[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		model[1] = new ModelRendererTurbo(this, 233, 1, textureX, textureY); // Box 1
		model[2] = new ModelRendererTurbo(this, 345, 1, textureX, textureY); // Box 2
		model[3] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 3
		model[4] = new ModelRendererTurbo(this, 409, 9, textureX, textureY); // Box 4
		model[5] = new ModelRendererTurbo(this, 113, 57, textureX, textureY); // Box 5
		model[6] = new ModelRendererTurbo(this, 225, 57, textureX, textureY); // Box 6
		model[7] = new ModelRendererTurbo(this, 337, 57, textureX, textureY); // Box 7
		model[8] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Box 8
		model[9] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 9
		model[10] = new ModelRendererTurbo(this, 401, 65, textureX, textureY); // Box 10
		model[11] = new ModelRendererTurbo(this, 73, 113, textureX, textureY); // Box 11
		model[12] = new ModelRendererTurbo(this, 185, 113, textureX, textureY); // Box 12
		model[13] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 14
		model[14] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 15
		model[15] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 16
		model[16] = new ModelRendererTurbo(this, 297, 1, textureX, textureY); // Box 17
		model[17] = new ModelRendererTurbo(this, 289, 113, textureX, textureY); // Box 18
		model[18] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 19
		model[19] = new ModelRendererTurbo(this, 409, 1, textureX, textureY); // Box 20
		model[20] = new ModelRendererTurbo(this, 345, 121, textureX, textureY); // Box 21
		model[21] = new ModelRendererTurbo(this, 297, 41, textureX, textureY); // Box 22
		model[22] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 23
		model[23] = new ModelRendererTurbo(this, 65, 57, textureX, textureY); // Box 24
		model[24] = new ModelRendererTurbo(this, 409, 137, textureX, textureY); // Box 25
		model[25] = new ModelRendererTurbo(this, 177, 57, textureX, textureY); // Box 26
		model[26] = new ModelRendererTurbo(this, 1, 169, textureX, textureY); // Box 27
		model[27] = new ModelRendererTurbo(this, 57, 169, textureX, textureY); // Box 28
		model[28] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 29
		model[29] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Box 30
		model[30] = new ModelRendererTurbo(this, 113, 169, textureX, textureY); // Box 31
		model[31] = new ModelRendererTurbo(this, 113, 177, textureX, textureY); // Box 32
		model[32] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 33
		model[33] = new ModelRendererTurbo(this, 297, 1, textureX, textureY); // Box 35
		model[34] = new ModelRendererTurbo(this, 289, 57, textureX, textureY); // Box 36
		model[35] = new ModelRendererTurbo(this, 345, 1, textureX, textureY); // Box 37
		model[36] = new ModelRendererTurbo(this, 289, 65, textureX, textureY); // Box 38
		model[37] = new ModelRendererTurbo(this, 369, 1, textureX, textureY); // Box 39
		model[38] = new ModelRendererTurbo(this, 217, 169, textureX, textureY); // Box 40
		model[39] = new ModelRendererTurbo(this, 137, 113, textureX, textureY); // Box 41
		model[40] = new ModelRendererTurbo(this, 465, 1, textureX, textureY); // Box 42
		model[41] = new ModelRendererTurbo(this, 489, 1, textureX, textureY); // Box 43
		model[42] = new ModelRendererTurbo(this, 409, 9, textureX, textureY); // Box 44
		model[43] = new ModelRendererTurbo(this, 433, 9, textureX, textureY); // Box 45
		model[44] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 46
		model[45] = new ModelRendererTurbo(this, 25, 17, textureX, textureY); // Box 47
		model[46] = new ModelRendererTurbo(this, 241, 17, textureX, textureY); // Box 48
		model[47] = new ModelRendererTurbo(this, 297, 17, textureX, textureY); // Box 49
		model[48] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Box 50
		model[49] = new ModelRendererTurbo(this, 265, 17, textureX, textureY); // Box 51
		model[50] = new ModelRendererTurbo(this, 289, 177, textureX, textureY); // Box 52
		model[51] = new ModelRendererTurbo(this, 65, 73, textureX, textureY); // Box 53
		model[52] = new ModelRendererTurbo(this, 177, 73, textureX, textureY); // Box 54
		model[53] = new ModelRendererTurbo(this, 345, 17, textureX, textureY); // Box 55
		model[54] = new ModelRendererTurbo(this, 369, 17, textureX, textureY); // Box 56
		model[55] = new ModelRendererTurbo(this, 465, 17, textureX, textureY); // Box 57
		model[56] = new ModelRendererTurbo(this, 185, 25, textureX, textureY); // Box 58
		model[57] = new ModelRendererTurbo(this, 409, 25, textureX, textureY); // Box 59
		model[58] = new ModelRendererTurbo(this, 433, 25, textureX, textureY); // Box 61
		model[59] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 62
		model[60] = new ModelRendererTurbo(this, 241, 33, textureX, textureY); // Box 63
		model[61] = new ModelRendererTurbo(this, 465, 33, textureX, textureY); // Box 64
		model[62] = new ModelRendererTurbo(this, 25, 33, textureX, textureY); // Box 65
		model[63] = new ModelRendererTurbo(this, 369, 33, textureX, textureY); // Box 66
		model[64] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 67
		model[65] = new ModelRendererTurbo(this, 345, 57, textureX, textureY); // Box 68
		model[66] = new ModelRendererTurbo(this, 401, 65, textureX, textureY); // Box 69
		model[67] = new ModelRendererTurbo(this, 465, 65, textureX, textureY); // Box 70
		model[68] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 71
		model[69] = new ModelRendererTurbo(this, 497, 33, textureX, textureY); // Box 72
		model[70] = new ModelRendererTurbo(this, 33, 57, textureX, textureY); // Box 73
		model[71] = new ModelRendererTurbo(this, 113, 185, textureX, textureY); // Box 74
		model[72] = new ModelRendererTurbo(this, 289, 73, textureX, textureY); // Box 75
		model[73] = new ModelRendererTurbo(this, 321, 73, textureX, textureY); // Box 76
		model[74] = new ModelRendererTurbo(this, 145, 57, textureX, textureY); // Box 77
		model[75] = new ModelRendererTurbo(this, 257, 57, textureX, textureY); // Box 78
		model[76] = new ModelRendererTurbo(this, 361, 193, textureX, textureY); // Box 79
		model[77] = new ModelRendererTurbo(this, 1, 201, textureX, textureY); // Box 80
		model[78] = new ModelRendererTurbo(this, 353, 73, textureX, textureY); // Box 81
		model[79] = new ModelRendererTurbo(this, 177, 209, textureX, textureY); // Box 82
		model[80] = new ModelRendererTurbo(this, 241, 113, textureX, textureY); // Box 83
		model[81] = new ModelRendererTurbo(this, 241, 137, textureX, textureY); // Box 84
		model[82] = new ModelRendererTurbo(this, 81, 113, textureX, textureY); // Box 85
		model[83] = new ModelRendererTurbo(this, 137, 113, textureX, textureY); // Box 86
		model[84] = new ModelRendererTurbo(this, 401, 81, textureX, textureY); // Box 87
		model[85] = new ModelRendererTurbo(this, 409, 41, textureX, textureY); // Box 88
		model[86] = new ModelRendererTurbo(this, 465, 81, textureX, textureY); // Box 89
		model[87] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 90
		model[88] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 91
		model[89] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 92
		model[90] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Box 93
		model[91] = new ModelRendererTurbo(this, 425, 81, textureX, textureY); // Box 94
		model[92] = new ModelRendererTurbo(this, 321, 1, textureX, textureY); // Box 95
		model[93] = new ModelRendererTurbo(this, 321, 17, textureX, textureY); // Box 96
		model[94] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 97
		model[95] = new ModelRendererTurbo(this, 481, 1, textureX, textureY); // Box 98
		model[96] = new ModelRendererTurbo(this, 497, 65, textureX, textureY); // Box 99
		model[97] = new ModelRendererTurbo(this, 33, 81, textureX, textureY); // Box 100
		model[98] = new ModelRendererTurbo(this, 233, 233, textureX, textureY); // Box 101
		model[99] = new ModelRendererTurbo(this, 65, 225, textureX, textureY); // Box 99
		model[100] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Box 100
		model[101] = new ModelRendererTurbo(this, 17, 113, textureX, textureY); // Box 101
		model[102] = new ModelRendererTurbo(this, 465, 49, textureX, textureY); // Box 102
		model[103] = new ModelRendererTurbo(this, 113, 241, textureX, textureY); // Box 103
		model[104] = new ModelRendererTurbo(this, 65, 89, textureX, textureY); // Box 104
		model[105] = new ModelRendererTurbo(this, 177, 89, textureX, textureY); // Box 105
		model[106] = new ModelRendererTurbo(this, 185, 9, textureX, textureY); // Box 106
		model[107] = new ModelRendererTurbo(this, 209, 9, textureX, textureY); // Box 107
		model[108] = new ModelRendererTurbo(this, 497, 25, textureX, textureY); // Box 120
		model[109] = new ModelRendererTurbo(this, 353, 41, textureX, textureY); // Box 129
		model[110] = new ModelRendererTurbo(this, 129, 57, textureX, textureY); // Box 130
		model[111] = new ModelRendererTurbo(this, 241, 57, textureX, textureY); // Box 131

		model[0].addBox(0F, 0F, 0F, 64, 5, 48, 0F); // Box 0
		model[0].setRotationPoint(-47F, 4F, -24F);

		model[1].addShapeBox(0F, 0F, 0F, 4, 5, 50, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 1
		model[1].setRotationPoint(17F, 4F, -25F);

		model[2].addShapeBox(0F, 0F, 0F, 4, 7, 48, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F); // Box 2
		model[2].setRotationPoint(21F, -3F, -24F);

		model[3].addShapeBox(0F, 0F, 0F, 4, 3, 48, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 3
		model[3].setRotationPoint(25F, -3F, -24F);

		model[4].addBox(0F, 0F, 0F, 1, 2, 48, 0F); // Box 4
		model[4].setRotationPoint(29F, -3F, -24F);

		model[5].addShapeBox(0F, 0F, 0F, 4, 3, 48, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 5
		model[5].setRotationPoint(30F, -3F, -24F);

		model[6].addShapeBox(0F, 0F, 0F, 4, 7, 48, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F); // Box 6
		model[6].setRotationPoint(34F, -3F, -24F);

		model[7].addShapeBox(0F, 0F, 0F, 4, 5, 50, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 7
		model[7].setRotationPoint(38F, 4F, -25F);

		model[8].addBox(0F, 0F, 0F, 21, 10, 36, 0F); // Box 8
		model[8].setRotationPoint(19F, -1F, -18F);

		model[9].addBox(0F, 0F, 0F, 3, 3, 44, 0F); // Box 9
		model[9].setRotationPoint(28F, 7F, -22F);

		model[10].addBox(0F, 0F, 0F, 4, 7, 48, 0F); // Box 10
		model[10].setRotationPoint(38F, -3F, -24F);

		model[11].addShapeBox(0F, 0F, 0F, 4, 5, 50, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F); // Box 11
		model[11].setRotationPoint(42F, 4F, -25F);

		model[12].addShapeBox(0F, 0F, 0F, 3, 7, 48, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 12
		model[12].setRotationPoint(42F, -3F, -24F);

		model[13].addBox(0F, 0F, 0F, 4, 3, 6, 0F); // Box 14
		model[13].setRotationPoint(40.5F, -6F, 16F);

		model[14].addBox(0F, 0F, 0F, 4, 3, 6, 0F); // Box 15
		model[14].setRotationPoint(40.5F, -6F, -22F);

		model[15].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 16
		model[15].setRotationPoint(42F, -6F, 22F);

		model[16].addBox(0F, 0F, 0F, 5, 3, 32, 0F); // Box 17
		model[16].setRotationPoint(40F, -6F, -16F);

		model[17].addShapeBox(0F, 0F, 0F, 3, 1, 48, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 18
		model[17].setRotationPoint(42F, -7F, -24F);

		model[18].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 19
		model[18].setRotationPoint(42F, -6F, -24F);

		model[19].addBox(0F, 0F, 0F, 25, 4, 2, 0F); // Box 20
		model[19].setRotationPoint(17F, -7F, 22F);

		model[20].addBox(0F, 0F, 0F, 4, 7, 48, 0F); // Box 21
		model[20].setRotationPoint(17F, -3F, -24F);

		model[21].addBox(0F, 0F, 0F, 25, 4, 2, 0F); // Box 22
		model[21].setRotationPoint(17F, -7F, -24F);

		model[22].addBox(0F, 0F, 0F, 1, 3, 16, 0F); // Box 23
		model[22].setRotationPoint(-83.2F, 4.5F, -8F);

		model[23].addShapeBox(0F, 0F, 0F, 25, 2, 12, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 24
		model[23].setRotationPoint(17F, -9F, 12F);

		model[24].addBox(0F, 0F, 0F, 1, 4, 44, 0F); // Box 25
		model[24].setRotationPoint(17F, -7F, -22F);

		model[25].addShapeBox(0F, 0F, 0F, 25, 2, 12, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 26
		model[25].setRotationPoint(17F, -9F, -24F);

		model[26].addShapeBox(0F, 0F, 0F, 27, 2, 24, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 27
		model[26].setRotationPoint(15F, -9F, -12F);

		model[27].addShapeBox(0F, 0F, 0F, 3, 1, 48, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 28
		model[27].setRotationPoint(42F, -8F, -24F);

		model[28].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 29
		model[28].setRotationPoint(42.5F, -5.5F, -24F);

		model[29].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 30
		model[29].setRotationPoint(42.5F, -5.5F, 23F);

		model[30].addBox(0F, 0F, 0F, 64, 5, 1, 0F); // Box 31
		model[30].setRotationPoint(-47F, 4F, 24F);

		model[31].addBox(0F, 0F, 0F, 64, 5, 1, 0F); // Box 32
		model[31].setRotationPoint(-47F, 4F, -25F);

		model[32].addShapeBox(0F, 0F, 0F, 4, 5, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 33
		model[32].setRotationPoint(-51F, 4F, -25F);

		model[33].addShapeBox(0F, 0F, 0F, 4, 5, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 35
		model[33].setRotationPoint(-51F, 4F, 18F);

		model[34].addBox(0F, 0F, 0F, 25, 5, 1, 0F); // Box 36
		model[34].setRotationPoint(-72F, 4F, 17F);

		model[35].addShapeBox(0F, 0F, 0F, 4, 5, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 37
		model[35].setRotationPoint(-72F, 4F, 18F);

		model[36].addBox(0F, 0F, 0F, 25, 5, 1, 0F); // Box 38
		model[36].setRotationPoint(-72F, 4F, -18F);

		model[37].addShapeBox(0F, 0F, 0F, 4, 5, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 39
		model[37].setRotationPoint(-72F, 4F, -25F);

		model[38].addBox(0F, 0F, 0F, 25, 5, 34, 0F); // Box 40
		model[38].setRotationPoint(-72F, 4F, -17F);

		model[39].addBox(0F, 0F, 0F, 3, 3, 44, 0F); // Box 41
		model[39].setRotationPoint(-61F, 7F, -22F);

		model[40].addShapeBox(0F, 0F, 0F, 4, 7, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F); // Box 42
		model[40].setRotationPoint(-55F, -3F, 18F);

		model[41].addShapeBox(0F, 0F, 0F, 4, 7, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F); // Box 43
		model[41].setRotationPoint(-55F, -3F, -24F);

		model[42].addShapeBox(0F, 0F, 0F, 4, 7, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F); // Box 44
		model[42].setRotationPoint(-68F, -3F, 18F);

		model[43].addShapeBox(0F, 0F, 0F, 4, 7, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F); // Box 45
		model[43].setRotationPoint(-68F, -3F, -24F);

		model[44].addShapeBox(0F, 0F, 0F, 4, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 46
		model[44].setRotationPoint(-59F, -3F, 18F);

		model[45].addShapeBox(0F, 0F, 0F, 4, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 47
		model[45].setRotationPoint(-59F, -3F, -24F);

		model[46].addShapeBox(0F, 0F, 0F, 4, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 48
		model[46].setRotationPoint(-64F, -3F, 18F);

		model[47].addShapeBox(0F, 0F, 0F, 4, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 49
		model[47].setRotationPoint(-64F, -3F, -24F);

		model[48].addBox(0F, 0F, 0F, 1, 2, 6, 0F); // Box 50
		model[48].setRotationPoint(-60F, -3F, 18F);

		model[49].addBox(0F, 0F, 0F, 1, 2, 6, 0F); // Box 51
		model[49].setRotationPoint(-60F, -3F, -24F);

		model[50].addBox(0F, 0F, 0F, 7, 5, 50, 0F); // Box 52
		model[50].setRotationPoint(-79F, 4F, -25F);

		model[51].addShapeBox(0F, 0F, 0F, 39, 14, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 53
		model[51].setRotationPoint(-51F, -10F, 23F);

		model[52].addShapeBox(0F, 0F, 0F, 39, 14, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 54
		model[52].setRotationPoint(-51F, -10F, -24F);

		model[53].addShapeBox(0F, 0F, 0F, 4, 7, 6, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 55
		model[53].setRotationPoint(-51F, -3F, 17F);

		model[54].addShapeBox(0F, 0F, 0F, 4, 7, 6, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 56
		model[54].setRotationPoint(-51F, -3F, -23F);

		model[55].addBox(0F, 0F, 0F, 17, 7, 1, 0F); // Box 57
		model[55].setRotationPoint(-68F, -3F, 17F);

		model[56].addBox(0F, 0F, 0F, 17, 7, 1, 0F); // Box 58
		model[56].setRotationPoint(-68F, -3F, -18F);

		model[57].addShapeBox(0F, 0F, 0F, 4, 7, 6, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 59
		model[57].setRotationPoint(-72F, -3F, 17F);

		model[58].addShapeBox(0F, 0F, 0F, 4, 7, 6, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 61
		model[58].setRotationPoint(-72F, -3F, -23F);

		model[59].addShapeBox(0F, 0F, 0F, 4, 2, 6, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 62
		model[59].setRotationPoint(-55F, -5F, 17F);

		model[60].addBox(0F, 0F, 0F, 9, 2, 6, 0F); // Box 63
		model[60].setRotationPoint(-64F, -5F, 17F);

		model[61].addBox(0F, 0F, 0F, 9, 2, 6, 0F); // Box 64
		model[61].setRotationPoint(-64F, -5F, -23F);

		model[62].addShapeBox(0F, 0F, 0F, 4, 2, 6, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 65
		model[62].setRotationPoint(-55F, -5F, -23F);

		model[63].addShapeBox(0F, 0F, 0F, 4, 2, 6, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 66
		model[63].setRotationPoint(-68F, -5F, 17F);

		model[64].addShapeBox(0F, 0F, 0F, 4, 2, 6, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 67
		model[64].setRotationPoint(-68F, -5F, -23F);

		model[65].addShapeBox(0F, 0F, 0F, 17, 7, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 68
		model[65].setRotationPoint(-68F, -10F, -24F);

		model[66].addShapeBox(0F, 0F, 0F, 17, 7, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 69
		model[66].setRotationPoint(-68F, -10F, 23F);

		model[67].addShapeBox(0F, 0F, 0F, 12, 14, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 70
		model[67].setRotationPoint(-80F, -10F, 23F);

		model[68].addShapeBox(0F, 0F, 0F, 12, 14, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 71
		model[68].setRotationPoint(-80F, -10F, -24F);

		model[69].addShapeBox(0F, 0F, 0F, 2, 14, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 72
		model[69].setRotationPoint(-82F, -10F, 20F);

		model[70].addShapeBox(0F, 0F, 0F, 2, 14, 4, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 73
		model[70].setRotationPoint(-82F, -10F, -24F);

		model[71].addShapeBox(0F, 0F, 0F, 4, 5, 50, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F); // Box 74
		model[71].setRotationPoint(-83F, 4F, -25F);

		model[72].addShapeBox(0F, 0F, 0F, 2, 2, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 75
		model[72].setRotationPoint(15F, -9F, 12F);

		model[73].addShapeBox(0F, 0F, 0F, 2, 2, 12, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 76
		model[73].setRotationPoint(15F, -9F, -24F);

		model[74].addBox(0F, 0F, 0F, 4, 11, 2, 0F); // Box 77
		model[74].setRotationPoint(13F, -7F, 22F);

		model[75].addBox(0F, 0F, 0F, 4, 11, 2, 0F); // Box 78
		model[75].setRotationPoint(13F, -7F, -24F);

		model[76].addShapeBox(0F, 0F, 0F, 6, 4, 44, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 79
		model[76].setRotationPoint(11F, -7F, -22F);

		model[77].addBox(0F, 0F, 0F, 2, 2, 48, 0F); // Box 80
		model[77].setRotationPoint(13F, -9F, -24F);

		model[78].addShapeBox(0F, 0F, 0F, 4, 4, 12, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 81
		model[78].setRotationPoint(9F, -9F, 7F);

		model[79].addBox(0F, 0F, 0F, 2, 14, 48, 0F); // Box 82
		model[79].setRotationPoint(-12F, -10F, -24F);

		model[80].addBox(0F, 0F, 0F, 15, 2, 16, 0F); // Box 83
		model[80].setRotationPoint(-9F, 2F, 5F);

		model[81].addBox(0F, 0F, 0F, 15, 2, 16, 0F); // Box 84
		model[81].setRotationPoint(-9F, 2F, -21F);

		model[82].addShapeBox(0F, 0F, 0F, 3, 16, 16, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 85
		model[82].setRotationPoint(-9F, -14F, 5F);

		model[83].addShapeBox(0F, 0F, 0F, 3, 16, 16, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 86
		model[83].setRotationPoint(-9F, -14F, -21F);

		model[84].addBox(0F, 0F, 0F, 1, 3, 16, 0F); // Box 87
		model[84].setRotationPoint(45.2F, 4.5F, -8F);

		model[85].addShapeBox(0F, 0F, 0F, 12, 3, 4, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 88
		model[85].setRotationPoint(-8F, 1F, -2F);

		model[86].addBox(0F, 0F, 0F, 10, 4, 8, 0F); // Box 89
		model[86].setRotationPoint(7F, 0F, -4F);

		model[87].addShapeBox(0F, 0F, 0F, 10, 6, 8, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 90
		model[87].setRotationPoint(7F, -6F, -4F);

		model[88].addBox(0F, 0F, 0F, 1, 7, 1, 0F); // Box 91
		model[88].setRotationPoint(3F, -1F, -0.5F);
		model[88].rotateAngleY = -0.01745329F;
		model[88].rotateAngleZ = -1.23918377F;

		model[89].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 92
		model[89].setRotationPoint(8F, -7F, -0.5F);
		model[89].rotateAngleZ = 0.34906585F;

		model[90].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 93
		model[90].setRotationPoint(6F, -10F, 12.5F);
		model[90].rotateAngleZ = -0.26179939F;

		model[91].addBox(0F, -3F, -3F, 1, 7, 7, 0F); // Box 94
		model[91].setRotationPoint(5F, -10F, 13F);
		model[91].rotateAngleZ = -0.26179939F;

		model[92].addBox(0F, 0F, 0F, 1, 14, 1, 0F); // Box 95
		model[92].setRotationPoint(12F, -9F, 22F);

		model[93].addBox(0F, 0F, 0F, 1, 14, 1, 0F); // Box 96
		model[93].setRotationPoint(12F, -9F, -23F);

		model[94].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 97
		model[94].setRotationPoint(14F, 2F, 9F);

		model[95].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 98
		model[95].setRotationPoint(14F, 2F, 13F);

		model[96].addBox(0F, 0F, 0F, 2, 13, 2, 0F); // Box 99
		model[96].setRotationPoint(-12F, -23F, 22F);

		model[97].addBox(0F, 0F, 0F, 2, 13, 2, 0F); // Box 100
		model[97].setRotationPoint(-12F, -23F, -24F);

		model[98].addBox(0F, 0F, 0F, 22, 1, 48, 0F); // Box 101
		model[98].setRotationPoint(-13F, -24F, -24F);

		model[99].addBox(0F, 0F, 0F, 1, 13, 44, 0F); // Box 99
		model[99].setRotationPoint(-11F, -23F, -22F);

		model[100].addBox(0F, 0F, 0F, 2, 16, 2, 0F); // Box 100
		model[100].setRotationPoint(7F, -23F, 22F);
		model[100].rotateAngleZ = 0.38397244F;

		model[101].addBox(0F, 0F, 0F, 2, 16, 2, 0F); // Box 101
		model[101].setRotationPoint(7F, -23F, -24F);
		model[101].rotateAngleZ = 0.38397244F;

		model[102].addShapeBox(0F, 0F, 0F, 12, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 102
		model[102].setRotationPoint(-82F, 8F, -14F);

		model[103].addBox(0F, 0F, 0F, 1, 16, 44, 0F); // Box 103
		model[103].setRotationPoint(7F, -23F, -22F);
		model[103].rotateAngleZ = 0.38397244F;

		model[104].addBox(0F, 0F, 0F, 23, 13, 1, 0F); // Box 104
		model[104].setRotationPoint(-10F, -9F, 23F);

		model[105].addBox(0F, 0F, 0F, 23, 13, 1, 0F); // Box 105
		model[105].setRotationPoint(-10F, -9F, -24F);

		model[106].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 106
		model[106].setRotationPoint(-6F, -7F, 23.2F);

		model[107].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 107
		model[107].setRotationPoint(-6F, -7F, -24.2F);

		model[108].addBox(0F, 0F, 0F, 1, 1, 6, 0F); // Box 120
		model[108].setRotationPoint(29F, 8F, 18.5F);

		model[109].addBox(0F, 0F, 0F, 1, 1, 6, 0F); // Box 129
		model[109].setRotationPoint(29F, 8F, -24.5F);

		model[110].addBox(0F, 0F, 0F, 1, 1, 6, 0F); // Box 130
		model[110].setRotationPoint(-60F, 8F, -24.5F);

		model[111].addBox(0F, 0F, 0F, 1, 1, 6, 0F); // Box 131
		model[111].setRotationPoint(-60F, 8F, 18.5F);

		translateAll(0F, 0F, 0F);
		
		
	}
}