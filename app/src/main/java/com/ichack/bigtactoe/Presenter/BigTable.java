package com.ichack.bigtactoe.Presenter;

public class BigTable {
  private Table[][] bigTable;
  private BigSquareState[][] status;

  public BigTable() {
    this.bigTable = new Table[4][4];
    this.status = new BigSquareState[4][4];

    for (int i = 1; i <= 3 ; i++) {
      for (int j = 1; j <= 3; j++) {
        bigTable[i][j] = new Table();
        status[i][j] = BigSquareState.UNKNOWN;
      }
    }
  }

  public BigSquareState isSubGameDone(int i, int j) {
    return status[i][j];
  }

  private BigSquareState getLineWinner(int index) {
    if (status[index][1] != BigSquareState.UNKNOWN &&
        status[index][1] != BigSquareState.BLOCKED &&
        status[index][1] == status[index][2] &&
        status[index][1] == status[index][3]) {
      return status[index][1];
    }

    return BigSquareState.UNKNOWN;
  }

  private BigSquareState getColumnWinner(int index) {
    if (status[1][index] != BigSquareState.UNKNOWN &&
        status[1][index] != BigSquareState.BLOCKED &&
        status[1][index] == status[2][index] &&
        status[1][index] == status[3][index]) {
      return status[1][index];
    }

    return BigSquareState.UNKNOWN;
  }

  private BigSquareState getFirstDiagonalWinner() {
    if(status[1][1] != BigSquareState.UNKNOWN &&
        status[1][1] != BigSquareState.BLOCKED &&
        status[1][1] == status[2][2] &&
        status[1][1] == status[3][3]) {
      return status[1][1];
    }

    return BigSquareState.UNKNOWN;
  }

  private BigSquareState getSecondDiagonalWinner() {
    if (status[1][3] != BigSquareState.UNKNOWN &&
        status[1][3] != BigSquareState.BLOCKED &&
        status[1][3] == status[2][2] &&
        status[1][3] == status[3][1]) {
      return status[1][3];
    }

    return BigSquareState.UNKNOWN;
  }

  public BigSquareState getGameWinner() {
    BigSquareState winner;

    winner = getFirstDiagonalWinner();
    if (winner != BigSquareState.UNKNOWN) {
      return winner;
    }

    winner = getSecondDiagonalWinner();
    if (winner != BigSquareState.UNKNOWN) {
      return winner;
    }

    for (int i = 1; i <= 3; i++) {
      winner = getLineWinner(i);
      if (winner != BigSquareState.UNKNOWN) {
        return winner;
      }

      winner = getColumnWinner(i);
      if (winner != BigSquareState.UNKNOWN) {
        return winner;
      }
    }

    return BigSquareState.UNKNOWN;
  }

  public boolean isGameDraw() {
    for (int i = 1; i <= 3; i++) {
      for (int j = 1; j <= 3; j++) {
        if (status[i][j] == BigSquareState.UNKNOWN) {
          return false;
        }
      }
    }

    if (getGameWinner() != BigSquareState.UNKNOWN) {
      return false;
    }

    return true;
  }

  public boolean isGameFinished() {
    return (isGameDraw() || (getGameWinner() != BigSquareState.UNKNOWN));
  }

  public void applyMove(int bigI, int bigJ, int i, int j, SquareState player) {
    Table currTable = bigTable[bigI][bigJ];
    currTable.setSquareState(i, j, player);

    if (currTable.isGameFinished()) {
      if (currTable.isGameDraw()) {
        status[bigI][bigJ] = BigSquareState.BLOCKED;
      } else {
        if (currTable.getGameWinner() == SquareState.PLAYERX) {
          status[bigI][bigJ] = BigSquareState.PLAYERX;
        } else {
          status[bigI][bigJ] = BigSquareState.PLAYER0;
        }
      }
    }
  }
}
