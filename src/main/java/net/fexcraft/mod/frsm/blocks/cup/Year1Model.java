package net.fexcraft.mod.frsm.blocks.cup; //Path where the model is located

import net.fexcraft.mod.lib.tmt.ModelConverter;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class Year1Model extends ModelConverter{
	
	int textureX = 64;
	int textureY = 32;

	public Year1Model(){
		bodyModel = new ModelRendererTurbo[6];
		bodyModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 1
		bodyModel[2] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 2
		bodyModel[3] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 3
		bodyModel[4] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 4
		bodyModel[5] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 5

		bodyModel[0].addBox(0F, 0F, 0F, 8, 1, 8, 0F); // Box 0
		bodyModel[0].setRotationPoint(-4F, 9F, -4F);

		bodyModel[1].addShapeBox(0F, 0F, 0F, 8, 1, 8, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 1
		bodyModel[1].setRotationPoint(-4F, 8F, -4F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 2, 1, 5, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 2
		bodyModel[2].setRotationPoint(-1F, 7F, -2.5F);

		bodyModel[3].addShapeBox(0F, 0F, 0F, 2, 1, 5, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 3
		bodyModel[3].setRotationPoint(-1F, 0.5F, -2.5F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F); // Box 4
		bodyModel[4].setRotationPoint(-1F, 1.5F, -1F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 5
		bodyModel[5].setRotationPoint(3F, 8F, -2F);

		translateAll(0F, -14F, 0F);
		
	}
}