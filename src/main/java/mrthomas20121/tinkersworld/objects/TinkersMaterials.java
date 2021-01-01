package mrthomas20121.tinkersworld.objects;

import mrthomas20121.tinkersworld.objects.blocks.BlockMaterial;
import mrthomas20121.tinkersworld.objects.items.ItemMaterial;
import mrthomas20121.tinkersworld.traits.Traits;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.tools.TinkerTraits;

import java.util.ArrayList;

public class TinkersMaterials {

    public static TinkersMaterials instance = new TinkersMaterials();

    public static ArrayList<Material> mats = new ArrayList<>();

    public static final Material zirconium = new Material("zirconium", 0x877972);
    public static final Material zircaloy = new Material("zircaloy", 0x825F57);
    public static final Material allactite = new Material("allactite", 0x873A2A);
    public static final Material sapphire = new Material("sapphire", 0x078DBA);
    public static final Material shivorium = new Material("shivorium", 0xD8086C);
    public static final Material bivorium = new Material("bivorium", 0x8A5678);
    public static final Material frostium = new Material("frostium", 0xDBB6D2);
    public static final Material froststeel = new Material("froststeel", 0x417CA3);

    public void preInit(FMLPreInitializationEvent event) {
        zirconium.addTrait(Traits.traitLux, MaterialTypes.HEAD);
        zirconium.addTrait(TinkerTraits.dense);
        TinkerRegistry.addMaterial(zirconium);
        TinkerRegistry.addMaterialStats(zirconium,
                new HeadMaterialStats(500, 6, 6, 3),
                new HandleMaterialStats(1, 110),
                new ExtraMaterialStats(-10));

        zircaloy.addTrait(Traits.traitLux, MaterialTypes.HEAD);
        zircaloy.addTrait(TinkerTraits.dense, MaterialTypes.HANDLE);
        zircaloy.addTrait(TinkerTraits.dense, MaterialTypes.EXTRA);
        TinkerRegistry.addMaterial(zircaloy);
        TinkerRegistry.addMaterialStats(zircaloy,
                new HeadMaterialStats(700, 8, 7, 4),
                new HandleMaterialStats(1, 110),
                new ExtraMaterialStats(20));

        allactite.addTrait(Traits.traitProtect, MaterialTypes.HANDLE);
        allactite.addTrait(TinkerTraits.sharp);
        TinkerRegistry.addMaterial(allactite);
        TinkerRegistry.addMaterialStats(allactite,
                new HeadMaterialStats(2000, 3, 4, 3),
                new HandleMaterialStats(1, 200),
                new ExtraMaterialStats(30));

        sapphire.addTrait(Traits.traitCrystalline, MaterialTypes.HEAD);
        sapphire.addTrait(Traits.traitBackburner, MaterialTypes.HANDLE);
        sapphire.addTrait(Traits.traitPacifist, MaterialTypes.EXTRA);
        TinkerRegistry.addMaterial(sapphire);
        TinkerRegistry.addMaterialStats(sapphire,
                new HeadMaterialStats(150, 5, 2, 2),
                new HandleMaterialStats(3, -50),
                new ExtraMaterialStats(30));

        shivorium.addTrait(Traits.traitBalance);
        shivorium.addTrait(Traits.traitRust, MaterialTypes.HANDLE);
        TinkerRegistry.addMaterial(shivorium);
        TinkerRegistry.addMaterialStats(shivorium,
                new HeadMaterialStats(1500, 8, 11, 5),
                new HandleMaterialStats(1.2f, 400),
                new ExtraMaterialStats(100));

        bivorium.addTrait(Traits.traitIvory);
        bivorium.addTrait(Traits.traitRust, MaterialTypes.HANDLE);
        TinkerRegistry.addMaterial(bivorium);
        TinkerRegistry.addMaterialStats(bivorium,
                new HeadMaterialStats(1500, 10, 9, 6),
                new HandleMaterialStats(1.2f, 400),
                new ExtraMaterialStats(10));

        frostium.addTrait(Traits.traitFrostFang);
        frostium.addTrait(TinkerTraits.coldblooded, MaterialTypes.HANDLE);
        TinkerRegistry.addMaterial(frostium);
        TinkerRegistry.addMaterialStats(frostium,
                new HeadMaterialStats(1500, 10, 9, 6),
                new HandleMaterialStats(1.2f, 400),
                new ExtraMaterialStats(120));

        froststeel.addTrait(Traits.traitFrostFang, MaterialTypes.HEAD);
        froststeel.addTrait(TinkerTraits.stiff);
        TinkerRegistry.addMaterial(froststeel);
        TinkerRegistry.addMaterialStats(froststeel,
                new HeadMaterialStats(1500, 11, 10, 6),
                new HandleMaterialStats(1.2f, 500),
                new ExtraMaterialStats(110));

        HarvestLevels.harvestLevelNames.put(5, shivorium.getTextColor() + Util.translate("ui.mininglevel.shivorium"));
        HarvestLevels.harvestLevelNames.put(6, bivorium.getTextColor() + Util.translate("ui.mininglevel.bivorium"));
    }

