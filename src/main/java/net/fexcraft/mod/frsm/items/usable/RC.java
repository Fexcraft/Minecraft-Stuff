package net.fexcraft.mod.frsm.items.usable;

import java.util.List;

import net.fexcraft.mod.frsm.util.CCS;
import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.entity.RoboType;
import net.fexcraft.mod.lib.api.item.öItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RC extends Item {
	
	@öItem(modid = FI.MODID, name = "rrc")
	public static class RR extends RC {
		public RR(){
			super(RoboType.RED);
		}
	}
	
	@öItem(modid = FI.MODID, name = "rbc")
	public static class RB extends RC {
		public RB(){
			super(RoboType.BLUE);
		}
	}
	
	@öItem(modid = FI.MODID, name = "rgc")
	public static class RG extends RC {
		public RG(){
			super(RoboType.GREEN);
		}
	}
	
	@öItem(modid = FI.MODID, name = "ryc")
	public static class RY extends RC {
		public RY(){
			super(RoboType.YELLOW);
		}
	}

	private RoboType r;
	
	public RC(RoboType r) {
		super();
		this.r = r;
		this.setMaxStackSize(16);
		this.setCreativeTab(CD.ROBOTS);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
		tooltip.add(CCS.fromInt(r.getColor().toDyeColor().getMetadata()) + r.getName());
	}
	
}