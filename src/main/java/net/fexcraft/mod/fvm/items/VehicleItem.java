package net.fexcraft.mod.fvm.items;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import net.fexcraft.mod.fvm.data.LoadedIn;
import net.fexcraft.mod.fvm.data.PartType;
import net.fexcraft.mod.fvm.data.VehicleType;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//@fItem(modid = FvmResources.MODID, name = VehicleItem.NAME)
public class VehicleItem extends Item {
	
	private static final ArrayList<VehicleItem> vehicles = new ArrayList<VehicleItem>();
	private VehicleType type;
	
	public VehicleItem(VehicleType vehicle){
		this.setCreativeTab(FvmResources.VEHICLES);
		this.setHasSubtypes(true);
		this.setMaxStackSize(1);
		this.type = vehicle;
		this.type.setItem(this);
		
		Registry.registerItemManually(FvmResources.MODID, "vehicle_" + vehicle.registryname, 0, null, this);
	}
	
	public static void addVehicle(VehicleType type){
		if(vehicles.isEmpty()){
			vehicles.add(new VehicleItem(new VehicleType(LoadedIn.NULL, true)));
		}
		vehicles.add(new VehicleItem(type));
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected){
		if(!stack.hasTagCompound()){
			stack.setTagCompound(type.write(new NBTTagCompound()));
		}
    }
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
		VehicleType type = null;
		if(this.type.registryname.equals("item") && stack.hasTagCompound() && stack.getTagCompound().hasKey("VehicleType")){
			type = new VehicleType(LoadedIn.NULL, stack.getTagCompound());
		}
		else{
			type = this.type;
		}
		tooltip.add("Vehicle: " + type.fullname);
		if(type.description.size() > 0){
			for(String s : type.description){
				tooltip.add(s);
			}
		}
		if(advanced){
			tooltip.add("- - - - - - - -");
			for(Entry<String, PartType> part : type.parts.entrySet()){
				tooltip.add(part.getValue().fullname + TextFormatting.AQUA + " (" + part.getKey().replace("_", " ") + ")");
			}
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
		/*for(int i = 1; i < types.size(); i++){
			subItems.add(new ItemStack(itemIn, 1, i));
		}*/
    }

	public static VehicleType getType(ItemStack itemstack){
		if(itemstack.getItem() instanceof VehicleItem == false){
			return null;
		}
		return ((VehicleItem)itemstack.getItem()).type;
	}
	
	/*@Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(worldIn.isRemote || facing != EnumFacing.UP){
            return EnumActionResult.FAIL;
        }
        else if (!player.canPlayerEdit(pos.offset(facing), facing, player.getHeldItem(hand))){
            return EnumActionResult.FAIL;
        }
        else if(worldIn.getBlockState(pos).isSideSolid(worldIn, pos, facing) && worldIn.isAirBlock(pos.up())){
        	ItemStack stack = player.getHeldItemMainhand();
            EntityLandVehicle vehicle = new EntityLandVehicle(worldIn, FvmResources.getNewInstanceOf(LoadedIn.ENTITY, stack));
            vehicle.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
            worldIn.spawnEntity(vehicle);
            return EnumActionResult.PASS;
        }
        else{
            return EnumActionResult.FAIL;
        }
    }*/
	
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entityplayer, EnumHand hand){
		if(!FvmResources.FFMM || !this.type.registryname.equals("item")){
			return new ActionResult(EnumActionResult.PASS, entityplayer.getHeldItemMainhand());
		}
        float cosYaw = MathHelper.cos(-entityplayer.rotationYaw * 0.01745329F - 3.141593F);
        float sinYaw = MathHelper.sin(-entityplayer.rotationYaw * 0.01745329F - 3.141593F);
        float cosPitch = -MathHelper.cos(-entityplayer.rotationPitch * 0.01745329F);
        float sinPitch = MathHelper.sin(-entityplayer.rotationPitch * 0.01745329F);
        double length = 5D;
        Vec3d posVec = new Vec3d(entityplayer.posX, entityplayer.posY + 1.62D - entityplayer.getYOffset(), entityplayer.posZ);        
        Vec3d lookVec = posVec.addVector(sinYaw * cosPitch * length, sinPitch * length, cosYaw * cosPitch * length);
        RayTraceResult movingobjectposition = world.rayTraceBlocks(posVec, lookVec, false/*water*/);
        
        if(movingobjectposition == null){
            return new ActionResult(EnumActionResult.PASS, entityplayer.getHeldItemMainhand());
        }
        if(movingobjectposition.typeOfHit == RayTraceResult.Type.BLOCK){
            BlockPos pos = movingobjectposition.getBlockPos();
            //Block block = world.getBlockState(pos).getBlock();
            //if(type.placeableOnLand || block instanceof BlockLiquid){
	            if(!world.isRemote){
	        		VehicleType type = FvmResources.getNewInstanceOf(LoadedIn.ENTITY, entityplayer.getHeldItemMainhand());
	        		Print.debug(type.toString());
					world.spawnEntity(new com.flansmod.fvm.LandVehicle(world, (double)pos.getX() + 0.5F, (double)pos.getY() + 2.5F, (double)pos.getZ() + 0.5F, entityplayer, type));
	            }
				if(!entityplayer.capabilities.isCreativeMode){	
					entityplayer.getHeldItemMainhand().shrink(1);
				}
			//}
		}
		return new ActionResult(EnumActionResult.SUCCESS, entityplayer.getHeldItemMainhand());
	}
	
}