package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelStreetLampBase extends ModelBase {
	
	private static final short ts = 16;

	public ModelStreetLampBase(){
		base = new ModelRendererTurbo[3];
		base[0] = new ModelRendererTurbo(this, 0, 0, ts, ts);
		base[1] = new ModelRendererTurbo(this, 0, 0, ts, ts);
		base[2] = new ModelRendererTurbo(this, 0, 0, ts, ts);
		base[0].addBox(0F, 0F, 0F, 4, 7, 4, 0F);
		base[0].setRotationPoint(-2F, 3F, -2F);
		base[1].addBox(0F, 0F, 0F, 2, 8, 2, 0F);
		base[1].setRotationPoint(-1F, -6F, -1F);
		base[2].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.7F, 0F, -0.7F, -0.7F, 0F, -0.7F, -0.7F, 0F, -0.7F, -0.7F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 2
		base[2].setRotationPoint(-2F, 2F, -2F);
		translateAll(0F, 14F, 0F);
	}
	
}