    public void init(FMLInitializationEvent event) {

        zirconium.setCraftable(false).setCastable(true);
        zirconium.addCommonItems("Zirconium");
        zirconium.setRepresentativeItem("ingotZirconium");
        zirconium.setFluid(FluidRegistry.getFluid("zirconium"));
        new MaterialIntegration(zirconium, FluidRegistry.getFluid("zirconium"), "Zirconium").toolforge().integrate();

        zircaloy.setCraftable(false).setCastable(true);
        zircaloy.addCommonItems("Zircaloy");
        zircaloy.setRepresentativeItem("ingotZircaloy");
        zircaloy.setFluid(FluidRegistry.getFluid("zircaloy"));
        new MaterialIntegration(zircaloy, FluidRegistry.getFluid("zircaloy"), "Zircaloy").toolforge().integrate();

        allactite.setCraftable(false).setCastable(true);
        allactite.setRepresentativeItem("gemAllactite");
        allactite.addCommonItems("Allactite");
        allactite.setFluid(FluidRegistry.getFluid("allactite"));
        TinkerSmeltery.registerOredictMeltingCasting(FluidRegistry.getFluid("allactite"), "Allactite");
        TinkerSmeltery.registerToolpartMeltingCasting(allactite);

        sapphire.setCraftable(false).setCastable(true);
        sapphire.setRepresentativeItem("gemSapphire");
        sapphire.addCommonItems("Sapphire");
        sapphire.setFluid(FluidRegistry.getFluid("sapphire"));
        TinkerSmeltery.registerOredictMeltingCasting(FluidRegistry.getFluid("sapphire"), "Sapphire");
        TinkerSmeltery.registerToolpartMeltingCasting(sapphire);

        shivorium.setCraftable(false).setCastable(true);
        shivorium.addCommonItems("Shivorium");
        shivorium.setRepresentativeItem("ingotShivorium");
        shivorium.setFluid(FluidRegistry.getFluid("shivorium"));
        new MaterialIntegration(shivorium, FluidRegistry.getFluid("shivorium"), "Shivorium").toolforge().integrate();

        bivorium.setCraftable(false).setCastable(true);
        bivorium.addCommonItems("Bivorium");
        bivorium.setRepresentativeItem("ingotBivorium");
        bivorium.setFluid(FluidRegistry.getFluid("bivorium"));
        new MaterialIntegration(bivorium, FluidRegistry.getFluid("bivorium"), "Bivorium").toolforge().integrate();

        frostium.setCraftable(false).setCastable(true);
        frostium.setRepresentativeItem("ingotFrostium");
        frostium.addCommonItems("Frostium");
        frostium.setFluid(FluidRegistry.getFluid("frostium"));
        new MaterialIntegration(froststeel, FluidRegistry.getFluid("frostium"), "Frostium").toolforge().integrate();

        froststeel.setCraftable(false).setCastable(true);
        froststeel.setRepresentativeItem("ingotFroststeel");
        froststeel.addCommonItems("Froststeel");
        froststeel.setFluid(FluidRegistry.getFluid("froststeel"));
        new MaterialIntegration(zircaloy, FluidRegistry.getFluid("froststeel"), "Froststeel").toolforge().integrate();

        TinkerSmeltery.registerOredictMeltingCasting(FluidRegistry.getFluid("sulfur"), "Sulfur");
        TinkerSmeltery.registerOredictMeltingCasting(FluidRegistry.getFluid("coal"), "Coal");
        TinkerSmeltery.registerOredictMeltingCasting(FluidRegistry.getFluid("bismuth"), "Bismuth");

        for(TinkersWorldMaterials material: TinkersWorldMaterials.values()) {
            for(MaterialType type : MaterialType.values()) {
                if(type.isBlock()) {
                    if(material.equals(TinkersWorldMaterials.COAL)) continue;
                    Block block = BlockMaterial.get(material, type);
                    if(block != null)OreDictionary.registerOre(type.name().toLowerCase()+StringUtils.capitalize(material.name().toLowerCase()), block);
                }
                else {
                    Item item = ItemMaterial.get(material, type);
                    if(item != null) OreDictionary.registerOre(type.name().toLowerCase()+StringUtils.capitalize(material.name().toLowerCase()), item);
                }
            }
        }

        // shivorium
        TinkerRegistry.registerAlloy(
                FluidRegistry.getFluidStack("shivorium", Material.VALUE_Ingot*8),
                FluidRegistry.getFluidStack("allactite", Material.VALUE_Block),
                FluidRegistry.getFluidStack("sapphire", Material.VALUE_Ingot*3),
                FluidRegistry.getFluidStack("cobalt", Material.VALUE_Ingot*2),
                FluidRegistry.getFluidStack("zircaloy", Material.VALUE_Ingot*2));
        // zircaloy
        TinkerRegistry.registerAlloy(
                FluidRegistry.getFluidStack("zircaloy", Material.VALUE_Ingot*4),
                FluidRegistry.getFluidStack("zirconium", Material.VALUE_Ingot*7),
                FluidRegistry.getFluidStack("tin", Material.VALUE_Ingot));
        // bivorium
        TinkerRegistry.registerAlloy(
                FluidRegistry.getFluidStack("bivorium", Material.VALUE_Ingot),
                FluidRegistry.getFluidStack("bismuth", Material.VALUE_Ingot*7),
                FluidRegistry.getFluidStack("shivorium", Material.VALUE_Ingot));
        // frostium
        TinkerRegistry.registerAlloy(
                FluidRegistry.getFluidStack("frostium", Material.VALUE_Ingot*2),
                FluidRegistry.getFluidStack("sulfur", Material.VALUE_Ingot*7),
                FluidRegistry.getFluidStack("bivorium", Material.VALUE_Ingot*2));
        // froststeel
        TinkerRegistry.registerAlloy(
                FluidRegistry.getFluidStack("froststeel", Material.VALUE_Ingot*3),
                FluidRegistry.getFluidStack("frostium", Material.VALUE_Ingot*5),
                FluidRegistry.getFluidStack("iron", Material.VALUE_Ingot*3),
                FluidRegistry.getFluidStack("coal", Material.VALUE_Ingot*3));
    }
}
