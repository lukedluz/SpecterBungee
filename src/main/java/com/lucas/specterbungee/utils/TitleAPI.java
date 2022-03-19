package com.lucas.specterbungee.utils;

public class TitleAPI {
    public static void sendTitle(ProxiedPlayer player, String title, String subtitle) {
        BungeeTitle packet = new BungeeTitle();
        packet.title(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', title)));
        packet.subTitle(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', subtitle)));
        packet.fadeIn(20);
        packet.fadeOut(10);
        packet.stay(10);
        packet.send(player);
    }
}
