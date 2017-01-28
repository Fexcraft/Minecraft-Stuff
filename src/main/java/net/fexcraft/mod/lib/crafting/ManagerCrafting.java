package net.fexcraft.mod.lib.crafting;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ManagerCrafting {
	
    private static final ManagerCrafting instance = new ManagerCrafting();
    private final List<IRecipe> recipes = Lists.<IRecipe>newArrayList();
    
    public static ManagerCrafting getInstance(){
        return instance;
    }

    private ManagerCrafting(){}
    
    public ShapedRecipes addRecipe(ItemStack stack, Object... recipeComponents){
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;
        if(recipeComponents[i] instanceof String[]){
            String[] astring = (String[])((String[])recipeComponents[i++]);
            for(String s2 : astring){
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }
        else{
            while(recipeComponents[i] instanceof String){
                String s1 = (String)recipeComponents[i++];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        Map<Character, ItemStack> map;
        for (map = Maps.<Character, ItemStack>newHashMap(); i < recipeComponents.length; i += 2){
            Character character = (Character)recipeComponents[i];
            ItemStack itemstack = ItemStack.EMPTY;
            if(recipeComponents[i + 1] instanceof Item){
                itemstack = new ItemStack((Item)recipeComponents[i + 1]);
            }
            else if(recipeComponents[i + 1] instanceof Block){
                itemstack = new ItemStack((Block)recipeComponents[i + 1], 1, 32767);
            }
            else if(recipeComponents[i + 1] instanceof ItemStack){
                itemstack = (ItemStack)recipeComponents[i + 1];
            }
            map.put(character, itemstack);
        }
        ItemStack[] aitemstack = new ItemStack[j * k];
        for(int l = 0; l < j * k; ++l){
            char c0 = s.charAt(l);
            if(map.containsKey(Character.valueOf(c0))){
                aitemstack[l] = ((ItemStack)map.get(Character.valueOf(c0))).copy();
            }
            else{
                aitemstack[l] = ItemStack.EMPTY;
            }
        }
        ShapedRecipes shapedrecipes = new ShapedRecipes(j, k, aitemstack, stack);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }
    
    public void addShapelessRecipe(ItemStack stack, Object... recipeComponents){
        List<ItemStack> list = Lists.<ItemStack>newArrayList();
        for(Object object : recipeComponents){
            if(object instanceof ItemStack){
                list.add(((ItemStack)object).copy());
            }
            else if(object instanceof Item){
                list.add(new ItemStack((Item)object));
            }
            else{
                if(!(object instanceof Block)){
                    throw new IllegalArgumentException("Invalid shapeless recipe: unknown type " + object.getClass().getName() + "!");
                }
                list.add(new ItemStack((Block)object));
            }
        }
        this.recipes.add(new ShapelessRecipes(stack, list));
    }
    
    public void addRecipe(IRecipe recipe){
        this.recipes.add(recipe);
    }
    
    public ItemStack findMatchingRecipe(CraftingInventory craftMatrix, World worldIn){
        for(IRecipe irecipe : this.recipes){
            if(irecipe.matches(craftMatrix, worldIn)){
                return irecipe.getCraftingResult(craftMatrix);
            }
        }
        return ItemStack.EMPTY;
    }

    public NonNullList<ItemStack> getRemainingItems(CraftingInventory craftMatrix, World worldIn){
        for(IRecipe irecipe : this.recipes){
            if(irecipe.matches(craftMatrix, worldIn)){
                return irecipe.getRemainingItems(craftMatrix);
            }
        }
        NonNullList<ItemStack> nonnulllist = NonNullList.<ItemStack>withSize(craftMatrix.getSizeInventory(), ItemStack.EMPTY);
        for(int i = 0; i < nonnulllist.size(); ++i){
            nonnulllist.set(i, craftMatrix.getStackInSlot(i));
        }
        return nonnulllist;
    }

    public List<IRecipe> getRecipeList(){
        return this.recipes;
    }
    
}