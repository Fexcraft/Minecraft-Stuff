package net.fexcraft.mod.fvm.model;

import net.fexcraft.mod.fvm.FVM;
import net.fexcraft.mod.lib.tmt.ModelConverter;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.util.ResourceLocation;

public class ModelConstructorController extends ModelConverter {
	
	private static final int textureX = 128;
	private static final int textureY = 64;

	public ModelConstructorController() {
		bodyModel = new ModelRendererTurbo[30];
		bodyModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 1
		bodyModel[2] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 2
		bodyModel[3] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Box 3
		bodyModel[4] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 4
		bodyModel[5] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 5
		bodyModel[6] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 6
		bodyModel[7] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 7
		bodyModel[8] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 8
		bodyModel[9] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Box 9
		bodyModel[10] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 10
		bodyModel[11] = new ModelRendererTurbo(this, 9, 9, textureX, textureY); // Box 11
		bodyModel[12] = new ModelRendererTurbo(this, 113, 9, textureX, textureY); // Box 12
		bodyModel[13] = new ModelRendererTurbo(this, 121, 9, textureX, textureY); // Box 13
		bodyModel[14] = new ModelRendererTurbo(this, 105, 17, textureX, textureY); // Box 14
		bodyModel[15] = new ModelRendererTurbo(this, 113, 17, textureX, textureY); // Box 15
		bodyModel[16] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 16
		bodyModel[17] = new ModelRendererTurbo(this, 105, 25, textureX, textureY); // Box 17
		bodyModel[18] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 18
		bodyModel[19] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 19
		bodyModel[20] = new ModelRendererTurbo(this, 33, 41, textureX, textureY); // Box 20
		bodyModel[21] = new ModelRendererTurbo(this, 65, 41, textureX, textureY); // Box 21
		bodyModel[22] = new ModelRendererTurbo(this, 89, 41, textureX, textureY); // Box 22
		bodyModel[23] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 23
		bodyModel[24] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 24
		bodyModel[25] = new ModelRendererTurbo(this, 25, 33, textureX, textureY); // Box 25
		bodyModel[26] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 26
		bodyModel[27] = new ModelRendererTurbo(this, 25, 49, textureX, textureY); // Box 27
		bodyModel[28] = new ModelRendererTurbo(this, 41, 33, textureX, textureY); // Box 28
		bodyModel[29] = new ModelRendererTurbo(this, 57, 49, textureX, textureY); // Box 29

		bodyModel[0].addBox(0F, 0F, 0F, 15, 15, 14, 0F); // Box 0
		bodyModel[0].setRotationPoint(-7.5F, -16F, -7.5F);

		bodyModel[1].addBox(0F, 0F, 0F, 16, 1, 16, 0F); // Box 1
		bodyModel[1].setRotationPoint(-8F, -17F, -8F);

		bodyModel[2].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 2
		bodyModel[2].setRotationPoint(6F, -1F, 5F);

		bodyModel[3].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 3
		bodyModel[3].setRotationPoint(-7F, -1F, 5F);

		bodyModel[4].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 4
		bodyModel[4].setRotationPoint(-7F, -1F, -7F);

		bodyModel[5].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 5
		bodyModel[5].setRotationPoint(6F, -1F, -7F);

		bodyModel[6].addBox(0F, 0F, 0F, 14, 3, 1, 0F); // Box 6
		bodyModel[6].setRotationPoint(-7F, -15.5F, 6F);

		bodyModel[7].addBox(0F, 0F, 0F, 14, 3, 1, 0F); // Box 7
		bodyModel[7].setRotationPoint(-7F, -12F, 6F);

		bodyModel[8].addBox(0F, 0F, 0F, 14, 3, 1, 0F); // Box 8
		bodyModel[8].setRotationPoint(-7F, -8.5F, 6F);

		bodyModel[9].addBox(0F, 0F, 0F, 14, 3, 1, 0F); // Box 9
		bodyModel[9].setRotationPoint(-7F, -5F, 6F);

		bodyModel[10].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F); // Box 10
		bodyModel[10].setRotationPoint(-5F, -4F, 7F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F); // Box 11
		bodyModel[11].setRotationPoint(4F, -4F, 7F);

