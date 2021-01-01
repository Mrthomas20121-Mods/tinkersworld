package mrthomas20121.tinkersworld.objects.blocks;

import mrthomas20121.tinkersworld.TinkersWorld;
import mrthomas20121.tinkersworld.objects.MaterialType;
import mrthomas20121.tinkersworld.objects.TinkersWorldMaterials;
import mrthomas20121.tinkersworld.objects.items.ItemMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.*;

public class BlockMaterial extends Block {

    private TinkersWorldMaterials material;
    private MaterialType type;

    private static Map<TinkersWorldMaterials, EnumMap<MaterialType, BlockMaterial>> table = new HashMap<>();

    public static Block get(TinkersWorldMaterials material, MaterialType type)
    {
        return table.get(material).get(type);
    }

    public static ItemStack get(TinkersWorldMaterials material, MaterialType type, int amount)
    {
        return new ItemStack(table.get(material).get(type), amount);
    }

    public BlockMaterial(TinkersWorldMaterials material, MaterialType type)
    {
        super(type.getMaterial());
        this.setHardness(material.getHardness());
        if(!type.isBlock()) throw new Error("ERROR not a valid material");
        this.material = material;
        this.type = type;
        this.setRegistryName(new ResourceLocation(TinkersWorld.MODID, material.name().toLowerCase()+"_"+type.name().toLowerCase()));
        this.setTranslationKey(TinkersWorld.MODID+"."+material.name().toLowerCase()+"_"+type.name().toLowerCase());

        if(!table.containsKey(material)) table.put(material, new EnumMap<>(MaterialType.class));
        table.get(material).put(type, this);

        this.setHarvestLevel("pickaxe", material.getHarvestlevel());
    }

    public TinkersWorldMaterials getMaterial() {
        return material;
    }

    public MaterialType getType() {
        return type;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if(type.equals(MaterialType.ORE) && material.isGem())
        {
            if(material.equals(TinkersWorldMaterials.SULFUR))
                return ItemMaterial.get(material, MaterialType.DUST);
            return ItemMaterial.get(material, MaterialType.GEM);
        }
        return super.getItemDropped(state, rand, fortune);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if(type.equals(MaterialType.ORE)) tooltip.add(new TextComponentTranslation("tinkersworld.tooltip."+type.name().toLowerCase()+"."+material.name().toLowerCase()).getFormattedText());
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
