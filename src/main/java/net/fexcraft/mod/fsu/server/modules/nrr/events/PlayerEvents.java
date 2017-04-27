package net.fexcraft.mod.fsu.server.modules.nrr.events;

import net.fexcraft.mod.fsu.server.modules.nrr.NRR;
import net.fexcraft.mod.fsu.server.modules.nrr.data.Chunk;
import net.fexcraft.mod.fsu.server.modules.nrr.data.PlayerData;
import net.fexcraft.mod.lib.perms.Permissions;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class PlayerEvents {
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onJoin(PlayerLoggedInEvent event){
		PlayerData data = NRR.getPlayerData(event.player);
		Print.chat(event.player, Formatter.format("&7Welcome back " + data.getNick(event.player) + "&7!"));
	}
	
	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event){
		event.setCanceled(cancel(event.getWorld(), event.getPos(), event.getPlayer(), true));
	}
	
	@SubscribeEvent
	public void onBlockBreak(BlockEvent.PlaceEvent event){
		event.setCanceled(cancel(event.getWorld(), event.getPos(), event.getPlayer(), false));
	}
	
	public boolean cancel(World world, BlockPos pos, EntityPlayer player, boolean b){
		PlayerData data = NRR.getPlayerData(player);
		if(!data.perms.hasPermission(b ? Permissions.GENERAL_BLOCK_BREAK : Permissions.GENERAL_BLOCK_PLACE)){
			Print.chat(player, "No permission to " + (b ? "break" : "place") + " blocks.");
			return true;
		}
		Chunk chunk = NRR.getChunk(world, pos);
		switch(chunk.ptype){
			case SERVER:
				if(data.perms.hasPermission(NRR.ADMINPERM)){
					return false;
				}
				else{
					Print.chat(player, "Server Property.");
					return true;
				}
			case COMPANY:
				Print.chat(player, "Chunk Protection Type not available yet.");
				return true;
			case GOVERMENT:
				Print.chat(player, "Chunk Protection Type not available yet.");
				return true;
			case MILITARY:
				Print.chat(player, "Chunk Protection Type not available yet.");
				return true;
			case PRIVATE:
				Print.chat(player, "Chunk Protection Type not available yet.");
				return true;
			case PROVINCE:
				if(data.province.id != chunk.province.id){
					if(chunk.province.leadership.contains(player.getGameProfile().getId())){
						return false;
					}
					else{
						Print.chat(player, "No permission to " + (b ? "break" : "place") + " blocks in this province!");
						return true;
					}
				}
				else{
					if(data.province.id < 1){
						return true;
					}
					else return false;
				}
			case REGIONAL:
				Print.chat(player, "Chunk Protection Type not available yet.");
				return true;
			case NONE:
				if(data.province.id != chunk.province.id){
					if(data.perms.hasPermission(NRR.ADMINPERM) || chunk.province.whitelist.contains(player.getGameProfile().getId())){
						return false;
					}
					else{
						Print.chat(player, "No permission to " + (b ? "break" : "place") + " blocks in this province!");
						return true;
					}
				}
				else{
					if(data.province.id < 1){
						if(data.perms.hasPermission(NRR.ADMINPERM)){
							return false;
						}
						else return true;
					}
					else return false;
				}
			case PUBLIC:
			default:
				return false;
		}
	}
	
}