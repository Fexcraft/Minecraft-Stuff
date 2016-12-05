package net.fexcraft.mod.frsm.entities.R3;

import net.fexcraft.mod.frsm.entities.common.AttributeContainer;
import net.fexcraft.mod.frsm.entities.common.FRRB;
import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.fexcraft.mod.lib.api.entity.RoboType;
import net.minecraft.world.World;

public class R3LJ{
	
	public static class Blue extends FRRB{
		public Blue(World world) {
			super(world, 0.5F, 0.5F, RoboType.BLUE, new AttributeContainer(20, 80, 0.5, 15, 0.2, false, FRSM_Items.SR3LJ_blue, 72));
		}
	}
	
	public static class Red extends FRRB{
		public Red(World world) {
			super(world, 0.5F, 0.5F, RoboType.RED, new AttributeContainer(20, 80, 0.5, 15, 0.2, false, FRSM_Items.SR3LJ_red, 72));
		}
	}
	
	public static class Green extends FRRB{
		public Green(World world) {
			super(world, 0.5F, 0.5F, RoboType.GREEN, new AttributeContainer(20, 80, 0.5, 15, 0.2, false, FRSM_Items.SR3LJ_green, 72));
		}
	}
	
	public static class Yellow extends FRRB{
		public Yellow(World world) {
			super(world, 0.5F, 0.5F, RoboType.YELLOW, new AttributeContainer(20, 80, 0.5, 15, 0.2, false, FRSM_Items.SR3LJ_yellow, 72));
		}
	}
	
	public static class Guard extends FRRB{
		public Guard(World world) {
			super(world, 0.5F, 0.5F, RoboType.GUARD, new AttributeContainer(20, 80, 0.5, 15, 0.2, false, FRSM_Items.SR3LJ_guard, 72));
		}
	}
	
}
