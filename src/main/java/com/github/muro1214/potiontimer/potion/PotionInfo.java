package com.github.muro1214.potiontimer.potion;

public class PotionInfo {
  private String name;
  private int duration;

  public PotionInfo(String name, int duration) {
    this.name = name;
    this.duration = duration;
  }

  public String getName() {
    return name;
  }

  public int getDuration() {
    return duration;
  }

  public boolean hasDuration() {
    return duration > 0;
  }
}
