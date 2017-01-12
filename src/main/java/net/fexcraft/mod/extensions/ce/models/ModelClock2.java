package net.fexcraft.mod.extensions.ce.models;

import net.fexcraft.mod.extensions.ce.util.ClockModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelClock2 extends ClockModelBase{
	
	int textureX = 128;
	int textureY = 64;

	public ModelClock2(){
		models.add(this);
		base = new ModelRendererTurbo[76];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		base[1] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 1
		base[2] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 2
		base[3] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 3
		base[4] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 4
		base[5] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 5
		base[6] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 6
		base[7] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 7
		base[8] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 8
		base[9] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 9
		base[10] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 10
		base[11] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 11
		base[12] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // Box 12
		base[13] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 13
		base[14] = new ModelRendererTurbo(this, 89, 9, textureX, textureY); // Box 14
		base[15] = new ModelRendererTurbo(this, 105, 9, textureX, textureY); // Box 15
		base[16] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 16
		base[17] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 17
		base[18] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 18
		base[19] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 19
		base[20] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 20
		base[21] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 21
		base[22] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 22
		base[23] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 23
		base[24] = new ModelRendererTurbo(this, 121, 9, textureX, textureY); // Box 24
		base[25] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 25
		base[26] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 26
		base[27] = new ModelRendererTurbo(this, 73, 25, textureX, textureY); // Box 27
		base[28] = new ModelRendererTurbo(this, 81, 25, textureX, textureY); // Box 28
		base[29] = new ModelRendererTurbo(this, 89, 25, textureX, textureY); // Box 29
		base[30] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 30
		base[31] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 31
		base[32] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 32
		base[33] = new ModelRendererTurbo(this, 9, 33, textureX, textureY); // Box 33
		base[34] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 34
		base[35] = new ModelRendererTurbo(this, 25, 33, textureX, textureY); // Box 35
		base[36] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 37
		base[37] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 40
		base[38] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 41
		base[39] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 42
		base[40] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 43
		base[41] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 44
		base[42] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 45
		base[43] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 46
		base[44] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 47
		base[45] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 48
		base[46] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 49
		base[47] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 50
		base[48] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 51
		base[49] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 52
		base[50] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // Box 53
		base[51] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 54
		base[52] = new ModelRendererTurbo(this, 89, 9, textureX, textureY); // Box 55
		base[53] = new ModelRendererTurbo(this, 105, 9, textureX, textureY); // Box 56
		base[54] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 57
		base[55] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 58
		base[56] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 59
		base[57] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 60
		base[58] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 61
		base[59] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 62
		base[60] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 63
		base[61] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 64
		base[62] = new ModelRendererTurbo(this, 121, 9, textureX, textureY); // Box 65
		base[63] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 66
		base[64] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 67
		base[65] = new ModelRendererTurbo(this, 73, 25, textureX, textureY); // Box 68
		base[66] = new ModelRendererTurbo(this, 81, 25, textureX, textureY); // Box 69
		base[67] = new ModelRendererTurbo(this, 89, 25, textureX, textureY); // Box 70
		base[68] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 71
		base[69] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 72
		base[70] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 73
		base[71] = new ModelRendererTurbo(this, 9, 33, textureX, textureY); // Box 74
		base[72] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 75
		base[73] = new ModelRendererTurbo(this, 25, 33, textureX, textureY); // Box 76
		base[74] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 78
		base[75] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 81

		base[0].addBox(0F, 0F, 0F, 3, 1, 6, 0F); // Box 0
		base[0].setRotationPoint(0F, -1F, -3F);

		base[1].addBox(0F, 0F, 0F, 3, 1, 6, 0F); // Box 1
		base[1].setRotationPoint(0F, -16F, -3F);

		base[2].addBox(0F, 0F, 0F, 3, 6, 1, 0F); // Box 2
		base[2].setRotationPoint(0F, -11F, 7F);

		base[3].addBox(0F, 0F, 0F, 3, 6, 1, 0F); // Box 3
		base[3].setRotationPoint(0F, -11F, -8F);

		base[4].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, 2F, 0F, 0F, 2F, 0F); // Box 4
		base[4].setRotationPoint(0F, -3F, -6F);

		base[5].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F, 0F, -1F, 1.5F, 0F, -1F, 1.5F); // Box 5
		base[5].setRotationPoint(0F, -5F, -8F);

		base[6].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F); // Box 6
		base[6].setRotationPoint(0F, -3F, 3F);

		base[7].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 7
		base[7].setRotationPoint(0F, -14F, 3F);

		base[8].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -2F, 0F, 0F, -2F, 0F); // Box 8
		base[8].setRotationPoint(0F, -14F, -6F);

		base[9].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F, 0F, -1F, 1.5F, 0F, -1F, 1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
		base[9].setRotationPoint(0F, -14F, -8F);

		base[10].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, -1F, 1.5F, 0F, -1F, 1.5F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
		base[10].setRotationPoint(0F, -14F, 7F);

		base[11].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 1.5F, 0F, -1F, 1.5F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F); // Box 11
		base[11].setRotationPoint(0F, -5F, 7F);

		base[12].addBox(0F, 0F, 0F, 1, 4, 6, 0F); // Box 12
		base[12].setRotationPoint(0F, -15F, -3F);

		base[13].addBox(0F, 0F, 0F, 1, 4, 6, 0F); // Box 13
		base[13].setRotationPoint(0F, -5F, -3F);

		base[14].addBox(0F, 0F, 0F, 1, 6, 4, 0F); // Box 14
		base[14].setRotationPoint(0F, -11F, -7F);

		base[15].addBox(0F, 0F, 0F, 1, 6, 4, 0F); // Box 15
		base[15].setRotationPoint(0F, -11F, 3F);

		base[16].addBox(0F, 0F, 0F, 1, 6, 6, 0F); // Box 16
		base[16].setRotationPoint(0F, -11F, -3F);

		base[17].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 17
		base[17].setRotationPoint(0F, -15F, -7F);

		base[18].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 18
		base[18].setRotationPoint(0F, -15F, 3F);

		base[19].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F); // Box 19
		base[19].setRotationPoint(0F, -5F, 3F);

		base[20].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 20
		base[20].setRotationPoint(0F, -5F, -7F);

		base[21].addBox(0F, 0F, 0F, 1, 3, 1, 0F); // Box 21
		base[21].setRotationPoint(0.25F, -9.5F, -0.5F);

		base[22].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 22
		base[22].setRotationPoint(0.25F, -9.5F, -1.5F);

		base[23].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 23
		base[23].setRotationPoint(0.25F, -9.5F, 0.5F);

		base[24].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 24
		base[24].setRotationPoint(0.0999999999999996F, -3.2F, -1F);

		base[25].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 25
		base[25].setRotationPoint(0.0999999999999996F, -14.8F, -1F);

		base[26].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 26
		base[26].setRotationPoint(0.0999999999999996F, -9F, 4.8F);

		base[27].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 27
		base[27].setRotationPoint(0.0999999999999996F, -9F, -6.8F);

		base[28].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 28
		base[28].setRotationPoint(0.0999999999999996F, -11.75F, 4F);

		base[29].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 29
		base[29].setRotationPoint(0.0999999999999996F, -14F, 1.75F);

		base[30].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 30
		base[30].setRotationPoint(0.0999999999999996F, -6.25F, 4F);

		base[31].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 31
		base[31].setRotationPoint(0.0999999999999996F, -4F, 1.75F);

		base[32].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 32
		base[32].setRotationPoint(0.0999999999999996F, -4F, -3.75F);

		base[33].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 33
		base[33].setRotationPoint(0.0999999999999996F, -14F, -3.75F);

		base[34].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 34
		base[34].setRotationPoint(0.0999999999999996F, -11.75F, -6F);

		base[35].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 35
		base[35].setRotationPoint(0.0999999999999996F, -6.25F, -6F);

		base[36].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 37
		base[36].setRotationPoint(1.5F, -8.5F, -0.5F);

		base[37].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 40
		base[37].setRotationPoint(0.5F, -8.5F, -0.5F);

		base[38].addBox(0F, 0F, 0F, 3, 1, 6, 0F); // Box 41
		base[38].setRotationPoint(-3F, -1F, -3F);

		base[39].addBox(0F, 0F, 0F, 3, 1, 6, 0F); // Box 42
		base[39].setRotationPoint(-3F, -16F, -3F);

		base[40].addBox(0F, 0F, 0F, 3, 6, 1, 0F); // Box 43
		base[40].setRotationPoint(-3F, -11F, -8F);

		base[41].addBox(0F, 0F, 0F, 3, 6, 1, 0F); // Box 44
		base[41].setRotationPoint(-3F, -11F, 7F);

		base[42].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F); // Box 45
		base[42].setRotationPoint(-3F, -3F, 3F);

		base[43].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 1.5F, 0F, -1F, 1.5F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F); // Box 46
		base[43].setRotationPoint(-3F, -5F, 7F);

		base[44].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, 2F, 0F, 0F, 2F, 0F); // Box 47
		base[44].setRotationPoint(-3F, -3F, -6F);

		base[45].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -2F, 0F, 0F, -2F, 0F); // Box 48
		base[45].setRotationPoint(-3F, -14F, -6F);

		base[46].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 49
		base[46].setRotationPoint(-3F, -14F, 3F);

		base[47].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, -1F, 1.5F, 0F, -1F, 1.5F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 50
		base[47].setRotationPoint(-3F, -14F, 7F);

		base[48].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F, 0F, -1F, 1.5F, 0F, -1F, 1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 51
		base[48].setRotationPoint(-3F, -14F, -8F);

		base[49].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F, 0F, -1F, 1.5F, 0F, -1F, 1.5F); // Box 52
		base[49].setRotationPoint(-3F, -5F, -8F);

		base[50].addBox(0F, 0F, 0F, 1, 4, 6, 0F); // Box 53
		base[50].setRotationPoint(-1F, -15F, -3F);

		base[51].addBox(0F, 0F, 0F, 1, 4, 6, 0F); // Box 54
		base[51].setRotationPoint(-1F, -5F, -3F);

		base[52].addBox(0F, 0F, 0F, 1, 6, 4, 0F); // Box 55
		base[52].setRotationPoint(-1F, -11F, 3F);

		base[53].addBox(0F, 0F, 0F, 1, 6, 4, 0F); // Box 56
		base[53].setRotationPoint(-1F, -11F, -7F);

		base[54].addBox(-1F, 0F, -6F, 1, 6, 6, 0F); // Box 57
		base[54].setRotationPoint(-1F, -11F, -3F);
		base[54].rotateAngleY = -3.14159265F;

		base[55].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 58
		base[55].setRotationPoint(-1F, -15F, 3F);

		base[56].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 59
		base[56].setRotationPoint(-1F, -15F, -7F);

		base[57].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 60
		base[57].setRotationPoint(-1F, -5F, -7F);

		base[58].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F); // Box 61
		base[58].setRotationPoint(-1F, -5F, 3F);

		base[59].addBox(0F, 0F, 0F, 1, 3, 1, 0F); // Box 62
		base[59].setRotationPoint(-1.25F, -9.5F, -0.5F);

		base[60].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 63
		base[60].setRotationPoint(-1.25F, -9.5F, 0.5F);

		base[61].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 64
		base[61].setRotationPoint(-1.25F, -9.5F, -1.5F);

		base[62].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 65
		base[62].setRotationPoint(-1.1F, -3.2F, -1F);
		base[62].rotateAngleY = -3.14159265F;

		base[63].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 66
		base[63].setRotationPoint(-1.1F, -14.8F, -1F);
		base[63].rotateAngleY = -3.14159265F;

		base[64].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 67
		base[64].setRotationPoint(-1.1F, -9F, -6.8F);
		base[64].rotateAngleY = -3.14159265F;

		base[65].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 68
		base[65].setRotationPoint(-1.1F, -9F, 4.8F);
		base[65].rotateAngleY = -3.14159265F;

		base[66].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 69
		base[66].setRotationPoint(-1.1F, -11.75F, -6F);
		base[66].rotateAngleY = -3.14159265F;

		base[67].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 70
		base[67].setRotationPoint(-1.1F, -14F, -3.75F);
		base[67].rotateAngleY = -3.14159265F;

		base[68].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 71
		base[68].setRotationPoint(-1.1F, -6.25F, -6F);
		base[68].rotateAngleY = -3.14159265F;

		base[69].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 72
		base[69].setRotationPoint(-1.1F, -4F, -3.75F);
		base[69].rotateAngleY = -3.14159265F;

		base[70].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 73
		base[70].setRotationPoint(-1.1F, -4F, 1.75F);
		base[70].rotateAngleY = -3.14159265F;

		base[71].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 74
		base[71].setRotationPoint(-1.1F, -14F, 1.75F);
		base[71].rotateAngleY = -3.14159265F;

		base[72].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 75
		base[72].setRotationPoint(-1.1F, -11.75F, 4F);
		base[72].rotateAngleY = -3.14159265F;

		base[73].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 76
		base[73].setRotationPoint(-1.1F, -6.25F, 4F);
		base[73].rotateAngleY = -3.14159265F;

		base[74].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 78
		base[74].setRotationPoint(-2.5F, -8.5F, -0.5F);

		base[75].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 81
		base[75].setRotationPoint(-1.5F, -8.5F, -0.5F);


		second = new ModelRendererTurbo[1];
		second[0] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Box 39

		second[0].addShapeBox(0F, 0F, -0.5F, 1, 7, 1, 0F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, 0F, -0.5F, -0.45F); // Box 39
		second[0].setRotationPoint(2F, -24F, 0F);


		secondR = new ModelRendererTurbo[1];
		secondR[0] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Box 80

		secondR[0].addShapeBox(0F, 0F, -0.5F, 1, 7, 1, 0F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, 0F, -0.5F, -0.45F); // Box 80
		secondR[0].setRotationPoint(-2F, -24F, 0F);


		minuteR = new ModelRendererTurbo[1];
		minuteR[0] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Box 77

		minuteR[0].addShapeBox(0F, 0F, -0.5F, 1, 6, 1, 0F, 0F, 0F, -0.3F, -0.8F, 0F, -0.3F, -0.8F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, 0F, -0.5F, -0.45F); // Box 77
		minuteR[0].setRotationPoint(-1.75F, -24F, 0F);


		hour = new ModelRendererTurbo[1];
		hour[0] = new ModelRendererTurbo(this, 41, 33, textureX, textureY); // Box 38

		hour[0].addShapeBox(0F, 0F, -0.5F, 1, 5, 1, 0F, 0F, 0F, -0.2F, -0.8F, 0F, -0.2F, -0.8F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.5F, -0.4F, -0.8F, -0.5F, -0.4F, -0.8F, -0.5F, -0.4F, 0F, -0.5F, -0.4F); // Box 38
		hour[0].setRotationPoint(1.5F, -24F, 0F);


		minute = new ModelRendererTurbo[1];
		minute[0] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Box 36

		minute[0].addShapeBox(0F, 0F, -0.5F, 1, 6, 1, 0F, 0F, 0F, -0.3F, -0.8F, 0F, -0.3F, -0.8F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, 0F, -0.5F, -0.45F); // Box 36
		minute[0].setRotationPoint(1.75F, -24F, 0F);


		hourR = new ModelRendererTurbo[1];
		hourR[0] = new ModelRendererTurbo(this, 41, 33, textureX, textureY); // Box 79

		hourR[0].addShapeBox(0F, 0F, -0.5F, 1, 5, 1, 0F, 0F, 0F, -0.2F, -0.8F, 0F, -0.2F, -0.8F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.5F, -0.4F, -0.8F, -0.5F, -0.4F, -0.8F, -0.5F, -0.4F, 0F, -0.5F, -0.4F); // Box 79
		hourR[0].setRotationPoint(-1.5F, -24F, 0F);



		translateAll(0F, 24F, 0F);


		//flipAll();
	}

	@Override
	public String getName(){
		return "clock2";
	}
}