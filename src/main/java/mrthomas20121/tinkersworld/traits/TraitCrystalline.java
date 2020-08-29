package mrthomas20121.tinkersworld.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitCrystalline extends AbstractTrait {
    public TraitCrystalline()
    {
        super("tw_crystalline", 0x0);
    }

    @Override
    public void beforeBlockBreak(ItemStack tool, BlockEvent.BreakEvent event) {
        IBlockState state = event.getState();
        EntityPlayer player = event.getPlayer();
        if(tool.canHarvestBlock(state))
        {
            if(event.getExpToDrop() == 0 && player.experienceLevel <= 30)
            {
                boolean bool = state.getBlock().getLocalizedName().contains("dirt") || state.getBlock().getLocalizedName().contains("ore");
                event.setExpToDrop(bool ? 3: 5);
            }
        }
    }
}
