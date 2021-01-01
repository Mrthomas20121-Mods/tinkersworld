package mrthomas20121.tinkersworld;

import mrthomas20121.tinkersworld.objects.TinkersWorldMaterials;
import mrthomas20121.tinkersworld.objects.blocks.BlockMaterial;
import mrthomas20121.tinkersworld.objects.items.ItemBlockMaterial;
import mrthomas20121.tinkersworld.TinkersWorld;
import mrthomas20121.tinkersworld.objects.MaterialType;
import mrthomas20121.tinkersworld.objects.items.ItemMaterial;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = TinkersWorld.MODID)
public class Registry {
    public static ArrayList<ItemMaterial> items = new ArrayList<>();
    public static ArrayList<BlockMaterial> blocks = new ArrayList<>();

    private static CreativeTabs creativeTab = new CreativeTabs("tinkersworld") {
        @Override
        public ItemStack createIcon() {
            return BlockMaterial.get(TinkersWorldMaterials.ZIRCONIUM, MaterialType.ORE, 1);
        }
    };

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> r = event.getRegistry();

        for(TinkersWorldMaterials mat : TinkersWorldMaterials.values())
        {
            if(mat.isGem()) registerItem(r, new ItemMaterial(mat, MaterialType.GEM));
            else if(!mat.equals(TinkersWorldMaterials.COAL) && !mat.equals(TinkersWorldMaterials.SULFUR)) registerItem(r, new ItemMaterial(mat, MaterialType.INGOT));

            registerItem(r, new ItemMaterial(mat, MaterialType.DUST));
            registerItem(r, new ItemMaterial(mat, MaterialType.PLATE));
            if(mat.isMaterial()) {
                registerItem(r, new ItemMaterial(mat, MaterialType.GEAR));
                registerItem(r, new ItemMaterial(mat, MaterialType.NUGGET));
            }
        }
        for(BlockMaterial block : blocks)
        {
            registerItemBlock(r, new ItemBlockMaterial(block));
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        IForgeRegistry<Block> r = event.getRegistry();

        for(TinkersWorldMaterials mat : TinkersWorldMaterials.values())
        {
            if(mat.equals(TinkersWorldMaterials.COAL)) continue;
            registerBlock(r, new BlockMaterial(mat, MaterialType.BLOCK));
            if(!mat.isAlloy()) registerBlock(r, new BlockMaterial(mat, MaterialType.ORE));
        }
    }

    private static void registerItem(IForgeRegistry<Item> r, ItemMaterial item)
    {
        item.setCreativeTab(creativeTab);
        r.register(item);
        items.add(item);
    }
    private static void registerItemBlock(IForgeRegistry<Item> r, ItemBlockMaterial item)
    {
        item.setCreativeTab(creativeTab);
        r.register(item);
    }
    private static void registerBlock(IForgeRegistry<Block> r, BlockMaterial block)
    {
        block.setCreativeTab(creativeTab);
        r.register(block);
        blocks.add(block);
    }
}
