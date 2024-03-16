package com.example.juegodepreguntas1;

public class Question {
    private String question;
    private String[] options = new String[2];
    private int correctAnswerIndex;

    public Question(String question, String optionOne, String optionTwo) {
        this.question = question;
        this.options[0] = optionOne;
        this.options[1] = optionTwo;
        // La primera opción es siempre la respuesta correcta
        this.correctAnswerIndex = 0;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption(int index) {
        return options[index];
    }

    public boolean isCorrectAnswer(int index) {
        return index == correctAnswerIndex;
    }
}
