/**
 * THIS FILE IS PART OF 'SCC' Simple Chunk Control
 *  © Fexcraft.net
 *  
 *  @author Ferdinand (FEX___96)
 */
package net.fexcraft.mod.sm.scc.events;

import net.fexcraft.mod.sm.scc.util.Chunk;
import net.fexcraft.mod.sm.scc.util.Config;
import net.fexcraft.mod.sm.scc.util.Data;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockEvents {
	
	@SubscribeEvent
	public void placeBlock(BlockEvent.PlaceEvent event){
		event.setCanceled(getResult(event.getWorld(), event.getPlayer(), event.getPos()));
		if(event.isCanceled()){
			event.getPlayer().sendMessage(new TextComponentString("No permission."));
		}
	}
	
	@SubscribeEvent
	public void breakBlock(BlockEvent.BreakEvent event){
		event.setCanceled(getResult(event.getWorld(), event.getPlayer(), event.getPos()));
		if(event.isCanceled()){
			event.getPlayer().sendMessage(new TextComponentString("No permission."));
		}
	}
	
	private static boolean getResult(World world, EntityPlayer player, BlockPos pos){
		if(player.dimension != 0){
			return false;
		}
		Chunk chunk = Data.getChunk(world, pos);
		if(chunk.hasOwner){
			if(chunk.owner.toString().equals(player.getGameProfile().getId().toString())){
				return false;
			}
			else return !chunk.isWhitelisted(player.getGameProfile().getId());
		}
		else return Config.protectUnclaimed;
	}
	
	@SubscribeEvent
	public void onSpawn(EntityEvent event){
		if(event.getEntity() instanceof EntityTNTPrimed){
			event.getEntity().setDead();
		}
	}
	
}