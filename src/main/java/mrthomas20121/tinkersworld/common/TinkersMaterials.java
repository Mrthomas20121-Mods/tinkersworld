package mrthomas20121.tinkersworld.common;

import mrthomas20121.biolib.common.MaterialBuilder;
import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.common.SmelteryUtils;
import mrthomas20121.biolib.util.FluidUtils;
import mrthomas20121.tinkersworld.traits.Traits;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

import java.util.ArrayList;

public class TinkersMaterials implements ModuleBase {

    public static TinkersMaterials instance = new TinkersMaterials();

    public static ArrayList<Material> mats = new ArrayList<>();

    public static MaterialBuilder zirconium;
    public static MaterialBuilder zircaloy;
    public static MaterialBuilder allactite;
    public static MaterialBuilder sapphire;
    public static MaterialBuilder shivorium;
    public static MaterialBuilder bivorium;
    public static MaterialBuilder frostium;
    public static MaterialBuilder froststeel;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        zirconium = Materials.zirconium.getTinkersMat();
        zirconium.setTrait(Traits.traitLux, MaterialTypes.HEAD);
        zirconium.setTrait(TinkerTraits.dense, MaterialTypes.HANDLE);
        zirconium.setTrait(TinkerTraits.dense, MaterialTypes.EXTRA);
        zirconium.setHeadStats(500, 6, 6, Materials.zirconium.getHarvestlevel());
        zirconium.setHandleStats(1f, 110);
        zirconium.setExtraStats(-10);
        addCommonModdedItems(zirconium, "Zirconium");
        zirconium.preInit("Zirconium", FluidUtils.getFluid("zirconium"));

        zircaloy = Materials.zircaloy.getTinkersMat();
        zircaloy.setTrait(Traits.traitLux, MaterialTypes.HEAD);
        zircaloy.setTrait(TinkerTraits.dense, MaterialTypes.HANDLE);
        zircaloy.setTrait(TinkerTraits.dense, MaterialTypes.EXTRA);
        zircaloy.setHeadStats(700, 8, 7, Materials.zircaloy.getHarvestlevel());
        zircaloy.setHandleStats(1f, 110);
        zircaloy.setExtraStats(20);
        addCommonModdedItems(zircaloy, "Zircaloy");
        zircaloy.preInit("Zircaloy", FluidUtils.getFluid("zircaloy"));

        allactite = Materials.allactite.getTinkersMat();
        allactite.setTrait(Traits.traitProtect, MaterialTypes.HANDLE);
        allactite.setTrait(TinkerTraits.sharp);
        allactite.setHeadStats(2000, 3, 4, Materials.allactite.getHarvestlevel());
        allactite.setHandleStats(1f, 200);
        allactite.setExtraStats(30);
        addCommonModdedItems(allactite, "Allactite", true);
        allactite.preInit("Allactite", FluidUtils.getFluid("allactite"));

        sapphire = Materials.sapphire.getTinkersMat();
        sapphire.setTrait(Traits.traitCrystalline, MaterialTypes.HEAD);
        sapphire.setTrait(Traits.traitBackburner, MaterialTypes.HANDLE);
        sapphire.setTrait(Traits.traitPacifist, MaterialTypes.EXTRA);
        sapphire.setHeadStats(150, 5, 2, Materials.sapphire.getHarvestlevel());
        sapphire.setHandleStats(3f, -100);
        sapphire.setExtraStats(5);
        addCommonModdedItems(sapphire, "Sapphire", true);
        sapphire.preInit("Sapphire", FluidUtils.getFluid("sapphire"));

        shivorium = Materials.shivorium.getTinkersMat();
        shivorium.setHeadStats(1500, 8, 11, 5);
        shivorium.setHandleStats(1.2f, 400);
        shivorium.setExtraStats(100);
        shivorium.setTrait(Traits.traitBalance);
        shivorium.setTrait(Traits.traitRust, MaterialTypes.HANDLE);
        addCommonModdedItems(shivorium, "Shivorium");
        shivorium.preInit("Shivorium", FluidUtils.getFluid("shivorium"));

