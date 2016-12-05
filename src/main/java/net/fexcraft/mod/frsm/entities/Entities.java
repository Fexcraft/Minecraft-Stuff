package net.fexcraft.mod.frsm.entities;

import java.util.ArrayList;
import java.util.List;

import net.fexcraft.mod.frsm.FRSM;
import net.fexcraft.mod.frsm.entities.R1.R1;
import net.fexcraft.mod.frsm.entities.R2.R2H;
import net.fexcraft.mod.frsm.entities.R2.R2J;
import net.fexcraft.mod.frsm.entities.R2.R2L;
import net.fexcraft.mod.frsm.entities.R2.R2M;
import net.fexcraft.mod.frsm.entities.R3.R3J;
import net.fexcraft.mod.frsm.entities.R3.R3L;
import net.fexcraft.mod.frsm.entities.R3.R3LJ;
import net.fexcraft.mod.frsm.entities.R3.R3M;
import net.fexcraft.mod.frsm.entities.car.EntityCar1;
import net.fexcraft.mod.frsm.entities.goat.EntityGoat;
import net.fexcraft.mod.frsm.util.FI;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public final class Entities{
	
	public static List<String> entity_ids;
	
	public static void register(){
        int id = 0;
        entity_ids = new ArrayList<String>();
        
        EntityRegistry.registerModEntity(EntityGoat.class, "Goat", id++, FI.MODID, 80, 1, true); entity_ids.add("Goat");
        EntityRegistry.addSpawn(EntityGoat.class, 2, 0, 1, EnumCreatureType.CREATURE, Biome.getBiome(3));       
        EntityRegistry.registerModEntity(EntityCar1.class, "Car1", id++, FI.MODID, 80, 1, true); entity_ids.add("Car1");
        EntityRegistry.addSpawn(EntityCar1.class, 2, 0, 3, EnumCreatureType.CREATURE, Biome.getBiome(1));
        EntityRegistry.addSpawn(EntityCar1.class, 2, 0, 4, EnumCreatureType.CREATURE, Biome.getBiome(2));
        
        EntityRegistry.registerModEntity(EntitySittable.class, "test_entity", id++, FI.MODID, 32, 1, false);
        
        if(FRSM.conf5){
	        EntityRegistry.registerModEntity(R1.Red.class,     "Basic_R1_Red",     id++, FI.MODID, 80, 1, true); entity_ids.add("Basic_R1_Red");
	        EntityRegistry.registerModEntity(R1.Blue.class,    "Basic_R1_Blue",    id++, FI.MODID, 80, 1, true); entity_ids.add("Basic_R1_Blue");
	        EntityRegistry.registerModEntity(R1.Green.class,   "Basic_R1_Green",   id++, FI.MODID, 80, 1, true); entity_ids.add("Basic_R1_Green");
	        EntityRegistry.registerModEntity(R1.Yellow.class,  "Basic_R1_Yellow",  id++, FI.MODID, 80, 1, true); entity_ids.add("Basic_R1_Yellow");
	        EntityRegistry.registerModEntity(R1.Guard.class,   "Basic_R1_Guard",   id++, FI.MODID, 80, 1, true); entity_ids.add("Basic_R1_Guard");
	        //
	        EntityRegistry.registerModEntity(R2H.Red.class,    "Heavy_R2_Red",     id++, FI.MODID, 80, 1, true); entity_ids.add("Heavy_R2_Red");
	        EntityRegistry.registerModEntity(R2H.Blue.class,   "Heavy_R2_Blue",    id++, FI.MODID, 80, 1, true); entity_ids.add("Heavy_R2_Blue");
	        EntityRegistry.registerModEntity(R2H.Green.class,  "Heavy_R2_Green",   id++, FI.MODID, 80, 1, true); entity_ids.add("Heavy_R2_Green");
	        EntityRegistry.registerModEntity(R2H.Yellow.class, "Heavy_R2_Yellow",  id++, FI.MODID, 80, 1, true); entity_ids.add("Heavy_R2_Yellow");
	        EntityRegistry.registerModEntity(R2H.Guard.class,  "Heavy_R2_Guard",   id++, FI.MODID, 80, 1, true); entity_ids.add("Heavy_R2_Guard");
	        //
	        EntityRegistry.registerModEntity(R2M.Red.class,    "Medium_R2_Red",     id++, FI.MODID, 80, 1, true); entity_ids.add("Medium_R2_Red");
	        EntityRegistry.registerModEntity(R2M.Blue.class,   "Medium_R2_Blue",    id++, FI.MODID, 80, 1, true); entity_ids.add("Medium_R2_Blue");
	        EntityRegistry.registerModEntity(R2M.Green.class,  "Medium_R2_Green",   id++, FI.MODID, 80, 1, true); entity_ids.add("Medium_R2_Green");
	        EntityRegistry.registerModEntity(R2M.Yellow.class, "Medium_R2_Yellow",  id++, FI.MODID, 80, 1, true); entity_ids.add("Medium_R2_Yellow");
	        EntityRegistry.registerModEntity(R2M.Guard.class,  "Medium_R2_Guard",   id++, FI.MODID, 80, 1, true); entity_ids.add("Medium_R2_Guard");
	        //
	        EntityRegistry.registerModEntity(R2L.Red.class,    "Light_R2_Red",     id++, FI.MODID, 80, 1, true); entity_ids.add("Light_R2_Red");
	        EntityRegistry.registerModEntity(R2L.Blue.class,   "Light_R2_Blue",    id++, FI.MODID, 80, 1, true); entity_ids.add("Light_R2_Blue");
	        EntityRegistry.registerModEntity(R2L.Green.class,  "Light_R2_Green",   id++, FI.MODID, 80, 1, true); entity_ids.add("Light_R2_Green");
	        EntityRegistry.registerModEntity(R2L.Yellow.class, "Light_R2_Yellow",  id++, FI.MODID, 80, 1, true); entity_ids.add("Light_R2_Yellow");
	        EntityRegistry.registerModEntity(R2L.Guard.class,  "Light_R2_Guard",   id++, FI.MODID, 80, 1, true); entity_ids.add("Light_R2_Guard");
	        //
	        EntityRegistry.registerModEntity(R2J.Red.class,    "Hunter_R2_Red",     id++, FI.MODID, 80, 1, true); entity_ids.add("Hunter_R2_Red");
	        EntityRegistry.registerModEntity(R2J.Blue.class,   "Hunter_R2_Blue",    id++, FI.MODID, 80, 1, true); entity_ids.add("Hunter_R2_Blue");
	        EntityRegistry.registerModEntity(R2J.Green.class,  "Hunter_R2_Green",   id++, FI.MODID, 80, 1, true); entity_ids.add("Hunter_R2_Green");
	        EntityRegistry.registerModEntity(R2J.Yellow.class, "Hunter_R2_Yellow",  id++, FI.MODID, 80, 1, true); entity_ids.add("Hunter_R2_Yellow");
	        EntityRegistry.registerModEntity(R2J.Guard.class,  "Hunter_R2_Guard",   id++, FI.MODID, 80, 1, true); entity_ids.add("Hunter_R2_Guard");
	        //
	        EntityRegistry.registerModEntity(R3J.Red.class,    "Hunter_R3_Red",     id++, FI.MODID, 80, 1, true); entity_ids.add("Hunter_R3_Red");
	        EntityRegistry.registerModEntity(R3J.Blue.class,   "Hunter_R3_Blue",    id++, FI.MODID, 80, 1, true); entity_ids.add("Hunter_R3_Blue");
	        EntityRegistry.registerModEntity(R3J.Green.class,  "Hunter_R3_Green",   id++, FI.MODID, 80, 1, true); entity_ids.add("Hunter_R3_Green");
	        EntityRegistry.registerModEntity(R3J.Yellow.class, "Hunter_R3_Yellow",  id++, FI.MODID, 80, 1, true); entity_ids.add("Hunter_R3_Yellow");
	        EntityRegistry.registerModEntity(R3J.Guard.class,  "Hunter_R3_Guard",   id++, FI.MODID, 80, 1, true); entity_ids.add("Hunter_R3_Guard");
	        //
	        EntityRegistry.registerModEntity(R3L.Red.class,    "Light_R3_Red",     id++, FI.MODID, 80, 1, true); entity_ids.add("Light_R3_Red");
	        EntityRegistry.registerModEntity(R3L.Blue.class,   "Light_R3_Blue",    id++, FI.MODID, 80, 1, true); entity_ids.add("Light_R3_Blue");
	        EntityRegistry.registerModEntity(R3L.Green.class,  "Light_R3_Green",   id++, FI.MODID, 80, 1, true); entity_ids.add("Light_R3_Green");
	        EntityRegistry.registerModEntity(R3L.Yellow.class, "Light_R3_Yellow",  id++, FI.MODID, 80, 1, true); entity_ids.add("Light_R3_Yellow");
	        EntityRegistry.registerModEntity(R3L.Guard.class,  "Light_R3_Guard",   id++, FI.MODID, 80, 1, true); entity_ids.add("Light_R3_Guard");
	        //
	        EntityRegistry.registerModEntity(R3M.Red.class,    "Medium_R3_Red",     id++, FI.MODID, 80, 1, true); entity_ids.add("Medium_R3_Red");
	        EntityRegistry.registerModEntity(R3M.Blue.class,   "Medium_R3_Blue",    id++, FI.MODID, 80, 1, true); entity_ids.add("Medium_R3_Blue");
	        EntityRegistry.registerModEntity(R3M.Green.class,  "Medium_R3_Green",   id++, FI.MODID, 80, 1, true); entity_ids.add("Medium_R3_Green");
	        EntityRegistry.registerModEntity(R3M.Yellow.class, "Medium_R3_Yellow",  id++, FI.MODID, 80, 1, true); entity_ids.add("Medium_R3_Yellow");
	        EntityRegistry.registerModEntity(R3M.Guard.class,  "Medium_R3_Guard",   id++, FI.MODID, 80, 1, true); entity_ids.add("Medium_R3_Guard");
	        //
	        EntityRegistry.registerModEntity(R3LJ.Red.class,    "LightHunter_R3_Red",     id++, FI.MODID, 80, 1, true); entity_ids.add("LightHunter_R3_Red");
	        EntityRegistry.registerModEntity(R3LJ.Blue.class,   "LightHunter_R3_Blue",    id++, FI.MODID, 80, 1, true); entity_ids.add("LightHunter_R3_Blue");
	        EntityRegistry.registerModEntity(R3LJ.Green.class,  "LightHunter_R3_Green",   id++, FI.MODID, 80, 1, true); entity_ids.add("LightHunter_R3_Green");
	        EntityRegistry.registerModEntity(R3LJ.Yellow.class, "LightHunter_R3_Yellow",  id++, FI.MODID, 80, 1, true); entity_ids.add("LightHunter_R3_Yellow");
	        EntityRegistry.registerModEntity(R3LJ.Guard.class,  "LightHunter_R3_Guard",   id++, FI.MODID, 80, 1, true); entity_ids.add("LightHunter_R3_Guard");
	        //
        }
        //EntityRegistry.registerModEntity(EntitySittable.class, "entitysittable", id++, FI.MODID, 80, 1, true);
	}
}