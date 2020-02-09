package com.ichack.bigtactoe.View;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.ichack.bigtactoe.Presenter.BigSquareState;
import com.ichack.bigtactoe.Presenter.Game;
import com.ichack.bigtactoe.Presenter.SquareState;
import com.ichack.bigtactoe.R;

public class MainActivity extends AppCompatActivity {

  ImageButton[][] smallButtons = new ImageButton[9][9];
  Game game;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    try {
      Intent intent = getIntent();
      int id = intent.getIntExtra("gid", 0);
      SquareState squareState = (SquareState) intent.getSerializableExtra("player");
      game = new Game(id, squareState);
    } catch(Exception e) {
      game = new Game();
    }

    final View[] boards = new View[9];
    boards[0] = findViewById(R.id.board1);
    boards[1] = findViewById(R.id.board2);
    boards[2] = findViewById(R.id.board3);
    boards[3] = findViewById(R.id.board4);
    boards[4] = findViewById(R.id.board5);
    boards[5] = findViewById(R.id.board6);
    boards[6] = findViewById(R.id.board7);
    boards[7] = findViewById(R.id.board8);
    boards[8] = findViewById(R.id.board9);

    final ImageView[] images = new ImageView[9];
    images[0] = findViewById(R.id.grid_done1);
    images[1] = findViewById(R.id.grid_done2);
    images[2] = findViewById(R.id.grid_done3);
    images[3] = findViewById(R.id.grid_done4);
    images[4] = findViewById(R.id.grid_done5);
    images[5] = findViewById(R.id.grid_done6);
    images[6] = findViewById(R.id.grid_done7);
    images[7] = findViewById(R.id.grid_done8);
    images[8] = findViewById(R.id.grid_done9);

    smallButtons[0][0] = boards[0].findViewById(R.id.imageButton11);
    smallButtons[0][1] = boards[0].findViewById(R.id.imageButton12);
    smallButtons[0][2] = boards[0].findViewById(R.id.imageButton13);
    smallButtons[1][0] = boards[0].findViewById(R.id.imageButton14);
    smallButtons[1][1] = boards[0].findViewById(R.id.imageButton15);
    smallButtons[1][2] = boards[0].findViewById(R.id.imageButton16);
    smallButtons[2][0] = boards[0].findViewById(R.id.imageButton17);
    smallButtons[2][1] = boards[0].findViewById(R.id.imageButton18);
    smallButtons[2][2] = boards[0].findViewById(R.id.imageButton19);

    smallButtons[0][3] = boards[1].findViewById(R.id.imageButton21);
    smallButtons[0][4] = boards[1].findViewById(R.id.imageButton22);
    smallButtons[0][5] = boards[1].findViewById(R.id.imageButton23);
    smallButtons[1][3] = boards[1].findViewById(R.id.imageButton24);
    smallButtons[1][4] = boards[1].findViewById(R.id.imageButton25);
    smallButtons[1][5] = boards[1].findViewById(R.id.imageButton26);
    smallButtons[2][3] = boards[1].findViewById(R.id.imageButton27);
    smallButtons[2][4] = boards[1].findViewById(R.id.imageButton28);
    smallButtons[2][5] = boards[1].findViewById(R.id.imageButton29);

    smallButtons[0][6] = boards[2].findViewById(R.id.imageButton31);
    smallButtons[0][7] = boards[2].findViewById(R.id.imageButton32);
    smallButtons[0][8] = boards[2].findViewById(R.id.imageButton33);
    smallButtons[1][6] = boards[2].findViewById(R.id.imageButton34);
    smallButtons[1][7] = boards[2].findViewById(R.id.imageButton35);
    smallButtons[1][8] = boards[2].findViewById(R.id.imageButton36);
    smallButtons[2][6] = boards[2].findViewById(R.id.imageButton37);
    smallButtons[2][7] = boards[2].findViewById(R.id.imageButton38);
    smallButtons[2][8] = boards[2].findViewById(R.id.imageButton39);




    smallButtons[3][0] = boards[3].findViewById(R.id.imageButton41);
    smallButtons[3][1] = boards[3].findViewById(R.id.imageButton42);
    smallButtons[3][2] = boards[3].findViewById(R.id.imageButton43);
    smallButtons[4][0] = boards[3].findViewById(R.id.imageButton44);
    smallButtons[4][1] = boards[3].findViewById(R.id.imageButton45);
    smallButtons[4][2] = boards[3].findViewById(R.id.imageButton46);
    smallButtons[5][0] = boards[3].findViewById(R.id.imageButton47);
    smallButtons[5][1] = boards[3].findViewById(R.id.imageButton48);
    smallButtons[5][2] = boards[3].findViewById(R.id.imageButton49);

    smallButtons[3][3] = boards[4].findViewById(R.id.imageButton51);
    smallButtons[3][4] = boards[4].findViewById(R.id.imageButton52);
    smallButtons[3][5] = boards[4].findViewById(R.id.imageButton53);
    smallButtons[4][3] = boards[4].findViewById(R.id.imageButton54);
    smallButtons[4][4] = boards[4].findViewById(R.id.imageButton55);
    smallButtons[4][5] = boards[4].findViewById(R.id.imageButton56);
    smallButtons[5][3] = boards[4].findViewById(R.id.imageButton57);
    smallButtons[5][4] = boards[4].findViewById(R.id.imageButton58);
    smallButtons[5][5] = boards[4].findViewById(R.id.imageButton59);

