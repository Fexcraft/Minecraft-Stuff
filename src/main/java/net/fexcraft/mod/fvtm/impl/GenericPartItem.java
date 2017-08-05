package net.fexcraft.mod.fvtm.impl;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
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

public class GenericPartItem extends Item implements PartItem {
	
	public static final GenericPartItem INSTANCE = new GenericPartItem();
	
	public GenericPartItem(){
		this.setCreativeTab(Tabs.PARTS);
		this.setHasSubtypes(true);
		this.setMaxStackSize(1);
		this.setRegistryName("fvtm:part");
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
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
			PartData part = Resources.getPartData(stack.getTagCompound());
			if(part == null){
				return;
			}
			tooltip.add(Formatter.format("&9Name: &7" + part.getPart().getName()));
			tooltip.add(Formatter.format("&9Type: &7" + part.getPart().getCategory()));
			for(String s : part.getPart().getDescription()){
				tooltip.add(Formatter.format(s));
			}
			tooltip.add(Formatter.format("&9Selected Texture: &7" + part.getSelectedTexture()));
			tooltip.add(Formatter.format("&9Current Offset: &8" + part.getCurrentOffset().toString()));
			for(Class clazz : part.getPart().getAttributeClasses()){
				part.getPart().getAttribute(clazz).addInformation(stack, world, tooltip, flag);
			}
		}
    }
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
        if(this.isInCreativeTab(tab)){
        	for(Part part : Resources.PARTS.getValues()){
        		ItemStack stack = new ItemStack(this);
        		NBTTagCompound nbt = new NBTTagCompound();
        		nbt.setString(NBTKEY, part.getRegistryName().toString());
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
	public PartData getPart(ItemStack stack){
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
			return Resources.getPartData(stack.getTagCompound());
		}
		return null;
	}
	
}