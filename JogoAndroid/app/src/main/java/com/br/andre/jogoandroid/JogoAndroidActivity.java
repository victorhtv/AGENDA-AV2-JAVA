package com.br.andre.jogoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class JogoAndroidActivity extends AppCompatActivity {

    private GameView game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        game = new GameView(this);
        setContentView(game);
    }

    protected void onDestroy(){
        super.onDestroy();
        game.release();
    }
}
