package net.fexcraft.mod.fsmm.items;

import net.minecraft.item.Item;

public final class FsmmItems {

	public static Item cent1;
	public static Item cent2;
	public static Item cent5;
	public static Item cent10;
	public static Item cent20;
	public static Item cent50;
	public static Item foney1;
	public static Item foney2;
	public static Item foney5;
	public static Item foney10;
	public static Item foney20;
	public static Item foney50;
	public static Item foney100;
	public static Item foney200;
	public static Item foney500;
	public static Item foney1000;
	public static Item foney2000;
	public static Item foney5000;
	public static Item foney10000;
	public static Item foney20000;
	public static Item foney50000;
	public static Item foney100k;
	public static Item foney200k;
	public static Item foney500k;
	
	public static void initialize() {
		cent1		= new MoneyItem("1cent",			0.01F);
		cent2		= new MoneyItem("2cent",			0.02F);
		cent5		= new MoneyItem("5cent",			0.05F);
		cent10		= new MoneyItem("10cent",		0.10F);
		cent20		= new MoneyItem("20cent",		0.20F);
		cent50		= new MoneyItem("50cent",		0.50F);
		foney1		= new MoneyItem("1foney",		1F);
		foney2		= new MoneyItem("2foney",		2F);
		foney5		= new MoneyItem("5foney",		5F);
		foney10		= new MoneyItem("10foney",		10F);
		foney20		= new MoneyItem("20foney",		20F);
		foney50		= new MoneyItem("50foney",		50F);
		foney100	= new MoneyItem("100foney",		100F);
		foney200	= new MoneyItem("200foney",		200F);
		foney500	= new MoneyItem("500foney",		500F);
		foney1000	= new MoneyItem("1000foney",		1000F);
		foney2000	= new MoneyItem("2000foney",		2000F);
		foney5000	= new MoneyItem("5000foney",		5000F);
		foney10000	= new MoneyItem("10000foney",	10000F);
		foney20000	= new MoneyItem("20000foney",	20000F);
		foney50000	= new MoneyItem("50000foney",	50000F);
		foney100k	= new MoneyItem("100kfoney",		100000F);
		foney200k	= new MoneyItem("200kfoney", 	200000F);
		foney500k	= new MoneyItem("500kfoney",		500000F);
	}
	
}