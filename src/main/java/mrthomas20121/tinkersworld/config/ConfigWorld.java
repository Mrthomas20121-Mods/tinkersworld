package mrthomas20121.tinkersworld.config;

import mrthomas20121.tinkersworld.TinkersWorld;
import mrthomas20121.tinkersworld.proxy.CommonProxy;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;

@Mod.EventBusSubscriber(modid = TinkersWorld.MODID)
public class ConfigWorld {

    @SubscribeEvent
    public static void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(TinkersWorld.MODID))
        {
            ConfigManager.sync(TinkersWorld.MODID, Config.Type.INSTANCE);
        }
    }

    @Config(modid = TinkersWorld.MODID, name = "Tinkers' World")
    public static class TinkersWorldConfig {

        public static boolean sapphire = true;

        public static boolean shivorium = true;
    }
}