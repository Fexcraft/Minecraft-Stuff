package net.fexcraft.mod.fvm.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import net.fexcraft.mod.fvm.data.Script;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

public class ScriptList implements List<Script> {
	
	private ArrayList<Script> list;
	
	public ScriptList(){
		list = new ArrayList<Script>();
	}

	@Override
	public int size(){
		return list.size();
	}

	@Override
	public boolean isEmpty(){
		return list.isEmpty();
	}

	@Override
	public boolean contains(Object o){
		return list.contains(o);
	}

	@Override
	public Iterator iterator(){
		return list.iterator();
	}

	@Override
	public Object[] toArray(){
		return list.toArray();
	}

	@Override
	public Object[] toArray(Object[] a){
		return list.toArray(a);
	}

	@Override
	public boolean add(Script e){
		return list.add(e);
	}

	@Override
	public boolean remove(Object o){
		return list.remove(o);
	}

	@Override
	public boolean containsAll(Collection c){
		return list.containsAll(c);
	}

	@Override
	public boolean addAll(Collection c){
		return list.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection c){
		return list.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection c){
		return list.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection c){
		return list.retainAll(c);
	}

	@Override
	public void clear(){
		list.clear();
	}

	@Override
	public Script get(int index){
		return list.get(index);
	}
	
	public Script get(String s){
		for(Script scr : list){
			if(scr.getId().equals(s)){
				return scr;
			}
		}
		return null;
	}
	public boolean contains(String string){
		return !(get(string) == null);
	}

	@Override
	public Script set(int index, Script element){
		return list.set(index, element);
	}

	@Override
	public void add(int index, Script element) {
		list.add(index, element);
	}

	@Override
	public Script remove(int index){
		return list.remove(index);
	}

	@Override
	public int indexOf(Object o){
		return list.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o){
		return list.lastIndexOf(o);
	}

	@Override
	public ListIterator listIterator(){
		return list.listIterator();
	}

	@Override
	public ListIterator listIterator(int index){
		return list.listIterator(index);
	}

	@Override
	public List subList(int fromIndex, int toIndex){
		return list.subList(fromIndex, toIndex);
	}

	public void onPacket(com.flansmod.fvm.LandVehicle landVehicle, NBTTagCompound nbt, Side side){
		String s = nbt.getString("ScriptId");
		for(Script scr : list){
			if(scr.getId().equals(s)){
				scr.onPacket(landVehicle, nbt, side);
			}
		}
	}

	public void read(NBTTagCompound compound){
		for(Script s : list){
			s.read(compound.hasKey(s.getId()) ? compound.getCompoundTag(s.getId()) : new NBTTagCompound());
		}
	}
	
	public void write(NBTTagCompound compound){
		for(Script s : list){
			compound.setTag(s.getId(), s.write(new NBTTagCompound()));
		}
	}

	public void onCreated(com.flansmod.fvm.LandVehicle vehicleentity){
		for(Script s : list){
			s.onCreated(vehicleentity);
		}
	}

	public void onRemoved(com.flansmod.fvm.LandVehicle vehicleentity){
		for(Script s : list){
			s.onRemoved(vehicleentity);
		}
	}

	public void onUpdate(com.flansmod.fvm.LandVehicle vehicleentity){
		for(Script s : list){
			s.onUpdate(vehicleentity);
		}
	}

	public boolean onInteract(com.flansmod.fvm.LandVehicle landVehicle, EntityPlayer entityplayer){
		boolean bool = false;
		for(Script s : list){
			if(s.onInteract(landVehicle, entityplayer)){
				bool = true;
			}
		}
		return bool;
	}
	
}