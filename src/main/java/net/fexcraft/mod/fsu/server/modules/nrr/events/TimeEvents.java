package net.fexcraft.mod.fsu.server.modules.nrr.events;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.fexcraft.mod.fsu.server.modules.nrr.NRR;
import net.fexcraft.mod.fsu.server.modules.nrr.data.Chunk;
import net.fexcraft.mod.fsu.server.modules.nrr.data.PlayerData;
import net.fexcraft.mod.fsu.server.modules.nrr.util.NCCS;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

public class TimeEvents {
	
	private static int last_quarter_call = 0;
	private static int tick;
	private static boolean working;
	private static int ct;

	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event){
		if(event.phase == Phase.START){
			tick++;
			if(tick >= 20){
				tick = 0;
			}
			if(tick == 5 || tick == 15){
				int m = Time.getMinute();
				if(m == 0 || m == 15 || m == 30 || m == 45 || m == 60){
					working = true;
					processQuarterJob(m);
					working = false;
				}
			}
			//NRR.gen.continueGen();
		}
		if(event.phase == Phase.END){
			ct++;
			if(ct > 20){
				ct = 0;
			}
			if(ct == 20){
				for(EntityPlayerMP entity : Static.getServer().getPlayerList().getPlayers()){
					PlayerData player = NRR.getPlayerData(entity);
					if(player.last_pos == null){
						player.last_pos = entity.getPosition();
					}
					if(!player.last_pos.equals(entity.getPosition())){
						player.last_pos = entity.getPosition();
						Chunk ck = NRR.getChunk(entity);
						if(ck != null && ck.province.id != player.last_province){
							player.last_province = ck.province.id;
							Print.chat(entity, NCCS.fromInt(ck.province.region.nation.color) + "&o[" + ck.province.region.nation.name + "] (" + ck.province.region.name + ")\n&3Entered: &7" + ck.province.name);
						}
					}
				}
			}
		}
	}
	
	public static void processQuarterJob(int m){
		if(last_quarter_call == m){
			return;
		}
		last_quarter_call = m;
		NRR.sendToAll("&4====================[" + getTimeI() + "]");
		NRR.sendToAll(TextFormatting.ITALIC + "&5Saving Data.");
		NRR.save();
		NRR.sendToAll("&2====================[" + getTimeI() + "]");
	}
	
	public static String getTimeI(){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(new Date());
	}
	
}