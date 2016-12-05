package net.fexcraft.mod.frsm.blocks.furnace;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelFurnance1 extends ModelBase {
	
	int textureX = 128;
	int textureY = 128;
	
	public ModelFurnance1(){
		base = new ModelRendererTurbo[54];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		base[1] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Box 1
		base[2] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 2
		base[3] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 3
		base[4] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 4
		base[5] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 5
		base[6] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 6
		base[7] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 7
		base[8] = new ModelRendererTurbo(this, 49, 41, textureX, textureY); // Box 8
		base[9] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 9
		base[10] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 10
		base[11] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 11
		base[12] = new ModelRendererTurbo(this, 89, 41, textureX, textureY); // Box 13
		base[13] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 14
		base[14] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 15
		base[15] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 16
		base[16] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 17
		base[17] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 18
		base[18] = new ModelRendererTurbo(this, 17, 57, textureX, textureY); // Box 19
		base[19] = new ModelRendererTurbo(this, 9, 17, textureX, textureY); // Box 20
		base[20] = new ModelRendererTurbo(this, 17, 49, textureX, textureY); // Box 21
		base[21] = new ModelRendererTurbo(this, 65, 49, textureX, textureY); // Box 22
		base[22] = new ModelRendererTurbo(this, 81, 57, textureX, textureY); // Box 23
		base[23] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 24
		base[24] = new ModelRendererTurbo(this, 81, 65, textureX, textureY); // Box 25
		base[25] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 26
		base[26] = new ModelRendererTurbo(this, 33, 73, textureX, textureY); // Box 27
		base[27] = new ModelRendererTurbo(this, 65, 73, textureX, textureY); // Box 28
		base[28] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 29
		base[29] = new ModelRendererTurbo(this, 105, 25, textureX, textureY); // Box 30
		base[30] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 31
		base[31] = new ModelRendererTurbo(this, 105, 33, textureX, textureY); // Box 32
		base[32] = new ModelRendererTurbo(this, 121, 33, textureX, textureY); // Box 33
		base[33] = new ModelRendererTurbo(this, 121, 49, textureX, textureY); // Box 34
		base[34] = new ModelRendererTurbo(this, 105, 41, textureX, textureY); // Box 35
		base[35] = new ModelRendererTurbo(this, 105, 65, textureX, textureY); // Box 36
		base[36] = new ModelRendererTurbo(this, 9, 33, textureX, textureY); // Box 37
		base[37] = new ModelRendererTurbo(this, 25, 73, textureX, textureY); // Box 38
		base[38] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 40
		base[39] = new ModelRendererTurbo(this, 41, 49, textureX, textureY); // Box 41
		base[40] = new ModelRendererTurbo(this, 57, 73, textureX, textureY); // Box 42
		base[41] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 43
		base[42] = new ModelRendererTurbo(this, 89, 73, textureX, textureY); // Box 44
		base[43] = new ModelRendererTurbo(this, 33, 57, textureX, textureY); // Box 45
		base[44] = new ModelRendererTurbo(this, 41, 81, textureX, textureY); // Box 46
		base[45] = new ModelRendererTurbo(this, 73, 81, textureX, textureY); // Box 47
		base[46] = new ModelRendererTurbo(this, 105, 81, textureX, textureY); // Box 48
		base[47] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 49
		base[48] = new ModelRendererTurbo(this, 41, 89, textureX, textureY); // Box 51
		base[49] = new ModelRendererTurbo(this, 57, 89, textureX, textureY); // Box 52
		base[50] = new ModelRendererTurbo(this, 73, 89, textureX, textureY); // Box 53
		base[51] = new ModelRendererTurbo(this, 89, 89, textureX, textureY); // Box 54
		base[52] = new ModelRendererTurbo(this, 105, 41, textureX, textureY); // Box 55
		base[53] = new ModelRendererTurbo(this, 113, 57, textureX, textureY); // Box 56

		base[0].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 0
		base[0].setRotationPoint(6F, 23F, 6F);

		base[1].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 1
		base[1].setRotationPoint(6F, 23F, -7F);

		base[2].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 2
		base[2].setRotationPoint(-7F, 23F, -7F);

		base[3].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 3
		base[3].setRotationPoint(-7F, 23F, 6F);

		base[4].addShapeBox(0F, 0F, 0F, 15, 1, 15, 0F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F); // Box 4
		base[4].setRotationPoint(-7.5F, 22F, -7.5F);

		base[5].addBox(0F, 0F, 0F, 15, 21, 1, 0F); // Box 5
		base[5].setRotationPoint(-7.5F, 1F, -7.5F);

		base[6].addShapeBox(0F, 0F, 0F, 15, 1, 15, 0F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F); // Box 6
		base[6].setRotationPoint(-7.5F, 0F, -7.5F);

		base[7].addBox(0F, 0F, 0F, 15, 21, 1, 0F); // Box 7
		base[7].setRotationPoint(-7.5F, 1F, 6.5F);

		base[8].addBox(0F, 0F, 0F, 1, 15, 13, 0F); // Box 8
		base[8].setRotationPoint(-7.5F, 7F, -6.5F);

		base[9].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 9
		base[9].setRotationPoint(-7.5F, 1F, -6.5F);

		base[10].addBox(0F, 0F, 0F, 1, 5, 5, 0F); // Box 10
		base[10].setRotationPoint(-7.5F, 2F, -6.5F);

		base[11].addBox(0F, 0F, 0F, 1, 5, 5, 0F); // Box 11
		base[11].setRotationPoint(-7.5F, 2F, 1.5F);

		base[12].addBox(0F, 0F, 0F, 2, 4, 11, 0F); // Box 13
		base[12].setRotationPoint(5.5F, 14F, -5.5F);

		base[13].addBox(0F, 0F, 0F, 2, 21, 1, 0F); // Box 14
		base[13].setRotationPoint(5.5F, 1F, -6.5F);

		base[14].addBox(0F, 0F, 0F, 2, 21, 1, 0F); // Box 15
		base[14].setRotationPoint(5.5F, 1F, 5.5F);

		base[15].addBox(0F, 0F, 0F, 2, 2, 11, 0F); // Box 16
		base[15].setRotationPoint(5.5F, 1F, -5.5F);

		base[16].addShapeBox(0F, 0F, 0F, 2, 11, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 17
		base[16].setRotationPoint(5.5F, 3F, -5.5F);

		base[17].addShapeBox(0F, 0F, 0F, 2, 11, 2, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 18
		base[17].setRotationPoint(5.5F, 3F, 3.5F);

		base[18].addBox(0F, 0F, 0F, 1, 4, 11, 0F); // Box 19
		base[18].setRotationPoint(6.8F, 18F, -5.5F);

		base[19].addBox(0F, 0F, 0F, 1, 1, 4, 0F); // Box 20
		base[19].setRotationPoint(7.2F, 19F, -2F);

		base[20].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 21
		base[20].setRotationPoint(-6.5F, 17F, -6.5F);

		base[21].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 22
		base[21].setRotationPoint(-6.5F, 17F, 5.5F);

		base[22].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 23
		base[22].setRotationPoint(-6.5F, 17F, -5F);

		base[23].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 24
		base[23].setRotationPoint(-6.5F, 17F, -3F);

		base[24].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 25
		base[24].setRotationPoint(-6.5F, 17F, -1.5F);

		base[25].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 26
		base[25].setRotationPoint(-6.5F, 17F, 2F);

		base[26].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 27
		base[26].setRotationPoint(-6.5F, 17F, 4F);

		base[27].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 28
		base[27].setRotationPoint(-6.5F, 17F, 0.5F);

		base[28].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, 0F, -0.8F, 0.2F, 0F, -0.8F, 0.2F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.8F, 0.2F, 0F, -0.8F, 0.2F, 0F, 0.2F, 0F, 0F, 0.2F, 0F); // Box 29
		base[28].setRotationPoint(-8F, 2F, -2.5F);

		base[29].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.8F, 0.2F, 0F, -0.8F, 0.2F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.8F, 0.2F, 0F, -0.8F, 0.2F); // Box 30
		base[29].setRotationPoint(-8F, 2F, 1.5F);

		base[30].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0.5F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0.5F, 0.2F, 0F); // Box 31
		base[30].setRotationPoint(-7.5F, 6F, -1.5F);

		base[31].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0.5F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0.5F, 0.2F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 32
		base[31].setRotationPoint(-7.5F, 2F, -1.5F);

		base[32].addBox(0F, 0F, 0F, 1, 11, 1, 0F); // Box 33
		base[32].setRotationPoint(7F, 3F, 3.5F);

		base[33].addBox(0F, 0F, 0F, 1, 11, 1, 0F); // Box 34
		base[33].setRotationPoint(7F, 3F, -4.5F);

		base[34].addBox(0F, 0F, 0F, 1, 1, 7, 0F); // Box 35
		base[34].setRotationPoint(7F, 3F, -3.5F);

		base[35].addBox(0F, 0F, 0F, 1, 1, 7, 0F); // Box 36
		base[35].setRotationPoint(7F, 13F, -3.5F);

		base[36].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 37
		base[36].setRotationPoint(7.5F, 7F, 3.5F);

		base[37].addBox(0F, 0F, 0F, 0, 9, 7, 0F); // Box 38
		base[37].setRotationPoint(7.5F, 4F, -3.5F);

		base[38].addBox(0F, 0F, 0F, 8, 1, 3, 0F); // Box 40
		base[38].setRotationPoint(-15.5F, 6F, -1.5F);

		base[39].addBox(0F, 0F, 0F, 6, 1, 3, 0F); // Box 41
		base[39].setRotationPoint(-13.5F, 2F, -1.5F);

		base[40].addBox(0F, 0F, 0F, 1, 10, 3, 0F); // Box 42
		base[40].setRotationPoint(-14.5F, -8F, -1.5F);

		base[41].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 43
		base[41].setRotationPoint(-14.5F, 2F, -1.5F);

		base[42].addBox(0F, 0F, 0F, 1, 12, 3, 0F); // Box 44
		base[42].setRotationPoint(-18.5F, -8F, -1.5F);

		base[43].addShapeBox(0F, 0F, 0F, 3, 3, 3, 0F, -1F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -1F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 45
		base[43].setRotationPoint(-18.5F, 4F, -1.5F);

		base[44].addShapeBox(0F, 0F, 0F, 6, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 46
		base[44].setRotationPoint(-13.5F, 2F, 1.5F);

		base[45].addShapeBox(0F, 0F, 0F, 6, 5, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 47
		base[45].setRotationPoint(-13.5F, 2F, -2.5F);

		base[46].addShapeBox(0F, 0F, 0F, 5, 10, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 48
		base[46].setRotationPoint(-18.5F, -8F, -2.5F);

		base[47].addShapeBox(0F, 0F, 0F, 5, 10, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 49
		base[47].setRotationPoint(-18.5F, -8F, 1.5F);

		base[48].addShapeBox(0F, 0F, 0F, 5, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -3F, -1F, 0F); // Box 51
		base[48].setRotationPoint(-18.5F, 4F, 1.5F);

		base[49].addShapeBox(0F, 0F, 0F, 4, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 52
		base[49].setRotationPoint(-18.5F, 2F, 1.5F);

		base[50].addShapeBox(0F, 0F, 0F, 5, 3, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, -3F, 0F, 0F); // Box 53
		base[50].setRotationPoint(-18.5F, 4F, -2.5F);

		base[51].addShapeBox(0F, 0F, 0F, 4, 2, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 54
		base[51].setRotationPoint(-18.5F, 2F, -2.5F);

		base[52].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 55
		base[52].setRotationPoint(-14.5F, 2F, 1.5F);

		base[53].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 56
		base[53].setRotationPoint(-14.5F, 2F, -2.5F);
		
		translateAll(0F, 0F, 0F);
		
	}
}