        bivorium = Materials.bivorium.getTinkersMat();
        bivorium.setHeadStats(1500, 10, 9, 6);
        bivorium.setHandleStats(1.2f, 400);
        bivorium.setExtraStats(100);
        bivorium.setTrait(Traits.traitIvory);
        bivorium.setTrait(Traits.traitRust, MaterialTypes.HANDLE);
        addCommonModdedItems(bivorium, "Bivorium");
        bivorium.preInit("Bivorium", FluidUtils.getFluid("bivorium"));

        frostium = Materials.frostium.getTinkersMat();
        frostium.setHeadStats(1500, 10, 9, 6);
        frostium.setHandleStats(1.2f, 400);
        frostium.setExtraStats(100);
        frostium.setTrait(Traits.traitFrostFang);
        frostium.setTrait(TinkerTraits.coldblooded, MaterialTypes.HANDLE);
        addCommonModdedItems(frostium, "Frostium");
        frostium.preInit("Frostium", FluidUtils.getFluid("frostium"));

        froststeel = Materials.froststeel.getTinkersMat();
        froststeel.setHeadStats(1500, 11, 10, 6);
        froststeel.setHandleStats(1.2f, 400);
        froststeel.setExtraStats(100);
        froststeel.setTrait(Traits.traitFrostFang, MaterialTypes.HEAD);
        froststeel.setTrait(TinkerTraits.stiff);
        addCommonModdedItems(froststeel, "Froststeel");
        froststeel.preInit("Froststeel", FluidUtils.getFluid("froststeel"));

        HarvestLevels.harvestLevelNames.put(5, shivorium.getMat().getTextColor() + Util.translate("ui.mininglevel.shivoium"));
        HarvestLevels.harvestLevelNames.put(6, bivorium.getMat().getTextColor() + Util.translate("ui.mininglevel.bivorium"));
    }

    @Override
    public void init(FMLInitializationEvent event) {
        // shivorium
        SmelteryUtils.registerAlloy(
                FluidUtils.getFluidStack("shivorium", Material.VALUE_Ingot*8),
                FluidUtils.getFluidStack("allactite", Material.VALUE_Block),
                FluidUtils.getFluidStack("sapphire", Material.VALUE_Ingot*3),
                FluidUtils.getFluidStack("cobalt", Material.VALUE_Ingot*2),
                FluidUtils.getFluidStack("zircaloy", Material.VALUE_Ingot*2));
        // zircaloy
        SmelteryUtils.registerAlloy(
                FluidUtils.getFluidStack("zircaloy", Material.VALUE_Ingot*4),
                FluidUtils.getFluidStack("zirconium", Material.VALUE_Ingot*7),
                FluidUtils.getFluidStack("tin", Material.VALUE_Ingot));
        // bivorium
        SmelteryUtils.registerAlloy(
                FluidUtils.getFluidStack("bivorium", Material.VALUE_Ingot),
                FluidUtils.getFluidStack("bismuth", Material.VALUE_Ingot*7),
                FluidUtils.getFluidStack("shivorium", Material.VALUE_Ingot));
        // frostium
        SmelteryUtils.registerAlloy(
                FluidUtils.getFluidStack("frostium", Material.VALUE_Ingot*2),
                FluidUtils.getFluidStack("sulfur", Material.VALUE_Ingot*7),
                FluidUtils.getFluidStack("bivorium", Material.VALUE_Ingot*2));
        // froststeel
        SmelteryUtils.registerAlloy(
                FluidUtils.getFluidStack("froststeel", Material.VALUE_Ingot*3),
                FluidUtils.getFluidStack("frostium", Material.VALUE_Ingot*5),
                FluidUtils.getFluidStack("iron", Material.VALUE_Ingot*3),
                FluidUtils.getFluidStack("coal", Material.VALUE_Ingot*3)
        );
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    private static void addCommonModdedItems(MaterialBuilder materialBuilder, String oredict)
    {
        materialBuilder.addCommonItems(oredict);
        materialBuilder.addGear(oredict);
        materialBuilder.addPlate(oredict);
        materialBuilder.addItem("dust"+oredict, 1);
    }
    private static void addCommonModdedItems(MaterialBuilder materialBuilder, String oredict, boolean isGem)
    {
        materialBuilder.addCommonItems(oredict);
        if(isGem) materialBuilder.addGem(oredict);
        materialBuilder.addGear(oredict);
        materialBuilder.addPlate(oredict);
        materialBuilder.addItem("dust"+oredict, 1);
        materialBuilder.setRepresentativeItem("gem"+oredict);
    }
}
