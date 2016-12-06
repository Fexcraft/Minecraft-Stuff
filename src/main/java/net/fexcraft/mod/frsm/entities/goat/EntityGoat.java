package net.fexcraft.mod.frsm.entities.goat;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityGoat extends EntityAnimal{
	
    public EntityGoat(World par1World){
        super(par1World);
        this.setSize(0.9F, 1.3F);
        //((PathNavigateGround)this.getNavigator()).func_179690_a(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.WHEAT, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }
    
    @Override
    protected void applyEntityAttributes(){
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
    }
    
    @Override
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_){
        int var3 = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);
        int var4;
        for (var4 = 0; var4 < var3; ++var4){
            this.dropItem(Items.LEATHER, 1);
        }
        var3 = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + p_70628_2_);
        for (var4 = 0; var4 < var3; ++var4){
            if (this.isBurning()){
                this.dropItem(Items.LEATHER, 2);
            }
            else{
                this.dropItem(Items.LEATHER, 2);
            }
        }
    }

	@Override
	public EntityGoat createChild(EntityAgeable entity) {
        return new EntityGoat(this.world);
	}
}