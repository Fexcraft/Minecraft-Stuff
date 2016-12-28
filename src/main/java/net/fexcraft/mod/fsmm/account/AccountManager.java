package net.fexcraft.mod.fsmm.account;

import java.io.File;
import java.util.Calendar;
import java.util.HashSet;
import java.util.UUID;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fsmm.FSMM;
import net.fexcraft.mod.fsmm.util.Util;
import net.fexcraft.mod.lib.util.cls.Print;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

public class AccountManager{
	
	public HashSet<Account> accounts = new HashSet<Account>();
	public HashSet<IBank> banks = new HashSet<IBank>();
	public static File account_save_directory;// = new File(FSMM.config_path, "/fsmm/accounts");
	public static File bank_save_directory;// = new File(FSMM.config_path, "/fsmm/banks");
	
	public void initialize(File file){
		account_save_directory = new File(file, "/fsmm/accounts/");
		bank_save_directory = new File(file, "/fsmm/banks/");
		if(!account_save_directory.exists()){
			account_save_directory.mkdirs();
		}
		if(!bank_save_directory.exists()){
			bank_save_directory.mkdirs();
		}
	}
	
	public void registerBank(IBank bank){
		bank.loadBank();
		banks.add(bank);
	}
	
	public void getBank(UUID id){
		getBank(id.toString());
	}
	
	public IBank getBank(String id){
		for(IBank bank : banks){
			if(bank.getIdAsString().equals(id)){
				return bank;
			}
		}
		for(IBank bank : banks){
			if(bank.getIdAsString().equals(FSMM.default_bank.toString())){
				return bank;
			}
		}
		return null;
	}
	
	public void unregisterBank(UUID id){
		unregisterBank(id.toString());
	}
	
	public void unregisterBank(String id){
		IBank toRemove = null;
		for(IBank bank : banks){
			if(bank.getIdAsString().equals(id)){
				toRemove = bank;
				break;
			}
		}
		if(toRemove != null){
			banks.remove(toRemove);
		}
	}
	
	public Account getAccountOf(UUID id){
		return getAccountOf("player", id.toString());
	}
	
	public Account getAccountOf(String type, String string){
		Account account = null;
		for(Account acc : accounts){
			if(acc.getIdAsString().equals(string)){
				account = acc;
			}
		}
		if(account == null){
			account = loadAccount(type, string);
		}
		if(account == null){
			account = createAccount(type, string);
		}
		return account;
	}

	public Account loadAccount(String type, String string){
		File file = new File(account_save_directory, type + "/" + string + ".fd");
		if(file.exists()){
			JsonObject obj = JsonUtil.get(file);
			float balance = obj.get("balance").getAsFloat();
			String uuid = obj.get("uuid").getAsString();
			String bank_id = obj.get("bank").getAsString();
			String tp = obj.get("type").getAsString();
			JsonObject objj = obj.get("data").getAsJsonObject();
			Account account = new Account(balance, uuid, bank_id, objj, tp);
			accounts.add(account);
			return account;
		}
		else return null;
	}

	public Account createAccount(String type, String string){
		JsonObject obj = new JsonObject();
		obj.addProperty("balance", FSMM.starting_balance);
		obj.addProperty("uuid", string);
		obj.addProperty("bank", FSMM.default_bank.toString());
		obj.add("data", new JsonObject());
		obj.addProperty("type", type);
		File file = new File(account_save_directory, type + "/" + string + ".fd");
		JsonUtil.write(file, obj);
		Account account = new Account(FSMM.starting_balance, string, FSMM.default_bank.toString(), new JsonObject(), type);
		accounts.add(account);
		return account;
	}
	
	public void saveAccount(Account account){
		JsonObject obj = new JsonObject();
		obj.addProperty("balance", account.balance);
		obj.addProperty("uuid", account.id.toString());
		obj.addProperty("bank", account.bank_id.toString());
		obj.add("data", account.data);
		obj.addProperty("type", account.type);
		File folder = new File(account_save_directory, account.type + "/");
		if(!folder.exists()){
			folder.mkdirs();
		}
		File file = new File(folder, account.id.toString() + ".fd");
		JsonUtil.write(file, obj);
	}

	public static class Account{
		private float balance;
		private String id;
		private UUID bank_id;
		private JsonObject data;
		private String type;
		
		public Account(float bal, String id, String bi, JsonObject obj, String type){
			this.balance = bal;
			this.id = id;//UUID.fromString(id);
			this.bank_id = UUID.fromString(bi);
			this.data = obj;
			this.type = type;
		}
		
		public float getBalance(){
			return balance;
		}
		
		public void addBalance(float d){
			balance += d;
			balance = Util.round(balance);
		}
		
		public void removeBalance(float d){
			balance -= d;
			balance = Util.round(balance);
		}
		
		public void setBalance(float d){
			balance = d;
			balance = Util.round(balance);
		}
		
		public String getId(){
			return id;
		}
		
		public String getIdAsString(){
			return id.toString();
		}
		
		public UUID getBankId(){
			return bank_id;
		}
		
		public String getBankIdAsString(){
			return bank_id.toString();
		}
		
		public void add(float d){
			balance += d;
			balance = Util.round(balance);
		}
		
		public void subtract(float d){
			balance -= d;
			balance = Util.round(balance);
		}
		
		public JsonObject getData(){
			return data;
		}
		
		public void setData(JsonObject obj){
			data = obj;
		}
		
		public String getAccountType(){
			return type;
		}
		
		public void setAccountType(String string){
			type = string;
		}
		
		public static AccountManager getAccountManager(){
			return FSMM.getInstance().getAccountManager();
		}
	}
	
	public static class DefaultBank implements IBank {
		
		private JsonObject data;
		private UUID uuid;
		private String name;
		private float balance;
		
