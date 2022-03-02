package com.example.blackoutboard;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

class Player {
    int position;
    public static int dice1, dice2;

    public void roll() {
        Random r = new Random();
        dice1 = r.nextInt(6+1);
        dice2 = r.nextInt(6+1);
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

    TextView[] squareTexts = new TextView[56];
    ImageView[] squareTiles = new ImageView[56];

    public static int numPlayers = 0;
    public static boolean win;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button controllerButton = findViewById(R.id.button);
        controllerButton.setOnClickListener(view -> startGame());

    }
    public void startGame() {
        TextInputEditText textin = findViewById(R.id.playertext);
        String noPlayers = textin.getText().toString();
        numPlayers = Integer.parseInt(noPlayers);
        setContentView(R.layout.gamepage);
        currentPlayerDisplay = findViewById(R.id.currentPlayerText);
        dice1Display = findViewById(R.id.dice1Display);
        dice2Display = findViewById(R.id.dice2Display);
        textOut = findViewById(R.id.textoutDisplay);
        rollButton = findViewById(R.id.rollButton);
        win = false;
        Player[] tmp = new Player[numPlayers];
        for (int c=0; c<numPlayers; c++) {
            Player tmpPlayer = new Player();
            tmpPlayer.position = 0;
            tmp[c] = tmpPlayer;
        }
        buildGame();
        textOut.setText("Roll to Begin!");
        dice1Display.setText("Dice 1: 0");
        dice2Display.setText("Dice 2: 0");
        while(!win) {
            gameLoop(tmp);
        }
    }

