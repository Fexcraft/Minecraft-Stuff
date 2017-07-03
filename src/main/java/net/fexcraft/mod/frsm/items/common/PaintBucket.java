package net.fexcraft.mod.frsm.items.common;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.fItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

@fItem(modid = FI.MODID, name = "paintbucket", variants = 16)
public class PaintBucket extends Item {

	public PaintBucket(){
		this.setMaxStackSize(1);
		this.setCreativeTab(CD.MATERIALS);
	}
	
	@Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list){
		if(tab != CD.MATERIALS){
			return;
		}
        for(int i = 0; i < 16; i++){
            list.add(new ItemStack(this, 1, i));
        }
    }
	
}