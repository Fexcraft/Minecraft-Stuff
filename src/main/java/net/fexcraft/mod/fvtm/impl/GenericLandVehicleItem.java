package net.fexcraft.mod.fvtm.impl;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.addons.gep.attributes.EngineAttribute;
import net.fexcraft.mod.fvtm.api.LandVehicle;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleData;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleItem;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericLandVehicleItem extends Item implements LandVehicleItem {
	
	public static final GenericLandVehicleItem INSTANCE = new GenericLandVehicleItem();
	
	public GenericLandVehicleItem(){
		this.setCreativeTab(Tabs.LANDVEHICLES);
		this.setHasSubtypes(true);
		this.setMaxStackSize(1);
		this.setRegistryName("fvtm:landvehicles");
		this.setUnlocalizedName(this.getRegistryName().toString());
	}
	
	@SideOnly(Side.CLIENT)
	public static class ItemMeshDef implements net.minecraft.client.renderer.ItemMeshDefinition {

		@Override
		public final net.minecraft.client.renderer.block.model.ModelResourceLocation getModelLocation(ItemStack stack){
			if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
				return new net.minecraft.client.renderer.block.model.ModelResourceLocation(new ResourceLocation(stack.getTagCompound().getString(NBTKEY)), "inventory");
			}
			return new net.minecraft.client.renderer.block.model.ModelResourceLocation(INSTANCE.getRegistryName(), "inventory");
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
			LandVehicleData veh = Resources.getLandVehicleData(stack.getTagCompound(), worldIn == null ? false/*true?*/ : worldIn.isRemote);
			if(veh == null){
				return;
			}
			tooltip.add(Formatter.format("&9Name: &7" + veh.getVehicle().getName()));
			for(String s : veh.getVehicle().getDescription()){
				tooltip.add(Formatter.format(s));
			}
			tooltip.add(Formatter.format("&9Lock Code: &r" + veh.getLockCode()));
			tooltip.add(Formatter.format("&9Selected Texture: &7" + veh.getSelectedTexture()));
			tooltip.add(Formatter.format("&9Fuel Tank: &7" + RGB.format(veh.getFuelTankContent()) + "&8/&e" + veh.getFuelTankSize()));
			tooltip.add(Formatter.format("&9Fuel Type: &7" + (veh.getPart("engine") == null ? "unknown / no engine" : veh.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelType().getName())));
			if(veh.getParts().size() > 0){
				tooltip.add(Formatter.format("&3Installed Parts:"));
				veh.getParts().forEach((key, data) -> {
					tooltip.add(Formatter.format("&7- &3" + data.getPart().getName() + " &7(" + key + ")"));
				});
			}
			if(veh.getVehicle().getModel() != null && veh.getVehicle().getModel().creators.size() > 0){
				tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
				tooltip.add(Formatter.format("&6Model by:"));
				for(String string : veh.getVehicle().getModel().creators){
					tooltip.add(Formatter.format("&7- &3" + string));
				}
			}
			tooltip.add(Formatter.format("&9Ready to Spawn: " + (veh.readyToSpawn() ? "&ayes" : "&cno")));
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
	public LandVehicleData getLandVehicle(ItemStack stack){
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
			return Resources.getLandVehicleData(stack.getTagCompound(), false);
		}
		return null;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entityplayer, EnumHand hand){
		//Raytracing
		float cosYaw = MathHelper.cos(-entityplayer.rotationYaw * 0.01745329F - 3.141593F);
		float sinYaw = MathHelper.sin(-entityplayer.rotationYaw * 0.01745329F - 3.141593F);
		float cosPitch = -MathHelper.cos(-entityplayer.rotationPitch * 0.01745329F);
		float sinPitch = MathHelper.sin(-entityplayer.rotationPitch * 0.01745329F);
		double length = 5D;
		Vec3d posVec = new Vec3d(entityplayer.posX, entityplayer.posY + 1.62D - entityplayer.getYOffset(), entityplayer.posZ);		
		Vec3d lookVec = posVec.addVector(sinYaw * cosPitch * length, sinPitch * length, cosYaw * cosPitch * length);
		RayTraceResult movingobjectposition = world.rayTraceBlocks(posVec, lookVec, true);
		
		//Result check
		if(movingobjectposition == null){
			return new ActionResult(EnumActionResult.PASS, entityplayer.getHeldItem(hand));
		}
		if(movingobjectposition.typeOfHit == RayTraceResult.Type.BLOCK){
			BlockPos pos = movingobjectposition.getBlockPos();
			if(!world.isRemote){
				world.spawnEntity(new com.flansmod.fvtm.LandVehicle(world, (double)pos.getX() + 0.5F, (double)pos.getY() + 2.5F, (double)pos.getZ() + 0.5F, entityplayer, this.getLandVehicle(entityplayer.getHeldItem(hand))));
			}
			if(!entityplayer.capabilities.isCreativeMode){
				entityplayer.getHeldItem(hand).shrink(1);
			}
		}
		return new ActionResult(EnumActionResult.SUCCESS, entityplayer.getHeldItemMainhand());
	}
	
}