package com.example.examplemod.zones;

import com.example.examplemod.world.DimensionRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;

public class DimensionManager {
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
                player.teleportTo(targetLevel, player.getX(), player.getY(), player.getZ());
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
}
