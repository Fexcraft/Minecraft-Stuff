package net.fexcraft.mod.frsm.util;

import net.fexcraft.mod.lib.api.common.öCreativeTab;
import net.fexcraft.mod.lib.api.common.öLoad;
import net.minecraft.creativetab.CreativeTabs;

@öLoad(true)
public class CD {
	
	@öCreativeTab(name = "frsm_blocks", icon="frsm:woodenlightbox")
	public static CreativeTabs BLOCKS;
	
	@öCreativeTab(name = "frsm_eatables", icon="frsm:cheese")
	public static CreativeTabs EATABLES;
	
	@öCreativeTab(name = "frsm_materials", icon="frsm:jar")
	public static CreativeTabs MATERIALS;
	
	@öCreativeTab(name = "frsm_tools", icon="frsm:ironsaw")
	public static CreativeTabs TOOLS;
	
	@öCreativeTab(name = "frsm_technic", icon="frsm:tvs")
	public static CreativeTabs TECHNIC;
	
	@öCreativeTab(name = "frsm_models", icon="frsm:model_rail")
	public static CreativeTabs MODELS;
	
	@öCreativeTab(name = "frsm_robots")
	public static CreativeTabs ROBOTS;
	
	@öCreativeTab(name = "frsm_experimental", icon="frsm:tbm")
	public static CreativeTabs EXPERIMENTAL;
	
	@öCreativeTab(name = "frsm_pipes", icon="frsm:pipe1")
	public static CreativeTabs PIPES;
	
	@öCreativeTab(name = "frsm_streets", icon="frsm:asphaltfull")
	public static CreativeTabs STREETS;
	
	@öCreativeTab(name = "frsm_treepots", icon="frsm:tree_pot", meta = 3)
	public static CreativeTabs TREEPOTS;
	
}