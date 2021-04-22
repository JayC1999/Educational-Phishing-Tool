package com.ljmu.educationalphishingtool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;

public class Posttest extends AppCompatActivity {

    private TextView postScoreView, postQuestion;
    private PhotoView postImageView;
    private Button postTrueButton, postFalseButton;

    private boolean postAnswer;
    private int postScore = 0;
    private int postQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posttest);

        postScoreView = (TextView) findViewById(R.id.PosttestPoints);
        postImageView = (PhotoView) findViewById(R.id.PosttestImageView);
        postQuestion = (TextView) findViewById(R.id.PosttestQuestion);
        postTrueButton = (Button) findViewById(R.id.PosttestTrueButton);
        postFalseButton = (Button) findViewById(R.id.PosttestFalseButton);

        updateQuestion();

        postTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (postAnswer == true) {
                    postScore++;
                    updateScore(postScore);

                    if (postQuestionNumber == QuizContents.postQuestions.length) {
                        Intent i = new Intent(Posttest.this, PosttestResults.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("postFinalScore", postScore);
                        i.putExtras(bundle);
                        Posttest.this.finish();
                        startActivity(i);
                    }else {
                        updateQuestion();
                    }
                }

                else {
                    if (postQuestionNumber == QuizContents.postQuestions.length) {
                        Intent i = new Intent(Posttest.this, PosttestResults.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("postFinalScore", postScore);
                        i.putExtras(bundle);
                        Posttest.this.finish();
                        startActivity(i);
                    }else {
                        updateQuestion();
                    }
                }

            }
        });

        postFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (postAnswer == false) {
                    postScore++;
                    updateScore(postScore);

                    if (postQuestionNumber == QuizContents.postQuestions.length) {
                        Intent i = new Intent(Posttest.this, PosttestResults.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("postFinalScore", postScore);
                        i.putExtras(bundle);
                        Posttest.this.finish();
                        startActivity(i);
                    }else {
                        updateQuestion();
                    }
                }

                else {
                    if (postQuestionNumber == QuizContents.postQuestions.length) {
                        Intent i = new Intent(Posttest.this, PosttestResults.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("postFinalScore", postScore);
                        i.putExtras(bundle);
                        Posttest.this.finish();
                        startActivity(i);
                    }else {
                        updateQuestion();
                    }
                }
            }
        });
    }

    private void updateQuestion() {
        postImageView.setImageResource(QuizContents.postImages[postQuestionNumber]);
        postQuestion.setText(QuizContents.postQuestions[postQuestionNumber]);
        postAnswer = QuizContents.postAnswers[postQuestionNumber];
        postQuestionNumber++;
    }

    public void updateScore(int point) { postScoreView.setText("" + postScore); }

}