package net.fexcraft.mod.nvr.server.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.nvr.common.enums.Mode;
import net.fexcraft.mod.nvr.server.NVR;
import net.fexcraft.mod.nvr.server.data.Chunk;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ImageCache {
	
	private static File deffile = new File(NVR.IMAGE_DIR, "empty.png");
	private static Color defgreen = Color.decode("#8CDBB8"), defblue = Color.decode("#908CDB");
	
	public static final boolean exists(int x, int z, Mode mode){
		switch(mode){
			case CLAIM: case TYPE: case GEOGRAPHIC:{
				return getChunkFile(0, x, z, mode).exists();
			}
			default: return true;
		}
	}
	
	public static final String getRegion(int x, int z){
		return (int)Math.floor(x / 32.0) + "_" + (int)Math.floor(z / 32.0);
	}
	
	public static final File getChunkFile(int zoom, int x, int z, Mode mode){
		return new File(NVR.IMAGE_DIR, "z" + zoom + "/" + getRegion(x, z) + "/" + mode.getFilePrefix() + "/" + x + "_" + z + ".png");
	}

	public static final InputStream getEmptyChunkImage() throws IOException {
		if(!deffile.exists()){
			BufferedImage img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
			for(int i = 0; i < 16; i++){
				for(int j = 0; j < 16; j++){
					img.setRGB(i, j, Color.BLACK.getRGB());
				}
			}
			ImageIO.write(img, "png", deffile);
		}
		return new FileInputStream(deffile);
	}

	public static final InputStream get(int zoom, int x, int z, Mode mode) throws FileNotFoundException {
		return new FileInputStream(getChunkFile(zoom, x, z, mode));
	}
	
	public static final void updateChunk(World world, Chunk chunk, Mode mode){
		Static.getServer().addScheduledTask(new Runnable(){
			@Override
			public void run(){
				BufferedImage img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
				File file = getChunkFile(0, chunk.x, chunk.z, mode);
				if(mode == Mode.GEOGRAPHIC){
					for(int i = 0; i < 16; i++){
						for(int j = 0; j < 16; j++){
							BlockPos pos = getPos(world, i + (16 * chunk.x), j + (chunk.z * 16));
							IBlockState state = world.getBlockState(pos);
							img.setRGB(i, j, new Color(state.getMapColor(world, pos).colorValue).getRGB());
						}
					}
				}
				else{
					Color color = mode == Mode.CLAIM ? (chunk.district.id <= -1 ? defgreen : defblue) : (mode == Mode.TYPE ? chunk.type.getColor() : Color.GRAY);
					for(int i = 0; i < 16; i++){
						for(int j = 0; j < 16; j++){
							img.setRGB(i, j, color.getRGB());
						}
					}
				}
				try{
					if(!file.getParentFile().exists()){
						file.getParentFile().mkdirs();
					}
					ImageIO.write(img, "png", file);
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		});
	}

	private static final BlockPos getPos(World world, int x, int z){
		for(int i = 255; i > 0; i--){
			BlockPos pos = new BlockPos(x, i, z);
			if(world.getBlockState(pos).getBlock() != Blocks.AIR){
				return pos;
			}
		}
		return new BlockPos(x, 0, z);
	}
	
}