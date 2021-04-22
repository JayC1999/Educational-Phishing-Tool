package com.ljmu.educationalphishingtool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    Button mSurveyButton;
    Button mPretestButton;
    Button mPosttestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //Below links each button to corresponding page
        mSurveyButton = (Button) findViewById(R.id.Button_Survey);
        mSurveyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, Survey.class));
            }
        });

        mPretestButton = (Button) findViewById(R.id.Button_Pretest);
        mPretestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, Pretest.class));
            }
        });

        mPosttestButton = (Button) findViewById(R.id.Button_Posttest);
        mPosttestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, Posttest.class));
            }
        });
    }
}