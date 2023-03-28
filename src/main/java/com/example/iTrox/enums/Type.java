package com.example.iTrox.enums;

public enum Type {
  COMMERCIAL("COMMERCIAL"),
  GOVERNMENT("GOVERNMENT");

  private final String type;

  Type(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
