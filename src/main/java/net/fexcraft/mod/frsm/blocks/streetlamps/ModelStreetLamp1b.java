package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelStreetLamp1b extends ModelBase {
	
	int textureX = 32;
	int textureY = 32;

	public ModelStreetLamp1b(){
		base = new ModelRendererTurbo[1];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 1

		base[0].addBox(0F, 0F, 0F, 2, 16, 2, 0F); // Box 1
		base[0].setRotationPoint(-1F, -6F, -1F);
		
		translateAll(0F, 14F, 0F);
		
	}
}