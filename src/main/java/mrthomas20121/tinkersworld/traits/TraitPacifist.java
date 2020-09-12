package mrthomas20121.tinkersworld.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitPacifist extends AbstractTrait {
    public TraitPacifist()
    {
        super("tw_pacifist", 0x0);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        if(target instanceof EntityAnimal)
        {
            target.setEntityInvulnerable(true);
            return 0;
        }
        return newDamage;
    }

    @Override
    public void onHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean isCritical) {
        if(target instanceof EntityAnimal)
        {
            target.setEntityInvulnerable(true);
        }
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
        if(target instanceof EntityAnimal)
        {
            target.setEntityInvulnerable(false);
        }
    }
}
