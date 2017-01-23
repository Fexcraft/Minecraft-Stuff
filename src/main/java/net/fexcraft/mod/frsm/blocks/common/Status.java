package net.fexcraft.mod.frsm.blocks.common;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.block.öBlock;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@öBlock(modid = FI.MODID, name = "status")
public class Status extends Block {
	
	public Status(){
        super(Material.IRON);
        this.setCreativeTab(CD.BLOCKS);
    }
	
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(world.isRemote){
        	Print.chat(player, "Currently disabled.");
            return true;
    	}
    	return false;
    }
    
}