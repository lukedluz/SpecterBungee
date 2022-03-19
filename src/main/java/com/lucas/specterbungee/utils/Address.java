package com.lucas.specterbungee.utils;

import net.md_5.bungee.api.connection.PendingConnection;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Address {
    public static String getAddres(ProxiedPlayer player) {
        PendingConnection pc = player.getPendingConnection();
        try {
            Object handshake = pc.getClass().getMethod("getHandshake", new Class[0]).invoke(pc, new Object[0]);
            String host = (String)handshake.getClass().getMethod("getHost", new Class[0]).invoke(handshake, new Object[0]);
            return host;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
