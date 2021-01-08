package com.github.muro1214.potiontimer.scheduler;

public class NotifyTiming {
  private static final int DEFAULT_SEC = 30;

  private static int seconds = DEFAULT_SEC;

  public static int getSeconds() {
    return seconds;
  }

  public static void setSeconds(int seconds) {
    NotifyTiming.seconds = seconds;
  }

  public static int getDefaultSeconds() {
    return DEFAULT_SEC;
  }
}
