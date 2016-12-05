package net.fexcraft.mod.extensions.ie.blocks;

import java.util.List;
import javax.annotation.Nullable;

import net.fexcraft.mod.extensions.ie.tileentities.WaterWheelTileEntity;
import net.fexcraft.mod.extensions.ie.util.Static;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.api.block.IMashineBlock;
import net.fexcraft.mod.lib.api.tileentity.ICableTileEntity;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.fexcraft.mod.lib.util.cls.EnumMashineType;
import net.fexcraft.mod.lib.util.cls.Print;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WaterWheel extends FBC_4R implements IMashineBlock{

	public WaterWheel() {
		super(Material.IRON);
		setCreativeTab(CD.TECHNIC.getCreativeTab());
		BlockUtil.register(Static.MODID, this);
		BlockUtil.registerFIB(this);
		BlockUtil.registerFIBRender(this);
	}

	@Override
	public boolean isMashine() {
		return true;
	}

	@Override
	public String getName() {
		return "water_wheel";
	}

	@Override
	public EnumMashineType getMashineType() {
		return EnumMashineType.GENERATION;
	}
	
	public static class IB extends ItemBlock{

		public IB(Block block) {
			super(block);
			this.setRegistryName(block.getRegistryName().toString());
		}
		
		public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean advanced){
			list.add(CCS.DGREEN + "Common Watter Wheel");
			list.add(CCS.DAQUA + "Conductivity: " + CCS.AQUA + "10~500/s");
			list.add(CCS.DAQUA + "Resistivity: " + CCS.AQUA + "10/s");
			list.add(CCS.BLUE + "Average: " + CCS.AQUA + "490/s");
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new WaterWheelTileEntity();
	}
	
	@Override
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		if(w.isRemote){
			return false;
		}
		else{
			if(p.getHeldItemMainhand() == null){
				Print.chat(p, CCS.GRAY + ((ICableTileEntity)w.getTileEntity(pos)).fpu_get(side));
			}
			return true;
		}
	}

}