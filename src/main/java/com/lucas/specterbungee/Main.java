package com.lucas.specterbungee;


import net.md_5.bungee.api.plugin.Plugin;

public final class Main extends Plugin {
    
    private static Main instance;

    public Main() {
        instance = this;
    }

    public static Main getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        getProxy().getPluginManager().registerCommand(this, (Command)new ClearChatCommand());
        getProxy().getPluginManager().registerCommand(this, (Command)new AlertaCommand());
        getProxy().getPluginManager().registerCommand(this, (Command)new InfoCommand());
        getProxy().getPluginManager().registerCommand(this, (Command)new YtCommand());
        getProxy().getPluginManager().registerCommand(this, (Command)new StCommand());
        getProxy().getPluginManager().registerCommand(this, (Command)new OnlineCommand());
        getProxy().getPluginManager().registerCommand(this, (Command)new StaffCommand());
        getProxy().getPluginManager().registerCommand(this, (Command)new ServerCommand());
        getProxy().getPluginManager().registerCommand(this, (Command)new FindCommand());
        getProxy().getPluginManager().registerCommand(this, (Command)new GoCommand());
        for (String s : getInstance().getProxy().getServers().keySet()) {
            ServerInfo i = (ServerInfo)getInstance().getProxy().getServers().get(s);
            i.getAddress().getPort();
        }
    }


}
