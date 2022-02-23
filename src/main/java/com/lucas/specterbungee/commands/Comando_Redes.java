package com.lucas.specterbungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Comando_Redes extends Command {

	public Comando_Redes() {
		super("redes", "site");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender cs, String[] args) {
		if (cs instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer) cs;
			p.sendMessage("§1");
			p.sendMessage("§eAcessos úteis do servidor:");
			p.sendMessage("§fTwitter: §7https://twitter.com/RedeSpecterOfc/");
			p.sendMessage("§fDiscord: §7https://discord.redespecter.xyz/");
			p.sendMessage("§fSite: §7https://loja.redespecter.xyz/");
			p.sendMessage("§2");
			return;
		}
	}
}
