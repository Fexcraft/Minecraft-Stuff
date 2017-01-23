package net.fexcraft.mod.lib.tmt;

public abstract class Model extends net.minecraft.client.model.ModelBase{
	
	public abstract void render();
	
	public abstract void render(ModelRendererTurbo[] part);
	
	protected abstract void translate(ModelRendererTurbo[] model, float x, float y, float z);
	
}