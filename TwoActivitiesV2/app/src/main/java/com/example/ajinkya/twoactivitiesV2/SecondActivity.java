package com.example.ajinkya.twoactivitiesV2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "SecondActivity.EXTRA_REPLY";
    public static final String LOG_TAG = SecondActivity.class.getSimpleName();
    private TextView mMessageTextView;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mMessageTextView = findViewById(R.id.text_message);
        mEditText = findViewById(R.id.reply_editText);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        mMessageTextView.setText(message);
        Log.d(LOG_TAG, "Second onCreate");
    }

    public void returnReply(View view) {
        String reply = mEditText.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        Log.d(LOG_TAG, "End Second Activity");
        finish();
    }

    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "Second onStart");
    }

    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "Second onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "Second onPause");
    }

    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "Second onRestart");
    }

    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "Second onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "Second onDestroy");
    }

}
