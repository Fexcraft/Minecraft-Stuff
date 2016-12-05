package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelStreetLamp1c extends ModelBase {
	
	int textureX = 32;
	int textureY = 32;

	public ModelStreetLamp1c(){
		
		base = new ModelRendererTurbo[3];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 1
		base[1] = new ModelRendererTurbo(this, 9, 9, textureX, textureY); // Box 0
		base[2] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 1

		base[0].addBox(0F, 0F, 0F, 2, 6, 2, 0F); // Box 1
		base[0].setRotationPoint(-1F, 4F, -1F);

		base[1].addBox(0F, 0F, 0F, 6, 2, 2, 0F); // Box 0
		base[1].setRotationPoint(2F, 1F, -1F);

		base[2].addShapeBox(0F, 0F, 0F, 2, 3, 2, 0F, -3F, 0F, 0F, 1F, -2F, 0F, 1F, -2F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 1
		base[2].setRotationPoint(-1F, 1F, -1F);
		
		translateAll(0F, 14F, 0F);
		
	}
}