package net.fexcraft.mod.fvm.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.items.PartItem;
import net.fexcraft.mod.fvm.models.NullModel;
import net.fexcraft.mod.fvm.models.PartModel;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PartType extends DataObject {
	
	public String addonpack;
	public String registryname;
	public String fullname;
	public ArrayList<String> description = new ArrayList<String>();
	@SideOnly(Side.CLIENT)
	private PartModel model;
	public String modelname;
	public ArrayList<String> category = new ArrayList<String>();
	public ArrayList<String> attributes = new ArrayList<String>();
	//
	public boolean removable;
	public PartItem item;
	public TreeMap<String, Integer> recipe = new TreeMap<String, Integer>();
	public Map<String, Pos> compatible = new HashMap<String, Pos>();
	public Map<String, ArrayList<String>> incompatible = new HashMap<String, ArrayList<String>>();
	public Map<String, ArrayList<String>> requires = new HashMap<String, ArrayList<String>>();
	//public Map<String, ArrayList<String>> alternative = new HashMap<String, ArrayList<String>>();
	public boolean availableInConstructor;
	//
	public ArrayList<ResourceLocation> textures = new ArrayList<ResourceLocation>();
	public int current_texture = 0;
	
	//Seat Attribute
	public ArrayList<Seat> seats = new ArrayList<Seat>();
	//Engine Attribute
	public float fuelConsumption;
	public float engineSpeed;
	
	
	public PartType(LoadedIn state, JsonObject obj){
		super(state);
		if(state.isLoadedInMemory() || obj == null){
			load(obj);
		}
	}
	
	@Override
	public void load(JsonObject obj){
		if(obj == null){
			addonpack = "none";
			registryname = "null";
			fullname = "Null Type";
			category.add("null");
			return;
		}
		addonpack = ju.getIfExists(obj, "AddOn", "nullpack");
		registryname = ju.getIfExists(obj, "RegistryName", "null");
		modelname = ju.getIfExists(obj, "ModelFile", "null");
		fullname = ju.getIfExists(obj, "FullName", registryname);
		if(obj.has("Description")){
			description = ju.jsonArrayToStringArray(obj.get("Description").getAsJsonArray());
		}
		if(obj.has("Category")){
			category = ju.jsonArrayToStringArray(obj.get("Category").getAsJsonArray());
		}
		if(obj.has("Attributes")){
			attributes = ju.jsonArrayToStringArray(obj.get("Attributes").getAsJsonArray());
		}
		removable = ju.getIfExists(obj, "Removable", false);
		
		if(obj.has("TextureSettings")){
			JsonObject ts = obj.get("TextureSettings").getAsJsonObject();
			ArrayList<String> list = ju.jsonArrayToStringArray(ts.get("Textures").getAsJsonArray());
			for(String s : list){
				textures.add(new ResourceLocation(s));
			}
			current_texture = ju.getIfExists(ts, "Default", 0).intValue();
		}
		if(obj.has("ConstructionSettings")){
			JsonObject vs = obj.get("ConstructionSettings").getAsJsonObject();
			availableInConstructor = ju.getIfExists(vs, "Available", true);
			if(vs.has("Compatible")){
				JsonArray array = vs.get("Compatible").getAsJsonArray();
				for(JsonElement elm : array){
					JsonObject objext = elm.getAsJsonObject();
					compatible.put(objext.get("Vehicle").getAsString(), Pos.fromJSON(objext.get("Offset").getAsJsonObject()));
				}
			}
			if(vs.has("Incompatible")){
				JsonArray array = vs.get("Incompatible").getAsJsonArray();
				for(JsonElement elm : array){
					JsonObject objext = elm.getAsJsonObject();
					incompatible.put(objext.get("Vehicle").getAsString(), ju.jsonArrayToStringArray(objext.get("Parts").getAsJsonArray()));
				}
			}
			if(vs.has("Requires")){
				JsonArray array = vs.get("Requires").getAsJsonArray();
				for(JsonElement elm : array){
					JsonObject objext = elm.getAsJsonObject();
					requires.put(objext.get("Vehicle").getAsString(), ju.jsonArrayToStringArray(objext.get("Parts").getAsJsonArray()));
				}
			}
			/*if(vs.has("AlternativeUse")){
				JsonArray array = vs.get("AlternativeUse").getAsJsonArray();
				for(JsonElement elm : array){
					JsonObject objext = elm.getAsJsonObject();
					alternative.put(objext.get("Vehicle").getAsString(), ju.jsonArrayToStringArray(objext.get("Category").getAsJsonArray()));
				}
			}*/
		}
		
		if(obj.has("AttributeSettings")){
			JsonObject cs = obj.get("AttributeSettings").getAsJsonObject();
			if(attributes.contains("seats") || attributes.contains("seat")){
				if(cs.has("Passengers")){
					for(JsonElement elm : cs.get("Passengers").getAsJsonArray()){
						seats.add(new Seat(elm.getAsJsonObject()));
					}
				}
			}
			if(attributes.contains("engine") || attributes.contains("main_engine")){
				engineSpeed = ju.getIfExists(cs, "EngineSpeed", 1f).floatValue();
				fuelConsumption = ju.getIfExists(cs, "FuelConsumption", 1f).floatValue();
			}
			//general modifiers
		}
		
		
		if(this.state().isLoadedInMemory()){
			PartItem.addPart(this);
			if(obj.has("Recipes")){
				JsonArray arr = obj.get("Recipes").getAsJsonArray();
				for(JsonElement elm : arr){
					try{
						RecipeObject.parse(newStack(), elm.getAsJsonObject());
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public JsonObject save(JsonObject obj){
		//obj.addProperty("Category", category);
		obj.addProperty("PartName", registryname);
		return obj;
	}
	
	/*public void save(String s){
		JsonObject obj = new JsonObject();
		obj.addProperty("UsedAs", s);
		obj.addProperty("PartName", registryname);
	}*/

	@Override
	public void read(NBTTagCompound compound){
		//
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		return null;
	}

	@Override
	public DataObject newInstance(LoadedIn state){
		return this;
	}
	
	public PartModel getModel(){
		return model;
	}
	
	@Override
	public int compareTo(Object o){
		if(registryname == null){
			return -1;
		}
		return registryname.compareTo(((PartType)o).registryname);
	}

	public void loadModel(JsonObject obj){
		if(obj != null){
			if(obj.has("type")){
				switch(obj.get("type").getAsString()){
					case "class":
						try{
							Class clazz = Class.forName(modelname.replace(".class", ""));
							model = (PartModel)clazz.newInstance();
							if(model == null){
								Static.exception(5, "Model is Null!");
							}
						}
						catch(Exception e){
							e.printStackTrace();
							Static.stop();
						}
						break;
					case "def_json":
						//TODO
						break;
					case "jtmt":
						model = new PartModel(obj);
						break;
				}
			}
			else{
				model = new PartModel(obj);
			}
		}
		else{
			model = NullModel.get();
		}
	}

	public void translate(String string){
		if(compatible.get(string) != null){
			compatible.get(string).translate();
		}
	}
	
	public void translateR(String string){
		if(compatible.get(string) != null){
			compatible.get(string).translateR();
		}
	}

	public void setItem(PartItem item){
		this.item = item;
	}

	public void render(VehicleType type) {
		if(model != null){
			model.render(type);
		}
	}

	public ItemStack newStack(){
		return new ItemStack(item, 1, 0);
	}
	
}