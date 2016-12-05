package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelStreetLamp1f extends ModelBase {
	
	int textureX = 32;
	int textureY = 32;

	public ModelStreetLamp1f(){
		
		base = new ModelRendererTurbo[1];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Import ImportImportBox1

		base[0].addBox(0F, 0F, 0F, 2, 16, 2, 0F); // Import ImportImportBox1
		base[0].setRotationPoint(-8F, 0F, -1F);
		base[0].rotateAngleZ = -1.57079633F;
		
		translateAll(0F, 14F, 0F);
		
	}
}