    public void buildGame() {
        //create board array
        TextView tex1 = findViewById(R.id.t1);
        squareTexts[0] = tex1;
        ImageView img1 = findViewById(R.id.square1);
        squareTiles[0] = img1;
        TextView tex2 = findViewById(R.id.t2);
        squareTexts[1] = tex2;
        ImageView img2 = findViewById(R.id.square2);
        squareTiles[1] = img2;
        TextView tex3 = findViewById(R.id.t3);
        squareTexts[2] = tex3;
        ImageView img3 = findViewById(R.id.square3);
        squareTiles[2] = img3;
        TextView tex4 = findViewById(R.id.t4);
        squareTexts[3] = tex4;
        ImageView img4 = findViewById(R.id.square4);
        squareTiles[3] = img4;
        TextView tex5 = findViewById(R.id.t5);
        squareTexts[4] = tex5;
        ImageView img5 = findViewById(R.id.square5);
        squareTiles[4] = img5;
        TextView tex6 = findViewById(R.id.t6);
        squareTexts[5] = tex6;
        ImageView img6 = findViewById(R.id.square6);
        squareTiles[5] = img6;
        TextView tex7 = findViewById(R.id.t7);
        squareTexts[6] = tex7;
        ImageView img7 = findViewById(R.id.square7);
        squareTiles[6] = img7;
        TextView tex8 = findViewById(R.id.t8);
        squareTexts[7] = tex8;
        ImageView img8 = findViewById(R.id.square8);
        squareTiles[7] = img8;
        TextView tex9 = findViewById(R.id.t9);
        squareTexts[8] = tex9;
        ImageView img9 = findViewById(R.id.square9);
        squareTiles[8] = img9;
        TextView tex10 = findViewById(R.id.t10);
        squareTexts[9] = tex10;
        ImageView img10 = findViewById(R.id.square10);
        squareTiles[9] = img10;
        TextView tex11 = findViewById(R.id.t11);
        squareTexts[10] = tex11;
        ImageView img11 = findViewById(R.id.square11);
        squareTiles[10] = img11;TextView tex12 = findViewById(R.id.t12);
        squareTexts[11] = tex12;
        ImageView img12 = findViewById(R.id.square12);
        squareTiles[11] = img12;TextView tex13 = findViewById(R.id.t13);
        squareTexts[12] = tex13;
        ImageView img13 = findViewById(R.id.square13);
        squareTiles[12] = img13;TextView tex14 = findViewById(R.id.t14);
        squareTexts[13] = tex14;
        ImageView img14 = findViewById(R.id.square14);
        squareTiles[13] = img14;TextView tex15 = findViewById(R.id.t15);
        squareTexts[14] = tex15;
        ImageView img15 = findViewById(R.id.square15);
        squareTiles[14] = img15;TextView tex16 = findViewById(R.id.t16);
        squareTexts[15] = tex16;
        ImageView img16 = findViewById(R.id.square16);
        squareTiles[15] = img16;TextView tex17 = findViewById(R.id.t17);
        squareTexts[16] = tex17;
        ImageView img17 = findViewById(R.id.square17);
        squareTiles[16] = img17;TextView tex18 = findViewById(R.id.t18);
        squareTexts[17] = tex18;
        ImageView img18 = findViewById(R.id.square18);
        squareTiles[17] = img18;TextView tex19 = findViewById(R.id.t19);
        squareTexts[18] = tex19;
        ImageView img19 = findViewById(R.id.square19);
        squareTiles[18] = img19;TextView tex20 = findViewById(R.id.t20);
        squareTexts[19] = tex20;
        ImageView img20 = findViewById(R.id.square20);
        squareTiles[19] = img20;TextView tex21 = findViewById(R.id.t21);
        squareTexts[20] = tex21;
        ImageView img21 = findViewById(R.id.square21);
        squareTiles[20] = img21;TextView tex22 = findViewById(R.id.t22);
        squareTexts[21] = tex22;
        ImageView img22 = findViewById(R.id.square22);
        squareTiles[21] = img22;TextView tex23 = findViewById(R.id.t23);
        squareTexts[22] = tex23;
        ImageView img23 = findViewById(R.id.square23);
        squareTiles[22] = img23;TextView tex24 = findViewById(R.id.t24);
        squareTexts[23] = tex24;
        ImageView img24 = findViewById(R.id.square24);
        squareTiles[23] = img24;TextView tex25 = findViewById(R.id.t25);
        squareTexts[24] = tex25;
        ImageView img25 = findViewById(R.id.square25);
        squareTiles[24] = img25;TextView tex26 = findViewById(R.id.t26);
        squareTexts[25] = tex26;
        ImageView img26 = findViewById(R.id.square26);
        squareTiles[25] = img26;TextView tex27 = findViewById(R.id.t27);
        squareTexts[26] = tex27;
        ImageView img27 = findViewById(R.id.square27);
        squareTiles[26] = img27;TextView tex28 = findViewById(R.id.t28);
        squareTexts[27] = tex28;
        ImageView img28 = findViewById(R.id.square28);
        squareTiles[27] = img28;TextView tex29 = findViewById(R.id.t29);
        squareTexts[28] = tex29;
        ImageView img29 = findViewById(R.id.square29);
        squareTiles[28] = img29;TextView tex30 = findViewById(R.id.t30);
        squareTexts[29] = tex30;
        ImageView img30 = findViewById(R.id.square30);
        squareTiles[29] = img30;TextView tex31 = findViewById(R.id.t31);
        squareTexts[30] = tex31;
        ImageView img31 = findViewById(R.id.square31);
        squareTiles[30] = img31;TextView tex32 = findViewById(R.id.t32);
        squareTexts[31] = tex32;
        ImageView img32 = findViewById(R.id.square32);
        squareTiles[31] = img32;TextView tex33 = findViewById(R.id.t33);
        squareTexts[32] = tex33;
        ImageView img33 = findViewById(R.id.square33);
        squareTiles[32] = img33;TextView tex34 = findViewById(R.id.t34);
        squareTexts[33] = tex34;
        ImageView img34 = findViewById(R.id.square34);
        squareTiles[33] = img34;TextView tex35 = findViewById(R.id.t35);
        squareTexts[34] = tex35;
        ImageView img35 = findViewById(R.id.square35);
        squareTiles[34] = img35;TextView tex36 = findViewById(R.id.t36);
        squareTexts[35] = tex36;
        ImageView img36 = findViewById(R.id.square36);
        squareTiles[35] = img36;TextView tex37 = findViewById(R.id.t37);
        squareTexts[36] = tex37;
        ImageView img37 = findViewById(R.id.square37);
        squareTiles[36] = img37;TextView tex38 = findViewById(R.id.t38);
        squareTexts[37] = tex38;
        ImageView img38 = findViewById(R.id.square38);
        squareTiles[37] = img38;TextView tex39 = findViewById(R.id.t39);
        squareTexts[38] = tex39;
        ImageView img39 = findViewById(R.id.square39);
        squareTiles[38] = img39;TextView tex40 = findViewById(R.id.t40);
        squareTexts[39] = tex40;
        ImageView img40 = findViewById(R.id.square40);
        squareTiles[39] = img40;TextView tex41 = findViewById(R.id.t41);
        squareTexts[40] = tex41;
        ImageView img41 = findViewById(R.id.square41);
        squareTiles[40] = img41;TextView tex42 = findViewById(R.id.t42);
        squareTexts[41] = tex42;
        ImageView img42 = findViewById(R.id.square42);
        squareTiles[41] = img42;TextView tex43 = findViewById(R.id.t43);
        squareTexts[42] = tex43;
        ImageView img43 = findViewById(R.id.square43);
        squareTiles[42] = img43;TextView tex44 = findViewById(R.id.t44);
        squareTexts[43] = tex44;
        ImageView img44 = findViewById(R.id.square44);
        squareTiles[43] = img44;TextView tex45 = findViewById(R.id.t45);
        squareTexts[44] = tex45;
        ImageView img45 = findViewById(R.id.square45);
        squareTiles[44] = img45;TextView tex46 = findViewById(R.id.t46);
        squareTexts[45] = tex46;
        ImageView img46 = findViewById(R.id.square46);
        squareTiles[45] = img46;TextView tex47 = findViewById(R.id.t47);
        squareTexts[46] = tex47;
        ImageView img47 = findViewById(R.id.square47);
        squareTiles[46] = img47;TextView tex48 = findViewById(R.id.t48);
        squareTexts[47] = tex48;
        ImageView img48 = findViewById(R.id.square48);
        squareTiles[47] = img48;TextView tex49 = findViewById(R.id.t49);
        squareTexts[48] = tex49;
        ImageView img49 = findViewById(R.id.square49);
        squareTiles[48] = img49;TextView tex50 = findViewById(R.id.t50);
        squareTexts[49] = tex50;
        ImageView img50 = findViewById(R.id.square50);
        squareTiles[49] = img50;TextView tex51 = findViewById(R.id.t51);
        squareTexts[50] = tex51;
        ImageView img51 = findViewById(R.id.square51);
        squareTiles[50] = img51;TextView tex52 = findViewById(R.id.t52);
        squareTexts[51] = tex52;
        ImageView img52 = findViewById(R.id.square52);
        squareTiles[51] = img52;TextView tex53 = findViewById(R.id.t53);
        squareTexts[52] = tex53;
        ImageView img53 = findViewById(R.id.square53);
        squareTiles[52] = img53;TextView tex54 = findViewById(R.id.t54);
        squareTexts[53] = tex54;
        ImageView img54 = findViewById(R.id.square54);
        squareTiles[53] = img54;TextView tex55 = findViewById(R.id.t55);
        squareTexts[54] = tex55;
        ImageView img55 = findViewById(R.id.square55);
        squareTiles[54] = img55; TextView tex56 = findViewById(R.id.t56);
        squareTexts[55] = tex56;
        ImageView img56 = findViewById(R.id.square56);
        squareTiles[55] = img56;
    }

