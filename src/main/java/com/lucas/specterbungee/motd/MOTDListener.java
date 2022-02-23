package com.lucas.specterbungee.motd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lucas.specterbungee.alertbans.MySQL;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class MOTDListener implements Listener {
	
	public static boolean manuglobal = false;
	public static String baixo = "";

	@SuppressWarnings("deprecation")
	@EventHandler(priority = 64)
	public static void aoPingar(ProxyPingEvent e) {
		ServerPing r = e.getResponse();
		ServerPing.Players p = r.getPlayers();
		ServerPing.PlayerInfo[] pi = { new ServerPing.PlayerInfo("§eloja.redespecter.xyz", "1") };
		p = new ServerPing.Players(500, p.getOnline(), pi);
		String motd = getBaixo().replace("&", "§");
		ServerPing ping = new ServerPing(r.getVersion(), p, "&f&lREDE &b&lSPECTER &7(1.8 á 1.16)".replace("&", "§") + "\n" + motd, r.getFaviconObject());
		if (taManuGlobal()) {
			ping.setVersion(new ServerPing.Protocol("§4MANUTENÇãO", 1));
		}
		e.setResponse(ping);
	}

	public static String getBaixo() {
		if (baixo != "") {
			return baixo;
		}
		return "§ejogar.redespecter.xyz";
	}

	public static void carregarInfos() {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM MOTDGlobal");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String valor = rs.getString("Baixo");
				baixo = valor;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int i = 0;
		int a = 0;
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM ManutencaoGlobal");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String valor = rs.getString("VALOR");
				i++;
				if (valor.equals("ON")) {
					a++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == a) {
			manuglobal = true;
		}
	}

	public static void setarTotalManu() {
		manuglobal = true;
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("UPDATE MOTDGlobal SET Total = ?");
			ps.setString(1, "MANU");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void removerTotalManu() {
		manuglobal = false;
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("UPDATE MOTDGlobal SET Total = ?");
			ps.setString(1, "SEM");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean dadosExistem() {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM MOTDGlobal");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void adicionarDados() {
		String baixopadrao = "§aR. Lure §eem desenvolvimento §a▌▌▌▌▌▌▌▌§7▌▌ §a85%";
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("INSERT INTO MOTDGlobal (Baixo,Total) VALUES (?,?);");
			ps.setString(1, baixopadrao);
			ps.setString(2, "SEM");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean taManuGlobal() {
		return manuglobal;
	}

	public static void setarBaixo(String args) {
		baixo = args;
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("UPDATE MOTDGlobal SET Baixo = ?");
			ps.setString(1, args);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
