package dev.felnull.vorkitus.block;

import dev.felnull.vorkitus.Vorkitus;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class VorkitusBlockTags {
    public static final TagKey<Block> NO_SPREADING_VOID = create("no_spreading_void");

    private static TagKey<Block> create(String name) {
        return BlockTags.create(new ResourceLocation(Vorkitus.MODID, name));
    }
}
