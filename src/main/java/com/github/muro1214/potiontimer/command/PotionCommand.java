package com.github.muro1214.potiontimer.command;

import org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import com.github.muro1214.potiontimer.scheduler.NotifyTiming;

public class PotionCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!(sender instanceof Player)) {
      return false;
    }

    if (args.length == 0) {
      displayCurrentEffectDuration((Player) sender);
      return true;
    }

    if (args[0].equals("timer")) {
      int sec;
      if (args.length == 1) {
        sec = NotifyTiming.getDefaultSeconds();
      } else if (args.length == 2) {
        sec = NumberUtils.toInt(args[1], NotifyTiming.getDefaultSeconds());
      } else {
        return false;
      }

      NotifyTiming.setSeconds(sec);
      sender.sendMessage(String.format("ポーションの効果が切れる %d 秒前に通知します", sec));
    }

    return true;
  }

  private void displayCurrentEffectDuration(Player player) {
    for (PotionEffect effect : player.getActivePotionEffects()) {
      player.sendMessage(String.format("%s, Remaining = %d sec", effect.getType().getName(),
          (int)(effect.getDuration() / 20)));
    }
  }
}
