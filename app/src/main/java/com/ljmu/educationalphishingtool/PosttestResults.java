package com.ljmu.educationalphishingtool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PosttestResults extends AppCompatActivity {

    TextView postFinalScore;
    Button postHomeButton;
    ConnectionHelper ConnectionHelper;

    public String preResult = "default";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posttest_results);

        postFinalScore = (TextView)findViewById(R.id.PostOutOf);
        postHomeButton = (Button)findViewById(R.id.ReturnHome);

        Bundle bundle = getIntent().getExtras();
        int postScore = bundle.getInt("postFinalScore");

        postFinalScore.setText("You scored " + postScore + " out of " + QuizContents.postQuestions.length);

        ConnectionHelper = new ConnectionHelper();
        try {
            Connection con = ConnectionHelper.CONN();
            String query = "INSERT INTO PosttestResults(UserID,PosttestScore)"+"VALUES('"+MainActivity.userID+"' , '"+postScore+"')";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        }
        catch (SQLException se)
        {
            Log.e("ERROR", se.getMessage());
        }

        postHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PosttestResults.this, HomePage.class));
            }
        });
    }
}