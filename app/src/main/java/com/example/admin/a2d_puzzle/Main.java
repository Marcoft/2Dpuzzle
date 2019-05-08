package com.example.admin.a2d_puzzle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main extends AppCompatActivity  {

    @BindView(R.id.btn) Button btn;
    @BindView(R.id.btn2) Button btn2;
    @BindView(R.id.btn3) Button btn3;
    @BindView(R.id.btn4) Button btn4;
    @BindView(R.id.btn5) Button btn5;
    @BindView(R.id.btn6) Button btn6;
    @BindView(R.id.btn7) Button btn7;
    @BindView(R.id.btn8) Button btn8;
    @BindView(R.id.btn9) Button btn9;
    @BindView(R.id.btn10) Button btn10;
    @BindView(R.id.btn11) Button btn11;
    @BindView(R.id.btn12) Button btn12;
    @BindView(R.id.btn13) Button btn13;
    @BindView(R.id.btn14) Button btn14;
    @BindView(R.id.btn15) Button btn15;
    @BindView(R.id.btn16) Button btn16;
    @BindView(R.id.btn17) Button btn17;
    @BindView(R.id.btn18) Button btn18;
    @BindView(R.id.btn19) Button btn19;
    @BindView(R.id.btn20) Button btn20;
    @BindView(R.id.btn21) Button btn21;
    @BindView(R.id.btn22) Button btn22;
    @BindView(R.id.btn23) Button btn23;
    @BindView(R.id.btn24) Button btn24;
    @BindView(R.id.btn25) Button btn25;
    @BindView(R.id.btn26) Button btn26;
    @BindView(R.id.btn27) Button btn27;
    @BindView(R.id.btn28) Button btn28;
    @BindView(R.id.btn29) Button btn29;
    @BindView(R.id.btn30) Button btn30;
    @BindView(R.id.btn31) Button btn31;
    @BindView(R.id.btn32) Button btn32;
    @BindView(R.id.btn33) Button btn33;
    @BindView(R.id.btn34) Button btn34;
    @BindView(R.id.btn35) Button btn35;
    @BindView(R.id.btn36) Button btn36;
    @BindView(R.id.btn37) Button btn37;
    @BindView(R.id.btn38) Button btn38;
    @BindView(R.id.btn39) Button btn39;


    String money = "";
    String money_result = "" ;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        money = intent.getStringExtra("count_data");

        LoadPreferences();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data == null){
            return;
        }

            money_result = data.getStringExtra("money_result");
            money = money_result;

            sharedPreferences = getPreferences(MODE_PRIVATE);
            String name = data.getStringExtra("block");
            switch (name) {
                case "0":
                    break;
                case "1":
                    btn.setBackgroundColor(Color.GREEN);
                    btn.setClickable(false);

                    btn2.setEnabled(true);
                    btn2.setClickable(true);

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("state", btn.isClickable());
                    editor.putBoolean("nextstate", btn2.isClickable());
                    editor.apply();
                    break;
                case "2":
                    btn2.setBackgroundColor(Color.GREEN);
                    btn2.setClickable(false);

                    btn3.setEnabled(true);
                    btn3.setClickable(true);

                    SharedPreferences.Editor editor2 = sharedPreferences.edit();
                    editor2.putBoolean("state2", btn2.isClickable());
                    editor2.putBoolean("nextstate2", btn3.isClickable());
                    editor2.apply();
                    break;
                case "3":
                    btn3.setBackgroundColor(Color.GREEN);
                    btn3.setClickable(false);

                    btn4.setEnabled(true);
                    btn4.setClickable(true);

                    SharedPreferences.Editor editor3 = sharedPreferences.edit();
                    editor3.putBoolean("state3", btn3.isClickable());
                    editor3.putBoolean("nextstate3", btn4.isClickable());
                    editor3.apply();
                    break;
                case "4":
                    btn4.setBackgroundColor(Color.GREEN);
                    btn4.setClickable(false);

                    btn5.setEnabled(true);
                    btn5.setClickable(true);

                    SharedPreferences.Editor editor4 = sharedPreferences.edit();
                    editor4.putBoolean("state4", btn4.isClickable());
                    editor4.putBoolean("nextstate4", btn5.isClickable());
                    editor4.apply();
                    break;
                case "5":
                    btn5.setBackgroundColor(Color.GREEN);
                    btn5.setClickable(false);

                    btn6.setEnabled(true);
                    btn6.setClickable(true);

                    SharedPreferences.Editor editor5 = sharedPreferences.edit();
                    editor5.putBoolean("state5", btn5.isClickable());
                    editor5.putBoolean("nextstate5", btn6.isClickable());
                    editor5.apply();
                    break;
                case "6":
                    btn6.setBackgroundColor(Color.GREEN);
                    btn6.setClickable(false);

                    btn7.setEnabled(true);
                    btn7.setClickable(true);

                    SharedPreferences.Editor editor6 = sharedPreferences.edit();
                    editor6.putBoolean("state6", btn6.isClickable());
                    editor6.putBoolean("nextstate6", btn7.isClickable());
                    editor6.apply();
                    break;
                case "7":
                    btn7.setBackgroundColor(Color.GREEN);
                    btn7.setClickable(false);

                    btn8.setEnabled(true);
                    btn8.setClickable(true);

                    SharedPreferences.Editor editor7 = sharedPreferences.edit();
                    editor7.putBoolean("state7", btn7.isClickable());
                    editor7.putBoolean("nextstate7", btn8.isClickable());
                    editor7.apply();
                    break;
                case "8":
                    btn8.setBackgroundColor(Color.GREEN);
                    btn8.setClickable(false);

                    btn9.setEnabled(true);
                    btn9.setClickable(true);

                    SharedPreferences.Editor editor8 = sharedPreferences.edit();
                    editor8.putBoolean("state8", btn8.isClickable());
                    editor8.putBoolean("nextstate8", btn9.isClickable());
                    editor8.apply();
                    break;
                case "9":
                    btn9.setBackgroundColor(Color.GREEN);
                    btn9.setClickable(false);

                    btn10.setEnabled(true);
                    btn10.setClickable(true);

                    SharedPreferences.Editor editor9 = sharedPreferences.edit();
                    editor9.putBoolean("state9", btn9.isClickable());
                    editor9.putBoolean("nextstate9", btn10.isClickable());
                    editor9.apply();
                    break;
                case "10":
                    btn10.setBackgroundColor(Color.GREEN);
                    btn10.setClickable(false);

                    btn11.setEnabled(true);
                    btn11.setClickable(true);

                    SharedPreferences.Editor editor10 = sharedPreferences.edit();
                    editor10.putBoolean("state10", btn10.isClickable());
                    editor10.putBoolean("nextstate10", btn11.isClickable());
                    editor10.apply();
                    break;
                case "11":
                    btn11.setBackgroundColor(Color.GREEN);
                    btn11.setClickable(false);

                    btn12.setEnabled(true);
                    btn12.setClickable(true);

                    SharedPreferences.Editor editor11 = sharedPreferences.edit();
                    editor11.putBoolean("state11", btn11.isClickable());
                    editor11.putBoolean("nextstate11", btn12.isClickable());
                    editor11.apply();
                    break;
                case "12":
                    btn12.setBackgroundColor(Color.GREEN);
                    btn12.setClickable(false);

                    btn13.setEnabled(true);
                    btn13.setClickable(true);

                    SharedPreferences.Editor editor12 = sharedPreferences.edit();
                    editor12.putBoolean("state12", btn12.isClickable());
                    editor12.putBoolean("nextstate12", btn13.isClickable());
                    editor12.apply();
                    break;
                case "13":
                    btn13.setBackgroundColor(Color.GREEN);
                    btn13.setClickable(false);

                    btn14.setEnabled(true);
                    btn14.setClickable(true);

                    SharedPreferences.Editor editor13 = sharedPreferences.edit();
                    editor13.putBoolean("state13", btn13.isClickable());
                    editor13.putBoolean("nextstate13", btn14.isClickable());
                    editor13.apply();
                    break;
                case "14":
                    btn14.setBackgroundColor(Color.GREEN);
                    btn14.setClickable(false);

                    btn15.setEnabled(true);
                    btn15.setClickable(true);

                    SharedPreferences.Editor editor14 = sharedPreferences.edit();
                    editor14.putBoolean("state14", btn14.isClickable());
                    editor14.putBoolean("nextstate14", btn15.isClickable());
                    editor14.apply();
                    break;
                case "15":
                    btn15.setBackgroundColor(Color.GREEN);
                    btn15.setClickable(false);

                    btn16.setEnabled(true);
                    btn16.setClickable(true);

                    SharedPreferences.Editor editor15 = sharedPreferences.edit();
                    editor15.putBoolean("state15", btn15.isClickable());
                    editor15.putBoolean("nextstate15", btn16.isClickable());
                    editor15.apply();
                    break;
                case "16":
                    btn16.setBackgroundColor(Color.GREEN);
                    btn16.setClickable(false);

                    btn17.setEnabled(true);
                    btn17.setClickable(true);

                    SharedPreferences.Editor editor16 = sharedPreferences.edit();
                    editor16.putBoolean("state16", btn16.isClickable());
                    editor16.putBoolean("nextstate16", btn17.isClickable());
                    editor16.apply();
                    break;
                case "17":
                    btn17.setBackgroundColor(Color.GREEN);
                    btn17.setClickable(false);

                    btn18.setEnabled(true);
                    btn18.setClickable(true);

                    SharedPreferences.Editor editor17 = sharedPreferences.edit();
                    editor17.putBoolean("state17", btn17.isClickable());
                    editor17.putBoolean("nextstate17", btn18.isClickable());
                    editor17.apply();
                    break;
                case "18":
                    btn18.setBackgroundColor(Color.GREEN);
                    btn18.setClickable(false);

                    btn19.setEnabled(true);
                    btn19.setClickable(true);

                    SharedPreferences.Editor editor18 = sharedPreferences.edit();
                    editor18.putBoolean("state18", btn18.isClickable());
                    editor18.putBoolean("nextstate18", btn19.isClickable());
                    editor18.apply();
                    break;
                case "19":
                    btn19.setBackgroundColor(Color.GREEN);
                    btn19.setClickable(false);

                    btn20.setEnabled(true);
                    btn20.setClickable(true);

                    SharedPreferences.Editor editor19 = sharedPreferences.edit();
                    editor19.putBoolean("state19", btn19.isClickable());
                    editor19.putBoolean("nextstate19", btn20.isClickable());
                    editor19.apply();
                    break;
                case "20":
                    btn20.setBackgroundColor(Color.GREEN);
                    btn20.setClickable(false);

                    btn21.setEnabled(true);
                    btn21.setClickable(true);

                    SharedPreferences.Editor editor20 = sharedPreferences.edit();
                    editor20.putBoolean("state20", btn20.isClickable());
                    editor20.putBoolean("nextstate20", btn21.isClickable());
                    editor20.apply();
                    break;
                case "21":
                    btn21.setBackgroundColor(Color.GREEN);
                    btn21.setClickable(false);

                    btn22.setEnabled(true);
                    btn22.setClickable(true);

                    SharedPreferences.Editor editor21 = sharedPreferences.edit();
                    editor21.putBoolean("state21", btn21.isClickable());
                    editor21.putBoolean("nextstate21", btn22.isClickable());
                    editor21.apply();
                    break;
                case "22":
                    btn22.setBackgroundColor(Color.GREEN);
                    btn22.setClickable(false);

                    btn23.setEnabled(true);
                    btn23.setClickable(true);

                    SharedPreferences.Editor editor22 = sharedPreferences.edit();
                    editor22.putBoolean("state22", btn22.isClickable());
                    editor22.putBoolean("nextstate22", btn23.isClickable());
                    editor22.apply();
                    break;
                case "23":
                    btn23.setBackgroundColor(Color.GREEN);
                    btn23.setClickable(false);

                    btn24.setEnabled(true);
                    btn24.setClickable(true);

                    SharedPreferences.Editor editor23 = sharedPreferences.edit();
                    editor23.putBoolean("state23", btn23.isClickable());
                    editor23.putBoolean("nextstate23", btn24.isClickable());
                    editor23.apply();
                    break;
                case "24":
                    btn24.setBackgroundColor(Color.GREEN);
                    btn24.setClickable(false);

                    btn25.setEnabled(true);
                    btn25.setClickable(true);

                    SharedPreferences.Editor editor24 = sharedPreferences.edit();
                    editor24.putBoolean("state24", btn24.isClickable());
                    editor24.putBoolean("nextstate24", btn25.isClickable());
                    editor24.apply();
                    break;
                case "25":
                    btn25.setBackgroundColor(Color.GREEN);
                    btn25.setClickable(false);

                    btn26.setEnabled(true);
                    btn26.setClickable(true);

                    SharedPreferences.Editor editor25 = sharedPreferences.edit();
                    editor25.putBoolean("state25", btn25.isClickable());
                    editor25.putBoolean("nextstate25", btn26.isClickable());
                    editor25.apply();
                    break;
                case "26":
                    btn26.setBackgroundColor(Color.GREEN);
                    btn26.setClickable(false);

                    btn27.setEnabled(true);
                    btn27.setClickable(true);

                    SharedPreferences.Editor editor26 = sharedPreferences.edit();
                    editor26.putBoolean("state26", btn26.isClickable());
                    editor26.putBoolean("nextstate26", btn27.isClickable());
                    editor26.apply();
                    break;
                case "27":
                    btn27.setBackgroundColor(Color.GREEN);
                    btn27.setClickable(false);

                    btn28.setEnabled(true);
                    btn28.setClickable(true);

                    SharedPreferences.Editor editor27 = sharedPreferences.edit();
                    editor27.putBoolean("state27", btn27.isClickable());
                    editor27.putBoolean("nextstate27", btn28.isClickable());
                    editor27.apply();
                    break;
                case "28":
                    btn28.setBackgroundColor(Color.GREEN);
                    btn28.setClickable(false);

                    btn29.setEnabled(true);
                    btn29.setClickable(true);

                    SharedPreferences.Editor editor28 = sharedPreferences.edit();
                    editor28.putBoolean("state28", btn28.isClickable());
                    editor28.putBoolean("nextstate28", btn29.isClickable());
                    editor28.apply();
                    break;
                case "29":
                    btn29.setBackgroundColor(Color.GREEN);
                    btn29.setClickable(false);

                    btn30.setEnabled(true);
                    btn30.setClickable(true);

                    SharedPreferences.Editor editor29 = sharedPreferences.edit();
                    editor29.putBoolean("state29", btn29.isClickable());
                    editor29.putBoolean("nextstate29", btn30.isClickable());
                    editor29.apply();
                    break;
                case "30":
                    btn30.setBackgroundColor(Color.GREEN);
                    btn30.setClickable(false);

                    btn31.setEnabled(true);
                    btn31.setClickable(true);

                    SharedPreferences.Editor editor30 = sharedPreferences.edit();
                    editor30.putBoolean("state30", btn30.isClickable());
                    editor30.putBoolean("nextstate30", btn31.isClickable());
                    editor30.apply();
                    break;
                case "31":
                    btn31.setBackgroundColor(Color.GREEN);
                    btn31.setClickable(false);

                    btn32.setEnabled(true);
                    btn32.setClickable(true);

                    SharedPreferences.Editor editor31 = sharedPreferences.edit();
                    editor31.putBoolean("state31", btn31.isClickable());
                    editor31.putBoolean("nextstate31", btn32.isClickable());
                    editor31.apply();
                    break;
                case "32":
                    btn32.setBackgroundColor(Color.GREEN);
                    btn32.setClickable(false);

                    btn33.setEnabled(true);
                    btn33.setClickable(true);

                    SharedPreferences.Editor editor32 = sharedPreferences.edit();
                    editor32.putBoolean("state32", btn32.isClickable());
                    editor32.putBoolean("nextstate32", btn33.isClickable());
                    editor32.apply();
                    break;
                case "33":
                    btn33.setBackgroundColor(Color.GREEN);
                    btn33.setClickable(false);

                    btn34.setEnabled(true);
                    btn34.setClickable(true);

                    SharedPreferences.Editor editor33 = sharedPreferences.edit();
                    editor33.putBoolean("state33", btn33.isClickable());
                    editor33.putBoolean("nextstate33", btn34.isClickable());
                    editor33.apply();
                    break;
                case "34":
                    btn34.setBackgroundColor(Color.GREEN);
                    btn34.setClickable(false);

                    btn35.setEnabled(true);
                    btn35.setClickable(true);

                    SharedPreferences.Editor editor34 = sharedPreferences.edit();
                    editor34.putBoolean("state34", btn34.isClickable());
                    editor34.putBoolean("nextstate34", btn35.isClickable());
                    editor34.apply();
                    break;
                case "35":
                    btn35.setBackgroundColor(Color.GREEN);
                    btn35.setClickable(false);

                    btn36.setEnabled(true);
                    btn36.setClickable(true);

                    SharedPreferences.Editor editor35 = sharedPreferences.edit();
                    editor35.putBoolean("state35", btn35.isClickable());
                    editor35.putBoolean("nextstate35", btn36.isClickable());
                    editor35.apply();
                    break;
                case "36":
                    btn36.setBackgroundColor(Color.GREEN);
                    btn36.setClickable(false);

                    btn37.setEnabled(true);
                    btn37.setClickable(true);

                    SharedPreferences.Editor editor36 = sharedPreferences.edit();
                    editor36.putBoolean("state36", btn36.isClickable());
                    editor36.putBoolean("nextstate36", btn37.isClickable());
                    editor36.apply();
                    break;
                case "37":
                    btn37.setBackgroundColor(Color.GREEN);
                    btn37.setClickable(false);

                    btn38.setEnabled(true);
                    btn38.setClickable(true);

                    SharedPreferences.Editor editor37 = sharedPreferences.edit();
                    editor37.putBoolean("state37", btn37.isClickable());
                    editor37.putBoolean("nextstate37", btn38.isClickable());
                    editor37.apply();
                    break;
                case "38":
                    btn38.setBackgroundColor(Color.GREEN);
                    btn38.setClickable(false);

                    btn39.setEnabled(true);
                    btn39.setClickable(true);

                    SharedPreferences.Editor editor38 = sharedPreferences.edit();
                    editor38.putBoolean("state38", btn38.isClickable());
                    editor38.putBoolean("nextstate38", btn39.isClickable());
                    editor38.apply();
                    break;
                case "39":
                    btn39.setBackgroundColor(Color.GREEN);
                    btn39.setClickable(false);

                    SharedPreferences.Editor editor39 = sharedPreferences.edit();
                    editor39.putBoolean("state39", btn39.isClickable());
                    editor39.apply();
                    break;
                default:
                    break;
            }
    }

    public void onClick(View v){

        switch (v.getId()){
            case R.id.btn:
                Intent intent = new Intent(Main.this,Test.class);
                intent.putExtra("dictionary","яр");
                intent.putExtra("progress",2);
                intent.putExtra("money_data",money);
                startActivityForResult(intent,1);
                break;
            case R.id.btn2:
                Intent intent2 = new Intent(Main.this,Test.class);
                intent2.putExtra("dictionary","ад");
                intent2.putExtra("progress",5);
                intent2.putExtra("money_data",money);
                startActivityForResult(intent2,2);
                break;
            case R.id.btn3:
                Intent intent3 = new Intent(Main.this,Test.class);
                intent3.putExtra("dictionary","дом");
                intent3.putExtra("progress",8);
                intent3.putExtra("money_data",money);
                startActivityForResult(intent3,3);
                break;
            case R.id.btn4:
                Intent intent4 = new Intent(Main.this,Test.class);
                intent4.putExtra("dictionary","мак");
                intent4.putExtra("progress",10);
                intent4.putExtra("money_data",money);
                startActivityForResult(intent4,4);
                break;
            case R.id.btn5:
                Intent intent5 = new Intent(Main.this,Test.class);
                intent5.putExtra("dictionary","лес");
                intent5.putExtra("progress",13);
                intent5.putExtra("money_data",money);
                startActivityForResult(intent5,5);
                break;
            case R.id.btn6:
                Intent intent6 = new Intent(Main.this,Test.class);
                intent6.putExtra("dictionary","бал");
                intent6.putExtra("progress",15);
                intent6.putExtra("money_data",money);
                startActivityForResult(intent6,6);
                break;
            case R.id.btn7:
                Intent intent7 = new Intent(Main.this,Test.class);
                intent7.putExtra("dictionary","бор");
                intent7.putExtra("progress",18);
                intent7.putExtra("money_data",money);
                startActivityForResult(intent7,7);
                break;
            case R.id.btn8:
                Intent intent8 = new Intent(Main.this,Test.class);
                intent8.putExtra("dictionary","бокс");
                intent8.putExtra("progress",20);
                intent8.putExtra("money_data",money);
                startActivityForResult(intent8,8);
                break;
            case R.id.btn9:
                Intent intent9 = new Intent(Main.this,Test.class);
                intent9.putExtra("dictionary","блюз");
                intent9.putExtra("progress",23);
                intent9.putExtra("money_data",money);
                startActivityForResult(intent9,9);
                break;
            case R.id.btn10:
                Intent intent10 = new Intent(Main.this,Test.class);
                intent10.putExtra("dictionary","бард");
                intent10.putExtra("progress",25);
                intent10.putExtra("money_data",money);
                startActivityForResult(intent10,10);
                break;
            case R.id.btn11:
                Intent intent11 = new Intent(Main.this,Test.class);
                intent11.putExtra("dictionary","жало");
                intent11.putExtra("progress",28);
                intent11.putExtra("money_data",money);
                startActivityForResult(intent11,11);
                break;
            case R.id.btn12:
                Intent intent12 = new Intent(Main.this,Test.class);
                intent12.putExtra("dictionary","марш");
                intent12.putExtra("progress",31);
                intent12.putExtra("money_data",money);
                startActivityForResult(intent12,12);
                break;
            case R.id.btn13:
                Intent intent13 = new Intent(Main.this,Test.class);
                intent13.putExtra("dictionary","канал");
                intent13.putExtra("progress",33);
                intent13.putExtra("money_data",money);
                startActivityForResult(intent13,13);
                break;
            case R.id.btn14:
                Intent intent14 = new Intent(Main.this,Test.class);
                intent14.putExtra("dictionary","арена");
                intent14.putExtra("progress",36);
                intent14.putExtra("money_data",money);
                startActivityForResult(intent14,14);
                break;
            case R.id.btn15:
                Intent intent15 = new Intent(Main.this,Test.class);
                intent15.putExtra("dictionary","вафля");
                intent15.putExtra("progress",38);
                intent15.putExtra("money_data",money);
                startActivityForResult(intent15,15);
                break;
            case R.id.btn16:
                Intent intent16 = new Intent(Main.this,Test.class);
                intent16.putExtra("dictionary","висок");
                intent16.putExtra("progress",41);
                intent16.putExtra("money_data",money);
                startActivityForResult(intent16,16);
                break;
            case R.id.btn17:
                Intent intent17 = new Intent(Main.this,Test.class);
                intent17.putExtra("dictionary","купол");
                intent17.putExtra("progress",43);
                intent17.putExtra("money_data",money);
                startActivityForResult(intent17,17);
                break;
            case R.id.btn18:
                Intent intent18 = new Intent(Main.this,Test.class);
                intent18.putExtra("dictionary","азбука");
                intent18.putExtra("progress",46);
                intent18.putExtra("money_data",money);
                startActivityForResult(intent18,18);
                break;
            case R.id.btn19:
                Intent intent19 = new Intent(Main.this,Test.class);
                intent19.putExtra("dictionary","почерк");
                intent19.putExtra("progress",49);
                intent19.putExtra("money_data",money);
                startActivityForResult(intent19,19);
                break;
            case R.id.btn20:
                Intent intent20 = new Intent(Main.this,Test.class);
                intent20.putExtra("dictionary","офлайн");
                intent20.putExtra("progress",51);
                intent20.putExtra("money_data",money);
                startActivityForResult(intent20,20);
                break;
            case R.id.btn21:
                Intent intent21 = new Intent(Main.this,Test.class);
                intent21.putExtra("dictionary","алтарь");
                intent21.putExtra("progress",54);
                intent21.putExtra("money_data",money);
                startActivityForResult(intent21,21);
                break;
            case R.id.btn22:
                Intent intent22 = new Intent(Main.this,Test.class);
                intent22.putExtra("dictionary","дранье");
                intent22.putExtra("progress",56);
                intent22.putExtra("money_data",money);
                startActivityForResult(intent22,22);
                break;
            case R.id.btn23:
                Intent intent23 = new Intent(Main.this,Test.class);
                intent23.putExtra("dictionary","будущий");
                intent23.putExtra("progress",59);
                intent23.putExtra("money_data",money);
                startActivityForResult(intent23,23);
                break;
            case R.id.btn24:
                Intent intent24 = new Intent(Main.this,Test.class);
                intent24.putExtra("dictionary","дворник");
                intent24.putExtra("progress",61);
                intent24.putExtra("money_data",money);
                startActivityForResult(intent24,24);
                break;
            case R.id.btn25:
                Intent intent25 = new Intent(Main.this,Test.class);
                intent25.putExtra("dictionary","мозаика");
                intent25.putExtra("progress",64);
                intent25.putExtra("money_data",money);
                startActivityForResult(intent25,25);
                break;
            case R.id.btn26:
                Intent intent26 = new Intent(Main.this,Test.class);
                intent26.putExtra("dictionary","дуршлаг");
                intent26.putExtra("progress",67);
                intent26.putExtra("money_data",money);
                startActivityForResult(intent26,26);
                break;
            case R.id.btn27:
                Intent intent27 = new Intent(Main.this,Test.class);
                intent27.putExtra("dictionary","виртуоз");
                intent27.putExtra("progress",69);
                intent27.putExtra("money_data",money);
                startActivityForResult(intent27,27);
                break;
            case R.id.btn28:
                Intent intent28 = new Intent(Main.this,Test.class);
                intent28.putExtra("dictionary","продюсер");
                intent28.putExtra("progress",72);
                intent28.putExtra("money_data",money);
                startActivityForResult(intent28,28);
                break;
            case R.id.btn29:
                Intent intent29 = new Intent(Main.this,Test.class);
                intent29.putExtra("dictionary","капучино");
                intent29.putExtra("progress",74);
                intent29.putExtra("money_data",money);
                startActivityForResult(intent29,29);
                break;
            case R.id.btn30:
                Intent intent30 = new Intent(Main.this,Test.class);
                intent30.putExtra("dictionary","кредитка");
                intent30.putExtra("progress",77);
                intent30.putExtra("money_data",money);
                startActivityForResult(intent30,30);
                break;
            case R.id.btn31:
                Intent intent31 = new Intent(Main.this,Test.class);
                intent31.putExtra("dictionary","лексикон");
                intent31.putExtra("progress",79);
                intent31.putExtra("money_data",money);
                startActivityForResult(intent31,31);
                break;
            case R.id.btn32:
                Intent intent32 = new Intent(Main.this,Test.class);
                intent32.putExtra("dictionary","бриллиант");
                intent32.putExtra("progress",82);
                intent32.putExtra("money_data",money);
                startActivityForResult(intent32,32);
                break;
            case R.id.btn33:
                Intent intent33 = new Intent(Main.this,Test.class);
                intent33.putExtra("dictionary","адреналин");
                intent33.putExtra("progress",84);
                intent33.putExtra("money_data",money);
                startActivityForResult(intent33,33);
                break;
            case R.id.btn34:
                Intent intent34 = new Intent(Main.this,Test.class);
                intent34.putExtra("dictionary","грейпфрут");
                intent34.putExtra("progress",87);
                intent34.putExtra("money_data",money);
                startActivityForResult(intent34,34);
                break;
            case R.id.btn35:
                Intent intent35 = new Intent(Main.this,Test.class);
                intent35.putExtra("dictionary","чугуновоз");
                intent35.putExtra("progress",90);
                intent35.putExtra("money_data",money);
                startActivityForResult(intent35,35);
                break;
            case R.id.btn36:
                Intent intent36 = new Intent(Main.this,Test.class);
                intent36.putExtra("dictionary","авитаминоз");
                intent36.putExtra("progress",92);
                intent36.putExtra("money_data",money);
                startActivityForResult(intent36,36);
                break;
            case R.id.btn37:
                Intent intent37 = new Intent(Main.this,Test.class);
                intent37.putExtra("dictionary","бензопровод");
                intent37.putExtra("progress",95);
                intent37.putExtra("money_data",money);
                startActivityForResult(intent37,37);
                break;
            case R.id.btn38:
                Intent intent38 = new Intent(Main.this,Test.class);
                intent38.putExtra("dictionary","автомобилист");
                intent38.putExtra("progress",97);
                intent38.putExtra("money_data",money);
                startActivityForResult(intent38,38);
                break;
            case R.id.btn39:
                Intent intent39 = new Intent(Main.this,Test.class);
                intent39.putExtra("dictionary","свидетельница");
                intent39.putExtra("progress",100);
                intent39.putExtra("money_data",money);
                startActivityForResult(intent39,39);
                break;
            default:
                break;
        }

    }


    private void LoadPreferences(){
        sharedPreferences = getPreferences(MODE_PRIVATE);
        boolean state = sharedPreferences.getBoolean("state", true);
        boolean state_next = sharedPreferences.getBoolean("nextstate", true);
        if(!state) {
            btn.setEnabled(state);
            btn.setClickable(state);
            btn.setBackgroundColor(Color.GREEN);
            btn2.setClickable(state_next);
            btn2.setEnabled(state_next);
        }

        boolean state2 = sharedPreferences.getBoolean("state2", true);
        boolean state_next2 = sharedPreferences.getBoolean("nextstate2", true);
        if(!state2) {
            btn2.setEnabled(state2);
            btn2.setClickable(state2);
            btn2.setBackgroundColor(Color.GREEN);
            btn3.setClickable(state_next2);
            btn3.setEnabled(state_next2);
        }

        boolean state3 = sharedPreferences.getBoolean("state3", true);
        boolean state_next3 = sharedPreferences.getBoolean("nextstate3", true);
        if(!state3) {
            btn3.setEnabled(state3);
            btn3.setClickable(state3);
            btn3.setBackgroundColor(Color.GREEN);
            btn4.setClickable(state_next3);
            btn4.setEnabled(state_next3);
        }

        boolean state4 = sharedPreferences.getBoolean("state4", true);
        boolean state_next4 = sharedPreferences.getBoolean("nextstate4", true);
        if(!state4) {
            btn4.setEnabled(state4);
            btn4.setClickable(state4);
            btn4.setBackgroundColor(Color.GREEN);
            btn5.setClickable(state_next4);
            btn5.setEnabled(state_next4);
        }

        boolean state5 = sharedPreferences.getBoolean("state5", true);
        boolean state_next5 = sharedPreferences.getBoolean("nextstate5", true);
        if(!state5) {
            btn5.setEnabled(state5);
            btn5.setClickable(state5);
            btn5.setBackgroundColor(Color.GREEN);
            btn6.setClickable(state_next5);
            btn6.setEnabled(state_next5);
        }

        boolean state6 = sharedPreferences.getBoolean("state6", true);
        boolean state_next6 = sharedPreferences.getBoolean("nextstate6", true);
        if(!state6) {
            btn6.setEnabled(state6);
            btn6.setClickable(state6);
            btn6.setBackgroundColor(Color.GREEN);
            btn7.setClickable(state_next6);
            btn7.setEnabled(state_next6);
        }

        boolean state7 = sharedPreferences.getBoolean("state7", true);
        boolean state_next7 = sharedPreferences.getBoolean("nextstate7", true);
        if(!state7) {
            btn7.setEnabled(state7);
            btn7.setClickable(state7);
            btn7.setBackgroundColor(Color.GREEN);
            btn8.setClickable(state_next7);
            btn8.setEnabled(state_next7);
        }

        boolean state8 = sharedPreferences.getBoolean("state8", true);
        boolean state_next8 = sharedPreferences.getBoolean("nextstate8", true);
        if(!state8) {
            btn8.setEnabled(state8);
            btn8.setClickable(state8);
            btn8.setBackgroundColor(Color.GREEN);
            btn9.setClickable(state_next8);
            btn9.setEnabled(state_next8);
        }

        boolean state9 = sharedPreferences.getBoolean("state9", true);
        boolean state_next9 = sharedPreferences.getBoolean("nextstate9", true);
        if(!state9) {
            btn9.setEnabled(state9);
            btn9.setClickable(state9);
            btn9.setBackgroundColor(Color.GREEN);
            btn10.setClickable(state_next9);
            btn10.setEnabled(state_next9);
        }

        boolean state10 = sharedPreferences.getBoolean("state10", true);
        boolean state_next10 = sharedPreferences.getBoolean("nextstate10", true);
        if(!state10) {
            btn10.setEnabled(state10);
            btn10.setClickable(state10);
            btn10.setBackgroundColor(Color.GREEN);
            btn11.setClickable(state_next10);
            btn11.setEnabled(state_next10);
        }

        boolean state11 = sharedPreferences.getBoolean("state11", true);
        boolean state_next11 = sharedPreferences.getBoolean("nextstate11", true);
        if(!state11) {
            btn11.setEnabled(state11);
            btn11.setClickable(state11);
            btn11.setBackgroundColor(Color.GREEN);
            btn12.setClickable(state_next11);
            btn12.setEnabled(state_next11);
        }

        boolean state12 = sharedPreferences.getBoolean("state12", true);
        boolean state_next12 = sharedPreferences.getBoolean("nextstate12", true);
        if(!state12) {
            btn12.setEnabled(state12);
            btn12.setClickable(state12);
            btn12.setBackgroundColor(Color.GREEN);
            btn13.setClickable(state_next12);
            btn13.setEnabled(state_next12);
        }

        boolean state13 = sharedPreferences.getBoolean("state13", true);
        boolean state_next13 = sharedPreferences.getBoolean("nextstate13", true);
        if(!state13) {
            btn13.setEnabled(state13);
            btn13.setClickable(state13);
            btn13.setBackgroundColor(Color.GREEN);
            btn14.setClickable(state_next13);
            btn14.setEnabled(state_next13);
        }

        boolean state14 = sharedPreferences.getBoolean("state14", true);
        boolean state_next14 = sharedPreferences.getBoolean("nextstate14", true);
        if(!state14) {
            btn14.setEnabled(state14);
            btn14.setClickable(state14);
            btn14.setBackgroundColor(Color.GREEN);
            btn15.setClickable(state_next14);
            btn15.setEnabled(state_next14);
        }

        boolean state15 = sharedPreferences.getBoolean("state15", true);
        boolean state_next15 = sharedPreferences.getBoolean("nextstate15", true);
        if(!state15) {
            btn15.setEnabled(state15);
            btn15.setClickable(state15);
            btn15.setBackgroundColor(Color.GREEN);
            btn16.setClickable(state_next15);
            btn16.setEnabled(state_next15);
        }

        boolean state16 = sharedPreferences.getBoolean("state16", true);
        boolean state_next16 = sharedPreferences.getBoolean("nextstate16", true);
        if(!state16) {
            btn16.setEnabled(state16);
            btn16.setClickable(state16);
            btn16.setBackgroundColor(Color.GREEN);
            btn17.setClickable(state_next16);
            btn17.setEnabled(state_next16);
        }

        boolean state17 = sharedPreferences.getBoolean("state17", true);
        boolean state_next17 = sharedPreferences.getBoolean("nextstate17", true);
        if(!state17) {
            btn17.setEnabled(state17);
            btn17.setClickable(state17);
            btn17.setBackgroundColor(Color.GREEN);
            btn18.setClickable(state_next17);
            btn18.setEnabled(state_next17);
        }

        boolean state18 = sharedPreferences.getBoolean("state18", true);
        boolean state_next18 = sharedPreferences.getBoolean("nextstate18", true);
        if(!state18) {
            btn18.setEnabled(state18);
            btn18.setClickable(state18);
            btn18.setBackgroundColor(Color.GREEN);
            btn19.setClickable(state_next18);
            btn19.setEnabled(state_next18);
        }

        boolean state19 = sharedPreferences.getBoolean("state19", true);
        boolean state_next19 = sharedPreferences.getBoolean("nextstate19", true);
        if(!state19) {
            btn19.setEnabled(state19);
            btn19.setClickable(state19);
            btn19.setBackgroundColor(Color.GREEN);
            btn20.setClickable(state_next19);
            btn20.setEnabled(state_next19);
        }

        boolean state20 = sharedPreferences.getBoolean("state20", true);
        boolean state_next20 = sharedPreferences.getBoolean("nextstate20", true);
        if(!state20) {
            btn20.setEnabled(state20);
            btn20.setClickable(state20);
            btn20.setBackgroundColor(Color.GREEN);
            btn21.setClickable(state_next20);
            btn21.setEnabled(state_next20);
        }

        boolean state21 = sharedPreferences.getBoolean("state21", true);
        boolean state_next21 = sharedPreferences.getBoolean("nextstate21", true);
        if(!state21) {
            btn21.setEnabled(state21);
            btn21.setClickable(state21);
            btn21.setBackgroundColor(Color.GREEN);
            btn22.setClickable(state_next21);
            btn22.setEnabled(state_next21);
        }

        boolean state22 = sharedPreferences.getBoolean("state22", true);
        boolean state_next22 = sharedPreferences.getBoolean("nextstate22", true);
        if(!state22) {
            btn22.setEnabled(state22);
            btn22.setClickable(state22);
            btn22.setBackgroundColor(Color.GREEN);
            btn23.setClickable(state_next22);
            btn23.setEnabled(state_next22);
        }

        boolean state23 = sharedPreferences.getBoolean("state23", true);
        boolean state_next23 = sharedPreferences.getBoolean("nextstate23", true);
        if(!state23) {
            btn23.setEnabled(state23);
            btn23.setClickable(state23);
            btn23.setBackgroundColor(Color.GREEN);
            btn24.setClickable(state_next23);
            btn24.setEnabled(state_next23);
        }


        boolean state24 = sharedPreferences.getBoolean("state24", true);
        boolean state_next24 = sharedPreferences.getBoolean("nextstate24", true);
        if(!state24) {
            btn24.setEnabled(state24);
            btn24.setClickable(state24);
            btn24.setBackgroundColor(Color.GREEN);
            btn25.setClickable(state_next24);
            btn25.setEnabled(state_next24);
        }

        boolean state25 = sharedPreferences.getBoolean("state25", true);
        boolean state_next25 = sharedPreferences.getBoolean("nextstate25", true);
        if(!state25) {
            btn25.setEnabled(state25);
            btn25.setClickable(state25);
            btn25.setBackgroundColor(Color.GREEN);
            btn26.setClickable(state_next25);
            btn26.setEnabled(state_next25);
        }

        boolean state26 = sharedPreferences.getBoolean("state26", true);
        boolean state_next26 = sharedPreferences.getBoolean("nextstate26", true);
        if(!state26) {
            btn26.setEnabled(state26);
            btn26.setClickable(state26);
            btn26.setBackgroundColor(Color.GREEN);
            btn27.setClickable(state_next26);
            btn27.setEnabled(state_next26);
        }

        boolean state27 = sharedPreferences.getBoolean("state27", true);
        boolean state_next27 = sharedPreferences.getBoolean("nextstate27", true);
        if(!state27) {
            btn27.setEnabled(state27);
            btn27.setClickable(state27);
            btn27.setBackgroundColor(Color.GREEN);
            btn28.setClickable(state_next27);
            btn28.setEnabled(state_next27);
        }

        boolean state28 = sharedPreferences.getBoolean("state28", true);
        boolean state_next28 = sharedPreferences.getBoolean("nextstate28", true);
        if(!state28) {
            btn28.setEnabled(state28);
            btn28.setClickable(state28);
            btn28.setBackgroundColor(Color.GREEN);
            btn29.setClickable(state_next28);
            btn29.setEnabled(state_next28);
        }

        boolean state29 = sharedPreferences.getBoolean("state29", true);
        boolean state_next29 = sharedPreferences.getBoolean("nextstate29", true);
        if(!state29) {
            btn29.setEnabled(state29);
            btn29.setClickable(state29);
            btn29.setBackgroundColor(Color.GREEN);
            btn30.setClickable(state_next29);
            btn30.setEnabled(state_next29);
        }

        boolean state30 = sharedPreferences.getBoolean("state30", true);
        boolean state_next30 = sharedPreferences.getBoolean("nextstate30", true);
        if(!state30) {
            btn30.setEnabled(state30);
            btn30.setClickable(state30);
            btn30.setBackgroundColor(Color.GREEN);
            btn31.setClickable(state_next30);
            btn31.setEnabled(state_next30);
        }

        boolean state31 = sharedPreferences.getBoolean("state31", true);
        boolean state_next31 = sharedPreferences.getBoolean("nextstate31", true);
        if(!state31) {
            btn31.setEnabled(state31);
            btn31.setClickable(state31);
            btn31.setBackgroundColor(Color.GREEN);
            btn32.setClickable(state_next31);
            btn32.setEnabled(state_next31);
        }

        boolean state32 = sharedPreferences.getBoolean("state32", true);
        boolean state_next32 = sharedPreferences.getBoolean("nextstate32", true);
        if(!state32) {
            btn32.setEnabled(state32);
            btn32.setClickable(state32);
            btn32.setBackgroundColor(Color.GREEN);
            btn33.setClickable(state_next32);
            btn33.setEnabled(state_next32);
        }

        boolean state33 = sharedPreferences.getBoolean("state33", true);
        boolean state_next33 = sharedPreferences.getBoolean("nextstate33", true);
        if(!state33) {
            btn33.setEnabled(state33);
            btn33.setClickable(state33);
            btn33.setBackgroundColor(Color.GREEN);
            btn34.setClickable(state_next33);
            btn34.setEnabled(state_next33);
        }

        boolean state34 = sharedPreferences.getBoolean("state34", true);
        boolean state_next34 = sharedPreferences.getBoolean("nextstate34", true);
        if(!state34) {
            btn34.setEnabled(state34);
            btn34.setClickable(state34);
            btn34.setBackgroundColor(Color.GREEN);
            btn35.setClickable(state_next34);
            btn35.setEnabled(state_next34);
        }

        boolean state35 = sharedPreferences.getBoolean("state35", true);
        boolean state_next35 = sharedPreferences.getBoolean("nextstate35", true);
        if(!state35) {
            btn35.setEnabled(state35);
            btn35.setClickable(state35);
            btn35.setBackgroundColor(Color.GREEN);
            btn36.setClickable(state_next35);
            btn36.setEnabled(state_next35);
        }

        boolean state36 = sharedPreferences.getBoolean("state36", true);
        boolean state_next36 = sharedPreferences.getBoolean("nextstate36", true);
        if(!state36) {
            btn.setEnabled(state36);
            btn.setClickable(state36);
            btn.setBackgroundColor(Color.GREEN);
            btn2.setClickable(state_next36);
            btn2.setEnabled(state_next36);
        }

        boolean state37 = sharedPreferences.getBoolean("state37", true);
        boolean state_next37 = sharedPreferences.getBoolean("nextstate37", true);
        if(!state37) {
            btn37.setEnabled(state37);
            btn37.setClickable(state37);
            btn37.setBackgroundColor(Color.GREEN);
            btn38.setClickable(state_next37);
            btn38.setEnabled(state_next37);
        }

        boolean state38 = sharedPreferences.getBoolean("state38", true);
        boolean state_next38 = sharedPreferences.getBoolean("nextstate38", true);
        if(!state38) {
            btn38.setEnabled(state38);
            btn38.setClickable(state38);
            btn38.setBackgroundColor(Color.GREEN);
            btn39.setClickable(state_next38);
            btn39.setEnabled(state_next38);
        }


        boolean state39 = sharedPreferences.getBoolean("state39", true);
        if(!state39) {
            btn.setEnabled(state39);
            btn.setClickable(state39);
            btn.setBackgroundColor(Color.GREEN);
        }

        sharedPreferences.edit().clear().apply();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent();
        if(!money_result.equals("")) {
            i.putExtra("money_resulttt", money_result);
        } else{
            i.putExtra("money_resulttt", money);
        }
        setResult(RESULT_OK, i);
        finish();
        super.onBackPressed();
    }
}

