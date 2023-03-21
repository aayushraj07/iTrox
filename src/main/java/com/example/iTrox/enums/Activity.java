package com.example.iTrox.enums;

public enum Activity {
  LIKED("LIKED"),
  SAVED("SAVED"),
  UNLIKED("UNLIKED"),
  NONE("NONE");

  private final String activity;

  Activity(String activity) {
    this.activity = activity;
  }

  public String getActivity() {
    return activity;
  }
}
