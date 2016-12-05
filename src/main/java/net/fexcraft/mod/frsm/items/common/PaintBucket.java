package net.fexcraft.mod.frsm.items.common;

import java.util.List;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PaintBucket extends Item implements IItem{

	public PaintBucket(){
		this.setMaxStackSize(1);
		this.setCreativeTab(CD.MATERIALS.getCreativeTab());
		ItemUtil.register(FI.MODID, this);
	}
	
	@Override
	public String getName(){
		return "paintBucket";
	}
	
	@Override
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list) {
        for(int i = 0; i < 16; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }

	@Override
	public int getVariantAmount(){
		return 16;
	}
	
}