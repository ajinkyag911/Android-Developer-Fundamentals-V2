package com.example.ajinkya.intentchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String PARA_CODE = "MainActivity.PARA_CODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void showFirstParagraph(View view) {
        Intent intent = new Intent(this, ParagraphActivity.class);
        intent.putExtra(PARA_CODE, 1);
        startActivity(intent);
    }

    public void showSecondParagraph(View view) {
        Intent intent = new Intent(this, ParagraphActivity.class);
        intent.putExtra(PARA_CODE, 2);
        startActivity(intent);
    }

    public void showThirdParagraph(View view) {
        Intent intent = new Intent(this, ParagraphActivity.class);
        intent.putExtra(PARA_CODE, 3);
        startActivity(intent);
    }

}
