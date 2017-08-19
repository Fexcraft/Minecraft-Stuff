package net.fexcraft.mod.addons.gep.attributes;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.blocks.ConstructorController.Button;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class InventoryAttribute implements Attribute {

	private static final ResourceLocation rs = new ResourceLocation("inventory");
	private int size;
	private ArrayList<ItemStack> whitelist = new ArrayList<ItemStack>();
	
	@Override
	public ResourceLocation getRegistryName(){
		return rs;
	}

	@Override
	public void load(JsonObject obj){
		size = JsonUtil.getIfExists(obj, "Inventory-Size", 4).intValue();
		if(obj.has("Inventory-Whitelist")){
			obj.get("Inventory-Whitelist").getAsJsonArray().forEach((elm) -> {
				JsonObject jsn = elm.getAsJsonObject();
				try{
					whitelist.add(new ItemStack(Item.getByNameOrId(JsonUtil.getIfExists(jsn, "id", "minecraft:stone")), 1, JsonUtil.getIfExists(obj, "meta", 0).intValue()));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			});
		}
	}

	@Override
	public String getName(){
		return "Inventory Attribute";
	}

	@Override
	public NBTTagCompound getScreen(NBTTagCompound compound, PartData part, int selection, int scroll){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onButtonPress(Button button, EntityPlayer player, String[] args){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag){
		tooltip.add(Formatter.format("&9Inventory Size: &7" + size));
	}

	@Override
	public boolean hasDataClass(){
		return true;
	}

	@Override
	public Class<? extends AttributeData> getDataClass(){
		return InventoryAttributeData.class;
	}
	
	public static class InventoryAttributeData implements AttributeData {
		
		private NonNullList<ItemStack> stacks;
		
		public InventoryAttributeData(PartData data, Attribute attr){
			stacks = NonNullList.<ItemStack>withSize(((InventoryAttribute)attr).size, ItemStack.EMPTY);
		}

		@Override
		public NBTTagCompound writeToNBT(PartData data, NBTTagCompound compound){
			compound.setTag("inventory", ItemStackHelper.saveAllItems(new NBTTagCompound(), stacks));
			return compound;
		}

		@Override
		public AttributeData readFromNBT(PartData data, NBTTagCompound compound){
			ItemStackHelper.loadAllItems(compound.getCompoundTag("inventory"), stacks);
			return this;
		}

		public NonNullList<ItemStack> getInventory(){
			return stacks;
		}
		
	}
	
	public int getSize(){
		return size;
	}
	
	public ArrayList<ItemStack> getItemWhitelist(){
		return whitelist;
	}
	
}