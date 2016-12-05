package net.fexcraft.mod.frsm.blocks.pchardware;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class pchardware1Model extends ModelBase{

    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;

    public pchardware1Model(){
    	textureWidth = 64;
    	textureHeight = 32;

	    Shape1 = new ModelRenderer(this, 0, 0);
	    Shape1.addBox(0F, 0F, 0F, 5, 12, 12);
	    Shape1.setRotationPoint(-8F, 12F, -5F);
	    Shape1.setTextureSize(64, 32);
	    Shape1.mirror = true;
	    setRotation(Shape1, 0F, 0F, 0F);
	    Shape2 = new ModelRenderer(this, 0, 25);
	    Shape2.addBox(0F, 0F, 0F, 5, 6, 1);
	    Shape2.setRotationPoint(-8F, 18F, -6F);
	    Shape2.setTextureSize(64, 32);
	    Shape2.mirror = true;
	    setRotation(Shape2, 0F, 0F, 0F);
	    Shape3 = new ModelRenderer(this, 13, 25);
	    Shape3.addBox(0F, 0F, 0F, 5, 2, 1);
	    Shape3.setRotationPoint(-8F, 17F, -4F);
	    Shape3.setTextureSize(64, 32);
	    Shape3.mirror = true;
	    setRotation(Shape3, -1.029744F, 0F, 0F);
	    Shape4 = new ModelRenderer(this, 14, 30);
	    Shape4.addBox(0F, 0F, 0F, 1, 1, 1);
	    Shape4.setRotationPoint(-7F, 16F, 7F);
	    Shape4.setTextureSize(64, 32);
	    Shape4.mirror = true;
	    setRotation(Shape4, 0F, 0F, 0F);
	    Shape5 = new ModelRenderer(this, 20, 30);
	    Shape5.addBox(0F, 0F, 0F, 1, 1, 1);
	    Shape5.setRotationPoint(-5F, 16F, 7F);
	    Shape5.setTextureSize(64, 32);
	    Shape5.mirror = true;
	    setRotation(Shape5, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5){
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5);
	    Shape1.render(f5);
	    Shape2.render(f5);
	    Shape3.render(f5);
	    Shape4.render(f5);
	    Shape5.render(f5);
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
