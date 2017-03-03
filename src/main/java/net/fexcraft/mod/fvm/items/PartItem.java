package net.fexcraft.mod.fvm.items;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import net.fexcraft.mod.fvm.data.LoadedIn;
import net.fexcraft.mod.fvm.data.PartType;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//@fItem(modid = FvmResources.MODID, name = PartItem.NAME)
public class PartItem extends Item {
	
	private static ArrayList<PartItem> parts = new ArrayList<PartItem>();
	private PartType type;
	
	public PartItem(PartType part){
		this.setCreativeTab(FvmResources.PARTS);
		this.setHasSubtypes(true);
		this.setMaxStackSize(part.maxStackSize);
		this.type = part;
		this.type.setItem(this);
		
		Registry.registerItemManually(FvmResources.MODID, "part_" + type.registryname, 0, null, this);
	}
	
	public static void addPart(PartType type){
		if(parts.isEmpty()){
			parts.add(new PartItem(new PartType(LoadedIn.NULL, null)));
		}
		parts.add(new PartItem(type));
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
		if(type == null){
			return;
		}
		tooltip.add("Part: " + type.fullname);
		if(type.description.size() > 0){
			for(String s : type.description){
				tooltip.add(s);
			}
		}
		if(advanced){
			tooltip.add("- - - - - - - -");
			tooltip.add("Compatible with:");
			for(String string : type.compatible.keySet()){
				tooltip.add(StringUtils.capitalize(TextFormatting.AQUA + string));
			}
		}
		if(type.attributes.contains("engine")){
			tooltip.add("- - - - - - - -");
			tooltip.add("Engine_Speed: " + type.engineSpeed + "fmp");
			tooltip.add("Fuel Consupmtion: " + type.fuelConsumption);
		}
		if(type.getModel() != null){
			tooltip.add("- - - - - - - -");
			tooltip.add("Creators:");
			for(String s : type.getModel().creators){
				tooltip.add(s);
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems){
		subItems.add(new ItemStack(itemIn, 1, 0));
		/*for(int i = 1; i < parts.size(); i++){
			subItems.add(new ItemStack(itemIn, 1, i));
		}*/
    }

	public static PartType getType(ItemStack itemstack){
		if(itemstack.getItem() instanceof PartItem == false){
			return null;
		}
		return ((PartItem)itemstack.getItem()).type;
	}
	
}