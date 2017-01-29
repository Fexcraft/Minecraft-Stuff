package net.fexcraft.mod.frsm.items.tools;

import java.util.List;

import net.fexcraft.mod.frsm.FRSM;
import net.fexcraft.mod.frsm.guis.GuiHandler;
import net.fexcraft.mod.frsm.util.CCS;
import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.common.PaintableObject;
import net.fexcraft.mod.lib.api.common.fLoad;
import net.fexcraft.mod.lib.util.common.EnumColor;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@fLoad(turn = 99)
public class PaintSet extends Item {
	
	private static PaintSet[] sets;
	private RGB color = new RGB();
	private EnumColor dye;
	private String name;
	private boolean custom = false;
	
	public PaintSet(){
		sets = new PaintSet[]{
			new PaintSet(0, EnumDyeColor.byMetadata(0)),
			new PaintSet(1, EnumDyeColor.byMetadata(1)),
			new PaintSet(2, EnumDyeColor.byMetadata(2)),
			new PaintSet(3, EnumDyeColor.byMetadata(3)),
			new PaintSet(4, EnumDyeColor.byMetadata(4)),
			new PaintSet(5, EnumDyeColor.byMetadata(5)),
			new PaintSet(6, EnumDyeColor.byMetadata(6)),
			new PaintSet(7, EnumDyeColor.byMetadata(7)),
			new PaintSet(8, EnumDyeColor.byMetadata(8)),
			new PaintSet(9, EnumDyeColor.byMetadata(9)),
			new PaintSet(10, EnumDyeColor.byMetadata(10)),
			new PaintSet(11, EnumDyeColor.byMetadata(11)),
			new PaintSet(12, EnumDyeColor.byMetadata(12)),
			new PaintSet(13, EnumDyeColor.byMetadata(13)),
			new PaintSet(14, EnumDyeColor.byMetadata(14)),
			new PaintSet(15, EnumDyeColor.byMetadata(15)),
			new PaintSet(16, EnumDyeColor.byMetadata(16), true),
		};
	}
	
	public PaintSet(int name, EnumDyeColor c){
		String id = "paintset" + name;
		this.color.fromDyeColor(c);
		dye = EnumColor.fromDyeColor(c);
		this.setCreativeTab(CD.TOOLS);
		this.setMaxStackSize(1);
		Registry.registerItemManually(FI.MODID, id, 1, null, this);
	}

	public PaintSet(int i, EnumDyeColor meta, boolean b){
		this(i, meta);
		custom = b;
	}

	public RGB getColor() {
		return color;
	}
	
	private EnumColor getDye(){
		return dye;
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			return EnumActionResult.PASS;
		}
		else{
			IBlockState state = world.getBlockState(pos);
			if(state.getBlock() instanceof PaintableObject){
				((PaintableObject)state.getBlock()).onPaintItemUse(this.getColor(), this.getDye(), player.getHeldItem(hand), player, pos, world);
			}
			else if(state.getBlock() == Blocks.WOOL){
				world.setBlockState(pos, Blocks.WOOL.getDefaultState().withProperty(BlockColored.COLOR, dye.toDyeColor()));
			}
			else if(state.getBlock() == Blocks.STAINED_HARDENED_CLAY){
				world.setBlockState(pos, Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, dye.toDyeColor()));
			}
			else if(state.getBlock() instanceof BlockStainedGlass){
				world.setBlockState(pos, Blocks.STAINED_GLASS.getDefaultState().withProperty(BlockColored.COLOR, dye.toDyeColor()));
			}
			else if(state.getBlock() instanceof BlockStainedGlassPane){
				world.setBlockState(pos, Blocks.STAINED_GLASS_PANE.getDefaultState().withProperty(BlockColored.COLOR, dye.toDyeColor()));
			}
			else if(state.getBlock() instanceof BlockCarpet){
				world.setBlockState(pos, Blocks.CARPET.getDefaultState().withProperty(BlockColored.COLOR, dye.toDyeColor()));
			}
			else if(state.getBlock().hasTileEntity(state)){
				if(world.getTileEntity(pos) instanceof PaintableObject){
					((PaintableObject)world.getTileEntity(pos)).onPaintItemUse(this.getColor(), this.getDye(), player.getHeldItem(hand), player, pos, world);
				}
			}
			else{
				if(this.getRegistryName().toString().contains("16")){
					player.openGui(FRSM.getInstance(), GuiHandler.RGB, world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
					return EnumActionResult.SUCCESS;
				}
				else return EnumActionResult.PASS;
			}
			return EnumActionResult.SUCCESS;
		}
    }

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean advanced){
		list.add(CCS.GOLD + color.toString());
		if(custom){
			list.add(CCS.DAQUA + "Customisable");
		}
		else{
			list.add(CCS.fromInt(dye.toDyeColor().getMetadata()) + dye.toString());
		}
    }
	
}