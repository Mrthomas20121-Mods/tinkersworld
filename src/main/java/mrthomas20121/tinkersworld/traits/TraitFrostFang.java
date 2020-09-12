package mrthomas20121.tinkersworld.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitFrostFang extends AbstractTrait {

    public static int bonus = 5;

    public TraitFrostFang()
    {
        super("tw_frostfang", 0x0);
    }

    @Override
    public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
        World world = event.getEntityPlayer().getEntityWorld();
        Biome biome = world.getBiome(event.getEntityPlayer().getPosition());
        int bonusspeed = biome.isSnowyBiome() ? bonus: 0;
        event.setNewSpeed(event.getNewSpeed()+bonusspeed);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        World world = player.getEntityWorld();

        Biome biome = world.getBiome(player.getPosition());
        int bonusdamage = biome.isSnowyBiome() ? bonus: 0;
        return newDamage+bonusdamage;
    }
}