    smallButtons[3][6] = boards[5].findViewById(R.id.imageButton61);
    smallButtons[3][7] = boards[5].findViewById(R.id.imageButton62);
    smallButtons[3][8] = boards[5].findViewById(R.id.imageButton63);
    smallButtons[4][6] = boards[5].findViewById(R.id.imageButton64);
    smallButtons[4][7] = boards[5].findViewById(R.id.imageButton65);
    smallButtons[4][8] = boards[5].findViewById(R.id.imageButton66);
    smallButtons[5][6] = boards[5].findViewById(R.id.imageButton67);
    smallButtons[5][7] = boards[5].findViewById(R.id.imageButton68);
    smallButtons[5][8] = boards[5].findViewById(R.id.imageButton69);





    smallButtons[6][0] = boards[6].findViewById(R.id.imageButton71);
    smallButtons[6][1] = boards[6].findViewById(R.id.imageButton72);
    smallButtons[6][2] = boards[6].findViewById(R.id.imageButton73);
    smallButtons[7][0] = boards[6].findViewById(R.id.imageButton74);
    smallButtons[7][1] = boards[6].findViewById(R.id.imageButton75);
    smallButtons[7][2] = boards[6].findViewById(R.id.imageButton76);
    smallButtons[8][0] = boards[6].findViewById(R.id.imageButton77);
    smallButtons[8][1] = boards[6].findViewById(R.id.imageButton78);
    smallButtons[8][2] = boards[6].findViewById(R.id.imageButton79);

    smallButtons[6][3] = boards[7].findViewById(R.id.imageButton81);
    smallButtons[6][4] = boards[7].findViewById(R.id.imageButton82);
    smallButtons[6][5] = boards[7].findViewById(R.id.imageButton83);
    smallButtons[7][3] = boards[7].findViewById(R.id.imageButton84);
    smallButtons[7][4] = boards[7].findViewById(R.id.imageButton85);
    smallButtons[7][5] = boards[7].findViewById(R.id.imageButton86);
    smallButtons[8][3] = boards[7].findViewById(R.id.imageButton87);
    smallButtons[8][4] = boards[7].findViewById(R.id.imageButton88);
    smallButtons[8][5] = boards[7].findViewById(R.id.imageButton89);

    smallButtons[6][6] = boards[8].findViewById(R.id.imageButton91);
    smallButtons[6][7] = boards[8].findViewById(R.id.imageButton92);
    smallButtons[6][8] = boards[8].findViewById(R.id.imageButton93);
    smallButtons[7][6] = boards[8].findViewById(R.id.imageButton94);
    smallButtons[7][7] = boards[8].findViewById(R.id.imageButton95);
    smallButtons[7][8] = boards[8].findViewById(R.id.imageButton96);
    smallButtons[8][6] = boards[8].findViewById(R.id.imageButton97);
    smallButtons[8][7] = boards[8].findViewById(R.id.imageButton98);
    smallButtons[8][8] = boards[8].findViewById(R.id.imageButton99);

    final TextView messageTV = (TextView) findViewById(R.id.MessageTV);

    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++){
        final int finalJ = j;
        final int finalI = i;
        smallButtons[i][j].setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
            SquareState player = game.makeMove((finalI %3) + 1, (finalJ %3) + 1, (finalI / 3) + 1, (finalJ / 3) + 1);
            if(player == SquareState.PLAYERX){
              smallButtons[finalI][finalJ].setImageResource(R.drawable.x_drawable);
              messageTV.setText(R.string.o_message);
            } else if (player == SquareState.PLAYER0){
              smallButtons[finalI][finalJ].setImageResource(R.drawable.o_drawable);
              messageTV.setText(R.string.x_message);
            } else {
              Toast.makeText(MainActivity.this, "Invalid move, please try again", Toast.LENGTH_SHORT).show();
            }

            BigSquareState smallGameState = game.bigTable.isSubGameDone((finalI / 3) + 1, (finalJ / 3) + 1);

            if(smallGameState != BigSquareState.UNKNOWN) {
              int index = (finalI/3) * 3 + finalJ/3;
              boards[index].setVisibility(View.INVISIBLE);
              if(smallGameState == BigSquareState.PLAYER0) {
                images[index].setImageResource(R.drawable.o_drawable);
              } else if (smallGameState == BigSquareState.PLAYERX) {
                images[index].setImageResource(R.drawable.x_drawable);
              } else {
                images[index].setImageResource(R.drawable.draw);
              }

            }

            if (game.bigTable.isGameDraw()) {
              messageTV.setText("It's a draw");
            }

            BigSquareState bigGameWinner = game.bigTable.getGameWinner();
            if (bigGameWinner != BigSquareState.UNKNOWN) {
              messageTV.setText("Player " + (bigGameWinner == BigSquareState.PLAYER0 ? "0" : "X") + " wins");
            }

          }
        });
      }
    }
  }

}
