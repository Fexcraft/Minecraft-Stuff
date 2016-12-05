package net.fexcraft.mod.extensions.ce.items;

import java.util.List;

import net.fexcraft.mod.extensions.ce.CE;
import net.fexcraft.mod.extensions.ce.blocks.CEBB;
import net.fexcraft.mod.extensions.ce.blocks.CEBBC;
import net.fexcraft.mod.frsm.util.PrintChat;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.network.Network;
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
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Tool extends Item{
	private String name = "universal_tool";
	public Tool(){
		setUnlocalizedName("frsm_ce_" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(CE.tabCE);
	}
	public String getName(){
		return name;
	}
	
	@Override
	public EnumActionResult onItemUseFirst(ItemStack stack, EntityPlayer p, World w, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand){
	    if(!w.isRemote && Network.isDonator(p)){
	    	Block block = w.getBlockState(pos).getBlock();
	    	if(block instanceof CEBB == false && block instanceof CEBBC == false){
	    		if(stack.getTagCompound() == null){
	    			stack.setTagCompound(new NBTTagCompound());
	    		}
	    		next(stack.getTagCompound(), p);
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
	public void next(NBTTagCompound nbt, EntityPlayer player){
	    String s = CCS.AQUA + " - Switch Mode.";
	    int i = nbt.getInteger("frsm_ce_mode");
	    switch(i){
	    	case 0: nbt.setInteger("frsm_ce_mode", 1); PrintChat.print(player, "Hour" + s); return;
	    	case 1: nbt.setInteger("frsm_ce_mode", 2); PrintChat.print(player, "Minute" + s); return;
	    	case 2: nbt.setInteger("frsm_ce_mode", 3); PrintChat.print(player, "Second" + s); return;
	    	case 3: nbt.setInteger("frsm_ce_mode", 4); PrintChat.print(player, "Day" + s); return;
	    	case 4: nbt.setInteger("frsm_ce_mode", 5); PrintChat.print(player, "Month" + s); return;
	    	case 5: nbt.setInteger("frsm_ce_mode", 0); PrintChat.print(player, "null" + CCS.AQUA + " - Disabled."); return;
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
}