package dev.felnull.vorkitus;

import com.mojang.logging.LogUtils;
import dev.felnull.vorkitus.block.VorkitusBlocks;
import dev.felnull.vorkitus.item.VorkitusItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(Vorkitus.MODID)
public class Vorkitus {
    public static final String MODID = "vorkitus";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Vorkitus() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        VorkitusItems.init(modEventBus);
        VorkitusBlocks.init(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
}
