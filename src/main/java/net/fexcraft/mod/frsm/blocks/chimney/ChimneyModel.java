// Date: 27.03.2015 15:12:53

package net.fexcraft.mod.frsm.blocks.chimney;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ChimneyModel extends ModelBase{
	
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
  
  public ChimneyModel(){
    textureWidth = 128;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 16, 10, 16);
      Shape1.setRotationPoint(-8F, 14F, -8F);
      Shape1.setTextureSize(128, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 63, 0);
      Shape2.addBox(0F, 0F, 0F, 12, 4, 4);
      Shape2.setRotationPoint(-8F, 10F, -8F);
      Shape2.setTextureSize(128, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 96, 0);
      Shape3.addBox(0F, 0F, 0F, 12, 4, 4);
      Shape3.setRotationPoint(-4F, 10F, 4F);
      Shape3.setTextureSize(128, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 96, 16);
      Shape4.addBox(0F, 0F, 0F, 4, 4, 12);
      Shape4.setRotationPoint(4F, 10F, -8F);
      Shape4.setTextureSize(128, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 63, 16);
      Shape5.addBox(0F, 0F, 0F, 4, 4, 12);
      Shape5.setRotationPoint(-8F, 10F, -4F);
      Shape5.setTextureSize(128, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 27);
      Shape6.addBox(0F, 0F, 0F, 12, 1, 5);
      Shape6.setRotationPoint(-3.5F, 9F, 3.5F);
      Shape6.setTextureSize(128, 64);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 34);
      Shape7.addBox(0F, 0F, 0F, 12, 1, 5);
      Shape7.setRotationPoint(-8.5F, 9F, -8.5F);
      Shape7.setTextureSize(128, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 41);
      Shape8.addBox(0F, 0F, 0F, 5, 1, 12);
      Shape8.setRotationPoint(-8.5F, 9F, -3.5F);
      Shape8.setTextureSize(128, 64);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 35, 41);
      Shape9.addBox(0F, 0F, 0F, 5, 1, 12);
      Shape9.setRotationPoint(3.5F, 9F, -8.5F);
      Shape9.setTextureSize(128, 64);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
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
