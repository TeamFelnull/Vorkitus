package dev.felnull.vorkitus.block;

import dev.felnull.vorkitus.Vorkitus;
import dev.felnull.vorkitus.item.VorkitusCreativeModeTab;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class VorkitusBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Vorkitus.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Vorkitus.MODID);

    public static final RegistryObject<Block> MAGIC_IRON_ORE = register("magic_iron_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> SPREADING_VOID = register("spreading_void", () -> new SpreadingVoidBlock(BlockBehaviour.Properties.of(Material.METAL).speedFactor(0.6F).randomTicks().requiresCorrectToolForDrops().isValidSpawn(VorkitusBlocks::never).strength(66, 1500)));

    public static void init(IEventBus eb) {
        BLOCKS.register(eb);
        ITEMS.register(eb);
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos, EntityType<?> entityType) {
        return false;
    }

    private static RegistryObject<Block> register(String name, Supplier<Block> block) {
        var rb = BLOCKS.register(name, block);
        ITEMS.register(name, () -> new BlockItem(rb.get(), new Item.Properties().tab(VorkitusCreativeModeTab.TAB)));
        return rb;
    }

}
