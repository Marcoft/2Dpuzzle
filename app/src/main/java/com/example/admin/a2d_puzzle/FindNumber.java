package com.example.admin.a2d_puzzle;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindNumber extends AppCompatActivity implements View.OnClickListener {

    private String color_1[] = new String[]{
            "#098178", // dark-green-blue
            "#FFA500", // orange
            "#FF0000", // red
            "#7FFF00", // green
            "#800080", // purple
            "#EE82EE", // violet
            "#000000" // black
            ,"#0000FF" // blue
            ,"#717ECF", // blue3
            "#FFC0CB" // pink
            ,"#7AABDF" // blue2
    };



    private Button[][] buttons = new Button[5][5];

    Random r1;
    Random r2;
    int one_for_r1;
    int two_for_r2;



    int num;

    private CountDownTimer countDownTimer;
    private long timemilliseconds = 31000;

    int Count = 0;


    Animation animation;

    MediaPlayer mPlayer;


    Random colorrs;

    @BindView(R.id.find_text) TextView text_find;
    @BindView(R.id.score) TextView score;
    @BindView(R.id.time) TextView time;

    @BindView(R.id.Start) Button play;


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_number);
        ButterKnife.bind(this);

        r1 = new Random();
        r2 = new Random();
        colorrs = new Random();
        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink); // animation blink

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String button_ID = "btn_" + i + j;
                int res_Id = getResources().getIdentifier(button_ID, "id", getPackageName());
                buttons[i][j] = findViewById(res_Id);
                buttons[i][j].setOnClickListener(this);
                buttons[i][j].setBackgroundColor(Color.GRAY);
                buttons[i][j].setEnabled(false);
            }
        }
    }

    private void newGame(){
        one_for_r1 = r1.nextInt(5);
        two_for_r2 = r2.nextInt(5);

        int array[][] = Random_function.randomArr(5,5,10000);

        int arr_for_blink[] = new int[9];
        int arr_for_blink2[] = new int[9];
        for (int i = 0; i < 9; i++) {
            arr_for_blink[i] = (int)(Math.random()*5);
            arr_for_blink2[i] = (int)(Math.random()*5);
            if (Random_function.equals_dobl(arr_for_blink,arr_for_blink2, 9, i)){
                --i;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setText(""+array[i][j]);
                buttons[arr_for_blink[i]][arr_for_blink2[i]].startAnimation(animation);
                buttons[i][j].setBackgroundColor(Color.parseColor(color_1[colorrs.nextInt(7)]));
            }
        }

        num = array[one_for_r1][two_for_r2];
        text_find.setText("Найдите указанное число : "+ num);
    }

    @Override
    public void onClick(View v) {
        if(((Button)v).getText().toString().equalsIgnoreCase(String.valueOf(num))){
            Count++;
            score.setText("" + Count);
        } else{
            if(Count != 0){
                Count--;
                score.setText("" + Count);
            }
        }
        newGame();
    }

    public void PlayGame(View v){
        play.setVisibility(View.GONE);
        StartTime();
        newGame();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setEnabled(true);
                buttons[i][j].setTextColor(Color.WHITE);
            }
        }
    }

    private void StartTime(){
        mPlayer=MediaPlayer.create(getApplicationContext(), R.raw.timee);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });
        mPlayer.start();

        countDownTimer = new CountDownTimer(timemilliseconds,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timemilliseconds = millisUntilFinished;
                update();
            }

            @Override
            public void onFinish() {
               Intent intent = new Intent();
                if(Count>0)
                    intent.putExtra("score",Count);
                else {
                    intent.putExtra("score",0);
                }
                setResult(RESULT_OK, intent);
                if (mPlayer.isPlaying()) {
                    stopPlay();
                }
                finish();
            }
        }.start();
    }

    public void update(){
        int seconds = (int)timemilliseconds/1000;
        time.setText(""+seconds);
    }

    private void stopPlay(){
        mPlayer.stop();
        try {
            mPlayer.prepare();
            mPlayer.seekTo(0);
        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onDestroy() {
        if (mPlayer.isPlaying()) {
            stopPlay();
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        StartTime();
        Intent intent = new Intent();
        intent.putExtra("score",0);
        setResult(RESULT_OK, intent);
        if (mPlayer.isPlaying()) {
            stopPlay();
        }
        finish();
        super.onBackPressed();
    }
}
