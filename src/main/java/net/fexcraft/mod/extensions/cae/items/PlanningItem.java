package net.fexcraft.mod.extensions.cae.items;

import java.util.List;

import net.fexcraft.mod.extensions.cae.CustomAsphaltExtension;
import net.fexcraft.mod.extensions.cae.CustomAsphaltExtension.FI;
import net.fexcraft.mod.extensions.cae.blocks.CAB2;
import net.fexcraft.mod.extensions.cae.blocks.CustomAsphaltBlock;
import net.fexcraft.mod.extensions.cae.util.CAEUtil;
import net.fexcraft.mod.extensions.cae.util.Type;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.api.network.IISPR;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.network.packet.PacketJsonObject;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PlanningItem extends Item implements IItem, IISPR{
	
	private char[] array;
	private Type type;
	
	public PlanningItem(){
		type = type.x16;
		array = type.getEmptyArray();
		this.setCreativeTab(CD.TOOLS.getCreativeTab());
		ItemUtil.register(FI.MODID, this);
		ItemUtil.registerRender(this);
	}
	
	@Override
	public String getName(){
		return "planning_item";
	}

	@Override
	public int getVariantAmount(){
		return 0;
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(worldIn.getBlockState(pos).getBlock() instanceof CustomAsphaltBlock || worldIn.getBlockState(pos).getBlock() instanceof CAB2){
			return EnumActionResult.PASS;
		}
		playerIn.openGui(CustomAsphaltExtension.getInstance(), 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return EnumActionResult.SUCCESS;
	}
	
	@SideOnly(Side.CLIENT) @Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
		if(stack.getTagCompound() == null || !stack.getTagCompound().hasKey("frsm_cae_type")){
			tooltip.add("No data.");
		}
		else{
			Type type = Type.fromString(stack.getTagCompound().getString("frsm_cae_type"));
			int[][] arr = CAEUtil.intXZfromCharArray(type, stack.getTagCompound().getString("frsm_cae_array").toCharArray());
			tooltip.add("Type: " + type.toString());
			if(type.N() < 17){
				for(int x = 0; x < type.N(); x++){
					String s = "";
					for(int z = 0; z < type.N(); z++){
						int i = arr[x][z];
						s += (i == 1 ? CCS.WHITE + "#" : CCS.DGRAY + "#");
					}
					tooltip.add(s);
				}
			}
			else{
				tooltip.add("Can't display sizes larger then x16.");
			}
		}
	}

	@Override
	public void processServerPacket(IPacket pkt, ItemStack stack){
		PacketJsonObject packet = (PacketJsonObject)pkt;
		this.type = Type.fromString(packet.obj.get("type").getAsString());
		this.array = packet.obj.get("array").getAsString().toCharArray();
		if(stack.getTagCompound() == null){
			stack.setTagCompound(new NBTTagCompound());
		}
		stack.getTagCompound().setString("frsm_cae_type", type.toString());
		stack.getTagCompound().setString("frsm_cae_array", new String(array));
	}

	@Override
	public void processClientPacket(IPacket pkt, ItemStack stack){
		PacketJsonObject packet = (PacketJsonObject)pkt;
		this.type = Type.fromString(packet.obj.get("type").getAsString());
		this.array = packet.obj.get("array").getAsString().toCharArray();
		if(stack.getTagCompound() == null){
			stack.setTagCompound(new NBTTagCompound());
		}
		stack.getTagCompound().setString("frsm_cae_type", type.toString());
		stack.getTagCompound().setString("frsm_cae_array", new String(array));
	}

	@Override
	public void requestNBT(EntityPlayer player){
		//
	}

	@Override
	public NBTTagCompound getRequest(){
		return null;
	}
	
}