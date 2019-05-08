package com.example.admin.a2d_puzzle;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Game_of_Color extends AppCompatActivity {

    ImageView iv_button,iv_arrow;
    TextView tv_points;

    ProgressBar progressBar;

    Handler handler;
    Runnable runnable;

    Random r;

    private final static int STATE_BLUE = 1;
    private final static int STATE_RED = 2;
    private final static int STATE_YELLOW = 3;
    private final static int STATE_GREEN = 4;

    int buttonState = STATE_BLUE;
    int arrowState = STATE_BLUE;

    int currentTime = 3000;
    int startTime = 3000;

    int currentPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_of__color);

        iv_button = (ImageView) findViewById(R.id.bottom);
        iv_arrow = (ImageView) findViewById(R.id.arrow);
        tv_points = (TextView) findViewById(R.id.points);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        progressBar.setMax(startTime);
        progressBar.setProgress(startTime);

        tv_points.setText("Points : " + currentPoints);

        r = new Random();
        arrowState = r.nextInt(4)+1;
        setArrowImage(arrowState);

        iv_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonImage(setButtonPosition(buttonState));
            }
        });

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                currentTime = currentTime -100;
                progressBar.setProgress(currentTime);
                if(currentTime > 0){
                    handler.postDelayed(runnable,100);
                } else{
                    if(buttonState == arrowState) {
                        currentPoints++;
                        tv_points.setText("Points : " + currentPoints);
                        startTime = startTime - 100;
                        if (startTime < 700) {
                            startTime = 2000;
                        }
                        progressBar.setMax(startTime);
                        currentTime = startTime;
                        progressBar.setProgress(currentTime);

                        arrowState = r.nextInt(4) + 1;

                        setArrowImage(arrowState);

                        handler.postDelayed(runnable, 100);
                    } else {
                        iv_button.setEnabled(false);
                        Intent intent = new Intent();

                        if(currentPoints>0)
                            intent.putExtra("score",currentPoints);
                        else {
                            intent.putExtra("score",0);
                        }

                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
            }
        };

        handler.postDelayed(runnable,100);

    }
    private void setArrowImage(int state){
        switch (state){
            case STATE_BLUE:
                iv_arrow.setImageResource(R.drawable.blue_triangle);
                arrowState = STATE_BLUE;
                break;
            case STATE_RED:
                iv_arrow.setImageResource(R.drawable.red_triangle);
                arrowState = STATE_RED;
                break;
            case STATE_YELLOW:
                iv_arrow.setImageResource(R.drawable.yellow_triangle);
                arrowState = STATE_YELLOW;
                break;
            case STATE_GREEN:
                iv_arrow.setImageResource(R.drawable.green_triangle);
                arrowState = STATE_GREEN;
                break;
        }
    }

    private void setRotation(final ImageView image,final int drawable){
        RotateAnimation rotateAnimation = new RotateAnimation(0,90, Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);

        rotateAnimation.setDuration(100);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                image.setImageResource(drawable);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(rotateAnimation);
    }

    private int setButtonPosition(int position){
        position = position+1;
        if(position == 5){
            position = 1;
        }
        return position;
    }

    private void setButtonImage(int state){
        switch (state){
            case STATE_BLUE:
                setRotation(iv_button,R.drawable.blue_up);
                buttonState = STATE_BLUE;
                break;
            case STATE_RED:
                setRotation(iv_button,R.drawable.red_up);
                buttonState = STATE_RED;
                break;
            case STATE_YELLOW:
                setRotation(iv_button,R.drawable.yellow_up);
                buttonState = STATE_YELLOW;
                break;
            case STATE_GREEN:
                setRotation(iv_button,R.drawable.green_up);
                buttonState = STATE_GREEN;
                break;
        }
    }
}
