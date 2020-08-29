package mrthomas20121.tinkersworld.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitBackburner extends AbstractTrait {
    public TraitBackburner()
    {
        super("tw_backburner", 0x0);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(entity instanceof EntityPlayer && !world.isRemote)
        {
            EntityPlayer player = (EntityPlayer)entity;

            if(player.inventory.hasItemStack(tool))
            {
                player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 50, 0));
                player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 50, 1));
            }
        }
    }
}
