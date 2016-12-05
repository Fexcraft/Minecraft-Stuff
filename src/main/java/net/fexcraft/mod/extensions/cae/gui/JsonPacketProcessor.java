package net.fexcraft.mod.extensions.cae.gui;

import com.google.gson.JsonObject;

import net.fexcraft.mod.extensions.cae.CustomAsphaltExtension;
import net.fexcraft.mod.extensions.cae.items.PlanningItem;
import net.fexcraft.mod.extensions.cae.util.Type;
import net.fexcraft.mod.frsm.util.PrintChat;
import net.fexcraft.mod.frsm.util.SSC;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketListener;
import net.fexcraft.mod.lib.network.packet.PacketJsonObject;
import net.fexcraft.mod.lib.util.cls.ApiUtil;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class JsonPacketProcessor{
	
	public static class Server implements IPacketListener{

		@Override
		public String getId(){
			return "cae";
		}

		@Override
		public void process(IPacket packet, Object[] objs){
			//Print.log("[CAE] PACKET RECEIVED! <<< SERVER");
			PacketJsonObject pkt = (PacketJsonObject)packet;
			if(pkt.obj.has("task")){
				JsonObject reply = JsonUtil.getJsonForPacket("cae");
				boolean send = true;
				switch(pkt.obj.get("task").getAsString()){
					case "reset_gui":
						reply.addProperty("type", pkt.obj.get("type").getAsString());
						reply.addProperty("task", "reset_gui");
						break;
					case "update_item":
						EntityPlayer player = SSC.getServer().getPlayerList().getPlayerByUsername(pkt.obj.get("player").getAsString());
						if(player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof PlanningItem){
							((PlanningItem)player.getHeldItemMainhand().getItem()).processServerPacket(pkt, player.getHeldItemMainhand());
						}
						player.inventoryContainer.detectAndSendChanges();
						reply = pkt.obj;
						break;
					case "request_nbt_update":
						BlockPos pos = new BlockPos(pkt.obj.get("x").getAsInt(), pkt.obj.get("y").getAsInt(), pkt.obj.get("z").getAsInt());
						int dim = pkt.obj.get("dim").getAsInt();
						TileEntity te = SSC.getServer().worldServerForDimension(dim).getTileEntity(pos);
						NBTTagCompound nbt = new NBTTagCompound();
						nbt.setString("array", te.getTileData().getString("frsm_cae_array"));
						nbt.setString("type",  te.getTileData().getString("frsm_cae_type") );
						ApiUtil.sendTileEntityUpdatePacket(SSC.getServer().worldServerForDimension(dim), pos, nbt);
						send = false;
						break;
				}
				if(send){
					SSC.getPacketHandler().sendTo(new PacketJsonObject(reply), SSC.getServer().getPlayerList().getPlayerByUsername(pkt.obj.get("player").getAsString()));
				}
			}
		}
		
	}
	
	public static class Client implements IPacketListener{
		
		private static Minecraft mc = Minecraft.getMinecraft();
		
		@Override
		public String getId(){
			return "cae";
		}

		@Override
		public void process(IPacket packet, Object[] objs){
			//Print.log("[CAE] PACKET RECEIVED! <<< CLIENT");
			PacketJsonObject pkt = (PacketJsonObject)packet;
			if(pkt.obj.has("task")){
				switch(pkt.obj.get("task").getAsString()){
					case "reset_gui":
						GuiCAE.close();
						GuiCAE.setType(Type.fromString(pkt.obj.get("type").getAsString()));
						mc.thePlayer.openGui(CustomAsphaltExtension.getInstance(), 0, mc.thePlayer.worldObj,
							mc.thePlayer.getPosition().getX(),
							mc.thePlayer.getPosition().getY(),
							mc.thePlayer.getPosition().getZ()
						);
						break;
					case "update_item":
						EntityPlayer player = Minecraft.getMinecraft().thePlayer;
						if(player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof PlanningItem){
							((PlanningItem)player.getHeldItemMainhand().getItem()).processServerPacket(pkt, player.getHeldItemMainhand());
						}
						PrintChat.print(player, "Layout updated.");
						GuiCAE.close();
						break;
				}
			}
		}
		
	}
}