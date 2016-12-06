package net.fexcraft.mod.extensions.fve.blocks;

import net.fexcraft.mod.extensions.fve.tileentities.C5TE;
import net.fexcraft.mod.extensions.fve.tileentities.C6TE;
import net.fexcraft.mod.extensions.fve.tileentities.T1TE;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public final class FVERBlocks {

    public static Block C5R;
    public static Block C5RBlue;
    public static Block C5RRed;
    public static Block C5RGreen;
    public static Block C5RBlack;
    public static Block C5RWhite;
    public static Block C5RPink;
    public static Block C5RPurple;
    public static Block C5ROrange;
    public static Block C5RCyan;
    public static Block C5RYellow;
    public static Block C5RBrown;
    public static Block C5RGray;
    //
    public static Block C6R;
    public static Block C6RBlue;
    public static Block C6RRed;
    public static Block C6RBlack;
    public static Block C6RWhite;
    public static Block C6RGray;
    public static Block C6RSilver;
    public static Block C6RYellow;
    public static Block C6RBeige;
    public static Block C6RPink;
    public static Block C6RBrown;
    public static Block C6ROrange;
    public static Block C6RPurple;
    public static Block C6RC;
    //
    public static Block T1R;
    public static Block T1RBlue;
    public static Block T1RRed;
    public static Block T1RBlack;
    public static Block T1RWhite;
    public static Block T1RGray;
    public static Block T1RSilver;
    public static Block T1RYellow;
    public static Block T1RBeige;
    public static Block T1RPink;
    public static Block T1RBrown;
    public static Block T1ROrange;
    public static Block T1RPurple;
    public static Block T1RCyan;
    public static Block T1RC;
    //
  
    public static void init(){
        C5R = new C5R("C5R");
    	C5RBlue = new C5RBlue("C5RBlue");
    	C5RRed = new C5RRed("C5RRed");
    	C5RGreen = new C5RGreen("C5RGreen");
    	C5RBlack = new C5RBlack("C5RBlack");
    	C5RWhite = new C5RWhite("C5RWhite");
    	C5RPink = new C5RPink("C5RPink");
    	C5RPurple = new C5RPurple("C5RPurple");
    	C5ROrange = new C5ROrange("C5ROrange");
    	C5RCyan = new C5RCyan("C5RCyan");
    	C5RYellow = new C5RYellow("C5RYellow");
    	C5RBrown = new C5RBrown("C5RBrown");
    	C5RGray = new C5RGray("C5RGray");
    	//
    	//
    	C6R = new C6R("C6R");
    	C6RBlue = new C6RBlue("C6RBlue");
    	C6RRed = new C6RRed("C6RRed");
    	C6RBlack = new C6RBlack("C6RBlack");
    	C6RWhite = new C6RWhite("C6RWhite");
    	C6RGray = new C6RGray("C6RGray");
    	C6RSilver = new C6RSilver("C6RSilver");
    	C6RYellow = new C6RYellow("C6RYellow");
    	C6RBeige = new C6RBeige("C6RBeige");
    	C6RPink = new C6RPink("C6RPink");
    	C6RBrown = new C6RBrown("C6RBrown");
    	C6ROrange = new C6ROrange("C6ROrange");
    	C6RPurple = new C6RPurple("C6RPurple");
    	C6RC = new C6RC("C6RC");
    	//
    	T1R = new T1R("T1R");
    	T1RBlue = new T1RBlue("T1RBlue");
    	T1RRed = new T1RRed("T1RRed");
    	T1RBlack = new T1RBlack("T1RBlack");
    	T1RWhite = new T1RWhite("T1RWhite");
    	T1RGray = new T1RGray("T1RGray");
    	T1RSilver = new T1RSilver("T1RSilver");
    	T1RYellow = new T1RYellow("T1RYellow");
    	T1RBeige = new T1RBeige("T1RBeige");
    	T1RPink = new T1RPink("T1RPink");
    	T1RBrown = new T1RBrown("T1RBrown");
    	T1ROrange = new T1ROrange("T1ROrange");
    	T1RPurple = new T1RPurple("T1RPurple");
    	T1RCyan = new T1RC("T1RCyan");
    	T1RC = new T1RC("T1RC");
    	//
	}
    
    //C5
    public static class C5R extends FVEBB{
    	public C5R(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5R();}
    }
    public static class C5RBlue extends FVEBB{
    	public C5RBlue(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5RBlue();}
    }
    public static class C5RRed extends FVEBB{
    	public C5RRed(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5RRed();}
    }
    public static class C5RGreen extends FVEBB{
    	public C5RGreen(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5RGreen();}
    }
    public static class C5RBlack extends FVEBB{
    	public C5RBlack(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5RBlack();}
    }
    public static class C5RWhite extends FVEBB{
    	public C5RWhite(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5RWhite();}
    }
    public static class C5RPink extends FVEBB{
    	public C5RPink(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5RPink();}
    }
    public static class C5RPurple extends FVEBB{
    	public C5RPurple(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5RPurple();}
    }
    public static class C5ROrange extends FVEBB{
    	public C5ROrange(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5ROrange();}
    }
    public static class C5RCyan extends FVEBB{
    	public C5RCyan(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5RCyan();}
    }
    public static class C5RYellow extends FVEBB{
    	public C5RYellow(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5RYellow();}
    }
    public static class C5RBrown extends FVEBB{
    	public C5RBrown(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5RBrown();}
    }
    public static class C5RGray extends FVEBB{
    	public C5RGray(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5RGray();}
    }
    // C6
    public static class C6R extends FVEBB{
    	public C6R(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6R();}
    }
    public static class C6RBlue extends FVEBB{
    	public C6RBlue(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6RBlue();}
    }
    public static class C6RRed extends FVEBB{
    	public C6RRed(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6RRed();}
    }
    public static class C6RBlack extends FVEBB{
    	public C6RBlack(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6RBlack();}
    }
    public static class C6RWhite extends FVEBB{
    	public C6RWhite(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6RWhite();}
    }
    public static class C6RGray extends FVEBB{
    	public C6RGray(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6RGray();}
    }
    public static class C6RSilver extends FVEBB{
    	public C6RSilver(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6RSilver();}
    }
    public static class C6RYellow extends FVEBB{
    	public C6RYellow(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6RYellow();}
    }
    public static class C6RBeige extends FVEBB{
    	public C6RBeige(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6RBeige();}
    }
    public static class C6RPink extends FVEBB{
    	public C6RPink(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6RPink();}
    }
    public static class C6RBrown extends FVEBB{
    	public C6RBrown(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6RBrown();}
    }
    public static class C6ROrange extends FVEBB{
    	public C6ROrange(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6ROrange();}
    }
    public static class C6RPurple extends FVEBB{
    	public C6RPurple(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6RPurple();}
    }
    public static class C6RC extends FVEBB{
    	public C6RC(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6RC();}
    }
    // T1
    public static class T1R extends FVEBB{
    	public T1R(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1R();}
    }
    public static class T1RBlue extends FVEBB{
    	public T1RBlue(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1RBlue();}
    }
    public static class T1RRed extends FVEBB{
    	public T1RRed(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1RRed();}
    }
    public static class T1RBlack extends FVEBB{
    	public T1RBlack(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1RBlack();}
    }
    public static class T1RWhite extends FVEBB{
    	public T1RWhite(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1RWhite();}
    }
    public static class T1RGray extends FVEBB{
    	public T1RGray(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1RGray();}
    }
    public static class T1RSilver extends FVEBB{
    	public T1RSilver(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1RSilver();}
    }
    public static class T1RYellow extends FVEBB{
    	public T1RYellow(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1RYellow();}
    }
    public static class T1RBeige extends FVEBB{
    	public T1RBeige(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1RBeige();}
    }
    public static class T1RPink extends FVEBB{
    	public T1RPink(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1RPink();}
    }
    public static class T1RBrown extends FVEBB{
    	public T1RBrown(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1RBrown();}
    }
    public static class T1ROrange extends FVEBB{
    	public T1ROrange(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1ROrange();}
    }
    public static class T1RPurple extends FVEBB{
    	public T1RPurple(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1RPurple();}
    }
    public static class T1RCyan extends FVEBB{
    	public T1RCyan(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1RCyan();}
    }
    public static class T1RC extends FVEBB{
    	public T1RC(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1RC();}
    }
} 
