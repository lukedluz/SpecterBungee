package com.lucas.specterbungee.manutencao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lucas.specterbungee.alertbans.MySQL;
import com.lucas.specterbungee.Main;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;

public class ManutencaoListener implements Listener {
	
	public static boolean checarTotalOn() {
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
			return true;
		}
		return false;
	}

	public static boolean checarOn(int port) {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM ManutencaoGlobal WHERE PORTA=?");
			ps.setInt(1, port);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String valor = rs.getString("VALOR");
				if (valor.equals("ON")) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean checarExiste(int port) {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM ManutencaoGlobal WHERE PORTA=?");
			ps.setInt(1, port);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void registrarServer(int port) {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("INSERT INTO ManutencaoGlobal (PORTA,VALOR) VALUES (?,?);");
			ps.setInt(1, port);
			ps.setString(2, "OFF");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static void findandkick(int port) {
		for (String s : Main.getInstance().getProxy().getServers().keySet()) {
			ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
			int port1 = i.getAddress().getPort();
			if (port == port1) {
				for (ProxiedPlayer p : i.getPlayers()) {
					if (!p.hasPermission("specter.equipe")) {
						p.disconnect("§f§lREDE &b&lSPECTER\n§cServidor entrou em modo §lManutenção§c.");
					}
				}
			}
		}
	}

	public static void setarOn(int port) {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("UPDATE ManutencaoGlobal SET VALOR = ? WHERE PORTA = ?;");
			ps.setString(1, "ON");
			ps.setInt(2, port);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void setarOff(int port) {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("UPDATE ManutencaoGlobal SET VALOR = ? WHERE PORTA = ?;");
			ps.setString(1, "OFF");
			ps.setInt(2, port);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
