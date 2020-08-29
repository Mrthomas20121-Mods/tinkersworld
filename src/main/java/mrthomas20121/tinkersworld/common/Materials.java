package mrthomas20121.tinkersworld.common;

import mrthomas20121.tinkersworld.api.MaterialTW;

import java.util.ArrayList;

public class Materials {

    public static MaterialTW zirconium;
    public static MaterialTW zircaloy;
    public static MaterialTW tin;
    public static MaterialTW copper;
    public static MaterialTW allactite;
    public static MaterialTW sapphire;
    public static MaterialTW shivorium;

    public static ArrayList<MaterialTW> mats = new ArrayList<>();

    public static void preInit()
    {
        zirconium = registerMaterial("zirconium", 0x877972, 3 ,500);
        zircaloy = registerMaterial("zircaloy", 0x825F57, 4, 750,false, true);
        tin = registerMaterial("tin", 0xE0F1FF, 1, 200);
        copper = registerMaterial("copper", 0xFF7700, 1, 450, false);
        allactite = registerMaterial("allactite", 0x873A2A, 3, 900,true);
        sapphire = registerMaterial("sapphire", 0x078DBA, 2, 750,true);
        shivorium = registerMaterial("shivorium", 0xD8086C, 5, 650,false, true);

        for(MaterialTW mat : mats)
        {
            mat.registerFluid();
        }
    }

    private static MaterialTW registerMaterial(String name, int color, int harvestlevel, int temp, boolean gem)
    {
        return registerMaterial(name, color, harvestlevel, temp, gem, false);
    }
    private static MaterialTW registerMaterial(String name, int color, int harvestlevel, int temp, boolean gem, boolean alloy)
    {
        MaterialTW mat = new MaterialTW(name, color, harvestlevel, temp, gem, alloy);
        mats.add(mat);
        return mat;
    }
    private static MaterialTW registerMaterial(String name, int color, int harvestlevel, int temp)
    {
        return registerMaterial(name, color, harvestlevel, temp, false, false);
    }
}
