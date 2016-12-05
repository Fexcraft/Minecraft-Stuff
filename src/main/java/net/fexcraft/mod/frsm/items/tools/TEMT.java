package net.fexcraft.mod.frsm.items.tools;

import java.util.List;

import net.fexcraft.mod.frsm.FRSM;
import net.fexcraft.mod.frsm.guis.GuiHandler.GUIS;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.SSC;
import net.fexcraft.mod.frsm.util.block.FRSMTE;
import net.fexcraft.mod.frsm.util.block.TemtUtil;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.api.network.IISPR;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.network.packet.PacketItemStackUpdate;
import net.fexcraft.mod.lib.util.cls.ApiUtil;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TEMT extends Item implements IItem, IISPR{

	public TEMT(){
		this.setMaxStackSize(1);
		this.setCreativeTab(CD.TOOLS.getCreativeTab());
		ItemUtil.register(FI.MODID, this);
	}
	
	@Override
	public String getName(){
		return "temt";
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        IBlockState state = world.getBlockState(pos);
        if(state.getBlock() instanceof IBlock){
        	if(state.getBlock().hasTileEntity(state)){
        		TileEntity te = world.getTileEntity(pos);
        		if(te instanceof FRSMTE){
        			process(te, state, stack, player, world, pos, facing);
        		}
        	}
        }
        else{
        	player.openGui(FRSM.getInstance(), GUIS.TEMT, world, pos.getX(), pos.getY(), pos.getZ());
        }
		return EnumActionResult.PASS;
    }
	
	public void load(ItemStack stack){
		if(stack.getTagCompound() == null){
			stack.setTagCompound(new NBTTagCompound());
		}
		
		NBTTagCompound nbt = stack.getTagCompound();
		if(nbt.hasKey("frsm_mode")){
			this.mode = nbt.getString("frsm_mode");
		}
		else{
			nbt.setString("frsm_mode", "null");
			this.mode = "null";
		}
		if(nbt.hasKey("frsm_type")){
			this.type = nbt.getString("frsm_type");
		}
		else{
			nbt.setString("frsm_type", "null");
			this.type = "null";
		}
		if(nbt.hasKey("frsm_amount")){
			this.amount = nbt.getInteger("frsm_amount");
		}
		else{
			nbt.setInteger("frsm_amount", 0);
			this.amount = 0;
		}
		stack.setTagCompound(nbt);
		
	}

	private void process(TileEntity te, IBlockState state, ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing facing) {
		load(stack);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setBoolean("temt_packet", true);
		nbt.setString("temt_mode", mode);
		nbt.setString("temt_type", type);
		nbt.setInteger("temt_amount", amount);
		ApiUtil.sendTileEntityUpdatePacket(world, pos, nbt);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
		load(stack);
		tooltip.add(CCS.DAQUA + "Mode: " + CCS.AQUA + mode);
		tooltip.add(CCS.DAQUA + "Type: " + CCS.AQUA + type);
		tooltip.add(CCS.DAQUA + "Amount: " + CCS.AQUA + amount);
	}
	
	private String mode;
	private String type;
	private int amount;

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
	@Override
	public void processServerPacket(IPacket pkt, ItemStack stack) {
		PacketItemStackUpdate packet = (PacketItemStackUpdate)pkt;
		if(packet.nbt.hasKey("mode")){
			this.mode = packet.nbt.getString("mode");
			stack.getTagCompound().setString("frsm_mode", mode);
		}
		if(packet.nbt.hasKey("type")){
			this.type = packet.nbt.getString("type");
			stack.getTagCompound().setString("frsm_type", type);
		}
		if(packet.nbt.hasKey("amount")){
			this.amount = packet.nbt.getInteger("amount");
			stack.getTagCompound().setInteger("frsm_amount", amount);
		}
		if(packet.nbt.hasKey("request")){
			if(packet.nbt.getString("request").equals("nbt")){
				load(stack);
				TemtUtil.sendRequestPacket(SSC.getServer().getPlayerList().getPlayerByUsername(packet.player), stack.getTagCompound());
			}
		}
	}

	@Override
	public void processClientPacket(IPacket pkt, ItemStack stack) {
		PacketItemStackUpdate packet = (PacketItemStackUpdate)pkt;
		stack.setTagCompound(packet.nbt);
	}

	@Override
	public void requestNBT(EntityPlayer player){
		TemtUtil.sendUpdatePacket(player, "request", "nbt");
	}
	
	private NBTTagCompound request = new NBTTagCompound();
	
	@Override
	public NBTTagCompound getRequest(){
		return request;
	}
	
}