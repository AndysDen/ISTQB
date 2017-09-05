package com.istqb.anandsoni.multichoicequest;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by anandsoni on 2016-05-17.
 */
public class ResultHolder implements Serializable {

    Set<TestResults>  setOfTestResult;

    public void addTestResult(TestResults testResults){

         if(null== setOfTestResult){
        setOfTestResult = new HashSet<TestResults>();

         }
        setOfTestResult.add(testResults);

    }

     public Set<TestResults> getSetOfTestResult(){
          return setOfTestResult;
     }
}
