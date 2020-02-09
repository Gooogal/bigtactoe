package com.ichack.bigtactoe;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  ImageButton[][] smallButtons = new ImageButton[9][9];

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    View[] boards = new View[9];
    boards[0] = findViewById(R.id.board1);
    boards[1] = findViewById(R.id.board2);
    boards[2] = findViewById(R.id.board3);
    boards[3] = findViewById(R.id.board4);
    boards[4] = findViewById(R.id.board5);
    boards[5] = findViewById(R.id.board6);
    boards[6] = findViewById(R.id.board7);
    boards[7] = findViewById(R.id.board8);
    boards[8] = findViewById(R.id.board9);

  }

}
