package com.ljmu.educationalphishingtool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Survey extends AppCompatActivity {

    Button btnSubmit;
    EditText editText1, editText2, editText3, editText4, editText5, editText6;
    Button mSurveyHomeButton;
    ConnectionHelper ConnectionHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        btnSubmit = (Button) findViewById(R.id.SubmitSurvey);
        mSurveyHomeButton = (Button) findViewById(R.id.SurveyHome);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstQuestion = editText1.getText().toString();
                String secondQuestion = editText2.getText().toString();
                String thirdQuestion = editText3.getText().toString();
                String fourthQuestion = editText4.getText().toString();
                String fifthQuestion = editText5.getText().toString();
                String sixthQuestion = editText6.getText().toString();
                ConnectionHelper = new ConnectionHelper();

                try
                {
                    Connection con = ConnectionHelper.CONN();
                    //Inserts user input into database
                    String query = "INSERT INTO SurveyAnswers(UserID,Question1,Question2,Question3,Question4,Question5,Question6)"+"VALUES('"+MainActivity.userID+"' , '"+firstQuestion+"' , '"+secondQuestion+"' , '"+thirdQuestion+"' , '"+fourthQuestion+"' , '"+fifthQuestion+"' , '"+sixthQuestion+"')";
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate(query);
                    //Display if successful
                    Toast.makeText(Survey.this, "Survey Successfully Submitted",Toast.LENGTH_LONG).show();

                }
                catch (SQLException se)
                {
                    Log.e("ERROR", se.getMessage());
                }
            }
        });





        mSurveyHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Survey.this, HomePage.class));
            }
        });
    }
}