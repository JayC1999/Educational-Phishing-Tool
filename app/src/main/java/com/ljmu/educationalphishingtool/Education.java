package com.ljmu.educationalphishingtool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.chrisbanes.photoview.PhotoView;

public class Education extends AppCompatActivity {

    PhotoView mEmailEducation;
    Button mHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        mEmailEducation = (PhotoView) findViewById(R.id.emailEducation);
        mHomeButton = (Button)findViewById(R.id.homeButton);

        Intent in = getIntent();
        Bundle b = in.getExtras();
        String s = b.getString("severity");

        if (s.equals("low")) {
            mEmailEducation.setImageResource(R.drawable.email_low);
        }else if (s.equals("medium")) {
            mEmailEducation.setImageResource(R.drawable.email_medium);
        }else {
            mEmailEducation.setImageResource(R.drawable.email_high);
        }

        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Education.this, HomePage.class));
                Education.this.finish();
            }
        });
    }
}