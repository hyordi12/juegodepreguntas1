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

        questionTextView = findViewById(R.id.questionTextView);
        optionOneButton = findViewById(R.id.optionOneButton);
        optionTwoButton = findViewById(R.id.optionTwoButton);
        resultTextView = findViewById(R.id.resultTextView);

        questions[0] = new Question("¿Cuál es la capital de España?", "Madrid", "Barcelona");
        questions[1] = new Question("¿Cuál es la capital de Francia?", "París", "Lyon");
        questions[2] = new Question("¿Cuál es la capital de Italia?", "Roma", "Milán");
        questions[3] = new Question("¿Cuál es la capital de Alemania?", "Berlín", "Múnich");
        questions[4] = new Question("¿Cuál es la capital de Reino Unido?", "Londres", "Edimburgo");
        questions[5] = new Question("¿Cuál es la capital de Australia?", "Canberra", "Sídney");
        questions[6] = new Question("¿Cuál es la capital de Brasil?", "Brasilia", "Río de Janeiro");
        questions[7] = new Question("¿Cuál es la capital de Canadá?", "Ottawa", "Toronto");

        loadQuestion();


        optionOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        optionTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
    }

    private void loadQuestion() {
        if (currentQuestionIndex < questions.length) {
            Question currentQuestion = questions[currentQuestionIndex];
            questionTextView.setText(currentQuestion.getQuestion());
            optionOneButton.setText(currentQuestion.getOption(0));
            optionTwoButton.setText(currentQuestion.getOption(1));
        } else {

        }
    }

    private void checkAnswer(boolean isOptionOne) {
        Question currentQuestion = questions[currentQuestionIndex];

        if (isOptionOne) {
            resultTextView.setText("¡Correcto!");
            correctAnswers++;
        } else {
            resultTextView.setText("Incorrecto. La respuesta correcta es " + currentQuestion.getOption(0));
            incorrectAnswers++;
        }


        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            loadQuestion();
        } else {
            
            showFinalResults();
        }
    }

    private void showFinalResults() {
        String resultMessage = "Respuestas correctas: " + correctAnswers + "\n" +
                "Respuestas incorrectas: " + incorrectAnswers;
        resultTextView.setText(resultMessage);
    }
}