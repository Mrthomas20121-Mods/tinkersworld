package mrthomas20121.tinkersworld;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class WorldLoader {

    private static final String worldgen = "assets/tinkersworld/world/tinkersworld.json";

    public static void loadWorld(File config)
    {
        File cofhDir = new File(config, "cofh");
        File world = new File(cofhDir, "world");
        File worldgenFile = new File(world, "tinkersworld.json");
        if(!worldgenFile.exists())
        {
            try {
                FileUtils.copyInputStreamToFile(WorldLoader.class.getClassLoader().getResourceAsStream(worldgen), worldgenFile);
            }
            catch (IOException e)
            {
                throw new Error("Problem Creating worldgen file in cofh/world", e);
            }
        }
        else TinkersWorld.getLogger().info("WorldLoader - tinkersworld.json already exist in cofh/world! Skipping");
    }
}
