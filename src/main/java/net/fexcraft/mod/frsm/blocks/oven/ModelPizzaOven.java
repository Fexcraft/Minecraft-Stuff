package net.fexcraft.mod.frsm.blocks.oven;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

/**
 * 
 * @author Ferdinand (FEX___96)
 */
public class ModelPizzaOven extends ModelBase{
	
	int textureX = 256;
	int textureY = 128;

	public ModelPizzaOven(){
		base = new ModelRendererTurbo[48];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		base[1] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Box 1
		base[2] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 2
		base[3] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 3
		base[4] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 4
		base[5] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 8
		base[6] = new ModelRendererTurbo(this, 225, 1, textureX, textureY); // Box 9
		base[7] = new ModelRendererTurbo(this, 57, 25, textureX, textureY); // Box 10
		base[8] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 12
		base[9] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 13
		base[10] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 14
		base[11] = new ModelRendererTurbo(this, 129, 1, textureX, textureY); // Box 15
		base[12] = new ModelRendererTurbo(this, 169, 1, textureX, textureY); // Box 16
		base[13] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 26
		base[14] = new ModelRendererTurbo(this, 225, 9, textureX, textureY); // Box 27
		base[15] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 28
		base[16] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 29
		base[17] = new ModelRendererTurbo(this, 209, 17, textureX, textureY); // Box 30
		base[18] = new ModelRendererTurbo(this, 105, 25, textureX, textureY); // Box 31
		base[19] = new ModelRendererTurbo(this, 193, 25, textureX, textureY); // Box 32
		base[20] = new ModelRendererTurbo(this, 225, 25, textureX, textureY); // Box 33
		base[21] = new ModelRendererTurbo(this, 145, 25, textureX, textureY); // Box 34
		base[22] = new ModelRendererTurbo(this, 177, 25, textureX, textureY); // Box 35
		base[23] = new ModelRendererTurbo(this, 129, 33, textureX, textureY); // Box 36
		base[24] = new ModelRendererTurbo(this, 161, 33, textureX, textureY); // Box 37
		base[25] = new ModelRendererTurbo(this, 193, 33, textureX, textureY); // Box 38
		base[26] = new ModelRendererTurbo(this, 225, 33, textureX, textureY); // Box 39
		base[27] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 40
		base[28] = new ModelRendererTurbo(this, 33, 41, textureX, textureY); // Box 41
		base[29] = new ModelRendererTurbo(this, 81, 41, textureX, textureY); // Box 42
		base[30] = new ModelRendererTurbo(this, 113, 41, textureX, textureY); // Box 43
		base[31] = new ModelRendererTurbo(this, 145, 41, textureX, textureY); // Box 44
		base[32] = new ModelRendererTurbo(this, 177, 41, textureX, textureY); // Box 45
		base[33] = new ModelRendererTurbo(this, 209, 41, textureX, textureY); // Box 46
		base[34] = new ModelRendererTurbo(this, 17, 49, textureX, textureY); // Box 47
		base[35] = new ModelRendererTurbo(this, 49, 49, textureX, textureY); // Box 48
		base[36] = new ModelRendererTurbo(this, 97, 49, textureX, textureY); // Box 49
		base[37] = new ModelRendererTurbo(this, 129, 49, textureX, textureY); // Box 50
		base[38] = new ModelRendererTurbo(this, 161, 49, textureX, textureY); // Box 51
		base[39] = new ModelRendererTurbo(this, 193, 49, textureX, textureY); // Box 52
		base[40] = new ModelRendererTurbo(this, 225, 49, textureX, textureY); // Box 53
		base[41] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 54
		base[42] = new ModelRendererTurbo(this, 249, 9, textureX, textureY); // Box 56
		base[43] = new ModelRendererTurbo(this, 57, 25, textureX, textureY); // Box 57
		base[44] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 58
		base[45] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Box 59
		base[46] = new ModelRendererTurbo(this, 57, 33, textureX, textureY); // Box 60
		base[47] = new ModelRendererTurbo(this, 121, 33, textureX, textureY); // Box 61

		base[0].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 0
		base[0].setRotationPoint(6F, -1F, -6F);

		base[1].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 1
		base[1].setRotationPoint(-7F, -1F, -6F);

		base[2].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 2
		base[2].setRotationPoint(-7F, -1F, 6F);

		base[3].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 3
		base[3].setRotationPoint(6F, -1F, 6F);

		base[4].addBox(0F, 0F, 0F, 16, 1, 15, 0F); // Box 4
		base[4].setRotationPoint(-8F, -2F, -7F);

		base[5].addShapeBox(0F, 0F, 0F, 13, 1, 14, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F); // Box 8
		base[5].setRotationPoint(-7.5F, -8.5F, -7F);

		base[6].addShapeBox(0F, 0F, 0F, 1, 7, 14, 0F, 0F, -0.5F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 9
		base[6].setRotationPoint(-7.5F, -9F, -7F);

		base[7].addShapeBox(0F, 0F, 0F, 1, 7, 14, 0F, -0.5F, -1F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -0.5F, -1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 10
		base[7].setRotationPoint(4.5F, -9F, -7F);

		base[8].addShapeBox(0F, 0F, 0F, 15, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 12
		base[8].setRotationPoint(-7.5F, -8F, 7F);

		base[9].addShapeBox(0F, 0F, 0F, 3, 8, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 13
		base[9].setRotationPoint(5F, -9F, -8F);

		base[10].addShapeBox(0F, 0F, 0F, 1, 8, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 14
		base[10].setRotationPoint(-8F, -9F, -8F);

		base[11].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 15
		base[11].setRotationPoint(-7F, -9F, -8F);

		base[12].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 16
		base[12].setRotationPoint(-7F, -2F, -8F);

		base[13].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.8F, -0.8F, -0.8F, 0F, -0.8F, -0.8F, 0F, 0F, -0.5F, -0.8F); // Box 26
		base[13].setRotationPoint(-7F, -3.5F, -6F);

		base[14].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.8F, -0.8F, -0.8F, 0F, -0.8F, -0.8F, 0F, 0F, -0.5F, -0.8F); // Box 27
		base[14].setRotationPoint(-7F, -3.5F, 3F);

		base[15].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, -0.8F, 0F, 0F, -0.5F, -0.8F, 0F, -0.5F, -0.8F, -0.8F, -0.8F, 0F); // Box 28
		base[15].setRotationPoint(4F, -3.5F, 3F);

		base[16].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, -0.8F, 0F, 0F, -0.5F, -0.8F, 0F, -0.5F, -0.8F, -0.8F, -0.8F, 0F); // Box 29
		base[16].setRotationPoint(4F, -3.5F, -6F);

		base[17].addShapeBox(0F, 0F, 0F, 1, 1, 13, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, -0.5F, -0.8F, 0F, -0.5F, -0.8F, 0F, 0F, -0.8F, 0F); // Box 30
		base[17].setRotationPoint(-7F, -3.7F, -6.5F);

		base[18].addShapeBox(0F, 0F, 0F, 1, 1, 13, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, -0.5F, -0.8F, 0F); // Box 31
		base[18].setRotationPoint(4F, -3.7F, -6.5F);

		base[19].addShapeBox(0F, 0F, 0F, 11, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, -0.5F, 0F, -0.8F, -0.5F); // Box 32
		base[19].setRotationPoint(-6.5F, -3.7F, -6.5F);

		base[20].addShapeBox(0F, 0F, 0F, 11, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, -0.5F, 0F, -0.8F, -0.5F, 0F, -0.8F, 0F, 0F, -0.8F, 0F); // Box 33
		base[20].setRotationPoint(-6.5F, -3.7F, 5.5F);

		base[21].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 34
		base[21].setRotationPoint(-6.5F, -3.7F, -6F);

		base[22].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 35
		base[22].setRotationPoint(-6F, -3.7F, -6F);

		base[23].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 36
		base[23].setRotationPoint(-5.5F, -3.7F, -6F);

		base[24].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 37
		base[24].setRotationPoint(-5F, -3.7F, -6F);

		base[25].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 38
		base[25].setRotationPoint(-4.5F, -3.7F, -6F);

		base[26].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 39
		base[26].setRotationPoint(-4F, -3.7F, -6F);

		base[27].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 40
		base[27].setRotationPoint(-3.5F, -3.7F, -6F);

		base[28].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 41
		base[28].setRotationPoint(-3F, -3.7F, -6F);

		base[29].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 42
		base[29].setRotationPoint(-2.5F, -3.7F, -6F);

		base[30].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 43
		base[30].setRotationPoint(-2F, -3.7F, -6F);

		base[31].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 44
		base[31].setRotationPoint(-1.5F, -3.7F, -6F);

		base[32].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 45
		base[32].setRotationPoint(-1F, -3.7F, -6F);

		base[33].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 46
		base[33].setRotationPoint(-0.5F, -3.7F, -6F);

		base[34].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 47
		base[34].setRotationPoint(0F, -3.7F, -6F);

		base[35].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 48
		base[35].setRotationPoint(0.5F, -3.7F, -6F);

		base[36].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 49
		base[36].setRotationPoint(1F, -3.7F, -6F);

		base[37].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 50
		base[37].setRotationPoint(1.5F, -3.7F, -6F);

		base[38].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 51
		base[38].setRotationPoint(2F, -3.7F, -6F);

		base[39].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 52
		base[39].setRotationPoint(2.5F, -3.7F, -6F);

		base[40].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 53
		base[40].setRotationPoint(3F, -3.7F, -6F);

		base[41].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F); // Box 54
		base[41].setRotationPoint(3.5F, -3.7F, -6F);

		base[42].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 56
		base[42].setRotationPoint(5.5F, -8.5F, -7.6F);

		base[43].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F); // Box 57
		base[43].setRotationPoint(5.5F, -6.5F, -7.6F);

