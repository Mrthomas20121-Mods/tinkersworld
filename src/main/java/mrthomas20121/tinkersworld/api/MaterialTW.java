package mrthomas20121.tinkersworld.api;

import mrthomas20121.biolib.common.MaterialBuilder;
import mrthomas20121.biolib.util.FluidUtils;
import mrthomas20121.tinkersworld.common.TinkersMaterials;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import slimeknights.tconstruct.library.materials.Material;

import javax.annotation.Nonnull;

public class MaterialTW {

    private String name;
    private int color;
    private final boolean isAlloy;
    private final boolean gem;
    private Fluid fluid;
    private int harvestlevel;
    private int hardness;

    public MaterialTW(@Nonnull String name, @Nonnull int color, @Nonnull int harvestlevel, @Nonnull int temp, @Nonnull boolean hasGem, @Nonnull boolean alloy)
    {
        this.name = name;
        this.color = color;
        this.isAlloy = alloy;
        this.gem = hasGem;
        this.harvestlevel = harvestlevel;
        this.fluid = FluidUtils.createMetalFluid(name, color);
        this.hardness = harvestlevel+1;
        this.fluid.setTemperature(temp);
    }

    public MaterialTW(@Nonnull String name, @Nonnull int color, @Nonnull int harvestlevel, @Nonnull int temp, @Nonnull boolean gem)
    {
        this(name, color, harvestlevel, temp, gem,false);
    }
    public MaterialTW(@Nonnull String name, @Nonnull int color, @Nonnull int harvestlevel, @Nonnull int temp)
    {
        this(name, color, harvestlevel,temp, false, false);
    }

    @Nonnull
    public MaterialBuilder getTinkersMat()
    {
        MaterialBuilder materialBuilder = new MaterialBuilder(new Material(this.name, this.color));
        materialBuilder.setCraftable(false).setCastable(true);
        TinkersMaterials.mats.add(materialBuilder.getMat());
        return materialBuilder;
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

    public String getName() {
        return name;
    }

    public Fluid getFluid() {
        return fluid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setFluid(Fluid fluid) {
        this.fluid = fluid;
    }

    public int getColor() {
        return color;
    }

    public boolean isAlloy() {
        return isAlloy;
    }

    public boolean hasGem() {
        return gem;
    }

    public int getHarvestlevel() {
        return harvestlevel;
    }

    public int getHardness() {
        return hardness;
    }

    public void setHardness(int hardness) {
        this.hardness = hardness;
    }
}
