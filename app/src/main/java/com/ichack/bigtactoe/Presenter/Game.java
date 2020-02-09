package com.ichack.bigtactoe.Presenter;

import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Game {
  public BigTable bigTable;
  private BigSquareState currPlayer;
  private int gameId = 0;
  private SquareState onlinePlayer = SquareState.EMPTY;

  private static String URL = "cloud-vm-43-80.doc.ic.ac.uk:8080/";
  private final OkHttpClient client = new OkHttpClient();

  private int bigI = -1;
  private int bigJ = -1;

  public int getBigI() {
    return bigI;
  }

  public int getBigJ() {
    return bigJ;
  }

  public Game() {
    this.bigTable = new BigTable();
    this.currPlayer = BigSquareState.PLAYERX;
  }

  public Game(int gameId, SquareState onlinePlayer) {
    this();
    this.gameId = gameId;
    this.onlinePlayer = onlinePlayer;
    initialWait();
  }

  private void initialWait() {
    RequestBody requestBody = new FormBody.Builder().add("game_id", String.valueOf(gameId)).build();
    Request request = new Request.Builder()
        .url(URL + "wait/")
        .post(requestBody)
        .build();

    try {
      Response response = client.newCall(request).execute();
      if (onlinePlayer == SquareState.PLAYER0) {
        int coords = Integer.parseInt(response.body().string());
        int bigI = coords / 1000;
        int bigJ = (coords / 100) % 10;
        int i = (coords / 10) % 10;
        int j = coords % 10;
        makeMove(i, j, bigI, bigJ);
      }
    } catch (IOException e) {

    }

  }

  private boolean isMoveValid(int i, int j, int givenBigI, int givenBigJ) {
    if (bigTable.isGameFinished()) {
      return false;
    }

    if (givenBigI != bigI || givenBigJ != bigJ) {
      return false;
    }

    return bigTable.bigTable[bigI][bigJ].isMoveValid(i, j);
  }

  public SquareState makeMove(int i, int j, int givenBigI, int givenBigJ) {
    if (bigI == -1 && bigJ == -1) {
      bigI = givenBigI;
      bigJ = givenBigJ;
    }

    if (!isMoveValid(i, j, givenBigI, givenBigJ)) {
      return SquareState.EMPTY;
    }

    SquareState squareState;

    if (currPlayer == BigSquareState.PLAYERX) {
      squareState = SquareState.PLAYERX;
    } else {
      squareState = SquareState.PLAYER0;
    }

    bigTable.applyMove(bigI, bigJ, i, j, squareState);

    bigI = i;
    bigJ = j;

    if (bigTable.isSubGameDone(bigI, bigJ) != BigSquareState.UNKNOWN) {
      bigI = -1;
      bigJ = -1;
    }

    if ((currPlayer == BigSquareState.PLAYERX && onlinePlayer == SquareState.PLAYERX) ||
    (currPlayer == BigSquareState.PLAYER0 && onlinePlayer == SquareState.PLAYER0)) {
      BigSquareState win = bigTable.getGameWinner();
      boolean won = !(win == BigSquareState.UNKNOWN);
      String p;
      if (onlinePlayer == SquareState.PLAYERX) {
        p = "0";
      } else {
        p = "1";
      }
      String mv = String.valueOf(1000 * bigI + 100 * bigJ + 10 * i + j);
      RequestBody requestBody = new FormBody.Builder().add("game_id", String.valueOf(gameId))
          .add("player", p)
          .add("move", mv)
          .add("game_over", String.valueOf(won)).build();
      Request request = new Request.Builder()
          .url(URL + "move/")
          .post(requestBody)
          .build();

      try {
        Response response = client.newCall(request).execute();
        int coords = Integer.parseInt(response.body().string());
        int newbigI = coords / 1000;
        int newbigJ = (coords / 100) % 10;
        int newi = (coords / 10) % 10;
        int newj = coords % 10;
        switch_player();
        makeMove(newi, newj, newbigI, newbigJ);
      }
       catch (IOException e) {

      }
    } else {
      switch_player();
    }

    return squareState;
  }

  private void switch_player() {
    if (currPlayer == BigSquareState.PLAYERX) {
      currPlayer = BigSquareState.PLAYER0;
    } else {
      currPlayer = BigSquareState.PLAYERX;
    }
  }
}
