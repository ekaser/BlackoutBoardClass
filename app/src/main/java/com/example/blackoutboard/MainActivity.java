package com.example.blackoutboard;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

class Player {
    int position;
    public int dice1, dice2;
    boolean skip;

    public void roll() {
        Random r = new Random();
        dice1 = r.nextInt(6) + 1;
        dice2 = r.nextInt(6) + 1;
    }
    public void move(int movement) {
        this.position = this.position + movement;
    }
}
public class MainActivity extends AppCompatActivity {
    //number of players
    TextView currentPlayerDisplay;
    TextView dice1Display;
    TextView dice2Display;
    TextView textOut;
    Button rollButton;
    Difficulty difficulty = Difficulty.Easy;
    int endSquare = 34;

    final TextView[] squareTexts = new TextView[56];
    final ArrayList<Player> players = new ArrayList<>();

    public static int numPlayers = 0;
    public static int curPlayer = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button controllerButton = findViewById(R.id.button);
        controllerButton.setOnClickListener(view -> startGame());
    }

    public void startGame() {
        TextInputEditText textin = findViewById(R.id.playertext);
        if (textin.getText().toString().equals("")) {
            textin.setText("0");
        }

        String noPlayers = textin.getText().toString();
        numPlayers = Integer.parseInt(noPlayers);
        setContentView(R.layout.gamepage);
        currentPlayerDisplay = findViewById(R.id.currentPlayerText);
        dice1Display = findViewById(R.id.dice1Display);
        dice2Display = findViewById(R.id.dice2Display);
        textOut = findViewById(R.id.textoutDisplay);
        rollButton = findViewById(R.id.rollButton);

        if (numPlayers <= 1) {
            changeText(textOut,"It's no fun playing by yourself! Player Count has been set to two.");
            numPlayers = 2;
        } else {
            textOut.setText("Roll to Begin!");
        }

        for (int c=0; c<numPlayers; c++) {
            Player tmpPlayer = new Player();
            tmpPlayer.position = 1;
            tmpPlayer.skip = false;
            players.add(tmpPlayer);
        }
        buildGame();
        dice1Display.setText("Dice 1: 0");
        dice2Display.setText("Dice 2: 0");
        changeText(currentPlayerDisplay, "Player 1");
        gameLoop();
    }

    public void buildGame() {
        //create board array
        TextView tex1 = findViewById(R.id.Tx1);
        squareTexts[0] = tex1;
        TextView tex2 = findViewById(R.id.tx2);
        squareTexts[1] = tex2;
        TextView tex3 = findViewById(R.id.tx3);
        squareTexts[2] = tex3;
        TextView tex4 = findViewById(R.id.tx4);
        squareTexts[3] = tex4;
        TextView tex5 = findViewById(R.id.tx5);
        squareTexts[4] = tex5;
        TextView tex6 = findViewById(R.id.tx6);
        squareTexts[5] = tex6;
        TextView tex7 = findViewById(R.id.tx7);
        squareTexts[6] = tex7;
        TextView tex8 = findViewById(R.id.tx8);
        squareTexts[7] = tex8;
        TextView tex9 = findViewById(R.id.tx9);
        squareTexts[8] = tex9;
        TextView tex10 = findViewById(R.id.tx10);
        squareTexts[9] = tex10;
        TextView tex11 = findViewById(R.id.tx11);
        squareTexts[10] = tex11;TextView tex12 = findViewById(R.id.tx12);
        squareTexts[11] = tex12;TextView tex13 = findViewById(R.id.tx13);
        squareTexts[12] = tex13;TextView tex14 = findViewById(R.id.tx14);
        squareTexts[13] = tex14;TextView tex15 = findViewById(R.id.tx15);
        squareTexts[14] = tex15;TextView tex16 = findViewById(R.id.tx16);
        squareTexts[15] = tex16;TextView tex17 = findViewById(R.id.tx17);
        squareTexts[16] = tex17;TextView tex18 = findViewById(R.id.tx18);
        squareTexts[17] = tex18;TextView tex19 = findViewById(R.id.tx19);
        squareTexts[18] = tex19;TextView tex20 = findViewById(R.id.tx20);
        squareTexts[19] = tex20;TextView tex21 = findViewById(R.id.tx21);
        squareTexts[20] = tex21;TextView tex22 = findViewById(R.id.tx22);
        squareTexts[21] = tex22;TextView tex23 = findViewById(R.id.tx23);
        squareTexts[22] = tex23;TextView tex24 = findViewById(R.id.tx24);
        squareTexts[23] = tex24;TextView tex25 = findViewById(R.id.tx25);
        squareTexts[24] = tex25;TextView tex26 = findViewById(R.id.tx26);
        squareTexts[25] = tex26;TextView tex27 = findViewById(R.id.tx27);
        squareTexts[26] = tex27;TextView tex28 = findViewById(R.id.tx28);
        squareTexts[27] = tex28;TextView tex29 = findViewById(R.id.tx29);
        squareTexts[28] = tex29;TextView tex30 = findViewById(R.id.tx30);
        squareTexts[29] = tex30;TextView tex31 = findViewById(R.id.tx31);
        squareTexts[30] = tex31;TextView tex32 = findViewById(R.id.tx32);
        squareTexts[31] = tex32;TextView tex33 = findViewById(R.id.tx33);
        squareTexts[32] = tex33;TextView tex34 = findViewById(R.id.tx34);
        squareTexts[33] = tex34;TextView tex35 = findViewById(R.id.tx35);
        squareTexts[34] = tex35;
    }

    public void gameLoop() {
        if (players.get(curPlayer-1).skip) {
            players.get(curPlayer-1).skip = false;
            if (curPlayer < numPlayers) {
                curPlayer++;
            } else {
                curPlayer = 1;
            }
            gameLoop();
        }
        rollButton.setOnClickListener(view -> turn());
    }

    public void startOver() {
        setContentView(R.layout.activity_main);
        players.removeAll(players);
        Button controllerButton = findViewById(R.id.button);
        controllerButton.setOnClickListener(view -> startGame());
    }

    public void turn() {
        changeText(currentPlayerDisplay, "Player " + curPlayer);
        players.get(curPlayer-1).roll();
        dice1Display.setText("Dice 1: " + players.get(curPlayer-1).dice1);
        dice2Display.setText("Dice 2: " + players.get(curPlayer-1).dice2);
        int tmpMove = players.get(curPlayer-1).dice1 + players.get(curPlayer-1).dice2;
        if (checkWin(players.get(curPlayer-1).position + tmpMove)) {
            setContentView(R.layout.endpage);
            Button reset = findViewById(R.id.resetButton);
            reset.setOnClickListener(view -> startOver());
            TextView winner = findViewById(R.id.winnerText);
            changeText(winner, currentPlayerDisplay.getText().toString() + " Wins!");
            return;
        }
        move(players.get(curPlayer-1), tmpMove);
        actionStep(players.get(curPlayer-1));

        if (curPlayer < numPlayers) {
            curPlayer++;
        } else {
            curPlayer = 1;
        }
        gameLoop();
    }

    public void move(Player player, int steps) {
        int oPos = player.position;
        if (squareTexts[oPos-1].getText().toString().length() > 1) {
            changeText(squareTexts[oPos - 1],
                    squareTexts[oPos-1].getText().toString().replaceAll(String.valueOf(curPlayer), ""));
            changeText(squareTexts[oPos - 1],
                    squareTexts[oPos-1].getText().toString().replaceAll(",", ""));
        } else {
            changeText(squareTexts[oPos - 1], "");
        }
        player.move(steps);
        int cPos = player.position;
        if (checkWin(cPos)) {
            setContentView(R.layout.endpage);
            Button reset = findViewById(R.id.resetButton);
            reset.setOnClickListener(view -> startOver());
            TextView winner = findViewById(R.id.winnerText);
            changeText(winner, currentPlayerDisplay.getText().toString() + " Wins!");
            return;
        }
        if (squareTexts[cPos-1].getText().toString().equals("")) {
            changeText(squareTexts[cPos - 1], "" + curPlayer);
        } else {
            changeText(squareTexts[cPos - 1], squareTexts[cPos-1].getText().toString() + "," + curPlayer);
        }
    }

    public boolean checkWin(int pos) {
        if (pos >= endSquare) {
            return true;
        } else {
            return false;
        }
    }

    public void actionStep(Player player) {
        int v = player.position;
        switch (v) {
            case 1:
                changeText(textOut, "Starting Square, shouldn't happen");
                break;
            case 2:
                changeText(textOut, "Also shouldn't happen with 2 dice");
                break;
            case 3:
                changeText(textOut, "Snake Eyes! Roll again");
                gameLoop();
                break;
            case 4: changeText(textOut, "Skip two squares");
                move(player, 2);
                break;
            case 5: changeText(textOut, "");
break;
            case 6: changeText(textOut, "");
break;
            case 7: changeText(textOut, "Skip your next turn");
                player.skip = true;
                break;
            case 8: changeText(textOut, "");
break;
            case 9: changeText(textOut, "Skip one square");
                move(player, 1);
                break;

            case 10: changeText(textOut, "");
break;
            case 11: changeText(textOut, "Move back one square");
                move(player, -1);
                break;
            case 12: changeText(textOut, "");
break;
            case 13: changeText(textOut, "Skip three squares");
                move(player, 3);
                break;
            case 14: changeText(textOut, "");
break;
            case 15:
                changeText(textOut, "Roll again");
                gameLoop();
                break;
            case 16: changeText(textOut, "Advance two squares");
            move(player, 2);
            break;
            case 17: changeText(textOut, "");
break;
            case 18: changeText(textOut, "Skip your next turn");
                player.skip = true;
                break;
            case 19: changeText(textOut, "");
break;
            case 20: changeText(textOut, "Start over!");
                move(player, -(v-1));
                break;
            case 21: changeText(textOut, "");
break;
            case 22: changeText(textOut, "Move back one square");
                move(player, -1);
                break;
            case 23: changeText(textOut, "");
break;
            case 24: changeText(textOut, "Skip your next turn");
                player.skip = true;
                break;
            case 25: changeText(textOut, "");
break;
            case 26: changeText(textOut, "Advance two squares");
                move(player, 2);
                break;
            case 27: changeText(textOut, "");
break;
            case 28: changeText(textOut, "");
break;
            case 29: changeText(textOut, "Move back one square");
                move(player, -1);
                break;
            case 30: changeText(textOut, "");
break;
            case 31: changeText(textOut, "Start over!");
                move(player, -(v-1));
                break;
            case 32: changeText(textOut, "");
break;
            case 33: changeText(textOut, "Skip 5 squares!");
                    move(player, 5);
                    break;
            case 34: changeText(textOut, "Every player moves back two squares");
                    for (int i=0; i<numPlayers; i++) {
                       move(players.get(i), -2);
                     }
                    break;
            case 35: changeText(textOut, "");
break;
            case 36: changeText(textOut, "Skip two squares");
                move(player, 2);
                break;
            case 37: changeText(textOut, "");
                break;
            case 38: changeText(textOut, "Move back one square");
                move(player, -1);
                break;
            case 39: changeText(textOut, "");
                break;
            case 40: changeText(textOut, "Skip one square");
                move(player, 1);
                break;
            case 41:
                changeText(textOut, "Roll again");
                gameLoop();
                break;
            case 42: changeText(textOut, "Every player moves back two squares");
                for (int i=0; i<numPlayers; i++) {
                    move(players.get(i), -2);
                }
                break;
            case 43: changeText(textOut, "");
                break;
            case 44: changeText(textOut, "Move back one square");
                move(player, -1);
                break;
            case 45: changeText(textOut, "");
                break;
            case 46: changeText(textOut, "Skip one square");
                move(player, 1);
                break;
            case 47: changeText(textOut, "");
                break;
            case 48: changeText(textOut, "Skip your next turn");
                player.skip = true;
                break;
            case 49: changeText(textOut, "");
                break;
            case 50: changeText(textOut, "Skip one square");
                move(player, 1);
                break;
            case 51: changeText(textOut, "");
                break;
            case 52: changeText(textOut, "Skip one square");
                move(player, 1);
                break;
            case 53: changeText(textOut, "");
                break;
            case 54: changeText(textOut, "Move back 8 squares");
                move(player, -8);
                break;
            case 55:
                changeText(textOut, "So close! Go back 2 squares");
                break;
            default:
                changeText(textOut, "ERROR");
                break;
        }
    }
    public void changeText(TextView thisText, String text) {
            thisText.setText(text);
    }

    public void onRadioButtonClicked(View view) {
        if (view.getId() == R.id.EasyButton) {
            difficulty = Difficulty.Easy;
        } else if (view.getId() == R.id.MedButton) {
            difficulty = Difficulty.Medium;
        } else {
            difficulty = Difficulty.Hard;
        }
    }
}