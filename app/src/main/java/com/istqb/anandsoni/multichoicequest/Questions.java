package com.istqb.anandsoni.multichoicequest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anandsoni on 2016-03-20.
 */
public class Questions implements Serializable {
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public List<String> getListOfOption() {
        return listOfOption;
    }
    public void setListOfOption(List<String> listOfOption) {
        this.listOfOption = listOfOption;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void addOption(String option){
        listOfOption.add(option);
    }
    private String question;
    private List<String> listOfOption= new ArrayList<String>();
    private String correctAnswer;
    private String attemptedAnswer="Not Attempted";
    private int questionNumber;
    public int getQuestionNumber(){
         return questionNumber;
    }
    public void setQuestionNumber(int questionNumber){
        this.questionNumber=questionNumber;
    }
    public String getAttemptedAnswer(){
         return attemptedAnswer;
    }
    public void setAttemptedAnswer(String attemptedAnswer){
        this.attemptedAnswer=attemptedAnswer;
    }


}
