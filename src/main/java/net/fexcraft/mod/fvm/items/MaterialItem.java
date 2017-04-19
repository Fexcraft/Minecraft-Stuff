package net.fexcraft.mod.fvm.items;

import java.util.ArrayList;
import java.util.List;

import net.fexcraft.mod.fvm.data.LoadedIn;
import net.fexcraft.mod.fvm.data.Material;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MaterialItem extends Item {
	
	private static ArrayList<MaterialItem> parts = new ArrayList<MaterialItem>();
	private Material type;
	
	public MaterialItem(Material type){
		this.setCreativeTab(FvmResources.MATERIALS);
		this.setHasSubtypes(true);
		this.setMaxStackSize(type.maxStackSize);
		this.type = type;
		this.type.setItem(this);
		
		Registry.registerItemManually(FvmResources.MODID, "material_" + type.registryname, 0, null, this);
	}
	
	public static void addMaterial(Material type){
		if(parts.isEmpty()){
			parts.add(new MaterialItem(new Material(LoadedIn.NULL, null)));
		}
		parts.add(new MaterialItem(type));
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
		if(type == null){
			return;
		}
		tooltip.add(Formatter.format("&9Material: &3" + type.fullname));
		if(type.description.size() > 0){
			for(String s : type.description){
				tooltip.add(s);
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems){
		if(((MaterialItem)itemIn).type.registryname.equals("null")){
			return;
		}
		subItems.add(new ItemStack(itemIn, 1, 0));
    }

	public static Material getType(ItemStack itemstack){
		if(itemstack.getItem() instanceof MaterialItem == false){
			return null;
		}
		return ((MaterialItem)itemstack.getItem()).type;
	}
	
}