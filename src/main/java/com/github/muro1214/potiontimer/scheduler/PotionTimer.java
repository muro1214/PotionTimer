package com.github.muro1214.potiontimer.scheduler;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import net.md_5.bungee.api.ChatColor;

public class PotionTimer extends BukkitRunnable {
  private Player player;
  private String potionName;
  private int seconds;
  private BukkitTask task;

  public PotionTimer(Player player, String potionName, int seconds) {
    this.player = player;
    this.potionName = potionName;
    this.seconds = seconds;
  }

  @Override
  public void run() {
    if (seconds <= 0) {
      player.sendMessage(ChatColor.RED +
          String.format("%s が %d 秒後に切れます", potionName, NotifyTiming.getSeconds()));
      player.getServer().getScheduler().cancelTask(task.getTaskId());
    }

    seconds--;
  }

  public void setTask(BukkitTask task) {
    this.task = task;
  }
}
