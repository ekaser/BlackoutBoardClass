package com.example.blackoutboard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Random;

class Player {
public int dice1, dice2;
int position;
boolean skip;
int number;

    public Player(int num) {
        position = 1;
        number = num;
        skip = false;
    }

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
final public static TextView[] squareTexts = new TextView[64];
final public static ArrayList<Player> players = new ArrayList<>();
public static Difficulty difficulty = Difficulty.Easy;
public static int endSquare = 34;
public static int numPlayers = 0;
public static int curPlayer = 1;
//number of players
TextView currentPlayerDisplay;
TextView dice1Display;
TextView dice2Display;
TextView textOut;
Button rollButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button controllerButton = findViewById(R.id.button);
        controllerButton.setOnClickListener(view -> startGame());
    }

    public void startGame() {
        TextInputEditText textin = this.findViewById(R.id.playertext);
        if (textin.getText().toString().equals("")) {
            textin.setText("0");
        }

        String noPlayers = textin.getText().toString();
        numPlayers = Integer.parseInt(noPlayers);
        if (difficulty == Difficulty.Easy) {
            setContentView(R.layout.gamepage);
            endSquare = 34;
        } else if (difficulty == Difficulty.Medium) {
            setContentView(R.layout.gamepagemed);
            endSquare = 44;
        } else if (difficulty == Difficulty.Hard) {
            setContentView(R.layout.gamepagehard);
            endSquare = 63;
        }
        currentPlayerDisplay = findViewById(R.id.currentPlayerText);
        dice1Display = findViewById(R.id.dice1Display);
        dice2Display = findViewById(R.id.dice2Display);
        textOut = findViewById(R.id.textoutDisplay);
        rollButton = findViewById(R.id.rollButton);

        if (numPlayers <= 1) {
            changeText(textOut, "It's no fun playing by yourself! Player Count has been set to two.");
            numPlayers = 2;
        } else if (numPlayers > 8) {
            changeText(textOut, "Too many players! Player count has been set to 8.");
            numPlayers = 8;
        } else {
            textOut.setText("Roll to Begin!");
        }

        for (int c = 0; c < numPlayers; c++) {
            Player tmpPlayer = new Player(c + 1);
            players.add(tmpPlayer);
        }
        if (difficulty == Difficulty.Easy) {
            buildGame();
        } else if (difficulty == Difficulty.Medium) {
            buildGameMedium();
        } else if (difficulty == Difficulty.Hard) {
            buildGameHard();
        }
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
        squareTexts[10] = tex11;
        TextView tex12 = findViewById(R.id.tx12);
        squareTexts[11] = tex12;
        TextView tex13 = findViewById(R.id.tx13);
        squareTexts[12] = tex13;
        TextView tex14 = findViewById(R.id.tx14);
        squareTexts[13] = tex14;
        TextView tex15 = findViewById(R.id.tx15);
        squareTexts[14] = tex15;
        TextView tex16 = findViewById(R.id.tx16);
        squareTexts[15] = tex16;
        TextView tex17 = findViewById(R.id.tx17);
        squareTexts[16] = tex17;
        TextView tex18 = findViewById(R.id.tx18);
        squareTexts[17] = tex18;
        TextView tex19 = findViewById(R.id.tx19);
        squareTexts[18] = tex19;
        TextView tex20 = findViewById(R.id.tx20);
        squareTexts[19] = tex20;
        TextView tex21 = findViewById(R.id.tx21);
        squareTexts[20] = tex21;
        TextView tex22 = findViewById(R.id.tx22);
        squareTexts[21] = tex22;
        TextView tex23 = findViewById(R.id.tx23);
        squareTexts[22] = tex23;
        TextView tex24 = findViewById(R.id.tx24);
        squareTexts[23] = tex24;
        TextView tex25 = findViewById(R.id.tx25);
        squareTexts[24] = tex25;
        TextView tex26 = findViewById(R.id.tx26);
        squareTexts[25] = tex26;
        TextView tex27 = findViewById(R.id.tx27);
        squareTexts[26] = tex27;
        TextView tex28 = findViewById(R.id.tx28);
        squareTexts[27] = tex28;
        TextView tex29 = findViewById(R.id.tx29);
        squareTexts[28] = tex29;
        TextView tex30 = findViewById(R.id.tx30);
        squareTexts[29] = tex30;
        TextView tex31 = findViewById(R.id.tx31);
        squareTexts[30] = tex31;
        TextView tex32 = findViewById(R.id.tx32);
        squareTexts[31] = tex32;
        TextView tex33 = findViewById(R.id.tx33);
        squareTexts[32] = tex33;
        TextView tex34 = findViewById(R.id.tx34);
        squareTexts[33] = tex34;
        TextView tex35 = findViewById(R.id.tx35);
        squareTexts[34] = tex35;
    }

    public void buildGameMedium() {
        //create board array
        TextView tex1 = findViewById(R.id.t1);
        squareTexts[0] = tex1;
        TextView tex2 = findViewById(R.id.t2);
        squareTexts[1] = tex2;
        TextView tex3 = findViewById(R.id.t3);
        squareTexts[2] = tex3;
        TextView tex4 = findViewById(R.id.t4);
        squareTexts[3] = tex4;
        TextView tex5 = findViewById(R.id.t5);
        squareTexts[4] = tex5;
        TextView tex6 = findViewById(R.id.t6);
        squareTexts[5] = tex6;
        TextView tex7 = findViewById(R.id.t7);
        squareTexts[6] = tex7;
        TextView tex8 = findViewById(R.id.t8);
        squareTexts[7] = tex8;
        TextView tex9 = findViewById(R.id.t9);
        squareTexts[8] = tex9;
        TextView tex10 = findViewById(R.id.t10);
        squareTexts[9] = tex10;
        TextView tex11 = findViewById(R.id.t11);
        squareTexts[10] = tex11;
        TextView tex12 = findViewById(R.id.t12);
        squareTexts[11] = tex12;
        TextView tex13 = findViewById(R.id.t13);
        squareTexts[12] = tex13;
        TextView tex14 = findViewById(R.id.t14);
        squareTexts[13] = tex14;
        TextView tex15 = findViewById(R.id.t15);
        squareTexts[14] = tex15;
        TextView tex16 = findViewById(R.id.t16);
        squareTexts[15] = tex16;
        TextView tex17 = findViewById(R.id.t17);
        squareTexts[16] = tex17;
        TextView tex18 = findViewById(R.id.t18);
        squareTexts[17] = tex18;
        TextView tex19 = findViewById(R.id.t19);
        squareTexts[18] = tex19;
        TextView tex20 = findViewById(R.id.t20);
        squareTexts[19] = tex20;
        TextView tex21 = findViewById(R.id.t21);
        squareTexts[20] = tex21;
        TextView tex22 = findViewById(R.id.t22);
        squareTexts[21] = tex22;
        TextView tex23 = findViewById(R.id.t23);
        squareTexts[22] = tex23;
        TextView tex24 = findViewById(R.id.t24);
        squareTexts[23] = tex24;
        TextView tex25 = findViewById(R.id.t25);
        squareTexts[24] = tex25;
        TextView tex26 = findViewById(R.id.t26);
        squareTexts[25] = tex26;
        TextView tex27 = findViewById(R.id.t27);
        squareTexts[26] = tex27;
        TextView tex28 = findViewById(R.id.t28);
        squareTexts[27] = tex28;
        TextView tex29 = findViewById(R.id.t29);
        squareTexts[28] = tex29;
        TextView tex30 = findViewById(R.id.t30);
        squareTexts[29] = tex30;
        TextView tex31 = findViewById(R.id.t31);
        squareTexts[30] = tex31;
        TextView tex32 = findViewById(R.id.t32);
        squareTexts[31] = tex32;
        TextView tex33 = findViewById(R.id.t33);
        squareTexts[32] = tex33;
        TextView tex34 = findViewById(R.id.t34);
        squareTexts[33] = tex34;
        TextView tex35 = findViewById(R.id.t35);
        squareTexts[34] = tex35;
        TextView tex36 = findViewById(R.id.t36);
        squareTexts[35] = tex36;
        TextView tex37 = findViewById(R.id.t37);
        squareTexts[36] = tex37;
        TextView tex38 = findViewById(R.id.t38);
        squareTexts[37] = tex38;
        TextView tex39 = findViewById(R.id.t39);
        squareTexts[38] = tex39;
        TextView tex40 = findViewById(R.id.t40);
        squareTexts[39] = tex40;
        TextView tex41 = findViewById(R.id.t41);
        squareTexts[40] = tex41;
        TextView tex42 = findViewById(R.id.t42);
        squareTexts[41] = tex42;
        TextView tex43 = findViewById(R.id.t43);
        squareTexts[42] = tex43;
        TextView tex44 = findViewById(R.id.t44);
        squareTexts[43] = tex44;
        TextView tex45 = findViewById(R.id.t45);
        squareTexts[44] = tex45;
    }

    public void buildGameHard() {
        //create board array
        TextView tex1 = findViewById(R.id.tp1);
        squareTexts[0] = tex1;
        TextView tex2 = findViewById(R.id.tp2);
        squareTexts[1] = tex2;
        TextView tex3 = findViewById(R.id.tp3);
        squareTexts[2] = tex3;
        TextView tex4 = findViewById(R.id.tp4);
        squareTexts[3] = tex4;
        TextView tex5 = findViewById(R.id.tp5);
        squareTexts[4] = tex5;
        TextView tex6 = findViewById(R.id.tp6);
        squareTexts[5] = tex6;
        TextView tex7 = findViewById(R.id.tp7);
        squareTexts[6] = tex7;
        TextView tex8 = findViewById(R.id.tp8);
        squareTexts[7] = tex8;
        TextView tex9 = findViewById(R.id.tp9);
        squareTexts[8] = tex9;
        TextView tex10 = findViewById(R.id.tp10);
        squareTexts[9] = tex10;
        TextView tex11 = findViewById(R.id.tp11);
        squareTexts[10] = tex11;
        TextView tex12 = findViewById(R.id.tp12);
        squareTexts[11] = tex12;
        TextView tex13 = findViewById(R.id.tp13);
        squareTexts[12] = tex13;
        TextView tex14 = findViewById(R.id.tp14);
        squareTexts[13] = tex14;
        TextView tex15 = findViewById(R.id.tp15);
        squareTexts[14] = tex15;
        TextView tex16 = findViewById(R.id.tp16);
        squareTexts[15] = tex16;
        TextView tex17 = findViewById(R.id.tp17);
        squareTexts[16] = tex17;
        TextView tex18 = findViewById(R.id.tp18);
        squareTexts[17] = tex18;
        TextView tex19 = findViewById(R.id.tp19);
        squareTexts[18] = tex19;
        TextView tex20 = findViewById(R.id.tp20);
        squareTexts[19] = tex20;
        TextView tex21 = findViewById(R.id.tp21);
        squareTexts[20] = tex21;
        TextView tex22 = findViewById(R.id.tp22);
        squareTexts[21] = tex22;
        TextView tex23 = findViewById(R.id.tp23);
        squareTexts[22] = tex23;
        TextView tex24 = findViewById(R.id.tp24);
        squareTexts[23] = tex24;
        TextView tex25 = findViewById(R.id.tp25);
        squareTexts[24] = tex25;
        TextView tex26 = findViewById(R.id.tp26);
        squareTexts[25] = tex26;
        TextView tex27 = findViewById(R.id.tp27);
        squareTexts[26] = tex27;
        TextView tex28 = findViewById(R.id.tp28);
        squareTexts[27] = tex28;
        TextView tex29 = findViewById(R.id.tp29);
        squareTexts[28] = tex29;
        TextView tex30 = findViewById(R.id.tp30);
        squareTexts[29] = tex30;
        TextView tex31 = findViewById(R.id.tp31);
        squareTexts[30] = tex31;
        TextView tex32 = findViewById(R.id.tp32);
        squareTexts[31] = tex32;
        TextView tex33 = findViewById(R.id.tp33);
        squareTexts[32] = tex33;
        TextView tex34 = findViewById(R.id.tp34);
        squareTexts[33] = tex34;
        TextView tex35 = findViewById(R.id.tp35);
        squareTexts[34] = tex35;
        TextView tex36 = findViewById(R.id.tp36);
        squareTexts[35] = tex36;
        TextView tex37 = findViewById(R.id.tp37);
        squareTexts[36] = tex37;
        TextView tex38 = findViewById(R.id.tp38);
        squareTexts[37] = tex38;
        TextView tex39 = findViewById(R.id.tp39);
        squareTexts[38] = tex39;
        TextView tex40 = findViewById(R.id.tp40);
        squareTexts[39] = tex40;
        TextView tex41 = findViewById(R.id.tp41);
        squareTexts[40] = tex41;
        TextView tex42 = findViewById(R.id.tp42);
        squareTexts[41] = tex42;
        TextView tex43 = findViewById(R.id.tp43);
        squareTexts[42] = tex43;
        TextView tex44 = findViewById(R.id.tp44);
        squareTexts[43] = tex44;
        TextView tex45 = findViewById(R.id.tp45);
        squareTexts[44] = tex45;
        TextView tex46 = findViewById(R.id.tp46);
        squareTexts[45] = tex46;
        TextView tex47 = findViewById(R.id.tp47);
        squareTexts[46] = tex47;
        TextView tex48 = findViewById(R.id.tp48);
        squareTexts[47] = tex48;
        TextView tex49 = findViewById(R.id.tp49);
        squareTexts[48] = tex49;
        TextView tex50 = findViewById(R.id.tp50);
        squareTexts[49] = tex50;
        TextView tex51 = findViewById(R.id.tp51);
        squareTexts[50] = tex51;
        TextView tex52 = findViewById(R.id.tp52);
        squareTexts[51] = tex52;
        TextView tex53 = findViewById(R.id.tp53);
        squareTexts[52] = tex53;
        TextView tex54 = findViewById(R.id.tp54);
        squareTexts[53] = tex54;
        TextView tex55 = findViewById(R.id.tp55);
        squareTexts[54] = tex55;
        TextView tex56 = findViewById(R.id.tp56);
        squareTexts[55] = tex56;
        TextView tex57 = findViewById(R.id.tp57);
        squareTexts[56] = tex57;
        TextView tex58 = findViewById(R.id.tp58);
        squareTexts[57] = tex58;
        TextView tex59 = findViewById(R.id.tp59);
        squareTexts[58] = tex59;
        TextView tex60 = findViewById(R.id.tp60);
        squareTexts[59] = tex60;
        TextView tex61 = findViewById(R.id.tp61);
        squareTexts[60] = tex61;
        TextView tex62 = findViewById(R.id.tp62);
        squareTexts[61] = tex62;
        TextView tex63 = findViewById(R.id.tp63);
        squareTexts[62] = tex63;
        TextView tex64 = findViewById(R.id.tp64);
        squareTexts[63] = tex64;
    }

    public void gameLoop() {
        if (players.get(curPlayer - 1).skip) {
            players.get(curPlayer - 1).skip = false;
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
        players.get(curPlayer - 1).roll();
        dice1Display.setText("Dice 1: " + players.get(curPlayer - 1).dice1);
        dice2Display.setText("Dice 2: " + players.get(curPlayer - 1).dice2);
        int tmpMove = players.get(curPlayer - 1).dice1 + players.get(curPlayer - 1).dice2;
        if (checkWin(players.get(curPlayer - 1).position + tmpMove)) {
            setContentView(R.layout.endpage);
            Button reset = findViewById(R.id.resetButton);
            reset.setOnClickListener(view -> startOver());
            TextView winner = findViewById(R.id.winnerText);
            changeText(winner, currentPlayerDisplay.getText().toString() + " Wins!");
            return;
        }
        move(players.get(curPlayer - 1), tmpMove);
        actionStep(players.get(curPlayer - 1));

        if (curPlayer < numPlayers) {
            curPlayer++;
        } else {
            curPlayer = 1;
        }
        gameLoop();
    }

    public void move(Player player, int steps) {
        int oPos = player.position;
        String playerString = Integer.toString(player.number);
        if (squareTexts[oPos - 1].getText().toString().length() > 1) {
            changeText(squareTexts[oPos - 1],
                    squareTexts[oPos - 1].getText().toString().replaceAll(playerString, ""));
            changeText(squareTexts[oPos - 1],
                    squareTexts[oPos - 1].getText().toString().replaceAll(",", ""));
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
        if (squareTexts[cPos - 1].getText().toString().equals("")) {
            changeText(squareTexts[cPos - 1], "" + playerString);
        } else {
            changeText(squareTexts[cPos - 1], squareTexts[cPos - 1].getText().toString() + "," + playerString);
        }
    }

    public boolean checkWin(int pos) {
        return pos >= endSquare;
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
            case 4:
                changeText(textOut, "Skip two squares");
                move(player, 2);
                break;
            case 5:
                changeText(textOut, "");
                break;
            case 6:
                changeText(textOut, "");
                break;
            case 7:
                changeText(textOut, "Skip your next turn");
                player.skip = true;
                break;
            case 8:
                changeText(textOut, "");
                break;
            case 9:
                changeText(textOut, "Skip one square");
                move(player, 1);
                break;

            case 10:
                changeText(textOut, "");
                break;
            case 11:
                changeText(textOut, "Move back one square");
                move(player, -1);
                break;
            case 12:
                changeText(textOut, "");
                break;
            case 13:
                changeText(textOut, "Skip three squares");
                move(player, 3);
                break;
            case 14:
                changeText(textOut, "");
                break;
            case 15:
                changeText(textOut, "Roll again");
                gameLoop();
                break;
            case 16:
                changeText(textOut, "Advance two squares");
                move(player, 2);
                break;
            case 17:
                changeText(textOut, "");
                break;
            case 18:
                changeText(textOut, "Skip your next turn");
                player.skip = true;
                break;
            case 19:
                changeText(textOut, "");
                break;
            case 20:
                changeText(textOut, "Start over!");
                move(player, -(v - 1));
                break;
            case 21:
                changeText(textOut, "");
                break;
            case 22:
                changeText(textOut, "Move back one square");
                move(player, -1);
                break;
            case 23:
                changeText(textOut, "");
                break;
            case 24:
                changeText(textOut, "Skip your next turn");
                player.skip = true;
                break;
            case 25:
                changeText(textOut, "");
                break;
            case 26:
                changeText(textOut, "Advance two squares");
                move(player, 2);
                break;
            case 27:
                changeText(textOut, "");
                break;
            case 28:
                changeText(textOut, "");
                break;
            case 29:
                changeText(textOut, "Move back one square");
                move(player, -1);
                break;
            case 30:
                changeText(textOut, "");
                break;
            case 31:
                changeText(textOut, "Start over!");
                move(player, -(v - 1));
                break;
            case 32:
                changeText(textOut, "");
                break;
            case 33:
                changeText(textOut, "Skip 5 squares!");
                move(player, 5);
                break;
            case 34:
                changeText(textOut, "Every player moves back two squares");
                for (int i = 0; i < numPlayers; i++) {
                    move(players.get(i), -2);
                }
                break;
            case 35:
                changeText(textOut, "");
                break;
            case 36:
                changeText(textOut, "Skip two squares");
                move(player, 2);
                break;
            case 37:
                changeText(textOut, "");
                break;
            case 38:
                changeText(textOut, "Move back one square");
                move(player, -1);
                break;
            case 39:
                changeText(textOut, "");
                break;
            case 40:
                changeText(textOut, "Skip one square");
                move(player, 1);
                break;
            case 41:
                changeText(textOut, "Roll again");
                gameLoop();
                break;
            case 42:
                changeText(textOut, "Every player moves back two squares");
                for (int i = 0; i < numPlayers; i++) {
                    move(players.get(i), -2);
                }
                break;
            case 43:
                changeText(textOut, "");
                break;
            case 44:
                changeText(textOut, "Move back one square");
                move(player, -1);
                break;
            case 45:
                changeText(textOut, "");
                break;
            case 46:
                changeText(textOut, "Skip one square");
                move(player, 1);
                break;
            case 47:
                changeText(textOut, "");
                break;
            case 48:
                changeText(textOut, "Skip your next turn");
                player.skip = true;
                break;
            case 49:
                changeText(textOut, "");
                break;
            case 50:
                changeText(textOut, "Skip one square");
                move(player, 1);
                break;
            case 51:
                changeText(textOut, "");
                break;
            case 52:
                changeText(textOut, "Skip one square");
                move(player, 1);
                break;
            case 53:
                changeText(textOut, "");
                break;
            case 54:
                changeText(textOut, "Move back 8 squares");
                move(player, -8);
                break;
            case 55:
                changeText(textOut, "");
                break;
            case 56:
                changeText(textOut, "");
                break;
            case 57:
                changeText(textOut, "Move back one square");
                move(player, -1);
                break;
            case 58:
                changeText(textOut, "");
                break;
            case 59:
                changeText(textOut, "Start over!");
                move(player, -(v - 1));
                break;
            case 60:
                changeText(textOut, "");
                break;
            case 61:
                changeText(textOut, "Skip 5 squares!");
                move(player, 5);
                break;
            case 62:
                changeText(textOut, "Every player moves back two squares");
                for (int i = 0; i < numPlayers; i++) {
                    move(players.get(i), -2);
                }
                break;
            case 63:
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