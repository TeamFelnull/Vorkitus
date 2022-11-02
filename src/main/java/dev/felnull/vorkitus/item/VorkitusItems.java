package dev.felnull.vorkitus.item;

import dev.felnull.vorkitus.Vorkitus;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class VorkitusItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Vorkitus.MODID);
    public static final RegistryObject<Item> VORKITUS_SEED = register("vorkitus_seed", () -> new Item(new Item.Properties().tab(VorkitusCreativeModeTab.TAB)));

    private static RegistryObject<Item> register(String name, Supplier<Item> item) {
        return ITEMS.register(name, item);
    }

    public static void init(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}