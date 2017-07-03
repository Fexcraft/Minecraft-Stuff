package net.fexcraft.mod.fsmm.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

public class GuiFactory implements IModGuiFactory {

	@Override
	public void initialize(Minecraft minecraftInstance){
		//
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories(){
		return null;
	}
	
	public static class ConfigGui extends GuiConfig {

		public ConfigGui(GuiScreen parent){
			super(parent, getList(), "fsmm", true, true, "FSMM Settings");
			titleLine2 = FsmmConfig.getConfig().getConfigFile().getAbsolutePath();
		}
		
		public static List<IConfigElement> getList(){
			List<IConfigElement> list = new ArrayList<IConfigElement>();
			list.add(new ConfigElement(FsmmConfig.getConfig().getCategory("General")));
			list.add(new ConfigElement(FsmmConfig.getConfig().getCategory("Logging")));
			return list;
		}
		
	}

	@Override
	public boolean hasConfigGui(){
		return true;
	}

	@Override
	public GuiScreen createConfigGui(GuiScreen parentScreen){
		return new ConfigGui(parentScreen);
	}
	
}