package net.fexcraft.mod.fvm.data;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import net.fexcraft.mod.fvm.items.VehicleItem;
import net.fexcraft.mod.fvm.models.VehicleModel;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.lang.SortableList;
import net.fexcraft.mod.lib.util.math.Pos;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VehicleType extends DataObject {
	
	public String addonpack;
	public String registryname;
	public String fullname;
	public ArrayList<String> description = new ArrayList<String>();
	@SideOnly(Side.CLIENT)
	public VehicleModel model;
	public String modelname;
	//
	public Item item;
	//
	public RGB primaryColor = new RGB();
	public RGB secondaryColor = new RGB();
	public ArrayList<ResourceLocation> textures = new ArrayList<ResourceLocation>();
	public int current_texture = 0;
	public boolean doors = false;
	//
	public int construction_length;
	public float construction_height_offset;
	public float construction_wheel_offset;
	public ArrayList<String> requires = new ArrayList<String>();
	//
	public TreeMap<String, PartType> parts = new TreeMap<String, PartType>();
	public float scale = 1f;
	public boolean readyToUse = false;
	public boolean hasLock;
	//EntityData
	public Pos[] wheelPos;
	public boolean isLocked = false;
	public boolean rotateWheels = true;
	//Inventory
	private Container container;
	//Resyncables
	public SortableList<Seat> seats = new SortableList<Seat>();
	public float wheelStepHeight;
	public float wheelSpringStrength;
	public float cameraDistance;
	public int fuelStored = 50;
	public int fuelTankSize;
	public float maxThrottle;
	public float maxNegativeThrottle;
	public float turnLeftModifier;
	public float turnRightModifier;
	public String lock_code = KeyItem.getNewKeyCode();
	private DriveType driveType = DriveType.FWD;
	
	public VehicleType(LoadedIn state, JsonObject obj){
		super(state);
		load(obj);
	}

	public VehicleType(LoadedIn state, NBTTagCompound tag){
		super(state);
		read(tag);
	}
	
	public VehicleType(LoadedIn state, boolean b){
		super(state);
		if(b){
			load(null);
			registryname = "item";
		}
		else{
			return;
		}
	}

	@Override
	public void load(JsonObject obj){
		if(obj == null){
			addonpack = "none";
			registryname = "null";
			fullname = "Null Type";
			return;
		}
		addonpack = ju.getIfExists(obj, "AddOn", "nullpack");
		registryname = ju.getIfExists(obj, "RegistryName", "null");
		modelname = ju.getIfExists(obj, "ModelFile", "null");
		fullname = ju.getIfExists(obj, "FullName", registryname);
		if(obj.has("Description")){
			description = ju.jsonArrayToStringArray(obj.get("Description").getAsJsonArray());
		}
		
		if(obj.has("PrimaryColor")){
			primaryColor = RGB.fromJSON(obj.get("PrimaryColor").getAsJsonObject(), false);
		}
		if(obj.has("SecondaryColor")){
			secondaryColor = RGB.fromJSON(obj.get("SecondaryColor").getAsJsonObject(), false);
		}
		
		if(obj.has("ConstructionSettings")){
			JsonObject cs = obj.get("ConstructionSettings").getAsJsonObject();
			construction_length = ju.getIfExists(cs, "Length", 3).intValue();
			construction_height_offset = ju.getIfExists(cs, "HeightOffset", 0).floatValue();
			construction_wheel_offset = ju.getIfExists(cs, "WheelOffset", 8).floatValue();
			if(cs.has("Requires")){
				requires = ju.jsonArrayToStringArray(cs.get("Requires").getAsJsonArray());
			}
			readyToUse = ju.getIfExists(obj, "ReadyToUse", false);
		}
		
		if(obj.has("TextureSettings")){
			JsonObject ts = obj.get("TextureSettings").getAsJsonObject();
			if(ts.has("Textures")){
				ArrayList<String> list = ju.jsonArrayToStringArray(ts.get("Textures").getAsJsonArray());
				for(String s : list){
					textures.add(new ResourceLocation(s));
				}
			}
			current_texture = ju.getIfExists(ts, "Default", 0).intValue();
		}
		
		if(obj.has("PartSettings")){
			JsonObject ps = obj.get("PartSettings").getAsJsonObject();
			if(ps.has("PreInstalled")){
				ArrayList<String> list = ju.jsonArrayToStringArray(ps.get("PreInstalled").getAsJsonArray());
				for(String s : list){
					String[] part = s.split(":");
					try{
						parts.put(part[0], FvmResources.getPart(part[1]));
					}
					catch(Exception e){
						//
					}
				}
			}
			if(ps.has("Installed")){
				ArrayList<String> list = ju.jsonArrayToStringArray(ps.get("Installed").getAsJsonArray());
				for(String s : list){
					String[] part = s.split(":");
					try{
						parts.put(part[0], FvmResources.getPart(part[1]));
					}
					catch(Exception e){
						//
					}
				}
			}
		}
		if(obj.has("RenderSettings")){
			JsonObject rs = obj.get("RenderSettings").getAsJsonObject();
			scale = ju.getIfExists(rs, "Scale", 1f).floatValue();
			rotateWheels = ju.getIfExists(rs, "RotateWheels", true);
			cameraDistance = ju.getIfExists(rs, "CameraDistance", 5f).floatValue();
		}
		if(obj.has("InventorySettings")){
			JsonObject is = obj.get("InventorySettings").getAsJsonObject();
			if(is.has("Size")){
				container = new Container(is.get("Size").getAsInt());
			}
			fuelTankSize = ju.getIfExists(is, "TankSize", 1000).intValue();
		}
		if(obj.has("VehicleDefaults")){
			JsonObject vd = obj.get("VehicleDefaults").getAsJsonObject();
			driveType = DriveType.fromString(ju.getIfExists(vd, "DriveType", driveType.toString()));
			hasLock = ju.getIfExists(vd, "Lockable", true);
			wheelStepHeight = ju.getIfExists(vd, "WheelStepHeight", 1f).floatValue();
			wheelSpringStrength = ju.getIfExists(vd, "WheelSpringStrength", 0.5f).floatValue();
			maxThrottle = ju.getIfExists(vd, "MaxThrottle", 1f).floatValue();
			maxNegativeThrottle = ju.getIfExists(vd, "MaxNegativeThrottle", 0.5f).floatValue();
			turnLeftModifier = ju.getIfExists(vd, "TurnLeftModifier", 1f).floatValue();
			turnRightModifier = ju.getIfExists(vd, "TurnRightModifier", 1f).floatValue();
		}
		
		//Other
		if(obj.has("WheelPos")){
			JsonArray array = obj.get("WheelPos").getAsJsonArray();
			wheelPos = new Pos[array.size()];
			for(int i = 0; i < array.size(); i++){
				wheelPos[i] = Pos.fromJSON(array.get(i).getAsJsonObject());
			}
		}
		
		
		
		this.refreshAttributes();
		if(state.isLoadedInMemory()){
			VehicleItem.addVehicle(this);
		}
	}

	@Override
	public JsonObject save(JsonObject obj){
		if(obj == null){
			obj = new JsonObject();
		}
		obj.addProperty("AddOn", addonpack);
		obj.addProperty("RegistryName", registryname);
		obj.addProperty("ModelFile", modelname);
		obj.add("PrimaryColor", primaryColor.toJSON());
		obj.add("SecondaryColor", secondaryColor.toJSON());
		//
		JsonObject cs = new JsonObject();
		cs.addProperty("Length", construction_length);
		cs.addProperty("HeightOffset", construction_height_offset);
		cs.addProperty("WheelOffset", construction_wheel_offset);
		cs.add("Requires", ju.getArrayFromStringList(requires));
		cs.addProperty("ReadyToUse", readyToUse);
		obj.add("ConstructionSettings", cs);
		//
		JsonObject ts = new JsonObject();
		ArrayList<String> list = new ArrayList<String>();
		for(ResourceLocation rs : textures){
			list.add(rs.toString());
		}
		ts.add("Textures", ju.getArrayFromStringList(list));
		ts.addProperty("Default", current_texture);
		obj.add("TextureSettings", ts);
		//
		JsonObject ps = new JsonObject();
		ps.add("Installed", new JsonArray());
		for(Entry<String, PartType> part : parts.entrySet()){
			try{
				ps.get("Installed").getAsJsonArray().add(new JsonPrimitive(part.getKey() + ":" + part.getValue().registryname));
			}
			catch(Exception e){
				try{
					ps.get("Installed").getAsJsonArray().add(new JsonPrimitive(part.getKey() + ":" + part.getValue().registryname));
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
		obj.add("PartSettings", ps);
		JsonObject rs = new JsonObject();
		rs.addProperty("Scale", scale);
		rs.addProperty("RotateWheels", rotateWheels);
		rs.addProperty("CameraDistance", cameraDistance);
		obj.add("RenderSettings", rs);
		JsonObject is = new JsonObject();
		if(container != null){
			obj.addProperty("Size", container.getSizeInventory());
		}
		obj.addProperty("TankSize", fuelTankSize);
		obj.add("InventorySettings", is);
		JsonObject vd = new JsonObject();
		vd.addProperty("DriveType", driveType.toString());
		vd.addProperty("Lockable", hasLock);
		vd.addProperty("WheelStepHeight", wheelStepHeight);
		vd.addProperty("WheelSpringStrength", wheelSpringStrength);
		vd.addProperty("MaxThrottle", maxThrottle);
		vd.addProperty("MaxNegativeThrottle", maxNegativeThrottle);
		vd.addProperty("TurnLeftModifier", turnLeftModifier);
		vd.addProperty("TurnRightModifier", turnRightModifier);
		obj.add("VehicleDefaults", vd);
		//
		JsonArray wheelpos = new JsonArray();
		if(wheelPos != null){
			for(Pos pos : wheelPos){
				JsonObject objj = pos.toJSON();
				wheelpos.add(objj);
			}
		}
		obj.add("WheelPos", wheelpos);
		return obj;
	}

	@Override
	public void read(NBTTagCompound compound){
		if(compound.hasKey("VehicleType")){
			this.load(JsonUtil.getFromString(compound.getString("VehicleType")).getAsJsonObject());
		}
		else{
			this.load(FvmResources.getVehicle("T1").save(null));
		}
		if(compound.hasKey("Locked")){
			this.isLocked = compound.getBoolean("Locked");
		}
		if(compound.hasKey("LockCode")){
			this.lock_code = compound.getString("LockCode");
		}
		if(compound.hasKey("Fuel")){
			this.fuelStored = compound.getInteger("Fuel");
		}
		if(compound.hasKey("Inventory")){
			container.readFromNBT(compound.getCompoundTag("Inventory"));
		}
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		compound.setString("VehicleType", this.toString());
		compound.setBoolean("Locked", isLocked);
		compound.setString("LockCode", lock_code);
		compound.setInteger("Fuel", fuelStored);
		if(container != null){
			compound.setTag("Inventory", container.writeToNBT(new NBTTagCompound()));
		}
		return compound;
	}

	@Override
	public DataObject newInstance(LoadedIn state){
		if(this.state.isLoadedInMemory()){
			return new VehicleType(state, save(new JsonObject()));
		}
		else{
			Static.exception(5);
			return null;
		}
	}
	
	public VehicleModel getModel(){
		return model;
	}
	
	public void loadModel(JsonObject obj){
		if(obj != null){
			if(obj.has("type")){
				switch(obj.get("type").getAsString()){
					case "class":
						try{
							Class clazz = Class.forName(modelname.replace(".class", ""));
							model = (VehicleModel)clazz.newInstance();
						}
						catch(Exception e){
							e.printStackTrace();
							//Static.stop();
						}
						break;
					case "def_json":
						//TODO
						break;
				}
			}
			else{
				model = new VehicleModel(obj);
			}
		}
	}

	@Override
	public int compareTo(Object o) {
		if(registryname == null){
			return -1;
		}
		return registryname.compareTo(((VehicleType)o).registryname);
	}

	public void setItem(Item item){
		this.item = item;
	}

	public boolean hasPartType(String string){
		return parts.containsKey(string);
	}

	public boolean canInstall(ItemStack stack){
		PartType part = FvmResources.getPart(stack);
		if(!part.availableInConstructor){
			return false;
		}
		for(String s : part.category){
			if(parts.containsKey(s)){
				return false;
			}
		}
		if(parts.containsValue(part)){
			return false;
		}
		for(PartType type : parts.values()){
			if(type.incompatible.containsKey("Any")){
				return false;
			}
			if(type.incompatible.get(type.registryname) != null){
				for(String s : type.incompatible.get(this.registryname)){
					if(s.equals(part.registryname) || s.equals("Any")){
						return false;
					}
				}
			}
		}
		return hasRequiredParts(part);
	}

	private boolean hasRequiredParts(PartType part){
		if(part.requires.isEmpty()){
			return true;
		}
		if(part.requires.get(this.registryname) != null){
			ArrayList<String> list = new ArrayList<String>(); 
			for(PartType type : parts.values()){
				list.add(type.registryname);
			}
			return list.containsAll(part.requires.get(this.registryname));
		}
		return true;
	}
	
	/**
	 * 
	 * @param b <br> true = add missing <br> false = add new
	 * @param type the part type
	 */
	public void installPart(boolean b, PartType type){
		if(b){
			
		}
		else{
			boolean installed = false;
			for(String s : type.category){
				if(!parts.containsKey(s)){
					parts.put(s, type);
					installed = true;
					this.refreshAttributes();
				}
			}
			if(!installed){
				Print.debug("Type already contains a part of this category!");
			}
		}
	}

	private void refreshAttributes(){
		for(PartType part : parts.values()){
			if(part.attributes.contains("seats") || part.attributes.contains("seat")){
				seats.addAll(part.seats);
			}
			//general modifiers
		}
		if(seats.size() > 0 && !seats.get(0).isDriver()){
			seats = new SortableList<Seat>();
			for(int i = 0; i < seats.size(); i++){
				if(seats.get(i).isDriver()){
					seats.putAt(0, i);
					break;
				}
			}
		}
		
	}

	public String usedAs(PartType type){
		for(Entry<String, PartType> part : parts.entrySet()){
			if(part.getValue().registryname.equals(type.registryname)){
				return part.getKey();
			}
		}
		return null;
	}
	
	@Override
	public String toString(){
		return this.save(null).toString();
	}

	public ResourceLocation getTexture(){
		if(current_texture < textures.size() && current_texture >= 0){
			return textures.get(current_texture);
		}
		return textures.get(0);
	}

	public boolean isReadyToUse(){
		if(readyToUse){
			return true;
		}
		return requires.isEmpty();
	}
	
	public Container getContainer(){
		if(container == null){
			container = new Container();
		}
		return container;
	}
	
	public static class Container implements IInventory {
		
		private NonNullList<ItemStack> stacks;
		
		public Container(){
			stacks = NonNullList.<ItemStack>withSize(0, ItemStack.EMPTY);
		}
		
		public Container(int i){
			stacks = NonNullList.<ItemStack>withSize(i, ItemStack.EMPTY);
		}
		
		public void readFromNBT(NBTTagCompound tag) {
			ItemStackHelper.loadAllItems(tag, stacks);
		}
		
		public NBTTagCompound writeToNBT(NBTTagCompound tag) {
			return ItemStackHelper.saveAllItems(tag, stacks);
		}

		@Override
		public String getName(){
			return "vehicledata.container";
		}

		@Override
		public boolean hasCustomName(){
			return false;
		}

		@Override
		public ITextComponent getDisplayName(){
			return new TextComponentString("fvm.vehicle.inventorycontainer");
		}

		@Override
		public int getSizeInventory(){
			return stacks.size();
		}

		@Override
		public boolean isEmpty(){
			return stacks.isEmpty();
		}

		@Override
		public ItemStack getStackInSlot(int index){
			return stacks.get(index);
		}

		@Override
		public ItemStack decrStackSize(int index, int count){
			return ItemStackHelper.getAndSplit(stacks, index, count);
		}

		@Override
		public ItemStack removeStackFromSlot(int index){
			return ItemStackHelper.getAndRemove(stacks, index);
		}

		@Override
		public void setInventorySlotContents(int index, ItemStack stack) {
			stacks.set(index, stack);
		}

		@Override
		public int getInventoryStackLimit(){
			return 128;
		}

		@Override
		public void markDirty(){
			// ?
		}

		@Override
		public boolean isUsableByPlayer(EntityPlayer player){
			return true;
		}

		@Override
		public void openInventory(EntityPlayer player){
			//
		}

		@Override
		public void closeInventory(EntityPlayer player){
			//
		}

		@Override
		public boolean isItemValidForSlot(int index, ItemStack stack) {
			// TODO
			return false;
		}

		@Override
		public int getField(int id){
			return 0;
		}

		@Override
		public void setField(int id, int value) {
			//
		}

		@Override
		public int getFieldCount(){
			return 0;
		}

		@Override
		public void clear(){
			stacks.clear();
		}
		
	}

	public PartType getPart(String string){
		return parts.get(string);
	}
	
	public boolean hasTracks(){
		return driveType == DriveType.TRACK;
	}
	
	public boolean is4WD(){
		return driveType == DriveType.AWD;
	}
	
	public boolean isFWD(){
		return driveType == DriveType.FWD;
	}
	
	public boolean isRWD(){
		return driveType == DriveType.RWD;
	}
	
	public DriveType drive(){
		return driveType;
	}

	public ItemStack newStack(){
		return new ItemStack(item, 1, 0);
	}
	
}