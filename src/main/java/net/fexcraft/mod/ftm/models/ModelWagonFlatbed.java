package net.fexcraft.mod.ftm.models;

import net.fexcraft.mod.lib.tmt.ModelConverter;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelWagonFlatbed extends ModelConverter {
	
	private static final int textureX = 256;
	private static final int textureY = 256;

	public ModelWagonFlatbed(){
		bodyModel = new ModelRendererTurbo[41];
		bodyModel[0] = new ModelRendererTurbo(this, 193, 25, textureX, textureY); // Box 77
		bodyModel[1] = new ModelRendererTurbo(this, 209, 25, textureX, textureY); // Box 78
		bodyModel[2] = new ModelRendererTurbo(this, 65, 33, textureX, textureY); // Box 79
		bodyModel[3] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 80
		bodyModel[4] = new ModelRendererTurbo(this, 57, 57, textureX, textureY); // Box 81
		bodyModel[5] = new ModelRendererTurbo(this, 113, 57, textureX, textureY); // Box 82
		bodyModel[6] = new ModelRendererTurbo(this, 161, 57, textureX, textureY); // Box 83
		bodyModel[7] = new ModelRendererTurbo(this, 209, 57, textureX, textureY); // Box 84
		bodyModel[8] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 85
		bodyModel[9] = new ModelRendererTurbo(this, 217, 33, textureX, textureY); // Box 86
		bodyModel[10] = new ModelRendererTurbo(this, 217, 41, textureX, textureY); // Box 87
		bodyModel[11] = new ModelRendererTurbo(this, 225, 25, textureX, textureY); // Box 88
		bodyModel[12] = new ModelRendererTurbo(this, 241, 25, textureX, textureY); // Box 89
		bodyModel[13] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 90
		bodyModel[14] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Box 91
		bodyModel[15] = new ModelRendererTurbo(this, 73, 33, textureX, textureY); // Box 92
		bodyModel[16] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 93
		bodyModel[17] = new ModelRendererTurbo(this, 57, 41, textureX, textureY); // Box 94
		bodyModel[18] = new ModelRendererTurbo(this, 65, 41, textureX, textureY); // Box 95
		bodyModel[19] = new ModelRendererTurbo(this, 33, 65, textureX, textureY); // Box 96
		bodyModel[20] = new ModelRendererTurbo(this, 105, 65, textureX, textureY); // Box 98
		bodyModel[21] = new ModelRendererTurbo(this, 145, 65, textureX, textureY); // Box 99
		bodyModel[22] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 100
		bodyModel[23] = new ModelRendererTurbo(this, 1, 97, textureX, textureY); // Box 101
		bodyModel[24] = new ModelRendererTurbo(this, 185, 65, textureX, textureY); // Box 102
		bodyModel[25] = new ModelRendererTurbo(this, 73, 41, textureX, textureY); // Box 103
		bodyModel[26] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 104
		bodyModel[27] = new ModelRendererTurbo(this, 57, 49, textureX, textureY); // Box 105
		bodyModel[28] = new ModelRendererTurbo(this, 241, 49, textureX, textureY); // Box 106
		bodyModel[29] = new ModelRendererTurbo(this, 57, 65, textureX, textureY); // Box 107
		bodyModel[30] = new ModelRendererTurbo(this, 113, 65, textureX, textureY); // Box 108
		bodyModel[31] = new ModelRendererTurbo(this, 129, 65, textureX, textureY); // Box 109
		bodyModel[32] = new ModelRendererTurbo(this, 145, 65, textureX, textureY); // Box 110
		bodyModel[33] = new ModelRendererTurbo(this, 169, 65, textureX, textureY); // Box 111
		bodyModel[34] = new ModelRendererTurbo(this, 185, 65, textureX, textureY); // Box 112
		bodyModel[35] = new ModelRendererTurbo(this, 209, 65, textureX, textureY); // Box 113
		bodyModel[36] = new ModelRendererTurbo(this, 225, 65, textureX, textureY); // Box 114
		bodyModel[37] = new ModelRendererTurbo(this, 241, 65, textureX, textureY); // Box 115
		bodyModel[38] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 116
		bodyModel[39] = new ModelRendererTurbo(this, 17, 73, textureX, textureY); // Box 117
		bodyModel[40] = new ModelRendererTurbo(this, 33, 73, textureX, textureY); // Box 118

		bodyModel[0].addBox(0F, 0F, 0F, 3, 1, 3, 0F); // Box 77
		bodyModel[0].setRotationPoint(-22.5F, -5F, -1.5F);

		bodyModel[1].addBox(0F, 0F, 0F, 3, 1, 3, 0F); // Box 78
		bodyModel[1].setRotationPoint(19.5F, -5F, -1.5F);

		bodyModel[2].addBox(0F, 0F, 0F, 66, 1, 18, 0F); // Box 79
		bodyModel[2].setRotationPoint(-33F, -8F, -9F);

		bodyModel[3].addShapeBox(0F, 0F, 0F, 18, 2, 14, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, -1.5F); // Box 80
		bodyModel[3].setRotationPoint(-30F, -7F, -7F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 18, 2, 14, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, -1.5F); // Box 81
		bodyModel[4].setRotationPoint(12F, -7F, -7F);

		bodyModel[5].addBox(0F, 0F, 0F, 19, 1, 2, 0F); // Box 82
		bodyModel[5].setRotationPoint(-30F, -7F, -8F);

		bodyModel[6].addBox(0F, 0F, 0F, 19, 1, 2, 0F); // Box 83
		bodyModel[6].setRotationPoint(-30F, -7F, 6F);

		bodyModel[7].addBox(0F, 0F, 0F, 19, 1, 2, 0F); // Box 84
		bodyModel[7].setRotationPoint(11F, -7F, -8F);

		bodyModel[8].addBox(0F, 0F, 0F, 19, 1, 2, 0F); // Box 85
		bodyModel[8].setRotationPoint(11F, -7F, 6F);

		bodyModel[9].addBox(0F, 0F, 0F, 16, 1, 2, 0F); // Box 86
		bodyModel[9].setRotationPoint(-8F, -4F, -8F);

		bodyModel[10].addBox(0F, 0F, 0F, 16, 1, 2, 0F); // Box 87
		bodyModel[10].setRotationPoint(-8F, -4F, 6F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 3, 1, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F); // Box 88
		bodyModel[11].setRotationPoint(-11F, -7F, -8F);

		bodyModel[12].addShapeBox(0F, 0F, 0F, 3, 1, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F); // Box 89
		bodyModel[12].setRotationPoint(-11F, -7F, 6F);

		bodyModel[13].addShapeBox(0F, 0F, 0F, 3, 1, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F); // Box 90
		bodyModel[13].setRotationPoint(8F, -7F, -8F);

		bodyModel[14].addShapeBox(0F, 0F, 0F, 3, 1, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F); // Box 91
		bodyModel[14].setRotationPoint(8F, -7F, 6F);

		bodyModel[15].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, -1F, 0F, -0.25F, 1F, 0F, -0.25F, 1F, 0F, -0.25F, -1F, 0F, -0.25F); // Box 92
		bodyModel[15].setRotationPoint(-9F, -7F, -8F);

		bodyModel[16].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 1F, 0F, -0.25F, -1F, 0F, -0.25F, -1F, 0F, -0.25F, 1F, 0F, -0.25F); // Box 93
		bodyModel[16].setRotationPoint(8F, -7F, -8F);

		bodyModel[17].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, -1F, 0F, -0.25F, 1F, 0F, -0.25F, 1F, 0F, -0.25F, -1F, 0F, -0.25F); // Box 94
		bodyModel[17].setRotationPoint(-9F, -7F, 6F);

		bodyModel[18].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 1F, 0F, -0.25F, -1F, 0F, -0.25F, -1F, 0F, -0.25F, 1F, 0F, -0.25F); // Box 95
		bodyModel[18].setRotationPoint(8F, -7F, 6F);

		bodyModel[19].addShapeBox(0F, 0F, 0F, 3, 2, 17, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 96
		bodyModel[19].setRotationPoint(-33F, -7F, -8.5F);

		bodyModel[20].addBox(0F, 0F, 0F, 1, 1, 18, 0F); // Box 98
		bodyModel[20].setRotationPoint(-33F, -9F, -9F);

		bodyModel[21].addBox(0F, 0F, 0F, 1, 1, 18, 0F); // Box 99
		bodyModel[21].setRotationPoint(32F, -9F, -9F);

		bodyModel[22].addBox(0F, 0F, 0F, 64, 1, 1, 0F); // Box 100
		bodyModel[22].setRotationPoint(-32F, -9F, -9F);

		bodyModel[23].addBox(0F, 0F, 0F, 64, 1, 1, 0F); // Box 101
		bodyModel[23].setRotationPoint(-32F, -9F, 8F);

		bodyModel[24].addShapeBox(0F, 0F, 0F, 3, 2, 17, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 102
		bodyModel[24].setRotationPoint(30F, -7F, -8.5F);

		bodyModel[25].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 103
		bodyModel[25].setRotationPoint(-34F, -7.5F, -6.5F);

		bodyModel[26].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 104
		bodyModel[26].setRotationPoint(-34F, -7.5F, 5.5F);

		bodyModel[27].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 105
		bodyModel[27].setRotationPoint(33F, -7.5F, -6.5F);

		bodyModel[28].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 106
		bodyModel[28].setRotationPoint(33F, -7.5F, 5.5F);

		bodyModel[29].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 107
		bodyModel[29].setRotationPoint(-35F, -7F, -7F);

		bodyModel[30].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, -0.75F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, -0.75F, 0F, -1F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 108
		bodyModel[30].setRotationPoint(-35F, -8F, -7F);

		bodyModel[31].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, -0.75F, 0F, -1F); // Box 109
		bodyModel[31].setRotationPoint(-35F, -6F, -7F);

		bodyModel[32].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, -0.75F, 0F, -1F); // Box 110
		bodyModel[32].setRotationPoint(-35F, -6F, 5F);

		bodyModel[33].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 111
		bodyModel[33].setRotationPoint(-35F, -7F, 5F);

		bodyModel[34].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, -0.75F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, -0.75F, 0F, -1F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 112
		bodyModel[34].setRotationPoint(-35F, -8F, 5F);

		bodyModel[35].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 113
		bodyModel[35].setRotationPoint(34F, -7F, -7F);

		bodyModel[36].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, -1F, -0.75F, 0F, -1F, -0.75F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 114
		bodyModel[36].setRotationPoint(34F, -8F, -7F);

		bodyModel[37].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.75F, 0F, -1F, -0.75F, 0F, -1F, 0F, 0F, -1F); // Box 115
		bodyModel[37].setRotationPoint(34F, -6F, -7F);

		bodyModel[38].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 116
		bodyModel[38].setRotationPoint(34F, -7F, 5F);

		bodyModel[39].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.75F, 0F, -1F, -0.75F, 0F, -1F, 0F, 0F, -1F); // Box 117
		bodyModel[39].setRotationPoint(34F, -6F, 5F);

		bodyModel[40].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, -1F, -0.75F, 0F, -1F, -0.75F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 118
		bodyModel[40].setRotationPoint(34F, -8F, 5F);


		leftTrackWheelModels = new ModelRendererTurbo[28];
		leftTrackWheelModels[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		leftTrackWheelModels[1] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Box 1
		leftTrackWheelModels[2] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 2
		leftTrackWheelModels[3] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 3
		leftTrackWheelModels[4] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 4
		leftTrackWheelModels[5] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 5
		leftTrackWheelModels[6] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 6
		leftTrackWheelModels[7] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 7
		leftTrackWheelModels[8] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 8
		leftTrackWheelModels[9] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 9
		leftTrackWheelModels[10] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 10
		leftTrackWheelModels[11] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 11
		leftTrackWheelModels[12] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 12
		leftTrackWheelModels[13] = new ModelRendererTurbo(this, 105, 1, textureX, textureY); // Box 13
		leftTrackWheelModels[14] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 14
		leftTrackWheelModels[15] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 15
		leftTrackWheelModels[16] = new ModelRendererTurbo(this, 129, 1, textureX, textureY); // Box 16
		leftTrackWheelModels[17] = new ModelRendererTurbo(this, 137, 1, textureX, textureY); // Box 17
		leftTrackWheelModels[18] = new ModelRendererTurbo(this, 145, 1, textureX, textureY); // Box 18
		leftTrackWheelModels[19] = new ModelRendererTurbo(this, 153, 1, textureX, textureY); // Box 19
		leftTrackWheelModels[20] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 20
		leftTrackWheelModels[21] = new ModelRendererTurbo(this, 169, 1, textureX, textureY); // Box 21
		leftTrackWheelModels[22] = new ModelRendererTurbo(this, 177, 1, textureX, textureY); // Box 22
		leftTrackWheelModels[23] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 23
		leftTrackWheelModels[24] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 24
		leftTrackWheelModels[25] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 25
		leftTrackWheelModels[26] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 26
		leftTrackWheelModels[27] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 27

		leftTrackWheelModels[0].addBox(-1F, -2F, 0F, 2, 4, 1, 0F); // Box 0
		leftTrackWheelModels[0].setRotationPoint(16F, -2F, -7F);

		leftTrackWheelModels[1].addShapeBox(-2F, -2F, 0F, 1, 4, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 1
		leftTrackWheelModels[1].setRotationPoint(16F, -2F, -7F);

		leftTrackWheelModels[2].addShapeBox(1F, -2F, 0F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 2
		leftTrackWheelModels[2].setRotationPoint(16F, -2F, -7F);

		leftTrackWheelModels[3].addBox(-1F, -2F, 0F, 2, 4, 1, 0F); // Box 3
		leftTrackWheelModels[3].setRotationPoint(16F, -2F, 6F);

		leftTrackWheelModels[4].addShapeBox(-2F, -2F, 0F, 1, 4, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 4
		leftTrackWheelModels[4].setRotationPoint(16F, -2F, 6F);

		leftTrackWheelModels[5].addShapeBox(1F, -2F, 0F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 5
		leftTrackWheelModels[5].setRotationPoint(16F, -2F, 6F);

		leftTrackWheelModels[6].addBox(-1F, -2F, 0F, 2, 4, 1, 0F); // Box 6
		leftTrackWheelModels[6].setRotationPoint(26F, -2F, 6F);

		leftTrackWheelModels[7].addShapeBox(-2F, -2F, 0F, 1, 4, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 7
		leftTrackWheelModels[7].setRotationPoint(26F, -2F, 6F);

		leftTrackWheelModels[8].addShapeBox(1F, -2F, 0F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 8
		leftTrackWheelModels[8].setRotationPoint(26F, -2F, 6F);

		leftTrackWheelModels[9].addBox(-1F, -2F, 0F, 2, 4, 1, 0F); // Box 9
		leftTrackWheelModels[9].setRotationPoint(26F, -2F, -7F);

		leftTrackWheelModels[10].addShapeBox(-2F, -2F, 0F, 1, 4, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 10
		leftTrackWheelModels[10].setRotationPoint(26F, -2F, -7F);

		leftTrackWheelModels[11].addShapeBox(1F, -2F, 0F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 11
		leftTrackWheelModels[11].setRotationPoint(26F, -2F, -7F);

		leftTrackWheelModels[12].addBox(-1F, -2F, 0F, 2, 4, 1, 0F); // Box 12
		leftTrackWheelModels[12].setRotationPoint(-16F, -2F, -7F);

		leftTrackWheelModels[13].addShapeBox(-2F, -2F, 0F, 1, 4, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 13
		leftTrackWheelModels[13].setRotationPoint(-16F, -2F, -7F);

		leftTrackWheelModels[14].addShapeBox(1F, -2F, 0F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 14
		leftTrackWheelModels[14].setRotationPoint(-16F, -2F, -7F);

		leftTrackWheelModels[15].addBox(-1F, -2F, 0F, 2, 4, 1, 0F); // Box 15
		leftTrackWheelModels[15].setRotationPoint(-26F, -2F, -7F);

		leftTrackWheelModels[16].addShapeBox(-2F, -2F, 0F, 1, 4, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 16
		leftTrackWheelModels[16].setRotationPoint(-26F, -2F, -7F);

		leftTrackWheelModels[17].addShapeBox(1F, -2F, 0F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 17
		leftTrackWheelModels[17].setRotationPoint(-26F, -2F, -7F);

		leftTrackWheelModels[18].addBox(-1F, -2F, 0F, 2, 4, 1, 0F); // Box 18
		leftTrackWheelModels[18].setRotationPoint(-16F, -2F, 6F);

		leftTrackWheelModels[19].addShapeBox(-2F, -2F, 0F, 1, 4, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 19
		leftTrackWheelModels[19].setRotationPoint(-16F, -2F, 6F);

		leftTrackWheelModels[20].addShapeBox(1F, -2F, 0F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 20
		leftTrackWheelModels[20].setRotationPoint(-16F, -2F, 6F);

		leftTrackWheelModels[21].addBox(-1F, -2F, 0F, 2, 4, 1, 0F); // Box 21
		leftTrackWheelModels[21].setRotationPoint(-26F, -2F, 6F);

		leftTrackWheelModels[22].addShapeBox(-2F, -2F, 0F, 1, 4, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 22
		leftTrackWheelModels[22].setRotationPoint(-26F, -2F, 6F);

		leftTrackWheelModels[23].addShapeBox(1F, -2F, 0F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 23
		leftTrackWheelModels[23].setRotationPoint(-26F, -2F, 6F);

		leftTrackWheelModels[24].addShapeBox(-0.5F, -0.5F, 0F, 1, 1, 12, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F); // Box 24
		leftTrackWheelModels[24].setRotationPoint(-16F, -2F, -6F);

		leftTrackWheelModels[25].addShapeBox(-0.5F, -0.5F, 0F, 1, 1, 12, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F); // Box 25
		leftTrackWheelModels[25].setRotationPoint(-26F, -2F, -6F);

		leftTrackWheelModels[26].addShapeBox(-0.5F, -0.5F, 0F, 1, 1, 12, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F); // Box 26
		leftTrackWheelModels[26].setRotationPoint(16F, -2F, -6F);

		leftTrackWheelModels[27].addShapeBox(-0.5F, -0.5F, 0F, 1, 1, 12, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F); // Box 27
		leftTrackWheelModels[27].setRotationPoint(26F, -2F, -6F);


		leftTrackModel = new ModelRendererTurbo[24];
		leftTrackModel[0] = new ModelRendererTurbo(this, 201, 1, textureX, textureY); // Box 28
		leftTrackModel[1] = new ModelRendererTurbo(this, 233, 1, textureX, textureY); // Box 29
		leftTrackModel[2] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 30
		leftTrackModel[3] = new ModelRendererTurbo(this, 249, 1, textureX, textureY); // Box 32
		leftTrackModel[4] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 33
		leftTrackModel[5] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 34
		leftTrackModel[6] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 35
		leftTrackModel[7] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // Box 36
		leftTrackModel[8] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 37
		leftTrackModel[9] = new ModelRendererTurbo(this, 105, 9, textureX, textureY); // Box 38
		leftTrackModel[10] = new ModelRendererTurbo(this, 113, 9, textureX, textureY); // Box 39
		leftTrackModel[11] = new ModelRendererTurbo(this, 121, 9, textureX, textureY); // Box 40
		leftTrackModel[12] = new ModelRendererTurbo(this, 129, 9, textureX, textureY); // Box 41
		leftTrackModel[13] = new ModelRendererTurbo(this, 129, 9, textureX, textureY); // Box 42
		leftTrackModel[14] = new ModelRendererTurbo(this, 161, 9, textureX, textureY); // Box 43
		leftTrackModel[15] = new ModelRendererTurbo(this, 169, 9, textureX, textureY); // Box 44
		leftTrackModel[16] = new ModelRendererTurbo(this, 177, 9, textureX, textureY); // Box 45
		leftTrackModel[17] = new ModelRendererTurbo(this, 249, 9, textureX, textureY); // Box 46
		leftTrackModel[18] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 47
		leftTrackModel[19] = new ModelRendererTurbo(this, 105, 17, textureX, textureY); // Box 48
		leftTrackModel[20] = new ModelRendererTurbo(this, 161, 17, textureX, textureY); // Box 49
		leftTrackModel[21] = new ModelRendererTurbo(this, 177, 17, textureX, textureY); // Box 50
		leftTrackModel[22] = new ModelRendererTurbo(this, 185, 9, textureX, textureY); // Box 51
		leftTrackModel[23] = new ModelRendererTurbo(this, 201, 9, textureX, textureY); // Box 52

		leftTrackModel[0].addShapeBox(0F, 0F, 0F, 5, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, -0.25F, -0.4F, 0F, -0.25F, -0.4F, 0F, -0.25F, -0.4F, 0F, -0.25F); // Box 28
		leftTrackModel[0].setRotationPoint(-23.5F, -2F, -7.5F);

		leftTrackModel[1].addShapeBox(0F, 0F, 0F, 5, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, -0.25F, -0.4F, 0F, -0.25F, -0.4F, 0F, -0.25F, -0.4F, 0F, -0.25F); // Box 29
		leftTrackModel[1].setRotationPoint(-23.5F, -2F, 5.5F);

		leftTrackModel[2].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, -0.25F, -0.2F, -0.2F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.2F, -0.25F, -0.2F, -0.2F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 30
		leftTrackModel[2].setRotationPoint(-26.5F, -2.5F, -8F);

		leftTrackModel[3].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, -0.25F, -0.2F, -0.2F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.2F, -0.25F, -0.2F, -0.2F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 32
		leftTrackModel[3].setRotationPoint(-16.5F, -2.5F, -8F);

		leftTrackModel[4].addShapeBox(0F, 0F, 0F, 10, 1, 1, 0F, 0F, -0.7F, -0.5F, 0F, -0.7F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 33
		leftTrackModel[4].setRotationPoint(-26F, -3F, -8F);

		leftTrackModel[5].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.2F, -0.25F, -0.2F, -0.2F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.2F, -0.25F, -0.2F, -0.2F, -0.25F); // Box 34
		leftTrackModel[5].setRotationPoint(-16.5F, -2.5F, 7F);

		leftTrackModel[6].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.2F, -0.25F, -0.2F, -0.2F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.2F, -0.25F, -0.2F, -0.2F, -0.25F); // Box 35
		leftTrackModel[6].setRotationPoint(-26.5F, -2.5F, 7F);

		leftTrackModel[7].addShapeBox(0F, 0F, 0F, 10, 1, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.7F, -0.5F, 0F, -0.7F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 36
		leftTrackModel[7].setRotationPoint(-26F, -3F, 7F);

		leftTrackModel[8].addBox(0F, 0F, 0F, 5, 1, 14, 0F); // Box 37
		leftTrackModel[8].setRotationPoint(-23.5F, -3F, -7F);

		leftTrackModel[9].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F); // Box 38
		leftTrackModel[9].setRotationPoint(-29.5F, -2F, -7.5F);

		leftTrackModel[10].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F); // Box 39
		leftTrackModel[10].setRotationPoint(-13.5F, -2F, -7.5F);

		leftTrackModel[11].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, -0.75F, 0F, 0F, 0.75F, 0F, 0F, 0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 40
		leftTrackModel[11].setRotationPoint(-29.5F, -4F, -7.5F);

		leftTrackModel[12].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 41
		leftTrackModel[12].setRotationPoint(-13.5F, -4F, -7.5F);

		leftTrackModel[13].addShapeBox(0F, 0F, 0F, 5, 1, 14, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 42
		leftTrackModel[13].setRotationPoint(-23.5F, -4F, -7F);

		leftTrackModel[14].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F); // Box 43
		leftTrackModel[14].setRotationPoint(-29.5F, -2F, 5.5F);

		leftTrackModel[15].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, -0.75F, 0F, 0F, 0.75F, 0F, 0F, 0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 44
		leftTrackModel[15].setRotationPoint(-29.5F, -4F, 5.5F);

		leftTrackModel[16].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F); // Box 45
		leftTrackModel[16].setRotationPoint(-13.5F, -2F, 5.5F);

		leftTrackModel[17].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 46
		leftTrackModel[17].setRotationPoint(-13.5F, -4F, 5.5F);

		leftTrackModel[18].addShapeBox(0F, 0F, 0F, 15, 1, 2, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F); // Box 47
		leftTrackModel[18].setRotationPoint(-28.5F, -5F, -7.5F);

		leftTrackModel[19].addShapeBox(0F, 0F, 0F, 15, 1, 2, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F); // Box 48
		leftTrackModel[19].setRotationPoint(-28.5F, -5F, 5.5F);

		leftTrackModel[20].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 49
		leftTrackModel[20].setRotationPoint(-19.5F, -5F, -1.5F);

		leftTrackModel[21].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 50
		leftTrackModel[21].setRotationPoint(-23.5F, -5F, -1.5F);

		leftTrackModel[22].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F); // Box 51
		leftTrackModel[22].setRotationPoint(-22.5F, -5F, -2.5F);

		leftTrackModel[23].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 52
		leftTrackModel[23].setRotationPoint(-22.5F, -5F, 1.5F);


		rightTrackModel = new ModelRendererTurbo[24];
		rightTrackModel[0] = new ModelRendererTurbo(this, 233, 9, textureX, textureY); // Box 53
		rightTrackModel[1] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 54
		rightTrackModel[2] = new ModelRendererTurbo(this, 185, 17, textureX, textureY); // Box 55
		rightTrackModel[3] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Box 56
		rightTrackModel[4] = new ModelRendererTurbo(this, 137, 9, textureX, textureY); // Box 57
		rightTrackModel[5] = new ModelRendererTurbo(this, 209, 17, textureX, textureY); // Box 58
		rightTrackModel[6] = new ModelRendererTurbo(this, 217, 9, textureX, textureY); // Box 59
		rightTrackModel[7] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 60
		rightTrackModel[8] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 61
		rightTrackModel[9] = new ModelRendererTurbo(this, 41, 25, textureX, textureY); // Box 62
		rightTrackModel[10] = new ModelRendererTurbo(this, 73, 25, textureX, textureY); // Box 63
		rightTrackModel[11] = new ModelRendererTurbo(this, 233, 17, textureX, textureY); // Box 64
		rightTrackModel[12] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 65
		rightTrackModel[13] = new ModelRendererTurbo(this, 241, 17, textureX, textureY); // Box 66
		rightTrackModel[14] = new ModelRendererTurbo(this, 249, 17, textureX, textureY); // Box 67
		rightTrackModel[15] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 68
		rightTrackModel[16] = new ModelRendererTurbo(this, 33, 25, textureX, textureY); // Box 69
		rightTrackModel[17] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 70
		rightTrackModel[18] = new ModelRendererTurbo(this, 41, 25, textureX, textureY); // Box 71
		rightTrackModel[19] = new ModelRendererTurbo(this, 153, 25, textureX, textureY); // Box 72
		rightTrackModel[20] = new ModelRendererTurbo(this, 161, 25, textureX, textureY); // Box 73
		rightTrackModel[21] = new ModelRendererTurbo(this, 177, 25, textureX, textureY); // Box 74
		rightTrackModel[22] = new ModelRendererTurbo(this, 169, 17, textureX, textureY); // Box 75
		rightTrackModel[23] = new ModelRendererTurbo(this, 169, 25, textureX, textureY); // Box 76

		rightTrackModel[0].addShapeBox(0F, 0F, 0F, 5, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, -0.25F, -0.4F, 0F, -0.25F, -0.4F, 0F, -0.25F, -0.4F, 0F, -0.25F); // Box 53
		rightTrackModel[0].setRotationPoint(18.5F, -2F, -7.5F);

		rightTrackModel[1].addShapeBox(0F, 0F, 0F, 5, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, -0.25F, -0.4F, 0F, -0.25F, -0.4F, 0F, -0.25F, -0.4F, 0F, -0.25F); // Box 54
		rightTrackModel[1].setRotationPoint(18.5F, -2F, 5.5F);

		rightTrackModel[2].addShapeBox(0F, 0F, 0F, 10, 1, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.7F, -0.5F, 0F, -0.7F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 55
		rightTrackModel[2].setRotationPoint(16F, -3F, 7F);

		rightTrackModel[3].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.2F, -0.25F, -0.2F, -0.2F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.2F, -0.25F, -0.2F, -0.2F, -0.25F); // Box 56
		rightTrackModel[3].setRotationPoint(25.5F, -2.5F, 7F);

		rightTrackModel[4].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.2F, -0.25F, -0.2F, -0.2F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.2F, -0.25F, -0.2F, -0.2F, -0.25F); // Box 57
		rightTrackModel[4].setRotationPoint(15.5F, -2.5F, 7F);

		rightTrackModel[5].addShapeBox(0F, 0F, 0F, 10, 1, 1, 0F, 0F, -0.7F, -0.5F, 0F, -0.7F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 58
		rightTrackModel[5].setRotationPoint(16F, -3F, -8F);

		rightTrackModel[6].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, -0.25F, -0.2F, -0.2F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.2F, -0.25F, -0.2F, -0.2F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 59
		rightTrackModel[6].setRotationPoint(25.5F, -2.5F, -8F);

		rightTrackModel[7].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, -0.25F, -0.2F, -0.2F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.2F, -0.25F, -0.2F, -0.2F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 60
		rightTrackModel[7].setRotationPoint(15.5F, -2.5F, -8F);

		rightTrackModel[8].addBox(0F, 0F, 0F, 5, 1, 14, 0F); // Box 61
		rightTrackModel[8].setRotationPoint(18.5F, -3F, -7F);

		rightTrackModel[9].addShapeBox(0F, 0F, 0F, 5, 1, 14, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 62
		rightTrackModel[9].setRotationPoint(18.5F, -4F, -7F);

		rightTrackModel[10].addShapeBox(0F, 0F, 0F, 15, 1, 2, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F); // Box 63
		rightTrackModel[10].setRotationPoint(13.5F, -5F, -7.5F);

		rightTrackModel[11].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 64
		rightTrackModel[11].setRotationPoint(28.5F, -4F, -7.5F);

		rightTrackModel[12].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F); // Box 65
		rightTrackModel[12].setRotationPoint(28.5F, -2F, -7.5F);

		rightTrackModel[13].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F); // Box 66
		rightTrackModel[13].setRotationPoint(12.5F, -2F, -7.5F);

		rightTrackModel[14].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, -0.75F, 0F, 0F, 0.75F, 0F, 0F, 0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 67
		rightTrackModel[14].setRotationPoint(12.5F, -4F, -7.5F);

		rightTrackModel[15].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F); // Box 68
		rightTrackModel[15].setRotationPoint(12.5F, -2F, 5.5F);

		rightTrackModel[16].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, -0.75F, 0F, 0F, 0.75F, 0F, 0F, 0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 69
		rightTrackModel[16].setRotationPoint(12.5F, -4F, 5.5F);

		rightTrackModel[17].addShapeBox(0F, 0F, 0F, 15, 1, 2, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F); // Box 70
		rightTrackModel[17].setRotationPoint(13.5F, -5F, 5.5F);

		rightTrackModel[18].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F); // Box 71
		rightTrackModel[18].setRotationPoint(28.5F, -2F, 5.5F);

		rightTrackModel[19].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 72
		rightTrackModel[19].setRotationPoint(28.5F, -4F, 5.5F);

		rightTrackModel[20].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 73
		rightTrackModel[20].setRotationPoint(22.5F, -5F, -1.5F);

		rightTrackModel[21].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 74
		rightTrackModel[21].setRotationPoint(18.5F, -5F, -1.5F);

		rightTrackModel[22].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F); // Box 75
		rightTrackModel[22].setRotationPoint(19.5F, -5F, -2.5F);

		rightTrackModel[23].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 76
		rightTrackModel[23].setRotationPoint(19.5F, -5F, 1.5F);

		translateAll(0F, 4F, 0F);
		
	}
	
}