package com.lucas.specterbungee;

import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

import com.lucas.specterbungee.alertbans.Manager;
import com.lucas.specterbungee.alertbans.MySQL;
import com.lucas.specterbungee.manutencao.ManutencaoCommand;
import com.lucas.specterbungee.manutencao.ManutencaoListener;
import com.lucas.specterbungee.motd.MOTDCommand;
import com.lucas.specterbungee.motd.MOTDListener;
import com.lucas.specterbungee.utils.PlayerCommandPreProcessListeners;
import com.lucas.specterbungee.commands.Comando_Alerta;
import com.lucas.specterbungee.commands.Comando_Bunker;
import com.lucas.specterbungee.commands.Comando_ClearChat;
import com.lucas.specterbungee.commands.Comando_Cores;
import com.lucas.specterbungee.commands.Comando_Denunciar;
import com.lucas.specterbungee.commands.Comando_Find;
import com.lucas.specterbungee.commands.Comando_Go;
import com.lucas.specterbungee.commands.Comando_Grupo;
import com.lucas.specterbungee.commands.Comando_Info;
import com.lucas.specterbungee.commands.Comando_Lobby;
import com.lucas.specterbungee.commands.Comando_Online;
import com.lucas.specterbungee.commands.Comando_Patrao;
import com.lucas.specterbungee.commands.Comando_Punir;
import com.lucas.specterbungee.commands.Comando_Redes;
import com.lucas.specterbungee.commands.Comando_Regras;
import com.lucas.specterbungee.commands.Comando_Send;
import com.lucas.specterbungee.commands.Comando_Server;
import com.lucas.specterbungee.commands.Comando_St;
import com.lucas.specterbungee.commands.Comando_Staff;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Plugin;
import org.bukkit.Bukkit;

public class Main extends Plugin {
	
	public static MySQL sql;
	private static Main instance;

	public Main() {
		Main.instance = this;
	}

	public static Main getInstance() {
		return instance;
	}

	@SuppressWarnings("deprecation")
	public void onEnable() {

		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§7==========================");
		Bukkit.getConsoleSender().sendMessage("§7| §bSpecterBungee          §7|");
		Bukkit.getConsoleSender().sendMessage("§7| §bVersão 1.0             §7|");
		Bukkit.getConsoleSender().sendMessage("§7| §fStatus: §aLigado       §7|");
		Bukkit.getConsoleSender().sendMessage("§7==========================");
		Bukkit.getConsoleSender().sendMessage("");

		instance = this;
		getProxy().getPluginManager().registerCommand(this, new Comando_Redes());
		getProxy().getPluginManager().registerCommand(this, new Comando_Regras());
		getProxy().getPluginManager().registerCommand(this, new Comando_Denunciar());
		getProxy().getPluginManager().registerCommand(this, new Comando_ClearChat());
		getProxy().getPluginManager().registerCommand(this, new Comando_Send());
		getProxy().getPluginManager().registerCommand(this, new Comando_Alerta());
		getProxy().getPluginManager().registerCommand(this, new Comando_Cores());
		getProxy().getPluginManager().registerCommand(this, new Comando_Find());
		getProxy().getPluginManager().registerCommand(this, new Comando_Grupo());
		getProxy().getPluginManager().registerCommand(this, new Comando_Info());
		getProxy().getPluginManager().registerCommand(this, new Comando_Online());
		getProxy().getPluginManager().registerCommand(this, new Comando_Lobby());
		getProxy().getPluginManager().registerCommand(this, new Comando_Staff());
		getProxy().getPluginManager().registerCommand(this, new Comando_St());
		getProxy().getPluginManager().registerCommand(this, new Comando_Server());
		getProxy().getPluginManager().registerCommand(this, new ManutencaoCommand());
		getProxy().getPluginManager().registerCommand(this, new MOTDCommand());
		getProxy().getPluginManager().registerCommand(this, new Comando_Bunker());
		getProxy().getPluginManager().registerCommand(this, new Comando_Go());
		getProxy().getPluginManager().registerCommand(this, new Comando_Patrao());
		getProxy().getPluginManager().registerCommand(this, new Comando_Punir());
		getProxy().getPluginManager().registerListener(this, new MOTDListener());
		getProxy().getPluginManager().registerListener(this, new ManutencaoListener());
		getProxy().getPluginManager().registerListener(this, new PlayerCommandPreProcessListeners());
		getRecentlyTweets();
		getProxy().registerChannel("PatraoChannel");
		getProxy().registerChannel("MutePunish");
		getProxy().registerChannel("GOCHANNEL");

		setupSQL();
		if (!MOTDListener.dadosExistem()) {
			MOTDListener.adicionarDados();
		}
		MOTDListener.carregarInfos();
		for (String s : getInstance().getProxy().getServers().keySet()) {
			ServerInfo i = (ServerInfo) getInstance().getProxy().getServers().get(s);
			int port = i.getAddress().getPort();
			if (!ManutencaoListener.checarExiste(port)) {
				ManutencaoListener.registrarServer(port);
				getInstance().getProxy().getConsole().sendMessage("§aServidor §b'" + i.getName() + "' §aregistrado no sistema de manutenção.");
			}
		}
	}

	public void getRecentlyTweets() {
		getProxy().getScheduler().schedule(this, new Runnable() {
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
					ProxyServer.getInstance().broadcast(" ");
					ProxyServer.getInstance().broadcast("§6§lPUNIÇÕES APLICADAS");
					ProxyServer.getInstance().broadcast("§8 § §fForam punidos §a" + NumberFormat.getIntegerInstance().format(Manager.getContador()) + " §fusuários até o momento.");
					ProxyServer.getInstance().broadcast("§8 § §fUtilize §a/denunciar §fe ajude-nos nesse combate.");
					ProxyServer.getInstance().broadcast(" ");
			}
		}, 10, 10, TimeUnit.MINUTES);
	}

	public void setupSQL() {
		String user = "u14_h4SW4CRmx1";
		String password = "G^DH9d8mv0Beg2Fy2Eaa!Lyf";
		String host = "51.81.69.7";
		String database = "s14_bungee";
		(Main.sql = new MySQL(user, password, host, database, this)).startConnection();
	}
}
