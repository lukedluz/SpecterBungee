package com.lucas.specterbungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ClearChatCommand extends Command {
    public ClearChatCommand() {
        super("clearchat");
    }

    public void execute(CommandSender cs, String[] args) {
        if (!cs.hasPermission("legit.clearchat")) {
            cs.sendMessage("ntem permisspara executar este comando.");
            return;
        }
        if (cs instanceof ProxiedPlayer)
            for (int i = 0; i < 150; i++) {
                for (ProxiedPlayer on : ProxyServer.getInstance().getPlayers())
                    on.sendMessage(");
            }
    }
}
