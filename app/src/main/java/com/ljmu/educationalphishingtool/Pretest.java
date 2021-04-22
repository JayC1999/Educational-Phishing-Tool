package com.ljmu.educationalphishingtool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;

public class Pretest extends AppCompatActivity {

    private TextView preScoreView, preQuestion;
    private PhotoView preImageView;
    private Button preTrueButton, preFalseButton;

    private boolean preAnswer;
    private int preScore = 0;
    private int preQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pretest);

        preScoreView = (TextView)findViewById(R.id.PretestPoints);
        preImageView = (PhotoView)findViewById(R.id.PretestImageView);
        preQuestion = (TextView)findViewById(R.id.PretestQuestion);
        preTrueButton = (Button)findViewById(R.id.PretestTrueButton);
        preFalseButton = (Button)findViewById(R.id.PretestFalseButton);

        updateQuestion();

        preTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (preAnswer == true) {
                    preScore++;
                    updateScore(preScore);

                    if (preQuestionNumber == QuizContents.preQuestions.length) {
                        Intent i = new Intent(Pretest.this, PretestResults.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("preFinalScore", preScore);
                        i.putExtras(bundle);
                        Pretest.this.finish();
                        startActivity(i);
                    }else {
                        updateQuestion();
                    }
                }

                else {
                    if (preQuestionNumber == QuizContents.preQuestions.length) {
                        Intent i = new Intent(Pretest.this, PretestResults.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("preFinalScore", preScore);
                        i.putExtras(bundle);
                        Pretest.this.finish();
                        startActivity(i);
                    }else {
                        updateQuestion();
                    }
                }

            }
        });

        preFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (preAnswer == false) {
                    preScore++;
                    updateScore(preScore);

                    if (preQuestionNumber == QuizContents.preQuestions.length) {
                        Intent i = new Intent(Pretest.this, PretestResults.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("preFinalScore", preScore);
                        i.putExtras(bundle);
                        Pretest.this.finish();
                        startActivity(i);
                    }else {
                        updateQuestion();
                    }
                }

                else {
                    if (preQuestionNumber == QuizContents.preQuestions.length) {
                        Intent i = new Intent(Pretest.this, PretestResults.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("preFinalScore", preScore);
                        i.putExtras(bundle);
                        Pretest.this.finish();
                        startActivity(i);
                    }else {
                        updateQuestion();
                    }
                }
            }
        });
    }

    private void updateQuestion() {
        preImageView.setImageResource(QuizContents.preImages[preQuestionNumber]);
        preQuestion.setText(QuizContents.preQuestions[preQuestionNumber]);
        preAnswer = QuizContents.preAnswers[preQuestionNumber];
        preQuestionNumber++;
    }

    public void updateScore(int point) {
        preScoreView.setText("" + preScore);
    }

}
