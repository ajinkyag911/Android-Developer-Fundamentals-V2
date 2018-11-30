package com.example.ajinkya.intentchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ParagraphActivity extends AppCompatActivity {

    public TextView mParagraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paragraph);
        mParagraph = findViewById(R.id.paragraph);
        Intent intent = getIntent();
        int code = intent.getIntExtra(MainActivity.PARA_CODE, 1);
        if (code == 1) {
            mParagraph.setText(R.string.first_paragraph_content);
        } else if (code == 2) {
            mParagraph.setText(R.string.second_paragraph_content);
        } else if (code == 3) {
            mParagraph.setText(R.string.third_paragraph_content);
        }
    }
}