    public void gameLoop(Player[] players) {
        for (int i=0; i<numPlayers; i++) {
            changeText(currentPlayerDisplay,"Player " + i);
            final int cplayer = i;
            rollButton.setOnClickListener(view -> {
                players[cplayer].roll();
                dice1Display.setText("Dice 1: " + players[cplayer].dice1);
                dice2Display.setText("Dice 2: " + players[cplayer].dice2);
                int tmpMove = players[cplayer].dice1 + players[cplayer].dice2;
                int oPos = players[cplayer].position;
                changeVis(squareTexts[oPos], false);
                changeVis(squareTiles[oPos], false);
                players[cplayer].move(tmpMove);
                int cPos = players[cplayer].position;
                if (squareTiles[cPos].getVisibility() == View.INVISIBLE) {
                    changeText(squareTexts[cPos], "" + cplayer);
                    changeVis(squareTexts[cPos], true);
                    changeVis(squareTiles[cPos], true);
                } else {
                    changeText(squareTexts[cPos], squareTexts[cPos].getText().toString() + "," + cplayer);
                }
            });
        }
    }
    public void changeText(TextView thisText, String text) {
            thisText.setText(text);
    }
    public void changeVis(View thisView, boolean appear) {
        if (appear) {
            thisView.setVisibility(View.VISIBLE);
        } else {
            thisView.setVisibility(View.INVISIBLE);
        }
    }
}