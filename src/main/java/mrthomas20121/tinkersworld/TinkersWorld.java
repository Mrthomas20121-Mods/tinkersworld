package mrthomas20121.tinkersworld;

import mrthomas20121.tinkersworld.common.Materials;
import mrthomas20121.tinkersworld.common.OredictUtils;
import mrthomas20121.tinkersworld.common.TinkersMaterials;
import mrthomas20121.tinkersworld.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(modid = TinkersWorld.MODID, name = TinkersWorld.NAME, version = TinkersWorld.VERSION,
        dependencies = "required-after:forge@[14.23.5.2847,);"
        + "required-after:mantle@[1.12-1.3.3.55,);"
        + "required-after:tconstruct@[1.12.2-2.13.0.183,);"
        + "required-after:biolib@[1.0.7,);")
public class TinkersWorld
{
    @Mod.Instance
    public static TinkersWorld instance;
    public static final String MODID = "tinkersworld";
    public static final String NAME = "Tinkers' World";
    public static final String VERSION = "1.0.0";

    private static Logger logger;

    public static Logger getLogger() {
        return logger;
    }

    @SidedProxy(serverSide = "mrthomas20121.tinkersworld.proxy.CommonProxy", clientSide = "mrthomas20121.tinkersworld.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
        logger = event.getModLog();
        proxy.preInit(event);
        Materials.preInit();
        TinkersMaterials.instance.preInit(event);
        WorldLoader.loadWorld(event.getModConfigurationDirectory());
   }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.registerBookData();
        proxy.init(event);
        OredictUtils.registerOredicts();
        TinkersMaterials.instance.init(event);
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.registerToolCrafting();
        proxy.postInit(event);
    }

}
