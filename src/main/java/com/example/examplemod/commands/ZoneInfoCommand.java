package com.example.examplemod.commands;

import com.example.examplemod.zones.ZoneManager;
import com.example.examplemod.zones.ZoneRestrictions;
import com.example.examplemod.zones.ZoneType;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class ZoneInfoCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("zoneinfo")
                .executes(ZoneInfoCommand::execute));
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        CommandSourceStack source = context.getSource();

        if (source.getEntity() == null) {
            source.sendFailure(new TextComponent("This command must be executed by a player"));
            return 0;
        }

        BlockPos pos = source.getEntity().blockPosition();
        Level level = source.getLevel();
        ZoneType zone = ZoneManager.getZoneAtPosition(level, pos);

        source.sendSuccess(new TextComponent("=== Zone Information ===").withStyle(ChatFormatting.GOLD), false);
        source.sendSuccess(new TextComponent("Current Zone: ")
                .withStyle(ChatFormatting.GREEN)
                .append(new TextComponent(zone.getDisplayName()).withStyle(ChatFormatting.YELLOW)), false);
        source.sendSuccess(new TextComponent("Zone Level: " + zone.getLevel()).withStyle(ChatFormatting.AQUA), false);
        source.sendSuccess(new TextComponent("PvP Enabled: " + (zone.isPvpEnabled() ? "Yes" : "No"))
                .withStyle(zone.isPvpEnabled() ? ChatFormatting.RED : ChatFormatting.GREEN), false);

        if (zone != ZoneType.BLACK) {
            source.sendSuccess(new TextComponent("Allowed Blocks:").withStyle(ChatFormatting.LIGHT_PURPLE), false);
            for (Block block : ZoneRestrictions.getAllowedBlocks(zone)) {
                source.sendSuccess(new TextComponent("  - " + block.getName().getString())
                        .withStyle(ChatFormatting.WHITE), false);
            }
        } else {
            source.sendSuccess(new TextComponent("Allowed Blocks: ALL").withStyle(ChatFormatting.GREEN), false);
        }

        return 1;
    }
}
