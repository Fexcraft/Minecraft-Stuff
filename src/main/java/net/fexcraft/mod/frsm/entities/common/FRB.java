package net.fexcraft.mod.frsm.entities.common;

import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.fexcraft.mod.lib.api.entity.IRoboEntity;
import net.fexcraft.mod.lib.api.entity.RoboType;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class FRB extends EntityMob implements IRoboEntity{
	
	private boolean swim;
	private Item item;
	
	private RoboType type;
	
	public FRB(World world, float sw, float sh, RoboType type, AttributeContainer c){
		super(world);
		this.setSize(sw, sh);
		this.type = type;
		this.swim = c.swim;
		this.item = c.item;
		this.postInitEntityAI();
		this.postApplyEntityAttributes(c);
	}
	
	@Override
	protected void initEntityAI(){
		super.initEntityAI();
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }
	
	private void postInitEntityAI(){
		if(this.swim){
			this.tasks.addTask(0, new EntityAISwimming(this));
		}
		if(type == RoboType.BLUE){
			this.tasks.addTask(3, new EntityAITempt(this, 1.1D, FRSM_Items.RBC, false));
		}
		if(type == RoboType.RED){
			this.tasks.addTask(3, new EntityAITempt(this, 1.1D, FRSM_Items.RRC, false));
		}
		if(type == RoboType.GREEN){
			this.tasks.addTask(3, new EntityAITempt(this, 1.1D, FRSM_Items.RGC, false));
		}
		if(type == RoboType.YELLOW){
			this.tasks.addTask(3, new EntityAITempt(this, 1.1D, FRSM_Items.RYC, false));
		}
		
		this.targetTasks.addTask(2, new EAINAT(this, EntityLivingBase.class, true, type));
		
		if(type == RoboType.GUARD){
			this.tasks.addTask(3, new EntityAITempt(this, 1.1D, FRSM_Items.RPC, false));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, FRB.class, false));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, FRRB.class, false));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZombie.class, false));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, false));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWitch.class, false));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySpider.class, false));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityCaveSpider.class, false));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySlime.class, false));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGhast.class, false));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPigZombie.class, false));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySilverfish.class, false));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityBlaze.class, false));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityMagmaCube.class, false));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWolf.class, false));
		}
	}
	
	@Override
	protected void applyEntityAttributes(){
        super.applyEntityAttributes();
	}
    
    protected void postApplyEntityAttributes(AttributeContainer c){
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(c.max_health);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(c.follow_range);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(c.movement_speed);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(c.attack_damage);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(c.armor);
	}

	@Override
	public RoboType getRoboType() {
		return type;
	}
	
	@Override
    protected void dropFewItems(boolean b, int i){
    	this.dropItem(item, 1);
    }
	
	public static class EAINAT extends EntityAINearestAttackableTarget{
		
		private RoboType type;
		
		public EAINAT(EntityCreature creature, Class classTarget, boolean checkSight, RoboType type) {
			super(creature, classTarget, checkSight);
			this.type = type;
		}
		
		@Override
		public boolean shouldExecute(){
			if(super.shouldExecute()){
				if(this.targetEntity instanceof IRoboEntity){
					RoboType typ = ((IRoboEntity)this.targetEntity).getRoboType();
					switch(type){
						case BLUE:
							if(typ != RoboType.BLUE && typ != RoboType.GUARD && typ != RoboType.NEUTRAL){
								return true;
							}
							else{
								this.resetTask();
								return false;
							}
						case GREEN:
							if(typ != RoboType.GREEN && typ != RoboType.GUARD && typ != RoboType.NEUTRAL){
								return true;
							}
							else{
								this.resetTask();
								return false;
							}
						case GUARD:
							if(typ != RoboType.GUARD && typ != RoboType.NEUTRAL){
								return true;
							}
							else{
								this.resetTask();
								return false;
							}
						case HOSTILE:
							//if(typ != RoboType.HOSTILE && typ != RoboType.GUARD && typ != RoboType.NEUTRAL){
								return true;
							//}
						case NEUTRAL:
							//if(typ != RoboType.NEUTRAL && typ != RoboType.GUARD && typ != RoboType.NEUTRAL){
								return false;
							//}
						case RED:
							if(typ != RoboType.RED && typ != RoboType.GUARD && typ != RoboType.NEUTRAL){
								return true;
							}
							else{
								this.resetTask();
								return false;
							}
						case YELLOW:
							if(typ != RoboType.YELLOW && typ != RoboType.GUARD && typ != RoboType.NEUTRAL){
								return true;
							}
							else{
								this.resetTask();
								return false;
							}
						default:
							this.resetTask();
							return false;
					}
				}
				else{
					this.resetTask();
					return false;
				}
			}
			else return false;
		}
		
	}
}