package com.example.examplemod.world;

import net.minecraft.data.worldgen.BiomeData;
import net.minecraft.sounds.Music;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class ZoneBiomes {

    public static Biome createGreenZone() {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(net.minecraft.world.entity.EntityType.SHEEP, new net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData(net.minecraft.world.entity.EntityType.SHEEP, 12, 4, 4));
        mobSpawnSettings.addSpawn(net.minecraft.world.entity.EntityType.PIG, new net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData(net.minecraft.world.entity.EntityType.PIG, 10, 4, 4));
        mobSpawnSettings.addSpawn(net.minecraft.world.entity.EntityType.COW, new net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData(net.minecraft.world.entity.EntityType.COW, 8, 4, 4));
        mobSpawnSettings.addSpawn(net.minecraft.world.entity.EntityType.CHICKEN, new net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData(net.minecraft.world.entity.EntityType.CHICKEN, 10, 4, 4));

        BiomeGenerationSettings.Builder genSettings = new BiomeGenerationSettings.Builder();
        genSettings.addFeature(net.minecraft.world.level.levelgen.GenerationStep.Decoration.VEGETAL_DECORATION, net.minecraft.world.level.levelgen.placement.PlacedFeatures.TREES_PLAINS);

        return new Biome.BiomeBuilder()
                .precipitation(net.minecraft.world.level.biome.Biome.Precipitation.RAIN)
                .biomeCategory(net.minecraft.world.level.biome.Biome.BiomeCategory.FOREST)
                .temperature(0.7f)
                .downfall(0.8f)
                .specialEffects(new net.minecraft.world.level.biome.BiomeSpecialEffects.Builder()
                        .waterColor(0x3F76E4)
                        .waterFogColor(0x050533)
                        .fogColor(0xC0D8FF)
                        .skyColor(0x78A7FF)
                        .grassColorOverride(0x90EE90)
                        .foliageColorOverride(0x228B22)
                        .build())
                .mobSpawnSettings(mobSpawnSettings.build())
                .generationSettings(genSettings.build())
                .build();
    }

    public static Biome createYellowZone() {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(net.minecraft.world.entity.EntityType.SHEEP, new net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData(net.minecraft.world.entity.EntityType.SHEEP, 12, 4, 4));
        mobSpawnSettings.addSpawn(net.minecraft.world.entity.EntityType.PIG, new net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData(net.minecraft.world.entity.EntityType.PIG, 10, 4, 4));

        BiomeGenerationSettings.Builder genSettings = new BiomeGenerationSettings.Builder();
        genSettings.addFeature(net.minecraft.world.level.levelgen.GenerationStep.Decoration.VEGETAL_DECORATION, net.minecraft.world.level.levelgen.placement.PlacedFeatures.TREES_SAVANNA);

        return new Biome.BiomeBuilder()
                .precipitation(net.minecraft.world.level.biome.Biome.Precipitation.NONE)
                .biomeCategory(net.minecraft.world.level.biome.Biome.BiomeCategory.SAVANNA)
                .temperature(1.2f)
                .downfall(0.0f)
                .specialEffects(new net.minecraft.world.level.biome.BiomeSpecialEffects.Builder()
                        .waterColor(0x32A4FF)
                        .waterFogColor(0x050533)
                        .fogColor(0xF4E4C1)
                        .skyColor(0xF0E68C)
                        .grassColorOverride(0xFFD700)
                        .foliageColorOverride(0xDAA520)
                        .build())
                .mobSpawnSettings(mobSpawnSettings.build())
                .generationSettings(genSettings.build())
                .build();
    }

    public static Biome createRedZone() {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(net.minecraft.world.entity.EntityType.HUSK, new net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData(net.minecraft.world.entity.EntityType.HUSK, 80, 4, 4));
        mobSpawnSettings.addSpawn(net.minecraft.world.entity.EntityType.ZOMBIE, new net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData(net.minecraft.world.entity.EntityType.ZOMBIE, 80, 4, 4));

        BiomeGenerationSettings.Builder genSettings = new BiomeGenerationSettings.Builder();
        genSettings.addFeature(net.minecraft.world.level.levelgen.GenerationStep.Decoration.VEGETAL_DECORATION, net.minecraft.world.level.levelgen.placement.PlacedFeatures.DEAD_BUSH_DESERT);

        return new Biome.BiomeBuilder()
                .precipitation(net.minecraft.world.level.biome.Biome.Precipitation.NONE)
                .biomeCategory(net.minecraft.world.level.biome.Biome.BiomeCategory.DESERT)
                .temperature(2.0f)
                .downfall(0.0f)
                .specialEffects(new net.minecraft.world.level.biome.BiomeSpecialEffects.Builder()
                        .waterColor(0x32A4FF)
                        .waterFogColor(0x050533)
                        .fogColor(0xFF6347)
                        .skyColor(0xFF6347)
                        .grassColorOverride(0xCD5C5C)
                        .foliageColorOverride(0x8B4513)
                        .build())
                .mobSpawnSettings(mobSpawnSettings.build())
                .generationSettings(genSettings.build())
                .build();
    }

    public static Biome createBlackZone() {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(net.minecraft.world.entity.EntityType.ZOMBIE, new net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData(net.minecraft.world.entity.EntityType.ZOMBIE, 95, 4, 4));
        mobSpawnSettings.addSpawn(net.minecraft.world.entity.EntityType.SKELETON, new net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData(net.minecraft.world.entity.EntityType.SKELETON, 100, 4, 4));
        mobSpawnSettings.addSpawn(net.minecraft.world.entity.EntityType.CREEPER, new net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData(net.minecraft.world.entity.EntityType.CREEPER, 100, 4, 4));

        BiomeGenerationSettings.Builder genSettings = new BiomeGenerationSettings.Builder();

        return new Biome.BiomeBuilder()
                .precipitation(net.minecraft.world.level.biome.Biome.Precipitation.NONE)
                .biomeCategory(net.minecraft.world.level.biome.Biome.BiomeCategory.NETHER)
                .temperature(2.0f)
                .downfall(0.0f)
                .specialEffects(new net.minecraft.world.level.biome.BiomeSpecialEffects.Builder()
                        .waterColor(0x3F1F1F)
                        .waterFogColor(0x050533)
                        .fogColor(0x1a1a1a)
                        .skyColor(0x1a1a1a)
                        .grassColorOverride(0x2F2F2F)
                        .foliageColorOverride(0x2F2F2F)
                        .build())
                .mobSpawnSettings(mobSpawnSettings.build())
                .generationSettings(genSettings.build())
                .build();
    }
}