		public DefaultBank(){
			data = new JsonObject();
			uuid = FSMM.default_bank;
			name = "FSMM Bank";
		}
		
		@Override
		public UUID getId(){
			return uuid;
		}
		
		@Override
		public String getName(){
			return name;
		}

		@Override
		public String getIdAsString() {
			return uuid.toString();
		}

		@Override
		public JsonObject getData() {
			return data;
		}

		@Override
		public void setData(JsonObject obj) {
			data = obj;
		}

		@Override
		public boolean processTransfer(Account sender, float amount, Account target){
			if(amount < 0){
				log(s(sender) + " -> " + s(target) + ": Transfer failed! Amount null or negative. (T:" + amount + ");");
				Print.log(s(sender) + " tried to transfer a negative amout of money to " + s(target) + "!");
				return false;
			}
			if(Util.round(sender.balance - amount) >= 0){
				sender.subtract(amount);
				target.add(amount);
				log(s(sender) + " -> (T:" + amount + ") -> " + s(target) + ";");
				return true;
			}
			log(s(sender) + " -> " + s(target) + ": Transfer failed! Sender don't has enough money. (T:" + amount + ");");
			return false;
		}

		@Override
		public boolean processWithdraw(EntityPlayer player, Account account, float amount){
			if(amount < 0){
				log(s(account) + ": Withdraw failed! Amount is negative. (W:" + amount + " || B:" + account.balance + ");");
				Print.log(s(account) + " tried to withdraw a negative amout of money!");
				return false;
			}
			if(account.getAccountType().equals("player")){
				if(player != null){
					if(Util.round(account.balance - amount) >= 0){
						ItemManager.addToInventory(player, amount);
						account.subtract(amount);
						log(s(account) + " -> (W:" + amount + ") -> WITHDRAWN;");
						return true;
					}
					log(s(account) + ": Withdraw failed! Player don't has enough money. (W:" + amount + " || B:" + account.balance + ");");
					return false;
				}
				log(s(account) + ": Withdraw failed! Player Entity is null. (W:" + amount + " || B:" + account.balance + ");");
				return false;
			}
			else{
				Print.log("[FSMM] Default FSMM Bank has only methods for player accounts!");
				Print.log("[FSMM] Account with ID '" + account.getIdAsString() + "' and type '" + account.getAccountType() + "' tried to withdraw " + amount + "F$.");
				return false;
			}
		}

		@Override
		public boolean processDeposit(EntityPlayer player, Account account, float amount){
			if(amount < 0){
				log(s(account) + ": Deposit failed! Amount is negative. (D:" + amount + " || B:" + account.balance + ");");
				Print.log(s(account) + " tried to deposit a negative amout of money!");
				return false;
			}
			if(account.getAccountType().equals("player")){
				if(player != null){
					if(Util.round(account.balance + amount) >= 0){
						if(Util.round(ItemManager.countMoneyInInventoryOf(player) - amount) >= 0){
							ItemManager.removeFromInventory(player, amount);
							account.add(amount);
							log(s(account) + " -> (D:" + amount + ") -> DEPOSITED;");
							return true;
						}
						else{
							log(s(account) + ": Deposit failed! Not enough money in Inventory. (D:" + amount + " || B:" + account.balance + ");");
							return false;
						}
					}
					log(s(account) + ": Deposit failed! Result is negative. (D:" + amount + " || B:" + account.balance + ");");
					return false;
				}
				log(s(account) + ": Deposit failed! Player Entity is null. (D:" + amount + " || B:" + account.balance + ");");
				return false;
			}
			else{
				Print.log("[FSMM] Default FSMM Bank has only methods for player accounts!");
				Print.log("[FSMM] Account with ID '" + account.getIdAsString() + "' and type '" + account.getAccountType() + "' tried to deposit " + amount + "F$.");
				return false;
			}
		}

		@Override
		public void loadBank() {
			File file = new File(bank_save_directory, getIdAsString() + ".fd");
			JsonObject obj = JsonUtil.get(file);
			if(obj.has("uuid")){
				uuid = UUID.fromString(obj.get("uuid").getAsString());
			}
			if(obj.has("name")){
				name = obj.get("name").getAsString();
			}
			if(obj.has("data")){
				data = obj.get("data").getAsJsonObject();
			}
		}

		@Override
		public void saveBank() {
			File file = new File(bank_save_directory, getIdAsString() + ".fd");
			JsonObject obj = new JsonObject();
			obj.addProperty("uuid", uuid.toString());
			obj.addProperty("name", name);
			obj.add("data", data);
			JsonUtil.write(file, obj);
		}
		
		public static AccountManager getAccountManager(){
			return FSMM.getInstance().getAccountManager();
		}
		
	}

	public void saveAll(){
		for(Account account : accounts){
			saveAccount(account);
		}
		for(IBank bank : banks){
			bank.saveBank();
		}
		if(FSMM.debug){
			Print.log("[FSMM] Saved Account and Bank data.");
		}
	}
	
	public static class TickHandler {
		private static int tick = 0;
		
		@SubscribeEvent
		public void onServerTick(TickEvent.ServerTickEvent event) {
			if(event.phase == Phase.START){
				tick++;
				if(tick >= 1200){
					tick = 0;
				}
				if(tick == 0 || tick == 300 || tick == 600 || tick == 900){
					int m = Calendar.getInstance().get(Calendar.MINUTE);
					if(m == 0 || m == 15 || m == 30 || m == 45 || m == 60){
						FSMM.getInstance().getAccountManager().saveAll();
					}
				}
			}
		}
	}
	
	private static void log(String s){
		if(FSMM.debug){
			Print.log(s);
		}
	}
	
	private static String s(Account acc){
		return "[" + acc.type + ":" + acc.id + "]";
	}
	
}