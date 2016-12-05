package net.fexcraft.mod.frsm.entities.R3;

import net.fexcraft.mod.frsm.entities.common.AttributeContainer;
import net.fexcraft.mod.frsm.entities.common.FRB;
import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.fexcraft.mod.lib.api.entity.RoboType;
import net.minecraft.world.World;

public class R3M{
	
	public static class Blue extends FRB{
		public Blue(World world) {
			super(world, 0.5F, 0.5F, RoboType.BLUE, new AttributeContainer(40, 60, 0.3, 3, 0.3, false, FRSM_Items.SR3M_blue));
		}
	}

	public static class Red extends FRB{
		public Red(World world) {
			super(world, 0.5F, 0.5F, RoboType.RED, new AttributeContainer(40, 60, 0.3, 3, 0.3, false, FRSM_Items.SR3M_red));
		}
	}

	public static class Green extends FRB{
		public Green(World world) {
			super(world, 0.5F, 0.5F, RoboType.GREEN, new AttributeContainer(40, 60, 0.3, 3, 0.3, false, FRSM_Items.SR3M_green));
		}
	}

	public static class Yellow extends FRB{
		public Yellow(World world) {
			super(world, 0.5F, 0.5F, RoboType.YELLOW, new AttributeContainer(40, 60, 0.3, 3, 0.3, false, FRSM_Items.SR3M_yellow));
		}
	}

	public static class Guard extends FRB{
		public Guard(World world) {
			super(world, 0.5F, 0.5F, RoboType.GUARD, new AttributeContainer(40, 60, 0.3, 3, 0.3, false, FRSM_Items.SR3M_guard));
		}
	}
	
}
