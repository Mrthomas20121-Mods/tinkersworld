package mrthomas20121.tinkersworld.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitBalance extends AbstractTrait {
    public TraitBalance()
    {
        super("tw_balance", 0x0);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        int dmg = tool.isItemDamaged()? tool.getItemDamage():0;
        return newDamage-(dmg*0.5f);
    }
}
