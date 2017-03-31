//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2016 Minecraft-SMP.de
// This file is for Fex's Vehicle Mod

// Model: T1(P)
// Model Creator: FEX___96
// Created on: 20.01.2016 - 22:15:40
// Last changed on: 20.01.2016 - 22:15:40

package net.fexcraft.mod.fvm.models;

import net.fexcraft.mod.fvm.data.PartType;
import net.fexcraft.mod.fvm.data.VehicleType;
import net.fexcraft.mod.fvm.models.PartModel;
import net.minecraft.util.math.Vec3d;

public class NullModel extends PartModel {
	
	int textureX = 512;
	int textureY = 512;
	
	private static final NullModel nullmodel = new NullModel();

	public NullModel(){}
	
	@Override
	public void render(){
		return;
	}
	
	@Override
	public void render(VehicleType data, String usedAs){
		return;
	}
	
	@Override
	public void render(VehicleType data, String usedAS, com.flansmod.fvm.LandVehicle vehicle){
		if(vehicle.throttle != 0 && data.parts.get(usedAS).pspawners != null){
			PartType part = data.parts.get(usedAS);
			for(int i = 0; i < part.pspawners.length; i++){
				Vec3d vec = calculatePos(vehicle, part.pspawners[i].pos);
				vehicle.world.spawnParticle(part.pspawners[i].type, vec.xCoord, vec.yCoord, vec.zCoord, part.pspawners[i].sx, part.pspawners[i].sy, part.pspawners[i].sz);
			}
		}
		return;
	}

	public static PartModel get(){
		return nullmodel;
	}
	
}