package com.example.admin.a2d_puzzle;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class Colords extends AppCompatActivity {


    private String words_1[] = new String[]{
            "Зеленый",
            "Красный",
            "Зеленый",
            "Синий",
            "Желтый",
            "Черный",
            "Желтый",
            "Синий",
            "Розовый",
            "Фиолетовый",
            "Фиолетовый",
            "Синий",
            "Зеленый",
            "Желтый"
    };
    private String words_2[] = new String[]{
            "Желтый",
            "Красный",
            "Черный",
            "Черный",
            "Зеленый",
            "Фиолетовый",
            "Красный",
            "Зеленый",
            "Синий",
            "Желтый",
            "Красный",
            "Синий",
            "Розовый",
            "Фиолетовый"
    };
    private String color_2_word[] = new String[]{
            "Зеленый", // green
            "Синий", // blue
            "Черный", // black
            "Синий", // blue
            "Желтый", // yellow
            "Черный", // black
            "Желтый", // yellow
            "Синий", //  blue
            "Розовый", // violet
            "Красный" // red
            ,"Красный"
            ,"Розовый"
            ,"Розовый"
            ,"Желтый"
    };
    private String color_1[] = new String[]{
            "#FFFF00", // yellow
            "#FF0000", // red
            "#7FFF00", // green
            "#800080", // purple
            "#7FFF00", // green
            "#800080", // purple
            "#EE82EE", // violet
            "#FFFF00", // yellow
            "#000000", // black
            "#7FFF00" // green
            ,"#FF0000" // red
            ,"#0000FF" // blue
            ,"#800080" //purple
            ,"#0000FF" // blue
    };
    private String color_2[] = new String[]{
            "#7FFF00", // green
            "#0000FF", // blue
            "#000000", // black
            "#0000FF", // blue
            "#FFFF00", // yellow
            "#000000", // black
            "#FFFF00", // yellow
            "#0000FF", //  blue
            "#EE82EE", // violet
            "#FF0000" // red
            ,"#FF0000" // red
            ,"#EE82EE" // violet
            ,"#EE82EE" // violet
            ,"#FFFF00" //yellow
    };


    int a = -1;
    int Count = 0;

    private CountDownTimer countDownTimer;
    private long timemilliseconds = 21000;

    MediaPlayer mPlayer;


    @BindView(R.id.btn_no) Button btn_no;
    @BindView(R.id.btn_yes) Button btn_yes;
    @BindView(R.id.btn_1) Button btn_1;
    @BindView(R.id.btn_2) Button btn_2;
    @BindView(R.id.Start) Button play;
    @BindView(R.id.score) TextView text_Count;
    @BindView(R.id.time) TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colords);
        ButterKnife.bind(this);

        a = new Random().nextInt(words_1.length);

        btn_no.setEnabled(false);
        btn_yes.setEnabled(false);
        btn_1.setEnabled(false);
        btn_2.setEnabled(false);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_yes:
                if(btn_1.getText().toString().equals(color_2_word[a].toString())){
                    Count ++;
                    text_Count.setText("Score :  " + Count);

                    a = new Random().nextInt(words_1.length);
                    NewGame();
                } else {
                    if(Count != 0){
                        Count --;
                        text_Count.setText("Score :  " + Count);

                        a = new Random().nextInt(words_1.length);
                        NewGame();
                    } else {
                        a = new Random().nextInt(words_1.length);
                        NewGame();
                    }
                }
                break;
            case R.id.btn_no:
                if(!btn_1.getText().toString().equals(color_2_word[a])){
                    Count ++;
                    text_Count.setText("Score :  " + Count);

                    a = new Random().nextInt(words_1.length);
                    NewGame();
                } else {
                        Count --;
                        text_Count.setText("Score :  " + Count);

                        a = new Random().nextInt(words_1.length);
                        NewGame();
                }
                break;
        }

    }

    public void PlayGame1(View v){
        play.setVisibility(View.GONE);
        Count = 0;
        StartTime();
        NewGame();
    }

    private void StartTime(){
        mPlayer=MediaPlayer.create(this, R.raw.timee);
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
                btn_no.setEnabled(false);
                btn_yes.setEnabled(false);
                btn_1.setEnabled(false);
                btn_2.setEnabled(false);


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

    public void NewGame(){
        btn_1.setText(words_1[a]);
        btn_1.setTextColor(Color.parseColor(color_1[a]));
        btn_2.setText(words_2[a]);
        btn_2.setTextColor(Color.parseColor(color_2[a]));
        btn_no.setEnabled(true);
        btn_yes.setEnabled(true);
        btn_1.setEnabled(true);
        btn_2.setEnabled(true);
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
        super.onDestroy();
        if (mPlayer.isPlaying()) {
            stopPlay();
        }
    }

    @Override
    public void onBackPressed() {
        StartTime();
        if (mPlayer.isPlaying()) {
            stopPlay();
        }
        Intent intent = new Intent();
        intent.putExtra("score",0);
        setResult(RESULT_OK, intent);
        finish();
        super.onBackPressed();
    }
}
