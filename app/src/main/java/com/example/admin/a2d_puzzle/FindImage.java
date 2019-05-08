package com.example.admin.a2d_puzzle;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindImage extends AppCompatActivity implements View.OnClickListener  {

    private ImageButton[][] buttons = new ImageButton[5][5];

    private String color_1[] = new String[]{
            "#FFFF00", // yellow
            "#FF0000", // red
            "#FFA500", // orange
            "#7FFF00", // green
            "#800080", // purple
            "#EE82EE", // violet
            "#D8D3C4", // gray
            "#FFC0CB" // pink
            ,"#0000FF" // blue
            ,"#7AABDF" // blue2
    };


    int[] myImageList = new int[]{
            R.drawable.ic_cloud,
            R.drawable.ic_home,
            R.drawable.ic_lock,
            R.drawable.ic_message,
            R.drawable.ic_pazzle,
            R.drawable.ic_guess_word,
            R.drawable.ic_find_in_page,
            R.drawable.ic_school,
            R.drawable.ic_star,
            R.drawable.ic_roulette,
            R.drawable.ic_question_answer,
            R.drawable.ic_smile,
            R.drawable.ic_visibility,
            R.drawable.ic_visibility_off,
            R.drawable.ic_spa,
            R.drawable.ic_shop,
            R.drawable.ic_shop_two,
            R.drawable.ic_sad_smile,
            R.drawable.ic_report,
            R.drawable.ic_power,
            R.drawable.ic_palette,
            R.drawable.ic_local_bar,
            R.drawable.ic_lightbulb_outline,
            R.drawable.ic_hd,
            R.drawable.ic_face,
            R.drawable.ic_favorite,
    };


    int find_picture;


    private CountDownTimer countDownTimer;
    private long timemilliseconds = 31000;

    int Count = 0;

    int a;
    int pictures[][] = new int[5][5];

    Random r;
    Random random1_find_pict;
    Random random2_find_pict;
    Random colorrs;

    @BindView(R.id.find_text) TextView text_find;
    @BindView(R.id.score) TextView score;
    @BindView(R.id.time) TextView time;

    @BindView(R.id.Start) Button play;
    @BindView(R.id.find_image) ImageButton find_image;

    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_image);

        ButterKnife.bind(this);
        r = new Random();
        random1_find_pict = new Random();
        random2_find_pict = new Random();
        colorrs = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String button_ID = "btn_" + i + j;
                int res_Id = getResources().getIdentifier(button_ID, "id", getPackageName());
                buttons[i][j] = findViewById(res_Id);
                buttons[i][j].setOnClickListener(this);
            }
        }
    }

    private void newGame(){
        int one_for_r1 = random1_find_pict.nextInt(5);
        int two_for_r2 = random2_find_pict.nextInt(5);
        int array[][] = Random_function.randomArr(5,5,26);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                pictures[i][j] = array[i][j];
                buttons[i][j].setImageResource(myImageList[array[i][j]]);
                buttons[i][j].setBackgroundColor(Color.parseColor(color_1[colorrs.nextInt(7)]));
            }
        }

        find_picture = pictures[one_for_r1][two_for_r2];

        find_image.setImageResource(myImageList[find_picture]);
    }

    @Override
    public void onClick(View v) {
        if(((ImageButton)v).getDrawable().getConstantState().equals
                (find_image.getDrawable().getConstantState())){
            Count++;
            score.setText("" + Count);
            newGame();
        } else{
            if(Count != 0){
                Count--;
                score.setText("" + Count);
                newGame();
            } else {
                newGame();
            }
        }
        newGame();
    }

    public void PlayGame(View v){
        play.setVisibility(View.GONE);
        Count = 0;
        StartTime();
        newGame();
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
