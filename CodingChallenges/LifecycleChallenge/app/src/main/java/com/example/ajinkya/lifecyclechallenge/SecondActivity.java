package com.example.ajinkya.lifecyclechallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "SecondActivity.EXTRA_REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void addCarrots(View view) {
        addVegetable(1);
    }

    public void addTomatoes(View view) {
        addVegetable(2);
    }

    public void addCucumbers(View view) {
        addVegetable(3);
    }

    public void addSpinach(View view) {
        addVegetable(4);
    }

    public void addOnions(View view) {
        addVegetable(5);
    }

    public void addVegetable(int id) {
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, id);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}