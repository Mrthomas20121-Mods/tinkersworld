package mrthomas20121.tinkersworld.objects.items;

import mrthomas20121.tinkersworld.TinkersWorld;
import mrthomas20121.tinkersworld.objects.MaterialType;
import mrthomas20121.tinkersworld.objects.TinkersWorldMaterials;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nonnull;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ItemMaterial extends Item {

    private static Map<TinkersWorldMaterials, EnumMap<MaterialType, ItemMaterial>> table = new HashMap<>();

    public static Item get(TinkersWorldMaterials material, MaterialType type)
    {
        return table.get(material).get(type);
    }
    public static ItemStack get(TinkersWorldMaterials material, MaterialType type, int nb)
    {
        return new ItemStack(get(material, type), nb);
    }

    private final TinkersWorldMaterials material;
    private final MaterialType type;

    public ItemMaterial(TinkersWorldMaterials material, MaterialType type)
    {
        this.material = material;
        this.type = type;
        this.setRegistryName(new ResourceLocation(TinkersWorld.MODID, material.name().toLowerCase()+"_"+type.name().toLowerCase()));
        this.setTranslationKey(TinkersWorld.MODID+"."+material.name().toLowerCase()+"_"+type.name().toLowerCase());
        this.setCreativeTab(CreativeTabs.MISC);
        if(!table.containsKey(material)) table.put(material, new EnumMap<>(MaterialType.class));
        table.get(material).put(type, this);
    }

    @Override
    @Nonnull
    public String getItemStackDisplayName(@Nonnull ItemStack stack)
    {
        return (new TextComponentTranslation("tinkersworld." + type.name().toLowerCase()+ "."+ material.name().toLowerCase())).getFormattedText();
    }

    public TinkersWorldMaterials getMaterial() {
        return material;
    }

    public MaterialType getType() {
        return type;
    }
}
