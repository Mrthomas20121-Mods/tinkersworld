package mrthomas20121.tinkersworld.objects.fluids;

import mrthomas20121.tinkersworld.objects.TinkersWorldMaterials;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import slimeknights.tconstruct.library.fluid.FluidMolten;

public class FluidsTinkersWorld {

    public static void init() {
        for(TinkersWorldMaterials material : TinkersWorldMaterials.values()) {
            registerFluid(material.name().toLowerCase(), material.getColor(), material.getTemp());
        }
    }

    public static void registerFluid(String name, int color, int temp) {
        Fluid fluid = new FluidMolten(name, color);
        fluid.setTemperature(temp);
        boolean registered = FluidRegistry.registerFluid(fluid);
        if(registered) {
            FluidRegistry.addBucketForFluid(fluid);
        }
    }
}
