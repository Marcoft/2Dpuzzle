package com.example.admin.a2d_puzzle;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Continue_the_row extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle drawerToggle;

    private CountDownTimer countDownTimer;
    private long timemilliseconds = 36000;

    @BindView(R.id.text_row) TextView text_row;
    @BindView(R.id.text) TextView text;
    @BindView(R.id.score) TextView score;
    @BindView(R.id.time) TextView time;

    @BindView(R.id.check) Button check;
    @BindView(R.id.start) Button start;

    @BindView(R.id.edt) EditText edt;

    MediaPlayer mPlayer;

    Random r;

    private String[] questions = new String[]{
            " 8 | 10 | 12 | 14 | ? ",
            " 2 | 4 | 8 | 16 | ? ",
            " 3 | 5 | 8 | 10 | ? ",
            " 1 | 4 | 9 | 16 | ? ",
            " 1 | 2 | 4 | 7 | ? ",
            " 15 | 13 | 10 | 8 | ? ",
            " 1 | 4 | 16 | 64 | ? ",
            " 2 | 8 | 3 | 27 | 4 | ? ",
            " 5 | 3 | 6 | 4 | 7 | ? ",
            " 1 | 2 | 6 | 24 | ? "
    };

    private String[] answers = new String[]{
            "16",
            "32",
            "13",
            "25",
            "11",
            "5",
            "256",
            "64",
            "5",
            "120"
    };

    int Count = 0;
    int ques;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_the_row);

        ButterKnife.bind(this);

        r = new Random();
        check.setEnabled(false);
        text_row.setEnabled(false);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        drawer = (DrawerLayout) findViewById(R.id.My_drawer);
        drawerToggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


        switch (menuItem.getItemId()) {
            case R.id.home:
                Intent intent_home = new Intent();
                intent_home.putExtra("block", "home");
                setResult(RESULT_OK, intent_home);
                finish();
                break;
            case R.id.Message:
                Toast.makeText(this, "Message", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Setting:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Roulette:
                Toast.makeText(this, "Roulette", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Guess_Word:
                Toast.makeText(this, "Guess_Word", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Riddle:
                Toast.makeText(this, "Riddle", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void newGame(){
        check.setEnabled(true);
        text_row.setEnabled(true);
        ques = r.nextInt(questions.length);
        text_row.setText(questions[ques]);
        StartTime();
    }

    public void clickCheck(View view){
        if(edt.getText().toString().equalsIgnoreCase(answers[ques])){
            Count++;
            edt.setText("");
            score.setText("Score : "+ Count);
            newGame();
        } else {
            if(Count!= 0){
                Count--;
                edt.setText("");
                score.setText("Score : "+ Count);
                newGame();
            }
            else{
                edt.setText("");
                newGame();
            }
        }
    }

    public void startGame(View view){
        newGame();
        start.setVisibility(View.GONE);
        edt.setEnabled(true);
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
                check.setEnabled(false);
                text_row.setEnabled(false);
                edt.setEnabled(false);
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
        time.setText("Time : "+seconds);
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
