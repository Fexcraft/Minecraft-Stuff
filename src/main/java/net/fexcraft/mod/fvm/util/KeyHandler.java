package net.fexcraft.mod.fvm.util;

import org.lwjgl.input.Keyboard;

import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value = Side.CLIENT)
public class KeyHandler{
	
	private static final String name = FvmResources.MODID;
	public static KeyBinding control    = new KeyBinding("control",      Keyboard.KEY_LCONTROL, name);
	public static KeyBinding inventory  = new KeyBinding("inventory",    Keyboard.KEY_R, name);
	public static KeyBinding gearUp     = new KeyBinding("gear.up",      Keyboard.KEY_O, name);
	public static KeyBinding gearDown   = new KeyBinding("gear.down",    Keyboard.KEY_L, name);
	public static KeyBinding doors      = new KeyBinding("doors",        Keyboard.KEY_P, name);

	Minecraft minecraft;
	
	public KeyHandler(){
		ClientRegistry.registerKeyBinding(control);
		ClientRegistry.registerKeyBinding(inventory);
		ClientRegistry.registerKeyBinding(gearUp);
		ClientRegistry.registerKeyBinding(gearDown);
		ClientRegistry.registerKeyBinding(doors);
		minecraft = Minecraft.getMinecraft();
	}
	
	@SubscribeEvent
	public void checkKeyInput(KeyInputEvent event){
		/*if(minecraft.currentScreen != null || FMLClientHandler.instance().isGUIOpen(GuiContainer.class)){
			return;
		}*/

		if(minecraft.player.getRidingEntity() instanceof EntityLivingBase){
			//entity
			if(minecraft.gameSettings.keyBindForward.isPressed()){
				//send packet
			}
			if(minecraft.gameSettings.keyBindBack.isPressed()){
				//send packet
			}
			if(minecraft.gameSettings.keyBindLeft.isPressed()){
				//send packet
			}
			if(minecraft.gameSettings.keyBindRight.isPressed()){
				//send packet
			}
			if(minecraft.gameSettings.keyBindJump.isPressed()){
				//send packet
			}
			if(control.isPressed()){
				//send packet
			}
			if(inventory.isPressed()){
				//send packet
			}
			if(gearUp.isPressed()){
				//send packet
				Print.debug("Gear Up");
			}
			if(gearDown.isPressed()){
				//send packet
				Print.debug("Gear Down");
			}
			if(doors.isPressed()){
				//send packet
			}
		}
	}
	
}
