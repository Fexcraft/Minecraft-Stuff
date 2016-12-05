package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelStreetLamp1 extends ModelBase {
	
	int textureX = 32;
	int textureY = 32;

	public ModelStreetLamp1(){
		base = new ModelRendererTurbo[3];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		base[1] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 1
		base[2] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 2

		base[0].addBox(0F, 0F, 0F, 4, 7, 4, 0F); // Box 0
		base[0].setRotationPoint(-2F, 3F, -2F);

		base[1].addBox(0F, 0F, 0F, 2, 8, 2, 0F); // Box 1
		base[1].setRotationPoint(-1F, -6F, -1F);

		base[2].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.7F, 0F, -0.7F, -0.7F, 0F, -0.7F, -0.7F, 0F, -0.7F, -0.7F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 2
		base[2].setRotationPoint(-2F, 2F, -2F);
		
		translateAll(0F, 14F, 0F);
		
	}
}