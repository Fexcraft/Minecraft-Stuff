package net.fexcraft.mod.lib.util.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;

/**
 * 
 * @author Ferdinand (FEX___96)
 * 
 */
public class EntUtil{
	
	//for Flansmod
	public static void setFallDistance(Entity ent, float f){
		for(Entity e : ent.getPassengers()){
			e.fallDistance = f;
		}
	}
	
	//for Flansnmod
	public static boolean isPassengerInstanceOfELB(Entity ent){
		boolean result = false;
		if(getPassengerOf(ent) instanceof EntityLivingBase){
			result = true;
		}
		return result;
	}
	
	//for Flansmod
	public static Entity getPassengerOf(Entity ent){
		if(ent.getPassengers() != null){
			if(ent.getPassengers().size() > 0){
				return ent.getPassengers().get(0);
			}
			else{
				//System.out.println(ent.getName() + " X:" + ent.getPosition().getX() + " Y:" + ent.getPosition().getY() + " Z:" + ent.getPosition().getZ() + " || Passenger == null || List != null");
				return null;
			}
		}
		else{
			//System.out.println(ent.getName() + " X:" + ent.getPosition().getX() + " Y:" + ent.getPosition().getY() + " Z:" + ent.getPosition().getZ() + " || Passenger == null || List == null");
			return null;
		}
	}
	
	//for Flansmod
	public static EntityEquipmentSlot getEquipmentSlot(int i){
		switch(i){
			case 1:
				return EntityEquipmentSlot.HEAD;
			case 2:
				return EntityEquipmentSlot.CHEST;
			case 3:
				return EntityEquipmentSlot.LEGS;
			case 4:
				return EntityEquipmentSlot.FEET;
			default:
				return null;
		}
	}
	
	//for Flansmod
	public static EntityEquipmentSlot getEquipmentSlotAl(int i){
		switch(i){
			case 0:
				return EntityEquipmentSlot.HEAD;
			case 1:
				return EntityEquipmentSlot.CHEST;
			case 2:
				return EntityEquipmentSlot.LEGS;
			case 3:
				return EntityEquipmentSlot.FEET;
			default:
				return null;
		}
	}
	
}