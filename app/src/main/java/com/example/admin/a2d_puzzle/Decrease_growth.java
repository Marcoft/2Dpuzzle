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

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Decrease_growth extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[7][4];

    int Count = 0;

    int numbers[][] = new int[7][4];

    MediaPlayer mPlayer;

    public int COLS = 4;
    public int ROWS = 7;

    int number = 0;

    @BindView(R.id.score) TextView score;

    @BindView(R.id.Start) Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrease_growth);
        ButterKnife.bind(this);


        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
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
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                numbers[i][j] = -1;
            }
        }
        numbers = Random_function.randomArr(ROWS,COLS,ROWS*COLS);

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                buttons[i][j].setText(""+numbers[i][j]);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if(((Button)v).getText().toString().equalsIgnoreCase(String.valueOf(number))){
            number++;
            Count++;
            score.setText("" + Count);
            ((Button)v).setBackgroundColor(Color.GRAY);
            ((Button)v).setEnabled(false);
            ((Button)v).setText("");
        }

        if(score.getText().toString().equalsIgnoreCase("28")){
            Intent intent_numb = new Intent();
            if(Count>0)
                intent_numb.putExtra("score",Count);
            else {
                intent_numb.putExtra("score",0);
            }
            setResult(RESULT_OK, intent_numb);
            if (mPlayer.isPlaying()) {
                stopPlay();
            }
            finish();
        }
    }

    public void PlayGame_Start(View v){
        play.setVisibility(View.GONE);
        Count = 0;
        StartTime();
        newGame();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                buttons[i][j].setEnabled(true);
                buttons[i][j].setTextColor(Color.WHITE);
                //buttons[i][j].setBackgroundColor(Color.parseColor(color_1[i]));
            }
        }
    }

    private void StartTime(){
        mPlayer= MediaPlayer.create(getApplicationContext(), R.raw.timee);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });
        mPlayer.start();
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
