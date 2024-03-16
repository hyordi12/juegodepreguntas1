package com.example.juegodepreguntas1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private Button optionOneButton;
    private Button optionTwoButton;
    private TextView resultTextView;
    private int currentQuestionIndex = 0;
    private Question[] questions = new Question[8];
    private Random random = new Random();
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}