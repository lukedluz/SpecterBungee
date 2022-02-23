package com.lucas.specterbungee.commands;

import com.lucas.specterbungee.utils.TitleAPI;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Comando_Alerta extends Command {

	public Comando_Alerta() {
		super("alerta", "", "bgbc");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender.hasPermission("specter.alerta")) {
			if (args.length < 2) {
				sender.sendMessage("§cUtilize /alerta <tipo> <mensagem> para enviar um alerta para todos os usuários.");
				return;
			} else if (args.length > 1) {
				String message = "";
				for (int i = 1; i < args.length; i++) {
					message = message + args[i] + " ";
				}
				if (args[0].equalsIgnoreCase("chat")) {
					ProxyServer.getInstance().broadcast();
					if (sender instanceof ProxiedPlayer) {
						ProxyServer.getInstance().broadcast("§1");
						ProxyServer.getInstance().broadcast(" §d§l[ANÚNCIO] §f" + message.replace("&", "§"));
						ProxyServer.getInstance().broadcast("§2");
					} else {
						ProxyServer.getInstance().broadcast("§1");
						ProxyServer.getInstance().broadcast(" §d§l[ANÚNCIO] §f" + message.replace("&", "§"));
						ProxyServer.getInstance().broadcast("§2");
					}
					ProxyServer.getInstance().broadcast();
				} else if (args[0].equalsIgnoreCase("title")) {
					String title = message.replace("&", "§");
					if (message.contains("<nl>")) {
						title = message.split("<nl>")[0];
						String subtitle = message.split("<nl>")[1];
						for (ProxiedPlayer on : ProxyServer.getInstance().getPlayers()) {
							TitleAPI.sendTitle(on, title, subtitle);
						}
					} else {
						for (ProxiedPlayer on : ProxyServer.getInstance().getPlayers()) {
							TitleAPI.sendTitle(on, title, "");
						}
					}
				}
			}
		} else {
			sender.sendMessage("§cVocê não tem permissão para executar este comando.");
			return;
		}
	}
}
