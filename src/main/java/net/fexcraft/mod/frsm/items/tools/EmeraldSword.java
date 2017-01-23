package net.fexcraft.mod.frsm.items.tools;

import java.util.List;

import net.fexcraft.mod.frsm.util.CCS;
import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.öItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

@öItem(modid = FI.MODID, name = "emeraldsword")
public class EmeraldSword extends ItemSword {
	
	public EmeraldSword(){
        super(ToolMaterial.DIAMOND);
        this.setMaxStackSize(1);
        this.setCreativeTab(CD.TOOLS);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
		super.onUpdate(stack, world, entity, par4, par5);
		EntityPlayer player = (EntityPlayer) entity;
		ItemStack equipped = player.getHeldItemMainhand();
		if(equipped != null && equipped == stack){
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 10, 2));
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(5), 10, 5));
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(8), 10, 2));
		}
	}
	
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
    	par3List.add(CCS.BLUE + "+ Speed Boost");
    	par3List.add(CCS.BLUE + "+ Strenght Boost");
    	par3List.add(CCS.BLUE + "+ Jump Boost");
    }
    
}