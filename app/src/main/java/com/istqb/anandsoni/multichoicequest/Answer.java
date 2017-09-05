package com.istqb.anandsoni.multichoicequest;

/**
 * Created by anandsoni on 2016-04-03.
 */
public class Answer {

    private int attemptedAnswer;
    private int correctAnswer;

    public int getAttemptedAnswer(){
         return attemptedAnswer;
    }

    public void setAttemptedAnswer(int attemptedAnswer){
        this.attemptedAnswer=attemptedAnswer;
    }

    public int getCorrectAnswer(){
        return correctAnswer;
    }
    public void setCorrectAnswer(int correctAnswer){
        this.correctAnswer=correctAnswer;
    }



}
