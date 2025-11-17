package com.example.examplemod.world;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = "examplemod", bus = Mod.EventBusSubscriber.Bus.MOD)
public class DimensionRegistry {
    public static final DeferredRegister<DimensionType> DIMENSION_TYPES = DeferredRegister.create(ForgeRegistries.DIMENSION_TYPES, "examplemod");

    public static final ResourceKey<Level> GREEN_DIMENSION = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("examplemod", "green_dimension"));
    public static final ResourceKey<Level> YELLOW_DIMENSION = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("examplemod", "yellow_dimension"));
    public static final ResourceKey<Level> RED_DIMENSION = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("examplemod", "red_dimension"));
    public static final ResourceKey<Level> BLACK_DIMENSION = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("examplemod", "black_dimension"));
}
