package com.lucas.specterbungee.manutencao;

import com.lucas.specterbungee.Main;
import com.lucas.specterbungee.motd.MOTDListener;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ManutencaoCommand extends Command {
	
	public ManutencaoCommand() {
		super("manutencao");
	}

	@SuppressWarnings({ "deprecation", "unused" })
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (!p.hasPermission("specter.manutencao")) {
			sender.sendMessage("§cVocê não tem permissão para executar este comando.");
			return;
		}
		if (args.length == 0) {
			sender.sendMessage("§cUtilize /manutencao <servidor> <on/off> para gerenciar o modo Manutenção.");
			return;
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("info")) {
				p.sendMessage("§1");
				for (String s : Main.getInstance().getProxy().getServers().keySet()) {
					String cor = "§c";
					ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
					int port = i.getAddress().getPort();
					if (!ManutencaoListener.checarExiste(port)) continue;
					if (ManutencaoListener.checarOn(port)) {
						cor = "§a";
					}
				}
				p.sendMessage("§2");
				return;
			}
			sender.sendMessage("§cUtilize /manutencao <servidor> <on/off> para gerenciar o modo Manutenção.");
			return;
		}
		if (args.length == 2) {
			String servidor = args[0].toLowerCase();
			if (servidor.equalsIgnoreCase("global")) {
				String toggle = args[1];
				if (toggle.equalsIgnoreCase("on")) {
					for (String s : Main.getInstance().getProxy().getServers().keySet()) {
						ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
						int port = i.getAddress().getPort();
						if (!ManutencaoListener.checarExiste(port) || ManutencaoListener.checarOn(port)) continue;
						ManutencaoListener.setarOn(port);
						ManutencaoListener.findandkick(port);
					}
					MOTDListener.setarTotalManu();
					p.sendMessage("§aVocê ativou a Manutenção global.");
					return;
				}
				if (toggle.equalsIgnoreCase("off")) {
					for (String s : Main.getInstance().getProxy().getServers().keySet()) {
						ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
						int port = i.getAddress().getPort();
						if (!ManutencaoListener.checarExiste(port) || !ManutencaoListener.checarOn(port)) continue;
						ManutencaoListener.setarOff(port);
					}
					MOTDListener.removerTotalManu();
					p.sendMessage("§aVocê desativou a Manutenção global.");
					return;
				}
				p.sendMessage("§cOpção '" + args[1] + "' inexistente.");
				return;
			}
			if (Main.getInstance().getProxy().getServers().get(servidor) == null) {
				p.sendMessage("§cServidor não encontrado.");
				return;
			}
			ServerInfo si = Main.getInstance().getProxy().getServers().get(servidor);
			int port = si.getAddress().getPort();
			if (!ManutencaoListener.checarExiste(port)) {
				p.sendMessage("§cServidor não registrado em nosso sistema.");
				return;
			}
			String toggle = args[1];
			if (toggle.equalsIgnoreCase("on")) {
				if (ManutencaoListener.checarOn(port)) {
					p.sendMessage("§cModo Manutenção do servidor '" + si.getName() + "' já está ativado.");
					return;
				}
				ManutencaoListener.setarOn(port);
				ManutencaoListener.findandkick(port);
				p.sendMessage("§fModo §aManutenção §fdo servidor '" + si.getName() + "' ativado.");
				return;
			}
			if (toggle.equalsIgnoreCase("off")) {
				if (!ManutencaoListener.checarOn(port)) {
					p.sendMessage("§cModo Manutenção do servidor '" + si.getName() + "' já está desativado.");
					return;
				}
				ManutencaoListener.setarOff(port);
				p.sendMessage("§fModo §cManutenção §fdo servidor '" + si.getName() + "' desativado.");
				return;
			}
			p.sendMessage("§cOpção '" + args[1] + "' inexistente.");
			return;
		}
		if (args.length > 2) {
			sender.sendMessage("§cUtilize /manutencao <servidor> <on/off> para gerenciar o modo Manutencao.");
			return;
		}
	}
}
