package net.fexcraft.mod.fvtm.auto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.LandVehicle;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleData;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleItem;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.math.Pos;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;

public class GenericLandVehicleData implements LandVehicleData {
	
	private LandVehicle vehicle;
	private int sel, tank;
	private String url;
	private TreeMap<String, PartData> parts = new TreeMap<String, PartData>();
	private List<Pos> wheelpos;
	private RGB primary, secondary;
	private boolean doors;
	
	public GenericLandVehicleData(){}
	
	@Override
	public LandVehicle getVehicle(){
		return this.vehicle;
	}

	@Override
	public int getSelectedTexture(){
		return sel;
	}

	@Override
	public String getTextureURL(){
		return url;
	}

	@Override
	public void setTextureURL(String string){
		this.url = string;
	}

	@Override
	public int getFuelTankContent(){
		return tank;
	}

	@Override
	public int getFuelTankSize(){
		//TODO calculation
		return 0;
	}

	@Override
	public Set<String> getInstalledParts(){
		return parts.keySet();
	}

	@Override
	public Map<String, PartData> getParts(){
		return parts;
	}

	@Override
	public List<Pos> getWheelPos(){
		return wheelpos == null ? vehicle.getDefaultWheelPos() : wheelpos;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tagcompound){
		tagcompound.setString(LandVehicleItem.NBTKEY, vehicle.getRegistryName().toString());
		NBTTagCompound compound = new NBTTagCompound();
		compound.setInteger("SelectedTexture", sel);
		compound.setString("TextureUrl", url == null ? "" : url);
		compound.setInteger("FuelTank", tank);
		NBTTagList list = new NBTTagList();
		for(Entry<String, PartData> part : parts.entrySet()){
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setString("UsedAs", part.getKey());
			list.appendTag(part.getValue().writeToNBT(nbt));
		}
		compound.setTag("Parts", list);
		if(wheelpos != null){
			NBTTagList wlist = new NBTTagList();
			for(int i = 0; i < wheelpos.size(); i++){
				wlist.appendTag(wheelpos.get(i).toNBT("W" + i, compound));
			}
			compound.setTag("WheelPos", wlist);
		}
		if(this.primary != null){
			compound.setFloat("PrimaryRed", this.primary.red);
			compound.setFloat("PrimaryGreen", this.primary.green);
			compound.setFloat("PrimaryBlue", this.primary.blue);
		}
		if(this.secondary != null){
			compound.setFloat("SecondaryRed", this.secondary.red);
			compound.setFloat("SecondaryGreen", this.secondary.green);
			compound.setFloat("SecondaryBlue", this.secondary.blue);
		}
		compound.setBoolean("DoorsOpen", doors);
		tagcompound.setTag(FVTM.MODID, compound);
		return tagcompound;
	}

	@Override
	public LandVehicleData readFromNBT(NBTTagCompound compound){
		if(!compound.hasKey(LandVehicleItem.NBTKEY)){
			return null;
		}
		vehicle = Resources.LANDVEHICLES.getValue(new ResourceLocation(compound.getString(LandVehicleItem.NBTKEY)));
		if(vehicle == null){
			return null;
		}
		compound = compound.getCompoundTag(FVTM.MODID);
		this.sel = compound.getInteger("SelectedTexture");
		this.url = compound.getString("TextureUrl");
		this.tank = compound.getInteger("FuelTank");
		if(compound.hasKey("Parts")){
			NBTTagList list = compound.getTagList("Parts", 9);
			for(NBTBase base : list){
				NBTTagCompound nbt = (NBTTagCompound)base;
				PartData data = new GenericPartData().readFromNBT(nbt);
				if(data != null){
					this.parts.put(nbt.getString("UsedAs"), data);
				}
			}
		}
		if(compound.hasKey("WheelPos")){
			NBTTagList list = compound.getTagList("WheelPos", 9);
			this.wheelpos = new ArrayList<Pos>();
			for(int i = 0; i < list.tagCount(); i++){
				if(this.wheelpos.size() < 4){
					this.wheelpos.add(Pos.fromNBT("W" + i, list.getCompoundTagAt(i)));
				}
			}
		}
		if(compound.hasKey("PrimaryRed")){
			this.primary = new RGB(compound.getFloat("PrimaryRed"), compound.getFloat("PrimaryGreen"), compound.getFloat("PrimaryBlue"));
		}
		else{
			this.primary = new RGB();
			this.primary.copyFrom(vehicle.getDefPrimaryColor());
		}
		if(compound.hasKey("SecondaryRed")){
			this.secondary = new RGB(compound.getFloat("SecondaryRed"), compound.getFloat("SecondaryGreen"), compound.getFloat("SecondaryBlue"));
		}
		else{
			this.secondary = new RGB();
			this.secondary.copyFrom(vehicle.getDefSecondaryolor());
		}
		this.doors = compound.getBoolean("DoorsOpen");
		return this;
	}

	@Override
	public RGB getPrimaryColor(){
		return primary;
	}

	@Override
	public RGB getSecondaryColor(){
		return secondary;
	}

	@Override
	public boolean readyToSpawn(){
		boolean result = true;
		for(ResourceLocation rs : vehicle.getRequiredParts()){
			if(!this.parts.containsKey(rs)){
				result = false;
				break;
			}
		}
		return result;
	}

	@Override
	public boolean doorsOpen(){
		return doors;
	}
	
}