		bodyModel[12].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F); // Box 12
		bodyModel[12].setRotationPoint(-5F, -7.5F, 7F);

		bodyModel[13].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F); // Box 13
		bodyModel[13].setRotationPoint(4F, -7.5F, 7F);

		bodyModel[14].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F); // Box 14
		bodyModel[14].setRotationPoint(-5F, -11F, 7F);

		bodyModel[15].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F); // Box 15
		bodyModel[15].setRotationPoint(4F, -11F, 7F);

		bodyModel[16].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F); // Box 16
		bodyModel[16].setRotationPoint(-5F, -14.5F, 7F);

		bodyModel[17].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F); // Box 17
		bodyModel[17].setRotationPoint(4F, -14.5F, 7F);

		bodyModel[18].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, -0.2F, -0.1F, -0.5F, -0.2F, -0.1F, -0.5F, -0.2F, -0.1F, 0F, -0.2F, -0.1F, 0F, -0.2F, -0.1F, -0.5F, -0.2F, -0.1F, -0.5F, -0.2F, -0.1F, 0F, -0.2F, -0.1F, 0F); // Box 18
		bodyModel[18].setRotationPoint(-6F, -4F, 7F);

		bodyModel[19].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, -0.2F, -0.1F, -0.5F, -0.2F, -0.1F, -0.5F, -0.2F, -0.1F, 0F, -0.2F, -0.1F, 0F, -0.2F, -0.1F, -0.5F, -0.2F, -0.1F, -0.5F, -0.2F, -0.1F, 0F, -0.2F, -0.1F, 0F); // Box 19
		bodyModel[19].setRotationPoint(-6F, -7.5F, 7F);

		bodyModel[20].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, -0.2F, -0.1F, -0.5F, -0.2F, -0.1F, -0.5F, -0.2F, -0.1F, 0F, -0.2F, -0.1F, 0F, -0.2F, -0.1F, -0.5F, -0.2F, -0.1F, -0.5F, -0.2F, -0.1F, 0F, -0.2F, -0.1F, 0F); // Box 20
		bodyModel[20].setRotationPoint(-6F, -11F, 7F);

		bodyModel[21].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, -0.2F, -0.1F, -0.5F, -0.2F, -0.1F, -0.5F, -0.2F, -0.1F, 0F, -0.2F, -0.1F, 0F, -0.2F, -0.1F, -0.5F, -0.2F, -0.1F, -0.5F, -0.2F, -0.1F, 0F, -0.2F, -0.1F, 0F); // Box 21
		bodyModel[21].setRotationPoint(-6F, -14.5F, 7F);

		bodyModel[22].addShapeBox(0F, 0F, 0F, 10, 1, 4, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 22
		bodyModel[22].setRotationPoint(-3F, -18F, 0F);

		bodyModel[23].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 23
		bodyModel[23].setRotationPoint(-2.5F, -18F, 0.5F);

		bodyModel[24].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 24
		bodyModel[24].setRotationPoint(5.5F, -18F, 0.5F);

		bodyModel[25].addBox(0F, 0F, 0F, 2, 1, 3, 0F); // Box 25
		bodyModel[25].setRotationPoint(-6.5F, -18F, 0F);

		bodyModel[26].addShapeBox(0F, 0F, 0F, 6, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 1F, 1F, -0.5F, 1F, 1F, -0.5F, 1F, 1F, -0.5F, 1F); // Box 26
		bodyModel[26].setRotationPoint(-3F, -17.5F, -6.5F);

		bodyModel[27].addBox(0F, 0F, 0F, 14, 9, 1, 0F); // Box 27
		bodyModel[27].setRotationPoint(-7F, -28F, -5F);
		bodyModel[27].rotateAngleX = 0.17453293F;

		bodyModel[28].addShapeBox(-1F, 0F, 0F, 2, 6, 1, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0.75F, 0F, 0F, 0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 28
		bodyModel[28].setRotationPoint(0F, -23F, -6F);

		bodyModel[29].addShapeBox(0F, 3F, -1F, 14, 5, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F); // Box 29
		bodyModel[29].setRotationPoint(-7F, -28F, -5F);
		bodyModel[29].rotateAngleX = 0.17453293F;

		translateAll(0F, 24F, 0F);
	}
	
	private static final ResourceLocation texture = new ResourceLocation(FVM.MODID, "textures/blocks/constructioncontroller.png");
	
	public static final ResourceLocation getTexture(){
		return texture;
	}
	
}