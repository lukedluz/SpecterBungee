package com.lucas.specterbungee.commands;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import com.lucas.specterbungee.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Comando_Go extends Command {
	public static ArrayList<String> tello = new ArrayList<String>();
	public static HashMap<String, String> tell = new HashMap<String, String>();

	public Comando_Go() {
		super("go");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		if (!(sender instanceof ProxiedPlayer)) {
			return;
		}
		if (!sender.hasPermission("specter.go")) {
			sender.sendMessage("§cVocê não tem permissão para executar este comando.");
		}
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (args.length == 0) {
			sender.sendMessage("§cUtilize /go <usuário>.");
			return;
		}
		if (args.length >= 1) {
			String targetNick = args[0];
			ProxiedPlayer target = Main.getInstance().getProxy().getPlayer(targetNick);
			if (p.getName().equalsIgnoreCase(targetNick)) {
				p.sendMessage("§cVocê não pode teleportar para você mesmo.");
				return;
			}
			if (Main.getInstance().getProxy().getPlayer(targetNick) == null) {
				p.sendMessage("§cEste usuário não está on-line.");
				return;
			}
			if (p.getServer().getInfo().getName().contains(target.getServer().getInfo().getName())) {
				p.sendMessage("§cVocê já se encontra no mesmo servidor do usuário.");
				return;
			}
	        if (p.getServer().getAddress().getPort() == target.getServer().getAddress().getPort()) {
	            p.sendMessage("§aTeleportando para " + target.getName() + "...");
	            ByteArrayDataOutput out = ByteStreams.newDataOutput();
	            out.writeUTF("GOCHANNEL");
	            out.writeUTF(p.getName());
	            target.sendData("GOCHANNEL", out.toByteArray());
	        }
	        else {
	            p.sendMessage("§aTeleportando para " + target.getName() + "...");
	            p.connect(target.getServer().getInfo());
	            ByteArrayDataOutput out = ByteStreams.newDataOutput();
	            out.writeUTF("GOCHANNEL");
	            out.writeUTF("TP");
	            target.sendData("GOCHANNEL", out.toByteArray());
	        }
		}
	}
}
