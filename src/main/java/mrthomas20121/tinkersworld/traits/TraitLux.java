package mrthomas20121.tinkersworld.traits;

import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitLux extends AbstractTrait {
    public TraitLux()
    {
        super("tw_lux", 0x0);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(!world.isRemote && isSelected)
        {
            long time = world.getWorldTime();
            if(time > 100 && time < 14000 && !world.isRaining())
            {
                if(world.canSeeSky(entity.getPosition()))
                {
                    int chance = world.rand.nextInt(50);
                    if(chance <= 25)
                    {
                        if(entity instanceof EntityLivingBase)
                        {
                            ToolHelper.healTool(tool, 10, (EntityLivingBase)entity);
                        }
                    }
                }
            }
        }
    }
}
