package net.fexcraft.mod.frsm.blocks.pipes;

import net.fexcraft.mod.lib.tmt.ModelConverter;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelStovePipe1g extends ModelConverter{
	
	int textureX = 64;
	int textureY = 64;

	public ModelStovePipe1g(){
		
		bodyModel = new ModelRendererTurbo[24];
		bodyModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Import ImportBox0
		bodyModel[1] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Import ImportBox55
		bodyModel[2] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Import ImportBox56
		bodyModel[3] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Import ImportBox57
		bodyModel[4] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Import ImportBox58
		bodyModel[5] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Import ImportBox59
		bodyModel[6] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Import ImportBox60
		bodyModel[7] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Import ImportBox61
		bodyModel[8] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Import ImportBox0
		bodyModel[9] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Import ImportBox55
		bodyModel[10] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Import ImportBox56
		bodyModel[11] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Import ImportBox57
		bodyModel[12] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Import ImportBox58
		bodyModel[13] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Import ImportBox59
		bodyModel[14] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Import ImportBox60
		bodyModel[15] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Import ImportBox61
		bodyModel[16] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Import ImportBox0
		bodyModel[17] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Import ImportBox1
		bodyModel[18] = new ModelRendererTurbo(this, 43, 5, textureX, textureY); // Import ImportBox2
		bodyModel[19] = new ModelRendererTurbo(this, 43, 5, textureX, textureY); // Import ImportBox3
		bodyModel[20] = new ModelRendererTurbo(this, 19, 21, textureX, textureY); // Import ImportBox4
		bodyModel[21] = new ModelRendererTurbo(this, 19, 21, textureX, textureY); // Import ImportBox5
		bodyModel[22] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Import ImportBox6
		bodyModel[23] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Import ImportBox7

		bodyModel[0].addShapeBox(0F, 0F, 0F, 1, 8, 1, 0F, -1F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import ImportBox0
		bodyModel[0].setRotationPoint(-2.5F, 18.5F, 1F);
		bodyModel[0].rotateAngleX = 1.57079633F;

		bodyModel[1].addShapeBox(0F, 0F, 0F, 3, 8, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import ImportBox55
		bodyModel[1].setRotationPoint(-1.5F, 18.5F, 1F);
		bodyModel[1].rotateAngleX = 1.57079633F;

		bodyModel[2].addShapeBox(0F, 0F, 0F, 3, 8, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import ImportBox56
		bodyModel[2].setRotationPoint(-1.5F, 14.5F, 1F);
		bodyModel[2].rotateAngleX = 1.57079633F;

		bodyModel[3].addShapeBox(0F, 0F, 0F, 1, 8, 3, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import ImportBox57
		bodyModel[3].setRotationPoint(-2.5F, 17.5F, 1F);
		bodyModel[3].rotateAngleX = 1.57079633F;

		bodyModel[4].addShapeBox(0F, 0F, 0F, 1, 6, 3, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import ImportBox58
		bodyModel[4].setRotationPoint(1.5F, 17.5F, 3F);
		bodyModel[4].rotateAngleX = 1.57079633F;

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import ImportBox59
		bodyModel[5].setRotationPoint(1.5F, 18.5F, 3F);
		bodyModel[5].rotateAngleX = 1.57079633F;

		bodyModel[6].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Import ImportBox60
		bodyModel[6].setRotationPoint(1.5F, 14.5F, 3F);
		bodyModel[6].rotateAngleX = 1.57079633F;

		bodyModel[7].addShapeBox(0F, 0F, 0F, 1, 8, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Import ImportBox61
		bodyModel[7].setRotationPoint(-2.5F, 14.5F, 1F);
		bodyModel[7].rotateAngleX = 1.57079633F;

		bodyModel[8].addShapeBox(0F, 0F, 0F, 1, 8, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Import ImportBox0
		bodyModel[8].setRotationPoint(8F, 13.5F, -1.5F);
		bodyModel[8].rotateAngleZ = -1.57079633F;

		bodyModel[9].addShapeBox(0F, 0F, 0F, 3, 7, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Import ImportBox55
		bodyModel[9].setRotationPoint(8F, 14.5F, -0.5F);
		bodyModel[9].rotateAngleX = -1.57079633F;
		bodyModel[9].rotateAngleY = -1.57079633F;
		bodyModel[9].rotateAngleZ = -3.14159265F;

		bodyModel[10].addShapeBox(0F, 0F, 0F, 3, 7, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Import ImportBox56
		bodyModel[10].setRotationPoint(8F, 18.5F, -0.5F);
		bodyModel[10].rotateAngleX = -1.57079633F;
		bodyModel[10].rotateAngleY = -1.57079633F;
		bodyModel[10].rotateAngleZ = -3.14159265F;

		bodyModel[11].addShapeBox(0F, 0F, 0F, 1, 8, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Import ImportBox57
		bodyModel[11].setRotationPoint(8F, 17.5F, -1.5F);
		bodyModel[11].rotateAngleX = -1.57079633F;
		bodyModel[11].rotateAngleY = -1.57079633F;
		bodyModel[11].rotateAngleZ = -3.14159265F;

		bodyModel[12].addShapeBox(0F, 0F, 0F, 1, 6, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Import ImportBox58
		bodyModel[12].setRotationPoint(8F, 17.5F, 2.5F);
		bodyModel[12].rotateAngleX = -1.57079633F;
		bodyModel[12].rotateAngleY = -1.57079633F;
		bodyModel[12].rotateAngleZ = -3.14159265F;

		bodyModel[13].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Import ImportBox59
		bodyModel[13].setRotationPoint(8F, 14.5F, 3.5F);
		bodyModel[13].rotateAngleX = -1.57079633F;
		bodyModel[13].rotateAngleY = -1.57079633F;
		bodyModel[13].rotateAngleZ = -4.71238898F;

		bodyModel[14].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, -0.5F, 0F); // Import ImportBox60
		bodyModel[14].setRotationPoint(8F, 17.5F, 2.5F);
		bodyModel[14].rotateAngleX = -1.57079633F;
		bodyModel[14].rotateAngleY = -1.57079633F;
		bodyModel[14].rotateAngleZ = -1.57079633F;

		bodyModel[15].addShapeBox(0F, 0F, 0F, 1, 8, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -1F, -0.5F, 0F); // Import ImportBox61
		bodyModel[15].setRotationPoint(8F, 18.5F, -0.5F);
		bodyModel[15].rotateAngleX = -1.57079633F;
		bodyModel[15].rotateAngleY = -1.57079633F;
		bodyModel[15].rotateAngleZ = 1.57079633F;

		bodyModel[16].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import ImportBox0
		bodyModel[16].setRotationPoint(1.5F, 17.5F, 2.5F);
		bodyModel[16].rotateAngleX = 1.57079633F;

		bodyModel[17].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Import ImportBox1
		bodyModel[17].setRotationPoint(-0.5F, 17.5F, -1.5F);
		bodyModel[17].rotateAngleX = 1.57079633F;

		bodyModel[18].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, -1F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Import ImportBox2
		bodyModel[18].setRotationPoint(-0.5F, 18.5F, -1.5F);
		bodyModel[18].rotateAngleX = 1.57079633F;

		bodyModel[19].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F); // Import ImportBox3
		bodyModel[19].setRotationPoint(-0.5F, 14.5F, -1.5F);
		bodyModel[19].rotateAngleX = 1.57079633F;

		bodyModel[20].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Import ImportBox4
		bodyModel[20].setRotationPoint(1.5F, 18.5F, 2.5F);
		bodyModel[20].rotateAngleX = 1.57079633F;

		bodyModel[21].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F); // Import ImportBox5
		bodyModel[21].setRotationPoint(1.5F, 14.5F, 2.5F);
		bodyModel[21].rotateAngleX = 1.57079633F;

		bodyModel[22].addShapeBox(0F, 0F, 0F, 3, 2, 1, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import ImportBox6
		bodyModel[22].setRotationPoint(-1.5F, 14.5F, -0.5F);
		bodyModel[22].rotateAngleX = 1.57079633F;

		bodyModel[23].addShapeBox(0F, 0F, 0F, 3, 2, 1, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import ImportBox7
		bodyModel[23].setRotationPoint(-1.5F, 18.5F, -0.5F);
		bodyModel[23].rotateAngleX = 1.57079633F;
		
		translateAll(0F, 14F, 0F);
		
	}
}