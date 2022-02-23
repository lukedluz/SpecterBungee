package com.lucas.specterbungee.commands;

import java.util.ArrayList;
import java.util.List;

import net.alpenblock.bungeeperms.BungeePerms;
import net.alpenblock.bungeeperms.Group;
import net.alpenblock.bungeeperms.User;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Comando_Grupo extends Command {

	public Comando_Grupo() {
		super("grupo");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		if (!sender.hasPermission("specter.groups")) {
			sender.sendMessage("§cVocê não tem permissão para executar este comando.");
		} else if (args.length == 0) {
			sender.sendMessage("");
			sender.sendMessage("§a/grupo adicionar <usuário> <grupo>.");
			sender.sendMessage("§a/grupo remover <usuário> <grupo>.");
			sender.sendMessage("§a/grupo definir <usuário> <grupo>.");
			sender.sendMessage("");
		} else {
			ProxiedPlayer player;
			String group;
			Group groups;
			User user;
			if (args[0].equalsIgnoreCase("adicionar")) {
				if (args.length < 3) {
					sender.sendMessage("§cUtilize /grupo adicionar <usuário> <grupo>.");
				} else {
					player = ProxyServer.getInstance().getPlayer(args[1]);
					if (player == null) {
						sender.sendMessage("§cEste usuário não está on-line.");
					} else {
						group = args[2];
						groups = BungeePerms.getInstance().getPermissionsManager().getGroup(group);
						user = BungeePerms.getInstance().getPermissionsManager().getUser(player.getName());
						BungeePerms.getInstance().getPermissionsManager().addUserGroup(user, groups);
						sender.sendMessage("§aUsuário adicionado ao grupo " + group + ".");
						player.sendMessage("§aVocê foi promovido ao cargo de " + group + ".");
					}
				}
			} else if (args[0].equalsIgnoreCase("remover")) {
				if (args.length < 3) {
					sender.sendMessage("§cUtilize /grupo adicionar <usuário> <grupo>.");
				} else {
					player = ProxyServer.getInstance().getPlayer(args[1]);
					if (player == null) {
						sender.sendMessage("§cEste usuário não está on-line.");
					} else {
						group = args[2];
						groups = BungeePerms.getInstance().getPermissionsManager().getGroup(group);
						user = BungeePerms.getInstance().getPermissionsManager().getUser(player.getName());
						BungeePerms.getInstance().getPermissionsManager().removeUserGroup(user, groups);
						sender.sendMessage("§aUsuário removido do grupo " + group + ".");
					}
				}
			} else if (args[0].equalsIgnoreCase("definir")) {
				if (args.length < 3) {
					sender.sendMessage("§cUtilize /grupo definir <usuário> <grupo>.");
				} else {
					player = ProxyServer.getInstance().getPlayer(args[1]);
					if (player == null) {
						sender.sendMessage("§cEste usuário não está on-line.");
					} else {
						group = args[2];
						groups = BungeePerms.getInstance().getPermissionsManager().getGroup(group);
						user = BungeePerms.getInstance().getPermissionsManager().getUser(player.getName());
						List<Group> list = new ArrayList<>();
						list.add(groups);
						user.getGroups().clear();
						//user.setGroups(list);
						sender.sendMessage("§aGrupo do usuário " + player.getName() + " definido para " + group + ".");
					}
				}
			}
		}
	}
}