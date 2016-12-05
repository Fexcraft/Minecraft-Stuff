// Date: 26.02.2015 15:56:30

package net.fexcraft.mod.frsm.entities.LRR1;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class LRR1 extends ModelBase{
	
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
  
  public LRR1(){
    textureWidth = 64;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 5);
      Shape1.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape1.setRotationPoint(5F, 23F, -6F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 5);
      Shape2.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape2.setRotationPoint(5F, 23F, 5F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 5);
      Shape3.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape3.setRotationPoint(-6F, 23F, 5F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 5);
      Shape4.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape4.setRotationPoint(-6F, 23F, -6F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 0);
      Shape5.addBox(0F, 0F, 0F, 20, 1, 3);
      Shape5.setRotationPoint(-6F, 22F, -8F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, -0.7853982F, 0F);
      Shape6 = new ModelRenderer(this, 0, 0);
      Shape6.addBox(0F, 0F, 0F, 20, 1, 3);
      Shape6.setRotationPoint(-8F, 22F, 6F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0.7853982F, 0F);
      Shape7 = new ModelRenderer(this, 0, 5);
      Shape7.addBox(0F, 0F, 0F, 8, 3, 8);
      Shape7.setRotationPoint(-4F, 20F, -4F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 17);
      Shape8.addBox(0F, 0F, 0F, 6, 2, 3);
      Shape8.setRotationPoint(-3F, 18F, 0F);
      Shape8.setTextureSize(64, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 19, 17);
      Shape9.addBox(0F, 0F, 0F, 2, 2, 5);
      Shape9.setRotationPoint(0F, 19.7F, 0F);
      Shape9.setTextureSize(64, 32);
      Shape9.mirror = true;
      setRotation(Shape9, 2.792527F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 0, 23);
      Shape10.addBox(0F, 0F, 0F, 2, 2, 4);
      Shape10.setRotationPoint(-2.5F, 20F, -3F);
      Shape10.setTextureSize(64, 32);
      Shape10.mirror = true;
      setRotation(Shape10, 0.5235988F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 34, 5);
      Shape11.addBox(0F, 0F, 0F, 1, 1, 12);
      Shape11.setRotationPoint(0.5F, 19.7F, 1F);
      Shape11.setTextureSize(64, 32);
      Shape11.mirror = true;
      setRotation(Shape11, 2.792527F, 0F, 0F);
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
    Shape10.render(f5);
    Shape11.render(f5);
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
