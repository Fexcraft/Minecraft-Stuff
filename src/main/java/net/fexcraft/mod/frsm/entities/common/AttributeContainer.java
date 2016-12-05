package net.fexcraft.mod.frsm.entities.common;

import net.minecraft.item.Item;

public class AttributeContainer{
	
	public double max_health;
	public double follow_range;
	public double movement_speed;
	public double attack_damage;
	public double armor;
	public boolean swim;
	public Item item;
	public float range;
	
	public AttributeContainer(double mh, double fr, double ms, double ad, double a, boolean swim, Item item){
		this.max_health = mh;
		this.follow_range = fr;
		this.movement_speed = ms;
		this.attack_damage = ad;
		this.armor = a;
		this.swim = swim;
		this.item = item;
	}
	
	public AttributeContainer(double mh, double fr, double ms, double ad, double a, boolean swim, Item item, float r){
		this.max_health = mh;
		this.follow_range = fr;
		this.movement_speed = ms;
		this.attack_damage = ad;
		this.armor = a;
		this.swim = swim;
		this.item = item;
		this.range = r;
	}
}