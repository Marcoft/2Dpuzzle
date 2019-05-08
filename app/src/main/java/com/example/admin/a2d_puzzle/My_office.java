package com.example.admin.a2d_puzzle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

    public class My_office extends AppCompatActivity implements Animation.AnimationListener {

        boolean blnButtonRotation = true;
        int intNumber = 6;
        long lngDegrees = 0;

        ImageView selected,imageRoulette;
        TextView money_roulette;

        Button b_start;

        int money = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            getWindow().addFlags(1024);
            requestWindowFeature(1);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_my_office);

            money_roulette = (TextView) findViewById(R.id.money_roulette);

            b_start = (Button)findViewById(R.id.buttonStart);

            selected = (ImageView)findViewById(R.id.imageSelected);
            imageRoulette = (ImageView)findViewById(R.id.rouletteImage);

        }

        @Override
        public void onAnimationStart(Animation animation)
        {
            money-= 3;
            money_roulette.setText(""+money);
            this.blnButtonRotation = false;
            b_start.setVisibility(View.VISIBLE);

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Toast toast = Toast.makeText(this, " " + String.valueOf((int)(((double)this.intNumber)
                    - Math.floor(((double)this.lngDegrees) / (360.0d / ((double)this.intNumber))))) + " ",Toast.LENGTH_SHORT);

            money += Integer.parseInt(String.valueOf((int)(((double)this.intNumber)
                    - Math.floor(((double)this.lngDegrees) / (360.0d / ((double)this.intNumber))))));
            money_roulette.setText(""+money);

            toast.setGravity(49,0,0);
            toast.show();
            this.blnButtonRotation = true;
            b_start.setVisibility(View.VISIBLE);


        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }

        public void onClickButtonRotation(View v)
        {
            if(this.blnButtonRotation)
            {
                int ran = new Random().nextInt(360) + 3600;
                RotateAnimation rotateAnimation = new RotateAnimation((float)this.lngDegrees, (float)
                        (this.lngDegrees + ((long)ran)),1,0.5f,1,0.5f);

                this.lngDegrees = (this.lngDegrees + ((long)ran)) % 360;
                rotateAnimation.setDuration((long)ran);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setInterpolator(new DecelerateInterpolator());
                rotateAnimation.setAnimationListener(this);
                imageRoulette.setAnimation(rotateAnimation);
                imageRoulette.startAnimation(rotateAnimation);

            }
        }

        @Override
        public void onBackPressed() {
            Intent intent = new Intent();
            intent.putExtra("roulette_score",money);
            setResult(RESULT_OK, intent);
            finish();
            super.onBackPressed();
        }

    }

