package com.lucas.specterbungee.commands;

import java.util.ArrayList;

import com.lucas.specterbungee.Main;
import net.alpenblock.bungeeperms.BungeePerms;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Comando_Bunker extends Command {
	
	public static ArrayList<String> cstaff = new ArrayList<String>();

	public Comando_Bunker() {
		super("b");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (!p.hasPermission("specter.SubDirecao")) {
			sender.sendMessage("§cVocê não tem permissão para executar este comando.");
			return;
		}
		if (args.length == 0) {
			p.sendMessage("§cUtilize /b <mensagem> para enviar uma mensagem para a gerência e direção.");
			return;
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("ativar")) {
				if (!cstaff.contains(p.getName())) {
					p.sendMessage("§cSeu chat bunker já está ativado.");
					return;
				}
				cstaff.remove(p.getName());
				p.sendMessage("§aChat bunker ativado!");
				return;
			}
			if (args[0].equalsIgnoreCase("desativar")) {
				if (cstaff.contains(p.getName())) {
					p.sendMessage("§cSeu chat bunker já está desativado.");
					return;
				}
				cstaff.add(p.getName());
				p.sendMessage("§aChat bunker desativado!");
				return;
			}
		}
		if (args.length > 0) {
			String message = "";
			for (String part : args) {
				if (message != "") {
					message = String.valueOf(message) + " ";
				}
				message = String.valueOf(message) + part;
			}
			String tag = "";
			try {
				if (BungeePerms.getInstance().getPermissionsManager().getUser(p.getName()).getGroups().contains(BungeePerms.getInstance().getPermissionsManager().getGroup("Master"))) {
					tag = "§6[Direção]";
					for (String s : Main.getInstance().getProxy().getServers().keySet()) {
						ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
						for (ProxiedPlayer todos : i.getPlayers()) {
							if (todos.hasPermission("specter.direcao") && !Comando_Bunker.cstaff.contains(todos.getName())) {
								todos.sendMessage("§5§l[§cB§5§l] §7[" + p.getServer().getInfo().getName().replaceAll("FactionsZ", "F. Obsoleto").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
							}
						}
					}
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (p.hasPermission("specter.SubDirecao")) {
				tag = "§9[SubDireção]";
				for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
					ServerInfo j = Main.getInstance().getProxy().getServers().get(s2);
					for (ProxiedPlayer todos2 : j.getPlayers()) {
						if (todos2.hasPermission("specter.SubDirecao") && !Comando_Bunker.cstaff.contains(todos2.getName())) {
							todos2.sendMessage("§5§l[§cB§5§l] §7[" + p.getServer().getInfo().getName().replaceAll("RankUPL", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
						}
					}
				}
			}
		}
	}

	public static String getServer(String s) {
		String cha = String.valueOf(s.charAt(0));
		String f = String.valueOf(cha.toUpperCase()) + "-1";
		if (s.contains("_")) {
			String cham = "" + s.split("_")[1].charAt(0);
			f = String.valueOf(cha.toUpperCase()) + "-" + cham.toUpperCase();
		}
		return f;
	}
}
