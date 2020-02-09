package com.ichack.bigtactoe.View;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.ichack.bigtactoe.R;

public class StartActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_start);

    Button playOfflineBtn = (Button) findViewById(R.id.play_offline);
    Button playOnlineBtn = (Button) findViewById(R.id.play_online);

    playOfflineBtn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        finish();
        startActivity(intent);
      }
    });

    playOnlineBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(StartActivity.this, PlayOnlineActivity.class);
        finish();
        startActivity(intent);
      }
    });
  }
}
