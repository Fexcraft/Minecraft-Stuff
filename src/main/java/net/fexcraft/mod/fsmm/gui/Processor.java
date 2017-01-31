package net.fexcraft.mod.fsmm.gui;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fsmm.FSMM;
import net.fexcraft.mod.fsmm.account.AccountManager;
import net.fexcraft.mod.fsmm.account.AccountManager.Account;
import net.fexcraft.mod.fsmm.util.FsmmConfig;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketListener;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketJsonObject;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class Processor implements IPacketListener {

	@Override
	public String getId(){
		return "fsmm_atm_gui";
	}

	@Override
	public void process(IPacket packet, Object[] objs){
		try{
			PacketJsonObject pkt = (PacketJsonObject)packet;
			if(FsmmConfig.DEBUG){
				Print.log("PKT R - Server: " + pkt.obj.toString());
			}
			JsonObject obj = JsonUtil.getJsonForPacket("fsmm_atm_gui");
			EntityPlayerMP player = FMLCommonHandler.instance().getMinecraftServerInstance().getServer().getPlayerList().getPlayerByUsername(pkt.obj.get("sender").getAsString());
			AccountManager manager = FSMM.getInstance().getAccountManager();
			Account account = manager.getAccountOf(player.getGameProfile().getId());
			if(pkt.obj.has("task")){
				switch(pkt.obj.get("task").getAsString()){
					case "get_balance":
						obj.addProperty("balance", account.getBalance());
						obj.addProperty("log", "");
						break;
					case "deposit":
						obj.addProperty("log", "Deposited: " + manager.getBank(account.getBankIdAsString()).processDeposit(player, account, pkt.obj.get("amount").getAsFloat()));
						obj.addProperty("balance", account.getBalance());
						break;
					case "transfer":
						String rec = pkt.obj.get("receiver").getAsString();
						String[] ar = rec.split(":");
						Account receiver = null;
						if(ar.length > 1){
							receiver = manager.getAccountOf(ar[0], ar[1]);
						}
						else{
							receiver = manager.getAccountOf(FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerProfileCache().getGameProfileForUsername(rec).getId());
						}
						obj.addProperty("log", "Transferred: " + manager.getBank(account.getBankIdAsString()).processTransfer(account, pkt.obj.get("amount").getAsFloat(), receiver));
						obj.addProperty("balance", account.getBalance());
						break;
					case "withdraw":
						obj.addProperty("log", "Withdrawn: " + manager.getBank(account.getBankIdAsString()).processWithdraw(player, account, pkt.obj.get("amount").getAsFloat()));
						obj.addProperty("balance", account.getBalance());
						break;
					default:
						return;
				}
			}
			PacketHandler.getInstance().sendTo(new PacketJsonObject(obj), player);
			if(FsmmConfig.DEBUG){
				Print.log("PKT S - Client: " + obj.toString());
			}
		}
		catch(Exception ex){
			PacketJsonObject pkt = (PacketJsonObject)packet;
			EntityPlayerMP player = FMLCommonHandler.instance().getMinecraftServerInstance().getServer().getPlayerList().getPlayerByUsername(pkt.obj.get("sender").getAsString());
			JsonObject obj = JsonUtil.getJsonForPacket("fsmm_atm_gui");
			obj.addProperty("log", ex.getStackTrace().toString());
			PacketHandler.getInstance().sendTo(new PacketJsonObject(obj), player);
			if(FsmmConfig.DEBUG){
				Print.log("PKT S - Server: " + obj.toString());
			}
		}
	}
	
}