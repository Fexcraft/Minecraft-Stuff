// Date: 18.02.2015 12:08:16

package net.fexcraft.mod.frsm.entities.R2;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class R2HModel extends ModelBase{
	
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape42;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
  
  public R2HModel(){
    textureWidth = 64;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 29, 0);
      Shape1.addBox(0F, 0F, 0F, 1, 3, 10);
      Shape1.setRotationPoint(2F, 21F, -5F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 29, 0);
      Shape2.addBox(0F, 0F, 0F, 1, 3, 10);
      Shape2.setRotationPoint(-3F, 21F, -5F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 2);
      Shape3.addBox(0F, 0F, 0F, 4, 3, 12);
      Shape3.setRotationPoint(-2F, 20F, -6F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, -8, 0);
      Shape4.addBox(0F, 0F, 0F, 1, 0, 10);
      Shape4.setRotationPoint(2F, 20.8F, -5F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape42 = new ModelRenderer(this, -8, 0);
      Shape42.addBox(0F, 0F, 0F, 1, 0, 10);
      Shape42.setRotationPoint(-3F, 20.8F, -5F);
      Shape42.setTextureSize(64, 32);
      Shape42.mirror = true;
      setRotation(Shape42, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 18);
      Shape5.addBox(0F, 0F, 0F, 2, 2, 1);
      Shape5.setRotationPoint(-1F, 20.5F, -7F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 7, 18);
      Shape6.addBox(0F, 0F, 0F, 4, 3, 0);
      Shape6.setRotationPoint(-2F, 20F, -7F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 33, 14);
      Shape7.addBox(0F, 0F, 0F, 3, 1, 6);
      Shape7.setRotationPoint(-1.5F, 19F, -3F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5){
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape42.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
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
