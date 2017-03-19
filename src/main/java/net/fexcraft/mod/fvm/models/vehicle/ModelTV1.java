//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: TV1
// Model Creator: FEX___96
// Created on: 15.03.2017 - 13:33:45
// Last changed on: 15.03.2017 - 13:33:45

package net.fexcraft.mod.fvm.models.vehicle;

import net.fexcraft.mod.fvm.data.VehicleType;
import net.fexcraft.mod.fvm.models.VehicleModel;
import net.fexcraft.mod.fvm.scripts.MultiDoorScript;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelTV1 extends VehicleModel {
	
	public ModelRendererTurbo front[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo back[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo lfront[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo rfront[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo lback[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo rback[] = new ModelRendererTurbo[0];
	
	int textureX = 512;
	int textureY = 128;

	public ModelTV1(){
		body = new ModelRendererTurbo[36];
		body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		body[1] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 1
		body[2] = new ModelRendererTurbo(this, 249, 1, textureX, textureY); // Box 2
		body[3] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 3
		body[4] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Box 4
		body[5] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 5
		body[6] = new ModelRendererTurbo(this, 297, 1, textureX, textureY); // Box 6
		body[7] = new ModelRendererTurbo(this, 329, 1, textureX, textureY); // Box 7
		body[8] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 8
		body[9] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 9
		body[10] = new ModelRendererTurbo(this, 433, 1, textureX, textureY); // Box 10
		body[11] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 11
		body[12] = new ModelRendererTurbo(this, 89, 41, textureX, textureY); // Box 12
		body[13] = new ModelRendererTurbo(this, 305, 17, textureX, textureY); // Box 13
		body[14] = new ModelRendererTurbo(this, 177, 41, textureX, textureY); // Box 14
		body[15] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 15
		body[16] = new ModelRendererTurbo(this, 177, 1, textureX, textureY); // Box 16
		body[17] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Box 17
		body[18] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Box 20
		body[19] = new ModelRendererTurbo(this, 449, 1, textureX, textureY); // Box 22
		body[20] = new ModelRendererTurbo(this, 297, 17, textureX, textureY); // Box 24
		body[21] = new ModelRendererTurbo(this, 345, 17, textureX, textureY); // Box 25
		body[22] = new ModelRendererTurbo(this, 401, 17, textureX, textureY); // Box 26
		body[23] = new ModelRendererTurbo(this, 433, 17, textureX, textureY); // Box 27
		body[24] = new ModelRendererTurbo(this, 481, 17, textureX, textureY); // Box 28
		body[25] = new ModelRendererTurbo(this, 249, 41, textureX, textureY); // Box 29
		body[26] = new ModelRendererTurbo(this, 25, 17, textureX, textureY); // Box 32
		body[27] = new ModelRendererTurbo(this, 321, 17, textureX, textureY); // Box 33
		body[28] = new ModelRendererTurbo(this, 377, 17, textureX, textureY); // Box 34
		body[29] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 35
		body[30] = new ModelRendererTurbo(this, 225, 1, textureX, textureY); // Box 36
		body[31] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 37
		body[32] = new ModelRendererTurbo(this, 217, 81, textureX, textureY); // Box 38
		body[33] = new ModelRendererTurbo(this, 417, 57, textureX, textureY); // Box 39
		body[34] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 40
		body[35] = new ModelRendererTurbo(this, 345, 25, textureX, textureY); // Box 41

		body[0].addBox(0F, 0F, 0F, 40, 2, 36, 0F); // Box 0
		body[0].setRotationPoint(-20F, 5F, -18F);

		body[1].addBox(0F, 0F, 0F, 4, 2, 36, 0F); // Box 1
		body[1].setRotationPoint(-36F, 5F, -18F);

		body[2].addShapeBox(0F, 0F, 0F, 4, 2, 36, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F); // Box 2
		body[2].setRotationPoint(32F, 5F, -18F);

		body[3].addBox(0F, 0F, 0F, 12, 2, 24, 0F); // Box 3
		body[3].setRotationPoint(20F, 5F, -12F);

		body[4].addBox(0F, 0F, 0F, 12, 2, 24, 0F); // Box 4
		body[4].setRotationPoint(-32F, 5F, -12F);

		body[5].addBox(-4F, -4F, 0F, 8, 8, 4, 0F); // Box 5
		body[5].setRotationPoint(26F, 6F, 13F);

		body[6].addBox(-4F, -4F, 0F, 8, 8, 4, 0F); // Box 6
		body[6].setRotationPoint(-26F, 6F, 13F);

		body[7].addBox(-4F, -4F, -4F, 8, 8, 4, 0F); // Box 7
		body[7].setRotationPoint(-26F, 6F, -13F);

		body[8].addBox(-4F, -4F, -4F, 8, 8, 4, 0F); // Box 8
		body[8].setRotationPoint(26F, 6F, -13F);

		body[9].addShapeBox(0F, 0F, 0F, 3, 7, 36, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F); // Box 9
		body[9].setRotationPoint(32F, -2F, -18F);

		body[10].addBox(0F, 0F, 0F, 3, 8, 36, 0F); // Box 10
		body[10].setRotationPoint(-35F, -3F, -18F);

		body[11].addBox(0F, 0F, 0F, 10, 1, 32, 0F); // Box 11
		body[11].setRotationPoint(1F, 4F, -16F);

		body[12].addBox(0F, 0F, 0F, 10, 1, 32, 0F); // Box 12
		body[12].setRotationPoint(-17F, 4F, -16F);

		body[13].addBox(0F, 0F, 0F, 2, 12, 32, 0F); // Box 13
		body[13].setRotationPoint(-19F, -8F, -16F);

		body[14].addBox(0F, 0F, 0F, 2, 12, 32, 0F); // Box 14
		body[14].setRotationPoint(-1F, -8F, -16F);

		body[15].addBox(0F, 0F, 0F, 8, 8, 1, 0F); // Box 15
		body[15].setRotationPoint(-20F, -3F, -18F);

		body[16].addBox(0F, 0F, 0F, 8, 8, 1, 0F); // Box 16
		body[16].setRotationPoint(-2F, -3F, -18F);

		body[17].addBox(0F, 0F, 0F, 4, 8, 1, 0F); // Box 17
		body[17].setRotationPoint(16F, -3F, -18F);

		body[18].addBox(0F, 0F, 0F, 4, 8, 1, 0F); // Box 20
		body[18].setRotationPoint(16F, -3F, 17F);

		body[19].addBox(0F, 0F, 0F, 8, 8, 1, 0F); // Box 22
		body[19].setRotationPoint(-2F, -3F, 17F);

		body[20].addBox(0F, 0F, 0F, 8, 8, 1, 0F); // Box 24
		body[20].setRotationPoint(-20F, -3F, 17F);

		body[21].addBox(0F, 0F, 0F, 12, 4, 1, 0F); // Box 25
		body[21].setRotationPoint(-32F, -3F, 17F);

		body[22].addBox(0F, 0F, 0F, 12, 4, 1, 0F); // Box 26
		body[22].setRotationPoint(-32F, -3F, -18F);

		body[23].addBox(0F, 0F, 0F, 12, 4, 1, 0F); // Box 27
		body[23].setRotationPoint(20F, -3F, -18F);

		body[24].addBox(0F, 0F, 0F, 12, 4, 1, 0F); // Box 28
		body[24].setRotationPoint(20F, -3F, 17F);

		body[25].addShapeBox(0F, 0F, 0F, 3, 2, 36, 0F, 0F, 0F, 0F, 0F, -1F, -2F, 0F, -1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F); // Box 29
		body[25].setRotationPoint(32F, -4F, -18F);

		body[26].addBox(0F, 0F, 0F, 3, 12, 1, 0F); // Box 32
		body[26].setRotationPoint(-20F, -15F, 17F);

		body[27].addBox(0F, 0F, 0F, 3, 12, 1, 0F); // Box 33
		body[27].setRotationPoint(-20F, -15F, -18F);

		body[28].addBox(0F, 0F, 0F, 3, 12, 1, 0F); // Box 34
		body[28].setRotationPoint(-2F, -15F, -18F);

		body[29].addBox(0F, 0F, 0F, 3, 12, 1, 0F); // Box 35
		body[29].setRotationPoint(-2F, -15F, 17F);

		body[30].addShapeBox(0F, 0F, 0F, 2, 12, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F); // Box 36
		body[30].setRotationPoint(11F, -15F, -18F);

		body[31].addShapeBox(0F, 0F, 0F, 2, 12, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F); // Box 37
		body[31].setRotationPoint(11F, -15F, 17F);

		body[32].addBox(0F, 0F, 0F, 34, 1, 36, 0F); // Box 38
		body[32].setRotationPoint(-20F, -16F, -18F);

		body[33].addBox(0F, 0F, 0F, 2, 8, 34, 0F); // Box 39
		body[33].setRotationPoint(16F, -3F, -17F);

		body[34].addBox(0F, -1F, -1F, 2, 2, 2, 0F); // Box 40
		body[34].setRotationPoint(14F, -3F, 8F);

		body[35].addBox(0F, -2.5F, -2.5F, 1, 5, 5, 0F); // Box 41
		body[35].setRotationPoint(13F, -3F, 8F);


		front = new ModelRendererTurbo[1];
		front[0] = new ModelRendererTurbo(this, 345, 49, textureX, textureY); // Box 30

		front[0].addBox(0F, 0F, 0F, 16, 1, 36, 0F); // Box 30
		front[0].setRotationPoint(16F, -4F, -18F);


		lfront = new ModelRendererTurbo[1];
		lfront[0] = new ModelRendererTurbo(this, 481, 1, textureX, textureY); // Box 21

		lfront[0].addBox(-10F, 0F, 0F, 10, 8, 1, 0F); // Box 21
		lfront[0].setRotationPoint(16F, -3F, 17F);


		rfront = new ModelRendererTurbo[1];
		rfront[0] = new ModelRendererTurbo(this, 425, 1, textureX, textureY); // Box 19

		rfront[0].addBox(-10F, 0F, -1F, 10, 8, 1, 0F); // Box 19
		rfront[0].setRotationPoint(16F, -3F, -17F);


		lback = new ModelRendererTurbo[1];
		lback[0] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 23

		lback[0].addBox(-10F, 0F, 0F, 10, 8, 1, 0F); // Box 23
		lback[0].setRotationPoint(-2F, -3F, 17F);


		rback = new ModelRendererTurbo[1];
		rback[0] = new ModelRendererTurbo(this, 401, 1, textureX, textureY); // Box 18

		rback[0].addBox(-10F, 0F, 0F, 10, 8, 1, 0F); // Box 18
		rback[0].setRotationPoint(-2F, -3F, -18F);


		back = new ModelRendererTurbo[1];
		back[0] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 31

		back[0].addShapeBox(-16F, 0F, 0F, 16, 1, 36, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 31
		back[0].setRotationPoint(-20F, -4F, -18F);
		
		translateAll(0F, 0F, 0F);
		
	}
	
	@Override
	public void render(VehicleType data){
		render(body);
		if(data.scripts.contains("generic-multidoor")){
			MultiDoorScript mds = (MultiDoorScript)data.scripts.get("generic-multidoor");
			//
			rotate(front, 0, 0, mds.front ? -0.785398f : 0);
			render(front);
			//
			rotate(back, 0, 0, mds.back ? 1.0472f : 0);
			render(back);
			//
			rotate(lfront, 0, mds.lf ? 1.0472f : 0, 0);
			render(lfront);
			//
			rotate(rfront, 0, mds.rf ? -1.0472f : 0, 0);
			render(rfront);
			//
			rotate(lback, 0, mds.lb ? 1.0472f : 0, 0);
			render(lback);
			//
			rotate(rback, 0, mds.rb ? -1.0472f : 0, 0);
			render(rback);
			//
		}
	}
}