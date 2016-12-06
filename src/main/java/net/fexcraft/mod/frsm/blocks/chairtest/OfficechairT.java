package net.fexcraft.mod.frsm.blocks.chairtest;

import java.util.List;

import net.fexcraft.mod.frsm.entities.EntitySittable;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.fexcraft.mod.lib.util.item.FIB;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OfficechairT extends FBC_4R {
	
	public OfficechairT() {
		super(Material.IRON);
		this.setHarvestLevel("axe", 1);
		this.setHardness(2.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.DEV.getCreativeTab());
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerFIB(this);
	}
	
	public static class IB extends FIB{
		public IB(Block block) {
			super(block, ((IBlock)block).getName(), ((IBlock)block).getVariantAmount());
		}
    	
		@Override
		public void addInformation(ItemStack itemstack, EntityPlayer player, List ls, boolean par4){
			ls.add(CCS.DPURPLE + "TEST");
		}
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new OfficechairTEntity();
	}
	
	@Override
	public String getName(){
		return "officechairT";
	}
	
    @Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(!w.isRemote){
    		if(p.getHeldItemMainhand() == null){
    			EntitySittable ent = new EntitySittable(w);
    			w.spawnEntity(ent);
    			ent.setPosition(pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f);
    			p.startRiding(ent, true);
    			return true;
    		}
    	}
		return false;
    }
}