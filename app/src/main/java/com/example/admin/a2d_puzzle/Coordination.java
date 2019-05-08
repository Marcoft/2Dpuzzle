package com.example.admin.a2d_puzzle;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Coordination extends AppCompatActivity {

    ImageView img,img2,img3,img4,img5;
    Button btn_up,btn_down,btn_left,btn_right;
    ObjectAnimator objectAnimator_right_1,objectAnimator_right_2,objectAnimator_right_3,objectAnimator_right_4,objectAnimator_right_5
            ,objectAnimator_up_1,objectAnimator_up_2,objectAnimator_up_3,objectAnimator_up_4,objectAnimator_up_5,
            objectAnimator_left_1,objectAnimator_left_2,objectAnimator_left_3,objectAnimator_left_4,objectAnimator_left_5
            ,objectAnimator_down_1,objectAnimator_down_2,objectAnimator_down_3,objectAnimator_down_4,objectAnimator_down_5;

    Random r;

    private  int STATE_UP = 0;
    private  int STATE_DOWN = 0;
    private  int STATE_LEFT = 0;
    private  int STATE_RIGHT = 0;

    int Count;
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordination);

        score = (TextView) findViewById(R.id.score);

        img = (ImageView) findViewById(R.id.img);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);


        btn_up = (Button) findViewById(R.id.btn_up);
        btn_down = (Button) findViewById(R.id.btn_down);
        btn_left = (Button) findViewById(R.id.btn_left);
        btn_right = (Button) findViewById(R.id.btn_right);

        r = new Random();

        setValue();
        newGame();
    }


    public void newGame(){
        resetGame();

        int move = r.nextInt(4) + 1;
        STATE_UP = 0;
        STATE_DOWN = 0;
        STATE_LEFT = 0;
        STATE_RIGHT = 0;

        switch (move){
            case 1:

                STATE_UP = 1;
                STATE_DOWN = 0;
                STATE_LEFT = 0;
                STATE_RIGHT = 0;


                objectAnimator_up_1.setDuration(4000);
                objectAnimator_up_1.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_up_1.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_up_1.start();

                objectAnimator_up_2.setDuration(4000);
                objectAnimator_up_2.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_up_2.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_up_2.start();

                objectAnimator_up_3.setDuration(4000);
                objectAnimator_up_3.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_up_3.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_up_3.start();

                objectAnimator_up_4.setDuration(4000);
                objectAnimator_up_4.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_up_4.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_up_4.start();

                objectAnimator_up_5.setDuration(4000);
                objectAnimator_up_5.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_up_5.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_up_5.start();

                btnClick();

                break;
            case 2:

                STATE_UP = 0;
                STATE_DOWN = 1;
                STATE_LEFT = 0;
                STATE_RIGHT = 0;


                objectAnimator_down_1.setDuration(4000);
                objectAnimator_down_1.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_down_1.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_down_1.start();

                objectAnimator_down_2.setDuration(4000);
                objectAnimator_down_2.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_down_2.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_down_2.start();

                objectAnimator_down_3.setDuration(4000);
                objectAnimator_down_3.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_down_3.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_down_3.start();

                objectAnimator_down_4.setDuration(4000);
                objectAnimator_down_4.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_down_4.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_down_4.start();

                objectAnimator_down_5.setDuration(4000);
                objectAnimator_down_5.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_down_5.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_down_5.start();

                btnClick();

                break;
            case 3:

                STATE_UP = 0;
                STATE_DOWN = 0;
                STATE_LEFT = 1;
                STATE_RIGHT = 0;


                objectAnimator_left_1.setDuration(4000);
                objectAnimator_left_1.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_left_1.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_left_1.start();

                objectAnimator_left_2.setDuration(4000);
                objectAnimator_left_2.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_left_2.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_left_2.start();

                objectAnimator_left_3.setDuration(4000);
                objectAnimator_left_3.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_left_3.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_left_3.start();

                objectAnimator_left_4.setDuration(4000);
                objectAnimator_left_4.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_left_4.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_left_4.start();

                objectAnimator_left_5.setDuration(4000);
                objectAnimator_left_5.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_left_5.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_left_5.start();

                btnClick();

                break;
            case 4:

                STATE_UP = 0;
                STATE_DOWN = 0;
                STATE_LEFT = 0;
                STATE_RIGHT = 1;


                objectAnimator_right_1.setDuration(4000);
                objectAnimator_right_1.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_right_1.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_right_1.start();

                objectAnimator_right_2.setDuration(4000);
                objectAnimator_right_2.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_right_2.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_right_2.start();

                objectAnimator_right_3.setDuration(4000);
                objectAnimator_right_3.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_right_3.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_right_3.start();

                objectAnimator_right_4.setDuration(4000);
                objectAnimator_right_4.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_right_4.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_right_4.start();

                objectAnimator_right_5.setDuration(4000);
                objectAnimator_right_5.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator_right_5.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator_right_5.start();

                btnClick();

                break;
            default:
                Toast.makeText(this, "Intssssss", Toast.LENGTH_SHORT).show();
        }
    }

    public void resetGame(){
        objectAnimator_down_1.end();
        objectAnimator_down_2.end();
        objectAnimator_down_3.end();
        objectAnimator_down_4.end();
        objectAnimator_down_5.end();


        objectAnimator_left_1.end();
        objectAnimator_left_2.end();
        objectAnimator_left_3.end();
        objectAnimator_left_4.end();
        objectAnimator_left_5.end();


        objectAnimator_right_1.end();
        objectAnimator_right_2.end();
        objectAnimator_right_3.end();
        objectAnimator_right_4.end();
        objectAnimator_right_5.end();

        objectAnimator_up_1.end();
        objectAnimator_up_2.end();
        objectAnimator_up_3.end();
        objectAnimator_up_4.end();
        objectAnimator_up_5.end();
    }

    public void setValue(){
        objectAnimator_right_1 = ObjectAnimator.ofFloat(img,"translationX",200); // right
        objectAnimator_right_2 = ObjectAnimator.ofFloat(img2,"translationX",200); // right
        objectAnimator_right_3 = ObjectAnimator.ofFloat(img3,"translationX",200); // right
        objectAnimator_right_4 = ObjectAnimator.ofFloat(img4,"translationX",200); // right
        objectAnimator_right_5 = ObjectAnimator.ofFloat(img5,"translationX",200); // right


        objectAnimator_down_1 = ObjectAnimator.ofFloat(img,"translationY",200); // down
        objectAnimator_down_2 = ObjectAnimator.ofFloat(img2,"translationY",200); // down
        objectAnimator_down_3 = ObjectAnimator.ofFloat(img3,"translationY",200); // down
        objectAnimator_down_4 = ObjectAnimator.ofFloat(img4,"translationY",200); // down
        objectAnimator_down_5 = ObjectAnimator.ofFloat(img5,"translationY",200); // down


        objectAnimator_left_1 = ObjectAnimator.ofFloat(img,"x",-200); // left
        objectAnimator_left_2 = ObjectAnimator.ofFloat(img2,"x",-200); // left
        objectAnimator_left_3 = ObjectAnimator.ofFloat(img3,"x",-200); // left
        objectAnimator_left_4 = ObjectAnimator.ofFloat(img4,"x",-200); // left
        objectAnimator_left_5 = ObjectAnimator.ofFloat(img5,"x",-200); // left


        objectAnimator_up_1 = ObjectAnimator.ofFloat(img,"y",-200); // up
        objectAnimator_up_2 = ObjectAnimator.ofFloat(img2,"y",-200); // up
        objectAnimator_up_3 = ObjectAnimator.ofFloat(img3,"y",-200); // up
        objectAnimator_up_4 = ObjectAnimator.ofFloat(img4,"y",-200); // up
        objectAnimator_up_5 = ObjectAnimator.ofFloat(img5,"y",-200); // up
    }

    public void btnClick(){
        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(STATE_UP == 1){
                    Count++;
                    score.setText("Score : " +Count);
                    newGame();
                } else {
                    Count--;
                    score.setText("Score : " +Count);
                    newGame();
                }
            }
        });

        btn_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(STATE_DOWN == 1){
                    Count++;
                    score.setText("Score : " +Count);
                    newGame();
                } else {
                    Count--;
                    score.setText("Score : " +Count);
                    newGame();
                }

            }
        });

        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(STATE_LEFT == 1){
                    Count++;
                    score.setText("Score : " +Count);
                    newGame();
                } else {
                    Count--;
                    score.setText("Score : " +Count);
                    newGame();
                }

            }
        });

        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(STATE_RIGHT == 1){
                    Count++;
                    score.setText("Score : " +Count);
                    newGame();
                } else {
                    Count--;
                    score.setText("Score : " +Count);
                    newGame();
                }

            }
        });
    }
}
