package net.fexcraft.mod.extensions.ce.items;

import java.util.List;

import net.fexcraft.mod.extensions.ce.CE;
import net.fexcraft.mod.extensions.ce.blocks.ClockBlockBase;
import net.fexcraft.mod.frsm.util.PrintChat;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Tool extends Item implements IItem {
	
	public Tool(){
		setCreativeTab(CE.tabCE);
		ItemUtil.register("frsm_ce", this);
		ItemUtil.registerRender(this);
	}
	
	@Override
	public String getName(){
		return "universal_tool";
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
	    if(!world.isRemote && hand != EnumHand.OFF_HAND){
	    	Block block = world.getBlockState(pos).getBlock();
	    	if(block instanceof ClockBlockBase == false){
	    		if(player.getHeldItemMainhand().getTagCompound() == null){
	    			player.getHeldItemMainhand().setTagCompound(new NBTTagCompound());
	    		}
	    		next(player.getHeldItemMainhand().getTagCompound(), player);
	    		return EnumActionResult.SUCCESS;
	    	}
	    	else{
	    		return EnumActionResult.FAIL;
	    	}
	    }
	    else{
	    	return EnumActionResult.FAIL;
	    }
	}
	//0: null
	//1: hour
	//2: minute
	//3: second
	//4: day
	//5: month
	//6: reverse;
	public void next(NBTTagCompound nbt, EntityPlayer player){
	    String s = CCS.AQUA + " - Switch Mode.";
	    int i = nbt.getInteger("frsm_ce_mode");
	    switch(i){
	    	case 0: nbt.setInteger("frsm_ce_mode", 1); PrintChat.print(player, "Hour" + s); return;
	    	case 1: nbt.setInteger("frsm_ce_mode", 2); PrintChat.print(player, "Minute" + s); return;
	    	case 2: nbt.setInteger("frsm_ce_mode", 3); PrintChat.print(player, "Second" + s); return;
	    	case 3: nbt.setInteger("frsm_ce_mode", 4); PrintChat.print(player, "Day" + s); return;
	    	case 4: nbt.setInteger("frsm_ce_mode", 5); PrintChat.print(player, "Month" + s); return;
	    	case 5: nbt.setInteger("frsm_ce_mode", 6); PrintChat.print(player, "Reverse" + s); return;
	    	case 6: nbt.setInteger("frsm_ce_mode", 0); PrintChat.print(player, "null" + CCS.AQUA + " - Disabled."); return;
	    	default: nbt.setInteger("frsm_ce_mode", 0);  PrintChat.print(player, CCS.RED + "Error."); return;
	    }
	}
	    
	@Override
	public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4){
	    if(par1.getTagCompound() == null){
	    	par1.setTagCompound(new NBTTagCompound());
	    }
	    int i = par1.getTagCompound().getInteger("frsm_ce_mode");
	    String text;
	    switch(i){
	    	case 0: text = null; par3.add(CCS.GRAY + "Mode: " + CCS.AQUA + text); return;
	    	case 1: text = "Hour"; par3.add(CCS.GRAY + "Mode: " + CCS.AQUA + text); return;
	    	case 2: text = "Minute"; par3.add(CCS.GRAY + "Mode: " + CCS.AQUA + text); return;
	    	case 3: text = "Second"; par3.add(CCS.GRAY + "Mode: " + CCS.AQUA + text); return;
	    	case 4: text = "Day"; par3.add(CCS.GRAY + "Mode: " + CCS.AQUA + text); return;
	    	case 5: text = "Month"; par3.add(CCS.GRAY + "Mode: " + CCS.AQUA + text); return;
	    	default: text = "Error"; par3.add(CCS.GRAY + "Mode: " + CCS.AQUA + text); return;
	    }
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
}