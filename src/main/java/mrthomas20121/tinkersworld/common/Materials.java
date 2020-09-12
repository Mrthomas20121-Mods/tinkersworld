package mrthomas20121.tinkersworld.common;

import mrthomas20121.tinkersworld.api.MaterialFluid;
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
    public static MaterialTW bismuth;
    public static MaterialTW bivorium;
    public static MaterialTW frostium;
    public static MaterialTW froststeel;
    public static MaterialTW sulfur;

    // fluids
    public static MaterialFluid coal;

    public static ArrayList<MaterialTW> mats = new ArrayList<>();
    public static ArrayList<MaterialFluid> materialFluids = new ArrayList<>();

    public static void preInit()
    {
        zirconium = registerMaterial("zirconium", 0x877972, 3 ,500);
        zircaloy = registerMaterial("zircaloy", 0x825F57, 4, 750,false, true);
        tin = registerMaterial("tin", 0xE0F1FF, 1, 200);
        copper = registerMaterial("copper", 0xFF7700, 1, 450, false);
        allactite = registerMaterial("allactite", 0x873A2A, 3, 900,true);
        sapphire = registerMaterial("sapphire", 0x078DBA, 2, 750,true);
        shivorium = registerMaterial("shivorium", 0xD8086C, 5, 650,false, true);
        bismuth = registerMaterial("bismuth", 0x70A694, 5, 650,false, false);
        bivorium = registerMaterial("bivorium", 0x8A5678, 6, 900,false, true);
        frostium = registerMaterial("frostium", 0xDBB6D2, 6, 750,false, true);
        froststeel = registerMaterial("froststeel", 0x417CA3, 6, 750,false, true);
        sulfur = registerMaterial("sulfur", 0xC4BB38, 6, 900,true, false);
        coal = registerMaterialFluid("coal", 0x5B5B5B, 500);

        for(MaterialTW mat : mats)
        {
            mat.registerFluid();
        }
        for(MaterialFluid materialFluid : materialFluids)
        {
            materialFluid.registerFluid();
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

    private static MaterialFluid registerMaterialFluid(String name, int color, int temp)
    {
        MaterialFluid materialFluid = new MaterialFluid(name, color, temp);
        materialFluids.add(materialFluid);
        return materialFluid;
    }
}
