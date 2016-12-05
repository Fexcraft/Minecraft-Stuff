package net.fexcraft.mod.frsm.blocks.printer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PrinterModel extends ModelBase{
	
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    
    public PrinterModel(){
	    textureWidth = 128;
	    textureHeight = 32;
	    
	    Shape1 = new ModelRenderer(this, 0, 21);
	    Shape1.addBox(0F, 0F, 0F, 12, 1, 10);
	    Shape1.setRotationPoint(-5F, 23F, -5F);
	    Shape1.setTextureSize(128, 32);
	    Shape1.mirror = true;
	    setRotation(Shape1, 0F, 0F, 0F);
	    Shape2 = new ModelRenderer(this, 70, 19);
	    Shape2.addBox(0F, 0F, 0F, 2, 3, 10);
	    Shape2.setRotationPoint(-5F, 20F, -5F);
	    Shape2.setTextureSize(128, 32);
	    Shape2.mirror = true;
	    setRotation(Shape2, 0F, 0F, 0F);
	    Shape3 = new ModelRenderer(this, 45, 19);
	    Shape3.addBox(0F, 0F, 0F, 2, 3, 10);
	    Shape3.setRotationPoint(5F, 20F, -5F);
	    Shape3.setTextureSize(128, 32);
	    Shape3.mirror = true;
	    setRotation(Shape3, 0F, 0F, 0F);
	    Shape4 = new ModelRenderer(this, 32, 17);
	    Shape4.addBox(0F, 0F, 0F, 2, 1, 2);
	    Shape4.setRotationPoint(-5F, 20F, -1F);
	    Shape4.setTextureSize(128, 32);
	    Shape4.mirror = true;
	    setRotation(Shape4, 0.5576792F, 0F, 0F);
	    Shape5 = new ModelRenderer(this, 0, 10);
	    Shape5.addBox(0F, 0F, 0F, 8, 1, 1);
	    Shape5.setRotationPoint(-3F, 22F, 4F);
	    Shape5.setTextureSize(128, 32);
	    Shape5.mirror = true;
	    setRotation(Shape5, 0F, 0F, 0F);
	    Shape6 = new ModelRenderer(this, 45, 13);
	    Shape6.addBox(0F, 0F, 0F, 6, 1, 4);
	    Shape6.setRotationPoint(-2F, 24F, -5F);
	    Shape6.setTextureSize(128, 32);
	    Shape6.mirror = true;
	    setRotation(Shape6, 2.862753F, 0F, 0F);
	    Shape7 = new ModelRenderer(this, 0, 12);
	    Shape7.addBox(0F, 0F, 0F, 8, 1, 7);
	    Shape7.setRotationPoint(-3F, 21F, -4F);
	    Shape7.setTextureSize(128, 32);
	    Shape7.mirror = true;
	    setRotation(Shape7, 0F, 0F, 0F);
	    Shape8 = new ModelRenderer(this, 0, 0);
	    Shape8.addBox(0F, 0F, 0F, 8, 1, 8);
	    Shape8.setRotationPoint(-3F, 20F, -5F);
	    Shape8.setTextureSize(128, 32);
	    Shape8.mirror = true;
	    setRotation(Shape8, 0F, 0F, 0F);
	    Shape9 = new ModelRenderer(this, 53, 0);
	    Shape9.addBox(0F, 0F, 0F, 8, 1, 8);
	    Shape9.setRotationPoint(-3F, 23F, 3F);
	    Shape9.setTextureSize(128, 32);
	    Shape9.mirror = true;
	    setRotation(Shape9, 1.041001F, 0F, 0F);
    }
    
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5){
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5);
	    Shape1.render(f5);
	    Shape2.render(f5);
	    Shape3.render(f5);
	    Shape4.render(f5);
	    Shape5.render(f5);
	    Shape6.render(f5);
	    Shape7.render(f5);
	    Shape8.render(f5);
	    Shape9.render(f5);
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
