package com.example.admin.a2d_puzzle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class Test extends AppCompatActivity{

    ProgressBar progressBar;

    Random r;


    int i = 0;
    int x = 0;

    String dictionary[] = {
            "1"
    };

    @BindView(R.id.setting) ImageView setting;
    @BindView(R.id.my_office) ImageView my_office;

    @OnClick(R.id.setting)
    public void click_setting(){
        Intent intent_setting = new Intent(getApplicationContext(), Setting.class);
        startActivityForResult(intent_setting,111);
    }

    @OnClick(R.id.my_office)
    public void click_my_office(){
        Intent intent_my_office = new Intent(getApplicationContext(), My_office.class);
        startActivityForResult(intent_my_office,222);
    }

    @BindView(R.id.check) Button check_b;
    @BindView(R.id.b_show_definition) Button b_show_definition;
    @BindView(R.id.b_open_letter) Button b_open_letter;
    @BindView(R.id.b_open_word) Button b_open_word;
    @BindView(R.id.edt) EditText edt;
    @BindView(R.id.text) TextView text;
    @BindView(R.id.money) TextView Money_text;


    boolean all_notification = true;
    boolean music = true;
    boolean aSwitch = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

        r = new Random();

        progressBar = (ProgressBar) findViewById(R.id.progress);

        changeWord();
        newGame();
        enterWord();
        progressBar1();

        check_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt.getText().toString().trim().equalsIgnoreCase(dictionary[0])) {
                    check_b.setEnabled(false);
                    edt.setEnabled(false);
                    Toast.makeText(Test.this, "Правильно!", Toast.LENGTH_SHORT).show();
                    b_show_definition.setEnabled(false);
                    b_open_letter.setEnabled(false);
                    b_open_word.setEnabled(false);

                    int money_for_open_word = Integer.parseInt(Money_text.getText().toString());
                    money_for_open_word += 20;
                    Money_text.setText(""+money_for_open_word);

                    forResult();
                } else {
                    Toast.makeText(Test.this, "     Неверно!" + "\n" + "Попробуй еще", Toast.LENGTH_LONG).show();

                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null){
            return;
        }

        if(requestCode == 111) {
            all_notification = data.getBooleanExtra("notification",true);
             music = data.getBooleanExtra("music",true);
            aSwitch = data.getBooleanExtra("aSwitch",true);
        }

        if(requestCode == 222) {
            int money1 = data.getIntExtra("roulette_score", 0);
            int result = Integer.parseInt(Money_text.getText().toString()) + money1;
            Money_text.setText("" + result);
        }

    }

    public void progressBar1() {
        Intent intent = getIntent();
        x = intent.getIntExtra("progress", 0);
        progressBar.setProgress(x);
    }


    private String shuffleWord(String word) {
        List<String> letters = Arrays.asList(word.split(""));
        Collections.shuffle(letters);

        String shuffled = "";
        for (String letter : letters) {
            shuffled += letter;
        }
        return shuffled;
    }

    public void NextLvl(){
        this.startActivity(new Intent(getApplicationContext(), Test.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
    }


    public void forResult() {
        switch (dictionary[0]) {
            case "яр":
                Intent intent_1 = new Intent();
                intent_1.putExtra("money_result", Money_text.getText().toString());
                intent_1.putExtra("block", "1");
                intent_1.putExtra("notification", all_notification);
                intent_1.putExtra("music", music);
                intent_1.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_1);
                finish();
                break;
            case "ад":
                Intent intent_2 = new Intent();
                intent_2.putExtra("money_result", Money_text.getText().toString());
                intent_2.putExtra("block", "2");
                setResult(RESULT_OK, intent_2);
                intent_2.putExtra("notification", all_notification);
                intent_2.putExtra("music", music);
                intent_2.putExtra("switch", aSwitch);
                finish();
                break;
            case "дом":
                Intent intent_3 = new Intent();
                intent_3.putExtra("money_result", Money_text.getText().toString());
                intent_3.putExtra("block", "3");
                intent_3.putExtra("notification", all_notification);
                intent_3.putExtra("music", music);
                intent_3.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_3);
                finish();
                break;
            case "мак":
                Intent intent_4 = new Intent();
                intent_4.putExtra("money_result", Money_text.getText().toString());
                intent_4.putExtra("block", "4");
                intent_4.putExtra("notification", all_notification);
                intent_4.putExtra("music", music);
                intent_4.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_4);
                finish();
                break;
            case "лес":
                Intent intent_5 = new Intent();
                intent_5.putExtra("money_result", Money_text.getText().toString());
                intent_5.putExtra("block", "5");
                intent_5.putExtra("notification", all_notification);
                intent_5.putExtra("music", music);
                intent_5.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_5);
                finish();
                break;
            case "бал":
                Intent intent_6 = new Intent();
                intent_6.putExtra("money_result", Money_text.getText().toString());
                intent_6.putExtra("block", "6");
                intent_6.putExtra("notification", all_notification);
                intent_6.putExtra("music", music);
                intent_6.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_6);
                finish();
                break;
            case "бор":
                Intent intent_7 = new Intent();
                intent_7.putExtra("money_result", Money_text.getText().toString());
                intent_7.putExtra("block", "7");
                intent_7.putExtra("notification", all_notification);
                intent_7.putExtra("music", music);
                intent_7.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_7);
                finish();
                break;
            case "бокс":
                Intent intent_8 = new Intent();
                intent_8.putExtra("money_result", Money_text.getText().toString());
                intent_8.putExtra("block", "8");
                intent_8.putExtra("notification", all_notification);
                intent_8.putExtra("music", music);
                intent_8.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_8);
                finish();
                break;
            case "блюз":
                Intent intent_9 = new Intent();
                intent_9.putExtra("money_result", Money_text.getText().toString());
                intent_9.putExtra("block", "9");
                intent_9.putExtra("notification", all_notification);
                intent_9.putExtra("music", music);
                intent_9.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_9);
                finish();
                break;
            case "бард":
                Intent intent_10 = new Intent();
                intent_10.putExtra("money_result", Money_text.getText().toString());
                intent_10.putExtra("block", "10");
                intent_10.putExtra("notification", all_notification);
                intent_10.putExtra("music", music);
                intent_10.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_10);
                finish();
                break;
            case "жало":
                Intent intent_11 = new Intent();
                intent_11.putExtra("money_result", Money_text.getText().toString());
                intent_11.putExtra("block", "11");
                intent_11.putExtra("notification", all_notification);
                intent_11.putExtra("music", music);
                intent_11.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_11);
                finish();
                break;
            case "марш":
                Intent intent_12 = new Intent();
                intent_12.putExtra("money_result", Money_text.getText().toString());
                intent_12.putExtra("block", "12");
                intent_12.putExtra("notification", all_notification);
                intent_12.putExtra("music", music);
                intent_12.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_12);
                finish();
                break;
            case "канал":
                Intent intent_13 = new Intent();
                intent_13.putExtra("money_result", Money_text.getText().toString());
                intent_13.putExtra("block", "13");
                intent_13.putExtra("notification", all_notification);
                intent_13.putExtra("music", music);
                intent_13.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_13);
                finish();
                break;
            case "арена":
                Intent intent_14 = new Intent();
                intent_14.putExtra("money_result", Money_text.getText().toString());
                intent_14.putExtra("block", "14");
                intent_14.putExtra("notification", all_notification);
                intent_14.putExtra("music", music);
                intent_14.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_14);
                finish();
                break;
            case "вафля":
                Intent intent_15 = new Intent();
                intent_15.putExtra("money_result", Money_text.getText().toString());
                intent_15.putExtra("block", "15");
                intent_15.putExtra("notification", all_notification);
                intent_15.putExtra("music", music);
                intent_15.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_15);
                finish();
                break;
            case "висок":
                Intent intent_16 = new Intent();
                intent_16.putExtra("money_result", Money_text.getText().toString());
                intent_16.putExtra("block", "16");
                intent_16.putExtra("notification", all_notification);
                intent_16.putExtra("music", music);
                intent_16.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_16);
                finish();
                break;
            case "купол":
                Intent intent_17 = new Intent();
                intent_17.putExtra("money_result", Money_text.getText().toString());
                intent_17.putExtra("block", "17");
                intent_17.putExtra("notification", all_notification);
                intent_17.putExtra("music", music);
                intent_17.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_17);
                finish();
                break;
            case "азбука":
                Intent intent_18 = new Intent();
                intent_18.putExtra("money_result", Money_text.getText().toString());
                intent_18.putExtra("block", "18");
                intent_18.putExtra("notification", all_notification);
                intent_18.putExtra("music", music);
                intent_18.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_18);
                finish();
                break;
            case "почерк":
                Intent intent_19 = new Intent();
                intent_19.putExtra("money_result", Money_text.getText().toString());
                intent_19.putExtra("block", "19");
                intent_19.putExtra("notification", all_notification);
                intent_19.putExtra("music", music);
                intent_19.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_19);
                finish();
                break;
            case "офлайн":
                Intent intent_20 = new Intent();
                intent_20.putExtra("money_result", Money_text.getText().toString());
                intent_20.putExtra("block", "20");
                intent_20.putExtra("notification", all_notification);
                intent_20.putExtra("music", music);
                intent_20.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_20);
                finish();
                break;
            case "алтарь":
                Intent intent_21 = new Intent();
                intent_21.putExtra("money_result", Money_text.getText().toString());
                intent_21.putExtra("block", "21");
                intent_21.putExtra("notification", all_notification);
                intent_21.putExtra("music", music);
                intent_21.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_21);
                finish();
                break;
            case "дранье":
                Intent intent_22 = new Intent();
                intent_22.putExtra("money_result", Money_text.getText().toString());
                intent_22.putExtra("block", "22");
                intent_22.putExtra("notification", all_notification);
                intent_22.putExtra("music", music);
                intent_22.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_22);
                finish();
                break;
            case "будущий":
                Intent intent_23 = new Intent();
                intent_23.putExtra("money_result", Money_text.getText().toString());
                intent_23.putExtra("block", "23");
                intent_23.putExtra("notification", all_notification);
                intent_23.putExtra("music", music);
                intent_23.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_23);
                finish();
                break;
            case "дворник":
                Intent intent_24 = new Intent();
                intent_24.putExtra("money_result", Money_text.getText().toString());
                intent_24.putExtra("block", "24");
                intent_24.putExtra("notification", all_notification);
                intent_24.putExtra("music", music);
                intent_24.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_24);
                finish();
                break;
            case "мозаика":
                Intent intent_25 = new Intent();
                intent_25.putExtra("money_result", Money_text.getText().toString());
                intent_25.putExtra("block", "25");
                intent_25.putExtra("notification", all_notification);
                intent_25.putExtra("music", music);
                intent_25.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_25);
                finish();
                break;
            case "дуршлаг":
                Intent intent_26 = new Intent();
                intent_26.putExtra("money_result", Money_text.getText().toString());
                intent_26.putExtra("block", "26");
                intent_26.putExtra("notification", all_notification);
                intent_26.putExtra("music", music);
                intent_26.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_26);
                finish();
                break;
            case "виртуоз":
                Intent intent_27 = new Intent();
                intent_27.putExtra("money_result", Money_text.getText().toString());
                intent_27.putExtra("block", "27");
                intent_27.putExtra("notification", all_notification);
                intent_27.putExtra("music", music);
                intent_27.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_27);
                finish();
                break;
            case "продюсер":
                Intent intent_28 = new Intent();
                intent_28.putExtra("money_result", Money_text.getText().toString());
                intent_28.putExtra("block", "28");
                intent_28.putExtra("notification", all_notification);
                intent_28.putExtra("music", music);
                intent_28.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_28);
                finish();
                break;
            case "капучино":
                Intent intent_29 = new Intent();
                intent_29.putExtra("money_result", Money_text.getText().toString());
                intent_29.putExtra("block", "29");
                intent_29.putExtra("notification", all_notification);
                intent_29.putExtra("music", music);
                intent_29.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_29);
                finish();
                break;
            case "кредитка":
                Intent intent_30 = new Intent();
                intent_30.putExtra("money_result", Money_text.getText().toString());
                intent_30.putExtra("block", "30");
                intent_30.putExtra("notification", all_notification);
                intent_30.putExtra("music", music);
                intent_30.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_30);
                finish();
                break;
            case "лексикон":
                Intent intent_31 = new Intent();
                intent_31.putExtra("money_result", Money_text.getText().toString());
                intent_31.putExtra("block", "31");
                intent_31.putExtra("notification", all_notification);
                intent_31.putExtra("music", music);
                intent_31.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_31);
                finish();
                break;
            case "бриллиант":
                Intent intent_32 = new Intent();
                intent_32.putExtra("money_result", Money_text.getText().toString());
                intent_32.putExtra("block", "32");
                intent_32.putExtra("notification", all_notification);
                intent_32.putExtra("music", music);
                intent_32.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_32);
                finish();
                break;
            case "адреналин":
                Intent intent_33 = new Intent();
                intent_33.putExtra("money_result", Money_text.getText().toString());
                intent_33.putExtra("block", "33");
                intent_33.putExtra("notification", all_notification);
                intent_33.putExtra("music", music);
                intent_33.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_33);
                finish();
                break;
            case "грейпфрут":
                Intent intent_34 = new Intent();
                intent_34.putExtra("money_result", Money_text.getText().toString());
                intent_34.putExtra("block", "34");
                intent_34.putExtra("notification", all_notification);
                intent_34.putExtra("music", music);
                intent_34.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_34);
                finish();
                break;
            case "чугуновоз":
                Intent intent_35 = new Intent();
                intent_35.putExtra("money_result", Money_text.getText().toString());
                intent_35.putExtra("block", "35");
                intent_35.putExtra("notification", all_notification);
                intent_35.putExtra("music", music);
                intent_35.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_35);
                finish();
                break;
            case "авитаминоз":
                Intent intent_36 = new Intent();
                intent_36.putExtra("money_result", Money_text.getText().toString());
                intent_36.putExtra("block", "36");
                intent_36.putExtra("notification", all_notification);
                intent_36.putExtra("music", music);
                intent_36.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_36);
                finish();
                break;
            case "бензопровод":
                Intent intent_37 = new Intent();
                intent_37.putExtra("money_result", Money_text.getText().toString());
                intent_37.putExtra("block", "37");
                intent_37.putExtra("notification", all_notification);
                intent_37.putExtra("music", music);
                intent_37.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_37);
                finish();
                break;
            case "автомобилист":
                Intent intent_38 = new Intent();
                intent_38.putExtra("money_result", Money_text.getText().toString());
                intent_38.putExtra("block", "38");
                intent_38.putExtra("notification", all_notification);
                intent_38.putExtra("music", music);
                intent_38.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_38);
                finish();
                break;
            case "свидетельница":
                Intent intent_39 = new Intent();
                intent_39.putExtra("money_result", Money_text.getText().toString());
                intent_39.putExtra("block", "39");
                intent_39.putExtra("notification", all_notification);
                intent_39.putExtra("music", music);
                intent_39.putExtra("switch", aSwitch);
                setResult(RESULT_OK, intent_39);
                finish();
                break;
        }
    }

    public void changeWord() {
        Intent intent = getIntent();
        dictionary[i] = intent.getStringExtra("dictionary");
        Money_text.setText(intent.getStringExtra("money_data"));
    }

    private void newGame() {
        //currentWord = dictionary[r.nextInt(dictionary.length)];

        text.setText(shuffleWord(dictionary[0]));

        edt.setText("");

        check_b.setEnabled(true);
    }


    public void openLetter(View view) {
        int money_for_open_word = Integer.parseInt(Money_text.getText().toString());

        if(money_for_open_word >= ((dictionary[0].length()*20* 30)/100)) {
         if (dictionary[0].length() != edt.getText().toString().length()) {
            int k = 0;
            for (int i = 1; i <= edt.getText().toString().length(); i++) {
                if (edt.getText().toString().startsWith(dictionary[0].substring(0, i))) {
                    k++;
                }
            }
            edt.setText("" + dictionary[0].substring(0, ++k));
            money_for_open_word -= ((dictionary[0].length() * 20* 30) / 100);
        } else {
            if (edt.getText().toString().equalsIgnoreCase(dictionary[0])) {
                edt.setEnabled(false);
                b_show_definition.setEnabled(false);
                b_open_letter.setEnabled(false);
                b_open_word.setEnabled(false);
            }  else {
                edt.setText("" + dictionary[0].substring(0, 1));

                money_for_open_word -= ((dictionary[0].length() * 20* 30) / 100);
            }
            }
        }else {
            Toast.makeText(this, "Не хватает монет", Toast.LENGTH_SHORT).show();
        }
        Money_text.setText(""+money_for_open_word);
    }


    public void openWord(View view) {
        int money_for_open_word = Integer.parseInt(Money_text.getText().toString());
        if(money_for_open_word >= ((dictionary[0].length()*20*80)/100)){
            money_for_open_word -= ((dictionary[0].length()*20*80)/100);
            Toast.makeText(this, ""+money_for_open_word, Toast.LENGTH_SHORT).show();
            Money_text.setText(""+money_for_open_word);
            edt.setText(dictionary[0]);
        } else {
            Toast.makeText(this, "Не хватает монет", Toast.LENGTH_SHORT).show();
        }
    }

    private void enterWord() { // Количество вводимых слов в строку
        int maxLength = dictionary[0].length();
        edt.setMaxLines(1);
        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(maxLength);
        edt.setFilters(FilterArray);
    }


    public void showDefinition(View view) {
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(Test.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
        int money_for_open_word = Integer.parseInt(Money_text.getText().toString());
        if(money_for_open_word > ((dictionary[0].length()*20*50)/100)) {
        switch (dictionary[0]) {
            case "яр":
                sweetAlertDialog.setTitleText(" - высокий, обрывистый, вогнутый, обычно речной и не затопляемый в половодье берег!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20*50) / 100) ;
                break;
            case "ад":
                sweetAlertDialog.setTitleText(" - ужасное, чаще посмертное, место наказания грешников, испытывающих в нём муки и страдания!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20 * 50) / 100);

                break;
            case "дом":
                sweetAlertDialog.setTitleText(" - жилое (или для учреждения) здание, в котором живут или работают люди!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20 * 50) / 100) ;

                break;
            case "мак":
                sweetAlertDialog.setTitleText(" - травянистое растение с длинным стеблем и крупными, чаще красными, цветками!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();
                money_for_open_word -= ((dictionary[0].length() * 20* 50) / 100);

                break;
            case "лес":
                sweetAlertDialog.setTitleText(" - большая площадь земли, заросшая деревьями!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20* 50) / 100) ;

                break;
            case "бал":
                sweetAlertDialog.setTitleText(" - собрание многочисленного общества лиц обоих полов для танцев!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20* 50) / 100) ;

                break;
            case "бор":
                sweetAlertDialog.setTitleText(" - хвойный лес!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20* 50) / 100) ;

                break;
            case "бокс":
                sweetAlertDialog.setTitleText(" - контактный вид спорта, единоборство, в котором спортсмены наносят друг другу удары кулаками в специальных перчатках!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20 * 50) / 100);

                break;
            case "блюз":
                sweetAlertDialog.setTitleText(" - джазовая афроамериканская музыка, а также парный бальный танец типа медленного фокстрота!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100 * 50) ;

                break;
            case "бард":
                sweetAlertDialog.setTitleText(" - певец или поэт; как правило, одиночный исполнитель песен собственного сочинения!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20 * 50) / 100) ;

                break;
            case "жало":
                sweetAlertDialog.setTitleText(" - общеупотребительное название заострённого органа или части тела различных животных и растений, используемого для впрыскивания ядовитого или жгучего вещества под кожу жертвы или для нанесения электрического удара!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20* 50) / 100);

                break;
            case "марш":
                sweetAlertDialog.setTitleText(" - род музыки, как правило военной, сопровождающей или рисующей стройные размеренные движения людей, преимущественно войск!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20* 50) / 100) ;

                break;
            case "канал":
                sweetAlertDialog.setTitleText(" - вытянутое, искусственно ограниченное пространство, предназначенное для организации связи, передачи или перемещения чего-либо.!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20* 50) / 100) ;

                break;
            case "арена":
                sweetAlertDialog.setTitleText(" - место проведения спортивных соревнований!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "вафля":
                sweetAlertDialog.setTitleText(" - тонкое сухое печенье с клетчатым оттиском по поверхности!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "висок":
                sweetAlertDialog.setTitleText(" - парная анатомическая область головы человека между ухом и лбом!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "купол":
                sweetAlertDialog.setTitleText(" - выпуклая крыша в виде полушария!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "азбука":
                sweetAlertDialog.setTitleText(" - название букваря, книги для изучения фонетики(звучания) букв и их написания!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "почерк":
                sweetAlertDialog.setTitleText(" - манера писать, характер начертаний букв в письме!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "офлайн":
                sweetAlertDialog.setTitleText(" - в компьютерной технике даное слово означает, что устройство выключено!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "алтарь":
                sweetAlertDialog.setTitleText(" - сооружение для совершения ритуальных жертвоприношений(жертвенник)!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "дранье":
                sweetAlertDialog.setTitleText(" - разорванные вещи!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "будущий":
                sweetAlertDialog.setTitleText(" - время и события, следующие за настоящим!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "дворник":
                sweetAlertDialog.setTitleText(" - работник, поддерживающий чистоту и порядок на дворе и на улице около дома!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "мозаика":
                sweetAlertDialog.setTitleText(" - рисунок или узор из скреплённых между собой разноцветных камешков, кусочков стекла, эмали и др!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;


                break;
            case "дуршлаг":
                sweetAlertDialog.setTitleText(" - кухонная посуда в виде металлического решета с ручкой для отцеживания чего-либо, варившегося в воде!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "виртуоз":
                sweetAlertDialog.setTitleText(" - тот, кто в совершенстве владеет техникой своего искусства преимущ. о музыкантах!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "продюсер":
                sweetAlertDialog.setTitleText(" - человек, организующий производство художественного произведения, осуществляющий финансовый и идейно-художественный контроль за ходом производства!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "капучино":
                sweetAlertDialog.setTitleText(" - кофейный напиток итальянской кухни на основе эспрессо с добавлением в него подогретого вспененного молока!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "кредитка":
                sweetAlertDialog.setTitleText(" - банковская платёжная карта, предназначенная для совершения операций, расчёты по которым осуществляются исключительно за счёт денежных средств, предоставленных банком клиенту!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "лексикон":
                sweetAlertDialog.setTitleText(" - словарный состав языка!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "бриллиант":
                sweetAlertDialog.setTitleText(" -  алмаз, которому посредством обработки придана специальная форма, максимально выявляющая его естественный блеск!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "адреналин":
                sweetAlertDialog.setTitleText(" - гормон мозгового вещества надпочечников, повышающий обмен веществ в организме и жизненную энергию!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;
                break;
            case "грейпфрут":
                sweetAlertDialog.setTitleText(" - субтропическое вечнозелёное дерево,гибрид лимона и апельсина!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();
                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;
                break;
            case "чугуновоз":
                sweetAlertDialog.setTitleText(" - вид грузового вагона, распространённый по всему миру!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "авитаминоз":
                sweetAlertDialog.setTitleText(" - заболевание, вызываемое недостатком витаминов в пище!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "бензопровод":
                sweetAlertDialog.setTitleText(" - устройство (трубка, шланг) в самолётах, автомобилях и пр., по к-рым жидкое топливо поступает из бака в двигатель!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "автомобилист":
                sweetAlertDialog.setTitleText(" - специалист по автомобильному делу!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();
                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;

                break;
            case "свидетельница":
                sweetAlertDialog.setTitleText(" - один из главнейших участников свадебного обряда!")
                        .setCustomImage(R.drawable.ic_question_answer)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();
                money_for_open_word -= ((dictionary[0].length() * 20) / 100) * 50;
            }
        } else {
            Toast.makeText(this, "Не хватает монет", Toast.LENGTH_SHORT).show();
        }
        Money_text.setText(""+money_for_open_word);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("save_count", Money_text.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Money_text.setText(savedInstanceState.getString("save_count"));
    }

    @Override
    public void onBackPressed() {
            Intent i2 = new Intent();
            i2.putExtra("money_result", Money_text.getText().toString());
            i2.putExtra("block", "0");
            i2.putExtra("notification", all_notification);
            i2.putExtra("music", music);
            i2.putExtra("switch", aSwitch);
            setResult(RESULT_OK, i2);
            finish();
        super.onBackPressed();

    }
}