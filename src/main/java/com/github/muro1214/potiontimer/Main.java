package com.github.muro1214.potiontimer;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.muro1214.potiontimer.command.PotionCommand;
import com.github.muro1214.potiontimer.event.PotionListener;

public class Main extends JavaPlugin {

  @Override
  public void onEnable() {
    getLogger().info("plugin enabled.");

    getCommand("pt").setExecutor(new PotionCommand());
    new PotionListener(this);
  }
}
