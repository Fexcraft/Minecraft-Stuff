package net.fexcraft.mod.frsm.entities.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Arrow1 extends EntityArrow{

	public Arrow1(World w, EntityLivingBase e) {
		super(w, e);
	}
	
	protected float getGravityVelocity(){
		return 0.02F;
	}
	
	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(Items.ARROW);
	}
}