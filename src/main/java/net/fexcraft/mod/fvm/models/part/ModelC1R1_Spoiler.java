//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: C1R1_Spoiler
// Model Creator: FEX___96
// Created on: 13.03.2017 - 13:31:14
// Last changed on: 13.03.2017 - 13:31:14

package net.fexcraft.mod.fvm.models.part;

import net.fexcraft.mod.fvm.data.VehicleType;
import net.fexcraft.mod.fvm.models.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelC1R1_Spoiler extends PartModel {
	
	int textureX = 128;
	int textureY = 32;

	public ModelC1R1_Spoiler(){
		this.creators.add("Ferdinand (FEX___96)");
		bodyColoredSecondary = new ModelRendererTurbo[5];
		bodyColoredSecondary[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		bodyColoredSecondary[1] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 1
		bodyColoredSecondary[2] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 2
		bodyColoredSecondary[3] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 3
		bodyColoredSecondary[4] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 4

		bodyColoredSecondary[0].addShapeBox(-24F, -3F, 0F, 3, 4, 1, 0F, 0.5F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 0
		bodyColoredSecondary[0].setRotationPoint(-30.5F, -12.5F, 10F);

		bodyColoredSecondary[1].addShapeBox(-24F, -3F, 0F, 3, 4, 1, 0F, 0.5F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 1
		bodyColoredSecondary[1].setRotationPoint(-30.5F, -12.5F, -11F);

		bodyColoredSecondary[2].addShapeBox(-25F, -4F, -14F, 5, 1, 28, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 2
		bodyColoredSecondary[2].setRotationPoint(-31.5F, -12.5F, 0F);

		bodyColoredSecondary[3].addShapeBox(-25F, -4F, -17F, 5, 1, 3, 0F, 0F, 0.5F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 3
		bodyColoredSecondary[3].setRotationPoint(-31.5F, -12.5F, 0F);

		bodyColoredSecondary[4].addShapeBox(-25F, -4F, 14F, 5, 1, 3, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 4
		bodyColoredSecondary[4].setRotationPoint(-31.5F, -12.5F, 0F);
		
		translateAll(0F, 0F, 0F);
	}
	
	@Override
	public void render(VehicleType data, String us){
		if(us.equals("rear_spoiler")){
			data.secondaryColor.glColorApply();
			if(data.doors){
				rotate(bodyColoredSecondary, 0, 0, 1.04719755F);
				render(bodyColoredSecondary);
			}
			else{
				rotate(bodyColoredSecondary, 0, 0, 0);
				render(bodyColoredSecondary);
			}
			data.secondaryColor.glColorReset();
		}
		
	}
	
	@Override
	public void render(VehicleType data, String us, com.flansmod.fvm.LandVehicle vehicle){
		if(us.equals("rear_spoiler")){
			data.secondaryColor.glColorApply();
			if(data.doors){
				rotate(bodyColoredSecondary, 0, 0, 1.04719755F);
				render(bodyColoredSecondary);
			}
			else{
				rotate(bodyColoredSecondary, 0, 0, 0);
				render(bodyColoredSecondary);
			}
			data.secondaryColor.glColorReset();
		}
		
	}
	
}