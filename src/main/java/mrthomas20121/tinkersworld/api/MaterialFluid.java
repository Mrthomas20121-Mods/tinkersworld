package mrthomas20121.tinkersworld.api;

import mrthomas20121.biolib.util.FluidUtils;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class MaterialFluid {

    private Fluid fluid;
    private String name;
    private int color;
    private int temp;

    public MaterialFluid(String name, int color, int temp)
    {
        this.name = name;
        this.color = color;
        this.temp = temp;
        this.fluid = FluidUtils.createMetalFluid(name, color);
        this.fluid.setTemperature(temp);
    }

    public boolean registerFluid()
    {
        boolean registered = FluidRegistry.registerFluid(this.fluid);
        if(registered)
        {
            FluidRegistry.addBucketForFluid(this.fluid);
        }
        return registered;
    }

    public Fluid getFluid() {
        return fluid;
    }
}
