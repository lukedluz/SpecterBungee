package com.lucas.specterbungee.config;

import java.io.IOException;

import com.lucas.specterbungee.Main;
import net.md_5.bungee.config.*;

public class Settings {

	public String host, user, password, database;
	protected static YamlConfig config;
	public static Configuration configuration;

	public Settings() {
		config = null;
		try {
			(config = new YamlConfig("config.yml", Main.getInstance())).saveDefaultConfig();
			config.loadConfig();
			configuration = config.getConfig();
			loadConfig();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void saveConfig() {
		try {
			config.saveConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean loadConfig() {
		if (configuration == null) {
			return false;
		}
		host = configuration.getString("mysql.host");
		user = configuration.getString("mysql.user");
		password = configuration.getString("mysql.password");
		database = configuration.getString("mysql.database");
		return true;
	}
}
