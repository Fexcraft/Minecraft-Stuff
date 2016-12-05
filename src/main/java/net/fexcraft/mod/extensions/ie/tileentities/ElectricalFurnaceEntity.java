package net.fexcraft.mod.extensions.ie.tileentities;

import net.fexcraft.mod.extensions.ie.util.Ticker;
import net.fexcraft.mod.frsm.util.SSC;
import net.fexcraft.mod.lib.api.item.ICableEditorItem;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.api.tileentity.ICableTileEntity;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ElectricalFurnaceEntity extends TileEntity implements ITickable, ISidedInventory, ICableTileEntity, IPacketReceiver{
	
	private static final int[] SLOTS_TOP = new int[] {0};
    private static final int[] SLOTS_BOTTOM = new int[] {2, 1};
    private static final int[] SLOTS_SIDES = new int[] {1};
    private ItemStack[] furnaceItemStacks = new ItemStack[3];
    private int furnaceBurnTime;
    private int cookTime;
    private int totalCookTime;
    
    private int power, powerls;
    //private EFIO input, copy;
    
    public ElectricalFurnaceEntity(){
    	power = 0;
    	powerls = -1;
    	//input = new EFIO(EnumFacing.UP, EnumIO.INPUT, 16);
    	//copy = new EFIO(EnumFacing.UP, EnumIO.INPUT, 16);
    }
	
	@Override
	public String getName(){
		return "electric_furnace";
	}

	@Override
	public boolean hasCustomName(){
		return false;
	}

	@Override
	public int getSizeInventory(){
		return this.furnaceItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int index){
		return this.furnaceItemStacks[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count){
		return ItemStackHelper.getAndSplit(this.furnaceItemStacks, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.furnaceItemStacks, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
        boolean flag = stack != null && stack.isItemEqual(this.furnaceItemStacks[index]) && ItemStack.areItemStackTagsEqual(stack, this.furnaceItemStacks[index]);
        this.furnaceItemStacks[index] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit()){
            stack.stackSize = this.getInventoryStackLimit();
        }

        if(index == 0 && !flag){
            this.totalCookTime = this.getSmeltTime();
            this.cookTime = 0;
            this.markDirty();
        }
	}
	
    public static void func_189676_a(DataFixer df){
        df.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists("Furnace", new String[] {"Items"}));
    }
    
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < nbttaglist.tagCount(); ++i){
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot");
            if (j >= 0 && j < this.furnaceItemStacks.length){
                this.furnaceItemStacks[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }
        this.furnaceBurnTime = compound.getInteger("BurnTime");
        this.cookTime = compound.getInteger("CookTime");
        this.totalCookTime = compound.getInteger("CookTimeTotal");
        
        this.power = compound.getInteger("fpu");
    }
    
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        compound.setInteger("BurnTime", this.furnaceBurnTime);
        compound.setInteger("CookTime", this.cookTime);
        compound.setInteger("CookTimeTotal", this.totalCookTime);
        NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < this.furnaceItemStacks.length; ++i){
            if (this.furnaceItemStacks[i] != null){
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                this.furnaceItemStacks[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }
        compound.setTag("Items", nbttaglist);
        
        compound.setInteger("fpu", power);
        return compound;
    }

	@Override
	public int getInventoryStackLimit(){
		return 64;
	}
	
    public boolean isBurning(){
        return this.power > this.fpu_min(null);
    }

    @SideOnly(Side.CLIENT)
    public static boolean isBurning(IInventory inventory){
        return inventory.getField(0) > 0;
    }
    
    private int sec = -1;
    
    public void update(){
        boolean flag = this.isBurning();
        boolean flag1 = false;
        
        if(sec != Ticker.sec){
        	this.detectAndSendChanges(null);
        	//this.check();
        	sec = Ticker.sec;
        }
        
        /*if(this.isBurning()){
        	--this.power;
        }*/
        boolean c = false;
        if(!this.worldObj.isRemote){
            if(this.isBurning() || this.furnaceItemStacks[1] != null && this.furnaceItemStacks[0] != null){
                if(this.isBurning() && this.canSmelt()){
                	c = true;
                    ++this.cookTime;
                    if(this.cookTime == this.totalCookTime){
                        this.cookTime = 0;
                        this.totalCookTime = this.getSmeltTime();
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else{
                    this.cookTime = 0;
                }
            }
            else if(!this.isBurning() && this.cookTime > 0){
                this.cookTime = MathHelper.clamp_int(this.cookTime - 2, 0, this.totalCookTime);
            }
            if(flag != this.isBurning()){
                flag1 = true;
            }
        }
        if(c){
        	--this.power;
        }
        if(flag1){
            this.markDirty();
        }
    }
    
    /*public void check(){
		if(input.facing == null || input.facing.equals(EnumFacing.UP)){
			switch(this.getBlockMetadata()){
				case 2: input.facing = EnumFacing.SOUTH; break;
				case 3: input.facing = EnumFacing.NORTH; break;
				case 4: input.facing = EnumFacing.EAST;  break;
				case 5: input.facing = EnumFacing.WEST;  break;
			}
		}
		else return;
	}*/

    public int getSmeltTime(){
        return 150;//200
    }
    
    private boolean canSmelt(){
        if(this.furnaceItemStacks[0] == null){
            return false;
        }
        else{
            ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.furnaceItemStacks[0]);
            if(itemstack == null) return false;
            if(this.furnaceItemStacks[2] == null) return true;
            if(!this.furnaceItemStacks[2].isItemEqual(itemstack)) return false;
            int result = furnaceItemStacks[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }
    
    public void smeltItem(){
        if(this.canSmelt()){
            ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.furnaceItemStacks[0]);
            if(this.furnaceItemStacks[2] == null){
                this.furnaceItemStacks[2] = itemstack.copy();
            }
            else if(this.furnaceItemStacks[2].getItem() == itemstack.getItem()){
                this.furnaceItemStacks[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }
            if(this.furnaceItemStacks[0].getItem() == Item.getItemFromBlock(Blocks.SPONGE) && this.furnaceItemStacks[0].getMetadata() == 1 && this.furnaceItemStacks[1] != null && this.furnaceItemStacks[1].getItem() == Items.BUCKET){
                this.furnaceItemStacks[1] = new ItemStack(Items.WATER_BUCKET);
            }
            --this.furnaceItemStacks[0].stackSize;
            if(this.furnaceItemStacks[0].stackSize <= 0){
                this.furnaceItemStacks[0] = null;
            }
        }
    }
    
    public boolean isUseableByPlayer(EntityPlayer player){
        return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    public void openInventory(EntityPlayer player){
    	
    }

    public void closeInventory(EntityPlayer player){
    	
    }
    
    public boolean isItemValidForSlot(int index, ItemStack stack){
        if (index == 2){
            return false;
        }
        else if (index != 1){
            return true;
        }
        else{
            ItemStack itemstack = this.furnaceItemStacks[1];
            return net.minecraftforge.fml.common.registry.GameRegistry.getFuelValue(stack) > 0 || SlotFurnaceFuel.isBucket(stack) && (itemstack == null || itemstack.getItem() != Items.BUCKET);
        }
    }

    public int[] getSlotsForFace(EnumFacing side){
        return side == EnumFacing.DOWN ? SLOTS_BOTTOM : (side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES);
    }
    
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction){
        return this.isItemValidForSlot(index, itemStackIn);
    }
    
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction){
        if (direction == EnumFacing.DOWN && index == 1){
            Item item = stack.getItem();
            if (item != Items.WATER_BUCKET && item != Items.BUCKET){
                return false;
            }
        }
        return true;
    }
    
    public String getGuiID(){
        return "frsm:furnace1";
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn){
        return new ContainerFurnace(playerInventory, this);
    }

    public int getField(int id){
        switch(id){
            case 0:
                return this.furnaceBurnTime;
            case 1:
                return 0;
            case 2:
                return this.cookTime;
            case 3:
                return this.totalCookTime;
            default:
                return 0;
        }
    }

    public void setField(int id, int value){
        switch (id){
            case 0:
                this.furnaceBurnTime = value;
                break;
            case 1:
                break;
            case 2:
                this.cookTime = value;
                break;
            case 3:
                this.totalCookTime = value;
        }
    }

    public int getFieldCount(){
        return 4;
    }

    public void clear(){
        for (int i = 0; i < this.furnaceItemStacks.length; ++i){
            this.furnaceItemStacks[i] = null;
        }
    }

    net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.UP);
    net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.DOWN);
    net.minecraftforge.items.IItemHandler handlerSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.WEST);

    @Override
    public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, net.minecraft.util.EnumFacing facing)
    {
        if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            if (facing == EnumFacing.DOWN)
                return (T) handlerBottom;
            else if (facing == EnumFacing.UP)
                return (T) handlerTop;
            else
                return (T) handlerSide;
        return super.getCapability(capability, facing);
    }
    
    //// <<<< ---- >>> \\\\

	@Override
	public String getContainerName(){
		return "Electric Furnace";
	}

	@Override
	public String getContainerId(){
		return getName();
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
	public void fpu_set(EnumFacing ef, int e) {
		power = e;
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
		return 1500;
	}

	@Override
	public int fpu_min(EnumFacing ef){
		return -10;
	}

	@Override
	public int fpu_transfer_speed(EnumFacing ef) {
		return 500;//200
	}

	@Override
	public int fpu_min_transfer_speed(EnumFacing ef){
		return 10;
	}

	@Override
	public EnumFacing fpu_input(){
		return null;
	}

	@Override
	public boolean fpu_isInput(EnumFacing ef){
		switch(ef){
			case EAST:
			case NORTH:
			case SOUTH:
			case WEST:
				return true;
			default:
				return false;
		}
		//return input.facing.equals(ef);
	}

	@Override
	public EnumFacing fpu_output(){
		return null;
	}

	@Override
	public boolean fpu_isOutput(EnumFacing ef) {
		return false;
	}

	@Override
	public void fpu_setInput(EnumFacing ef, int i) {
		//input.facing = ef;
	}

	@Override
	public void fpu_setOutput(EnumFacing ef, int i) {
		//
	}

	@Override
	public void detectAndSendChanges(EnumFacing ef) {
		if(powerls != power){
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setInteger("fpu", power);
			SSC.getPacketHandler().sendToAll(new PacketTileEntityUpdate(pos, nbt));
			powerls = power;
		}
	}

	@Override
	public int fpu_resistivity(EnumFacing ef){
		return 0;
	}

	@Override
	public void onEditorItemInteract(EnumFacing ef, ICableEditorItem edit, ItemStack item, EntityPlayer player) {
		//
	}

	@Override
	public void processServerPacket(IPacket packet) {
		//
	}

	@Override
	public void processClientPacket(IPacket packet) {
		PacketTileEntityUpdate pkt = (PacketTileEntityUpdate)packet;
		if(pkt.nbt.hasKey("fpu")){
			power = pkt.nbt.getInteger("fpu");
		}
		/*if(pkt.nbt.hasKey("on")){
			on = pkt.nbt.getBoolean("on");
		}*/
	}
}