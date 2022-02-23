package com.lucas.specterbungee.commands;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import com.lucas.specterbungee.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Comando_Lobby extends Command {
	public Comando_Lobby() {
		super("lobby");
	}

	public static HashMap<String, Integer> conf = new HashMap<String, Integer>();

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		if (!(sender instanceof ProxiedPlayer)) {
			return;
		}
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (p.getServer().getInfo().getName().contains("Lobby")) {
			p.sendMessages(new String[] { "§cVocê já está no lobby." });
			return;
		}
		Main.getInstance().getProxy().getScheduler().schedule(Main.getInstance(), new Runnable() {
			public void run() {
				ServerInfo lobby = Main.getInstance().getProxy().getServerInfo("Lobby");
				p.connect(lobby);
			}
		}, 1L, TimeUnit.SECONDS);
	}
}
