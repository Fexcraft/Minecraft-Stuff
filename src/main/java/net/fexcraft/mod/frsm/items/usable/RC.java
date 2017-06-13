package net.fexcraft.mod.frsm.items.usable;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.frsm.util.CCS;
import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.entity.RoboType;
import net.fexcraft.mod.lib.api.item.fItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RC extends Item {
	
	@fItem(modid = FI.MODID, name = "rrc")
	public static class RR extends RC {
		public RR(){
			super(RoboType.RED);
		}
	}
	
	@fItem(modid = FI.MODID, name = "rbc")
	public static class RB extends RC {
		public RB(){
			super(RoboType.BLUE);
		}
	}
	
	@fItem(modid = FI.MODID, name = "rgc")
	public static class RG extends RC {
		public RG(){
			super(RoboType.GREEN);
		}
	}
	
	@fItem(modid = FI.MODID, name = "ryc")
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
	public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> tooltip, ITooltipFlag advanced){
		tooltip.add(CCS.fromInt(r.getColor().toDyeColor().getMetadata()) + r.getName());
	}
	
}