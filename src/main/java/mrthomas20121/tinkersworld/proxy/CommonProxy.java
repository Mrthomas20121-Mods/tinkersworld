package mrthomas20121.tinkersworld.proxy;

import mrthomas20121.tinkersworld.TinkersWorld;
import mrthomas20121.tinkersworld.api.MaterialTW;
import mrthomas20121.tinkersworld.config.Config;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import slimeknights.tconstruct.library.modifiers.IModifier;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.tools.ToolCore;

import java.io.File;


@Mod.EventBusSubscriber(modid = TinkersWorld.MODID)
public class CommonProxy {

    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "tinkersworld.cfg"));

        Config.readConfig();
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