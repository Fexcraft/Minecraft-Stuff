package net.fexcraft.mod.extensions.fve.blocks;

import net.fexcraft.mod.extensions.fve.tileentities.C5TE;
import net.fexcraft.mod.extensions.fve.tileentities.C6TE;
import net.fexcraft.mod.extensions.fve.tileentities.T1TE;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public final class FVELBlocks {

    public static Block C5L;
    public static Block C5LBlue;
    public static Block C5LRed;
    public static Block C5LGreen;
    public static Block C5LBlack;
    public static Block C5LWhite;
    public static Block C5LPink;
    public static Block C5LPurple;
    public static Block C5LOrange;
    public static Block C5LCyan;
    public static Block C5LYellow;
    public static Block C5LBrown;
    public static Block C5LGray;
    //
    public static Block C6L;
    public static Block C6LBlue;
    public static Block C6LRed;
    public static Block C6LBlack;
    public static Block C6LWhite;
    public static Block C6LGray;
    public static Block C6LSilver;
    public static Block C6LYellow;
    public static Block C6LBeige;
    public static Block C6LPink;
    public static Block C6LBrown;
    public static Block C6LOrange;
    public static Block C6LPurple;
    public static Block C6LC;
    //
    public static Block T1L;
    public static Block T1LBlue;
    public static Block T1LRed;
    public static Block T1LBlack;
    public static Block T1LWhite;
    public static Block T1LGray;
    public static Block T1LSilver;
    public static Block T1LYellow;
    public static Block T1LBeige;
    public static Block T1LPink;
    public static Block T1LBrown;
    public static Block T1LOrange;
    public static Block T1LPurple;
    public static Block T1LCyan;
    public static Block T1LC;
    //
  
    public static void init(){
        C5L = new C5L("C5L");
    	C5LBlue = new C5LBlue("C5LBlue");
    	C5LRed = new C5LRed("C5LRed");
    	C5LGreen = new C5LGreen("C5LGreen");
    	C5LBlack = new C5LBlack("C5LBlack");
    	C5LWhite = new C5LWhite("C5LWhite");
    	C5LPink = new C5LPink("C5LPink");
    	C5LPurple = new C5LPurple("C5LPurple");
    	C5LOrange = new C5LOrange("C5LOrange");
    	C5LCyan = new C5LCyan("C5LCyan");
    	C5LYellow = new C5LYellow("C5LYellow");
    	C5LBrown = new C5LBrown("C5LBrown");
    	C5LGray = new C5LGray("C5LGray");
    	//
    	C6L = new C6L("C6L");
    	C6LBlue = new C6LBlue("C6LBlue");
    	C6LRed = new C6LRed("C6LRed");
    	C6LBlack = new C6LBlack("C6LBlack");
    	C6LWhite = new C6LWhite("C6LWhite");
    	C6LGray = new C6LGray("C6LGray");
    	C6LSilver = new C6LSilver("C6LSilver");
    	C6LYellow = new C6LYellow("C6LYellow");
    	C6LBeige = new C6LBeige("C6LBeige");
    	C6LPink = new C6LPink("C6LPink");
    	C6LBrown = new C6LBrown("C6LBrown");
    	C6LOrange = new C6LOrange("C6LOrange");
    	C6LPurple = new C6LPurple("C6LPurple");
    	C6LC = new C6LC("C6LC");
    	//
    	T1L = new T1L("T1L");
    	T1LBlue = new T1LBlue("T1LBlue");
    	T1LRed = new T1LRed("T1LRed");
    	T1LBlack = new T1LBlack("T1LBlack");
    	T1LWhite = new T1LWhite("T1LWhite");
    	T1LGray = new T1LGray("T1LGray");
    	T1LSilver = new T1LSilver("T1LSilver");
    	T1LYellow = new T1LYellow("T1LYellow");
    	T1LBeige = new T1LBeige("T1LBeige");
    	T1LPink = new T1LPink("T1LPink");
    	T1LBrown = new T1LBrown("T1LBrown");
    	T1LOrange = new T1LOrange("T1LOrange");
    	T1LPurple = new T1LPurple("T1LPurple");
    	T1LCyan = new T1LC("T1LCyan");
    	T1LC = new T1LC("T1LC");
    	//
	}
    
    //C5
    public static class C5L extends FVEBB{
    	public C5L(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5L();}
    }
    public static class C5LBlue extends FVEBB{
    	public C5LBlue(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5LBlue();}
    }
    public static class C5LRed extends FVEBB{
    	public C5LRed(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5LRed();}
    }
    public static class C5LGreen extends FVEBB{
    	public C5LGreen(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5LGreen();}
    }
    public static class C5LBlack extends FVEBB{
    	public C5LBlack(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5LBlack();}
    }
    public static class C5LWhite extends FVEBB{
    	public C5LWhite(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5LWhite();}
    }
    public static class C5LPink extends FVEBB{
    	public C5LPink(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5LPink();}
    }
    public static class C5LPurple extends FVEBB{
    	public C5LPurple(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5LPurple();}
    }
    public static class C5LOrange extends FVEBB{
    	public C5LOrange(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5LOrange();}
    }
    public static class C5LCyan extends FVEBB{
    	public C5LCyan(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5LCyan();}
    }
    public static class C5LYellow extends FVEBB{
    	public C5LYellow(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5LYellow();}
    }
    public static class C5LBrown extends FVEBB{
    	public C5LBrown(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5LBrown();}
    }
    public static class C5LGray extends FVEBB{
    	public C5LGray(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C5TE.C5LGray();}
    }
    // C6
    public static class C6L extends FVEBB{
    	public C6L(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6L();}
    }
    public static class C6LBlue extends FVEBB{
    	public C6LBlue(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6LBlue();}
    }
    public static class C6LRed extends FVEBB{
    	public C6LRed(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6LRed();}
    }
    public static class C6LBlack extends FVEBB{
    	public C6LBlack(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6LBlack();}
    }
    public static class C6LWhite extends FVEBB{
    	public C6LWhite(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6LWhite();}
    }
    public static class C6LGray extends FVEBB{
    	public C6LGray(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6LGray();}
    }
    public static class C6LSilver extends FVEBB{
    	public C6LSilver(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6LSilver();}
    }
    public static class C6LYellow extends FVEBB{
    	public C6LYellow(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6LYellow();}
    }
    public static class C6LBeige extends FVEBB{
    	public C6LBeige(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6LBeige();}
    }
    public static class C6LPink extends FVEBB{
    	public C6LPink(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6LPink();}
    }
    public static class C6LBrown extends FVEBB{
    	public C6LBrown(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6LBrown();}
    }
    public static class C6LOrange extends FVEBB{
    	public C6LOrange(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6LOrange();}
    }
    public static class C6LPurple extends FVEBB{
    	public C6LPurple(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6LPurple();}
    }
    public static class C6LC extends FVEBB{
    	public C6LC(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new C6TE.C6LC();}
    }
    // T1
    public static class T1L extends FVEBB{
    	public T1L(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1L();}
    }
    public static class T1LBlue extends FVEBB{
    	public T1LBlue(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1LBlue();}
    }
    public static class T1LRed extends FVEBB{
    	public T1LRed(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1LRed();}
    }
    public static class T1LBlack extends FVEBB{
    	public T1LBlack(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1LBlack();}
    }
    public static class T1LWhite extends FVEBB{
    	public T1LWhite(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1LWhite();}
    }
    public static class T1LGray extends FVEBB{
    	public T1LGray(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1LGray();}
    }
    public static class T1LSilver extends FVEBB{
    	public T1LSilver(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1LSilver();}
    }
    public static class T1LYellow extends FVEBB{
    	public T1LYellow(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1LYellow();}
    }
    public static class T1LBeige extends FVEBB{
    	public T1LBeige(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1LBeige();}
    }
    public static class T1LPink extends FVEBB{
    	public T1LPink(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1LPink();}
    }
    public static class T1LBrown extends FVEBB{
    	public T1LBrown(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1LBrown();}
    }
    public static class T1LOrange extends FVEBB{
    	public T1LOrange(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1LOrange();}
    }
    public static class T1LPurple extends FVEBB{
    	public T1LPurple(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1LPurple();}
    }
    public static class T1LCyan extends FVEBB{
    	public T1LCyan(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1LCyan();}
    }
    public static class T1LC extends FVEBB{
    	public T1LC(String name){super(name);}
    	@Override
    	public TileEntity createNewTileEntity(World worldIn, int meta) {return new T1TE.T1LC();}
    }
}
