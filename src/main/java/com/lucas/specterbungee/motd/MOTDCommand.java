package com.lucas.specterbungee.motd;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class MOTDCommand extends Command {
	
	public MOTDCommand() {
		super("motd");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (!p.hasPermission("specter.motd")) {
			sender.sendMessage("§cVocê não tem permissão para executar este comando.");
			return;
		}
		if (args.length == 0) {
			sender.sendMessage("§cUtilize /motd <MOTD> para editar a MOTD do servidor.");

			return;
		}
		if (args.length > 0) {
			String message = "";
			String[] arrayOfString;
			int j = (arrayOfString = args).length;
			for (int i = 0; i < j; i++) {
				String part = arrayOfString[i];
				if (message != "") {
					message = message + " ";
				}
				message = message + part;
			}
			message = message.replace("&", "§");
			MOTDListener.setarBaixo(message);
			p.sendMessage("§aVocê alterou a MOTD do servidor.");
			return;
		}
	}
}
