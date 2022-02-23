package com.lucas.specterbungee.alertbans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Manager {
	
	public static boolean checarContaExiste(String nome) {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM ContasAPI WHERE Nome=?");
			ps.setString(1, nome.toLowerCase());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean checarPrefs(String nome, String tipo) {
		if (tipo.equals("TELL")) {
			try {
				PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM ContasAPI WHERE Nome=?");
				ps.setString(1, nome.toLowerCase());
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					String[] prefs = rs.getString("Prefs").split(";");
					int i = Integer.valueOf(prefs[0]).intValue();
					if (i == 1) {
						return true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (tipo.equals("VANISH")) {
			try {
				PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM ContasAPI WHERE Nome=?");
				ps.setString(1, nome.toLowerCase());
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					String[] prefs = rs.getString("Prefs").split(";");
					int i = Integer.valueOf(prefs[4]).intValue();
					if (i == 1) {
						return true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static Integer pegarPrefs(String nome, String tipo) {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM ContasAPI WHERE Nome=?");
			ps.setString(1, nome.toLowerCase());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String[] prefs = rs.getString("Prefs").split(";");
				if (tipo.equals("TELL")) {
					int i = Integer.valueOf(prefs[0]).intValue();
					return Integer.valueOf(i);
				}
				if (tipo.equals("GLOBAL")) {
					int i = Integer.valueOf(prefs[1]).intValue();
					return Integer.valueOf(i);
				}
				if (tipo.equals("TPA")) {
					int i = Integer.valueOf(prefs[2]).intValue();
					return Integer.valueOf(i);
				}
				if (tipo.equals("COINS")) {
					int i = Integer.valueOf(prefs[3]).intValue();
					return Integer.valueOf(i);
				}
				if (tipo.equals("VANISH")) {
					int i = Integer.valueOf(prefs[4]).intValue();
					return Integer.valueOf(i);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean checarLocExiste(String loc) {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM LocationsAPI WHERE Nome=?");
			ps.setString(1, loc.toLowerCase());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String pegarNomePlayer(String nome) {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM ContasAPI WHERE Nome=?");
			ps.setString(1, nome.toLowerCase());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString("Nick");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void setarPrefs(String nome, int a, int b, int c, int d, int v) {
		String awe = a + ";" + b + ";" + c + ";" + d + ";" + v;
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("UPDATE ContasAPI SET Prefs = ? WHERE Nome = ?;");
			ps.setString(1, awe);
			ps.setString(2, nome.toLowerCase());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Integer getContador() {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM ContadorPunish WHERE Servidor = ?");
			ps.setString(1, "global");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("Punish");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void AddContador() {
		Integer i = 1 + getContador();
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("UPDATE ContadorPunish SET Punish = ? WHERE Servidor = ?;");
			ps.setInt(1, i);
			ps.setString(2, "global");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int getSize(String table, String from, String uuid, String get) {
		int count = 0;
		ResultSet rs = null;
		try {
			PreparedStatement statement = MySQL.connection.prepareStatement("SELECT * FROM " + table + " ORDER BY ID");
			rs = statement.executeQuery();
			while (rs.next()) {
				count++;
			}
		} catch (SQLException e) {
		}
		return count;
	}

}
