package dev.felnull.vorkitus.item;

import dev.felnull.vorkitus.Vorkitus;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class VorkitusCreativeModeTab {
    public static final CreativeModeTab TAB = new CreativeModeTab(Vorkitus.MODID) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(Items.APPLE);
        }
    };
}
