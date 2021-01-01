package mrthomas20121.tinkersworld.proxy;

import mrthomas20121.tinkersworld.TinkersWorld;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import slimeknights.tconstruct.library.modifiers.IModifier;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.tools.ToolCore;

@Mod.EventBusSubscriber(modid = TinkersWorld.MODID)
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
    }

    public void init(FMLInitializationEvent e) {}

    public void postInit(FMLPostInitializationEvent e) { }

    public <T extends Item & IToolPart> void registerToolPartModel(T part) { }

    public void registerToolModel(ToolCore tc) { }
    public void registerModifierModel(IModifier mod, ResourceLocation rl) { }
    public void registerBookData() { }

    public void registerToolCrafting()
    {

    }
}