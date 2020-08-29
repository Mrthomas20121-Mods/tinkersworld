package mrthomas20121.tinkersworld.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitProtect extends AbstractTrait {
    public TraitProtect()
    {
        super("tw_protect", 0x0);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(entity instanceof EntityPlayer && !world.isRemote && isSelected)
        {
            EntityPlayer entityLivingBase = (EntityPlayer) entity;
            entityLivingBase.removePotionEffect(MobEffects.WITHER);
        }
    }

    @Override
    public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
        player.removePotionEffect(MobEffects.WITHER);
    }
}
