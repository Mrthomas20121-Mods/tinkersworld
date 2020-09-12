package mrthomas20121.tinkersworld.config;

import mrthomas20121.tinkersworld.TinkersWorld;
import mrthomas20121.tinkersworld.proxy.CommonProxy;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;

@Mod.EventBusSubscriber(modid = TinkersWorld.MODID)
public class Config {

    public static boolean file = true;

    @SubscribeEvent
    public static void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(TinkersWorld.MODID))
        {
            ConfigManager.sync(TinkersWorld.MODID, net.minecraftforge.common.config.Config.Type.INSTANCE);
        }
    }

    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            //file = cfg.getBoolean("worldgen_copy", Configuration.CATEGORY_GENERAL, file, "Set to false to stop tinkersworld from copying the file to cofhworld config on every launch.");

        } catch (Exception e1) {
            TinkersWorld.getLogger().log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }
}