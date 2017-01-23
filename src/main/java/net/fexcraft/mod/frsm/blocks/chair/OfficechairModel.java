package net.fexcraft.mod.frsm.blocks.chair;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class OfficechairModel extends ModelBase {
	
	int textureX = 128;
	int textureY = 128;

	public OfficechairModel(){
		base = new ModelRendererTurbo[34];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		base[1] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 1
		base[2] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 2
		base[3] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 3
		base[4] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 4
		base[5] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 5
		base[6] = new ModelRendererTurbo(this, 25, 17, textureX, textureY); // Box 6
		base[7] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 7
		base[8] = new ModelRendererTurbo(this, 73, 17, textureX, textureY); // Box 8
		base[9] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 9
		base[10] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 10
		base[11] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 11
		base[12] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 12
		base[13] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 13
		base[14] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 14
		base[15] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 15
		base[16] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 16
		base[17] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 17
		base[18] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 18
		base[19] = new ModelRendererTurbo(this, 41, 17, textureX, textureY); // Box 19
		base[20] = new ModelRendererTurbo(this, 65, 17, textureX, textureY); // Box 20
		base[21] = new ModelRendererTurbo(this, 89, 17, textureX, textureY); // Box 21
		base[22] = new ModelRendererTurbo(this, 113, 17, textureX, textureY); // Box 22
		base[23] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 23
		base[24] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 24
		base[25] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Box 25
		base[26] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Box 26
		base[27] = new ModelRendererTurbo(this, 65, 33, textureX, textureY); // Box 27
		base[28] = new ModelRendererTurbo(this, 81, 33, textureX, textureY); // Box 28
		base[29] = new ModelRendererTurbo(this, 97, 33, textureX, textureY); // Box 29
		base[30] = new ModelRendererTurbo(this, 121, 9, textureX, textureY); // Box 30
		base[31] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 31
		base[32] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 32
		base[33] = new ModelRendererTurbo(this, 113, 33, textureX, textureY); // Box 33

		base[0].addShapeBox(0F, 0F, 0F, 1, 1, 8, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F); // Box 0
		base[0].setRotationPoint(0F, -3F, 0F);
		base[0].rotateAngleX = -0.01745329F;

		base[1].addShapeBox(-1F, 0F, 0F, 1, 1, 8, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F); // Box 1
		base[1].setRotationPoint(0F, -3F, 0F);
		base[1].rotateAngleX = -0.01745329F;

		base[2].addShapeBox(0F, 0F, 0F, 1, 1, 8, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F); // Box 2
		base[2].setRotationPoint(0F, -3F, 0F);
		base[2].rotateAngleX = -0.01745329F;
		base[2].rotateAngleY = -1.25663706F;

		base[3].addShapeBox(-1F, 0F, 0F, 1, 1, 8, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F); // Box 3
		base[3].setRotationPoint(0F, -3F, 0F);
		base[3].rotateAngleX = -0.01745329F;
		base[3].rotateAngleY = -1.25663706F;

		base[4].addShapeBox(0F, 0F, 0F, 1, 1, 8, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F); // Box 4
		base[4].setRotationPoint(0F, -3F, 0F);
		base[4].rotateAngleX = -0.01745329F;
		base[4].rotateAngleY = -2.51327412F;

		base[5].addShapeBox(-1F, 0F, 0F, 1, 1, 8, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F); // Box 5
		base[5].setRotationPoint(0F, -3F, 0F);
		base[5].rotateAngleX = -0.01745329F;
		base[5].rotateAngleY = -2.51327412F;

		base[6].addShapeBox(-1F, 0F, 0F, 1, 1, 8, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F); // Box 6
		base[6].setRotationPoint(0F, -3F, 0F);
		base[6].rotateAngleX = -0.01745329F;
		base[6].rotateAngleY = 2.51327412F;

		base[7].addShapeBox(0F, 0F, 0F, 1, 1, 8, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F); // Box 7
		base[7].setRotationPoint(0F, -3F, 0F);
		base[7].rotateAngleX = -0.01745329F;
		base[7].rotateAngleY = 2.51327412F;

		base[8].addShapeBox(-1F, 0F, 0F, 1, 1, 8, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F); // Box 8
		base[8].setRotationPoint(0F, -3F, 0F);
		base[8].rotateAngleX = -0.01745329F;
		base[8].rotateAngleY = 1.25663706F;

		base[9].addShapeBox(0F, 0F, 0F, 1, 1, 8, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F); // Box 9
		base[9].setRotationPoint(0F, -3F, 0F);
		base[9].rotateAngleX = -0.01745329F;
		base[9].rotateAngleY = 1.25663706F;

		base[10].addBox(-0.5F, -0.5F, 6.5F, 1, 1, 1, 0F); // Box 10
		base[10].setRotationPoint(0F, -2F, 0F);

		base[11].addBox(-0.5F, -0.5F, 6.5F, 1, 1, 1, 0F); // Box 11
		base[11].setRotationPoint(0F, -2F, 0F);
		base[11].rotateAngleY = -1.25663706F;

		base[12].addBox(-0.5F, -0.5F, 6.5F, 1, 1, 1, 0F); // Box 12
		base[12].setRotationPoint(0F, -2F, 0F);
		base[12].rotateAngleY = -2.51327412F;

		base[13].addBox(-0.5F, -0.5F, 6.5F, 1, 1, 1, 0F); // Box 13
		base[13].setRotationPoint(0F, -2F, 0F);
		base[13].rotateAngleY = 1.25663706F;

		base[14].addBox(-0.5F, -0.5F, 6.5F, 1, 1, 1, 0F); // Box 14
		base[14].setRotationPoint(0F, -2F, 0F);
		base[14].rotateAngleY = 2.51327412F;

		base[15].addShapeBox(-1F, 1.5F, 6F, 2, 1, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F); // Box 15
		base[15].setRotationPoint(0F, -2F, 0F);

		base[16].addShapeBox(-1F, -0.25F, 6F, 2, 1, 2, 0F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 16
		base[16].setRotationPoint(0F, -2F, 0F);

		base[17].addShapeBox(-1F, 0.75F, 6F, 2, 1, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F); // Box 17
		base[17].setRotationPoint(0F, -2F, 0F);

		base[18].addShapeBox(-1F, -0.25F, 6F, 2, 1, 2, 0F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 18
		base[18].setRotationPoint(0F, -2F, 0F);
		base[18].rotateAngleY = -1.25663706F;

		base[19].addShapeBox(-1F, 0.75F, 6F, 2, 1, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F); // Box 19
		base[19].setRotationPoint(0F, -2F, 0F);
		base[19].rotateAngleY = -1.25663706F;

		base[20].addShapeBox(-1F, 1.5F, 6F, 2, 1, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F); // Box 20
		base[20].setRotationPoint(0F, -2F, 0F);
		base[20].rotateAngleY = -1.25663706F;

		base[21].addShapeBox(-1F, -0.25F, 6F, 2, 1, 2, 0F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 21
		base[21].setRotationPoint(0F, -2F, 0F);
		base[21].rotateAngleY = -2.51327412F;

		base[22].addShapeBox(-1F, 0.75F, 6F, 2, 1, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F); // Box 22
		base[22].setRotationPoint(0F, -2F, 0F);
		base[22].rotateAngleY = -2.51327412F;

		base[23].addShapeBox(-1F, 1.5F, 6F, 2, 1, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F); // Box 23
		base[23].setRotationPoint(0F, -2F, 0F);
		base[23].rotateAngleY = -2.51327412F;

		base[24].addShapeBox(-1F, -0.25F, 6F, 2, 1, 2, 0F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 24
		base[24].setRotationPoint(0F, -2F, 0F);
		base[24].rotateAngleY = 1.25663706F;

		base[25].addShapeBox(-1F, 0.75F, 6F, 2, 1, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F); // Box 25
		base[25].setRotationPoint(0F, -2F, 0F);
		base[25].rotateAngleY = 1.25663706F;

		base[26].addShapeBox(-1F, 1.5F, 6F, 2, 1, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F); // Box 26
		base[26].setRotationPoint(0F, -2F, 0F);
		base[26].rotateAngleY = 1.25663706F;

		base[27].addShapeBox(-1F, -0.25F, 6F, 2, 1, 2, 0F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 27
		base[27].setRotationPoint(0F, -2F, 0F);
		base[27].rotateAngleY = 2.51327412F;

		base[28].addShapeBox(-1F, 0.75F, 6F, 2, 1, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F); // Box 28
		base[28].setRotationPoint(0F, -2F, 0F);
		base[28].rotateAngleY = 2.51327412F;

		base[29].addShapeBox(-1F, 1.5F, 6F, 2, 1, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F); // Box 29
		base[29].setRotationPoint(0F, -2F, 0F);
		base[29].rotateAngleY = 2.51327412F;

		base[30].addShapeBox(0F, -0.5F, -1F, 1, 3, 2, 0F, 0F, 0F, 0.2F, 0.2F, 0F, -0.3F, 0.2F, 0F, -0.3F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0.2F, 0F, -0.3F, 0.2F, 0F, -0.3F, 0F, 0F, 0.2F); // Box 30
		base[30].setRotationPoint(0F, -5F, 0F);

		base[31].addShapeBox(-1F, -0.5F, -1F, 1, 3, 2, 0F, 0.2F, 0F, -0.3F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0.2F, 0F, -0.3F, 0.2F, 0F, -0.3F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0.2F, 0F, -0.3F); // Box 31
		base[31].setRotationPoint(0F, -5F, 0F);

		base[32].addShapeBox(0F, -0.5F, -1F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F); // Box 32
		base[32].setRotationPoint(0F, -7F, 0F);

		base[33].addShapeBox(-1F, -0.5F, -1F, 1, 2, 2, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F); // Box 33
		base[33].setRotationPoint(0F, -7F, 0F);


		r1 = new ModelRendererTurbo[27];
		r1[0] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 34
		r1[1] = new ModelRendererTurbo(this, 17, 41, textureX, textureY); // Box 35
		r1[2] = new ModelRendererTurbo(this, 33, 41, textureX, textureY); // Box 36
		r1[3] = new ModelRendererTurbo(this, 49, 41, textureX, textureY); // Box 37
		r1[4] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 38
		r1[5] = new ModelRendererTurbo(this, 41, 9, textureX, textureY); // Box 39
		r1[6] = new ModelRendererTurbo(this, 65, 41, textureX, textureY); // Box 40
		r1[7] = new ModelRendererTurbo(this, 81, 41, textureX, textureY); // Box 41
		r1[8] = new ModelRendererTurbo(this, 121, 33, textureX, textureY); // Box 45
		r1[9] = new ModelRendererTurbo(this, 65, 49, textureX, textureY); // Box 46
		r1[10] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 47
		r1[11] = new ModelRendererTurbo(this, 49, 57, textureX, textureY); // Box 51
		r1[12] = new ModelRendererTurbo(this, 65, 57, textureX, textureY); // Box 52
		r1[13] = new ModelRendererTurbo(this, 81, 57, textureX, textureY); // Box 53
		r1[14] = new ModelRendererTurbo(this, 97, 57, textureX, textureY); // Box 54
		r1[15] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 55
		r1[16] = new ModelRendererTurbo(this, 33, 41, textureX, textureY); // Box 56
		r1[17] = new ModelRendererTurbo(this, 49, 41, textureX, textureY); // Box 57
		r1[18] = new ModelRendererTurbo(this, 113, 57, textureX, textureY); // Box 58
		r1[19] = new ModelRendererTurbo(this, 121, 57, textureX, textureY); // Box 59
		r1[20] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 60
		r1[21] = new ModelRendererTurbo(this, 9, 65, textureX, textureY); // Box 61
		r1[22] = new ModelRendererTurbo(this, 49, 65, textureX, textureY); // Box 62
		r1[23] = new ModelRendererTurbo(this, 49, 65, textureX, textureY); // Box 63
		r1[24] = new ModelRendererTurbo(this, 73, 65, textureX, textureY); // Box 64
		r1[25] = new ModelRendererTurbo(this, 97, 65, textureX, textureY); // Box 65
		r1[26] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 66

		r1[0].addBox(-2F, -0.5F, -1F, 4, 1, 5, 0F); // Box 34
		r1[0].setRotationPoint(0F, -8F, 0F);

		r1[1].addShapeBox(-2F, -0.5F, -4F, 4, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 35
		r1[1].setRotationPoint(0F, -8F, 0F);

		r1[2].addShapeBox(2F, -0.5F, -1F, 2, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F); // Box 36
		r1[2].setRotationPoint(0F, -8F, 0F);

		r1[3].addShapeBox(-4F, -0.5F, -1F, 2, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F); // Box 37
		r1[3].setRotationPoint(0F, -8F, 0F);

		r1[4].addShapeBox(2F, -0.5F, -4F, 2, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F); // Box 38
		r1[4].setRotationPoint(0F, -8F, 0F);

		r1[5].addShapeBox(-4F, -0.5F, -4F, 2, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F); // Box 39
		r1[5].setRotationPoint(0F, -8F, 0F);

		r1[6].addBox(-1F, 0F, 4F, 2, 1, 2, 0F); // Box 40
		r1[6].setRotationPoint(0F, -9F, 0F);

		r1[7].addShapeBox(-1F, 0F, 6F, 2, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F); // Box 41
		r1[7].setRotationPoint(0F, -9F, 0F);

		r1[8].addBox(-1F, -8F, 7F, 2, 7, 1, 0F); // Box 45
		r1[8].setRotationPoint(0F, -9F, 0F);

		r1[9].addBox(-2F, -9F, 6.5F, 4, 4, 1, 0F); // Box 46
		r1[9].setRotationPoint(0F, -9F, 0F);
		r1[9].rotateAngleX = -0.05235988F;

		r1[10].addShapeBox(-2F, -11F, 6.5F, 4, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 47
		r1[10].setRotationPoint(0F, -9F, 0F);
		r1[10].rotateAngleX = -0.05235988F;

		r1[11].addBox(3.5F, -0.25F, 1.5F, 3, 1, 1, 0F); // Box 51
		r1[11].setRotationPoint(0F, -9F, 0F);

		r1[12].addBox(3.5F, -0.25F, -2.5F, 3, 1, 1, 0F); // Box 52
		r1[12].setRotationPoint(0F, -9F, 0F);

		r1[13].addBox(-6.5F, -0.25F, -2.5F, 3, 1, 1, 0F); // Box 53
		r1[13].setRotationPoint(0F, -9F, 0F);

		r1[14].addBox(-6.5F, -0.25F, 1.5F, 3, 1, 1, 0F); // Box 54
		r1[14].setRotationPoint(0F, -9F, 0F);

		r1[15].addShapeBox(6.5F, -0.25F, 1.5F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 55
		r1[15].setRotationPoint(0F, -9F, 0F);

		r1[16].addShapeBox(6.5F, -0.25F, -2.5F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 56
		r1[16].setRotationPoint(0F, -9F, 0F);

		r1[17].addShapeBox(-7.5F, -0.25F, -2.5F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 57
		r1[17].setRotationPoint(0F, -9F, 0F);

		r1[18].addShapeBox(-7.5F, -0.25F, 1.5F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 58
		r1[18].setRotationPoint(0F, -9F, 0F);

		r1[19].addBox(6.5F, -4.25F, 1.5F, 1, 4, 1, 0F); // Box 59
		r1[19].setRotationPoint(0F, -9F, 0F);

		r1[20].addBox(6.5F, -4.25F, -2.5F, 1, 4, 1, 0F); // Box 60
		r1[20].setRotationPoint(0F, -9F, 0F);

		r1[21].addBox(-7.5F, -4.25F, -2.5F, 1, 4, 1, 0F); // Box 61
		r1[21].setRotationPoint(0F, -9F, 0F);

		r1[22].addBox(-7.5F, -4.25F, 1.5F, 1, 4, 1, 0F); // Box 62
		r1[22].setRotationPoint(0F, -9F, 0F);

		r1[23].addShapeBox(6F, -4.4F, -4F, 1, 1, 8, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 63
		r1[23].setRotationPoint(0F, -9F, 0F);

		r1[24].addShapeBox(7F, -4.4F, -4F, 1, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 64
		r1[24].setRotationPoint(0F, -9F, 0F);

		r1[25].addShapeBox(-7F, -4.4F, -4F, 1, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 65
		r1[25].setRotationPoint(0F, -9F, 0F);

		r1[26].addShapeBox(-8F, -4.4F, -4F, 1, 1, 8, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 66
		r1[26].setRotationPoint(0F, -9F, 0F);


		r0 = new ModelRendererTurbo[6];
		r0[0] = new ModelRendererTurbo(this, 81, 41, textureX, textureY); // Box 42
		r0[1] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 43
		r0[2] = new ModelRendererTurbo(this, 33, 49, textureX, textureY); // Box 44
		r0[3] = new ModelRendererTurbo(this, 17, 57, textureX, textureY); // Box 48
		r0[4] = new ModelRendererTurbo(this, 33, 57, textureX, textureY); // Box 49
		r0[5] = new ModelRendererTurbo(this, 41, 57, textureX, textureY); // Box 50

		r0[0].addBox(-6F, -0.5F, -5F, 12, 1, 9, 0F); // Box 42
		r0[0].setRotationPoint(0F, -9F, 0F);

		r0[1].addShapeBox(-6F, -0.5F, -7F, 12, 1, 2, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 43
		r0[1].setRotationPoint(0F, -9F, 0F);

		r0[2].addShapeBox(-6F, -0.5F, 4F, 12, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F); // Box 44
		r0[2].setRotationPoint(0F, -9F, 0F);

		r0[3].addBox(-3F, -15F, 6F, 6, 12, 1, 0F); // Box 48
		r0[3].setRotationPoint(0F, -8F, 0F);
		r0[3].rotateAngleX = -0.05235988F;

		r0[4].addShapeBox(-5F, -15F, 6F, 2, 12, 1, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 49
		r0[4].setRotationPoint(0F, -8F, 0F);
		r0[4].rotateAngleX = -0.05235988F;

		r0[5].addShapeBox(3F, -15F, 6F, 2, 12, 1, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 50
		r0[5].setRotationPoint(0F, -8F, 0F);
		r0[5].rotateAngleX = -0.05235988F;
		
		translateAll(0F, 24F, 0F);
		
	}
}