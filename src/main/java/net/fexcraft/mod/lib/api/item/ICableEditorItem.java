package net.fexcraft.mod.lib.api.item;

import net.fexcraft.mod.lib.util.cls.EnumCableEditorMode;
import net.fexcraft.mod.lib.util.cls.EnumFacingEditType;

public interface ICableEditorItem extends IItem {

	public EnumFacingEditType getFacingEditType();
	
	public EnumCableEditorMode getMode();

	public void setFacingEditType(EnumFacingEditType e);
	
	public void setMode(EnumCableEditorMode e);
}