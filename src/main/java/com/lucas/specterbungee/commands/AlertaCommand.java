package com.lucas.specterbungee.commands;

import br.com.smitecraft.bungee.utils.TitleAPI;
import java.util.Collection;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class AlertaCommand extends Command {
    public AlertaCommand() {
        super("alerta", "bgbc", new String[] { "alert" });
    }

    public void execute(CommandSender sender, String[] args) {
        if (!sender.hasPermission("legit.alert")) {
            sender.sendMessage("ntem permisspara executar este comando.");
            return;
        }
        if (args.length < 2) {
            sender.sendMessage("/alerta <chat/title> <mensagem> para enviar um alerta para todos os usu);
            return;
        }
        if (args.length > 1) {
            String message = "";
            for (int i = 1; i < args.length; i++)
                message = String.valueOf(String.valueOf(String.valueOf(message))) + args[i] + " ";
            if (args[0].equalsIgnoreCase("chat")) {
                ProxyServer.getInstance().broadcast(new net.md_5.bungee.api.chat.BaseComponent[0]);
                ProxyServer.getInstance().broadcast(");
                        ProxyServer.getInstance().broadcast(" + message.replace("&", "));
                ProxyServer.getInstance().broadcast(");
                        ProxyServer.getInstance().broadcast(new net.md_5.bungee.api.chat.BaseComponent[0]);
            } else if (args[0].equalsIgnoreCase("title")) {
                String title = message.replace("&", ");
                        Collection<ProxiedPlayer> playerCollection = ProxyServer.getInstance().getPlayers();
                if (message.contains("<nl>")) {
                    title = message.split("<nl>")[0];
                    String subtitle = message.split("<nl>")[1];
                    for (ProxiedPlayer on : playerCollection)
                        TitleAPI.sendTitle(on, title, subtitle);
                } else {
                    for (ProxiedPlayer on2 : playerCollection)
                        TitleAPI.sendTitle(on2, title, "");
                }
            }
        }
    }
}

