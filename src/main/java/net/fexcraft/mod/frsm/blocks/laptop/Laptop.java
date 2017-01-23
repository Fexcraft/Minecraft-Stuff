package net.fexcraft.mod.frsm.blocks.laptop;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBN_4R;
import net.fexcraft.mod.lib.api.block.öBlock;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@öBlock(modid = FI.MODID, name = "laptop")
public class Laptop extends FBN_4R{
	
	public Laptop() {
		super(Material.GLASS);
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(2.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.TECHNIC);
	}
	
    @Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(!w.isRemote){
    		if(!p.getHeldItemMainhand().isEmpty() && p.getHeldItemMainhand().getItem() == Registry.getItem("frsm:upgradekit")){
    			w.setBlockState(pos, Registry.getBlock("frsm:laptop_black").getDefaultState().withProperty(FACING, p.getHorizontalFacing().getOpposite()));
    			p.getHeldItemMainhand().shrink(1);
    			return true;
    		}
    	}
		return false;
    }
    
}