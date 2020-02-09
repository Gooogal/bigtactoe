package com.ichack.bigtactoe.View;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.ichack.bigtactoe.Presenter.Online;
import com.ichack.bigtactoe.Presenter.SquareState;
import com.ichack.bigtactoe.R;

public class PlayOnlineActivity extends AppCompatActivity {

  Online online;
  EditText usernameET;
  EditText idET;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_play_online);

    usernameET = (EditText) findViewById(R.id.usernameET);
    idET = (EditText) findViewById(R.id.idET);
    Button joinBtn = (Button) findViewById(R.id.joinButton);
    joinBtn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        online.joinOnlineGame(idET.getText().toString());
      }
    });

    online = new Online(this);
    Button createBtn = (Button) findViewById(R.id.createButton);
    createBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        online.startOnlineGame();
      }
    });
  }

  public void startMainActivity(int id, SquareState player) {
    Intent intent = new Intent(PlayOnlineActivity.this, MainActivity.class);
    intent.putExtra("gid", id);
    intent.putExtra("player", player);
    startActivity(intent);
  }

  public String getUsername() {
    return usernameET.getText().toString();
  }
}
