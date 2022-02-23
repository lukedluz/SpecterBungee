package com.lucas.specterbungee.commands;

import java.util.ArrayList;
import java.util.List;

import com.lucas.specterbungee.alertbans.Manager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Comando_Punir extends Command {

	public Comando_Punir() {
		super("punir");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender.hasPermission("specter.punir")) {
			if (args.length == 0 || args.length == 1) {
				sender.sendMessage("§cUtilize /punir <usuário> <provas> para exibir os tipos de infrações.");
				return;
			} else if (args.length == 2) {
				if (!(sender instanceof ProxiedPlayer)) {
					sender.sendMessage("§cApenas jogadores in-game podem executar este comando.");
					return;
				}
				ProxiedPlayer p = (ProxiedPlayer) sender;
				String p2 = args[0];
				String url = args[1];
				if (!url.toLowerCase().contains("http://") && !url.toLowerCase().contains("https://")) {
					sender.sendMessage("§cInsira a prova para efetuar a punição.");
					return;
				}
				if (p2.equalsIgnoreCase("specter") || p2.equalsIgnoreCase("Craazy_Sx ")) {
					ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(),
							"ban " + p.getName() + " Abuso de bugs");
					return;
				}
				sendMotives(p, p2, url);
				return;
			} else if (args.length == 3) {
				if (!(sender instanceof ProxiedPlayer)) {
					sender.sendMessage("§cApenas jogadores in-game podem executar este comando.");
					return;
				}
				String p2 = args[0];
				String url = args[1];
				String motivo = args[2];
				if (!url.toLowerCase().contains("http://") && !url.toLowerCase().contains("https://")) {
					sender.sendMessage("§cInsira a prova para efetuar a punição.");
					return;
				}
				switch (motivo.toLowerCase()) {
				case "capslock":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempmute " + p2 + " 1h CapsLock - " + url);
					addBan();
					break;
				case "ajuda":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempmute " + p2 + " 3h Mal uso do /ajuda - " + url);
					addBan();
					break;
				case "reportarbug":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempmute " + p2 + " 3h Mal uso do /reportarbug - " + url);
					addBan();
					break;
				case "malusochat":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempmute " + p2 + " 3h Mal uso do chat/anuncio - " + url);
					addBan();
					break;
				case "spam":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempmute " + p2 + " 4h Spam - " + url);
					addBan();
					break;
				case "flood":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempmute " + p2 + " 4h Flood - " + url);
					addBan();
					break;
				case "palavrasinadequadas":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempmute " + p2 + " 4h Palavras inadequadas - " + url);
					addBan();
					break;
				case "iniciativadeflood":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempmute " + p2 + " 5h Iniciativa de Flood - " + url);
					addBan();
					break;
				case "iniciativadebriga":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempmute " + p2 + " 5h Iniciativa de Briga - " + url);
					addBan();
					break;
				case "chatfake":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempmute " + p2 + " 5h Chat Fake - " + url);
					addBan();
					break;
				case "ameaça":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempmute " + p2 + " 6h Ameaça - " + url);
					addBan();
					break;
				case "ofensaajogador":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempmute " + p2 + " 6h Ofensa a Jogador - " + url);
					addBan();
					break;
				case "divulgacaoindireta":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempmute " + p2 + " 3d Divulgação indireta - " + url);
					addBan();
					break;
				case "floodc":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempban " + p2 + " 6h Flood por comandos - " + url);
					addBan();
					break;
				case "desinformação":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempban " + p2 + " 1d Desinformação - " + url);
					addBan();
					break;
				case "skinimprópria":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempban " + p2 + " 3d Skin Imprópria - " + url);
					addBan();
					break;
				case "compartilhamentodeconta":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempban " + p2 + " 7d Compartilhamento de conta - " + url);
					addBan();
					break;
				case "antijogo":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempban " + p2 + " 7d AntiJogo - " + url);
					addBan();
					break;
				case "passarseporstaff":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempban " + p2 + " 10d Passar-se por staff - " + url);
					addBan();
					break;
				case "comercioexterno":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempban " + p2 + " 15d Comercio Externo - " + url);
					addBan();
					break;
				case "abusodebugs":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"tempban " + p2 + " 60d Abuso de Bugs - " + url);
					addBan();
					break;
				case "auxilioexterno":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"ban " + p2 + " Auxílio Externo - " + url);
					addBan();
					break;
				case "nickimpróprio":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"ban " + p2 + " Nick Impróprio - " + url);
					addBan();
					break;
				case "negartela":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"ban " + p2 + " Deslogar/Negar Pedido de Tela - " + url);
					addBan();
					break;
				case "ofensastaff":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"ban " + p2 + " Ofensa à Staff/Servidor - " + url);
					addBan();
					break;
				case "regedit":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"ban " + p2 + " Regedit - " + url);
					addBan();
					break;
				case "chantagem":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"ban " + p2 + " Chantagem/Suborno - " + url);
					addBan();
					break;
				case "modnãoautorizado":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"ban " + p2 + " Mod Não Autorizado - " + url);
					addBan();
					break;
				case "divulgação":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"ban " + p2 + " Divulgação - " + url);
					addBan();
					break;
				case "roubo":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"ban " + p2 + " Roubo - " + url);
					addBan();
					break;
				case "falsificação":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"ipban " + p2 + " Falsificação de Provas - " + url);
					addBan();
					break;
				case "discursodeódio":
					ProxyServer.getInstance().getPluginManager().dispatchCommand(sender,
							"ipban " + p2 + " Discurso de Ódio - " + url);
					addBan();
					break;
				}
			} else if (args.length > 3) {
				sender.sendMessage("§cUtilize /punir <usuário> <provas> para exibir os tipos de infrações.");
				return;
			}
		} else {
			sender.sendMessage("§cVocê precisa do grupo Moderação ou superior para executar este comando.");
			return;
		}
	}

	@SuppressWarnings("deprecation")
	public void sendMotives(ProxiedPlayer p, String p2, String url) {
		p.sendMessage("");
		p.sendMessage("§e Selecione um tipo de infração:");
		List<TextComponent> list = new ArrayList<>();

		TextComponent text1 = new TextComponent();
		text1.setText("§e ▪ §fCapsLock");
		text1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder("§r§7Tipo de punição: §aMute temporário" + "\n" + "\n§eClique para selecionar.")
						.create()));
		text1.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " CapsLock"));
		TextComponent textma = new TextComponent();
		textma.setText("§e ▪ §fMal uso do /ajuda");
		textma.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder("§r§7Tipo de punição: §aMute temporário" + "\n" + "\n§eClique para selecionar.")
						.create()));
		textma.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " ajuda"));
		TextComponent textrb = new TextComponent();
		textrb.setText("§e ▪ §fMal uso do /reportarbug");
		textrb.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder("§r§7Tipo de punição: §aMute temporário" + "\n" + "\n§eClique para selecionar.")
						.create()));
		textrb.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " reportarbug"));
		TextComponent textmac = new TextComponent();
		textmac.setText("§e ▪ §fMal uso do chat/anuncio");
		textmac.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder("§r§7Tipo de punição: §aMute temporário" + "\n" + "\n§eClique para selecionar.")
						.create()));
		textmac.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " malusochat"));
		TextComponent text2 = new TextComponent();
		text2.setText("§e ▪ §fSpam");
		text2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder("§r§7Tipo de punição: §aMute temporário" + "\n" + "\n§eClique para selecionar.")
						.create()));
		text2.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " spam"));
		TextComponent text3 = new TextComponent();
		text3.setText("§e ▪ §fFlood");
		text3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder("§r§7Tipo de punição: §aMute temporário" + "\n" + "\n§eClique para selecionar.")
						.create()));
		text3.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " flood"));
		TextComponent textpi = new TextComponent();
		textpi.setText("§e ▪ §fPalavras inadequadas");
		textpi.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder("§r§7Tipo de punição: §aMute temporário" + "\n" + "\n§eClique para selecionar.")
						.create()));
		textpi.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " palavrasinadequadas"));
		
		TextComponent text4 = new TextComponent();
		text4.setText("§e ▪ §fIniciativa de Flood");
		text4.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder("§r§7Tipo de punição: §aMute temporário" + "\n" + "\n§eClique para selecionar.")
						.create()));
		text4.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " iniciativadeflood"));
		TextComponent text5 = new TextComponent();
		text5.setText("§e ▪ §fIniciativa de Briga");
		text5.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder("§r§7Tipo de punição: §aMute temporário" + "\n" + "\n§eClique para selecionar.")
						.create()));
		text5.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " iniciativadebriga"));
		TextComponent text6 = new TextComponent();
		text6.setText("§e ▪ §fChat Fake");
		text6.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder("§r§7Tipo de punição: §aMute temporário" + "\n" + "\n§eClique para selecionar.")
						.create()));
		text6.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " chatfake"));
		TextComponent text7 = new TextComponent();
		text7.setText("§e ▪ §fAmeaça");
		text7.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder("§r§7Tipo de punição: §aMute temporário" + "\n" + "\n§eClique para selecionar.")
						.create()));
		text7.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " ameaça"));
		TextComponent text9 = new TextComponent();
		text9.setText("§e ▪ §fOfensa a Jogador");
		text9.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder("§r§7Tipo de punição: §aMute temporário" + "\n" + "\n§eClique para selecionar.")
						.create()));
		text9.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " ofensaajogador"));
		TextComponent text8 = new TextComponent();
		text8.setText("§e ▪ §fDivulgação indireta");
		text8.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder("§r§7Tipo de punição: §aMute temporário" + "\n" + "\n§eClique para selecionar.")
						.create()));
		text8.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " divulgacaoindireta"));
		TextComponent textflood = new TextComponent();
		textflood.setText("§e ▪ §fFlood por comandos");
		textflood.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento temporário" + "\n" + "\n§eClique para selecionar.")
								.create()));
		textflood.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " floodc"));
		TextComponent text10 = new TextComponent();
		text10.setText("§e ▪ §fDesinformação");
		text10.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento temporário" + "\n" + "\n§eClique para selecionar.")
								.create()));
		text10.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " desinformação"));
		TextComponent text11 = new TextComponent();
		text11.setText("§e ▪ §fSkin Imprópria");
		text11.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento temporário" + "\n" + "\n§eClique para selecionar.")
								.create()));
		text11.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " skinimprópria"));
		TextComponent text13 = new TextComponent();
		text13.setText("§e ▪ §fCompartilhamento de Conta");
		text13.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento temporário" + "\n" + "\n§eClique para selecionar.")
								.create()));
		text13.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND,
				"/punir " + p2 + " " + url + " compartilhamentodeconta"));
		TextComponent text14 = new TextComponent();
		text14.setText("§e ▪ §fAntiJogo");
		text14.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento temporário" + "\n" + "\n§eClique para selecionar.")
								.create()));
		text14.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " antijogo"));
		TextComponent text15 = new TextComponent();
		text15.setText("§e ▪ §fComercio Externo");
		text15.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento temporário" + "\n" + "\n§eClique para selecionar.")
								.create()));
		text15.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " comercioexterno"));
		TextComponent textps = new TextComponent();
		textps.setText("§e ▪ §fPassar-se por staff");
		textps.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento temporário" + "\n" + "\n§eClique para selecionar.")
								.create()));
		textps.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " passarseporstaff"));
		TextComponent text16 = new TextComponent();
		text16.setText("§e ▪ §fAbuso de Bugs");
		text16.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento temporário" + "\n" + "\n§eClique para selecionar.")
								.create()));
		text16.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " abusodebugs"));
		TextComponent text17 = new TextComponent();
		text17.setText("§e ▪ §fAuxílio Externo");
		text17.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento permanente" + "\n" + "\n§eClique para selecionar.")
								.create()));
		text17.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " auxilioexterno"));
		TextComponent text18 = new TextComponent();
		text18.setText("§e ▪ §fNick Impróprio");
		text18.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento permanente" + "\n" + "\n§eClique para selecionar.")
								.create()));
		text18.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " nickimpróprio"));
		TextComponent text19 = new TextComponent();
		text19.setText("§e ▪ §fDiscurso de Ódio");
		text19.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento permanente" + "\n" + "\n§eClique para selecionar.")
								.create()));
		text19.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " discursodeódio"));
		TextComponent text20 = new TextComponent();
		text20.setText("§e ▪ §fDeslogar/Negar Pedido de Tela");
		text20.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento permanente" + "\n" + "\n§eClique para selecionar.")
								.create()));
		text20.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " negartela"));
		TextComponent text21 = new TextComponent();
		text21.setText("§e ▪ §fOfensa à Staff/Servidor");
		text21.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento permanente" + "\n" + "\n§eClique para selecionar.")
								.create()));
		text21.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " ofensastaff"));
		TextComponent text22 = new TextComponent();
		text22.setText("§e ▪ §fRegedit");
		text22.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento permanente" + "\n" + "\n§eClique para selecionar.")
								.create()));
		text22.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " regedit"));
		TextComponent text23 = new TextComponent();
		text23.setText("§e ▪ §fChantagem/Suborno");
		text23.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento permanente" + "\n" + "\n§eClique para selecionar.")
								.create()));
		text23.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " chantagem"));
		TextComponent text24 = new TextComponent();
		text24.setText("§e ▪ §fMod Não Autorizado");
		text24.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento permanente" + "\n" + "\n§eClique para selecionar.")
								.create()));
		text24.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " modnãoautorizado"));
		TextComponent text25 = new TextComponent();
		text25.setText("§e ▪ §fDivulgação");
		text25.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento permanente" + "\n" + "\n§eClique para selecionar.")
								.create()));
		text25.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " divulgação"));
		TextComponent text26 = new TextComponent();
		text26.setText("§e ▪ §fRoubo");
		text26.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento permanente" + "\n" + "\n§eClique para selecionar.")
								.create()));
		text26.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " roubo"));
		TextComponent text27 = new TextComponent();
		text27.setText("§e ▪ §fFalsificação de Provas");
		text27.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder(
						"§r§7Tipo de punição: §aBanimento permanente por IP" + "\n" + "\n§eClique para selecionar.")
								.create()));
		text27.setClickEvent(
				new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + p2 + " " + url + " falsificação"));

		if (p.hasPermission("specter.punir.suporte")) {
			list.add(text1);
			list.add(textma);
			list.add(textrb);
			list.add(textmac);
			list.add(text2);
			list.add(text3);
			list.add(text4);
			list.add(textpi);
			list.add(text5);
			list.add(text6);
			list.add(text7);
			list.add(text9);
			list.add(text8);
		}
		if (p.hasPermission("specter.punir.moderacao")) {
			list.add(textflood);
			list.add(text10);
			list.add(text11);
			list.add(text13);
			list.add(text14);
			list.add(text15);
			list.add(textps);
			list.add(text16);
		}
		if (p.hasPermission("specter.punir.administracao")) {
			list.add(text17);
			list.add(text18);
			list.add(text20);
			list.add(text21);
			list.add(text22);
			list.add(text23);
			list.add(text24);
			list.add(text25);
			list.add(text26);
		}
		if (p.hasPermission("specter.punir.supervisao")) {
			list.add(text27);
			list.add(text19);
		}
		for (TextComponent text : list) {
			p.sendMessage(text);
		}
		p.sendMessage("");
	}

	public void addBan() {
		Manager.AddContador();
	}
}
