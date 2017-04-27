package net.fexcraft.mod.fsu.server.modules.esc;

import net.fexcraft.mod.fsu.server.FSU;
import net.fexcraft.mod.fsu.server.modules.IModule;
import net.fexcraft.mod.fsu.server.modules.fModule;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@fModule(config_description = "Entity Spawn Control", def_enabled = true, id = "esc")
public class EntitySpawnControl implements IModule<EntitySpawnControl> {
	
	private EntitySpawnControl instance;
	private boolean enabled;
	
	public EntitySpawnControl(){
		instance = this;
	}
	
	@Override
	public String getId(){
		return "esc";
	}

	@Override
	public void preInit(FMLPreInitializationEvent event){
		return;
	}

	@Override
	public void init(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event){
		return;
	}

	@Override
	public void serverStart(FMLServerStartingEvent event){
		return;
	}

	@Override
	public void serverStop(FMLServerStoppingEvent event){
		return;
	}

	@Override
	public void setEnabled(boolean bool){
		enabled = bool;
	}

	@Override
	public boolean isEnabled(){
		return enabled;
	}
	
    @SubscribeEvent
    public void despawnEntity(LivingUpdateEvent event){
    	if(event.getEntity() instanceof EntityZombie){
    		event.getEntity().setDead();
    	}
    	if(event.getEntity() instanceof EntityCreeper){
    		event.getEntity().setDead();
    	}
    	if(event.getEntity() instanceof EntitySkeleton){
    		event.getEntity().setDead();
    	}
    	if(event.getEntity() instanceof EntityWitch){
    		event.getEntity().setDead();
    	}
    	if(event.getEntity() instanceof EntityGhast){
    		event.getEntity().setDead();
    	}
    	if(event.getEntity() instanceof EntityPigZombie){
    		event.getEntity().setDead();
    	}
    	if(event.getEntity() instanceof EntityWither){
    		event.getEntity().setDead();
    	}
    	if(event.getEntity() instanceof EntityEnderman){
    		event.getEntity().setDead();
    	}
    	if(event.getEntity() instanceof EntityDragon){
    		event.getEntity().setDead();
    	}
    	
    	if(FSU.isModuleEnabled("nrr")){
    		//
    	}
    	/*if(Server.nrr && event.getEntityLiving() instanceof EntityLivingBase && (event.getEntityLiving() instanceof EntityPlayer) == false  && (event.getEntityLiving() instanceof EntityVillager) == false){
    		Chunk ck = Data.getChunk(event.getEntity().world, event.getEntity().getPosition());
    		if(ck.province.id == 0){
    			event.getEntity().setDead();
    		}
    	}*/
    }
    
	@SubscribeEvent
	public void onSpawn(EntityEvent event){
		if(event.getEntity() instanceof EntityTNTPrimed){
			event.getEntity().setDead();
		}
	}

	@Override
	public EntitySpawnControl getInstace(){
		return instance;
	}
	
}