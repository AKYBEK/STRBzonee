package com.example.examplemod.zones;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.*;

public class ZoneRestrictions {
    private static final Map<ZoneType, Set<Block>> ALLOWED_BLOCKS = new HashMap<>();

    public static void initializeRestrictions() {
        ALLOWED_BLOCKS.put(ZoneType.SPAWN, new HashSet<>(Arrays.asList(
                Blocks.DIRT
        )));

        ALLOWED_BLOCKS.put(ZoneType.GREEN, new HashSet<>(Arrays.asList(
                Blocks.IRON_BLOCK
        )));

        ALLOWED_BLOCKS.put(ZoneType.YELLOW, new HashSet<>(Arrays.asList(
                Blocks.GOLD_BLOCK
        )));

        ALLOWED_BLOCKS.put(ZoneType.RED, new HashSet<>(Arrays.asList(
                Blocks.NETHERITE_BLOCK
        )));

        ALLOWED_BLOCKS.put(ZoneType.BLACK, new HashSet<>());
    }

    public static boolean canPlaceBlock(ZoneType zone, Block block) {
        if (zone == ZoneType.BLACK) {
            return true;
        }

        Set<Block> allowedBlocks = ALLOWED_BLOCKS.get(zone);
        if (allowedBlocks == null) {
            return false;
        }

        return allowedBlocks.contains(block);
    }

    public static Set<Block> getAllowedBlocks(ZoneType zone) {
        return ALLOWED_BLOCKS.getOrDefault(zone, Collections.emptySet());
    }
}
