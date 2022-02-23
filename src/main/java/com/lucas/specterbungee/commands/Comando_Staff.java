package com.lucas.specterbungee.commands;

import java.util.ArrayList;

import com.lucas.specterbungee.Main;
import net.alpenblock.bungeeperms.BungeePerms;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Comando_Staff extends Command {
	public static ArrayList<String> cstaff = new ArrayList<String>();

	public Comando_Staff() {
		super("s");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (!p.hasPermission("specter.chatstaff")) {
			sender.sendMessage("§cVocê não tem permissão para executar este comando.");
			return;
		}
		if (args.length == 0) {
			p.sendMessage("§cUtilize /s <mensagem> para enviar uma mensagem para toda a staff.");
			return;
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("ativar")) {
				if (!cstaff.contains(p.getName())) {
					p.sendMessage("§cSeu chat da staff já está ativado.");
					return;
				}
				cstaff.remove(p.getName());
				p.sendMessage("§aChat da staff ativado!");
				return;
			}
			if (args[0].equalsIgnoreCase("desativar")) {
				if (cstaff.contains(p.getName())) {
					p.sendMessage("§cSeu chat da staff já está desativado.");
					return;
				}
				cstaff.add(p.getName());
				p.sendMessage("§aChat da staff desativado!");
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
				if (BungeePerms.getInstance().getPermissionsManager().getUser(p.getName()).getGroups().contains(BungeePerms.getInstance().getPermissionsManager().getGroup("Presidente"))) {
	                tag = "§0[Presidente]";
	                for (String s : Main.getInstance().getProxy().getServers().keySet()) {
	                    ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
	                    for (ProxiedPlayer todos : i.getPlayers()) {
	                        if (todos.hasPermission("specter.chatstaff")) {
	                            if (!Comando_Staff.cstaff.contains(todos.getName())) {
	                                todos.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
	                            }
	                            if (!Comando_Staff.cstaff.contains(todos.getName()) || !todos.getName().equals(p.getName())) {
	                                continue;
	                            }
	                            todos.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
	                        }
	                    }
	                }
	                return;
	            }
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
			if (p.hasPermission("specter.direcao")) {
				tag = "§6[Direção]";
				for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
					ServerInfo j = Main.getInstance().getProxy().getServers().get(s2);
					for (ProxiedPlayer todos2 : j.getPlayers()) {
						if (todos2.hasPermission("specter.chatstaff")) {
							if (!Comando_Staff.cstaff.contains(todos2.getName())) {
								todos2.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
							}
							if (!Comando_Staff.cstaff.contains(todos2.getName()) || !todos2.getName().equals(p.getName())) {
								continue;
							}
							todos2.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
						}
					}
				}
				return;
			}
			if (p.hasPermission("specter.subdirecao")) {
				tag = "§9[SubDireção]";
				for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
					ServerInfo j = Main.getInstance().getProxy().getServers().get(s2);
					for (ProxiedPlayer todos2 : j.getPlayers()) {
						if (todos2.hasPermission("specter.chatstaff")) {
							if (!Comando_Staff.cstaff.contains(todos2.getName())) {
								todos2.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
							}
							if (!Comando_Staff.cstaff.contains(todos2.getName()) || !todos2.getName().equals(p.getName())) {
								continue;
							}
							todos2.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
						}
					}
				}
				return;
			}
	        if (p.hasPermission("specter.gerente")) {
	            tag = "§4[Gerente]";
	            for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
	                ServerInfo j = Main.getInstance().getProxy().getServers().get(s2);
	                for (ProxiedPlayer todos2 : j.getPlayers()) {
	                	if (todos2.hasPermission("specter.chatstaff")) {
	                        if (!Comando_Staff.cstaff.contains(todos2.getName())) {
	                            todos2.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
	                        }
	                        if (!Comando_Staff.cstaff.contains(todos2.getName()) || !todos2.getName().equals(p.getName())) {
	                            continue;
	                        }
	                        todos2.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
	                    }
	                }
	            }
	            return;
	        }
			if (p.hasPermission("specter.supervisao")) {
				tag = "§b[SuperVisão]";
				for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
					ServerInfo j = Main.getInstance().getProxy().getServers().get(s2);
					for (ProxiedPlayer todos2 : j.getPlayers()) {
						if (todos2.hasPermission("specter.chatstaff")) {
							if (!Comando_Staff.cstaff.contains(todos2.getName())) {
								todos2.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
							}
							if (!Comando_Staff.cstaff.contains(todos2.getName()) || !todos2.getName().equals(p.getName())) {
								continue;
							}
							todos2.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
						}
					}
				}
				return;
			}
	        if (p.hasPermission("specter.administracao")) {
	            tag = "§c[Admin]";
	            for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
	                ServerInfo j = Main.getInstance().getProxy().getServers().get(s2);
	                for (ProxiedPlayer todos2 : j.getPlayers()) {
	                	if (todos2.hasPermission("specter.chatstaff")) {
	                        if (!Comando_Staff.cstaff.contains(todos2.getName())) {
	                            todos2.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
	                        }
	                        if (!Comando_Staff.cstaff.contains(todos2.getName()) || !todos2.getName().equals(p.getName())) {
	                            continue;
	                        }
	                        todos2.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
	                    }
	                }
	            }
	            return;
	        }
	        if (p.hasPermission("specter.modGC")) {
	            tag = "§5[ModGC]";
	            for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
	                ServerInfo j = Main.getInstance().getProxy().getServers().get(s2);
	                for (ProxiedPlayer todos2 : j.getPlayers()) {
	                	if (todos2.hasPermission("specter.chatstaff")) {
	                        if (!Comando_Staff.cstaff.contains(todos2.getName())) {
	                            todos2.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
	                        }
	                        if (!Comando_Staff.cstaff.contains(todos2.getName()) || !todos2.getName().equals(p.getName())) {
	                            continue;
	                        }
	                        todos2.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
	                    }
	                }
	            }
	            return;
	        }
	        if (p.hasPermission("specter.moderacao")) {
	            tag = "§2[Moderação]";
	            for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
	                ServerInfo j = Main.getInstance().getProxy().getServers().get(s2);
	                for (ProxiedPlayer todos2 : j.getPlayers()) {
	                	if (todos2.hasPermission("specter.chatstaff")) {
	                        if (!Comando_Staff.cstaff.contains(todos2.getName())) {
	                            todos2.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
	                        }
	                        if (!Comando_Staff.cstaff.contains(todos2.getName()) || !todos2.getName().equals(p.getName())) {
	                            continue;
	                        }
	                        todos2.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
	                    }
	                }
	            }
	            return;
	        }
	        if (p.hasPermission("specter.suporte")) {
	            tag = "§e[Ajudante]";
	            for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
	                ServerInfo j = Main.getInstance().getProxy().getServers().get(s2);
	                for (ProxiedPlayer todos2 : j.getPlayers()) {
	                	if (todos2.hasPermission("specter.chatstaff")) {
	                        if (!Comando_Staff.cstaff.contains(todos2.getName())) {
	                            todos2.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
	                        }
	                        if (!Comando_Staff.cstaff.contains(todos2.getName()) || !todos2.getName().equals(p.getName())) {
	                            continue;
	                        }
	                        todos2.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
	                    }
	                }
	            }
	        }
	        if (p.hasPermission("specter.estagiario")) {
	            tag = "§d[Estagiário]";
	            for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
	                ServerInfo j = Main.getInstance().getProxy().getServers().get(s2);
	                for (ProxiedPlayer todos2 : j.getPlayers()) {
	                	if (todos2.hasPermission("specter.chatstaff")) {
	                        if (!Comando_Staff.cstaff.contains(todos2.getName())) {
	                            todos2.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
	                        }
	                        if (!Comando_Staff.cstaff.contains(todos2.getName()) || !todos2.getName().equals(p.getName())) {
	                            continue;
	                        }
	                        todos2.sendMessage("§4[STAFF]§r §7[" + p.getServer().getInfo().getName().replaceAll("RankUP", "R. Lure").replaceAll("Lobby", "Lobby").replaceAll("Testes", "S. Testes") + "] " + tag + " " + p.getName() + ": §f" + message);
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
