package com.lucas.specterbungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class Comando_Cores extends Command {

	public Comando_Cores(){
		super("cores");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		sendMessage(sender, "");
		sendMessage(sender, "§a&a Verde Claro");
		sendMessage(sender, "§b&b Azul Claro");
		sendMessage(sender, "§c&c Vermelho Claro");
		sendMessage(sender, "§d&d Rosa");
		sendMessage(sender, "§e&e Amarelo");
		sendMessage(sender, "§f&f Branco");
		sendMessage(sender, "§0&0 Preto");
		sendMessage(sender, "§1&1 Azul Escuro");
		sendMessage(sender, "§2&2 Verde Escuro");
		sendMessage(sender, "§3&3 Ciano");
		sendMessage(sender, "§4&4 Vermelho");
		sendMessage(sender, "§5&5 Roxo");
		sendMessage(sender, "§6&6 Dourado");
		sendMessage(sender, "§7&7 Cinza");
		sendMessage(sender, "§8&8 Cinza Escuro");
		sendMessage(sender, "§9&9 Azul Mar");
		sendMessage(sender, "");
	}
	
	@SuppressWarnings("deprecation")
	public void sendMessage(CommandSender sender, String message){
		TextComponent text = new TextComponent();
		text.setText(message);
		sender.sendMessage(message);
	}
}
