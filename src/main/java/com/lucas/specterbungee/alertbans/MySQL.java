package com.lucas.specterbungee.alertbans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.lucas.specterbungee.Main;

public class MySQL {
	
	private String user;
	private String host;
	private String database;
	private String password;
	public static Connection connection;
	static Statement statement;

	public MySQL(String user, String password, String host, String database, Main plugin) {
		this.user = user;
		this.password = password;
		this.host = host;
		this.database = database;
	}

    public void startConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://" + this.host + "/" + this.database, this.user, this.password);
			statement = connection.createStatement();
			statement.execute("CREATE TABLE IF NOT EXISTS MOTDGlobal (Baixo VARCHAR(64) NOT NULL, Total VARCHAR(64) NOT NULL)");
			statement.execute("CREATE TABLE IF NOT EXISTS ContasAPI (Nome VARCHAR(16) NOT NULL, Nick VARCHAR(16) NOT NULL, Prefs VARCHAR(16) NOT NULL)");
			statement.execute("CREATE TABLE IF NOT EXISTS ManutencaoGlobal (PORTA int(16) NOT NULL, VALOR VARCHAR(100) NOT NULL)");
			statement.execute("CREATE TABLE IF NOT EXISTS Punish (ID int(16) NOT NULL,Nome VARCHAR(16) NOT NULL,Nick VARCHAR(16) NOT NULL,Tipo VARCHAR(16) NOT NULL,Motivo VARCHAR(64) NOT NULL,Autor VARCHAR(16) NOT NULL,Prova VARCHAR(100) NOT NULL,Data VARCHAR(16) NOT NULL,Fim VARCHAR(100) NOT NULL,DataF VARCHAR(100) NOT NULL,Ativo VARCHAR(16) NOT NULL)");
			statement.execute("CREATE TABLE IF NOT EXISTS ContadorPunish (Servidor VARCHAR(16) NOT NULL, Punish int(16) NOT NULL)");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
