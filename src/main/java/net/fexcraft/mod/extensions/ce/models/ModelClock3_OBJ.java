package net.fexcraft.mod.extensions.ce.models;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelClock3_OBJ extends ModelBase {
	
	public ModelClock3_OBJ(){
	    int textureX = 64;
	    int textureY = 64;
        base = new ModelRendererTurbo[1];
        base[0] = new ModelRendererTurbo(this,  0,  0, textureX, textureY);
        base[0].addObjF("frsm_ce/models/block/obj/Clock3");
        base[0].setRotationPoint(0F, 0F, 0F);
    }
}