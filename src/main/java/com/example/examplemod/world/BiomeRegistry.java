package com.example.examplemod.world;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = "examplemod", bus = Mod.EventBusSubscriber.Bus.MOD)
public class BiomeRegistry {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, "examplemod");

    public static final RegistryObject<Biome> GREEN_ZONE = BIOMES.register("green_zone", ZoneBiomes::createGreenZone);
    public static final RegistryObject<Biome> YELLOW_ZONE = BIOMES.register("yellow_zone", ZoneBiomes::createYellowZone);
    public static final RegistryObject<Biome> RED_ZONE = BIOMES.register("red_zone", ZoneBiomes::createRedZone);
    public static final RegistryObject<Biome> BLACK_ZONE = BIOMES.register("black_zone", ZoneBiomes::createBlackZone);
}
