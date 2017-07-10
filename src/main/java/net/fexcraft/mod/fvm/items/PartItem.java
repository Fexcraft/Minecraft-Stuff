package net.fexcraft.mod.fvm.items;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvm.data.Part;
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

public class PartItem extends Item {
	
	public static final PartItem INSTANCE = new PartItem();
	
	public PartItem(){
		this.setCreativeTab(FvmTabs.MATERIALS);
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);
		this.setRegistryName("fvm:part");
		this.setUnlocalizedName(this.getRegistryName().toString());
	}
	
	public static class PartItemMesh implements ItemMeshDefinition {

		@Override
		public final ModelResourceLocation getModelLocation(ItemStack stack){
			return new ModelResourceLocation(stack.getItem().getRegistryName().toString() + getSuffix(stack), "inventory");
		}

		private final String getSuffix(ItemStack stack){
			if(stack.hasTagCompound()){
				return "_" + stack.getTagCompound().getString("Part").split(":")[1];
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
        	for(Part material : FvmResources.PARTS.getValues()){
        		ItemStack stack = new ItemStack(this);
        		NBTTagCompound nbt = new NBTTagCompound();
        		nbt.setString("Part", material.getRegistryName().toString());
        		stack.setTagCompound(nbt);
                items.add(stack);
        	}
        }
    }
	
	@Override
	public String getUnlocalizedName(ItemStack stack){
		if(stack.hasTagCompound()){
			return this.getUnlocalizedName() + "_" + stack.getTagCompound().getString("Part").split(":")[1];
		}
        return this.getUnlocalizedName();
    }
	
}