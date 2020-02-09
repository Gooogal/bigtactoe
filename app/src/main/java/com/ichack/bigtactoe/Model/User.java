package com.ichack.bigtactoe.Model;

import com.ichack.bigtactoe.Presenter.SquareState;

public class User {

  private final String name;
  private final int gameId;
  private final SquareState mark;

  public User(String name, int gameId, SquareState mark) {
    this.name = name;
    this.gameId = gameId;
    this.mark = mark;
  }

  public int getGameId() {
    return gameId;
  }

  public String getName() {
    return name;
  }

  public SquareState getMark() {
    return mark;
  }


}
