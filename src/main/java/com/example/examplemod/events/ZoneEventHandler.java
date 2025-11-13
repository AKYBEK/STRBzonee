package com.example.examplemod.events;

import com.example.examplemod.zones.ZoneManager;
import com.example.examplemod.zones.ZoneRestrictions;
import com.example.examplemod.zones.ZoneType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "examplemod", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ZoneEventHandler {

    @SubscribeEvent
    public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
        if (event.getWorld().isClientSide()) {
            return;
        }

        ZoneType zone = ZoneManager.getZoneAtPosition((net.minecraft.world.level.Level) event.getWorld(), event.getPos());
        Block placedBlock = event.getPlacedBlock().getBlock();

        if (!ZoneRestrictions.canPlaceBlock(zone, placedBlock)) {
            event.setCanceled(true);

            if (event.getEntity() != null) {
                String blockName = placedBlock.getName().getString();
                event.getEntity().sendMessage(
                        new TextComponent("You cannot place ")
                                .withStyle(ChatFormatting.RED)
                                .append(new TextComponent(blockName).withStyle(ChatFormatting.YELLOW))
                                .append(new TextComponent(" in ").withStyle(ChatFormatting.RED))
                                .append(new TextComponent(zone.getDisplayName()).withStyle(ChatFormatting.GOLD)),
                        event.getEntity().getUUID()
                );
            }
        }
    }
}
