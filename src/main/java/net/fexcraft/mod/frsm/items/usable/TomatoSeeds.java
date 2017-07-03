package net.fexcraft.mod.frsm.items.usable;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.fItem;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

@fItem(modid = FI.MODID, name = "tomatoseeds")
public class TomatoSeeds extends ItemFood implements IPlantable {
    
    private Block tomatoPlant;
    private Block soilBlockID;
    
    public TomatoSeeds(){
        super(4, 0.4F, true);
        this.tomatoPlant = RegistryUtil.getBlock("frsm:tomatoplant");
        this.soilBlockID = Blocks.FARMLAND;
        this.setMaxStackSize(32);
    }
    
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if (facing != EnumFacing.UP){
            return EnumActionResult.FAIL;
        }
        else if (!player.canPlayerEdit(pos.offset(facing), facing, player.getHeldItem(hand))){
            return EnumActionResult.FAIL;
        }
        else if (worldIn.getBlockState(pos).getBlock().canSustainPlant(worldIn.getBlockState(pos), worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up())){
            worldIn.setBlockState(pos.up(), this.tomatoPlant.getDefaultState());
            player.getHeldItem(hand).shrink(1);
            return EnumActionResult.PASS;
        }
        else{
            return EnumActionResult.FAIL;
        }
    }

    @Override
    public EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos){
        return EnumPlantType.Crop;
    }

    @Override
    public IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos){
        return this.tomatoPlant.getDefaultState();
    }
    
}