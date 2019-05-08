package com.example.admin.a2d_puzzle;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Collections;

public class Find_a_Match extends AppCompatActivity {



    ImageView iv_11,iv_12,iv_13,iv_14,iv_21,iv_22,iv_23,iv_24,iv_31,iv_32,
            iv_33,iv_34;

    Integer[] cardArray = { 101,102,103,104,105,106,201,202,203,204,205,206};

    int images101,images102,images103,images104,images105,images106,images201,images202,images203,images204,images205,images206;


    int firstCard,secondCard;
    int clickedFirst,clickedSecond;
    int cardNumber = 1;

    TextView moves;
    int Count_moves = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_a__match);

        moves = (TextView) findViewById(R.id.moves);


        iv_11 = (ImageView) findViewById(R.id.img1);
        iv_12 = (ImageView) findViewById(R.id.img2);
        iv_13 = (ImageView) findViewById(R.id.img3);
        iv_14 = (ImageView) findViewById(R.id.img4);
        iv_21 = (ImageView) findViewById(R.id.img5);
        iv_22 = (ImageView) findViewById(R.id.img6);
        iv_23 = (ImageView) findViewById(R.id.img7);
        iv_24 = (ImageView) findViewById(R.id.img8);
        iv_31 = (ImageView) findViewById(R.id.img9);
        iv_32 = (ImageView) findViewById(R.id.img10);
        iv_33 = (ImageView) findViewById(R.id.img11);
        iv_34 = (ImageView) findViewById(R.id.img12);


        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_14.setTag("3");
        iv_21.setTag("4");
        iv_22.setTag("5");
        iv_23.setTag("6");
        iv_24.setTag("7");
        iv_31.setTag("8");
        iv_32.setTag("9");
        iv_33.setTag("10");
        iv_34.setTag("11");


        frontOfCardsResourses();

        Collections.shuffle(Arrays.asList(cardArray));


        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String)v.getTag());
                doStuff(iv_11,theCard);
            }
        });

        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String)v.getTag());
                doStuff(iv_12,theCard);
            }
        });

        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String)v.getTag());
                doStuff(iv_13,theCard);
            }
        });

        iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String)v.getTag());
                doStuff(iv_14,theCard);
            }
        });

        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String)v.getTag());
                doStuff(iv_21,theCard);
            }
        });

        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String)v.getTag());
                doStuff(iv_22,theCard);
            }
        });

        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String)v.getTag());
                doStuff(iv_23,theCard);
            }
        });

        iv_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String)v.getTag());
                doStuff(iv_24,theCard);
            }
        });

        iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String)v.getTag());
                doStuff(iv_31,theCard);
            }
        });

        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String)v.getTag());
                doStuff(iv_32,theCard);
            }
        });

        iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String)v.getTag());
                doStuff(iv_33,theCard);
            }
        });

        iv_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String)v.getTag());
                doStuff(iv_34,theCard);
            }
        });


    }

    private void doStuff(ImageView iv,int card){
        if(cardArray[card] == 101){
            iv.setImageResource(images101);
        } else if(cardArray[card] == 102){
            iv.setImageResource(images102);
        } else if(cardArray[card] == 103){
            iv.setImageResource(images103);
        } else if(cardArray[card] == 104){
            iv.setImageResource(images104);
        } else if(cardArray[card] == 105){
            iv.setImageResource(images105);
        } else if(cardArray[card] == 106){
            iv.setImageResource(images106);
        } else if(cardArray[card] == 201){
            iv.setImageResource(images201);
        } else if(cardArray[card] == 202){
            iv.setImageResource(images202);
        } else if(cardArray[card] == 203){
            iv.setImageResource(images203);
        } else if(cardArray[card] == 204){
            iv.setImageResource(images204);
        } else if(cardArray[card] == 205){
            iv.setImageResource(images205);
        } else if(cardArray[card] == 206){
            iv.setImageResource(images206);
        }

        if(cardNumber == 1){
            firstCard = cardArray[card];
            if(firstCard > 200){
                firstCard = firstCard - 100;
            }
            Count_moves++;
            moves.setText("Number of moves: " + Count_moves);
            cardNumber = 2;
            clickedFirst = card;
            iv.setEnabled(false);
        } else if(cardNumber == 2){
            secondCard = cardArray[card];
            if(secondCard > 200){
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_14.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);
            iv_24.setEnabled(false);
            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            iv_33.setEnabled(false);
            iv_34.setEnabled(false);


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            },1000);

        }
    }

    private void calculate(){
        if(firstCard == secondCard) {
            if (clickedFirst == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                iv_24.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 10) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 11) {
                iv_34.setVisibility(View.INVISIBLE);
            }


            if (clickedSecond == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                iv_24.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 8) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 9) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 10) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 11) {
                iv_34.setVisibility(View.INVISIBLE);
            }

        } else {
                iv_11.setImageResource(R.drawable.btn_questions);
                iv_12.setImageResource(R.drawable.btn_questions);
                iv_13.setImageResource(R.drawable.btn_questions);
                iv_14.setImageResource(R.drawable.btn_questions);
                iv_21.setImageResource(R.drawable.btn_questions);
                iv_22.setImageResource(R.drawable.btn_questions);
                iv_23.setImageResource(R.drawable.btn_questions);
                iv_24.setImageResource(R.drawable.btn_questions);
                iv_31.setImageResource(R.drawable.btn_questions);
                iv_32.setImageResource(R.drawable.btn_questions);
                iv_33.setImageResource(R.drawable.btn_questions);
                iv_34.setImageResource(R.drawable.btn_questions);

        }
        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_14.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_24.setEnabled(true);
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_33.setEnabled(true);
        iv_34.setEnabled(true);

        checkEnd();
    }

    public void checkEnd(){
        if(iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE &&
                iv_13.getVisibility() == View.INVISIBLE &&
                iv_14.getVisibility() == View.INVISIBLE &&
                iv_21.getVisibility() == View.INVISIBLE &&
                iv_22.getVisibility() == View.INVISIBLE &&
                iv_23.getVisibility() == View.INVISIBLE &&
                iv_24.getVisibility() == View.INVISIBLE &&
                iv_31.getVisibility() == View.INVISIBLE &&
                iv_32.getVisibility() == View.INVISIBLE &&
                iv_33.getVisibility() == View.INVISIBLE &&
                iv_34.getVisibility() == View.INVISIBLE ){

            AlertDialog.Builder alert = new AlertDialog.Builder(Find_a_Match.this);
            alert.setMessage("GAME OVER!")
                    .setCancelable(false)
                    .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(),Find_a_Match.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = alert.create();
            alertDialog.show();
        }
    }

    private void frontOfCardsResourses(){
        images101 = R.drawable.ic_email;
        images102 = R.drawable.ic_cloud ;
        images103 = R.drawable.ic_home ;
        images104 = R.drawable.ic_shop ;
        images105 = R.drawable.ic_guess_word ;
        images106 = R.drawable.ic_find_in_page ;
        images201 = R.drawable.ic_email ;
        images202 = R.drawable.ic_cloud ;
        images203 = R.drawable.ic_home ;
        images204 = R.drawable.ic_shop;
        images205 = R.drawable.ic_guess_word;
        images206 = R.drawable.ic_find_in_page;
    }
}
