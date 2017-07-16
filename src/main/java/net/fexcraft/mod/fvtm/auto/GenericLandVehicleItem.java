package net.fexcraft.mod.fvtm.auto;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.LandVehicle;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleData;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleItem;
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

public class GenericLandVehicleItem extends Item implements LandVehicleItem {
	
	public static final GenericLandVehicleItem INSTANCE = new GenericLandVehicleItem();
	
	public GenericLandVehicleItem(){
		this.setCreativeTab(Tabs.LANDVEHICLES);
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);
		this.setRegistryName("fvtm:landvehicles");
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
			LandVehicleData veh = new GenericLandVehicleData().readFromNBT(stack.getTagCompound());
			if(veh == null){
				return;
			}
			tooltip.add(Formatter.format("&9Name: &7" + veh.getVehicle().getName()));
			for(String s : veh.getVehicle().getDescription()){
				tooltip.add(Formatter.format(s));
			}
			tooltip.add(Formatter.format("&9Selected Texture: &7" + veh.getSelectedTexture()));
			if(veh.getInstalledParts().size() > 0){
				tooltip.add(Formatter.format("&3Installed Parts:"));
				for(PartData part : veh.getParts().values()){
					tooltip.add(Formatter.format(part.getPart().getName() + " &7(" + part.getPart().getCategory() + ")"));
				}
			}
		}
    }
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
        if(this.isInCreativeTab(tab)){
        	for(LandVehicle veh : Resources.LANDVEHICLES.getValues()){
        		ItemStack stack = new ItemStack(this);
        		NBTTagCompound nbt = new NBTTagCompound();
        		nbt.setString(NBTKEY, veh.getRegistryName().toString());
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
	public LandVehicleData getLandVehicle(ItemStack stack) {
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
			return new GenericLandVehicleData().readFromNBT(stack.getTagCompound());
		}
		return null;
	}
	
}