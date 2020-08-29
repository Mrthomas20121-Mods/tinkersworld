package mrthomas20121.tinkersworld.proxy;

import mrthomas20121.tinkersworld.common.Registry;
import mrthomas20121.tinkersworld.common.TinkersMaterials;
import mrthomas20121.tinkersworld.TinkersWorld;

import mrthomas20121.tinkersworld.objects.blocks.BlockMaterial;
import mrthomas20121.tinkersworld.objects.items.ItemMaterial;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.modifiers.IModifier;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.tools.ToolCore;

import java.awt.*;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void postInit(FMLPostInitializationEvent event) {
        for (Material mat : TinkersMaterials.mats) {
            mat.setRenderInfo(mat.materialTextColor);
        }
    }
    @Override
    public <T extends Item & IToolPart> void registerToolPartModel(T part) {
        ModelRegisterUtil.registerPartModel(part);
    }
    @Override
    public void registerModifierModel(IModifier mod, ResourceLocation rl) {
        ModelRegisterUtil.registerModifierModel(mod, rl);
    }

    @Override
    public void registerBookData() {
    }

    @Override
    public void registerToolModel(ToolCore tc) {
        ModelRegisterUtil.registerToolModel(tc);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        TinkersWorld.getLogger().info("Loading Model");
        for(ItemMaterial item : Registry.items) {
            ModelLoader.setCustomModelResourceLocation(item, 0 , new ModelResourceLocation(new ResourceLocation(TinkersWorld.MODID,"material/"+item.getType().name()), "inventory"));
        }
        for(BlockMaterial block: Registry.blocks)
        {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0 , new ModelResourceLocation(block.getRegistryName(), "inventory"));
        }
        for(ItemBlock itemBlock : Registry.blockFluids)
        {
            ModelLoader.setCustomModelResourceLocation(itemBlock, 0, new ModelResourceLocation(itemBlock.getRegistryName(), "normal"));
            ModelLoader.setCustomStateMapper(itemBlock.getBlock(), new StateMapperBase() {
                @Override
                public ModelResourceLocation getModelResourceLocation(IBlockState state) {
                    return new ModelResourceLocation(itemBlock.getRegistryName(), "normal");
                }});
        }
    }

    @SubscribeEvent
    public static void registerItemColourHandlers(final ColorHandlerEvent.Item event)
    {
        final ItemColors itemColors = event.getItemColors();

        for (Item item : Registry.items)
        {
            itemColors.registerItemColorHandler(
                    (stack, tintIndex) -> {
                        return (new Color(((ItemMaterial) stack.getItem()).getMaterial().getColor())).brighter().getRGB();
                    },item
            );
        }
    }
}
