package net.fexcraft.mod.fvm.items;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvm.data.Material;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.fvm.util.FvmTabs;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MaterialItem extends Item {
	
	public static final MaterialItem INSTANCE = new MaterialItem();
	
	public MaterialItem(){
		this.setCreativeTab(FvmTabs.MATERIALS);
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);
		this.setRegistryName("fvm:material");
		this.setUnlocalizedName(this.getRegistryName().toString());
	}
	
	public static class MaterialItemMesh implements ItemMeshDefinition {

		@Override
		public final ModelResourceLocation getModelLocation(ItemStack stack){
			return new ModelResourceLocation(INSTANCE.getRegistryName() + getSuffix(stack), "inventory");
		}

		private final String getSuffix(ItemStack stack){
			if(stack.hasTagCompound()){
				return "_" + stack.getTagCompound().getString("Material").split(":")[1];
			}
			return "";
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
		//TODO
    }
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
        if(this.isInCreativeTab(tab)){
        	for(Material material : FvmResources.MATERIALS.getValues()){
        		ItemStack stack = new ItemStack(this);
        		NBTTagCompound nbt = new NBTTagCompound();
        		nbt.setString("Material", material.getRegistryName().toString());
        		stack.setTagCompound(nbt);
                items.add(stack);
        	}
        }
    }
	
	@Override
	public String getUnlocalizedName(ItemStack stack){
		if(stack.hasTagCompound()){
			return this.getUnlocalizedName() + "_" + stack.getTagCompound().getString("Material").split(":")[1];
		}
        return this.getUnlocalizedName();
    }
	
}