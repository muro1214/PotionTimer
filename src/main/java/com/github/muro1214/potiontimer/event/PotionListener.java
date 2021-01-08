package com.github.muro1214.potiontimer.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.muro1214.potiontimer.potion.PotionInfo;
import com.github.muro1214.potiontimer.potion.PotionResolver;
import com.github.muro1214.potiontimer.scheduler.NotifyTiming;
import com.github.muro1214.potiontimer.scheduler.PotionTimer;

public class PotionListener implements Listener {
  private JavaPlugin plugin;

  public PotionListener(JavaPlugin plugin) {
    this.plugin = plugin;
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler
  public void onPotionDrink(PlayerItemConsumeEvent e) {
    Player player = e.getPlayer();

    // 手持ちアイテムがポーションではない場合、何もしない
    if (e.getItem().getType() != Material.POTION) {
      return;
    }

    PotionMeta potionMeta = (PotionMeta) e.getItem().getItemMeta();
    PotionInfo potionInfo = PotionResolver.resolve(potionMeta);

    if(!potionInfo.hasDuration()) {
      return;
    }

    player.sendMessage(String.format("[%s] 効果時間 = %d 秒, 通知 = 終了 %d 秒前",
        potionInfo.getName(), potionInfo.getDuration(), NotifyTiming.getSeconds()));

    PotionTimer timer = new PotionTimer(player, potionInfo.getName(),
        potionInfo.getDuration() - NotifyTiming.getSeconds());
    timer.setTask(timer.runTaskTimer(plugin, 0L, 20L));
  }
}
