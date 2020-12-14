package com.sampleshow.android.sampleshow;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int player1DrawCount = 0;
    private int player2DrawCount = 0;
    private int totalDrawCount = 0;
    private int totalBetMoney=0;
    private int player1BetMoney=0;
    private int player2BetMoney=0;
    private int hiddenImageRes1;
    private int hiddenImageRes2;

    private boolean isStarted =false;
    private boolean isChecked=false;

    private int turn;

    List<Integer> randomList = new ArrayList<>();

    private ArrayList<Card> cards=new ArrayList<Card>();
    private ArrayList<Card> player1Cards = new ArrayList<Card>();
    private ArrayList<Card> player2Cards = new ArrayList<Card>();
    private ArrayList<Card> player1ReducedCards=new ArrayList<>();
    private ArrayList<Card> player2ReducedCards=new ArrayList<>();

    private StringBuilder trueValue = new StringBuilder();

    private String player1Value;
    private String player2Value;

    private String player1TrueValue;
    private String player2TrueValue;

    private int player1Power;
    private int player2Power;

    private int indexForCardImage;

    private String[] powerArray = new String[125];
    private ArrayList<String> powerList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        indexForCardImage=1;

        powerArray[0] = "HC9C";
        powerArray[1] = "HC9D";
        powerArray[2] = "HC9H";
        powerArray[3] = "HC9S";

        powerArray[4] = "HC10C";
        powerArray[5] = "HC10D";
        powerArray[6] = "HC10H";
        powerArray[7] = "HC10S";

        powerArray[8] = "HC11C";
        powerArray[9] = "HC11D";
        powerArray[10] = "HC11H";
        powerArray[11] = "HC11S";

        powerArray[12] = "HC12C";
        powerArray[13] = "HC12D";
        powerArray[14] = "HC12H";
        powerArray[15] = "HC12S";

        powerArray[16] = "HC13C";
        powerArray[17] = "HC13D";
        powerArray[18] = "HC13H";
        powerArray[19] = "HC13S";

        powerArray[20] = "HC14C";
        powerArray[21] = "HC14D";
        powerArray[22] = "HC14H";
        powerArray[23] = "HC14S";

        powerArray[24] = "OP9D";
        powerArray[25] = "OP9H";
        powerArray[26] = "OP9S";
        powerArray[27] = "OP10D";
        powerArray[28] = "OP10H";
        powerArray[29] = "OP10S";
        powerArray[30] = "OP11D";
        powerArray[31] = "OP11H";
        powerArray[32] = "OP11S";
        powerArray[33] = "OP12D";
        powerArray[34] = "OP12H";
        powerArray[35] = "OP12S";
        powerArray[36] = "OP13D";
        powerArray[37] = "OP13H";
        powerArray[38] = "OP13S";
        powerArray[39] = "OP14D";
        powerArray[40] = "OP14H";
        powerArray[41] = "OP14S";

        powerArray[42] = "TP109D";
        powerArray[43] = "TP109H";
        powerArray[44] = "TP109S";
        powerArray[45] = "TP119D";
        powerArray[46] = "TP119H";
        powerArray[47] = "TP119S";
        powerArray[48] = "TP1110D";
        powerArray[49] = "TP1110H";
        powerArray[50] = "TP1110S";

        powerArray[51] = "TP129D";
        powerArray[52] = "TP129H";
        powerArray[53] = "TP129S";
        powerArray[54] = "TP1210D";
        powerArray[55] = "TP1210H";
        powerArray[56] = "TP1210S";
        powerArray[57] = "TP1211D";
        powerArray[58] = "TP1211H";
        powerArray[59] = "TP1211S";
        powerArray[60] = "TP139D";

        powerArray[61] = "TP139H";
        powerArray[62] = "TP139S";
        powerArray[63] = "TP1310D";
        powerArray[64] = "TP1310H";
        powerArray[65] = "TP1310S";
        powerArray[66] = "TP1311D";
        powerArray[67] = "TP1311H";
        powerArray[68] = "TP1311S";
        powerArray[69] = "TP1312D";
        powerArray[70] = "TP1312H";

        powerArray[71] = "TP1312S";
        powerArray[72] = "TP149D";
        powerArray[73] = "TP149H";
        powerArray[74] = "TP149S";
        powerArray[75] = "TP1410D";
        powerArray[76] = "TP1410H";
        powerArray[77] = "TP1410S";
        powerArray[78] = "TP1411D";
        powerArray[79] = "TP1411H";
        powerArray[80] = "TP1411S";

        powerArray[81] = "TP1412D";
        powerArray[82] = "TP1412H";
        powerArray[83] = "TP1412S";
        powerArray[84] = "TP1413D";
        powerArray[85] = "TP1413H";
        powerArray[86] = "TP1413S";
        powerArray[87] = "TK9";
        powerArray[88] = "TK10";
        powerArray[89] = "TK11";
        powerArray[90] = "TK12";

        powerArray[91] = "TK13";
        powerArray[92] = "TK14";
        powerArray[93] = "ST13C";
        powerArray[94] = "ST13D";
        powerArray[95] = "ST13H";
        powerArray[96] = "ST13S";
        powerArray[97] = "ST14C";
        powerArray[98] = "ST14D";
        powerArray[99] = "ST14H";
        powerArray[100] = "ST14S";

        powerArray[101] = "FLC";
        powerArray[102] = "FLD";
        powerArray[103] = "FLH";
        powerArray[104] = "FLS";
        powerArray[105] = "FH9";
        powerArray[106] = "FH10";
        powerArray[107] = "FH11";
        powerArray[108] = "FH12";
        powerArray[109] = "FH13";
        powerArray[110] = "FH14";

        powerArray[111] = "FK9";
        powerArray[112] = "FK10";
        powerArray[113] = "FK11";
        powerArray[114] = "FK12";
        powerArray[115] = "FK13";
        powerArray[116] = "FK14";
        powerArray[117] = "SF13C";
        powerArray[118] = "SF13D";
        powerArray[119] = "SF13H";
        powerArray[120] = "SF13S";

        powerArray[121] = "RF14C";
        powerArray[122] = "RF14D";
        powerArray[123] = "RF14H";
        powerArray[124] = "RF14S";

        for (int i = 0; i < 105; i++) {
            powerList.add(powerArray[i]);
        }


        for (int i = 0; i <= 23; i++) {
            randomList.add(i);
        }
        Collections.shuffle(randomList);


        cards.add(new Card(14, "S", R.drawable._1s));
        cards.add(new Card(9, "S", R.drawable._9s));
        cards.add(new Card(10, "S", R.drawable._10s));
        cards.add(new Card(11, "S", R.drawable._11s));
        cards.add(new Card(12, "S", R.drawable._12s));
        cards.add(new Card(13, "S", R.drawable._13s));

        cards.add(new Card(14, "H", R.drawable._1h));
        cards.add(new Card(9, "H", R.drawable._9h));
        cards.add(new Card(10, "H", R.drawable._10h));
        cards.add(new Card(11, "H", R.drawable._11h));
        cards.add(new Card(12, "H", R.drawable._12h));
        cards.add(new Card(13, "H", R.drawable._13h));

        cards.add(new Card(14, "D", R.drawable._1d));
        cards.add(new Card(9, "D", R.drawable._9d));
        cards.add(new Card(10, "D", R.drawable._10d));
        cards.add(new Card(11, "D", R.drawable._11d));
        cards.add(new Card(12, "D", R.drawable._12d));
        cards.add(new Card(13, "D", R.drawable._13d));

        cards.add(new Card(14, "C", R.drawable._1c));
        cards.add(new Card(9, "C", R.drawable._9c));
        cards.add(new Card(10, "C", R.drawable._10c));
        cards.add(new Card(11, "C", R.drawable._11c));
        cards.add(new Card(12, "C", R.drawable._12c));
        cards.add(new Card(13, "C", R.drawable._13c));

        LinearLayout cardContainerPlayer1 = findViewById(R.id.cardContainer_player1);
        LinearLayout cardContainerPlayer2 = findViewById(R.id.cardContainer_player2);
        Button betBtn=findViewById(R.id.bet_btn);
        Button callBtn = findViewById(R.id.call_btn);
        Button foldBtn = findViewById(R.id.fold_btn);
        Button restartBtn= findViewById(R.id.start_btn);
        Button checkBtn=findViewById(R.id.check_btn);
        TextView player1ValueTV = findViewById(R.id.player1_value);
        TextView player2ValueTV = findViewById(R.id.player2_value);
        TextView winnerTV=findViewById(R.id.winner_textView);
        TextView totalBetMoneyTV=findViewById(R.id.total_bet_money);
        TextView player1BetMoneyTV=findViewById(R.id.player1_betMoney);
        TextView player2BetMoneyTV=findViewById(R.id.player2_betMoney);
        TextView playerTurnTV=findViewById(R.id.player_turn_tv);
        TextView betAmountTV=findViewById(R.id.bet_amount_tv);
        SeekBar betAmountSB=findViewById(R.id.bet_amount_sb);

        callBtn.setVisibility(View.GONE);
        betAmountSB.setMax(1000);
        betAmountSB.setMin(110);

        totalBetMoneyTV.setText(String.valueOf(totalBetMoney));
        betAmountTV.setText(betAmountSB.getProgress()+"/"+betAmountSB.getMax());

        betAmountSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                betAmountTV.setText(betAmountSB.getProgress()+"/"+betAmountSB.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                betAmountTV.setText(betAmountSB.getProgress()+"/"+betAmountSB.getMax());
            }
        });

        //Give initial 2 cards to each player when the activity is created
        for (int i = 1; i <= 2; i++) {
            if(i==1){
                addBackfaceCard(cardContainerPlayer1);
                hiddenImageRes1=cards.get(randomList.get(totalDrawCount)).getImageRes();
            }else if(i==2) {
                updateUIForCards(cardContainerPlayer1,indexForCardImage);
                player1ReducedCards.add(cards.get(randomList.get(totalDrawCount)));
            }
            //Storing number and value of drawn/used cards
            player1Cards.add(cards.get(randomList.get(totalDrawCount)));

            totalDrawCount++;
            player1DrawCount++;

            player1Value = calculateValue(player1DrawCount, player1Cards);
            player1ValueTV.setText(player1Value);

            if(i==1) {
                addBackfaceCard(cardContainerPlayer2);
                hiddenImageRes2=cards.get(randomList.get(totalDrawCount)).getImageRes();
            }else if(i==2){
                updateUIForCards(cardContainerPlayer2,indexForCardImage);
                player2ReducedCards.add(cards.get(randomList.get(totalDrawCount)));
            }

            //Storing number and value of drawn/used cards
            player2Cards.add(cards.get(randomList.get(totalDrawCount)));

            totalDrawCount++;
            player2DrawCount++;

            player2Value = calculateValue(player2DrawCount, player2Cards);
            player2ValueTV.setText(player2Value);
        }
        indexForCardImage++;

        turn=decideTurn();
        setPlayerTurn(turn,playerTurnTV);

        if(turn==1){
            revealHiddenCard(cardContainerPlayer1,hiddenImageRes1);
        }else if(turn==2){
            revealHiddenCard(cardContainerPlayer2,hiddenImageRes2);
        }

        //Initial bet amount 100
        player1BetMoney=100;
        player2BetMoney=100;
        player1BetMoneyTV.setText(String.valueOf(player1BetMoney));
        player2BetMoneyTV.setText(String.valueOf(player2BetMoney));


        betBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (turn == 1) {
                        player1BetMoney = betAmountSB.getProgress();
                        player1BetMoneyTV.setText(String.valueOf(player1BetMoney));
                        betAmountSB.setMin(player1BetMoney+10);
                        turn = 2;
                        hideFirstCard(cardContainerPlayer1);
                        revealHiddenCard(cardContainerPlayer2,hiddenImageRes2);
                    } else if (turn == 2) {
                        player2BetMoney = betAmountSB.getProgress();
                        player2BetMoneyTV.setText(String.valueOf(player2BetMoney));
                        betAmountSB.setMin(player2BetMoney+10);
                        turn = 1;
                        hideFirstCard(cardContainerPlayer2);
                        revealHiddenCard(cardContainerPlayer1,hiddenImageRes1);
                    }
                    setPlayerTurn(turn, playerTurnTV);
                    checkBtn.setVisibility(View.GONE);
                    callBtn.setVisibility(View.VISIBLE);
            }
        });

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isChecked) {
                    if (turn == 1) {
                        turn = 2;
                        player1BetMoneyTV.setText("Checked");
                        setPlayerTurn(turn, playerTurnTV);
                        hideFirstCard(cardContainerPlayer1);
                        revealHiddenCard(cardContainerPlayer2,hiddenImageRes2);
                    }else if (turn == 2) {
                        turn = 1;
                        player2BetMoneyTV.setText("Checked");
                        setPlayerTurn(turn, playerTurnTV);
                        hideFirstCard(cardContainerPlayer2);
                        revealHiddenCard(cardContainerPlayer1,hiddenImageRes1);
                    }
                    isChecked=true;
                }else{
                    if(totalDrawCount<10){
                        totalBetMoney+=player1BetMoney+player2BetMoney;
                        totalBetMoneyTV.setText(String.valueOf(totalBetMoney));
                        player1BetMoneyTV.setText("");
                        player2BetMoneyTV.setText("");

                        updateUIForCards(cardContainerPlayer1,indexForCardImage);

                        //Storing number and value of drawn/used cards
                        player1ReducedCards.add(cards.get(randomList.get(totalDrawCount)));
                        player1Cards.add(cards.get(randomList.get(totalDrawCount)));

                        totalDrawCount++;
                        player1DrawCount++;

                        player1Value = calculateValue(player1DrawCount, player1Cards);
                        player1ValueTV.setText(player1Value);


                        updateUIForCards(cardContainerPlayer2,indexForCardImage);

                        //Storing number and value of drawn/used cards
                        player2ReducedCards.add(cards.get(randomList.get(totalDrawCount)));
                        player2Cards.add(cards.get(randomList.get(totalDrawCount)));

                        totalDrawCount++;
                        player2DrawCount++;

                        indexForCardImage++;

                        player2Value = calculateValue(player2DrawCount, player2Cards);
                        player2ValueTV.setText(player2Value);

                        turn=decideTurn();
                        setPlayerTurn(turn, playerTurnTV);
                        if(turn==1){
                            hideFirstCard(cardContainerPlayer2);
                            revealHiddenCard(cardContainerPlayer1,hiddenImageRes1);
                        }else if(turn==2){
                            hideFirstCard(cardContainerPlayer1);
                            revealHiddenCard(cardContainerPlayer2,hiddenImageRes2);
                        }

                        betAmountSB.setMin(100);
                        betAmountSB.setProgress(100);
                    }else if(totalDrawCount==10){
                        //reveal the hidden 1st card
                       revealHiddenCard(cardContainerPlayer1,hiddenImageRes1);
                       revealHiddenCard(cardContainerPlayer2,hiddenImageRes2);

                        player1BetMoneyTV.setText("");
                        player2BetMoneyTV.setText("");

                        player1TrueValue = calculateTrueValue(player1Cards, player1Value);
                        player1Power = calculatePower(player1TrueValue);

                        player2TrueValue = calculateTrueValue(player2Cards, player2Value);
                        player2Power = calculatePower(player2TrueValue);

                        winnerTV.setText(decideWinner());
                    }
                    isChecked=false;
                    player1BetMoney=0;
                    player2BetMoney=0;
                }
            }
        });

        foldBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turn==1){
                    player1BetMoneyTV.setText("Folded");
                    turn=2;
                    setPlayerTurn(turn,playerTurnTV);
                    winnerTV.setText("Player 2 is winner");
                }else if(turn==2){
                    player2BetMoneyTV.setText("Folded");
                    turn=1;
                    setPlayerTurn(turn,playerTurnTV);
                    winnerTV.setText("Player 1 is winner");
                }
            }
        });
        
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(totalDrawCount<10) {
                    if (turn == 2) {
                        player2BetMoney = player1BetMoney;
                        totalBetMoney += player1BetMoney+player2BetMoney;
                        player2BetMoneyTV.setText(String.valueOf(player2BetMoney));
                        totalBetMoneyTV.setText(String.valueOf(totalBetMoney));

                    }
                    if (turn == 1) {
                        player1BetMoney = player2BetMoney;
                        totalBetMoney += player1BetMoney+player2BetMoney;
                        player1BetMoneyTV.setText(String.valueOf(player1BetMoney));
                        totalBetMoneyTV.setText(String.valueOf(totalBetMoney));
                    }
                    player1BetMoney=0;
                    player2BetMoney=0;
                    player1BetMoneyTV.setText("");
                    player2BetMoneyTV.setText("");
                    updateUIForCards(cardContainerPlayer1,indexForCardImage);
                    //Storing number and value of drawn/used cards
                    player1ReducedCards.add(cards.get(randomList.get(totalDrawCount)));
                    player1Cards.add(cards.get(randomList.get(totalDrawCount)));

                    totalDrawCount++;
                    player1DrawCount++;

                    player1Value = calculateValue(player1DrawCount, player1Cards);
                    player1ValueTV.setText(player1Value);


                    updateUIForCards(cardContainerPlayer2,indexForCardImage);

                    //Storing number and value of drawn/used cards
                    player2ReducedCards.add(cards.get(randomList.get(totalDrawCount)));
                    player2Cards.add(cards.get(randomList.get(totalDrawCount)));

                    totalDrawCount++;
                    player2DrawCount++;

                    indexForCardImage++;

                    player2Value = calculateValue(player2DrawCount, player2Cards);
                    player2ValueTV.setText(player2Value);


                    checkBtn.setVisibility(View.VISIBLE);
                    callBtn.setVisibility(View.GONE);


                    turn=decideTurn();
                    setPlayerTurn(turn, playerTurnTV);
                    if(turn==1){
                        hideFirstCard(cardContainerPlayer2);
                        revealHiddenCard(cardContainerPlayer1,hiddenImageRes1);
                    }else if(turn==2){
                        hideFirstCard(cardContainerPlayer1);
                        revealHiddenCard(cardContainerPlayer2,hiddenImageRes2);
                    }

                    betAmountSB.setMin(100);
                    betAmountSB.setProgress(100);
                }else if(totalDrawCount==10) {
                    if (turn == 2) {
                        player2BetMoney = player1BetMoney;
                        totalBetMoney += player1BetMoney+player2BetMoney;
                        player2BetMoneyTV.setText(String.valueOf(player2BetMoney));
                        totalBetMoneyTV.setText(String.valueOf(totalBetMoney));

                    }
                    if (turn == 1) {
                        player1BetMoney = player2BetMoney;
                        totalBetMoney += player1BetMoney+player2BetMoney;
                        player1BetMoneyTV.setText(String.valueOf(player1BetMoney));
                        totalBetMoneyTV.setText(String.valueOf(totalBetMoney));
                    }
                    player1BetMoney=0;
                    player2BetMoney=0;

                    //reveal the hidden 1st card
                    revealHiddenCard(cardContainerPlayer1,hiddenImageRes1);
                    revealHiddenCard(cardContainerPlayer2,hiddenImageRes2);

                    player1BetMoneyTV.setText("");
                    player2BetMoneyTV.setText("");

                    player1TrueValue = calculateTrueValue(player1Cards, player1Value);
                    player1Power = calculatePower(player1TrueValue);

                    player2TrueValue = calculateTrueValue(player2Cards, player2Value);
                    player2Power = calculatePower(player2TrueValue);

                    winnerTV.setText(decideWinner());
                }
            }
        });

        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    cardContainerPlayer1.removeAllViews();
                    cardContainerPlayer2.removeAllViews();
                    player1DrawCount = 0;
                    player2DrawCount = 0;
                    totalDrawCount = 0;
                    player1ValueTV.setText("");
                    player2ValueTV.setText("");
                    player1Cards.clear();
                    player2Cards.clear();
                    player1ReducedCards.clear();
                    player2ReducedCards.clear();
                    winnerTV.setText("");
                    player1BetMoney=100;
                    player2BetMoney=100;
                    player1BetMoneyTV.setText(String.valueOf(player1BetMoney));
                    player2BetMoneyTV.setText(String.valueOf(player2BetMoney));
                    totalBetMoneyTV.setText("");
                    totalBetMoney=0;
                    betAmountSB.setMin(110);
                    betAmountSB.setProgress(110);
                    indexForCardImage=1;

                    callBtn.setVisibility(View.GONE);
                    checkBtn.setVisibility(View.VISIBLE);

                    Collections.shuffle(randomList);

                    for (int i = 1; i <= 2; i++) {
                        if(i==1){
                            addBackfaceCard(cardContainerPlayer1);
                            hiddenImageRes1=cards.get(randomList.get(totalDrawCount)).getImageRes();
                        }else if(i==2) {
                            player1ReducedCards.add(cards.get(randomList.get(totalDrawCount)));
                            updateUIForCards(cardContainerPlayer1,indexForCardImage);
                        }

                        //Storing number and value of drawn/used cards
                        player1Cards.add(cards.get(randomList.get(totalDrawCount)));

                        totalDrawCount++;
                        player1DrawCount++;

                        player1Value = calculateValue(player1DrawCount, player1Cards);
                        player1ValueTV.setText(player1Value);

                        if(i==1){
                            addBackfaceCard(cardContainerPlayer2);
                            hiddenImageRes2=cards.get(randomList.get(totalDrawCount)).getImageRes();
                        }else if(i==2) {
                            player2ReducedCards.add(cards.get(randomList.get(totalDrawCount)));
                            updateUIForCards(cardContainerPlayer2,indexForCardImage);
                        }

                        //Storing number and value of drawn/used cards
                        player2Cards.add(cards.get(randomList.get(totalDrawCount)));

                        totalDrawCount++;
                        player2DrawCount++;

                        player2Value = calculateValue(player2DrawCount, player2Cards);
                        player2ValueTV.setText(player2Value);

                    }
                indexForCardImage++;

                turn=decideTurn();
                setPlayerTurn(turn,playerTurnTV);

                //reveal the hidden 1st card for the turn player
                if(turn==1){
                    revealHiddenCard(cardContainerPlayer1,hiddenImageRes1);
                }else if(turn==2){
                    revealHiddenCard(cardContainerPlayer2,hiddenImageRes2);
                }
                }
        });
    }

    private String calculateValue(int playerDrawCount, ArrayList<Card> playerCards) {

        if (playerDrawCount == 1) {
            return "High Card";
        } else if (playerDrawCount == 2) {
            if (playerCards.get(0).getNumber() == playerCards.get(1).getNumber()) {
                return "One Pair";
            } else {
                return "High Card";
            }
        } else if (playerDrawCount == 3) {
            int n1 = playerCards.get(0).getNumber();
            int n2 = playerCards.get(1).getNumber();
            int n3 = playerCards.get(2).getNumber();
            if ((n1 == n2) && (n2 == n3)) {
                return "Three of a kind";
            } else if ((n1 == n2) ||
                    (n2 == n3) ||
                    (n1 == n3)) {
                return "One Pair";
            } else {
                return "High Card";
            }
        } else if (playerDrawCount == 4) {
            int n1 = playerCards.get(0).getNumber();
            int n2 = playerCards.get(1).getNumber();
            int n3 = playerCards.get(2).getNumber();
            int n4 = playerCards.get(3).getNumber();
//            Log.i("Main Activity","The numbers are" +n1+n2+n3+n4);
            if ((n1 == n2) && (n2 == n3) && (n3 == n4)) {
                return "Four of a kind";
            } else if (((n1 == n2) && (n2 == n3)) ||
                    ((n1 == n2) && (n2 == n4)) ||
                    ((n1 == n3) && (n3 == n4)) ||
                    ((n2 == n3) && (n3 == n4))
            ) {
                return "Three of a kind";
            } else if (((n1 == n2) && (n3 == n4)) ||
                    ((n1 == n4) && (n2 == n3)) ||
                    ((n1 == n3) && (n2 == n4))
            ) {
                return "Two Pair";
            } else if (((n1 == n2) || (n1 == n3) || (n1 == n4) || (n2 == n3) || (n2 == n4) || (n3 == n4))) {
                return "One Pair";
            } else {
                return "High Card";
            }
        } else if (playerDrawCount == 5) {
            //Sorting is important.
            Collections.sort(playerCards);

            int[] numbers = new int[5];
            numbers[0] = playerCards.get(0).getNumber();
            numbers[1] = playerCards.get(1).getNumber();
            numbers[2] = playerCards.get(2).getNumber();
            numbers[3] = playerCards.get(3).getNumber();
            numbers[4] = playerCards.get(4).getNumber();

            String v1 = playerCards.get(0).getValue();
            String v2 = playerCards.get(1).getValue();
            String v3 = playerCards.get(2).getValue();
            String v4 = playerCards.get(3).getValue();
            String v5 = playerCards.get(4).getValue();

//            Log.i("Main Activity","Numbers: "+numbers[0]+numbers[1]+numbers[2]+numbers[3]+numbers[4]);

            if ((numbers[0] == 9 && numbers[1] == 10 && numbers[2] == 11 && numbers[3] == 12 && numbers[4] == 13) ||
                    (numbers[0] == 10 && numbers[1] == 11 && numbers[2] == 12 && numbers[3] == 13 && numbers[4] == 14)
            ) {
                String value = "Straight";
                if ((v1.equals(v2)) && (v2.equals(v3)) && (v3.equals(v4)) && (v4.equals(v5))) {
                    value = "Straight Flush";
                    if (numbers[4] == 14) {
                        value = "Royal Flush";
                    }
                }
                return value;
            } else if ((v1.equals(v2)) && (v2.equals(v3)) && (v3.equals(v4)) && (v4.equals(v5))) {
                return "Flush";
            } else if (((numbers[1] == numbers[2]) && (numbers[2] == numbers[3]) && (numbers[3] == numbers[4]))
                    || ((numbers[0] == numbers[1]) && (numbers[1] == numbers[2]) && (numbers[2] == numbers[3]))
            ) {
                return "Four of a kind";
            } else if (((numbers[0] == numbers[1]) && (numbers[1] == numbers[2]) && (numbers[3] == numbers[4]))
                    || ((numbers[0] == numbers[1]) && (numbers[2] == numbers[3]) && (numbers[3] == numbers[4]))
            ) {
                return "Full House";
            } else if (((numbers[0] == numbers[1]) && (numbers[1] == numbers[2]))
                    || ((numbers[1] == numbers[2]) && (numbers[2] == numbers[3]))
                    || ((numbers[2] == numbers[3]) && (numbers[3] == numbers[4]))
            ) {
                return "Three of a kind";
            } else if (((numbers[0] == numbers[1]) && (numbers[2] == numbers[3]))
                    || ((numbers[0] == numbers[1]) && (numbers[3] == numbers[4]))
                    || ((numbers[1] == numbers[2]) && (numbers[3] == numbers[4]))
            ) {
                return "Two Pair";
            } else if ((numbers[0] == numbers[1])
                    || (numbers[1] == numbers[2])
                    || (numbers[2] == numbers[3])
                    || (numbers[3] == numbers[4])
            ) {
                return "One Pair";
            } else {
                return "High Card";
            }
        }
        return null;
    }

    /* This method is called when it is already known as "One Pair".
        This method finds that one pair's value and line then return as string.
     */
    private String findOnePairValue(int[] numbers, String[] lines) {
        String pairNumber = "";
        String pairLine = "";
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] == numbers[i + 1]) {
                pairNumber = String.valueOf(numbers[i]);
                if ((lines[i].equals("S")) || (lines[i + 1].equals("S"))) {
                    pairLine = "S";
                    return pairNumber + pairLine;
                } else if ((lines[i].equals("H")) || (lines[i + 1].equals("H"))) {
                    pairLine = "H";
                    return pairNumber + pairLine;
                } else if ((lines[i].equals("D")) || (lines[i + 1].equals("D"))) {
                    pairLine = "D";
                    return pairNumber + pairLine;
                }
            }
        return "No One-Pair";
    }

    /* This method is called when it is already known as "Two Pair".
        This method finds the numbers of each pair and line of the greater pair then returns as String.
     */
    private String findTwoPairValue(int[] numbers, String[] lines) {
        String smallerPair = "";
        String greaterPair = "";
        String greaterPairLine = "";

        smallerPair = String.valueOf(numbers[1]);
        greaterPair = String.valueOf(numbers[3]);

        if (numbers[2] == numbers[3]) {
            if ((lines[2].equals("S")) || (lines[3].equals("S"))) {
                greaterPairLine = "S";
                return greaterPair + smallerPair + greaterPairLine;
            } else if ((lines[2].equals("H")) || (lines[3].equals("H"))) {
                greaterPairLine = "H";
                return greaterPair + smallerPair + greaterPairLine;
            } else if ((lines[2].equals("D")) || (lines[3].equals("D"))) {
                greaterPairLine = "D";
                return greaterPair + smallerPair + greaterPairLine;
            }
        } else if (numbers[3] == numbers[4]) {
            if ((lines[3].equals("S")) || (lines[4].equals("S"))) {
                greaterPairLine = "S";
                return greaterPair + smallerPair + greaterPairLine;
            } else if ((lines[3].equals("H")) || (lines[4].equals("H"))) {
                greaterPairLine = "H";
                return greaterPair + smallerPair + greaterPairLine;
            } else if ((lines[3].equals("D")) || (lines[4].equals("D"))) {
                greaterPairLine = "D";
                return greaterPair + smallerPair + greaterPairLine;
            }
        }
        return "No Two Pair";
    }

    private String findThreeKindValue(int[] numbers) {
        return String.valueOf(numbers[2]);
    }

    private String findFourKindValue(int[] numbers) {
        return String.valueOf(numbers[2]);
    }

    private String findFullHouseValue(int[] numbers) {
        String threePairNumber = "";
        if ((numbers[0] == numbers[1]) || (numbers[1] == numbers[2])) {
            threePairNumber = String.valueOf(numbers[0]);
            return threePairNumber;
        } else if ((numbers[2] == numbers[3]) || (numbers[3] == numbers[4])) {
            threePairNumber = String.valueOf(numbers[2]);
            return threePairNumber;
        }
        return "No Full House";
    }

    private String findStraightValue(int[] numbers, String[] lines) {
        String straightNumber = String.valueOf(numbers[4]);
        String straightLine = lines[4];

        return straightNumber + straightLine;
    }

    private String findFlushValue(String lines[]) {
        return lines[0];
    }

    private String findStraightFlushValue(int[] numbers, String[] lines) {
        String sfNumber = String.valueOf(numbers[4]);
        String sfLine = lines[4];

        return sfNumber + sfLine;
    }

    private String calculateTrueValue(ArrayList<Card> playerCards, String playerValue) {
        String trueValueStr = "";
        Collections.sort(playerCards);
        int[] numbers = new int[playerCards.size()];
        for (int i=0;i<playerCards.size();i++){
            numbers[i]=playerCards.get(i).getNumber();
        }

        String[] lines = new String[playerCards.size()];
        for(int i=0;i<playerCards.size();i++){
            lines[i]=playerCards.get(i).getValue();
        }

        if (playerValue.equals("High Card")) {
            trueValueStr = "HC" + numbers[playerCards.size()-1] + lines[playerCards.size()-1];
        } else if (playerValue.equals("One Pair")) {
            trueValueStr = "OP" + findOnePairValue(numbers, lines);
        } else if (playerValue.equals("Two Pair")) {
            trueValueStr = "TP" + findTwoPairValue(numbers, lines);
        } else if (playerValue.equals("Three of a kind")) {
            trueValueStr = "TK" + findThreeKindValue(numbers);
        } else if (playerValue.equals("Four of a kind")) {
            trueValueStr = "FK" + findFourKindValue(numbers);
        } else if (playerValue.equals("Full House")) {
            trueValueStr = "FH" + findFullHouseValue(numbers);
        } else if (playerValue.equals("Straight")) {
            trueValueStr = "ST" + findStraightValue(numbers, lines);
        } else if (playerValue.equals("Flush")) {
            trueValueStr = "FL" + findFlushValue(lines);
        } else if (playerValue.equals("Straight Flush")) {
            trueValueStr = "SF" + findStraightFlushValue(numbers, lines);
        } else if (playerValue.equals("Royal Flush")) {
            trueValueStr = "RF" + findStraightFlushValue(numbers, lines);
        }
        return trueValueStr;
    }
    private int calculatePower(String playerTrueValue){
        return powerList.indexOf(playerTrueValue);
    }
    private String decideWinner(){
        if(player1Power>player2Power){
            return "Player 1 is the winner.";
        }else{
            return "Player 2 is the winner";
        }
    }
    private void addBackfaceCard(LinearLayout cardContainer){
        ImageView cardImage=new ImageView(MainActivity.this);
        cardImage.setImageDrawable(getResources().getDrawable(R.drawable.backface_card));
        int dp1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, MainActivity.this.getResources().getDisplayMetrics());
        cardImage.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 80 * dp1));
        cardImage.setAdjustViewBounds(true);
        cardContainer.addView(cardImage,0);
    }
    private void updateUIForCards(LinearLayout cardContainer,int cardImageIndex){
        ImageView cardImage = new ImageView(MainActivity.this);
        cardImage.setImageDrawable(getResources().getDrawable(cards.get(randomList.get(totalDrawCount)).getImageRes()));
        int dp1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, MainActivity.this.getResources().getDisplayMetrics());
        cardImage.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 80 * dp1));
        cardImage.setAdjustViewBounds(true);
        cardContainer.addView(cardImage,cardImageIndex);
    }
    private void setPlayerTurn(int turn,TextView container){
        if(turn==1){
            container.setText("Player 1 Turn");
        }else if(turn==2){
            container.setText("Player 2 Turn");
        }
    }
    private int decideTurn(){
        String player1ReducedValue=calculateValue(player1DrawCount-1,player1ReducedCards);
        int player1ReducedPower=calculatePower(calculateTrueValue(player1ReducedCards,player1ReducedValue));

        String player2ReducedValue=calculateValue(player2DrawCount-1,player2ReducedCards);
        int player2ReducedPower=calculatePower(calculateTrueValue(player2ReducedCards,player2ReducedValue));

        if(player1ReducedPower>player2ReducedPower){
            return 1;
        }else{
            return 2;
        }
    }
    //reveal the hidden card of the player
    private void revealHiddenCard(LinearLayout cardContainer,int hiddenImageRes){
        cardContainer.removeViewAt(0);
        ImageView hiddenCard=new ImageView(MainActivity.this);
        hiddenCard.setImageDrawable(getResources().getDrawable(hiddenImageRes));

        int dp1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, MainActivity.this.getResources().getDisplayMetrics());
        hiddenCard.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 80 * dp1));
        hiddenCard.setAdjustViewBounds(true);

        cardContainer.addView(hiddenCard,0);
    }
    //hide the first card of the player
    private void hideFirstCard(LinearLayout cardContainer){
        cardContainer.removeViewAt(0);
        addBackfaceCard(cardContainer);
    }
}
