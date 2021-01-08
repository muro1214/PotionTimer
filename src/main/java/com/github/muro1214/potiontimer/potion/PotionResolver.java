package com.github.muro1214.potiontimer.potion;

import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;

public class PotionResolver {

  private PotionResolver() {
  }

  public static PotionInfo resolve(PotionMeta potionMeta) {
    PotionType type = potionMeta.getBasePotionData().getType();
    boolean isExtended = potionMeta.getBasePotionData().isExtended();
    boolean isUpgraded = potionMeta.getBasePotionData().isUpgraded();

    switch (type) {
    case AWKWARD:
      return new PotionInfo("奇妙なポーション", 0);
    case FIRE_RESISTANCE:
      return new PotionInfo("耐火のポーション", isExtended ? 480 : 180);
    case INSTANT_DAMAGE:
      if (isUpgraded) {
        return new PotionInfo("負傷のポーションⅡ", 0);
      } else {
        return new PotionInfo("負傷のポーション", 0);
      }
    case INSTANT_HEAL:
      if (isUpgraded) {
        return new PotionInfo("治癒のポーションⅡ", 0);
      } else {
        return new PotionInfo("治癒のポーション", 0);
      }
    case INVISIBILITY:
      return new PotionInfo("透明化のポーション", isExtended ? 480 : 180);
    case JUMP:
      if (isUpgraded) {
        return new PotionInfo("跳躍のポーションⅡ", 90);
      } else {
        return new PotionInfo("跳躍のポーション", isExtended ? 480 : 180);
      }
    case LUCK:
      return new PotionInfo("幸運のポーション", 300);
    case MUNDANE:
      return new PotionInfo("ありふれたポーション", 0);
    case NIGHT_VISION:
      return new PotionInfo("暗視のポーション", isExtended ? 480 : 180);
    case POISON:
      if (isUpgraded) {
        return new PotionInfo("毒のポーションⅡ", 22);
      } else {
        return new PotionInfo("毒のポーション", isExtended ? 90 : 45);
      }
    case REGEN:
      if (isUpgraded) {
        return new PotionInfo("再生のポーションⅡ", 22);
      } else {
        return new PotionInfo("再生のポーション", isExtended ? 90 : 45);
      }
    case SLOWNESS:
      if (isUpgraded) {
        return new PotionInfo("鈍化のポーション Ⅳ", 20);
      } else {
        return new PotionInfo("鈍化のポーション", isExtended ? 240 : 90);
      }
    case SLOW_FALLING:
      return new PotionInfo("低速落下のポーション", isExtended ? 240 : 90);
    case SPEED:
      if (isUpgraded) {
        return new PotionInfo("俊敏のポーションⅡ", 90);
      } else {
        return new PotionInfo("俊敏のポーション", isExtended ? 480 : 180);
      }
    case STRENGTH:
      if (isUpgraded) {
        return new PotionInfo("力のポーションⅡ", 90);
      } else {
        return new PotionInfo("力のポーション", isExtended ? 480 : 180);
      }
    case THICK:
      return new PotionInfo("濃厚なポーション", 0);
    case TURTLE_MASTER:
      if (isUpgraded) {
        return new PotionInfo("タートルマスターのポーションⅡ", 20);
      } else {
        return new PotionInfo("タートルマスターのポーション", isExtended ? 40 : 20);
      }
    case UNCRAFTABLE:
      return new PotionInfo("醸造不可能なポーション", 0);
    case WATER:
      return new PotionInfo("水入り瓶", 0);
    case WATER_BREATHING:
      return new PotionInfo("水中呼吸のポーション", isExtended ? 480 : 180);
    case WEAKNESS:
      return new PotionInfo("弱化のポーション", isExtended ? 240 : 90);
    default:
      return new PotionInfo("未登録", 0);
    }
  }
}
