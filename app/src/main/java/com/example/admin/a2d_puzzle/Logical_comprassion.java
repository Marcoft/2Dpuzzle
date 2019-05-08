package com.example.admin.a2d_puzzle;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Logical_comprassion extends AppCompatActivity {

    Random r_1;
    Random r_2;
    Random r1_1;
    Random r1_2;

    int num1,num2,num3,num4;
    int Count = 0;

    private CountDownTimer countDownTimer;
    private long timemilliseconds = 31000;


    @BindView(R.id.btn_1) Button btn_1;
    @BindView(R.id.btn_2) Button btn_2;
    @BindView(R.id.Start) Button play;
    @BindView(R.id.score) TextView text_Count;
    @BindView(R.id.time) TextView time;

    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logical_comprassion);

        ButterKnife.bind(this);

        r_1 = new Random();
        r_2 = new Random();
        r1_1 = new Random();
        r1_2 = new Random();


        btn_1.setEnabled(false);
        btn_2.setEnabled(false);
    }


    public void PlayGame(View v){
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
        num1 = r_1.nextInt(300);
        num2 = r_2.nextInt(300);
        num3 = r1_1.nextInt(300);
        num4 = r1_2.nextInt(300);
        if(num1 > num2){
            btn_1.setText("" + num1 + " - " + num2);
        } else {
            btn_1.setText("" + num2 + " - " + num1);
        }
        if(num3 > num4){
            btn_2.setText("" + num3 + " - " + num4);
        } else{
            btn_2.setText("" + num4 + " - " + num3);
        }

        btn_1.setEnabled(true);
        btn_2.setEnabled(true);
    }

    public void Check(View v){
        switch (v.getId()){
            case R.id.btn_1:
                if(num1>num2){
                    if(num1 - num2  > num3 - num4 && num1 - num2  > num4 - num3){
                        Count++;
                        text_Count.setText(""+Count);
                        NewGame();
                    } else {
                        Count--;
                        text_Count.setText(""+Count);
                        NewGame();
                    }
                } else {
                    if(num2 - num1  > num3 - num4 && num2 - num1  > num4 - num3){
                        Count++;
                        text_Count.setText(""+Count);
                        NewGame();
                    } else {
                        Count--;
                        text_Count.setText(""+Count);
                        NewGame();
                    }
                }
                break;
            case R.id.btn_2:
                if(num3>num4){
                    if(num3 - num4  > num1 - num2 && num3 - num4  > num2 - num1){
                        Count++;
                        text_Count.setText(""+Count);
                        NewGame();
                    } else {
                        Count--;
                        text_Count.setText(""+Count);
                        NewGame();
                    }
                } else {
                    if(num4 - num3  > num1 - num2 && num4 - num3  > num2 - num1){
                        Count++;
                        text_Count.setText(""+Count);
                        NewGame();
                    } else {
                        Count--;
                        text_Count.setText(""+Count);
                        NewGame();
                    }
                }
                break;
        }
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

