package com.example.ajinkya.lifecyclechallenge;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int TEXT_REQUEST = 1;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    String[] vegetables = {"Carrots", "Tomatoes", "Cucumbers", "Spinach", "Onions"};
    private TextView[] item;
    private EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item = new TextView[5];
        mLocationEditText = findViewById(R.id.loc_editText);
        item[0] = findViewById(R.id.item1);
        item[1] = findViewById(R.id.item2);
        item[2] = findViewById(R.id.item3);
        item[3] = findViewById(R.id.item4);
        item[4] = findViewById(R.id.item5);
    }

    public void openCommonItems(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                int itemId = data.getIntExtra(SecondActivity.EXTRA_REPLY, 0);
                setItem(itemId);
            }
        }
    }

    private void setItem(int itemId) {
        Log.d("setItem", "Hello");
        item[itemId - 1].setText(vegetables[itemId - 1]);
    }

    public void openLocation(View view) {
        String loc = mLocationEditText.getText().toString();

        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d(LOG_TAG, "Cannot open location!");
        }
    }
}
