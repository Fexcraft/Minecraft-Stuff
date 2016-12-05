package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelStreetLamp1d extends ModelBase {
	
	int textureX = 64;
	int textureY = 32;

	public ModelStreetLamp1d(){
		
		base = new ModelRendererTurbo[3];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 1
		base[1] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 0
		base[2] = new ModelRendererTurbo(this, 9, 9, textureX, textureY); // Box 1

		base[0].addBox(0F, 0F, 0F, 2, 6, 2, 0F); // Box 1
		base[0].setRotationPoint(-1F, 4F, -1F);

		base[1].addBox(0F, 0F, 0F, 16, 2, 2, 0F); // Box 0
		base[1].setRotationPoint(-8F, 1F, -1F);

		base[2].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 1
		base[2].setRotationPoint(-1F, 3F, -1F);
		
		translateAll(0F, 14F, 0F);
		
	}
}