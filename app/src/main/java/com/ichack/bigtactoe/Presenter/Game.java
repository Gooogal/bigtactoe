package com.ichack.bigtactoe.Presenter;

public class Game {
  private BigTable bigTable;
  private BigSquareState currPlayer;

  private int bigI;
  private int bigJ;

  public Game() {
    this.bigTable = new BigTable();
    this.currPlayer = BigSquareState.PLAYERX;
  }

  public void makeMove(int i, int j) {
    SquareState squareState;

    if (currPlayer == BigSquareState.PLAYERX) {
      squareState = SquareState.PLAYERX;
    } else {
      squareState = SquareState.PLAYER0;
    }

    bigTable.applyMove(bigI, bigJ, i, j, squareState);

  }

  public void play() {
    while (!bigTable.isGameFinished()) {
      int i = 0;
      int j = 0;
      // Get move somehow;

      if (bigI == -1 && bigJ == -1) {
        // ToDO: handle free choice
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

      if (bigTable.isSubGameDone(i, j) != BigSquareState.UNKNOWN) {
        bigI = -1;
        bigJ = -1;
      }

      // ToDo: Handle player sent to completed game
    }

    BigSquareState winner = bigTable.getGameWinner();

    // ToDo: return winner
  }
}
