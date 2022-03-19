package com.lucas.specterbungee.commands;

import br.com.smitecraft.bungee.Main;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import java.util.ArrayList;
import java.util.HashMap;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class GoCommand extends Command {
    public static ArrayList<String> tello = new ArrayList<>();

    public static HashMap<String, String> tell = new HashMap<>();

    public GoCommand() {
        super("go");
    }

    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer))
            return;
        if (!sender.hasPermission("smite.go")) {
            sender.sendMessage("ntem permisspara executar este comando.");
            return;
        }
        ProxiedPlayer p = (ProxiedPlayer)sender;
        if (args.length == 0) {
            sender.sendMessage("/go <usu);
            return;
        }
        if (args.length >= 1) {
            String targetNick = args[0];
            ProxiedPlayer target = Main.getInstance().getProxy().getPlayer(targetNick);
            if (p.getName().equalsIgnoreCase(targetNick)) {
                p.sendMessage("npode teleportar para vocmesmo.");
                return;
            }
            if (Main.getInstance().getProxy().getPlayer(targetNick) == null) {
                p.sendMessage("usuneston-line.");
                return;
            }
            if (p.getServer().getInfo().getName().contains(target.getServer().getInfo().getName())) {
                p.sendMessage("jse encontra no mesmo servidor do usu);
                return;
            }
            if (p.getServer().getAddress().getPort() == target.getServer().getAddress().getPort()) {
                p.sendMessage("para " + target.getName() + "...");
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("GOCHANNEL");
                out.writeUTF(p.getName());
                target.sendData("GOCHANNEL", out.toByteArray());
            } else {
                p.sendMessage("para " + target.getName() + "...");
                p.connect(target.getServer().getInfo());
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("GOCHANNEL");
                out.writeUTF("TP");
                target.sendData("GOCHANNEL", out.toByteArray());
            }
        }
    }
}
