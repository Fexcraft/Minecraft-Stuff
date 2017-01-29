package net.fexcraft.mod.frsm.util;

import net.fexcraft.mod.lib.api.common.fCreativeTab;
import net.fexcraft.mod.lib.api.common.fLoad;
import net.minecraft.creativetab.CreativeTabs;

@fLoad(true)
public class CD {
	
	@fCreativeTab(name = "frsm_blocks", icon="frsm:woodenlightbox")
	public static CreativeTabs BLOCKS;
	
	@fCreativeTab(name = "frsm_eatables", icon="frsm:cheese")
	public static CreativeTabs EATABLES;
	
	@fCreativeTab(name = "frsm_materials", icon="frsm:jar")
	public static CreativeTabs MATERIALS;
	
	@fCreativeTab(name = "frsm_tools", icon="frsm:ironsaw")
	public static CreativeTabs TOOLS;
	
	@fCreativeTab(name = "frsm_technic", icon="frsm:tvs")
	public static CreativeTabs TECHNIC;
	
	@fCreativeTab(name = "frsm_models", icon="frsm:model_rail")
	public static CreativeTabs MODELS;
	
	@fCreativeTab(name = "frsm_robots")
	public static CreativeTabs ROBOTS;
	
	@fCreativeTab(name = "frsm_experimental", icon="frsm:tbm")
	public static CreativeTabs EXPERIMENTAL;
	
	@fCreativeTab(name = "frsm_pipes", icon="frsm:stove_pipe")
	public static CreativeTabs PIPES;
	
	@fCreativeTab(name = "frsm_streets", icon="frsm:asphaltfull")
	public static CreativeTabs STREETS;
	
	@fCreativeTab(name = "frsm_treepots", icon="frsm:tree_pot", meta = 3)
	public static CreativeTabs TREEPOTS;
	
}