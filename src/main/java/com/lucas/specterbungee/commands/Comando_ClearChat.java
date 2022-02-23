package com.lucas.specterbungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Comando_ClearChat extends Command {

	public Comando_ClearChat() {
		super("clearchat");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender cs, String[] args) {
		if (!cs.hasPermission("specter.clearchat")) {
			cs.sendMessage("§cVocê não tem permissão para executar este comando.");
			return;
		}
		if (cs instanceof ProxiedPlayer) {
			for (int i = 0; i < 150; i++) {
				for (ProxiedPlayer on : ProxyServer.getInstance().getPlayers()) {
					on.sendMessage("");
				}
			}
		}
		return;
	}
}
