package com.lucas.specterbungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class FindCommand extends Command {
    public FindCommand() {
        super("find");
    }

    public void execute(CommandSender sender, String[] args) {
        if (!sender.hasPermission("smite.find")) {
            sender.sendMessage("ntem permisspara executar este comando.");
            return;
        }
        if (args.length == 0) {
            sender.sendMessage("/find <usu);
            return;
        }
        ProxiedPlayer player = ProxyServer.getInstance().getPlayer(args[0]);
        if (player == null) {
            sender.sendMessage("usuneston-line.");
            return;
        }
        sender.sendMessage("usu" + player.getName() + " estconectado ao servidor '" + player.getServer().getInfo().getName().replaceAll("Lobby", "Lobby").replaceAll("Factions", "Factions Flame").replaceAll("Testes", "Servidor de Testes") + "'.");
    }
}
