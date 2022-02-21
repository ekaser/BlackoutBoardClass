package com.example.blackoutboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //number of players
    public int numPlayers = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button controllerButton = findViewById(R.id.button);
        controllerButton.setOnClickListener(view -> startGame());
    }
    public void startGame() {
        setContentView(R.layout.gamepage);
    }
}