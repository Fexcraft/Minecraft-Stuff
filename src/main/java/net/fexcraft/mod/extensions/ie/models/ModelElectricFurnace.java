package net.fexcraft.mod.extensions.ie.models;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelElectricFurnace extends ModelBase {
	int textureX = 64;
	int textureY = 64;

	public ModelElectricFurnace(){
		base = new ModelRendererTurbo[64];
		base[0] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 0
		base[1] = new ModelRendererTurbo(this, 0, 27, textureX, textureY); // Box 1
		base[2] = new ModelRendererTurbo(this, 0, 27, textureX, textureY); // Box 2
		base[3] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 3
		base[4] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 4
		base[5] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 5
		base[6] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 6
		base[7] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 7
		base[8] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 8
		base[9] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 9
		base[10] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 10
		base[11] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 11
		base[12] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 12
		base[13] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 13
		base[14] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 14
		base[15] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 15
		base[16] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 16
		base[17] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 17
		base[18] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 18
		base[19] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 19
		base[20] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 20
		base[21] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 21
		base[22] = new ModelRendererTurbo(this, 0, 27, textureX, textureY); // Box 22
		base[23] = new ModelRendererTurbo(this, 0, 27, textureX, textureY); // Box 23
		base[24] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 24
		base[25] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 25
		base[26] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 26
		base[27] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 27
		base[28] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 28
		base[29] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 29
		base[30] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 30
		base[31] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 31
		base[32] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 32
		base[33] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 33
		base[34] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 34
		base[35] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 35
		base[36] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 36
		base[37] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 37
		base[38] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 38
		base[39] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 39
		base[40] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 40
		base[41] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 41
		base[42] = new ModelRendererTurbo(this, 0, 49, textureX, textureY); // Box 42
		base[43] = new ModelRendererTurbo(this, 0, 45, textureX, textureY); // Box 43
		base[44] = new ModelRendererTurbo(this, 0, 45, textureX, textureY); // Box 44
		base[45] = new ModelRendererTurbo(this, 31, 47, textureX, textureY); // Box 45
		base[46] = new ModelRendererTurbo(this, 31, 47, textureX, textureY); // Box 46
		base[47] = new ModelRendererTurbo(this, 22, 27, textureX, textureY); // Box 47
		base[48] = new ModelRendererTurbo(this, 22, 27, textureX, textureY); // Box 48
		base[49] = new ModelRendererTurbo(this, 8, 45, textureX, textureY); // Box 49
		base[50] = new ModelRendererTurbo(this, 8, 45, textureX, textureY); // Box 50
		base[51] = new ModelRendererTurbo(this, 16, 46, textureX, textureY); // Box 51
		base[52] = new ModelRendererTurbo(this, 16, 46, textureX, textureY); // Box 52
		base[53] = new ModelRendererTurbo(this, 18, 34, textureX, textureY); // Box 53
		base[54] = new ModelRendererTurbo(this, 18, 34, textureX, textureY); // Box 54
		base[55] = new ModelRendererTurbo(this, 18, 34, textureX, textureY); // Box 55
		base[56] = new ModelRendererTurbo(this, 0, 34, textureX, textureY); // Box 58
		base[57] = new ModelRendererTurbo(this, 46, 47, textureX, textureY); // Box 59
		base[58] = new ModelRendererTurbo(this, 0, 29, textureX, textureY); // Box 60
		base[59] = new ModelRendererTurbo(this, 0, 29, textureX, textureY); // Box 61
		base[60] = new ModelRendererTurbo(this, 0, 29, textureX, textureY); // Box 62
		base[61] = new ModelRendererTurbo(this, 0, 7, textureX, textureY); // Box 64
		base[62] = new ModelRendererTurbo(this, 5, 7, textureX, textureY); // Box 65
		base[63] = new ModelRendererTurbo(this, 5, 4, textureX, textureY); // Box 66

		base[0].addBox(0F, 0F, 0F, 14, 16, 10, 0F); // Box 0
		base[0].setRotationPoint(-7F, -16F, -5F);

		base[1].addBox(0F, 0F, 0F, 1, 3, 14, 0F); // Box 1
		base[1].setRotationPoint(-8F, -3F, -7F);

		base[2].addBox(0F, 0F, 0F, 1, 3, 14, 0F); // Box 2
		base[2].setRotationPoint(-8F, -16F, -7F);

		base[3].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 3
		base[3].setRotationPoint(-8F, -13F, -7F);

		base[4].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 4
		base[4].setRotationPoint(-8F, -12.5F, -7F);

		base[5].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 5
		base[5].setRotationPoint(-8F, -12F, -7F);

		base[6].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 6
		base[6].setRotationPoint(-8F, -11.5F, -7F);

		base[7].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 7
		base[7].setRotationPoint(-8F, -11F, -7F);

		base[8].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 8
		base[8].setRotationPoint(-8F, -10.5F, -7F);

		base[9].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 9
		base[9].setRotationPoint(-8F, -10F, -7F);

		base[10].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 10
		base[10].setRotationPoint(-8F, -9.5F, -7F);

		base[11].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 11
		base[11].setRotationPoint(-8F, -9F, -7F);

		base[12].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 12
		base[12].setRotationPoint(-8F, -8.5F, -7F);

		base[13].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 13
		base[13].setRotationPoint(-8F, -8F, -7F);

		base[14].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 14
		base[14].setRotationPoint(-8F, -7.5F, -7F);

		base[15].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 15
		base[15].setRotationPoint(-8F, -7F, -7F);

		base[16].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 16
		base[16].setRotationPoint(-8F, -6.5F, -7F);

		base[17].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 17
		base[17].setRotationPoint(-8F, -6F, -7F);

		base[18].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 18
		base[18].setRotationPoint(-8F, -5.5F, -7F);

		base[19].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 19
		base[19].setRotationPoint(-8F, -5F, -7F);

		base[20].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 20
		base[20].setRotationPoint(-8F, -4.5F, -7F);

		base[21].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 21
		base[21].setRotationPoint(-8F, -4F, -7F);

		base[22].addBox(0F, 0F, 0F, 1, 3, 14, 0F); // Box 22
		base[22].setRotationPoint(7F, -3F, -7F);

		base[23].addBox(0F, 0F, 0F, 1, 3, 14, 0F); // Box 23
		base[23].setRotationPoint(7F, -16F, -7F);

		base[24].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 24
		base[24].setRotationPoint(7F, -13F, -7F);

		base[25].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 25
		base[25].setRotationPoint(7F, -12.5F, -7F);

		base[26].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 26
		base[26].setRotationPoint(7F, -12F, -7F);

		base[27].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 27
		base[27].setRotationPoint(7F, -11.5F, -7F);

		base[28].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 28
		base[28].setRotationPoint(7F, -11F, -7F);

		base[29].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 29
		base[29].setRotationPoint(7F, -10.5F, -7F);

		base[30].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 30
		base[30].setRotationPoint(7F, -10F, -7F);

		base[31].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 31
		base[31].setRotationPoint(7F, -9.5F, -7F);

		base[32].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 32
		base[32].setRotationPoint(7F, -9F, -7F);

		base[33].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 33
		base[33].setRotationPoint(7F, -8.5F, -7F);

		base[34].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 34
		base[34].setRotationPoint(7F, -8F, -7F);

		base[35].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 35
		base[35].setRotationPoint(7F, -7.5F, -7F);

		base[36].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 36
		base[36].setRotationPoint(7F, -7F, -7F);

		base[37].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 37
		base[37].setRotationPoint(7F, -6.5F, -7F);

		base[38].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 38
		base[38].setRotationPoint(7F, -6F, -7F);

		base[39].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 39
		base[39].setRotationPoint(7F, -5.5F, -7F);

		base[40].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 40
		base[40].setRotationPoint(7F, -5F, -7F);

		base[41].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 41
		base[41].setRotationPoint(7F, -4.5F, -7F);

		base[42].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 42
		base[42].setRotationPoint(7F, -4F, -7F);

		base[43].addBox(0F, 0F, 0F, 2, 16, 2, 0F); // Box 43
		base[43].setRotationPoint(5F, -16F, 5F);

		base[44].addBox(0F, 0F, 0F, 2, 16, 2, 0F); // Box 44
		base[44].setRotationPoint(-7F, -16F, 5F);

		base[45].addBox(0F, 0F, 0F, 3, 16, 1, 0F); // Box 45
		base[45].setRotationPoint(5F, -16F, 7F);

		base[46].addBox(0F, 0F, 0F, 3, 16, 1, 0F); // Box 46
		base[46].setRotationPoint(-8F, -16F, 7F);

		base[47].addBox(0F, 0F, 0F, 10, 3, 3, 0F); // Box 47
		base[47].setRotationPoint(-5F, -16F, 5F);

		base[48].addBox(0F, 0F, 0F, 10, 3, 3, 0F); // Box 48
		base[48].setRotationPoint(-5F, -3F, 5F);

		base[49].addBox(0F, 0F, 0F, 1, 16, 2, 0F); // Box 49
		base[49].setRotationPoint(-7F, -16F, -7F);

		base[50].addBox(0F, 0F, 0F, 1, 16, 2, 0F); // Box 50
		base[50].setRotationPoint(6F, -16F, -7F);

		base[51].addBox(0F, 0F, 0F, 2, 16, 1, 0F); // Box 51
		base[51].setRotationPoint(6F, -16F, -8F);

		base[52].addBox(0F, 0F, 0F, 2, 16, 1, 0F); // Box 52
		base[52].setRotationPoint(-8F, -16F, -8F);

		base[53].addBox(0F, 0F, 0F, 12, 2, 3, 0F); // Box 53
		base[53].setRotationPoint(-6F, -2F, -8F);

		base[54].addBox(0F, 0F, 0F, 12, 1, 3, 0F); // Box 54
		base[54].setRotationPoint(-6F, -16F, -8F);

		base[55].addBox(0F, 0F, 0F, 12, 2, 3, 0F); // Box 55
		base[55].setRotationPoint(-6F, -9F, -8F);

		base[56].addShapeBox(0F, 0F, 0F, 6, 6, 1, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 58
		base[56].setRotationPoint(-6F, -15F, -7.5F);

		base[57].addBox(0F, 0F, 0F, 6, 6, 3, 0F); // Box 59
		base[57].setRotationPoint(0F, -15F, -7.5F);

		base[58].addBox(0F, 0F, 0F, 3, 1, 3, 0F); // Box 60
		base[58].setRotationPoint(-1.5F, -9F, 4.5F);

		base[59].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 61
		base[59].setRotationPoint(-1.5F, -10F, 4.5F);

		base[60].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 62
		base[60].setRotationPoint(-1.5F, -8F, 4.5F);

		base[61].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 64
		base[61].setRotationPoint(4.5F, -11F, -7.75F);

		base[62].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 65
		base[62].setRotationPoint(4.5F, -12.5F, -7.75F);

		base[63].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 66
		base[63].setRotationPoint(4.5F, -14F, -7.75F);


		closed = new ModelRendererTurbo[2];
		closed[0] = new ModelRendererTurbo(this, 31, 40, textureX, textureY); // Box 56
		closed[1] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 57

		closed[0].addBox(0F, 0F, 0F, 12, 5, 1, 0F); // Box 56
		closed[0].setRotationPoint(-6F, -7F, -7.5F);

		closed[1].addBox(0F, 0F, 0F, 1, 3, 1, 0F); // Box 57
		closed[1].setRotationPoint(-5F, -6F, -8F);


		r0 = new ModelRendererTurbo[1];
		r0[0] = new ModelRendererTurbo(this, 42, 57, textureX, textureY); // Box 63

		r0[0].addShapeBox(-0.5F, 0F, 0F, 1, 5, 2, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F, 0F, -0.6F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F); // Box 63
		r0[0].setRotationPoint(0F, -7.5F, 5F);
		
		translateAll(0F, 8F, 0F);
		
	}
}