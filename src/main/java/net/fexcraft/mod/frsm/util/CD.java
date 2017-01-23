package net.fexcraft.mod.frsm.util;

import net.fexcraft.mod.lib.api.common.�CreativeTab;
import net.fexcraft.mod.lib.api.common.�Load;
import net.minecraft.creativetab.CreativeTabs;

@�Load(true)
public class CD {
	
	@�CreativeTab(name = "frsm_blocks", icon="frsm:woodenlightbox")
	public static CreativeTabs BLOCKS;
	
	@�CreativeTab(name = "frsm_eatables", icon="frsm:cheese")
	public static CreativeTabs EATABLES;
	
	@�CreativeTab(name = "frsm_materials", icon="frsm:jar")
	public static CreativeTabs MATERIALS;
	
	@�CreativeTab(name = "frsm_tools", icon="frsm:ironsaw")
	public static CreativeTabs TOOLS;
	
	@�CreativeTab(name = "frsm_technic", icon="frsm:tvs")
	public static CreativeTabs TECHNIC;
	
	@�CreativeTab(name = "frsm_models", icon="frsm:model_rail")
	public static CreativeTabs MODELS;
	
	@�CreativeTab(name = "frsm_robots")
	public static CreativeTabs ROBOTS;
	
	@�CreativeTab(name = "frsm_experimental", icon="frsm:tbm")
	public static CreativeTabs EXPERIMENTAL;
	
	@�CreativeTab(name = "frsm_pipes", icon="frsm:pipe1")
	public static CreativeTabs PIPES;
	
	@�CreativeTab(name = "frsm_streets", icon="frsm:asphaltfull")
	public static CreativeTabs STREETS;
	
	@�CreativeTab(name = "frsm_treepots", icon="frsm:tree_pot", meta = 3)
	public static CreativeTabs TREEPOTS;
	
}