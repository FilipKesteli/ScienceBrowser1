package com.kesteli.filip.sciencebrowser1.aplikacije;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kesteli.filip.sciencebrowser1.R;

public class EducationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        handleIntent();
    }

    private void handleIntent() {
        Intent intent = getIntent();
        /**if (intent.hasExtra(MainActivity.PARAMETER_NAME)) {
            String message = intent.getStringExtra(MainActivity.PARAMETER_NAME);
            etReceivedMessage.setText(message);
        }*/
    }
}
