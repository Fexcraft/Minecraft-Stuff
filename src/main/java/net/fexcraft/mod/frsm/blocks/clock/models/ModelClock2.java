package net.fexcraft.mod.frsm.blocks.clock.models;

import net.fexcraft.mod.frsm.blocks.clock.ClockBaseModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelClock2 extends ClockBaseModel {
	
	public static final ModelClock2 INSTANCE = new ModelClock2();
	int textureX = 128;
	int textureY = 64;

	public ModelClock2(){
		base = new ModelRendererTurbo[52];
		base[0] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // Box 12
		base[1] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 13
		base[2] = new ModelRendererTurbo(this, 89, 9, textureX, textureY); // Box 14
		base[3] = new ModelRendererTurbo(this, 105, 9, textureX, textureY); // Box 15
		base[4] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 16
		base[5] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 17
		base[6] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 18
		base[7] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 19
		base[8] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 20
		base[9] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 21
		base[10] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 22
		base[11] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 23
		base[12] = new ModelRendererTurbo(this, 121, 9, textureX, textureY); // Box 24
		base[13] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 25
		base[14] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 26
		base[15] = new ModelRendererTurbo(this, 73, 25, textureX, textureY); // Box 27
		base[16] = new ModelRendererTurbo(this, 81, 25, textureX, textureY); // Box 28
		base[17] = new ModelRendererTurbo(this, 89, 25, textureX, textureY); // Box 29
		base[18] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 30
		base[19] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 31
		base[20] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 32
		base[21] = new ModelRendererTurbo(this, 9, 33, textureX, textureY); // Box 33
		base[22] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 34
		base[23] = new ModelRendererTurbo(this, 25, 33, textureX, textureY); // Box 35
		base[24] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 37
		base[25] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 40
		base[26] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // Box 53
		base[27] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 54
		base[28] = new ModelRendererTurbo(this, 89, 9, textureX, textureY); // Box 55
		base[29] = new ModelRendererTurbo(this, 105, 9, textureX, textureY); // Box 56
		base[30] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 57
		base[31] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 58
		base[32] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 59
		base[33] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 60
		base[34] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 61
		base[35] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 62
		base[36] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 63
		base[37] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 64
		base[38] = new ModelRendererTurbo(this, 121, 9, textureX, textureY); // Box 65
		base[39] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 66
		base[40] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 67
		base[41] = new ModelRendererTurbo(this, 73, 25, textureX, textureY); // Box 68
		base[42] = new ModelRendererTurbo(this, 81, 25, textureX, textureY); // Box 69
		base[43] = new ModelRendererTurbo(this, 89, 25, textureX, textureY); // Box 70
		base[44] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 71
		base[45] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 72
		base[46] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 73
		base[47] = new ModelRendererTurbo(this, 9, 33, textureX, textureY); // Box 74
		base[48] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 75
		base[49] = new ModelRendererTurbo(this, 25, 33, textureX, textureY); // Box 76
		base[50] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 78
		base[51] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 81

		base[0].addBox(0F, 0F, 0F, 1, 4, 6, 0F); // Box 12
		base[0].setRotationPoint(0F, -15F, -3F);

		base[1].addBox(0F, 0F, 0F, 1, 4, 6, 0F); // Box 13
		base[1].setRotationPoint(0F, -5F, -3F);

		base[2].addBox(0F, 0F, 0F, 1, 6, 4, 0F); // Box 14
		base[2].setRotationPoint(0F, -11F, -7F);

		base[3].addBox(0F, 0F, 0F, 1, 6, 4, 0F); // Box 15
		base[3].setRotationPoint(0F, -11F, 3F);

		base[4].addBox(0F, 0F, 0F, 1, 6, 6, 0F); // Box 16
		base[4].setRotationPoint(0F, -11F, -3F);

		base[5].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 17
		base[5].setRotationPoint(0F, -15F, -7F);

		base[6].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 18
		base[6].setRotationPoint(0F, -15F, 3F);

		base[7].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F); // Box 19
		base[7].setRotationPoint(0F, -5F, 3F);

		base[8].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 20
		base[8].setRotationPoint(0F, -5F, -7F);

		base[9].addBox(0F, 0F, 0F, 1, 3, 1, 0F); // Box 21
		base[9].setRotationPoint(0.25F, -9.5F, -0.5F);

		base[10].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 22
		base[10].setRotationPoint(0.25F, -9.5F, -1.5F);

		base[11].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 23
		base[11].setRotationPoint(0.25F, -9.5F, 0.5F);

		base[12].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 24
		base[12].setRotationPoint(0.0999999999999996F, -3.2F, -1F);

		base[13].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 25
		base[13].setRotationPoint(0.0999999999999996F, -14.8F, -1F);

		base[14].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 26
		base[14].setRotationPoint(0.0999999999999996F, -9F, 4.8F);

		base[15].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 27
		base[15].setRotationPoint(0.0999999999999996F, -9F, -6.8F);

		base[16].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 28
		base[16].setRotationPoint(0.0999999999999996F, -11.75F, 4F);

		base[17].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 29
		base[17].setRotationPoint(0.0999999999999996F, -14F, 1.75F);

		base[18].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 30
		base[18].setRotationPoint(0.0999999999999996F, -6.25F, 4F);

		base[19].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 31
		base[19].setRotationPoint(0.0999999999999996F, -4F, 1.75F);

		base[20].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 32
		base[20].setRotationPoint(0.0999999999999996F, -4F, -3.75F);

		base[21].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 33
		base[21].setRotationPoint(0.0999999999999996F, -14F, -3.75F);

		base[22].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 34
		base[22].setRotationPoint(0.0999999999999996F, -11.75F, -6F);

		base[23].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 35
		base[23].setRotationPoint(0.0999999999999996F, -6.25F, -6F);

		base[24].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 37
		base[24].setRotationPoint(1.5F, -8.5F, -0.5F);

		base[25].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 40
		base[25].setRotationPoint(0.5F, -8.5F, -0.5F);

		base[26].addBox(0F, 0F, 0F, 1, 4, 6, 0F); // Box 53
		base[26].setRotationPoint(-1F, -15F, -3F);

		base[27].addBox(0F, 0F, 0F, 1, 4, 6, 0F); // Box 54
		base[27].setRotationPoint(-1F, -5F, -3F);

		base[28].addBox(0F, 0F, 0F, 1, 6, 4, 0F); // Box 55
		base[28].setRotationPoint(-1F, -11F, 3F);

		base[29].addBox(0F, 0F, 0F, 1, 6, 4, 0F); // Box 56
		base[29].setRotationPoint(-1F, -11F, -7F);

		base[30].addBox(-1F, 0F, -6F, 1, 6, 6, 0F); // Box 57
		base[30].setRotationPoint(-1F, -11F, -3F);
		base[30].rotateAngleY = -3.14159265F;

		base[31].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 58
		base[31].setRotationPoint(-1F, -15F, 3F);

		base[32].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 59
		base[32].setRotationPoint(-1F, -15F, -7F);

		base[33].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 60
		base[33].setRotationPoint(-1F, -5F, -7F);

		base[34].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F); // Box 61
		base[34].setRotationPoint(-1F, -5F, 3F);

		base[35].addBox(0F, 0F, 0F, 1, 3, 1, 0F); // Box 62
		base[35].setRotationPoint(-1.25F, -9.5F, -0.5F);

		base[36].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 63
		base[36].setRotationPoint(-1.25F, -9.5F, 0.5F);

		base[37].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 64
		base[37].setRotationPoint(-1.25F, -9.5F, -1.5F);

		base[38].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 65
		base[38].setRotationPoint(-1.1F, -3.2F, -1F);
		base[38].rotateAngleY = -3.14159265F;

		base[39].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 66
		base[39].setRotationPoint(-1.1F, -14.8F, -1F);
		base[39].rotateAngleY = -3.14159265F;

		base[40].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 67
		base[40].setRotationPoint(-1.1F, -9F, -6.8F);
		base[40].rotateAngleY = -3.14159265F;

		base[41].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 68
		base[41].setRotationPoint(-1.1F, -9F, 4.8F);
		base[41].rotateAngleY = -3.14159265F;

		base[42].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 69
		base[42].setRotationPoint(-1.1F, -11.75F, -6F);
		base[42].rotateAngleY = -3.14159265F;

		base[43].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 70
		base[43].setRotationPoint(-1.1F, -14F, -3.75F);
		base[43].rotateAngleY = -3.14159265F;

		base[44].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 71
		base[44].setRotationPoint(-1.1F, -6.25F, -6F);
		base[44].rotateAngleY = -3.14159265F;

		base[45].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 72
		base[45].setRotationPoint(-1.1F, -4F, -3.75F);
		base[45].rotateAngleY = -3.14159265F;

		base[46].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 73
		base[46].setRotationPoint(-1.1F, -4F, 1.75F);
		base[46].rotateAngleY = -3.14159265F;

		base[47].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 74
		base[47].setRotationPoint(-1.1F, -14F, 1.75F);
		base[47].rotateAngleY = -3.14159265F;

		base[48].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 75
		base[48].setRotationPoint(-1.1F, -11.75F, 4F);
		base[48].rotateAngleY = -3.14159265F;

		base[49].addBox(-1F, 0F, -2F, 1, 2, 2, 0F); // Box 76
		base[49].setRotationPoint(-1.1F, -6.25F, 4F);
		base[49].rotateAngleY = -3.14159265F;

		base[50].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 78
		base[50].setRotationPoint(-2.5F, -8.5F, -0.5F);

		base[51].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 81
		base[51].setRotationPoint(-1.5F, -8.5F, -0.5F);


		paintable = new ModelRendererTurbo[24];
		paintable[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		paintable[1] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 1
		paintable[2] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 2
		paintable[3] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 3
		paintable[4] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 4
		paintable[5] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 5
		paintable[6] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 6
		paintable[7] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 7
		paintable[8] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 8
		paintable[9] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 9
		paintable[10] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 10
		paintable[11] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 11
		paintable[12] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 41
		paintable[13] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 42
		paintable[14] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 43
		paintable[15] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 44
		paintable[16] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 45
		paintable[17] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 46
		paintable[18] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 47
		paintable[19] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 48
		paintable[20] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 49
		paintable[21] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 50
		paintable[22] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 51
		paintable[23] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 52

		paintable[0].addBox(0F, 0F, 0F, 3, 1, 6, 0F); // Box 0
		paintable[0].setRotationPoint(0F, -1F, -3F);

		paintable[1].addBox(0F, 0F, 0F, 3, 1, 6, 0F); // Box 1
		paintable[1].setRotationPoint(0F, -16F, -3F);

		paintable[2].addBox(0F, 0F, 0F, 3, 6, 1, 0F); // Box 2
		paintable[2].setRotationPoint(0F, -11F, 7F);

		paintable[3].addBox(0F, 0F, 0F, 3, 6, 1, 0F); // Box 3
		paintable[3].setRotationPoint(0F, -11F, -8F);

		paintable[4].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, 2F, 0F, 0F, 2F, 0F); // Box 4
		paintable[4].setRotationPoint(0F, -3F, -6F);

		paintable[5].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F, 0F, -1F, 1.5F, 0F, -1F, 1.5F); // Box 5
		paintable[5].setRotationPoint(0F, -5F, -8F);

		paintable[6].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F); // Box 6
		paintable[6].setRotationPoint(0F, -3F, 3F);

		paintable[7].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 7
		paintable[7].setRotationPoint(0F, -14F, 3F);

		paintable[8].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -2F, 0F, 0F, -2F, 0F); // Box 8
		paintable[8].setRotationPoint(0F, -14F, -6F);

		paintable[9].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F, 0F, -1F, 1.5F, 0F, -1F, 1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
		paintable[9].setRotationPoint(0F, -14F, -8F);

		paintable[10].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, -1F, 1.5F, 0F, -1F, 1.5F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
		paintable[10].setRotationPoint(0F, -14F, 7F);

		paintable[11].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 1.5F, 0F, -1F, 1.5F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F); // Box 11
		paintable[11].setRotationPoint(0F, -5F, 7F);

		paintable[12].addBox(0F, 0F, 0F, 3, 1, 6, 0F); // Box 41
		paintable[12].setRotationPoint(-3F, -1F, -3F);

		paintable[13].addBox(0F, 0F, 0F, 3, 1, 6, 0F); // Box 42
		paintable[13].setRotationPoint(-3F, -16F, -3F);

		paintable[14].addBox(0F, 0F, 0F, 3, 6, 1, 0F); // Box 43
		paintable[14].setRotationPoint(-3F, -11F, -8F);

		paintable[15].addBox(0F, 0F, 0F, 3, 6, 1, 0F); // Box 44
		paintable[15].setRotationPoint(-3F, -11F, 7F);

		paintable[16].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F); // Box 45
		paintable[16].setRotationPoint(-3F, -3F, 3F);

		paintable[17].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 1.5F, 0F, -1F, 1.5F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F); // Box 46
		paintable[17].setRotationPoint(-3F, -5F, 7F);

		paintable[18].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, 2F, 0F, 0F, 2F, 0F); // Box 47
		paintable[18].setRotationPoint(-3F, -3F, -6F);

		paintable[19].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -2F, 0F, 0F, -2F, 0F); // Box 48
		paintable[19].setRotationPoint(-3F, -14F, -6F);

		paintable[20].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 49
		paintable[20].setRotationPoint(-3F, -14F, 3F);

		paintable[21].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, -1F, 1.5F, 0F, -1F, 1.5F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 50
		paintable[21].setRotationPoint(-3F, -14F, 7F);

		paintable[22].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F, 0F, -1F, 1.5F, 0F, -1F, 1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 51
		paintable[22].setRotationPoint(-3F, -14F, -8F);

		paintable[23].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, -1.75F, 0F, -0.25F, -1.75F, 0F, -1F, 1.5F, 0F, -1F, 1.5F); // Box 52
		paintable[23].setRotationPoint(-3F, -5F, -8F);


		second = new ModelRendererTurbo[1];
		second[0] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Box 39

		second[0].addShapeBox(0F, 0F, -0.5F, 1, 7, 1, 0F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, 0F, -0.5F, -0.45F); // Box 39
		second[0].setRotationPoint(2F, -24F, 0F);


		second_ = new ModelRendererTurbo[1];
		second_[0] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Box 80

		second_[0].addShapeBox(0F, 0F, -0.5F, 1, 7, 1, 0F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, 0F, -0.5F, -0.45F); // Box 80
		second_[0].setRotationPoint(-2F, -24F, 0F);


		minute_ = new ModelRendererTurbo[1];
		minute_[0] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Box 77

		minute_[0].addShapeBox(0F, 0F, -0.5F, 1, 6, 1, 0F, 0F, 0F, -0.3F, -0.8F, 0F, -0.3F, -0.8F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, 0F, -0.5F, -0.45F); // Box 77
		minute_[0].setRotationPoint(-1.75F, -24F, 0F);


		hour = new ModelRendererTurbo[1];
		hour[0] = new ModelRendererTurbo(this, 41, 33, textureX, textureY); // Box 38

		hour[0].addShapeBox(0F, 0F, -0.5F, 1, 5, 1, 0F, 0F, 0F, -0.2F, -0.8F, 0F, -0.2F, -0.8F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.5F, -0.4F, -0.8F, -0.5F, -0.4F, -0.8F, -0.5F, -0.4F, 0F, -0.5F, -0.4F); // Box 38
		hour[0].setRotationPoint(1.5F, -24F, 0F);


		minute = new ModelRendererTurbo[1];
		minute[0] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Box 36

		minute[0].addShapeBox(0F, 0F, -0.5F, 1, 6, 1, 0F, 0F, 0F, -0.3F, -0.8F, 0F, -0.3F, -0.8F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, -0.8F, -0.5F, -0.45F, 0F, -0.5F, -0.45F); // Box 36
		minute[0].setRotationPoint(1.75F, -24F, 0F);


		hour_ = new ModelRendererTurbo[1];
		hour_[0] = new ModelRendererTurbo(this, 41, 33, textureX, textureY); // Box 79

		hour_[0].addShapeBox(0F, 0F, -0.5F, 1, 5, 1, 0F, 0F, 0F, -0.2F, -0.8F, 0F, -0.2F, -0.8F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.5F, -0.4F, -0.8F, -0.5F, -0.4F, -0.8F, -0.5F, -0.4F, 0F, -0.5F, -0.4F); // Box 79
		hour_[0].setRotationPoint(-1.5F, -24F, 0F);
		
		translateAll(0F, 24F, 0F);
		
	}
	
}