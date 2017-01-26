package net.fexcraft.mod.frsm.blocks.pchardware;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelPCHardware1 extends ModelBase {
	int textureX = 64;
	int textureY = 64;

	public ModelPCHardware1(){
		base = new ModelRendererTurbo[32];
		base[0] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 1
		base[1] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 2
		base[2] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 5
		base[3] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 6
		base[4] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 7
		base[5] = new ModelRendererTurbo(this, 41, 17, textureX, textureY); // Box 9
		base[6] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 10
		base[7] = new ModelRendererTurbo(this, 57, 17, textureX, textureY); // Box 11
		base[8] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 12
		base[9] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 13
		base[10] = new ModelRendererTurbo(this, 17, 25, textureX, textureY); // Box 14
		base[11] = new ModelRendererTurbo(this, 25, 25, textureX, textureY); // Box 15
		base[12] = new ModelRendererTurbo(this, 33, 25, textureX, textureY); // Box 16
		base[13] = new ModelRendererTurbo(this, 41, 25, textureX, textureY); // Box 17
		base[14] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 18
		base[15] = new ModelRendererTurbo(this, 57, 25, textureX, textureY); // Box 19
		base[16] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 20
		base[17] = new ModelRendererTurbo(this, 9, 33, textureX, textureY); // Box 21
		base[18] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 22
		base[19] = new ModelRendererTurbo(this, 25, 33, textureX, textureY); // Box 23
		base[20] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Box 24
		base[21] = new ModelRendererTurbo(this, 41, 33, textureX, textureY); // Box 25
		base[22] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Box 26
		base[23] = new ModelRendererTurbo(this, 57, 33, textureX, textureY); // Box 27
		base[24] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 28
		base[25] = new ModelRendererTurbo(this, 9, 41, textureX, textureY); // Box 29
		base[26] = new ModelRendererTurbo(this, 17, 41, textureX, textureY); // Box 30
		base[27] = new ModelRendererTurbo(this, 25, 41, textureX, textureY); // Box 31
		base[28] = new ModelRendererTurbo(this, 33, 41, textureX, textureY); // Box 32
		base[29] = new ModelRendererTurbo(this, 41, 41, textureX, textureY); // Box 33
		base[30] = new ModelRendererTurbo(this, 49, 41, textureX, textureY); // Box 34
		base[31] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 35

		base[0].addBox(-2F, 6F, -4F, 4, 6, 1, 0F); // Box 1
		base[0].setRotationPoint(0F, -12F, 0F);

		base[1].addShapeBox(-2F, 5F, -4F, 4, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 2
		base[1].setRotationPoint(0F, -12F, 0F);

		base[2].addShapeBox(-2.1F, 0F, -5F, 4, 1, 1, 0F, -0.25F, 0F, -0.8F, -0.25F, 0F, -0.8F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.8F, -0.25F, 0F, -0.8F, -0.25F, 0F, 0F, -0.25F, 0F, 0F); // Box 5
		base[2].setRotationPoint(0F, -2F, 0F);

		base[3].addShapeBox(-2.1F, -1.5F, -5F, 4, 1, 1, 0F, -0.25F, 0F, -0.8F, -0.25F, 0F, -0.8F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.8F, -0.25F, 0F, -0.8F, -0.25F, 0F, 0F, -0.25F, 0F, 0F); // Box 6
		base[3].setRotationPoint(0F, -2F, 0F);

		base[4].addShapeBox(-2F, -3.5F, -4.9F, 1, 1, 1, 0F, -0.25F, 0F, -0.8F, -0.25F, 0F, -0.8F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.8F, -0.25F, 0F, -0.8F, -0.25F, 0F, 0F, -0.25F, 0F, 0F); // Box 7
		base[4].setRotationPoint(0F, -2F, 0F);

		base[5].addShapeBox(1F, -3.5F, -4.9F, 1, 1, 1, 0F, -0.25F, 0F, -0.8F, -0.25F, 0F, -0.8F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.8F, -0.25F, 0F, -0.8F, -0.25F, 0F, 0F, -0.25F, 0F, 0F); // Box 9
		base[5].setRotationPoint(0F, -2F, 0F);

		base[6].addShapeBox(-1F, -3.5F, -4.9F, 1, 1, 1, 0F, -0.25F, 0F, -0.8F, -0.25F, 0F, -0.8F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.8F, -0.25F, 0F, -0.8F, -0.25F, 0F, 0F, -0.25F, 0F, 0F); // Box 10
		base[6].setRotationPoint(0F, -2F, 0F);

		base[7].addShapeBox(1.2F, -1.5F, -4.1F, 1, 1, 1, 0F, -0.5F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.5F, -0.25F, 0F); // Box 11
		base[7].setRotationPoint(0F, -2F, 0F);

		base[8].addShapeBox(1.2F, 0F, -4.1F, 1, 1, 1, 0F, -0.5F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.5F, -0.25F, 0F); // Box 12
		base[8].setRotationPoint(0F, -2F, 0F);

		base[9].addShapeBox(0F, -3.5F, -4.9F, 1, 1, 1, 0F, -0.25F, 0F, -0.8F, -0.25F, 0F, -0.8F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.8F, -0.25F, 0F, -0.8F, -0.25F, 0F, 0F, -0.25F, 0F, 0F); // Box 13
		base[9].setRotationPoint(0F, -2F, 0F);

		base[10].addShapeBox(0F, -3.5F, -3.6F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 14
		base[10].setRotationPoint(0F, -8F, 0F);

		base[11].addBox(-0.5F, -1F, 5.2F, 2, 2, 1, 0F); // Box 15
		base[11].setRotationPoint(0F, -2F, 0F);

		base[12].addShapeBox(-1.75F, 0F, 5.2F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 16
		base[12].setRotationPoint(0F, -11.5F, 0F);

		base[13].addShapeBox(-1.75F, 0F, 5.2F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 17
		base[13].setRotationPoint(0F, -10F, 0F);

		base[14].addShapeBox(-1.75F, 0F, 5.2F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 18
		base[14].setRotationPoint(0F, -7F, 0F);

		base[15].addShapeBox(-1.75F, 0F, 5.2F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 19
		base[15].setRotationPoint(0F, -8.5F, 0F);

		base[16].addShapeBox(1F, 0F, 5.2F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F); // Box 20
		base[16].setRotationPoint(0F, -11.5F, 0F);

		base[17].addShapeBox(1F, 2F, 5.2F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F); // Box 21
		base[17].setRotationPoint(0F, -11.5F, 0F);

		base[18].addShapeBox(0.5F, 2F, 5.2F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F); // Box 22
		base[18].setRotationPoint(0F, -11.5F, 0F);

		base[19].addShapeBox(0.5F, 0F, 5.2F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F); // Box 23
		base[19].setRotationPoint(0F, -11.5F, 0F);

		base[20].addShapeBox(0.5F, 1F, 5.2F, 1, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.4F, -0.25F, 0F, -0.4F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.4F, -0.25F, 0F, -0.4F, -0.25F, 0F); // Box 24
		base[20].setRotationPoint(0F, -11.5F, 0F);

		base[21].addShapeBox(1F, 1F, 5.2F, 1, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.4F, -0.25F, 0F, -0.4F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.4F, -0.25F, 0F, -0.4F, -0.25F, 0F); // Box 25
		base[21].setRotationPoint(0F, -11.5F, 0F);

		base[22].addShapeBox(0F, 0F, 5.2F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 26
		base[22].setRotationPoint(0F, -7F, 0F);

		base[23].addShapeBox(0F, 1F, 5.2F, 2, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F); // Box 27
		base[23].setRotationPoint(0F, -7F, 0F);

		base[24].addShapeBox(0F, 1.75F, 5.2F, 2, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.2F, -0.25F, 0F, -0.2F, -0.25F, 0F); // Box 28
		base[24].setRotationPoint(0F, -7F, 0F);

		base[25].addShapeBox(-2F, 6F, 5.2F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F); // Box 29
		base[25].setRotationPoint(0F, -11.5F, 0F);

		base[26].addShapeBox(-1.5F, 6F, 5.2F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F); // Box 30
		base[26].setRotationPoint(0F, -11.5F, 0F);

		base[27].addShapeBox(-0.75F, 0F, 5.2F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 31
		base[27].setRotationPoint(0F, -8.5F, 0F);

		base[28].addShapeBox(-0.75F, 0F, 5.2F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 32
		base[28].setRotationPoint(0F, -11.5F, 0F);

		base[29].addShapeBox(-0.75F, 0F, 5.2F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 33
		base[29].setRotationPoint(0F, -10F, 0F);

		base[30].addBox(-2F, 0F, 5F, 4, 12, 1, 0F); // Box 34
		base[30].setRotationPoint(0F, -12F, 0F);

		base[31].addShapeBox(-1F, -3.5F, -3.6F, 1, 1, 1, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 35
		base[31].setRotationPoint(0F, -8F, 0F);


		r0 = new ModelRendererTurbo[3];
		r0[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		r0[1] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 3
		r0[2] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 4

		r0[0].addBox(-2F, 0F, -3F, 4, 12, 8, 0F); // Box 0
		r0[0].setRotationPoint(0F, -12F, 0F);

		r0[1].addShapeBox(-2F, 0F, -4F, 2, 5, 1, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 3
		r0[1].setRotationPoint(0F, -12F, 0F);

		r0[2].addShapeBox(0F, 0F, -4F, 2, 5, 1, 0F, 0F, 0F, -0.5F, -0.25F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4
		r0[2].setRotationPoint(0F, -12F, 0F);
		
		translateAll(0F, 24F, 0F);
		
	}
}