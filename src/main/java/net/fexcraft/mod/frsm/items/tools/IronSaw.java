package net.fexcraft.mod.frsm.items.tools;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.item.ItemAxe;

public class IronSaw extends ItemAxe implements IItem{
	
	private String name = "ironSaw";
	
	public IronSaw(ToolMaterial material) {
        super(material);
        this.setMaxStackSize(1);
        this.setCreativeTab(CD.TOOLS.getCreativeTab());
        ItemUtil.register(FI.MODID, this);
	}
	
	@Override
    public String getName(){
    	return "ironSaw";
    }

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
}