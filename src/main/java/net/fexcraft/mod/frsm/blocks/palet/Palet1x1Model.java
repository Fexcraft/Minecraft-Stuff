//This File was created with the Minecraft-SMP Modelling Toolbox 2.2.1.1
// Copyright (C) 2015 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

package net.fexcraft.mod.frsm.blocks.palet;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Palet1x1Model extends ModelBase{
	ModelRenderer Box_0;
	ModelRenderer Box_1;
	ModelRenderer Box_2;
	ModelRenderer Box_3;
	ModelRenderer Box_4;
	ModelRenderer Box_5;
	ModelRenderer Box_6;
	ModelRenderer Box_7;
	ModelRenderer Box_8;
	ModelRenderer Box_9;
	ModelRenderer Box_10;
	ModelRenderer Box_11;
	ModelRenderer Box_12;
	ModelRenderer Box_13;
	ModelRenderer Box_14;
	ModelRenderer Box_15;
	ModelRenderer Box_16;

	public Palet1x1Model(){
		textureWidth = 128;
		textureHeight = 128;

		Box_0 = new ModelRenderer(this, 1, 1);
		Box_0.addBox(0F, 0F, 0F, 3, 1, 16);
		Box_0.setRotationPoint(5F, 23F, -8F);
		Box_0.setTextureSize(128, 128);
		Box_0.mirror = true;
		setRotation(Box_0, 0F, 0F, 0F);
		Box_1 = new ModelRenderer(this, 41, 1);
		Box_1.addBox(0F, 0F, 0F, 3, 1, 16);
		Box_1.setRotationPoint(-8F, 23F, -8F);
		Box_1.setTextureSize(128, 128);
		Box_1.mirror = true;
		setRotation(Box_1, 0F, 0F, 0F);
		Box_2 = new ModelRenderer(this, 81, 1);
		Box_2.addBox(0F, 0F, 0F, 3, 1, 16);
		Box_2.setRotationPoint(-1.5F, 23F, -8F);
		Box_2.setTextureSize(128, 128);
		Box_2.mirror = true;
		setRotation(Box_2, 0F, 0F, 0F);
		Box_3 = new ModelRenderer(this, 1, 1);
		Box_3.addBox(0F, 0F, 0F, 3, 2, 3);
		Box_3.setRotationPoint(-8F, 21F, -8F);
		Box_3.setTextureSize(128, 128);
		Box_3.mirror = true;
		setRotation(Box_3, 0F, 0F, 0F);
		Box_4 = new ModelRenderer(this, 25, 1);
		Box_4.addBox(0F, 0F, 0F, 3, 2, 3);
		Box_4.setRotationPoint(-1.5F, 21F, -8F);
		Box_4.setTextureSize(128, 128);
		Box_4.mirror = true;
		setRotation(Box_4, 0F, 0F, 0F);
		Box_5 = new ModelRenderer(this, 41, 1);
		Box_5.addBox(0F, 0F, 0F, 3, 2, 3);
		Box_5.setRotationPoint(5F, 21F, -8F);
		Box_5.setTextureSize(128, 128);
		Box_5.mirror = true;
		setRotation(Box_5, 0F, 0F, 0F);
		Box_6 = new ModelRenderer(this, 65, 1);
		Box_6.addBox(0F, 0F, 0F, 3, 2, 3);
		Box_6.setRotationPoint(-8F, 21F, 5F);
		Box_6.setTextureSize(128, 128);
		Box_6.mirror = true;
		setRotation(Box_6, 0F, 0F, 0F);
		Box_7 = new ModelRenderer(this, 81, 1);
		Box_7.addBox(0F, 0F, 0F, 3, 2, 3);
		Box_7.setRotationPoint(5F, 21F, 5F);
		Box_7.setTextureSize(128, 128);
		Box_7.mirror = true;
		setRotation(Box_7, 0F, 0F, 0F);
		Box_8 = new ModelRenderer(this, 105, 1);
		Box_8.addBox(0F, 0F, 0F, 3, 2, 3);
		Box_8.setRotationPoint(-1.5F, 21F, 5F);
		Box_8.setTextureSize(128, 128);
		Box_8.mirror = true;
		setRotation(Box_8, 0F, 0F, 0F);
		Box_9 = new ModelRenderer(this, 1, 25);
		Box_9.addBox(0F, 0F, 0F, 16, 1, 3);
		Box_9.setRotationPoint(-8F, 20F, -8F);
		Box_9.setTextureSize(128, 128);
		Box_9.mirror = true;
		setRotation(Box_9, 0F, 0F, 0F);
		Box_10 = new ModelRenderer(this, 41, 25);
		Box_10.addBox(0F, 0F, 0F, 16, 1, 3);
		Box_10.setRotationPoint(-8F, 20F, 5F);
		Box_10.setTextureSize(128, 128);
		Box_10.mirror = true;
		setRotation(Box_10, 0F, 0F, 0F);
		Box_11 = new ModelRenderer(this, 65, 25);
		Box_11.addBox(0F, 0F, 0F, 2, 1, 16);
		Box_11.setRotationPoint(-8F, 19F, -8F);
		Box_11.setTextureSize(128, 128);
		Box_11.mirror = true;
		setRotation(Box_11, 0F, 0F, 0F);
		Box_12 = new ModelRenderer(this, 1, 33);
		Box_12.addBox(0F, 0F, 0F, 2, 1, 16);
		Box_12.setRotationPoint(-5.5F, 19F, -8F);
		Box_12.setTextureSize(128, 128);
		Box_12.mirror = true;
		setRotation(Box_12, 0F, 0F, 0F);
		Box_13 = new ModelRenderer(this, 41, 33);
		Box_13.addBox(0F, 0F, 0F, 2, 1, 16);
		Box_13.setRotationPoint(6F, 19F, -8F);
		Box_13.setTextureSize(128, 128);
		Box_13.mirror = true;
		setRotation(Box_13, 0F, 0F, 0F);
		Box_14 = new ModelRenderer(this, 89, 33);
		Box_14.addBox(0F, 0F, 0F, 2, 1, 16);
		Box_14.setRotationPoint(3.5F, 19F, -8F);
		Box_14.setTextureSize(128, 128);
		Box_14.mirror = true;
		setRotation(Box_14, 0F, 0F, 0F);
		Box_15 = new ModelRenderer(this, 65, 49);
		Box_15.addBox(0F, 0F, 0F, 2, 1, 16);
		Box_15.setRotationPoint(0.5F, 19F, -8F);
		Box_15.setTextureSize(128, 128);
		Box_15.mirror = true;
		setRotation(Box_15, 0F, 0F, 0F);
		Box_16 = new ModelRenderer(this, 1, 57);
		Box_16.addBox(0F, 0F, 0F, 2, 1, 16);
		Box_16.setRotationPoint(-2.5F, 19F, -8F);
		Box_16.setTextureSize(128, 128);
		Box_16.mirror = true;
		setRotation(Box_16, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5){
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Box_0.render(f5);
		Box_1.render(f5);
		Box_2.render(f5);
		Box_3.render(f5);
		Box_4.render(f5);
		Box_5.render(f5);
		Box_6.render(f5);
		Box_7.render(f5);
		Box_8.render(f5);
		Box_9.render(f5);
		Box_10.render(f5);
		Box_11.render(f5);
		Box_12.render(f5);
		Box_13.render(f5);
		Box_14.render(f5);
		Box_15.render(f5);
		Box_16.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z){
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5){
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
	}

}
