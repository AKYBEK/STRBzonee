package com.example.examplemod.zones;

import com.example.examplemod.world.DimensionRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = "examplemod", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DimensionManager {
    private static final Logger LOGGER = LoggerFactory.getLogger("examplemod");
    private static final Map<ZoneType, ResourceKey<Level>> ZONE_DIMENSIONS = new HashMap<>();

    public static void initializeDimensions() {
        ZONE_DIMENSIONS.put(ZoneType.GREEN, DimensionRegistry.GREEN_DIMENSION);
        ZONE_DIMENSIONS.put(ZoneType.YELLOW, DimensionRegistry.YELLOW_DIMENSION);
        ZONE_DIMENSIONS.put(ZoneType.RED, DimensionRegistry.RED_DIMENSION);
        ZONE_DIMENSIONS.put(ZoneType.BLACK, DimensionRegistry.BLACK_DIMENSION);
        ZONE_DIMENSIONS.put(ZoneType.SPAWN, Level.OVERWORLD);
    }

    public static ResourceKey<Level> getDimensionForZone(ZoneType zone) {
        return ZONE_DIMENSIONS.getOrDefault(zone, Level.OVERWORLD);
    }

    public static void teleportPlayerToZone(Player player, ZoneType zone) {
        if (player.level instanceof ServerLevel serverLevel) {
            ResourceKey<Level> targetDimension = getDimensionForZone(zone);
            ServerLevel targetLevel = serverLevel.getServer().getLevel(targetDimension);

            if (targetLevel != null && !player.level.equals(targetLevel)) {
                player.changeDimension(targetLevel);
            }
        }
    }

    public static ZoneType getZoneFromDimension(Level level) {
        ResourceKey<Level> dimKey = level.dimension();

        for (Map.Entry<ZoneType, ResourceKey<Level>> entry : ZONE_DIMENSIONS.entrySet()) {
            if (entry.getValue().equals(dimKey)) {
                return entry.getKey();
            }
        }
        return ZoneType.SPAWN;
    }

    @SubscribeEvent
    public static void onServerStarted(ServerStartedEvent event) {
        LOGGER.info("Ensuring all zone dimensions are loaded...");

        for (Map.Entry<ZoneType, ResourceKey<Level>> entry : ZONE_DIMENSIONS.entrySet()) {
            ServerLevel level = event.getServer().getLevel(entry.getValue());
            if (level == null) {
                LOGGER.warn("Dimension for zone {} was not loaded", entry.getKey());
            } else {
                LOGGER.info("Zone {} dimension loaded successfully", entry.getKey());
            }
        }
    }
}
