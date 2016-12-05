package net.fexcraft.mod.frsm.items.keys;

import java.util.List;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class Key3 extends Item implements IItem{
	
	private String name = "key3";
	
	public Key3() {
		this.setCreativeTab(CD.TOOLS.getCreativeTab());
		this.setMaxStackSize(1);
		ItemUtil.register(FI.MODID, this);
	}
	
	@Override
	public String getName(){
		return name;
	}
	
	/*@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		itemstack.setTagCompound(new NBTTagCompound());
		NBTTagCompound nbt = itemstack.getTagCompound();
		nbt.setString("origin", "crafted");
		nbt.setString("owner", player.getName());
		nbt.setInteger("code", Item.itemRand.nextInt(9999));
	}*/
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int itemSlot, boolean isSelected) {
		if(itemstack.getTagCompound() == null){
			itemstack.setTagCompound(new NBTTagCompound());
			NBTTagCompound nbt = itemstack.getTagCompound();
			nbt.setString("origin", "cheated");
			nbt.setString("owner", entity.getName());
			nbt.setInteger("code", 0000);
		}
	}
	    
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4) {		
		if (itemstack.getTagCompound() != null) {
			NBTTagCompound nbt = itemstack.getTagCompound();
			String owner = nbt.getString("owner");
			int code = nbt.getInteger("code");
			if (owner.equals(player.getName())) {
				list.add("Key type: Admin");
			}
			if (!owner.equals(player.getName())) {
				list.add("Admin key, can be used only by Admins.");
			}
			list.add("Owner: " + owner);
			list.add(CCS.GREEN + "Code: " + code);
			if (itemstack.getTagCompound().getString("origin").equals("crafted")){
				list.add(CCS.GREEN + "Crafted");
			}
			if (itemstack.getTagCompound().getString("origin").equals("cheated")){
				list.add(CCS.RED + "Cheated");
			}
		}
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
}