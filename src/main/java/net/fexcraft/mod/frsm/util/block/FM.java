package net.fexcraft.mod.frsm.util.block;

import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class FM extends Material{
	
	public FM(MapColor color) {
		super(color);
	}
	
    public static final FM placeholder = new FM(MapColor.BLACK).setTranslucent().setImmovableMobility();
    public static final FM normal = new FM(MapColor.BLACK).setTranslucent().setRequiresTool();
    public static final FM ground = new FM(MapColor.DIRT);
    public static final FM wood = (new FM(MapColor.WOOD)).setBurning();
    public static final FM rock = (new FM(MapColor.STONE)).setRequiresTool();
    public static final FM iron = (new FM(MapColor.IRON)).setRequiresTool();
    public static final FM anvil = (new FM(MapColor.IRON)).setRequiresTool().setImmovableMobility();
    public static final FM leaves = (new FM(MapColor.FOLIAGE)).setBurning().setTranslucent().setNoPushMobility();
    public static final FM sponge = new FM(MapColor.YELLOW);
    public static final FM cloth = (new FM(MapColor.CLOTH)).setBurning();
    public static final FM sand = new FM(MapColor.SAND);
    public static final FM glass = (new FM(MapColor.AIR)).setTranslucent().setAdventureModeExempt();
    public static final FM redstoneLight = (new FM(MapColor.AIR)).setAdventureModeExempt();
    public static final FM tnt = (new FM(MapColor.TNT)).setBurning().setTranslucent();
    public static final FM coral = (new FM(MapColor.FOLIAGE)).setNoPushMobility();
    public static final FM ice = (new FM(MapColor.ICE)).setTranslucent().setAdventureModeExempt();
    public static final FM packedIce = (new FM(MapColor.ICE)).setAdventureModeExempt();
    public static final FM cactus = (new FM(MapColor.FOLIAGE)).setTranslucent().setNoPushMobility();
    public static final FM clay = new FM(MapColor.CLAY);
    public static final FM gourd = (new FM(MapColor.FOLIAGE)).setNoPushMobility();
    public static final FM dragonEgg = (new FM(MapColor.FOLIAGE)).setNoPushMobility();
    public static final FM cake = (new FM(MapColor.AIR)).setNoPushMobility();
    public static final FM web = (new FM(MapColor.CLOTH){public boolean blocksMovement(){return false;}}).setRequiresTool().setNoPushMobility();
    public static final FM piston = (new FM(MapColor.STONE)).setImmovableMobility();
    public static final FM barrier = (new FM(MapColor.AIR)).setRequiresTool().setImmovableMobility();
    private boolean canBurn;
    private boolean replaceable;
    private boolean isTranslucent;
    private boolean requiresNoTool = true;
    private EnumPushReaction mobilityFlag = EnumPushReaction.NORMAL;
    private boolean isAdventureModeExempt;

    public boolean isLiquid()
    {
        return false;
    }
    
    public boolean isSolid()
    {
        return true;
    }
    
    public boolean blocksLight()
    {
        return true;
    }
    
    public boolean blocksMovement(){
        return true;
    }

    private FM setTranslucent(){
        this.isTranslucent = true;
        return this;
    }

    protected FM setRequiresTool(){
        this.requiresNoTool = false;
        return this;
    }

    protected FM setBurning(){
        this.canBurn = true;
        return this;
    }

    public boolean getCanBurn(){
        return this.canBurn;
    }
    
    public FM setReplaceable(){
        this.replaceable = true;
        return this;
    }

    public boolean isReplaceable(){
        return this.replaceable;
    }

    public boolean isOpaque(){
        return this.isTranslucent ? false : this.blocksMovement();
    }

    public boolean isToolNotRequired(){
        return this.requiresNoTool;
    }

    public EnumPushReaction getMobilityFlag(){
        return this.mobilityFlag;
    }
    
    protected FM setNoPushMobility(){
        this.mobilityFlag = EnumPushReaction.DESTROY;
        return this;
    }
    
    protected FM setImmovableMobility(){
        this.mobilityFlag = EnumPushReaction.BLOCK;
        return this;
    }
    
    protected FM setAdventureModeExempt(){
        this.isAdventureModeExempt = true;
        return this;
    }
	
}