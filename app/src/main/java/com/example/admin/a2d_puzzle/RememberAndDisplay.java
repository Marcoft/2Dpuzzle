package com.example.admin.a2d_puzzle;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class RememberAndDisplay extends AppCompatActivity implements View.OnClickListener {


    private Button[][] buttons = new Button[5][5];
    TextView time,score;

    Random r;
    Random r1;
    int i = 0;
    int z ;
    int a = 1;
    final int N = 5;
    int first, second;
    int first_mas[];
    int second_mas[];

    private CountDownTimer countDownTimer;
    private long timemilliseconds = 51000;
    Button play;

    int Count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_and_display);
        play = (Button) findViewById(R.id.Start);
        time = (TextView) findViewById(R.id.time);
        score = (TextView) findViewById(R.id.score);


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String button_ID = "btn_" + i + j;
                int res_Id = getResources().getIdentifier(button_ID, "id", getPackageName());
                buttons[i][j] = findViewById(res_Id);
                buttons[i][j].setOnClickListener(this);
                buttons[i][j].setBackgroundColor(Color.GRAY);
                buttons[i][j].setEnabled(false);
            }


            r = new Random();
            r1 = new Random();

        }
    }

    private void newGame() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setEnabled(true);
                buttons[i][j].setBackgroundColor(Color.GRAY);
                buttons[i][j].setText("");
            }
        }

        ++a;
        first_mas = new int[a];
        second_mas = new int[a];
        for (int i = 0; i < a; i++) {
            first_mas[i] = (int)(Math.random()*N);
            second_mas[i] = (int)(Math.random()*N);
            if (Random_function.equals_dobl(first_mas,second_mas, a, i)){
                --i;
            }
        }

        z = -1;
        for (int i = 0; i < a; i++) {
            ++z;
            first = first_mas[i];
            second = second_mas[i];
            buttons[first][second].setBackgroundColor(Color.YELLOW);
            buttons[first][second].setText("" + z);
        }

        new CountDownTimer(2000, 1000) { // pause 2 seconds

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                for (int i = 0; i < a; i++) {
                    first = first_mas[i];
                    second = second_mas[i];
                    buttons[first][second].setBackgroundColor(Color.GRAY);
                    buttons[first][second].setText("");
                }
            }
        }.start();

    }

    @Override
    public void onClick(View v) {
        first = first_mas[i];
        second = second_mas[i];
        if (((Button) v).getId() == (buttons[first][second].getId())) {
            buttons[first][second].setBackgroundColor(Color.YELLOW);
            i++;
        } else {
            ((Button) v).setBackgroundColor(Color.RED);
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    buttons[i][j].setEnabled(false);
                }
            }
            if(Count>0) {
                Count--;
                score.setText("" + Count);
            }
            new CountDownTimer(2000, 1000) { // pause 2 seconds

                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    i = 0;
                    Restart();
                }
            }.start();
        }
        if(i==a)  {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    buttons[i][j].setEnabled(false);
                }
            }
            new CountDownTimer(2000, 1000) { // pause 2 seconds

                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    Count++;
                    score.setText(""+Count);
                    i = 0;
                    newGame();
                }
            }.start();
        }
    }

    public void Restart(){
        if(a!=1) {
            a = a - 2;
        }else{
            a = a -1;
        }
        newGame();
    }

    public void PlayGame(View v){
        play.setVisibility(View.GONE);
        StartTime();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setEnabled(true);
            }
        }
        newGame();
    }

    private void StartTime(){
        countDownTimer = new CountDownTimer(timemilliseconds,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timemilliseconds = millisUntilFinished;
                update();
            }

            @Override
            public void onFinish() {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        buttons[i][j].setEnabled(false);
                    }
                }
                Intent intent = new Intent();
                if(Count>0)
                    intent.putExtra("score",Count);
                else {
                    intent.putExtra("score",0);
                }
                setResult(RESULT_OK, intent);
                finish();
            }
        }.start();
    }

    public void update(){
        int seconds = (int)timemilliseconds/1000;
        time.setText(""+seconds);
    }

    @Override
    public void onBackPressed() {
        StartTime();
        Intent intent = new Intent();
        intent.putExtra("score",0);
        setResult(RESULT_OK, intent);
        finish();
        super.onBackPressed();
    }
}
