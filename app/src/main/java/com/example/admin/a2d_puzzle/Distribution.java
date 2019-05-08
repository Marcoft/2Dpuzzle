package com.example.admin.a2d_puzzle;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class Distribution extends AppCompatActivity {

    MediaPlayer mPlayer;


    @BindView(R.id.check_truth_lie) CheckBox check_truth_lie;
    @BindView(R.id.check_color_play) CheckBox check_color_play;
    @BindView(R.id.check_growth) CheckBox check_growth;
    @BindView(R.id.check_find_match) CheckBox check_find_match;
    @BindView(R.id.check_rememb_last) CheckBox check_rememb_last;
    @BindView(R.id.check_remember_and_diap) CheckBox check_remember_and_diap;
    @BindView(R.id.check_coordinat) CheckBox check_coordinat;
    @BindView(R.id.check_continur_row) CheckBox check_continur_row;
    @BindView(R.id.check_colords) CheckBox check_colords;
    @BindView(R.id.check_logic_compr) CheckBox check_logic_compr;
    @BindView(R.id.check_find_image) CheckBox check_find_image;
    @BindView(R.id.check_find_number) CheckBox check_find_number;

    @BindView(R.id.bestScore_color) TextView bestScore_color;
    @BindView(R.id.bestScore_color_play) TextView bestScore_color_play;
    @BindView(R.id.bestScore_cont_row) TextView bestScore_cont_row;
    @BindView(R.id.bestScore_coordination) TextView  bestScore_coordination;
    @BindView(R.id.bestScore_find_image)TextView bestScore_find_image;
    @BindView(R.id.bestScore_find_match)TextView bestScore_find_match;
    @BindView(R.id.bestScore_find_number)TextView bestScore_find_number;
    @BindView(R.id.bestScore_growth)TextView bestScore_growth;
    @BindView(R.id.bestScore_logical_compr)TextView bestScore_logical_compr;
    @BindView(R.id.bestScore_rememb_last)TextView bestScore_rememb_last;
    @BindView(R.id.bestScore_remember_and_disp)TextView bestScore_remember_and_disp;
    @BindView(R.id.bestScore_truth)TextView bestScore_truth;

    boolean all_notification = true;
    boolean music = true;
    boolean aSwitch = true;
    boolean musi = true;
    boolean mus = true;

    SharedPreferences sPref;
    final public String SAVED_TEXT = "saved_text";
    String all_money = "";
    int moneey;

    @BindView(R.id.money) TextView money;
    @BindView(R.id.setting) ImageView setting;
    @BindView(R.id.my_office) ImageView my_office;

    private NotificationManagerCompat nm;

    public String text_for_notific_id = "0";

    public final int NOTIFICATION_truth_lie = 1;
    public final int NOTIFICATION_color_play = 2;
    public final int NOTIFICATION_growth = 3;
    public final int NOTIFICATION_find_match = 4;
    public final int NOTIFICATION_rememb_last = 5;
    public final int NOTIFICATION_remember_and_diap = 6;
    public final int NOTIFICATION_coordinat = 7;
    public final int NOTIFICATION_continur_row = 8;
    public final int NOTIFICATION_colords = 9;
    public final int NOTIFICATION_logic_compr = 10;
    public final int NOTIFICATION_find_image = 11;
    public final int NOTIFICATION_find_number = 12;

    int money1;


    @OnClick(R.id.my_office)
    public void click_my_office(){
        Intent intent_my_office = new Intent(getApplicationContext(), My_office.class);
        startActivityForResult(intent_my_office,222);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distribution);
        ButterKnife.bind(this);
        LoadInformation();

        startMusic();

    }

    @Override
    protected void onResume() {
        startMusic();
        super.onResume();
    }

    public void startMusic(){
        if(music) {
            mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.picnic_on_the_roof);
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlay();
                }
            });
            mPlayer.start();
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



    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_anagram:
                Intent intent_anagram = new Intent(getApplicationContext(), Main.class);
                intent_anagram.putExtra("count_data",money.getText().toString());
                startActivityForResult(intent_anagram,1);
                break;
            case R.id.btn_math:
                Intent intent_math = new Intent(getApplicationContext(), Math_lvls.class);
                intent_math.putExtra("count_data",money.getText().toString());
                startActivity(intent_math);
                break;
            /*case R.id.btn_puzzle2d:
                Intent intent_puzzle2d = new Intent(getApplicationContext(), Colords.class);
                startActivity(intent_puzzle2d);
                break;*/
            case R.id.btn_color:
                if (mPlayer.isPlaying()) {
                    stopPlay();
                }
                Intent intent_color = new Intent(getApplicationContext(), Colords.class);
                startActivityForResult(intent_color,1_1);;
                break;
            case R.id.btn_rememb_and_display:
                if (mPlayer.isPlaying()) {
                    stopPlay();
                }
                Intent intent_rememb_and_display = new Intent(getApplicationContext(), RememberAndDisplay.class);
                startActivityForResult(intent_rememb_and_display,2_2);
                break;
            case R.id.btn_find_number:
                if (mPlayer.isPlaying()) {
                    stopPlay();
                }
                Intent intent_find_number = new Intent(getApplicationContext(), FindNumber.class);
                startActivityForResult(intent_find_number,3_3);
                break;
            case R.id.logical_comp:
                if (mPlayer.isPlaying()) {
                    stopPlay();
                }
                Intent intent_logical_compr = new Intent(getApplicationContext(), Logical_comprassion.class);
                startActivityForResult(intent_logical_compr,4_4);
                break;
            case R.id.find_image:
                if (mPlayer.isPlaying()) {
                    stopPlay();
                }
                Intent intent_find_image = new Intent(getApplicationContext(), FindImage.class);
                startActivityForResult(intent_find_image,5_5);
                break;
            case R.id.cont_row:
                if (mPlayer.isPlaying()) {
                    stopPlay();
                }
                Intent intent_cont_row = new Intent(getApplicationContext(), Continue_the_row.class);
                startActivityForResult(intent_cont_row,6_6);
                break;
            case R.id.btn_rememb_last:
                if (mPlayer.isPlaying()) {
                    stopPlay();
                }
                Intent intent_rememb_last = new Intent(getApplicationContext(), Remember_Last.class);
                startActivityForResult(intent_rememb_last,7_7);
                break;
            case R.id.coordination:
                if (mPlayer.isPlaying()) {
                    stopPlay();
                }
                Intent intent_coordination = new Intent(getApplicationContext(), Coordination.class);
                startActivityForResult(intent_coordination,8_8);
                break;
            case R.id.btn_find_match:
                if (mPlayer.isPlaying()) {
                    stopPlay();
                }
                Intent intent_find_match = new Intent(getApplicationContext(), Find_a_Match.class);
                startActivityForResult(intent_find_match,9_9);
                break;
            case R.id.btn_growth:
                if (mPlayer.isPlaying()) {
                    stopPlay();
                }
                Intent intent_btn_growth = new Intent(getApplicationContext(), Decrease_growth.class);
                startActivityForResult(intent_btn_growth,10_10);
                break;
            case R.id.btn_color_play:
                if (mPlayer.isPlaying()) {
                    stopPlay();
                }
                Intent intent_color_play = new Intent(getApplicationContext(), Game_of_Color.class);
                startActivityForResult(intent_color_play,11_11);
                break;
            case R.id.btn_truth_or_lie:
                if (mPlayer.isPlaying()) {
                    stopPlay();
                }
                Intent intent_truth_or_lie = new Intent(getApplicationContext(), Truth_or_lie.class);
                startActivityForResult(intent_truth_or_lie,12_12);
                break;

            case R.id.setting:
                Intent intent_setting = new Intent(getApplicationContext(), Setting.class);
                startActivityForResult(intent_setting,111);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null){
            return;
        }
        if(requestCode == 1_1 || requestCode == 2_2 || requestCode == 3_3 || requestCode == 4_4 ||
                requestCode == 5_5 || requestCode == 6_6 || requestCode == 7_7 || requestCode == 8_8
            || requestCode == 9_9 || requestCode == 10_10 || requestCode == 11_11 || requestCode == 12_12) {
            all_money = money.getText().toString();
            money1 = data.getIntExtra("score", 0);
                moneey = Integer.parseInt(all_money) + money1;
                money.setText("" + moneey);
            SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(Distribution.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE);

                if(money1 == 1){
                    sweetAlertDialog.setTitleText("Вы заработали " + money1 + " монетку!")
                            .setCustomImage(R.drawable.ic_pazzle)
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                    sweetAlertDialog.dismiss();
                                }
                            })
                            .show();
                } else if(money1 == 2 || money1 == 3 || money1 == 4){
                    sweetAlertDialog.setTitleText("Вы заработали " + money1 + " монетки!")
                            .setCustomImage(R.drawable.ic_pazzle)
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                    sweetAlertDialog.dismiss();
                                }
                            })
                            .show();
                } else {
                    sweetAlertDialog.setTitleText("Вы заработали " + money1 + " монеток!")
                            .setCustomImage(R.drawable.ic_pazzle)
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                    sweetAlertDialog.dismiss();
                                }
                            })
                            .show();
                }

            if(music) {
                startMusic();
            }

        }

        if(requestCode == 1_1){
            text_for_notific_id = "1";
            timerGame();

            if(Integer.parseInt(bestScore_color.getText().toString()) < money1) {
                bestScore_color.setText("" + money1);
            }
        } else if(requestCode == 2_2){
            text_for_notific_id = "2";
            timerGame();

            if(Integer.parseInt(bestScore_remember_and_disp.getText().toString()) < money1) {
                bestScore_remember_and_disp.setText("" + money1);
            }
        } else if(requestCode == 3_3){
            text_for_notific_id = "3";
            timerGame();

            if(Integer.parseInt(bestScore_find_number.getText().toString()) < money1) {
                bestScore_find_number.setText("" + money1);
            }
        } else if(requestCode == 4_4){
            text_for_notific_id = "4";
            timerGame();

            if(Integer.parseInt(bestScore_logical_compr.getText().toString()) < money1) {
                bestScore_logical_compr.setText("" + money1);
            }
        } else if(requestCode == 5_5){
            text_for_notific_id = "5";
            timerGame();

            if(Integer.parseInt(bestScore_find_image.getText().toString()) < money1) {
                bestScore_find_image.setText("" + money1);
            }
        } else if(requestCode == 6_6){
            text_for_notific_id = "6";
            timerGame();

            if(Integer.parseInt(bestScore_cont_row.getText().toString()) < money1) {
                bestScore_cont_row.setText("" + money1);
            }
        } else if(requestCode == 7_7){
            text_for_notific_id = "7";
           timerGame();


            if(Integer.parseInt(bestScore_rememb_last.getText().toString()) < money1) {
                bestScore_rememb_last.setText("" + money1);
            }
        } else if(requestCode == 8_8){
            text_for_notific_id = "8";
            timerGame();

            if(Integer.parseInt(bestScore_coordination.getText().toString()) < money1) {
                bestScore_coordination.setText("" + money1);
            }
        } else if(requestCode == 9_9){
            text_for_notific_id = "9";
            timerGame();

            if(Integer.parseInt(bestScore_find_match.getText().toString()) < money1) {
                bestScore_find_match.setText("" + money1);
            }
        } else if(requestCode == 10_10){
            text_for_notific_id = "10";
            timerGame();

            if(Integer.parseInt(bestScore_growth.getText().toString()) < money1) {
                bestScore_growth.setText("" + money1);
            }
        } else if(requestCode == 11_11){
            text_for_notific_id = "11";
            timerGame();

            if(Integer.parseInt(bestScore_color_play.getText().toString()) < money1) {
                bestScore_color_play.setText("" + money1);
            }
        } else if(requestCode == 12_12){
            text_for_notific_id = "12";
            timerGame();

            if(Integer.parseInt(bestScore_truth.getText().toString()) < money1) {
                bestScore_truth.setText("" + money1);
            }
        }

        if(requestCode == 1) {
            String money2 = data.getStringExtra("money_resulttt");
            money.setText(money2);
        } //else if(requestCode == 2){
           // int money1 = data.getIntExtra("score", 0);
           // Toast.makeText(this, money1, Toast.LENGTH_SHORT).show();
          //  money.setText(money1);
           //}

        if(requestCode == 111) {
            all_notification = data.getBooleanExtra("notification",true);
            music = data.getBooleanExtra("music",true);
            aSwitch = data.getBooleanExtra("aSwitch",true);
            if(!music && mPlayer.isPlaying()){
                stopPlay();
            } else {
                startMusic();
            }
        }
        if(requestCode == 222) {
            all_money = money.getText().toString();
            int money1 = data.getIntExtra("roulette_score", 0);
            moneey = Integer.parseInt(all_money) + money1;
            money.setText("" + moneey);
        }

    }

     public void LoadInformation() {
         sPref = getPreferences(MODE_PRIVATE);
         String money_saved = sPref.getString(SAVED_TEXT, "");
         mus = sPref.getBoolean("qqqq", true);
         boolean notificat = sPref.getBoolean("qqq", true);
         if (money_saved.equals("0") || money_saved.equalsIgnoreCase("")) {
             return;
         } else {
             money.setText("" + money_saved);
         }
         music = mus;
         all_notification = notificat;

         bestScore_color.setText(sPref.getString("bestScore_color", "0"));
         bestScore_truth.setText(sPref.getString("bestScore_truth", "0"));
         bestScore_color_play.setText(sPref.getString("bestScore_color_play", "0"));
         bestScore_growth.setText(sPref.getString("bestScore_growth", "0"));
         bestScore_find_match.setText(sPref.getString("bestScore_find_match", "0"));
         bestScore_coordination.setText(sPref.getString("bestScore_coordination", "0"));
         bestScore_rememb_last.setText(sPref.getString("bestScore_rememb_last", "0"));
         bestScore_cont_row.setText(sPref.getString("bestScore_cont_row", "0"));
         bestScore_find_image.setText(sPref.getString("bestScore_find_image", "0"));
         bestScore_logical_compr.setText(sPref.getString("bestScore_logical_compr", "0"));
         bestScore_find_number.setText(sPref.getString("bestScore_find_number", "0"));
         bestScore_remember_and_disp.setText(sPref.getString("bestScore_remember_and_disp", "0"));
     }



    public void SavedInformation(){
        sPref = getPreferences(MODE_PRIVATE);
        musi = music;
        boolean not = all_notification;
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT,money.getText().toString());
        ed.putBoolean("qqq",not);
        ed.putBoolean("qqqq",musi);


        ed.putString("bestScore_color",bestScore_color.getText().toString());
        ed.putString("bestScore_truth",bestScore_truth.getText().toString());
        ed.putString("bestScore_color_play",bestScore_color_play.getText().toString());
        ed.putString("bestScore_growth",bestScore_growth.getText().toString());
        ed.putString("bestScore_find_match",bestScore_find_match.getText().toString());
        ed.putString("bestScore_coordination",bestScore_coordination.getText().toString());
        ed.putString("bestScore_rememb_last",bestScore_rememb_last.getText().toString());
        ed.putString("bestScore_cont_row",bestScore_cont_row.getText().toString());
        ed.putString("bestScore_find_image",bestScore_find_image.getText().toString());
        ed.putString("bestScore_logical_compr",bestScore_logical_compr.getText().toString());
        ed.putString("bestScore_find_number",bestScore_find_number.getText().toString());
        ed.putString("bestScore_remember_and_disp",bestScore_remember_and_disp.getText().toString());


        ed.apply();
    }

    @Override
    protected void onDestroy() {
        if (mPlayer.isPlaying()) {
            stopPlay();
        }
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        SavedInformation();
        if (mPlayer.isPlaying()) {
            stopPlay();
        }
        super.onPause();
    }

    public void timerGame(){
        if(text_for_notific_id.equalsIgnoreCase("1") && (check_colords.isChecked()) && all_notification) {


            PendingIntent intent_colords = PendingIntent.getActivity(getApplicationContext(),1_1,
                    new Intent(getApplicationContext(),Colords.class),PendingIntent.FLAG_CANCEL_CURRENT);
            Notification builder = new Notification.Builder(getApplicationContext())
                        .setContentIntent(intent_colords)
                        .setSmallIcon(R.drawable.ic_swap)
                        .setTicker("Время откатилось!")
                        .setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setContentTitle("Вы можете играть")
                        .setContentText("Время ожидания вышло. Пора сыграть в игру и заработать немного монеток")
                        .build();

            nm = NotificationManagerCompat.from(this);
            nm.notify(NOTIFICATION_colords, builder);

        } else if(text_for_notific_id.equals("2") && check_remember_and_diap.isChecked() && all_notification) {

            PendingIntent intent_remember_and_diap = PendingIntent.getActivity(getApplicationContext(),2_2,
                    new Intent(getApplicationContext(),RememberAndDisplay.class),PendingIntent.FLAG_CANCEL_CURRENT);

            Notification builder = new Notification.Builder(getApplicationContext())
                        .setContentIntent(intent_remember_and_diap)
                        .setSmallIcon(R.drawable.ic_swap)
                        .setTicker("Время откатилось!")
                        .setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setContentTitle("Вы можете играть")
                        .setContentText("Время ожидания вышло. Пора сыграть в игру и заработать немного монеток")
                    .build();

                nm = NotificationManagerCompat.from(this);
                nm.notify(NOTIFICATION_remember_and_diap,builder);


        } else if(text_for_notific_id.equals("3") && check_find_number.isChecked() && all_notification) {

            PendingIntent intent_find_number = PendingIntent.getActivity(getApplicationContext(),3_3,
                    new Intent(getApplicationContext(),FindNumber.class),PendingIntent.FLAG_CANCEL_CURRENT);
            Notification builder = new Notification.Builder(getApplicationContext())
                        .setContentIntent(intent_find_number)
                        .setSmallIcon(R.drawable.ic_swap)
                        .setTicker("Время откатилось!")
                        .setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setContentTitle("Вы можете играть")
                        .setContentText("Время ожидания вышло. Пора сыграть в игру и заработать немного монеток")
                    .build();

            nm = NotificationManagerCompat.from(this);
                nm.notify(NOTIFICATION_find_number,builder);


        } else if(text_for_notific_id.equals("4") && (check_logic_compr.isChecked()) && all_notification) {
            PendingIntent intent_logic_compr = PendingIntent.getActivity(getApplicationContext(),4_4,
                    new Intent(getApplicationContext(),Logical_comprassion.class),PendingIntent.FLAG_CANCEL_CURRENT);

            Notification builder = new Notification.Builder(getApplicationContext())
                        .setContentIntent(intent_logic_compr)
                        .setSmallIcon(R.drawable.ic_swap)
                        .setTicker("Время откатилось!")
                        .setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setContentTitle("Вы можете играть")
                        .setContentText("Время ожидания вышло. Пора сыграть в игру и заработать немного монеток")
                    .build();

            nm = NotificationManagerCompat.from(this);
                nm.notify(NOTIFICATION_logic_compr,builder);


        } else if(text_for_notific_id.equals("5") && (check_find_image.isChecked()) && all_notification) {

            PendingIntent intent_find_image = PendingIntent.getActivity(getApplicationContext(),5_5,
                    new Intent(getApplicationContext(),FindImage.class),PendingIntent.FLAG_CANCEL_CURRENT);

            Notification builder = new Notification.Builder(getApplicationContext())
                        .setContentIntent(intent_find_image)
                        .setSmallIcon(R.drawable.ic_swap)
                        .setTicker("Время откатилось!")
                        .setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setContentTitle("Вы можете играть")
                        .setContentText("Время ожидания вышло. Пора сыграть в игру и заработать немного монеток")
                    .build();

            nm = NotificationManagerCompat.from(this);
                nm.notify(NOTIFICATION_find_image,builder);



        } else if(text_for_notific_id.equals("6") && check_continur_row.isChecked() && all_notification) {

            PendingIntent intent_continur_row = PendingIntent.getActivity(getApplicationContext(),6_6,
                    new Intent(getApplicationContext(),Continue_the_row.class),PendingIntent.FLAG_CANCEL_CURRENT);

            Notification builder = new Notification.Builder(getApplicationContext())
                        .setContentIntent(intent_continur_row)
                        .setSmallIcon(R.drawable.ic_swap)
                        .setTicker("Время откатилось!")
                        .setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setContentTitle("Вы можете играть")
                        .setContentText("Время ожидания вышло. Пора сыграть в игру и заработать немного монеток")
                    .build();

            nm = NotificationManagerCompat.from(this);
                nm.notify(NOTIFICATION_continur_row,builder);


        } else if(text_for_notific_id.equals("7") && check_rememb_last.isChecked() && all_notification) {

            PendingIntent intent_rememb_last = PendingIntent.getActivity(getApplicationContext(),7_7,
                    new Intent(getApplicationContext(),Remember_Last.class),PendingIntent.FLAG_CANCEL_CURRENT);

            Notification builder = new Notification.Builder(getApplicationContext())
                        .setContentIntent(intent_rememb_last)
                        .setSmallIcon(R.drawable.ic_swap)
                        .setTicker("Время откатилось!")
                        .setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setContentTitle("Вы можете играть")
                        .setContentText("Время ожидания вышло. Пора сыграть в игру и заработать немного монеток")
                    .build();

            nm = NotificationManagerCompat.from(this);
                nm.notify(NOTIFICATION_rememb_last,builder);



        } else if(text_for_notific_id.equals("8") && check_coordinat.isChecked() && all_notification) {

            PendingIntent intent_coordinat = PendingIntent.getActivity(getApplicationContext(),8_8,
                    new Intent(getApplicationContext(),Coordination.class),PendingIntent.FLAG_CANCEL_CURRENT);

            Notification builder = new Notification.Builder(getApplicationContext())
                        .setContentIntent(intent_coordinat)
                        .setSmallIcon(R.drawable.ic_swap)
                        .setTicker("Время откатилось!")
                        .setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setContentTitle("Вы можете играть")
                        .setContentText("Время ожидания вышло. Пора сыграть в игру и заработать немного монеток")
                    .build();

            nm = NotificationManagerCompat.from(this);
                nm.notify(NOTIFICATION_coordinat,builder);



        } else if(text_for_notific_id.equals("9") && check_find_match.isChecked() && all_notification) {

            PendingIntent intent_find_match = PendingIntent.getActivity(getApplicationContext(),9_9,
                    new Intent(getApplicationContext(),Find_a_Match.class),PendingIntent.FLAG_CANCEL_CURRENT);

            Notification builder = new Notification.Builder(getApplicationContext())
                        .setContentIntent(intent_find_match)
                        .setSmallIcon(R.drawable.ic_swap)
                        .setTicker("Время откатилось!")
                        .setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setContentTitle("Вы можете играть")
                        .setContentText("Время ожидания вышло. Пора сыграть в игру и заработать немного монеток")
                    .build();

            nm = NotificationManagerCompat.from(this);
                nm.notify(NOTIFICATION_find_match,builder);



        } else if(text_for_notific_id.equals("10") && check_growth.isChecked() && all_notification) {

            PendingIntent intent_growth = PendingIntent.getActivity(getApplicationContext(),10_10,
                    new Intent(getApplicationContext(),Decrease_growth.class),PendingIntent.FLAG_CANCEL_CURRENT);

            Notification builder = new Notification.Builder(getApplicationContext())
                        .setContentIntent(intent_growth)
                        .setSmallIcon(R.drawable.ic_swap)
                        .setTicker("Время откатилось!")
                        .setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setContentTitle("Вы можете играть")
                        .setContentText("Время ожидания вышло. Пора сыграть в игру и заработать немного монеток")
                    .build();

            nm = NotificationManagerCompat.from(this);
                nm.notify(NOTIFICATION_growth,builder);


        } else if(text_for_notific_id.equals("11") && check_color_play.isChecked() && all_notification) {

            PendingIntent intent_color_play = PendingIntent.getActivity(getApplicationContext(),11_11,
                    new Intent(getApplicationContext(),Game_of_Color.class),PendingIntent.FLAG_CANCEL_CURRENT);

            Notification builder = new Notification.Builder(getApplicationContext())
                        .setContentIntent(intent_color_play)
                        .setSmallIcon(R.drawable.ic_swap)
                        .setTicker("Время откатилось!")
                        .setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setContentTitle("Вы можете играть")
                        .setContentText("Время ожидания вышло. Пора сыграть в игру и заработать немного монеток")
                    .build();

            nm = NotificationManagerCompat.from(this);
                nm.notify(NOTIFICATION_color_play,builder);




        } else if(text_for_notific_id.equals("12") && check_truth_lie.isChecked() && all_notification) {

            PendingIntent intent_truth_notif = PendingIntent.getActivity(getApplicationContext(),12_12,
                    new Intent(getApplicationContext(),Truth_or_lie.class),PendingIntent.FLAG_CANCEL_CURRENT);

            Notification builder = new Notification.Builder(getApplicationContext())
                        .setContentIntent(intent_truth_notif)
                        .setSmallIcon(R.drawable.ic_swap)
                        .setTicker("Время откатилось!")
                        .setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setContentTitle("Вы можете играть")
                        .setContentText("Время ожидания вышло. Пора сыграть в игру и заработать немного монеток")
                    .build();

            nm = NotificationManagerCompat.from(this);
                nm.notify(NOTIFICATION_truth_lie,builder);
        }

    }




}
