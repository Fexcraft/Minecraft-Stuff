package net.fexcraft.mod.fvtm.auto;

import net.fexcraft.mod.fvtm.FVTM;
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
	private String url;
	
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
	public NBTTagCompound writeToNBT(NBTTagCompound tagcompound){
		tagcompound.setString(PartItem.NBTKEY, part.getRegistryName().toString());
		NBTTagCompound compound = new NBTTagCompound();
		compound.setInteger("SelectedTexture", sel);
		compound.setString("TextureUrl", url);
		tagcompound.setTag(FVTM.MODID, offset.toNBT("Offset", compound));
		return tagcompound;
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
		compound = compound.getCompoundTag(FVTM.MODID);
		sel = compound.getInteger("SelectedTexture");
		offset = Pos.fromNBT("Offset", compound);
		url = compound.getString("TextureUrl");
		return this;
	}

	@Override
	public String getTextureURL(){
		return url;
	}

	@Override
	public void setTextureURL(String string){
		url = string;
	}
	
}