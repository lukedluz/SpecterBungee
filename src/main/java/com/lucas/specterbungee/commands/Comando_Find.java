package com.lucas.specterbungee.commands;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class Comando_Find extends Command {
	
    public Comando_Find() {
        super("find");
    }

	@SuppressWarnings("deprecation")
    public void execute(CommandSender sender, String[] args) {
        if (!sender.hasPermission("specter.find")) {
            sender.sendMessage("§cVocê não tem permissão para executar este comando.");
            return;
        }
        if (args.length == 0) {
            sender.sendMessage("§cUtilize /find <usuário>.");
            return;
        }
        ProxiedPlayer player = ProxyServer.getInstance().getPlayer(args[0]);
        if (player == null) {
        	sender.sendMessage("§cEste usuário não está on-line.");
        	return;
        }
        sender.sendMessage("§aO usuário " + player.getName() + " está conectado ao servidor '" + player.getServer().getInfo().getName().replaceAll("Lobby", "Lobby").replaceAll("RankUP", "RankUP Lure").replaceAll("Testes", "Servidor de Testes") + "'.");
    }
}