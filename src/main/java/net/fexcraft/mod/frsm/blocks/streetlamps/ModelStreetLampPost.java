package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelStreetLampPost extends ModelBase {
	
	private static final short ts = 16;

	public ModelStreetLampPost(){
		base = new ModelRendererTurbo[1];
		base[0] = new ModelRendererTurbo(this, 0, 0, ts, ts);
		base[0].addBox(-1F, -1F, -1F, 2, 2, 2, 0F);
		base[0].setRotationPoint(0F, 16F, 0F);
		
		r0 = new ModelRendererTurbo[1];
		r0[0] = new ModelRendererTurbo(this, 0, 0, ts, ts);
		r0[0].addBox(-1F, 1F, -1F, 2, 7, 2, 0F);
		r0[0].setRotationPoint(0F, 16F, 0F);
		
		translateAll(0F, 0F, 0F);
	}
	
}