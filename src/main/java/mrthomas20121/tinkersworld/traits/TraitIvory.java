package mrthomas20121.tinkersworld.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitIvory extends AbstractTrait {
    public TraitIvory()
    {
        super("tw_ivory", 0x0);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(isSelected)
        {
            if(!world.isRemote)
            {
                if(entity instanceof EntityLivingBase)
                {
                    EntityLivingBase ent = (EntityLivingBase)entity;
                    ent.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 100, 1, true, true));
                    ent.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 100, 1, true, true));
                }
            }
        }
    }
}
