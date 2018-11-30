package com.example.ajinkya.twoactivities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "MainActivity.EXTRA_MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private EditText mEditText;
    private TextView mReplyHeader;
    private TextView mReplyMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.editText_main);
        mReplyHeader = findViewById(R.id.reply_header);
        mReplyMessage = findViewById(R.id.reply_message);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Send Button Clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeader.setVisibility(View.VISIBLE);
                mReplyMessage.setText(reply);
                mReplyMessage.setVisibility(View.VISIBLE);
            }
        }
    }
}
