package net.fexcraft.mod.frsm.entities.R1;

import net.fexcraft.mod.frsm.entities.common.AttributeContainer;
import net.fexcraft.mod.frsm.entities.common.FRB;
import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.fexcraft.mod.lib.api.entity.RoboType;
import net.minecraft.world.World;

public class R1{
	
	public static class Blue extends FRB{
		public Blue(World world) {
			super(world, 0.5F, 0.5F, RoboType.BLUE, new AttributeContainer(10D, 40D, 0.15D, 1D, 0D, false, FRSM_Items.SR1_blue));
		}
	}
	
	public static class Red extends FRB{
		public Red(World world) {
			super(world, 0.5F, 0.5F, RoboType.RED, new AttributeContainer(10D, 40D, 0.15D, 1D, 0D, false, FRSM_Items.SR1_red));
		}
	}
	
	public static class Green extends FRB{
		public Green(World world) {
			super(world, 0.5F, 0.5F, RoboType.GREEN, new AttributeContainer(10D, 40D, 0.15D, 1D, 0D, false, FRSM_Items.SR1_green));
		}
	}
	
	public static class Yellow extends FRB{
		public Yellow(World world) {
			super(world, 0.5F, 0.5F, RoboType.YELLOW, new AttributeContainer(10D, 40D, 0.15D, 1D, 0D, false, FRSM_Items.SR1_yellow));
		}
	}
	
	public static class Guard extends FRB{
		public Guard(World world) {
			super(world, 0.5F, 0.5F, RoboType.GUARD, new AttributeContainer(10D, 40D, 0.15D, 1D, 0D, false, FRSM_Items.SR1_guard));
		}
	}
    
}
