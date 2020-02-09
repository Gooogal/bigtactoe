package com.ichack.bigtactoe.Presenter;

public class Table {
  private SquareState[][] table;

  public Table() {
    table = new SquareState[4][4];

    for (int i = 1; i <= 3; i++) {
      for (int j = 1; j <= 3 ; j++) {
        table[i][j] = SquareState.EMPTY;
      }
    }
  }

  public SquareState getSquareState(int i, int j) {
    return table[i][j];
  }

  public void setSquareState(int i, int j, SquareState squareState) {
    table[i][j] = squareState;
  }

  private SquareState getLineWinner(int index) {
    if (table[index][1] != SquareState.EMPTY &&
        table[index][1] == table[index][2] &&
        table[index][1] == table[index][3]) {
      return table[index][1];
    }

    return SquareState.EMPTY;
  }

  private SquareState getColumnWinner(int index) {
    if (table[1][index] != SquareState.EMPTY &&
        table[1][index] == table[2][index] &&
        table[1][index] == table[3][index]) {
      return table[1][index];
    }

    return SquareState.EMPTY;
  }

  private SquareState getFirstDiagonalWinner() {
    if(table[1][1] != SquareState.EMPTY &&
       table[1][1] == table[2][2] &&
       table[1][1] == table[3][3]) {
      return table[1][1];
    }

    return SquareState.EMPTY;
  }

  private SquareState getSecondDiagonalWinner() {
    if (table[1][3] != SquareState.EMPTY &&
        table[1][3] == table[2][2] &&
        table[1][3] == table[3][1]) {
      return table[1][3];
    }

    return SquareState.EMPTY;
  }

  public SquareState getGameWinner() {
    SquareState winner;

    winner = getFirstDiagonalWinner();
    if (winner != SquareState.EMPTY) {
      return winner;
    }

    winner = getSecondDiagonalWinner();
    if (winner != SquareState.EMPTY) {
      return winner;
    }

    for (int i = 1; i <= 3; i++) {
      winner = getLineWinner(i);
      if (winner != SquareState.EMPTY) {
        return winner;
      }

      winner = getColumnWinner(i);
      if (winner != SquareState.EMPTY) {
        return winner;
      }
    }

    return SquareState.EMPTY;
  }

  public boolean isGameDraw() {
    for (int i = 1; i <= 3; i++) {
      for (int j = 1; j <= 3; j++) {
        if (table[i][j] == SquareState.EMPTY) {
          return false;
        }
      }
    }

    if (getGameWinner() != SquareState.EMPTY) {
      return false;
    }

    return true;
  }

  public boolean isGameFinished() {
    return (isGameDraw() || (getGameWinner() != SquareState.EMPTY));
  }

  public boolean isMoveValid(int i, int j) {
    return table[i][j] == SquareState.EMPTY;
  }
}
