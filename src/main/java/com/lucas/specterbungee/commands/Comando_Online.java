package com.lucas.specterbungee.commands;

import com.lucas.specterbungee.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Comando_Online extends Command {
	public Comando_Online() {
		super("online");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		if (!(sender instanceof ProxiedPlayer)) {
			return;
		}
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (p.hasPermission("specter.direcao") || p.hasPermission("specter.subdirecao")) {
			int total = 0;
			int thi = 0;
			for (String s : Main.getInstance().getProxy().getServers().keySet()) {
				ServerInfo i = (ServerInfo) Main.getInstance().getProxy().getServers().get(s);
				total += i.getPlayers().size();
				if (!i.getName().equalsIgnoreCase(p.getServer().getInfo().getName())) continue;
				thi += i.getPlayers().size();
			}
			p.sendMessages("§1");
			p.sendMessages(" §e" + total + " §fusuários on-line em toda rede.");
			p.sendMessages(" §e" + thi + " §fusuários on-line neste servidor.");
			p.sendMessages("§2");
			int ch = 0;
			for (String s : Main.getInstance().getProxy().getServers().keySet()) {
				ServerInfo i = (ServerInfo) Main.getInstance().getProxy().getServers().get(s);
				p.sendMessage("§f o §e" + i.getPlayers().size() + " §fon-line no " + getServer1(i.getName().replaceAll("Lobby", "Lobby").replaceAll("RankUP", "R. Lure").replaceAll("Factions", "F. Caribe")));
				++ch;
			}
			if (ch > 0) {
				p.sendMessage("§3");
			}
		} else {
			int total = 0;
			int thi = 0;
			for (String s : Main.getInstance().getProxy().getServers().keySet()) {
				ServerInfo i = (ServerInfo) Main.getInstance().getProxy().getServers().get(s);
				total += i.getPlayers().size();
				if (!i.getName().equalsIgnoreCase(p.getServer().getInfo().getName()))
					continue;
				thi += i.getPlayers().size();
			}
			p.sendMessages("§1");
			p.sendMessages(" §e" + total + " §fusuários on-line em toda rede.");
			p.sendMessages(" §e" + thi + " §fusuários on-line neste servidor.");
			p.sendMessages("§2");
		}
	}

	public static String getServer1(String s) {
		String cha = String.valueOf(s.charAt(0));
		String f = String.valueOf(cha.toUpperCase()) + s.substring(1) + " ";
		if (s.contains("_")) {
			String ant = s.split("_")[0];
			String dps = s.split("_")[1];
			String cham = "" + s.split("_")[1].charAt(0);
			if (Comando_Online.isInt(cham)) {
				f = String.valueOf(cha.toUpperCase()) + ant.substring(1) + " " + cham;
				return f;
			}
			String cha2 = String.valueOf(dps.charAt(0));
			f = String.valueOf(cha.toUpperCase()) + ant.substring(1) + " " + cha2.toUpperCase() + dps.substring(1);
		}
		return f;
	}

	public static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
