// Date: 26.02.2015 23:36:54

package net.fexcraft.mod.frsm.blocks.chair;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class OfficechairModel extends ModelBase{
	
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
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
  
  public OfficechairModel(){
    textureWidth = 128;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 5);
      Shape1.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape1.setRotationPoint(5F, 23F, -6F);
      Shape1.setTextureSize(128, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 5);
      Shape2.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape2.setRotationPoint(-6F, 23F, 5F);
      Shape2.setTextureSize(128, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 5);
      Shape3.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape3.setRotationPoint(5F, 23F, 5F);
      Shape3.setTextureSize(128, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 5);
      Shape4.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape4.setRotationPoint(-6F, 23F, -6F);
      Shape4.setTextureSize(128, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 0);
      Shape5.addBox(0F, 0F, 0F, 17, 1, 3);
      Shape5.setRotationPoint(-7F, 22F, 5F);
      Shape5.setTextureSize(128, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0.7853982F, 0F);
      Shape6 = new ModelRenderer(this, 0, 0);
      Shape6.addBox(0F, 0F, 0F, 17, 1, 3);
      Shape6.setRotationPoint(-5F, 22F, -7F);
      Shape6.setTextureSize(128, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, -0.7853982F, 0F);
      Shape7 = new ModelRenderer(this, 0, 5);
      Shape7.addBox(0F, 0F, 0F, 8, 2, 8);
      Shape7.setRotationPoint(-4F, 21F, -4F);
      Shape7.setTextureSize(128, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 33, 5);
      Shape8.addBox(0F, 0F, 0F, 2, 6, 2);
      Shape8.setRotationPoint(-1F, 15F, -1F);
      Shape8.setTextureSize(128, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 53, 25);
      Shape9.addBox(0F, 0F, 0F, 6, 1, 6);
      Shape9.setRotationPoint(-3F, 14F, -3F);
      Shape9.setTextureSize(128, 32);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 0, 21);
      Shape10.addBox(0F, 0F, 0F, 10, 1, 10);
      Shape10.setRotationPoint(-5F, 13F, -6F);
      Shape10.setTextureSize(128, 32);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 26, 0);
      Shape11.addBox(0F, 0F, 0F, 10, 1, 16);
      Shape11.setRotationPoint(-5F, 13F, 4F);
      Shape11.setTextureSize(128, 32);
      Shape11.mirror = true;
      setRotation(Shape11, 1.396263F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 35, 18);
      Shape12.addBox(0F, 0F, 0F, 1, 6, 2);
      Shape12.setRotationPoint(-6F, 8F, -2F);
      Shape12.setTextureSize(128, 32);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 35, 18);
      Shape13.addBox(0F, 0F, 0F, 1, 6, 2);
      Shape13.setRotationPoint(5F, 8F, -2F);
      Shape13.setTextureSize(128, 32);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0F, 0F);
      Shape14 = new ModelRenderer(this, 32, 18);
      Shape14.addBox(0F, 0F, 0F, 2, 1, 11);
      Shape14.setRotationPoint(-6.5F, 7F, -5F);
      Shape14.setTextureSize(128, 32);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0F, 0F);
      Shape15 = new ModelRenderer(this, 32, 18);
      Shape15.addBox(0F, 0F, 0F, 2, 1, 11);
      Shape15.setRotationPoint(4.5F, 7F, -5F);
      Shape15.setTextureSize(128, 32);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 0F, 0F);
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
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);
    Shape15.render(f5);
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
