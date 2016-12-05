package net.fexcraft.mod.extensions.cae.model;

import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class Models{
	
	public static class Modelx16 extends ModelBase {
		int textureX = 16;
		int textureY = 16;
		float defx = -8F, defy = -1F, defz = -8F;
		
		public ModelRendererTurbo base[];

		public Modelx16(){
			base = new ModelRendererTurbo[256];
			int i = 0;
			for(int x = 0; x < 16; x++){
				for(int z = 0; z < 16; z++){
					base[i] = new ModelRendererTurbo(this, 0, 0, textureX, textureY);
					base[i].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F);
					base[i].setRotationPoint((defx + x), 0, (defz + z));
					i++;
				}
			}
		}
		
		public void render(int i, int y){
			base[i].rotationPointY = (22 - y);
			base[i].render(0.0625F);
		}
	}
	
	public static class Modelx8 extends ModelBase {
		
		int textureX = 16;
		int textureY = 16;
		float defx = -8F, defy = -1F, defz = -8F;
		
		public ModelRendererTurbo base[];

		public Modelx8(){
			base = new ModelRendererTurbo[64];
			int i = 0;
			for(int x = 0; x < 8; x++){
				for(int z = 0; z < 8; z++){
					base[i] = new ModelRendererTurbo(this, 0, 0, textureX, textureY);
					base[i].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F);
					base[i].setRotationPoint((defx + (x * 2)), 0, (defz + (z * 2)));
					i++;
				}
			}
		}
		
		public void render(int i, int y){
			base[i].rotationPointY = (22 - y);
			base[i].render(0.0625F);
		}
	}
	
}