package net.fexcraft.mod.extensions.bge;

import net.fexcraft.mod.extensions.bge.blocks.Blk1;
import net.fexcraft.mod.extensions.bge.blocks.CTower;
import net.fexcraft.mod.extensions.bge.blocks.Dice;
import net.fexcraft.mod.extensions.bge.tileentities.BLK1TE;
import net.fexcraft.mod.extensions.bge.tileentities.CTTE;
import net.fexcraft.mod.extensions.bge.tileentities.DiceTileEntity;
import net.fexcraft.mod.extensions.bge.util.BGEEventHandler;
import net.fexcraft.mod.extensions.bge.util.Data;
import net.fexcraft.mod.extensions.bge.util.RenderRegistry;
import net.fexcraft.mod.extensions.bge.util.UpdateHandler;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = BGE.modid, name = "Board Game Extension", version = BGE.version, dependencies = "required-after:frsm@[3.6.81,)")
public class BGE{
	
	public static final String modid = "frsm_bge";
	public static final String version = "1.3.1";
	public static final String mcv = "1.10.2";
	public static final String BGE = CCS.BLACK + "[" + CCS.DGREEN + "BGE" + CCS.BLACK + "]" + CCS.GRAY + "";
	
	public static Block blk1;
	public static Block ct;
	public static Block dice;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		blk1 = new Blk1();
		ct = new CTower();
		dice = new Dice();
		GameRegistry.registerTileEntity(BLK1TE.class, "frsm_bge:block1");
		GameRegistry.registerTileEntity(CTTE.class, "frsm_bge:chess_tower");
		GameRegistry.registerTileEntity(DiceTileEntity.class, "frsm_bge:dice");
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event) {
		if(event.getSide() == Side.CLIENT){
			RenderRegistry.register();
		}
	}
	
	public static CreativeTabs tabBGE = new CreativeTabs("tabBGE"){
		@Override
		public Item getTabIconItem() {
			Item item = Item.getItemFromBlock(blk1);
			if(item != null){
				return item;
			}
			else return Items.FLOWER_POT;
		}
	};
	
	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	Data.getDataFromServer();
    	UpdateHandler.load();
    	MinecraftForge.EVENT_BUS.register(new BGEEventHandler());
    }
}