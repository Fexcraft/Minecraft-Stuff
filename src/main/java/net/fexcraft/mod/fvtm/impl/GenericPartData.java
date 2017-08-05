package net.fexcraft.mod.fvtm.impl;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.math.Pos;
import net.fexcraft.mod.lib.util.render.ExternalTextureHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class GenericPartData implements PartData {
	
	private Part part;
	private int sel;
	private Pos offset;
	private String url;
	private ResourceLocation custom;
	private boolean isexternal;
	
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
		compound.setString("CustomTexture", isexternal ? url == null ? "" : url : custom.toString());
		compound.setBoolean("IsTextureExternal", isexternal);
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
		isexternal = compound.getBoolean("IsTextureExternal");
		url = isexternal ? compound.getString("CustomTexture") : null;
		custom = isexternal ? null : new ResourceLocation(compound.getString("CustomTexture"));
		return this;
	}

	@Override
	public ResourceLocation getCustomTexture(){
		return isexternal ? ExternalTextureHelper.get(url) : this.custom;
	}

	@Override
	public void setCustomTexture(String string, boolean external){
		this.url = external ? string : null;
		this.custom = external ? null : new ResourceLocation(string);
		this.isexternal = external;
	}

	@Override
	public void setSelectedTexture(int i){
		this.sel = i;
	}

	@Override
	public boolean isTextureExternal(){
		return isexternal;
	}

	@Override
	public ResourceLocation getTexture(){
		return sel >= 0 ? part.getTextures().get(sel) : this.getCustomTexture();
	}
	
}