package com.lucas.specterbungee.commands;

import br.com.smitecraft.bungee.Main;
import java.util.HashMap;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class StCommand extends Command {
    public StCommand() {
        super("st");
    }

    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer)sender;
        if (!p.hasPermission("legit.equipe")) {
            sender.sendMessage("ntem permisspara executar este comando.");
            return;
        }
        if (args.length == 0) {
            p.sendMessage(");
                    p.sendMessage("Staffers online no momento:");
            HashMap<ProxiedPlayer, String> ceo = new HashMap<>();
            HashMap<ProxiedPlayer, String> diretor = new HashMap<>();
            HashMap<ProxiedPlayer, String> gerente = new HashMap<>();
            HashMap<ProxiedPlayer, String> admin = new HashMap<>();
            HashMap<ProxiedPlayer, String> moderador = new HashMap<>();
            HashMap<ProxiedPlayer, String> ajudante = new HashMap<>();
            for (String s : Main.getInstance().getProxy().getServers().keySet()) {
                ServerInfo i = (ServerInfo)Main.getInstance().getProxy().getServers().get(s);
                for (ProxiedPlayer todos : i.getPlayers()) {
                    if (!todos.hasPermission("legit.equipe"))
                        continue;
                    int che = 0;
                    if (todos.hasPermission("legit.chatceo") && che <= 0) {
                        ceo.put(todos, todos.getName());
                        che = 1;
                    }
                    if (todos.hasPermission("legit.chatdiretor") && che <= 0) {
                        diretor.put(todos, todos.getName());
                        che = 1;
                    }
                    if (todos.hasPermission("legit.chatgerente") && che <= 0) {
                        gerente.put(todos, todos.getName());
                        che = 1;
                    }
                    if (todos.hasPermission("legit.chatadmin") && che <= 0) {
                        admin.put(todos, todos.getName());
                        che = 1;
                    }
                    if (todos.hasPermission("legit.chatmoderador") && che <= 0) {
                        moderador.put(todos, todos.getName());
                        che = 1;
                    }
                    if (!todos.hasPermission("legit.chatajudante"))
                        continue;
                    if (che > 0)
                        continue;
                    ajudante.put(todos, todos.getName());
                    che = 1;
                }
            }
            for (ProxiedPlayer todos2 : ceo.keySet()) {
                String ch = "";
                if (StaffCommand.cstaff.contains(todos2.getName()))
                    ch = "OFF)";
                p.sendMessage(" " + getTag("legit.ceo") + " " + todos2.getName() + " + todos2.getServer().getInfo().getName() + ") " + ch);
            }
            for (ProxiedPlayer todos2 : diretor.keySet()) {
                String ch = "";
                if (StaffCommand.cstaff.contains(todos2.getName()))
                    ch = "OFF)";
                p.sendMessage(" " + getTag("legit.diretor") + " " + todos2.getName() + " + todos2.getServer().getInfo().getName() + ") " + ch);
            }
            for (ProxiedPlayer todos2 : gerente.keySet()) {
                String ch = "";
                if (StaffCommand.cstaff.contains(todos2.getName()))
                    ch = "OFF)";
                p.sendMessage(" " + getTag("legit.gerente") + " " + todos2.getName() + " + todos2.getServer().getInfo().getName() + ") " + ch);
            }
            for (ProxiedPlayer todos2 : admin.keySet()) {
                String ch = "";
                if (StaffCommand.cstaff.contains(todos2.getName()))
                    ch = "OFF)";
                p.sendMessage(" " + getTag("legit.admin") + " " + todos2.getName() + " + todos2.getServer().getInfo().getName() + ") " + ch);
            }
            for (ProxiedPlayer todos2 : moderador.keySet()) {
                String ch = "";
                if (StaffCommand.cstaff.contains(todos2.getName()))
                    ch = "OFF)";
                p.sendMessage(" " + getTag("legit.moderador") + " " + todos2.getName() + " + todos2.getServer().getInfo().getName() + ") " + ch);
            }
            for (ProxiedPlayer todos2 : ajudante.keySet()) {
                String ch = "";
                if (StaffCommand.cstaff.contains(todos2.getName()))
                    ch = "OFF)";
                p.sendMessage(" " + getTag("legit.ajudante") + " " + todos2.getName() + " + todos2.getServer().getInfo().getName() + ") " + ch);
            }
            p.sendMessage(");
        }
    }

    public static String getTag(String grup) {
        if (grup.equalsIgnoreCase("legit.ceo")) {
            String tag = ";
            return ";
        }
        if (grup.equals("legit.diretor")) {
            String tag = ";
            return ";
        }
        if (grup.equals("legit.gerente")) {
            String tag = ";
            return ";
        }
        if (grup.equals("legit.admin")) {
            String tag = ";
            return ";
        }
        if (grup.equals("legit.moderador")) {
            String tag = ";
            return ";
        }
        if (grup.equals("legit.ajudante")) {
            String tag = ";
            return ";
        }
        return null;
    }

    public static String getServer1(String s) {
        String cha = String.valueOf(s.charAt(0));
        String f = String.valueOf(String.valueOf(String.valueOf(String.valueOf(cha.toUpperCase())))) + s.substring(1) + " 1";
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
