package net.fexcraft.mod.lib.api.item;

import net.fexcraft.mod.lib.util.render.ModelType;

public interface ICargoItem extends IItem {
	
	public ModelType getModelType();
	
	public Object getModel();
	
}