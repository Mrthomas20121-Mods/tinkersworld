package mrthomas20121.tinkersworld.objects;

import net.minecraft.block.material.Material;

import javax.annotation.Nullable;

public enum MaterialType {

    ORE(true, Material.ROCK),
    BLOCK(true, Material.IRON),
    GEAR(false),
    INGOT(false),
    DUST(false),
    PLATE(false),
    NUGGET(false),
    GEM(false);

    private final boolean block;
    private final Material material;


    MaterialType(boolean isBlock, @Nullable Material material)
    {
        this.block = isBlock;
        this.material = material;
    }

    MaterialType(boolean isBlock)
    {
        this(isBlock, Material.AIR);
    }

    public final boolean isBlock() {
        return this.block;
    }

    public final Material getMaterial() {
        return this.material;
    }
}
