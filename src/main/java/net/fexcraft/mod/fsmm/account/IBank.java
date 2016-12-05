package net.fexcraft.mod.fsmm.account;

import java.util.UUID;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fsmm.account.AccountManager.Account;
import net.minecraft.entity.player.EntityPlayer;

public interface IBank {
	
	public UUID getId();
	
	public String getName();
	
	public String getIdAsString();
	
	public JsonObject getData();
	
	public void setData(JsonObject obj);
	
	public boolean processTransfer(Account sender, float amount, Account target);

	public boolean processWithdraw(EntityPlayer player, Account account, float amount);
	
	public boolean processDeposit(EntityPlayer player, Account account, float amount);
	
	public void loadBank();
	
	public void saveBank();
	
}