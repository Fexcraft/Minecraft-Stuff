package net.fexcraft.mod.extensions.bge.models;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelChessTower extends ModelBase{
	int textureX = 128;
	int textureY = 64;

	public ModelChessTower(){
		base = new ModelRendererTurbo[35];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Import Box0
		base[1] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Import Box1
		base[2] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Import Box2
		base[3] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Import Box3
		base[4] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Import Box4
		base[5] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Import Box5
		base[6] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Import Box6
		base[7] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Import Box7
		base[8] = new ModelRendererTurbo(this, 73, 17, textureX, textureY); // Import Box8
		base[9] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Import Box9
		base[10] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Import Box10
		base[11] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Import Box11
		base[12] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Import Box12
		base[13] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Import Box13
		base[14] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Import Box14
		base[15] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Import Box15
		base[16] = new ModelRendererTurbo(this, 89, 25, textureX, textureY); // Import Box16
		base[17] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Import Box17
		base[18] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Import Box18
		base[19] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Import Box19
		base[20] = new ModelRendererTurbo(this, 121, 9, textureX, textureY); // Import Box20
		base[21] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Import Box21
		base[22] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 0
		base[23] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 1
		base[24] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 24
		base[25] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 25
		base[26] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 26
		base[27] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 27
		base[28] = new ModelRendererTurbo(this, 25, 17, textureX, textureY); // Box 28
		base[29] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 29
		base[30] = new ModelRendererTurbo(this, 41, 17, textureX, textureY); // Box 30
		base[31] = new ModelRendererTurbo(this, 73, 17, textureX, textureY); // Box 31
		base[32] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 32
		base[33] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 33
		base[34] = new ModelRendererTurbo(this, 57, 25, textureX, textureY); // Box 34

		base[0].addBox(-2.5F, -2F, -5F, 5, 2, 10, 0F); // Import Box0
		base[0].setRotationPoint(0F, -24F, 0F);

		base[1].addShapeBox(2.5F, -2F, -5F, 2, 2, 10, 0F, 0F, 0F, 0F, 0.5F, 0F, -2F, 0.5F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, -2F, 0.5F, 0F, -2F, 0F, 0F, 0F); // Import Box1
		base[1].setRotationPoint(0F, -24F, 0F);

		base[2].addShapeBox(-4.5F, -2F, -5F, 2, 2, 10, 0F, 0.5F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, -2F, 0.5F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, -2F); // Import Box2
		base[2].setRotationPoint(0F, -24F, 0F);

		base[3].addShapeBox(-2.5F, -13F, -2.5F, 5, 10, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F); // Import Box3
		base[3].setRotationPoint(0F, -24F, 0F);

		base[4].addBox(-2.5F, -2F, -4.5F, 5, 2, 9, 0F); // Import Box4
		base[4].setRotationPoint(0F, -25F, 0F);

		base[5].addShapeBox(2.5F, -3F, -4.5F, 2, 1, 9, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 0F); // Import Box5
		base[5].setRotationPoint(0F, -24F, 0F);

		base[6].addShapeBox(-4.5F, -3F, -4.5F, 2, 1, 9, 0F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F); // Import Box6
		base[6].setRotationPoint(0F, -24F, 0F);

		base[7].addShapeBox(2.5F, -13F, -2.5F, 1, 10, 5, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import Box7
		base[7].setRotationPoint(0F, -24F, 0F);

		base[8].addShapeBox(-3.5F, -13F, -2.5F, 1, 10, 5, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import Box8
		base[8].setRotationPoint(0F, -24F, 0F);

		base[9].addShapeBox(-2.5F, -14F, -3.5F, 5, 1, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Import Box9
		base[9].setRotationPoint(0F, -24F, 0F);

		base[10].addShapeBox(-3.5F, -14F, -2.5F, 1, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Import Box10
		base[10].setRotationPoint(0F, -24F, 0F);

		base[11].addShapeBox(2.5F, -14F, -2.5F, 1, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Import Box11
		base[11].setRotationPoint(0F, -24F, 0F);

		base[12].addBox(-2.5F, -17F, -3.5F, 5, 1, 7, 0F); // Import Box12
		base[12].setRotationPoint(0F, -22F, 0F);

		base[13].addBox(-3.5F, -17F, -2.5F, 1, 1, 5, 0F); // Import Box13
		base[13].setRotationPoint(0F, -22F, 0F);

		base[14].addBox(2.5F, -17F, -2.5F, 1, 1, 5, 0F); // Import Box14
		base[14].setRotationPoint(0F, -22F, 0F);

		base[15].addBox(-2.5F, -18F, -3.5F, 5, 2, 1, 0F); // Import Box15
		base[15].setRotationPoint(0F, -23F, 0F);

		base[16].addBox(-3.5F, -18F, -2.5F, 1, 2, 5, 0F); // Import Box16
		base[16].setRotationPoint(0F, -23F, 0F);

		base[17].addBox(2.5F, -18F, -2.5F, 1, 2, 5, 0F); // Import Box17
		base[17].setRotationPoint(0F, -23F, 0F);

		base[18].addShapeBox(-3.5F, -17F, 2.5F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Import Box18
		base[18].setRotationPoint(0F, -25F, 0F);

		base[19].addShapeBox(-3.5F, -17F, -3.5F, 1, 4, 1, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import Box19
		base[19].setRotationPoint(0F, -25F, 0F);

		base[20].addShapeBox(2.5F, -17F, -3.5F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Import Box20
		base[20].setRotationPoint(0F, -25F, 0F);

		base[21].addShapeBox(2.5F, -17F, 2.5F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F); // Import Box21
		base[21].setRotationPoint(0F, -25F, 0F);

		base[22].addBox(-2.5F, -18F, -3.5F, 5, 2, 1, 0F); // Box 0
		base[22].setRotationPoint(0F, -23F, 6F);

		base[23].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 1
		base[23].setRotationPoint(1.5F, -42F, 2.5F);

		base[24].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 24
		base[24].setRotationPoint(-2.5F, -42F, 2.5F);

		base[25].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 25
		base[25].setRotationPoint(-0.5F, -42F, 2.5F);

		base[26].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 26
		base[26].setRotationPoint(-2.5F, -42F, -3.5F);

		base[27].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 27
		base[27].setRotationPoint(-0.5F, -42F, -3.5F);

		base[28].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 28
		base[28].setRotationPoint(1.5F, -42F, -3.5F);

		base[29].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 29
		base[29].setRotationPoint(2.5F, -42F, 1.5F);

		base[30].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 30
		base[30].setRotationPoint(2.5F, -42F, -0.5F);

		base[31].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 31
		base[31].setRotationPoint(2.5F, -42F, -2.5F);

		base[32].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 32
		base[32].setRotationPoint(-3.5F, -42F, -2.5F);

		base[33].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 33
		base[33].setRotationPoint(-3.5F, -42F, -0.5F);

		base[34].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 34
		base[34].setRotationPoint(-3.5F, -42F, 1.5F);

		translateAll(0F, 48F, 0F);

	}
}