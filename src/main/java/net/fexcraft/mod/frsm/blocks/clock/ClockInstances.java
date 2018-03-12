package net.fexcraft.mod.frsm.blocks.clock;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClockInstances {
	
	//@fBlock(modid = FI.MODID, name = "clock1", item = ClockBaseItem.class)
	public static class Clock1 extends ClockBase {}
	
	//@fBlock(modid = FI.MODID, name = "clock1c", item = ClockBaseItem.class)
	public static class Clock1C extends ClockBase {}
	
	//@fBlock(modid = FI.MODID, name = "clock1w", item = ClockBaseItem.class)
	public static class Clock1W extends ClockBase {}
	
	//@fBlock(modid = FI.MODID, name = "clock2", item = ClockBaseItem.class)
	public static class Clock2 extends ClockBase {}
	
	//@fBlock(modid = FI.MODID, name = "clock2c", item = ClockBaseItem.class)
	public static class Clock2C extends ClockBase {}
	
	//@fBlock(modid = FI.MODID, name = "clock2w", item = ClockBaseItem.class)
	public static class Clock2W extends ClockBase {}

	public static void register(){
		GameRegistry.registerTileEntity(ClockBaseTileEntity.class, "frsm:clock_base");
		GameRegistry.register(new Clock1().setRegistryName("frsm:clock1").setUnlocalizedName("frsm:clock1"));
		GameRegistry.register(new Clock1C().setRegistryName("frsm:clock1c").setUnlocalizedName("frsm:clock1c"));
		GameRegistry.register(new Clock1W().setRegistryName("frsm:clock1w").setUnlocalizedName("frsm:clock1w"));
		GameRegistry.register(new Clock2().setRegistryName("frsm:clock2").setUnlocalizedName("frsm:clock2"));
		GameRegistry.register(new Clock2C().setRegistryName("frsm:clock2c").setUnlocalizedName("frsm:clock2c"));
		GameRegistry.register(new Clock2W().setRegistryName("frsm:clock2w").setUnlocalizedName("frsm:clock2w"));
		GameRegistry.register(new ClockBaseItem(Block.getBlockFromName("frsm:clock1")).setRegistryName("frsm:clock1").setUnlocalizedName("frsm:clock1"));
		GameRegistry.register(new ClockBaseItem(Block.getBlockFromName("frsm:clock1c")).setRegistryName("frsm:clock1c").setUnlocalizedName("frsm:clock1c"));
		GameRegistry.register(new ClockBaseItem(Block.getBlockFromName("frsm:clock1w")).setRegistryName("frsm:clock1w").setUnlocalizedName("frsm:clock1w"));
		GameRegistry.register(new ClockBaseItem(Block.getBlockFromName("frsm:clock2")).setRegistryName("frsm:clock2").setUnlocalizedName("frsm:clock2"));
		GameRegistry.register(new ClockBaseItem(Block.getBlockFromName("frsm:clock2c")).setRegistryName("frsm:clock2c").setUnlocalizedName("frsm:clock2c"));
		GameRegistry.register(new ClockBaseItem(Block.getBlockFromName("frsm:clock2w")).setRegistryName("frsm:clock2w").setUnlocalizedName("frsm:clock2w"));
	}
	
	
}