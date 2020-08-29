package mrthomas20121.tinkersworld.api;

import slimeknights.tconstruct.library.materials.Material;

public enum MaterialType {

    ORE(true, Material.VALUE_Ore()),
    BLOCK(true, Material.VALUE_Block),
    GEAR(false, Material.VALUE_BrickBlock),
    INGOT(false, Material.VALUE_Ingot),
    DUST(false, Material.VALUE_Ingot),
    PLATE(false, Material.VALUE_Ingot),
    NUGGET(false, Material.VALUE_Nugget),
    GEM(false, Material.VALUE_Ingot);

    private int value;
    private boolean block;

    private MaterialType(boolean isBlock, int value)
    {
        this.value = value;
        this.block = isBlock;
    }

    public int getValue() {
        return value;
    }

    public boolean isBlock() {
        return block;
    }
}
