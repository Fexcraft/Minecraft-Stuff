// Date: 13.03.2015 10:25:07

package net.fexcraft.mod.frsm.blocks.RCT;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class RCTModel extends ModelBase{
	
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
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer Shape18;
    ModelRenderer Shape19;
  
  public RCTModel(){
    textureWidth = 128;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 14, 5, 14);
      Shape1.setRotationPoint(-7F, 12F, -7F);
      Shape1.setTextureSize(128, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 20);
      Shape2.addBox(0F, 0F, 0F, 2, 12, 2);
      Shape2.setRotationPoint(-8F, 12F, -8F);
      Shape2.setTextureSize(128, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 20);
      Shape3.addBox(0F, 0F, 0F, 2, 12, 2);
      Shape3.setRotationPoint(6F, 12F, 6F);
      Shape3.setTextureSize(128, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 20);
      Shape4.addBox(0F, 0F, 0F, 2, 12, 2);
      Shape4.setRotationPoint(6F, 12F, -8F);
      Shape4.setTextureSize(128, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 20);
      Shape5.addBox(0F, 0F, 0F, 2, 12, 2);
      Shape5.setRotationPoint(-8F, 12F, 6F);
      Shape5.setTextureSize(128, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 20);
      Shape6.addBox(0F, 0F, 0F, 16, 4, 16);
      Shape6.setRotationPoint(-8F, 8F, -8F);
      Shape6.setTextureSize(128, 64);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 41);
      Shape7.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape7.setRotationPoint(6.5F, 15F, -4F);
      Shape7.setTextureSize(128, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 45);
      Shape8.addBox(0F, 0F, 0F, 1, 5, 1);
      Shape8.setRotationPoint(7.2F, 14.5F, -3.5F);
      Shape8.setTextureSize(128, 64);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 0, 53);
      Shape9.addBox(0F, 0F, 0F, 1, 1, 3);
      Shape9.setRotationPoint(7.2F, 13.5F, -4.5F);
      Shape9.setTextureSize(128, 64);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 0, 41);
      Shape10.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape10.setRotationPoint(6.5F, 15F, 2F);
      Shape10.setTextureSize(128, 64);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 0, 41);
      Shape11.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape11.setRotationPoint(-8.5F, 15F, -4F);
      Shape11.setTextureSize(128, 64);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 0, 41);
      Shape12.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape12.setRotationPoint(-8.5F, 15F, 3F);
      Shape12.setTextureSize(128, 64);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 11, 41);
      Shape13.addBox(0F, 0F, 0F, 1, 8, 1);
      Shape13.setRotationPoint(-8.2F, 12.5F, 3.5F);
      Shape13.setTextureSize(128, 64);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0F, 0F);
      Shape14 = new ModelRenderer(this, 0, 45);
      Shape14.addBox(0F, 0F, 0F, 1, 6, 1);
      Shape14.setRotationPoint(-8.2F, 14.5F, -3.5F);
      Shape14.setTextureSize(128, 64);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0F, 0F);
      Shape15 = new ModelRenderer(this, 0, 53);
      Shape15.addBox(0F, 0F, 0F, 1, 1, 3);
      Shape15.setRotationPoint(-8.2F, 13.5F, -4F);
      Shape15.setTextureSize(128, 64);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 0F, 0F);
      Shape16 = new ModelRenderer(this, 0, 58);
      Shape16.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape16.setRotationPoint(5F, 7F, 5F);
      Shape16.setTextureSize(128, 64);
      Shape16.mirror = true;
      setRotation(Shape16, 0F, 0.4537856F, 0F);
      Shape17 = new ModelRenderer(this, 0, 58);
      Shape17.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape17.setRotationPoint(2F, 7F, 5F);
      Shape17.setTextureSize(128, 64);
      Shape17.mirror = true;
      setRotation(Shape17, 0F, -0.2443461F, 0F);
      Shape18 = new ModelRenderer(this, 16, 41);
      Shape18.addBox(0F, 0F, 0F, 4, 2, 8);
      Shape18.setRotationPoint(4F, 6F, -2F);
      Shape18.setTextureSize(128, 64);
      Shape18.mirror = true;
      setRotation(Shape18, 0.122173F, 0F, 0F);
      Shape19 = new ModelRenderer(this, 5, 52);
      Shape19.addBox(0F, 0F, 0F, 8, 0, 1);
      Shape19.setRotationPoint(-7F, 7.9F, 6.5F);
      Shape19.setTextureSize(128, 64);
      Shape19.mirror = true;
      setRotation(Shape19, 0F, 0F, 0F);
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
    Shape16.render(f5);
    Shape17.render(f5);
    Shape18.render(f5);
    Shape19.render(f5);
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
