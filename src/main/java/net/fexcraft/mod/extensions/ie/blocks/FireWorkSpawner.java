package net.fexcraft.mod.extensions.ie.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.fexcraft.mod.extensions.ie.util.EFIO;
import net.fexcraft.mod.extensions.ie.util.Ticker;
import net.fexcraft.mod.extensions.ie.util.EFIO.EnumIO;
import net.fexcraft.mod.frsm.util.SSC;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.frsm.util.java.BoolUtil;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.api.block.IMashineBlock;
import net.fexcraft.mod.lib.api.item.ICableEditorItem;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.api.tileentity.ICableTileEntity;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.fexcraft.mod.lib.util.cls.EnumMashineType;
import net.fexcraft.mod.lib.util.cls.Print;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFirework;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FireWorkSpawner extends FBC_4R implements IMashineBlock{

	public FireWorkSpawner() {
		super(Material.IRON);
		this.setRegistryName("frsm_ie", getName());
		this.setUnlocalizedName(this.getRegistryName().toString());
		GameRegistry.register(this);
		BlockUtil.registerFIB(this);
	}

	@Override
	public boolean isMashine() {
		return true;
	}

	@Override
	public String getName() {
		return "test_fireworkspawner";
	}

	@Override
	public EnumMashineType getMashineType() {
		return EnumMashineType.OTHER;
	}
	
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new FWSTE();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState state, World w, BlockPos pos, Random random){
		w.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, pos.getX() + 0.5F, pos.getY() + 0.7F, pos.getZ() + 0.5F, 0.0D, 0.10D, 0.0D);
		w.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, pos.getX() + 0.5F, pos.getY() + 0.7F, pos.getZ() + 0.5F, 0.0D, 0.05D, 0.0D);
		w.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, pos.getX() + 0.5F, pos.getY() + 0.7F, pos.getZ() + 0.5F, 0.0D, 0.10D, 0.0D);
		w.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, pos.getX() + 0.5F, pos.getY() + 0.7F, pos.getZ() + 0.5F, 0.0D, 0.05D, 0.0D);
	}
	
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		if(!w.isRemote && hand == EnumHand.MAIN_HAND){
			if(p.getHeldItemMainhand() != null && p.getHeldItemMainhand().getItem() instanceof ItemFirework){
				((FWSTE)w.getTileEntity(pos)).stack = p.getHeldItemMainhand().copy();
				w.getTileEntity(pos).getUpdatePacket();
				Print.chat(p, "Item set.");
			}
			if(p.getHeldItemMainhand() == null){
				((FWSTE)w.getTileEntity(pos)).on = BoolUtil.reverse(((FWSTE)w.getTileEntity(pos)).on);
			}
			Print.chat(p, CCS.GRAY + ((ICableTileEntity)w.getTileEntity(pos)).fpu_get(side));
			Print.chat(p, CCS.GREEN + ((ICableTileEntity)w.getTileEntity(pos)).fpu_input().getName());
			((ICableTileEntity)w.getTileEntity(pos)).detectAndSendChanges(side);
			return true;
		}
		return false;
	}
	
	public static class FWSTE extends TileEntity implements ITickable, IPacketReceiver, ICableTileEntity{

		private int power, powerls;
		private EFIO input, copy;
		private int s;
		private ItemStack stack;
		public boolean on;
		private boolean onls;
		
		public FWSTE(){
			power = 0;
			powerls = -1;
			input = new EFIO(EnumFacing.UP, EnumIO.INPUT, 2);
			copy = new EFIO(EnumFacing.UP, EnumIO.INPUT, 2);
			stack = new ItemStack(Items.FIREWORKS, 1);
			on = onls = false;
		}
		
		@Override
		public String getContainerName(){
			return "Test FireWork Spawner";
		}

		@Override
		public String getContainerId(){
			return "test_firework_spawner";
		}

		@Override
		public boolean isMashine(){
			return true;
		}

		@Override
		public int fpu_get(EnumFacing ef){
			return power;
		}

		@Override
		public void detectAndSendChanges(EnumFacing ef){
			if(powerls != power){
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setInteger("fpu", power);
				SSC.getPacketHandler().sendToAll(new PacketTileEntityUpdate(pos, nbt));
				powerls = power;
			}
			if(onls != on){
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setBoolean("on", on);
				SSC.getPacketHandler().sendToAll(new PacketTileEntityUpdate(pos, nbt));
				onls = on;
			}
		}

		@Override
		public void processServerPacket(IPacket pkt) {
			//
		}

		@Override
		public void processClientPacket(IPacket packet) {
			PacketTileEntityUpdate pkt = (PacketTileEntityUpdate)packet;
			if(pkt.nbt.hasKey("fpu")){
				power = pkt.nbt.getInteger("fpu");
			}
			if(pkt.nbt.hasKey("on")){
				on = pkt.nbt.getBoolean("on");
			}
			/*if(pkt.nbt.hasKey("stack")){
				stack.readFromNBT((NBTTagCompound)pkt.nbt.getTag("stack"));
			}*/
		}
		
		private int sec = -1;

		@Override
		public void update() {
			while(worldObj.isRemote){
				return;
			}
			if(sec != Ticker.sec){
				sec = Ticker.sec;
				check();
				if(power >= 10 && on){
					EntityFireworkRocket entityfireworkrocket = new EntityFireworkRocket(worldObj, (double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 1.5F), (double)((float)pos.getZ() + 0.5F), stack);
		            worldObj.spawnEntityInWorld(entityfireworkrocket);
		            power -= 10;
		            this.detectAndSendChanges(null);
				}
			}
		}
		
		public void check(){
			if(input.facing == null || input.facing.equals(EnumFacing.UP)){
				switch(this.getBlockMetadata()){
					case 2: input.facing = EnumFacing.SOUTH; break;
					case 3: input.facing = EnumFacing.NORTH; break;
					case 4: input.facing = EnumFacing.EAST;  break;
					case 5: input.facing = EnumFacing.WEST;  break;
				}
			}
			else return;
		}

		@Override
		public void onEditorItemInteract(EnumFacing ef, ICableEditorItem edit, ItemStack item, EntityPlayer player) {
			//
		}
		
		@Override
		public NBTTagCompound getUpdateTag(){
			NBTTagCompound nbt = new NBTTagCompound();
			nbt = this.writeToNBT(nbt);
			return nbt;
		}
		
		@Override
		public SPacketUpdateTileEntity getUpdatePacket(){
			NBTTagCompound nbt = new NBTTagCompound();
			nbt = this.writeToNBT(nbt);
			return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), nbt);
		}
		
		@Override
		public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
			this.readFromNBT(pkt.getNbtCompound());
		}
		
		@Override
		public NBTTagCompound writeToNBT(NBTTagCompound compound){
			super.writeToNBT(compound);
			compound.setInteger("fpu", power);;
			compound.setBoolean("on", on);
			compound.setTag("stack", stack.writeToNBT(new NBTTagCompound()));
			return compound;
		}
		
		@Override
		public void readFromNBT(NBTTagCompound compound){
			super.readFromNBT(compound);
			power = compound.getInteger("fpu");
			on = compound.getBoolean("on");
			stack.readFromNBT((NBTTagCompound)compound.getTag("stack"));
		}

		@Override
		public void fpu_add(EnumFacing ef, int e) {
			power += e;
		}

		@Override
		public void fpu_subtract(EnumFacing ef, int e) {
			power -= e;
		}

		@Override
		public int fpu_max(EnumFacing ef){
			return 250;//200//100//50
		}

		@Override
		public int fpu_min(EnumFacing ef){
			return 0;
		}

		@Override
		public int fpu_transfer_speed(EnumFacing ef){
			return 10;
		}

		@Override
		public int fpu_min_transfer_speed(EnumFacing ef){
			return 2;
		}

		@Override
		public EnumFacing fpu_input(){
			return input.facing;
		}

		@Override
		public boolean fpu_isInput(EnumFacing ef){
			return input.facing.equals(ef);
		}

		@Override
		public EnumFacing fpu_output(){
			return null;
		}

		@Override
		public boolean fpu_isOutput(EnumFacing ef){
			return false;
		}

		@Override
		public void fpu_setInput(EnumFacing ef, int i) {
			input.facing = ef;
		}

		@Override
		public void fpu_setOutput(EnumFacing ef, int i) {
			//
		}

		@Override
		public int fpu_resistivity(EnumFacing ef){
			return 0;
		}

		@Override
		public void fpu_set(EnumFacing ef, int e) {
			power += e;
		}
	}
}