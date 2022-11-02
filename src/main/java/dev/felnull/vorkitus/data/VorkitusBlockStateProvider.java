package dev.felnull.vorkitus.data;

import dev.felnull.vorkitus.block.VorkitusBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class VorkitusBlockStateProvider extends BlockStateProvider {

    public VorkitusBlockStateProvider(DataGenerator gen, String modid, ExistingFileHelper existingFileHelper) {
        super(gen, modid, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockAndItem(VorkitusBlocks.MAGIC_IRON_ORE.get());
        simpleBlockAndItem(VorkitusBlocks.SPREADING_VOID.get());
    }

    private void simpleBlockAndItem(Block block) {
        var tbm = cubeAll(block);
        simpleBlock(block, tbm);
        simpleBlockItem(block, tbm);
    }
}
