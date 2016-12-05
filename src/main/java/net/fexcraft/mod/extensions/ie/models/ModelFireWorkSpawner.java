package net.fexcraft.mod.extensions.ie.models;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelFireWorkSpawner extends ModelBase {
	int textureX = 128;
	int textureY = 128;

	public ModelFireWorkSpawner(){
		base = new ModelRendererTurbo[50];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // cable01
		base[1] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // cable02
		base[2] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // cable05
		base[3] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // cable06
		base[4] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 0
		base[5] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 1
		base[6] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 2
		base[7] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 3
		base[8] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 4
		base[9] = new ModelRendererTurbo(this, 89, 9, textureX, textureY); // Box 5
		base[10] = new ModelRendererTurbo(this, 57, 17, textureX, textureY); // Box 6
		base[11] = new ModelRendererTurbo(this, 73, 25, textureX, textureY); // Box 7
		base[12] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 8
		base[13] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 9
		base[14] = new ModelRendererTurbo(this, 97, 25, textureX, textureY); // Box 10
		base[15] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 11
		base[16] = new ModelRendererTurbo(this, 25, 41, textureX, textureY); // Box 12
		base[17] = new ModelRendererTurbo(this, 49, 41, textureX, textureY); // Box 13
		base[18] = new ModelRendererTurbo(this, 25, 9, textureX, textureY); // Box 14
		base[19] = new ModelRendererTurbo(this, 41, 9, textureX, textureY); // Box 15
		base[20] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // Box 16
		base[21] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 17
		base[22] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 18
		base[23] = new ModelRendererTurbo(this, 73, 17, textureX, textureY); // Box 19
		base[24] = new ModelRendererTurbo(this, 73, 41, textureX, textureY); // Box 20
		base[25] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 21
		base[26] = new ModelRendererTurbo(this, 89, 25, textureX, textureY); // Box 22
		base[27] = new ModelRendererTurbo(this, 113, 33, textureX, textureY); // Box 23
		base[28] = new ModelRendererTurbo(this, 97, 41, textureX, textureY); // Box 24
		base[29] = new ModelRendererTurbo(this, 57, 49, textureX, textureY); // Box 25
		base[30] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 26
		base[31] = new ModelRendererTurbo(this, 17, 57, textureX, textureY); // Box 27
		base[32] = new ModelRendererTurbo(this, 33, 57, textureX, textureY); // Box 28
		base[33] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 29
		base[34] = new ModelRendererTurbo(this, 41, 65, textureX, textureY); // Box 30
		base[35] = new ModelRendererTurbo(this, 25, 73, textureX, textureY); // Box 31
		base[36] = new ModelRendererTurbo(this, 57, 73, textureX, textureY); // Box 32
		base[37] = new ModelRendererTurbo(this, 81, 73, textureX, textureY); // Box 33
		base[38] = new ModelRendererTurbo(this, 105, 41, textureX, textureY); // Box 34
		base[39] = new ModelRendererTurbo(this, 97, 73, textureX, textureY); // Box 35
		base[40] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 36
		base[41] = new ModelRendererTurbo(this, 41, 81, textureX, textureY); // Box 37
		base[42] = new ModelRendererTurbo(this, 113, 49, textureX, textureY); // Box 38
		base[43] = new ModelRendererTurbo(this, 97, 81, textureX, textureY); // Box 39
		base[44] = new ModelRendererTurbo(this, 113, 73, textureX, textureY); // Box 40
		base[45] = new ModelRendererTurbo(this, 73, 81, textureX, textureY); // Box 41
		base[46] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 42
		base[47] = new ModelRendererTurbo(this, 65, 49, textureX, textureY); // Box 43
		base[48] = new ModelRendererTurbo(this, 17, 89, textureX, textureY); // Box 44
		base[49] = new ModelRendererTurbo(this, 25, 89, textureX, textureY); // Box 45

		base[0].addShapeBox(0F, 0.1F, -8F, 1, 1, 1, 0F, -0.05F, 0F, -0.5F, -0.05F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.05F, -0.1F, -0.5F, -0.05F, -0.1F, -0.5F, -0.1F, -0.2F, 0F, -0.1F, -0.2F, 0F); // cable01
		base[0].setRotationPoint(0F, -1F, 0F);

		base[1].addShapeBox(-1F, 0.1F, -8F, 1, 1, 1, 0F, -0.05F, 0F, -0.5F, -0.05F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.05F, -0.1F, -0.5F, -0.05F, -0.1F, -0.5F, -0.1F, -0.2F, 0F, -0.1F, -0.2F, 0F); // cable02
		base[1].setRotationPoint(0F, -1F, 0F);

		base[2].addShapeBox(0F, 0F, -8F, 1, 1, 1, 0F, -0.05F, -0.1F, 0F, -0.05F, -0.1F, 0F, -0.05F, -0.1F, -0.5F, -0.05F, -0.1F, -0.5F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, -0.5F, -0.05F, 0F, -0.5F); // cable05
		base[2].setRotationPoint(0F, -1F, 0F);

		base[3].addShapeBox(-1F, 0F, -8F, 1, 1, 1, 0F, -0.05F, -0.1F, 0F, -0.05F, -0.1F, 0F, -0.05F, -0.1F, -0.5F, -0.05F, -0.1F, -0.5F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, -0.5F, -0.05F, 0F, -0.5F); // cable06
		base[3].setRotationPoint(0F, -1F, 0F);

		base[4].addBox(0F, 0F, 0F, 2, 6, 2, 0F); // Box 0
		base[4].setRotationPoint(-8F, -6F, -8F);

		base[5].addBox(0F, 0F, 0F, 2, 6, 2, 0F); // Box 1
		base[5].setRotationPoint(6F, -6F, -8F);

		base[6].addBox(0F, 0F, 0F, 2, 6, 2, 0F); // Box 2
		base[6].setRotationPoint(6F, -6F, 6F);

		base[7].addBox(0F, 0F, 0F, 2, 6, 2, 0F); // Box 3
		base[7].setRotationPoint(-8F, -6F, 6F);

		base[8].addBox(0F, 0F, 0F, 16, 2, 16, 0F); // Box 4
		base[8].setRotationPoint(-8F, -8F, -8F);

		base[9].addBox(0F, 0F, 0F, 8, 1, 8, 0F); // Box 5
		base[9].setRotationPoint(-4F, -3F, -4F);

		base[10].addShapeBox(0F, 0F, 0F, 1, 4, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 3F, -1F, 0F, 3F, -1F, 0F, -4F, 0F, 0F); // Box 6
		base[10].setRotationPoint(-8F, -6F, -4F);

		base[11].addShapeBox(0F, 0F, 0F, 1, 4, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, -1F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 3F, -1F, 0F); // Box 7
		base[11].setRotationPoint(7F, -6F, -4F);

		base[12].addShapeBox(0F, 0F, 0F, 8, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, -1F, 3F, 0F, -1F, 3F); // Box 8
		base[12].setRotationPoint(-4F, -6F, -8F);

		base[13].addShapeBox(0F, 0F, 0F, 8, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 3F, 0F, -1F, 3F, 0F, 0F, -4F, 0F, 0F, -4F); // Box 9
		base[13].setRotationPoint(-4F, -6F, 7F);

		base[14].addShapeBox(0F, 0F, 0F, 4, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, -4F, 0F, 0F); // Box 10
		base[14].setRotationPoint(-8F, -6F, -8F);

		base[15].addShapeBox(0F, 0F, 0F, 4, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, -4F, 0F, -4F, -4F, 0F, 0F, 0F, 0F, 0F); // Box 11
		base[15].setRotationPoint(4F, -6F, -8F);

		base[16].addShapeBox(0F, 0F, 0F, 4, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, -4F, 0F, 0F, -4F); // Box 12
		base[16].setRotationPoint(4F, -6F, 4F);

		base[17].addShapeBox(0F, 0F, 0F, 4, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, -4F, 0F, -4F); // Box 13
		base[17].setRotationPoint(-8F, -6F, 4F);

		base[18].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, 1.9F, 0F, -0.1F, 1.9F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -2.1F, 0F, -0.1F, -2.1F, 0F); // Box 14
		base[18].setRotationPoint(0F, -1F, -7F);

		base[19].addShapeBox(-1F, 0F, 0F, 1, 1, 4, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, 1.9F, 0F, -0.1F, 1.9F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -2.1F, 0F, -0.1F, -2.1F, 0F); // Box 15
		base[19].setRotationPoint(0F, -1F, -7F);

		base[20].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 16
		base[20].setRotationPoint(-8F, -10F, -8F);

		base[21].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 17
		base[21].setRotationPoint(-8F, -10F, 6F);

		base[22].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 18
		base[22].setRotationPoint(6F, -10F, 6F);

		base[23].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 19
		base[23].setRotationPoint(6F, -10F, -8F);

		base[24].addBox(-2F, 0F, -2F, 4, 2, 4, 0F); // Box 20
		base[24].setRotationPoint(0F, -10F, 0F);

		base[25].addShapeBox(-2F, 0F, -3F, 4, 2, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 21
		base[25].setRotationPoint(0F, -10F, 0F);

		base[26].addShapeBox(-2F, 0F, 2F, 4, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 22
		base[26].setRotationPoint(0F, -10F, 0F);

		base[27].addShapeBox(2F, 0F, -2F, 1, 2, 4, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 23
		base[27].setRotationPoint(0F, -10F, 0F);

		base[28].addShapeBox(-3F, 0F, -2F, 1, 2, 4, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 24
		base[28].setRotationPoint(0F, -10F, 0F);

		base[29].addBox(0F, 0F, 0F, 16, 2, 16, 0F); // Box 25
		base[29].setRotationPoint(-8F, -12F, -8F);

		base[30].addShapeBox(0F, 0F, 0F, 8, 4, 1, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, -1F, 3F, 0F, -1F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 26
		base[30].setRotationPoint(-4F, -16F, -8F);

		base[31].addShapeBox(0F, 0F, 0F, 1, 4, 8, 0F, 3F, -1F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 3F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 27
		base[31].setRotationPoint(7F, -16F, -4F);

		base[32].addShapeBox(0F, 0F, 0F, 8, 4, 1, 0F, 0F, -1F, 3F, 0F, -1F, 3F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 28
		base[32].setRotationPoint(-4F, -16F, 7F);

		base[33].addShapeBox(0F, 0F, 0F, 1, 4, 8, 0F, -4F, 0F, 0F, 3F, -1F, 0F, 3F, -1F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		base[33].setRotationPoint(-8F, -16F, -4F);

		base[34].addShapeBox(0F, 0F, 0F, 4, 4, 4, 0F, -4F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 30
		base[34].setRotationPoint(-8F, -16F, -8F);

		base[35].addShapeBox(0F, 0F, 0F, 4, 4, 4, 0F, 0F, 0F, -4F, -4F, 0F, -4F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 31
		base[35].setRotationPoint(4F, -16F, -8F);

		base[36].addShapeBox(0F, 0F, 0F, 4, 4, 4, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 32
		base[36].setRotationPoint(4F, -16F, 4F);

		base[37].addShapeBox(0F, 0F, 0F, 4, 4, 4, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, -4F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 33
		base[37].setRotationPoint(-8F, -16F, 4F);

		base[38].addBox(0F, 0F, 0F, 7, 1, 1, 0F); // Box 34
		base[38].setRotationPoint(-4F, -16F, -4F);

		base[39].addBox(0F, 0F, 0F, 7, 1, 1, 0F); // Box 35
		base[39].setRotationPoint(-3F, -16F, 3F);

		base[40].addBox(0F, 0F, 0F, 1, 1, 7, 0F); // Box 36
		base[40].setRotationPoint(-4F, -16F, -3F);

		base[41].addBox(0F, 0F, 0F, 1, 1, 7, 0F); // Box 37
		base[41].setRotationPoint(3F, -16F, -4F);

		base[42].addShapeBox(0F, 0F, 0F, 4, 12, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 38
		base[42].setRotationPoint(-2F, -28F, -3F);

		base[43].addShapeBox(0F, 0F, 0F, 4, 12, 1, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F); // Box 39
		base[43].setRotationPoint(-2F, -28F, 2F);

		base[44].addShapeBox(0F, 0F, 0F, 1, 12, 4, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F); // Box 40
		base[44].setRotationPoint(-3F, -28F, -2F);

		base[45].addShapeBox(0F, 0F, 0F, 1, 12, 4, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Box 41
		base[45].setRotationPoint(2F, -28F, -2F);

		base[46].addBox(0F, 0F, 0F, 1, 12, 1, 0F); // Box 42
		base[46].setRotationPoint(-3F, -28F, -3F);

		base[47].addBox(0F, 0F, 0F, 1, 12, 1, 0F); // Box 43
		base[47].setRotationPoint(2F, -28F, -3F);

		base[48].addBox(0F, 0F, 0F, 1, 12, 1, 0F); // Box 44
		base[48].setRotationPoint(2F, -28F, 2F);

		base[49].addBox(0F, 0F, 0F, 1, 12, 1, 0F); // Box 45
		base[49].setRotationPoint(-3F, -28F, 2F);


		open = new ModelRendererTurbo[1];
		open[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 46

		open[0].addShapeBox(0F, 0F, 1.5F, 1, 2, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 46
		open[0].setRotationPoint(0F, -10F, 0F);
		
		translateAll(0F, 8F, 0F);
		
	}
}