package net.fexcraft.mod.lib.util.math;

/**
 * 
 * @author Ferdinand (FEX___96)
 * @desc some code based of the 1.8 MC's MathHelper, same class and method names for compatibility
 *
 */
public class MathHelper{
	
    public static double wrapAngleTo180(double p_76138_0_){
        p_76138_0_ %= 360.0D;
        if(p_76138_0_ >= 180.0D){p_76138_0_ -= 360.0D;}
        if(p_76138_0_ < -180.0D){p_76138_0_ += 360.0D;}
        return p_76138_0_;
    }
    
    public static float wrapAngleTo180(float f){
        f %= 360.0F;
        if(f >= 180.0F){f -= 360.0F;}
        if(f < -180.0F){f += 360.0F;}
        return f;
    }
    
}