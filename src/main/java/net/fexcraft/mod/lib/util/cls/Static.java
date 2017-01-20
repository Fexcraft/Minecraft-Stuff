package net.fexcraft.mod.lib.util.cls;

import java.util.Random;

import net.minecraft.entity.MoverType;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

public class Static{
	
	public static final boolean NO = false;
	public static final boolean YES = true;
	
	public static final float sixteenth = 0.0625F;
	public static final float eighth = 0.125F;
	public static final float quarter = 0.250F;
	public static final float half = 0.5F;
	
	//
	
	//
	
	//
	
	public static final String Null_8 = "00000000";
	public static final String Null_16 = "0000000000000000";
	public static final String Null_32 = Null_16 + Null_16;
	public static final String Null_64 = Null_32 + Null_32;
	public static final String Null_128 = Null_64 + Null_64;
	public static final String Null_256 = Null_128 + Null_128;
	public static final String Null_512 = Null_256 + Null_256;
	public static final String Null_1024 = Null_512 + Null_512;
	public static final String Null_2048 = Null_1024 + Null_1024;
	public static final String Null_4096 = Null_2048 + Null_2048;
	public static final MoverType SELF = MoverType.SELF;
	public static final Random random = new Random();
	
	/** soon... **/
	//public static final String Unicode_Block_
	
	public static void halt(){
		FMLCommonHandler.instance().exitJava(1, true);
	}
	
	public static void stop(){
		if(dev()){
			halt();
		}
	}
	
	private static boolean dev = true, cdev = false;
	
	public static boolean dev(){
		if(cdev){
			return dev;
		}
		else{
			cdev = true;
			dev = (Boolean)Launch.blackboard.get("fml.deobfuscatedEnvironment");
		}
		return dev;
	}

	public static MinecraftServer getServer(){
		return FMLCommonHandler.instance().getMinecraftServerInstance();
	}
	
	public static Side side(){
		return FMLCommonHandler.instance().getSide();
	}
	
}