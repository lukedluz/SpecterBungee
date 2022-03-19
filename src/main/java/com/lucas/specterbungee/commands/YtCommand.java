package com.lucas.specterbungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class YtCommand extends Command {
    public YtCommand() {
        super("youtubers");
    }

    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage("");
        sender.sendMessage("online no momento:");
        int i = 0;
        for (ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
            if (players.hasPermission("legit.youtuber")) {
                i++;
                sender.sendMessage(" " + players.getName() + " + players.getServer().getInfo().getName() + ")");
            }
        }
        if (i == 0)
            sender.sendMessage("hyoutubers online no momento.");
        sender.sendMessage("");
    }
}
