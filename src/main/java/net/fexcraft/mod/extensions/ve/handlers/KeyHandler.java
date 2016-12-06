package net.fexcraft.mod.extensions.ve.handlers;

import java.util.HashSet;

import org.lwjgl.input.Keyboard;

import net.fexcraft.mod.frsm.util.SSC;
import net.fexcraft.mod.lib.network.packet.PacketKeyInput;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyHandler{
	
	public static KeyBinding up;
	public static KeyBinding down;
	public static KeyBinding left;
	public static KeyBinding right;
	public static KeyBinding toggleDoors;
	public static KeyBinding toggleLock;
	public static KeyBinding out;
	
	private static Minecraft mc = Minecraft.getMinecraft();
	private static String ent = "entity_ridden";
	private static HashSet<KeyBinding> set = new HashSet<KeyBinding>();
	
	public static void init(){
		up          = new KeyBinding("key.up",          Keyboard.KEY_W, "FRSM:VE");
		down        = new KeyBinding("key.down",        Keyboard.KEY_S, "FRSM:VE");
		left        = new KeyBinding("key.left",        Keyboard.KEY_A, "FRSM:VE");
		right       = new KeyBinding("key.right",       Keyboard.KEY_D, "FRSM:VE");
		toggleDoors = new KeyBinding("key.toggleDoors", Keyboard.KEY_K, "FRSM:VE");
		toggleLock  = new KeyBinding("key.toggleLock",  Keyboard.KEY_L, "FRSM:VE");
		out         = new KeyBinding("key.out",         Keyboard.KEY_LSHIFT, "FRSM:VE");
	}
	
	public static void register(){
		ClientRegistry.registerKeyBinding(up);
		ClientRegistry.registerKeyBinding(down);
		ClientRegistry.registerKeyBinding(left);
		ClientRegistry.registerKeyBinding(right);
		ClientRegistry.registerKeyBinding(toggleDoors);
		ClientRegistry.registerKeyBinding(toggleLock);
		ClientRegistry.registerKeyBinding(out);
		set.add(up);
		set.add(down);
		set.add(left);
		set.add(right);
		set.add(toggleDoors);
		set.add(toggleLock);
		set.add(out);
	}
	
	public static class Event{
		@SubscribeEvent
		public void onKeyInput(InputEvent.KeyInputEvent event) {
			for(KeyBinding k : set){
				if(k.isPressed() && mc.thePlayer.isRiding()){
					SSC.getPacketHandler().sendToServer(new PacketKeyInput(k.getKeyCode(), ent));
				}
			}
		}
	}
}
