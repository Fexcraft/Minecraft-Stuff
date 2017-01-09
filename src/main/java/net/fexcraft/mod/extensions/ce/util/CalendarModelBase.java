package net.fexcraft.mod.extensions.ce.util;

import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;


public class CalendarModelBase extends ModelBase {
	
	public ModelRendererTurbo d00[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d01[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d02[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d03[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d04[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d05[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d06[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d07[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d08[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d09[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d10[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d11[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d12[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d13[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d14[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d15[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d16[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d17[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d18[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d19[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d20[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d21[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d22[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d23[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d24[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d25[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d26[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d27[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d28[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d29[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d30[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo d31[] = new ModelRendererTurbo[0];
	
	public ModelRendererTurbo base[] = new ModelRendererTurbo[0];
	   
	public void render(){
		renderPart(base);
		renderPart(d01);
		renderPart(d02);
		renderPart(d02);
		renderPart(d03);
		renderPart(d04);
		renderPart(d05);
		renderPart(d06);
		renderPart(d07);
		renderPart(d08);
		renderPart(d09);
		renderPart(d10);
		renderPart(d11);
		renderPart(d12);
		renderPart(d13);
		renderPart(d14);
		renderPart(d15);
		renderPart(d16);
		renderPart(d17);
		renderPart(d18);
		renderPart(d19);
		renderPart(d20);
		renderPart(d21);
		renderPart(d22);
		renderPart(d23);
		renderPart(d24);
		renderPart(d25);
		renderPart(d26);
		renderPart(d27);
		renderPart(d28);
		renderPart(d29);
		renderPart(d30);
		renderPart(d31);
	}

	public void renderPart(ModelRendererTurbo[] part){
		for(ModelRendererTurbo bit : part){
			bit.render(0.0625F);
		}
	}
}
