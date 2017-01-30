package net.fexcraft.mod.lib.api.item;

import java.util.UUID;

import net.fexcraft.mod.frsm.util.CCS;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author Ferdinand (FEX___96)
 * 
 */
public abstract class KeyItem extends Item {
	
	public abstract KeyType getType(ItemStack stack);
	
	public abstract String getCode(ItemStack stack);
	
	public abstract UUID getCreator(ItemStack stack);
	
	public static enum KeyType {
		
		PRIVATE("private"), COMMON("common"), ADMIN("admin");
		
		private String string;
		
		KeyType(String s){
			string = s;
		}
		
		@Override
		public String toString(){
			return string;
		}
		
		public static KeyType fromString(String s){
			for(KeyType type : values()){
				if(type.string.equals(s)){
					return type;
				}
			}
			return null;
		}

		public String toText(){
			switch(this){
				case ADMIN:
					return CCS.RED + string;
				case COMMON:
					return CCS.AQUA + string;
				case PRIVATE:
					return CCS.GREEN + string;
				default:
					return CCS.DRED + "ERROR";
			}
		}
		
	}

	public String getNewKeyCode(){
		return UUID.randomUUID().toString().substring(0, 8);
	}
	
}