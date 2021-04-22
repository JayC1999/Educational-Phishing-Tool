package com.ljmu.educationalphishingtool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button mConsentButton;
    public static final int userID = new Random().nextInt(); //Generates random ID for each participant

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Links to button in XML
        mConsentButton = (Button) findViewById(R.id.Consent_Button);

        //When clicked go to home page
        mConsentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HomePage.class));
            }
        });
    }
}