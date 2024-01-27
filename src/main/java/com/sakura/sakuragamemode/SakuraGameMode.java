package com.sakura.sakuragamemode;

import org.bukkit.plugin.java.JavaPlugin;

public final class SakuraGameMode extends JavaPlugin {

    public static SakuraGameMode javaPlugin;

    @Override
    public void onEnable() {
        getLogger().info("[SakuraGameMode]已启动");
        saveDefaultConfig();
        javaPlugin = this;
        getCommand("gms").setExecutor(new commands());
        getCommand("gmsp").setExecutor(new commands());
        if (getConfig().getBoolean("enable")){

            getLogger().info("SakuraGameMode]Have been successfully initialize");
        }else {
            getLogger().info("[SakuraGameMode]配置文件已将插件关闭");
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
