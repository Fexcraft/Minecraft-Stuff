package net.fexcraft.mod.frsm.util.block;

import net.fexcraft.mod.frsm.util.SSC;
import net.fexcraft.mod.lib.network.packet.PacketItemStackUpdate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TemtUtil{
	
	public static void render(TileEntity TE){
		/*if(FI.TEMT){
			FRSMTE te = (FRSMTE)TE;
			GL11.glScalef(te.getTemtValue("scale_x"), te.getTemtValue("scale_y"), te.getTemtValue("scale_z"));
			GL11.glTranslatef(te.getTemtValue("translate_x"), te.getTemtValue("translate_y"), te.getTemtValue("translate_z"));
			GL11.glRotatef(te.getTemtValue("rotation_x"), 1, 0, 0);
			GL11.glRotatef(te.getTemtValue("rotation_y"), 0, 1, 0);
			GL11.glRotatef(te.getTemtValue("rotation_z"), 0, 0, 1);*/
			
			/*PrintLog.print("DEBUG", "===========================");
			for(FRSMTE.INT i : te.getTemtTypes()){
				PrintLog.print("DEBUG", i.id + " >>> " + i.value);
			}*/
		//}
	}
	
	public static void sendUpdatePacket(EntityPlayer player, String string, String value){
		NBTTagCompound nbt = new NBTTagCompound();
		switch(string){
			case "mode":
				nbt.setString("mode", value);
				break;
			case "type":
				nbt.setString("type", value);
				break;
			case "amount":
				nbt.setInteger("amount", Integer.parseInt(value));
				break;
			case "request":
				nbt.setString("request", value);
				break;
			default: return;
		}
		SSC.getPacketHandler().sendToServer(new PacketItemStackUpdate(player, nbt));
	}

	public static void sendRequestPacket(EntityPlayer player, NBTTagCompound nbt) {
		SSC.getPacketHandler().sendTo(new PacketItemStackUpdate(player, nbt), (EntityPlayerMP)player);
	}
}