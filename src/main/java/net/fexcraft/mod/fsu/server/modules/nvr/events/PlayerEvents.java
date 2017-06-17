package net.fexcraft.mod.fsu.server.modules.nvr.events;

import net.fexcraft.mod.fsu.server.modules.nvr.NVR;
import net.fexcraft.mod.fsu.server.modules.nvr.data.Chunk;
import net.fexcraft.mod.fsu.server.modules.nvr.data.Player;
import net.fexcraft.mod.fsu.server.modules.nvr.data.Nation.GovType;
import net.fexcraft.mod.lib.perms.Permissions;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class PlayerEvents {
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onJoin(PlayerLoggedInEvent event){
		Player data = NVR.getPlayerData(event.player);
		if(data != null){
			Print.chat(event.player, Formatter.format("&7Welcome back " + data.getNick(event.player) + "&7!"));
		}
		else{
			Print.debug("DATA IS NULL!");
		}
	}
	
	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event){
		boolean bool = cancel(event.getWorld(), event.getPos(), event.getPlayer(), true);
		event.setCanceled(bool);
		if(!bool){
			log("BREAK", event.getState(), event.getPlayer().getActiveHand(), event.getPlayer(), Time.getDate());
		}
	}
	
	@SubscribeEvent
	public void onBlockPlace(BlockEvent.PlaceEvent event){
		boolean bool = cancel(event.getWorld(), event.getPos(), event.getPlayer(), false);
		event.setCanceled(bool);
		if(!bool){
			log("PLACE", event.getPlacedBlock(), event.getHand(), event.getPlayer(), Time.getDate());
		}
	}
	
	private void log(String action, IBlockState block, EnumHand hand, EntityPlayer player, long date){
		try{
			ItemStack stack = player.getHeldItem(hand);
			String item = stack.getItem().getRegistryName() + " | " + stack.getCount() + " | " + stack.getMetadata() + " | " + (stack.hasTagCompound() ? stack.getTagCompound().toString() : "no tags");
			String bleck = block.getBlock().getRegistryName() + "|" + block.getBlock().getMetaFromState(block);
			NVR.SQL.update("INSERT INTO blocklog (`action`, `block`, `inhand`, `player`, `date`) VALUES ('" + action + "', '" + bleck + "', '" + item + "', '" + player.getGameProfile().getId().toString() + "', '" + date + "');");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public boolean cancel(World world, BlockPos pos, EntityPlayer player, boolean b){
		Player data = NVR.getPlayerData(player);
		if(!data.perms.hasPermission(b ? Permissions.GENERAL_BLOCK_BREAK : Permissions.GENERAL_BLOCK_PLACE)){
			Print.chat(player, "No permission to " + (b ? "break" : "place") + " blocks.");
			return true;
		}
		if(player.dimension == 5){
			if(data.perms.hasPermission("nv1.whitelisted")){
				return false;
			}
			else{
				Print.chat(player, "You aren't whitelisted in the NV1 World.");
				return true;
			}
		}
		Chunk chunk = NVR.getChunk(world, pos);
		if(chunk.district.municipality.province.nation.isInAnarchy()){
			return false;
		}
		switch(chunk.type){
			case NEUTRAL:
				if(data.perms.hasPermission(NVR.ADMINPERM)){
					return false;
				}
				else{
					Print.chat(player, "&7Chunk isn't claimed.");
					return true;
				}
			case CLAIMED:
				if(data.municipality.id == chunk.district.municipality.id){
					return false;
				}
				else{
					if(chunk.district.municipality.province.nation.govtype == GovType.AUTOCRACY && (chunk.district.manager.equals(data.uuid) || chunk.district.municipality.management.contains(data.uuid)
							|| chunk.district.municipality.province.ruler.equals(data.uuid) || chunk.district.municipality.province.nation.canInteractWithBlocks(data.uuid))){
						return false;
					}
					else{
						Print.chat(player, "&7You aren't a citizen of this Municipality.");
						return true;
					}
				}
			case PRIVATE:
				if(data.uuid.equals(chunk.owner) || chunk.whitelist.contains(data.uuid)){
					return false;
				}
				else{
					Print.chat(player, "&7This chunk is private property of &9" + Static.getPlayerNameByUUID(chunk.owner) + "&7.");
					return true;
				}
			case COMPANY:
				//Company com = NVR.companies.get(chunk.owner);
				//if(com != null && company.members.contains(data.uuid)){
					//return false;
				//}
				/*else*/ if(chunk.whitelist.contains(data.uuid)){
					return true;
				}
				else{
					Print.chat(player, "&7This chunk is property of &9" /*com.name*/ + "&7.");
					return false;
				}
			case PROTECTED:
				if(chunk.district.manager.equals(data.uuid) || chunk.district.municipality.management.contains(data.uuid)
						|| chunk.district.municipality.province.ruler.equals(data.uuid) || chunk.district.municipality.province.nation.canInteractWithBlocks(data.uuid)){
					return false;
				}
				else{
					Print.chat(player, "&7Protected Territory of this Municipality.");
					return true;
				}
			case PUBLIC:
			default:
				return false;
			/*case SERVER:
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
				return false;*/
		}
	}
	
}