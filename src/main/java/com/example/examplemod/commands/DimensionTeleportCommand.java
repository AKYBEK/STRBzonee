package com.example.examplemod.commands;

import com.example.examplemod.zones.DimensionManager;
import com.example.examplemod.zones.ZoneType;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;

public class DimensionTeleportCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("dimtp")
                .requires(cs -> cs.hasPermission(2))
                .then(Commands.argument("zone", StringArgumentType.word())
                        .suggests((ctx, builder) -> {
                            builder.suggest("green");
                            builder.suggest("yellow");
                            builder.suggest("red");
                            builder.suggest("black");
                            builder.suggest("spawn");
                            return builder.buildFuture();
                        })
                        .executes(ctx -> {
                            String zoneName = StringArgumentType.getString(ctx, "zone").toLowerCase();
                            CommandSourceStack source = ctx.getSource();

                            if (!(source.getEntity() instanceof Player)) {
                                source.sendFailure(new TextComponent("This command can only be run by a player"));
                                return 0;
                            }

                            Player player = (Player) source.getEntity();
                            ZoneType zone;

                            try {
                                zone = ZoneType.valueOf(zoneName.toUpperCase());
                            } catch (IllegalArgumentException e) {
                                source.sendFailure(new TextComponent("Unknown zone: " + zoneName));
                                return 0;
                            }

                            DimensionManager.teleportPlayerToZone(player, zone);
                            source.sendSuccess(new TextComponent("Teleported to " + zone.getDisplayName()), true);
                            return 1;
                        })
                )
        );
    }
}
