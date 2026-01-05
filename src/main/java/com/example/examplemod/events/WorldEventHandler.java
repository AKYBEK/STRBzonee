package com.example.examplemod.events;

import com.example.examplemod.zones.DimensionManager;
import com.example.examplemod.zones.ZoneType;
import com.example.examplemod.world.DimensionRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod.EventBusSubscriber(modid = "examplemod", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WorldEventHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger("examplemod");

    @SubscribeEvent
    public static void onServerAboutToStart(ServerAboutToStartEvent event) {
        LOGGER.info("Preparing zone dimensions for world: {}", event.getServer().getWorldData().getLevelName());
    }
}
