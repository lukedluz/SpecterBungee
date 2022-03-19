package com.lucas.specterbungee.commands;

import br.com.smitecraft.bungee.utils.Address;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class InfoCommand extends Command {
    public InfoCommand() {
        super("check");
    }

    public void execute(CommandSender sender, String[] args) {
        if (!sender.hasPermission("legit.check")) {
            sender.sendMessage("ntem permisspara executar este comando.");
            return;
        }
        if (args.length == 0) {
            sender.sendMessage("/check <usu);
            return;
        }
        if (args.length != 1)
            return;
        ProxiedPlayer p = ProxyServer.getInstance().getPlayer(args[0]);
        if (p == null) {
            sender.sendMessage("usunestonline.");
            return;
        }
        sender.sendMessage(");
                sender.sendMessage(" + p.getName());
                        sender.sendMessage(" + p.getAddress().getAddress().getHostAddress());
                                sender.sendMessage(" + p.getPing() + "ms");
                                        sender.sendMessage(" conectado: + Address.getAddres(p));
                                                sender.sendMessage(" conectado: + p.getServer().getInfo().getName());
                                                        sender.sendMessage(");
    }
}
