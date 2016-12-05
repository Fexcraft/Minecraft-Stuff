package net.fexcraft.mod.frsm.entities.R2;

import net.fexcraft.mod.frsm.entities.common.AttributeContainer;
import net.fexcraft.mod.frsm.entities.common.FRRB;
import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.fexcraft.mod.lib.api.entity.RoboType;
import net.minecraft.world.World;

public class R2J{
	
	public static class Blue extends FRRB{
		public Blue(World world) {
			super(world, 0.5F, 0.5F, RoboType.BLUE, new AttributeContainer(10, 60, 0.15, 5, 0, false, FRSM_Items.SR2J_blue, 16));
		}
	}
	
	public static class Red extends FRRB{
		public Red(World world) {
			super(world, 0.5F, 0.5F, RoboType.RED, new AttributeContainer(10, 60, 0.15, 5, 0, false, FRSM_Items.SR2J_red, 16));
		}
	}
	
	public static class Green extends FRRB{
		public Green(World world) {
			super(world, 0.5F, 0.5F, RoboType.GREEN, new AttributeContainer(10, 60, 0.15, 5, 0, false, FRSM_Items.SR2J_green, 16));
		}
	}
	
	public static class Yellow extends FRRB{
		public Yellow(World world) {
			super(world, 0.5F, 0.5F, RoboType.YELLOW, new AttributeContainer(10, 60, 0.15, 5, 0, false, FRSM_Items.SR2J_yellow, 16));
		}
	}
	
	public static class Guard extends FRRB{
		public Guard(World world) {
			super(world, 0.5F, 0.5F, RoboType.GUARD, new AttributeContainer(10, 60, 0.15, 5, 0, false, FRSM_Items.SR2J_guard, 16));
		}
	}
}
