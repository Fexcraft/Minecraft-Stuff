package net.fexcraft.mod.fsu.server.modules.nrr.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.fexcraft.mod.fsu.server.modules.nrr.NRR;
import net.fexcraft.mod.fsu.server.modules.nrr.data.Chunk;
import net.fexcraft.mod.lib.FCL;
import net.minecraft.world.World;

public class MappingUtil {
	
	public static class ProvinceMap {
		
		private static BufferedImage img;
		public static File file = new File(FCL.getInstance().getConfigDirectory().getParentFile(), "/fsu-nrr/map_0_0_province.png");
		
		public static void init(){
			if(file.exists()){
				try{
					img = ImageIO.read(file);
				}
				catch(IOException e){
					e.printStackTrace();
					img = new BufferedImage(1280, 1280, BufferedImage.TYPE_INT_ARGB);
				}
			}
			else{
				img = new BufferedImage(1280, 1280, BufferedImage.TYPE_INT_ARGB);
			}
			save();
		}
		
		public static void processChunk(World world, int x, int z){
			if(x > 640 || x < -640 || z > 640 || z < -640){
				return;
			}
			Chunk ck = NRR.getChunk(x, z);
			if(ck.province.id < 0){
				img.setRGB(x + 639, z + 639, colorFromBiome(ck.mainbiome));
			}
			else{
				img.setRGB(x + 639, z + 639, getColor(ck.province.hex).getRGB());
			}
		}
		
		private static int colorFromBiome(String biome){
			switch(biome){
				case "Ocean":
					return Color.CYAN.getRGB();
				case "Deep Ocean":
					return Color.BLUE.getRGB();
				case "River":
					return Color.LIGHT_GRAY.getRGB();
				default:
					return Color.DARK_GRAY.getRGB();
			}
		}
		
		public static void save(){
			try{
				ImageIO.write(img, "png", file);
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}

	public static void init(){
		ProvinceMap.init();
	}
	
	public static void save(){
		ProvinceMap.save();
	}
	
	/**
	 * @source http://stackoverflow.com/questions/4129666/how-to-convert-hex-to-rgb-using-java
	 * @param colorStr e.g. "#FFFFFF"
	 * @return 
	 */
	public static Color getColor(String colorStr) {
	    return new Color(Integer.valueOf(colorStr.substring(1, 3), 16), Integer.valueOf( colorStr.substring(3, 5), 16), Integer.valueOf( colorStr.substring(5, 7), 16));
	}
	
}