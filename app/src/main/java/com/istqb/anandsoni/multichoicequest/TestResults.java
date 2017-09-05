package com.istqb.anandsoni.multichoicequest;

import java.io.Serializable;

/**
 * Created by anandsoni on 2016-05-17.
 */
public class TestResults implements Serializable{



    public int getNoOfCorrectAnswer() {
        return noOfCorrectAnswer;
    }

    public void setNoOfCorrectAnswer(int noOfCorrectAnswer) {
        this.noOfCorrectAnswer = noOfCorrectAnswer;
    }

    public int getNoOfIncorrectAnswer() {
        return noOfIncorrectAnswer;
    }

    public void setNoOfIncorrectAnswer(int noOfIncorrectAnswer) {
        this.noOfIncorrectAnswer = noOfIncorrectAnswer;
    }

    private int noOfIncorrectAnswer;
    private int noOfCorrectAnswer;

}
