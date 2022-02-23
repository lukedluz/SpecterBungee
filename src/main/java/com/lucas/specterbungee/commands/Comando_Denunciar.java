package com.lucas.specterbungee.commands;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;

public class Comando_Denunciar extends Command implements TabExecutor {

	public static HashMap<String, Date> delay = new HashMap<String, Date>();

	public Comando_Denunciar() {
		super("denuncia", "", "denunciar");
	}

	@SuppressWarnings("deprecation")
	public static void yourself(ProxiedPlayer P) {
		P.sendMessage("§cVocê não pode denunciar você mesmo.");
	}

	@SuppressWarnings("deprecation")
	public static void offline(ProxiedPlayer P, String targetname) {
		P.sendMessage("§cEste usuário não está on-line.");
	}

	@SuppressWarnings({ "deprecation" })
	public void execute(CommandSender cs, String[] args) {
		if (cs instanceof ProxiedPlayer) {
			ProxiedPlayer player = (ProxiedPlayer) cs;
			if (args.length < 2) {
				player.sendMessage("§cUtilize /denunciar <usuário> <motivo>.");
				return;
			}
			String Targetname = args[0];
			ProxiedPlayer pls = BungeeCord.getInstance().getPlayer(Targetname);
			if (pls == null) {
				offline(player, Targetname);
				return;
			}
			if (pls == player) {
				yourself(player);
				return;
			}
			if (pls.hasPermission("specter.punir")) {
				player.sendMessage("§cVocê n§o tem permiss§o para Denunciar este usu§rio.");
				return;
			}
			if (args.length > 1) {
				if (delay.containsKey(player.getName())) {
					Date now = new Date();
					if (now.after(delay.get(player.getName()))) {
						delay.remove(player.getName());
					} else {
						player.sendMessage("§cAguarde um pouco para enviar uma Denúncia novamente.");
						return;
					}
				}
				StringBuilder sb = new StringBuilder();
				for (int i = 1; i < args.length; ++i) {
					sb.append(args[i]).append(" ");
				}
				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("PatraoChannel");
				out.writeUTF("Toque");
				String allArgs = sb.toString().trim();
				for (ProxiedPlayer pls2 : BungeeCord.getInstance().getPlayers()) {
					if (pls2.hasPermission("specter.punir")) {
						pls2.getServer().sendData("PatraoChannel", out.toByteArray());
						pls2.sendMessage("§1");
						pls2.sendMessage("§e§l Denúncia");
						pls2.sendMessage(" §e" + args[0] + " foi Denunciado por " + player.getName() + ".");
						pls2.sendMessage(" §eMotivo: " + allArgs);
						pls2.sendMessage(" §eServidor: " + player.getServer().getInfo().getName().replaceAll("Lobby", "Lobby").replaceAll("RankUPL", "R. Lure").replaceAll("Testes", "Servidor de Testes"));
						pls2.sendMessage("§2");
					}
				}
				player.sendMessage("§a * Você denunciou o usu§rio §7" + args[0] + "§a. Um membro de nossa equipe foi notificado e o comportamento desde usuário será analisado em breve.");
				player.sendMessage("§1");
				player.sendMessage("§a * O uso abusivo deste comando poderá resultar em punição.");
				if (delay.containsKey(player.getName())) {
					delay.remove(player.getName());
				}
				Date na = new Date();
				na.setSeconds(na.getSeconds() + 30);
				delay.put(player.getName(), na);
			}
		}
	}

	public Iterable<String> onTabComplete(CommandSender cs, String[] args) {
		if (args.length <= 2) {
		}
		Set<String> match = new HashSet<String>();
		if (args.length == 1) {
			String search = args[0].toLowerCase();
			for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
				if (player.getName().toLowerCase().startsWith(search)) {
					match.add(player.getName());
				}
			}
		}
		return match;
	}
}
