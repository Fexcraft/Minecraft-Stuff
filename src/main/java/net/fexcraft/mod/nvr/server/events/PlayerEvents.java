package net.fexcraft.mod.nvr.server.events;

import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.nvr.server.NVR;
import net.fexcraft.mod.nvr.server.data.Chunk;
import net.fexcraft.mod.nvr.server.data.Player;
import net.fexcraft.mod.nvr.server.util.Permissions;
import net.fexcraft.mod.nvr.server.util.Sender;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
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
			Print.chat(event.player, Formatter.format("&fWelcome back " + data.getNick(event.player) + "&f!"));
			data.lastseen = NVR.getChunk(event.player.world, event.player.getPosition()).district;
			data.lastseenpos = event.player.getPositionVector();
			Sender.sendLocationUpdate(event.player, Formatter.format("&7Welcome back " + data.getNick(event.player) + "&7!"), null, "green", 10);
		}
		else{
			Print.debug("DATA IS NULL!");
			Sender.sendLocationUpdate(event.player, Formatter.format("&cDATA ERROR, IS &eNULL&c."), null, "green", 10);
		}
	}
	
	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event){
		boolean bool = cancel(event.getWorld(), event.getPos(), event.getPlayer(), true);
		event.setCanceled(bool);
		if(!bool){
			log("BREAK", event.getState(), event.getPos(), event.getPlayer().getActiveHand(), event.getPlayer(), Time.getDate());
		}
	}
	
	@SubscribeEvent
	public void onBlockPlace(BlockEvent.PlaceEvent event){
		boolean bool = cancel(event.getWorld(), event.getPos(), event.getPlayer(), false);
		event.setCanceled(bool);
		if(!bool){
			log("PLACE", event.getPlacedBlock(), event.getPos(), event.getHand(), event.getPlayer(), Time.getDate());
		}
	}
	
	private void log(String action, IBlockState block, BlockPos pos, EnumHand hand, EntityPlayer player, long date){
		/*try{
			ItemStack stack = player.getHeldItem(hand);
			String item = stack.getItem().getRegistryName() + " | " + stack.getCount() + " | " + stack.getMetadata() + " | " + (stack.hasTagCompound() ? stack.getTagCompound().toString() : "no tags");
			String bleck = block.getBlock().getRegistryName() + "|" + block.getBlock().getMetaFromState(block);
			NVR.SQL.update("INSERT INTO block_log (`action`, `block`, `inhand`, `player`, `date`) VALUES ('" + ((Static.dev() ? "DEV_" : "") + action) + "', '" + bleck + "', '" + item + "', '" + player.getGameProfile().getId().toString() + "', '" + date + "');");
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
		//NVR.LOGGER.log("//TODO Implement Block Logging.");
		//Sender.sendLocationUpdate(player, action, block.getBlock().getUnlocalizedName() + pos.toString(), "#000000", null);
	}

	public boolean cancel(World world, BlockPos pos, EntityPlayer player, boolean b){
		Player data = NVR.getPlayerData(player);
		if(!data.perms.hasPermission(b ? Permissions.BLOCK_BREAK : Permissions.BLOCK_PLACE)){
			Print.chat(player, "No permission to " + (b ? "break" : "place") + " blocks.");
			return true;
		}
		Chunk chunk = NVR.getChunk(world, pos);
		if(chunk.district.municipality.province.nation.isInAnarchy() && chunk.district.id != -1 && chunk.district.municipality.id != -1 && chunk.district.municipality.province.id != -1 && chunk.district.municipality.province.nation.id != -1){
			return false;
		}
		switch(chunk.type){
			case NEUTRAL:{
				if(data.perms.hasPermission(Permissions.ADMIN)){
					return false;
				}
				else{
					Print.chat(player, "&7Chunk isn't claimed.");
					return true;
				}
			}
			case CLAIMED:{
				if(data.municipality == chunk.district.municipality){
					return false;
				}
				else if(/*data.municipality.province == chunk.district.municipality.province &&*/ chunk.district.municipality.province.ruler.equals(data.uuid)){
					return false;
				}
				else if(data.municipality.province.nation == chunk.district.municipality.province.nation){
					if(chunk.district.municipality.province.nation.incharge.equals(data.uuid)){
						return false;
					}
					else if(chunk.district.municipality.province.nation.gov.contains(data.uuid) && !chunk.district.municipality.province.nation.isDemocratic()){
						return false;
					}
					else{
						Print.chat(player, "&7You aren't a citizen of this Municipality.");
						return true;
					}
				}
				else{
					Print.chat(player, "&7You aren't a citizen of this Municipality.");
					return true;
				}
			}
			case PRIVATE:{
				if(data.uuid.equals(chunk.owner) || chunk.whitelist.contains(data.uuid.toString())){
					return false;
				}
				else if(chunk.district.municipality.province.nation.isAutocratic() && chunk.district.municipality.province.nation.incharge.equals(data.uuid)){
					return false;
				}
				else if(chunk.district.municipality.province.nation.isMonarchy() && (chunk.district.municipality.province.nation.incharge.equals(data.uuid) || chunk.district.municipality.province.nation.gov.contains(data.uuid))){
					return false;
				}
				Print.chat(player, "&7This chunk is private property of &9" + Static.getPlayerNameByUUID(chunk.owner) + "&7.");
				return true;
			}
			case COMPANY:
				/*Company com = NVR.getCompany(chunk.owner);
				if(com != null && company.members.contains(data.uuid)){
					return false;
				}
				else if(chunk.whitelist.contains(data.uuid.toString())){
					return true;
				}
				else{
					Print.chat(player, "&7This chunk is property of &9" + com.name + "&7.");
					return false;
				}*/
			case PROTECTED:{
				if(chunk.district.manager.equals(data.uuid) || chunk.district.municipality.management.contains(data.uuid) || chunk.district.municipality.province.ruler.equals(data.uuid)){
					return false;
				}
				if((chunk.district.municipality.province.nation.isAutocratic() || chunk.district.municipality.province.nation.isMonarchy()) && chunk.district.municipality.province.nation.incharge.equals(data.uuid)){
					return false;
				}
				Print.chat(player, "&7Protected Territory of this Municipality.");
				return true;
			}
			case PUBLIC:
			default:
				return false;
		}
	}
	
}