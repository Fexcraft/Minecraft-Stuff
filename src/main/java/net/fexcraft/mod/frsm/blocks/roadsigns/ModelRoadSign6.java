//This File was created with the Minecraft-SMP Modelling Toolbox 2.2.1.1
// Copyright (C) 2016 Minecraft-SMP.de

package net.fexcraft.mod.frsm.blocks.roadsigns;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelRoadSign6 extends ModelBase {
	
	int textureX = 128;
	int textureY = 64;

	public ModelRoadSign6(){
		
		base = new ModelRendererTurbo[30];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		base[1] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 1
		base[2] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 2
		base[3] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 3
		base[4] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 4
		base[5] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 5
		base[6] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 6
		base[7] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 7
		base[8] = new ModelRendererTurbo(this, 105, 1, textureX, textureY); // Box 8
		base[9] = new ModelRendererTurbo(this, 105, 9, textureX, textureY); // Box 9
		base[10] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Box 10
		base[11] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 11
		base[12] = new ModelRendererTurbo(this, 113, 17, textureX, textureY); // Box 12
		base[13] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 13
		base[14] = new ModelRendererTurbo(this, 113, 9, textureX, textureY); // Box 14
		base[15] = new ModelRendererTurbo(this, 105, 17, textureX, textureY); // Box 15
		base[16] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 16
		base[17] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 17
		base[18] = new ModelRendererTurbo(this, 73, 25, textureX, textureY); // Box 18
		base[19] = new ModelRendererTurbo(this, 89, 25, textureX, textureY); // Box 19
		base[20] = new ModelRendererTurbo(this, 105, 25, textureX, textureY); // Box 20
		base[21] = new ModelRendererTurbo(this, 65, 33, textureX, textureY); // Box 21
		base[22] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 24
		base[23] = new ModelRendererTurbo(this, 81, 33, textureX, textureY); // Box 25
		base[24] = new ModelRendererTurbo(this, 89, 33, textureX, textureY); // Box 26
		base[25] = new ModelRendererTurbo(this, 97, 33, textureX, textureY); // Box 27
		base[26] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 28
		base[27] = new ModelRendererTurbo(this, 105, 33, textureX, textureY); // Box 29
		base[28] = new ModelRendererTurbo(this, 113, 33, textureX, textureY); // Box 30
		base[29] = new ModelRendererTurbo(this, 121, 33, textureX, textureY); // Box 31

		base[0].addBox(0F, 0F, 0F, 1, 36, 3, 0F); // Box 0
		base[0].setRotationPoint(-0.5F, -26F, -1.5F);

		base[1].addBox(0F, 0F, 0F, 1, 36, 1, 0F); // Box 1
		base[1].setRotationPoint(-1.5F, -26F, -0.5F);

		base[2].addBox(0F, 0F, 0F, 1, 36, 1, 0F); // Box 2
		base[2].setRotationPoint(0.5F, -26F, -0.5F);

		base[3].addShapeBox(0F, 0F, 0F, 1, 36, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 3
		base[3].setRotationPoint(-1.5F, -26F, -1.5F);

		base[4].addShapeBox(0F, 0F, 0F, 1, 36, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4
		base[4].setRotationPoint(0.5F, -26F, -1.5F);

		base[5].addShapeBox(0F, 0F, 0F, 1, 36, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 5
		base[5].setRotationPoint(0.5F, -26F, 0.5F);

		base[6].addShapeBox(0F, 0F, 0F, 1, 36, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 6
		base[6].setRotationPoint(-1.5F, -26F, 0.5F);

		base[7].addShapeBox(0F, 0F, 0F, 16, 16, 0, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F); // Box 7
		base[7].setRotationPoint(-8F, -34F, -1.6F);

		base[8].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F); // Box 8
		base[8].setRotationPoint(1.25F, -25F, -1.5F);

		base[9].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
		base[9].setRotationPoint(-1.25F, -25F, -1.5F);

		base[10].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 10
		base[10].setRotationPoint(-0.5F, -25F, 1.5F);

		base[11].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F); // Box 11
		base[11].setRotationPoint(1.25F, -20F, -1.5F);

		base[12].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 12
		base[12].setRotationPoint(-1.25F, -20F, -1.5F);

		base[13].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 13
		base[13].setRotationPoint(-0.5F, -20F, 1.5F);

		base[14].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 14
		base[14].setRotationPoint(-2F, -34F, -2F);

		base[15].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 15
		base[15].setRotationPoint(-2F, -19F, -2F);

		base[16].addBox(0F, 0F, 0F, 1, 4, 1, 0F); // Box 16
		base[16].setRotationPoint(-8F, -28F, -2F);

		base[17].addBox(0F, 0F, 0F, 1, 4, 1, 0F); // Box 17
		base[17].setRotationPoint(7F, -28F, -2F);

		base[18].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 18
		base[18].setRotationPoint(-5F, -34F, -2F);

		base[19].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 19
		base[19].setRotationPoint(2F, -34F, -2F);

		base[20].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 20
		base[20].setRotationPoint(2F, -19F, -2F);

		base[21].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 21
		base[21].setRotationPoint(-5F, -19F, -2F);

		base[22].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 24
		base[22].setRotationPoint(-8F, -24F, -2F);

		base[23].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 25
		base[23].setRotationPoint(-8F, -31F, -2F);

		base[24].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 26
		base[24].setRotationPoint(7F, -31F, -2F);

		base[25].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 27
		base[25].setRotationPoint(7F, -24F, -2F);

		base[26].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 28
		base[26].setRotationPoint(-6F, -21F, -2F);

		base[27].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		base[27].setRotationPoint(-6F, -32F, -2F);

		base[28].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 30
		base[28].setRotationPoint(5F, -32F, -2F);

		base[29].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 31
		base[29].setRotationPoint(5F, -21F, -2F);
		
		translateAll(0F, 14F, 0F);
		
	}
}