package net.fexcraft.mod.extensions.ie.models;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelCabelType4 extends ModelBase {
	
	int textureX = 64;
	int textureY = 32;

	public ModelCabelType4(){
		
		base = new ModelRendererTurbo[2];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		base[1] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 1

		base[0].addBox(0F, 0F, 0F, 5, 1, 5, 0F); // Box 0
		base[0].setRotationPoint(-2.5F, -1F, -2.5F);

		base[1].addShapeBox(0F, 0F, 0F, 5, 1, 5, 0F, -1F, -0.5F, -1F, -1F, -0.5F, -1F, -1F, -0.5F, -1F, -1F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 1
		base[1].setRotationPoint(-2.5F, -2F, -2.5F);


		r1 = new ModelRendererTurbo[6];
		r1[0] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 2
		r1[1] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 3
		r1[2] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 6
		r1[3] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 7
		r1[4] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 10
		r1[5] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 11

		r1[0].addShapeBox(0F, 0F, -7F, 1, 1, 5, 0F, -0.1F, -0.2F, 0F, -0.1F, -0.2F, 0F, -0.1F, -0.2F, 0F, -0.1F, -0.2F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 2
		r1[0].setRotationPoint(0F, -1F, 0F);

		r1[1].addShapeBox(-1F, 0F, -7F, 1, 1, 5, 0F, -0.1F, -0.2F, 0F, -0.1F, -0.2F, 0F, -0.1F, -0.2F, 0F, -0.1F, -0.2F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 3
		r1[1].setRotationPoint(0F, -1F, 0F);

		r1[2].addShapeBox(0F, 0F, -8F, 1, 1, 1, 0F, -0.05F, -0.1F, -0.5F, -0.05F, -0.1F, -0.5F, -0.1F, -0.2F, 0F, -0.1F, -0.2F, 0F, -0.05F, 0F, -0.5F, -0.05F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 6
		r1[2].setRotationPoint(0F, -1F, 0F);

		r1[3].addShapeBox(-1F, 0F, -8F, 1, 1, 1, 0F, -0.05F, -0.1F, -0.5F, -0.05F, -0.1F, -0.5F, -0.1F, -0.2F, 0F, -0.1F, -0.2F, 0F, -0.05F, 0F, -0.5F, -0.05F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 7
		r1[3].setRotationPoint(0F, -1F, 0F);

		r1[4].addShapeBox(0F, 0F, -8F, 1, 1, 1, 0F, -0.05F, -0.1F, 0F, -0.05F, -0.1F, 0F, -0.05F, -0.1F, -0.5F, -0.05F, -0.1F, -0.5F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, -0.5F, -0.05F, 0F, -0.5F); // Box 10
		r1[4].setRotationPoint(0F, -1F, 0F);

		r1[5].addShapeBox(-1F, 0F, -8F, 1, 1, 1, 0F, -0.05F, -0.1F, 0F, -0.05F, -0.1F, 0F, -0.05F, -0.1F, -0.5F, -0.05F, -0.1F, -0.5F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, -0.5F, -0.05F, 0F, -0.5F); // Box 11
		r1[5].setRotationPoint(0F, -1F, 0F);


		r2 = new ModelRendererTurbo[6];
		r2[0] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 4
		r2[1] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 5
		r2[2] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 8
		r2[3] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 9
		r2[4] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 12
		r2[5] = new ModelRendererTurbo(this, 9, 9, textureX, textureY); // Box 13

		r2[0].addShapeBox(1F, 0F, -7F, 1, 1, 5, 0F, -0.1F, -0.2F, 0F, -0.1F, -0.2F, 0F, -0.1F, -0.2F, 0F, -0.1F, -0.2F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 4
		r2[0].setRotationPoint(0F, -1F, 0F);

		r2[1].addShapeBox(-2F, 0F, -7F, 1, 1, 5, 0F, -0.1F, -0.2F, 0F, -0.1F, -0.2F, 0F, -0.1F, -0.2F, 0F, -0.1F, -0.2F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 5
		r2[1].setRotationPoint(0F, -1F, 0F);

		r2[2].addShapeBox(1F, 0F, -8F, 1, 1, 1, 0F, -0.05F, -0.1F, -0.5F, -0.05F, -0.1F, -0.5F, -0.1F, -0.2F, 0F, -0.1F, -0.2F, 0F, -0.05F, 0F, -0.5F, -0.05F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 8
		r2[2].setRotationPoint(0F, -1F, 0F);

		r2[3].addShapeBox(-2F, 0F, -8F, 1, 1, 1, 0F, -0.05F, -0.1F, -0.5F, -0.05F, -0.1F, -0.5F, -0.1F, -0.2F, 0F, -0.1F, -0.2F, 0F, -0.05F, 0F, -0.5F, -0.05F, 0F, -0.5F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 9
		r2[3].setRotationPoint(0F, -1F, 0F);

		r2[4].addShapeBox(1F, 0F, -8F, 1, 1, 1, 0F, -0.05F, -0.1F, 0F, -0.05F, -0.1F, 0F, -0.05F, -0.1F, -0.5F, -0.05F, -0.1F, -0.5F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, -0.5F, -0.05F, 0F, -0.5F); // Box 12
		r2[4].setRotationPoint(0F, -1F, 0F);

		r2[5].addShapeBox(-2F, 0F, -8F, 1, 1, 1, 0F, -0.05F, -0.1F, 0F, -0.05F, -0.1F, 0F, -0.05F, -0.1F, -0.5F, -0.05F, -0.1F, -0.5F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, -0.5F, -0.05F, 0F, -0.5F); // Box 13
		r2[5].setRotationPoint(0F, -1F, 0F);


		r0 = new ModelRendererTurbo[1];
		r0[0] = new ModelRendererTurbo(this, 25, 9, textureX, textureY); // Box 14

		r0[0].addShapeBox(-1F, -1F, -1F, 2, 1, 2, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 14
		r0[0].setRotationPoint(0F, -1F, 0F);
		
		r3 = new ModelRendererTurbo[1];
		r3[0] = new ModelRendererTurbo(this, 15, 9, textureX, textureY); // Box 15

		r3[0].addShapeBox(-0.5F, 0.5F, -2.5F, 1, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 15
		r3[0].setRotationPoint(0F, -2F, 0F);


		translateAll(0F, 8F, 0F);


		//flipAll();
	}
}