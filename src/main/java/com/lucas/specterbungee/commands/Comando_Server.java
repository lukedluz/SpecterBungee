package com.lucas.specterbungee.commands;

import com.lucas.specterbungee.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Comando_Server
extends Command {
    public Comando_Server() {
        super("server");
    }

    @SuppressWarnings({ "deprecation", "unused" })
	public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer)sender;
        if (!p.hasPermission("specter.server")) {
        	sender.sendMessage("§cVocê não tem permissão para executar este comando.");
            return;
        }
        if (args.length == 0) {
        	sender.sendMessage("§cUtilize /server <servidor> para se conectar a um servidor.");
            return;
        }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("listar")) {
                p.sendMessage("§1");
                p.sendMessage("§a Servidores conectados ao BungeeCord:");
                for (String s : Main.getInstance().getProxy().getServers().keySet()) {
                    ServerInfo i = (ServerInfo)Main.getInstance().getProxy().getServers().get(s);
                    p.sendMessage("§a  " + i.getName());
                }
                p.sendMessage("§2");
                return;
            }
            String servidor = args[0].toLowerCase();
            if ((ServerInfo)Main.getInstance().getProxy().getServers().get(servidor) == null) {
            	p.sendMessage("§cServidor não encontrado.");
                return;
            }
            ServerInfo ia;
            ServerInfo i = (ServerInfo)Main.getInstance().getProxy().getServers().get(servidor);
            if (i.equals((Object)(ia = p.getServer().getInfo()))) {
            	p.sendMessage("§cVocê já está conectado a este servidor.");
                return;
            }
            p.sendMessage("§aEnviando " + p.getName() + " para o servidor '" + i.getName().toLowerCase() + "'.");
            p.connect(i);
        }
        if (args.length == 2) {
            int ia = 0;
            ProxiedPlayer p1 = null;
            for (String s : Main.getInstance().getProxy().getServers().keySet()) {
                ServerInfo i = (ServerInfo)Main.getInstance().getProxy().getServers().get(s);
                for (ProxiedPlayer todos : i.getPlayers()) {
                    if (!todos.getName().equalsIgnoreCase(args[0])) continue;
                    p1 = todos;
                    ++ia;
                }
            }
            if (ia == 0) {
            	p.sendMessage("§cEste usuário não está on-line.");
                return;
            }
            String servidor = args[1].toLowerCase();
            if ((ServerInfo)Main.getInstance().getProxy().getServers().get(servidor) == null) {
            	p.sendMessage("§cServidor não encontrado.");
                return;
            }
            ServerInfo iaa;
            ServerInfo i = (ServerInfo)Main.getInstance().getProxy().getServers().get(servidor);
            if (i.equals((Object)(iaa = p1.getServer().getInfo()))) {
                p.sendMessage("§cEste usuário já está conectado a este servidor.");
                return;
            }
            p.sendMessage("§aEnviando " + p1.getName() + " para o servidor '" + i.getName().toLowerCase() + "'.");
            p1.connect(i);
        }
    }
}

