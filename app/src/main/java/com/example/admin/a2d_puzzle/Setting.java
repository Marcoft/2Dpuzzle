package com.example.admin.a2d_puzzle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Setting extends AppCompatActivity {

    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";
    final String SAVED_TEXT2 = "saved_text2";
    final String SAVED_TEXT3 = "saved_text3";

    @BindView(R.id.push) Switch push;
    @BindView(R.id.music) Switch music;
    @BindView(R.id.id3) Switch aSwitch;
    @BindView(R.id.button_open) Button button_open;


    @OnClick(R.id.button_open)
    public void button_Open(){
        Toast.makeText(this, "Wow,you are crazy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        LoadInformation();
    }

    public void LoadInformation() {
        sPref = getPreferences(MODE_PRIVATE);
        boolean money_saved = sPref.getBoolean(SAVED_TEXT, true);
        boolean money_saved2 = sPref.getBoolean(SAVED_TEXT2, true);
        boolean money_saved3 = sPref.getBoolean(SAVED_TEXT3, true);
        push.setChecked(money_saved);
        music.setChecked(money_saved2);
        aSwitch.setChecked(money_saved3);
    }

    public void SavedInformation(){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putBoolean(SAVED_TEXT,push.isChecked());
        ed.putBoolean(SAVED_TEXT2,music.isChecked());
        ed.putBoolean(SAVED_TEXT3,aSwitch.isChecked());
        ed.apply();
    }

    @Override
    protected void onDestroy() {
        SavedInformation();
        Intent intent_1 = new Intent();
        intent_1.putExtra("notification", push.isChecked());
        intent_1.putExtra("music", music.isChecked());
        intent_1.putExtra("aSwitch", aSwitch.isChecked());
        setResult(RESULT_OK, intent_1);
        finish();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        SavedInformation();
        Intent intent_1 = new Intent();
        intent_1.putExtra("notification", push.isChecked());
        intent_1.putExtra("music", music.isChecked());
        intent_1.putExtra("aSwitch", aSwitch.isChecked());
        setResult(RESULT_OK, intent_1);
        finish();
        super.onBackPressed();
    }
}
