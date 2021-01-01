package mrthomas20121.tinkersworld.objects;

public enum TinkersWorldMaterials {
    ALLACTITE(0x873A2A, 800, 3, 4, true, true),
    BISMUTH(0x70A694, 650, 5, 4, false, false, false),
    BIVORIUM(0x8A5678, 900, 6, 4, true, false, true),
    COPPER(0xFF7700, 450, 1, 4),
    COAL(0x5B5B5B, 500, 1, 4),
    FROSTIUM(0xDBB6D2, 750, 6, 4, true, false, true),
    FROSTSTEEL(0x417CA3, 750, 6, 4, true, false, true),
    SAPPHIRE(0x078DBA, 750, 2, 4, true, true, false),
    SHIVORIUM(0xD8086C, 900, 5, 4, true, false, true),
    SULFUR(0xC4BB38, 1, 6, 4, false, false, false),
    TIN(0xE0F1FF, 200, 1, 4),
    ZIRCONIUM(0x877972, 500, 3, 4, true, false, false),
    ZIRCALOY(0x825F57, 900, 4, 4, true, false, true);

    private int color;
    private int temp;
    private int harvestlevel;
    private int hardness;
    private boolean material;
    private boolean gem;
    private boolean alloy;

    TinkersWorldMaterials(int color, int temp, int harvestlevel, int hardness, boolean material, boolean gem, boolean alloy) {
        this.color = color;
        this.temp = temp;
        this.harvestlevel = harvestlevel;
        this.hardness = hardness;
        this.material = material;
        this.gem = gem;
        this.alloy = alloy;
    }

    TinkersWorldMaterials(int color, int temp, int harvestlevel, int hardness, boolean material, boolean gem) {
        this(color, temp, harvestlevel, hardness, material, gem, false);
    }

    TinkersWorldMaterials(int color, int temp, int harvestlevel, int hardness, boolean material) {
        this(color, temp, harvestlevel, hardness, material, false, false);
    }

    TinkersWorldMaterials(int color, int temp, int harvestlevel, int hardness) {
        this(color, temp, harvestlevel, hardness, false, false, false);
    }

    public int getColor() {
        return color;
    }

    public int getTemp() {
        return temp;
    }

    public int getHarvestlevel() {
        return harvestlevel;
    }

    public int getHardness() {
        return hardness;
    }

    public boolean isMaterial() {
        return material;
    }

    public boolean isGem() {
        return gem;
    }

    public boolean isAlloy() {
        return alloy;
    }
}
