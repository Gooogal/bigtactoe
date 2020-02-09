package com.ichack.bigtactoe.Presenter;

import com.ichack.bigtactoe.View.PlayOnlineActivity;
import okhttp3.*;

public class Online {

  private PlayOnlineActivity activity;
  private final OkHttpClient client = new OkHttpClient();
  private static String URL = "cloud-vm-43-80.doc.ic.ac.uk:8080/";

  public Online(PlayOnlineActivity activity) {
    this.activity = activity;
  }

  public void joinOnlineGame(String id) {
    RequestBody body = new FormBody.Builder().add("game_id", id).build();
    Request request = new Request.Builder()
        .url(URL + "join/")
        .post(body)
        .build();
    try {
      Response response = client.newCall(request).execute();
      int idd = Integer.parseInt(id);
      activity.startMainActivity(idd, SquareState.PLAYER0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void startOnlineGame() {
    String username = activity.getUsername();
    RequestBody rBody = new FormBody.Builder().add("player", username).build();
    Request request = new Request.Builder()
        .url(URL + "create/")
        .post(rBody)
        .build();

    try {
      Response response = client.newCall(request).execute();
      int id = Integer.parseInt(response.body().string());
      activity.startMainActivity(id, SquareState.PLAYERX);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
