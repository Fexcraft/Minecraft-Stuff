package net.fexcraft.mod.frsm.blocks.pipes;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelStovePipe extends ModelBase {
	
	int textureX = 16;
	int textureY = 16;

	public ModelStovePipe(){
		
		base = new ModelRendererTurbo[1];
		base[0] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 17

		base[0].addShapeBox(-2.5F, -2.5F, -2.5F, 5, 5, 5, 0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F); // Box 17
		base[0].setRotationPoint(0F, -8F, 0F);

		r0 = new ModelRendererTurbo[8];
		r0[0] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 0
		r0[1] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 55
		r0[2] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 56
		r0[3] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 57
		r0[4] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 58
		r0[5] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 59
		r0[6] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 60
		r0[7] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 61

		r0[0].addShapeBox(-2.5F, 2F, -2.5F, 1, 6, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 0
		r0[0].setRotationPoint(0F, -8F, 0F);

		r0[1].addBox(-1.5F, 2F, -2.5F, 3, 6, 1, 0F); // Box 55
		r0[1].setRotationPoint(0F, -8F, 0F);

		r0[2].addBox(-1.5F, 2F, 1.5F, 3, 6, 1, 0F); // Box 56
		r0[2].setRotationPoint(0F, -8F, 0F);

		r0[3].addBox(-2.5F, 2F, -1.5F, 1, 6, 3, 0F); // Box 57
		r0[3].setRotationPoint(0F, -8F, 0F);

		r0[4].addBox(1.5F, 2F, -1.5F, 1, 6, 3, 0F); // Box 58
		r0[4].setRotationPoint(0F, -8F, 0F);

		r0[5].addShapeBox(1.5F, 2F, -2.5F, 1, 6, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 59
		r0[5].setRotationPoint(0F, -8F, 0F);

		r0[6].addShapeBox(1.5F, 2F, 1.5F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 60
		r0[6].setRotationPoint(0F, -8F, 0F);

		r0[7].addShapeBox(-2.5F, 2F, 1.5F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 61
		r0[7].setRotationPoint(0F, -8F, 0F);
		
		translateAll(0F, 24F, 0F);
		
	}
}