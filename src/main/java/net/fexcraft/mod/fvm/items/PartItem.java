package net.fexcraft.mod.fvm.items;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import net.fexcraft.mod.fvm.data.LoadedIn;
import net.fexcraft.mod.fvm.data.PartType;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.api.item.fItem;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@fItem(modid = FvmResources.MODID, name = PartItem.NAME)
public class PartItem extends Item {
	
	private static final ArrayList<PartType> types = new ArrayList<PartType>();
	protected static final String NAME = "part_item";
	
	public PartItem(){
		this.setCreativeTab(FvmResources.PARTS);
		this.setHasSubtypes(true);
		this.setMaxStackSize(1);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack){
		if(stack.getMetadata() >= types.size() || stack.getMetadata() == 0){
			return "item." + this.getRegistryName().toString();
		}
		return "item." + this.getRegistryName().toString() + "_" + types.get(stack.getMetadata()).registryname;
	}
	
	public static void addPart(PartType type){
		if(types.isEmpty()){
			types.add(new PartType(LoadedIn.NULL, null));
		}
		if(types.size() >= Short.MAX_VALUE){
			Print.log("REACHED PART LIMIT IN DEFAULT PART ITEM");
			Static.halt();
			return;
		}
		types.add(type);
		Item item = Registry.getItem("fvm:part_item");
		type.setItem(new ItemStack(item, 1, types.size() - 1));
	}

	public static void reRegisterItemModels(){
		Item item = Registry.getItem(FvmResources.MODID + ":" + NAME);
		net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
		for(int i = 1; i < types.size(); i++){
			net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName().toString() + "_" + types.get(i).registryname, "inventory"));
		}
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
		PartType type = null;
		if(stack.getMetadata() == 0){
			if(stack.hasTagCompound() && stack.getTagCompound().hasKey("PartType")){
				type = new PartType(LoadedIn.NULL, JsonUtil.getObjectFromString(stack.getTagCompound().getString("PartType")));
			}
			else{
				type = new PartType(LoadedIn.NULL, null);
			}
		}
		else{
			type = types.get(stack.getMetadata());
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
		for(int i = 1; i < types.size(); i++){
			subItems.add(new ItemStack(itemIn, 1, i));
		}
    }

	public static PartType getType(ItemStack itemstack){
		if(itemstack.getMetadata() >= types.size()){
			return types.get(0);
		}
		return types.get(itemstack.getMetadata());
	}
	
}