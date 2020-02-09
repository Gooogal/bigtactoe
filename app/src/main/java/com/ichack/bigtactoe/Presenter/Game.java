package com.ichack.bigtactoe.Presenter;

public class Game {
  public BigTable bigTable;
  private BigSquareState currPlayer;

  private int bigI = -1;
  private int bigJ = -1;

  public Game() {
    this.bigTable = new BigTable();
    this.currPlayer = BigSquareState.PLAYERX;
  }

  private boolean isMoveValid(int i, int j, int givenBigI, int givenBigJ) {
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

    switch_player();

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
