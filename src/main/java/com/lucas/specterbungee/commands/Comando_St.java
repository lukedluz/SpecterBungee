package com.lucas.specterbungee.commands;

import net.alpenblock.bungeeperms.BungeePerms;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Comando_St
extends Command {
    public Comando_St() {
        super("st");
    }
    
    @SuppressWarnings("deprecation")
	public void execute(final CommandSender sender, final String[] args) {
        if (!sender.hasPermission("specter.stafflist")) {
            sender.sendMessage("§cVocê precisa do grupo Gerente ou superior para executar este comando.");
        }
        else {
            int on = 0;
            sender.sendMessage("");
            sender.sendMessage("§eEquipe online:");
            sender.sendMessage("");
            for (final ProxiedPlayer staffers2 : ProxyServer.getInstance().getPlayers()) {
                if (BungeePerms.getInstance().getPermissionsManager().getUser(staffers2.getName()).getGroups().contains(BungeePerms.getInstance().getPermissionsManager().getGroup("Direcao"))) {
                    sender.sendMessage(" §f- " + this.colorize(BungeePerms.getInstance().getPermissionsManager().getUser(staffers2.getName()).buildPrefix()) + staffers2.getName() + "§f (" + staffers2.getServer().getInfo().getName().replaceAll("-", " ") + ")");
                    ++on;
                }
            }
            for (final ProxiedPlayer staffers3 : ProxyServer.getInstance().getPlayers()) {
                if (BungeePerms.getInstance().getPermissionsManager().getUser(staffers3.getName()).getGroups().contains(BungeePerms.getInstance().getPermissionsManager().getGroup("SubDirecao"))) {
                    sender.sendMessage(" §f- " + this.colorize(BungeePerms.getInstance().getPermissionsManager().getUser(staffers3.getName()).buildPrefix()) + staffers3.getName() + "§f (" + staffers3.getServer().getInfo().getName().replaceAll("-", " ") + ")");
                    ++on;
                }
            }
            for (final ProxiedPlayer staffers4 : ProxyServer.getInstance().getPlayers()) {
                if (BungeePerms.getInstance().getPermissionsManager().getUser(staffers4.getName()).getGroups().contains(BungeePerms.getInstance().getPermissionsManager().getGroup("Gerente"))) {
                    sender.sendMessage(" §f- " + this.colorize(BungeePerms.getInstance().getPermissionsManager().getUser(staffers4.getName()).buildPrefix()) + staffers4.getName() + "§f (" + staffers4.getServer().getInfo().getName().replaceAll("-", " ") + ")");
                    ++on;
                }
            }
            for (final ProxiedPlayer staffers5 : ProxyServer.getInstance().getPlayers()) {
                if (BungeePerms.getInstance().getPermissionsManager().getUser(staffers5.getName()).getGroups().contains(BungeePerms.getInstance().getPermissionsManager().getGroup("Administracao"))) {
                    sender.sendMessage(" §f- " + this.colorize(BungeePerms.getInstance().getPermissionsManager().getUser(staffers5.getName()).buildPrefix()) + staffers5.getName() + "§f (" + staffers5.getServer().getInfo().getName().replaceAll("-", " ") + ")");
                    ++on;
                }
            }
            for (final ProxiedPlayer staffers6 : ProxyServer.getInstance().getPlayers()) {
                if (BungeePerms.getInstance().getPermissionsManager().getUser(staffers6.getName()).getGroups().contains(BungeePerms.getInstance().getPermissionsManager().getGroup("Moderacao"))) {
                    sender.sendMessage(" §f- " + this.colorize(BungeePerms.getInstance().getPermissionsManager().getUser(staffers6.getName()).buildPrefix()) + staffers6.getName() + "§f (" + staffers6.getServer().getInfo().getName().replaceAll("-", " ") + ")");
                    ++on;
                }
            }
            for (final ProxiedPlayer staffers7 : ProxyServer.getInstance().getPlayers()) {
                if (BungeePerms.getInstance().getPermissionsManager().getUser(staffers7.getName()).getGroups().contains(BungeePerms.getInstance().getPermissionsManager().getGroup("ModGC"))) {
                    sender.sendMessage(" §f- " + this.colorize(BungeePerms.getInstance().getPermissionsManager().getUser(staffers7.getName()).buildPrefix()) + staffers7.getName() + "§f (" + staffers7.getServer().getInfo().getName().replaceAll("-", " ") + ")");
                    ++on;
                }
            }
            for (final ProxiedPlayer staffers8 : ProxyServer.getInstance().getPlayers()) {
                if (BungeePerms.getInstance().getPermissionsManager().getUser(staffers8.getName()).getGroups().contains(BungeePerms.getInstance().getPermissionsManager().getGroup("Suporte"))) {
                    sender.sendMessage(" §f- " + this.colorize(BungeePerms.getInstance().getPermissionsManager().getUser(staffers8.getName()).buildPrefix()) + staffers8.getName() + "§f (" + staffers8.getServer().getInfo().getName().replaceAll("-", " ") + ")");
                    ++on;
                }
            }
            for (final ProxiedPlayer staffers9 : ProxyServer.getInstance().getPlayers()) {
                if (BungeePerms.getInstance().getPermissionsManager().getUser(staffers9.getName()).getGroups().contains(BungeePerms.getInstance().getPermissionsManager().getGroup("Estagiario"))) {
                    sender.sendMessage(" §f- " + this.colorize(BungeePerms.getInstance().getPermissionsManager().getUser(staffers9.getName()).buildPrefix()) + staffers9.getName() + "§f (" + staffers9.getServer().getInfo().getName().replaceAll("-", " ") + ")");
                    ++on;
                }
            }
            if (on == 0) {
                sender.sendMessage(" §cNão há nenhum membro da staff online.");
            }
            sender.sendMessage("");
        }
    }
    
    public String colorize(final String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
