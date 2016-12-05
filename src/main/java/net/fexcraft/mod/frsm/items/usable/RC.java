package net.fexcraft.mod.frsm.items.usable;

import java.util.List;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.frsm.util.java.StringUtil;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.api.entity.RoboType;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RC extends Item implements IItem{

	private RoboType r;
	
	public RC(RoboType r) {
		super();
		this.r = r;
		this.setMaxStackSize(16);
		this.setCreativeTab(CD.ROBO.getCreativeTab());
		ItemUtil.register(FI.MODID, this);
	}

	@Override
	public String getName(){
		return "R" + r.getShortName() + "C";
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
		tooltip.add(CCS.intToCCS(r.getColor().toDyeColor().getMetadata()) + StringUtil.firstToUpperCase(r.getName()));
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
}