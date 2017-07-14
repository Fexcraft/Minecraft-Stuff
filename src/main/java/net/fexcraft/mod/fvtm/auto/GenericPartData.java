package net.fexcraft.mod.fvtm.auto;

import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class GenericPartData implements PartData {
	
	private Part part;
	private int sel;
	private Pos offset;
	
	public GenericPartData(){}

	@Override
	public Part getPart(){
		return part;
	}

	@Override
	public int getSelectedTexture(){
		return sel;
	}

	@Override
	public Pos getCurrentOffset(){
		return offset;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		compound.setString(PartItem.NBTKEY, part.getRegistryName().toString());
		compound.setInteger("SelectedTexture", sel);
		return offset.toNBT("Offset", compound);
	}

	@Override
	public PartData readFromNBT(NBTTagCompound compound){
		if(!compound.hasKey(PartItem.NBTKEY)){
			return null;
		}
		part = Resources.PARTS.getValue(new ResourceLocation(compound.getString(PartItem.NBTKEY)));
		if(part == null){
			return null;
		}
		sel = compound.getInteger("SelectedTexture");
		offset = Pos.fromNBT("Offset", compound);
		return this;
	}
	
}