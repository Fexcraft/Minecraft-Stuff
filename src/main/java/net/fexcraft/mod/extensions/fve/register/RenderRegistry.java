package net.fexcraft.mod.extensions.fve.register;

import net.fexcraft.mod.extensions.fve.FVE;
import net.fexcraft.mod.extensions.fve.renderers.C5LRenderer;
import net.fexcraft.mod.extensions.fve.renderers.C5RRenderer;
import net.fexcraft.mod.extensions.fve.renderers.C6LRenderer;
import net.fexcraft.mod.extensions.fve.renderers.C6RRenderer;
import net.fexcraft.mod.extensions.fve.renderers.T1LRenderer;
import net.fexcraft.mod.extensions.fve.renderers.T1RRenderer;
import net.fexcraft.mod.extensions.fve.tileentities.C5TE;
import net.fexcraft.mod.extensions.fve.tileentities.C6TE;
import net.fexcraft.mod.extensions.fve.tileentities.T1TE;
import net.fexcraft.mod.frsm.util.PrintLog;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class RenderRegistry{
	
	public static void register(Side side){
		if(side == Side.SERVER){
			PrintLog.print("FVE Render Registry", "Skipping! Mod executed on server side.");
			return;
		}
		if(FVE.conf2 == true){
			ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5R.class, new C5RRenderer("fve:textures/blocks/C5.png"));
			ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5RBlue.class, new C5RRenderer("fve:textures/blocks/C5Blue.png"));
        	ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5RRed.class, new C5RRenderer("fve:textures/blocks/C5Red.png"));
        	ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5RGreen.class, new C5RRenderer("fve:textures/blocks/C5Green.png"));
        	ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5RBlack.class, new C5RRenderer("fve:textures/blocks/C5Black.png"));
        	ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5RWhite.class, new C5RRenderer("fve:textures/blocks/C5White.png"));
        	ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5RPink.class, new C5RRenderer("fve:textures/blocks/C5Pink.png"));
        	ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5RPurple.class, new C5RRenderer("fve:textures/blocks/C5Purple.png"));
        	ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5ROrange.class, new C5RRenderer("fve:textures/blocks/C5Orange.png"));
        	ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5RCyan.class, new C5RRenderer("fve:textures/blocks/C5Cyan.png"));
        	ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5RYellow.class, new C5RRenderer("fve:textures/blocks/C5Yellow.png"));
        	ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5RBrown.class, new C5RRenderer("fve:textures/blocks/C5Brown.png"));
        	ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5RGray.class, new C5RRenderer("fve:textures/blocks/C5Gray.png"));
        	//
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6R.class, new C6RRenderer("fve:textures/blocks/C6.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6RBlue.class, new C6RRenderer("fve:textures/blocks/C6Blue.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6RRed.class, new C6RRenderer("fve:textures/blocks/C6Red.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6RBlack.class, new C6RRenderer("fve:textures/blocks/C6Black.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6RWhite.class, new C6RRenderer("fve:textures/blocks/C6White.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6RGray.class, new C6RRenderer("fve:textures/blocks/C6Gray.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6RSilver.class, new C6RRenderer("fve:textures/blocks/C6Silver.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6RYellow.class, new C6RRenderer("fve:textures/blocks/C6Yellow.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6RBeige.class, new C6RRenderer("fve:textures/blocks/C6Beige.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6RPink.class, new C6RRenderer("fve:textures/blocks/C6Pink.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6RBrown.class, new C6RRenderer("fve:textures/blocks/C6Brown.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6ROrange.class, new C6RRenderer("fve:textures/blocks/C6Orange.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6RPurple.class, new C6RRenderer("fve:textures/blocks/C6Purple.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6RC.class, new C6RRenderer("fve:textures/blocks/C6C.png"));
            //
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1R.class, new T1RRenderer("fve:textures/blocks/T1.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1RBlue.class, new T1RRenderer("fve:textures/blocks/T1Blue.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1RRed.class, new T1RRenderer("fve:textures/blocks/T1Red.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1RBlack.class, new T1RRenderer("fve:textures/blocks/T1Black.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1RWhite.class, new T1RRenderer("fve:textures/blocks/T1White.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1RGray.class, new T1RRenderer("fve:textures/blocks/T1Gray.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1RSilver.class, new T1RRenderer("fve:textures/blocks/T1Silver.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1RYellow.class, new T1RRenderer("fve:textures/blocks/T1Yellow.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1RBeige.class, new T1RRenderer("fve:textures/blocks/T1Beige.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1RPink.class, new T1RRenderer("fve:textures/blocks/T1Pink.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1RBrown.class, new T1RRenderer("fve:textures/blocks/T1Brown.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1ROrange.class, new T1RRenderer("fve:textures/blocks/T1Orange.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1RPurple.class, new T1RRenderer("fve:textures/blocks/T1Purple.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1RCyan.class, new T1RRenderer("fve:textures/blocks/T1Cyan.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1RC.class, new T1RRenderer("fve:textures/blocks/T1C.png"));
            //
		}
    	if(FVE.conf3 == true){
            ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5L.class, new C5LRenderer("fve:textures/blocks/C5.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5LBlue.class, new C5LRenderer("fve:textures/blocks/C5Blue.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5LRed.class, new C5LRenderer("fve:textures/blocks/C5Red.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5LGreen.class, new C5LRenderer("fve:textures/blocks/C5Green.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5LBlack.class, new C5LRenderer("fve:textures/blocks/C5Black.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5LWhite.class, new C5LRenderer("fve:textures/blocks/C5White.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5LPink.class, new C5LRenderer("fve:textures/blocks/C5Pink.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5LPurple.class, new C5LRenderer("fve:textures/blocks/C5Purple.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5LOrange.class, new C5LRenderer("fve:textures/blocks/C5Orange.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5LCyan.class, new C5LRenderer("fve:textures/blocks/C5Cyan.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5LYellow.class, new C5LRenderer("fve:textures/blocks/C5Yellow.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5LBrown.class, new C5LRenderer("fve:textures/blocks/C5Brown.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C5TE.C5LGray.class, new C5LRenderer("fve:textures/blocks/C5Gray.png"));
            //
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6L.class, new C6LRenderer("fve:textures/blocks/C6.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6LBlue.class, new C6LRenderer("fve:textures/blocks/C6Blue.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6LRed.class, new C6LRenderer("fve:textures/blocks/C6Red.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6LBlack.class, new C6LRenderer("fve:textures/blocks/C6Black.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6LWhite.class, new C6LRenderer("fve:textures/blocks/C6White.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6LGray.class, new C6LRenderer("fve:textures/blocks/C6Gray.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6LSilver.class, new C6LRenderer("fve:textures/blocks/C6Silver.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6LYellow.class, new C6LRenderer("fve:textures/blocks/C6Yellow.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6LBeige.class, new C6LRenderer("fve:textures/blocks/C6Beige.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6LPink.class, new C6LRenderer("fve:textures/blocks/C6Pink.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6LBrown.class, new C6LRenderer("fve:textures/blocks/C6Brown.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6LOrange.class, new C6LRenderer("fve:textures/blocks/C6Orange.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6LPurple.class, new C6LRenderer("fve:textures/blocks/C6Purple.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(C6TE.C6LC.class, new C6LRenderer("fve:textures/blocks/C6C.png"));
            //
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1L.class, new T1LRenderer("fve:textures/blocks/T1.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1LBlue.class, new T1LRenderer("fve:textures/blocks/T1Blue.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1LRed.class, new T1LRenderer("fve:textures/blocks/T1Led.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1LBlack.class, new T1LRenderer("fve:textures/blocks/T1Black.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1LWhite.class, new T1LRenderer("fve:textures/blocks/T1White.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1LGray.class, new T1LRenderer("fve:textures/blocks/T1Gray.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1LSilver.class, new T1LRenderer("fve:textures/blocks/T1Silver.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1LYellow.class, new T1LRenderer("fve:textures/blocks/T1Yellow.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1LBeige.class, new T1LRenderer("fve:textures/blocks/T1Beige.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1LPink.class, new T1LRenderer("fve:textures/blocks/T1Pink.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1LBrown.class, new T1LRenderer("fve:textures/blocks/T1Brown.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1LOrange.class, new T1LRenderer("fve:textures/blocks/T1Orange.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1LPurple.class, new T1LRenderer("fve:textures/blocks/T1Purple.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1LCyan.class, new T1LRenderer("fve:textures/blocks/T1Cyan.png"));
            ClientRegistry.bindTileEntitySpecialRenderer(T1TE.T1LC.class, new T1LRenderer("fve:textures/blocks/T1C.png"));
            //
        }
	}
}