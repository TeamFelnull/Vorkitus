package dev.felnull.vorkitus.handler;

import dev.felnull.vorkitus.Vorkitus;
import dev.felnull.vorkitus.data.VorkitusBlockStateProvider;
import dev.felnull.vorkitus.data.VorkitusBlockTagsProvider;
import dev.felnull.vorkitus.data.VorkitusItemModelProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Vorkitus.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenHandler {
    @SubscribeEvent
    public static void onDataGen(GatherDataEvent event) {
        var data = event.getGenerator();
        data.addProvider(event.includeClient(), new VorkitusBlockStateProvider(data, Vorkitus.MODID, event.getExistingFileHelper()));
        data.addProvider(event.includeClient(), new VorkitusItemModelProvider(data, Vorkitus.MODID, event.getExistingFileHelper()));
        data.addProvider(event.includeServer(), new VorkitusBlockTagsProvider(data, Vorkitus.MODID, event.getExistingFileHelper()));
    }
}
