package net.fexcraft.mod.frsm.blocks.crate;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class CrateModel extends ModelBase{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape22;
    ModelRenderer Shape23;
    ModelRenderer Shape24;
    ModelRenderer Shape3;
    ModelRenderer Shape32;
    ModelRenderer Shape33;
    ModelRenderer Shape34;
    ModelRenderer Shape4;
    ModelRenderer Shape42;
    ModelRenderer Shape43;
    ModelRenderer Shape44;
    ModelRenderer Shape5;
    ModelRenderer Shape52;
    ModelRenderer Shape53;
    ModelRenderer Shape54;
  
  public CrateModel(){
    textureWidth = 128;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 14, 14, 14);
      Shape1.setRotationPoint(-7F, 9F, -7F);
      Shape1.setTextureSize(128, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 72, 26);
      Shape2.addBox(0F, 0F, 0F, 16, 3, 3);
      Shape2.setRotationPoint(-8F, 8F, 5F);
      Shape2.setTextureSize(128, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape22 = new ModelRenderer(this, 72, 26);
      Shape22.addBox(0F, 0F, 0F, 16, 3, 3);
      Shape22.setRotationPoint(-8F, 21F, 5F);
      Shape22.setTextureSize(128, 32);
      Shape22.mirror = true;
      setRotation(Shape22, 0F, 0F, 0F);
      Shape23 = new ModelRenderer(this, 72, 26);
      Shape23.addBox(0F, 0F, 0F, 16, 3, 3);
      Shape23.setRotationPoint(-8F, 21F, -8F);
      Shape23.setTextureSize(128, 32);
      Shape23.mirror = true;
      setRotation(Shape23, 0F, 0F, 0F);
      Shape24 = new ModelRenderer(this, 72, 26);
      Shape24.addBox(0F, 0F, 0F, 16, 3, 3);
      Shape24.setRotationPoint(-8F, 8F, -8F);
      Shape24.setTextureSize(128, 32);
      Shape24.mirror = true;
      setRotation(Shape24, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 110, 14);
      Shape3.addBox(0F, 0F, 0F, 3, 10, 3);
      Shape3.setRotationPoint(-8F, 11F, -8F);
      Shape3.setTextureSize(128, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape32 = new ModelRenderer(this, 110, 14);
      Shape32.addBox(0F, 0F, 0F, 3, 10, 3);
      Shape32.setRotationPoint(5F, 11F, -8F);
      Shape32.setTextureSize(128, 32);
      Shape32.mirror = true;
      setRotation(Shape32, 0F, 0F, 0F);
      Shape33 = new ModelRenderer(this, 110, 14);
      Shape33.addBox(0F, 0F, 0F, 3, 10, 3);
      Shape33.setRotationPoint(-8F, 11F, 5F);
      Shape33.setTextureSize(128, 32);
      Shape33.mirror = true;
      setRotation(Shape33, 0F, 0F, 0F);
      Shape34 = new ModelRenderer(this, 110, 14);
      Shape34.addBox(0F, 0F, 0F, 3, 10, 3);
      Shape34.setRotationPoint(5F, 11F, 5F);
      Shape34.setTextureSize(128, 32);
      Shape34.mirror = true;
      setRotation(Shape34, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 96, 0);
      Shape4.addBox(0F, 0F, 0F, 3, 3, 10);
      Shape4.setRotationPoint(5F, 8F, -5F);
      Shape4.setTextureSize(128, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape42 = new ModelRenderer(this, 96, 0);
      Shape42.addBox(0F, 0F, 0F, 3, 3, 10);
      Shape42.setRotationPoint(-8F, 8F, -5F);
      Shape42.setTextureSize(128, 32);
      Shape42.mirror = true;
      setRotation(Shape42, 0F, 0F, 0F);
      Shape43 = new ModelRenderer(this, 96, 0);
      Shape43.addBox(0F, 0F, 0F, 3, 3, 10);
      Shape43.setRotationPoint(5F, 21F, -5F);
      Shape43.setTextureSize(128, 32);
      Shape43.mirror = true;
      setRotation(Shape43, 0F, 0F, 0F);
      Shape44 = new ModelRenderer(this, 96, 0);
      Shape44.addBox(0F, 0F, 0F, 3, 3, 10);
      Shape44.setRotationPoint(-8F, 21F, -5F);
      Shape44.setTextureSize(128, 32);
      Shape44.mirror = true;
      setRotation(Shape44, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 124, 0);
      Shape5.addBox(0F, 0F, 0F, 1, 15, 1);
      Shape5.setRotationPoint(-8F, 11F, -6F);
      Shape5.setTextureSize(128, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0.7853982F, 0F, 0F);
      Shape52 = new ModelRenderer(this, 124, 0);
      Shape52.addBox(0F, 0F, 0F, 1, 15, 1);
      Shape52.setRotationPoint(7F, 10F, 5F);
      Shape52.setTextureSize(128, 32);
      Shape52.mirror = true;
      setRotation(Shape52, -0.7853982F, 0F, 0F);
      Shape53 = new ModelRenderer(this, 124, 0);
      Shape53.addBox(0F, 0F, 0F, 1, 15, 1);
      Shape53.setRotationPoint(-6F, 11F, 7F);
      Shape53.setTextureSize(128, 32);
      Shape53.mirror = true;
      setRotation(Shape53, 0F, 0F, -0.7853982F);
      Shape54 = new ModelRenderer(this, 124, 0);
      Shape54.addBox(0F, 0F, 0F, 1, 15, 1);
      Shape54.setRotationPoint(5F, 10F, -8F);
      Shape54.setTextureSize(128, 32);
      Shape54.mirror = true;
      setRotation(Shape54, 0F, 0F, 0.7853982F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5){
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape22.render(f5);
    Shape23.render(f5);
    Shape24.render(f5);
    Shape3.render(f5);
    Shape32.render(f5);
    Shape33.render(f5);
    Shape34.render(f5);
    Shape4.render(f5);
    Shape42.render(f5);
    Shape43.render(f5);
    Shape44.render(f5);
    Shape5.render(f5);
    Shape52.render(f5);
    Shape53.render(f5);
    Shape54.render(f5);
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
