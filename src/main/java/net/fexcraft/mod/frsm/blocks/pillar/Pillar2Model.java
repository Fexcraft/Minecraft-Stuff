// Date: 25.02.2015 17:33:26

package net.fexcraft.mod.frsm.blocks.pillar;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Pillar2Model extends ModelBase{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape9;
    ModelRenderer Shape13;
  
  public Pillar2Model(){
    textureWidth = 128;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 2, 12, 4);
      Shape1.setRotationPoint(-4F, 12F, -2F);
      Shape1.setTextureSize(128, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 2, 12, 4);
      Shape2.setRotationPoint(2F, 12F, -2F);
      Shape2.setTextureSize(128, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 13, 0);
      Shape3.addBox(0F, 0F, 0F, 4, 12, 2);
      Shape3.setRotationPoint(-2F, 12F, -4F);
      Shape3.setTextureSize(128, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 13, 0);
      Shape4.addBox(0F, 0F, 0F, 4, 12, 2);
      Shape4.setRotationPoint(-2F, 12F, 2F);
      Shape4.setTextureSize(128, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 26, 0);
      Shape5.addBox(0F, 0F, 0F, 3, 12, 2);
      Shape5.setRotationPoint(1.8F, 12F, -3.9F);
      Shape5.setTextureSize(128, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, -0.7853982F, 0F);
      Shape6 = new ModelRenderer(this, 37, 0);
      Shape6.addBox(0F, 0F, 0F, 2, 12, 3);
      Shape6.setRotationPoint(-1.8F, 12F, -3.9F);
      Shape6.setTextureSize(128, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, -0.7853982F, 0F);
      Shape7 = new ModelRenderer(this, 37, 0);
      Shape7.addBox(0F, 0F, 0F, 2, 12, 3);
      Shape7.setRotationPoint(2.5F, 12F, 0.4F);
      Shape7.setTextureSize(128, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, -0.7853982F, 0F);
      Shape8 = new ModelRenderer(this, 26, 0);
      Shape8.addBox(0F, 0F, 0F, 3, 12, 2);
      Shape8.setRotationPoint(-2.5F, 12F, 0.4F);
      Shape8.setTextureSize(128, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, -0.7853982F, 0F);
      Shape10 = new ModelRenderer(this, 0, 22);
      Shape10.addBox(0F, 0F, 0F, 8, 2, 8);
      Shape10.setRotationPoint(-4F, 10F, -4F);
      Shape10.setTextureSize(128, 32);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 33, 21);
      Shape11.addBox(0F, 0F, 0F, 16, 1, 10);
      Shape11.setRotationPoint(-8F, 8F, -5F);
      Shape11.setTextureSize(128, 32);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 86, 23);
      Shape12.addBox(0F, 0F, 0F, 4, 1, 8);
      Shape12.setRotationPoint(-6F, 8F, -4F);
      Shape12.setTextureSize(128, 32);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0.7853982F);
      Shape9 = new ModelRenderer(this, 86, 23);
      Shape9.addBox(0F, 0F, 0F, 4, 1, 8);
      Shape9.setRotationPoint(6F, 8F, 4F);
      Shape9.setTextureSize(128, 32);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 3.141593F, -0.7853982F);
      Shape13 = new ModelRenderer(this, 86, 13);
      Shape13.addBox(0F, 0F, 0F, 10, 1, 8);
      Shape13.setRotationPoint(-5F, 9F, -4F);
      Shape13.setTextureSize(128, 32);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0F, 0F);
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
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape9.render(f5);
    Shape13.render(f5);
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
