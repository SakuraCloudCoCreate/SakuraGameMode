package com.sakura.sakuragamemode;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class commands implements CommandExecutor {
    private JavaPlugin plugin;
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (commandSender instanceof Player){
            plugin = SakuraGameMode.javaPlugin;
            Player player = (Player) commandSender;
            if (label.equalsIgnoreCase("gms")){
                String gmsPermission = plugin.getConfig().getString("permission.gms");
                if (Objects.nonNull(gmsPermission)){
                    if (player.hasPermission(gmsPermission)){
                        if (!player.getGameMode().equals(GameMode.SURVIVAL)){
                            player.setGameMode(GameMode.SURVIVAL);
                            String success = plugin.getConfig().getString("message.success");
                            if (success != null) {
                                success = success.replaceAll("%gamemode%", GameMode.SURVIVAL.name());
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', success));
                            }
                        }else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',Objects.requireNonNull(plugin.getConfig().getString("message.notNeeded"))));
                        }
                    }else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',Objects.requireNonNull(plugin.getConfig().getString("message.noPermission"))));
                    }
                }
            }

            if (label.equalsIgnoreCase("gmsp")){
                String gmspPermission = plugin.getConfig().getString("permission.gmsp");
                if (Objects.nonNull(gmspPermission)) {
                    if (player.hasPermission(gmspPermission)) {
                        if (!player.getGameMode().equals(GameMode.SPECTATOR)) {
                            player.setGameMode(GameMode.SPECTATOR);
                            String success = plugin.getConfig().getString("message.success");
                            if (success != null) {
                                success = success.replaceAll("%gamemode%", GameMode.SPECTATOR.name());
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', success));
                            }

                        } else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("message.notNeeded"))));
                        }
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("message.noPermission"))));
                    }
                }
            }
        }else {
            System.out.println("Illegal usage, this command can;t be executed in the console");
        }

        return true;
    }
}
