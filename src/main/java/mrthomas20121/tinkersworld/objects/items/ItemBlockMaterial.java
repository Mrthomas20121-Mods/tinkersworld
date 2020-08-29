package mrthomas20121.tinkersworld.objects.items;

import jdk.nashorn.internal.ir.Block;
import mrthomas20121.tinkersworld.objects.blocks.BlockMaterial;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ItemBlockMaterial extends ItemBlock {

    public ItemBlockMaterial(BlockMaterial block)
    {
        super(block);
        this.setRegistryName(block.getRegistryName());
        this.setTranslationKey(block.getTranslationKey());
    }

    @Override
    @Nonnull
    public String getItemStackDisplayName(@Nonnull ItemStack stack)
    {
        BlockMaterial block = (BlockMaterial)this.block;
        return (new TextComponentTranslation("tinkersworld." + block.getType().name().toLowerCase()+ "."+ block.getMaterial().getName().toLowerCase())).getFormattedText();
    }
}
