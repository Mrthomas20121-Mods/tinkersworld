package mrthomas20121.tinkersworld.common;

import mrthomas20121.tinkersworld.objects.blocks.BlockMaterial;
import mrthomas20121.tinkersworld.objects.items.ItemMaterial;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;
import java.util.Map;

public class OredictUtils {
    private static Map<String, ItemMaterial> itemsOredicts = new HashMap<>();
    private static Map<String, BlockMaterial> blockOredicts = new HashMap<>();

    public static void addOredict(String ore, ItemMaterial itemMaterial)
    {
        itemsOredicts.put(ore, itemMaterial);
    }
    public static void addOredict(String ore, BlockMaterial blockMaterial)
    {
        blockOredicts.put(ore, blockMaterial);
    }
    public static void registerOredicts()
    {
        for(Map.Entry<String, ItemMaterial> entry :itemsOredicts.entrySet())
        {
            OreDictionary.registerOre(entry.getKey(), entry.getValue());
        }
        for(Map.Entry<String, BlockMaterial> entry: blockOredicts.entrySet())
        {
            OreDictionary.registerOre(entry.getKey(), entry.getValue());
        }
    }
}
