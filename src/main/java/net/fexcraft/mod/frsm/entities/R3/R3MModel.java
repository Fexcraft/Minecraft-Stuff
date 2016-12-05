// Date: 26.02.2015 13:44:38

package net.fexcraft.mod.frsm.entities.R3;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class R3MModel extends ModelBase{
	
    ModelRenderer Shape1n1;
    ModelRenderer Shape1n3;
    ModelRenderer Shape2n1;
    ModelRenderer Shape2n3;
    ModelRenderer Shape3n2;
    ModelRenderer Shape3n4;
    ModelRenderer Shape4n1;
    ModelRenderer Shape4n3;
    ModelRenderer Shape5n1;
    ModelRenderer Shape5n3;
    ModelRenderer Shape5n4;
    ModelRenderer Shape6n2;
    ModelRenderer Shape7;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape14;
    ModelRenderer Shape1;
  
  public R3MModel(){
    textureWidth = 128;
    textureHeight = 64;
    
      Shape1n1 = new ModelRenderer(this, 24, 32);
      Shape1n1.addBox(0F, 0F, 0F, 1, 4, 10);
      Shape1n1.setRotationPoint(3F, 20F, -5F);
      Shape1n1.setTextureSize(128, 64);
      Shape1n1.mirror = true;
      setRotation(Shape1n1, 0F, 0F, 0F);
      Shape1n3 = new ModelRenderer(this, 24, 32);
      Shape1n3.addBox(0F, 0F, 0F, 1, 4, 10);
      Shape1n3.setRotationPoint(-4F, 20F, -5F);
      Shape1n3.setTextureSize(128, 64);
      Shape1n3.mirror = true;
      setRotation(Shape1n3, 0F, 0F, 0F);
      Shape2n1 = new ModelRenderer(this, 49, 3);
      Shape2n1.addBox(0F, 0F, 0F, 1, 1, 13);
      Shape2n1.setRotationPoint(3F, 21.5F, -6.5F);
      Shape2n1.setTextureSize(128, 64);
      Shape2n1.mirror = true;
      setRotation(Shape2n1, 0F, 0F, 0F);
      Shape2n3 = new ModelRenderer(this, 49, 3);
      Shape2n3.addBox(0F, 0F, 0F, 1, 1, 13);
      Shape2n3.setRotationPoint(-4F, 21.5F, -6.5F);
      Shape2n3.setTextureSize(128, 64);
      Shape2n3.mirror = true;
      setRotation(Shape2n3, 0F, 0F, 0F);
      Shape3n2 = new ModelRenderer(this, 0, 0);
      Shape3n2.addBox(0F, 0F, 0F, 1, 2, 2);
      Shape3n2.setRotationPoint(3F, 20F, 5F);
      Shape3n2.setTextureSize(128, 64);
      Shape3n2.mirror = true;
      setRotation(Shape3n2, -0.7853982F, 0F, 0F);
      Shape3n4 = new ModelRenderer(this, 0, 0);
      Shape3n4.addBox(0F, 0F, 0F, 1, 2, 2);
      Shape3n4.setRotationPoint(-4F, 20F, 5F);
      Shape3n4.setTextureSize(128, 64);
      Shape3n4.mirror = true;
      setRotation(Shape3n4, -0.7853982F, 0F, 0F);
      Shape4n1 = new ModelRenderer(this, 0, 0);
      Shape4n1.addBox(0F, 0F, 0F, 1, 2, 2);
      Shape4n1.setRotationPoint(3F, 20F, -5F);
      Shape4n1.setTextureSize(128, 64);
      Shape4n1.mirror = true;
      setRotation(Shape4n1, -0.7853982F, 0F, 0F);
      Shape4n3 = new ModelRenderer(this, 0, 0);
      Shape4n3.addBox(0F, 0F, 0F, 1, 2, 2);
      Shape4n3.setRotationPoint(-4F, 20F, -5F);
      Shape4n3.setTextureSize(128, 64);
      Shape4n3.mirror = true;
      setRotation(Shape4n3, -0.7853982F, 0F, 0F);
      Shape5n1 = new ModelRenderer(this, 0, 0);
      Shape5n1.addBox(0F, 0F, 0F, 1, 2, 2);
      Shape5n1.setRotationPoint(3F, 24F, -5F);
      Shape5n1.setTextureSize(128, 64);
      Shape5n1.mirror = true;
      setRotation(Shape5n1, 2.356194F, 0F, 0F);
      Shape5n3 = new ModelRenderer(this, 0, 0);
      Shape5n3.addBox(0F, 0F, 0F, 1, 2, 2);
      Shape5n3.setRotationPoint(-4F, 24F, -5F);
      Shape5n3.setTextureSize(128, 64);
      Shape5n3.mirror = true;
      setRotation(Shape5n3, 2.356194F, 0F, 0F);
      Shape5n4 = new ModelRenderer(this, 0, 0);
      Shape5n4.addBox(0F, 0F, 0F, 1, 2, 2);
      Shape5n4.setRotationPoint(-4F, 24F, 5F);
      Shape5n4.setTextureSize(128, 64);
      Shape5n4.mirror = true;
      setRotation(Shape5n4, 2.356194F, 0F, 0F);
      Shape6n2 = new ModelRenderer(this, 0, 0);
      Shape6n2.addBox(0F, 0F, 0F, 1, 2, 2);
      Shape6n2.setRotationPoint(3F, 24F, 5F);
      Shape6n2.setTextureSize(128, 64);
      Shape6n2.mirror = true;
      setRotation(Shape6n2, 2.356194F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 0);
      Shape7.addBox(0F, 0F, 0F, 6, 4, 14);
      Shape7.setRotationPoint(-3F, 19F, -7F);
      Shape7.setTextureSize(128, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 9);
      Shape3.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape3.setRotationPoint(-2F, 19.5F, -8F);
      Shape3.setTextureSize(128, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 9);
      Shape4.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape4.setRotationPoint(1F, 19.5F, -8F);
      Shape4.setTextureSize(128, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 19);
      Shape5.addBox(0F, 0F, 0F, 6, 4, 0);
      Shape5.setRotationPoint(-3F, 19F, -8F);
      Shape5.setTextureSize(128, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 47, 38);
      Shape6.addBox(0F, 0F, 0F, 6, 2, 6);
      Shape6.setRotationPoint(-3F, 17F, -4F);
      Shape6.setTextureSize(128, 64);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 29);
      Shape8.addBox(0F, 0F, 0F, 6, 2, 5);
      Shape8.setRotationPoint(-3F, 17F, 2F);
      Shape8.setTextureSize(128, 64);
      Shape8.mirror = true;
      setRotation(Shape8, -0.5235988F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 22, 19);
      Shape9.addBox(0F, 0F, 0F, 8, 0, 12);
      Shape9.setRotationPoint(-4F, 19.7F, -6F);
      Shape9.setTextureSize(128, 64);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 0, 37);
      Shape11.addBox(0F, 0F, 0F, 4, 1, 2);
      Shape11.setRotationPoint(-2F, 18.7F, -6.5F);
      Shape11.setTextureSize(128, 64);
      Shape11.mirror = true;
      setRotation(Shape11, -0.122173F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 0, 41);
      Shape12.addBox(0F, 0F, 0F, 8, 0, 2);
      Shape12.setRotationPoint(-4F, 19.7F, -6F);
      Shape12.setTextureSize(128, 64);
      Shape12.mirror = true;
      setRotation(Shape12, -2.094395F, 0F, 0F);
      Shape14 = new ModelRenderer(this, 0, 44);
      Shape14.addBox(0F, 0F, 0F, 8, 0, 2);
      Shape14.setRotationPoint(-4F, 19.7F, 6F);
      Shape14.setTextureSize(128, 64);
      Shape14.mirror = true;
      setRotation(Shape14, -0.7853982F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 28, 0);
      Shape1.addBox(0F, 0F, 0F, 8, 4, 1);
      Shape1.setRotationPoint(-4F, 19F, 7F);
      Shape1.setTextureSize(128, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5){
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Shape1n1.render(f5);
    Shape1n3.render(f5);
    Shape2n1.render(f5);
    Shape2n3.render(f5);
    Shape3n2.render(f5);
    Shape3n4.render(f5);
    Shape4n1.render(f5);
    Shape4n3.render(f5);
    Shape5n1.render(f5);
    Shape5n3.render(f5);
    Shape5n4.render(f5);
    Shape6n2.render(f5);
    Shape7.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape14.render(f5);
    Shape1.render(f5);
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
