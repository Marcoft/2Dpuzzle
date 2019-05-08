package com.example.admin.a2d_puzzle;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Truth_or_lie extends AppCompatActivity {


    String questions[] = {
            "Правда ли, что луна — светило темное, собственного света не имеет?",
            "Правда ли, что межпланетная среда — это пустота?",
            "Правда ли, что втыкая швейную иглу, можно развить давление в одну тысячу атмосфер?",
            "Правда ли, что дятлы умирают от сотрясения мозга?",
            "Правда ли, что у головастика передние лапы вырастают раньше, чем задние?",
            "Правда ли, что беременность у слонихи длится почти год?",
            "Правда ли, что в южных странах тараканы достигают размера в мышь?",
            "Правда ли, что высота Эйфелевой башни больше трехсот пятидесяти метров?",
            "Правда ли, что кенгуру в момент опасности развивают скорость шестьдесят пять километров в час?",
            "Правда ли, что слоны могут набрать в хобот около семи литров воды?",
            "Правда ли, что верблюды запасают воду в своих горбах?",
            "Правда ли, что верблюды могут прожить без питья около восьми недель, но когда они добираются до оазиса, выпивают за раз более ста литров воды?",
            "Правда ли, что укол жала скорпиона смертелен для человека?",
            "Правда ли, что насекомые спят с открытыми глазами?",
            "Правда ли, что мед дают только пчелы?",
            "Правда ли, что было время, когда в оперу ходили со своим стулом?",
            "Правда ли, что грушевое дерево может приносить яблоки?",
            "Правда ли, что каратэ — это старояпонская борьба?",
            "Правда ли, что клаустрофобия — это страх перед экзаменами?",
            "Правда ли, что шея жирафа может достигать двух метров в длину?",
            "Правда ли, что в Японии ученики на доске пишут кисточкой с цветными чернилами?",
            "Правда ли, что римляне носили штаны?",
            "Правда ли, что правда ли что, пауки питаются собственной паутиной?",
            "Правда ли, что если камбалу положить на шахматную доску, она тоже станет клетчатой?",
            "Правда ли, что некоторые лягушки умеют летать? ",
            "Правда ли, что дельфины — это маленькие киты?",
            "Правда ли, что первое место среди причин гибели от несчастных случаев в Японии в 1995г. заняли туфли на высоком каблуке?",
            "Правда ли, что спартанские воины перед битвой опрыскивали волосы духами?",
            "Правда ли, что белокурые волосы растут быстрее, чем тёмные?",
            "Правда ли, что один волос может выдержать вес в 3 кг?",
            "Правда ли, что чтобы покончить жизнь самоубийством с помощью кофе, нужно выпить 100 чашек подряд?",
            "Правда ли, что арахис используется при производстве динамита?",
            "Правда ли, что ананасы растут на деревьях?",
            "Правда ли, что лошадь фыркает, чтобы предупредить других об опасности?",
            "Правда ли, что когда вы краснеете, ваш желудок НЕ краснеет тоже?",
            "Правда ли, что у человека меньше мускулов, чем у гусеницы?",
            "Правда ли, что ярко-красные яблоки могут вызвать аллергию?",
            "Правда ли, что у белых медведей чёрная кожа?",
    };

    String answers[] = {
            "Правда",
            "Ложь",
            "Правда",
            "Правда",
            "Ложь",
            "Ложь",
            "Правда",
            "Ложь",
            "Правда",
            "Правда",
            "Ложь",
            "Правда",
            "Ложь",
            "Правда",
            "Ложь",
            "Правда",
            "Правда",
            "Ложь",
            "Ложь",
            "Правда",
            "Правда",
            "Ложь",
            "Правда",
            "Правда",
            "Правда",
            "Ложь",
            "Правда",
            "Правда",
            "Правда",
            "Правда",
            "Правда",
            "Правда",
            "Ложь",
            "Ложь",
            "Ложь",
            "Правда",
            "Правда",
            "Правда",
    };

    MediaPlayer mPlayer;

    private CountDownTimer countDownTimer;
    private long timemilliseconds = 36000;

    Random r;

    int Count = 0;

    TextView text,time,score;
    Button truee,lie,start;

    int num_quest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truth_or_lie);

        text = (TextView) findViewById(R.id.text);
        time = (TextView) findViewById(R.id.time);
        score = (TextView) findViewById(R.id.score);
        truee = (Button) findViewById(R.id.truee);
        lie = (Button) findViewById(R.id.lie);
        start = (Button) findViewById(R.id.start);

        r = new Random();

        truee.setEnabled(false);
        lie.setEnabled(false);

    }

    private void newGame(){
        truee.setEnabled(true);
        lie.setEnabled(true);
        num_quest = r.nextInt(questions.length);
        text.setText(questions[num_quest]);
        StartTime();
    }

    public void clickTrue(View view){
        if(truee.getText().toString().equalsIgnoreCase(answers[num_quest])){
            Count++;
            score.setText("Score : "+ Count);
            newGame();
        } else {
            if(Count > 0){
                Count--;
                score.setText("Score : "+ Count);
                newGame();
            }
            else{
                newGame();
            }
        }
    }

    public void clickLie(View view){
        if(lie.getText().toString().equalsIgnoreCase(answers[num_quest])){
            Count++;
            score.setText("Score : "+ Count);
            newGame();
        } else {
            if(Count > 0){
                Count--;
                score.setText("Score : "+ Count);
                newGame();
            }
            else{
                newGame();
            }
        }
    }

    public void startGame(View view){
        newGame();
        start.setVisibility(View.GONE);
    }

    private void StartTime(){
        mPlayer= MediaPlayer.create(this, R.raw.timee);
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
                truee.setEnabled(true);
                lie.setEnabled(true);
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
