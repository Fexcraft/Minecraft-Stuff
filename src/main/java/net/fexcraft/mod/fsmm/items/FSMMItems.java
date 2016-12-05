package net.fexcraft.mod.fsmm.items;

import net.minecraft.item.Item;

public final class FSMMItems {

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
	
	public static void init() {
		
		cent1		= new FSMMItem("1cent",			0.01F);   MoneyItems.addItemToMap((IMoneyItem)cent1);
		cent2		= new FSMMItem("2cent",			0.02F);   MoneyItems.addItemToMap((IMoneyItem)cent2);
		cent5		= new FSMMItem("5cent",			0.05F);   MoneyItems.addItemToMap((IMoneyItem)cent5);
		cent10		= new FSMMItem("10cent",		0.10F);   MoneyItems.addItemToMap((IMoneyItem)cent10);
		cent20		= new FSMMItem("20cent",		0.20F);   MoneyItems.addItemToMap((IMoneyItem)cent20);
		cent50		= new FSMMItem("50cent",		0.50F);   MoneyItems.addItemToMap((IMoneyItem)cent50);
		foney1		= new FSMMItem("1foney",		1F);      MoneyItems.addItemToMap((IMoneyItem)foney1);
		foney2		= new FSMMItem("2foney",		2F);      MoneyItems.addItemToMap((IMoneyItem)foney2);
		foney5		= new FSMMItem("5foney",		5F);      MoneyItems.addItemToMap((IMoneyItem)foney5);
		foney10		= new FSMMItem("10foney",		10F);     MoneyItems.addItemToMap((IMoneyItem)foney10);
		foney20		= new FSMMItem("20foney",		20F);     MoneyItems.addItemToMap((IMoneyItem)foney20);
		foney50		= new FSMMItem("50foney",		50F);     MoneyItems.addItemToMap((IMoneyItem)foney50);
		foney100	= new FSMMItem("100foney",		100F);    MoneyItems.addItemToMap((IMoneyItem)foney100);
		foney200	= new FSMMItem("200foney",		200F);    MoneyItems.addItemToMap((IMoneyItem)foney200);
		foney500	= new FSMMItem("500foney",		500F);    MoneyItems.addItemToMap((IMoneyItem)foney500);
		foney1000	= new FSMMItem("1000foney",		1000F);   MoneyItems.addItemToMap((IMoneyItem)foney1000);
		foney2000	= new FSMMItem("2000foney",		2000F);   MoneyItems.addItemToMap((IMoneyItem)foney2000);
		foney5000	= new FSMMItem("5000foney",		5000F);   MoneyItems.addItemToMap((IMoneyItem)foney5000);
		foney10000	= new FSMMItem("10000foney",	10000F);  MoneyItems.addItemToMap((IMoneyItem)foney10000);
		foney20000	= new FSMMItem("20000foney",	20000F);  MoneyItems.addItemToMap((IMoneyItem)foney20000);
		foney50000	= new FSMMItem("50000foney",	50000F);  MoneyItems.addItemToMap((IMoneyItem)foney50000);
		foney100k	= new FSMMItem("100kfoney",		100000F); MoneyItems.addItemToMap((IMoneyItem)foney100k);
		foney200k	= new FSMMItem("200kfoney", 	200000F); MoneyItems.addItemToMap((IMoneyItem)foney200k);
		foney500k	= new FSMMItem("500kfoney",		500000F); MoneyItems.addItemToMap((IMoneyItem)foney500k);
		
	}
}