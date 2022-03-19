package com.lucas.specterbungee.commands;

import br.com.smitecraft.bungee.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class OnlineCommand extends Command {
    public OnlineCommand() {
        super("online");
    }

    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer))
            return;
        ProxiedPlayer p = (ProxiedPlayer)sender;
        if (p.hasPermission("legit.online")) {
            int total = 0;
            int thi = 0;
            for (String s : Main.getInstance().getProxy().getServers().keySet()) {
                ServerInfo i = (ServerInfo)Main.getInstance().getProxy().getServers().get(s);
                total += i.getPlayers().size();
                if (!i.getName().equalsIgnoreCase(p.getServer().getInfo().getName()))
                    continue;
                thi += i.getPlayers().size();
            }
            p.sendMessages(new String[] { "});
                    p.sendMessages(new String[] { " + total + " on-line em toda rede." });
                            p.sendMessages(new String[] { " + thi + " on-line neste servidor." });
                                    p.sendMessages(new String[] { "});
            int ch = 0;
            for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
                ServerInfo j = (ServerInfo)Main.getInstance().getProxy().getServers().get(s2);
                p.sendMessage(" + j.getPlayers().size() + " no " + getServer1(j.getName().replaceAll("Lobby", "Lobby").replaceAll("FactionsB", "Factions Flame").replaceAll("Testes", "Servidor de Testes")));
                        ch++;
            }
            if (ch > 0)
                p.sendMessage(");
    } else {
                int total = 0;
                int thi = 0;
                for (String s : Main.getInstance().getProxy().getServers().keySet()) {
                    ServerInfo i = (ServerInfo)Main.getInstance().getProxy().getServers().get(s);
                    total += i.getPlayers().size();
                    if (!i.getName().equalsIgnoreCase(p.getServer().getInfo().getName()))
                        continue;
                    thi += i.getPlayers().size();
                }
                p.sendMessages(new String[] { "});
                        p.sendMessages(new String[] { " + total + " on-line em toda rede." });
                                p.sendMessages(new String[] { " + thi + " on-line neste servidor." });
                                        p.sendMessages(new String[] { "});
                                        }
                                }

                public static String getServer1(String s) {
                    String cha = String.valueOf(s.charAt(0));
                    String f = String.valueOf(String.valueOf(String.valueOf(String.valueOf(cha.toUpperCase())))) + s.substring(1) + " ";
                    if (s.contains("_")) {
                        String ant = s.split("_")[0];
                        String dps = s.split("_")[1];
                        char c = s.split("_")[1].charAt(0);
                        String c2 = String.valueOf(c);
                        if (isInt(c2)) {
                            f = String.valueOf(String.valueOf(String.valueOf(String.valueOf(cha.toUpperCase())))) + ant.substring(1) + " " + c;
                            return f;
                        }
                        String cha2 = String.valueOf(dps.charAt(0));
                        f = String.valueOf(String.valueOf(String.valueOf(String.valueOf(cha.toUpperCase())))) + ant.substring(1) + " " + cha2.toUpperCase() + dps.substring(1);
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

