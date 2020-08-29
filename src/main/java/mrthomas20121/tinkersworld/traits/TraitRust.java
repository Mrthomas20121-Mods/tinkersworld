package mrthomas20121.tinkersworld.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitRust extends AbstractTrait {
    public TraitRust()
    {
        super("tw_rust", 0x0);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        float distance = target.getDistance(player);
        if(distance > newDamage)
        {
            return newDamage;
        }
        return distance>3? newDamage-distance:newDamage+distance;
    }
}
