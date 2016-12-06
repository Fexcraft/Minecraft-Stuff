package net.fexcraft.mod.frsm.commads;

import java.util.ArrayList;
import java.util.List;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class SummonRobo extends CommandBase{ 
	
    private final ArrayList aliases;
    private ResourceLocation fullEntityName; 
    private Entity RoboEntity; 
  
    public SummonRobo() { 
        aliases = new ArrayList(); 
        aliases.add("spawnrobo"); 
        aliases.add("summonrobo");
        aliases.add("frsmrobo");
    }
    
    @Override 
    public String getName() { 
        return "srobo"; 

    } 

    @Override         
    public String getUsage(ICommandSender var1) { 
        return "command.srobo.use"; 

    } 

    @Override 
    public List getAliases() { 
        return this.aliases;

    } 

    @Override 
    public void execute(MinecraftServer server, ICommandSender sender, String[] args)  throws CommandException{ 
        World world = sender.getEntityWorld(); 

        if (world.isRemote) { 
            //System.out.println("Not processing on Client side"); 
        } 

        else{
            //System.out.println("Processing on Server side");
            if(args.length == 0){
            	sender.sendMessage(new TextComponentString((CCS.RED + "Invalid argument"))); 
            	return; 
            } 

            sender.sendMessage(new TextComponentString((CCS.DAQUA + "Spawning.... [" + args[0] + "]"))); 
            
            set(args[0]); 
            if (EntityList.isRegistered(fullEntityName)){ 
                RoboEntity = EntityList.createEntityByIDFromName(fullEntityName, world);  
                RoboEntity.setPosition(sender.getPosition().getX(),       
                sender.getPosition().getY(), 
                sender.getPosition().getZ()); 
                world.spawnEntity(RoboEntity); 
            }
            else{
                sender.sendMessage(new TextComponentString((CCS.DRED + "Entity not found!"))); 
            }
        }
    }
    
    public void set(String s){
    	fullEntityName = new ResourceLocation(FI.MODID, s);
    }

    @Override 
    public boolean isUsernameIndex(String[] var1, int var2) { 
    	return false;
    }
    
    /*@Override
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos){
        return Entities.entity_ids;
    }*/
}

