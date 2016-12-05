package net.fexcraft.mod.frsm.items.tools;

import java.util.List;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EmeraldSword extends ItemSword implements IItem{
	
	public EmeraldSword(ToolMaterial material) {
        super(material);
        this.setMaxStackSize(1);
        this.setCreativeTab(CD.TOOLS.getCreativeTab());
        ItemUtil.register(FI.MODID, this);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
		super.onUpdate(stack, world, entity, par4, par5);
		EntityPlayer player = (EntityPlayer) entity;
		ItemStack equipped = player.getHeldItemMainhand();
		if(equipped != null && equipped == stack) {
			//player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10, 0));
			//player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 5, 0));
			//player.addPotionEffect(new PotionEffect(Potion.jump.id, 5, 0));
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
    
    @Override
    public String getName(){
    	return "emeraldSword";
    }

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
}