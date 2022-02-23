package com.lucas.specterbungee.commands;

import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.ProxyServer;

import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;

public class Comando_Send extends Command implements TabExecutor {

	public Comando_Send() {
		super("send");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		if (!sender.hasPermission("specter.send")) {
			sender.sendMessage("§cVocê não tem permissão para executar este comando.");
			return;
		}
		if (args.length < 2) {
			sender.sendMessage("§cUtilize /send <usuário> <servidor>.");
			return;
		}
		ProxiedPlayer player = ProxyServer.getInstance().getPlayer(args[0]);
		if (player == null && !args[0].equalsIgnoreCase("current")) {
			sender.sendMessage("§cEste usuário não está on-line.");
			return;
		} else if (args[0].equalsIgnoreCase("current")) {
			ProxiedPlayer p = ProxyServer.getInstance().getPlayer(sender.getName());
			for (ProxiedPlayer pp : ProxyServer.getInstance().getServerInfo(p.getServer().getInfo().getName()).getPlayers()) {
				if (pp == p) {
					continue;
				}
				ServerInfo server = ProxyServer.getInstance().getServerInfo(args[1]);
				pp.connect(server);
			}
		} else {
			ServerInfo server = ProxyServer.getInstance().getServerInfo(args[1]);
			if (server == null) {
				sender.sendMessage("§cServidor não encontrado.");
				return;
			}
			if (player.getServer().getInfo() == server) {
				sender.sendMessage("§cEste usuário já está conectado á este servidor.");
				return;
			}
			try {
				Socket s = new Socket(server.getAddress().getAddress().getHostAddress(), server.getAddress().getPort());
				s.close();
				player.connect(server);
				sender.sendMessage("§aEnviando " + player.getName() + " para o servidor '" + server.getName() + "'.");
			} catch (Exception e) {
				sender.sendMessage("§cEste servidor está off-line!");
				return;
			}
		}
	}

	public Iterable<String> onTabComplete(CommandSender sender, String[] args) {
		if (args.length > 2 || args.length == 0) {
			return ImmutableSet.of();
		}
		Set<String> matches = new HashSet<>();
		if (args.length == 1) {
			String search = args[0].toLowerCase();
			for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
				if (player.getName().toLowerCase().startsWith(search)) {
					matches.add(player.getName());
				}
			}
			if ("all".startsWith(search)) {
				matches.add("all");
			}
			if ("current".startsWith(search)) {
				matches.add("current");
			}
		} else {
			String search = args[1].toLowerCase();
			for (String server : ProxyServer.getInstance().getServers().keySet()) {
				if (server.toLowerCase().startsWith(search)) {
					matches.add(server);
				}
			}
		}
		return matches;
	}
}