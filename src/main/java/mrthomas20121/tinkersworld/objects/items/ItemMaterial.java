package mrthomas20121.tinkersworld.objects.items;

import mrthomas20121.biolib.common.OredictHelper;
import mrthomas20121.tinkersworld.TinkersWorld;
import mrthomas20121.tinkersworld.api.MaterialTW;
import mrthomas20121.tinkersworld.api.MaterialType;
import mrthomas20121.tinkersworld.common.OredictUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nonnull;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ItemMaterial extends Item {

    private static Map<MaterialTW, EnumMap<MaterialType, ItemMaterial>> table = new HashMap<>();

    public static Item get(MaterialTW material, MaterialType type)
    {
        return table.get(material).get(type);
    }
    public static ItemStack get(MaterialTW material, MaterialType type, int nb)
    {
        return new ItemStack(get(material, type), nb);
    }

    private final MaterialTW material;
    private final MaterialType type;

    public ItemMaterial(MaterialTW material, MaterialType type)
    {
        this.material = material;
        this.type = type;
        this.setRegistryName(new ResourceLocation(TinkersWorld.MODID, material.getName()+"_"+type.name()));
        this.setTranslationKey(TinkersWorld.MODID+"."+material.getName()+"_"+type.name());
        this.setCreativeTab(CreativeTabs.MISC);
        if(!table.containsKey(material)) table.put(material, new EnumMap<>(MaterialType.class));
        table.get(material).put(type, this);

        OredictUtils.addOredict(type.name().toLowerCase()+StringUtils.capitalize(material.getName()), this);
    }

    @Override
    @Nonnull
    public String getItemStackDisplayName(@Nonnull ItemStack stack)
    {
        return (new TextComponentTranslation("tinkersworld." + type.name().toLowerCase()+ "."+ material.getName().toLowerCase())).getFormattedText();
    }

    public MaterialTW getMaterial() {
        return material;
    }

    public MaterialType getType() {
        return type;
    }
}
