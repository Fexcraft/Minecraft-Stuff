package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelStreetLamp1e extends ModelBase {
	
	int textureX = 64;
	int textureY = 32;

	public ModelStreetLamp1e(){
		
		base = new ModelRendererTurbo[7];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 1
		base[1] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 0
		base[2] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 3
		base[3] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 4
		base[4] = new ModelRendererTurbo(this, 41, 9, textureX, textureY); // Box 5
		base[5] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 6
		base[6] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 7

		base[0].addShapeBox(0F, 0F, 0F, 8, 2, 5, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 1
		base[0].setRotationPoint(-4F, 0.5F, -2.5F);

		base[1].addShapeBox(0F, 0F, 0F, 8, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 0
		base[1].setRotationPoint(-8F, 1F, -1F);

		base[2].addShapeBox(0F, 0F, 0F, 6, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F); // Box 3
		base[2].setRotationPoint(-3F, 2.5F, -1.5F);

		base[3].addShapeBox(0F, 0F, 0F, 8, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 4
		base[3].setRotationPoint(-4F, 2.5F, -2.5F);

		base[4].addShapeBox(0F, 0F, 0F, 8, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 5
		base[4].setRotationPoint(-4F, 2.5F, 2F);

		base[5].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 6
		base[5].setRotationPoint(-4F, 2.5F, -2F);

		base[6].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 7
		base[6].setRotationPoint(3.5F, 2.5F, -2F);
		
		translateAll(0F, 14F, 0F);
		
	}
}