		base[44].addBox(0F, 0F, 0F, 2, 1, 1, 0F); // Box 58
		base[44].setRotationPoint(5.5F, -7.5F, -7.6F);

		base[45].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F); // Box 59
		base[45].setRotationPoint(5.5F, -3.5F, -7.6F);

		base[46].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 60
		base[46].setRotationPoint(5.5F, -5.5F, -7.6F);

		base[47].addBox(0F, 0F, 0F, 2, 1, 1, 0F); // Box 61
		base[47].setRotationPoint(5.5F, -4.5F, -7.6F);


		closed = new ModelRendererTurbo[5];
		closed[0] = new ModelRendererTurbo(this, 161, 25, textureX, textureY); // Box 21
		closed[1] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 22
		closed[2] = new ModelRendererTurbo(this, 249, 1, textureX, textureY); // Box 23
		closed[3] = new ModelRendererTurbo(this, 209, 9, textureX, textureY); // Box 24
		closed[4] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 25

		closed[0].addShapeBox(0F, 0F, 0F, 12, 6, 1, 0F, 0F, 0F, -0.7F, 0F, 0F, -0.7F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.7F, 0F, 0F, -0.7F, 0F, 0F, -0.1F, 0F, 0F, -0.1F); // Box 21
		closed[0].setRotationPoint(-7F, -8F, -8F);

		closed[1].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F); // Box 22
		closed[1].setRotationPoint(0.5F, -7.5F, -8.2F);

		closed[2].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F); // Box 23
		closed[2].setRotationPoint(-3.5F, -7.5F, -8.2F);

		closed[3].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -0.2F, -0.6F, 0F, -0.2F, -0.6F, 0F, -0.2F, -0.6F, -0.4F, -0.2F, -0.6F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F); // Box 24
		closed[3].setRotationPoint(-4F, -8F, -8.5F);

		closed[4].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, -0.2F, -0.6F, 0F, -0.2F, -0.6F, 0F, -0.2F, -0.6F, -0.4F, -0.2F, -0.6F, -0.4F); // Box 25
		closed[4].setRotationPoint(-4F, -7F, -8.5F);


		r0 = new ModelRendererTurbo[1];
		r0[0] = new ModelRendererTurbo(this, 89, 9, textureX, textureY); // Box 55

		r0[0].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.6F, 0F, -0.2F, -0.6F, 0F, 0.8F, -0.6F, 0F, 0.8F, -0.6F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0.8F, 0F, 0F, 0.8F, 0F, 0F); // Box 55
		r0[0].setRotationPoint(6F, -2.5F, -7.7F);


		r1 = new ModelRendererTurbo[1];
		r1[0] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 63

		r1[0].addShapeBox(-0.5F, -0.5F, 0F, 1, 1, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0.4F, -0.6F, -0.3F, 0.4F, -0.6F, -0.3F, 0.4F, 0F, -0.3F, 0.4F, 0F, -0.3F, 0.4F, -0.6F, -0.3F, 0.4F, -0.6F); // Box 63
		r1[0].setRotationPoint(6.5F, -4F, -8F);
		r1[0].rotateAngleZ = 0.85521133F;


		r2 = new ModelRendererTurbo[1];
		r2[0] = new ModelRendererTurbo(this, 233, 9, textureX, textureY); // Box 62

		r2[0].addShapeBox(-0.5F, -0.5F, 0F, 1, 1, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0.4F, -0.6F, -0.3F, 0.4F, -0.6F, -0.3F, 0.4F, 0F, -0.3F, 0.4F, 0F, -0.3F, 0.4F, -0.6F, -0.3F, 0.4F, -0.6F); // Box 62
		r2[0].setRotationPoint(6.5F, -7F, -8F);
		r2[0].rotateAngleZ = -0.76794487F;


		r3 = new ModelRendererTurbo[4];
		r3[0] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 5
		r3[1] = new ModelRendererTurbo(this, 145, 1, textureX, textureY); // Box 6
		r3[2] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 7
		r3[3] = new ModelRendererTurbo(this, 81, 25, textureX, textureY); // Box 11

		r3[0].addShapeBox(0F, 0F, 0F, 16, 1, 15, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F); // Box 5
		r3[0].setRotationPoint(-8F, -9F, -7F);

		r3[1].addShapeBox(0F, 0F, 0F, 1, 7, 15, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 6
		r3[1].setRotationPoint(-8F, -9F, -7F);

		r3[2].addShapeBox(0F, 0F, 0F, 1, 7, 15, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 7
		r3[2].setRotationPoint(7F, -9F, -7F);

		r3[3].addShapeBox(0F, 0F, 0F, 15, 7, 1, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 11
		r3[3].setRotationPoint(-7.5F, -9F, 7F);
		
		translateAll(0F, 24F, 0F);
		
	}
	
}