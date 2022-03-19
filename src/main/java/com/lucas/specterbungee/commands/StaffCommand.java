package com.lucas.specterbungee.commands;

import br.com.smitecraft.bungee.Main;
import java.util.ArrayList;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class StaffCommand extends Command {
    public static ArrayList<String> cstaff = new ArrayList<>();

    public StaffCommand() {
        super("s");
    }

    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer)sender;
        if (!p.hasPermission("legit.chatstaff")) {
            sender.sendMessage("ntem permisspara executar este comando.");
            return;
        }
        if (args.length == 0) {
            p.sendMessage("/s <mensagem> para enviar uma mensagem para toda a staff.");
            return;
        }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("ativar")) {
                if (!cstaff.contains(p.getName())) {
                    p.sendMessage("chat da staff jestativado.");
                    return;
                }
                cstaff.remove(p.getName());
                p.sendMessage("da staff ativado!");
                return;
            }
            if (args[0].equalsIgnoreCase("desativar")) {
                if (cstaff.contains(p.getName())) {
                    p.sendMessage("chat da staff jestdesativado.");
                    return;
                }
                cstaff.add(p.getName());
                p.sendMessage("da staff desativado!");
                return;
            }
        }
        if (args.length > 0) {
            String message = "";
            String[] arrayOfString = args;
            int i = args.length;
            for (byte b = 0; b < i; b = (byte)(b + 1)) {
                String part = arrayOfString[b];
                if (message != "")
                    message = String.valueOf(String.valueOf(String.valueOf(String.valueOf(message)))) + " ";
                message = String.valueOf(String.valueOf(String.valueOf(String.valueOf(message)))) + part;
            }
            String tag = null;
            if (p.hasPermission("legit.ceo")) {
                tag = ";
            } else if (p.hasPermission("legit.diretor")) {
                tag = ";
            } else if (p.hasPermission("legit.gerente")) {
                tag = ";
            } else if (p.hasPermission("legit.admin")) {
                tag = ";
            } else if (p.hasPermission("legit.moderador")) {
                tag = ";
            } else if (p.hasPermission("legit.ajudante")) {
                tag = ";
            }
            if (tag == null) {
                p.sendMessage("me parece que ocorreu um erro ao enviar sua mensagem, por favor, contate seus superiores.");
                return;
            }
            for (String s : Main.getInstance().getProxy().getServers().keySet()) {
                ServerInfo serverInfo = (ServerInfo)Main.getInstance().getProxy().getServers().get(s);
                for (ProxiedPlayer todos : serverInfo.getPlayers()) {
                    if (todos.hasPermission("legit.chatstaff")) {
                        if (!cstaff.contains(todos.getName()))
                            todos.sendMessage("+ p.getServer().getInfo().getName() + "] " + tag + " " + p.getName() + ": + message);
                        if (!cstaff.contains(todos.getName()))
                            continue;
                        if (!todos.getName().equals(p.getName()))
                            continue;
                        todos.sendMessage("+ p.getServer().getInfo().getName() + "] " + tag + " " + p.getName() + ": + message);
                    }
                }
            }
        }
    }
}
