package com.ljmu.educationalphishingtool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PretestResults extends AppCompatActivity {

    ImageView preGrade;
    TextView preFinalScore;
    Button preEduButton;
    ConnectionHelper ConnectionHelper;

    public String preResult = "default";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pretest_results);

        preGrade = (ImageView)findViewById(R.id.PreGrade);
        preFinalScore = (TextView)findViewById(R.id.PreOutOf);
        preEduButton = (Button)findViewById(R.id.EducationButton);

        Bundle bundle = getIntent().getExtras();
        int preScore = bundle.getInt("preFinalScore");

        preFinalScore.setText("You scored " + preScore + " out of " + QuizContents.preQuestions.length);

        if (preScore >=10) {
            preGrade.setImageResource(R.drawable.score_low);
            preResult = "low";
        }else if (preScore > 5 && preScore <=9) {
            preGrade.setImageResource(R.drawable.score_medium);
            preResult = "medium";
        }else {
            preGrade.setImageResource(R.drawable.score_high);
            preResult = "high";
        }

        preEduButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectionHelper = new ConnectionHelper();

                try {
                    Connection con = ConnectionHelper.CONN();
                    String query = "INSERT INTO PretestResults(UserID,PretestScore)"+"VALUES('"+MainActivity.userID+"' , '"+preScore+"')";
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate(query);
                    Bundle b = new Bundle();
                    b.putString("severity", preResult);
                    Intent in = new Intent(getApplicationContext(), Education.class);
                    in.putExtras(b);
                    startActivity(in);
                }
                catch (SQLException se)
                {
                    Log.e("ERROR", se.getMessage());
                }
            }
        });
    }
}