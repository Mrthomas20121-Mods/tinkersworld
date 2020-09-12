package mrthomas20121.tinkersworld.common;

import mrthomas20121.biolib.block.BlockFluid;
import mrthomas20121.tinkersworld.api.MaterialFluid;
import mrthomas20121.tinkersworld.objects.blocks.BlockMaterial;
import mrthomas20121.tinkersworld.objects.items.ItemBlockMaterial;
import mrthomas20121.tinkersworld.TinkersWorld;
import mrthomas20121.tinkersworld.api.MaterialTW;
import mrthomas20121.tinkersworld.api.MaterialType;
import mrthomas20121.tinkersworld.objects.items.ItemMaterial;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = TinkersWorld.MODID)
public class Registry {
    public static ArrayList<ItemMaterial> items = new ArrayList<>();
    public static ArrayList<BlockMaterial> blocks = new ArrayList<>();
    public static ArrayList<ItemBlock> blockFluids = new ArrayList<>();
    public static ArrayList<ItemBlockMaterial> itemBlockMaterials = new ArrayList<>();

    private static CreativeTabs creativeTab = new CreativeTabs("tinkersworld") {
        @Override
        public ItemStack createIcon() {
            return BlockMaterial.get(Materials.zirconium, MaterialType.ORE, 1);
        }
    };

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> r = event.getRegistry();

        for(MaterialTW mat : Materials.mats)
        {
            for(MaterialType type: MaterialType.values())
            {
                if( (mat.hasGem() && type.equals(MaterialType.INGOT)) || (!mat.hasGem() && type.equals(MaterialType.GEM))) continue;
                if (!type.isBlock())
                {
                    if(!mat.equals(Materials.sulfur))
                    {
                        registerItem(r, new ItemMaterial(mat, type));
                    }
                    else
                    {
                        if(type.equals(MaterialType.DUST) || type.equals(MaterialType.GEM))
                        {
                            registerItem(r, new ItemMaterial(mat, type));
                        }
                    }
                }
            }
        }
        for(ItemBlockMaterial itemBlock : itemBlockMaterials)
        {
            registerItemBlock(r, itemBlock);
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        IForgeRegistry<Block> r = event.getRegistry();

        for(MaterialTW mat : Materials.mats)
        {
            registerFluidBlock(r, mat.getFluid());
            for(MaterialType type: MaterialType.values())
            {
                if(type.isBlock())
                {
                    if(!(mat.isAlloy() && type.equals(MaterialType.ORE)))
                    {
                        registerBlock(r, new BlockMaterial(mat, type));
                    }
                }
            }
        }
        for(MaterialFluid materialFluid : Materials.materialFluids)
        {
            registerFluidBlock(r, materialFluid.getFluid());
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
        itemBlockMaterials.add(new ItemBlockMaterial(block));
    }
    private static void registerFluidBlock(IForgeRegistry<Block> r, Fluid f) {
        BlockFluidClassic fluidBlock = new BlockFluidClassic(f, Material.LAVA);
        fluidBlock.setRegistryName(TinkersWorld.MODID, "molten_"+f.getName());
        f.setUnlocalizedName(f.getName());
        ItemBlock itemBlock = new ItemBlock(fluidBlock);
        itemBlock.setRegistryName(fluidBlock.getRegistryName());
        blockFluids.add(itemBlock);
        r.register(fluidBlock);
    }
}
