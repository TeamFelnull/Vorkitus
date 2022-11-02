package dev.felnull.vorkitus.data;

import dev.felnull.vorkitus.block.VorkitusBlockTags;
import dev.felnull.vorkitus.block.VorkitusBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class VorkitusBlockTagsProvider extends BlockTagsProvider {
    public VorkitusBlockTagsProvider(DataGenerator p_126511_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126511_, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(VorkitusBlockTags.NO_SPREADING_VOID)
                .add(VorkitusBlocks.MAGIC_IRON_ORE.get())
                .addTag(BlockTags.PORTALS)
                .addTag(BlockTags.FIRE);

        this.tag(BlockTags.WITHER_IMMUNE)
                .add(VorkitusBlocks.SPREADING_VOID.get());

        this.tag(BlockTags.DRAGON_IMMUNE)
                .add(VorkitusBlocks.SPREADING_VOID.get());

    }
}
