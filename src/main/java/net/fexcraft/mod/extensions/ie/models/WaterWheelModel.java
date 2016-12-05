//This File was created with the Minecraft-SMP Modelling Toolbox 2.2.2.2
// Copyright (C) 2016 Minecraft-SMP.de

// Model: WW1
// Model Creator: FEX___96 
// Created on: 22.07.2016 - 12:19:39
// Last changed on: 22.07.2016 - 12:19:39

package net.fexcraft.mod.extensions.ie.models;

import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class WaterWheelModel extends CabelModelBase
{
	int textureX = 512;
	int textureY = 128;

	public WaterWheelModel()
	{
		base = new ModelRendererTurbo[15];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		base[1] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 1
		base[2] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 2
		base[3] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 3
		base[4] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 4
		base[5] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box 5
		base[6] = new ModelRendererTurbo(this, 225, 1, textureX, textureY); // Box 6
		base[7] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Box 7
		base[8] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 8
		base[9] = new ModelRendererTurbo(this, 273, 1, textureX, textureY); // Box 9
		base[10] = new ModelRendererTurbo(this, 313, 1, textureX, textureY); // Box 10
		base[11] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 11
		base[12] = new ModelRendererTurbo(this, 393, 1, textureX, textureY); // Box 12
		base[13] = new ModelRendererTurbo(this, 417, 1, textureX, textureY); // Box 13
		base[14] = new ModelRendererTurbo(this, 433, 1, textureX, textureY); // Box 14

		base[0].addBox(0F, 0F, 0F, 1, 8, 12, 0F); // Box 0
		base[0].setRotationPoint(-8F, -4F, -7F);

		base[1].addBox(0F, 0F, 0F, 8, 1, 12, 0F); // Box 1
		base[1].setRotationPoint(-4F, 7F, -7F);

		base[2].addBox(0F, 0F, 0F, 1, 8, 12, 0F); // Box 2
		base[2].setRotationPoint(7F, -4F, -7F);

		base[3].addBox(0F, 0F, 0F, 8, 1, 12, 0F); // Box 3
		base[3].setRotationPoint(-4F, -8F, -7F);

		base[4].addShapeBox(0F, 0F, 0F, 1, 4, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, -1F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 3F, -1F, 0F); // Box 4
		base[4].setRotationPoint(7F, 4F, -7F);

		base[5].addShapeBox(0F, 0F, 0F, 1, 4, 12, 0F, 3F, -1F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 3F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 5
		base[5].setRotationPoint(7F, -8F, -7F);

		base[6].addShapeBox(0F, 0F, 0F, 1, 4, 12, 0F, -4F, 0F, 0F, 3F, -1F, 0F, 3F, -1F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 6
		base[6].setRotationPoint(-8F, -8F, -7F);

		base[7].addShapeBox(0F, 0F, 0F, 1, 4, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 3F, -1F, 0F, 3F, -1F, 0F, -4F, 0F, 0F); // Box 7
		base[7].setRotationPoint(-8F, 4F, -7F);

		base[8].addShapeBox(0F, 0F, 0F, 10, 4, 2, 0F, -0.75F, 0.25F, 0F, -0.75F, 0.25F, 0F, -0.75F, -0.75F, 0F, -0.75F, -0.75F, 0F, -0.75F, -0.75F, 0F, -0.75F, -0.75F, 0F, -0.75F, -1F, 0F, -0.75F, -1F, 0F); // Box 8
		base[8].setRotationPoint(-5F, 5F, 6F);

		base[9].addShapeBox(0F, 0F, 0F, 16, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, -3.75F, 0F, 0F, -3.75F, 0F, 0F); // Box 9
		base[9].setRotationPoint(-8F, 4F, 5F);

		base[10].addShapeBox(0F, 0F, 0F, 16, 8, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F); // Box 10
		base[10].setRotationPoint(-8F, -4F, 5F);

		base[11].addShapeBox(0F, 0F, 0F, 16, 4, 1, 0F, -4F, 0F, 0F, -4F, 0F, 0F, -7F, -1F, 0F, -7F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F); // Box 11
		base[11].setRotationPoint(-8F, -8F, 5F);

		base[12].addShapeBox(0F, 0F, 0F, 8, 16, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 12
		base[12].setRotationPoint(-4F, -8F, -8F);

		base[13].addShapeBox(0F, 0F, 0F, 4, 16, 1, 0F, -1F, -5F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, -1F, -5F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -4F, 0F); // Box 13
		base[13].setRotationPoint(-8F, -8F, -8F);

		base[14].addShapeBox(0F, 0F, 0F, 4, 16, 1, 0F, 0F, -1F, 0F, -1F, -5F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -5F, 0F, 0F, -4F, 0F, 0F, 0F, 0F); // Box 14
		base[14].setRotationPoint(4F, -8F, -8F);


		rotor = new ModelRendererTurbo[127];
		rotor[0] = new ModelRendererTurbo(this, 433, 1, textureX, textureY); // Box 15
		rotor[1] = new ModelRendererTurbo(this, 273, 9, textureX, textureY); // Box 16
		rotor[2] = new ModelRendererTurbo(this, 337, 9, textureX, textureY); // Box 17
		rotor[3] = new ModelRendererTurbo(this, 137, 1, textureX, textureY); // Box 18
		rotor[4] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // Box 19
		rotor[5] = new ModelRendererTurbo(this, 465, 1, textureX, textureY); // Box 20
		rotor[6] = new ModelRendererTurbo(this, 481, 1, textureX, textureY); // Box 21
		rotor[7] = new ModelRendererTurbo(this, 497, 1, textureX, textureY); // Box 22
		rotor[8] = new ModelRendererTurbo(this, 305, 9, textureX, textureY); // Box 23
		rotor[9] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 24
		rotor[10] = new ModelRendererTurbo(this, 321, 17, textureX, textureY); // Box 25
		rotor[11] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 26
		rotor[12] = new ModelRendererTurbo(this, 97, 25, textureX, textureY); // Box 27
		rotor[13] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 28
		rotor[14] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 29
		rotor[15] = new ModelRendererTurbo(this, 177, 1, textureX, textureY); // Box 30
		rotor[16] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Box 31
		rotor[17] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 32
		rotor[18] = new ModelRendererTurbo(this, 145, 1, textureX, textureY); // Box 33
		rotor[19] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 34
		rotor[20] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 35
		rotor[21] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Box 36
		rotor[22] = new ModelRendererTurbo(this, 369, 9, textureX, textureY); // Box 37
		rotor[23] = new ModelRendererTurbo(this, 113, 17, textureX, textureY); // Box 38
		rotor[24] = new ModelRendererTurbo(this, 385, 17, textureX, textureY); // Box 39
		rotor[25] = new ModelRendererTurbo(this, 137, 25, textureX, textureY); // Box 40
		rotor[26] = new ModelRendererTurbo(this, 161, 25, textureX, textureY); // Box 41
		rotor[27] = new ModelRendererTurbo(this, 489, 17, textureX, textureY); // Box 42
		rotor[28] = new ModelRendererTurbo(this, 41, 25, textureX, textureY); // Box 43
		rotor[29] = new ModelRendererTurbo(this, 185, 25, textureX, textureY); // Box 44
		rotor[30] = new ModelRendererTurbo(this, 209, 25, textureX, textureY); // Box 45
		rotor[31] = new ModelRendererTurbo(this, 233, 25, textureX, textureY); // Box 46
		rotor[32] = new ModelRendererTurbo(this, 249, 25, textureX, textureY); // Box 47
		rotor[33] = new ModelRendererTurbo(this, 321, 25, textureX, textureY); // Box 48
		rotor[34] = new ModelRendererTurbo(this, 401, 25, textureX, textureY); // Box 49
		rotor[35] = new ModelRendererTurbo(this, 425, 25, textureX, textureY); // Box 50
		rotor[36] = new ModelRendererTurbo(this, 449, 25, textureX, textureY); // Box 51
		rotor[37] = new ModelRendererTurbo(this, 465, 25, textureX, textureY); // Box 52
		rotor[38] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 53
		rotor[39] = new ModelRendererTurbo(this, 25, 33, textureX, textureY); // Box 54
		rotor[40] = new ModelRendererTurbo(this, 57, 33, textureX, textureY); // Box 55
		rotor[41] = new ModelRendererTurbo(this, 73, 33, textureX, textureY); // Box 56
		rotor[42] = new ModelRendererTurbo(this, 97, 33, textureX, textureY); // Box 57
		rotor[43] = new ModelRendererTurbo(this, 121, 33, textureX, textureY); // Box 58
		rotor[44] = new ModelRendererTurbo(this, 137, 33, textureX, textureY); // Box 59
		rotor[45] = new ModelRendererTurbo(this, 153, 33, textureX, textureY); // Box 60
		rotor[46] = new ModelRendererTurbo(this, 177, 33, textureX, textureY); // Box 61
		rotor[47] = new ModelRendererTurbo(this, 201, 33, textureX, textureY); // Box 62
		rotor[48] = new ModelRendererTurbo(this, 217, 33, textureX, textureY); // Box 63
		rotor[49] = new ModelRendererTurbo(this, 265, 33, textureX, textureY); // Box 64
		rotor[50] = new ModelRendererTurbo(this, 281, 33, textureX, textureY); // Box 65
		rotor[51] = new ModelRendererTurbo(this, 297, 33, textureX, textureY); // Box 66
		rotor[52] = new ModelRendererTurbo(this, 337, 33, textureX, textureY); // Box 67
		rotor[53] = new ModelRendererTurbo(this, 369, 17, textureX, textureY); // Box 78
		rotor[54] = new ModelRendererTurbo(this, 361, 33, textureX, textureY); // Box 79
		rotor[55] = new ModelRendererTurbo(this, 377, 33, textureX, textureY); // Box 80
		rotor[56] = new ModelRendererTurbo(this, 401, 33, textureX, textureY); // Box 81
		rotor[57] = new ModelRendererTurbo(this, 417, 33, textureX, textureY); // Box 82
		rotor[58] = new ModelRendererTurbo(this, 465, 33, textureX, textureY); // Box 83
		rotor[59] = new ModelRendererTurbo(this, 433, 33, textureX, textureY); // Box 84
		rotor[60] = new ModelRendererTurbo(this, 489, 33, textureX, textureY); // Box 85
		rotor[61] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 86
		rotor[62] = new ModelRendererTurbo(this, 73, 41, textureX, textureY); // Box 87
		rotor[63] = new ModelRendererTurbo(this, 97, 41, textureX, textureY); // Box 88
		rotor[64] = new ModelRendererTurbo(this, 41, 41, textureX, textureY); // Box 89
		rotor[65] = new ModelRendererTurbo(this, 153, 41, textureX, textureY); // Box 90
		rotor[66] = new ModelRendererTurbo(this, 169, 41, textureX, textureY); // Box 91
		rotor[67] = new ModelRendererTurbo(this, 185, 41, textureX, textureY); // Box 92
		rotor[68] = new ModelRendererTurbo(this, 233, 41, textureX, textureY); // Box 93
		rotor[69] = new ModelRendererTurbo(this, 249, 41, textureX, textureY); // Box 94
		rotor[70] = new ModelRendererTurbo(this, 297, 41, textureX, textureY); // Box 95
		rotor[71] = new ModelRendererTurbo(this, 313, 41, textureX, textureY); // Box 96
		rotor[72] = new ModelRendererTurbo(this, 329, 41, textureX, textureY); // Box 97
		rotor[73] = new ModelRendererTurbo(this, 345, 41, textureX, textureY); // Box 98
		rotor[74] = new ModelRendererTurbo(this, 361, 41, textureX, textureY); // Box 99
		rotor[75] = new ModelRendererTurbo(this, 377, 41, textureX, textureY); // Box 100
		rotor[76] = new ModelRendererTurbo(this, 425, 41, textureX, textureY); // Box 101
		rotor[77] = new ModelRendererTurbo(this, 449, 41, textureX, textureY); // Box 102
		rotor[78] = new ModelRendererTurbo(this, 473, 41, textureX, textureY); // Box 103
		rotor[79] = new ModelRendererTurbo(this, 497, 41, textureX, textureY); // Box 104
		rotor[80] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 105
		rotor[81] = new ModelRendererTurbo(this, 393, 41, textureX, textureY); // Box 106
		rotor[82] = new ModelRendererTurbo(this, 409, 41, textureX, textureY); // Box 107
		rotor[83] = new ModelRendererTurbo(this, 17, 49, textureX, textureY); // Box 108
		rotor[84] = new ModelRendererTurbo(this, 33, 49, textureX, textureY); // Box 109
		rotor[85] = new ModelRendererTurbo(this, 49, 49, textureX, textureY); // Box 110
		rotor[86] = new ModelRendererTurbo(this, 73, 49, textureX, textureY); // Box 111
		rotor[87] = new ModelRendererTurbo(this, 89, 49, textureX, textureY); // Box 112
		rotor[88] = new ModelRendererTurbo(this, 105, 49, textureX, textureY); // Box 113
		rotor[89] = new ModelRendererTurbo(this, 121, 49, textureX, textureY); // Box 114
		rotor[90] = new ModelRendererTurbo(this, 137, 49, textureX, textureY); // Box 115
		rotor[91] = new ModelRendererTurbo(this, 153, 49, textureX, textureY); // Box 116
		rotor[92] = new ModelRendererTurbo(this, 169, 49, textureX, textureY); // Box 117
		rotor[93] = new ModelRendererTurbo(this, 193, 49, textureX, textureY); // Box 118
		rotor[94] = new ModelRendererTurbo(this, 217, 49, textureX, textureY); // Box 119
		rotor[95] = new ModelRendererTurbo(this, 241, 49, textureX, textureY); // Box 121
		rotor[96] = new ModelRendererTurbo(this, 257, 49, textureX, textureY); // Box 122
		rotor[97] = new ModelRendererTurbo(this, 273, 49, textureX, textureY); // Box 123
		rotor[98] = new ModelRendererTurbo(this, 289, 49, textureX, textureY); // Box 124
		rotor[99] = new ModelRendererTurbo(this, 305, 49, textureX, textureY); // Box 125
		rotor[100] = new ModelRendererTurbo(this, 321, 49, textureX, textureY); // Box 126
		rotor[101] = new ModelRendererTurbo(this, 345, 49, textureX, textureY); // Box 127
		rotor[102] = new ModelRendererTurbo(this, 393, 49, textureX, textureY); // Box 128
		rotor[103] = new ModelRendererTurbo(this, 441, 49, textureX, textureY); // Box 129
		rotor[104] = new ModelRendererTurbo(this, 33, 57, textureX, textureY); // Box 130
		rotor[105] = new ModelRendererTurbo(this, 121, 57, textureX, textureY); // Box 131
		rotor[106] = new ModelRendererTurbo(this, 169, 57, textureX, textureY); // Box 132
		rotor[107] = new ModelRendererTurbo(this, 217, 57, textureX, textureY); // Box 133
		rotor[108] = new ModelRendererTurbo(this, 273, 57, textureX, textureY); // Box 134
		rotor[109] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 135
		rotor[110] = new ModelRendererTurbo(this, 65, 65, textureX, textureY); // Box 136
		rotor[111] = new ModelRendererTurbo(this, 305, 65, textureX, textureY); // Box 137
		rotor[112] = new ModelRendererTurbo(this, 353, 65, textureX, textureY); // Box 138
		rotor[113] = new ModelRendererTurbo(this, 401, 65, textureX, textureY); // Box 139
		rotor[114] = new ModelRendererTurbo(this, 449, 65, textureX, textureY); // Box 140
		rotor[115] = new ModelRendererTurbo(this, 33, 73, textureX, textureY); // Box 141
		rotor[116] = new ModelRendererTurbo(this, 97, 73, textureX, textureY); // Box 142
		rotor[117] = new ModelRendererTurbo(this, 145, 73, textureX, textureY); // Box 143
		rotor[118] = new ModelRendererTurbo(this, 193, 73, textureX, textureY); // Box 144
		rotor[119] = new ModelRendererTurbo(this, 505, 17, textureX, textureY); // Box 145
		rotor[120] = new ModelRendererTurbo(this, 489, 49, textureX, textureY); // Box 146
		rotor[121] = new ModelRendererTurbo(this, 497, 49, textureX, textureY); // Box 147
		rotor[122] = new ModelRendererTurbo(this, 505, 49, textureX, textureY); // Box 148
		rotor[123] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 149
		rotor[124] = new ModelRendererTurbo(this, 97, 57, textureX, textureY); // Box 150
		rotor[125] = new ModelRendererTurbo(this, 113, 57, textureX, textureY); // Box 151
		rotor[126] = new ModelRendererTurbo(this, 265, 57, textureX, textureY); // Box 152

		rotor[0].addBox(-1.5F, -1.5F, -26F, 3, 3, 18, 0F); // Box 15
		rotor[0].setRotationPoint(0F, 0F, 0F);

		rotor[1].addShapeBox(-1.5F, -2.5F, -26F, 3, 1, 18, 0F, -0.5F, -0.5F, -1F, -0.5F, -0.5F, -1F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 16
		rotor[1].setRotationPoint(0F, 0F, 0F);

		rotor[2].addShapeBox(-1.5F, 1.5F, -26F, 3, 1, 18, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -1F, -0.5F, -0.5F, -1F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F); // Box 17
		rotor[2].setRotationPoint(0F, 0F, 0F);

		rotor[3].addShapeBox(-2.5F, -1.5F, -26F, 1, 3, 18, 0F, -0.5F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F); // Box 18
		rotor[3].setRotationPoint(0F, 0F, 0F);

		rotor[4].addShapeBox(1.5F, -1.5F, -26F, 1, 3, 18, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -1F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -1F, -0.5F, -0.5F, 0F, 0F, 0F, 0F); // Box 19
		rotor[4].setRotationPoint(0F, 0F, 0F);

		rotor[5].addBox(-1F, -16F, -10.5F, 2, 14, 2, 0F); // Box 20
		rotor[5].setRotationPoint(0F, 0F, 0F);

		rotor[6].addBox(-1F, 2F, -10.5F, 2, 14, 2, 0F); // Box 21
		rotor[6].setRotationPoint(0F, 0F, 0F);

		rotor[7].addBox(-1F, 2F, -23.5F, 2, 14, 2, 0F); // Box 22
		rotor[7].setRotationPoint(0F, 0F, 0F);

		rotor[8].addBox(-1F, -16F, -23.5F, 2, 14, 2, 0F); // Box 23
		rotor[8].setRotationPoint(0F, 0F, 0F);

		rotor[9].addBox(2F, -1F, -23.5F, 14, 2, 2, 0F); // Box 24
		rotor[9].setRotationPoint(0F, 0F, 0F);

		rotor[10].addBox(2F, -1F, -10.5F, 14, 2, 2, 0F); // Box 25
		rotor[10].setRotationPoint(0F, 0F, 0F);

		rotor[11].addBox(-16F, -1F, -10.5F, 14, 2, 2, 0F); // Box 26
		rotor[11].setRotationPoint(0F, 0F, 0F);

		rotor[12].addBox(-16F, -1F, -23.5F, 14, 2, 2, 0F); // Box 27
		rotor[12].setRotationPoint(0F, 0F, 0F);

		rotor[13].addBox(-4F, 24F, -23.5F, 8, 2, 2, 0F); // Box 28
		rotor[13].setRotationPoint(0F, 0F, 0F);

		rotor[14].addBox(-4F, 24F, -10.5F, 8, 2, 2, 0F); // Box 29
		rotor[14].setRotationPoint(0F, 0F, 0F);

		rotor[15].addBox(-4F, -26F, -10.5F, 8, 2, 2, 0F); // Box 30
		rotor[15].setRotationPoint(0F, 0F, 0F);

		rotor[16].addBox(-4F, -26F, -23.5F, 8, 2, 2, 0F); // Box 31
		rotor[16].setRotationPoint(0F, 0F, 0F);

		rotor[17].addBox(-26F, -4F, -23.5F, 2, 8, 2, 0F); // Box 32
		rotor[17].setRotationPoint(0F, 0F, 0F);

		rotor[18].addBox(-26F, -4F, -10.5F, 2, 8, 2, 0F); // Box 33
		rotor[18].setRotationPoint(0F, 0F, 0F);

		rotor[19].addBox(24F, -4F, -23.5F, 2, 8, 2, 0F); // Box 34
		rotor[19].setRotationPoint(0F, 0F, 0F);

		rotor[20].addBox(24F, -4F, -10.5F, 2, 8, 2, 0F); // Box 35
		rotor[20].setRotationPoint(0F, 0F, 0F);

		rotor[21].addShapeBox(24F, 4F, -10.5F, 2, 8, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 36
		rotor[21].setRotationPoint(0F, 0F, 0F);

		rotor[22].addShapeBox(4F, 24F, -10.5F, 8, 2, 2, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 37
		rotor[22].setRotationPoint(0F, 0F, 0F);

		rotor[23].addShapeBox(12F, 22F, -10.5F, 8, 2, 2, 0F, 0F, 0F, 0F, -2.5F, 4.5F, 0F, -2.5F, 4.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -5.5F, 0F, -1F, -5.5F, 0F, 0F, 0F, 0F); // Box 38
		rotor[23].setRotationPoint(0F, 0F, 0F);

		rotor[24].addShapeBox(22F, 12F, -10.5F, 2, 8, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4.5F, -2.5F, 0F, -5F, -1.5F, 0F, -5F, -1.5F, 0F, 4.5F, -2.5F, 0F); // Box 39
		rotor[24].setRotationPoint(0F, 0F, 0F);

		rotor[25].addShapeBox(4F, 24F, -23.5F, 8, 2, 2, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 40
		rotor[25].setRotationPoint(0F, 0F, 0F);

		rotor[26].addShapeBox(12F, 22F, -23.5F, 8, 2, 2, 0F, 0F, 0F, 0F, -2.5F, 4.5F, 0F, -2.5F, 4.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -5.5F, 0F, -1F, -5.5F, 0F, 0F, 0F, 0F); // Box 41
		rotor[26].setRotationPoint(0F, 0F, 0F);

		rotor[27].addShapeBox(22F, 12F, -23.5F, 2, 8, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4.5F, -2.5F, 0F, -5F, -1.5F, 0F, -5F, -1.5F, 0F, 4.5F, -2.5F, 0F); // Box 42
		rotor[27].setRotationPoint(0F, 0F, 0F);

		rotor[28].addShapeBox(24F, 4F, -23.5F, 2, 8, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 43
		rotor[28].setRotationPoint(0F, 0F, 0F);

		rotor[29].addShapeBox(4F, -26F, -23.5F, 8, 2, 2, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 44
		rotor[29].setRotationPoint(0F, 0F, 0F);

		rotor[30].addShapeBox(12F, -24F, -23.5F, 8, 2, 2, 0F, 0F, 0F, 0F, -1F, -5.5F, 0F, -1F, -5.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2.5F, 4.5F, 0F, -2.5F, 4.5F, 0F, 0F, 0F, 0F); // Box 45
		rotor[30].setRotationPoint(0F, 0F, 0F);

		rotor[31].addShapeBox(22F, -20F, -23.5F, 2, 8, 2, 0F, 4.5F, -2.5F, 0F, -5F, -1.5F, 0F, -5F, -1.5F, 0F, 4.5F, -2.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 46
		rotor[31].setRotationPoint(0F, 0F, 0F);

		rotor[32].addShapeBox(24F, -12F, -23.5F, 2, 8, 2, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 47
		rotor[32].setRotationPoint(0F, 0F, 0F);

		rotor[33].addShapeBox(24F, -12F, -10.5F, 2, 8, 2, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 48
		rotor[33].setRotationPoint(0F, 0F, 0F);

		rotor[34].addShapeBox(4F, -26F, -10.5F, 8, 2, 2, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 49
		rotor[34].setRotationPoint(0F, 0F, 0F);

		rotor[35].addShapeBox(12F, -24F, -10.5F, 8, 2, 2, 0F, 0F, 0F, 0F, -1F, -5.5F, 0F, -1F, -5.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2.5F, 4.5F, 0F, -2.5F, 4.5F, 0F, 0F, 0F, 0F); // Box 50
		rotor[35].setRotationPoint(0F, 0F, 0F);

		rotor[36].addShapeBox(22F, -20F, -10.5F, 2, 8, 2, 0F, 4.5F, -2.5F, 0F, -5F, -1.5F, 0F, -5F, -1.5F, 0F, 4.5F, -2.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 51
		rotor[36].setRotationPoint(0F, 0F, 0F);

		rotor[37].addShapeBox(-12F, 24F, -23.5F, 8, 2, 2, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 52
		rotor[37].setRotationPoint(0F, 0F, 0F);

		rotor[38].addShapeBox(-20F, 22F, -23.5F, 8, 2, 2, 0F, -2.5F, 4.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2.5F, 4.5F, 0F, -1F, -5.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -5.5F, 0F); // Box 53
		rotor[38].setRotationPoint(0F, 0F, 0F);

		rotor[39].addShapeBox(-24F, 12F, -23.5F, 2, 8, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, -1.5F, 0F, 4.5F, -2.5F, 0F, 4.5F, -2.5F, 0F, -5F, -1.5F, 0F); // Box 54
		rotor[39].setRotationPoint(0F, 0F, 0F);

		rotor[40].addShapeBox(-26F, 4F, -23.5F, 2, 8, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 55
		rotor[40].setRotationPoint(0F, 0F, 0F);

		rotor[41].addShapeBox(-12F, -26F, -23.5F, 8, 2, 2, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 56
		rotor[41].setRotationPoint(0F, 0F, 0F);

		rotor[42].addShapeBox(-20F, -24F, -23.5F, 8, 2, 2, 0F, -1F, -5.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -5.5F, 0F, -2.5F, 4.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2.5F, 4.5F, 0F); // Box 57
		rotor[42].setRotationPoint(0F, 0F, 0F);

		rotor[43].addShapeBox(-24F, -20F, -23.5F, 2, 8, 2, 0F, -5F, -1.5F, 0F, 4.5F, -2.5F, 0F, 4.5F, -2.5F, 0F, -5F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 58
		rotor[43].setRotationPoint(0F, 0F, 0F);

		rotor[44].addShapeBox(-26F, -12F, -23.5F, 2, 8, 2, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 59
		rotor[44].setRotationPoint(0F, 0F, 0F);

		rotor[45].addShapeBox(-12F, -26F, -10.5F, 8, 2, 2, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 60
		rotor[45].setRotationPoint(0F, 0F, 0F);

		rotor[46].addShapeBox(-20F, -24F, -10.5F, 8, 2, 2, 0F, -1F, -5.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -5.5F, 0F, -2.5F, 4.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2.5F, 4.5F, 0F); // Box 61
		rotor[46].setRotationPoint(0F, 0F, 0F);

		rotor[47].addShapeBox(-24F, -20F, -10.5F, 2, 8, 2, 0F, -5F, -1.5F, 0F, 4.5F, -2.5F, 0F, 4.5F, -2.5F, 0F, -5F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 62
		rotor[47].setRotationPoint(0F, 0F, 0F);

		rotor[48].addShapeBox(-26F, -12F, -10.5F, 2, 8, 2, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 63
		rotor[48].setRotationPoint(0F, 0F, 0F);

		rotor[49].addShapeBox(-26F, 4F, -10.5F, 2, 8, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 64
		rotor[49].setRotationPoint(0F, 0F, 0F);

		rotor[50].addShapeBox(-24F, 12F, -10.5F, 2, 8, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, -1.5F, 0F, 4.5F, -2.5F, 0F, 4.5F, -2.5F, 0F, -5F, -1.5F, 0F); // Box 65
		rotor[50].setRotationPoint(0F, 0F, 0F);

		rotor[51].addShapeBox(-20F, 22F, -10.5F, 8, 2, 2, 0F, -2.5F, 4.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2.5F, 4.5F, 0F, -1F, -5.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -5.5F, 0F); // Box 66
		rotor[51].setRotationPoint(0F, 0F, 0F);

		rotor[52].addShapeBox(-12F, 24F, -10.5F, 8, 2, 2, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 67
		rotor[52].setRotationPoint(0F, 0F, 0F);

		rotor[53].addBox(16F, -2F, -23.5F, 2, 4, 2, 0F); // Box 78
		rotor[53].setRotationPoint(0F, 0F, 0F);

		rotor[54].addBox(-2F, -18F, -23.5F, 4, 2, 2, 0F); // Box 79
		rotor[54].setRotationPoint(0F, 0F, 0F);

		rotor[55].addBox(18F, -1F, -23.5F, 6, 2, 2, 0F); // Box 80
		rotor[55].setRotationPoint(0F, 0F, 0F);

		rotor[56].addBox(-1F, -24F, -23.5F, 2, 6, 2, 0F); // Box 81
		rotor[56].setRotationPoint(0F, 0F, 0F);

		rotor[57].addShapeBox(16F, -8F, -23.5F, 2, 6, 2, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 82
		rotor[57].setRotationPoint(0F, 0F, 0F);

		rotor[58].addShapeBox(2F, -18F, -23.5F, 6, 2, 2, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 83
		rotor[58].setRotationPoint(0F, 0F, 0F);

		rotor[59].addShapeBox(8F, -16F, -23.5F, 4, 2, 2, 0F, 0F, 0F, 0F, 0.5F, -3F, 0F, 0.5F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 2.5F, 0F, -1F, 2.5F, 0F, 0F, 0F, 0F); // Box 84
		rotor[59].setRotationPoint(0F, 0F, 0F);

		rotor[60].addShapeBox(14F, -12F, -23.5F, 2, 4, 2, 0F, 3F, -0.5F, 0F, -3.5F, 1F, 0F, -3.5F, 1F, 0F, 3F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 85
		rotor[60].setRotationPoint(0F, 0F, 0F);

		rotor[61].addBox(-24F, -1F, -23.5F, 6, 2, 2, 0F); // Box 86
		rotor[61].setRotationPoint(0F, 0F, 0F);

		rotor[62].addBox(-24F, -1F, -10.5F, 6, 2, 2, 0F); // Box 87
		rotor[62].setRotationPoint(0F, 0F, 0F);

		rotor[63].addBox(18F, -1F, -10.5F, 6, 2, 2, 0F); // Box 88
		rotor[63].setRotationPoint(0F, 0F, 0F);

		rotor[64].addBox(16F, -2F, -10.5F, 2, 4, 2, 0F); // Box 89
		rotor[64].setRotationPoint(0F, 0F, 0F);

		rotor[65].addBox(-18F, -2F, -10.5F, 2, 4, 2, 0F); // Box 90
		rotor[65].setRotationPoint(0F, 0F, 0F);

		rotor[66].addBox(-18F, -2F, -23.5F, 2, 4, 2, 0F); // Box 91
		rotor[66].setRotationPoint(0F, 0F, 0F);

		rotor[67].addBox(-1F, -24F, -10.5F, 2, 6, 2, 0F); // Box 92
		rotor[67].setRotationPoint(0F, 0F, 0F);

		rotor[68].addBox(-1F, 18F, -23.5F, 2, 6, 2, 0F); // Box 93
		rotor[68].setRotationPoint(0F, 0F, 0F);

		rotor[69].addBox(-1F, 18F, -10.5F, 2, 6, 2, 0F); // Box 94
		rotor[69].setRotationPoint(0F, 0F, 0F);

		rotor[70].addBox(-2F, -18F, -10.5F, 4, 2, 2, 0F); // Box 95
		rotor[70].setRotationPoint(0F, 0F, 0F);

		rotor[71].addBox(-2F, 16F, -10.5F, 4, 2, 2, 0F); // Box 96
		rotor[71].setRotationPoint(0F, 0F, 0F);

		rotor[72].addBox(-2F, 16F, -23.5F, 4, 2, 2, 0F); // Box 97
		rotor[72].setRotationPoint(0F, 0F, 0F);

		rotor[73].addShapeBox(16F, 2F, -23.5F, 2, 6, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 98
		rotor[73].setRotationPoint(0F, 0F, 0F);

		rotor[74].addShapeBox(14F, 8F, -23.5F, 2, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, -0.5F, 0F, -3.5F, 1F, 0F, -3.5F, 1F, 0F, 3F, -0.5F, 0F); // Box 99
		rotor[74].setRotationPoint(0F, 0F, 0F);

		rotor[75].addShapeBox(8F, 14F, -23.5F, 4, 2, 2, 0F, 0F, 0F, 0F, -1F, 2.5F, 0F, -1F, 2.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, -3F, 0F, 0.5F, -3F, 0F, 0F, 0F, 0F); // Box 100
		rotor[75].setRotationPoint(0F, 0F, 0F);

		rotor[76].addShapeBox(2F, 16F, -23.5F, 6, 2, 2, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 101
		rotor[76].setRotationPoint(0F, 0F, 0F);

		rotor[77].addShapeBox(-8F, -18F, -23.5F, 6, 2, 2, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 102
		rotor[77].setRotationPoint(0F, 0F, 0F);

		rotor[78].addShapeBox(-8F, 16F, -23.5F, 6, 2, 2, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 103
		rotor[78].setRotationPoint(0F, 0F, 0F);

		rotor[79].addShapeBox(-12F, -16F, -23.5F, 4, 2, 2, 0F, 0.5F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, -3F, 0F, -1F, 2.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 2.5F, 0F); // Box 104
		rotor[79].setRotationPoint(0F, 0F, 0F);

		rotor[80].addShapeBox(-12F, 14F, -23.5F, 4, 2, 2, 0F, -1F, 2.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 2.5F, 0F, 0.5F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, -3F, 0F); // Box 105
		rotor[80].setRotationPoint(0F, 0F, 0F);

		rotor[81].addShapeBox(-16F, -12F, -23.5F, 2, 4, 2, 0F, -3.5F, 1F, 0F, 3F, -0.5F, 0F, 3F, -0.5F, 0F, -3.5F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 106
		rotor[81].setRotationPoint(0F, 0F, 0F);

		rotor[82].addShapeBox(-16F, 8F, -23.5F, 2, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3.5F, 1F, 0F, 3F, -0.5F, 0F, 3F, -0.5F, 0F, -3.5F, 1F, 0F); // Box 107
		rotor[82].setRotationPoint(0F, 0F, 0F);

		rotor[83].addShapeBox(-18F, -8F, -23.5F, 2, 6, 2, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 108
		rotor[83].setRotationPoint(0F, 0F, 0F);

		rotor[84].addShapeBox(-18F, 2F, -23.5F, 2, 6, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 109
		rotor[84].setRotationPoint(0F, 0F, 0F);

		rotor[85].addShapeBox(2F, -18F, -10.5F, 6, 2, 2, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 110
		rotor[85].setRotationPoint(0F, 0F, 0F);

		rotor[86].addShapeBox(8F, -16F, -10.5F, 4, 2, 2, 0F, 0F, 0F, 0F, 0.5F, -3F, 0F, 0.5F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 2.5F, 0F, -1F, 2.5F, 0F, 0F, 0F, 0F); // Box 111
		rotor[86].setRotationPoint(0F, 0F, 0F);

		rotor[87].addShapeBox(14F, -12F, -10.5F, 2, 4, 2, 0F, 3F, -0.5F, 0F, -3.5F, 1F, 0F, -3.5F, 1F, 0F, 3F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 112
		rotor[87].setRotationPoint(0F, 0F, 0F);

		rotor[88].addShapeBox(16F, -8F, -10.5F, 2, 6, 2, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 113
		rotor[88].setRotationPoint(0F, 0F, 0F);

		rotor[89].addShapeBox(16F, 2F, -10.5F, 2, 6, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 114
		rotor[89].setRotationPoint(0F, 0F, 0F);

		rotor[90].addShapeBox(14F, 8F, -10.5F, 2, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, -0.5F, 0F, -3.5F, 1F, 0F, -3.5F, 1F, 0F, 3F, -0.5F, 0F); // Box 115
		rotor[90].setRotationPoint(0F, 0F, 0F);

		rotor[91].addShapeBox(8F, 14F, -10.5F, 4, 2, 2, 0F, 0F, 0F, 0F, -1F, 2.5F, 0F, -1F, 2.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, -3F, 0F, 0.5F, -3F, 0F, 0F, 0F, 0F); // Box 116
		rotor[91].setRotationPoint(0F, 0F, 0F);

		rotor[92].addShapeBox(2F, 16F, -10.5F, 6, 2, 2, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 117
		rotor[92].setRotationPoint(0F, 0F, 0F);

		rotor[93].addShapeBox(-8F, 16F, -10.5F, 6, 2, 2, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 118
		rotor[93].setRotationPoint(0F, 0F, 0F);

		rotor[94].addShapeBox(-12F, 14F, -10.5F, 4, 2, 2, 0F, -1F, 2.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 2.5F, 0F, 0.5F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, -3F, 0F); // Box 119
		rotor[94].setRotationPoint(0F, 0F, 0F);

		rotor[95].addShapeBox(-16F, 8F, -10.5F, 2, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3.5F, 1F, 0F, 3F, -0.5F, 0F, 3F, -0.5F, 0F, -3.5F, 1F, 0F); // Box 121
		rotor[95].setRotationPoint(0F, 0F, 0F);

		rotor[96].addShapeBox(-18F, 2F, -10.5F, 2, 6, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 122
		rotor[96].setRotationPoint(0F, 0F, 0F);

		rotor[97].addShapeBox(-18F, -8F, -10.5F, 2, 6, 2, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 123
		rotor[97].setRotationPoint(0F, 0F, 0F);

		rotor[98].addShapeBox(-16F, -12F, -10.5F, 2, 4, 2, 0F, -3.5F, 1F, 0F, 3F, -0.5F, 0F, 3F, -0.5F, 0F, -3.5F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 124
		rotor[98].setRotationPoint(0F, 0F, 0F);

		rotor[99].addShapeBox(-12F, -16F, -10.5F, 4, 2, 2, 0F, 0.5F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, -3F, 0F, -1F, 2.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 2.5F, 0F); // Box 125
		rotor[99].setRotationPoint(0F, 0F, 0F);

		rotor[100].addShapeBox(-8F, -18F, -10.5F, 6, 2, 2, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 126
		rotor[100].setRotationPoint(0F, 0F, 0F);

		rotor[101].addBox(16F, -0.5F, -21.5F, 10, 1, 11, 0F); // Box 127
		rotor[101].setRotationPoint(0F, 0F, 0F);

		rotor[102].addBox(16F, -0.5F, -21.5F, 10, 1, 11, 0F); // Box 128
		rotor[102].setRotationPoint(0F, 0F, 0F);
		rotor[102].rotateAngleZ = -0.34906585F;

		rotor[103].addBox(16F, -0.5F, -21.5F, 10, 1, 11, 0F); // Box 129
		rotor[103].setRotationPoint(0F, 0F, 0F);
		rotor[103].rotateAngleZ = -0.6981317F;

		rotor[104].addBox(16F, -0.5F, -21.5F, 10, 1, 11, 0F); // Box 130
		rotor[104].setRotationPoint(0F, 0F, 0F);
		rotor[104].rotateAngleZ = -1.04719755F;

		rotor[105].addBox(16F, -0.5F, -21.5F, 10, 1, 11, 0F); // Box 131
		rotor[105].setRotationPoint(0F, 0F, 0F);
		rotor[105].rotateAngleZ = -1.37881011F;

		rotor[106].addBox(16F, -0.5F, -21.5F, 10, 1, 11, 0F); // Box 132
		rotor[106].setRotationPoint(0F, 0F, 0F);
		rotor[106].rotateAngleZ = -1.74532925F;

		rotor[107].addBox(16F, -0.5F, -21.5F, 10, 1, 11, 0F); // Box 133
		rotor[107].setRotationPoint(0F, 0F, 0F);
		rotor[107].rotateAngleZ = -2.0943951F;

		rotor[108].addBox(16F, -0.5F, -21.5F, 10, 1, 11, 0F); // Box 134
		rotor[108].setRotationPoint(0F, 0F, 0F);
		rotor[108].rotateAngleZ = -2.42600766F;

		rotor[109].addBox(16F, -0.5F, -21.5F, 10, 1, 11, 0F); // Box 135
		rotor[109].setRotationPoint(0F, 0F, 0F);
		rotor[109].rotateAngleZ = -2.7925268F;

		rotor[110].addBox(-26F, -0.5F, -21.5F, 10, 1, 11, 0F); // Box 136
		rotor[110].setRotationPoint(0F, 0F, 0F);

		rotor[111].addBox(-26F, -0.5F, -21.5F, 10, 1, 11, 0F); // Box 137
		rotor[111].setRotationPoint(0F, 0F, 0F);
		rotor[111].rotateAngleZ = -0.34906585F;

		rotor[112].addBox(-26F, -0.5F, -21.5F, 10, 1, 11, 0F); // Box 138
		rotor[112].setRotationPoint(0F, 0F, 0F);
		rotor[112].rotateAngleZ = -0.68067841F;

		rotor[113].addBox(-26F, -0.5F, -21.5F, 10, 1, 11, 0F); // Box 139
		rotor[113].setRotationPoint(0F, 0F, 0F);
		rotor[113].rotateAngleZ = -1.04719755F;

		rotor[114].addBox(-26F, -0.5F, -21.5F, 10, 1, 11, 0F); // Box 140
		rotor[114].setRotationPoint(0F, 0F, 0F);
		rotor[114].rotateAngleZ = -1.3962634F;

		rotor[115].addBox(-26F, -0.5F, -21.5F, 10, 1, 11, 0F); // Box 141
		rotor[115].setRotationPoint(0F, 0F, 0F);
		rotor[115].rotateAngleZ = -1.74532925F;

		rotor[116].addBox(-26F, -0.5F, -21.5F, 10, 1, 11, 0F); // Box 142
		rotor[116].setRotationPoint(0F, 0F, 0F);
		rotor[116].rotateAngleZ = -2.0943951F;

		rotor[117].addBox(-26F, -0.5F, -21.5F, 10, 1, 11, 0F); // Box 143
		rotor[117].setRotationPoint(0F, 0F, 0F);
		rotor[117].rotateAngleZ = -2.44346095F;

		rotor[118].addBox(-26F, -0.5F, -21.5F, 10, 1, 11, 0F); // Box 144
		rotor[118].setRotationPoint(0F, 0F, 0F);
		rotor[118].rotateAngleZ = -2.7925268F;

		rotor[119].addShapeBox(12F, -13F, -23F, 1, 12, 1, 0F, 12F, 0F, 0F, -12F, 0F, 0F, -12F, 0F, 0F, 12F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 145
		rotor[119].setRotationPoint(0F, 0F, 0F);

		rotor[120].addShapeBox(12F, -13F, -10F, 1, 12, 1, 0F, 12F, 0F, 0F, -12F, 0F, 0F, -12F, 0F, 0F, 12F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 146
		rotor[120].setRotationPoint(0F, 0F, 0F);

		rotor[121].addShapeBox(12F, 1F, -10F, 1, 12, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 12F, 0F, 0F, -12F, 0F, 0F, -12F, 0F, 0F, 12F, 0F, 0F); // Box 147
		rotor[121].setRotationPoint(0F, 0F, 0F);

		rotor[122].addShapeBox(12F, 1F, -23F, 1, 12, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 12F, 0F, 0F, -12F, 0F, 0F, -12F, 0F, 0F, 12F, 0F, 0F); // Box 148
		rotor[122].setRotationPoint(0F, 0F, 0F);

		rotor[123].addShapeBox(-13F, -13F, -10F, 1, 12, 1, 0F, -12F, 0F, 0F, 12F, 0F, 0F, 12F, 0F, 0F, -12F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 149
		rotor[123].setRotationPoint(0F, 0F, 0F);

		rotor[124].addShapeBox(-13F, -13F, -23F, 1, 12, 1, 0F, -12F, 0F, 0F, 12F, 0F, 0F, 12F, 0F, 0F, -12F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 150
		rotor[124].setRotationPoint(0F, 0F, 0F);

		rotor[125].addShapeBox(-13F, 1F, -23F, 1, 12, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -12F, 0F, 0F, 12F, 0F, 0F, 12F, 0F, 0F, -12F, 0F, 0F); // Box 151
		rotor[125].setRotationPoint(0F, 0F, 0F);

		rotor[126].addShapeBox(-13F, 1F, -10F, 1, 12, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -12F, 0F, 0F, 12F, 0F, 0F, 12F, 0F, 0F, -12F, 0F, 0F); // Box 152
		rotor[126].setRotationPoint(0F, 0F, 0F);
		
		
		translateAll(0F, 16F, 0F);
		
	}
}