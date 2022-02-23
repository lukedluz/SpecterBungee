package com.lucas.specterbungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Comando_Regras extends Command {

	public Comando_Regras() {
		super("regras");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender cs, String[] args) {
		if (cs instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer) cs;
			p.sendMessage("§1");
			p.sendMessage("§eTabela de Punições:");
			p.sendMessage("§eLeia as regras e evite ao máximo ingringi-las para que não");
			p.sendMessage("§eseja punido!");
			p.sendMessage("§2");
			p.sendMessage("  §7§l▪ §fCapsLock §8- §7Mutado por 1 hora");
			p.sendMessage("  §7§l▪ §fMal uso do /ajuda §8- §7Mutado por 3 hora");
			p.sendMessage("  §7§l▪ §fMal uso do /reportarbug §8- §7Mutado por 3 hora");
			p.sendMessage("  §7§l▪ §fMal uso do /anuncio §8- §7Mutado por 3 hora");
			p.sendMessage("  §7§l▪ §fMal uso do chat §8- §7Mutado por 3 hora");
			p.sendMessage("  §7§l▪ §fSpam §8- §7Mutado por 4 horas");
			p.sendMessage("  §7§l▪ §fFlood §8- §7Mutado por 4 horas");
			p.sendMessage("  §7§l▪ §fPalavras inadequadas §8- §7Mutado por 4 horas");
			p.sendMessage("  §7§l▪ §fIniciativa de Flood §8- §7Mutado por 5 horas");
			p.sendMessage("  §7§l▪ §fIniciativa de Briga §8- §7Mutado por 5 horas");
			p.sendMessage("  §7§l▪ §fChatFake §8- §7Mutado por 5 horas");
			p.sendMessage("  §7§l▪ §fAmeaa §8- §7Mutado por 6 horas");
			p.sendMessage("  §7§l▪ §fDivulgação indireta §8- §7Mutado por 3 dias");
			p.sendMessage("  §7§l▪ §fOfensa a jogador §8- §7Mutado por 6 horas");
			p.sendMessage("  §7§l▪ §fFlood por comandos §8- §7Banido por 6 horas");
			p.sendMessage("  §7§l▪ §fDesinformação §8- §7Banido por 1 dia");
			p.sendMessage("  §7§l▪ §fSkin imprópria §8- §7Banido por 3 dias");
			p.sendMessage("  §7§l▪ §fCompartilhamento de conta §8- §7Banido por 7 dias");
			p.sendMessage("  §7§l▪ §fPassar-se por staff §8- §7Banido por 10 dias");
			p.sendMessage("  §7§l▪ §fComércio externo §8- §7Banido por 15 dias");
			p.sendMessage("  §7§l▪ §fAbuso de Bugs §8- §7Banido por 60 dias");
			p.sendMessage("  §7§l▪ §fAuxílio externo §8- §7Banido permanentemente");
			p.sendMessage("  §7§l▪ §fNickname impróprio §8- §7Banido permanentemente");
			p.sendMessage("  §7§l▪ §fDeslogar/negar pedido de tela §8- §7Banido permanentemente");
			p.sendMessage("  §7§l▪ §fOfensa a staff/servidor §8- §7Banido permanentemente");
			p.sendMessage("  §7§l▪ §fRegedit §8- §7Banido permanentemente");
			p.sendMessage("  §7§l▪ §fChantagem/suborno §8- §7Banido permanentemente");
			p.sendMessage("  §7§l▪ §fUso de mods não autorizados §8- §7Banido permanentemente");
			p.sendMessage("  §7§l▪ §fDivulgação §8- §7Banido permanentemente");
			p.sendMessage("  §7§l▪ §fRoubo §8- §7Banido permanentemente");
			p.sendMessage("  §7§l▪ §fEstorno de Pagamento §8- §7Banido por IP permanentemente");
			p.sendMessage("  §7§l▪ §fFalsificação de provas §8- §7Banido por IP permanentemente");
			p.sendMessage("  §7§l▪ §fDiscurso de ódio §8- §7Banido por IP permanentemente");
			p.sendMessage("§3");
			p.sendMessage("§cEssas regras podem ser alteradas § qualquer momento,");
			p.sendMessage("§cportanto, fique atento");
			p.sendMessage("§cUltima atualiza§§o: §l15/01/2022.");
			p.sendMessage("§4");
			return;
		}
	}
}
