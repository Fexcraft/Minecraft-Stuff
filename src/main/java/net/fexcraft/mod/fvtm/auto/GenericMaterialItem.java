package net.fexcraft.mod.fvtm.auto;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Material.MaterialItem;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericMaterialItem extends Item implements MaterialItem {
	
	public static final GenericMaterialItem INSTANCE = new GenericMaterialItem();
	
	public GenericMaterialItem(){
		this.setCreativeTab(Tabs.MATERIALS);
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);
		this.setRegistryName("fvtm:material");
		this.setUnlocalizedName(this.getRegistryName().toString());
	}
	
	public static class ItemMeshDef implements ItemMeshDefinition {

		@Override
		public final ModelResourceLocation getModelLocation(ItemStack stack){
			if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
				return new ModelResourceLocation(new ResourceLocation(stack.getTagCompound().getString(NBTKEY)), "inventory");
			}
			return new ModelResourceLocation(INSTANCE.getRegistryName(), "inventory");
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
			Material mat = Resources.MATERIALS.getValue(new ResourceLocation(stack.getTagCompound().getString(NBTKEY)));
			if(mat == null){
				return;
			}
			tooltip.add(Formatter.format("&9Name: &7" + mat.getName()));
			for(String s : mat.getDescription()){
				tooltip.add(Formatter.format(s));
			}
		}
    }
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
        if(this.isInCreativeTab(tab)){
        	for(Material material : Resources.MATERIALS.getValues()){
        		ItemStack stack = new ItemStack(this);
        		NBTTagCompound nbt = new NBTTagCompound();
        		nbt.setString(NBTKEY, material.getRegistryName().toString());
        		stack.setTagCompound(nbt);
                items.add(stack);
        	}
        }
    }
	
	@Override
	public String getUnlocalizedName(ItemStack stack){
		if(stack.hasTagCompound()){
			return "item." + stack.getTagCompound().getString(NBTKEY);
		}
        return this.getUnlocalizedName();
    }

	@Override
	public Material getMaterial(ItemStack stack){
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
			return Resources.MATERIALS.getValue(new ResourceLocation(stack.getTagCompound().getString(NBTKEY)));
		}
		return null;
	}
	
}