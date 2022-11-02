package dev.felnull.vorkitus.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MagmaBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.lwjgl.system.SharedLibrary;

public class SpreadingVoidBlock extends Block {
    public SpreadingVoidBlock(Properties p_49795_) {
        super(p_49795_);
    }

    /*@Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        entity.makeStuckInBlock(state, new Vec3(0.25, 0.05, 0.25));

        if (!level.isClientSide()) {
            entity.hurt(DamageSource.MAGIC, 2.0F);
        }
    }*/

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (!level.isClientSide()) {
            entity.hurt(DamageSource.MAGIC, 2.0F);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource rand) {
        super.randomTick(state, serverLevel, pos, rand);

        //エンド以外なら終了
        if (serverLevel.dimension() != Level.END)
            return;

        //増殖処理
        for (Direction direct : Direction.values()) {
            BlockPos dirPos = pos.relative(direct, 1);
            BlockState dirState = serverLevel.getBlockState(dirPos);

            if (!dirState.isAir() && !dirState.is(this) && !dirState.is(VorkitusBlockTags.NO_SPREADING_VOID)) {
                serverLevel.setBlockAndUpdate(dirPos, this.defaultBlockState());
            }
        }
    }
}

