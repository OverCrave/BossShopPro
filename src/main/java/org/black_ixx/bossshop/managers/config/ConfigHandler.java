package org.black_ixx.bossshop.managers.config;

import org.black_ixx.bossshop.BossShop;
import org.black_ixx.bossshop.managers.ClassManager;
import org.black_ixx.bossshop.settings.Settings;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigHandler {

    // /////////////////////////////////////// <- Init class

    public ConfigHandler(BossShop plugin) {
        Settings settings = ClassManager.manager.getSettings();
        FileConfiguration config = plugin.getConfig();

        if (config.getBoolean("signs.enabled") || config.getBoolean("EnableSigns")) {
            settings.setSignsEnabled(true);
        }

        String main = config.getString("MainShop");
        settings.setMainShop(main.toLowerCase());
        settings.setTransactionLogEnabled(config.getBoolean("EnableTransactionLog"));
        settings.setServerPingingSpeed((config.getInt("ServerPinging.Delay")));
        settings.setServerPingingTimeout((config.getInt("ServerPinging.Timeout")));
        settings.setServerPingingWaitTime((config.getInt("ServerPinging.WaitTimeAfterFail")));
        settings.setServerPingingFixConnector((config.getBoolean("ServerPinging.FixConnector")));
        settings.setAutoRefreshSpeed((config.getInt("AutoRefreshDelay")));
        settings.setMetricsEnabled((!config.getBoolean("DisableMetrics")));
        settings.setLoadSubfoldersEnabled(config.getBoolean("SearchSubfoldersForShops"));
        settings.setServerPingingEnabled(config.getBoolean("ServerPinging.Enabled"));
        settings.setInventoryFullDropItems(config.getBoolean("InventoryFullDropItems"));
        settings.setMaxLineLength(config.getInt("MaxLineLength"));
        settings.setCheckStackSize(config.getBoolean("CheckStackSize"));
        settings.setDebugEnabled(config.getBoolean("Debug"));
        settings.setItemAllShowFinalReward(config.getBoolean("SellAllPlaceholderShowFinalReward"));
        settings.setPurchaseAsyncEnabled(config.getBoolean("AsynchronousActions"));
        settings.setExpUseLevel(config.getBoolean("ExpUseLevels"));
        settings.setAllowSellingDamagedItems(config.getBoolean("AllowSellingDamagedItems"));
        settings.setInputTimeout(config.getInt("InputTimeout"));

        if (config.getBoolean("BungeeCord")) {
            settings.setBungeeCordServerEnabled(true); //Do it that way because maybe in config it is set to false but still required and enabled by something else
        }

        if (config.getBoolean("MoneyDisplay.Enabled")) {
            settings.setMoneyFormatting(config.getStringList("MoneyDisplay.List"));
        }
        if (config.getBoolean("PointsDisplay.Enabled")) {
            settings.setPointsFormatting(config.getStringList("PointsDisplay.List"));
        }
        settings.setNumberLocale(config.getString("NumberDisplay.Locale"));
        settings.setNumberGroupingSize(config.getInt("NumberDisplay.GroupingSize"));
        settings.loadConfig(config);
    }


}
