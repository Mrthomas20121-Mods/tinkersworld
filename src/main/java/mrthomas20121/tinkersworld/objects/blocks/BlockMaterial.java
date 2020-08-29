package mrthomas20121.tinkersworld.objects.blocks;

import mrthomas20121.tinkersworld.TinkersWorld;
import mrthomas20121.tinkersworld.api.MaterialTW;
import mrthomas20121.tinkersworld.api.MaterialType;
import mrthomas20121.tinkersworld.common.OredictUtils;
import mrthomas20121.tinkersworld.objects.items.ItemBlockMaterial;
import mrthomas20121.tinkersworld.objects.items.ItemMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

public class BlockMaterial extends Block {

    private MaterialTW material;
    private MaterialType type;

    private static Map<MaterialTW, EnumMap<MaterialType, BlockMaterial>> table = new HashMap<>();

    public static Block get(MaterialTW material, MaterialType type)
    {
        return table.get(material).get(type);
    }

    public static ItemStack get(MaterialTW material, MaterialType type, int amount)
    {
        return new ItemStack(table.get(material).get(type), amount);
    }

    public BlockMaterial(MaterialTW material, MaterialType type)
    {
        super(Material.IRON);
        this.setHardness(material.getHardness());
        if(!type.isBlock()) throw new Error("ERROR not a valid material");
        this.material = material;
        this.type = type;
        this.setRegistryName(new ResourceLocation(TinkersWorld.MODID, material.getName()+"_"+type.name().toLowerCase()));
        this.setTranslationKey(TinkersWorld.MODID+"."+material.getName()+"_"+type.name().toLowerCase());

        if(!table.containsKey(material)) table.put(material, new EnumMap<>(MaterialType.class));
        table.get(material).put(type, this);

        this.setHarvestLevel("pickaxe", material.getHarvestlevel());

        OredictUtils.addOredict(type.name().toLowerCase()+ StringUtils.capitalize(material.getName()), this);
    }

    public MaterialTW getMaterial() {
        return material;
    }

    public MaterialType getType() {
        return type;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if(type.equals(MaterialType.ORE) && material.hasGem())
        {
          return ItemMaterial.get(material, MaterialType.GEM);
        }
        return super.getItemDropped(state, rand, fortune);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if(type.equals(MaterialType.ORE)) tooltip.add(new TextComponentTranslation("tinkersworld.tooltip."+type.name().toLowerCase()+"."+material.getName().toLowerCase()).getFormattedText());
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
