package net.fexcraft.mod.ftm.models;

import net.fexcraft.mod.lib.tmt.ModelConverter;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelWagonBogieBase extends ModelConverter{
    
	int textureX = 512;
	int textureY = 512;

	public ModelWagonBogieBase(){
            
		bodyModel = new ModelRendererTurbo[49];
		bodyModel[0] = new ModelRendererTurbo(this, 145, 9, textureX, textureY); // Box 141
		bodyModel[1] = new ModelRendererTurbo(this, 153, 9, textureX, textureY); // Box 142
		bodyModel[2] = new ModelRendererTurbo(this, 161, 9, textureX, textureY); // Box 143
		bodyModel[3] = new ModelRendererTurbo(this, 169, 9, textureX, textureY); // Box 144
		bodyModel[4] = new ModelRendererTurbo(this, 177, 9, textureX, textureY); // Box 145
		bodyModel[5] = new ModelRendererTurbo(this, 185, 9, textureX, textureY); // Box 146
		bodyModel[6] = new ModelRendererTurbo(this, 193, 9, textureX, textureY); // Box 147
		bodyModel[7] = new ModelRendererTurbo(this, 201, 9, textureX, textureY); // Box 148
		bodyModel[8] = new ModelRendererTurbo(this, 209, 9, textureX, textureY); // Box 149
		bodyModel[9] = new ModelRendererTurbo(this, 249, 9, textureX, textureY); // Box 150
		bodyModel[10] = new ModelRendererTurbo(this, 273, 9, textureX, textureY); // Box 151
		bodyModel[11] = new ModelRendererTurbo(this, 281, 9, textureX, textureY); // Box 152
		bodyModel[12] = new ModelRendererTurbo(this, 289, 9, textureX, textureY); // Box 153
		bodyModel[13] = new ModelRendererTurbo(this, 297, 9, textureX, textureY); // Box 154
		bodyModel[14] = new ModelRendererTurbo(this, 305, 9, textureX, textureY); // Box 155
		bodyModel[15] = new ModelRendererTurbo(this, 321, 9, textureX, textureY); // Box 156
		bodyModel[16] = new ModelRendererTurbo(this, 329, 9, textureX, textureY); // Box 157
		bodyModel[17] = new ModelRendererTurbo(this, 337, 9, textureX, textureY); // Box 158
		bodyModel[18] = new ModelRendererTurbo(this, 345, 9, textureX, textureY); // Box 159
		bodyModel[19] = new ModelRendererTurbo(this, 353, 9, textureX, textureY); // Box 160
		bodyModel[20] = new ModelRendererTurbo(this, 361, 9, textureX, textureY); // Box 161
		bodyModel[21] = new ModelRendererTurbo(this, 369, 9, textureX, textureY); // Box 162
		bodyModel[22] = new ModelRendererTurbo(this, 409, 9, textureX, textureY); // Box 163
		bodyModel[23] = new ModelRendererTurbo(this, 417, 9, textureX, textureY); // Box 164
		bodyModel[24] = new ModelRendererTurbo(this, 425, 9, textureX, textureY); // Box 165
		bodyModel[25] = new ModelRendererTurbo(this, 449, 9, textureX, textureY); // Box 166
		bodyModel[26] = new ModelRendererTurbo(this, 457, 9, textureX, textureY); // Box 167
		bodyModel[27] = new ModelRendererTurbo(this, 465, 9, textureX, textureY); // Box 168
		bodyModel[28] = new ModelRendererTurbo(this, 473, 9, textureX, textureY); // Box 169
		bodyModel[29] = new ModelRendererTurbo(this, 481, 9, textureX, textureY); // Box 170
		bodyModel[30] = new ModelRendererTurbo(this, 41, 17, textureX, textureY); // Box 171
		bodyModel[31] = new ModelRendererTurbo(this, 497, 9, textureX, textureY); // Box 172
		bodyModel[32] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 173
		bodyModel[33] = new ModelRendererTurbo(this, 129, 17, textureX, textureY); // Box 174
		bodyModel[34] = new ModelRendererTurbo(this, 153, 17, textureX, textureY); // Box 175
		bodyModel[35] = new ModelRendererTurbo(this, 177, 17, textureX, textureY); // Box 176
		bodyModel[36] = new ModelRendererTurbo(this, 201, 17, textureX, textureY); // Box 177
		bodyModel[37] = new ModelRendererTurbo(this, 145, 17, textureX, textureY); // Box 178
		bodyModel[38] = new ModelRendererTurbo(this, 169, 17, textureX, textureY); // Box 179
		bodyModel[39] = new ModelRendererTurbo(this, 217, 17, textureX, textureY); // Box 180
		bodyModel[40] = new ModelRendererTurbo(this, 249, 17, textureX, textureY); // Box 181
		bodyModel[41] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 182
		bodyModel[42] = new ModelRendererTurbo(this, 65, 17, textureX, textureY); // Box 183
		bodyModel[43] = new ModelRendererTurbo(this, 9, 17, textureX, textureY); // Box 184
		bodyModel[44] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 185
		bodyModel[45] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 186
		bodyModel[46] = new ModelRendererTurbo(this, 41, 17, textureX, textureY); // Box 187
		bodyModel[47] = new ModelRendererTurbo(this, 73, 17, textureX, textureY); // Box 188
		bodyModel[48] = new ModelRendererTurbo(this, 81, 17, textureX, textureY); // Box 189

		bodyModel[0].addShapeBox(-1F, -0.5F, 0.25F, 2, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F); // Box 141
		bodyModel[0].setRotationPoint(-7F, -6F, -10F);

		bodyModel[1].addShapeBox(-1F, -1F, 0.25F, 2, 1, 1, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F); // Box 142
		bodyModel[1].setRotationPoint(-7F, -6F, -10F);

		bodyModel[2].addShapeBox(-1F, 0F, 0.25F, 2, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F); // Box 143
		bodyModel[2].setRotationPoint(-7F, -6F, -10F);

		bodyModel[3].addShapeBox(-1F, -0.5F, 0.25F, 2, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F); // Box 144
		bodyModel[3].setRotationPoint(7F, -6F, -10F);

		bodyModel[4].addShapeBox(-1F, 0F, 0.25F, 2, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F); // Box 145
		bodyModel[4].setRotationPoint(7F, -6F, -10F);

		bodyModel[5].addShapeBox(-1F, -1F, 0.25F, 2, 1, 1, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F); // Box 146
		bodyModel[5].setRotationPoint(7F, -6F, -10F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 147
		bodyModel[6].setRotationPoint(-9F, -7F, -9.6F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 148
		bodyModel[7].setRotationPoint(7F, -7F, -9.6F);

		bodyModel[8].addShapeBox(0F, 0F, 0F, 17, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 149
		bodyModel[8].setRotationPoint(-8.5F, -8F, -9.6F);

		bodyModel[9].addShapeBox(0F, 0F, 0F, 10, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 150
		bodyModel[9].setRotationPoint(-5F, -5F, -9.6F);

		bodyModel[10].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F); // Box 151
		bodyModel[10].setRotationPoint(-6F, -7F, -9.6F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F); // Box 152
		bodyModel[11].setRotationPoint(5F, -7F, -9.6F);

		bodyModel[12].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 153
		bodyModel[12].setRotationPoint(-3F, -7F, -9.6F);

		bodyModel[13].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 154
		bodyModel[13].setRotationPoint(2F, -7F, -9.6F);

		bodyModel[14].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 155
		bodyModel[14].setRotationPoint(-2F, -7F, -10.1F);

		bodyModel[15].addShapeBox(-1F, -0.5F, 0.75F, 2, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F); // Box 156
		bodyModel[15].setRotationPoint(7F, -6F, 8F);

		bodyModel[16].addShapeBox(-1F, -1F, 0.75F, 2, 1, 1, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F); // Box 157
		bodyModel[16].setRotationPoint(7F, -6F, 8F);

		bodyModel[17].addShapeBox(-1F, 0F, -0.25F, 2, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F); // Box 158
		bodyModel[17].setRotationPoint(7F, -6F, 9F);

		bodyModel[18].addShapeBox(-1F, 0F, -0.25F, 2, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F); // Box 159
		bodyModel[18].setRotationPoint(-7F, -6F, 9F);

		bodyModel[19].addShapeBox(-1F, -0.5F, 0.75F, 2, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F); // Box 160
		bodyModel[19].setRotationPoint(-7F, -6F, 8F);

		bodyModel[20].addShapeBox(-1F, -1F, 0.75F, 2, 1, 1, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F); // Box 161
		bodyModel[20].setRotationPoint(-7F, -6F, 8F);

		bodyModel[21].addShapeBox(0F, 0F, 0F, 17, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 162
		bodyModel[21].setRotationPoint(-8.5F, -8F, 8.6F);

		bodyModel[22].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 163
		bodyModel[22].setRotationPoint(-9F, -7F, 8.6F);

		bodyModel[23].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 164
		bodyModel[23].setRotationPoint(7F, -7F, 8.6F);

		bodyModel[24].addShapeBox(0F, 0F, 0F, 10, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 165
		bodyModel[24].setRotationPoint(-5F, -5F, 8.6F);

		bodyModel[25].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F); // Box 166
		bodyModel[25].setRotationPoint(5F, -7F, 8.6F);

		bodyModel[26].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F); // Box 167
		bodyModel[26].setRotationPoint(-6F, -7F, 8.6F);

		bodyModel[27].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 168
		bodyModel[27].setRotationPoint(-3F, -7F, 8.6F);

		bodyModel[28].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 169
		bodyModel[28].setRotationPoint(2F, -7F, 8.6F);

		bodyModel[29].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 170
		bodyModel[29].setRotationPoint(-2F, -7F, 8.1F);

		bodyModel[30].addBox(0F, 0F, 0F, 4, 3, 13, 0F); // Box 171
		bodyModel[30].setRotationPoint(-2F, -8F, -6.5F);

		bodyModel[31].addShapeBox(0F, 0F, 0F, 5, 3, 2, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0.2F, 0F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.1F); // Box 172
		bodyModel[31].setRotationPoint(-2.5F, -8F, -8.6F);

		bodyModel[32].addShapeBox(0F, 0F, 0F, 5, 3, 2, 0F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0.2F, 0F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.1F, 0F, 0.2F, 0F, 0F, 0.2F, 0F); // Box 173
		bodyModel[32].setRotationPoint(-2.5F, -8F, 6.6F);

		bodyModel[33].addShapeBox(0F, 0F, 0F, 1, 1, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, -0.5F, 0F, 0F); // Box 174
		bodyModel[33].setRotationPoint(2F, -7F, -8.5F);

		bodyModel[34].addShapeBox(0F, 0F, 0F, 1, 1, 7, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 175
		bodyModel[34].setRotationPoint(-3.5F, -7F, -8.5F);

		bodyModel[35].addShapeBox(0F, 0F, 0F, 1, 1, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, -0.5F, 0F, 0F); // Box 176
		bodyModel[35].setRotationPoint(-3.5F, -7F, 1.5F);

		bodyModel[36].addShapeBox(0F, 0F, 0F, 1, 1, 7, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 177
		bodyModel[36].setRotationPoint(2F, -7F, 1.5F);

		bodyModel[37].addBox(0F, 0F, 0F, 1, 1, 3, 0F); // Box 178
		bodyModel[37].setRotationPoint(2.5F, -7F, -1.5F);

		bodyModel[38].addBox(0F, 0F, 0F, 1, 1, 3, 0F); // Box 179
		bodyModel[38].setRotationPoint(-3.5F, -7F, -1.5F);

		bodyModel[39].addShapeBox(0F, 0F, 0F, 13, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 180
		bodyModel[39].setRotationPoint(-6.5F, -9F, -9.6F);

		bodyModel[40].addShapeBox(0F, 0F, 0F, 13, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 181
		bodyModel[40].setRotationPoint(-6.5F, -9F, 8.6F);

		bodyModel[41].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Box 182
		bodyModel[41].setRotationPoint(-3F, -9F, -1F);

		bodyModel[42].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F); // Box 183
		bodyModel[42].setRotationPoint(2F, -9F, -1F);

		bodyModel[43].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 184
		bodyModel[43].setRotationPoint(-1F, -9F, 2F);

		bodyModel[44].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 185
		bodyModel[44].setRotationPoint(-1F, -9F, -3F);

		bodyModel[45].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, -2F, -1F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -2F, -1F, 1F, 1F, 0F, 0F, 0F); // Box 186
		bodyModel[45].setRotationPoint(1F, -9F, -3F);

		bodyModel[46].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, -1F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 1F, 1F, 0F, 0F, -2F, 0F, 0F, 1F); // Box 187
		bodyModel[46].setRotationPoint(1F, -9F, 2F);

		bodyModel[47].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, -1F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, -1F, 1F, 1F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -2F); // Box 188
		bodyModel[47].setRotationPoint(-3F, -9F, 2F);

		bodyModel[48].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, 0F, -1F, 1F, 1F); // Box 189
		bodyModel[48].setRotationPoint(-3F, -9F, -3F);


		frontWheelModel = new ModelRendererTurbo[70];
		frontWheelModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Wheel 01
		frontWheelModel[1] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Wheel 02
		frontWheelModel[2] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Wheel 03
		frontWheelModel[3] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Wheel 04
		frontWheelModel[4] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Wheel 05
		frontWheelModel[5] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Wheel 06
		frontWheelModel[6] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Wheel 07
		frontWheelModel[7] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Wheel 08
		frontWheelModel[8] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Wheel 09
		frontWheelModel[9] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Wheel 10
		frontWheelModel[10] = new ModelRendererTurbo(this, 105, 1, textureX, textureY); // Wheel 11
		frontWheelModel[11] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Wheel 12
		frontWheelModel[12] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Wheel 13
		frontWheelModel[13] = new ModelRendererTurbo(this, 129, 1, textureX, textureY); // Wheel 14
		frontWheelModel[14] = new ModelRendererTurbo(this, 137, 1, textureX, textureY); // Wheel 15
		frontWheelModel[15] = new ModelRendererTurbo(this, 145, 1, textureX, textureY); // Wheel 16
		frontWheelModel[16] = new ModelRendererTurbo(this, 153, 1, textureX, textureY); // Wheel 17
		frontWheelModel[17] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Wheel 18
		frontWheelModel[18] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Wheel 19
		frontWheelModel[19] = new ModelRendererTurbo(this, 177, 1, textureX, textureY); // Wheel 20
		frontWheelModel[20] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Wheel 21
		frontWheelModel[21] = new ModelRendererTurbo(this, 201, 1, textureX, textureY); // Wheel 22
		frontWheelModel[22] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Wheel 23
		frontWheelModel[23] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Wheel 24
		frontWheelModel[24] = new ModelRendererTurbo(this, 225, 1, textureX, textureY); // Wheel 25
		frontWheelModel[25] = new ModelRendererTurbo(this, 233, 1, textureX, textureY); // Wheel 26
		frontWheelModel[26] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Wheel 27
		frontWheelModel[27] = new ModelRendererTurbo(this, 249, 1, textureX, textureY); // Wheel 28
		frontWheelModel[28] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Wheel 29
		frontWheelModel[29] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Wheel 30
		frontWheelModel[30] = new ModelRendererTurbo(this, 273, 1, textureX, textureY); // Wheel 31
		frontWheelModel[31] = new ModelRendererTurbo(this, 281, 1, textureX, textureY); // Wheel 32
		frontWheelModel[32] = new ModelRendererTurbo(this, 289, 1, textureX, textureY); // Wheel 33
		frontWheelModel[33] = new ModelRendererTurbo(this, 297, 1, textureX, textureY); // Wheel 34
		frontWheelModel[34] = new ModelRendererTurbo(this, 305, 1, textureX, textureY); // Wheel 35
		frontWheelModel[35] = new ModelRendererTurbo(this, 321, 1, textureX, textureY); // Box 35
		frontWheelModel[36] = new ModelRendererTurbo(this, 329, 1, textureX, textureY); // Box 36
		frontWheelModel[37] = new ModelRendererTurbo(this, 337, 1, textureX, textureY); // Box 37
		frontWheelModel[38] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 38
		frontWheelModel[39] = new ModelRendererTurbo(this, 369, 1, textureX, textureY); // Box 39
		frontWheelModel[40] = new ModelRendererTurbo(this, 377, 1, textureX, textureY); // Box 40
		frontWheelModel[41] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 41
		frontWheelModel[42] = new ModelRendererTurbo(this, 393, 1, textureX, textureY); // Box 42
		frontWheelModel[43] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 43
		frontWheelModel[44] = new ModelRendererTurbo(this, 401, 1, textureX, textureY); // Box 44
		frontWheelModel[45] = new ModelRendererTurbo(this, 417, 1, textureX, textureY); // Box 45
		frontWheelModel[46] = new ModelRendererTurbo(this, 425, 1, textureX, textureY); // Box 46
		frontWheelModel[47] = new ModelRendererTurbo(this, 433, 1, textureX, textureY); // Box 47
		frontWheelModel[48] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 48
		frontWheelModel[49] = new ModelRendererTurbo(this, 449, 1, textureX, textureY); // Box 49
		frontWheelModel[50] = new ModelRendererTurbo(this, 457, 1, textureX, textureY); // Box 50
		frontWheelModel[51] = new ModelRendererTurbo(this, 465, 1, textureX, textureY); // Box 51
		frontWheelModel[52] = new ModelRendererTurbo(this, 473, 1, textureX, textureY); // Box 52
		frontWheelModel[53] = new ModelRendererTurbo(this, 481, 1, textureX, textureY); // Box 53
		frontWheelModel[54] = new ModelRendererTurbo(this, 489, 1, textureX, textureY); // Box 55
		frontWheelModel[55] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 56
		frontWheelModel[56] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 57
		frontWheelModel[57] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 58
		frontWheelModel[58] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 59
		frontWheelModel[59] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 60
		frontWheelModel[60] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // Box 61
		frontWheelModel[61] = new ModelRendererTurbo(this, 65, 9, textureX, textureY); // Box 62
		frontWheelModel[62] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 63
		frontWheelModel[63] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Box 64
		frontWheelModel[64] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 65
		frontWheelModel[65] = new ModelRendererTurbo(this, 105, 9, textureX, textureY); // Box 66
		frontWheelModel[66] = new ModelRendererTurbo(this, 113, 9, textureX, textureY); // Box 67
		frontWheelModel[67] = new ModelRendererTurbo(this, 121, 9, textureX, textureY); // Box 68
		frontWheelModel[68] = new ModelRendererTurbo(this, 129, 9, textureX, textureY); // Box 69
		frontWheelModel[69] = new ModelRendererTurbo(this, 137, 9, textureX, textureY); // Box 70

		frontWheelModel[0].addBox(-1F, 2F, 0F, 2, 1, 2, 0F); // Wheel 01
		frontWheelModel[0].setRotationPoint(7F, -6F, 6.5F);

		frontWheelModel[1].addBox(-1F, -3F, 0F, 2, 1, 2, 0F); // Wheel 02
		frontWheelModel[1].setRotationPoint(7F, -6F, 6.5F);

		frontWheelModel[2].addBox(2F, -1F, 0F, 1, 2, 2, 0F); // Wheel 03
		frontWheelModel[2].setRotationPoint(7F, -6F, 6.5F);

		frontWheelModel[3].addBox(-3F, -1F, 0F, 1, 2, 2, 0F); // Wheel 04
		frontWheelModel[3].setRotationPoint(7F, -6F, 6.5F);

		frontWheelModel[4].addShapeBox(-3F, 1F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -2F, 0F, 0F); // Wheel 05
		frontWheelModel[4].setRotationPoint(7F, -6F, 6.5F);

		frontWheelModel[5].addShapeBox(-3F, -3F, 0F, 1, 2, 2, 0F, -2F, 0F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Wheel 06
		frontWheelModel[5].setRotationPoint(7F, -6F, 6.5F);

		frontWheelModel[6].addShapeBox(2F, -3F, 0F, 1, 2, 2, 0F, 1F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Wheel 07
		frontWheelModel[6].setRotationPoint(7F, -6F, 6.5F);

		frontWheelModel[7].addShapeBox(2F, 1F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -1F, 0F); // Wheel 08
		frontWheelModel[7].setRotationPoint(7F, -6F, 6.5F);

		frontWheelModel[8].addBox(-2F, -2F, 0F, 4, 4, 1, 0F); // Wheel 09
		frontWheelModel[8].setRotationPoint(7F, -6F, 7F);

		frontWheelModel[9].addShapeBox(-1F, 2F, -1F, 2, 1, 1, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, -0.8F, 0F, 0.5F, -0.8F, 0F, 0.5F, 0F, 0F, 0.5F, 0F); // Wheel 10
		frontWheelModel[9].setRotationPoint(7F, -6F, 6.5F);

		frontWheelModel[10].addShapeBox(-1F, -3F, -1F, 2, 1, 1, 0F, 0F, 0.5F, -0.8F, 0F, 0.5F, -0.8F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F); // Wheel 11
		frontWheelModel[10].setRotationPoint(7F, -6F, 6.5F);

		frontWheelModel[11].addShapeBox(2F, -1F, -1F, 1, 2, 1, 0F, 0F, 0F, -0.8F, 0.5F, 0F, -0.8F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0.5F, 0F, -0.8F, 0.5F, 0F, 0F, 0F, 0F, 0F); // Wheel 12
		frontWheelModel[11].setRotationPoint(7F, -6F, 6.5F);

		frontWheelModel[12].addShapeBox(-3F, -1F, -1F, 1, 2, 1, 0F, 0.5F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0.5F, 0F, 0F); // Wheel 13
		frontWheelModel[12].setRotationPoint(7F, -6F, 6.5F);

		frontWheelModel[13].addShapeBox(2F, 1F, -1F, 1, 2, 1, 0F, 0F, 0F, -0.8F, 0.5F, 0F, -0.8F, 0.5F, 0F, 0F, 0F, 0F, 0F, 1F, -1F, -0.8F, -2F, 0.5F, -0.8F, -2F, 0.5F, 0F, 1F, -1F, 0F); // Wheel 14
		frontWheelModel[13].setRotationPoint(7F, -6F, 6.5F);

		frontWheelModel[14].addShapeBox(2F, -3F, -1F, 1, 2, 1, 0F, 1F, -1F, -0.8F, -2F, 0.5F, -0.8F, -2F, 0.5F, 0F, 1F, -1F, 0F, 0F, 0F, -0.8F, 0.5F, 0F, -0.8F, 0.5F, 0F, 0F, 0F, 0F, 0F); // Wheel 15
		frontWheelModel[14].setRotationPoint(7F, -6F, 6.5F);

		frontWheelModel[15].addShapeBox(-3F, -3F, -1F, 1, 2, 1, 0F, -2F, 0.5F, -0.8F, 1F, -1F, -0.8F, 1F, -1F, 0F, -2F, 0.5F, 0F, 0.5F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0.5F, 0F, 0F); // Wheel 16
		frontWheelModel[15].setRotationPoint(7F, -6F, 6.5F);

		frontWheelModel[16].addShapeBox(-3F, 1F, -1F, 1, 2, 1, 0F, 0.5F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0.5F, 0F, 0F, -2F, 0.5F, -0.8F, 1F, -1F, -0.8F, 1F, -1F, 0F, -2F, 0.5F, 0F); // Wheel 17
		frontWheelModel[16].setRotationPoint(7F, -6F, 6.5F);

		frontWheelModel[17].addBox(-0.5F, -0.5F, 0F, 1, 1, 19, 0F); // Wheel 18
		frontWheelModel[17].setRotationPoint(7F, -6F, -9.5F);

		frontWheelModel[18].addBox(-1F, 2F, 0F, 2, 1, 2, 0F); // Wheel 19
		frontWheelModel[18].setRotationPoint(7F, -6F, -8.5F);

		frontWheelModel[19].addBox(-1F, -3F, 0F, 2, 1, 2, 0F); // Wheel 20
		frontWheelModel[19].setRotationPoint(7F, -6F, -8.5F);

		frontWheelModel[20].addShapeBox(-3F, -3F, 0F, 1, 2, 2, 0F, -2F, 0F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Wheel 21
		frontWheelModel[20].setRotationPoint(7F, -6F, -8.5F);

		frontWheelModel[21].addShapeBox(-3F, 1F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -2F, 0F, 0F); // Wheel 22
		frontWheelModel[21].setRotationPoint(7F, -6F, -8.5F);

		frontWheelModel[22].addBox(-3F, -1F, 0F, 1, 2, 2, 0F); // Wheel 23
		frontWheelModel[22].setRotationPoint(7F, -6F, -8.5F);

		frontWheelModel[23].addShapeBox(2F, 1F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -1F, 0F); // Wheel 24
		frontWheelModel[23].setRotationPoint(7F, -6F, -8.5F);

		frontWheelModel[24].addBox(2F, -1F, 0F, 1, 2, 2, 0F); // Wheel 25
		frontWheelModel[24].setRotationPoint(7F, -6F, -8.5F);

		frontWheelModel[25].addShapeBox(2F, -3F, 0F, 1, 2, 2, 0F, 1F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Wheel 26
		frontWheelModel[25].setRotationPoint(7F, -6F, -8.5F);

		frontWheelModel[26].addShapeBox(2F, 1F, -1F, 1, 2, 1, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, -0.8F, 0F, 0F, -0.8F, 1F, -1F, 0F, -2F, 0.5F, 0F, -2F, 0.5F, -0.8F, 1F, -1F, -0.8F); // Wheel 27
		frontWheelModel[26].setRotationPoint(7F, -6F, -5.5F);

		frontWheelModel[27].addShapeBox(2F, -1F, -1F, 1, 2, 1, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, -0.8F, 0F, 0F, -0.8F); // Wheel 28
		frontWheelModel[27].setRotationPoint(7F, -6F, -5.5F);

		frontWheelModel[28].addShapeBox(2F, -3F, -1F, 1, 2, 1, 0F, 1F, -1F, 0F, -2F, 0.5F, 0F, -2F, 0.5F, -0.8F, 1F, -1F, -0.8F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, -0.8F, 0F, 0F, -0.8F); // Wheel 29
		frontWheelModel[28].setRotationPoint(7F, -6F, -5.5F);

		frontWheelModel[29].addShapeBox(-1F, -3F, -1F, 2, 1, 1, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.8F, 0F, 0.5F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F); // Wheel 30
		frontWheelModel[29].setRotationPoint(7F, -6F, -5.5F);

		frontWheelModel[30].addShapeBox(-3F, -3F, -1F, 1, 2, 1, 0F, -2F, 0.5F, 0F, 1F, -1F, 0F, 1F, -1F, -0.8F, -2F, 0.5F, -0.8F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0.5F, 0F, -0.8F); // Wheel 31
		frontWheelModel[30].setRotationPoint(7F, -6F, -5.5F);

		frontWheelModel[31].addShapeBox(-3F, -1F, -1F, 1, 2, 1, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0.5F, 0F, -0.8F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0.5F, 0F, -0.8F); // Wheel 32
		frontWheelModel[31].setRotationPoint(7F, -6F, -5.5F);

		frontWheelModel[32].addShapeBox(-3F, 1F, -1F, 1, 2, 1, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0.5F, 0F, -0.8F, -2F, 0.5F, 0F, 1F, -1F, 0F, 1F, -1F, -0.8F, -2F, 0.5F, -0.8F); // Wheel 33
		frontWheelModel[32].setRotationPoint(7F, -6F, -5.5F);

		frontWheelModel[33].addShapeBox(-1F, 2F, -1F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.8F, 0F, 0.5F, -0.8F); // Wheel 34
		frontWheelModel[33].setRotationPoint(7F, -6F, -5.5F);

		frontWheelModel[34].addBox(-2F, -2F, 0F, 4, 4, 1, 0F); // Wheel 35
		frontWheelModel[34].setRotationPoint(7F, -6F, -8F);

		frontWheelModel[35].addBox(-3F, -1F, 0F, 1, 2, 2, 0F); // Box 35
		frontWheelModel[35].setRotationPoint(-7F, -6F, -8.5F);

		frontWheelModel[36].addBox(2F, -1F, 0F, 1, 2, 2, 0F); // Box 36
		frontWheelModel[36].setRotationPoint(-7F, -6F, -8.5F);

		frontWheelModel[37].addBox(-1F, 2F, 0F, 2, 1, 2, 0F); // Box 37
		frontWheelModel[37].setRotationPoint(-7F, -6F, -8.5F);

		frontWheelModel[38].addBox(-1F, -3F, 0F, 2, 1, 2, 0F); // Box 38
		frontWheelModel[38].setRotationPoint(-7F, -6F, -8.5F);

		frontWheelModel[39].addShapeBox(-3F, 1F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -2F, 0F, 0F); // Box 39
		frontWheelModel[39].setRotationPoint(-7F, -6F, -8.5F);

		frontWheelModel[40].addShapeBox(-3F, -3F, 0F, 1, 2, 2, 0F, -2F, 0F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 40
		frontWheelModel[40].setRotationPoint(-7F, -6F, -8.5F);

		frontWheelModel[41].addShapeBox(2F, -3F, 0F, 1, 2, 2, 0F, 1F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 41
		frontWheelModel[41].setRotationPoint(-7F, -6F, -8.5F);

		frontWheelModel[42].addShapeBox(2F, 1F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -1F, 0F); // Box 42
		frontWheelModel[42].setRotationPoint(-7F, -6F, -8.5F);

		frontWheelModel[43].addBox(-0.5F, -0.5F, 0F, 1, 1, 19, 0F); // Box 43
		frontWheelModel[43].setRotationPoint(-7F, -6F, -9.5F);

		frontWheelModel[44].addBox(-2F, -2F, 0F, 4, 4, 1, 0F); // Box 44
		frontWheelModel[44].setRotationPoint(-7F, -6F, -8F);

		frontWheelModel[45].addShapeBox(-3F, 1F, -1F, 1, 2, 1, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0.5F, 0F, -0.8F, -2F, 0.5F, 0F, 1F, -1F, 0F, 1F, -1F, -0.8F, -2F, 0.5F, -0.8F); // Box 45
		frontWheelModel[45].setRotationPoint(-7F, -6F, -5.5F);

		frontWheelModel[46].addShapeBox(-1F, 2F, -1F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.8F, 0F, 0.5F, -0.8F); // Box 46
		frontWheelModel[46].setRotationPoint(-7F, -6F, -5.5F);

		frontWheelModel[47].addShapeBox(2F, 1F, -1F, 1, 2, 1, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, -0.8F, 0F, 0F, -0.8F, 1F, -1F, 0F, -2F, 0.5F, 0F, -2F, 0.5F, -0.8F, 1F, -1F, -0.8F); // Box 47
		frontWheelModel[47].setRotationPoint(-7F, -6F, -5.5F);

		frontWheelModel[48].addShapeBox(2F, -1F, -1F, 1, 2, 1, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, -0.8F, 0F, 0F, -0.8F); // Box 48
		frontWheelModel[48].setRotationPoint(-7F, -6F, -5.5F);

		frontWheelModel[49].addShapeBox(2F, -3F, -1F, 1, 2, 1, 0F, 1F, -1F, 0F, -2F, 0.5F, 0F, -2F, 0.5F, -0.8F, 1F, -1F, -0.8F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, -0.8F, 0F, 0F, -0.8F); // Box 49
		frontWheelModel[49].setRotationPoint(-7F, -6F, -5.5F);

		frontWheelModel[50].addShapeBox(-1F, -3F, -1F, 2, 1, 1, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.8F, 0F, 0.5F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F); // Box 50
		frontWheelModel[50].setRotationPoint(-7F, -6F, -5.5F);

		frontWheelModel[51].addShapeBox(-3F, -3F, -1F, 1, 2, 1, 0F, -2F, 0.5F, 0F, 1F, -1F, 0F, 1F, -1F, -0.8F, -2F, 0.5F, -0.8F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0.5F, 0F, -0.8F); // Box 51
		frontWheelModel[51].setRotationPoint(-7F, -6F, -5.5F);

		frontWheelModel[52].addShapeBox(-3F, -1F, -1F, 1, 2, 1, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0.5F, 0F, -0.8F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0.5F, 0F, -0.8F); // Box 52
		frontWheelModel[52].setRotationPoint(-7F, -6F, -5.5F);

		frontWheelModel[53].addBox(-3F, -1F, 0F, 1, 2, 2, 0F); // Box 53
		frontWheelModel[53].setRotationPoint(-7F, -6F, 6.5F);

		frontWheelModel[54].addBox(-2F, -2F, 0F, 4, 4, 1, 0F); // Box 55
		frontWheelModel[54].setRotationPoint(-7F, -6F, 7F);

		frontWheelModel[55].addShapeBox(-3F, -3F, 0F, 1, 2, 2, 0F, -2F, 0F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 56
		frontWheelModel[55].setRotationPoint(-7F, -6F, 6.5F);

		frontWheelModel[56].addBox(-1F, -3F, 0F, 2, 1, 2, 0F); // Box 57
		frontWheelModel[56].setRotationPoint(-7F, -6F, 6.5F);

		frontWheelModel[57].addShapeBox(-3F, 1F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -2F, 0F, 0F); // Box 58
		frontWheelModel[57].setRotationPoint(-7F, -6F, 6.5F);

		frontWheelModel[58].addBox(-1F, 2F, 0F, 2, 1, 2, 0F); // Box 59
		frontWheelModel[58].setRotationPoint(-7F, -6F, 6.5F);

		frontWheelModel[59].addShapeBox(2F, 1F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -1F, 0F); // Box 60
		frontWheelModel[59].setRotationPoint(-7F, -6F, 6.5F);

		frontWheelModel[60].addBox(2F, -1F, 0F, 1, 2, 2, 0F); // Box 61
		frontWheelModel[60].setRotationPoint(-7F, -6F, 6.5F);

		frontWheelModel[61].addShapeBox(2F, -3F, 0F, 1, 2, 2, 0F, 1F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 62
		frontWheelModel[61].setRotationPoint(-7F, -6F, 6.5F);

		frontWheelModel[62].addShapeBox(-1F, -3F, -1F, 2, 1, 1, 0F, 0F, 0.5F, -0.8F, 0F, 0.5F, -0.8F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 63
		frontWheelModel[62].setRotationPoint(-7F, -6F, 6.5F);

		frontWheelModel[63].addShapeBox(-3F, -3F, -1F, 1, 2, 1, 0F, -2F, 0.5F, -0.8F, 1F, -1F, -0.8F, 1F, -1F, 0F, -2F, 0.5F, 0F, 0.5F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0.5F, 0F, 0F); // Box 64
		frontWheelModel[63].setRotationPoint(-7F, -6F, 6.5F);

		frontWheelModel[64].addShapeBox(-3F, -1F, -1F, 1, 2, 1, 0F, 0.5F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0.5F, 0F, 0F); // Box 65
		frontWheelModel[64].setRotationPoint(-7F, -6F, 6.5F);

		frontWheelModel[65].addShapeBox(-3F, 1F, -1F, 1, 2, 1, 0F, 0.5F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0.5F, 0F, 0F, -2F, 0.5F, -0.8F, 1F, -1F, -0.8F, 1F, -1F, 0F, -2F, 0.5F, 0F); // Box 66
		frontWheelModel[65].setRotationPoint(-7F, -6F, 6.5F);

		frontWheelModel[66].addShapeBox(-1F, 2F, -1F, 2, 1, 1, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, -0.8F, 0F, 0.5F, -0.8F, 0F, 0.5F, 0F, 0F, 0.5F, 0F); // Box 67
		frontWheelModel[66].setRotationPoint(-7F, -6F, 6.5F);

		frontWheelModel[67].addShapeBox(2F, 1F, -1F, 1, 2, 1, 0F, 0F, 0F, -0.8F, 0.5F, 0F, -0.8F, 0.5F, 0F, 0F, 0F, 0F, 0F, 1F, -1F, -0.8F, -2F, 0.5F, -0.8F, -2F, 0.5F, 0F, 1F, -1F, 0F); // Box 68
		frontWheelModel[67].setRotationPoint(-7F, -6F, 6.5F);

		frontWheelModel[68].addShapeBox(2F, -1F, -1F, 1, 2, 1, 0F, 0F, 0F, -0.8F, 0.5F, 0F, -0.8F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0.5F, 0F, -0.8F, 0.5F, 0F, 0F, 0F, 0F, 0F); // Box 69
		frontWheelModel[68].setRotationPoint(-7F, -6F, 6.5F);

		frontWheelModel[69].addShapeBox(2F, -3F, -1F, 1, 2, 1, 0F, 1F, -1F, -0.8F, -2F, 0.5F, -0.8F, -2F, 0.5F, 0F, 1F, -1F, 0F, 0F, 0F, -0.8F, 0.5F, 0F, -0.8F, 0.5F, 0F, 0F, 0F, 0F, 0F); // Box 70
		frontWheelModel[69].setRotationPoint(-7F, -6F, 6.5F);
                
                translateAll(0F, 7F, 0F);
                
	}
}