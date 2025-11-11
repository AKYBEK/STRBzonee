package com.example.examplemod.zones;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;

import java.util.HashMap;
import java.util.Map;

public class ZoneManager {
    private static final Map<ResourceLocation, ZoneType> BIOME_ZONES = new HashMap<>();

    public static void registerBiomeZone(ResourceLocation biome, ZoneType zone) {
        BIOME_ZONES.put(biome, zone);
    }

    public static ZoneType getZoneAtPosition(Level level, BlockPos pos) {
        Holder<Biome> biomeHolder = level.getBiome(pos);
        ResourceLocation biomeName = biomeHolder.unwrap()
                .map(key -> key.location(), biome -> new ResourceLocation("unknown"));

        return BIOME_ZONES.getOrDefault(biomeName, ZoneType.SPAWN);
    }

    public static void initializeDefaultZones() {
        registerBiomeZone(new ResourceLocation("minecraft:plains"), ZoneType.SPAWN);
        registerBiomeZone(new ResourceLocation("minecraft:forest"), ZoneType.GREEN);
        registerBiomeZone(new ResourceLocation("minecraft:birch_forest"), ZoneType.GREEN);
        registerBiomeZone(new ResourceLocation("minecraft:taiga"), ZoneType.YELLOW);
        registerBiomeZone(new ResourceLocation("minecraft:savanna"), ZoneType.YELLOW);
        registerBiomeZone(new ResourceLocation("minecraft:desert"), ZoneType.RED);
        registerBiomeZone(new ResourceLocation("minecraft:badlands"), ZoneType.RED);
        registerBiomeZone(new ResourceLocation("minecraft:nether_wastes"), ZoneType.BLACK);
        registerBiomeZone(new ResourceLocation("minecraft:warped_forest"), ZoneType.BLACK);
        registerBiomeZone(new ResourceLocation("minecraft:crimson_forest"), ZoneType.BLACK);
        registerBiomeZone(new ResourceLocation("minecraft:basalt_deltas"), ZoneType.BLACK);
        registerBiomeZone(new ResourceLocation("minecraft:soul_sand_valley"), ZoneType.BLACK);
        registerBiomeZone(new ResourceLocation("minecraft:the_end"), ZoneType.BLACK);
    }
}
