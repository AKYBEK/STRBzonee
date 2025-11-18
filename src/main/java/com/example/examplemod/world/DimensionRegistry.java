package com.example.examplemod.world;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class DimensionRegistry {
    public static final ResourceKey<Level> GREEN_DIMENSION = ResourceKey.create(ResourceKey.createRegistryKey(new ResourceLocation("minecraft", "dimension")), new ResourceLocation("examplemod", "green_dimension"));
    public static final ResourceKey<Level> YELLOW_DIMENSION = ResourceKey.create(ResourceKey.createRegistryKey(new ResourceLocation("minecraft", "dimension")), new ResourceLocation("examplemod", "yellow_dimension"));
    public static final ResourceKey<Level> RED_DIMENSION = ResourceKey.create(ResourceKey.createRegistryKey(new ResourceLocation("minecraft", "dimension")), new ResourceLocation("examplemod", "red_dimension"));
    public static final ResourceKey<Level> BLACK_DIMENSION = ResourceKey.create(ResourceKey.createRegistryKey(new ResourceLocation("minecraft", "dimension")), new ResourceLocation("examplemod", "black_dimension"));
}
