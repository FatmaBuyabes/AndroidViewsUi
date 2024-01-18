package com.joincoded.androidviewsui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView question, wrong,correct;
    private Button trueButton, falseButton,nextQButton;

    private ArrayList<String> questions = new ArrayList<>();

    private ArrayList<Boolean> answers = new ArrayList<>();


    private static int currentQuestionIndex =0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intializeViews();
        setupQuestionsAndAnswers();
        displayQuestion();
        displayNextQuestion();

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            checkAnswer(true);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(false);
            }
        });

        return nextQButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.nextQButton) {
                    currentQuestionIndex--;
                    displayQuestion();
                }
            }


            private void intializeViews() {
                question = findViewById(R.id.question);
                correct = findViewById(R.id.correct);
                wrong = findViewById(R.id.wrong);
                trueButton = findViewById(R.id.trueButton);
                falseButton = findViewById(R.id.falseButton);
                nextQButton = findViewById(R.id.nextQButton);
            }


            private void setupQuestionsAndAnswers() {
                questions.add("Cats have 230 bones ");
                answers.add(true);
                questions.add(" Dolphins Only Sleep with Half of Their Brain");
                answers.add(true);
                questions.add(" Dolphins Only Sleep with Half of Their Brain");
                answers.add(true);
            }

            private void displayQuestion() {
                String que = questions.get(currentQuestionIndex);
                question.setText(que);

            }

            private void checkAnswer(Boolean answer) {
                Boolean currentAnswer = answers.get(currentQuestionIndex);
                if (currentAnswer == answer) {
                    showCorrectAnswer();
                } else {
                    showWrongAnswer();
                }
            }

            private void showCorrectAnswer() {
                nextQButton.setVisibility(View.VISIBLE);
                correct.setVisibility(View.VISIBLE);
                trueButton.setVisibility(View.INVISIBLE);
                falseButton.setVisibility(View.INVISIBLE);
            }

            private void showWrongAnswer() {
                wrong.setVisibility(View.VISIBLE);
                trueButton.setVisibility(View.INVISIBLE);
                falseButton.setVisibility(View.INVISIBLE);
                nextQButton.setVisibility(View.VISIBLE);
                correct.setVisibility(View.INVISIBLE);
            }

            private void displayNextQuestion() {
                if (currentQuestionIndex < questions.size() - 1)
                    currentQuestionIndex++;
                else
                    currentQuestionIndex = 0;

                displayQuestion();

                correct.setVisibility(View.INVISIBLE);
                nextQButton.setVisibility(View.INVISIBLE);

                trueButton.setVisibility(View.VISIBLE);
                falseButton.setVisibility(View.VISIBLE);
            }


        };
    }