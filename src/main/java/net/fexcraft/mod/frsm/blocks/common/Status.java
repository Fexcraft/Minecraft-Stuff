package net.fexcraft.mod.frsm.blocks.common;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.PrintChat;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Status extends Block implements IBlock {
	
	public Status(){
        super(Material.IRON);
        this.setCreativeTab(CD.BLOCKS.getCreativeTab());
        BlockUtil.register(FI.MODID, this);
        BlockUtil.registerFIB(this);
    }
    
    @Override
    public String getName(){
    	return "status";
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(world.isRemote){
        	PrintChat.print(player, "Currently disabled.");
    	}
        return true;
    }

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
}