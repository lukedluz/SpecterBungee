package com.lucas.specterbungee.commands;

import br.com.smitecraft.bungee.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ServerCommand extends Command {
    public ServerCommand() {
        super("server");
    }

    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer)sender;
        if (!p.hasPermission("smite.server")) {
            sender.sendMessage("ntem permisspara executar este comando.");
            return;
        }
        if (args.length == 0) {
            sender.sendMessage("/server <servidor> para se conectar a um servidor.");
            return;
        }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("listar")) {
                p.sendMessage(");
                        p.sendMessage("Servidores conectados ao BungeeCord:");
                for (String s : Main.getInstance().getProxy().getServers().keySet()) {
                    ServerInfo serverInfo = (ServerInfo)Main.getInstance().getProxy().getServers().get(s);
                    p.sendMessage(" " + serverInfo.getName());
                }
                p.sendMessage(");
                return;
            }
            String servidor = args[0].toLowerCase();
            if (Main.getInstance().getProxy().getServers().get(servidor) == null) {
                p.sendMessage("nencontrado.");
                return;
            }
            ServerInfo i = (ServerInfo)Main.getInstance().getProxy().getServers().get(servidor);
            ServerInfo ia;
            if (i.equals(ia = p.getServer().getInfo())) {
                p.sendMessage("jestconectado a este servidor.");
                return;
            }
            p.sendMessage("" + p.getName() + " para o servidor '" + i.getName().toLowerCase() + "'.");
            p.connect(i);
        }
        if (args.length == 2) {
            int ia2 = 0;
            ProxiedPlayer p2 = null;
            for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
                ServerInfo serverInfo2 = (ServerInfo)Main.getInstance().getProxy().getServers().get(s2);
                for (ProxiedPlayer todos : serverInfo2.getPlayers()) {
                    if (!todos.getName().equalsIgnoreCase(args[0]))
                        continue;
                    p2 = todos;
                    ia2++;
                }
            }
            if (ia2 == 0) {
                p.sendMessage("usunestonline.");
                return;
            }
            String servidor2 = args[1].toLowerCase();
            if (Main.getInstance().getProxy().getServers().get(servidor2) == null) {
                p.sendMessage("nencontrado.");
                return;
            }
            ServerInfo j = (ServerInfo)Main.getInstance().getProxy().getServers().get(servidor2);
            ServerInfo iaa;
            if (j.equals(iaa = p2.getServer().getInfo())) {
                p.sendMessage("usujestconectado a este servidor.");
                return;
            }
            p.sendMessage("" + p2.getName() + " para o servidor '" + j.getName().toLowerCase() + "'.");
            p2.connect(j);
        }
    }
}
