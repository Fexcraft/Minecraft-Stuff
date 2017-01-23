package net.fexcraft.mod.frsm.util.block;

import net.fexcraft.mod.frsm.util.CCS;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class FBC_4R_L extends FBC_4R {
	
	public String bname;
	protected String s = CCS.GRAY;
	protected String f = "frsm_lock_";
	
	public FBC_4R_L(Material material, String bname) {
    	super(material);
    	this.bname = CCS.AQUA + bname + CCS.GRAY;
	}
	
	//TODO UPDATE THIS
	
	@Override
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {	
		
		if (!w.isRemote && getConfigStatus()){
			NBTTagCompound TE = w.getTileEntity(pos).getTileData();
			ItemStack ei = p.getHeldItemMainhand();
			
			//Key Code
			if (ei != null && ei.getItem() == Registry.getItem("frsm:key")) {
				
				ItemStack key = p.getHeldItemMainhand().copy();
				String owner = key.getTagCompound().getString("owner");
				int code = key.getTagCompound().getInteger("code");
				
				if(TE == null || TE.getBoolean(f + "locked") == false){
					if(owner.equals(p.getName())){
						TE.setBoolean(f + "locked", true);
						TE.setInteger(f + "code", code);
						TE.setString(f + "type", "private");
						TE.setString(f + "owner", owner);
						TE.setString(f + "locker", p.getName());
						//p.addChatMessage(new ChatComponentText(s + "The " + bname + " has now the same password as your key."));
						return true;
					}
					else{
						//p.addChatMessage(new ChatComponentText(s + "You are not the key owner."));
						return false;
					}
				}
				if(TE.getBoolean(f + "locked") == true){
					if(owner.equals(p.getName())){
						if(TE.getInteger(f + "code") == code && TE.getString(f + "type") == "private"){
							if(TE.getString(f + "owner") == p.getName()){
								return ifLockedTrueKeyTrue(w, pos, state, p, side, hitX, hitY, hitZ);
							}
							else{
								//p.addChatMessage(new ChatComponentText(s + "This is not your " + bname));
								return false;
							}
						}
						else {
							//p.addChatMessage(new ChatComponentText(s + "False key."));
							return true;
						}
					}
					else{
						//p.addChatMessage(new ChatComponentText(s + "You are not the key owner."));
						return false;
					}
				}
				else return false;
			}
			//Key2 code
			if (ei != null && ei.getItem() == Registry.getItem("frsm:key2")) {
				
				ItemStack key = p.getHeldItemMainhand().copy();
				String owner = key.getTagCompound().getString("owner");
				int code = key.getTagCompound().getInteger("code");
				String sr = "shared";
				
				if(TE == null || TE.getBoolean(f + "locked") == false){
					TE.setBoolean(f + "locked", true);
					TE.setInteger(f + "code", code);
					TE.setString(f + "type", sr);
					TE.setString(f + "owner", owner);
					TE.setString(f + "locker", p.getName());
					//p.addChatMessage(new ChatComponentText(s + "The " + bname + " has now the same password as the key."));
					return true;
				}
				if(TE.getBoolean(f + "locked") == true){
					if(TE.getString(f + "type") == sr){
						if(TE.getInteger(f + "code") == code){
							return ifLockedTrueKeyTrue(w, pos, state, p, side, hitZ, hitZ, hitZ);
							
						}
						else{
							//p.addChatMessage(new ChatComponentText(s + "False code."));
							return true;
						}
					}
					if(TE.getString(f + "type") != "private" && TE.getString(f + "type") != "admin"){
						if(TE.getInteger(f + "code") == code){
							return ifLockedTrueKeyTrue(w, pos, state, p, side, hitZ, hitZ, hitZ);
							
						}
						else{
							//p.addChatMessage(new ChatComponentText(s + "False code."));
							return true;
						}
					}
					else {
						//p.addChatMessage(new ChatComponentText(s + "False key type."));
						return true;
					}
				}
				else return false;
			}
			//Key3 code
			if (ei != null && ei.getItem() == Registry.getItem("frsm:key3")){
				ItemStack key = p.getHeldItemMainhand().copy();
				String owner = key.getTagCompound().getString("owner");
				int code = key.getTagCompound().getInteger("code");
				
				if(p.getEntityData().getString("frsm_admin") == "true"){
					if(TE == null || TE.getBoolean(f + "locked") == false){
						if(owner.equals(p.getName())){
							TE.setBoolean(f + "locked", true);
							TE.setInteger(f + "code", code);
							TE.setString(f + "type", "admin");
							TE.setString(f + "owner", owner);
							TE.setString(f + "locker", p.getName());
							//p.addChatMessage(new ChatComponentText(s + "The " + bname + " has now the same password as your key."));
							return true;
						}
						else{
							//p.addChatMessage(new ChatComponentText(s + "You are not the key owner."));
							return false;
						}
					}
					else if(TE.getBoolean(f + "locked") == true){
						return ifLockedTrueKeyTrue(w, pos, state, p, side, hitZ, hitZ, hitZ);
					}
				}
				else if(p.getEntityData().getString("frsm_admin") == "false"){
					//p.addChatMessage(new ChatComponentText(s + "You don't have FRSM admin mode enabled!"));
					return false;
				}
			}
			//no Key code
			/*else if (ei != null && ei.getItem() != ModItems.key && ei.getItem() != ModItems.key2 && ei.getItem() != ModItems.key3){
				if(TE.getBoolean("locked") == true){
					return ifLockedTrueKeyFalse(w, pos, state, p, side, hitZ, hitZ, hitZ);
				}
				else{
					ifLockedFalse(w, pos, state, p, side, hitZ, hitZ, hitZ);
					return false;
				}
			}*/
			//End
			if(TE.getBoolean(f + "locked") == true){
				return ifLockedTrueKeyFalse(w, pos, state, p, side, hitZ, hitZ, hitZ);
			}
			else{
				return ifLockedFalse(w, pos, state, p, side, hitZ, hitZ, hitZ);
			}
		}
		else return false;
	}
	
	public boolean ifLockedFalse(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumFacing side, float hitX, float hitY, float hitZ){
		return false;
	}
	public boolean ifLockedTrueKeyFalse(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumFacing side, float hitX, float hitY, float hitZ){
		return false;
	}
	public boolean ifLockedTrueKeyTrue(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumFacing side, float hitX, float hitY, float hitZ){
		return false;
	}
	
	public boolean getConfigStatus(){
		return true;
	}
}