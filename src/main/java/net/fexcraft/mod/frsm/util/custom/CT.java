package net.fexcraft.mod.frsm.util.custom;

import java.util.HashSet;
import java.util.Set;

import net.fexcraft.mod.frsm.util.PrintLog;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;

public class CT{
	
	private static Set<Ct> ls = new HashSet<Ct>();
	
	public enum CD{
		BLOCKS("blocks"), FOOD("food"), MATERIALS("materials"), TOOLS("tools"), TECHNIC("technic"),
		MODELS("models"), ROBO("robo"), DEV("dev"), RC("RC"), FLAGS("flags"), PIPES("pipes"),
		STREETS("streets"), TREEPOTS("treepots");
		
		private CreativeTabs ct;
		
		CD(String tab){
			ct = CT.get(tab);
		}
		
		public CreativeTabs getCreativeTab(){
			return ct;
		}
	}
	
	public static void initDefaults(Side s){
		if(s.equals(Side.CLIENT)){
			addCT(CreativeTabs.BUILDING_BLOCKS, "MC_Blocks");
			addCT(CreativeTabs.BREWING,         "MC_Brewing");
			addCT(CreativeTabs.COMBAT,          "MC_Combat");
			addCT(CreativeTabs.DECORATIONS,     "MC_Decorations");
			addCT(CreativeTabs.FOOD,            "MC_Food");
			addCT(CreativeTabs.MATERIALS,       "MC_Materials");
			addCT(CreativeTabs.MISC,            "MC_Misc");
			addCT(CreativeTabs.REDSTONE,        "MC_Redstone");
			addCT(CreativeTabs.TOOLS,           "MC_Tools");
			addCT(CreativeTabs.TRANSPORTATION,  "MC_Transport");
			addCT("tabFRSM_Blocks",    "blocks",    "frsm:woodenLightBox");
			addCT("tabFRSM_Food",      "food",      "frsm:cheese");
			addCT("tabFRSM_Materials", "materials", "frsm:jar");
			addCT("tabFRSM_Tools",     "tools",     "frsm:ironSaw");
			addCT("tabFRSM_Technic",   "technic",   "frsm:tvs");
			addCT("tabFRSM_Models",    "models",    "frsm:rail");
			addCT("tabFRSM_Robo",      "robo",      "frsm:SRobo1B");
			addCT("tabFRSM_Dev",       "dev",       "frsm:tbm");
			addCT("tabFRSM_RC",        "RC",        "frsm:RCT");
			addCT("tabFRSM_Flags",     "flags",     "frsm:flag0");
			addCT("tabFRSM_Pipes",     "pipes",     "frsm:pipe1");
			addCT("tabFRSM_Streets",   "streets",   "frsm:asphalt");
			addCT("tabFRSM_TreePots",  "treepots",  "frsm:tree_pot");
		}
	}
	
	public static void addCT(CreativeTabs ct, String ID){
		ls.add(new Ct(ct, ID));
		PrintLog.print("FRSM:CreativeTabsLoader", "Registed vanilla Creative Tab '" + ct.getTranslatedTabLabel() + "' with ID '" + ID + "'.");
	}
	
	public static void addCT(String name, String ID, String item){
		ls.add(new Ct(new CTS(name), ID, item));
		PrintLog.print("FRSM:CreativeTabsLoader", "Registed new Creative Tab '" + name + "' with ID '" + ID + "'. (" + item + ")");
	}
	
	public static void fixCT(){
		for(Ct c : ls){
			if(c.type.equals("FRSM")){
				((CTS)c.ct).setIcon(c.item);
				((CTS)c.ct).getTabIconItem();
				PrintLog.print("FRSM:CreativeTabsLoader", "Reloaded CreativeTab '" + c.ID + "'.");
			}
		}
	}
	
	public static CreativeTabs get(String ID){
		CreativeTabs ct = CreativeTabs.MISC;
		for(Ct t : ls){
			if(t.ID.equals(ID)){
				ct = t.ct;
				break;
			}
		}
		return ct;
	}
	
	public static class CTS extends CreativeTabs{

		private ItemStack iconItemStack;

		public CTS(String label) {
			super(label);
		}

		@Override
		public Item getTabIconItem(){
			if(iconItemStack == null){
				return Items.SNOWBALL;
			}
			return iconItemStack.getItem();
		}
		
		public void setIcon(String s1){
			ItemStack is = null;
			Item item = Item.getByNameOrId(s1);
			if(item != null){
				is = new ItemStack(item, 1 ,0);
			}
			iconItemStack = (is == null ? new ItemStack(Items.SNOWBALL) : is);
		}
	}
	
	private static class Ct{
		CreativeTabs ct;
		String ID, item, type;
		
		public Ct(CreativeTabs c, String s){
			ct = c;
			ID = s;
			item = null;
			type = "Minecraft";
		}
		
		public Ct(CTS c, String s, String it){
			ct = c;
			ID = s;
			item = it;
			type = "FRSM";
		}
	}
}