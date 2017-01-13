package net.fexcraft.mod.extensions.bge.models;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelDice extends ModelBase {
	int textureX = 32;
	int textureY = 32;

	public ModelDice(){
		base = new ModelRendererTurbo[1];
		base[0] = new ModelRendererTurbo(this, 0, 0, textureX, textureY);

		base[0].addBox(-4F, 12F, -4F, 8, 8, 8, 0F);
		base[0].setRotationPoint(0F, 0F, 0F);


		r0 = new ModelRendererTurbo[1];
		r0[0] = new ModelRendererTurbo(this, 0, 0, textureX, textureY);

		r0[0].addBox(-4F, 16F, -4F, 8, 8, 8, 0F);
		r0[0].setRotationPoint(0F, 0F, 0F);
		
		translateAll(0F, 0F, 0F);
		
	}
}