package net.fexcraft.mod.extensions.bge.models;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class BLK1M extends ModelBase
{
	int textureX = 128;
	int textureY = 64;

	public BLK1M()
	{
		base = new ModelRendererTurbo[22];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		base[1] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 1
		base[2] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 2
		base[3] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 3
		base[4] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 4
		base[5] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 5
		base[6] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Box 6
		base[7] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 7
		base[8] = new ModelRendererTurbo(this, 73, 17, textureX, textureY); // Box 8
		base[9] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 9
		base[10] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 10
		base[11] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 11
		base[12] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 12
		base[13] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 13
		base[14] = new ModelRendererTurbo(this, 89, 25, textureX, textureY); // Box 14
		base[15] = new ModelRendererTurbo(this, 57, 33, textureX, textureY); // Box 15
		base[16] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 16
		base[17] = new ModelRendererTurbo(this, 25, 33, textureX, textureY); // Box 17
		base[18] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 18
		base[19] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 19
		base[20] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 20
		base[21] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 21

		base[0].addBox(-2.5F, -2F, -5F, 5, 2, 10, 0F); // Box 0
		base[0].setRotationPoint(0F, 0F, 0F);

		base[1].addShapeBox(2.5F, -2F, -5F, 2, 2, 10, 0F, 0F, 0F, 0F, 0.5F, 0F, -2F, 0.5F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, -2F, 0.5F, 0F, -2F, 0F, 0F, 0F); // Box 1
		base[1].setRotationPoint(0F, 0F, 0F);

		base[2].addShapeBox(-4.5F, -2F, -5F, 2, 2, 10, 0F, 0.5F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, -2F, 0.5F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, -2F); // Box 2
		base[2].setRotationPoint(0F, 0F, 0F);

		base[3].addShapeBox(-2.5F, -13F, -2.5F, 5, 10, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 3
		base[3].setRotationPoint(0F, 0F, 0F);

		base[4].addBox(-2.5F, -2F, -4.5F, 5, 2, 9, 0F); // Box 4
		base[4].setRotationPoint(0F, -1F, 0F);

		base[5].addShapeBox(2.5F, -3F, -4.5F, 2, 1, 9, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 0F); // Box 5
		base[5].setRotationPoint(0F, 0F, 0F);

		base[6].addShapeBox(-4.5F, -3F, -4.5F, 2, 1, 9, 0F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F); // Box 6
		base[6].setRotationPoint(0F, 0F, 0F);

		base[7].addShapeBox(2.5F, -13F, -2.5F, 1, 10, 5, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 7
		base[7].setRotationPoint(0F, 0F, 0F);

		base[8].addShapeBox(-3.5F, -13F, -2.5F, 1, 10, 5, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 8
		base[8].setRotationPoint(0F, 0F, 0F);

		base[9].addShapeBox(-2.5F, -14F, -3.5F, 5, 1, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 9
		base[9].setRotationPoint(0F, 0F, 0F);

		base[10].addShapeBox(-3.5F, -14F, -2.5F, 1, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 10
		base[10].setRotationPoint(0F, 0F, 0F);

		base[11].addShapeBox(2.5F, -14F, -2.5F, 1, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 11
		base[11].setRotationPoint(0F, 0F, 0F);

		base[12].addBox(-2.5F, -17F, -3.5F, 5, 3, 7, 0F); // Box 12
		base[12].setRotationPoint(0F, 0F, 0F);

		base[13].addBox(-3.5F, -17F, -2.5F, 1, 3, 5, 0F); // Box 13
		base[13].setRotationPoint(0F, 0F, 0F);

		base[14].addBox(2.5F, -17F, -2.5F, 1, 3, 5, 0F); // Box 14
		base[14].setRotationPoint(0F, 0F, 0F);

		base[15].addShapeBox(-2.5F, -18F, -3.5F, 5, 1, 7, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 15
		base[15].setRotationPoint(0F, 0F, 0F);

		base[16].addShapeBox(-3.5F, -18F, -2.5F, 1, 1, 5, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 16
		base[16].setRotationPoint(0F, 0F, 0F);

		base[17].addShapeBox(2.5F, -18F, -2.5F, 1, 1, 5, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 17
		base[17].setRotationPoint(0F, 0F, 0F);

		base[18].addShapeBox(-3.5F, -17F, 2.5F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 18
		base[18].setRotationPoint(0F, 0F, 0F);

		base[19].addShapeBox(-3.5F, -17F, -3.5F, 1, 3, 1, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 19
		base[19].setRotationPoint(0F, 0F, 0F);

		base[20].addShapeBox(2.5F, -17F, -3.5F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 20
		base[20].setRotationPoint(0F, 0F, 0F);

		base[21].addShapeBox(2.5F, -17F, 2.5F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 21
		base[21].setRotationPoint(0F, 0F, 0F);
		
		translateAll(0F, 24F, 0F);
		
	}
}