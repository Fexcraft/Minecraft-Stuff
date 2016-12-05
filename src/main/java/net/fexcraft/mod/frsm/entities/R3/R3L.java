package net.fexcraft.mod.frsm.entities.R3;

import net.fexcraft.mod.frsm.entities.common.AttributeContainer;
import net.fexcraft.mod.frsm.entities.common.FRB;
import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.fexcraft.mod.lib.api.entity.RoboType;
import net.minecraft.world.World;

public class R3L{
	
	public static class Blue extends FRB{
		public Blue(World world) {
			super(world, 0.5F, 0.5F, RoboType.BLUE, new AttributeContainer(20, 60, 0.5, 4, 0.1, false, FRSM_Items.SR3L_blue));
		}
	}
	
	public static class Red extends FRB{
		public Red(World world) {
			super(world, 0.5F, 0.5F, RoboType.RED, new AttributeContainer(20, 60, 0.5, 4, 0.1, false, FRSM_Items.SR3L_red));
		}
	}
	
	public static class Green extends FRB{
		public Green(World world) {
			super(world, 0.5F, 0.5F, RoboType.GREEN, new AttributeContainer(20, 60, 0.5, 4, 0.1, false, FRSM_Items.SR3L_green));
		}
	}
	
	public static class Yellow extends FRB{
		public Yellow(World world) {
			super(world, 0.5F, 0.5F, RoboType.YELLOW, new AttributeContainer(20, 60, 0.5, 4, 0.1, false, FRSM_Items.SR3L_yellow));
		}
	}
	
	public static class Guard extends FRB{
		public Guard(World world) {
			super(world, 0.5F, 0.5F, RoboType.GUARD, new AttributeContainer(20, 60, 0.5, 4, 0.1, false, FRSM_Items.SR3L_guard));
		}
	}
	
}
