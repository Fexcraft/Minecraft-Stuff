package net.fexcraft.mod.fsu.server.modules.nrr.util;

import java.io.File;
import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fsu.server.FSU;
import net.fexcraft.mod.lib.FCL;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.ForgeChunkManager.LoadingCallback;
import net.minecraftforge.common.ForgeChunkManager.Ticket;

public class Generator implements LoadingCallback {
	
	public static Ticket ticket;
	private static int x, z;
	private static ChunkPos[] cpos = new ChunkPos[16], opos = new ChunkPos[16];
	private static boolean done;
	
	public void continueGen(){
		if(done){
			return;
		}
		if(ticket == null){
			ticket = ForgeChunkManager.requestTicket(FSU.INSTANCE, Static.getServer().worlds[0], ForgeChunkManager.Type.NORMAL);
		}
		if(cpos[0] == null){
			for(int i = 0; i < 16; i++){
				cpos[i] = new ChunkPos(x + i, z);
			}
		}
		else{
			opos = cpos;
			for(ChunkPos pos : opos){
				ForgeChunkManager.unforceChunk(ticket, pos);
			}
			for(int i = 0; i < 16; i++){
				cpos[i] = new ChunkPos(x + i, z);
			}
		}
		for(ChunkPos pos : cpos){
			ForgeChunkManager.forceChunk(ticket, pos);
		}
		if(x <= 640){
			x += 8;
		}
		if(x > 640){
			x = -640;
			z++;
			save();
		}
		if(z >640){
			done = true;
		}
		Print.log("Generating chunks " + x + " - " + (x + 8) + "x | " + z + "z;");
	}
	
	public void load(){
		File file = new File(FCL.getInstance().getConfigDirectory().getParentFile(), "/fsu-nrr/pregen.data");
		if(!file.exists()){
			x = z = -640;
		}
		else{
			JsonObject obj = JsonUtil.get(file);
			x = obj.get("x").getAsInt();
			z = obj.get("z").getAsInt();
			return;
		}
	}
	
	public void save(){
		File file = new File(FCL.getInstance().getConfigDirectory().getParentFile(), "/fsu-nrr/pregen.data");
		JsonObject obj = new JsonObject();
		obj.addProperty("x", x);
		obj.addProperty("z", z);
		JsonUtil.write(file, obj);
	}

	@Override
	public void ticketsLoaded(List<Ticket> tickets, World world) {
		//
	}
	
}